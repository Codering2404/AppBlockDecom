package cz.mobilesoft.coreblock.scene.statistics;

import android.app.Application;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import cz.mobilesoft.coreblock.base.viewmodel.BaseViewModel;
import cz.mobilesoft.coreblock.enums.Product;
import cz.mobilesoft.coreblock.enums.StatisticsRecordType;
import cz.mobilesoft.coreblock.enums.StatisticsTimeFilter;
import cz.mobilesoft.coreblock.enums.StatisticsUsageTypeFilter;
import cz.mobilesoft.coreblock.repository.PremiumRepositoryV2;
import cz.mobilesoft.coreblock.scene.statistics.BaseStatisticsFragmentViewModel.BaseStatisticsFilter;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao;
import cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao;
import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__BuildersKt;
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
public abstract class BaseStatisticsFragmentViewModel<F extends BaseStatisticsFilter> extends BaseViewModel {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Lazy f119626i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private StatisticsTimeFilter f119627j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private StatisticsUsageTypeFilter f119628k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Lazy f119629l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final Lazy f119630m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f119631n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final MutableLiveData f119632o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final MutableLiveData f119633p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final MutableLiveData f119634q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final MutableLiveData f119635r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private Long f119636s;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static class BaseStatisticsFilter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f119637a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f119638b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private StatisticsUsageTypeFilter f119639c = StatisticsUsageTypeFilter.USAGE_TIME;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private StatisticsRecordType f119640d = StatisticsRecordType.ALL;

        public final long a() {
            return this.f119638b;
        }

        public final long b() {
            return this.f119637a;
        }

        public final StatisticsRecordType c() {
            return this.f119640d;
        }

        public final StatisticsUsageTypeFilter d() {
            return this.f119639c;
        }

        public final boolean e() {
            return (this.f119637a == 0 || this.f119638b == 0) ? false : true;
        }

        public final void f(long j3) {
            this.f119638b = j3;
        }

        public final void g(long j3) {
            this.f119637a = j3;
        }

        public final void h(StatisticsRecordType statisticsRecordType) {
            Intrinsics.checkNotNullParameter(statisticsRecordType, "<set-?>");
            this.f119640d = statisticsRecordType;
        }

        public final void i(StatisticsUsageTypeFilter statisticsUsageTypeFilter) {
            Intrinsics.checkNotNullParameter(statisticsUsageTypeFilter, "<set-?>");
            this.f119639c = statisticsUsageTypeFilter;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public BaseStatisticsFragmentViewModel(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f119626i = LazyKt.a(lazyThreadSafetyModeB, new Function0<PremiumRepositoryV2>() { // from class: cz.mobilesoft.coreblock.scene.statistics.BaseStatisticsFragmentViewModel$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(PremiumRepositoryV2.class), qualifier, objArr);
            }
        });
        this.f119627j = StatisticsTimeFilter.WEEK;
        this.f119628k = StatisticsUsageTypeFilter.USAGE_TIME;
        LazyThreadSafetyMode lazyThreadSafetyModeB2 = koinPlatformTools.b();
        final Object[] objArr2 = 0 == true ? 1 : 0;
        final Object[] objArr3 = 0 == true ? 1 : 0;
        this.f119629l = LazyKt.a(lazyThreadSafetyModeB2, new Function0<IgnoredStatisticsItemDao>() { // from class: cz.mobilesoft.coreblock.scene.statistics.BaseStatisticsFragmentViewModel$special$$inlined$inject$default$2
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
        this.f119630m = LazyKt.a(lazyThreadSafetyModeB3, new Function0<ProfileDao>() { // from class: cz.mobilesoft.coreblock.scene.statistics.BaseStatisticsFragmentViewModel$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(ProfileDao.class), objArr4, objArr5);
            }
        });
        this.f119632o = new MutableLiveData(BuildersKt__BuildersKt.b(null, new BaseStatisticsFragmentViewModel$_ignoredItems$1(this, null), 1, null));
        this.f119633p = new MutableLiveData(new StatisticsIntervalConfig());
        this.f119634q = new MutableLiveData();
        this.f119635r = new MutableLiveData(null);
        e1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IgnoredStatisticsItemDao W0() {
        return (IgnoredStatisticsItemDao) this.f119629l.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object X0(java.lang.String r9, cz.mobilesoft.coreblock.dto.UsageAccess.Type r10, kotlin.coroutines.Continuation r11) throws java.lang.Throwable {
        /*
            r8 = this;
            boolean r0 = r11 instanceof cz.mobilesoft.coreblock.scene.statistics.BaseStatisticsFragmentViewModel$getItemSourceType$1
            if (r0 == 0) goto L14
            r0 = r11
            cz.mobilesoft.coreblock.scene.statistics.BaseStatisticsFragmentViewModel$getItemSourceType$1 r0 = (cz.mobilesoft.coreblock.scene.statistics.BaseStatisticsFragmentViewModel$getItemSourceType$1) r0
            int r1 = r0.f119649f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.f119649f = r1
        L12:
            r5 = r0
            goto L1a
        L14:
            cz.mobilesoft.coreblock.scene.statistics.BaseStatisticsFragmentViewModel$getItemSourceType$1 r0 = new cz.mobilesoft.coreblock.scene.statistics.BaseStatisticsFragmentViewModel$getItemSourceType$1
            r0.<init>(r8, r11)
            goto L12
        L1a:
            java.lang.Object r11 = r5.f119647c
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r5.f119649f
            r2 = 1
            if (r1 == 0) goto L3b
            if (r1 != r2) goto L33
            java.lang.Object r9 = r5.f119646b
            cz.mobilesoft.coreblock.dto.UsageAccess$Type r9 = (cz.mobilesoft.coreblock.dto.UsageAccess.Type) r9
            java.lang.Object r9 = r5.f119645a
            java.lang.String r9 = (java.lang.String) r9
            kotlin.ResultKt.b(r11)
            goto L5c
        L33:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L3b:
            kotlin.ResultKt.b(r11)
            cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao r1 = r8.W0()
            java.lang.Object r11 = kotlin.coroutines.jvm.internal.SpillingKt.a(r9)
            r5.f119645a = r11
            java.lang.Object r11 = kotlin.coroutines.jvm.internal.SpillingKt.a(r10)
            r5.f119646b = r11
            r5.f119649f = r2
            r4 = 0
            r6 = 4
            r7 = 0
            r2 = r9
            r3 = r10
            java.lang.Object r11 = cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao.W(r1, r2, r3, r4, r5, r6, r7)
            if (r11 != r0) goto L5c
            return r0
        L5c:
            cz.mobilesoft.coreblock.storage.room.entity.core.IgnoredStatisticsItem r11 = (cz.mobilesoft.coreblock.storage.room.entity.core.IgnoredStatisticsItem) r11
            if (r11 == 0) goto L68
            cz.mobilesoft.coreblock.storage.room.entity.core.IgnoredStatisticsItem$ItemSourceType r9 = r11.b()
            if (r9 != 0) goto L67
            goto L68
        L67:
            return r9
        L68:
            cz.mobilesoft.coreblock.storage.room.entity.core.IgnoredStatisticsItem$ItemSourceType r9 = cz.mobilesoft.coreblock.storage.room.entity.core.IgnoredStatisticsItem.ItemSourceType.CUSTOM
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.statistics.BaseStatisticsFragmentViewModel.X0(java.lang.String, cz.mobilesoft.coreblock.dto.UsageAccess$Type, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final PremiumRepositoryV2 Y0() {
        return (PremiumRepositoryV2) this.f119626i.getValue();
    }

    private final void e1() {
        BuildersKt__Builders_commonKt.d(C0(), null, null, new BaseStatisticsFragmentViewModel$init$1(this, null), 3, null);
    }

    public final void N0() {
        BaseStatisticsFilter baseStatisticsFilter = (BaseStatisticsFilter) a1().f();
        if (baseStatisticsFilter != null) {
            if (baseStatisticsFilter.e()) {
                a1().n(baseStatisticsFilter);
            } else {
                e1();
            }
        }
    }

    public final List O0() {
        return (List) BuildersKt__BuildersKt.b(null, new BaseStatisticsFragmentViewModel$getActiveCustomIgnoredStatisticsItems$1(this, null), 1, null);
    }

    public abstract LiveData P0();

    public final MutableLiveData Q0() {
        return this.f119635r;
    }

    public final MutableLiveData R0() {
        return this.f119634q;
    }

    public abstract Object S0(Continuation continuation);

    public final LiveData T0() {
        return this.f119632o;
    }

    public final Object U0(Continuation continuation) {
        return W0().P(continuation);
    }

    public final LiveData V0() {
        return this.f119633p;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final ProfileDao Z0() {
        return (ProfileDao) this.f119630m.getValue();
    }

    public abstract MutableLiveData a1();

    public StatisticsTimeFilter b1() {
        return this.f119627j;
    }

    public StatisticsUsageTypeFilter c1() {
        return this.f119628k;
    }

    public final void d1(Collection items) {
        Intrinsics.checkNotNullParameter(items, "items");
        BuildersKt__Builders_commonKt.d(C0(), null, null, new BaseStatisticsFragmentViewModel$ignoreStatisticsItems$1(items, this, null), 3, null);
    }

    public final boolean f1() {
        return Y0().J().f(Product.STATISTICS);
    }

    public final boolean g1() {
        return this.f119631n;
    }

    public final void h1() {
        Long l3 = this.f119636s;
        if (l3 != null) {
            if (System.currentTimeMillis() > l3.longValue()) {
                e1();
            }
        }
    }

    public void i1(StatisticsTimeFilter statisticsTimeFilter) {
        Intrinsics.checkNotNullParameter(statisticsTimeFilter, "<set-?>");
        this.f119627j = statisticsTimeFilter;
    }

    public void j1(StatisticsUsageTypeFilter value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.f119628k = value;
        BaseStatisticsFilter baseStatisticsFilter = (BaseStatisticsFilter) a1().f();
        if (baseStatisticsFilter != null) {
            baseStatisticsFilter.i(value);
        }
        a1().p(a1().f());
    }

    public final void k1(boolean z2) {
        this.f119631n = z2;
    }

    public void l1() {
        BuildersKt__Builders_commonKt.d(C0(), null, null, new BaseStatisticsFragmentViewModel$updateHeader$1(this, null), 3, null);
    }

    public final void m1() {
        BuildersKt__Builders_commonKt.d(C0(), null, null, new BaseStatisticsFragmentViewModel$updateIgnoredItems$1(this, null), 3, null);
    }
}
