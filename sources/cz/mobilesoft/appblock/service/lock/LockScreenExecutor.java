package cz.mobilesoft.appblock.service.lock;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import cz.mobilesoft.appblock.activity.LockActivityV2;
import cz.mobilesoft.coreblock.dto.UrlDto;
import cz.mobilesoft.coreblock.enums.ProfileType;
import cz.mobilesoft.coreblock.repository.SubApp;
import cz.mobilesoft.coreblock.storage.datastore.EventDataStore;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.BlockSessionDao;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.UsageLimit;
import cz.mobilesoft.coreblock.usecase.GetForegroundAppsUseCase;
import cz.mobilesoft.coreblock.util.CrashHelper;
import cz.mobilesoft.coreblock.util.helperextension.CoroutinesHelperExtKt;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
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
public final class LockScreenExecutor implements KoinComponent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CoroutineScope f94770a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Lazy f94771b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Lazy f94772c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Lazy f94773d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class LockRequest {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final GetForegroundAppsUseCase.AppsDTO f94774a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f94775b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final UrlDto f94776c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final SubApp f94777d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final List f94778e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final boolean f94779f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final boolean f94780g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final boolean f94781h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final String f94782i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final Set f94783j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private final UsageLimit.PeriodType f94784k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private final Function0 f94785l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private final Function1 f94786m;

        public LockRequest(GetForegroundAppsUseCase.AppsDTO foregroundApps, String packageName, UrlDto urlDto, SubApp subApp, List profiles, boolean z2, boolean z3, boolean z4, String str, Set excludedBrowsers, UsageLimit.PeriodType periodType, Function0 onUsageLimitPeriodTypeReset, Function1 pauseMediaPlayback) {
            Intrinsics.checkNotNullParameter(foregroundApps, "foregroundApps");
            Intrinsics.checkNotNullParameter(packageName, "packageName");
            Intrinsics.checkNotNullParameter(profiles, "profiles");
            Intrinsics.checkNotNullParameter(excludedBrowsers, "excludedBrowsers");
            Intrinsics.checkNotNullParameter(onUsageLimitPeriodTypeReset, "onUsageLimitPeriodTypeReset");
            Intrinsics.checkNotNullParameter(pauseMediaPlayback, "pauseMediaPlayback");
            this.f94774a = foregroundApps;
            this.f94775b = packageName;
            this.f94776c = urlDto;
            this.f94777d = subApp;
            this.f94778e = profiles;
            this.f94779f = z2;
            this.f94780g = z3;
            this.f94781h = z4;
            this.f94782i = str;
            this.f94783j = excludedBrowsers;
            this.f94784k = periodType;
            this.f94785l = onUsageLimitPeriodTypeReset;
            this.f94786m = pauseMediaPlayback;
        }

        public final Set a() {
            return this.f94783j;
        }

        public final GetForegroundAppsUseCase.AppsDTO b() {
            return this.f94774a;
        }

        public final Function0 c() {
            return this.f94785l;
        }

        public final String d() {
            return this.f94775b;
        }

        public final Function1 e() {
            return this.f94786m;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof LockRequest)) {
                return false;
            }
            LockRequest lockRequest = (LockRequest) obj;
            return Intrinsics.areEqual(this.f94774a, lockRequest.f94774a) && Intrinsics.areEqual(this.f94775b, lockRequest.f94775b) && Intrinsics.areEqual(this.f94776c, lockRequest.f94776c) && Intrinsics.areEqual(this.f94777d, lockRequest.f94777d) && Intrinsics.areEqual(this.f94778e, lockRequest.f94778e) && this.f94779f == lockRequest.f94779f && this.f94780g == lockRequest.f94780g && this.f94781h == lockRequest.f94781h && Intrinsics.areEqual(this.f94782i, lockRequest.f94782i) && Intrinsics.areEqual(this.f94783j, lockRequest.f94783j) && this.f94784k == lockRequest.f94784k && Intrinsics.areEqual(this.f94785l, lockRequest.f94785l) && Intrinsics.areEqual(this.f94786m, lockRequest.f94786m);
        }

        public final String f() {
            return this.f94782i;
        }

        public final List g() {
            return this.f94778e;
        }

        public final SubApp h() {
            return this.f94777d;
        }

        public int hashCode() {
            int iHashCode = ((this.f94774a.hashCode() * 31) + this.f94775b.hashCode()) * 31;
            UrlDto urlDto = this.f94776c;
            int iHashCode2 = (iHashCode + (urlDto == null ? 0 : urlDto.hashCode())) * 31;
            SubApp subApp = this.f94777d;
            int iHashCode3 = (((((((((iHashCode2 + (subApp == null ? 0 : subApp.hashCode())) * 31) + this.f94778e.hashCode()) * 31) + Boolean.hashCode(this.f94779f)) * 31) + Boolean.hashCode(this.f94780g)) * 31) + Boolean.hashCode(this.f94781h)) * 31;
            String str = this.f94782i;
            int iHashCode4 = (((iHashCode3 + (str == null ? 0 : str.hashCode())) * 31) + this.f94783j.hashCode()) * 31;
            UsageLimit.PeriodType periodType = this.f94784k;
            return ((((iHashCode4 + (periodType != null ? periodType.hashCode() : 0)) * 31) + this.f94785l.hashCode()) * 31) + this.f94786m.hashCode();
        }

        public final UrlDto i() {
            return this.f94776c;
        }

        public final UsageLimit.PeriodType j() {
            return this.f94784k;
        }

        public final boolean k() {
            return this.f94780g;
        }

        public final boolean l() {
            return this.f94781h;
        }

        public final boolean m() {
            return this.f94779f;
        }

        public String toString() {
            return "LockRequest(foregroundApps=" + this.f94774a + ", packageName=" + this.f94775b + ", url=" + this.f94776c + ", subApp=" + this.f94777d + ", profiles=" + this.f94778e + ", isPopup=" + this.f94779f + ", isFloatingWindowBlockingEnabled=" + this.f94780g + ", isFloatingWindowCollapseEnabled=" + this.f94781h + ", previouslyCheckedPackage=" + this.f94782i + ", excludedBrowsers=" + this.f94783j + ", usageLimitPeriodType=" + this.f94784k + ", onUsageLimitPeriodTypeReset=" + this.f94785l + ", pauseMediaPlayback=" + this.f94786m + ")";
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LockScreenExecutor(CoroutineScope ioScope) {
        Intrinsics.checkNotNullParameter(ioScope, "ioScope");
        this.f94770a = ioScope;
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f94771b = LazyKt.a(lazyThreadSafetyModeB, new Function0<Context>() { // from class: cz.mobilesoft.appblock.service.lock.LockScreenExecutor$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(Context.class), qualifier, objArr);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB2 = koinPlatformTools.b();
        final Object[] objArr2 = 0 == true ? 1 : 0;
        final Object[] objArr3 = 0 == true ? 1 : 0;
        this.f94772c = LazyKt.a(lazyThreadSafetyModeB2, new Function0<EventDataStore>() { // from class: cz.mobilesoft.appblock.service.lock.LockScreenExecutor$special$$inlined$inject$default$2
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
        this.f94773d = LazyKt.a(lazyThreadSafetyModeB3, new Function0<BlockSessionDao>() { // from class: cz.mobilesoft.appblock.service.lock.LockScreenExecutor$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(BlockSessionDao.class), objArr4, objArr5);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BlockSessionDao e() {
        return (BlockSessionDao) this.f94773d.getValue();
    }

    private final Context f() {
        return (Context) this.f94771b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final EventDataStore g() {
        return (EventDataStore) this.f94772c.getValue();
    }

    private final void h() {
        CoroutinesHelperExtKt.d(new LockScreenExecutor$goBackAndCloseApp$1(this, null));
    }

    private final void i() {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: cz.mobilesoft.appblock.service.lock.b
            @Override // java.lang.Runnable
            public final void run() {
                LockScreenExecutor.j(this.f95026a);
            }
        }, 50L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(LockScreenExecutor lockScreenExecutor) {
        lockScreenExecutor.k();
    }

    private final void k() {
        CoroutinesHelperExtKt.d(new LockScreenExecutor$goHomeUsingAccessibility$1(this, null));
    }

    private final void l(String str) {
        BuildersKt__Builders_commonKt.d(this.f94770a, null, null, new LockScreenExecutor$insertBlockSession$1(this, str, null), 3, null);
    }

    private final void n(String str) {
        CoroutinesHelperExtKt.d(new LockScreenExecutor$requestFloatingWindowCollapse$1(this, str, null));
    }

    private final void p(String str, Long l3, ProfileType profileType, String str2, UsageLimit.PeriodType periodType) {
        q(LockActivityV2.f93943g.a(f(), str, l3, profileType, str2, periodType));
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:143|(1:145)(3:147|(12:149|(1:151)|152|154|(1:156)(2:158|(1:160)(8:161|162|163|180|164|169|(1:173)|174))|157|162|163|180|164|169|(3:171|173|174)(0))|153)|146|154|(0)(0)|157|162|163|180|164|169|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x032c, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x032d, code lost:
    
        r3 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x032e, code lost:
    
        cz.mobilesoft.coreblock.util.CrashHelper.j(r0);
        p(r24.d(), r3, r4, r5, r24.j());
     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x02fb A[Catch: SecurityException -> 0x02b0, TryCatch #2 {SecurityException -> 0x02b0, blocks: (B:132:0x0291, B:134:0x02a3, B:140:0x02b5, B:143:0x02cd, B:145:0x02d7, B:154:0x02f1, B:156:0x02fb, B:162:0x031d, B:158:0x0309, B:160:0x030f, B:147:0x02dc, B:149:0x02e2, B:153:0x02ee), top: B:182:0x0291 }] */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0309 A[Catch: SecurityException -> 0x02b0, TryCatch #2 {SecurityException -> 0x02b0, blocks: (B:132:0x0291, B:134:0x02a3, B:140:0x02b5, B:143:0x02cd, B:145:0x02d7, B:154:0x02f1, B:156:0x02fb, B:162:0x031d, B:158:0x0309, B:160:0x030f, B:147:0x02dc, B:149:0x02e2, B:153:0x02ee), top: B:182:0x0291 }] */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0342  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0348  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x009f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:206:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0179  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void d(cz.mobilesoft.appblock.service.lock.LockScreenExecutor.LockRequest r24) {
        /*
            Method dump skipped, instruction units count: 875
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.appblock.service.lock.LockScreenExecutor.d(cz.mobilesoft.appblock.service.lock.LockScreenExecutor$LockRequest):void");
    }

    public final void m(LockRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        if (request.h() != null) {
            return;
        }
        request.e().invoke(request.d());
    }

    public final void o(LockRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        if (request.h() != null) {
            return;
        }
        CoroutinesHelperExtKt.d(new LockScreenExecutor$requestPipDismiss$1(this, request, null));
    }

    public final void q(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        try {
            f().startActivity(intent);
        } catch (ActivityNotFoundException e3) {
            CrashHelper.j(e3);
        }
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }
}
