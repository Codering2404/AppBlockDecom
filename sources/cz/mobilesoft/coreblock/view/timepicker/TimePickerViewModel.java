package cz.mobilesoft.coreblock.view.timepicker;

import android.app.Application;
import cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel;
import cz.mobilesoft.coreblock.repository.StrictModeRepository;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao;
import cz.mobilesoft.coreblock.util.helperextension.DateHelperExtKt;
import cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt;
import cz.mobilesoft.coreblock.view.timepicker.TimePickerConfig;
import cz.mobilesoft.coreblock.view.timepicker.TimePickerViewEvent;
import cz.mobilesoft.coreblock.view.timepicker.TimePickerViewModel;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.collections.immutable.ExtensionsKt;
import kotlinx.collections.immutable.PersistentList;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
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
@Deprecated
@Metadata
public final class TimePickerViewModel extends BaseStatefulViewModel<TimePickerViewState, TimePickerViewEvent, TimePickerViewCommand> {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Params f133070o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private Job f133071p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final Lazy f133072q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final Lazy f133073r;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.view.timepicker.TimePickerViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.view.timepicker.TimePickerViewModel$1", f = "TimePickerViewModel.kt", l = {}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f133074a;

        AnonymousClass1(Continuation continuation) {
            super(1, continuation);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final TimePickerViewState q(boolean z2, TimePickerViewState timePickerViewState) {
            return TimePickerViewState.b(timePickerViewState, null, null, null, false, null, 0, 0, 0, 0, false, 0L, 0L, 0L, 0L, null, null, null, z2, 131071, null);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return TimePickerViewModel.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.f133074a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            final boolean zN = TimePickerViewModel.this.t0().n();
            TimePickerViewModel.this.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.view.timepicker.j1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return TimePickerViewModel.AnonymousClass1.q(zN, (TimePickerViewState) obj2);
                }
            });
            TimePickerViewModel timePickerViewModel = TimePickerViewModel.this;
            timePickerViewModel.o1(timePickerViewModel.e1().d(), Boxing.e(TimePickerViewModel.this.e1().b()), TimePickerViewModel.this.e1().a(), TimePickerViewModel.this.e1().e());
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public TimePickerViewModel(Application application, Params params) {
        super(application, new TimePickerViewState(null, null, null, false, null, 0, 0, 0, 0, false, 0L, 0L, 0L, 0L, null, null, null, false, 262143, null));
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(params, "params");
        this.f133070o = params;
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f133072q = LazyKt.a(lazyThreadSafetyModeB, new Function0<ProfileDao>() { // from class: cz.mobilesoft.coreblock.view.timepicker.TimePickerViewModel$special$$inlined$inject$default$1
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
        this.f133073r = LazyKt.a(lazyThreadSafetyModeB2, new Function0<StrictModeRepository>() { // from class: cz.mobilesoft.coreblock.view.timepicker.TimePickerViewModel$special$$inlined$inject$default$2
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
        G0(new AnonymousClass1(null));
    }

    public static final /* synthetic */ TimePickerViewState Y0(TimePickerViewModel timePickerViewModel) {
        return (TimePickerViewState) timePickerViewModel.I0();
    }

    private final Pair c1(long j3) {
        long j4 = j3 / 60000;
        return new Pair(Long.valueOf(j4 / 60), Long.valueOf(j4 % 60));
    }

    private final InitialTimes d1(TimePickerConfig timePickerConfig, long j3) {
        boolean z2;
        Integer num;
        List listD = timePickerConfig.d();
        PersistentList persistentListK = listD != null ? ExtensionsKt.k(listD) : null;
        List listF = timePickerConfig.f();
        PersistentList persistentListK2 = listF != null ? ExtensionsKt.k(listF) : null;
        List listH = timePickerConfig.h();
        PersistentList persistentListK3 = listH != null ? ExtensionsKt.k(listH) : null;
        InitialTimes initialTimes = new InitialTimes(0, 0, 0, 7, null);
        if (j3 <= 0) {
            return initialTimes;
        }
        if (timePickerConfig.i()) {
            Pair pairC1 = c1(j3);
            long jLongValue = ((Number) pairC1.a()).longValue();
            long jLongValue2 = ((Number) pairC1.b()).longValue();
            Integer numValueOf = persistentListK2 != null ? Integer.valueOf(persistentListK2.indexOf(Long.valueOf(jLongValue))) : null;
            if (numValueOf != null && numValueOf.intValue() == -1) {
                numValueOf = null;
            }
            initialTimes.e(numValueOf != null ? numValueOf.intValue() : 0);
            Integer numValueOf2 = persistentListK3 != null ? Integer.valueOf(persistentListK3.indexOf(Long.valueOf(jLongValue2))) : null;
            num = (numValueOf2 == null || numValueOf2.intValue() != -1) ? numValueOf2 : null;
            initialTimes.f(num != null ? num.intValue() : 0);
            return initialTimes;
        }
        TimeHelperExt timeHelperExt = TimeHelperExt.f128663a;
        boolean z3 = true;
        boolean z4 = timePickerConfig.c() != null;
        if (timePickerConfig.e() != null) {
            z2 = true;
        } else {
            z2 = true;
            z3 = false;
        }
        if (timePickerConfig.g() == null) {
            z2 = false;
        }
        Triple tripleS = timeHelperExt.s(z4, z3, z2, j3);
        long jLongValue3 = ((Number) tripleS.a()).longValue();
        long jLongValue4 = ((Number) tripleS.b()).longValue();
        long jLongValue5 = ((Number) tripleS.c()).longValue();
        Integer numValueOf3 = persistentListK != null ? Integer.valueOf(persistentListK.indexOf(Long.valueOf(jLongValue3))) : null;
        if (numValueOf3 != null && numValueOf3.intValue() == -1) {
            numValueOf3 = null;
        }
        initialTimes.d(numValueOf3 != null ? numValueOf3.intValue() : 0);
        Integer numValueOf4 = persistentListK2 != null ? Integer.valueOf(persistentListK2.indexOf(Long.valueOf(jLongValue4))) : null;
        if (numValueOf4 != null && numValueOf4.intValue() == -1) {
            numValueOf4 = null;
        }
        initialTimes.e(numValueOf4 != null ? numValueOf4.intValue() : 0);
        Integer numValueOf5 = persistentListK3 != null ? Integer.valueOf(persistentListK3.indexOf(Long.valueOf(jLongValue5))) : null;
        num = (numValueOf5 == null || numValueOf5.intValue() != -1) ? numValueOf5 : null;
        initialTimes.f(num != null ? num.intValue() : 0);
        return initialTimes;
    }

    private final boolean f1() {
        TimePickerViewState timePickerViewState = (TimePickerViewState) I0();
        InitialTimes initialTimesD1 = d1(this.f133070o.d(), timePickerViewState.h());
        if (timePickerViewState.l() > initialTimesD1.a() || timePickerViewState.m() > initialTimesD1.b() || timePickerViewState.n() > initialTimesD1.c()) {
            return true;
        }
        return this.f133070o.d().a() != null && timePickerViewState.k() > this.f133070o.d().a().a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TimePickerViewState h1(TimePickerViewEvent timePickerViewEvent, TimePickerViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return TimePickerViewState.b(updateState, null, null, null, false, null, ((TimePickerViewEvent.OnUpdateDayIndexEvent) timePickerViewEvent).a(), 0, 0, 0, false, 0L, 0L, 0L, 0L, null, null, null, false, 262111, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TimePickerViewState i1(TimePickerViewEvent timePickerViewEvent, TimePickerViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return TimePickerViewState.b(updateState, null, null, null, false, null, 0, ((TimePickerViewEvent.OnUpdateHourIndexEvent) timePickerViewEvent).a(), 0, 0, false, 0L, 0L, 0L, 0L, null, null, null, false, 262079, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TimePickerViewState j1(TimePickerViewEvent timePickerViewEvent, TimePickerViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return TimePickerViewState.b(updateState, null, null, null, false, null, 0, 0, ((TimePickerViewEvent.OnUpdateMinuteIndexEvent) timePickerViewEvent).a(), 0, false, 0L, 0L, 0L, 0L, null, null, null, false, 262015, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TimePickerViewState k1(TimePickerViewEvent timePickerViewEvent, TimePickerViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return TimePickerViewState.b(updateState, null, null, null, false, null, 0, 0, 0, ((TimePickerViewEvent.OnUpdateCustomIndexEvent) timePickerViewEvent).a(), false, 0L, 0L, 0L, 0L, null, null, null, false, 261887, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TimePickerViewState l1(long j3, TimePickerViewModel timePickerViewModel, long j4, TimePickerViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        String str = DateHelperExtKt.i(timePickerViewModel.A0(), true, true).format(new Date(j4 + j3));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return TimePickerViewState.b(updateState, null, null, null, false, null, 0, 0, 0, 0, false, 0L, j3, 0L, 0L, str, null, null, false, 243711, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TimePickerViewState m1(TimePickerViewEvent timePickerViewEvent, TimePickerViewState updateState) {
        List listB;
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        TimePickerViewEvent.OnUpdateTimePickerConfig onUpdateTimePickerConfig = (TimePickerViewEvent.OnUpdateTimePickerConfig) timePickerViewEvent;
        List listD = onUpdateTimePickerConfig.a().d();
        PersistentList persistentListK = null;
        PersistentList persistentListK2 = listD != null ? ExtensionsKt.k(listD) : null;
        List listF = onUpdateTimePickerConfig.a().f();
        PersistentList persistentListK3 = listF != null ? ExtensionsKt.k(listF) : null;
        List listH = onUpdateTimePickerConfig.a().h();
        PersistentList persistentListK4 = listH != null ? ExtensionsKt.k(listH) : null;
        TimePickerConfig.TimePickerType.Custom customA = onUpdateTimePickerConfig.a().a();
        if (customA != null && (listB = customA.b()) != null) {
            persistentListK = ExtensionsKt.k(listB);
        }
        return TimePickerViewState.b(updateState, persistentListK2, persistentListK3, persistentListK4, false, persistentListK, 0, 0, 0, 0, false, 0L, 0L, 0L, 0L, null, null, null, false, 262120, null);
    }

    private final void n1(long j3) {
        Flow flowA = TimeHelperExt.f128663a.a(j3, 500L);
        Job job = this.f133071p;
        if (job != null) {
            Job.DefaultImpls.b(job, null, 1, null);
        }
        this.f133071p = FlowKt.Q(FlowKt.V(FlowKt.g(flowA), new TimePickerViewModel$updateCountdown$1(this, null)), B0());
    }

    public static /* synthetic */ void p1(TimePickerViewModel timePickerViewModel, TimePickerConfig timePickerConfig, Long l3, Long l4, boolean z2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            l3 = 0L;
        }
        if ((i3 & 4) != 0) {
            l4 = null;
        }
        if ((i3 & 8) != 0) {
            z2 = false;
        }
        timePickerViewModel.o1(timePickerConfig, l3, l4, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TimePickerViewState q1(TimePickerConfig timePickerConfig, InitialTimes initialTimes, TimePickerViewModel timePickerViewModel, long j3, boolean z2, Long l3, TimePickerViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        List listD = timePickerConfig.d();
        PersistentList persistentListK = listD != null ? ExtensionsKt.k(listD) : null;
        List listF = timePickerConfig.f();
        PersistentList persistentListK2 = listF != null ? ExtensionsKt.k(listF) : null;
        List listH = timePickerConfig.h();
        PersistentList persistentListK3 = listH != null ? ExtensionsKt.k(listH) : null;
        List listB = timePickerConfig.b();
        PersistentList persistentListK4 = listB != null ? ExtensionsKt.k(listB) : null;
        int iA = initialTimes.a();
        int iB = initialTimes.b();
        int iC = initialTimes.c();
        TimePickerConfig.TimePickerType.Custom customA = timePickerConfig.a();
        int iA2 = customA != null ? customA.a() : 0;
        String str = DateHelperExtKt.i(timePickerViewModel.A0(), true, true).format(new Date(TimeHelperExt.f128663a.f() + j3));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return TimePickerViewState.b(updateState, persistentListK, persistentListK2, persistentListK3, timePickerConfig.i(), persistentListK4, iA, iB, iC, iA2, z2, j3, j3, 0L, 0L, str, l3, null, false, 208896, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StrictModeRepository t0() {
        return (StrictModeRepository) this.f133073r.getValue();
    }

    public final Params e1() {
        return this.f133070o;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel
    /* JADX INFO: renamed from: g1, reason: merged with bridge method [inline-methods] */
    public void O0(final TimePickerViewEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof TimePickerViewEvent.OnUpdateDayIndexEvent) {
            Q0(new Function1() { // from class: cz.mobilesoft.coreblock.view.timepicker.c1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return TimePickerViewModel.h1(event, (TimePickerViewState) obj);
                }
            });
            return;
        }
        if (event instanceof TimePickerViewEvent.OnUpdateHourIndexEvent) {
            Q0(new Function1() { // from class: cz.mobilesoft.coreblock.view.timepicker.d1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return TimePickerViewModel.i1(event, (TimePickerViewState) obj);
                }
            });
            return;
        }
        if (event instanceof TimePickerViewEvent.OnUpdateMinuteIndexEvent) {
            Q0(new Function1() { // from class: cz.mobilesoft.coreblock.view.timepicker.e1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return TimePickerViewModel.j1(event, (TimePickerViewState) obj);
                }
            });
            return;
        }
        if (event instanceof TimePickerViewEvent.OnUpdateCustomIndexEvent) {
            Q0(new Function1() { // from class: cz.mobilesoft.coreblock.view.timepicker.f1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return TimePickerViewModel.k1(event, (TimePickerViewState) obj);
                }
            });
            return;
        }
        if (!Intrinsics.areEqual(event, TimePickerViewEvent.OnUpdateSelectedTimeEvent.f133068a)) {
            if (!(event instanceof TimePickerViewEvent.OnUpdateTimePickerConfig)) {
                throw new NoWhenBranchMatchedException();
            }
            Q0(new Function1() { // from class: cz.mobilesoft.coreblock.view.timepicker.h1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return TimePickerViewModel.m1(event, (TimePickerViewState) obj);
                }
            });
            return;
        }
        TimePickerViewState timePickerViewState = (TimePickerViewState) I0();
        PersistentList persistentListD = timePickerViewState.d();
        long millis = persistentListD != null ? TimeUnit.DAYS.toMillis(((Number) persistentListD.get(timePickerViewState.l())).longValue()) : 0L;
        PersistentList persistentListG = timePickerViewState.g();
        long millis2 = persistentListG != null ? TimeUnit.HOURS.toMillis(((Number) persistentListG.get(timePickerViewState.m())).longValue()) : 0L;
        PersistentList persistentListI = timePickerViewState.i();
        final long millis3 = millis + millis2 + (persistentListI != null ? TimeUnit.MINUTES.toMillis(((Number) persistentListI.get(timePickerViewState.n())).longValue()) : 0L);
        Long lF = timePickerViewState.f();
        final long jLongValue = lF != null ? lF.longValue() : TimeHelperExt.f128663a.f();
        if (timePickerViewState.t() && this.f133070o.c() != null && f1()) {
            G0(new TimePickerViewModel$onEvent$5$1(this, null));
            p1(this, this.f133070o.d(), Long.valueOf(timePickerViewState.h()), null, false, 12, null);
        } else {
            Q0(new Function1() { // from class: cz.mobilesoft.coreblock.view.timepicker.g1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return TimePickerViewModel.l1(millis3, this, jLongValue, (TimePickerViewState) obj);
                }
            });
            G0(new TimePickerViewModel$onEvent$5$3(this, millis3, null));
        }
    }

    public final void o1(final TimePickerConfig timePickerConfig, Long l3, final Long l4, final boolean z2) {
        Intrinsics.checkNotNullParameter(timePickerConfig, "timePickerConfig");
        final long jLongValue = l3 != null ? l3.longValue() : ((TimePickerViewState) I0()).o();
        final InitialTimes initialTimesD1 = d1(timePickerConfig, jLongValue);
        Q0(new Function1() { // from class: cz.mobilesoft.coreblock.view.timepicker.i1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TimePickerViewModel.q1(timePickerConfig, initialTimesD1, this, jLongValue, z2, l4, (TimePickerViewState) obj);
            }
        });
        if (l4 != null) {
            n1(l4.longValue());
        }
        G0(new TimePickerViewModel$updateWithNewConfig$2(this, null));
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Params {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final TimePickerConfig f133076a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f133077b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Long f133078c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f133079d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final Long f133080e;

        public Params(TimePickerConfig timePickerConfig, long j3, Long l3, boolean z2, Long l4) {
            Intrinsics.checkNotNullParameter(timePickerConfig, "timePickerConfig");
            this.f133076a = timePickerConfig;
            this.f133077b = j3;
            this.f133078c = l3;
            this.f133079d = z2;
            this.f133080e = l4;
        }

        public final Long a() {
            return this.f133078c;
        }

        public final long b() {
            return this.f133077b;
        }

        public final Long c() {
            return this.f133080e;
        }

        public final TimePickerConfig d() {
            return this.f133076a;
        }

        public final boolean e() {
            return this.f133079d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Params)) {
                return false;
            }
            Params params = (Params) obj;
            return Intrinsics.areEqual(this.f133076a, params.f133076a) && this.f133077b == params.f133077b && Intrinsics.areEqual(this.f133078c, params.f133078c) && this.f133079d == params.f133079d && Intrinsics.areEqual(this.f133080e, params.f133080e);
        }

        public int hashCode() {
            int iHashCode = ((this.f133076a.hashCode() * 31) + Long.hashCode(this.f133077b)) * 31;
            Long l3 = this.f133078c;
            int iHashCode2 = (((iHashCode + (l3 == null ? 0 : l3.hashCode())) * 31) + Boolean.hashCode(this.f133079d)) * 31;
            Long l4 = this.f133080e;
            return iHashCode2 + (l4 != null ? l4.hashCode() : 0);
        }

        public String toString() {
            return "Params(timePickerConfig=" + this.f133076a + ", initialTimeInMillis=" + this.f133077b + ", extendedTimeInMillis=" + this.f133078c + ", withEndsAtText=" + this.f133079d + ", remainingUsageLimit=" + this.f133080e + ")";
        }

        public /* synthetic */ Params(TimePickerConfig timePickerConfig, long j3, Long l3, boolean z2, Long l4, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(timePickerConfig, (i3 & 2) != 0 ? 0L : j3, (i3 & 4) != 0 ? null : l3, (i3 & 8) != 0 ? false : z2, (i3 & 16) != 0 ? null : l4);
        }
    }
}
