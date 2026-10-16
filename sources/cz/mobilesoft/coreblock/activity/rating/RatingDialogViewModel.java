package cz.mobilesoft.coreblock.activity.rating;

import android.app.Application;
import cz.mobilesoft.coreblock.activity.rating.RatingDialogEvent;
import cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel;
import cz.mobilesoft.coreblock.storage.datastore.RatingDataStore;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
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
public final class RatingDialogViewModel extends BaseStatefulViewModel<RatingDialogState, RatingDialogEvent, RatingDialogCommand> {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final RatingTriggerSource f96084o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final boolean f96085p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final Lazy f96086q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public RatingDialogViewModel(Application application, RatingTriggerSource source, boolean z2) {
        super(application, new RatingDialogState(false, 1, null));
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(source, "source");
        final Qualifier qualifier = null;
        this.f96084o = source;
        this.f96085p = z2;
        LazyThreadSafetyMode lazyThreadSafetyModeB = KoinPlatformTools.f146106a.b();
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f96086q = LazyKt.a(lazyThreadSafetyModeB, new Function0<RatingDataStore>() { // from class: cz.mobilesoft.coreblock.activity.rating.RatingDialogViewModel$special$$inlined$inject$default$1
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RatingDataStore b1() {
        return (RatingDataStore) this.f96086q.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RatingDialogState d1(RatingDialogState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return updateState.a(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RatingDialogState e1(RatingDialogState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return updateState.a(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RatingDialogState f1(RatingDialogState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return updateState.a(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RatingDialogState g1(RatingDialogState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return updateState.a(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RatingDialogState h1(RatingDialogState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return updateState.a(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RatingDialogState i1(RatingDialogState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return updateState.a(false);
    }

    private final void j1(long j3) {
        G0(new RatingDialogViewModel$setShownDate$1(this, j3, null));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel
    /* JADX INFO: renamed from: c1, reason: merged with bridge method [inline-methods] */
    public void O0(RatingDialogEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof RatingDialogEvent.OnReviewPreparationFinished) {
            Q0(new Function1() { // from class: cz.mobilesoft.coreblock.activity.rating.o0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return RatingDialogViewModel.d1((RatingDialogState) obj);
                }
            });
            G0(new RatingDialogViewModel$onEvent$2(event, this, null));
            return;
        }
        if (Intrinsics.areEqual(event, RatingDialogEvent.OnReviewPreparationFailed.f96081a)) {
            Q0(new Function1() { // from class: cz.mobilesoft.coreblock.activity.rating.p0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return RatingDialogViewModel.e1((RatingDialogState) obj);
                }
            });
            return;
        }
        if (Intrinsics.areEqual(event, RatingDialogEvent.OnPlayStoreDialogReady.f96077a)) {
            Q0(new Function1() { // from class: cz.mobilesoft.coreblock.activity.rating.q0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return RatingDialogViewModel.f1((RatingDialogState) obj);
                }
            });
            return;
        }
        if (Intrinsics.areEqual(event, RatingDialogEvent.OnDialogReady.f96070a)) {
            Q0(new Function1() { // from class: cz.mobilesoft.coreblock.activity.rating.r0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return RatingDialogViewModel.g1((RatingDialogState) obj);
                }
            });
            return;
        }
        if (Intrinsics.areEqual(event, RatingDialogEvent.OnReviewPreparationCancelled.f96080a)) {
            G0(new RatingDialogViewModel$onEvent$6(this, null));
            return;
        }
        if (Intrinsics.areEqual(event, RatingDialogEvent.OnDismissRequested.f96071a)) {
            j1(System.currentTimeMillis());
            AnswersHelper.z4(new AnswersHelper.RatingShownEvent(null, "later"), this.f96084o, false, 4, null);
            G0(new RatingDialogViewModel$onEvent$7(this, null));
            return;
        }
        if (Intrinsics.areEqual(event, RatingDialogEvent.OnLoveItClicked.f96074a)) {
            Q0(new Function1() { // from class: cz.mobilesoft.coreblock.activity.rating.s0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return RatingDialogViewModel.h1((RatingDialogState) obj);
                }
            });
            AnswersHelper.w4(true, this.f96084o);
            G0(new RatingDialogViewModel$onEvent$9(this, null));
            return;
        }
        if (Intrinsics.areEqual(event, RatingDialogEvent.OnRateNoClicked.f96078a)) {
            Q0(new Function1() { // from class: cz.mobilesoft.coreblock.activity.rating.t0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return RatingDialogViewModel.i1((RatingDialogState) obj);
                }
            });
            AnswersHelper.w4(false, this.f96084o);
            G0(new RatingDialogViewModel$onEvent$11(this, null));
            return;
        }
        if (Intrinsics.areEqual(event, RatingDialogEvent.OnCloseClicked.f96069a)) {
            AnswersHelper.z4(new AnswersHelper.RatingShownEvent(null, "later"), this.f96084o, false, 4, null);
            j1(System.currentTimeMillis());
            G0(new RatingDialogViewModel$onEvent$12(this, null));
            return;
        }
        if (event instanceof RatingDialogEvent.OnReviewFlowFinished) {
            G0(new RatingDialogViewModel$onEvent$13(event, this, null));
            return;
        }
        if (Intrinsics.areEqual(event, RatingDialogEvent.OnPlayStoreButtonClicked.f96075a)) {
            j1(-1L);
            AnswersHelper.z4(new AnswersHelper.RatingShownEvent(Boolean.TRUE, "confirm"), this.f96084o, false, 4, null);
            G0(new RatingDialogViewModel$onEvent$14(this, null));
            return;
        }
        if (Intrinsics.areEqual(event, RatingDialogEvent.OnPlayStoreDialogDismissed.f96076a)) {
            j1(System.currentTimeMillis());
            AnswersHelper.z4(new AnswersHelper.RatingShownEvent(null, "later"), this.f96084o, false, 4, null);
            G0(new RatingDialogViewModel$onEvent$15(this, null));
        } else if (Intrinsics.areEqual(event, RatingDialogEvent.OnFeedbackSendClicked.f96073a)) {
            AnswersHelper.z4(new AnswersHelper.RatingShownEvent(null, "confirm", "send_feedback"), this.f96084o, false, 4, null);
            j1(-1L);
            G0(new RatingDialogViewModel$onEvent$16(this, null));
        } else {
            if (!Intrinsics.areEqual(event, RatingDialogEvent.OnFeedbackDismissed.f96072a)) {
                throw new NoWhenBranchMatchedException();
            }
            AnswersHelper.z4(new AnswersHelper.RatingShownEvent(null, "confirm", "no_feedback"), this.f96084o, false, 4, null);
            j1(-1L);
            G0(new RatingDialogViewModel$onEvent$17(this, null));
        }
    }
}
