package cz.mobilesoft.coreblock.activity.rating;

import android.app.Application;
import cz.mobilesoft.coreblock.activity.rating.RatingFlowEvent;
import cz.mobilesoft.coreblock.activity.rating.RatingFlowViewModel;
import cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel;
import cz.mobilesoft.coreblock.storage.datastore.RatingDataStore;
import cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao;
import cz.mobilesoft.coreblock.usecase.StatisticsPermissionsUseCase;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class RatingFlowViewModel extends BaseStatefulViewModel<RatingFlowState, RatingFlowEvent, RatingFlowCommand> {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final RatingTriggerSource f96141o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final Lazy f96142p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final Lazy f96143q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final Lazy f96144r;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.activity.rating.RatingFlowViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.activity.rating.RatingFlowViewModel$1", f = "RatingFlowViewModel.kt", l = {33}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f96145a;

        AnonymousClass1(Continuation continuation) {
            super(1, continuation);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final RatingFlowState q(boolean z2, RatingFlowState ratingFlowState) {
            return RatingFlowState.b(ratingFlowState, z2, false, false, null, null, 30, null);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return RatingFlowViewModel.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f96145a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowB0 = RatingFlowViewModel.this.g1().b0();
                this.f96145a = 1;
                obj = FlowKt.D(flowB0, this);
                if (obj == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            final boolean zBooleanValue = ((Boolean) obj).booleanValue();
            if (zBooleanValue) {
                RatingFlowViewModel.this.e1();
                AnswersHelper.D4(RatingFlowViewModel.this.f96141o);
            }
            RatingFlowViewModel.this.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.activity.rating.s1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return RatingFlowViewModel.AnonymousClass1.q(zBooleanValue, (RatingFlowState) obj2);
                }
            });
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public RatingFlowViewModel(Application application, RatingTriggerSource source) {
        super(application, new RatingFlowState(false, false, false, null, null, 31, null));
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(source, "source");
        this.f96141o = source;
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f96142p = LazyKt.a(lazyThreadSafetyModeB, new Function0<RatingDataStore>() { // from class: cz.mobilesoft.coreblock.activity.rating.RatingFlowViewModel$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(RatingDataStore.class), qualifier, objArr);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB2 = koinPlatformTools.b();
        final Object[] objArr2 = 0 == true ? 1 : 0;
        final Object[] objArr3 = 0 == true ? 1 : 0;
        this.f96143q = LazyKt.a(lazyThreadSafetyModeB2, new Function0<IgnoredStatisticsItemDao>() { // from class: cz.mobilesoft.coreblock.activity.rating.RatingFlowViewModel$special$$inlined$inject$default$2
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
        this.f96144r = LazyKt.a(lazyThreadSafetyModeB3, new Function0<StatisticsPermissionsUseCase>() { // from class: cz.mobilesoft.coreblock.activity.rating.RatingFlowViewModel$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(StatisticsPermissionsUseCase.class), objArr4, objArr5);
            }
        });
        G0(new AnonymousClass1(null));
    }

    public static final /* synthetic */ RatingFlowState V0(RatingFlowViewModel ratingFlowViewModel) {
        return (RatingFlowState) ratingFlowViewModel.I0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e1() {
        BuildersKt__Builders_commonKt.d(C0(), null, null, new RatingFlowViewModel$fetchLast7DayStatistics$1(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IgnoredStatisticsItemDao f1() {
        return (IgnoredStatisticsItemDao) this.f96143q.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RatingDataStore g1() {
        return (RatingDataStore) this.f96142p.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StatisticsPermissionsUseCase h1() {
        return (StatisticsPermissionsUseCase) this.f96144r.getValue();
    }

    private final void i1(final RatingFlowEvent.OnReviewPreparationFinished onReviewPreparationFinished) {
        Q0(new Function1() { // from class: cz.mobilesoft.coreblock.activity.rating.r1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return RatingFlowViewModel.j1(onReviewPreparationFinished, (RatingFlowState) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RatingFlowState j1(RatingFlowEvent.OnReviewPreparationFinished onReviewPreparationFinished, RatingFlowState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return RatingFlowState.b(updateState, false, true, onReviewPreparationFinished.a(), null, null, 25, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k1() {
        G0(new RatingFlowViewModel$launchRatingFlowOrFallback$1(this, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RatingFlowState m1(RatingFlowState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return RatingFlowState.b(updateState, false, true, false, null, null, 25, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RatingFlowState n1(RatingFlowState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return RatingFlowState.b(updateState, false, false, false, null, null, 29, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RatingFlowState o1(RatingFlowState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return RatingFlowState.b(updateState, false, false, false, null, null, 29, null);
    }

    private final void p1(long j3) {
        G0(new RatingFlowViewModel$setShownDate$1(this, j3, null));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel
    /* JADX INFO: renamed from: l1, reason: merged with bridge method [inline-methods] */
    public void O0(RatingFlowEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (Intrinsics.areEqual(event, RatingFlowEvent.OnScreenShown.f96134a)) {
            return;
        }
        if (event instanceof RatingFlowEvent.OnReviewPreparationFinished) {
            i1((RatingFlowEvent.OnReviewPreparationFinished) event);
            return;
        }
        if (Intrinsics.areEqual(event, RatingFlowEvent.OnReviewPreparationFailed.f96132a)) {
            Q0(new Function1() { // from class: cz.mobilesoft.coreblock.activity.rating.o1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return RatingFlowViewModel.m1((RatingFlowState) obj);
                }
            });
            return;
        }
        if (Intrinsics.areEqual(event, RatingFlowEvent.OnReviewPreparationCancelled.f96131a)) {
            G0(new RatingFlowViewModel$onEvent$2(this, null));
            return;
        }
        if (Intrinsics.areEqual(event, RatingFlowEvent.OnDismissRequested.f96125a)) {
            p1(System.currentTimeMillis());
            AnswersHelper.z4(new AnswersHelper.RatingShownEvent(null, "later"), this.f96141o, false, 4, null);
            G0(new RatingFlowViewModel$onEvent$3(this, null));
            return;
        }
        if (Intrinsics.areEqual(event, RatingFlowEvent.OnLoveItClicked.f96128a)) {
            Q0(new Function1() { // from class: cz.mobilesoft.coreblock.activity.rating.p1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return RatingFlowViewModel.n1((RatingFlowState) obj);
                }
            });
            AnswersHelper.w4(true, this.f96141o);
            G0(new RatingFlowViewModel$onEvent$5(this, null));
            return;
        }
        if (Intrinsics.areEqual(event, RatingFlowEvent.OnRateNoClicked.f96129a)) {
            Q0(new Function1() { // from class: cz.mobilesoft.coreblock.activity.rating.q1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return RatingFlowViewModel.o1((RatingFlowState) obj);
                }
            });
            AnswersHelper.w4(false, this.f96141o);
            G0(new RatingFlowViewModel$onEvent$7(this, null));
            return;
        }
        if (event instanceof RatingFlowEvent.OnCloseClicked) {
            AnswersHelper.x4(((RatingFlowEvent.OnCloseClicked) event).a().getAnalyticsValue(), this.f96141o);
            AnswersHelper.z4(new AnswersHelper.RatingShownEvent(null, "later"), this.f96141o, false, 4, null);
            p1(System.currentTimeMillis());
            G0(new RatingFlowViewModel$onEvent$8(this, null));
            return;
        }
        if (event instanceof RatingFlowEvent.OnReviewFlowFinished) {
            G0(new RatingFlowViewModel$onEvent$9(event, this, null));
            return;
        }
        if (Intrinsics.areEqual(event, RatingFlowEvent.OnFeedbackSendClicked.f96127a)) {
            AnswersHelper.z4(new AnswersHelper.RatingShownEvent(null, "confirm", "send_feedback"), this.f96141o, false, 4, null);
            p1(-1L);
            G0(new RatingFlowViewModel$onEvent$10(this, null));
        } else {
            if (!Intrinsics.areEqual(event, RatingFlowEvent.OnFeedbackDismissed.f96126a)) {
                throw new NoWhenBranchMatchedException();
            }
            AnswersHelper.z4(new AnswersHelper.RatingShownEvent(null, "confirm", "no_feedback"), this.f96141o, false, 4, null);
            p1(-1L);
            G0(new RatingFlowViewModel$onEvent$11(this, null));
        }
    }
}
