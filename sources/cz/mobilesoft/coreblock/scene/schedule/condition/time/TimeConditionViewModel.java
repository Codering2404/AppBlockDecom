package cz.mobilesoft.coreblock.scene.schedule.condition.time;

import android.app.Application;
import cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel;
import cz.mobilesoft.coreblock.enums.Product;
import cz.mobilesoft.coreblock.repository.PremiumRepositoryV2;
import cz.mobilesoft.coreblock.repository.StrictModeRepository;
import cz.mobilesoft.coreblock.scene.schedule.condition.ConditionDTO;
import cz.mobilesoft.coreblock.scene.schedule.condition.IntervalDTO;
import cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionViewEvent;
import cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionViewModel;
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
public final class TimeConditionViewModel extends BaseStatefulViewModel<TimeConditionViewState, TimeConditionViewEvent, TimeConditionViewCommand> implements TimeConditionHandler {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Long f115761o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final boolean f115762p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final PremiumRepositoryV2 f115763q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final Lazy f115764r;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionViewModel$1", f = "TimeConditionViewModel.kt", l = {72}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f115765a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ConditionDTO.TimeDTO f115766b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ TimeConditionViewModel f115767c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ConditionDTO.TimeDTO timeDTO, TimeConditionViewModel timeConditionViewModel, Continuation continuation) {
            super(2, continuation);
            this.f115766b = timeDTO;
            this.f115767c = timeConditionViewModel;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final TimeConditionViewState q(boolean z2, TimeConditionViewState timeConditionViewState) {
            return TimeConditionViewState.b(timeConditionViewState, z2, false, null, 6, null);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.f115766b, this.f115767c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f115765a;
            if (i3 == 0) {
                ResultKt.b(obj);
                if (this.f115766b != null) {
                    StrictModeRepository strictModeRepositoryT0 = this.f115767c.t0();
                    Long lW = this.f115767c.w();
                    this.f115765a = 1;
                    obj = strictModeRepositoryT0.q(lW, this);
                    if (obj == objF) {
                        return objF;
                    }
                }
                this.f115767c.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.time.y
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return TimeConditionViewModel.AnonymousClass1.q(z, (TimeConditionViewState) obj2);
                    }
                });
                return Unit.f139807a;
            }
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            final boolean z2 = ((Boolean) obj).booleanValue();
            this.f115767c.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.time.y
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return TimeConditionViewModel.AnonymousClass1.q(z2, (TimeConditionViewState) obj2);
                }
            });
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public TimeConditionViewModel(Application application, ConditionDTO.TimeDTO timeDTO, Long l3, boolean z2, PremiumRepositoryV2 premiumRepository) {
        super(application, new TimeConditionViewState(false, z2, TimeConditionViewModelKt.c(application, timeDTO, premiumRepository.J().g(), false, premiumRepository.J().f(Product.TIMES), 8, null), 1, null));
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(premiumRepository, "premiumRepository");
        this.f115761o = l3;
        this.f115762p = z2;
        this.f115763q = premiumRepository;
        LazyThreadSafetyMode lazyThreadSafetyModeB = KoinPlatformTools.f146106a.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f115764r = LazyKt.a(lazyThreadSafetyModeB, new Function0<StrictModeRepository>() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionViewModel$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(StrictModeRepository.class), qualifier, objArr);
            }
        });
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass1(timeDTO, this, null), 3, null);
    }

    public static final /* synthetic */ TimeConditionViewState S0(TimeConditionViewModel timeConditionViewModel) {
        return (TimeConditionViewState) timeConditionViewModel.I0();
    }

    private final void V0() {
        BuildersKt__Builders_commonKt.d(B0(), null, null, new TimeConditionViewModel$onCloseClicked$1(this, null), 3, null);
    }

    private final void X0() {
        ConditionDTO.TimeDTO timeDTOB = ((TimeConditionViewState) I0()).c().b();
        if (timeDTOB == null) {
            h0();
        } else {
            BuildersKt__Builders_commonKt.d(B0(), null, null, new TimeConditionViewModel$onSaveClicked$1(this, timeDTOB, null), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TimeConditionViewState Y0(TimeConditionConfigurationViewState timeConditionConfigurationViewState, TimeConditionViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return TimeConditionViewState.b(updateState, false, false, timeConditionConfigurationViewState, 3, null);
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionHandler
    public boolean O() {
        return ((TimeConditionViewState) I0()).f();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel
    /* JADX INFO: renamed from: W0, reason: merged with bridge method [inline-methods] */
    public void O0(TimeConditionViewEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof TimeConditionViewEvent.OnDayCheckedChanged) {
            TimeConditionViewEvent.OnDayCheckedChanged onDayCheckedChanged = (TimeConditionViewEvent.OnDayCheckedChanged) event;
            f(onDayCheckedChanged.b(), onDayCheckedChanged.a());
            return;
        }
        if (event instanceof TimeConditionViewEvent.OnIntervalRemoveClicked) {
            a0(((TimeConditionViewEvent.OnIntervalRemoveClicked) event).a());
            return;
        }
        if (Intrinsics.areEqual(event, TimeConditionViewEvent.OnCloseClicked.f115751a)) {
            V0();
            return;
        }
        if (Intrinsics.areEqual(event, TimeConditionViewEvent.OnSaveClicked.f115760a)) {
            X0();
            return;
        }
        if (Intrinsics.areEqual(event, TimeConditionViewEvent.OnAddIntervalClicked.f115749a)) {
            x();
            return;
        }
        if (event instanceof TimeConditionViewEvent.OnIntervalClicked) {
            p0(((TimeConditionViewEvent.OnIntervalClicked) event).a());
            return;
        }
        if (event instanceof TimeConditionViewEvent.OnIntervalSet) {
            TimeConditionViewEvent.OnIntervalSet onIntervalSet = (TimeConditionViewEvent.OnIntervalSet) event;
            g(onIntervalSet.b(), onIntervalSet.a(), onIntervalSet.c());
        } else if (event instanceof TimeConditionViewEvent.OnAllDayLongCheckedChanged) {
            y(((TimeConditionViewEvent.OnAllDayLongCheckedChanged) event).a());
        } else {
            if (!Intrinsics.areEqual(event, TimeConditionViewEvent.OnDismissTimeRangePickerBottomSheet.f115754a)) {
                throw new NoWhenBranchMatchedException();
            }
            m();
        }
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionHandler
    public boolean X() {
        return this.f115762p;
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionHandler
    public /* bridge */ void a0(IntervalDTO intervalDTO) {
        super.a0(intervalDTO);
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionHandler
    public void c(int i3) {
        G0(new TimeConditionViewModel$onShowSnackbar$1(this, i3, null));
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
        return this.f115763q.J().g();
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionHandler
    public /* bridge */ void m() {
        super.m();
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionHandler
    public void n0(final TimeConditionConfigurationViewState newState) {
        Intrinsics.checkNotNullParameter(newState, "newState");
        Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.time.x
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TimeConditionViewModel.Y0(newState, (TimeConditionViewState) obj);
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
        return (StrictModeRepository) this.f115764r.getValue();
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionHandler
    public Long w() {
        return this.f115761o;
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionHandler
    public /* bridge */ void x() {
        super.x();
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionHandler
    public TimeConditionConfigurationViewState x0() {
        return ((TimeConditionViewState) I0()).c();
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionHandler
    public /* bridge */ void y(boolean z2) {
        super.y(z2);
    }
}
