package cz.mobilesoft.coreblock.scene.statistics.detail;

import android.app.Application;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import cz.mobilesoft.coreblock.dto.AppWebWrapper;
import cz.mobilesoft.coreblock.dto.UsageAccess;
import cz.mobilesoft.coreblock.enums.StatisticsUsageTypeFilter;
import cz.mobilesoft.coreblock.scene.statistics.BaseStatisticsFragmentViewModel;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationDao;
import cz.mobilesoft.statistics.api.Statistics;
import cz.mobilesoft.statistics.model.AggregatedItemRecord;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
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
public final class StatisticsDetailFragmentViewModel extends BaseStatisticsFragmentViewModel<BaseStatisticsFragmentViewModel.BaseStatisticsFilter> {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final Lazy f119821t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private String f119822u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private Collection f119823v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final MutableLiveData f119824w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final LiveData f119825x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final LiveData f119826y;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f119827a;

        static {
            int[] iArr = new int[StatisticsUsageTypeFilter.values().length];
            try {
                iArr[StatisticsUsageTypeFilter.USAGE_TIME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[StatisticsUsageTypeFilter.LAUNCH_COUNT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[StatisticsUsageTypeFilter.UNLOCKS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f119827a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public StatisticsDetailFragmentViewModel(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        LazyThreadSafetyMode lazyThreadSafetyModeB = KoinPlatformTools.f146106a.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f119821t = LazyKt.a(lazyThreadSafetyModeB, new Function0<ApplicationDao>() { // from class: cz.mobilesoft.coreblock.scene.statistics.detail.StatisticsDetailFragmentViewModel$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(ApplicationDao.class), qualifier, objArr);
            }
        });
        k1(true);
        this.f119824w = new MutableLiveData(new BaseStatisticsFragmentViewModel.BaseStatisticsFilter());
        this.f119825x = Transformations.f(a1(), new Function1() { // from class: cz.mobilesoft.coreblock.scene.statistics.detail.d
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StatisticsDetailFragmentViewModel.C1(this.f119861a, (BaseStatisticsFragmentViewModel.BaseStatisticsFilter) obj);
            }
        });
        this.f119826y = Transformations.d(v1(), new Function1() { // from class: cz.mobilesoft.coreblock.scene.statistics.detail.e
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StatisticsDetailFragmentViewModel.r1(this.f119862a, (List) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LiveData C1(StatisticsDetailFragmentViewModel statisticsDetailFragmentViewModel, BaseStatisticsFragmentViewModel.BaseStatisticsFilter baseStatisticsFilter) {
        if (!baseStatisticsFilter.e()) {
            return new MutableLiveData(CollectionsKt.emptyList());
        }
        List listY1 = statisticsDetailFragmentViewModel.y1();
        statisticsDetailFragmentViewModel.l1();
        return Statistics.f(statisticsDetailFragmentViewModel.w1(listY1), baseStatisticsFilter.b(), baseStatisticsFilter.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List r1(StatisticsDetailFragmentViewModel statisticsDetailFragmentViewModel, List it) {
        Intrinsics.checkNotNullParameter(it, "it");
        List<AggregatedItemRecord> list = it;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (AggregatedItemRecord aggregatedItemRecord : list) {
            arrayList.add(aggregatedItemRecord.g() == UsageAccess.Type.WEBSITE.getTypeId() ? new AppWebWrapper(null, CollectionsKt.arrayListOf(aggregatedItemRecord), statisticsDetailFragmentViewModel.c1(), 1, null) : new AppWebWrapper(aggregatedItemRecord, null, statisticsDetailFragmentViewModel.c1(), 2, null));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ApplicationDao t1() {
        return (ApplicationDao) this.f119821t.getValue();
    }

    private final List w1(List list) {
        List list2 = (List) T0().f();
        if (list2 != null) {
            List list3 = list2;
            if (!list3.isEmpty()) {
                list.removeAll(list3);
            }
        }
        return list;
    }

    public final String A1() {
        return this.f119822u;
    }

    public final void B1(Function1 callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        BuildersKt__Builders_commonKt.d(C0(), null, null, new StatisticsDetailFragmentViewModel$getProfiles$1(this, callback, null), 3, null);
    }

    public final void D1(Collection collection) {
        this.f119823v = collection;
    }

    public final void E1(String str) {
        this.f119822u = str;
    }

    @Override // cz.mobilesoft.coreblock.scene.statistics.BaseStatisticsFragmentViewModel
    public LiveData P0() {
        return this.f119826y;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0266  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x029d  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0312  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    @Override // cz.mobilesoft.coreblock.scene.statistics.BaseStatisticsFragmentViewModel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object S0(kotlin.coroutines.Continuation r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 894
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.statistics.detail.StatisticsDetailFragmentViewModel.S0(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // cz.mobilesoft.coreblock.scene.statistics.BaseStatisticsFragmentViewModel
    public MutableLiveData a1() {
        return this.f119824w;
    }

    public final void s1(String packageName, Function1 callback) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(callback, "callback");
        BuildersKt__Builders_commonKt.d(C0(), null, null, new StatisticsDetailFragmentViewModel$existApplication$1(this, packageName, callback, null), 3, null);
    }

    public final Collection u1() {
        return this.f119823v;
    }

    public LiveData v1() {
        return this.f119825x;
    }

    public final List x1() {
        ArrayList arrayList = new ArrayList();
        String str = this.f119822u;
        if (str != null) {
            arrayList.add(str);
        }
        return arrayList;
    }

    public final List y1() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(x1());
        arrayList.addAll(z1());
        return arrayList;
    }

    public final List z1() {
        ArrayList arrayList = new ArrayList();
        Collection collection = this.f119823v;
        if (collection != null) {
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                arrayList.add((String) it.next());
            }
        }
        return arrayList;
    }
}
