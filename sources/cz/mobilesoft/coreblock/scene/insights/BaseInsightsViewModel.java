package cz.mobilesoft.coreblock.scene.insights;

import android.app.Application;
import cz.mobilesoft.coreblock.LockieApplication;
import cz.mobilesoft.coreblock.base.ViewEvent;
import cz.mobilesoft.coreblock.base.ViewState;
import cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel;
import cz.mobilesoft.coreblock.enums.Limit;
import cz.mobilesoft.coreblock.enums.Product;
import cz.mobilesoft.coreblock.repository.PremiumRepositoryV2;
import cz.mobilesoft.coreblock.scene.strictmode3.followschedules.ScheduleSelectViewState;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationProfileRelationDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.IntervalDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao;
import cz.mobilesoft.coreblock.storage.room.dto.blocking.ProfileWithConfiguration;
import cz.mobilesoft.coreblock.util.UsageAccessHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public abstract class BaseInsightsViewModel<STATE extends ViewState, EVENT extends ViewEvent> extends BaseStatefulViewModel<STATE, EVENT, InsightsViewCommand> {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Lazy f102472o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final Lazy f102473p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final Lazy f102474q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final Lazy f102475r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final Lazy f102476s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f102477t;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public BaseInsightsViewModel(Application application, ViewState initialState) {
        super(application, initialState);
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(initialState, "initialState");
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f102472o = LazyKt.a(lazyThreadSafetyModeB, new Function0<ProfileDao>() { // from class: cz.mobilesoft.coreblock.scene.insights.BaseInsightsViewModel$special$$inlined$inject$default$1
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
        this.f102473p = LazyKt.a(lazyThreadSafetyModeB2, new Function0<IntervalDao>() { // from class: cz.mobilesoft.coreblock.scene.insights.BaseInsightsViewModel$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(IntervalDao.class), objArr2, objArr3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB3 = koinPlatformTools.b();
        final Object[] objArr4 = 0 == true ? 1 : 0;
        final Object[] objArr5 = 0 == true ? 1 : 0;
        this.f102474q = LazyKt.a(lazyThreadSafetyModeB3, new Function0<ApplicationDao>() { // from class: cz.mobilesoft.coreblock.scene.insights.BaseInsightsViewModel$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(ApplicationDao.class), objArr4, objArr5);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB4 = koinPlatformTools.b();
        final Object[] objArr6 = 0 == true ? 1 : 0;
        final Object[] objArr7 = 0 == true ? 1 : 0;
        this.f102475r = LazyKt.a(lazyThreadSafetyModeB4, new Function0<ApplicationProfileRelationDao>() { // from class: cz.mobilesoft.coreblock.scene.insights.BaseInsightsViewModel$special$$inlined$inject$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(ApplicationProfileRelationDao.class), objArr6, objArr7);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB5 = koinPlatformTools.b();
        final Object[] objArr8 = 0 == true ? 1 : 0;
        final Object[] objArr9 = 0 == true ? 1 : 0;
        this.f102476s = LazyKt.a(lazyThreadSafetyModeB5, new Function0<PremiumRepositoryV2>() { // from class: cz.mobilesoft.coreblock.scene.insights.BaseInsightsViewModel$special$$inlined$inject$default$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(PremiumRepositoryV2.class), objArr8, objArr9);
            }
        });
    }

    public static /* synthetic */ void a1(BaseInsightsViewModel baseInsightsViewModel, String str, boolean z2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createNewSchedule");
        }
        if ((i3 & 2) != 0) {
            z2 = false;
        }
        baseInsightsViewModel.Z0(str, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ApplicationDao c1() {
        return (ApplicationDao) this.f102474q.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ApplicationProfileRelationDao d1() {
        return (ApplicationProfileRelationDao) this.f102475r.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IntervalDao e1() {
        return (IntervalDao) this.f102473p.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PremiumRepositoryV2 f1() {
        return (PremiumRepositoryV2) this.f102476s.getValue();
    }

    private final ProfileDao g1() {
        return (ProfileDao) this.f102472o.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o1(BaseInsightsViewModel baseInsightsViewModel, Function1 function1, boolean z2) {
        if (z2) {
            baseInsightsViewModel.G0(new BaseInsightsViewModel$syncUsageAccessThenReload$1$1(function1, null));
        }
        return Unit.f139807a;
    }

    public final boolean Y0(List schedules) {
        Intrinsics.checkNotNullParameter(schedules, "schedules");
        if (f1().J().f(Product.PROFILE)) {
            return true;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : schedules) {
            if (!((ScheduleSelectViewState.ScheduleDto) obj).m()) {
                arrayList.add(obj);
            }
        }
        return arrayList.size() < Limit.PROFILE_LIMIT.getLimitValue();
    }

    public final void Z0(String packageName, boolean z2) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        G0(new BaseInsightsViewModel$createNewSchedule$1(packageName, this, z2, null));
    }

    public boolean b1() {
        return this.f102477t;
    }

    public abstract List h1();

    public abstract boolean i1();

    public final Object j1(String str, Continuation continuation) {
        final Flow flowY0 = g1().Y0();
        Object objCollect = new Flow<List<? extends ProfileWithConfiguration>>() { // from class: cz.mobilesoft.coreblock.scene.insights.BaseInsightsViewModel$loadSchedules$$inlined$map$1

            /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.insights.BaseInsightsViewModel$loadSchedules$$inlined$map$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class AnonymousClass2<T> implements FlowCollector {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ FlowCollector f102487a;

                /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.insights.BaseInsightsViewModel$loadSchedules$$inlined$map$1$2$1, reason: invalid class name */
                @Metadata
                @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.insights.BaseInsightsViewModel$loadSchedules$$inlined$map$1$2", f = "BaseInsightsViewModel.kt", l = {50}, m = "emit", v = 1)
                public static final class AnonymousClass1 extends ContinuationImpl {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    /* synthetic */ Object f102488a;

                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                    int f102489b;

                    /* JADX INFO: renamed from: c, reason: collision with root package name */
                    Object f102490c;

                    /* JADX INFO: renamed from: f, reason: collision with root package name */
                    Object f102492f;

                    /* JADX INFO: renamed from: g, reason: collision with root package name */
                    Object f102493g;

                    /* JADX INFO: renamed from: h, reason: collision with root package name */
                    Object f102494h;

                    /* JADX INFO: renamed from: i, reason: collision with root package name */
                    int f102495i;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.f102488a = obj;
                        this.f102489b |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.f102487a = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r9, kotlin.coroutines.Continuation r10) throws java.lang.Throwable {
                    /*
                        r8 = this;
                        boolean r0 = r10 instanceof cz.mobilesoft.coreblock.scene.insights.BaseInsightsViewModel$loadSchedules$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r10
                        cz.mobilesoft.coreblock.scene.insights.BaseInsightsViewModel$loadSchedules$$inlined$map$1$2$1 r0 = (cz.mobilesoft.coreblock.scene.insights.BaseInsightsViewModel$loadSchedules$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.f102489b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.f102489b = r1
                        goto L18
                    L13:
                        cz.mobilesoft.coreblock.scene.insights.BaseInsightsViewModel$loadSchedules$$inlined$map$1$2$1 r0 = new cz.mobilesoft.coreblock.scene.insights.BaseInsightsViewModel$loadSchedules$$inlined$map$1$2$1
                        r0.<init>(r10)
                    L18:
                        java.lang.Object r10 = r0.f102488a
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                        int r2 = r0.f102489b
                        r3 = 1
                        if (r2 == 0) goto L39
                        if (r2 != r3) goto L31
                        java.lang.Object r9 = r0.f102494h
                        kotlinx.coroutines.flow.FlowCollector r9 = (kotlinx.coroutines.flow.FlowCollector) r9
                        java.lang.Object r9 = r0.f102492f
                        cz.mobilesoft.coreblock.scene.insights.BaseInsightsViewModel$loadSchedules$$inlined$map$1$2$1 r9 = (cz.mobilesoft.coreblock.scene.insights.BaseInsightsViewModel$loadSchedules$$inlined$map$1.AnonymousClass2.AnonymousClass1) r9
                        kotlin.ResultKt.b(r10)
                        goto L91
                    L31:
                        java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                        java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
                        r9.<init>(r10)
                        throw r9
                    L39:
                        kotlin.ResultKt.b(r10)
                        kotlinx.coroutines.flow.FlowCollector r10 = r8.f102487a
                        r2 = r9
                        java.util.List r2 = (java.util.List) r2
                        java.lang.Iterable r2 = (java.lang.Iterable) r2
                        java.util.ArrayList r4 = new java.util.ArrayList
                        r4.<init>()
                        java.util.Iterator r2 = r2.iterator()
                    L4c:
                        boolean r5 = r2.hasNext()
                        if (r5 == 0) goto L6d
                        java.lang.Object r5 = r2.next()
                        r6 = r5
                        cz.mobilesoft.coreblock.storage.room.dto.blocking.ProfileWithConfiguration r6 = (cz.mobilesoft.coreblock.storage.room.dto.blocking.ProfileWithConfiguration) r6
                        cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile r6 = r6.p()
                        int r6 = r6.E()
                        cz.mobilesoft.coreblock.enums.ProfileType r7 = cz.mobilesoft.coreblock.enums.ProfileType.STRICT_MODE
                        int r7 = r7.mask()
                        if (r6 == r7) goto L4c
                        r4.add(r5)
                        goto L4c
                    L6d:
                        java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.a(r9)
                        r0.f102490c = r2
                        java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.a(r0)
                        r0.f102492f = r2
                        java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.a(r9)
                        r0.f102493g = r9
                        java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.a(r10)
                        r0.f102494h = r9
                        r9 = 0
                        r0.f102495i = r9
                        r0.f102489b = r3
                        java.lang.Object r9 = r10.emit(r4, r0)
                        if (r9 != r1) goto L91
                        return r1
                    L91:
                        kotlin.Unit r9 = kotlin.Unit.f139807a
                        return r9
                    */
                    throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.insights.BaseInsightsViewModel$loadSchedules$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector flowCollector, Continuation continuation2) {
                Object objCollect2 = flowY0.collect(new AnonymousClass2(flowCollector), continuation2);
                return objCollect2 == IntrinsicsKt.f() ? objCollect2 : Unit.f139807a;
            }
        }.collect(new BaseInsightsViewModel$loadSchedules$3(this, str), continuation);
        return objCollect == IntrinsicsKt.f() ? objCollect : Unit.f139807a;
    }

    public final void k1(int i3) {
        G0(new BaseInsightsViewModel$onScheduleClicked$1(this, i3, null));
    }

    public final void l1() {
        G0(new BaseInsightsViewModel$resetSelectedSchedules$1(this, null));
    }

    public void m1(boolean z2) {
        this.f102477t = z2;
    }

    protected final void n1(final Function1 onSynced) {
        Intrinsics.checkNotNullParameter(onSynced, "onSynced");
        UsageAccessHelper.s(A0(), new Function1() { // from class: cz.mobilesoft.coreblock.scene.insights.a
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BaseInsightsViewModel.o1(this.f102956a, onSynced, ((Boolean) obj).booleanValue());
            }
        }, null, 4, null);
    }

    public abstract void p1(List list);

    public final void q1(boolean z2, String packageName) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        List listH1 = h1();
        if (Intrinsics.areEqual(packageName, LockieApplication.f95360f) && !z2) {
            List<ScheduleSelectViewState.ScheduleDto> list = listH1;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                for (ScheduleSelectViewState.ScheduleDto scheduleDto : list) {
                    if (scheduleDto.j() && !scheduleDto.i()) {
                        G0(new BaseInsightsViewModel$updateSchedules$2(this, null));
                        return;
                    }
                }
            }
        }
        G0(new BaseInsightsViewModel$updateSchedules$3(listH1, this, packageName, null));
    }
}
