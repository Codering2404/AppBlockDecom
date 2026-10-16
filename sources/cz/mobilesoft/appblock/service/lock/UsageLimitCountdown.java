package cz.mobilesoft.appblock.service.lock;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import cz.mobilesoft.appblock.util.NotificationHelper;
import cz.mobilesoft.coreblock.dto.UrlDto;
import cz.mobilesoft.coreblock.enums.EventShowAsType;
import cz.mobilesoft.coreblock.repository.SubApp;
import cz.mobilesoft.coreblock.service.UsageLimitEndOverlayService;
import cz.mobilesoft.coreblock.storage.datastore.EventDataStore;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.UsageLimitDao;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.UsageLimit;
import cz.mobilesoft.coreblock.usecase.GetForegroundAppsUseCase;
import cz.mobilesoft.coreblock.util.helperextension.StringHelper;
import cz.mobilesoft.coreblock.util.permissions.PermissionHelper;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
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
public final class UsageLimitCountdown implements KoinComponent {
    private static volatile long A;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final Companion f94941y = new Companion(null);

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f94942z = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CoroutineScope f94943a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function0 f94944b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Lazy f94945c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Lazy f94946d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Lazy f94947f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Lazy f94948g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Callback f94949h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Function0 f94950i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f94951j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private EventShowAsType f94952k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private volatile List f94953l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private volatile boolean f94954m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private UsageLimit.PeriodType f94955n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private long f94956o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final Set f94957p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final Lazy f94958q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private volatile UsageLimitTimer f94959r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private long f94960s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private GetForegroundAppsUseCase.AppsDTO f94961t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private UrlDto f94962u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private SubApp f94963v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f94964w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final Map f94965x;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public interface Callback {
        void a(long j3, String str, String str2);

        void b();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ChangeCheckResult {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f94966a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f94967b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f94968c;

        public ChangeCheckResult(boolean z2, boolean z3, boolean z4) {
            this.f94966a = z2;
            this.f94967b = z3;
            this.f94968c = z4;
        }

        public final boolean a() {
            return this.f94966a;
        }

        public final boolean b() {
            return this.f94967b;
        }

        public final boolean c() {
            return this.f94968c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ChangeCheckResult)) {
                return false;
            }
            ChangeCheckResult changeCheckResult = (ChangeCheckResult) obj;
            return this.f94966a == changeCheckResult.f94966a && this.f94967b == changeCheckResult.f94967b && this.f94968c == changeCheckResult.f94968c;
        }

        public int hashCode() {
            return (((Boolean.hashCode(this.f94966a) * 31) + Boolean.hashCode(this.f94967b)) * 31) + Boolean.hashCode(this.f94968c);
        }

        public String toString() {
            return "ChangeCheckResult(shouldReload=" + this.f94966a + ", launchedNameChanged=" + this.f94967b + ", launchCountingStopped=" + this.f94968c + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final long a() {
            return UsageLimitCountdown.A;
        }

        public final void b(long j3) {
            UsageLimitCountdown.A = j3;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private final class UsageLimitTimer extends CountDownTimer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List f94969a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f94970b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f94971c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f94972d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private volatile boolean f94973e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ UsageLimitCountdown f94974f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UsageLimitTimer(UsageLimitCountdown usageLimitCountdown, List packageNames, String label, String profileTitle, long j3, long j4) {
            super(j3, j4);
            Intrinsics.checkNotNullParameter(packageNames, "packageNames");
            Intrinsics.checkNotNullParameter(label, "label");
            Intrinsics.checkNotNullParameter(profileTitle, "profileTitle");
            this.f94974f = usageLimitCountdown;
            this.f94969a = packageNames;
            this.f94970b = label;
            this.f94971c = profileTitle;
        }

        private final void c() {
            Log.d("UsageLimitCountdown", "Stopping countdown");
            a(false);
            cancel();
        }

        public final void a(boolean z2) {
            Log.d("UsageLimitCountdown", "==== Countdown onFinish called ====");
            if (z2) {
                this.f94974f.f94956o = -1L;
            }
            this.f94972d = true;
            Callback callbackQ = this.f94974f.q();
            if (callbackQ != null) {
                callbackQ.b();
            }
            Iterator it = this.f94969a.iterator();
            while (it.hasNext()) {
                this.f94974f.f94957p.remove((String) it.next());
            }
        }

        public final void b() {
            this.f94973e = true;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            a(true);
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j3) {
            Log.d("UsageLimitCountdown", "==== Countdown tick, " + j3 + " ms until finished ====");
            if (this.f94972d) {
                Log.d("UsageLimitCountdown", "==== Countdown already finished, returning ====");
                return;
            }
            if (this.f94974f.O(this.f94973e)) {
                c();
                return;
            }
            List<UsageLimit> listZ = this.f94974f.z();
            boolean z2 = false;
            if (listZ != null) {
                UsageLimitCountdown usageLimitCountdown = this.f94974f;
                for (UsageLimit usageLimit : listZ) {
                    if (usageLimit.i() == UsageLimit.LimitType.TIME) {
                        usageLimit.p(usageLimit.m() + ((long) 1000));
                        if (usageLimitCountdown.u() != 0 && j3 <= usageLimitCountdown.u()) {
                            z2 = true;
                        }
                        if (usageLimit.m() > usageLimit.f()) {
                            usageLimit.p(usageLimit.f());
                        }
                    }
                }
            }
            Callback callbackQ = this.f94974f.q();
            if (callbackQ != null) {
                callbackQ.a(j3, this.f94970b, this.f94971c);
            }
            for (String str : this.f94969a) {
                if (z2 && !this.f94974f.f94957p.contains(str)) {
                    this.f94974f.f94957p.add(str);
                    if (this.f94974f.p() == EventShowAsType.POP_UP && PermissionHelper.g(this.f94974f.r())) {
                        UsageLimitEndOverlayService.l(this.f94974f.r(), str, (String) this.f94974f.w().invoke(), j3);
                    } else {
                        NotificationHelper.f95109a.b(this.f94974f.r(), this.f94970b);
                    }
                }
            }
            Log.d("UsageLimitCountdown", "==== Countdown tick finished ====");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public UsageLimitCountdown(CoroutineScope ioScope, Function0 isRunningSupplier) {
        Intrinsics.checkNotNullParameter(ioScope, "ioScope");
        Intrinsics.checkNotNullParameter(isRunningSupplier, "isRunningSupplier");
        this.f94943a = ioScope;
        this.f94944b = isRunningSupplier;
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f94945c = LazyKt.a(lazyThreadSafetyModeB, new Function0<UsageLimitDao>() { // from class: cz.mobilesoft.appblock.service.lock.UsageLimitCountdown$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(UsageLimitDao.class), qualifier, objArr);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB2 = koinPlatformTools.b();
        final Object[] objArr2 = 0 == true ? 1 : 0;
        final Object[] objArr3 = 0 == true ? 1 : 0;
        this.f94946d = LazyKt.a(lazyThreadSafetyModeB2, new Function0<EventDataStore>() { // from class: cz.mobilesoft.appblock.service.lock.UsageLimitCountdown$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(EventDataStore.class), objArr2, objArr3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB3 = koinPlatformTools.b();
        final Object[] objArr4 = 0 == true ? 1 : 0;
        final Object[] objArr5 = 0 == true ? 1 : 0;
        this.f94947f = LazyKt.a(lazyThreadSafetyModeB3, new Function0<Context>() { // from class: cz.mobilesoft.appblock.service.lock.UsageLimitCountdown$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(Context.class), objArr4, objArr5);
            }
        });
        this.f94948g = LazyKt.b(new Function0() { // from class: cz.mobilesoft.appblock.service.lock.k
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return UsageLimitCountdown.E(this.f95045a);
            }
        });
        this.f94950i = new Function0() { // from class: cz.mobilesoft.appblock.service.lock.UsageLimitCountdown$urlDomainSupplier$1
            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Void invoke() {
                return null;
            }
        };
        this.f94957p = new HashSet();
        this.f94958q = LazyKt.b(new Function0() { // from class: cz.mobilesoft.appblock.service.lock.l
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return UsageLimitCountdown.C();
            }
        });
        this.f94965x = new LinkedHashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Handler C() {
        return new Handler(Looper.getMainLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PackageManager E(UsageLimitCountdown usageLimitCountdown) {
        return usageLimitCountdown.r().getPackageManager();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R(UsageLimitCountdown usageLimitCountdown, List list, String str, String str2, long j3) {
        UsageLimitTimer usageLimitTimer = new UsageLimitTimer(usageLimitCountdown, list, str, str2, j3, 1000L);
        usageLimitCountdown.f94959r = usageLimitTimer;
        usageLimitTimer.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence o(UsageLimitCountdown usageLimitCountdown, String packageName) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        return StringHelper.c(usageLimitCountdown.v(), packageName);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Context r() {
        return (Context) this.f94947f.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final EventDataStore s() {
        return (EventDataStore) this.f94946d.getValue();
    }

    private final Handler t() {
        return (Handler) this.f94958q.getValue();
    }

    private final PackageManager v() {
        Object value = this.f94948g.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (PackageManager) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final UsageLimitDao x() {
        return (UsageLimitDao) this.f94945c.getValue();
    }

    public final void A() {
        List list = this.f94953l;
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                UsageLimit usageLimit = (UsageLimit) obj;
                boolean z2 = usageLimit.i() == UsageLimit.LimitType.LAUNCH_COUNT;
                if (z2) {
                    usageLimit.p(usageLimit.m() + 1);
                }
                if (z2) {
                    arrayList.add(obj);
                }
            }
            BuildersKt__Builders_commonKt.d(this.f94943a, null, null, new UsageLimitCountdown$incrementLaunchCounts$2$1(this, arrayList, null), 3, null);
        }
    }

    public final boolean B(long j3) {
        return this.f94956o != j3;
    }

    public final void D(List reloadedLimits) {
        Intrinsics.checkNotNullParameter(reloadedLimits, "reloadedLimits");
        List<UsageLimit> list = this.f94953l;
        if (list != null) {
            for (UsageLimit usageLimit : list) {
                this.f94965x.put(TuplesKt.a(Long.valueOf(usageLimit.g()), Long.valueOf(usageLimit.h())), Long.valueOf(usageLimit.m()));
            }
        }
        Iterator it = reloadedLimits.iterator();
        while (it.hasNext()) {
            UsageLimit usageLimit2 = (UsageLimit) it.next();
            Long l3 = (Long) this.f94965x.get(TuplesKt.a(Long.valueOf(usageLimit2.g()), Long.valueOf(usageLimit2.h())));
            if (l3 != null) {
                long jLongValue = l3.longValue();
                if (jLongValue > usageLimit2.m()) {
                    usageLimit2.p(RangesKt.l(jLongValue, usageLimit2.f()));
                }
            }
        }
        this.f94953l = reloadedLimits;
    }

    public final void F(long j3) {
        this.f94960s = j3;
    }

    public final void G() {
        this.f94956o = -1L;
    }

    public final void H() {
        G();
        T();
    }

    public final void I() {
        this.f94955n = null;
    }

    public final void J() {
        List list = this.f94953l;
        if (list != null) {
            if (list.isEmpty()) {
                list = null;
            }
            if (list != null) {
                Log.d("UsageLimitCountdown", "==== Updating " + list.size() + " usage limits ====");
                BuildersKt__Builders_commonKt.d(this.f94943a, null, null, new UsageLimitCountdown$save$2$1(this, list, null), 3, null);
            }
        }
    }

    public final void K(EventShowAsType eventShowAsType) {
        this.f94952k = eventShowAsType;
    }

    public final void L(Callback callback) {
        this.f94949h = callback;
    }

    public final void M(long j3) {
        this.f94951j = j3;
    }

    public final void N(Function0 function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.f94950i = function0;
    }

    public final boolean O(boolean z2) {
        boolean zBooleanValue = ((Boolean) this.f94944b.invoke()).booleanValue();
        boolean z3 = this.f94954m;
        boolean z4 = (zBooleanValue && !z2 && z3) ? false : true;
        if (z4) {
            List list = this.f94953l;
            Log.d("UsageLimitCountdown", "==== Countdown stopping, shouldStop is " + z2 + ", existAnyTimeLimit is " + z3 + ", usageLimits empty is " + (list != null ? Boolean.valueOf(list.isEmpty()) : null) + " and shouldRun is " + zBooleanValue + " ====");
        }
        return z4;
    }

    public final void P() {
        this.f94964w = true;
    }

    public final void Q(final List packageNames, String str, String str2, UsageLimit limit, final String profileTitle) {
        Intrinsics.checkNotNullParameter(packageNames, "packageNames");
        Intrinsics.checkNotNullParameter(limit, "limit");
        Intrinsics.checkNotNullParameter(profileTitle, "profileTitle");
        final long jF = limit.f() - limit.m();
        final String strN = n(packageNames, str, str2);
        Log.d("UsageLimitCountdown", "Starting countdown for " + packageNames);
        T();
        t().post(new Runnable() { // from class: cz.mobilesoft.appblock.service.lock.m
            @Override // java.lang.Runnable
            public final void run() {
                UsageLimitCountdown.R(this.f95046a, packageNames, strN, profileTitle, jF);
            }
        });
    }

    public final void S() {
        this.f94964w = false;
    }

    public final void T() {
        t().removeCallbacksAndMessages(null);
        UsageLimitTimer usageLimitTimer = this.f94959r;
        if (usageLimitTimer != null) {
            usageLimitTimer.b();
        }
        this.f94959r = null;
    }

    public final void U(long j3) {
        this.f94956o = j3;
    }

    public final void V(GetForegroundAppsUseCase.AppsDTO foregroundApps, UrlDto urlDto, SubApp subApp) {
        Intrinsics.checkNotNullParameter(foregroundApps, "foregroundApps");
        this.f94961t = foregroundApps;
        this.f94962u = urlDto;
        this.f94963v = subApp;
    }

    public final void l(UsageLimit usageLimit, UsageLimit usageLimit2) {
        if (usageLimit != null) {
            this.f94954m = true;
            this.f94955n = usageLimit.k();
        } else if (usageLimit2 != null) {
            this.f94954m = false;
            this.f94955n = usageLimit2.k();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0017  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final cz.mobilesoft.appblock.service.lock.UsageLimitCountdown.ChangeCheckResult m(long r7, cz.mobilesoft.coreblock.usecase.GetForegroundAppsUseCase.AppsDTO r9, cz.mobilesoft.coreblock.dto.UrlDto r10, cz.mobilesoft.coreblock.repository.SubApp r11, boolean r12) {
        /*
            r6 = this;
            java.lang.String r0 = "foregroundApps"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            r0 = 0
            r1 = 1
            if (r10 == 0) goto L1b
            boolean r2 = r10.getHasKeywordsBlocking()
            if (r2 != r1) goto L1b
            cz.mobilesoft.coreblock.dto.UrlDto r2 = r6.f94962u
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r10)
            if (r10 != 0) goto L19
        L17:
            r10 = r1
            goto L33
        L19:
            r10 = r0
            goto L33
        L1b:
            cz.mobilesoft.coreblock.dto.UrlDto r2 = r6.f94962u
            r3 = 0
            if (r2 == 0) goto L25
            java.lang.String r2 = r2.getDomain()
            goto L26
        L25:
            r2 = r3
        L26:
            if (r10 == 0) goto L2c
            java.lang.String r3 = r10.getDomain()
        L2c:
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r3)
            if (r10 != 0) goto L19
            goto L17
        L33:
            cz.mobilesoft.coreblock.usecase.GetForegroundAppsUseCase$AppsDTO r2 = r6.f94961t
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual(r9, r2)
            if (r9 == 0) goto L48
            if (r10 != 0) goto L48
            cz.mobilesoft.coreblock.repository.SubApp r9 = r6.f94963v
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual(r9, r11)
            if (r9 != 0) goto L46
            goto L48
        L46:
            r9 = r0
            goto L49
        L48:
            r9 = r1
        L49:
            if (r9 == 0) goto L5a
            boolean r10 = r6.f94964w
            if (r10 == 0) goto L5a
            long r10 = java.lang.System.currentTimeMillis()
            cz.mobilesoft.appblock.service.lock.UsageLimitCountdown.A = r10
            r6.S()
            r10 = r1
            goto L5b
        L5a:
            r10 = r0
        L5b:
            long r2 = r6.f94960s
            r4 = 0
            int r11 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r11 == 0) goto L6b
            int r7 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r7 != 0) goto L6b
            if (r9 != 0) goto L6b
            if (r12 == 0) goto L6c
        L6b:
            r0 = r1
        L6c:
            cz.mobilesoft.appblock.service.lock.UsageLimitCountdown$ChangeCheckResult r7 = new cz.mobilesoft.appblock.service.lock.UsageLimitCountdown$ChangeCheckResult
            r7.<init>(r0, r9, r10)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.appblock.service.lock.UsageLimitCountdown.m(long, cz.mobilesoft.coreblock.usecase.GetForegroundAppsUseCase$AppsDTO, cz.mobilesoft.coreblock.dto.UrlDto, cz.mobilesoft.coreblock.repository.SubApp, boolean):cz.mobilesoft.appblock.service.lock.UsageLimitCountdown$ChangeCheckResult");
    }

    public final String n(List packageNames, String str, String str2) {
        Object next;
        Intrinsics.checkNotNullParameter(packageNames, "packageNames");
        if (str2 == null) {
            return CollectionsKt.joinToString$default(packageNames, ", ", null, null, 0, null, new Function1() { // from class: cz.mobilesoft.appblock.service.lock.n
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return UsageLimitCountdown.o(this.f95051a, (String) obj);
                }
            }, 30, null);
        }
        Iterator it = packageNames.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (!Intrinsics.areEqual((String) next, str)) {
                break;
            }
        }
        String str3 = (String) next;
        if (str3 != null) {
            String str4 = StringHelper.c(v(), str3) + ", " + str2;
            if (str4 != null) {
                return str4;
            }
        }
        return str2;
    }

    public final EventShowAsType p() {
        return this.f94952k;
    }

    public final Callback q() {
        return this.f94949h;
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }

    public final long u() {
        return this.f94951j;
    }

    public final Function0 w() {
        return this.f94950i;
    }

    public final UsageLimit.PeriodType y() {
        return this.f94955n;
    }

    public final List z() {
        return this.f94953l;
    }
}
