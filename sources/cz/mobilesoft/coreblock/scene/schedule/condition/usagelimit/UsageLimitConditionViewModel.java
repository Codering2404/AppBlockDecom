package cz.mobilesoft.coreblock.scene.schedule.condition.usagelimit;

import android.app.Application;
import cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel;
import cz.mobilesoft.coreblock.enums.Product;
import cz.mobilesoft.coreblock.repository.PremiumRepositoryV2;
import cz.mobilesoft.coreblock.repository.StrictModeRepository;
import cz.mobilesoft.coreblock.scene.schedule.condition.ConditionDTO;
import cz.mobilesoft.coreblock.scene.schedule.condition.IntervalDTO;
import cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionConfigurationViewState;
import cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionHandler;
import cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionViewEvent;
import cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionViewModelKt;
import cz.mobilesoft.coreblock.scene.schedule.condition.time.UsageLimitConfigurationViewState;
import cz.mobilesoft.coreblock.scene.schedule.condition.usagelimit.UsageLimitConditionViewEvent;
import cz.mobilesoft.coreblock.scene.schedule.condition.usagelimit.UsageLimitConditionViewModel;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.UsageLimit;
import cz.mobilesoft.coreblock.view.timepicker.TimePickerConfig;
import cz.mobilesoft.coreblock.view.timepicker.TimePickerHelperKt;
import cz.mobilesoft.coreblock.view.timepicker.TimePickerState;
import java.util.concurrent.TimeUnit;
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
public final class UsageLimitConditionViewModel extends BaseStatefulViewModel<UsageLimitConditionViewState, UsageLimitConditionViewEvent, UsageLimitConditionViewCommand> implements TimeConditionHandler {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Long f115886o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final boolean f115887p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final PremiumRepositoryV2 f115888q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final Lazy f115889r;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.schedule.condition.usagelimit.UsageLimitConditionViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.schedule.condition.usagelimit.UsageLimitConditionViewModel$1", f = "UsageLimitConditionViewModel.kt", l = {79}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f115890a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ConditionDTO.UsageLimitDTO f115891b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ UsageLimitConditionViewModel f115892c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ConditionDTO.UsageLimitDTO usageLimitDTO, UsageLimitConditionViewModel usageLimitConditionViewModel, Continuation continuation) {
            super(2, continuation);
            this.f115891b = usageLimitDTO;
            this.f115892c = usageLimitConditionViewModel;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final UsageLimitConditionViewState q(boolean z2, UsageLimitConditionViewState usageLimitConditionViewState) {
            return UsageLimitConditionViewState.b(usageLimitConditionViewState, z2, false, null, null, 14, null);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.f115891b, this.f115892c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f115890a;
            if (i3 == 0) {
                ResultKt.b(obj);
                if (this.f115891b != null) {
                    StrictModeRepository strictModeRepositoryT0 = this.f115892c.t0();
                    Long lW = this.f115892c.w();
                    this.f115890a = 1;
                    obj = strictModeRepositoryT0.q(lW, this);
                    if (obj == objF) {
                        return objF;
                    }
                }
                this.f115892c.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.usagelimit.b0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return UsageLimitConditionViewModel.AnonymousClass1.q(z, (UsageLimitConditionViewState) obj2);
                    }
                });
                return Unit.f139807a;
            }
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            final boolean z2 = ((Boolean) obj).booleanValue();
            this.f115892c.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.usagelimit.b0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return UsageLimitConditionViewModel.AnonymousClass1.q(z2, (UsageLimitConditionViewState) obj2);
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
    public UsageLimitConditionViewModel(Application application, ConditionDTO.UsageLimitDTO usageLimitDTO, Long l3, boolean z2, PremiumRepositoryV2 premiumRepository) {
        UsageLimit.PeriodType periodTypeG;
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(premiumRepository, "premiumRepository");
        final Qualifier qualifier = null;
        Object[] objArr = 0;
        TimeConditionConfigurationViewState timeConditionConfigurationViewStateB = TimeConditionViewModelKt.b(application, usageLimitDTO != null ? usageLimitDTO.i() : null, premiumRepository.J().g(), (usageLimitDTO != null ? usageLimitDTO.i() : null) == null, premiumRepository.J().f(Product.TIMES));
        TimePickerState timePickerStateB = TimePickerHelperKt.b((usageLimitDTO != null ? usageLimitDTO.g() : null) == UsageLimit.PeriodType.HOURLY ? new TimePickerConfig(new TimePickerConfig.TimePickerType.Minutes(0L, 0L, 3, null), null, null, false, null, false, 62, null) : TimePickerConfig.f133036h.b(), usageLimitDTO != null ? usageLimitDTO.e() : TimeUnit.MINUTES.toMillis(15L));
        super(application, new UsageLimitConditionViewState(false, z2, timeConditionConfigurationViewStateB, new UsageLimitConfigurationViewState(usageLimitDTO != null ? usageLimitDTO.f() : null, usageLimitDTO != null ? usageLimitDTO.j() : 0L, premiumRepository.J().f(Product.USAGE_LIMIT), (usageLimitDTO == null || (periodTypeG = usageLimitDTO.g()) == null) ? UsageLimit.PeriodType.DAILY : periodTypeG, timePickerStateB), 1, null));
        this.f115886o = l3;
        this.f115887p = z2;
        this.f115888q = premiumRepository;
        LazyThreadSafetyMode lazyThreadSafetyModeB = KoinPlatformTools.f146106a.b();
        final Object[] objArr2 = objArr == true ? 1 : 0;
        this.f115889r = LazyKt.a(lazyThreadSafetyModeB, new Function0<StrictModeRepository>() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.usagelimit.UsageLimitConditionViewModel$special$$inlined$inject$default$1
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
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass1(usageLimitDTO, this, null), 3, null);
    }

    public static final /* synthetic */ UsageLimitConditionViewState U0(UsageLimitConditionViewModel usageLimitConditionViewModel) {
        return (UsageLimitConditionViewState) usageLimitConditionViewModel.I0();
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
        BuildersKt__Builders_commonKt.d(B0(), null, null, new UsageLimitConditionViewModel$onCloseClicked$1(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final UsageLimitConditionViewState a1(UsageLimitConditionViewEvent usageLimitConditionViewEvent, UsageLimitConditionViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return UsageLimitConditionViewState.b(updateState, false, false, null, UsageLimitConfigurationViewState.e(updateState.e(), null, 0L, false, null, ((UsageLimitConditionViewEvent.OnTimePickerStateChanged) usageLimitConditionViewEvent).a(), 15, null), 7, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final UsageLimitConditionViewState b1(UsageLimitConditionViewEvent usageLimitConditionViewEvent, UsageLimitConditionViewState usageLimitConditionViewState, UsageLimitConditionViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        UsageLimitConditionViewEvent.OnPeriodTypeChanged onPeriodTypeChanged = (UsageLimitConditionViewEvent.OnPeriodTypeChanged) usageLimitConditionViewEvent;
        return UsageLimitConditionViewState.b(updateState, false, false, null, UsageLimitConfigurationViewState.e(updateState.e(), null, 0L, false, onPeriodTypeChanged.a(), onPeriodTypeChanged.a() == UsageLimit.PeriodType.DAILY ? TimePickerHelperKt.b(TimePickerConfig.f133036h.b(), usageLimitConditionViewState.e().i().s()) : TimePickerHelperKt.b(new TimePickerConfig(new TimePickerConfig.TimePickerType.Minutes(0L, 0L, 3, null), null, null, false, null, false, 62, null), usageLimitConditionViewState.e().i().n()), 7, null), 7, null);
    }

    private final void c1() {
        UsageLimitConditionViewState usageLimitConditionViewState = (UsageLimitConditionViewState) I0();
        ConditionDTO.TimeDTO timeDTOB = usageLimitConditionViewState.d().b();
        if (timeDTOB == null) {
            h0();
        } else {
            BuildersKt__Builders_commonKt.d(B0(), null, null, new UsageLimitConditionViewModel$onSaveClicked$1(this, ConditionDTO.UsageLimitDTO.d(usageLimitConditionViewState.e().b(), 0L, null, 0L, null, timeDTOB, 15, null), null), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final UsageLimitConditionViewState d1(TimeConditionConfigurationViewState timeConditionConfigurationViewState, UsageLimitConditionViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return UsageLimitConditionViewState.b(updateState, false, false, timeConditionConfigurationViewState, null, 11, null);
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionHandler
    public boolean O() {
        return ((UsageLimitConditionViewState) I0()).g();
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionHandler
    public boolean X() {
        return this.f115887p;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel
    /* JADX INFO: renamed from: Z0, reason: merged with bridge method [inline-methods] */
    public void O0(final UsageLimitConditionViewEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (Intrinsics.areEqual(event, UsageLimitConditionViewEvent.OnCloseClicked.f115881a)) {
            Y0();
            return;
        }
        if (event instanceof UsageLimitConditionViewEvent.OnTimePickerStateChanged) {
            UsageLimitConditionViewState usageLimitConditionViewState = (UsageLimitConditionViewState) I0();
            if (usageLimitConditionViewState.g() && usageLimitConditionViewState.e().l(((UsageLimitConditionViewEvent.OnTimePickerStateChanged) event).a().s())) {
                G0(new UsageLimitConditionViewModel$onEvent$1(this, null));
                return;
            } else {
                Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.usagelimit.y
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return UsageLimitConditionViewModel.a1(event, (UsageLimitConditionViewState) obj);
                    }
                });
                return;
            }
        }
        if (event instanceof UsageLimitConditionViewEvent.UsageLimitTimeConditionViewEvent) {
            X0(((UsageLimitConditionViewEvent.UsageLimitTimeConditionViewEvent) event).a());
            return;
        }
        if (!(event instanceof UsageLimitConditionViewEvent.OnPeriodTypeChanged)) {
            if (!Intrinsics.areEqual(event, UsageLimitConditionViewEvent.OnSaveClicked.f115883a)) {
                throw new NoWhenBranchMatchedException();
            }
            c1();
        } else {
            final UsageLimitConditionViewState usageLimitConditionViewState2 = (UsageLimitConditionViewState) I0();
            if (!usageLimitConditionViewState2.g() || usageLimitConditionViewState2.e().g() == null) {
                Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.usagelimit.z
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return UsageLimitConditionViewModel.b1(event, usageLimitConditionViewState2, (UsageLimitConditionViewState) obj);
                    }
                });
            } else {
                G0(new UsageLimitConditionViewModel$onEvent$3(this, null));
            }
        }
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionHandler
    public /* bridge */ void a0(IntervalDTO intervalDTO) {
        super.a0(intervalDTO);
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionHandler
    public void c(int i3) {
        G0(new UsageLimitConditionViewModel$onShowSnackbar$1(this, i3, null));
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
        return this.f115888q.J().g();
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionHandler
    public /* bridge */ void m() {
        super.m();
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionHandler
    public void n0(final TimeConditionConfigurationViewState newState) {
        Intrinsics.checkNotNullParameter(newState, "newState");
        Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.usagelimit.a0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return UsageLimitConditionViewModel.d1(newState, (UsageLimitConditionViewState) obj);
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
        return (StrictModeRepository) this.f115889r.getValue();
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionHandler
    public Long w() {
        return this.f115886o;
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionHandler
    public /* bridge */ void x() {
        super.x();
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionHandler
    public TimeConditionConfigurationViewState x0() {
        return ((UsageLimitConditionViewState) I0()).d();
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionHandler
    public /* bridge */ void y(boolean z2) {
        super.y(z2);
    }
}
