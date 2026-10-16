package com.superwall.sdk.paywall.presentation.internal.operators;

import android.app.Activity;
import com.superwall.sdk.Superwall;
import com.superwall.sdk.analytics.internal.TrackingKt;
import com.superwall.sdk.analytics.internal.trackable.InternalSuperwallEvent;
import com.superwall.sdk.logger.LogLevel;
import com.superwall.sdk.logger.LogScope;
import com.superwall.sdk.logger.Logger;
import com.superwall.sdk.models.paywall.PaywallPresentationStyle;
import com.superwall.sdk.models.triggers.Experiment;
import com.superwall.sdk.models.triggers.TriggerRuleOccurrence;
import com.superwall.sdk.paywall.presentation.internal.InternalPresentationLogic;
import com.superwall.sdk.paywall.presentation.internal.PaywallPresentationRequestStatus;
import com.superwall.sdk.paywall.presentation.internal.PaywallPresentationRequestStatusReason;
import com.superwall.sdk.paywall.presentation.internal.PresentationRequest;
import com.superwall.sdk.paywall.presentation.internal.operators.PresentPaywallKt;
import com.superwall.sdk.paywall.presentation.internal.request.PaywallOverrides;
import com.superwall.sdk.paywall.presentation.internal.state.PaywallState;
import com.superwall.sdk.paywall.view.PaywallActivityLaunchException;
import com.superwall.sdk.paywall.view.PaywallView;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

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
public final class PresentPaywallKt {

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.presentation.internal.operators.PresentPaywallKt$presentPaywallView$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.presentation.internal.operators.PresentPaywallKt$presentPaywallView$2", f = "PresentPaywall.kt", l = {59}, m = "invokeSuspend")
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Superwall $this_presentPaywallView;
        final /* synthetic */ InternalSuperwallEvent.PresentationRequest $trackedEvent;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Superwall superwall, InternalSuperwallEvent.PresentationRequest presentationRequest, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$this_presentPaywallView = superwall;
            this.$trackedEvent = presentationRequest;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$this_presentPaywallView, this.$trackedEvent, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                Superwall superwall = this.$this_presentPaywallView;
                InternalSuperwallEvent.PresentationRequest presentationRequest = this.$trackedEvent;
                this.label = 1;
                if (TrackingKt.track(superwall, presentationRequest, this) == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                ((Result) obj).j();
            }
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.presentation.internal.operators.PresentPaywallKt$presentPaywallView$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.presentation.internal.operators.PresentPaywallKt$presentPaywallView$3", f = "PresentPaywall.kt", l = {98, 99, 102}, m = "invokeSuspend")
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Map<String, Object> $debugInfo;
        final /* synthetic */ Experiment $experiment;
        final /* synthetic */ MutableSharedFlow<PaywallState> $paywallStatePublisher;
        final /* synthetic */ PaywallView $paywallView;
        final /* synthetic */ Activity $presenter;
        final /* synthetic */ PresentationRequest $request;
        final /* synthetic */ Superwall $this_presentPaywallView;
        final /* synthetic */ TriggerRuleOccurrence $unsavedOccurrence;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(PaywallView paywallView, Activity activity, PresentationRequest presentationRequest, TriggerRuleOccurrence triggerRuleOccurrence, MutableSharedFlow<PaywallState> mutableSharedFlow, Experiment experiment, Superwall superwall, Map<String, ? extends Object> map, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.$paywallView = paywallView;
            this.$presenter = activity;
            this.$request = presentationRequest;
            this.$unsavedOccurrence = triggerRuleOccurrence;
            this.$paywallStatePublisher = mutableSharedFlow;
            this.$experiment = experiment;
            this.$this_presentPaywallView = superwall;
            this.$debugInfo = map;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$0(PaywallView paywallView, Superwall superwall, Map map, MutableSharedFlow mutableSharedFlow, boolean z2) throws PaywallPresentationRequestStatusReason.PaywallAlreadyPresented {
            if (z2) {
                BuildersKt__Builders_commonKt.d(superwall.getIoScope$superwall_release(), null, null, new PresentPaywallKt$presentPaywallView$3$1$1(mutableSharedFlow, new PaywallState.Presented(paywallView.getInfo()), null), 3, null);
                return Unit.f139807a;
            }
            Logger.debug$default(Logger.INSTANCE, LogLevel.info, LogScope.paywallPresentation, "Paywall Already Presented", map, (Throwable) null, 16, (Object) null);
            BuildersKt__Builders_commonKt.d(superwall.getIoScope$superwall_release(), null, null, new PresentPaywallKt$presentPaywallView$3$1$2(mutableSharedFlow, InternalPresentationLogic.INSTANCE.presentationError("SWKPresentationError", 102, "Paywall Already Presented", "Trying to present paywall while another paywall is presented."), null), 3, null);
            throw new PaywallPresentationRequestStatusReason.PaywallAlreadyPresented();
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass3(this.$paywallView, this.$presenter, this.$request, this.$unsavedOccurrence, this.$paywallStatePublisher, this.$experiment, this.$this_presentPaywallView, this.$debugInfo, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            PaywallActivityLaunchException paywallActivityLaunchException;
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                try {
                    PaywallView paywallView = this.$paywallView;
                    Activity activity = this.$presenter;
                    PresentationRequest presentationRequest = this.$request;
                    TriggerRuleOccurrence triggerRuleOccurrence = this.$unsavedOccurrence;
                    PaywallOverrides paywallOverrides = presentationRequest.getPaywallOverrides();
                    PaywallPresentationStyle presentationStyle = paywallOverrides != null ? paywallOverrides.getPresentationStyle() : null;
                    final MutableSharedFlow<PaywallState> mutableSharedFlow = this.$paywallStatePublisher;
                    Experiment experiment = this.$experiment;
                    final PaywallView paywallView2 = this.$paywallView;
                    final Superwall superwall = this.$this_presentPaywallView;
                    final Map<String, Object> map = this.$debugInfo;
                    paywallView.present(activity, presentationRequest, triggerRuleOccurrence, presentationStyle, mutableSharedFlow, experiment, new Function1() { // from class: com.superwall.sdk.paywall.presentation.internal.operators.a
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return PresentPaywallKt.AnonymousClass3.invokeSuspend$lambda$0(paywallView2, superwall, map, mutableSharedFlow, ((Boolean) obj2).booleanValue());
                        }
                    });
                    return Unit.f139807a;
                } catch (PaywallActivityLaunchException e3) {
                    MutableSharedFlow<PaywallState> mutableSharedFlow2 = this.$paywallStatePublisher;
                    PaywallState.PresentationError presentationError = new PaywallState.PresentationError(e3);
                    this.L$0 = e3;
                    this.label = 1;
                    if (mutableSharedFlow2.emit(presentationError, this) != objF) {
                        paywallActivityLaunchException = e3;
                    }
                } catch (Throwable th) {
                    Superwall superwall2 = this.$this_presentPaywallView;
                    PresentationRequest presentationRequest2 = this.$request;
                    this.L$0 = th;
                    this.label = 3;
                    if (LogErrorsKt.logErrors(superwall2, presentationRequest2, th, this) != objF) {
                        throw th;
                    }
                }
            } else {
                if (i3 != 1) {
                    if (i3 == 2) {
                        PaywallActivityLaunchException paywallActivityLaunchException2 = (PaywallActivityLaunchException) this.L$0;
                        ResultKt.b(obj);
                        throw paywallActivityLaunchException2;
                    }
                    if (i3 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    Throwable th2 = (Throwable) this.L$0;
                    ResultKt.b(obj);
                    throw th2;
                }
                paywallActivityLaunchException = (PaywallActivityLaunchException) this.L$0;
                ResultKt.b(obj);
            }
            Superwall superwall3 = this.$this_presentPaywallView;
            PresentationRequest presentationRequest3 = this.$request;
            this.L$0 = paywallActivityLaunchException;
            this.label = 2;
            if (LogErrorsKt.logErrors(superwall3, presentationRequest3, paywallActivityLaunchException, this) == objF) {
                return objF;
            }
            throw paywallActivityLaunchException;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.presentation.internal.operators.PresentPaywallKt$presentPaywallViewSync$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.presentation.internal.operators.PresentPaywallKt$presentPaywallViewSync$1", f = "PresentPaywall.kt", l = {129}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Map<String, Object> $debugInfo;
        final /* synthetic */ Experiment $experiment;
        final /* synthetic */ Function1<PaywallState, Unit> $onStateChanged;
        final /* synthetic */ PaywallView $paywallView;
        final /* synthetic */ Activity $presenter;
        final /* synthetic */ PresentationRequest $request;
        final /* synthetic */ Superwall $this_presentPaywallViewSync;
        final /* synthetic */ TriggerRuleOccurrence $unsavedOccurrence;
        int label;

        /* JADX INFO: renamed from: com.superwall.sdk.paywall.presentation.internal.operators.PresentPaywallKt$presentPaywallViewSync$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @DebugMetadata(c = "com.superwall.sdk.paywall.presentation.internal.operators.PresentPaywallKt$presentPaywallViewSync$1$1", f = "PresentPaywall.kt", l = {125}, m = "invokeSuspend")
        static final class C02411 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function1<PaywallState, Unit> $onStateChanged;
            final /* synthetic */ MutableSharedFlow<PaywallState> $publisher;
            int label;

            /* JADX INFO: renamed from: com.superwall.sdk.paywall.presentation.internal.operators.PresentPaywallKt$presentPaywallViewSync$1$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            @DebugMetadata(c = "com.superwall.sdk.paywall.presentation.internal.operators.PresentPaywallKt$presentPaywallViewSync$1$1$1", f = "PresentPaywall.kt", l = {}, m = "invokeSuspend")
            static final class C02421 extends SuspendLambda implements Function2<PaywallState, Continuation<? super Unit>, Object> {
                final /* synthetic */ Function1<PaywallState, Unit> $onStateChanged;
                /* synthetic */ Object L$0;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                C02421(Function1<? super PaywallState, Unit> function1, Continuation<? super C02421> continuation) {
                    super(2, continuation);
                    this.$onStateChanged = function1;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    C02421 c02421 = new C02421(this.$onStateChanged, continuation);
                    c02421.L$0 = obj;
                    return c02421;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(PaywallState paywallState, Continuation<? super Unit> continuation) {
                    return ((C02421) create(paywallState, continuation)).invokeSuspend(Unit.f139807a);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) throws Throwable {
                    IntrinsicsKt.f();
                    if (this.label != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                    this.$onStateChanged.invoke((PaywallState) this.L$0);
                    return Unit.f139807a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            C02411(MutableSharedFlow<PaywallState> mutableSharedFlow, Function1<? super PaywallState, Unit> function1, Continuation<? super C02411> continuation) {
                super(2, continuation);
                this.$publisher = mutableSharedFlow;
                this.$onStateChanged = function1;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C02411(this.$publisher, this.$onStateChanged, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objF = IntrinsicsKt.f();
                int i3 = this.label;
                if (i3 == 0) {
                    ResultKt.b(obj);
                    MutableSharedFlow<PaywallState> mutableSharedFlow = this.$publisher;
                    C02421 c02421 = new C02421(this.$onStateChanged, null);
                    this.label = 1;
                    if (FlowKt.l(mutableSharedFlow, c02421, this) == objF) {
                        return objF;
                    }
                } else {
                    if (i3 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                }
                return Unit.f139807a;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C02411) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(Superwall superwall, PaywallView paywallView, Activity activity, TriggerRuleOccurrence triggerRuleOccurrence, Map<String, ? extends Object> map, PresentationRequest presentationRequest, Experiment experiment, Function1<? super PaywallState, Unit> function1, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$this_presentPaywallViewSync = superwall;
            this.$paywallView = paywallView;
            this.$presenter = activity;
            this.$unsavedOccurrence = triggerRuleOccurrence;
            this.$debugInfo = map;
            this.$request = presentationRequest;
            this.$experiment = experiment;
            this.$onStateChanged = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$this_presentPaywallViewSync, this.$paywallView, this.$presenter, this.$unsavedOccurrence, this.$debugInfo, this.$request, this.$experiment, this.$onStateChanged, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                MutableSharedFlow mutableSharedFlowB = SharedFlowKt.b(0, 0, null, 7, null);
                BuildersKt__Builders_commonKt.d(this.$this_presentPaywallViewSync.getIoScope$superwall_release(), null, null, new C02411(mutableSharedFlowB, this.$onStateChanged, null), 3, null);
                Superwall superwall = this.$this_presentPaywallViewSync;
                PaywallView paywallView = this.$paywallView;
                Activity activity = this.$presenter;
                TriggerRuleOccurrence triggerRuleOccurrence = this.$unsavedOccurrence;
                Map<String, Object> map = this.$debugInfo;
                PresentationRequest presentationRequest = this.$request;
                Experiment experiment = this.$experiment;
                this.label = 1;
                if (PresentPaywallKt.presentPaywallView(superwall, paywallView, activity, triggerRuleOccurrence, map, presentationRequest, mutableSharedFlowB, experiment, this) == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    public static final Object presentPaywallView(Superwall superwall, PaywallView paywallView, Activity activity, TriggerRuleOccurrence triggerRuleOccurrence, Map<String, ? extends Object> map, PresentationRequest presentationRequest, MutableSharedFlow<PaywallState> mutableSharedFlow, Experiment experiment, Continuation<? super Unit> continuation) {
        BuildersKt__Builders_commonKt.d(superwall.getIoScope$superwall_release(), null, null, new AnonymousClass2(superwall, new InternalSuperwallEvent.PresentationRequest(presentationRequest.getPresentationInfo().getEventData(), presentationRequest.getFlags().getType(), PaywallPresentationRequestStatus.Presentation.INSTANCE, null, superwall.getDependencyContainer$superwall_release(), null, 32, null), null), 3, null);
        Object objG = BuildersKt.g(Dispatchers.c(), new AnonymousClass3(paywallView, activity, presentationRequest, triggerRuleOccurrence, mutableSharedFlow, experiment, superwall, map, null), continuation);
        return objG == IntrinsicsKt.f() ? objG : Unit.f139807a;
    }

    public static final void presentPaywallViewSync(Superwall superwall, PaywallView paywallView, Activity presenter, TriggerRuleOccurrence triggerRuleOccurrence, Map<String, ? extends Object> debugInfo, PresentationRequest request, Experiment experiment, Function1<? super PaywallState, Unit> onStateChanged) {
        Intrinsics.checkNotNullParameter(superwall, "<this>");
        Intrinsics.checkNotNullParameter(paywallView, "paywallView");
        Intrinsics.checkNotNullParameter(presenter, "presenter");
        Intrinsics.checkNotNullParameter(debugInfo, "debugInfo");
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(onStateChanged, "onStateChanged");
        BuildersKt__Builders_commonKt.d(superwall.getMainScope$superwall_release(), null, null, new AnonymousClass1(superwall, paywallView, presenter, triggerRuleOccurrence, debugInfo, request, experiment, onStateChanged, null), 3, null);
    }
}
