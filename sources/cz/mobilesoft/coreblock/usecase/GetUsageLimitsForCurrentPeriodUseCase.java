package cz.mobilesoft.coreblock.usecase;

import cz.mobilesoft.coreblock.dto.UrlDto;
import cz.mobilesoft.coreblock.repository.SubApp;
import cz.mobilesoft.coreblock.storage.datastore.CoreMultiProcessDataStore;
import cz.mobilesoft.coreblock.storage.datastore.EventDataStore;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.AdultContentWebsiteDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.UsageLimitDao;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.UsageLimit;
import cz.mobilesoft.coreblock.usecase.UseCase;
import cz.mobilesoft.coreblock.util.helperextension.CoroutinesHelperExtKt;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class GetUsageLimitsForCurrentPeriodUseCase extends UseCase<Params, List<? extends UsageLimit>> implements KoinComponent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CoroutineScope f127131a = CoroutineScopeKt.a(Dispatchers.b().plus(SupervisorKt.b(null, 1, null)).plus(CoroutinesHelperExtKt.b()));

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Lazy f127132b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Lazy f127133c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Lazy f127134d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Lazy f127135f;

    /* JADX WARN: Multi-variable type inference failed */
    public GetUsageLimitsForCurrentPeriodUseCase() {
        final Qualifier qualifier = null;
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f127132b = LazyKt.a(lazyThreadSafetyModeB, new Function0<CoreMultiProcessDataStore>() { // from class: cz.mobilesoft.coreblock.usecase.GetUsageLimitsForCurrentPeriodUseCase$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(CoreMultiProcessDataStore.class), qualifier, objArr);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB2 = koinPlatformTools.b();
        final Object[] objArr2 = 0 == true ? 1 : 0;
        final Object[] objArr3 = 0 == true ? 1 : 0;
        this.f127133c = LazyKt.a(lazyThreadSafetyModeB2, new Function0<EventDataStore>() { // from class: cz.mobilesoft.coreblock.usecase.GetUsageLimitsForCurrentPeriodUseCase$special$$inlined$inject$default$2
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
        this.f127134d = LazyKt.a(lazyThreadSafetyModeB3, new Function0<UsageLimitDao>() { // from class: cz.mobilesoft.coreblock.usecase.GetUsageLimitsForCurrentPeriodUseCase$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(UsageLimitDao.class), objArr4, objArr5);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB4 = koinPlatformTools.b();
        final Object[] objArr6 = 0 == true ? 1 : 0;
        final Object[] objArr7 = 0 == true ? 1 : 0;
        this.f127135f = LazyKt.a(lazyThreadSafetyModeB4, new Function0<AdultContentWebsiteDao>() { // from class: cz.mobilesoft.coreblock.usecase.GetUsageLimitsForCurrentPeriodUseCase$special$$inlined$inject$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(AdultContentWebsiteDao.class), objArr6, objArr7);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AdultContentWebsiteDao e() {
        return (AdultContentWebsiteDao) this.f127135f.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x0100  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final kotlin.Pair f(java.util.Collection r11, long r12, long r14, java.util.Collection r16, cz.mobilesoft.coreblock.dto.UrlDto r17, cz.mobilesoft.coreblock.repository.SubApp r18) {
        /*
            Method dump skipped, instruction units count: 572
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.usecase.GetUsageLimitsForCurrentPeriodUseCase.f(java.util.Collection, long, long, java.util.Collection, cz.mobilesoft.coreblock.dto.UrlDto, cz.mobilesoft.coreblock.repository.SubApp):kotlin.Pair");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CoreMultiProcessDataStore g() {
        return (CoreMultiProcessDataStore) this.f127132b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final EventDataStore h() {
        return (EventDataStore) this.f127133c.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final UsageLimitDao i() {
        return (UsageLimitDao) this.f127134d.getValue();
    }

    public List j(Params params) {
        Intrinsics.checkNotNullParameter(params, "params");
        long jG0 = g().g0(UsageLimit.PeriodType.DAILY, ((Number) BuildersKt__BuildersKt.b(null, new GetUsageLimitsForCurrentPeriodUseCase$invoke$dayBeginningHour$1(this, null), 1, null)).intValue());
        long jG02 = g().g0(UsageLimit.PeriodType.HOURLY, -1);
        List listB = params.b();
        Pair pairF = f(listB, jG02, jG0, params.a(), params.d(), params.c());
        List list = (List) pairF.a();
        List list2 = (List) pairF.b();
        if (!list2.isEmpty()) {
            BuildersKt__Builders_commonKt.d(this.f127131a, null, null, new GetUsageLimitsForCurrentPeriodUseCase$invoke$1(this, list2, null), 3, null);
        }
        return list;
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Params implements UseCase.Params {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List f127136a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List f127137b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final UrlDto f127138c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final SubApp f127139d;

        public Params(List profiles, List list, UrlDto urlDto, SubApp subApp) {
            Intrinsics.checkNotNullParameter(profiles, "profiles");
            this.f127136a = profiles;
            this.f127137b = list;
            this.f127138c = urlDto;
            this.f127139d = subApp;
        }

        public final List a() {
            return this.f127137b;
        }

        public final List b() {
            return this.f127136a;
        }

        public final SubApp c() {
            return this.f127139d;
        }

        public final UrlDto d() {
            return this.f127138c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Params)) {
                return false;
            }
            Params params = (Params) obj;
            return Intrinsics.areEqual(this.f127136a, params.f127136a) && Intrinsics.areEqual(this.f127137b, params.f127137b) && Intrinsics.areEqual(this.f127138c, params.f127138c) && Intrinsics.areEqual(this.f127139d, params.f127139d);
        }

        public int hashCode() {
            int iHashCode = this.f127136a.hashCode() * 31;
            List list = this.f127137b;
            int iHashCode2 = (iHashCode + (list == null ? 0 : list.hashCode())) * 31;
            UrlDto urlDto = this.f127138c;
            int iHashCode3 = (iHashCode2 + (urlDto == null ? 0 : urlDto.hashCode())) * 31;
            SubApp subApp = this.f127139d;
            return iHashCode3 + (subApp != null ? subApp.hashCode() : 0);
        }

        public String toString() {
            return "Params(profiles=" + this.f127136a + ", packageNames=" + this.f127137b + ", url=" + this.f127138c + ", subApp=" + this.f127139d + ")";
        }

        public /* synthetic */ Params(List list, List list2, UrlDto urlDto, SubApp subApp, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(list, (i3 & 2) != 0 ? null : list2, (i3 & 4) != 0 ? null : urlDto, (i3 & 8) != 0 ? null : subApp);
        }
    }
}
