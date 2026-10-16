package cz.mobilesoft.appblock.service;

import android.accessibilityservice.AccessibilityService;
import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityWindowInfo;
import androidx.core.content.ContextCompat;
import cz.mobilesoft.appblock.R;
import cz.mobilesoft.appblock.service.lock.BlockingDecision;
import cz.mobilesoft.appblock.service.lock.BlockingDecisionMaker;
import cz.mobilesoft.appblock.service.lock.SubAppScreenResolver;
import cz.mobilesoft.appblock.util.ServiceHelper;
import cz.mobilesoft.coreblock.BuildConfig;
import cz.mobilesoft.coreblock.dto.UrlDto;
import cz.mobilesoft.coreblock.dto.UsageAccess;
import cz.mobilesoft.coreblock.dto.ViewIdDTO;
import cz.mobilesoft.coreblock.dto.events.EventWithPackageDTO;
import cz.mobilesoft.coreblock.dto.events.PackageAdditionalBlockingDTO;
import cz.mobilesoft.coreblock.enums.StrictModeOption;
import cz.mobilesoft.coreblock.repository.SubApp;
import cz.mobilesoft.coreblock.repository.SubAppRepository;
import cz.mobilesoft.coreblock.rest.exception.AccessibilityException;
import cz.mobilesoft.coreblock.service.receiver.DexReceiver;
import cz.mobilesoft.coreblock.storage.datastore.CoreMultiProcessDataStore;
import cz.mobilesoft.coreblock.storage.datastore.EventDataStore;
import cz.mobilesoft.coreblock.storage.datastore.StatisticsDataStore;
import cz.mobilesoft.coreblock.storage.datastore.StrictModeDataStore;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.AdultContentWebsiteDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.BlockSessionDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.BrowserViewIdDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.WebsiteProfileRelationDao;
import cz.mobilesoft.coreblock.storage.room.dto.blocking.ProfileWithConfiguration;
import cz.mobilesoft.coreblock.storage.room.dto.blocking.ProfileWithConfigurationKt;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.BrowserViewId;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.UsageLimit;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.WebsiteProfileRelation;
import cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager;
import cz.mobilesoft.coreblock.usecase.GetForegroundAppsUseCase;
import cz.mobilesoft.coreblock.usecase.GetUsageLimitsForCurrentPeriodUseCase;
import cz.mobilesoft.coreblock.usecase.accessibility.BrowserUrlDetectionResult;
import cz.mobilesoft.coreblock.usecase.accessibility.DetectBrowserUrlUseCase;
import cz.mobilesoft.coreblock.util.CrashHelper;
import cz.mobilesoft.coreblock.util.compose.FlowExtKt;
import cz.mobilesoft.coreblock.util.constants.UrlParsing;
import cz.mobilesoft.coreblock.util.helperextension.CollectionsExtKt;
import cz.mobilesoft.coreblock.util.helperextension.CoroutinesHelperExtKt;
import cz.mobilesoft.coreblock.util.helperextension.DatabaseExtKt;
import cz.mobilesoft.coreblock.util.helperextension.StringHelper;
import cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt;
import cz.mobilesoft.coreblock.util.runnability.InitHelper;
import cz.mobilesoft.coreblock.util.runnability.RunnabilityHelper;
import cz.mobilesoft.statistics.api.Statistics;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.xn.YvFRmou;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.serialization.json.internal.OBeo.vgWWUoTKYyuC;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.core.qualifier.Qualifier;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class LockAccessibilityService extends AccessibilityService implements InitHelper.OnInitializedListener {

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public static final Companion f94207g0 = new Companion(null);

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public static final int f94208h0 = 8;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    private static final Set f94209i0 = SetsKt.setOf((Object[]) new String[]{"com.android.systemui", "com.google.android.apps.nexuslauncher", "com.motorola.launcher3", "com.mi.android.globallauncher", "com.sec.android.app.launcher", "com.miui.home"});

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    private static final Set f94210j0 = SetsKt.setOf((Object[]) new String[]{"org.mozilla.firefox", "org.mozilla.firefox_beta", "com.microsoft.emmx"});
    private String A;
    private long B;
    private String C;
    private UrlCheck D;
    private SubApp E;
    private FullScreenBrowserBlockingCache F;
    private Set G;
    private String H;
    private Uri I;
    private int J;
    private boolean K;
    private boolean L;
    private boolean M;
    private boolean N;
    private boolean O;
    private Executor P;
    private AccessibilityRunnable Q;
    private final BlockingQueue R;
    private ScreenReceiver S;
    private Set T;
    private boolean U;
    private boolean V;
    private boolean W;
    private volatile boolean X;
    private volatile long Y;
    private volatile long Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private long f94212a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private volatile List f94214b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Lazy f94215c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    private volatile long f94216c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Lazy f94217d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    private volatile List f94218d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    private boolean f94219e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Lazy f94220f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    private boolean f94221f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Lazy f94222g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Lazy f94223h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Lazy f94224i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Lazy f94225j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Lazy f94226k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Lazy f94227l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final Lazy f94228m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Lazy f94229n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Lazy f94230o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final Lazy f94231p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final BlockingDecisionMaker f94232q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final Lazy f94233r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final Lazy f94234s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private long f94235t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final Lazy f94236u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f94237v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private Map f94238w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private Map f94239x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private Map f94240y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private long f94241z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CoroutineScope f94211a = CoroutinesHelperExtKt.a(Dispatchers.a());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CoroutineScope f94213b = CoroutinesHelperExtKt.a(Dispatchers.b());

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private final class AccessibilityRunnable implements Runnable {
        public AccessibilityRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            while (true) {
                try {
                    AccessibilityNodeInfo accessibilityNodeInfo = (AccessibilityNodeInfo) LockAccessibilityService.this.R.take();
                    if (accessibilityNodeInfo != null) {
                        try {
                            LockAccessibilityService.this.H0(accessibilityNodeInfo);
                        } catch (Exception e3) {
                            e3.printStackTrace();
                            CrashHelper.j(e3);
                        }
                    }
                } catch (InterruptedException e4) {
                    e4.printStackTrace();
                    LockAccessibilityService.this.Q = null;
                    LockAccessibilityService.this.P = null;
                    return;
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class NodeInfoDTO {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AccessibilityNodeInfo f94245a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f94246b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f94247c;

        public NodeInfoDTO(AccessibilityNodeInfo nodeInfo, boolean z2, boolean z3) {
            Intrinsics.checkNotNullParameter(nodeInfo, "nodeInfo");
            this.f94245a = nodeInfo;
            this.f94246b = z2;
            this.f94247c = z3;
        }

        public final AccessibilityNodeInfo a() {
            return this.f94245a;
        }

        public final boolean b() {
            return this.f94246b;
        }

        public final boolean c() {
            return this.f94247c;
        }

        public final AccessibilityNodeInfo d() {
            return this.f94245a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof NodeInfoDTO)) {
                return false;
            }
            NodeInfoDTO nodeInfoDTO = (NodeInfoDTO) obj;
            return Intrinsics.areEqual(this.f94245a, nodeInfoDTO.f94245a) && this.f94246b == nodeInfoDTO.f94246b && this.f94247c == nodeInfoDTO.f94247c;
        }

        public int hashCode() {
            return (((this.f94245a.hashCode() * 31) + Boolean.hashCode(this.f94246b)) * 31) + Boolean.hashCode(this.f94247c);
        }

        public String toString() {
            return "NodeInfoDTO(nodeInfo=" + this.f94245a + ", clearUrl=" + this.f94246b + ", showLocalHtml=" + this.f94247c + vgWWUoTKYyuC.KoJAtsDpblnsa;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private final class ScreenReceiver extends BroadcastReceiver {
        public ScreenReceiver() {
        }

        public final IntentFilter a() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            return intentFilter;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) throws Throwable {
            LockAccessibilityService.this.y1();
            LockAccessibilityService.this.z1();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f94253a;

        static {
            int[] iArr = new int[StrictModeOption.values().length];
            try {
                iArr[StrictModeOption.BlockSplitScreen.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f94253a = iArr;
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.appblock.service.LockAccessibilityService$onInitialized$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.appblock.service.LockAccessibilityService$onInitialized$1", f = "LockAccessibilityService.kt", l = {442}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f94296a;

        AnonymousClass1(Continuation continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return LockAccessibilityService.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f94296a;
            if (i3 == 0) {
                ResultKt.b(obj);
                EventDataStore eventDataStoreZ0 = LockAccessibilityService.this.Z0();
                long jF = TimeHelperExt.f128663a.f();
                this.f94296a = 1;
                if (eventDataStoreZ0.M1(jF, this) == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.appblock.service.LockAccessibilityService$onInitialized$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.appblock.service.LockAccessibilityService$onInitialized$2", f = "LockAccessibilityService.kt", l = {448, 451}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f94320a;

        AnonymousClass2(Continuation continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return LockAccessibilityService.this.new AnonymousClass2(continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:17:0x0040, code lost:
        
            if (r6.M1(r3, r5) == r0) goto L18;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) throws java.lang.Throwable {
            /*
                r5 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r1 = r5.f94320a
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L20
                if (r1 == r3) goto L1c
                if (r1 != r2) goto L14
                kotlin.ResultKt.b(r6)     // Catch: java.lang.NullPointerException -> L12
                goto L46
            L12:
                r6 = move-exception
                goto L43
            L14:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            L1c:
                kotlin.ResultKt.b(r6)
                goto L2e
            L20:
                kotlin.ResultKt.b(r6)
                r5.f94320a = r3
                r3 = 500(0x1f4, double:2.47E-321)
                java.lang.Object r6 = kotlinx.coroutines.DelayKt.b(r3, r5)
                if (r6 != r0) goto L2e
                goto L42
            L2e:
                cz.mobilesoft.appblock.service.LockAccessibilityService r6 = cz.mobilesoft.appblock.service.LockAccessibilityService.this     // Catch: java.lang.NullPointerException -> L12
                cz.mobilesoft.coreblock.storage.datastore.EventDataStore r6 = cz.mobilesoft.appblock.service.LockAccessibilityService.z(r6)     // Catch: java.lang.NullPointerException -> L12
                cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt r1 = cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt.f128663a     // Catch: java.lang.NullPointerException -> L12
                long r3 = r1.f()     // Catch: java.lang.NullPointerException -> L12
                r5.f94320a = r2     // Catch: java.lang.NullPointerException -> L12
                java.lang.Object r6 = r6.M1(r3, r5)     // Catch: java.lang.NullPointerException -> L12
                if (r6 != r0) goto L46
            L42:
                return r0
            L43:
                cz.mobilesoft.coreblock.util.CrashHelper.j(r6)
            L46:
                kotlin.Unit r6 = kotlin.Unit.f139807a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.appblock.service.LockAccessibilityService.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((AnonymousClass2) create(continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.appblock.service.LockAccessibilityService$onInitialized$23, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    static final class AnonymousClass23<T> implements FlowCollector {
        AnonymousClass23() {
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object a(long r10, kotlin.coroutines.Continuation r12) throws java.lang.Throwable {
            /*
                r9 = this;
                boolean r0 = r12 instanceof cz.mobilesoft.appblock.service.LockAccessibilityService$onInitialized$23$emit$1
                if (r0 == 0) goto L13
                r0 = r12
                cz.mobilesoft.appblock.service.LockAccessibilityService$onInitialized$23$emit$1 r0 = (cz.mobilesoft.appblock.service.LockAccessibilityService$onInitialized$23$emit$1) r0
                int r1 = r0.f94329d
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f94329d = r1
                goto L18
            L13:
                cz.mobilesoft.appblock.service.LockAccessibilityService$onInitialized$23$emit$1 r0 = new cz.mobilesoft.appblock.service.LockAccessibilityService$onInitialized$23$emit$1
                r0.<init>(r9, r12)
            L18:
                java.lang.Object r12 = r0.f94327b
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r2 = r0.f94329d
                r3 = 1
                if (r2 == 0) goto L31
                if (r2 != r3) goto L29
                kotlin.ResultKt.b(r12)
                goto L46
            L29:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r11)
                throw r10
            L31:
                kotlin.ResultKt.b(r12)
                cz.mobilesoft.appblock.service.LockAccessibilityService r12 = cz.mobilesoft.appblock.service.LockAccessibilityService.this
                r12.performGlobalAction(r3)
                r0.f94326a = r10
                r0.f94329d = r3
                r10 = 100
                java.lang.Object r10 = kotlinx.coroutines.DelayKt.b(r10, r0)
                if (r10 != r1) goto L46
                return r1
            L46:
                cz.mobilesoft.appblock.service.LockAccessibilityService r10 = cz.mobilesoft.appblock.service.LockAccessibilityService.this
                r11 = 2
                r10.performGlobalAction(r11)
                cz.mobilesoft.appblock.service.LockAccessibilityService r10 = cz.mobilesoft.appblock.service.LockAccessibilityService.this
                java.util.List r10 = cz.mobilesoft.appblock.service.LockAccessibilityService.G(r10)
                java.lang.Iterable r10 = (java.lang.Iterable) r10
                java.util.Iterator r10 = r10.iterator()
            L58:
                boolean r11 = r10.hasNext()
                if (r11 == 0) goto L70
                java.lang.Object r11 = r10.next()
                r12 = r11
                cz.mobilesoft.coreblock.storage.room.dto.blocking.ProfileWithConfiguration r12 = (cz.mobilesoft.coreblock.storage.room.dto.blocking.ProfileWithConfiguration) r12
                cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile r12 = r12.p()
                boolean r12 = r12.S()
                if (r12 == 0) goto L58
                goto L71
            L70:
                r11 = 0
            L71:
                cz.mobilesoft.coreblock.storage.room.dto.blocking.ProfileWithConfiguration r11 = (cz.mobilesoft.coreblock.storage.room.dto.blocking.ProfileWithConfiguration) r11
                if (r11 != 0) goto L78
                kotlin.Unit r10 = kotlin.Unit.f139807a
                return r10
            L78:
                cz.mobilesoft.appblock.service.LockAccessibilityService r0 = cz.mobilesoft.appblock.service.LockAccessibilityService.this
                java.util.List r3 = kotlin.collections.CollectionsKt.listOf(r11)
                cz.mobilesoft.appblock.service.LockAccessibilityService r10 = cz.mobilesoft.appblock.service.LockAccessibilityService.this
                android.content.Context r10 = r10.getApplicationContext()
                r11 = 2132082931(0x7f1500f3, float:1.980599E38)
                java.lang.String r5 = r10.getString(r11)
                cz.mobilesoft.coreblock.enums.StrictModeOption r6 = cz.mobilesoft.coreblock.enums.StrictModeOption.BlockUninstalling
                r7 = 8
                r8 = 0
                java.lang.String r1 = "com.google.android.packageinstaller"
                r2 = 0
                r4 = 0
                cz.mobilesoft.appblock.service.LockAccessibilityService.H1(r0, r1, r2, r3, r4, r5, r6, r7, r8)
                kotlin.Unit r10 = kotlin.Unit.f139807a
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.appblock.service.LockAccessibilityService.AnonymousClass23.a(long, kotlin.coroutines.Continuation):java.lang.Object");
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
            return a(((Number) obj).longValue(), continuation);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.appblock.service.LockAccessibilityService$onInitialized$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.appblock.service.LockAccessibilityService$onInitialized$3", f = "LockAccessibilityService.kt", l = {462}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass3 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f94335a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f94336b;

        AnonymousClass3(Continuation continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return LockAccessibilityService.this.new AnonymousClass3(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            LockAccessibilityService lockAccessibilityService;
            Object objF = IntrinsicsKt.f();
            int i3 = this.f94336b;
            if (i3 == 0) {
                ResultKt.b(obj);
                PrefManager prefManager = PrefManager.f126839a;
                if (!prefManager.H1()) {
                    Context applicationContext = LockAccessibilityService.this.getApplicationContext();
                    Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
                    prefManager.z1(applicationContext);
                }
                LockAccessibilityService lockAccessibilityService2 = LockAccessibilityService.this;
                Flow flowD0 = lockAccessibilityService2.W0().d0();
                this.f94335a = lockAccessibilityService2;
                this.f94336b = 1;
                Object objD = FlowKt.D(flowD0, this);
                if (objD == objF) {
                    return objF;
                }
                lockAccessibilityService = lockAccessibilityService2;
                obj = objD;
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                lockAccessibilityService = (LockAccessibilityService) this.f94335a;
                ResultKt.b(obj);
            }
            lockAccessibilityService.J = ((Number) obj).intValue();
            LockAccessibilityService.this.f94237v = true;
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((AnonymousClass3) create(continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.appblock.service.LockAccessibilityService$onInitialized$4, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.appblock.service.LockAccessibilityService$onInitialized$4", f = "LockAccessibilityService.kt", l = {470}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f94338a;

        AnonymousClass4(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return LockAccessibilityService.this.new AnonymousClass4(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f94338a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowE = DatabaseExtKt.e(LockAccessibilityService.this.e1().Q0(), 0, 0L, null, 7, null);
                final LockAccessibilityService lockAccessibilityService = LockAccessibilityService.this;
                FlowCollector flowCollector = new FlowCollector() { // from class: cz.mobilesoft.appblock.service.LockAccessibilityService.onInitialized.4.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public final Object emit(List list, Continuation continuation) {
                        List listL1 = lockAccessibilityService.L1(list);
                        lockAccessibilityService.f94218d0 = listL1;
                        lockAccessibilityService.f94214b0 = null;
                        lockAccessibilityService.f94216c0 = 0L;
                        ArrayList arrayList = new ArrayList();
                        for (T t2 : listL1) {
                            if (((ProfileWithConfiguration) t2).z()) {
                                arrayList.add(t2);
                            }
                        }
                        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
                        int size = arrayList.size();
                        int i4 = 0;
                        while (i4 < size) {
                            Object obj2 = arrayList.get(i4);
                            i4++;
                            arrayList2.add(Boxing.e(((ProfileWithConfiguration) obj2).p().r()));
                        }
                        Set set = CollectionsKt.toSet(arrayList2);
                        Set setMinus = SetsKt.minus(set, (Iterable) lockAccessibilityService.G);
                        lockAccessibilityService.G = set;
                        if (lockAccessibilityService.F1(listL1, setMinus)) {
                            lockAccessibilityService.J1();
                        }
                        return Unit.f139807a;
                    }
                };
                this.f94338a = 1;
                if (flowE.collect(flowCollector, this) == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass4) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.appblock.service.LockAccessibilityService$onInitialized$5, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.appblock.service.LockAccessibilityService$onInitialized$5", f = "LockAccessibilityService.kt", l = {499}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f94341a;

        AnonymousClass5(Continuation continuation) {
            super(2, continuation);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Map q(List list) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                BrowserViewId browserViewId = (BrowserViewId) it.next();
                String packageName = browserViewId.getPackageName();
                Object linkedHashSet = linkedHashMap.get(packageName);
                if (linkedHashSet == null) {
                    linkedHashSet = new LinkedHashSet();
                }
                Set set = (Set) linkedHashSet;
                set.add(new ViewIdDTO(browserViewId.getViewId(), browserViewId.getClearUrl(), browserViewId.getShowLocalHtml()));
                linkedHashMap.put(packageName, set);
            }
            return linkedHashMap;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return LockAccessibilityService.this.new AnonymousClass5(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f94341a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowE = DatabaseExtKt.e(LockAccessibilityService.this.V0().J(), 0, 0L, null, 7, null);
                final LockAccessibilityService lockAccessibilityService = LockAccessibilityService.this;
                FlowCollector flowCollector = new FlowCollector() { // from class: cz.mobilesoft.appblock.service.LockAccessibilityService.onInitialized.5.1

                    /* JADX INFO: renamed from: cz.mobilesoft.appblock.service.LockAccessibilityService$onInitialized$5$1$WhenMappings */
                    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                    @Metadata
                    public static final /* synthetic */ class WhenMappings {

                        /* JADX INFO: renamed from: a, reason: collision with root package name */
                        public static final /* synthetic */ int[] f94344a;

                        static {
                            int[] iArr = new int[BrowserViewId.ViewType.values().length];
                            try {
                                iArr[BrowserViewId.ViewType.URL_BAR.ordinal()] = 1;
                            } catch (NoSuchFieldError unused) {
                            }
                            try {
                                iArr[BrowserViewId.ViewType.INCOGNITO_BADGE.ordinal()] = 2;
                            } catch (NoSuchFieldError unused2) {
                            }
                            f94344a = iArr;
                        }
                    }

                    @Override // kotlinx.coroutines.flow.FlowCollector
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public final Object emit(List list, Continuation continuation) {
                        lockAccessibilityService.w1("BrowserViewIds updated with " + list);
                        ArrayList arrayList = new ArrayList();
                        ArrayList arrayList2 = new ArrayList();
                        for (T t2 : list) {
                            if (((BrowserViewId) t2).getDetectionMethod() != null) {
                                arrayList.add(t2);
                            } else {
                                arrayList2.add(t2);
                            }
                        }
                        Pair pair = new Pair(arrayList, arrayList2);
                        List<BrowserViewId> list2 = (List) pair.a();
                        List list3 = (List) pair.b();
                        LockAccessibilityService lockAccessibilityService2 = lockAccessibilityService;
                        LinkedHashMap linkedHashMap = new LinkedHashMap();
                        for (BrowserViewId browserViewId : list2) {
                            String packageName = browserViewId.getPackageName();
                            Object arrayList3 = linkedHashMap.get(packageName);
                            if (arrayList3 == null) {
                                arrayList3 = new ArrayList();
                            }
                            List list4 = (List) arrayList3;
                            list4.add(browserViewId);
                            linkedHashMap.put(packageName, list4);
                        }
                        lockAccessibilityService2.f94239x = linkedHashMap;
                        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                        for (T t3 : list3) {
                            BrowserViewId.ViewType viewType = ((BrowserViewId) t3).getViewType();
                            Object arrayList4 = linkedHashMap2.get(viewType);
                            if (arrayList4 == null) {
                                arrayList4 = new ArrayList();
                                linkedHashMap2.put(viewType, arrayList4);
                            }
                            ((List) arrayList4).add(t3);
                        }
                        LockAccessibilityService lockAccessibilityService3 = lockAccessibilityService;
                        for (Map.Entry entry : linkedHashMap2.entrySet()) {
                            BrowserViewId.ViewType viewType2 = (BrowserViewId.ViewType) entry.getKey();
                            List list5 = (List) entry.getValue();
                            int i4 = WhenMappings.f94344a[viewType2.ordinal()];
                            if (i4 == 1) {
                                lockAccessibilityService3.f94238w = AnonymousClass5.q(list5);
                            } else {
                                if (i4 != 2) {
                                    throw new NoWhenBranchMatchedException();
                                }
                                lockAccessibilityService3.f94240y = AnonymousClass5.q(list5);
                            }
                        }
                        return Unit.f139807a;
                    }
                };
                this.f94341a = 1;
                if (flowE.collect(flowCollector, this) == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass5) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LockAccessibilityService() {
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.f139761a;
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f94215c = LazyKt.a(lazyThreadSafetyMode, new Function0<BlockSessionDao>() { // from class: cz.mobilesoft.appblock.service.LockAccessibilityService$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ComponentCallbacks componentCallbacks = this;
                return AndroidKoinScopeExtKt.a(componentCallbacks).e(Reflection.b(BlockSessionDao.class), qualifier, objArr);
            }
        });
        final Object[] objArr2 = 0 == true ? 1 : 0;
        final Object[] objArr3 = 0 == true ? 1 : 0;
        this.f94217d = LazyKt.a(lazyThreadSafetyMode, new Function0<BrowserViewIdDao>() { // from class: cz.mobilesoft.appblock.service.LockAccessibilityService$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ComponentCallbacks componentCallbacks = this;
                return AndroidKoinScopeExtKt.a(componentCallbacks).e(Reflection.b(BrowserViewIdDao.class), objArr2, objArr3);
            }
        });
        final Object[] objArr4 = 0 == true ? 1 : 0;
        final Object[] objArr5 = 0 == true ? 1 : 0;
        this.f94220f = LazyKt.a(lazyThreadSafetyMode, new Function0<ProfileDao>() { // from class: cz.mobilesoft.appblock.service.LockAccessibilityService$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ComponentCallbacks componentCallbacks = this;
                return AndroidKoinScopeExtKt.a(componentCallbacks).e(Reflection.b(ProfileDao.class), objArr4, objArr5);
            }
        });
        final Object[] objArr6 = 0 == true ? 1 : 0;
        final Object[] objArr7 = 0 == true ? 1 : 0;
        this.f94222g = LazyKt.a(lazyThreadSafetyMode, new Function0<WebsiteProfileRelationDao>() { // from class: cz.mobilesoft.appblock.service.LockAccessibilityService$special$$inlined$inject$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ComponentCallbacks componentCallbacks = this;
                return AndroidKoinScopeExtKt.a(componentCallbacks).e(Reflection.b(WebsiteProfileRelationDao.class), objArr6, objArr7);
            }
        });
        final Object[] objArr8 = 0 == true ? 1 : 0;
        final Object[] objArr9 = 0 == true ? 1 : 0;
        this.f94223h = LazyKt.a(lazyThreadSafetyMode, new Function0<AdultContentWebsiteDao>() { // from class: cz.mobilesoft.appblock.service.LockAccessibilityService$special$$inlined$inject$default$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ComponentCallbacks componentCallbacks = this;
                return AndroidKoinScopeExtKt.a(componentCallbacks).e(Reflection.b(AdultContentWebsiteDao.class), objArr8, objArr9);
            }
        });
        final Object[] objArr10 = 0 == true ? 1 : 0;
        final Object[] objArr11 = 0 == true ? 1 : 0;
        this.f94224i = LazyKt.a(lazyThreadSafetyMode, new Function0<CoreMultiProcessDataStore>() { // from class: cz.mobilesoft.appblock.service.LockAccessibilityService$special$$inlined$inject$default$6
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ComponentCallbacks componentCallbacks = this;
                return AndroidKoinScopeExtKt.a(componentCallbacks).e(Reflection.b(CoreMultiProcessDataStore.class), objArr10, objArr11);
            }
        });
        final Object[] objArr12 = 0 == true ? 1 : 0;
        final Object[] objArr13 = 0 == true ? 1 : 0;
        this.f94225j = LazyKt.a(lazyThreadSafetyMode, new Function0<StatisticsDataStore>() { // from class: cz.mobilesoft.appblock.service.LockAccessibilityService$special$$inlined$inject$default$7
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ComponentCallbacks componentCallbacks = this;
                return AndroidKoinScopeExtKt.a(componentCallbacks).e(Reflection.b(StatisticsDataStore.class), objArr12, objArr13);
            }
        });
        final Object[] objArr14 = 0 == true ? 1 : 0;
        final Object[] objArr15 = 0 == true ? 1 : 0;
        this.f94226k = LazyKt.a(lazyThreadSafetyMode, new Function0<StrictModeDataStore>() { // from class: cz.mobilesoft.appblock.service.LockAccessibilityService$special$$inlined$inject$default$8
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ComponentCallbacks componentCallbacks = this;
                return AndroidKoinScopeExtKt.a(componentCallbacks).e(Reflection.b(StrictModeDataStore.class), objArr14, objArr15);
            }
        });
        final Object[] objArr16 = 0 == true ? 1 : 0;
        final Object[] objArr17 = 0 == true ? 1 : 0;
        this.f94227l = LazyKt.a(lazyThreadSafetyMode, new Function0<EventDataStore>() { // from class: cz.mobilesoft.appblock.service.LockAccessibilityService$special$$inlined$inject$default$9
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ComponentCallbacks componentCallbacks = this;
                return AndroidKoinScopeExtKt.a(componentCallbacks).e(Reflection.b(EventDataStore.class), objArr16, objArr17);
            }
        });
        final Object[] objArr18 = 0 == true ? 1 : 0;
        final Object[] objArr19 = 0 == true ? 1 : 0;
        this.f94228m = LazyKt.a(lazyThreadSafetyMode, new Function0<SubAppRepository>() { // from class: cz.mobilesoft.appblock.service.LockAccessibilityService$special$$inlined$inject$default$10
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ComponentCallbacks componentCallbacks = this;
                return AndroidKoinScopeExtKt.a(componentCallbacks).e(Reflection.b(SubAppRepository.class), objArr18, objArr19);
            }
        });
        final Object[] objArr20 = 0 == true ? 1 : 0;
        final Object[] objArr21 = 0 == true ? 1 : 0;
        this.f94229n = LazyKt.a(lazyThreadSafetyMode, new Function0<DexReceiver>() { // from class: cz.mobilesoft.appblock.service.LockAccessibilityService$special$$inlined$inject$default$11
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ComponentCallbacks componentCallbacks = this;
                return AndroidKoinScopeExtKt.a(componentCallbacks).e(Reflection.b(DexReceiver.class), objArr20, objArr21);
            }
        });
        final Object[] objArr22 = 0 == true ? 1 : 0;
        final Object[] objArr23 = 0 == true ? 1 : 0;
        this.f94230o = LazyKt.a(lazyThreadSafetyMode, new Function0<GetUsageLimitsForCurrentPeriodUseCase>() { // from class: cz.mobilesoft.appblock.service.LockAccessibilityService$special$$inlined$inject$default$12
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ComponentCallbacks componentCallbacks = this;
                return AndroidKoinScopeExtKt.a(componentCallbacks).e(Reflection.b(GetUsageLimitsForCurrentPeriodUseCase.class), objArr22, objArr23);
            }
        });
        final Object[] objArr24 = 0 == true ? 1 : 0;
        final Object[] objArr25 = 0 == true ? 1 : 0;
        this.f94231p = LazyKt.a(lazyThreadSafetyMode, new Function0<DetectBrowserUrlUseCase>() { // from class: cz.mobilesoft.appblock.service.LockAccessibilityService$special$$inlined$inject$default$13
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ComponentCallbacks componentCallbacks = this;
                return AndroidKoinScopeExtKt.a(componentCallbacks).e(Reflection.b(DetectBrowserUrlUseCase.class), objArr24, objArr25);
            }
        });
        this.f94232q = new BlockingDecisionMaker();
        final Object[] objArr26 = 0 == true ? 1 : 0;
        final Object[] objArr27 = 0 == true ? 1 : 0;
        this.f94233r = LazyKt.a(lazyThreadSafetyMode, new Function0<GetForegroundAppsUseCase>() { // from class: cz.mobilesoft.appblock.service.LockAccessibilityService$special$$inlined$inject$default$14
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ComponentCallbacks componentCallbacks = this;
                return AndroidKoinScopeExtKt.a(componentCallbacks).e(Reflection.b(GetForegroundAppsUseCase.class), objArr26, objArr27);
            }
        });
        this.f94234s = LazyKt.b(new Function0() { // from class: cz.mobilesoft.appblock.service.y
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return LockAccessibilityService.l1(this.f95104a);
            }
        });
        this.f94236u = LazyKt.b(new Function0() { // from class: cz.mobilesoft.appblock.service.z
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return LockAccessibilityService.p0(this.f95106a);
            }
        });
        this.f94241z = -1L;
        this.A = "";
        this.C = "";
        this.D = new UrlCheck(null, null, 0L, false, 15, null);
        this.F = new FullScreenBrowserBlockingCache(0 == true ? 1 : 0, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        this.G = SetsKt.emptySet();
        this.M = true;
        this.R = new LinkedBlockingQueue();
        this.T = SetsKt.emptySet();
        this.f94218d0 = CollectionsKt.emptyList();
    }

    private final void A0(AccessibilityNodeInfo accessibilityNodeInfo, String str) {
        List list;
        BrowserUrlDetectionResult browserUrlDetectionResultA;
        Map map = this.f94239x;
        if (map == null || (list = (List) map.get(str)) == null) {
            return;
        }
        if ((this.V || !accessibilityNodeInfo.isFocused()) && (browserUrlDetectionResultA = X0().a(new DetectBrowserUrlUseCase.Params(accessibilityNodeInfo, list))) != null) {
            K1(str, browserUrlDetectionResultA.c());
            String url = browserUrlDetectionResultA.c().getUrl();
            boolean zAreEqual = Intrinsics.areEqual(url, this.D.d());
            boolean z2 = zAreEqual && (this.X || (this.D.f() && TimeHelperExt.c() - this.D.c() > 3000));
            if (!zAreEqual || z2) {
                boolean zU0 = U0(browserUrlDetectionResultA.b(), browserUrlDetectionResultA.c(), browserUrlDetectionResultA.a().getClearUrl(), browserUrlDetectionResultA.a().getShowLocalHtml());
                this.X = false;
                this.D = UrlCheck.b(this.D, url, null, TimeHelperExt.c(), zU0, 2, null);
                if (zU0) {
                    this.V = false;
                }
            }
        }
    }

    private final void A1(AccessibilityNodeInfo accessibilityNodeInfo, boolean z2) {
        String string;
        String string2;
        if (Build.VERSION.SDK_INT < 30) {
            if (z2) {
                Bundle bundle = new Bundle();
                bundle.putCharSequence("ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE", "");
                accessibilityNodeInfo.performAction(2097152, bundle);
            }
            try {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setFlags(1);
                intent.addFlags(268435456);
                intent.setPackage(accessibilityNodeInfo.getPackageName().toString());
                Uri uri = this.I;
                if (uri == null) {
                    uri = Uri.parse(this.H);
                }
                intent.setData(uri);
                startActivity(intent);
                return;
            } catch (Exception e3) {
                performGlobalAction(1);
                e3.printStackTrace();
                CrashHelper.j(e3);
                return;
            }
        }
        Bundle bundle2 = new Bundle();
        Uri uri2 = this.I;
        if (uri2 == null || (string = uri2.toString()) == null) {
            string = this.H;
        }
        bundle2.putCharSequence("ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE", string);
        boolean zPerformAction = accessibilityNodeInfo.performAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_FOCUS.getId());
        CharSequence packageName = accessibilityNodeInfo.getPackageName();
        String string3 = packageName != null ? packageName.toString() : null;
        String str = string3 != null ? string3 : "";
        if (!zPerformAction && !accessibilityNodeInfo.isFocused() && !Intrinsics.areEqual(str, "com.sec.android.app.sbrowser")) {
            B1(this.H, str);
            return;
        }
        this.Y = System.currentTimeMillis();
        accessibilityNodeInfo.performAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_CLICK.getId());
        if (!accessibilityNodeInfo.performAction(2097152, bundle2)) {
            performGlobalAction(1);
            performGlobalAction(2);
            return;
        }
        Bundle bundle3 = new Bundle();
        bundle3.putInt("ACTION_ARGUMENT_SELECTION_START_INT", 0);
        Uri uri3 = this.I;
        if (uri3 == null || (string2 = uri3.toString()) == null) {
            string2 = this.H;
        }
        bundle3.putInt("ACTION_ARGUMENT_SELECTION_END_INT", string2 != null ? string2.length() : 0);
        accessibilityNodeInfo.performAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_SELECTION.getId(), bundle3);
        accessibilityNodeInfo.performAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_IME_ENTER.getId());
    }

    private final void B0(AccessibilityNodeInfo accessibilityNodeInfo, String str) {
        Set set;
        Map map = this.f94238w;
        if (map == null || (set = (Set) map.get(str)) == null) {
            return;
        }
        List listO0 = O0(this, accessibilityNodeInfo, set, false, 4, null);
        if (listO0.isEmpty()) {
            return;
        }
        if (Intrinsics.areEqual(str, "com.android.chrome")) {
            this.W = true;
        }
        I0(listO0);
        if (this.W) {
            I0(O0(this, accessibilityNodeInfo, SetsKt.setOf(new ViewIdDTO(":id/title_bar", false, false)), false, 4, null));
        }
    }

    private final void B1(String str, String str2) {
        if (str == null) {
            str = PrefManager.f126839a.W0();
        }
        if (str == null || StringsKt.p0(str)) {
            performGlobalAction(1);
            performGlobalAction(2);
            return;
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        intent.setPackage(str2);
        intent.addFlags(268435456);
        try {
            startActivity(intent);
        } catch (Exception unused) {
            performGlobalAction(1);
            performGlobalAction(2);
        }
    }

    private final void C0(AccessibilityNodeInfo accessibilityNodeInfo) {
        w1("Checking for AppBlock in FGS Task Manager.");
        if (q1(accessibilityNodeInfo)) {
            w1("AppBlock found");
            r0(this, null, getApplicationContext().getString(R.string.active_apps_dialog), null, 5, null);
        }
    }

    private final void C1(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (t1()) {
            return;
        }
        if (!CollectionsKt.contains(this.T, accessibilityNodeInfo.getPackageName()) || !this.U) {
            if (this.D.d().length() > 0) {
                this.D = UrlCheck.b(this.D, null, "", 0L, false, 13, null);
                return;
            }
            return;
        }
        if (accessibilityNodeInfo.isFocused()) {
            String simpleName = LockAccessibilityService.class.getSimpleName();
            Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
            Log.d(simpleName, "Node focused, clearing focus");
            this.V = false;
            accessibilityNodeInfo.performAction(2);
            return;
        }
        if (this.D.e().length() != 0 && System.currentTimeMillis() - this.f94212a0 < 2000) {
            w1("Node not focused, secondary url known, skipping");
            return;
        }
        w1("Node not focused, secondary url unknown, clicking");
        this.f94212a0 = System.currentTimeMillis();
        this.V = true;
        this.Y = System.currentTimeMillis();
        accessibilityNodeInfo.performAction(16);
    }

    private final boolean D0(AccessibilityNodeInfo accessibilityNodeInfo) {
        w1("Checking if user change is being attempted.");
        if (!v1(accessibilityNodeInfo)) {
            return false;
        }
        w1("User selection dialog is open");
        r0(this, null, getApplicationContext().getString(R.string.user_change), null, 5, null);
        return true;
    }

    private final void D1() {
        if (this.f94221f0) {
            return;
        }
        try {
            DexReceiver dexReceiverY0 = Y0();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.app.action.ENTER_KNOX_DESKTOP_MODE");
            intentFilter.addAction("android.app.action.EXIT_KNOX_DESKTOP_MODE");
            Unit unit = Unit.f139807a;
            ContextCompat.registerReceiver(this, dexReceiverY0, intentFilter, 4);
            this.f94221f0 = true;
        } catch (Exception e3) {
            CrashHelper.j(e3);
        }
    }

    private final void E0(AccessibilityNodeInfo accessibilityNodeInfo, String str) throws Throwable {
        Set set;
        if (!this.M) {
            x1(str);
            return;
        }
        Map map = this.f94240y;
        if (map != null && (set = (Set) map.get(accessibilityNodeInfo.getPackageName())) != null) {
            NodeInfoDTO nodeInfoDTO = (NodeInfoDTO) CollectionsKt.firstOrNull(O0(this, accessibilityNodeInfo, set, false, 4, null));
            Unit unit = null;
            if (nodeInfoDTO != null) {
                w1("Incognito detected: " + nodeInfoDTO.d().getViewIdResourceName());
                x1(null);
                unit = Unit.f139807a;
            }
            if (unit != null) {
                return;
            }
        }
        x1(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E1(String str) {
        if (f94209i0.contains(str)) {
            return;
        }
        this.C = str;
    }

    private final BlockingDecision F0(List list, UrlDto urlDto, SubApp subApp) {
        return this.f94232q.e(list, c1().j(new GetUsageLimitsForCurrentPeriodUseCase.Params(list, null, urlDto, subApp, 2, null)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean F1(List list, Set set) {
        UrlDto urlDtoB;
        if (set.isEmpty() || (urlDtoB = this.F.b()) == null) {
            return false;
        }
        List<ProfileWithConfiguration> list2 = list;
        if ((list2 instanceof Collection) && list2.isEmpty()) {
            return false;
        }
        for (ProfileWithConfiguration profileWithConfiguration : list2) {
            if (set.contains(Long.valueOf(profileWithConfiguration.p().r())) && profileWithConfiguration.z() && (profileWithConfiguration.w(urlDtoB) || profileWithConfiguration.p().j())) {
                return true;
            }
        }
        return false;
    }

    static /* synthetic */ BlockingDecision G0(LockAccessibilityService lockAccessibilityService, List list, UrlDto urlDto, SubApp subApp, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            urlDto = null;
        }
        if ((i3 & 4) != 0) {
            subApp = null;
        }
        return lockAccessibilityService.F0(list, urlDto, subApp);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0085  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void G1(java.lang.String r17, cz.mobilesoft.coreblock.dto.UrlDto r18, java.util.List r19, cz.mobilesoft.coreblock.storage.room.entity.blocking.UsageLimit.PeriodType r20, java.lang.String r21, cz.mobilesoft.coreblock.enums.StrictModeOption r22) {
        /*
            Method dump skipped, instruction units count: 202
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.appblock.service.LockAccessibilityService.G1(java.lang.String, cz.mobilesoft.coreblock.dto.UrlDto, java.util.List, cz.mobilesoft.coreblock.storage.room.entity.blocking.UsageLimit$PeriodType, java.lang.String, cz.mobilesoft.coreblock.enums.StrictModeOption):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H0(AccessibilityNodeInfo accessibilityNodeInfo) {
        String string;
        CharSequence packageName = accessibilityNodeInfo.getPackageName();
        if (packageName == null || (string = packageName.toString()) == null) {
            return;
        }
        SubAppRepository subAppRepositoryI1 = i1();
        List list = this.f94218d0;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((ProfileWithConfiguration) obj).z()) {
                arrayList.add(obj);
            }
        }
        List listE = subAppRepositoryI1.e(CollectionsKt.toList(ProfileWithConfigurationKt.c(arrayList)));
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : listE) {
            if (Intrinsics.areEqual(((SubApp) obj2).getParentApp(), accessibilityNodeInfo.getPackageName())) {
                arrayList2.add(obj2);
            }
        }
        if (!arrayList2.isEmpty() && accessibilityNodeInfo.getParent() == null) {
            w0(arrayList2, accessibilityNodeInfo);
        }
        if (Q0() != null) {
            if (Intrinsics.areEqual(string, "com.android.systemui") && !D0(accessibilityNodeInfo) && Build.VERSION.SDK_INT >= 33) {
                C0(accessibilityNodeInfo);
            }
            if (this.N) {
                u0(accessibilityNodeInfo);
            }
        }
        if (!Intrinsics.areEqual(this.C, string)) {
            if (Intrinsics.areEqual(string, "com.google.android.googlequicksearchbox")) {
                CoroutinesHelperExtKt.d(new LockAccessibilityService$checkNodeInfo$1$2(this, null));
            }
            E1(string);
        }
        B0(accessibilityNodeInfo, string);
        A0(accessibilityNodeInfo, string);
    }

    static /* synthetic */ void H1(LockAccessibilityService lockAccessibilityService, String str, UrlDto urlDto, List list, UsageLimit.PeriodType periodType, String str2, StrictModeOption strictModeOption, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            periodType = null;
        }
        if ((i3 & 16) != 0) {
            str2 = null;
        }
        if ((i3 & 32) != 0) {
            strictModeOption = null;
        }
        lockAccessibilityService.G1(str, urlDto, list, periodType, str2, strictModeOption);
    }

    private final void I0(List list) {
        String lowerCase;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            NodeInfoDTO nodeInfoDTO = (NodeInfoDTO) it.next();
            AccessibilityNodeInfo accessibilityNodeInfoA = nodeInfoDTO.a();
            boolean zB = nodeInfoDTO.b();
            boolean zC = nodeInfoDTO.c();
            CharSequence text = accessibilityNodeInfoA.getText();
            if (text == null || text.length() == 0) {
                lowerCase = "";
            } else {
                lowerCase = accessibilityNodeInfoA.getText().toString().toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            }
            w1("Loaded URL: " + lowerCase);
            if (!this.V && accessibilityNodeInfoA.isFocused()) {
                w1("Node focused, not blocking");
            } else if (t0(accessibilityNodeInfoA, lowerCase, zB, zC)) {
                this.V = false;
                this.W = false;
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I1(String str, UrlDto urlDto, SubApp subApp) {
        PackageAdditionalBlockingDTO packageAdditionalBlockingDTO = new PackageAdditionalBlockingDTO(str, urlDto, subApp);
        ServiceHelper serviceHelper = ServiceHelper.f95139a;
        if (serviceHelper.d(this)) {
            if (str == null && urlDto == null && subApp == null) {
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putParcelable("USAGE_LIMIT_HOST", packageAdditionalBlockingDTO);
            serviceHelper.g(this, bundle);
        }
        CoroutinesHelperExtKt.d(new LockAccessibilityService$startOrInformLockService$1(this, packageAdditionalBlockingDTO, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void J0() {
        this.F = new FullScreenBrowserBlockingCache(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J1() {
        String strA;
        AccessibilityNodeInfo rootInActiveWindow;
        CharSequence packageName;
        String string;
        Map map;
        UrlDto urlDtoB = this.F.b();
        if (urlDtoB == null || (strA = this.F.a()) == null || (rootInActiveWindow = getRootInActiveWindow()) == null || (packageName = rootInActiveWindow.getPackageName()) == null || (string = packageName.toString()) == null || !Intrinsics.areEqual(string, strA)) {
            return;
        }
        Map map2 = this.f94239x;
        if ((map2 == null || !map2.containsKey(string)) && ((map = this.f94238w) == null || !map.containsKey(string))) {
            return;
        }
        U0(rootInActiveWindow, urlDtoB, false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object K0(String str, Continuation continuation) {
        Object objG = BuildersKt.g(Dispatchers.c(), new LockAccessibilityService$closeBlockedSubApp$2(this, str, null), continuation);
        return objG == IntrinsicsKt.f() ? objG : Unit.f139807a;
    }

    private final void K1(String str, UrlDto urlDto) {
        if (urlDto.isDomainReliable() && s1(urlDto.getDomain())) {
            this.F = new FullScreenBrowserBlockingCache(str, urlDto);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L0() {
        performGlobalAction(2);
        performGlobalAction(3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List L1(List list) {
        String strW0 = this.H;
        if (strW0 != null || (strW0 = PrefManager.f126839a.W0()) != null) {
            String lowerCase = StringHelper.f128649a.y(strW0, "((.*:)//)?(www\\.)?([A-Za-z0-9\\-]+(\\.[A-Za-z0-9\\-]+)+)(:[0-9]+)?(.*)").toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            if (!StringsKt.p0(lowerCase)) {
                List<ProfileWithConfiguration> list2 = list;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                for (ProfileWithConfiguration profileWithConfigurationD : list2) {
                    if (profileWithConfigurationD.p().o() == Profile.BlockingMode.Allowlist) {
                        profileWithConfigurationD = ProfileWithConfiguration.d(profileWithConfigurationD, null, null, CollectionsKt.plus((Collection<? extends WebsiteProfileRelation>) profileWithConfigurationD.s(), new WebsiteProfileRelation(0L, profileWithConfigurationD.p().r(), lowerCase, WebsiteProfileRelation.BlockingType.DOMAIN, false, false, 49, null)), null, null, null, null, null, null, 507, null);
                    }
                    arrayList.add(profileWithConfigurationD);
                }
                return arrayList;
            }
        }
        return list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M0(String str) {
        BuildersKt__Builders_commonKt.d(this.f94211a, null, null, new LockAccessibilityService$dismissPipWindowOf$1(this, str, null), 3, null);
    }

    private final List N0(AccessibilityNodeInfo accessibilityNodeInfo, Set set, boolean z2) {
        AccessibilityNodeInfo accessibilityNodeInfoF1;
        NodeInfoDTO nodeInfoDTO;
        try {
            AccessibilityWindowInfo window = accessibilityNodeInfo.getWindow();
            if (window == null || (accessibilityNodeInfoF1 = window.getRoot()) == null) {
                accessibilityNodeInfoF1 = f1(accessibilityNodeInfo, 30);
                if (accessibilityNodeInfoF1 == null) {
                    return CollectionsKt.emptyList();
                }
            }
            ArrayList arrayList = new ArrayList();
            Iterator it = set.iterator();
            while (it.hasNext()) {
                ViewIdDTO viewIdDTO = (ViewIdDTO) it.next();
                CharSequence packageName = accessibilityNodeInfo.getPackageName();
                List<AccessibilityNodeInfo> listFindAccessibilityNodeInfosByViewId = accessibilityNodeInfoF1.findAccessibilityNodeInfosByViewId(((Object) packageName) + viewIdDTO.b());
                Intrinsics.checkNotNullExpressionValue(listFindAccessibilityNodeInfosByViewId, "findAccessibilityNodeInfosByViewId(...)");
                ArrayList arrayList2 = new ArrayList();
                for (AccessibilityNodeInfo accessibilityNodeInfo2 : listFindAccessibilityNodeInfosByViewId) {
                    if (!z2 || accessibilityNodeInfo2.isVisibleToUser()) {
                        Intrinsics.checkNotNull(accessibilityNodeInfo2);
                        nodeInfoDTO = new NodeInfoDTO(accessibilityNodeInfo2, viewIdDTO.a(), viewIdDTO.c());
                    } else {
                        nodeInfoDTO = null;
                    }
                    if (nodeInfoDTO != null) {
                        arrayList2.add(nodeInfoDTO);
                    }
                }
                arrayList.addAll(arrayList2);
            }
            if (arrayList.isEmpty()) {
                AccessibilityWindowInfo window2 = accessibilityNodeInfo.getWindow();
                if (window2 != null) {
                    window2.recycle();
                }
                return CollectionsKt.emptyList();
            }
            AccessibilityWindowInfo window3 = accessibilityNodeInfo.getWindow();
            if (window3 != null) {
                window3.recycle();
            }
            return arrayList;
        } catch (IllegalStateException e3) {
            CrashHelper.j(e3);
            e3.printStackTrace();
            return CollectionsKt.emptyList();
        }
    }

    static /* synthetic */ List O0(LockAccessibilityService lockAccessibilityService, AccessibilityNodeInfo accessibilityNodeInfo, Set set, boolean z2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z2 = false;
        }
        return lockAccessibilityService.N0(accessibilityNodeInfo, set, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AccessibilityNodeInfo P0(String str) {
        AccessibilityNodeInfo accessibilityNodeInfo;
        AccessibilityNodeInfo root;
        List<AccessibilityWindowInfo> windows = getWindows();
        Intrinsics.checkNotNullExpressionValue(windows, "getWindows(...)");
        Iterator<T> it = windows.iterator();
        do {
            accessibilityNodeInfo = null;
            if (!it.hasNext()) {
                break;
            }
            AccessibilityWindowInfo accessibilityWindowInfo = (AccessibilityWindowInfo) it.next();
            if (accessibilityWindowInfo.getType() == 1 && accessibilityWindowInfo.isInPictureInPictureMode()) {
                try {
                    root = accessibilityWindowInfo.getRoot();
                } catch (Exception e3) {
                    String string = e3.toString();
                    String simpleName = LockAccessibilityService.class.getSimpleName();
                    Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
                    Log.e(simpleName, string);
                    root = null;
                }
                if (root != null) {
                    CharSequence packageName = root.getPackageName();
                    if (Intrinsics.areEqual(packageName != null ? packageName.toString() : null, str)) {
                        accessibilityNodeInfo = root;
                    }
                }
            }
        } while (accessibilityNodeInfo == null);
        return accessibilityNodeInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List Q0() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j3 = this.B;
        if (j3 != 0 && jCurrentTimeMillis - j3 <= 500) {
            return null;
        }
        if (this.f94214b0 == null || jCurrentTimeMillis - this.f94216c0 >= 500) {
            List list = this.f94218d0;
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                ProfileWithConfiguration profileWithConfiguration = (ProfileWithConfiguration) obj;
                if (profileWithConfiguration.p().S() && profileWithConfiguration.y()) {
                    arrayList.add(obj);
                }
            }
            this.f94214b0 = arrayList.isEmpty() ? null : arrayList;
            this.f94216c0 = jCurrentTimeMillis;
        }
        return this.f94214b0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AdultContentWebsiteDao R0() {
        return (AdultContentWebsiteDao) this.f94223h.getValue();
    }

    private final String S0() {
        return (String) this.f94236u.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BlockSessionDao T0() {
        return (BlockSessionDao) this.f94215c.getValue();
    }

    private final boolean U0(AccessibilityNodeInfo accessibilityNodeInfo, UrlDto urlDto, boolean z2, boolean z3) {
        UrlDto urlDtoCopy$default;
        List list = this.f94218d0;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            ProfileWithConfiguration profileWithConfiguration = (ProfileWithConfiguration) obj;
            if (profileWithConfiguration.z() && (profileWithConfiguration.w(urlDto) || (profileWithConfiguration.p().j() && ((Boolean) BuildersKt__BuildersKt.b(null, new LockAccessibilityService$getBlockedSitesAndBlock$activeProfiles$1$1(this, urlDto, null), 1, null)).booleanValue()))) {
                arrayList.add(obj);
            }
        }
        if (arrayList.isEmpty()) {
            w1("Url not blocked");
            I1((this.K || this.L) ? null : accessibilityNodeInfo.getPackageName().toString(), null, null);
            return false;
        }
        this.W = false;
        if (arrayList.isEmpty()) {
            urlDtoCopy$default = urlDto;
        } else {
            int size = arrayList.size();
            int i3 = 0;
            loop1: while (i3 < size) {
                Object obj2 = arrayList.get(i3);
                i3++;
                List<WebsiteProfileRelation> listS = ((ProfileWithConfiguration) obj2).s();
                if (!(listS instanceof Collection) || !listS.isEmpty()) {
                    for (WebsiteProfileRelation websiteProfileRelation : listS) {
                        if (websiteProfileRelation.a() == WebsiteProfileRelation.BlockingType.KEYWORD && websiteProfileRelation.e() && StringsKt.a0(urlDto.getUrl(), websiteProfileRelation.c(), false, 2, null)) {
                            urlDtoCopy$default = UrlDto.copy$default(urlDto, null, null, true, false, 11, null);
                            break loop1;
                        }
                    }
                }
            }
            urlDtoCopy$default = urlDto;
        }
        w1("Blocking");
        BlockingDecision blockingDecisionG0 = G0(this, arrayList, urlDtoCopy$default, null, 4, null);
        if (blockingDecisionG0 instanceof BlockingDecision.Blocked) {
            s0(accessibilityNodeInfo, urlDtoCopy$default, arrayList, (BlockingDecision.Blocked) blockingDecisionG0, z2, z3);
            return true;
        }
        if (!Intrinsics.areEqual(blockingDecisionG0, BlockingDecision.NotBlocked.f94766a)) {
            throw new NoWhenBranchMatchedException();
        }
        I1(accessibilityNodeInfo.getPackageName().toString(), urlDtoCopy$default, null);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BrowserViewIdDao V0() {
        return (BrowserViewIdDao) this.f94217d.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CoreMultiProcessDataStore W0() {
        return (CoreMultiProcessDataStore) this.f94224i.getValue();
    }

    private final DetectBrowserUrlUseCase X0() {
        return (DetectBrowserUrlUseCase) this.f94231p.getValue();
    }

    private final DexReceiver Y0() {
        return (DexReceiver) this.f94229n.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final EventDataStore Z0() {
        return (EventDataStore) this.f94227l.getValue();
    }

    private final GetForegroundAppsUseCase b1() {
        return (GetForegroundAppsUseCase) this.f94233r.getValue();
    }

    private final GetUsageLimitsForCurrentPeriodUseCase c1() {
        return (GetUsageLimitsForCurrentPeriodUseCase) this.f94230o.getValue();
    }

    private final InAppPurchaseDialogBlocker d1() {
        return (InAppPurchaseDialogBlocker) this.f94234s.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ProfileDao e1() {
        return (ProfileDao) this.f94220f.getValue();
    }

    private final AccessibilityNodeInfo f1(AccessibilityNodeInfo accessibilityNodeInfo, int i3) {
        if (i3 < 1) {
            return null;
        }
        return (accessibilityNodeInfo.getParent() == null || Intrinsics.areEqual(accessibilityNodeInfo.getParent(), accessibilityNodeInfo)) ? accessibilityNodeInfo : f1(accessibilityNodeInfo, i3 - 1);
    }

    private final StatisticsDataStore g1() {
        return (StatisticsDataStore) this.f94225j.getValue();
    }

    private final StrictModeDataStore h1() {
        return (StrictModeDataStore) this.f94226k.getValue();
    }

    private final SubAppRepository i1() {
        return (SubAppRepository) this.f94228m.getValue();
    }

    private final WebsiteProfileRelationDao j1() {
        return (WebsiteProfileRelationDao) this.f94222g.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k1() {
        this.Z = SystemClock.elapsedRealtime();
        performGlobalAction(3);
        BuildersKt__Builders_commonKt.d(this.f94211a, null, null, new LockAccessibilityService$goToRecentsAndHome$1(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InAppPurchaseDialogBlocker l1(final LockAccessibilityService lockAccessibilityService) {
        return new InAppPurchaseDialogBlocker(lockAccessibilityService.f94211a, new Function0() { // from class: cz.mobilesoft.appblock.service.a0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return LockAccessibilityService.m1(this.f94713a);
            }
        }, new Function0() { // from class: cz.mobilesoft.appblock.service.b0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return LockAccessibilityService.n1(this.f94716a);
            }
        }, new Function0() { // from class: cz.mobilesoft.appblock.service.c0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return LockAccessibilityService.o1(this.f94719a);
            }
        }, new Function2() { // from class: cz.mobilesoft.appblock.service.d0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return LockAccessibilityService.p1(this.f94721a, (String) obj, (List) obj2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List m1(LockAccessibilityService lockAccessibilityService) {
        return lockAccessibilityService.f94218d0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GetForegroundAppsUseCase.AppsDTO n1(LockAccessibilityService lockAccessibilityService) {
        return lockAccessibilityService.b1().c(GetForegroundAppsUseCase.Params.f127109a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List o1(LockAccessibilityService lockAccessibilityService) {
        List<AccessibilityWindowInfo> windows = lockAccessibilityService.getWindows();
        Intrinsics.checkNotNullExpressionValue(windows, "getWindows(...)");
        return windows;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String p0(LockAccessibilityService lockAccessibilityService) {
        String string = lockAccessibilityService.getString(R.string.app_name);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p1(LockAccessibilityService lockAccessibilityService, String hostPackageName, List activeProfiles) {
        Intrinsics.checkNotNullParameter(hostPackageName, "hostPackageName");
        Intrinsics.checkNotNullParameter(activeProfiles, "activeProfiles");
        lockAccessibilityService.performGlobalAction(1);
        H1(lockAccessibilityService, hostPackageName, null, activeProfiles, null, lockAccessibilityService.getApplicationContext().getString(R.string.purchase_blocking_title), null, 40, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q0(String str, String str2, StrictModeOption strictModeOption) {
        List listQ0 = Q0();
        if (listQ0 != null) {
            w1("Strict Mode is blocking.");
            if ((strictModeOption == null ? -1 : WhenMappings.f94253a[strictModeOption.ordinal()]) == 1) {
                w1("Split screen divider detected, toggling");
                performGlobalAction(7);
                BuildersKt__Builders_commonKt.d(this.f94211a, null, null, new LockAccessibilityService$blockIfStrictModeActive$1$1(this, null), 3, null);
            } else {
                performGlobalAction(1);
                if (Build.VERSION.SDK_INT >= 31) {
                    performGlobalAction(15);
                } else {
                    performGlobalAction(2);
                }
            }
            H1(this, str, null, listQ0, null, str2, strictModeOption, 8, null);
        }
    }

    static /* synthetic */ void r0(LockAccessibilityService lockAccessibilityService, String str, String str2, StrictModeOption strictModeOption, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = "com.android.settings";
        }
        if ((i3 & 2) != 0) {
            str2 = null;
        }
        if ((i3 & 4) != 0) {
            strictModeOption = null;
        }
        lockAccessibilityService.q0(str, str2, strictModeOption);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean r1(AccessibilityWindowInfo accessibilityWindowInfo) {
        List<AccessibilityNodeInfo> listFindAccessibilityNodeInfosByViewId;
        CharSequence title = accessibilityWindowInfo.getTitle();
        if (Intrinsics.areEqual(title != null ? title.toString() : null, S0())) {
            return true;
        }
        try {
            AccessibilityNodeInfo root = accessibilityWindowInfo.getRoot();
            if (root != null && (listFindAccessibilityNodeInfosByViewId = root.findAccessibilityNodeInfosByViewId("com.android.packageinstaller:id/app_label")) != null) {
                List<AccessibilityNodeInfo> list = listFindAccessibilityNodeInfosByViewId;
                if (!(list instanceof Collection) || !list.isEmpty()) {
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        CharSequence text = ((AccessibilityNodeInfo) it.next()).getText();
                        if (Intrinsics.areEqual(text != null ? text.toString() : null, S0())) {
                            return true;
                        }
                    }
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00c1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void s0(android.view.accessibility.AccessibilityNodeInfo r11, cz.mobilesoft.coreblock.dto.UrlDto r12, java.util.List r13, cz.mobilesoft.appblock.service.lock.BlockingDecision.Blocked r14, boolean r15, boolean r16) {
        /*
            Method dump skipped, instruction units count: 265
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.appblock.service.LockAccessibilityService.s0(android.view.accessibility.AccessibilityNodeInfo, cz.mobilesoft.coreblock.dto.UrlDto, java.util.List, cz.mobilesoft.appblock.service.lock.BlockingDecision$Blocked, boolean, boolean):void");
    }

    private final boolean s1(String str) {
        if (!StringsKt.p0(str) && !StringsKt.Z(str, ' ', false, 2, null) && StringsKt.Z(str, '.', false, 2, null) && !StringsKt.Y0(str, '.', false, 2, null) && !StringsKt.e0(str, '.', false, 2, null)) {
            for (int i3 = 0; i3 < str.length(); i3++) {
                if (Character.isLetter(str.charAt(i3))) {
                    return true;
                }
            }
        }
        return false;
    }

    private final boolean t0(AccessibilityNodeInfo accessibilityNodeInfo, String str, boolean z2, boolean z3) throws Throwable {
        String string;
        boolean z4 = this.V && accessibilityNodeInfo.isFocused();
        boolean z5 = (z4 || Intrinsics.areEqual(str, this.D.d())) ? false : true;
        boolean z6 = (z4 || z5 || (!this.X && (!this.D.f() || TimeHelperExt.c() - this.D.c() <= 3000))) ? false : true;
        boolean z7 = z4 && !Intrinsics.areEqual(str, this.D.e());
        if (z5 || z6 || z7) {
            UrlParsing urlParsing = UrlParsing.f128456a;
            String strA = urlParsing.a(str);
            if (strA != null) {
                UrlDto urlDto = new UrlDto(str, strA, false, urlParsing.c(accessibilityNodeInfo.getViewIdResourceName()), 4, null);
                CharSequence packageName = accessibilityNodeInfo.getPackageName();
                if (packageName != null && (string = packageName.toString()) != null) {
                    K1(string, urlDto);
                }
                if (z5) {
                    E0(accessibilityNodeInfo, strA);
                }
                boolean zU0 = U0(accessibilityNodeInfo, urlDto, z2, z3);
                this.X = false;
                UrlCheck urlCheck = this.D;
                this.D = urlCheck.a(z4 ? urlCheck.d() : str, z4 ? str : this.D.e(), TimeHelperExt.c(), z4 ? this.D.f() || zU0 : zU0);
                if (zU0) {
                    return true;
                }
                if (z4) {
                    this.V = false;
                    accessibilityNodeInfo.performAction(2);
                    return false;
                }
            } else {
                w1("URL malformed");
            }
        } else {
            w1("URL already checked");
        }
        C1(accessibilityNodeInfo);
        return false;
    }

    private final boolean t1() {
        Iterator<AccessibilityWindowInfo> it = getWindows().iterator();
        while (it.hasNext()) {
            if (it.next().getType() == 2) {
                return true;
            }
        }
        return false;
    }

    private final void u0(AccessibilityNodeInfo accessibilityNodeInfo) {
        String string;
        CharSequence packageName = accessibilityNodeInfo.getPackageName();
        if (packageName == null || (string = packageName.toString()) == null) {
            return;
        }
        w1("Checking for recent apps screen");
        if (!Intrinsics.areEqual(this.C, string)) {
            E1(string);
            this.D = new UrlCheck(null, null, 0L, false, 15, null);
        }
        if (SystemClock.elapsedRealtime() - this.Z <= 1000) {
            w1("Recents screen opened by the service, not blocking");
        } else {
            if (CollectionsExtKt.d(O0(this, accessibilityNodeInfo, SetsKt.setOf((Object[]) new ViewIdDTO[]{new ViewIdDTO(":id/recents_container", false, false), new ViewIdDTO(":id/overview_panel", false, false), new ViewIdDTO(":id/taskView", false, false)}), false, 4, null)) == null) {
                return;
            }
            w1("Recent apps screen found, blocking if Strict Mode is active");
            q0(string, getApplicationContext().getString(R.string.recent_apps), StrictModeOption.BlockRecentApps);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean u1(String str) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        List<AccessibilityWindowInfo> windows = getWindows();
        Intrinsics.checkNotNullExpressionValue(windows, "getWindows(...)");
        List<AccessibilityWindowInfo> list = windows;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        for (AccessibilityWindowInfo accessibilityWindowInfo : list) {
            if (accessibilityWindowInfo.getType() == 1 && !accessibilityWindowInfo.isInPictureInPictureMode()) {
                CharSequence packageName = null;
                try {
                    AccessibilityNodeInfo root = accessibilityWindowInfo.getRoot();
                    if (root != null) {
                        packageName = root.getPackageName();
                    }
                } catch (Exception unused) {
                }
                Rect rect = new Rect();
                accessibilityWindowInfo.getBoundsInScreen(rect);
                if (Intrinsics.areEqual(packageName, str) && rect.width() < displayMetrics.widthPixels && rect.height() < displayMetrics.heightPixels) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v0() {
        List<AccessibilityWindowInfo> windows = getWindows();
        w1(windows.size() + " windows");
        Iterator<AccessibilityWindowInfo> it = windows.iterator();
        while (it.hasNext()) {
            if (it.next().getType() == 5) {
                r0(this, null, getApplicationContext().getString(R.string.split_screen), StrictModeOption.BlockSplitScreen, 1, null);
                return;
            }
        }
    }

    private final boolean v1(AccessibilityNodeInfo accessibilityNodeInfo) {
        List<AccessibilityNodeInfo> listFindAccessibilityNodeInfosByViewId = accessibilityNodeInfo.findAccessibilityNodeInfosByViewId("android:id/alertTitle");
        Intrinsics.checkNotNullExpressionValue(listFindAccessibilityNodeInfosByViewId, "findAccessibilityNodeInfosByViewId(...)");
        if (listFindAccessibilityNodeInfosByViewId.isEmpty()) {
            List<AccessibilityNodeInfo> listFindAccessibilityNodeInfosByViewId2 = accessibilityNodeInfo.findAccessibilityNodeInfosByViewId("com.android.systemui:id/qs_detail_header");
            Intrinsics.checkNotNullExpressionValue(listFindAccessibilityNodeInfosByViewId2, "findAccessibilityNodeInfosByViewId(...)");
            if (listFindAccessibilityNodeInfosByViewId2.isEmpty()) {
                return false;
            }
        }
        int size = accessibilityNodeInfo.findAccessibilityNodeInfosByViewId("com.android.systemui:id/user_name").size();
        return size == accessibilityNodeInfo.findAccessibilityNodeInfosByViewId("com.android.systemui:id/user_picture").size() && size > 1;
    }

    private final void w0(List list, final AccessibilityNodeInfo accessibilityNodeInfo) {
        SubAppScreenResolver.f94938a.a(list, new Function1() { // from class: cz.mobilesoft.appblock.service.v
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(LockAccessibilityService.x0(this.f95095a, accessibilityNodeInfo, (SubApp) obj));
            }
        }, new Function0() { // from class: cz.mobilesoft.appblock.service.w
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return LockAccessibilityService.y0(this.f95100a);
            }
        }, new Function1() { // from class: cz.mobilesoft.appblock.service.x
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LockAccessibilityService.z0(this.f95102a, (SubApp) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w1(String str) {
        if (BuildConfig.f95357b.booleanValue()) {
            String simpleName = LockAccessibilityService.class.getSimpleName();
            Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
            Log.d(simpleName, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean x0(LockAccessibilityService lockAccessibilityService, AccessibilityNodeInfo accessibilityNodeInfo, SubApp subApp) {
        Intrinsics.checkNotNullParameter(subApp, "subApp");
        List list = lockAccessibilityService.f94218d0;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (((ProfileWithConfiguration) it.next()).B(subApp)) {
                List<String> viewIds = subApp.getViewIds();
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(viewIds, 10));
                Iterator<T> it2 = viewIds.iterator();
                while (it2.hasNext()) {
                    arrayList.add(new ViewIdDTO((String) it2.next(), false, false, 6, null));
                }
                return !lockAccessibilityService.N0(accessibilityNodeInfo, CollectionsKt.toSet(arrayList), true).isEmpty();
            }
        }
        return false;
    }

    private final void x1(String str) throws Throwable {
        if (this.K || this.L) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        String str2 = this.A;
        if (str2 != null) {
            synchronized (str2) {
                try {
                    if (this.f94241z != -1) {
                        try {
                            if (StringsKt.t0(str2, '.', 0, false, 6, null) > -1) {
                                Statistics.S(new UsageAccess(UsageAccess.Type.WEBSITE, str2, this.f94241z, jCurrentTimeMillis, this.C, null, 32, null));
                            }
                        } catch (Throwable th) {
                            th = th;
                            str2 = str2;
                            Throwable th2 = th;
                            throw th2;
                        }
                    }
                    Unit unit = Unit.f139807a;
                } catch (Throwable th3) {
                    th = th3;
                }
            }
        }
        this.f94241z = jCurrentTimeMillis;
        this.A = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y0(LockAccessibilityService lockAccessibilityService) {
        lockAccessibilityService.E = null;
        lockAccessibilityService.I1(null, null, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z0(LockAccessibilityService lockAccessibilityService, SubApp visibleSubApp) {
        Intrinsics.checkNotNullParameter(visibleSubApp, "visibleSubApp");
        if (!Intrinsics.areEqual(visibleSubApp, lockAccessibilityService.E)) {
            List list = lockAccessibilityService.f94218d0;
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                if (((ProfileWithConfiguration) obj).B(visibleSubApp)) {
                    arrayList.add(obj);
                }
            }
            BuildersKt__Builders_commonKt.d(lockAccessibilityService.f94213b, null, null, new LockAccessibilityService$checkAndBlockSubApps$3$1(lockAccessibilityService, arrayList, visibleSubApp, null), 3, null);
            lockAccessibilityService.E = visibleSubApp;
        }
        return Unit.f139807a;
    }

    public final File a1(Context context, String fileName) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        File file = new File(context.getCacheDir(), fileName);
        if (file.exists()) {
            return file;
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            InputStream inputStreamOpen = context.getAssets().open(fileName);
            try {
                Intrinsics.checkNotNull(inputStreamOpen);
                ByteStreamsKt.b(inputStreamOpen, fileOutputStream, 0, 2, null);
                Unit unit = Unit.f139807a;
                CloseableKt.a(inputStreamOpen, null);
                CloseableKt.a(fileOutputStream, null);
                return file;
            } finally {
            }
        } finally {
        }
    }

    @Override // android.accessibilityservice.AccessibilityService
    public void onAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        Map map;
        Map map2;
        if (this.f94237v) {
            if ((accessibilityEvent != null ? accessibilityEvent.getPackageName() : null) == null) {
                return;
            }
            if (accessibilityEvent.getClassName() == null) {
                CrashHelper.j(new AccessibilityException("event.className for " + ((Object) accessibilityEvent.getPackageName()) + " is null"));
                return;
            }
            try {
                String string = accessibilityEvent.getPackageName().toString();
                if (accessibilityEvent.getEventType() == 1 && (((map = this.f94238w) != null && map.containsKey(string)) || ((map2 = this.f94239x) != null && map2.containsKey(string)))) {
                    if (System.currentTimeMillis() - this.Y > 1000) {
                        this.X = true;
                    }
                }
                AccessibilityNodeInfo source = accessibilityEvent.getSource();
                if (source != null) {
                    if (this.S == null) {
                        ScreenReceiver screenReceiver = new ScreenReceiver();
                        registerReceiver(screenReceiver, screenReceiver.a());
                        this.S = screenReceiver;
                        Unit unit = Unit.f139807a;
                    }
                    if (d1().g(accessibilityEvent)) {
                        return;
                    }
                    if ((!Intrinsics.areEqual(accessibilityEvent.getPackageName(), "com.android.systemui") || accessibilityEvent.getEventType() == 2048 || accessibilityEvent.getEventType() == 32 || accessibilityEvent.getEventType() == 1) && !this.R.contains(source)) {
                        this.R.add(source);
                    }
                    if (this.Q == null) {
                        this.Q = new AccessibilityRunnable();
                    }
                    if (this.P == null) {
                        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
                        this.P = executorServiceNewSingleThreadExecutor;
                        if (executorServiceNewSingleThreadExecutor != null) {
                            executorServiceNewSingleThreadExecutor.execute(this.Q);
                        }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
                CrashHelper.j(th);
            }
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        InitHelper.h(this);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        if (this.f94221f0) {
            try {
                unregisterReceiver(Y0());
            } catch (Exception e3) {
                CrashHelper.j(e3);
            }
            this.f94221f0 = false;
        }
    }

    @Override // cz.mobilesoft.coreblock.util.runnability.InitHelper.OnInitializedListener
    public void onInitialized() {
        try {
            CoroutinesHelperExtKt.d(new AnonymousClass1(null));
        } catch (NullPointerException e3) {
            CrashHelper.j(e3);
            CoroutinesHelperExtKt.d(new AnonymousClass2(null));
        }
        CoroutinesHelperExtKt.d(new AnonymousClass3(null));
        BuildersKt__Builders_commonKt.d(this.f94213b, null, null, new AnonymousClass4(null), 3, null);
        BuildersKt__Builders_commonKt.d(this.f94213b, null, null, new AnonymousClass5(null), 3, null);
        FlowExtKt.i(W0().d0(), this.f94213b, new FlowCollector() { // from class: cz.mobilesoft.appblock.service.LockAccessibilityService.onInitialized.6
            public final Object a(int i3, Continuation continuation) {
                LockAccessibilityService.this.J = i3;
                return Unit.f139807a;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return a(((Number) obj).intValue(), continuation);
            }
        });
        FlowExtKt.i(W0().l0(), this.f94213b, new FlowCollector() { // from class: cz.mobilesoft.appblock.service.LockAccessibilityService.onInitialized.7
            @Override // kotlinx.coroutines.flow.FlowCollector
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object emit(Set set, Continuation continuation) {
                LockAccessibilityService.this.T = set;
                return Unit.f139807a;
            }
        });
        FlowExtKt.i(j1().L(), this.f94213b, new FlowCollector() { // from class: cz.mobilesoft.appblock.service.LockAccessibilityService.onInitialized.8
            public final Object a(long j3, Continuation continuation) {
                LockAccessibilityService.this.U = j3 > 0;
                return Unit.f139807a;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return a(((Number) obj).longValue(), continuation);
            }
        });
        FlowExtKt.i(h1().m0(), this.f94213b, new FlowCollector() { // from class: cz.mobilesoft.appblock.service.LockAccessibilityService.onInitialized.9
            @Override // kotlinx.coroutines.flow.FlowCollector
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object emit(List list, Continuation continuation) {
                LockAccessibilityService.this.N = list.contains(StrictModeOption.BlockRecentApps);
                LockAccessibilityService lockAccessibilityService = LockAccessibilityService.this;
                lockAccessibilityService.w1("recent apps disabled: " + lockAccessibilityService.N);
                return Unit.f139807a;
            }
        });
        FlowExtKt.i(h1().m0(), this.f94213b, new FlowCollector() { // from class: cz.mobilesoft.appblock.service.LockAccessibilityService.onInitialized.10
            @Override // kotlinx.coroutines.flow.FlowCollector
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object emit(List list, Continuation continuation) {
                LockAccessibilityService.this.O = list.contains(StrictModeOption.BlockSplitScreen);
                LockAccessibilityService lockAccessibilityService = LockAccessibilityService.this;
                lockAccessibilityService.w1("split screen blocking enabled: " + lockAccessibilityService.O);
                return Unit.f139807a;
            }
        });
        FlowExtKt.i(g1().Y(), this.f94213b, new FlowCollector() { // from class: cz.mobilesoft.appblock.service.LockAccessibilityService.onInitialized.11
            public final Object a(boolean z2, Continuation continuation) {
                LockAccessibilityService.this.K = !z2;
                LockAccessibilityService lockAccessibilityService = LockAccessibilityService.this;
                lockAccessibilityService.w1("statistics enabled: " + (!lockAccessibilityService.K));
                return Unit.f139807a;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return a(((Boolean) obj).booleanValue(), continuation);
            }
        });
        FlowExtKt.i(g1().Z(), this.f94213b, new FlowCollector() { // from class: cz.mobilesoft.appblock.service.LockAccessibilityService.onInitialized.12
            public final Object a(boolean z2, Continuation continuation) {
                LockAccessibilityService.this.L = !z2;
                LockAccessibilityService lockAccessibilityService = LockAccessibilityService.this;
                lockAccessibilityService.w1("web statistics enabled: " + (!lockAccessibilityService.L));
                return Unit.f139807a;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return a(((Boolean) obj).booleanValue(), continuation);
            }
        });
        FlowExtKt.i(g1().X(), this.f94213b, new FlowCollector() { // from class: cz.mobilesoft.appblock.service.LockAccessibilityService.onInitialized.13
            public final Object a(boolean z2, Continuation continuation) {
                LockAccessibilityService.this.M = !z2;
                LockAccessibilityService lockAccessibilityService = LockAccessibilityService.this;
                lockAccessibilityService.w1("incognito statistics enabled: " + (!lockAccessibilityService.M));
                return Unit.f139807a;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return a(((Boolean) obj).booleanValue(), continuation);
            }
        });
        FlowExtKt.l(Z0().e1(), this.f94213b, new FlowCollector() { // from class: cz.mobilesoft.appblock.service.LockAccessibilityService.onInitialized.14
            @Override // kotlinx.coroutines.flow.FlowCollector
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object emit(String str, Continuation continuation) {
                LockAccessibilityService lockAccessibilityService = LockAccessibilityService.this;
                if (StringsKt.p0(str)) {
                    str = null;
                }
                lockAccessibilityService.H = str;
                return Unit.f139807a;
            }
        });
        FlowExtKt.l(Z0().Z0(), this.f94213b, new FlowCollector() { // from class: cz.mobilesoft.appblock.service.LockAccessibilityService.onInitialized.15
            /* JADX WARN: Removed duplicated region for block: B:13:0x0037  */
            @Override // kotlinx.coroutines.flow.FlowCollector
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object emit(cz.mobilesoft.coreblock.dto.events.PackageAdditionalBlockingDTO r9, kotlin.coroutines.Continuation r10) {
                /*
                    r8 = this;
                    cz.mobilesoft.coreblock.dto.UrlDto r10 = r9.getUrlDto()
                    r0 = 0
                    if (r10 == 0) goto Lc
                    java.lang.String r10 = r10.getUrl()
                    goto Ld
                Lc:
                    r10 = r0
                Ld:
                    cz.mobilesoft.appblock.service.LockAccessibilityService r1 = cz.mobilesoft.appblock.service.LockAccessibilityService.this
                    cz.mobilesoft.appblock.service.LockAccessibilityService$UrlCheck r1 = cz.mobilesoft.appblock.service.LockAccessibilityService.D(r1)
                    java.lang.String r1 = r1.d()
                    boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual(r10, r1)
                    if (r10 != 0) goto L37
                    cz.mobilesoft.coreblock.dto.UrlDto r9 = r9.getUrlDto()
                    if (r9 == 0) goto L27
                    java.lang.String r0 = r9.getUrl()
                L27:
                    cz.mobilesoft.appblock.service.LockAccessibilityService r9 = cz.mobilesoft.appblock.service.LockAccessibilityService.this
                    cz.mobilesoft.appblock.service.LockAccessibilityService$UrlCheck r9 = cz.mobilesoft.appblock.service.LockAccessibilityService.D(r9)
                    java.lang.String r9 = r9.e()
                    boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r9)
                    if (r9 == 0) goto L49
                L37:
                    cz.mobilesoft.appblock.service.LockAccessibilityService r9 = cz.mobilesoft.appblock.service.LockAccessibilityService.this
                    cz.mobilesoft.appblock.service.LockAccessibilityService$UrlCheck r0 = new cz.mobilesoft.appblock.service.LockAccessibilityService$UrlCheck
                    r6 = 15
                    r7 = 0
                    r1 = 0
                    r2 = 0
                    r3 = 0
                    r5 = 0
                    r0.<init>(r1, r2, r3, r5, r6, r7)
                    cz.mobilesoft.appblock.service.LockAccessibilityService.Z(r9, r0)
                L49:
                    cz.mobilesoft.appblock.service.LockAccessibilityService r9 = cz.mobilesoft.appblock.service.LockAccessibilityService.this
                    cz.mobilesoft.appblock.service.LockAccessibilityService.m(r9)
                    kotlin.Unit r9 = kotlin.Unit.f139807a
                    return r9
                */
                throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.appblock.service.LockAccessibilityService.AnonymousClass15.emit(cz.mobilesoft.coreblock.dto.events.PackageAdditionalBlockingDTO, kotlin.coroutines.Continuation):java.lang.Object");
            }
        });
        FlowExtKt.i(Z0().q1(), this.f94213b, new FlowCollector() { // from class: cz.mobilesoft.appblock.service.LockAccessibilityService.onInitialized.16
            public final Object a(boolean z2, Continuation continuation) {
                LockAccessibilityService.this.f94219e0 = z2;
                return Unit.f139807a;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return a(((Boolean) obj).booleanValue(), continuation);
            }
        });
        FlowExtKt.l(Z0().U0(), this.f94211a, new FlowCollector() { // from class: cz.mobilesoft.appblock.service.LockAccessibilityService.onInitialized.17

            /* JADX INFO: renamed from: cz.mobilesoft.appblock.service.LockAccessibilityService$onInitialized$17$1, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            @DebugMetadata(c = "cz.mobilesoft.appblock.service.LockAccessibilityService$onInitialized$17$1", f = "LockAccessibilityService.kt", l = {583}, m = "invokeSuspend", v = 1)
            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                int f94306a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                final /* synthetic */ LockAccessibilityService f94307b;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(LockAccessibilityService lockAccessibilityService, Continuation continuation) {
                    super(2, continuation);
                    this.f94307b = lockAccessibilityService;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation create(Object obj, Continuation continuation) {
                    return new AnonymousClass1(this.f94307b, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) throws Throwable {
                    Object objF = IntrinsicsKt.f();
                    int i3 = this.f94306a;
                    if (i3 == 0) {
                        ResultKt.b(obj);
                        this.f94307b.J0();
                        LockAccessibilityService lockAccessibilityService = this.f94307b;
                        SubApp subApp = lockAccessibilityService.E;
                        String parentApp = subApp != null ? subApp.getParentApp() : null;
                        this.f94306a = 1;
                        if (lockAccessibilityService.K0(parentApp, this) == objF) {
                            return objF;
                        }
                    } else {
                        if (i3 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.b(obj);
                    }
                    ServiceHelper serviceHelper = ServiceHelper.f95139a;
                    Context applicationContext = this.f94307b.getApplicationContext();
                    Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
                    serviceHelper.b(applicationContext);
                    return Unit.f139807a;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
                }
            }

            public final Object a(long j3, Continuation continuation) {
                Object objG = BuildersKt.g(Dispatchers.c(), new AnonymousClass1(LockAccessibilityService.this, null), continuation);
                return objG == IntrinsicsKt.f() ? objG : Unit.f139807a;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return a(((Number) obj).longValue(), continuation);
            }
        });
        FlowExtKt.l(Z0().T0(), this.f94211a, new FlowCollector() { // from class: cz.mobilesoft.appblock.service.LockAccessibilityService.onInitialized.18

            /* JADX INFO: renamed from: cz.mobilesoft.appblock.service.LockAccessibilityService$onInitialized$18$1, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            @DebugMetadata(c = "cz.mobilesoft.appblock.service.LockAccessibilityService$onInitialized$18$1", f = "LockAccessibilityService.kt", l = {}, m = "invokeSuspend", v = 1)
            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                int f94309a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                private /* synthetic */ Object f94310b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                final /* synthetic */ LockAccessibilityService f94311c;

                /* JADX INFO: renamed from: cz.mobilesoft.appblock.service.LockAccessibilityService$onInitialized$18$1$1, reason: invalid class name and collision with other inner class name */
                /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                @Metadata
                @DebugMetadata(c = "cz.mobilesoft.appblock.service.LockAccessibilityService$onInitialized$18$1$1", f = "LockAccessibilityService.kt", l = {647, 649}, m = "invokeSuspend", v = 1)
                static final class C02581 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    int f94312a;

                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                    final /* synthetic */ LockAccessibilityService f94313b;

                    /* JADX INFO: renamed from: cz.mobilesoft.appblock.service.LockAccessibilityService$onInitialized$18$1$1$1, reason: invalid class name and collision with other inner class name */
                    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                    @Metadata
                    @DebugMetadata(c = "cz.mobilesoft.appblock.service.LockAccessibilityService$onInitialized$18$1$1$1", f = "LockAccessibilityService.kt", l = {}, m = "invokeSuspend", v = 1)
                    static final class C02591 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

                        /* JADX INFO: renamed from: a, reason: collision with root package name */
                        int f94314a;

                        /* JADX INFO: renamed from: b, reason: collision with root package name */
                        final /* synthetic */ LockAccessibilityService f94315b;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        C02591(LockAccessibilityService lockAccessibilityService, Continuation continuation) {
                            super(2, continuation);
                            this.f94315b = lockAccessibilityService;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation create(Object obj, Continuation continuation) {
                            return new C02591(this.f94315b, continuation);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) throws Throwable {
                            IntrinsicsKt.f();
                            if (this.f94314a != 0) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.b(obj);
                            this.f94315b.performGlobalAction(2);
                            return Unit.f139807a;
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                            return ((C02591) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
                        }
                    }

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C02581(LockAccessibilityService lockAccessibilityService, Continuation continuation) {
                        super(2, continuation);
                        this.f94313b = lockAccessibilityService;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation create(Object obj, Continuation continuation) {
                        return new C02581(this.f94313b, continuation);
                    }

                    /* JADX WARN: Code restructure failed: missing block: B:14:0x003e, code lost:
                    
                        if (kotlinx.coroutines.BuildersKt.g(r6, r1, r5) == r0) goto L15;
                     */
                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public final java.lang.Object invokeSuspend(java.lang.Object r6) throws java.lang.Throwable {
                        /*
                            r5 = this;
                            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                            int r1 = r5.f94312a
                            r2 = 2
                            r3 = 1
                            if (r1 == 0) goto L1e
                            if (r1 == r3) goto L1a
                            if (r1 != r2) goto L12
                            kotlin.ResultKt.b(r6)
                            goto L41
                        L12:
                            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                            r6.<init>(r0)
                            throw r6
                        L1a:
                            kotlin.ResultKt.b(r6)
                            goto L2c
                        L1e:
                            kotlin.ResultKt.b(r6)
                            r5.f94312a = r3
                            r3 = 100
                            java.lang.Object r6 = kotlinx.coroutines.DelayKt.b(r3, r5)
                            if (r6 != r0) goto L2c
                            goto L40
                        L2c:
                            kotlinx.coroutines.MainCoroutineDispatcher r6 = kotlinx.coroutines.Dispatchers.c()
                            cz.mobilesoft.appblock.service.LockAccessibilityService$onInitialized$18$1$1$1 r1 = new cz.mobilesoft.appblock.service.LockAccessibilityService$onInitialized$18$1$1$1
                            cz.mobilesoft.appblock.service.LockAccessibilityService r3 = r5.f94313b
                            r4 = 0
                            r1.<init>(r3, r4)
                            r5.f94312a = r2
                            java.lang.Object r6 = kotlinx.coroutines.BuildersKt.g(r6, r1, r5)
                            if (r6 != r0) goto L41
                        L40:
                            return r0
                        L41:
                            kotlin.Unit r6 = kotlin.Unit.f139807a
                            return r6
                        */
                        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.appblock.service.LockAccessibilityService.AnonymousClass18.AnonymousClass1.C02581.invokeSuspend(java.lang.Object):java.lang.Object");
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                        return ((C02581) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(LockAccessibilityService lockAccessibilityService, Continuation continuation) {
                    super(2, continuation);
                    this.f94311c = lockAccessibilityService;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation create(Object obj, Continuation continuation) {
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f94311c, continuation);
                    anonymousClass1.f94310b = obj;
                    return anonymousClass1;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) throws Throwable {
                    IntrinsicsKt.f();
                    if (this.f94309a != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                    this.f94311c.w1("PIP exit request received");
                    if (this.f94311c.f94219e0) {
                        this.f94311c.L0();
                        return Unit.f139807a;
                    }
                    List<AccessibilityWindowInfo> windows = this.f94311c.getWindows();
                    this.f94311c.w1(windows.size() + " windows");
                    for (AccessibilityWindowInfo accessibilityWindowInfo : windows) {
                        int type = accessibilityWindowInfo.getType();
                        AccessibilityNodeInfo root = null;
                        if (type == 1) {
                            this.f94311c.w1("Application window detected");
                            try {
                                root = accessibilityWindowInfo.getRoot();
                            } catch (Exception e3) {
                                String string = e3.toString();
                                String simpleName = CoroutineScope.class.getSimpleName();
                                Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
                                Log.e(simpleName, string);
                            }
                            if (root != null) {
                                CharSequence packageName = root.getPackageName();
                                this.f94311c.w1("packageName is " + ((Object) root.getPackageName()));
                                if (packageName != null && accessibilityWindowInfo.isInPictureInPictureMode()) {
                                    this.f94311c.w1("Dismissing PIP for " + ((Object) packageName));
                                    boolean zPerformAction = root.performAction(1048576);
                                    this.f94311c.w1("Successful: " + zPerformAction);
                                    if (!zPerformAction) {
                                        this.f94311c.w1("Expanding PIP for " + ((Object) packageName));
                                        zPerformAction = root.performAction(262144);
                                    }
                                    this.f94311c.w1("Successful: " + zPerformAction);
                                    if (!zPerformAction) {
                                        this.f94311c.k1();
                                    }
                                    return Unit.f139807a;
                                }
                            } else {
                                this.f94311c.w1("windowInfo.root is null");
                            }
                        } else if (type == 5) {
                            this.f94311c.w1("Split screen divider detected, toggling");
                            this.f94311c.performGlobalAction(7);
                            BuildersKt__Builders_commonKt.d(this.f94311c.f94211a, null, null, new C02581(this.f94311c, null), 3, null);
                            return Unit.f139807a;
                        }
                    }
                    this.f94311c.k1();
                    return Unit.f139807a;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
                }
            }

            public final Object a(long j3, Continuation continuation) {
                Object objG = BuildersKt.g(Dispatchers.c(), new AnonymousClass1(LockAccessibilityService.this, null), continuation);
                return objG == IntrinsicsKt.f() ? objG : Unit.f139807a;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return a(((Number) obj).longValue(), continuation);
            }
        });
        FlowExtKt.l(Z0().P0(), this.f94211a, new FlowCollector() { // from class: cz.mobilesoft.appblock.service.LockAccessibilityService.onInitialized.19

            /* JADX INFO: renamed from: cz.mobilesoft.appblock.service.LockAccessibilityService$onInitialized$19$1, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            @DebugMetadata(c = "cz.mobilesoft.appblock.service.LockAccessibilityService$onInitialized$19$1", f = "LockAccessibilityService.kt", l = {}, m = "invokeSuspend", v = 1)
            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                int f94317a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                final /* synthetic */ LockAccessibilityService f94318b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                final /* synthetic */ String f94319c;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(LockAccessibilityService lockAccessibilityService, String str, Continuation continuation) {
                    super(2, continuation);
                    this.f94318b = lockAccessibilityService;
                    this.f94319c = str;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation create(Object obj, Continuation continuation) {
                    return new AnonymousClass1(this.f94318b, this.f94319c, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) throws Throwable {
                    IntrinsicsKt.f();
                    if (this.f94317a != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                    if (this.f94318b.u1(this.f94319c)) {
                        this.f94318b.w1("Collapsing floating window of " + this.f94319c);
                        this.f94318b.k1();
                    } else {
                        this.f94318b.w1("No floating window of " + this.f94319c + " found");
                    }
                    return Unit.f139807a;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
                }
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object emit(EventWithPackageDTO eventWithPackageDTO, Continuation continuation) {
                String packageName = eventWithPackageDTO.getPackageName();
                if (packageName == null) {
                    return Unit.f139807a;
                }
                Object objG = BuildersKt.g(Dispatchers.c(), new AnonymousClass1(LockAccessibilityService.this, packageName, null), continuation);
                return objG == IntrinsicsKt.f() ? objG : Unit.f139807a;
            }
        });
        FlowExtKt.l(Z0().S0(), this.f94211a, new FlowCollector() { // from class: cz.mobilesoft.appblock.service.LockAccessibilityService.onInitialized.20
            @Override // kotlinx.coroutines.flow.FlowCollector
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object emit(EventWithPackageDTO eventWithPackageDTO, Continuation continuation) {
                String packageName = eventWithPackageDTO.getPackageName();
                if (packageName == null) {
                    return Unit.f139807a;
                }
                LockAccessibilityService.this.M0(packageName);
                return Unit.f139807a;
            }
        });
        FlowExtKt.l(Z0().N0(), this.f94213b, new FlowCollector() { // from class: cz.mobilesoft.appblock.service.LockAccessibilityService.onInitialized.21
            public final Object a(long j3, Continuation continuation) {
                LockAccessibilityService.this.f94240y = null;
                return Unit.f139807a;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return a(((Number) obj).longValue(), continuation);
            }
        });
        FlowExtKt.l(Z0().J0(), this.f94213b, new FlowCollector() { // from class: cz.mobilesoft.appblock.service.LockAccessibilityService.onInitialized.22
            public final Object a(long j3, Continuation continuation) {
                if (LockAccessibilityService.this.Q0() != null) {
                    LockAccessibilityService lockAccessibilityService = LockAccessibilityService.this;
                    List<AccessibilityWindowInfo> windows = lockAccessibilityService.getWindows();
                    lockAccessibilityService.w1(windows.size() + " windows");
                    for (AccessibilityWindowInfo accessibilityWindowInfo : windows) {
                        Intrinsics.checkNotNull(accessibilityWindowInfo);
                        if (lockAccessibilityService.r1(accessibilityWindowInfo)) {
                            lockAccessibilityService.q0("com.google.android.packageinstaller", lockAccessibilityService.getApplicationContext().getString(R.string.appblock_uninstalling), StrictModeOption.BlockUninstalling);
                            return Unit.f139807a;
                        }
                    }
                }
                return Unit.f139807a;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return a(((Number) obj).longValue(), continuation);
            }
        });
        FlowExtKt.l(Z0().R0(), this.f94213b, new AnonymousClass23());
        FlowExtKt.l(Z0().O0(), this.f94213b, new FlowCollector() { // from class: cz.mobilesoft.appblock.service.LockAccessibilityService.onInitialized.24
            public final Object a(long j3, Continuation continuation) {
                if (LockAccessibilityService.this.Q0() != null) {
                    LockAccessibilityService.this.v0();
                }
                return Unit.f139807a;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return a(((Number) obj).longValue(), continuation);
            }
        });
        FlowExtKt.l(Z0().F0(), this.f94213b, new FlowCollector() { // from class: cz.mobilesoft.appblock.service.LockAccessibilityService.onInitialized.25
            public final Object a(long j3, Continuation continuation) {
                Object objK1 = LockAccessibilityService.this.Z0().K1(TimeHelperExt.f128663a.f(), continuation);
                return objK1 == IntrinsicsKt.f() ? objK1 : Unit.f139807a;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return a(((Number) obj).longValue(), continuation);
            }
        });
        FlowExtKt.l(Z0().m1(), this.f94213b, new FlowCollector() { // from class: cz.mobilesoft.appblock.service.LockAccessibilityService.onInitialized.26
            public final Object a(long j3, Continuation continuation) {
                LockAccessibilityService.this.D = new UrlCheck(null, null, 0L, false, 15, null);
                LockAccessibilityService.this.J0();
                LockAccessibilityService.this.E1("");
                return Unit.f139807a;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return a(((Number) obj).longValue(), continuation);
            }
        });
        FlowExtKt.l(Z0().M0(), this.f94213b, new FlowCollector() { // from class: cz.mobilesoft.appblock.service.LockAccessibilityService.onInitialized.27
            public final Object a(long j3, Continuation continuation) throws Throwable {
                LockAccessibilityService.this.y1();
                return Unit.f139807a;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return a(((Number) obj).longValue(), continuation);
            }
        });
        FlowExtKt.l(Z0().k1(), this.f94213b, new FlowCollector() { // from class: cz.mobilesoft.appblock.service.LockAccessibilityService.onInitialized.28
            public final Object a(long j3, Continuation continuation) {
                LockAccessibilityService.this.z1();
                return Unit.f139807a;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return a(((Number) obj).longValue(), continuation);
            }
        });
        if (RunnabilityHelper.f129617a.K()) {
            D1();
        }
    }

    @Override // android.accessibilityservice.AccessibilityService
    public void onInterrupt() {
    }

    public final void y1() throws Throwable {
        w1("BrowserClosedEvent received");
        this.D = new UrlCheck(null, null, 0L, false, 15, null);
        J0();
        x1(null);
        E1("");
    }

    public final void z1() {
        this.E = null;
    }

    private final boolean q1(AccessibilityNodeInfo accessibilityNodeInfo) {
        List<AccessibilityNodeInfo> listFindAccessibilityNodeInfosByViewId;
        if (RunnabilityHelper.f129617a.G()) {
            List<AccessibilityNodeInfo> listFindAccessibilityNodeInfosByViewId2 = accessibilityNodeInfo.findAccessibilityNodeInfosByViewId("com.android.systemui:id/qs_detail_item_layout");
            if (listFindAccessibilityNodeInfosByViewId2 != null) {
                listFindAccessibilityNodeInfosByViewId = new ArrayList<>();
                for (AccessibilityNodeInfo accessibilityNodeInfo2 : listFindAccessibilityNodeInfosByViewId2) {
                    w1("Row found");
                    List<AccessibilityNodeInfo> listFindAccessibilityNodeInfosByViewId3 = accessibilityNodeInfo2.findAccessibilityNodeInfosByViewId("android:id/title");
                    Intrinsics.checkNotNullExpressionValue(listFindAccessibilityNodeInfosByViewId3, "findAccessibilityNodeInfosByViewId(...)");
                    CollectionsKt.addAll(listFindAccessibilityNodeInfosByViewId, listFindAccessibilityNodeInfosByViewId3);
                }
            } else {
                listFindAccessibilityNodeInfosByViewId = null;
            }
        } else {
            listFindAccessibilityNodeInfosByViewId = accessibilityNodeInfo.findAccessibilityNodeInfosByViewId(YvFRmou.BmPVn);
        }
        if (listFindAccessibilityNodeInfosByViewId == null) {
            return false;
        }
        List<AccessibilityNodeInfo> list = listFindAccessibilityNodeInfosByViewId;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (Intrinsics.areEqual(((AccessibilityNodeInfo) it.next()).getText(), S0())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class FullScreenBrowserBlockingCache {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f94243a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final UrlDto f94244b;

        public FullScreenBrowserBlockingCache(String str, UrlDto urlDto) {
            this.f94243a = str;
            this.f94244b = urlDto;
        }

        public final String a() {
            return this.f94243a;
        }

        public final UrlDto b() {
            return this.f94244b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof FullScreenBrowserBlockingCache)) {
                return false;
            }
            FullScreenBrowserBlockingCache fullScreenBrowserBlockingCache = (FullScreenBrowserBlockingCache) obj;
            return Intrinsics.areEqual(this.f94243a, fullScreenBrowserBlockingCache.f94243a) && Intrinsics.areEqual(this.f94244b, fullScreenBrowserBlockingCache.f94244b);
        }

        public int hashCode() {
            String str = this.f94243a;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            UrlDto urlDto = this.f94244b;
            return iHashCode + (urlDto != null ? urlDto.hashCode() : 0);
        }

        public String toString() {
            return "FullScreenBrowserBlockingCache(browserPackageName=" + this.f94243a + ", url=" + this.f94244b + ")";
        }

        public /* synthetic */ FullScreenBrowserBlockingCache(String str, UrlDto urlDto, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? null : str, (i3 & 2) != 0 ? null : urlDto);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class UrlCheck {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f94249a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f94250b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f94251c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f94252d;

        public UrlCheck(String mainUrl, String secondaryCheckUrl, long j3, boolean z2) {
            Intrinsics.checkNotNullParameter(mainUrl, "mainUrl");
            Intrinsics.checkNotNullParameter(secondaryCheckUrl, "secondaryCheckUrl");
            this.f94249a = mainUrl;
            this.f94250b = secondaryCheckUrl;
            this.f94251c = j3;
            this.f94252d = z2;
        }

        public static /* synthetic */ UrlCheck b(UrlCheck urlCheck, String str, String str2, long j3, boolean z2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = urlCheck.f94249a;
            }
            if ((i3 & 2) != 0) {
                str2 = urlCheck.f94250b;
            }
            if ((i3 & 4) != 0) {
                j3 = urlCheck.f94251c;
            }
            if ((i3 & 8) != 0) {
                z2 = urlCheck.f94252d;
            }
            boolean z3 = z2;
            return urlCheck.a(str, str2, j3, z3);
        }

        public final UrlCheck a(String mainUrl, String secondaryCheckUrl, long j3, boolean z2) {
            Intrinsics.checkNotNullParameter(mainUrl, "mainUrl");
            Intrinsics.checkNotNullParameter(secondaryCheckUrl, "secondaryCheckUrl");
            return new UrlCheck(mainUrl, secondaryCheckUrl, j3, z2);
        }

        public final long c() {
            return this.f94251c;
        }

        public final String d() {
            return this.f94249a;
        }

        public final String e() {
            return this.f94250b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof UrlCheck)) {
                return false;
            }
            UrlCheck urlCheck = (UrlCheck) obj;
            return Intrinsics.areEqual(this.f94249a, urlCheck.f94249a) && Intrinsics.areEqual(this.f94250b, urlCheck.f94250b) && this.f94251c == urlCheck.f94251c && this.f94252d == urlCheck.f94252d;
        }

        public final boolean f() {
            return this.f94252d;
        }

        public int hashCode() {
            return (((((this.f94249a.hashCode() * 31) + this.f94250b.hashCode()) * 31) + Long.hashCode(this.f94251c)) * 31) + Boolean.hashCode(this.f94252d);
        }

        public String toString() {
            return "UrlCheck(mainUrl='" + this.f94249a + "', secondaryCheckUrl='" + this.f94250b + "', checkedAt=" + this.f94251c + ", wasBlocked=" + this.f94252d + ")";
        }

        public /* synthetic */ UrlCheck(String str, String str2, long j3, boolean z2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) != 0 ? 0L : j3, (i3 & 8) != 0 ? false : z2);
        }
    }
}
