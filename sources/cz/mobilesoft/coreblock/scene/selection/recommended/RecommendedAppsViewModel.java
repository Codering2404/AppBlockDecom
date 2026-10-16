package cz.mobilesoft.coreblock.scene.selection.recommended;

import com.google.android.gms.common.api.Api;
import cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel;
import cz.mobilesoft.coreblock.dto.ApplicationDTO;
import cz.mobilesoft.coreblock.enums.Limit;
import cz.mobilesoft.coreblock.enums.PremiumFeature;
import cz.mobilesoft.coreblock.enums.PremiumState;
import cz.mobilesoft.coreblock.enums.Product;
import cz.mobilesoft.coreblock.repository.PremiumRepositoryV2;
import cz.mobilesoft.coreblock.scene.selection.recommended.RecommendedAppsViewEvent;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.AppWebsiteCategoryDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationDao;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Application;
import cz.mobilesoft.coreblock.util.helperextension.DateHelper;
import cz.mobilesoft.statistics.api.Statistics;
import cz.mobilesoft.statistics.model.AggregatedItemRecord;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlinx.collections.immutable.ExtensionsKt;
import kotlinx.collections.immutable.ImmutableList;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
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
public final class RecommendedAppsViewModel extends BaseStatefulViewModel<RecommendedAppsViewState, RecommendedAppsViewEvent, RecommendedAppsViewCommand> {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final List f119197o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final Lazy f119198p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final Lazy f119199q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final Lazy f119200r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final PremiumFeature f119201s;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.selection.recommended.RecommendedAppsViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.selection.recommended.RecommendedAppsViewModel$1", f = "RecommendedAppsViewModel.kt", l = {38, 45}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f119202a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f119203b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f119204c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        long f119205d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f119206f;

        AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return RecommendedAppsViewModel.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            AnonymousClass1 anonymousClass1;
            List list;
            Object objF = IntrinsicsKt.f();
            int i3 = this.f119206f;
            if (i3 == 0) {
                ResultKt.b(obj);
                ApplicationDao applicationDaoD1 = RecommendedAppsViewModel.this.d1();
                List listG1 = RecommendedAppsViewModel.this.g1();
                this.f119206f = 1;
                obj = applicationDaoD1.a0(listG1, this);
                if (obj == objF) {
                }
                return objF;
            }
            if (i3 != 1) {
                if (i3 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                list = (List) this.f119202a;
                ResultKt.b(obj);
                anonymousClass1 = this;
                RecommendedAppsViewModel.this.l1(list, (List) obj);
                return Unit.f139807a;
            }
            ResultKt.b(obj);
            final RecommendedAppsViewModel recommendedAppsViewModel = RecommendedAppsViewModel.this;
            List listSortedWith = CollectionsKt.sortedWith((Iterable) obj, new Comparator() { // from class: cz.mobilesoft.coreblock.scene.selection.recommended.RecommendedAppsViewModel$1$invokeSuspend$$inlined$sortedBy$1
                @Override // java.util.Comparator
                public final int compare(Object obj2, Object obj3) {
                    return ComparisonsKt.d(Integer.valueOf(recommendedAppsViewModel.g1().indexOf(((Application) obj2).d())), Integer.valueOf(recommendedAppsViewModel.g1().indexOf(((Application) obj3).d())));
                }
            });
            Calendar calendarJ = DateHelper.j();
            long timeInMillis = calendarJ.getTimeInMillis();
            calendarJ.add(3, -1);
            long timeInMillis2 = calendarJ.getTimeInMillis();
            List listG12 = RecommendedAppsViewModel.this.g1();
            this.f119202a = listSortedWith;
            this.f119203b = SpillingKt.a(calendarJ);
            this.f119204c = timeInMillis;
            this.f119205d = timeInMillis2;
            this.f119206f = 2;
            anonymousClass1 = this;
            Object objJ = Statistics.j(listG12, timeInMillis2, timeInMillis, anonymousClass1);
            if (objJ != objF) {
                list = listSortedWith;
                obj = objJ;
                RecommendedAppsViewModel.this.l1(list, (List) obj);
                return Unit.f139807a;
            }
            return objF;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public RecommendedAppsViewModel(android.app.Application application, List recommendedApps) {
        super(application, new RecommendedAppsViewState(null, null, 3, null));
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(recommendedApps, "recommendedApps");
        final Qualifier qualifier = null;
        this.f119197o = recommendedApps;
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f119198p = LazyKt.a(lazyThreadSafetyModeB, new Function0<AppWebsiteCategoryDao>() { // from class: cz.mobilesoft.coreblock.scene.selection.recommended.RecommendedAppsViewModel$special$$inlined$inject$default$1
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
        this.f119199q = LazyKt.a(lazyThreadSafetyModeB2, new Function0<ApplicationDao>() { // from class: cz.mobilesoft.coreblock.scene.selection.recommended.RecommendedAppsViewModel$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(ApplicationDao.class), objArr2, objArr3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB3 = koinPlatformTools.b();
        final Object[] objArr4 = 0 == true ? 1 : 0;
        final Object[] objArr5 = 0 == true ? 1 : 0;
        this.f119200r = LazyKt.a(lazyThreadSafetyModeB3, new Function0<PremiumRepositoryV2>() { // from class: cz.mobilesoft.coreblock.scene.selection.recommended.RecommendedAppsViewModel$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(PremiumRepositoryV2.class), objArr4, objArr5);
            }
        });
        this.f119201s = PremiumFeature.PROFILES_APPS_UNLIMITED;
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass1(null), 3, null);
    }

    public static final /* synthetic */ RecommendedAppsViewState T0(RecommendedAppsViewModel recommendedAppsViewModel) {
        return (RecommendedAppsViewState) recommendedAppsViewModel.I0();
    }

    private final boolean a1(PremiumFeature premiumFeature, int i3) {
        PremiumState premiumStateJ = f1().J();
        Product product = Product.APPLICATIONS;
        if (premiumStateJ.f(product)) {
            return true;
        }
        Limit limit = premiumFeature.getLimit();
        return i3 < (limit != null ? limit.getLimitValue() : product.getLimit());
    }

    private final void b1(boolean z2, boolean z3) {
        G0(new RecommendedAppsViewModel$finishWithApplications$1(this, z3, z2, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AppWebsiteCategoryDao c1() {
        return (AppWebsiteCategoryDao) this.f119198p.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ApplicationDao d1() {
        return (ApplicationDao) this.f119199q.getValue();
    }

    private final boolean e1() {
        PremiumFeature premiumFeature = this.f119201s;
        ImmutableList immutableListC = ((RecommendedAppsViewState) I0()).c();
        int i3 = 0;
        if (immutableListC == null || !immutableListC.isEmpty()) {
            Iterator<E> it = immutableListC.iterator();
            while (it.hasNext()) {
                if (((ApplicationDTO) it.next()).h() && (i3 = i3 + 1) < 0) {
                    CollectionsKt.throwCountOverflow();
                }
            }
        }
        return a1(premiumFeature, i3);
    }

    private final PremiumRepositoryV2 f1() {
        return (PremiumRepositoryV2) this.f119200r.getValue();
    }

    private final void h1() {
        BuildersKt__Builders_commonKt.d(B0(), null, null, new RecommendedAppsViewModel$getWebsitesForSelectedApps$1(this, null), 3, null);
    }

    private final void i1(final ApplicationDTO applicationDTO) {
        if (applicationDTO.h() || e1()) {
            Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.selection.recommended.v
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return RecommendedAppsViewModel.j1(applicationDTO, (RecommendedAppsViewState) obj);
                }
            });
        } else {
            G0(new RecommendedAppsViewModel$onAppSelected$1(this, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RecommendedAppsViewState j1(ApplicationDTO applicationDTO, RecommendedAppsViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        List mutableList = CollectionsKt.toMutableList((Collection) updateState.c());
        Iterator it = mutableList.iterator();
        int i3 = 0;
        while (true) {
            if (!it.hasNext()) {
                i3 = -1;
                break;
            }
            if (Intrinsics.areEqual(((ApplicationDTO) it.next()).f(), applicationDTO.f())) {
                break;
            }
            i3++;
        }
        if (i3 != -1) {
            mutableList.set(i3, ApplicationDTO.b((ApplicationDTO) mutableList.get(i3), null, null, null, !applicationDTO.h(), false, null, null, false, null, 503, null));
        }
        return RecommendedAppsViewState.b(updateState, ExtensionsKt.h(mutableList), null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l1(List list, List list2) {
        LinkedHashMap linkedHashMap;
        AggregatedItemRecord aggregatedItemRecord;
        if (list2 != null) {
            List list3 = list2;
            linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list3, 10)), 16));
            for (Object obj : list3) {
                linkedHashMap.put(((AggregatedItemRecord) obj).e(), obj);
            }
        } else {
            linkedHashMap = null;
        }
        final ArrayList arrayList = new ArrayList();
        Limit limit = this.f119201s.getLimit();
        int iMin = Math.min(limit != null ? limit.getLimitValue() : Api.BaseClientBuilder.API_PRIORITY_OTHER, list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Application application = (Application) it.next();
            arrayList.add(new ApplicationDTO(application.d(), application.b(), null, iMin > 0, true, (linkedHashMap == null || (aggregatedItemRecord = (AggregatedItemRecord) linkedHashMap.get(application.d())) == null) ? null : Integer.valueOf(aggregatedItemRecord.c()), null, false, null, 452, null));
            iMin--;
        }
        Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.selection.recommended.w
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                return RecommendedAppsViewModel.m1(arrayList, (RecommendedAppsViewState) obj2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RecommendedAppsViewState m1(List list, RecommendedAppsViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return RecommendedAppsViewState.b(updateState, ExtensionsKt.h(list), null, 2, null);
    }

    public final List g1() {
        return this.f119197o;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel
    /* JADX INFO: renamed from: k1, reason: merged with bridge method [inline-methods] */
    public void O0(RecommendedAppsViewEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof RecommendedAppsViewEvent.OnAppSelected) {
            i1(((RecommendedAppsViewEvent.OnAppSelected) event).a());
            return;
        }
        if (event instanceof RecommendedAppsViewEvent.FinishWithApplications) {
            RecommendedAppsViewEvent.FinishWithApplications finishWithApplications = (RecommendedAppsViewEvent.FinishWithApplications) event;
            b1(finishWithApplications.a(), finishWithApplications.b());
        } else {
            if (!Intrinsics.areEqual(event, RecommendedAppsViewEvent.SearchWebsitesForSelectedApps.f119196a)) {
                throw new NoWhenBranchMatchedException();
            }
            h1();
        }
    }
}
