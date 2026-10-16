package cz.mobilesoft.coreblock.scene.schedule.condition.launchcount;

import android.app.Application;
import cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel;
import cz.mobilesoft.coreblock.enums.Product;
import cz.mobilesoft.coreblock.repository.PremiumRepositoryV2;
import cz.mobilesoft.coreblock.repository.StrictModeRepository;
import cz.mobilesoft.coreblock.scene.schedule.condition.ConditionDTO;
import cz.mobilesoft.coreblock.scene.schedule.condition.IntervalDTO;
import cz.mobilesoft.coreblock.scene.schedule.condition.launchcount.LaunchCountConditionViewEvent;
import cz.mobilesoft.coreblock.scene.schedule.condition.launchcount.LaunchCountConditionViewModel;
import cz.mobilesoft.coreblock.scene.schedule.condition.time.LaunchCountConditionConfigurationViewState;
import cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionConfigurationViewState;
import cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionHandler;
import cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionViewEvent;
import cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionViewModelKt;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.UsageLimit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import org.koin.core.component.KoinComponent;
import org.koin.core.component.KoinScopeComponent;
import org.koin.core.qualifier.Qualifier;
import org.koin.mp.KoinPlatformTools;
import org.threeten.bp.DayOfWeek;

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
public final class LaunchCountConditionViewModel extends BaseStatefulViewModel<LaunchCountConditionViewState, LaunchCountConditionViewEvent, LaunchCountConditionViewCommand> implements TimeConditionHandler {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Long f115239o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final boolean f115240p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final PremiumRepositoryV2 f115241q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final Lazy f115242r;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.schedule.condition.launchcount.LaunchCountConditionViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.schedule.condition.launchcount.LaunchCountConditionViewModel$1", f = "LaunchCountConditionViewModel.kt", l = {66}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f115243a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ConditionDTO.LaunchCountDTO f115244b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ LaunchCountConditionViewModel f115245c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ConditionDTO.LaunchCountDTO launchCountDTO, LaunchCountConditionViewModel launchCountConditionViewModel, Continuation continuation) {
            super(2, continuation);
            this.f115244b = launchCountDTO;
            this.f115245c = launchCountConditionViewModel;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final LaunchCountConditionViewState q(boolean z2, LaunchCountConditionViewState launchCountConditionViewState) {
            return LaunchCountConditionViewState.b(launchCountConditionViewState, false, z2, null, null, 13, null);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.f115244b, this.f115245c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f115243a;
            if (i3 == 0) {
                ResultKt.b(obj);
                if (this.f115244b != null) {
                    StrictModeRepository strictModeRepositoryT0 = this.f115245c.t0();
                    Long lW = this.f115245c.w();
                    this.f115243a = 1;
                    obj = strictModeRepositoryT0.q(lW, this);
                    if (obj == objF) {
                        return objF;
                    }
                }
                this.f115245c.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.launchcount.h0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return LaunchCountConditionViewModel.AnonymousClass1.q(z, (LaunchCountConditionViewState) obj2);
                    }
                });
                return Unit.f139807a;
            }
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            final boolean z2 = ((Boolean) obj).booleanValue();
            this.f115245c.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.launchcount.h0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return LaunchCountConditionViewModel.AnonymousClass1.q(z2, (LaunchCountConditionViewState) obj2);
                }
            });
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    public LaunchCountConditionViewModel(Application application, ConditionDTO.LaunchCountDTO launchCountDTO, Long l3, boolean z2, PremiumRepositoryV2 premiumRepository) {
        UsageLimit.PeriodType periodTypeG;
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(premiumRepository, "premiumRepository");
        final Qualifier qualifier = null;
        Object[] objArr = 0;
        super(application, new LaunchCountConditionViewState(z2, false, TimeConditionViewModelKt.b(application, launchCountDTO != null ? launchCountDTO.i() : null, premiumRepository.J().g(), (launchCountDTO != null ? launchCountDTO.i() : null) == null, premiumRepository.J().f(Product.TIMES)), new LaunchCountConditionConfigurationViewState(launchCountDTO != null ? launchCountDTO.e() : 10L, launchCountDTO != null ? launchCountDTO.f() : null, launchCountDTO != null ? launchCountDTO.j() : 0L, premiumRepository.J().f(Product.LAUNCH_COUNT), (launchCountDTO == null || (periodTypeG = launchCountDTO.g()) == null) ? UsageLimit.PeriodType.DAILY : periodTypeG), 2, null));
        this.f115239o = l3;
        this.f115240p = z2;
        this.f115241q = premiumRepository;
        LazyThreadSafetyMode lazyThreadSafetyModeB = KoinPlatformTools.f146106a.b();
        final Object[] objArr2 = objArr == true ? 1 : 0;
        this.f115242r = LazyKt.a(lazyThreadSafetyModeB, new Function0<StrictModeRepository>() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.launchcount.LaunchCountConditionViewModel$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(StrictModeRepository.class), qualifier, objArr2);
            }
        });
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass1(launchCountDTO, this, null), 3, null);
    }

    public static final /* synthetic */ LaunchCountConditionViewState U0(LaunchCountConditionViewModel launchCountConditionViewModel) {
        return (LaunchCountConditionViewState) launchCountConditionViewModel.I0();
    }

    private final void X0(TimeConditionViewEvent timeConditionViewEvent) {
        if (timeConditionViewEvent instanceof TimeConditionViewEvent.OnDayCheckedChanged) {
            TimeConditionViewEvent.OnDayCheckedChanged onDayCheckedChanged = (TimeConditionViewEvent.OnDayCheckedChanged) timeConditionViewEvent;
            f(onDayCheckedChanged.b(), onDayCheckedChanged.a());
            return;
        }
        if (timeConditionViewEvent instanceof TimeConditionViewEvent.OnIntervalRemoveClicked) {
            a0(((TimeConditionViewEvent.OnIntervalRemoveClicked) timeConditionViewEvent).a());
            return;
        }
        if (Intrinsics.areEqual(timeConditionViewEvent, TimeConditionViewEvent.OnAddIntervalClicked.f115749a)) {
            x();
            return;
        }
        if (timeConditionViewEvent instanceof TimeConditionViewEvent.OnIntervalClicked) {
            p0(((TimeConditionViewEvent.OnIntervalClicked) timeConditionViewEvent).a());
            return;
        }
        if (timeConditionViewEvent instanceof TimeConditionViewEvent.OnIntervalSet) {
            TimeConditionViewEvent.OnIntervalSet onIntervalSet = (TimeConditionViewEvent.OnIntervalSet) timeConditionViewEvent;
            g(onIntervalSet.b(), onIntervalSet.a(), onIntervalSet.c());
        } else if (timeConditionViewEvent instanceof TimeConditionViewEvent.OnAllDayLongCheckedChanged) {
            y(((TimeConditionViewEvent.OnAllDayLongCheckedChanged) timeConditionViewEvent).a());
        } else if (Intrinsics.areEqual(timeConditionViewEvent, TimeConditionViewEvent.OnDismissTimeRangePickerBottomSheet.f115754a)) {
            m();
        } else if (!Intrinsics.areEqual(timeConditionViewEvent, TimeConditionViewEvent.OnCloseClicked.f115751a) && !Intrinsics.areEqual(timeConditionViewEvent, TimeConditionViewEvent.OnSaveClicked.f115760a)) {
            throw new NoWhenBranchMatchedException();
        }
    }

    private final void Y0() {
        BuildersKt__Builders_commonKt.d(B0(), null, null, new LaunchCountConditionViewModel$onCloseClicked$1(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LaunchCountConditionViewState a1(LaunchCountConditionViewEvent launchCountConditionViewEvent, LaunchCountConditionViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return LaunchCountConditionViewState.b(updateState, false, false, null, LaunchCountConditionConfigurationViewState.e(updateState.c(), RangesKt.g(updateState.c().f() + ((long) ((LaunchCountConditionViewEvent.OnLaunchCountChanged) launchCountConditionViewEvent).a()), 0L), null, 0L, false, null, 30, null), 7, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LaunchCountConditionViewState b1(LaunchCountConditionViewEvent launchCountConditionViewEvent, LaunchCountConditionViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return LaunchCountConditionViewState.b(updateState, false, false, null, LaunchCountConditionConfigurationViewState.e(updateState.c(), 0L, null, 0L, false, ((LaunchCountConditionViewEvent.OnPeriodTypeChanged) launchCountConditionViewEvent).a(), 15, null), 7, null);
    }

    private final void c1() {
        LaunchCountConditionViewState launchCountConditionViewState = (LaunchCountConditionViewState) I0();
        ConditionDTO.TimeDTO timeDTOB = launchCountConditionViewState.d().b();
        if (timeDTOB == null) {
            h0();
        } else {
            BuildersKt__Builders_commonKt.d(B0(), null, null, new LaunchCountConditionViewModel$onSaveClicked$1(this, ConditionDTO.LaunchCountDTO.d(launchCountConditionViewState.c().b(), 0L, null, 0L, null, timeDTOB, 15, null), null), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LaunchCountConditionViewState d1(TimeConditionConfigurationViewState timeConditionConfigurationViewState, LaunchCountConditionViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return LaunchCountConditionViewState.b(updateState, false, false, timeConditionConfigurationViewState, null, 11, null);
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionHandler
    public boolean O() {
        return ((LaunchCountConditionViewState) I0()).g();
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionHandler
    public boolean X() {
        return this.f115240p;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel
    /* JADX INFO: renamed from: Z0, reason: merged with bridge method [inline-methods] */
    public void O0(final LaunchCountConditionViewEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (Intrinsics.areEqual(event, LaunchCountConditionViewEvent.OnCloseClicked.f115235a)) {
            Y0();
            return;
        }
        if (event instanceof LaunchCountConditionViewEvent.OnLaunchCountChanged) {
            if (((LaunchCountConditionViewState) I0()).g() && ((LaunchCountConditionViewEvent.OnLaunchCountChanged) event).a() > 0) {
                LaunchCountConditionConfigurationViewState launchCountConditionConfigurationViewStateC = ((LaunchCountConditionViewState) I0()).c();
                if (launchCountConditionConfigurationViewStateC.l(launchCountConditionConfigurationViewStateC.f() + 1)) {
                    G0(new LaunchCountConditionViewModel$onEvent$2(this, null));
                    return;
                }
            }
            Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.launchcount.e0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return LaunchCountConditionViewModel.a1(event, (LaunchCountConditionViewState) obj);
                }
            });
            return;
        }
        if (event instanceof LaunchCountConditionViewEvent.LaunchCountTimeConditionViewEvent) {
            X0(((LaunchCountConditionViewEvent.LaunchCountTimeConditionViewEvent) event).a());
            return;
        }
        if (!(event instanceof LaunchCountConditionViewEvent.OnPeriodTypeChanged)) {
            if (!Intrinsics.areEqual(event, LaunchCountConditionViewEvent.OnSaveClicked.f115238a)) {
                throw new NoWhenBranchMatchedException();
            }
            c1();
        } else {
            LaunchCountConditionViewState launchCountConditionViewState = (LaunchCountConditionViewState) I0();
            if (!launchCountConditionViewState.g() || launchCountConditionViewState.c().h() == null) {
                Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.launchcount.f0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return LaunchCountConditionViewModel.b1(event, (LaunchCountConditionViewState) obj);
                    }
                });
            } else {
                G0(new LaunchCountConditionViewModel$onEvent$4(this, null));
            }
        }
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionHandler
    public /* bridge */ void a0(IntervalDTO intervalDTO) {
        super.a0(intervalDTO);
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionHandler
    public void c(int i3) {
        G0(new LaunchCountConditionViewModel$onShowSnackbar$1(this, i3, null));
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionHandler
    public /* bridge */ void f(boolean z2, DayOfWeek dayOfWeek) {
        super.f(z2, dayOfWeek);
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionHandler
    public /* bridge */ void g(IntervalDTO intervalDTO, long j3, long j4) {
        super.g(intervalDTO, j3, j4);
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionHandler
    public CoroutineScope getScope() {
        return B0();
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionHandler
    public /* bridge */ void h0() {
        super.h0();
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionHandler
    public boolean isPremium() {
        return this.f115241q.J().g();
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionHandler
    public /* bridge */ void m() {
        super.m();
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionHandler
    public void n0(final TimeConditionConfigurationViewState newState) {
        Intrinsics.checkNotNullParameter(newState, "newState");
        Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.launchcount.g0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LaunchCountConditionViewModel.d1(newState, (LaunchCountConditionViewState) obj);
            }
        });
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionHandler
    public /* bridge */ void p(IntervalDTO intervalDTO) {
        super.p(intervalDTO);
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionHandler
    public /* bridge */ void p0(IntervalDTO intervalDTO) {
        super.p0(intervalDTO);
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionHandler
    public StrictModeRepository t0() {
        return (StrictModeRepository) this.f115242r.getValue();
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionHandler
    public Long w() {
        return this.f115239o;
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionHandler
    public /* bridge */ void x() {
        super.x();
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionHandler
    public TimeConditionConfigurationViewState x0() {
        return ((LaunchCountConditionViewState) I0()).d();
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionHandler
    public /* bridge */ void y(boolean z2) {
        super.y(z2);
    }
}
