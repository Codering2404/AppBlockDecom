package cz.mobilesoft.coreblock.scene.dashboard.blocking.pause;

import android.app.Application;
import cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel;
import cz.mobilesoft.coreblock.enums.PremiumState;
import cz.mobilesoft.coreblock.repository.PremiumRepositoryV2;
import cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.PauseBlockingViewEvent;
import cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.PauseBlockingViewModel;
import cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.PauseBlockingViewState;
import cz.mobilesoft.coreblock.scene.streaks.StreakActivityTracker;
import cz.mobilesoft.coreblock.scene.streaks.StreakEvaluator;
import cz.mobilesoft.coreblock.scene.streaks.StreakPauseTracker;
import cz.mobilesoft.coreblock.scene.streaks.StreakStore;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao;
import cz.mobilesoft.coreblock.storage.room.dao.core.SchedulePauseHistoryDao;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.coreblock.util.helperextension.DateHelper;
import cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;
import kotlin.KotlinNothingValueException;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class PauseBlockingViewModel extends BaseStatefulViewModel<PauseBlockingViewState, PauseBlockingViewEvent, PauseBlockingViewCommand> {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final Companion f100121x = new Companion(null);

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f100122y = 8;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final long f100123o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final PremiumState f100124p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final Lazy f100125q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final Lazy f100126r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final Lazy f100127s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final Lazy f100128t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final Lazy f100129u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final Lazy f100130v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final Lazy f100131w;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.PauseBlockingViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.PauseBlockingViewModel$1", f = "PauseBlockingViewModel.kt", l = {49}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f100132a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.PauseBlockingViewModel$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class C02721<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ PauseBlockingViewModel f100134a;

            C02721(PauseBlockingViewModel pauseBlockingViewModel) {
                this.f100134a = pauseBlockingViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final PauseBlockingViewState f(PremiumState premiumState, PauseBlockingViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return PauseBlockingViewState.b(updateState, premiumState, null, null, null, null, 30, null);
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object emit(final PremiumState premiumState, Continuation continuation) {
                this.f100134a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.p0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return PauseBlockingViewModel.AnonymousClass1.C02721.f(premiumState, (PauseBlockingViewState) obj);
                    }
                });
                return Unit.f139807a;
            }
        }

        AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return PauseBlockingViewModel.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f100132a;
            if (i3 == 0) {
                ResultKt.b(obj);
                StateFlow stateFlowK = PauseBlockingViewModel.this.k1().K();
                C02721 c02721 = new C02721(PauseBlockingViewModel.this);
                this.f100132a = 1;
                if (stateFlowK.collect(c02721, this) == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            throw new KotlinNothingValueException();
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(PauseBlockingViewState.PauseBlockingType type) {
            Intrinsics.checkNotNullParameter(type, "type");
            boolean z2 = type instanceof PauseBlockingViewState.PauseBlockingType.Custom;
            String str = z2 ? "custom_time" : type instanceof PauseBlockingViewState.PauseBlockingType.FifteenMinutes ? "15 min" : type instanceof PauseBlockingViewState.PauseBlockingType.ForToday ? "today" : type instanceof PauseBlockingViewState.PauseBlockingType.OneHour ? "1 hour" : null;
            String strValueOf = z2 ? String.valueOf((((PauseBlockingViewState.PauseBlockingType.Custom) type).a() - TimeHelperExt.f128663a.f()) / ((long) 60000)) : null;
            if (str != null) {
                AnswersHelper.f128199a.k5(str, strValueOf);
            }
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public PauseBlockingViewModel(Application application, long j3, PremiumState premiumState) {
        super(application, new PauseBlockingViewState(premiumState, null, null, null, null, 30, null));
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(premiumState, "premiumState");
        this.f100123o = j3;
        this.f100124p = premiumState;
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f100125q = LazyKt.a(lazyThreadSafetyModeB, new Function0<ProfileDao>() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.PauseBlockingViewModel$special$$inlined$inject$default$1
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
        this.f100126r = LazyKt.a(lazyThreadSafetyModeB2, new Function0<SchedulePauseHistoryDao>() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.PauseBlockingViewModel$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(SchedulePauseHistoryDao.class), objArr2, objArr3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB3 = koinPlatformTools.b();
        final Object[] objArr4 = 0 == true ? 1 : 0;
        final Object[] objArr5 = 0 == true ? 1 : 0;
        this.f100127s = LazyKt.a(lazyThreadSafetyModeB3, new Function0<PremiumRepositoryV2>() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.PauseBlockingViewModel$special$$inlined$inject$default$3
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
        LazyThreadSafetyMode lazyThreadSafetyModeB4 = koinPlatformTools.b();
        final Object[] objArr6 = 0 == true ? 1 : 0;
        final Object[] objArr7 = 0 == true ? 1 : 0;
        this.f100128t = LazyKt.a(lazyThreadSafetyModeB4, new Function0<StreakPauseTracker>() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.PauseBlockingViewModel$special$$inlined$inject$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(StreakPauseTracker.class), objArr6, objArr7);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB5 = koinPlatformTools.b();
        final Object[] objArr8 = 0 == true ? 1 : 0;
        final Object[] objArr9 = 0 == true ? 1 : 0;
        this.f100129u = LazyKt.a(lazyThreadSafetyModeB5, new Function0<StreakActivityTracker>() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.PauseBlockingViewModel$special$$inlined$inject$default$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(StreakActivityTracker.class), objArr8, objArr9);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB6 = koinPlatformTools.b();
        final Object[] objArr10 = 0 == true ? 1 : 0;
        final Object[] objArr11 = 0 == true ? 1 : 0;
        this.f100130v = LazyKt.a(lazyThreadSafetyModeB6, new Function0<StreakEvaluator>() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.PauseBlockingViewModel$special$$inlined$inject$default$6
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(StreakEvaluator.class), objArr10, objArr11);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB7 = koinPlatformTools.b();
        final Object[] objArr12 = 0 == true ? 1 : 0;
        final Object[] objArr13 = 0 == true ? 1 : 0;
        this.f100131w = LazyKt.a(lazyThreadSafetyModeB7, new Function0<StreakStore>() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.PauseBlockingViewModel$special$$inlined$inject$default$7
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(StreakStore.class), objArr12, objArr13);
            }
        });
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass1(null), 3, null);
        s1();
        Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.o0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PauseBlockingViewModel.W0(this.f100323a, (PauseBlockingViewState) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long A1(PauseBlockingViewState.PauseBlockingType pauseBlockingType) {
        long jA;
        long jA2;
        long jF;
        if (pauseBlockingType instanceof PauseBlockingViewState.PauseBlockingType.FifteenMinutes) {
            jA = TimeUnit.MINUTES.toMillis(15L);
        } else if (pauseBlockingType instanceof PauseBlockingViewState.PauseBlockingType.OneHour) {
            jA = TimeUnit.HOURS.toMillis(1L);
        } else {
            if (pauseBlockingType instanceof PauseBlockingViewState.PauseBlockingType.ForToday) {
                jA2 = DateHelper.j().getTimeInMillis();
                jF = TimeHelperExt.f128663a.f();
            } else if (pauseBlockingType instanceof PauseBlockingViewState.PauseBlockingType.Custom) {
                PauseBlockingViewState.PauseBlockingType.Custom custom = (PauseBlockingViewState.PauseBlockingType.Custom) pauseBlockingType;
                long jA3 = custom.a();
                TimeHelperExt timeHelperExt = TimeHelperExt.f128663a;
                if (jA3 < timeHelperExt.f()) {
                    jA = custom.a();
                } else {
                    jA2 = custom.a();
                    jF = timeHelperExt.f();
                }
            } else if (pauseBlockingType instanceof PauseBlockingViewState.PauseBlockingType.UntilDateAndTime) {
                jA2 = ((PauseBlockingViewState.PauseBlockingType.UntilDateAndTime) pauseBlockingType).a();
                jF = TimeHelperExt.f128663a.f();
            } else {
                if (!(pauseBlockingType instanceof PauseBlockingViewState.PauseBlockingType.Indefinitely)) {
                    throw new NoWhenBranchMatchedException();
                }
                jA = 0;
            }
            jA = jA2 - jF;
        }
        return RangesKt.g(jA, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B1(PauseBlockingViewState.PauseBlockingType pauseBlockingType) {
        Profile.PausedUntil time;
        if (C1(pauseBlockingType)) {
            return;
        }
        if (pauseBlockingType instanceof PauseBlockingViewState.PauseBlockingType.FifteenMinutes) {
            time = new Profile.PausedUntil.Time(TimeHelperExt.c() + TimeUnit.MINUTES.toMillis(15L));
        } else if (pauseBlockingType instanceof PauseBlockingViewState.PauseBlockingType.OneHour) {
            time = new Profile.PausedUntil.Time(TimeHelperExt.c() + TimeUnit.HOURS.toMillis(1L));
        } else if (pauseBlockingType instanceof PauseBlockingViewState.PauseBlockingType.ForToday) {
            time = new Profile.PausedUntil.Time(DateHelper.j().getTimeInMillis() - 1);
        } else if (pauseBlockingType instanceof PauseBlockingViewState.PauseBlockingType.Custom) {
            PauseBlockingViewState.PauseBlockingType.Custom custom = (PauseBlockingViewState.PauseBlockingType.Custom) pauseBlockingType;
            long jA = custom.a();
            TimeHelperExt timeHelperExt = TimeHelperExt.f128663a;
            time = new Profile.PausedUntil.Time(jA < timeHelperExt.f() ? timeHelperExt.f() + custom.a() : custom.a());
        } else if (pauseBlockingType instanceof PauseBlockingViewState.PauseBlockingType.Indefinitely) {
            time = Profile.PausedUntil.DisabledByUser.f126479b;
        } else {
            if (!(pauseBlockingType instanceof PauseBlockingViewState.PauseBlockingType.UntilDateAndTime)) {
                throw new NoWhenBranchMatchedException();
            }
            time = new Profile.PausedUntil.Time(((PauseBlockingViewState.PauseBlockingType.UntilDateAndTime) pauseBlockingType).a());
        }
        G0(new PauseBlockingViewModel$pauseProfile$1(this, pauseBlockingType, time, null));
    }

    private final boolean C1(PauseBlockingViewState.PauseBlockingType pauseBlockingType) {
        if (Intrinsics.areEqual(pauseBlockingType, PauseBlockingViewState.PauseBlockingType.Indefinitely.f100194b) || ((PauseBlockingViewState) I0()).f().g()) {
            return false;
        }
        AnswersHelper.f128199a.Y4();
        G0(new PauseBlockingViewModel$showPaywallIfNeeded$1(this, null));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PauseBlockingViewState W0(PauseBlockingViewModel pauseBlockingViewModel, PauseBlockingViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        PauseBlockingViewState.DateTimePicker dateTimePickerE = updateState.e();
        TimeHelperExt timeHelperExt = TimeHelperExt.f128663a;
        return PauseBlockingViewState.b(updateState, null, null, PauseBlockingViewState.DateTimePicker.b(dateTimePickerE, timeHelperExt.k(pauseBlockingViewModel.A0(), timeHelperExt.f()), TimeHelperExt.j(timeHelperExt, pauseBlockingViewModel.A0(), timeHelperExt.f(), false, false, 12, null), 0L, timeHelperExt.f() - DateHelper.h().getTimeInMillis(), 4, null), null, null, 27, null);
    }

    public static final /* synthetic */ PauseBlockingViewState X0(PauseBlockingViewModel pauseBlockingViewModel) {
        return (PauseBlockingViewState) pauseBlockingViewModel.I0();
    }

    private final void j1(PauseBlockingViewState.PauseBlockingType pauseBlockingType) {
        if (C1(pauseBlockingType)) {
            return;
        }
        if (Intrinsics.areEqual(pauseBlockingType, PauseBlockingViewState.PauseBlockingType.Indefinitely.f100194b)) {
            B1(pauseBlockingType);
        } else {
            G0(new PauseBlockingViewModel$attemptPause$1(this, pauseBlockingType, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PremiumRepositoryV2 k1() {
        return (PremiumRepositoryV2) this.f100127s.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ProfileDao l1() {
        return (ProfileDao) this.f100125q.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SchedulePauseHistoryDao n1() {
        return (SchedulePauseHistoryDao) this.f100126r.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StreakActivityTracker o1() {
        return (StreakActivityTracker) this.f100129u.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StreakEvaluator p1() {
        return (StreakEvaluator) this.f100130v.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StreakPauseTracker q1() {
        return (StreakPauseTracker) this.f100128t.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StreakStore r1() {
        return (StreakStore) this.f100131w.getValue();
    }

    private final void s1() {
        BuildersKt__Builders_commonKt.d(C0(), null, null, new PauseBlockingViewModel$loadPresetsHistory$1(this, null), 3, null);
    }

    private final void t1(long j3) {
        final long jF = ((PauseBlockingViewState) I0()).e().f();
        final long jM = TimeHelperExt.f128663a.m(j3);
        Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.m0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PauseBlockingViewModel.u1(this.f100312a, jM, jF, (PauseBlockingViewState) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PauseBlockingViewState u1(PauseBlockingViewModel pauseBlockingViewModel, long j3, long j4, PauseBlockingViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return PauseBlockingViewState.b(updateState, null, null, PauseBlockingViewState.DateTimePicker.b(updateState.e(), null, TimeHelperExt.j(TimeHelperExt.f128663a, pauseBlockingViewModel.A0(), j3 + j4, true, false, 8, null), j3, 0L, 9, null), null, null, 27, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PauseBlockingViewState w1(PauseBlockingViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return PauseBlockingViewState.b(updateState, null, null, null, null, null, 15, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PauseBlockingViewState x1(PauseBlockingViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return PauseBlockingViewState.b(updateState, null, null, null, null, null, 15, null);
    }

    private final void y1(final long j3) {
        final long jC = ((PauseBlockingViewState) I0()).e().c();
        final long timeInMillis = DateHelper.h().getTimeInMillis();
        Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.n0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PauseBlockingViewModel.z1(this.f100318a, timeInMillis, j3, jC, (PauseBlockingViewState) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PauseBlockingViewState z1(PauseBlockingViewModel pauseBlockingViewModel, long j3, long j4, long j5, PauseBlockingViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        PauseBlockingViewState.DateTimePicker dateTimePickerE = updateState.e();
        TimeHelperExt timeHelperExt = TimeHelperExt.f128663a;
        return PauseBlockingViewState.b(updateState, null, null, PauseBlockingViewState.DateTimePicker.b(dateTimePickerE, timeHelperExt.k(pauseBlockingViewModel.A0(), j3 + j4), TimeHelperExt.j(timeHelperExt, pauseBlockingViewModel.A0(), j5 + j4, true, false, 8, null), 0L, j4, 4, null), null, null, 27, null);
    }

    public final long m1() {
        return this.f100123o;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel
    /* JADX INFO: renamed from: v1, reason: merged with bridge method [inline-methods] */
    public void O0(PauseBlockingViewEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof PauseBlockingViewEvent.OnPauseClicked) {
            j1(((PauseBlockingViewEvent.OnPauseClicked) event).a());
            return;
        }
        if (Intrinsics.areEqual(event, PauseBlockingViewEvent.OnStreakPauseTakeBackClicked.f100119a)) {
            Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.k0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return PauseBlockingViewModel.w1((PauseBlockingViewState) obj);
                }
            });
            AnswersHelper.f128199a.b5();
            return;
        }
        if (Intrinsics.areEqual(event, PauseBlockingViewEvent.OnStreakPauseContinueClicked.f100118a)) {
            PauseBlockingViewState.StreakPauseWarning streakPauseWarningH = ((PauseBlockingViewState) I0()).h();
            PauseBlockingViewState.PauseBlockingType pauseBlockingTypeB = streakPauseWarningH != null ? streakPauseWarningH.b() : null;
            Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.l0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return PauseBlockingViewModel.x1((PauseBlockingViewState) obj);
                }
            });
            if (pauseBlockingTypeB != null) {
                B1(pauseBlockingTypeB);
                return;
            }
            return;
        }
        if (event instanceof PauseBlockingViewEvent.OnProfileCustomPauseTimeSelected) {
            Calendar calendarA = TimeHelperExt.A();
            calendarA.setTimeInMillis(calendarA.getTime().getTime() + ((PauseBlockingViewEvent.OnProfileCustomPauseTimeSelected) event).a());
            B1(new PauseBlockingViewState.PauseBlockingType.Custom(calendarA.getTimeInMillis()));
        } else if (event instanceof PauseBlockingViewEvent.OnTimeSelected) {
            y1(((PauseBlockingViewEvent.OnTimeSelected) event).a());
        } else {
            if (!(event instanceof PauseBlockingViewEvent.OnDateSelected)) {
                throw new NoWhenBranchMatchedException();
            }
            t1(((PauseBlockingViewEvent.OnDateSelected) event).a());
        }
    }
}
