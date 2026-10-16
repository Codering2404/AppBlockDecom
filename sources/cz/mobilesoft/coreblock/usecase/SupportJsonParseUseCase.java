package cz.mobilesoft.coreblock.usecase;

import android.content.Context;
import cz.mobilesoft.coreblock.repository.DiagnosticRepository;
import cz.mobilesoft.coreblock.repository.QuickBlockRepository;
import cz.mobilesoft.coreblock.storage.datastore.CoreMultiProcessDataStore;
import cz.mobilesoft.coreblock.storage.datastore.QuickBlockDataStore;
import cz.mobilesoft.coreblock.storage.datastore.StrictModeDataStore;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationProfileRelationDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.GeoAddressDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.UsageLimitDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.WebsiteProfileRelationDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.WifiNetworkDao;
import cz.mobilesoft.coreblock.storage.room.management.BlockingDatabase;
import cz.mobilesoft.coreblock.usecase.FlowUseCase;
import cz.mobilesoft.coreblock.util.DataState;
import cz.mobilesoft.coreblock.util.runnability.JobHelperKtx;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
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
public final class SupportJsonParseUseCase extends FlowUseCase<Params, DataState<? extends Boolean>> implements KoinComponent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f127330a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Lazy f127331b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Lazy f127332c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Lazy f127333d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Lazy f127334f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Lazy f127335g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Lazy f127336h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Lazy f127337i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Lazy f127338j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Lazy f127339k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Lazy f127340l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final Lazy f127341m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Lazy f127342n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Lazy f127343o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final Lazy f127344p;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Params implements FlowUseCase.Params {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f127345a;

        public Params(String json) {
            Intrinsics.checkNotNullParameter(json, "json");
            this.f127345a = json;
        }

        public final String a() {
            return this.f127345a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Params) && Intrinsics.areEqual(this.f127345a, ((Params) obj).f127345a);
        }

        public int hashCode() {
            return this.f127345a.hashCode();
        }

        public String toString() {
            return "Params(json=" + this.f127345a + ")";
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SupportJsonParseUseCase(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f127330a = context;
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f127331b = LazyKt.a(lazyThreadSafetyModeB, new Function0<ProfileDao>() { // from class: cz.mobilesoft.coreblock.usecase.SupportJsonParseUseCase$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(ProfileDao.class), qualifier, objArr);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB2 = koinPlatformTools.b();
        final Object[] objArr2 = 0 == true ? 1 : 0;
        final Object[] objArr3 = 0 == true ? 1 : 0;
        this.f127332c = LazyKt.a(lazyThreadSafetyModeB2, new Function0<UsageLimitDao>() { // from class: cz.mobilesoft.coreblock.usecase.SupportJsonParseUseCase$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(UsageLimitDao.class), objArr2, objArr3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB3 = koinPlatformTools.b();
        final Object[] objArr4 = 0 == true ? 1 : 0;
        final Object[] objArr5 = 0 == true ? 1 : 0;
        this.f127333d = LazyKt.a(lazyThreadSafetyModeB3, new Function0<GeoAddressDao>() { // from class: cz.mobilesoft.coreblock.usecase.SupportJsonParseUseCase$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(GeoAddressDao.class), objArr4, objArr5);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB4 = koinPlatformTools.b();
        final Object[] objArr6 = 0 == true ? 1 : 0;
        final Object[] objArr7 = 0 == true ? 1 : 0;
        this.f127334f = LazyKt.a(lazyThreadSafetyModeB4, new Function0<ApplicationDao>() { // from class: cz.mobilesoft.coreblock.usecase.SupportJsonParseUseCase$special$$inlined$inject$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(ApplicationDao.class), objArr6, objArr7);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB5 = koinPlatformTools.b();
        final Object[] objArr8 = 0 == true ? 1 : 0;
        final Object[] objArr9 = 0 == true ? 1 : 0;
        this.f127335g = LazyKt.a(lazyThreadSafetyModeB5, new Function0<ApplicationProfileRelationDao>() { // from class: cz.mobilesoft.coreblock.usecase.SupportJsonParseUseCase$special$$inlined$inject$default$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(ApplicationProfileRelationDao.class), objArr8, objArr9);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB6 = koinPlatformTools.b();
        final Object[] objArr10 = 0 == true ? 1 : 0;
        final Object[] objArr11 = 0 == true ? 1 : 0;
        this.f127336h = LazyKt.a(lazyThreadSafetyModeB6, new Function0<WebsiteProfileRelationDao>() { // from class: cz.mobilesoft.coreblock.usecase.SupportJsonParseUseCase$special$$inlined$inject$default$6
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(WebsiteProfileRelationDao.class), objArr10, objArr11);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB7 = koinPlatformTools.b();
        final Object[] objArr12 = 0 == true ? 1 : 0;
        final Object[] objArr13 = 0 == true ? 1 : 0;
        this.f127337i = LazyKt.a(lazyThreadSafetyModeB7, new Function0<WifiNetworkDao>() { // from class: cz.mobilesoft.coreblock.usecase.SupportJsonParseUseCase$special$$inlined$inject$default$7
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(WifiNetworkDao.class), objArr12, objArr13);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB8 = koinPlatformTools.b();
        final Object[] objArr14 = 0 == true ? 1 : 0;
        final Object[] objArr15 = 0 == true ? 1 : 0;
        this.f127338j = LazyKt.a(lazyThreadSafetyModeB8, new Function0<QuickBlockDataStore>() { // from class: cz.mobilesoft.coreblock.usecase.SupportJsonParseUseCase$special$$inlined$inject$default$8
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(QuickBlockDataStore.class), objArr14, objArr15);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB9 = koinPlatformTools.b();
        final Object[] objArr16 = 0 == true ? 1 : 0;
        final Object[] objArr17 = 0 == true ? 1 : 0;
        this.f127339k = LazyKt.a(lazyThreadSafetyModeB9, new Function0<QuickBlockRepository>() { // from class: cz.mobilesoft.coreblock.usecase.SupportJsonParseUseCase$special$$inlined$inject$default$9
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(QuickBlockRepository.class), objArr16, objArr17);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB10 = koinPlatformTools.b();
        final Object[] objArr18 = 0 == true ? 1 : 0;
        final Object[] objArr19 = 0 == true ? 1 : 0;
        this.f127340l = LazyKt.a(lazyThreadSafetyModeB10, new Function0<BlockingDatabase>() { // from class: cz.mobilesoft.coreblock.usecase.SupportJsonParseUseCase$special$$inlined$inject$default$10
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(BlockingDatabase.class), objArr18, objArr19);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB11 = koinPlatformTools.b();
        final Object[] objArr20 = 0 == true ? 1 : 0;
        final Object[] objArr21 = 0 == true ? 1 : 0;
        this.f127341m = LazyKt.a(lazyThreadSafetyModeB11, new Function0<DiagnosticRepository>() { // from class: cz.mobilesoft.coreblock.usecase.SupportJsonParseUseCase$special$$inlined$inject$default$11
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(DiagnosticRepository.class), objArr20, objArr21);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB12 = koinPlatformTools.b();
        final Object[] objArr22 = 0 == true ? 1 : 0;
        final Object[] objArr23 = 0 == true ? 1 : 0;
        this.f127342n = LazyKt.a(lazyThreadSafetyModeB12, new Function0<CoreMultiProcessDataStore>() { // from class: cz.mobilesoft.coreblock.usecase.SupportJsonParseUseCase$special$$inlined$inject$default$12
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(CoreMultiProcessDataStore.class), objArr22, objArr23);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB13 = koinPlatformTools.b();
        final Object[] objArr24 = 0 == true ? 1 : 0;
        final Object[] objArr25 = 0 == true ? 1 : 0;
        this.f127343o = LazyKt.a(lazyThreadSafetyModeB13, new Function0<StrictModeDataStore>() { // from class: cz.mobilesoft.coreblock.usecase.SupportJsonParseUseCase$special$$inlined$inject$default$13
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(StrictModeDataStore.class), objArr24, objArr25);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB14 = koinPlatformTools.b();
        final Object[] objArr26 = 0 == true ? 1 : 0;
        final Object[] objArr27 = 0 == true ? 1 : 0;
        this.f127344p = LazyKt.a(lazyThreadSafetyModeB14, new Function0<JobHelperKtx>() { // from class: cz.mobilesoft.coreblock.usecase.SupportJsonParseUseCase$special$$inlined$inject$default$14
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(JobHelperKtx.class), objArr26, objArr27);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final UsageLimitDao A() {
        return (UsageLimitDao) this.f127332c.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final WebsiteProfileRelationDao B() {
        return (WebsiteProfileRelationDao) this.f127336h.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final WifiNetworkDao C() {
        return (WifiNetworkDao) this.f127337i.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ApplicationDao p() {
        return (ApplicationDao) this.f127334f.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ApplicationProfileRelationDao q() {
        return (ApplicationProfileRelationDao) this.f127335g.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BlockingDatabase r() {
        return (BlockingDatabase) this.f127340l.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CoreMultiProcessDataStore s() {
        return (CoreMultiProcessDataStore) this.f127342n.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DiagnosticRepository t() {
        return (DiagnosticRepository) this.f127341m.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GeoAddressDao u() {
        return (GeoAddressDao) this.f127333d.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JobHelperKtx v() {
        return (JobHelperKtx) this.f127344p.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ProfileDao w() {
        return (ProfileDao) this.f127331b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final QuickBlockDataStore x() {
        return (QuickBlockDataStore) this.f127338j.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final QuickBlockRepository y() {
        return (QuickBlockRepository) this.f127339k.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StrictModeDataStore z() {
        return (StrictModeDataStore) this.f127343o.getValue();
    }

    public Flow D(Params params) {
        Intrinsics.checkNotNullParameter(params, "params");
        return FlowKt.j(new SupportJsonParseUseCase$invoke$1(this, params, null));
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }
}
