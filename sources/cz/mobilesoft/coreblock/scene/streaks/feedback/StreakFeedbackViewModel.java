package cz.mobilesoft.coreblock.scene.streaks.feedback;

import android.app.Application;
import android.util.Patterns;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel;
import cz.mobilesoft.coreblock.scene.feedback.FeedbackViewCommand;
import cz.mobilesoft.coreblock.scene.feedback.FeedbackViewEvent;
import cz.mobilesoft.coreblock.scene.feedback.FeedbackViewState;
import cz.mobilesoft.coreblock.scene.streaks.feedback.StreakFeedbackViewModel;
import cz.mobilesoft.coreblock.storage.datastore.SessionDataStore;
import cz.mobilesoft.coreblock.usecase.SendContactSupportDetailedRequestUseCase;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
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
@Metadata
public final class StreakFeedbackViewModel extends BaseStatefulViewModel<FeedbackViewState, FeedbackViewEvent, FeedbackViewCommand> {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Lazy f120853o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final Lazy f120854p;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.streaks.feedback.StreakFeedbackViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.streaks.feedback.StreakFeedbackViewModel$1", f = "StreakFeedbackViewModel.kt", l = {33}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f120855a;

        AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final FeedbackViewState q(String str, FeedbackViewState feedbackViewState) {
            return feedbackViewState.a((10223 & 1) != 0 ? feedbackViewState.f102177a : null, (10223 & 2) != 0 ? feedbackViewState.f102178b : str, (10223 & 4) != 0 ? feedbackViewState.f102179c : null, (10223 & 8) != 0 ? feedbackViewState.f102180d : null, (10223 & 16) != 0 ? feedbackViewState.f102181f : null, (10223 & 32) != 0 ? feedbackViewState.f102182g : false, (10223 & 64) != 0 ? feedbackViewState.f102183h : false, (10223 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? feedbackViewState.f102184i : 0, (10223 & Function.MAX_NARGS) != 0 ? feedbackViewState.f102185j : null, (10223 & 512) != 0 ? feedbackViewState.f102186k : null, (10223 & 1024) != 0 ? feedbackViewState.f102187l : StringsKt.p0(str), (10223 & 2048) != 0 ? feedbackViewState.f102188m : false, (10223 & 4096) != 0 ? feedbackViewState.f102189n : false, (10223 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? feedbackViewState.f102190o : false);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return StreakFeedbackViewModel.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f120855a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowS = StreakFeedbackViewModel.this.a1().S();
                this.f120855a = 1;
                obj = FlowKt.D(flowS, this);
                if (obj == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            final String str = (String) obj;
            StreakFeedbackViewModel.this.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.streaks.feedback.w
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return StreakFeedbackViewModel.AnonymousClass1.q(str, (FeedbackViewState) obj2);
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
    public StreakFeedbackViewModel(Application application) {
        super(application, new FeedbackViewState(null, null, null, null, null, false, false, 0, null, null, false, false, false, false, 16383, null));
        Intrinsics.checkNotNullParameter(application, "application");
        final Qualifier qualifier = null;
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f120853o = LazyKt.a(lazyThreadSafetyModeB, new Function0<SendContactSupportDetailedRequestUseCase>() { // from class: cz.mobilesoft.coreblock.scene.streaks.feedback.StreakFeedbackViewModel$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(SendContactSupportDetailedRequestUseCase.class), qualifier, objArr);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB2 = koinPlatformTools.b();
        final Object[] objArr2 = 0 == true ? 1 : 0;
        final Object[] objArr3 = 0 == true ? 1 : 0;
        this.f120854p = LazyKt.a(lazyThreadSafetyModeB2, new Function0<SessionDataStore>() { // from class: cz.mobilesoft.coreblock.scene.streaks.feedback.StreakFeedbackViewModel$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(SessionDataStore.class), objArr2, objArr3);
            }
        });
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass1(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SendContactSupportDetailedRequestUseCase Z0() {
        return (SendContactSupportDetailedRequestUseCase) this.f120853o.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SessionDataStore a1() {
        return (SessionDataStore) this.f120854p.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FeedbackViewState c1(FeedbackViewEvent feedbackViewEvent, FeedbackViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return updateState.a((10223 & 1) != 0 ? updateState.f102177a : ((FeedbackViewEvent.OnMessageChanged) feedbackViewEvent).a(), (10223 & 2) != 0 ? updateState.f102178b : null, (10223 & 4) != 0 ? updateState.f102179c : null, (10223 & 8) != 0 ? updateState.f102180d : null, (10223 & 16) != 0 ? updateState.f102181f : null, (10223 & 32) != 0 ? updateState.f102182g : false, (10223 & 64) != 0 ? updateState.f102183h : false, (10223 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? updateState.f102184i : 0, (10223 & Function.MAX_NARGS) != 0 ? updateState.f102185j : SetsKt.minus((Set<? extends FeedbackViewState.FeedbackValidationError>) updateState.n(), FeedbackViewState.FeedbackValidationError.MessageIsEmpty), (10223 & 512) != 0 ? updateState.f102186k : null, (10223 & 1024) != 0 ? updateState.f102187l : false, (10223 & 2048) != 0 ? updateState.f102188m : false, (10223 & 4096) != 0 ? updateState.f102189n : false, (10223 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? updateState.f102190o : false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FeedbackViewState d1(FeedbackViewEvent feedbackViewEvent, FeedbackViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return updateState.a((10223 & 1) != 0 ? updateState.f102177a : null, (10223 & 2) != 0 ? updateState.f102178b : ((FeedbackViewEvent.OnEmailChanged) feedbackViewEvent).a(), (10223 & 4) != 0 ? updateState.f102179c : null, (10223 & 8) != 0 ? updateState.f102180d : null, (10223 & 16) != 0 ? updateState.f102181f : null, (10223 & 32) != 0 ? updateState.f102182g : false, (10223 & 64) != 0 ? updateState.f102183h : false, (10223 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? updateState.f102184i : 0, (10223 & Function.MAX_NARGS) != 0 ? updateState.f102185j : SetsKt.minus((Set<? extends FeedbackViewState.FeedbackValidationError>) updateState.n(), FeedbackViewState.FeedbackValidationError.EmailIsInvalid), (10223 & 512) != 0 ? updateState.f102186k : null, (10223 & 1024) != 0 ? updateState.f102187l : false, (10223 & 2048) != 0 ? updateState.f102188m : false, (10223 & 4096) != 0 ? updateState.f102189n : false, (10223 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? updateState.f102190o : false);
    }

    private final void e1() {
        FeedbackViewState feedbackViewState = (FeedbackViewState) I0();
        final Set setH1 = h1(feedbackViewState);
        if (!setH1.isEmpty()) {
            Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.streaks.feedback.u
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return StreakFeedbackViewModel.f1(setH1, (FeedbackViewState) obj);
                }
            });
        } else {
            Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.streaks.feedback.v
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return StreakFeedbackViewModel.g1((FeedbackViewState) obj);
                }
            });
            BuildersKt__Builders_commonKt.d(C0(), null, null, new StreakFeedbackViewModel$send$3(this, feedbackViewState, null), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FeedbackViewState f1(Set set, FeedbackViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return updateState.a((10223 & 1) != 0 ? updateState.f102177a : null, (10223 & 2) != 0 ? updateState.f102178b : null, (10223 & 4) != 0 ? updateState.f102179c : null, (10223 & 8) != 0 ? updateState.f102180d : null, (10223 & 16) != 0 ? updateState.f102181f : null, (10223 & 32) != 0 ? updateState.f102182g : false, (10223 & 64) != 0 ? updateState.f102183h : false, (10223 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? updateState.f102184i : 0, (10223 & Function.MAX_NARGS) != 0 ? updateState.f102185j : set, (10223 & 512) != 0 ? updateState.f102186k : null, (10223 & 1024) != 0 ? updateState.f102187l : false, (10223 & 2048) != 0 ? updateState.f102188m : false, (10223 & 4096) != 0 ? updateState.f102189n : false, (10223 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? updateState.f102190o : false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FeedbackViewState g1(FeedbackViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return updateState.a((10223 & 1) != 0 ? updateState.f102177a : null, (10223 & 2) != 0 ? updateState.f102178b : null, (10223 & 4) != 0 ? updateState.f102179c : null, (10223 & 8) != 0 ? updateState.f102180d : null, (10223 & 16) != 0 ? updateState.f102181f : null, (10223 & 32) != 0 ? updateState.f102182g : false, (10223 & 64) != 0 ? updateState.f102183h : true, (10223 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? updateState.f102184i : 0, (10223 & Function.MAX_NARGS) != 0 ? updateState.f102185j : null, (10223 & 512) != 0 ? updateState.f102186k : null, (10223 & 1024) != 0 ? updateState.f102187l : false, (10223 & 2048) != 0 ? updateState.f102188m : false, (10223 & 4096) != 0 ? updateState.f102189n : false, (10223 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? updateState.f102190o : false);
    }

    private final Set h1(FeedbackViewState feedbackViewState) {
        Set setCreateSetBuilder = SetsKt.createSetBuilder();
        if (StringsKt.p0(feedbackViewState.i())) {
            setCreateSetBuilder.add(FeedbackViewState.FeedbackValidationError.MessageIsEmpty);
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(feedbackViewState.f()).matches()) {
            setCreateSetBuilder.add(FeedbackViewState.FeedbackValidationError.EmailIsInvalid);
        }
        return SetsKt.build(setCreateSetBuilder);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel
    /* JADX INFO: renamed from: b1, reason: merged with bridge method [inline-methods] */
    public void O0(final FeedbackViewEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        super.O0(event);
        if (event instanceof FeedbackViewEvent.OnMessageChanged) {
            Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.streaks.feedback.s
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return StreakFeedbackViewModel.c1(event, (FeedbackViewState) obj);
                }
            });
        } else if (event instanceof FeedbackViewEvent.OnEmailChanged) {
            Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.streaks.feedback.t
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return StreakFeedbackViewModel.d1(event, (FeedbackViewState) obj);
                }
            });
        } else if (Intrinsics.areEqual(event, FeedbackViewEvent.OnSendClicked.f102079a)) {
            e1();
        }
    }
}
