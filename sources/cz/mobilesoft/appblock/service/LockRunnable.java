package cz.mobilesoft.appblock.service;

import android.content.Context;
import android.os.PowerManager;
import android.util.Log;
import cz.mobilesoft.appblock.service.lock.BackgroundPlaybackBlocker;
import cz.mobilesoft.appblock.service.lock.BlockingDecisionMaker;
import cz.mobilesoft.appblock.service.lock.ForegroundAppResolver;
import cz.mobilesoft.appblock.service.lock.LockScreenExecutor;
import cz.mobilesoft.appblock.service.lock.MediaSessionWatcher;
import cz.mobilesoft.appblock.service.lock.PopupDetectionTracker;
import cz.mobilesoft.appblock.service.lock.ProfileProvider;
import cz.mobilesoft.appblock.service.lock.UsageLimitCountdown;
import cz.mobilesoft.appblock.service.lock.UsageLimitHostTracker;
import cz.mobilesoft.appblock.usecase.BlockingProfilesBesidesLimitsChecker;
import cz.mobilesoft.coreblock.dto.UrlDto;
import cz.mobilesoft.coreblock.dto.events.EventWithPackageDTO;
import cz.mobilesoft.coreblock.dto.events.PackageAdditionalBlockingDTO;
import cz.mobilesoft.coreblock.enums.ProfileType;
import cz.mobilesoft.coreblock.repository.ApplicationRepository;
import cz.mobilesoft.coreblock.repository.SubApp;
import cz.mobilesoft.coreblock.scene.lockscreen.ossettings.DefaultAllowedSettings;
import cz.mobilesoft.coreblock.storage.datastore.CoreDataStore;
import cz.mobilesoft.coreblock.storage.datastore.CoreMultiProcessDataStore;
import cz.mobilesoft.coreblock.storage.datastore.EventDataStore;
import cz.mobilesoft.coreblock.storage.datastore.StrictModeDataStore;
import cz.mobilesoft.coreblock.storage.datastore.dev.DevDataStore;
import cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao;
import cz.mobilesoft.coreblock.storage.room.dao.core.LaunchTimeDao;
import cz.mobilesoft.coreblock.storage.room.dto.blocking.ProfileWithConfiguration;
import cz.mobilesoft.coreblock.storage.room.dto.blocking.ProfileWithConfigurationKt;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.UsageLimit;
import cz.mobilesoft.coreblock.storage.room.entity.core.IgnoredStatisticsItem;
import cz.mobilesoft.coreblock.storage.sharedprefs.flowproperty.BlockingFlowProperty;
import cz.mobilesoft.coreblock.usecase.GetForegroundAppsUseCase;
import cz.mobilesoft.coreblock.usecase.GetUsageLimitsForCurrentPeriodUseCase;
import cz.mobilesoft.coreblock.util.compose.FlowExtKt;
import cz.mobilesoft.coreblock.util.helperextension.ComparableExtKt;
import cz.mobilesoft.coreblock.util.helperextension.CoroutinesHelperExtKt;
import cz.mobilesoft.coreblock.util.helperextension.LoggingExtKt;
import cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt;
import cz.mobilesoft.coreblock.util.runnability.JobHelper;
import cz.mobilesoft.coreblock.util.runnability.RunnabilityHelper;
import cz.mobilesoft.coreblock.util.runnability.ServiceHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
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
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import org.koin.core.Koin;
import org.koin.core.component.KoinComponent;
import org.koin.core.component.KoinScopeComponent;
import org.koin.core.qualifier.Qualifier;
import org.koin.mp.KoinPlatformTools;

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
public final class LockRunnable implements Runnable, KoinComponent {
    public static final Companion T = new Companion(null);
    public static final int U = 8;
    private static final Lazy V = LazyKt.b(new Function0() { // from class: cz.mobilesoft.appblock.service.e0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return Long.valueOf(LockRunnable.w0());
        }
    });
    private String A;
    private int B;
    private boolean C;
    private boolean D;
    private volatile boolean E;
    private volatile boolean F;
    private final PopupDetectionTracker G;
    private int H;
    private final UsageLimitHostTracker I;
    private final ForegroundAppResolver J;
    private final BlockingDecisionMaker K;
    private final MediaSessionWatcher L;
    private final BackgroundPlaybackBlocker M;
    private final Flow N;
    private volatile List O;
    private volatile Set P;
    private volatile Set Q;
    private StateFlow R;
    private final CountDownLatch S;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f94406a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final PackageAdditionalBlockingDTO f94407b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Callback f94408c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final CoroutineScope f94409d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Lazy f94410f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Lazy f94411g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Lazy f94412h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Lazy f94413i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Lazy f94414j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Lazy f94415k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Lazy f94416l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final Lazy f94417m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Lazy f94418n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Lazy f94419o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private volatile boolean f94420p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private GetForegroundAppsUseCase.AppsDTO f94421q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private String f94422r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final ProfileProvider f94423s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private volatile boolean f94424t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final UsageLimitCountdown f94425u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final LockScreenExecutor f94426v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private volatile long f94427w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private volatile boolean f94428x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private volatile long f94429y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private volatile GetForegroundAppsUseCase.AppsDTO f94430z;

    /* JADX INFO: renamed from: cz.mobilesoft.appblock.service.LockRunnable$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.appblock.service.LockRunnable$2", f = "LockRunnable.kt", l = {373}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f94432a;

        AnonymousClass2(Continuation continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return LockRunnable.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f94432a;
            if (i3 == 0) {
                ResultKt.b(obj);
                LaunchTimeDao launchTimeDaoS = LockRunnable.this.S();
                this.f94432a = 1;
                if (launchTimeDaoS.M(this) == objF) {
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
            return ((AnonymousClass2) create(continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.appblock.service.LockRunnable$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.appblock.service.LockRunnable$3", f = "LockRunnable.kt", l = {378}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f94434a;

        AnonymousClass3(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return LockRunnable.this.new AnonymousClass3(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f94434a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowH0 = LockRunnable.this.N().H0();
                final LockRunnable lockRunnable = LockRunnable.this;
                FlowCollector flowCollector = new FlowCollector() { // from class: cz.mobilesoft.appblock.service.LockRunnable.3.1
                    public final Object a(boolean z2, Continuation continuation) {
                        lockRunnable.f94420p = z2;
                        return Unit.f139807a;
                    }

                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return a(((Boolean) obj2).booleanValue(), continuation);
                    }
                };
                this.f94434a = 1;
                if (flowH0.collect(flowCollector, this) == objF) {
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
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.appblock.service.LockRunnable$4, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.appblock.service.LockRunnable$4", f = "LockRunnable.kt", l = {384}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f94437a;

        AnonymousClass4(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return LockRunnable.this.new AnonymousClass4(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f94437a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowE0 = LockRunnable.this.M().e0();
                final LockRunnable lockRunnable = LockRunnable.this;
                FlowCollector flowCollector = new FlowCollector() { // from class: cz.mobilesoft.appblock.service.LockRunnable.4.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public final Object emit(Set set, Continuation continuation) {
                        lockRunnable.Q = set;
                        return Unit.f139807a;
                    }
                };
                this.f94437a = 1;
                if (flowE0.collect(flowCollector, this) == objF) {
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

    /* JADX INFO: renamed from: cz.mobilesoft.appblock.service.LockRunnable$5, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.appblock.service.LockRunnable$5", f = "LockRunnable.kt", l = {390}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f94440a;

        AnonymousClass5(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return LockRunnable.this.new AnonymousClass5(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f94440a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowI2 = LockRunnable.this.L().i2();
                final LockRunnable lockRunnable = LockRunnable.this;
                FlowCollector flowCollector = new FlowCollector() { // from class: cz.mobilesoft.appblock.service.LockRunnable.5.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public final Object emit(Set set, Continuation continuation) {
                        LockRunnable lockRunnable2 = lockRunnable;
                        Set setA = set;
                        if (setA.isEmpty()) {
                            setA = DefaultAllowedSettings.f105719a.a();
                        }
                        lockRunnable2.P = setA;
                        return Unit.f139807a;
                    }
                };
                this.f94440a = 1;
                if (flowI2.collect(flowCollector, this) == objF) {
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

    /* JADX INFO: renamed from: cz.mobilesoft.appblock.service.LockRunnable$6, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.appblock.service.LockRunnable$6", f = "LockRunnable.kt", l = {398}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass6 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f94443a;

        AnonymousClass6(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return LockRunnable.this.new AnonymousClass6(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f94443a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowJ2 = LockRunnable.this.L().j2();
                final LockRunnable lockRunnable = LockRunnable.this;
                FlowCollector flowCollector = new FlowCollector() { // from class: cz.mobilesoft.appblock.service.LockRunnable.6.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public final Object emit(Boolean bool, Continuation continuation) {
                        boolean zBooleanValue = !ServiceHelper.g(lockRunnable.f94406a);
                        LockRunnable lockRunnable2 = lockRunnable;
                        if (!RunnabilityHelper.f129617a.K()) {
                            zBooleanValue = false;
                        } else if (bool != null) {
                            zBooleanValue = bool.booleanValue();
                        }
                        lockRunnable2.E = zBooleanValue;
                        lockRunnable.F = !Intrinsics.areEqual(bool, Boxing.a(false));
                        return Unit.f139807a;
                    }
                };
                this.f94443a = 1;
                if (flowJ2.collect(flowCollector, this) == objF) {
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
            return ((AnonymousClass6) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.appblock.service.LockRunnable$7, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.appblock.service.LockRunnable$7", f = "LockRunnable.kt", l = {414}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass7 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f94446a;

        AnonymousClass7(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return LockRunnable.this.new AnonymousClass7(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f94446a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowS = LockRunnable.this.R().S(true);
                final LockRunnable lockRunnable = LockRunnable.this;
                FlowCollector flowCollector = new FlowCollector() { // from class: cz.mobilesoft.appblock.service.LockRunnable.7.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public final Object emit(List list, Continuation continuation) {
                        LockRunnable lockRunnable2 = lockRunnable;
                        List list2 = list;
                        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                        Iterator<T> it = list2.iterator();
                        while (it.hasNext()) {
                            arrayList.add(((IgnoredStatisticsItem) it.next()).c());
                        }
                        lockRunnable2.O = arrayList;
                        return Unit.f139807a;
                    }
                };
                this.f94446a = 1;
                if (flowS.collect(flowCollector, this) == objF) {
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
            return ((AnonymousClass7) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.appblock.service.LockRunnable$8, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.appblock.service.LockRunnable$8", f = "LockRunnable.kt", l = {420}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass8 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f94449a;

        AnonymousClass8(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return LockRunnable.this.new AnonymousClass8(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f94449a;
            if (i3 == 0) {
                ResultKt.b(obj);
                LockRunnable lockRunnable = LockRunnable.this;
                this.f94449a = 1;
                if (lockRunnable.z0(this) == objF) {
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
            return ((AnonymousClass8) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public interface Callback {
        void a(long j3, String str, String str2);

        void b();

        void c(List list);

        void d(int i3, String str, UsageLimit.PeriodType periodType);

        void e();

        void f();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final long b() {
            return ((Number) LockRunnable.V.getValue()).longValue();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class IterationResult {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f94452a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f94453b;

        public IterationResult(boolean z2, long j3) {
            this.f94452a = z2;
            this.f94453b = j3;
        }

        public final boolean a() {
            return this.f94452a;
        }

        public final long b() {
            return this.f94453b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof IterationResult)) {
                return false;
            }
            IterationResult iterationResult = (IterationResult) obj;
            return this.f94452a == iterationResult.f94452a && this.f94453b == iterationResult.f94453b;
        }

        public int hashCode() {
            return (Boolean.hashCode(this.f94452a) * 31) + Long.hashCode(this.f94453b);
        }

        public String toString() {
            return "IterationResult(locked=" + this.f94452a + ", restartJobScheduleTime=" + this.f94453b + ")";
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LockRunnable(Context context, PackageAdditionalBlockingDTO packageAdditionalBlockingDTO, Callback callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.f94406a = context;
        this.f94407b = packageAdditionalBlockingDTO;
        this.f94408c = callback;
        final Qualifier qualifier = null;
        CoroutineScope coroutineScopeA = CoroutineScopeKt.a(Dispatchers.b().plus(SupervisorKt.b(null, 1, null)).plus(CoroutinesHelperExtKt.b()));
        this.f94409d = coroutineScopeA;
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f94410f = LazyKt.a(lazyThreadSafetyModeB, new Function0<LaunchTimeDao>() { // from class: cz.mobilesoft.appblock.service.LockRunnable$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(LaunchTimeDao.class), qualifier, objArr);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB2 = koinPlatformTools.b();
        final Object[] objArr2 = 0 == true ? 1 : 0;
        final Object[] objArr3 = 0 == true ? 1 : 0;
        this.f94411g = LazyKt.a(lazyThreadSafetyModeB2, new Function0<IgnoredStatisticsItemDao>() { // from class: cz.mobilesoft.appblock.service.LockRunnable$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(IgnoredStatisticsItemDao.class), objArr2, objArr3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB3 = koinPlatformTools.b();
        final Object[] objArr4 = 0 == true ? 1 : 0;
        final Object[] objArr5 = 0 == true ? 1 : 0;
        this.f94412h = LazyKt.a(lazyThreadSafetyModeB3, new Function0<CoreMultiProcessDataStore>() { // from class: cz.mobilesoft.appblock.service.LockRunnable$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(CoreMultiProcessDataStore.class), objArr4, objArr5);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB4 = koinPlatformTools.b();
        final Object[] objArr6 = 0 == true ? 1 : 0;
        final Object[] objArr7 = 0 == true ? 1 : 0;
        this.f94413i = LazyKt.a(lazyThreadSafetyModeB4, new Function0<StrictModeDataStore>() { // from class: cz.mobilesoft.appblock.service.LockRunnable$special$$inlined$inject$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(StrictModeDataStore.class), objArr6, objArr7);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB5 = koinPlatformTools.b();
        final Object[] objArr8 = 0 == true ? 1 : 0;
        final Object[] objArr9 = 0 == true ? 1 : 0;
        this.f94414j = LazyKt.a(lazyThreadSafetyModeB5, new Function0<EventDataStore>() { // from class: cz.mobilesoft.appblock.service.LockRunnable$special$$inlined$inject$default$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(EventDataStore.class), objArr8, objArr9);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB6 = koinPlatformTools.b();
        final Object[] objArr10 = 0 == true ? 1 : 0;
        final Object[] objArr11 = 0 == true ? 1 : 0;
        this.f94415k = LazyKt.a(lazyThreadSafetyModeB6, new Function0<DevDataStore>() { // from class: cz.mobilesoft.appblock.service.LockRunnable$special$$inlined$inject$default$6
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(DevDataStore.class), objArr10, objArr11);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB7 = koinPlatformTools.b();
        final Object[] objArr12 = 0 == true ? 1 : 0;
        final Object[] objArr13 = 0 == true ? 1 : 0;
        this.f94416l = LazyKt.a(lazyThreadSafetyModeB7, new Function0<CoreDataStore>() { // from class: cz.mobilesoft.appblock.service.LockRunnable$special$$inlined$inject$default$7
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(CoreDataStore.class), objArr12, objArr13);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB8 = koinPlatformTools.b();
        final Object[] objArr14 = 0 == true ? 1 : 0;
        final Object[] objArr15 = 0 == true ? 1 : 0;
        this.f94417m = LazyKt.a(lazyThreadSafetyModeB8, new Function0<GetUsageLimitsForCurrentPeriodUseCase>() { // from class: cz.mobilesoft.appblock.service.LockRunnable$special$$inlined$inject$default$8
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(GetUsageLimitsForCurrentPeriodUseCase.class), objArr14, objArr15);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB9 = koinPlatformTools.b();
        final Object[] objArr16 = 0 == true ? 1 : 0;
        final Object[] objArr17 = 0 == true ? 1 : 0;
        this.f94418n = LazyKt.a(lazyThreadSafetyModeB9, new Function0<GetForegroundAppsUseCase>() { // from class: cz.mobilesoft.appblock.service.LockRunnable$special$$inlined$inject$default$9
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(GetForegroundAppsUseCase.class), objArr16, objArr17);
            }
        });
        this.f94419o = LazyKt.b(new Function0() { // from class: cz.mobilesoft.appblock.service.f0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return LockRunnable.t0(this.f94729a);
            }
        });
        ProfileProvider profileProvider = new ProfileProvider(coroutineScopeA);
        this.f94423s = profileProvider;
        this.f94424t = true;
        UsageLimitCountdown usageLimitCountdown = new UsageLimitCountdown(coroutineScopeA, new Function0() { // from class: cz.mobilesoft.appblock.service.g0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(LockRunnable.B0(this.f94731a));
            }
        });
        this.f94425u = usageLimitCountdown;
        this.f94426v = new LockScreenExecutor(coroutineScopeA);
        this.B = -1;
        this.C = true;
        this.G = new PopupDetectionTracker(new Function0() { // from class: cz.mobilesoft.appblock.service.h0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(LockRunnable.s0(this.f94740a));
            }
        }, 0 == true ? 1 : 0, 2, 0 == true ? 1 : 0);
        UsageLimitHostTracker usageLimitHostTracker = new UsageLimitHostTracker(coroutineScopeA);
        this.I = usageLimitHostTracker;
        this.J = new ForegroundAppResolver(new Function0() { // from class: cz.mobilesoft.appblock.service.i0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return LockRunnable.I(this.f94744a);
            }
        });
        this.K = new BlockingDecisionMaker();
        this.L = new MediaSessionWatcher(context);
        this.M = new BackgroundPlaybackBlocker(SetsKt.setOf("cz.mobilesoft.appblock"), 0, 0L, 6, null);
        this.N = FlowKt.I(new LockRunnable$backgroundPlaybackHeartbeat$1(null));
        this.O = CollectionsKt.emptyList();
        this.P = SetsKt.emptySet();
        this.Q = SetsKt.emptySet();
        this.R = FlowKt.h0(FlowKt.I(new LockRunnable$special$$inlined$transform$1(O().h1(), null)), coroutineScopeA, SharingStarted.f142210a.c(), Boolean.FALSE);
        usageLimitCountdown.L(new UsageLimitCountdown.Callback() { // from class: cz.mobilesoft.appblock.service.LockRunnable.1
            @Override // cz.mobilesoft.appblock.service.lock.UsageLimitCountdown.Callback
            public void a(long j3, String appLabel, String profileTitle) {
                Intrinsics.checkNotNullParameter(appLabel, "appLabel");
                Intrinsics.checkNotNullParameter(profileTitle, "profileTitle");
                LockRunnable.this.f94408c.a(j3, appLabel, profileTitle);
            }

            @Override // cz.mobilesoft.appblock.service.lock.UsageLimitCountdown.Callback
            public void b() {
                LockRunnable.this.f94408c.b();
            }
        });
        ApplicationRepository.f97454a.r(context, true);
        CoroutinesHelperExtKt.d(new AnonymousClass2(null));
        BuildersKt__Builders_commonKt.d(coroutineScopeA, null, null, new AnonymousClass3(null), 3, null);
        BuildersKt__Builders_commonKt.d(coroutineScopeA, null, null, new AnonymousClass4(null), 3, null);
        BuildersKt__Builders_commonKt.d(coroutineScopeA, null, null, new AnonymousClass5(null), 3, null);
        BuildersKt__Builders_commonKt.d(coroutineScopeA, null, null, new AnonymousClass6(null), 3, null);
        BuildersKt__Builders_commonKt.d(coroutineScopeA, null, null, new AnonymousClass7(null), 3, null);
        BuildersKt__Builders_commonKt.d(coroutineScopeA, null, null, new AnonymousClass8(null), 3, null);
        FlowExtKt.l(O().a1(), coroutineScopeA, new FlowCollector() { // from class: cz.mobilesoft.appblock.service.LockRunnable.9
            @Override // kotlinx.coroutines.flow.FlowCollector
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object emit(EventWithPackageDTO eventWithPackageDTO, Continuation continuation) {
                String packageName = eventWithPackageDTO.getPackageName();
                if (packageName == null) {
                    return Unit.f139807a;
                }
                LockRunnable.this.m0("==== Pausing media playback of " + packageName + " on request ====");
                LockRunnable.this.L.g(packageName);
                return Unit.f139807a;
            }
        });
        profileProvider.s();
        usageLimitHostTracker.i();
        this.S = new CountDownLatch(1);
    }

    private final boolean A0(List list, GetForegroundAppsUseCase.AppsDTO appsDTO, UrlDto urlDto, SubApp subApp, long j3) {
        boolean z2 = j3 - this.f94429y <= 500 && appsDTO.c("cz.mobilesoft.appblock");
        boolean z3 = this.D && appsDTO.c("com.android.settings");
        if (z2 || z3) {
            return false;
        }
        List listB = this.K.b(list, appsDTO, urlDto, (Set) this.f94423s.n().b());
        String strD = this.K.d(listB, appsDTO);
        if (urlDto == null && subApp == null) {
            if (!ComparableExtKt.c(listB != null ? Integer.valueOf(listB.size()) : null, 0)) {
                return false;
            }
        }
        this.f94425u.J();
        long jC = TimeHelperExt.c();
        boolean zC = this.G.c(strD);
        if (this.G.e(strD, zC, jC)) {
            return false;
        }
        if (jC - this.f94429y > 300) {
            m0("Locking " + appsDTO + ", last was " + this.f94430z + " " + (jC - this.f94429y) + "ms ago");
            h0(appsDTO, strD, urlDto, subApp, list, zC);
            this.f94429y = TimeHelperExt.c();
            this.G.d(strD);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean B0(LockRunnable lockRunnable) {
        return lockRunnable.f94424t;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x005f A[Catch: all -> 0x0023, TryCatch #0 {all -> 0x0023, blocks: (B:3:0x0001, B:4:0x000c, B:6:0x0012, B:8:0x001f, B:11:0x0025, B:13:0x0032, B:16:0x0039, B:18:0x004b, B:20:0x004f, B:22:0x0055, B:25:0x0069, B:27:0x0074, B:24:0x005f, B:30:0x0080), top: B:35:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final synchronized boolean E(java.util.List r6, cz.mobilesoft.coreblock.dto.events.PackageAdditionalBlockingDTO r7) {
        /*
            r5 = this;
            monitor-enter(r5)
            java.lang.Iterable r6 = (java.lang.Iterable) r6     // Catch: java.lang.Throwable -> L23
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L23
            r0.<init>()     // Catch: java.lang.Throwable -> L23
            java.util.Iterator r6 = r6.iterator()     // Catch: java.lang.Throwable -> L23
        Lc:
            boolean r1 = r6.hasNext()     // Catch: java.lang.Throwable -> L23
            if (r1 == 0) goto L25
            java.lang.Object r1 = r6.next()     // Catch: java.lang.Throwable -> L23
            r2 = r1
            cz.mobilesoft.coreblock.storage.room.dto.blocking.ProfileWithConfiguration r2 = (cz.mobilesoft.coreblock.storage.room.dto.blocking.ProfileWithConfiguration) r2     // Catch: java.lang.Throwable -> L23
            boolean r2 = r2.z()     // Catch: java.lang.Throwable -> L23
            if (r2 == 0) goto Lc
            r0.add(r1)     // Catch: java.lang.Throwable -> L23
            goto Lc
        L23:
            r6 = move-exception
            goto L87
        L25:
            cz.mobilesoft.appblock.service.lock.ForegroundAppResolver r6 = r5.J     // Catch: java.lang.Throwable -> L23
            java.lang.String r1 = r7.getPackageName()     // Catch: java.lang.Throwable -> L23
            cz.mobilesoft.coreblock.usecase.GetForegroundAppsUseCase$AppsDTO r6 = r6.a(r0, r1)     // Catch: java.lang.Throwable -> L23
            r1 = 0
            if (r6 == 0) goto L80
            boolean r2 = r6.l()     // Catch: java.lang.Throwable -> L23
            if (r2 == 0) goto L39
            goto L80
        L39:
            cz.mobilesoft.appblock.service.lock.PopupDetectionTracker r2 = r5.G     // Catch: java.lang.Throwable -> L23
            java.lang.String r3 = r6.i()     // Catch: java.lang.Throwable -> L23
            r2.f(r3)     // Catch: java.lang.Throwable -> L23
            cz.mobilesoft.coreblock.usecase.GetForegroundAppsUseCase$AppsDTO r2 = r5.f94421q     // Catch: java.lang.Throwable -> L23
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r6)     // Catch: java.lang.Throwable -> L23
            r3 = 0
            if (r2 == 0) goto L5f
            cz.mobilesoft.coreblock.usecase.GetForegroundAppsUseCase$AppsDTO r2 = r5.f94421q     // Catch: java.lang.Throwable -> L23
            if (r2 == 0) goto L54
            java.lang.String r2 = r2.h()     // Catch: java.lang.Throwable -> L23
            goto L55
        L54:
            r2 = r3
        L55:
            java.lang.String r4 = r6.h()     // Catch: java.lang.Throwable -> L23
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r4)     // Catch: java.lang.Throwable -> L23
            if (r2 != 0) goto L69
        L5f:
            r5.f94421q = r6     // Catch: java.lang.Throwable -> L23
            cz.mobilesoft.appblock.service.LockRunnable$checkAppOrLock$1 r2 = new cz.mobilesoft.appblock.service.LockRunnable$checkAppOrLock$1     // Catch: java.lang.Throwable -> L23
            r2.<init>(r6, r5, r3)     // Catch: java.lang.Throwable -> L23
            cz.mobilesoft.coreblock.util.helperextension.CoroutinesHelperExtKt.d(r2)     // Catch: java.lang.Throwable -> L23
        L69:
            cz.mobilesoft.appblock.service.lock.UsageLimitHostTracker r2 = r5.I     // Catch: java.lang.Throwable -> L23
            r2.b(r6, r7)     // Catch: java.lang.Throwable -> L23
            boolean r2 = r0.isEmpty()     // Catch: java.lang.Throwable -> L23
            if (r2 != 0) goto L7e
            boolean r1 = r5.F(r6, r0, r7)     // Catch: java.lang.Throwable -> L23
            java.lang.String r6 = r6.i()     // Catch: java.lang.Throwable -> L23
            r5.f94422r = r6     // Catch: java.lang.Throwable -> L23
        L7e:
            monitor-exit(r5)
            return r1
        L80:
            cz.mobilesoft.appblock.service.lock.UsageLimitCountdown r6 = r5.f94425u     // Catch: java.lang.Throwable -> L23
            r6.H()     // Catch: java.lang.Throwable -> L23
            monitor-exit(r5)
            return r1
        L87:
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L23
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.appblock.service.LockRunnable.E(java.util.List, cz.mobilesoft.coreblock.dto.events.PackageAdditionalBlockingDTO):boolean");
    }

    private final synchronized boolean F(GetForegroundAppsUseCase.AppsDTO appsDTO, List list, PackageAdditionalBlockingDTO packageAdditionalBlockingDTO) {
        try {
            UsageLimitHostTracker.HostInfo hostInfoG = this.I.g(appsDTO, packageAdditionalBlockingDTO);
            String strA = hostInfoG.a();
            UrlDto urlDtoC = hostInfoG.c();
            SubApp subAppB = hostInfoG.b();
            long jC = TimeHelperExt.c();
            String domain = urlDtoC != null ? urlDtoC.getDomain() : null;
            long jG0 = M().g0(UsageLimit.PeriodType.HOURLY, this.H);
            UsageLimitCountdown.ChangeCheckResult changeCheckResultM = this.f94425u.m(jG0, appsDTO, urlDtoC, subAppB, this.f94423s.r(list));
            boolean zA = changeCheckResultM.a();
            boolean zB = changeCheckResultM.b();
            boolean zC = changeCheckResultM.c();
            m0("==== Launched name changed: " + zB + " ====");
            if (zB) {
                UsageLimitCountdown.Companion companion = UsageLimitCountdown.f94941y;
                if (companion.a() == -1) {
                    m0("==== Resetting last launch time ====");
                    companion.b(jC);
                }
                if (zC) {
                    m0("==== Resetting notification text ====");
                    this.f94408c.b();
                }
            }
            u0(zA, jG0, list, appsDTO, urlDtoC, subAppB);
            List listZ = this.f94425u.z();
            if (listZ == null || listZ.isEmpty()) {
                listZ = null;
            }
            if (listZ != null) {
                return b0(listZ, appsDTO, list, strA, domain, urlDtoC, subAppB, jC, zB);
            }
            m0("==== No usage limits, locking ====");
            this.f94425u.G();
            this.f94425u.V(appsDTO, urlDtoC, subAppB);
            return l0(this, list, appsDTO, null, jC, null, 16, null);
        } catch (Throwable th) {
            throw th;
        }
    }

    private final void G(GetForegroundAppsUseCase.AppsDTO appsDTO) {
        if (this.D && appsDTO.c("com.android.settings")) {
            String strH = Intrinsics.areEqual(appsDTO.i(), "com.android.settings") ? appsDTO.h() : appsDTO.j();
            String str = this.A;
            if (str == null) {
                this.A = strH;
            } else {
                if (Intrinsics.areEqual(str, strH)) {
                    return;
                }
                this.A = strH;
                CoroutinesHelperExtKt.d(new LockRunnable$checkSettingsClassName$1(this, strH, null));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GetForegroundAppsUseCase.AppsDTO I(LockRunnable lockRunnable) {
        return lockRunnable.P().c(GetForegroundAppsUseCase.Params.f127109a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CoreDataStore L() {
        return (CoreDataStore) this.f94416l.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CoreMultiProcessDataStore M() {
        return (CoreMultiProcessDataStore) this.f94412h.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DevDataStore N() {
        return (DevDataStore) this.f94415k.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final EventDataStore O() {
        return (EventDataStore) this.f94414j.getValue();
    }

    private final GetForegroundAppsUseCase P() {
        return (GetForegroundAppsUseCase) this.f94418n.getValue();
    }

    private final GetUsageLimitsForCurrentPeriodUseCase Q() {
        return (GetUsageLimitsForCurrentPeriodUseCase) this.f94417m.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IgnoredStatisticsItemDao R() {
        return (IgnoredStatisticsItemDao) this.f94411g.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LaunchTimeDao S() {
        return (LaunchTimeDao) this.f94410f.getValue();
    }

    private final PowerManager T() {
        return (PowerManager) this.f94419o.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StrictModeDataStore U() {
        return (StrictModeDataStore) this.f94413i.getValue();
    }

    public static /* synthetic */ List Y(LockRunnable lockRunnable, List list, List list2, UrlDto urlDto, SubApp subApp, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            list2 = null;
        }
        if ((i3 & 4) != 0) {
            urlDto = null;
        }
        if ((i3 & 8) != 0) {
            subApp = null;
        }
        return lockRunnable.X(list, list2, urlDto, subApp);
    }

    private final void Z(PackageAdditionalBlockingDTO packageAdditionalBlockingDTO) throws InterruptedException {
        this.f94425u.H();
        this.I.b(null, packageAdditionalBlockingDTO);
        JobHelper.l();
        if (this.C) {
            m0("==== Switching to non-interactive ====");
            this.f94425u.J();
            this.C = false;
        }
        m0("==== Display off, sleeping ====");
        Thread.sleep(300L);
    }

    private final IterationResult a0(List list, PackageAdditionalBlockingDTO packageAdditionalBlockingDTO, long j3) throws InterruptedException {
        m0("==== Checking " + list.size() + " profiles ====");
        if (((Boolean) this.R.getValue()).booleanValue()) {
            BuildersKt__Builders_commonKt.d(this.f94409d, null, null, new LockRunnable$handleActiveProfiles$1(list, this, null), 3, null);
        }
        this.f94408c.c(list);
        if (E(list, packageAdditionalBlockingDTO)) {
            m0("==== Locked, continuing ====");
            return new IterationResult(true, j3);
        }
        long jD0 = d0(j3);
        m0("==== Sleeping for 300 ms ====");
        Thread.sleep(300L);
        return new IterationResult(false, jD0);
    }

    private final void c0(boolean z2, UsageLimit usageLimit, GetForegroundAppsUseCase.AppsDTO appsDTO, String str, String str2, long j3) {
        if (!z2 || usageLimit == null) {
            return;
        }
        UsageLimitCountdown.Companion companion = UsageLimitCountdown.f94941y;
        if (j3 - companion.a() >= 30000) {
            String simpleName = LockRunnable.class.getSimpleName();
            Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
            Log.d(simpleName, "==== Incrementing launch count to " + (usageLimit.m() + 1) + "  ====");
            companion.b(-1L);
            this.f94425u.A();
        }
        this.f94425u.P();
        String strN = this.f94425u.n(appsDTO.f(), str, str2);
        this.f94408c.d((int) (usageLimit.f() - usageLimit.m()), strN, usageLimit.k());
        String simpleName2 = LockRunnable.class.getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName2, "getSimpleName(...)");
        Log.d(simpleName2, "==== Updating notification text for " + strN + " ====");
    }

    private final long d0(long j3) {
        int i3 = this.B;
        if (i3 >= 1000 || i3 == -1) {
            this.f94408c.e();
            this.B = 0;
        }
        Companion companion = T;
        if (companion.b() != -1) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - j3 >= companion.b()) {
                JobHelper.B();
                return jCurrentTimeMillis;
            }
        }
        return j3;
    }

    private final void e0() {
        BuildersKt__Builders_commonKt.d(this.f94409d, null, null, new LockRunnable$initialize$1(this, null), 3, null);
        this.f94423s.o();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean f0(String str) {
        GetForegroundAppsUseCase.AppsDTO appsDTO = new GetForegroundAppsUseCase.AppsDTO(str, null, false, 4, null);
        List listM = this.f94423s.m();
        ArrayList arrayList = new ArrayList();
        for (Object obj : listM) {
            ProfileWithConfiguration profileWithConfiguration = (ProfileWithConfiguration) obj;
            if (profileWithConfiguration.y() && profileWithConfiguration.z() && profileWithConfiguration.A(appsDTO.f())) {
                arrayList.add(obj);
            }
        }
        if (arrayList.isEmpty()) {
            return false;
        }
        List listB = this.K.b(arrayList, appsDTO, null, (Set) this.f94423s.n().b());
        if (listB == null || listB.isEmpty()) {
            return false;
        }
        List listY = Y(this, arrayList, appsDTO.f(), null, null, 12, null);
        if (listY.isEmpty()) {
            return true;
        }
        Pair pairA = this.K.a(listY);
        if (this.K.c((UsageLimit) pairA.a(), (UsageLimit) pairA.b(), false)) {
            return true;
        }
        return BlockingProfilesBesidesLimitsChecker.f95108a.a(arrayList, appsDTO.f(), listY);
    }

    private final synchronized void h0(GetForegroundAppsUseCase.AppsDTO appsDTO, String str, UrlDto urlDto, SubApp subApp, List list, boolean z2) {
        this.f94426v.d(new LockScreenExecutor.LockRequest(appsDTO, str, urlDto, subApp, list, z2, this.E, this.F, this.f94422r, this.Q, this.f94425u.y(), new Function0() { // from class: cz.mobilesoft.appblock.service.j0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return LockRunnable.i0(this.f94750a);
            }
        }, new Function1() { // from class: cz.mobilesoft.appblock.service.k0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LockRunnable.j0(this.f94753a, (String) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i0(LockRunnable lockRunnable) {
        lockRunnable.f94425u.I();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j0(LockRunnable lockRunnable, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        lockRunnable.L.g(it);
        return Unit.f139807a;
    }

    private final synchronized boolean k0(List list, GetForegroundAppsUseCase.AppsDTO appsDTO, UrlDto urlDto, long j3, SubApp subApp) {
        this.f94425u.T();
        if (this.K.h(appsDTO)) {
            return false;
        }
        G(appsDTO);
        boolean z2 = this.D;
        this.D = ((Boolean) new BlockingFlowProperty(O().i1()).b()).booleanValue();
        if (!this.K.g(appsDTO, this.f94430z, this.f94428x, z2 != this.D, j3 - this.f94427w)) {
            return false;
        }
        x0(appsDTO);
        this.f94430z = appsDTO;
        this.f94427w = TimeHelperExt.c();
        boolean zA0 = A0(list, appsDTO, urlDto, subApp, j3);
        this.f94428x = zA0;
        return zA0;
    }

    static /* synthetic */ boolean l0(LockRunnable lockRunnable, List list, GetForegroundAppsUseCase.AppsDTO appsDTO, UrlDto urlDto, long j3, SubApp subApp, int i3, Object obj) {
        if ((i3 & 16) != 0) {
            subApp = null;
        }
        return lockRunnable.k0(list, appsDTO, urlDto, j3, subApp);
    }

    public static /* synthetic */ void p0(LockRunnable lockRunnable, boolean z2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z2 = true;
        }
        lockRunnable.o0(z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q0(Set set) {
        if (set.isEmpty() || !this.f94423s.q()) {
            return;
        }
        for (String str : this.M.d(set, TimeHelperExt.c(), new LockRunnable$pauseBlockedPlayingApps$packagesToPause$1(this))) {
            m0("==== Pausing media playback of " + str + " ====");
            this.L.g(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean s0(LockRunnable lockRunnable) {
        return lockRunnable.E;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PowerManager t0(LockRunnable lockRunnable) {
        Object systemService = lockRunnable.f94406a.getSystemService("power");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.PowerManager");
        return (PowerManager) systemService;
    }

    private final void u0(boolean z2, long j3, List list, GetForegroundAppsUseCase.AppsDTO appsDTO, UrlDto urlDto, SubApp subApp) {
        if (z2) {
            this.f94425u.F(j3);
            this.f94425u.J();
            m0("==== Usage limits saved ====");
            this.f94425u.D(X(list, appsDTO.f(), urlDto, subApp));
            m0("==== Usage limits fetched: " + this.f94425u.z() + " ====");
        }
    }

    private final List v0(PackageAdditionalBlockingDTO packageAdditionalBlockingDTO) throws InterruptedException {
        m0("==== Checking profiles ====");
        if (!this.f94423s.p()) {
            m0("==== Profiles not initialized ====");
            Thread.sleep(300L);
            return null;
        }
        List listM = this.f94423s.m();
        ArrayList arrayList = new ArrayList();
        for (Object obj : listM) {
            ProfileWithConfiguration profileWithConfiguration = (ProfileWithConfiguration) obj;
            if (profileWithConfiguration.y() && profileWithConfiguration.x(packageAdditionalBlockingDTO.getUrlDto(), packageAdditionalBlockingDTO.getSubApp())) {
                arrayList.add(obj);
            }
        }
        if (!arrayList.isEmpty() || packageAdditionalBlockingDTO.getPackageName() != null) {
            return arrayList;
        }
        m0("==== Profiles empty ====");
        CoroutinesHelperExtKt.d(new LockRunnable$resolveActiveProfiles$1(this, null));
        this.f94424t = false;
        this.f94408c.f();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long w0() {
        RunnabilityHelper runnabilityHelper = RunnabilityHelper.f129617a;
        return (runnabilityHelper.P() || runnabilityHelper.M()) ? 5000L : -1L;
    }

    private final void x0(GetForegroundAppsUseCase.AppsDTO appsDTO) {
        GetForegroundAppsUseCase.AppsDTO appsDTO2;
        if (!this.D || (appsDTO2 = this.f94430z) == null || !appsDTO2.c("com.android.settings") || Intrinsics.areEqual(this.f94430z, appsDTO) || appsDTO.e("com.android.settings") || CollectionsKt.contains(this.P, appsDTO.h())) {
            return;
        }
        CoroutinesHelperExtKt.d(new LockRunnable$revokeSettingsAccessIfNeeded$1(this, null));
        this.D = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object z0(Continuation continuation) {
        Object objCollect = FlowKt.J(this.L.f(), this.N, new LockRunnable$stopBackgroundPlaybackOfBlockedApps$2(null)).collect(new LockRunnable$stopBackgroundPlaybackOfBlockedApps$3(this), continuation);
        return objCollect == IntrinsicsKt.f() ? objCollect : Unit.f139807a;
    }

    public final void H() {
        if (this.K.f(this.f94430z)) {
            this.f94430z = null;
            this.f94427w = 0L;
        }
    }

    public final List J() {
        return this.O;
    }

    public final List K(Collection profiles) {
        Intrinsics.checkNotNullParameter(profiles, "profiles");
        return ProfileWithConfigurationKt.a(profiles);
    }

    public final UsageLimitCountdown V() {
        return this.f94425u;
    }

    public final UsageLimitHostTracker W() {
        return this.I;
    }

    public final List X(List profiles, List list, UrlDto urlDto, SubApp subApp) {
        Intrinsics.checkNotNullParameter(profiles, "profiles");
        return Q().j(new GetUsageLimitsForCurrentPeriodUseCase.Params(profiles, list, urlDto, subApp));
    }

    public final boolean g0() {
        return this.f94424t;
    }

    public final void m0(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        if (this.f94420p) {
            LoggingExtKt.a("LockService", message);
        }
    }

    public final void n0() {
        p0(this, false, 1, null);
    }

    public final void o0(boolean z2) {
        List listM = this.f94423s.m();
        if (!(listM instanceof Collection) || !listM.isEmpty()) {
            Iterator it = listM.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (ProfileType.USAGE_LIMIT.isSetTo(((ProfileWithConfiguration) it.next()).p().E())) {
                    this.f94425u.J();
                    break;
                }
            }
        }
        if (z2) {
            JobHelper.B();
        }
        CoroutineScopeKt.e(this.f94409d, null, 1, null);
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }

    @Override // java.lang.Runnable
    public void run() {
        e0();
        try {
            this.S.await();
            long j3 = 0;
            while (this.f94424t) {
                UsageLimitHostTracker.PollResult pollResultF = this.I.f();
                PackageAdditionalBlockingDTO packageAdditionalBlockingDTOA = pollResultF.a();
                UsageLimitHostTracker.HostChangeResult hostChangeResultB = pollResultF.b();
                if (!Intrinsics.areEqual(hostChangeResultB, UsageLimitHostTracker.HostChangeResult.NoChange.f95001a)) {
                    m0("==== Host changed (" + hostChangeResultB + "), stopping countdown, resetting ====");
                    this.f94425u.H();
                }
                if (T().isInteractive()) {
                    if (!this.C) {
                        m0("==== Switching to interactive ====");
                        this.C = true;
                    }
                    List listV0 = v0(packageAdditionalBlockingDTOA);
                    if (listV0 != null) {
                        IterationResult iterationResultA0 = a0(listV0, packageAdditionalBlockingDTOA, j3);
                        long jB = iterationResultA0.b();
                        if (iterationResultA0.a()) {
                            j3 = jB;
                        } else {
                            j3 = jB;
                        }
                    }
                } else {
                    Z(packageAdditionalBlockingDTOA);
                }
                this.B++;
            }
        } catch (InterruptedException unused) {
            this.f94424t = false;
            String simpleName = LockRunnable.class.getSimpleName();
            Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
            Log.i(simpleName, "LOCK THREAD - INTERRUPTED");
        }
    }

    public final void y0(int i3) {
        this.H = i3;
    }

    private final boolean b0(List list, GetForegroundAppsUseCase.AppsDTO appsDTO, List list2, String str, String str2, UrlDto urlDto, SubApp subApp, long j3, boolean z2) {
        boolean zB;
        Object next;
        String strA;
        Profile profileP;
        m0("==== Found " + list.size() + " usage limits ====");
        Pair pairA = this.K.a(list);
        UsageLimit usageLimit = (UsageLimit) pairA.a();
        UsageLimit usageLimit2 = (UsageLimit) pairA.b();
        this.f94425u.l(usageLimit, usageLimit2);
        if (this.K.c(usageLimit, usageLimit2, z2)) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : list2) {
                ProfileWithConfiguration profileWithConfiguration = (ProfileWithConfiguration) obj;
                if ((usageLimit != null && profileWithConfiguration.p().r() == usageLimit.l()) || (usageLimit2 != null && profileWithConfiguration.p().r() == usageLimit2.l())) {
                    arrayList.add(obj);
                }
            }
            return k0(arrayList, appsDTO, urlDto, j3, subApp);
        }
        if (usageLimit == null) {
            this.f94425u.G();
            zB = false;
        } else {
            zB = this.f94425u.B(usageLimit.g());
        }
        if (BlockingProfilesBesidesLimitsChecker.f95108a.a(list2, appsDTO.q(), this.f94425u.z())) {
            m0(YvFRmou.qzf);
            ArrayList arrayList2 = new ArrayList();
            for (Object obj2 : list2) {
                ProfileWithConfiguration profileWithConfiguration2 = (ProfileWithConfiguration) obj2;
                List list3 = list;
                ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
                Iterator it = list3.iterator();
                while (it.hasNext()) {
                    arrayList3.add(Long.valueOf(((UsageLimit) it.next()).l()));
                }
                if (!arrayList3.contains(Long.valueOf(profileWithConfiguration2.p().r()))) {
                    arrayList2.add(obj2);
                }
            }
            this.f94425u.V(appsDTO, urlDto, subApp);
            return l0(this, arrayList2, appsDTO, null, j3, null, 16, null);
        }
        if (zB && usageLimit != null) {
            Iterator it2 = list2.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    next = null;
                    break;
                }
                next = it2.next();
                if (((ProfileWithConfiguration) next).p().r() == usageLimit.l()) {
                    break;
                }
            }
            ProfileWithConfiguration profileWithConfiguration3 = (ProfileWithConfiguration) next;
            if (profileWithConfiguration3 == null || (profileP = profileWithConfiguration3.p()) == null || (strA = profileP.A()) == null) {
                strA = "";
            }
            this.f94425u.Q(appsDTO.f(), str, str2, usageLimit, strA);
            this.f94425u.U(usageLimit.g());
            m0("==== Countdown started, returning ====");
        }
        c0(z2, usageLimit2, appsDTO, str, str2, j3);
        this.f94425u.V(appsDTO, urlDto, subApp);
        return false;
    }
}
