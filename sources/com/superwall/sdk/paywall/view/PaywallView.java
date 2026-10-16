package com.superwall.sdk.paywall.view;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.ActivityResultRegistryOwner;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.graphics.drawable.DrawableKt;
import androidx.lifecycle.LifecycleOwner;
import com.google.firebase.sessions.api.ITd.wgbAZXYjrv;
import com.superwall.sdk.R;
import com.superwall.sdk.analytics.internal.trackable.InternalSuperwallEvent;
import com.superwall.sdk.config.models.Survey;
import com.superwall.sdk.config.options.PaywallOptions;
import com.superwall.sdk.config.options.PaywallOptionsKt;
import com.superwall.sdk.dependencies.AttributesFactory;
import com.superwall.sdk.dependencies.CustomerInfoFactory;
import com.superwall.sdk.dependencies.DelegateAdapterFactory;
import com.superwall.sdk.dependencies.DeviceHelperFactory;
import com.superwall.sdk.dependencies.EnrichmentFactory;
import com.superwall.sdk.dependencies.OptionsFactory;
import com.superwall.sdk.dependencies.PresentationFactory;
import com.superwall.sdk.dependencies.TrackingFactory;
import com.superwall.sdk.dependencies.TriggerFactory;
import com.superwall.sdk.game.GameControllerDelegate;
import com.superwall.sdk.game.GameControllerEvent;
import com.superwall.sdk.game.GameControllerManager;
import com.superwall.sdk.logger.LogLevel;
import com.superwall.sdk.logger.LogScope;
import com.superwall.sdk.logger.Logger;
import com.superwall.sdk.misc.AlertControllerFactory;
import com.superwall.sdk.misc.IOScope;
import com.superwall.sdk.misc.MainScope;
import com.superwall.sdk.models.customer.CustomerInfo;
import com.superwall.sdk.models.paywall.PaywallPresentationStyle;
import com.superwall.sdk.models.triggers.Experiment;
import com.superwall.sdk.models.triggers.TriggerRuleOccurrence;
import com.superwall.sdk.network.device.DeviceHelper;
import com.superwall.sdk.paywall.manager.PaywallViewCache;
import com.superwall.sdk.paywall.presentation.PaywallCloseReason;
import com.superwall.sdk.paywall.presentation.PaywallInfo;
import com.superwall.sdk.paywall.presentation.internal.PresentationRequest;
import com.superwall.sdk.paywall.presentation.internal.state.PaywallResult;
import com.superwall.sdk.paywall.presentation.internal.state.PaywallState;
import com.superwall.sdk.paywall.view.PaywallView;
import com.superwall.sdk.paywall.view.PaywallViewState;
import com.superwall.sdk.paywall.view.delegate.PaywallLoadingState;
import com.superwall.sdk.paywall.view.delegate.PaywallViewDelegateAdapter;
import com.superwall.sdk.paywall.view.delegate.PaywallViewEventCallback;
import com.superwall.sdk.paywall.view.survey.SurveyManager;
import com.superwall.sdk.paywall.view.survey.SurveyPresentationResult;
import com.superwall.sdk.paywall.view.webview.CustomTabsHelper;
import com.superwall.sdk.paywall.view.webview.PaywallUIDelegate;
import com.superwall.sdk.paywall.view.webview.PaywallWebUI;
import com.superwall.sdk.paywall.view.webview.SWWebView;
import com.superwall.sdk.paywall.view.webview.SendPaywallMessages;
import com.superwall.sdk.paywall.view.webview.messaging.PaywallMessage;
import com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandlerDelegate;
import com.superwall.sdk.paywall.view.webview.messaging.PaywallStateDelegate;
import com.superwall.sdk.paywall.view.webview.messaging.PaywallWebEvent;
import com.superwall.sdk.storage.LocalStorage;
import com.superwall.sdk.storage.core_data.CoreDataManager;
import com.superwall.sdk.web.WebPaywallRedeemer;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URI;
import java.util.Date;
import java.util.List;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonKt;
import kotlinx.serialization.json.JsonNamingStrategy;

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
public final class PaywallView extends FrameLayout implements PaywallMessageHandlerDelegate, PaywallUIDelegate, PaywallStateDelegate, ActivityEncapsulatable, GameControllerDelegate, SendPaywallMessages {
    private static final Companion Companion = new Companion(null);
    private static final Lazy<Json> gameControllerJson$delegate = LazyKt.b(new Function0() { // from class: com.superwall.sdk.paywall.view.g
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return PaywallView.gameControllerJson_delegate$lambda$20();
        }
    });
    private static final IOScope ioScope;
    private static final MainScope mainScope;
    private ActivityResultLauncher<String> activityResultLauncher;
    private final PaywallViewCache cache;
    private PaywallViewDelegateAdapter callback;
    private final PaywallController controller;
    private Job customerInfoListener;
    private Job delayedHideJob;
    private final DeviceHelper deviceHelper;
    private WeakReference<Activity> encapsulatingActivity;
    private final PaywallViewEventCallback eventCallback;
    private final Factory factory;
    private Integer initialOrientation;
    private boolean isPaymentSheetPresented;
    private PaywallLoadingState lastHandledLoadingState;
    private PaywallPurchaseLoadingView loadingView;
    private final WebPaywallRedeemer redeemer;
    private final SendPaywallMessages sendMessages;
    private PaywallShimmerView shimmerView;
    private Job stateListener;
    private final LocalStorage storage;
    private PaywallWebUI webView;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Json getGameControllerJson() {
            return (Json) PaywallView.gameControllerJson$delegate.getValue();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public interface Factory extends TriggerFactory, OptionsFactory, DeviceHelperFactory, AttributesFactory, EnrichmentFactory, TrackingFactory, DelegateAdapterFactory, CustomerInfoFactory, PresentationFactory {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class PaywallController implements PaywallStateDelegate {
        private MutableStateFlow<PaywallViewState> _state;
        private final StateFlow<PaywallViewState> currentState;

        public PaywallController(PaywallViewState initialState) {
            Intrinsics.checkNotNullParameter(initialState, "initialState");
            MutableStateFlow<PaywallViewState> mutableStateFlowA = StateFlowKt.a(initialState);
            this._state = mutableStateFlowA;
            this.currentState = FlowKt.c(mutableStateFlowA);
        }

        public final StateFlow<PaywallViewState> getCurrentState() {
            return this.currentState;
        }

        @Override // com.superwall.sdk.paywall.view.webview.messaging.PaywallStateDelegate
        public PaywallViewState getState() {
            return (PaywallViewState) this._state.getValue();
        }

        @Override // com.superwall.sdk.paywall.view.webview.messaging.PaywallStateDelegate
        public void updateState(PaywallViewState.Updates update) {
            Object value;
            Intrinsics.checkNotNullParameter(update, "update");
            MutableStateFlow<PaywallViewState> mutableStateFlow = this._state;
            do {
                value = mutableStateFlow.getValue();
            } while (!mutableStateFlow.compareAndSet(value, (PaywallViewState) update.getTransform().invoke((PaywallViewState) value)));
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.view.PaywallView$destroyed$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.view.PaywallView", f = "PaywallView.kt", l = {494, 498}, m = "destroyed")
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PaywallView.this.destroyed(false, this);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.view.PaywallView$destroyed$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.view.PaywallView$destroyed$2", f = "PaywallView.kt", l = {468}, m = "invokeSuspend")
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PaywallView.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                PaywallView paywallView = PaywallView.this;
                this.label = 1;
                if (paywallView.trackClose(this) == objF) {
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
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.view.PaywallView$destroyed$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.view.PaywallView$destroyed$3", f = "PaywallView.kt", l = {478}, m = "invokeSuspend")
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass3(Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PaywallView.this.new AnonymousClass3(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                PaywallView paywallView = PaywallView.this;
                this.label = 1;
                if (paywallView.trackClose(this) == objF) {
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
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.view.PaywallView$eventDidOccur$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.view.PaywallView$eventDidOccur$1", f = "PaywallView.kt", l = {760}, m = "invokeSuspend")
    static final class C28621 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PaywallWebEvent $paywallWebEvent;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C28621(PaywallWebEvent paywallWebEvent, Continuation<? super C28621> continuation) {
            super(2, continuation);
            this.$paywallWebEvent = paywallWebEvent;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PaywallView.this.new C28621(this.$paywallWebEvent, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                PaywallViewEventCallback eventCallback = PaywallView.this.getEventCallback();
                if (eventCallback != null) {
                    PaywallWebEvent paywallWebEvent = this.$paywallWebEvent;
                    PaywallView paywallView = PaywallView.this;
                    this.label = 1;
                    if (eventCallback.eventDidOccur(paywallWebEvent, paywallView, this) == objF) {
                        return objF;
                    }
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
            return ((C28621) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.view.PaywallView$hideShimmerView$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.view.PaywallView$hideShimmerView$2", f = "PaywallView.kt", l = {857}, m = "invokeSuspend")
    static final class C28632 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ double $visibleDuration;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C28632(double d3, Continuation<? super C28632> continuation) {
            super(2, continuation);
            this.$visibleDuration = d3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PaywallView.this.new C28632(this.$visibleDuration, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                InternalSuperwallEvent.ShimmerLoad shimmerLoad = new InternalSuperwallEvent.ShimmerLoad(InternalSuperwallEvent.ShimmerLoad.State.Complete, PaywallView.this.getState().getPaywall().getIdentifier(), Boxing.b(this.$visibleDuration), PaywallView.this.getState().getPaywall().getPresentation().getDelay(), PaywallOptionsKt.computedShouldPreload(PaywallView.this.getFactory().makeSuperwallOptions(), PaywallView.this.getDeviceHelper().getDeviceTier()));
                Factory factory = PaywallView.this.getFactory();
                this.label = 1;
                if (factory.mo1271trackgIAlus(shimmerLoad, this) == objF) {
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
            return ((C28632) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.view.PaywallView$loadWebView$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.view.PaywallView$loadWebView$1", f = "PaywallView.kt", l = {}, m = "invokeSuspend")
    static final class C28641 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: com.superwall.sdk.paywall.view.PaywallView$loadWebView$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @DebugMetadata(c = "com.superwall.sdk.paywall.view.PaywallView$loadWebView$1$1", f = "PaywallView.kt", l = {965}, m = "invokeSuspend")
        static final class C02451 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ PaywallView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C02451(PaywallView paywallView, Continuation<? super C02451> continuation) {
                super(2, continuation);
                this.this$0 = paywallView;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C02451(this.this$0, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objF = IntrinsicsKt.f();
                int i3 = this.label;
                if (i3 == 0) {
                    ResultKt.b(obj);
                    InternalSuperwallEvent.PaywallWebviewLoad paywallWebviewLoad = new InternalSuperwallEvent.PaywallWebviewLoad(new InternalSuperwallEvent.PaywallWebviewLoad.State.Start(), this.this$0.getInfo());
                    Factory factory = this.this$0.getFactory();
                    this.label = 1;
                    if (factory.mo1271trackgIAlus(paywallWebviewLoad, this) == objF) {
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
                return ((C02451) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
            }
        }

        C28641(Continuation<? super C28641> continuation) {
            super(2, continuation);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$0(PaywallView paywallView, boolean z2, int i3) {
            paywallView.getController().updateState(PaywallViewState.Updates.CrashRetry.INSTANCE);
            Logger logger = Logger.INSTANCE;
            LogLevel logLevel = LogLevel.error;
            LogScope logScope = LogScope.paywallView;
            Logger.debug$default(logger, logLevel, logScope, "Webview Process has crashed for paywall with identifier: " + paywallView.getState().getPaywall().getIdentifier() + ".\nCrashed by the system: " + Boolean.valueOf(z2) + " - priority " + Integer.valueOf(i3), (Map) null, (Throwable) null, 24, (Object) null);
            if (paywallView.getState().getCrashRetries() < 3) {
                Logger.debug$default(logger, logLevel, logScope, "Webview crash - recreating " + paywallView.getState().getPaywall().getIdentifier(), (Map) null, (Throwable) null, 24, (Object) null);
                paywallView.recreateWebview();
            } else {
                paywallView.getController().updateState(PaywallViewState.Updates.WebLoadingFailed.INSTANCE);
                Logger.debug$default(logger, logLevel, logScope, "Webview keeps crashing - paywall " + paywallView.getState().getPaywall().getIdentifier() + " not recreated", (Map) null, (Throwable) null, 24, (Object) null);
                if (paywallView.getState().isPresented()) {
                    Logger.debug$default(logger, logLevel, logScope, "Dismissing active paywall due to webview process crash, cannot recreate", (Map) null, (Throwable) null, 24, (Object) null);
                    PaywallView.dismiss$superwall_release$default(paywallView, new PaywallResult.Declined(), PaywallCloseReason.WebViewFailedToLoad.INSTANCE, null, 4, null);
                } else {
                    BuildersKt__Builders_commonKt.d(PaywallView.mainScope, null, null, new PaywallView$loadWebView$1$2$1(paywallView, null), 3, null);
                }
            }
            return Unit.f139807a;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C28641 c28641 = PaywallView.this.new C28641(continuation);
            c28641.L$0 = obj;
            return c28641;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            String strM1295getUrl24UBhI0 = PaywallView.this.getState().getPaywall().m1295getUrl24UBhI0();
            PaywallView.this.getController().updateState(PaywallViewState.Updates.WebLoadingStarted.INSTANCE);
            BuildersKt__Builders_commonKt.d(coroutineScope, null, null, new C02451(PaywallView.this, null), 3, null);
            PaywallWebUI webView$superwall_release = PaywallView.this.getWebView$superwall_release();
            final PaywallView paywallView = PaywallView.this;
            webView$superwall_release.mo1339setupMkQ7Bds(strM1295getUrl24UBhI0, new Function2() { // from class: com.superwall.sdk.paywall.view.h
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return PaywallView.C28641.invokeSuspend$lambda$0(paywallView, ((Boolean) obj2).booleanValue(), ((Integer) obj3).intValue());
                }
            });
            PaywallView.this.getController().updateState(new PaywallViewState.Updates.SetLoadingState(PaywallLoadingState.LoadingURL.INSTANCE));
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C28641) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.view.PaywallView$onViewCreated$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.view.PaywallView$onViewCreated$1", f = "PaywallView.kt", l = {703}, m = "invokeSuspend")
    static final class C28651 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C28651(Continuation<? super C28651> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PaywallView.this.new C28651(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                PaywallView paywallView = PaywallView.this;
                this.label = 1;
                if (paywallView.trackOpen(this) == objF) {
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
            return ((C28651) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.view.PaywallView$onViewCreated$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.view.PaywallView$onViewCreated$2", f = "PaywallView.kt", l = {710}, m = "invokeSuspend")
    static final class C28662 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C28662(Continuation<? super C28662> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PaywallView.this.new C28662(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                MutableSharedFlow<PaywallState> paywallStatePublisher = PaywallView.this.getState().getPaywallStatePublisher();
                if (paywallStatePublisher != null) {
                    PaywallView paywallView = PaywallView.this;
                    Factory factory = paywallView.getFactory();
                    PresentationRequest request = paywallView.getState().getRequest();
                    this.label = 1;
                    if (factory.storePresentationObject(request, paywallStatePublisher, this) == objF) {
                        return objF;
                    }
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
            return ((C28662) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.view.PaywallView$onViewCreated$4, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.view.PaywallView$onViewCreated$4", f = "PaywallView.kt", l = {725}, m = "invokeSuspend")
    static final class AnonymousClass4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass4(Continuation<? super AnonymousClass4> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PaywallView.this.new AnonymousClass4(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                PaywallView paywallView = PaywallView.this;
                this.label = 1;
                if (paywallView.trackOpen(this) == objF) {
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
            return ((AnonymousClass4) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.view.PaywallView$present$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.view.PaywallView$present$2", f = "PaywallView.kt", l = {328, 331, 349}, m = "invokeSuspend")
    static final class C28672 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Duration $timeout;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        final /* synthetic */ PaywallView this$0;

        /* JADX INFO: renamed from: com.superwall.sdk.paywall.view.PaywallView$present$2$3, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @DebugMetadata(c = "com.superwall.sdk.paywall.view.PaywallView$present$2$3", f = "PaywallView.kt", l = {327}, m = "invokeSuspend")
        static final class AnonymousClass3 extends SuspendLambda implements Function3<FlowCollector<? super Result<? extends PaywallLoadingState>>, Throwable, Continuation<? super Unit>, Object> {
            private /* synthetic */ Object L$0;
            /* synthetic */ Object L$1;
            int label;

            AnonymousClass3(Continuation<? super AnonymousClass3> continuation) {
                super(3, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objF = IntrinsicsKt.f();
                int i3 = this.label;
                if (i3 == 0) {
                    ResultKt.b(obj);
                    FlowCollector flowCollector = (FlowCollector) this.L$0;
                    Throwable th = (Throwable) this.L$1;
                    Result.Companion companion = Result.f139772b;
                    Result resultA = Result.a(Result.b(ResultKt.a(th)));
                    this.L$0 = null;
                    this.label = 1;
                    if (flowCollector.emit(resultA, this) == objF) {
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

            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(FlowCollector<? super Result<? extends PaywallLoadingState>> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
                AnonymousClass3 anonymousClass3 = new AnonymousClass3(continuation);
                anonymousClass3.L$0 = flowCollector;
                anonymousClass3.L$1 = th;
                return anonymousClass3.invokeSuspend(Unit.f139807a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C28672(Duration duration, PaywallView paywallView, Continuation<? super C28672> continuation) {
            super(2, continuation);
            this.$timeout = duration;
            this.this$0 = paywallView;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C28672(this.$timeout, this.this$0, continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:28:0x010a, code lost:
        
            if (r1.mo1271trackgIAlus(r3, r12) == r0) goto L29;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r13) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 272
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.paywall.view.PaywallView.C28672.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C28672) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.view.PaywallView$showAlert$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.view.PaywallView$showAlert$1", f = "PaywallView.kt", l = {}, m = "invokeSuspend")
    static final class C28681 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function0<Unit> $action;
        final /* synthetic */ String $actionTitle;
        final /* synthetic */ Activity $activity;
        final /* synthetic */ String $closeActionTitle;
        final /* synthetic */ String $message;
        final /* synthetic */ Function0<Unit> $onClose;
        final /* synthetic */ String $title;
        int label;
        final /* synthetic */ PaywallView this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C28681(Activity activity, String str, String str2, String str3, String str4, PaywallView paywallView, Function0<Unit> function0, Function0<Unit> function02, Continuation<? super C28681> continuation) {
            super(2, continuation);
            this.$activity = activity;
            this.$title = str;
            this.$message = str2;
            this.$actionTitle = str3;
            this.$closeActionTitle = str4;
            this.this$0 = paywallView;
            this.$action = function0;
            this.$onClose = function02;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$0(Function0 function0) {
            if (function0 != null) {
                function0.invoke();
            }
            return Unit.f139807a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$1(Function0 function0) {
            if (function0 != null) {
                function0.invoke();
            }
            return Unit.f139807a;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C28681(this.$activity, this.$title, this.$message, this.$actionTitle, this.$closeActionTitle, this.this$0, this.$action, this.$onClose, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            AlertControllerFactory alertControllerFactory = AlertControllerFactory.INSTANCE;
            Activity activity = this.$activity;
            String str = this.$title;
            String str2 = this.$message;
            String str3 = this.$actionTitle;
            String str4 = this.$closeActionTitle;
            final Function0<Unit> function0 = this.$action;
            Function0<Unit> function02 = new Function0() { // from class: com.superwall.sdk.paywall.view.i
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return PaywallView.C28681.invokeSuspend$lambda$0(function0);
                }
            };
            final Function0<Unit> function03 = this.$onClose;
            alertControllerFactory.make(activity, str, str2, str3, str4, function02, new Function0() { // from class: com.superwall.sdk.paywall.view.j
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return PaywallView.C28681.invokeSuspend$lambda$1(function03);
                }
            }).show();
            this.this$0.getController().updateState(new PaywallViewState.Updates.SetLoadingState(PaywallLoadingState.Ready.INSTANCE));
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C28681) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.view.PaywallView$startStateListener$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.view.PaywallView$startStateListener$1", f = "PaywallView.kt", l = {244}, m = "invokeSuspend")
    static final class C28691 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        /* JADX INFO: renamed from: com.superwall.sdk.paywall.view.PaywallView$startStateListener$1$3, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @DebugMetadata(c = "com.superwall.sdk.paywall.view.PaywallView$startStateListener$1$3", f = "PaywallView.kt", l = {}, m = "invokeSuspend")
        static final class AnonymousClass3 extends SuspendLambda implements Function2<PaywallLoadingState, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ PaywallView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass3(PaywallView paywallView, Continuation<? super AnonymousClass3> continuation) {
                super(2, continuation);
                this.this$0 = paywallView;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass3(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(PaywallLoadingState paywallLoadingState, Continuation<? super Unit> continuation) {
                return ((AnonymousClass3) create(paywallLoadingState, continuation)).invokeSuspend(Unit.f139807a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                IntrinsicsKt.f();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                this.this$0.loadingStateDidChange$superwall_release();
                return Unit.f139807a;
            }
        }

        C28691(Continuation<? super C28691> continuation) {
            super(2, continuation);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean invokeSuspend$lambda$1(PaywallLoadingState paywallLoadingState, PaywallLoadingState paywallLoadingState2) {
            return paywallLoadingState.getClass() == paywallLoadingState2.getClass();
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PaywallView.this.new C28691(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                final StateFlow<PaywallViewState> currentState = PaywallView.this.getController().getCurrentState();
                Flow flowV = FlowKt.v(new Flow<PaywallLoadingState>() { // from class: com.superwall.sdk.paywall.view.PaywallView$startStateListener$1$invokeSuspend$$inlined$map$1

                    /* JADX INFO: renamed from: com.superwall.sdk.paywall.view.PaywallView$startStateListener$1$invokeSuspend$$inlined$map$1$2, reason: invalid class name */
                    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                    @Metadata
                    public static final class AnonymousClass2<T> implements FlowCollector {
                        final /* synthetic */ FlowCollector $this_unsafeFlow;

                        /* JADX INFO: renamed from: com.superwall.sdk.paywall.view.PaywallView$startStateListener$1$invokeSuspend$$inlined$map$1$2$1, reason: invalid class name */
                        @Metadata
                        @DebugMetadata(c = "com.superwall.sdk.paywall.view.PaywallView$startStateListener$1$invokeSuspend$$inlined$map$1$2", f = "PaywallView.kt", l = {50}, m = "emit")
                        public static final class AnonymousClass1 extends ContinuationImpl {
                            Object L$0;
                            int label;
                            /* synthetic */ Object result;

                            public AnonymousClass1(Continuation continuation) {
                                super(continuation);
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Object invokeSuspend(Object obj) {
                                this.result = obj;
                                this.label |= Integer.MIN_VALUE;
                                return AnonymousClass2.this.emit(null, this);
                            }
                        }

                        public AnonymousClass2(FlowCollector flowCollector) {
                            this.$this_unsafeFlow = flowCollector;
                        }

                        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct code enable 'Show inconsistent code' option in preferences
                        */
                        public final java.lang.Object emit(java.lang.Object r5, kotlin.coroutines.Continuation r6) throws java.lang.Throwable {
                            /*
                                r4 = this;
                                boolean r0 = r6 instanceof com.superwall.sdk.paywall.view.PaywallView$startStateListener$1$invokeSuspend$$inlined$map$1.AnonymousClass2.AnonymousClass1
                                if (r0 == 0) goto L13
                                r0 = r6
                                com.superwall.sdk.paywall.view.PaywallView$startStateListener$1$invokeSuspend$$inlined$map$1$2$1 r0 = (com.superwall.sdk.paywall.view.PaywallView$startStateListener$1$invokeSuspend$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                                int r1 = r0.label
                                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                                r3 = r1 & r2
                                if (r3 == 0) goto L13
                                int r1 = r1 - r2
                                r0.label = r1
                                goto L18
                            L13:
                                com.superwall.sdk.paywall.view.PaywallView$startStateListener$1$invokeSuspend$$inlined$map$1$2$1 r0 = new com.superwall.sdk.paywall.view.PaywallView$startStateListener$1$invokeSuspend$$inlined$map$1$2$1
                                r0.<init>(r6)
                            L18:
                                java.lang.Object r6 = r0.result
                                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                                int r2 = r0.label
                                r3 = 1
                                if (r2 == 0) goto L31
                                if (r2 != r3) goto L29
                                kotlin.ResultKt.b(r6)
                                goto L45
                            L29:
                                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                                r5.<init>(r6)
                                throw r5
                            L31:
                                kotlin.ResultKt.b(r6)
                                kotlinx.coroutines.flow.FlowCollector r6 = r4.$this_unsafeFlow
                                com.superwall.sdk.paywall.view.PaywallViewState r5 = (com.superwall.sdk.paywall.view.PaywallViewState) r5
                                com.superwall.sdk.paywall.view.delegate.PaywallLoadingState r5 = r5.getLoadingState()
                                r0.label = r3
                                java.lang.Object r5 = r6.emit(r5, r0)
                                if (r5 != r1) goto L45
                                return r1
                            L45:
                                kotlin.Unit r5 = kotlin.Unit.f139807a
                                return r5
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.paywall.view.PaywallView$startStateListener$1$invokeSuspend$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                        }
                    }

                    @Override // kotlinx.coroutines.flow.Flow
                    public Object collect(FlowCollector flowCollector, Continuation continuation) {
                        Object objCollect = currentState.collect(new AnonymousClass2(flowCollector), continuation);
                        return objCollect == IntrinsicsKt.f() ? objCollect : Unit.f139807a;
                    }
                }, new Function2() { // from class: com.superwall.sdk.paywall.view.k
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        return Boolean.valueOf(PaywallView.C28691.invokeSuspend$lambda$1((PaywallLoadingState) obj2, (PaywallLoadingState) obj3));
                    }
                });
                AnonymousClass3 anonymousClass3 = new AnonymousClass3(PaywallView.this, null);
                this.label = 1;
                if (FlowKt.l(flowV, anonymousClass3, this) == objF) {
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
            return ((C28691) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.view.PaywallView$startStateListener$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.view.PaywallView$startStateListener$2", f = "PaywallView.kt", l = {248}, m = "invokeSuspend")
    static final class C28702 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C28702(Continuation<? super C28702> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PaywallView.this.new C28702(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                StateFlow<CustomerInfo> stateFlowCustomerInfoFlow = PaywallView.this.getFactory().customerInfoFlow();
                final PaywallView paywallView = PaywallView.this;
                FlowCollector flowCollector = new FlowCollector() { // from class: com.superwall.sdk.paywall.view.PaywallView.startStateListener.2.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit((CustomerInfo) obj2, (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(CustomerInfo customerInfo, Continuation<? super Unit> continuation) {
                        paywallView.getController().updateState(new PaywallViewState.Updates.SetCustomerInfo(customerInfo));
                        return Unit.f139807a;
                    }
                };
                this.label = 1;
                if (stateFlowCustomerInfoFlow.collect(flowCollector, this) == objF) {
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
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C28702) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.view.PaywallView$trackClose$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.view.PaywallView", f = "PaywallView.kt", l = {755}, m = "trackClose")
    static final class C28711 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C28711(Continuation<? super C28711> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PaywallView.this.trackClose(this);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.view.PaywallView$trackOpen$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.view.PaywallView", f = "PaywallView.kt", l = {746}, m = "trackOpen")
    static final class C28721 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C28721(Continuation<? super C28721> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PaywallView.this.trackOpen(this);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.view.PaywallView$trackShimmerStart$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.view.PaywallView$trackShimmerStart$1", f = "PaywallView.kt", l = {807}, m = "invokeSuspend")
    static final class C28731 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ InternalSuperwallEvent.ShimmerLoad $trackedEvent;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C28731(InternalSuperwallEvent.ShimmerLoad shimmerLoad, Continuation<? super C28731> continuation) {
            super(2, continuation);
            this.$trackedEvent = shimmerLoad;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PaywallView.this.new C28731(this.$trackedEvent, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                Factory factory = PaywallView.this.getFactory();
                InternalSuperwallEvent.ShimmerLoad shimmerLoad = this.$trackedEvent;
                this.label = 1;
                if (factory.mo1271trackgIAlus(shimmerLoad, this) == objF) {
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
            return ((C28731) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        int i3 = 1;
        mainScope = new MainScope(0 == true ? 1 : 0, i3, 0 == true ? 1 : 0);
        ioScope = new IOScope(0 == true ? 1 : 0, i3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ PaywallView(Context context, PaywallViewEventCallback paywallViewEventCallback, PaywallViewDelegateAdapter paywallViewDelegateAdapter, DeviceHelper deviceHelper, Factory factory, LocalStorage localStorage, PaywallWebUI paywallWebUI, PaywallViewCache paywallViewCache, PaywallController paywallController, SendPaywallMessages sendPaywallMessages, WebPaywallRedeemer webPaywallRedeemer, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        WebPaywallRedeemer webPaywallRedeemer2;
        SendPaywallMessages sendPaywallMessages2;
        PaywallController paywallController2;
        PaywallViewCache paywallViewCache2;
        PaywallWebUI paywallWebUI2;
        LocalStorage localStorage2;
        Factory factory2;
        DeviceHelper deviceHelper2;
        PaywallViewDelegateAdapter paywallViewDelegateAdapter2;
        paywallViewEventCallback = (i3 & 2) != 0 ? null : paywallViewEventCallback;
        if ((i3 & 4) != 0) {
            webPaywallRedeemer2 = webPaywallRedeemer;
            sendPaywallMessages2 = sendPaywallMessages;
            paywallController2 = paywallController;
            paywallViewCache2 = paywallViewCache;
            paywallWebUI2 = paywallWebUI;
            localStorage2 = localStorage;
            factory2 = factory;
            deviceHelper2 = deviceHelper;
            paywallViewDelegateAdapter2 = null;
        } else {
            webPaywallRedeemer2 = webPaywallRedeemer;
            sendPaywallMessages2 = sendPaywallMessages;
            paywallController2 = paywallController;
            paywallViewCache2 = paywallViewCache;
            paywallWebUI2 = paywallWebUI;
            localStorage2 = localStorage;
            factory2 = factory;
            deviceHelper2 = deviceHelper;
            paywallViewDelegateAdapter2 = paywallViewDelegateAdapter;
        }
        this(context, paywallViewEventCallback, paywallViewDelegateAdapter2, deviceHelper2, factory2, localStorage2, paywallWebUI2, paywallViewCache2, paywallController2, sendPaywallMessages2, webPaywallRedeemer2);
    }

    public static /* synthetic */ void beforeOnDestroy$default(PaywallView paywallView, boolean z2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z2 = false;
        }
        paywallView.beforeOnDestroy(z2);
    }

    public static /* synthetic */ Object destroyed$default(PaywallView paywallView, boolean z2, Continuation continuation, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z2 = false;
        }
        return paywallView.destroyed(z2, continuation);
    }

    private final void dismiss(boolean z2) {
        Activity activity;
        WeakReference<Activity> encapsulatingActivity = getEncapsulatingActivity();
        if (encapsulatingActivity == null || (activity = encapsulatingActivity.get()) == null) {
            return;
        }
        activity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x01a8, code lost:
    
        if (r14 == r1) goto L71;
     */
    /* JADX WARN: Removed duplicated region for block: B:42:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0175 A[PHI: r10 r13
      0x0175: PHI (r10v10 com.superwall.sdk.paywall.view.PaywallView) = 
      (r10v1 com.superwall.sdk.paywall.view.PaywallView)
      (r10v1 com.superwall.sdk.paywall.view.PaywallView)
      (r10v1 com.superwall.sdk.paywall.view.PaywallView)
      (r10v14 com.superwall.sdk.paywall.view.PaywallView)
     binds: [B:28:0x00a9, B:29:0x00ab, B:31:0x00dc, B:59:0x016a] A[DONT_GENERATE, DONT_INLINE]
      0x0175: PHI (r13v8 com.superwall.sdk.paywall.presentation.internal.state.PaywallResult) = 
      (r13v1 com.superwall.sdk.paywall.presentation.internal.state.PaywallResult)
      (r13v1 com.superwall.sdk.paywall.presentation.internal.state.PaywallResult)
      (r13v1 com.superwall.sdk.paywall.presentation.internal.state.PaywallResult)
      (r13v11 com.superwall.sdk.paywall.presentation.internal.state.PaywallResult)
     binds: [B:28:0x00a9, B:29:0x00ab, B:31:0x00dc, B:59:0x016a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object dismiss$dismissView(com.superwall.sdk.paywall.view.PaywallView r10, boolean r11, boolean r12, com.superwall.sdk.paywall.presentation.internal.state.PaywallResult r13, kotlin.coroutines.Continuation<? super kotlin.Unit> r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 441
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.paywall.view.PaywallView.dismiss$dismissView(com.superwall.sdk.paywall.view.PaywallView, boolean, boolean, com.superwall.sdk.paywall.presentation.internal.state.PaywallResult, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Job dismiss$lambda$6(PaywallView paywallView, boolean z2, boolean z3, PaywallResult paywallResult) {
        return BuildersKt__Builders_commonKt.d(ioScope, null, null, new PaywallView$dismiss$finalDismiss$1$1(paywallView, z2, z3, paywallResult, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit dismiss$lambda$8(PaywallView paywallView, Function0 function0, SurveyPresentationResult res) {
        Intrinsics.checkNotNullParameter(res, "res");
        paywallView.controller.updateState(new PaywallViewState.Updates.UpdateSurveyState(res));
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void dismiss$superwall_release$default(PaywallView paywallView, PaywallResult paywallResult, PaywallCloseReason paywallCloseReason, Function0 function0, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            function0 = null;
        }
        paywallView.dismiss$superwall_release(paywallResult, paywallCloseReason, function0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Json gameControllerJson_delegate$lambda$20() {
        return JsonKt.b(null, new Function1() { // from class: com.superwall.sdk.paywall.view.c
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PaywallView.gameControllerJson_delegate$lambda$20$lambda$19((JsonBuilder) obj);
            }
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit gameControllerJson_delegate$lambda$20$lambda$19(JsonBuilder Json) {
        Intrinsics.checkNotNullParameter(Json, "$this$Json");
        Json.f(true);
        Json.j(JsonNamingStrategy.f143018a.c());
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hideLoadingView() {
        PaywallPurchaseLoadingView paywallPurchaseLoadingView = this.loadingView;
        if (paywallPurchaseLoadingView != null) {
            BuildersKt__Builders_commonKt.d(mainScope, null, null, new PaywallView$hideLoadingView$1$1(paywallPurchaseLoadingView, null), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hideShimmerView() {
        double dI;
        PaywallShimmerView paywallShimmerView = this.shimmerView;
        if (paywallShimmerView != null) {
            BuildersKt__Builders_commonKt.d(mainScope, null, null, new PaywallView$hideShimmerView$1$1(paywallShimmerView, null), 3, null);
        }
        if (getState().getPaywall().getShimmerLoadingInfo().getEndAt() != null) {
            return;
        }
        Date startAt = getState().getPaywall().getShimmerLoadingInfo().getStartAt();
        Date lastOpen = getState().getLastOpen();
        Date date = new Date();
        if (startAt == null || lastOpen == null) {
            dI = 0.0d;
        } else {
            Duration.Companion companion = Duration.f140631b;
            long time = date.getTime() - lastOpen.getTime();
            DurationUnit durationUnit = DurationUnit.f140641f;
            dI = Duration.I(DurationKt.t(time, durationUnit), durationUnit);
        }
        this.controller.updateState(PaywallViewState.Updates.ShimmerEnded.INSTANCE);
        BuildersKt__Builders_commonKt.d(ioScope, null, null, new C28632(dI, null), 3, null);
    }

    private final void presentCheckoutBottomSheet(String str) {
        Logger logger = Logger.INSTANCE;
        LogLevel logLevel = LogLevel.debug;
        LogScope logScope = LogScope.paywallView;
        Logger.debug$default(logger, logLevel, logScope, "Opening checkout URL in Chrome Custom Tab: " + str, (Map) null, (Throwable) null, 24, (Object) null);
        ActivityResultLauncher<String> activityResultLauncher = this.activityResultLauncher;
        if (activityResultLauncher != null) {
            activityResultLauncher.b(str);
        } else {
            Logger.debug$default(logger, LogLevel.error, logScope, "Activity result launcher not initialized - cannot present Chrome Custom Tab", (Map) null, (Throwable) null, 24, (Object) null);
            this.isPaymentSheetPresented = false;
        }
    }

    private final void presentationWillBegin() {
        if (!getState().getPresentationWillPrepare() || getState().getPresentationDidFinishPrepare()) {
            return;
        }
        this.controller.updateState(PaywallViewState.Updates.PresentationWillBegin.INSTANCE);
        this.controller.updateState(PaywallViewState.Updates.BeginPresentation.INSTANCE);
        this.factory.delegate().willPresentPaywall(getInfo());
        this.webView.scrollTo(0, 0);
        if (getLoadingState() instanceof PaywallLoadingState.Ready) {
            this.webView.getMessageHandler().handle(PaywallMessage.TemplateParamsAndUserAttributes.INSTANCE);
        } else if ((getLoadingState() instanceof PaywallLoadingState.LoadingURL) || (getLoadingState() instanceof PaywallLoadingState.Unknown)) {
            trackShimmerStart();
            this.controller.updateState(PaywallViewState.Updates.ShimmerStarted.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void recreateWebview() {
        PaywallWebUI paywallWebUI = this.webView;
        paywallWebUI.getMessageHandler().resetForWebViewReload$superwall_release();
        paywallWebUI.detach(this);
        paywallWebUI.destroyView();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        SWWebView sWWebView = new SWWebView(context, paywallWebUI.getMessageHandler(), null, new Function0() { // from class: com.superwall.sdk.paywall.view.d
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PaywallView.recreateWebview$lambda$15(this.f93635a);
            }
        }, null, 20, null);
        this.webView = sWWebView;
        sWWebView.attach(this);
        this.webView.setDelegate(this);
        loadWebView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PaywallOptions recreateWebview$lambda$15(PaywallView paywallView) {
        return paywallView.factory.makeSuperwallOptions().getPaywalls();
    }

    private final void resetPresentationPreparations() {
        this.controller.updateState(PaywallViewState.Updates.ResetPresentationPreparations.INSTANCE);
    }

    private final void setLoadingState(PaywallLoadingState paywallLoadingState) {
        this.controller.updateState(new PaywallViewState.Updates.SetLoadingState(paywallLoadingState));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void showAlert$default(PaywallView paywallView, String str, String str2, String str3, String str4, Function0 function0, Function0 function02, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = null;
        }
        if ((i3 & 2) != 0) {
            str2 = null;
        }
        if ((i3 & 4) != 0) {
            str3 = null;
        }
        if ((i3 & 8) != 0) {
            str4 = "Done";
        }
        if ((i3 & 16) != 0) {
            function0 = null;
        }
        if ((i3 & 32) != 0) {
            function02 = null;
        }
        paywallView.showAlert(str, str2, str3, str4, function0, function02);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showLoadingView() {
        PaywallPurchaseLoadingView paywallPurchaseLoadingView;
        if (this.factory.makeSuperwallOptions().getPaywalls().getTransactionBackgroundView() == PaywallOptions.TransactionBackgroundView.SPINNER && (paywallPurchaseLoadingView = this.loadingView) != null) {
            BuildersKt__Builders_commonKt.d(mainScope, null, null, new PaywallView$showLoadingView$1$1(paywallPurchaseLoadingView, null), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showShimmerView() {
        PaywallShimmerView paywallShimmerView = this.shimmerView;
        if (paywallShimmerView != null) {
            BuildersKt__Builders_commonKt.d(mainScope, null, null, new PaywallView$showShimmerView$1$1(paywallShimmerView, null), 3, null);
        }
    }

    private final void startStateListener() {
        stopStateListener();
        IOScope iOScope = ioScope;
        this.stateListener = BuildersKt__Builders_commonKt.d(iOScope, null, null, new C28691(null), 3, null);
        this.customerInfoListener = BuildersKt__Builders_commonKt.d(iOScope, null, null, new C28702(null), 3, null);
    }

    private final void stopStateListener() {
        Job job = this.stateListener;
        if (job != null) {
            Job.DefaultImpls.b(job, null, 1, null);
        }
        this.stateListener = null;
        Job job2 = this.customerInfoListener;
        if (job2 != null) {
            Job.DefaultImpls.b(job2, null, 1, null);
        }
        this.customerInfoListener = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object trackClose(kotlin.coroutines.Continuation<? super kotlin.Unit> r6) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.superwall.sdk.paywall.view.PaywallView.C28711
            if (r0 == 0) goto L13
            r0 = r6
            com.superwall.sdk.paywall.view.PaywallView$trackClose$1 r0 = (com.superwall.sdk.paywall.view.PaywallView.C28711) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.superwall.sdk.paywall.view.PaywallView$trackClose$1 r0 = new com.superwall.sdk.paywall.view.PaywallView$trackClose$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            kotlin.ResultKt.b(r6)
            kotlin.Result r6 = (kotlin.Result) r6
            r6.j()
            goto L55
        L2e:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L36:
            kotlin.ResultKt.b(r6)
            com.superwall.sdk.analytics.internal.trackable.InternalSuperwallEvent$PaywallClose r6 = new com.superwall.sdk.analytics.internal.trackable.InternalSuperwallEvent$PaywallClose
            com.superwall.sdk.paywall.presentation.PaywallInfo r2 = r5.getInfo()
            com.superwall.sdk.paywall.view.PaywallViewState r4 = r5.getState()
            com.superwall.sdk.paywall.view.survey.SurveyPresentationResult r4 = r4.getSurveyPresentationResult()
            r6.<init>(r2, r4)
            com.superwall.sdk.paywall.view.PaywallView$Factory r2 = r5.factory
            r0.label = r3
            java.lang.Object r6 = r2.mo1271trackgIAlus(r6, r0)
            if (r6 != r1) goto L55
            return r1
        L55:
            kotlin.Unit r6 = kotlin.Unit.f139807a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.paywall.view.PaywallView.trackClose(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object trackOpen(kotlin.coroutines.Continuation<? super kotlin.Unit> r8) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r8 instanceof com.superwall.sdk.paywall.view.PaywallView.C28721
            if (r0 == 0) goto L13
            r0 = r8
            com.superwall.sdk.paywall.view.PaywallView$trackOpen$1 r0 = (com.superwall.sdk.paywall.view.PaywallView.C28721) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.superwall.sdk.paywall.view.PaywallView$trackOpen$1 r0 = new com.superwall.sdk.paywall.view.PaywallView$trackOpen$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            kotlin.ResultKt.b(r8)
            kotlin.Result r8 = (kotlin.Result) r8
            r8.j()
            goto L76
        L2e:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L36:
            kotlin.ResultKt.b(r8)
            com.superwall.sdk.paywall.view.PaywallView$PaywallController r8 = r7.controller
            com.superwall.sdk.paywall.view.PaywallViewState$Updates$SetLastOpen r2 = com.superwall.sdk.paywall.view.PaywallViewState.Updates.SetLastOpen.INSTANCE
            r8.updateState(r2)
            com.superwall.sdk.storage.LocalStorage r8 = r7.storage
            r8.trackPaywallOpen()
            com.superwall.sdk.paywall.view.webview.PaywallWebUI r8 = r7.webView
            com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler r8 = r8.getMessageHandler()
            com.superwall.sdk.paywall.view.webview.messaging.PaywallMessage$PaywallOpen r2 = com.superwall.sdk.paywall.view.webview.messaging.PaywallMessage.PaywallOpen.INSTANCE
            r8.handle(r2)
            com.superwall.sdk.analytics.internal.trackable.InternalSuperwallEvent$PaywallOpen r8 = new com.superwall.sdk.analytics.internal.trackable.InternalSuperwallEvent$PaywallOpen
            com.superwall.sdk.paywall.presentation.PaywallInfo r2 = r7.getInfo()
            com.superwall.sdk.paywall.view.PaywallView$Factory r4 = r7.factory
            java.util.Map r4 = r4.getCurrentUserAttributes()
            com.superwall.sdk.paywall.view.PaywallView$Factory r5 = r7.factory
            java.lang.String r5 = r5.demandTier()
            com.superwall.sdk.paywall.view.PaywallView$Factory r6 = r7.factory
            java.lang.Integer r6 = r6.demandScore()
            r8.<init>(r2, r4, r5, r6)
            com.superwall.sdk.paywall.view.PaywallView$Factory r2 = r7.factory
            r0.label = r3
            java.lang.Object r8 = r2.mo1271trackgIAlus(r8, r0)
            if (r8 != r1) goto L76
            return r1
        L76:
            kotlin.Unit r8 = kotlin.Unit.f139807a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.paywall.view.PaywallView.trackOpen(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void trackShimmerStart() {
        BuildersKt__Builders_commonKt.d(ioScope, null, null, new C28731(new InternalSuperwallEvent.ShimmerLoad(InternalSuperwallEvent.ShimmerLoad.State.Started, getState().getPaywall().getIdentifier(), null, getState().getPaywall().getPresentation().getDelay(), PaywallOptionsKt.computedShouldPreload(this.factory.makeSuperwallOptions(), this.deviceHelper.getDeviceTier())), null), 3, null);
    }

    public final void backButtonPressed() {
        this.webView.getMessageHandler().handle(PaywallMessage.BackButtonPressed.INSTANCE);
    }

    public final void beforeOnDestroy(boolean z2) {
        if (z2) {
            this.factory.updatePaywallInfo(getInfo());
            this.factory.delegate().willDismissPaywall(getInfo());
        }
    }

    public final void beforeViewCreated() {
        if (getState().isBrowserViewPresented()) {
            return;
        }
        PaywallShimmerView paywallShimmerView = this.shimmerView;
        if (paywallShimmerView != null) {
            paywallShimmerView.checkForOrientationChanges();
        }
        presentationWillBegin();
    }

    public final void cleanup() {
        WeakReference<Activity> encapsulatingActivity = getEncapsulatingActivity();
        if (encapsulatingActivity != null) {
            encapsulatingActivity.clear();
        }
        this.callback = null;
        this.webView.setOnScrollChangeListener(null);
        this.webView.setDelegate(null);
        ActivityResultLauncher<String> activityResultLauncher = this.activityResultLauncher;
        if (activityResultLauncher != null) {
            activityResultLauncher.d();
        }
        this.activityResultLauncher = null;
        ViewParent parent = getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        removeAllViews();
        detachAllViewsFromParent();
        stopStateListener();
    }

    public final void clearActivityLaunchState$superwall_release() {
        this.controller.updateState(PaywallViewState.Updates.ClearViewCreatedCompletion.INSTANCE);
        PaywallViewCache paywallViewCache = this.cache;
        if (paywallViewCache != null) {
            paywallViewCache.setActivePaywallVcKey(null);
        }
    }

    public final void destroyWebview$superwall_release() {
        this.webView.destroyView();
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x0114, code lost:
    
        if (r14 == r1) goto L49;
     */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object destroyed(boolean r13, kotlin.coroutines.Continuation<? super kotlin.Unit> r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 335
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.paywall.view.PaywallView.destroyed(boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void dismiss$superwall_release(final PaywallResult result, PaywallCloseReason closeReason, Function0<Unit> function0) {
        Activity activity;
        PresentationRequest.Flags flags;
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(closeReason, "closeReason");
        this.controller.updateState(new PaywallViewState.Updates.InitiateDismiss(result, closeReason, function0));
        final boolean z2 = getState().getPaywallResult() instanceof PaywallResult.Declined;
        final boolean z3 = closeReason instanceof PaywallCloseReason.ManualClose;
        final Function0 function02 = new Function0() { // from class: com.superwall.sdk.paywall.view.e
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PaywallView.dismiss$lambda$6(this.f93639a, z2, z3, result);
            }
        };
        if (this.isPaymentSheetPresented) {
            beforeOnDestroy$default(this, false, 1, null);
            cleanup();
            this.isPaymentSheetPresented = false;
        }
        SurveyManager surveyManager = SurveyManager.INSTANCE;
        List<Survey> surveys = getState().getPaywall().getSurveys();
        WeakReference<Activity> encapsulatingActivity = getEncapsulatingActivity();
        if (encapsulatingActivity == null || (activity = encapsulatingActivity.get()) == null) {
            function02.invoke();
            return;
        }
        PaywallLoadingState loadingState = getLoadingState();
        PresentationRequest request = getState().getRequest();
        surveyManager.presentSurveyIfAvailable(surveys, result, closeReason, activity, this, loadingState, (request == null || (flags = request.getFlags()) == null || !flags.isDebuggerLaunched()) ? false : true, getInfo(), this.storage, this.factory, new Function1() { // from class: com.superwall.sdk.paywall.view.f
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PaywallView.dismiss$lambda$8(this.f93644a, function02, (SurveyPresentationResult) obj);
            }
        });
    }

    @Override // com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandlerDelegate
    public void evaluate(String code, Function1<? super String, Unit> function1) {
        Intrinsics.checkNotNullParameter(code, "code");
        this.webView.evaluate(code, function1);
    }

    @Override // com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandlerDelegate
    public void eventDidOccur(PaywallWebEvent paywallWebEvent) {
        Intrinsics.checkNotNullParameter(paywallWebEvent, "paywallWebEvent");
        BuildersKt__Builders_commonKt.d(ioScope, null, null, new C28621(paywallWebEvent, null), 3, null);
    }

    @Override // com.superwall.sdk.game.GameControllerDelegate
    public void gameControllerEventOccured(GameControllerEvent event) {
        String strB;
        Intrinsics.checkNotNullParameter(event, "event");
        try {
            Json gameControllerJson = Companion.getGameControllerJson();
            gameControllerJson.a();
            strB = gameControllerJson.b(GameControllerEvent.Companion.serializer(), event);
        } catch (Throwable unused) {
            strB = null;
        }
        this.webView.evaluate("window.paywall.accept([" + strB + "])", null);
        Logger.debug$default(Logger.INSTANCE, LogLevel.debug, LogScope.paywallView, "Game controller event occurred: " + strB, (Map) null, (Throwable) null, 24, (Object) null);
    }

    public final int getBackgroundColor() {
        if ((Build.VERSION.SDK_INT >= 29 ? getContext().getResources().getConfiguration().uiMode & 48 : 0) != 32) {
            return getState().getPaywall().getBackgroundColor();
        }
        Integer darkBackgroundColor = getState().getPaywall().getDarkBackgroundColor();
        return darkBackgroundColor != null ? darkBackgroundColor.intValue() : getState().getPaywall().getBackgroundColor();
    }

    public final PaywallViewDelegateAdapter getCallback() {
        return this.callback;
    }

    public final PaywallController getController() {
        return this.controller;
    }

    public final DeviceHelper getDeviceHelper() {
        return this.deviceHelper;
    }

    @Override // com.superwall.sdk.paywall.view.ActivityEncapsulatable
    public WeakReference<Activity> getEncapsulatingActivity() {
        return this.encapsulatingActivity;
    }

    public final PaywallViewEventCallback getEventCallback() {
        return this.eventCallback;
    }

    public final Factory getFactory() {
        return this.factory;
    }

    @Override // com.superwall.sdk.paywall.view.webview.PaywallInfoDelegate
    public PaywallInfo getInfo() {
        return this.controller.getState().getInfo();
    }

    public final PaywallLoadingState getLoadingState() {
        return getState().getLoadingState();
    }

    public final SendPaywallMessages getSendMessages() {
        return this.sendMessages;
    }

    @Override // com.superwall.sdk.paywall.view.webview.messaging.PaywallStateDelegate
    public PaywallViewState getState() {
        return this.controller.getState();
    }

    public final LocalStorage getStorage() {
        return this.storage;
    }

    public final PaywallWebUI getWebView$superwall_release() {
        return this.webView;
    }

    @Override // com.superwall.sdk.paywall.view.webview.SendPaywallMessages
    public void handle(PaywallMessage message) {
        Intrinsics.checkNotNullParameter(message, "message");
        this.sendMessages.handle(message);
    }

    public final void handleActivityLaunchFailure$superwall_release(Throwable error, boolean z2) {
        MutableSharedFlow<PaywallState> paywallStatePublisher;
        Intrinsics.checkNotNullParameter(error, "error");
        Logger logger = Logger.INSTANCE;
        LogLevel logLevel = LogLevel.error;
        LogScope logScope = LogScope.paywallPresentation;
        String message = error.getMessage();
        if (message == null) {
            message = "Unable to launch SuperwallPaywallActivity";
        }
        Logger.debug$default(logger, logLevel, logScope, message, (Map) null, error, 8, (Object) null);
        if (!z2 || (paywallStatePublisher = getState().getPaywallStatePublisher()) == null) {
            return;
        }
        BuildersKt__Builders_commonKt.d(ioScope, null, null, new PaywallView$handleActivityLaunchFailure$1$1(paywallStatePublisher, error, null), 3, null);
    }

    public final boolean isPaymentSheetPresented$superwall_release() {
        return this.isPaymentSheetPresented;
    }

    public final void loadWebView() {
        BuildersKt__Builders_commonKt.d(ioScope, null, null, new C28641(null), 3, null);
    }

    public final void loadingStateDidChange$superwall_release() {
        if (getState().isPresented()) {
            PaywallLoadingState paywallLoadingState = this.lastHandledLoadingState;
            PaywallLoadingState loadingState = getLoadingState();
            this.lastHandledLoadingState = loadingState;
            Job job = this.delayedHideJob;
            if (job != null) {
                Job.DefaultImpls.b(job, null, 1, null);
            }
            this.delayedHideJob = null;
            BuildersKt__Builders_commonKt.d(mainScope, null, null, new PaywallView$loadingStateDidChange$1(loadingState, this, paywallLoadingState, null), 3, null);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        startStateListener();
        if (getLoadingState() instanceof PaywallLoadingState.Unknown) {
            loadWebView();
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return getState().getInterceptTouchEvents();
    }

    public final void onThemeChanged() {
        this.webView.getMessageHandler().handle(PaywallMessage.TemplateParamsAndUserAttributes.INSTANCE);
    }

    public final void onViewCreated() {
        boolean presentationDidFinishPrepare = getState().getPresentationDidFinishPrepare();
        if (!presentationDidFinishPrepare) {
            this.controller.updateState(PaywallViewState.Updates.BeginPresentation.INSTANCE);
        }
        Function1<Boolean, Unit> viewCreatedCompletion = getState().getViewCreatedCompletion();
        if (viewCreatedCompletion != null) {
            viewCreatedCompletion.invoke(Boolean.TRUE);
        }
        this.controller.updateState(PaywallViewState.Updates.ClearViewCreatedCompletion.INSTANCE);
        if (presentationDidFinishPrepare) {
            if (getState().getClosedForBackground()) {
                this.controller.updateState(new PaywallViewState.Updates.SetClosedForBackground(false));
                BuildersKt__Builders_commonKt.d(ioScope, null, null, new C28651(null), 3, null);
                return;
            }
            return;
        }
        IOScope iOScope = ioScope;
        BuildersKt__Builders_commonKt.d(iOScope, null, null, new C28662(null), 3, null);
        TriggerRuleOccurrence unsavedOccurrence = getState().getUnsavedOccurrence();
        if (unsavedOccurrence != null) {
            CoreDataManager.save$default(this.storage.getCoreDataManager(), unsavedOccurrence, null, 2, null);
            this.controller.updateState(PaywallViewState.Updates.ClearUnsavedOccurrence.INSTANCE);
        }
        this.controller.updateState(PaywallViewState.Updates.SetPresentedAndFinished.INSTANCE);
        this.factory.delegate().didPresentPaywall(getInfo());
        loadingStateDidChange$superwall_release();
        this.webView.getMessageHandler().flushPendingMessages();
        BuildersKt__Builders_commonKt.d(iOScope, null, null, new AnonymousClass4(null), 3, null);
        GameControllerManager.Companion.getShared().setDelegate(this);
        this.initialOrientation = Integer.valueOf(getResources().getConfiguration().orientation);
    }

    @Override // com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandlerDelegate
    public void openDeepLink(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        Uri uri = Uri.parse(url);
        eventDidOccur(new PaywallWebEvent.OpenedDeepLink(uri));
        WeakReference<Activity> encapsulatingActivity = getEncapsulatingActivity();
        Activity context = encapsulatingActivity != null ? encapsulatingActivity.get() : null;
        Intent intent = new Intent("android.intent.action.VIEW", uri);
        if (context == null) {
            intent.addFlags(268435456);
        }
        if (context == null) {
            try {
                context = getContext();
            } catch (ActivityNotFoundException unused) {
                Logger.debug$default(Logger.INSTANCE, LogLevel.warn, LogScope.paywallView, "No activity found to handle deep link: " + url, (Map) null, (Throwable) null, 24, (Object) null);
                return;
            }
        }
        context.startActivity(intent);
    }

    public final void prepareToDisplay() {
        ViewParent parent = getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeView(this);
        }
        PaywallViewCache paywallViewCache = this.cache;
        if (paywallViewCache != null) {
            paywallViewCache.setActivePaywallVcKey(getState().getCacheKey$superwall_release());
        }
    }

    public final void present(Activity presenter, PresentationRequest request, TriggerRuleOccurrence triggerRuleOccurrence, PaywallPresentationStyle paywallPresentationStyle, MutableSharedFlow<PaywallState> paywallStatePublisher, Experiment experiment, Function1<? super Boolean, Unit> completion) throws Throwable {
        PaywallShimmerView paywallShimmerViewAcquireShimmerView;
        PaywallPurchaseLoadingView paywallPurchaseLoadingViewAcquireLoadingView;
        Intrinsics.checkNotNullParameter(presenter, "presenter");
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(paywallStatePublisher, "paywallStatePublisher");
        Intrinsics.checkNotNullParameter(completion, "completion");
        this.webView.attach(this);
        PaywallViewCache paywallViewCache = this.cache;
        if (paywallViewCache != null && (paywallPurchaseLoadingViewAcquireLoadingView = paywallViewCache.acquireLoadingView()) != null) {
            setupLoading$superwall_release(paywallPurchaseLoadingViewAcquireLoadingView);
        }
        Duration durationM1263getTimeoutAfterFghU774 = this.factory.makeSuperwallOptions().getPaywalls().m1263getTimeoutAfterFghU774();
        if (durationM1263getTimeoutAfterFghU774 != null) {
            BuildersKt__Builders_commonKt.d(ioScope, null, null, new C28672(durationM1263getTimeoutAfterFghU774, this, null), 3, null);
        }
        PaywallViewCache paywallViewCache2 = this.cache;
        if (paywallViewCache2 != null && (paywallShimmerViewAcquireShimmerView = paywallViewCache2.acquireShimmerView()) != null) {
            setupShimmer$superwall_release(paywallShimmerViewAcquireShimmerView);
        }
        set$superwall_release(request, paywallStatePublisher, triggerRuleOccurrence, experiment);
        this.controller.updateState(new PaywallViewState.Updates.SetPresentationConfig(paywallPresentationStyle, completion));
        ResultKt.b(SuperwallPaywallActivity.Companion.m1338startWithViewForPresentationBWLJW6A$superwall_release(presenter, this, getState().getCacheKey$superwall_release(), getState().getPresentationStyle()));
        startStateListener();
    }

    @Override // com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandlerDelegate
    public void presentBrowserExternal(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        try {
            String string = new URI(url).toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(string));
            intent.addFlags(268435456);
            try {
                this.controller.updateState(new PaywallViewState.Updates.SetBrowserPresented(true));
                getContext().startActivity(intent);
            } catch (MalformedURLException unused) {
                Logger.debug$default(Logger.INSTANCE, LogLevel.debug, LogScope.paywallView, "Invalid URL provided for \"Open External URL\" click behavior.", (Map) null, (Throwable) null, 24, (Object) null);
            } catch (Throwable unused2) {
                Logger.debug$default(Logger.INSTANCE, LogLevel.debug, LogScope.paywallView, "Exception thrown for \"Open External URL\" click behavior.", (Map) null, (Throwable) null, 24, (Object) null);
            }
        } catch (MalformedURLException unused3) {
        } catch (Throwable unused4) {
        }
    }

    @Override // com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandlerDelegate
    public void presentBrowserInApp(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        try {
            URI uri = new URI(url);
            CustomTabsIntent customTabsIntentA = new CustomTabsIntent.Builder().a();
            Intrinsics.checkNotNullExpressionValue(customTabsIntentA, "build(...)");
            customTabsIntentA.f2637a.setFlags(268435456);
            Context context = getContext();
            String string = uri.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            customTabsIntentA.a(context, Uri.parse(string));
            try {
                this.controller.updateState(new PaywallViewState.Updates.SetBrowserPresented(true));
            } catch (MalformedURLException unused) {
                Logger.debug$default(Logger.INSTANCE, LogLevel.debug, LogScope.paywallView, "Invalid URL provided for \"Open In-App URL\" click behavior.", (Map) null, (Throwable) null, 24, (Object) null);
            } catch (Throwable unused2) {
                Logger.debug$default(Logger.INSTANCE, LogLevel.debug, LogScope.paywallView, "Exception thrown for \"Open In-App URL\" click behavior.", (Map) null, (Throwable) null, 24, (Object) null);
            }
        } catch (MalformedURLException unused3) {
        } catch (Throwable unused4) {
        }
    }

    @Override // com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandlerDelegate
    public void presentPaymentSheet(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        try {
            this.isPaymentSheetPresented = true;
            presentCheckoutBottomSheet(url);
        } catch (MalformedURLException e3) {
            Logger.debug$default(Logger.INSTANCE, LogLevel.debug, LogScope.paywallView, "Invalid URL provided for \"Open In-App URL\" click behavior.", (Map) null, e3, 8, (Object) null);
        } catch (Throwable th) {
            th.printStackTrace();
            Logger.debug$default(Logger.INSTANCE, LogLevel.debug, LogScope.paywallView, "Exception thrown for \"Open In-App URL\" click behavior.", (Map) null, th, 8, (Object) null);
        }
    }

    public final void registerIntent$superwall_release(LifecycleOwner lifecycleOwner, ActivityResultRegistryOwner registryOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(registryOwner, "registryOwner");
        this.activityResultLauncher = registryOwner.getActivityResultRegistry().m("checkoutSheet", lifecycleOwner, new ActivityResultContract<String, Integer>() { // from class: com.superwall.sdk.paywall.view.PaywallView$registerIntent$1
            @Override // androidx.activity.result.contract.ActivityResultContract
            public Intent createIntent(Context context, String input) {
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(input, "input");
                double d3 = ((double) context.getResources().getDisplayMetrics().heightPixels) * 0.9d;
                CustomTabsIntent.Builder builderI = new CustomTabsIntent.Builder().e(1).i(false);
                PaywallPresentationStyle presentationStyle = this.this$0.getState().getPresentationStyle();
                if (presentationStyle instanceof PaywallPresentationStyle.Drawer) {
                    builderI.u((int) ((PaywallPresentationStyle.Drawer) presentationStyle).getCornerRadius());
                } else if (presentationStyle instanceof PaywallPresentationStyle.Popup) {
                    builderI.u((int) ((PaywallPresentationStyle.Popup) presentationStyle).getCornerRadius());
                } else {
                    Unit unit = Unit.f139807a;
                }
                CustomTabsIntent.Builder builderN = builderI.s(true).b(false).r(2).m(true).n(true);
                Drawable drawableB = AppCompatResources.b(context, R.drawable.none);
                Intrinsics.checkNotNull(drawableB);
                Drawable drawableMutate = drawableB.mutate();
                DrawableCompat.n(drawableMutate, 0);
                Intrinsics.checkNotNull(drawableMutate);
                Intent intent = builderN.c(DrawableKt.b(drawableMutate, 0, 0, null, 7, null)).v(true).l((int) (((double) ((int) d3)) * 0.7d), 1).a().f2637a;
                Intrinsics.checkNotNullExpressionValue(intent, "intent");
                intent.setPackage(CustomTabsHelper.getPackageNameToUse(context));
                intent.setData(Uri.parse(input));
                return intent;
            }

            @Override // androidx.activity.result.contract.ActivityResultContract
            public Integer parseResult(int i3, Intent intent) {
                return Integer.valueOf(i3);
            }
        }, new ActivityResultCallback() { // from class: com.superwall.sdk.paywall.view.b
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                PaywallView.registerIntent$lambda$18(this.f93631a, ((Integer) obj).intValue());
            }
        });
    }

    public final void registerPaymentSheetLauncher(LifecycleOwner lifecycleOwner, ActivityResultRegistryOwner registryOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(registryOwner, "registryOwner");
        registerIntent$superwall_release(lifecycleOwner, registryOwner);
    }

    public final void resetTransientPresentationState$superwall_release() {
        if ((getLoadingState() instanceof PaywallLoadingState.LoadingPurchase) || (getLoadingState() instanceof PaywallLoadingState.ManualLoading)) {
            this.controller.updateState(new PaywallViewState.Updates.SetLoadingState(PaywallLoadingState.Ready.INSTANCE));
        }
        resetPresentationPreparations();
    }

    public final void scrollBy(int i3) {
        this.webView.scrollBy(0, i3);
    }

    public final void scrollTo(int i3) {
        this.webView.scrollTo(0, i3);
    }

    public final void set$superwall_release(PresentationRequest request, MutableSharedFlow<PaywallState> paywallStatePublisher, TriggerRuleOccurrence triggerRuleOccurrence, Experiment experiment) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(paywallStatePublisher, "paywallStatePublisher");
        this.controller.updateState(new PaywallViewState.Updates.SetRequest(request, paywallStatePublisher, triggerRuleOccurrence, experiment));
    }

    public final void setCallback(PaywallViewDelegateAdapter paywallViewDelegateAdapter) {
        this.callback = paywallViewDelegateAdapter;
    }

    @Override // com.superwall.sdk.paywall.view.ActivityEncapsulatable
    public void setEncapsulatingActivity(WeakReference<Activity> weakReference) {
        this.encapsulatingActivity = weakReference;
    }

    public final void setPaymentSheetPresented$superwall_release(boolean z2) {
        this.isPaymentSheetPresented = z2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setupLoading$superwall_release(PaywallPurchaseLoadingView loadingView) {
        Intrinsics.checkNotNullParameter(loadingView, "loadingView");
        this.loadingView = loadingView;
        if (loadingView instanceof View) {
            LoadingViewKt.setupFor((View) loadingView, this, getLoadingState());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setupShimmer$superwall_release(PaywallShimmerView shimmerView) {
        Intrinsics.checkNotNullParameter(shimmerView, "shimmerView");
        this.shimmerView = shimmerView;
        if (shimmerView instanceof View) {
            PaywallShimmerViewKt.setupFor((View) shimmerView, this, getLoadingState());
        }
    }

    public final void setupWith(PaywallShimmerView shimmerView, PaywallPurchaseLoadingView loadingView) {
        Intrinsics.checkNotNullParameter(shimmerView, "shimmerView");
        Intrinsics.checkNotNullParameter(loadingView, "loadingView");
        this.webView.attach(this);
        this.shimmerView = shimmerView;
        this.loadingView = loadingView;
    }

    public final void showAlert(String str, String str2, String str3, String closeActionTitle, Function0<Unit> function0, Function0<Unit> function02) {
        Activity activity;
        Intrinsics.checkNotNullParameter(closeActionTitle, "closeActionTitle");
        WeakReference<Activity> encapsulatingActivity = getEncapsulatingActivity();
        if (encapsulatingActivity == null || (activity = encapsulatingActivity.get()) == null) {
            return;
        }
        BuildersKt__Builders_commonKt.d(mainScope, null, null, new C28681(activity, str, str2, str3, closeActionTitle, this, function0, function02, null), 3, null);
    }

    public final void showRefreshButtonAfterTimeout(boolean z2) {
    }

    @Override // com.superwall.sdk.paywall.view.webview.messaging.PaywallStateDelegate
    public void updateState(PaywallViewState.Updates update) {
        Intrinsics.checkNotNullParameter(update, "update");
        this.controller.updateState(update);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PaywallView(Context context, PaywallViewEventCallback paywallViewEventCallback, PaywallViewDelegateAdapter paywallViewDelegateAdapter, DeviceHelper deviceHelper, Factory factory, LocalStorage storage, PaywallWebUI webView, PaywallViewCache paywallViewCache, PaywallController controller, SendPaywallMessages sendMessages, WebPaywallRedeemer redeemer) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(deviceHelper, "deviceHelper");
        Intrinsics.checkNotNullParameter(factory, "factory");
        Intrinsics.checkNotNullParameter(storage, "storage");
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(controller, "controller");
        Intrinsics.checkNotNullParameter(sendMessages, "sendMessages");
        Intrinsics.checkNotNullParameter(redeemer, "redeemer");
        this.eventCallback = paywallViewEventCallback;
        this.callback = paywallViewDelegateAdapter;
        this.deviceHelper = deviceHelper;
        this.factory = factory;
        this.storage = storage;
        this.cache = paywallViewCache;
        this.controller = controller;
        this.sendMessages = sendMessages;
        this.redeemer = redeemer;
        this.webView = webView;
        this.lastHandledLoadingState = PaywallLoadingState.Unknown.INSTANCE;
        setId(View.generateViewId());
        setBackgroundColor(getBackgroundColor());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void registerIntent$lambda$18(PaywallView paywallView, int i3) {
        Logger.debug$default(Logger.INSTANCE, LogLevel.debug, LogScope.paywallView, wgbAZXYjrv.tXYrmX + i3, (Map) null, (Throwable) null, 24, (Object) null);
        paywallView.isPaymentSheetPresented = false;
        paywallView.controller.updateState(new PaywallViewState.Updates.SetBrowserPresented(false));
    }
}
