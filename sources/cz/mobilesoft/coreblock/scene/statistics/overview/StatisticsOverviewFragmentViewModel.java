package cz.mobilesoft.coreblock.scene.statistics.overview;

import android.app.Application;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import cz.mobilesoft.coreblock.dto.UsageAccess;
import cz.mobilesoft.coreblock.enums.StatisticsRecordType;
import cz.mobilesoft.coreblock.enums.StatisticsTimeFilter;
import cz.mobilesoft.coreblock.enums.StatisticsUsageTypeFilter;
import cz.mobilesoft.coreblock.repository.StrictModeRepository;
import cz.mobilesoft.coreblock.scene.statistics.BaseStatisticsFragmentViewModel;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.AppWebsiteCategoryDao;
import cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager;
import cz.mobilesoft.coreblock.util.helperextension.LiveDataExtKt;
import cz.mobilesoft.statistics.api.Statistics;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__BuildersKt;
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
public final class StatisticsOverviewFragmentViewModel extends BaseStatisticsFragmentViewModel<BaseStatisticsFragmentViewModel.BaseStatisticsFilter> {
    private final LiveData A;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final Lazy f120054t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final Lazy f120055u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private StatisticsTimeFilter f120056v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private StatisticsUsageTypeFilter f120057w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final Lazy f120058x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final MutableLiveData f120059y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final LiveData f120060z;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f120061a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f120062b;

        static {
            int[] iArr = new int[StatisticsRecordType.values().length];
            try {
                iArr[StatisticsRecordType.ALL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[StatisticsRecordType.APPS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[StatisticsRecordType.WEBS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f120061a = iArr;
            int[] iArr2 = new int[StatisticsUsageTypeFilter.values().length];
            try {
                iArr2[StatisticsUsageTypeFilter.USAGE_TIME.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[StatisticsUsageTypeFilter.LAUNCH_COUNT.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[StatisticsUsageTypeFilter.UNLOCKS.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            f120062b = iArr2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public StatisticsOverviewFragmentViewModel(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f120054t = LazyKt.a(lazyThreadSafetyModeB, new Function0<AppWebsiteCategoryDao>() { // from class: cz.mobilesoft.coreblock.scene.statistics.overview.StatisticsOverviewFragmentViewModel$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(AppWebsiteCategoryDao.class), qualifier, objArr);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB2 = koinPlatformTools.b();
        final Object[] objArr2 = 0 == true ? 1 : 0;
        final Object[] objArr3 = 0 == true ? 1 : 0;
        this.f120055u = LazyKt.a(lazyThreadSafetyModeB2, new Function0<StrictModeRepository>() { // from class: cz.mobilesoft.coreblock.scene.statistics.overview.StatisticsOverviewFragmentViewModel$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(StrictModeRepository.class), objArr2, objArr3);
            }
        });
        StatisticsTimeFilter.Companion companion = StatisticsTimeFilter.Companion;
        PrefManager prefManager = PrefManager.f126839a;
        this.f120056v = companion.a(prefManager.z0());
        this.f120057w = StatisticsUsageTypeFilter.Companion.a(prefManager.A0());
        this.f120058x = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.scene.statistics.overview.j
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return StatisticsOverviewFragmentViewModel.r1(this.f120093a);
            }
        });
        this.f120059y = new MutableLiveData(new BaseStatisticsFragmentViewModel.BaseStatisticsFilter());
        this.f120060z = Transformations.f(a1(), new Function1() { // from class: cz.mobilesoft.coreblock.scene.statistics.overview.k
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StatisticsOverviewFragmentViewModel.x1(this.f120094a, (BaseStatisticsFragmentViewModel.BaseStatisticsFilter) obj);
            }
        });
        this.A = LiveDataExtKt.e(u1(), C0(), new StatisticsOverviewFragmentViewModel$appsWebsList$1(this, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map r1(StatisticsOverviewFragmentViewModel statisticsOverviewFragmentViewModel) {
        return (Map) BuildersKt__BuildersKt.b(null, new StatisticsOverviewFragmentViewModel$appWebRelations$2$1(statisticsOverviewFragmentViewModel, null), 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map s1() {
        return (Map) this.f120058x.getValue();
    }

    private final StrictModeRepository t0() {
        return (StrictModeRepository) this.f120055u.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AppWebsiteCategoryDao t1() {
        return (AppWebsiteCategoryDao) this.f120054t.getValue();
    }

    private final Set v1(BaseStatisticsFragmentViewModel.BaseStatisticsFilter baseStatisticsFilter) {
        int i3 = WhenMappings.f120061a[baseStatisticsFilter.c().ordinal()];
        if (i3 == 1) {
            return SetsKt.setOf((Object[]) new Integer[]{Integer.valueOf(UsageAccess.Type.APPLICATION.getTypeId()), Integer.valueOf(UsageAccess.Type.WEBSITE.getTypeId())});
        }
        if (i3 == 2) {
            return SetsKt.setOf(Integer.valueOf(UsageAccess.Type.APPLICATION.getTypeId()));
        }
        if (i3 == 3) {
            return SetsKt.setOf(Integer.valueOf(UsageAccess.Type.WEBSITE.getTypeId()));
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LiveData x1(StatisticsOverviewFragmentViewModel statisticsOverviewFragmentViewModel, BaseStatisticsFragmentViewModel.BaseStatisticsFilter baseStatisticsFilter) {
        if (!baseStatisticsFilter.e()) {
            return new MutableLiveData(CollectionsKt.emptyList());
        }
        if (baseStatisticsFilter.d() == StatisticsUsageTypeFilter.UNLOCKS) {
            statisticsOverviewFragmentViewModel.l1();
            return new MutableLiveData(CollectionsKt.emptyList());
        }
        Intrinsics.checkNotNull(baseStatisticsFilter);
        Set setV1 = statisticsOverviewFragmentViewModel.v1(baseStatisticsFilter);
        statisticsOverviewFragmentViewModel.l1();
        return Statistics.e(setV1, (List) statisticsOverviewFragmentViewModel.T0().f(), baseStatisticsFilter.b(), baseStatisticsFilter.a());
    }

    @Override // cz.mobilesoft.coreblock.scene.statistics.BaseStatisticsFragmentViewModel
    public LiveData P0() {
        return this.A;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0256  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x02b5  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x02fd  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0391  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    @Override // cz.mobilesoft.coreblock.scene.statistics.BaseStatisticsFragmentViewModel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object S0(kotlin.coroutines.Continuation r23) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 1038
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.statistics.overview.StatisticsOverviewFragmentViewModel.S0(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // cz.mobilesoft.coreblock.scene.statistics.BaseStatisticsFragmentViewModel
    public MutableLiveData a1() {
        return this.f120059y;
    }

    @Override // cz.mobilesoft.coreblock.scene.statistics.BaseStatisticsFragmentViewModel
    public StatisticsTimeFilter b1() {
        return this.f120056v;
    }

    @Override // cz.mobilesoft.coreblock.scene.statistics.BaseStatisticsFragmentViewModel
    public StatisticsUsageTypeFilter c1() {
        return this.f120057w;
    }

    @Override // cz.mobilesoft.coreblock.scene.statistics.BaseStatisticsFragmentViewModel
    public void i1(StatisticsTimeFilter value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.f120056v = value;
        PrefManager.f126839a.c2(value.getFilterId());
    }

    @Override // cz.mobilesoft.coreblock.scene.statistics.BaseStatisticsFragmentViewModel
    public void j1(StatisticsUsageTypeFilter value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.f120057w = value;
        BaseStatisticsFragmentViewModel.BaseStatisticsFilter baseStatisticsFilter = (BaseStatisticsFragmentViewModel.BaseStatisticsFilter) a1().f();
        if (baseStatisticsFilter != null) {
            baseStatisticsFilter.i(value);
        }
        a1().p(a1().f());
        PrefManager.f126839a.d2(value.getFilterId());
    }

    public LiveData u1() {
        return this.f120060z;
    }

    public final Object w1(Continuation continuation) {
        return Boxing.a(t0().n());
    }
}
