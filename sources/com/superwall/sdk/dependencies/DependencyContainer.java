package com.superwall.sdk.dependencies;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.util.Base64;
import android.webkit.WebSettings;
import androidx.lifecycle.ProcessLifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.media3.exoplayer.audio.wRw.CbYNFSEGaQj;
import com.android.billingclient.api.Purchase;
import com.superwall.sdk.SdkContextImpl;
import com.superwall.sdk.Superwall;
import com.superwall.sdk.analytics.AttributionManager;
import com.superwall.sdk.analytics.CPUInfo;
import com.superwall.sdk.analytics.ClassifierDataFactory;
import com.superwall.sdk.analytics.DefaultClassifierDataFactory;
import com.superwall.sdk.analytics.DeviceClassifier;
import com.superwall.sdk.analytics.SessionEventsManager;
import com.superwall.sdk.analytics.internal.TrackingKt;
import com.superwall.sdk.analytics.internal.trackable.InternalSuperwallEvent;
import com.superwall.sdk.analytics.internal.trackable.Trackable;
import com.superwall.sdk.analytics.internal.trackable.TrackableSuperwallEvent;
import com.superwall.sdk.analytics.session.AppManagerDelegate;
import com.superwall.sdk.analytics.session.AppSession;
import com.superwall.sdk.analytics.session.AppSessionManager;
import com.superwall.sdk.billing.GoogleBillingWrapper;
import com.superwall.sdk.config.Assignments;
import com.superwall.sdk.config.ConfigLogic;
import com.superwall.sdk.config.ConfigManager;
import com.superwall.sdk.config.PaywallPreload;
import com.superwall.sdk.config.models.ConfigState;
import com.superwall.sdk.config.options.SuperwallOptions;
import com.superwall.sdk.customer.CustomerInfoManager;
import com.superwall.sdk.debug.DebugManager;
import com.superwall.sdk.debug.DebugView;
import com.superwall.sdk.deeplinks.DeepLinkRouter;
import com.superwall.sdk.delegate.SuperwallDelegateAdapter;
import com.superwall.sdk.delegate.subscription_controller.PurchaseController;
import com.superwall.sdk.dependencies.ApiFactory;
import com.superwall.sdk.identity.IdentityInfo;
import com.superwall.sdk.identity.IdentityManager;
import com.superwall.sdk.identity.IdentityManagerActorKt;
import com.superwall.sdk.identity.IdentityPendingInterceptor;
import com.superwall.sdk.identity.IdentityPersistenceInterceptor;
import com.superwall.sdk.logger.LogLevel;
import com.superwall.sdk.logger.LogScope;
import com.superwall.sdk.logger.Logger;
import com.superwall.sdk.misc.ActivityProvider;
import com.superwall.sdk.misc.AlertControllerFactory;
import com.superwall.sdk.misc.AppLifecycleObserver;
import com.superwall.sdk.misc.CurrentActivityTracker;
import com.superwall.sdk.misc.Either;
import com.superwall.sdk.misc.IOScope;
import com.superwall.sdk.misc.MainScope;
import com.superwall.sdk.misc.String_SHA256Kt;
import com.superwall.sdk.misc.primitives.SequentialActor;
import com.superwall.sdk.models.attribution.AttributionProvider;
import com.superwall.sdk.models.config.ComputedPropertyRequest;
import com.superwall.sdk.models.config.Config;
import com.superwall.sdk.models.config.FeatureFlags;
import com.superwall.sdk.models.config.WebToAppConfig;
import com.superwall.sdk.models.customer.CustomerInfo;
import com.superwall.sdk.models.entitlements.Entitlement;
import com.superwall.sdk.models.entitlements.SubscriptionStatus;
import com.superwall.sdk.models.events.EventData;
import com.superwall.sdk.models.internal.DeviceVendorId;
import com.superwall.sdk.models.internal.RedemptionResult;
import com.superwall.sdk.models.internal.UserId;
import com.superwall.sdk.models.internal.VendorId;
import com.superwall.sdk.models.paywall.LocalNotification;
import com.superwall.sdk.models.paywall.Paywall;
import com.superwall.sdk.models.serialization.DateSerializer;
import com.superwall.sdk.network.Api;
import com.superwall.sdk.network.BaseHostService;
import com.superwall.sdk.network.CollectorService;
import com.superwall.sdk.network.EnrichmentService;
import com.superwall.sdk.network.JsonFactory;
import com.superwall.sdk.network.Network;
import com.superwall.sdk.network.NetworkError;
import com.superwall.sdk.network.RequestExecutor;
import com.superwall.sdk.network.SubscriptionService;
import com.superwall.sdk.network.device.DeviceHelper;
import com.superwall.sdk.network.device.DeviceInfo;
import com.superwall.sdk.network.session.CustomHttpUrlConnection;
import com.superwall.sdk.paywall.manager.PaywallManager;
import com.superwall.sdk.paywall.manager.PaywallViewCache;
import com.superwall.sdk.paywall.presentation.CustomCallbackRegistry;
import com.superwall.sdk.paywall.presentation.PaywallInfo;
import com.superwall.sdk.paywall.presentation.PublicPresentationKt;
import com.superwall.sdk.paywall.presentation.get_presentation_result.PublicGetPresentationResultKt;
import com.superwall.sdk.paywall.presentation.internal.DefaultGetPaywallComponentsFactory;
import com.superwall.sdk.paywall.presentation.internal.GetPaywallComponentsFactory;
import com.superwall.sdk.paywall.presentation.internal.InternalPresentationKt;
import com.superwall.sdk.paywall.presentation.internal.PresentationRequest;
import com.superwall.sdk.paywall.presentation.internal.PresentationRequestType;
import com.superwall.sdk.paywall.presentation.internal.operators.StorePresentationObjectsKt;
import com.superwall.sdk.paywall.presentation.internal.request.PaywallOverrides;
import com.superwall.sdk.paywall.presentation.internal.request.PresentationInfo;
import com.superwall.sdk.paywall.presentation.internal.state.PaywallResult;
import com.superwall.sdk.paywall.presentation.internal.state.PaywallState;
import com.superwall.sdk.paywall.presentation.rule_logic.cel.SuperscriptEvaluator;
import com.superwall.sdk.paywall.presentation.rule_logic.expression_evaluator.CombinedExpressionEvaluator;
import com.superwall.sdk.paywall.presentation.rule_logic.expression_evaluator.ExpressionEvaluating;
import com.superwall.sdk.paywall.presentation.rule_logic.javascript.RuleEvaluator;
import com.superwall.sdk.paywall.request.PaywallRequest;
import com.superwall.sdk.paywall.request.PaywallRequestManager;
import com.superwall.sdk.paywall.request.PaywallRequestManagerDepFactory;
import com.superwall.sdk.paywall.request.ResponseIdentifiers;
import com.superwall.sdk.paywall.view.PaywallView;
import com.superwall.sdk.paywall.view.PaywallViewState;
import com.superwall.sdk.paywall.view.SuperwallPaywallActivity;
import com.superwall.sdk.paywall.view.SuperwallStoreOwner;
import com.superwall.sdk.paywall.view.ViewModelFactory;
import com.superwall.sdk.paywall.view.ViewStorageViewModel;
import com.superwall.sdk.paywall.view.webview.WebviewChecker;
import com.superwall.sdk.paywall.view.webview.messaging.PaywallMessage;
import com.superwall.sdk.permissions.UserPermissions;
import com.superwall.sdk.permissions.UserPermissionsImpl;
import com.superwall.sdk.review.MockReviewManager;
import com.superwall.sdk.review.ReviewManager;
import com.superwall.sdk.review.ReviewManagerImpl;
import com.superwall.sdk.storage.EventsQueue;
import com.superwall.sdk.storage.IntegrationAttributes;
import com.superwall.sdk.storage.LocalStorage;
import com.superwall.sdk.store.AutomaticPurchaseController;
import com.superwall.sdk.store.Entitlements;
import com.superwall.sdk.store.InternalPurchaseController;
import com.superwall.sdk.store.StoreManager;
import com.superwall.sdk.store.abstractions.product.receipt.ReceiptManager;
import com.superwall.sdk.store.abstractions.transactions.GoogleBillingPurchaseTransaction;
import com.superwall.sdk.store.abstractions.transactions.StoreTransaction;
import com.superwall.sdk.store.testmode.TestMode;
import com.superwall.sdk.store.testmode.TestModeTransactionHandler;
import com.superwall.sdk.store.testmode.models.SuperwallProductsResponse;
import com.superwall.sdk.store.transactions.TransactionManager;
import com.superwall.sdk.store.transactions.notifications.TrialReminderLogic;
import com.superwall.sdk.utilities.DateUtils;
import com.superwall.sdk.utilities.DateUtilsKt;
import com.superwall.sdk.utilities.ErrorTracker;
import com.superwall.sdk.web.DeepLinkReferrer;
import com.superwall.sdk.web.WebPaywallRedeemer;
import java.lang.ref.WeakReference;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
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
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.serialization.json.ClassDiscriminatorMode;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonKt;
import kotlinx.serialization.modules.SerializersModuleBuilder;

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
public final class DependencyContainer implements ApiFactory, DeviceInfoFactory, AppManagerDelegate, RequestFactory, RuleAttributesFactory, DeviceHelper.Factory, CacheFactory, PaywallRequestManagerDepFactory, VariablesFactory, StoreTransactionFactory, LocalStorage.Factory, InternalSuperwallEvent.PresentationRequest.Factory, ViewFactory, PaywallManager.Factory, OptionsFactory, TriggerFactory, TransactionVerifierFactory, TransactionManager.Factory, PaywallView.Factory, ConfigManager.Factory, AppSessionManager.Factory, DebugView.Factory, RuleEvaluator.Factory, JsonFactory, ConfigAttributesFactory, PaywallPreload.Factory, ViewStoreFactory, SuperwallScopeFactory, GoogleBillingWrapper.Factory, ClassifierDataFactory, ExperimentalPropertiesFactory, CustomerInfoFactory, ActiveEntitlementsFactory, WebPaywallRedeemer.Factory {
    private IOScope _ioScope;
    private MainScope _mainScope;
    private ActivityProvider activityProvider;
    private Api api;
    private final String apiKey;
    private AppLifecycleObserver appLifecycleObserver;
    private AppSessionManager appSessionManager;
    private final Assignments assignments;
    private final AttributionManager attributionManager;
    public ConfigManager configManager;
    private final Context context;
    private final CustomCallbackRegistry customCallbackRegistry;
    public CustomerInfoManager customerInfoManager;
    private DebugManager debugManager;
    private final DeepLinkRouter deepLinkRouter;
    private SuperwallDelegateAdapter delegateAdapter;
    private DeviceHelper deviceHelper;
    private Entitlements entitlements;
    private final ErrorTracker errorTracker;
    private final Lazy evaluator$delegate;
    private EventsQueue eventsQueue;
    private final Lazy getPaywallComponentsFactory$delegate;
    private final GoogleBillingWrapper googleBillingWrapper;
    private IdentityManager identityManager;
    private Network network;
    private final Json paywallJson;
    private PaywallManager paywallManager;
    private final PaywallPreload paywallPreload;
    private PaywallRequestManager paywallRequestManager;
    public WebPaywallRedeemer reedemer;
    private final ReviewManager reviewManager;
    private SessionEventsManager sessionEventsManager;
    public LocalStorage storage;
    private StoreManager storeManager;
    private final TestMode testMode;
    private final TestModeTransactionHandler testModeTransactionHandler;
    private final TransactionManager transactionManager;
    private final UserPermissions userPermissions;
    private final ViewModelProvider vmProvider;

    /* JADX INFO: renamed from: com.superwall.sdk.dependencies.DependencyContainer$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.dependencies.DependencyContainer$1", f = "DependencyContainer.kt", l = {}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return DependencyContainer.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            ProcessLifecycleOwner.f40032j.a().getLifecycle().addObserver(DependencyContainer.this.getAppLifecycleObserver());
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.dependencies.DependencyContainer$13, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.dependencies.DependencyContainer$13", f = "DependencyContainer.kt", l = {336}, m = "invokeSuspend")
    static final class AnonymousClass13 extends SuspendLambda implements Function1<Continuation<? super Either<? extends SuperwallProductsResponse, NetworkError>>, Object> {
        int label;

        AnonymousClass13(Continuation<? super AnonymousClass13> continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return DependencyContainer.this.new AnonymousClass13(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 != 0) {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                return obj;
            }
            ResultKt.b(obj);
            Network network = DependencyContainer.this.getNetwork();
            this.label = 1;
            Object superwallProducts = network.getSuperwallProducts(this);
            return superwallProducts == objF ? objF : superwallProducts;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Either<SuperwallProductsResponse, NetworkError>> continuation) {
            return ((AnonymousClass13) create(continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.dependencies.DependencyContainer$14, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.dependencies.DependencyContainer$14", f = "DependencyContainer.kt", l = {343}, m = "invokeSuspend")
    static final class AnonymousClass14 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass14(Continuation<? super AnonymousClass14> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return DependencyContainer.this.new AnonymousClass14(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                StoreManager storeManager = DependencyContainer.this.getStoreManager();
                this.label = 1;
                if (storeManager.loadStorefrontCountryCode(this) == objF) {
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
            return ((AnonymousClass14) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.dependencies.DependencyContainer$17, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.dependencies.DependencyContainer$17", f = "DependencyContainer.kt", l = {386}, m = "invokeSuspend")
    static final class AnonymousClass17 extends SuspendLambda implements Function3<Boolean, String, Continuation<? super Map<String, ? extends String>>, Object> {
        /* synthetic */ Object L$0;
        /* synthetic */ boolean Z$0;
        int label;

        AnonymousClass17(Continuation<? super AnonymousClass17> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return invoke(((Boolean) obj).booleanValue(), (String) obj2, (Continuation<? super Map<String, String>>) obj3);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 != 0) {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                return obj;
            }
            ResultKt.b(obj);
            boolean z2 = this.Z$0;
            String str = (String) this.L$0;
            DependencyContainer dependencyContainer = DependencyContainer.this;
            this.label = 1;
            Object objMakeHeaders = dependencyContainer.makeHeaders(z2, str, this);
            return objMakeHeaders == objF ? objF : objMakeHeaders;
        }

        public final Object invoke(boolean z2, String str, Continuation<? super Map<String, String>> continuation) {
            AnonymousClass17 anonymousClass17 = DependencyContainer.this.new AnonymousClass17(continuation);
            anonymousClass17.Z$0 = z2;
            anonymousClass17.L$0 = str;
            return anonymousClass17.invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.dependencies.DependencyContainer$19, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.dependencies.DependencyContainer$19", f = "DependencyContainer.kt", l = {445}, m = "invokeSuspend")
    static final class AnonymousClass19 extends SuspendLambda implements Function2<InternalSuperwallEvent, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;

        AnonymousClass19(Continuation<? super AnonymousClass19> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass19 anonymousClass19 = new AnonymousClass19(continuation);
            anonymousClass19.L$0 = obj;
            return anonymousClass19;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(InternalSuperwallEvent internalSuperwallEvent, Continuation<? super Unit> continuation) {
            return ((AnonymousClass19) create(internalSuperwallEvent, continuation)).invokeSuspend(Unit.f139807a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                InternalSuperwallEvent internalSuperwallEvent = (InternalSuperwallEvent) this.L$0;
                Superwall companion = Superwall.Companion.getInstance();
                this.label = 1;
                if (TrackingKt.track(companion, internalSuperwallEvent, this) == objF) {
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
    }

    /* JADX INFO: renamed from: com.superwall.sdk.dependencies.DependencyContainer$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.dependencies.DependencyContainer$2", f = "DependencyContainer.kt", l = {286}, m = "invokeSuspend")
    static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Either<? extends SuperwallProductsResponse, NetworkError>>, Object> {
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return DependencyContainer.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 != 0) {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                return obj;
            }
            ResultKt.b(obj);
            Network network = DependencyContainer.this.getNetwork();
            this.label = 1;
            Object superwallProducts = network.getSuperwallProducts(this);
            return superwallProducts == objF ? objF : superwallProducts;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Either<SuperwallProductsResponse, NetworkError>> continuation) {
            return ((AnonymousClass2) create(continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.dependencies.DependencyContainer$21, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.dependencies.DependencyContainer$21", f = "DependencyContainer.kt", l = {486}, m = "invokeSuspend")
    static final class AnonymousClass21 extends SuspendLambda implements Function2<TrackableSuperwallEvent, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;

        AnonymousClass21(Continuation<? super AnonymousClass21> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass21 anonymousClass21 = new AnonymousClass21(continuation);
            anonymousClass21.L$0 = obj;
            return anonymousClass21;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(TrackableSuperwallEvent trackableSuperwallEvent, Continuation<? super Unit> continuation) {
            return ((AnonymousClass21) create(trackableSuperwallEvent, continuation)).invokeSuspend(Unit.f139807a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                TrackableSuperwallEvent trackableSuperwallEvent = (TrackableSuperwallEvent) this.L$0;
                Superwall companion = Superwall.Companion.getInstance();
                this.label = 1;
                if (TrackingKt.track(companion, trackableSuperwallEvent, this) == objF) {
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
    }

    /* JADX INFO: renamed from: com.superwall.sdk.dependencies.DependencyContainer$24, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.dependencies.DependencyContainer$24", f = "DependencyContainer.kt", l = {496}, m = "invokeSuspend")
    static final class AnonymousClass24 extends SuspendLambda implements Function3<Config, Boolean, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        /* synthetic */ boolean Z$0;
        int label;

        AnonymousClass24(Continuation<? super AnonymousClass24> continuation) {
            super(3, continuation);
        }

        public final Object invoke(Config config, boolean z2, Continuation<? super Unit> continuation) {
            AnonymousClass24 anonymousClass24 = DependencyContainer.this.new AnonymousClass24(continuation);
            anonymousClass24.L$0 = config;
            anonymousClass24.Z$0 = z2;
            return anonymousClass24.invokeSuspend(Unit.f139807a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                Config config = (Config) this.L$0;
                boolean z2 = this.Z$0;
                TestMode testMode$superwall_release = DependencyContainer.this.getTestMode$superwall_release();
                this.label = 1;
                if (testMode$superwall_release.activate(config, z2, this) == objF) {
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
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return invoke((Config) obj, ((Boolean) obj2).booleanValue(), (Continuation<? super Unit>) obj3);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.dependencies.DependencyContainer$30, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.dependencies.DependencyContainer$30", f = "DependencyContainer.kt", l = {}, m = "invokeSuspend")
    static final class AnonymousClass30 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass30(Continuation<? super AnonymousClass30> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return DependencyContainer.this.new AnonymousClass30(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            ProcessLifecycleOwner.f40032j.a().getLifecycle().addObserver(DependencyContainer.this.getAppSessionManager());
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass30) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.dependencies.DependencyContainer$31, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.dependencies.DependencyContainer$31", f = "DependencyContainer.kt", l = {578}, m = "invokeSuspend")
    static final class AnonymousClass31 extends SuspendLambda implements Function2<TrackableSuperwallEvent, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;

        AnonymousClass31(Continuation<? super AnonymousClass31> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass31 anonymousClass31 = new AnonymousClass31(continuation);
            anonymousClass31.L$0 = obj;
            return anonymousClass31;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(TrackableSuperwallEvent trackableSuperwallEvent, Continuation<? super Unit> continuation) {
            return ((AnonymousClass31) create(trackableSuperwallEvent, continuation)).invokeSuspend(Unit.f139807a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                TrackableSuperwallEvent trackableSuperwallEvent = (TrackableSuperwallEvent) this.L$0;
                Superwall companion = Superwall.Companion.getInstance();
                this.label = 1;
                if (TrackingKt.track(companion, trackableSuperwallEvent, this) == objF) {
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
    }

    /* JADX INFO: renamed from: com.superwall.sdk.dependencies.DependencyContainer$32, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.dependencies.DependencyContainer$32", f = "DependencyContainer.kt", l = {590}, m = "invokeSuspend")
    static final class AnonymousClass32 extends SuspendLambda implements Function3<String, PaywallResult, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        AnonymousClass32(Continuation<? super AnonymousClass32> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                String str = (String) this.L$0;
                PaywallResult paywallResult = (PaywallResult) this.L$1;
                PaywallView paywallViewResolvePaywallViewForKey = ViewResolutionKt.resolvePaywallViewForKey(DependencyContainer.this.makeViewStore(), Superwall.Companion.getInstance().getPaywallView(), str);
                if (paywallViewResolvePaywallViewForKey == null) {
                    return Unit.f139807a;
                }
                this.L$0 = null;
                this.label = 1;
                if (InternalPresentationKt.dismiss$default(paywallViewResolvePaywallViewForKey, paywallResult, null, null, this, 12, null) == objF) {
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
        public final Object invoke(String str, PaywallResult paywallResult, Continuation<? super Unit> continuation) {
            AnonymousClass32 anonymousClass32 = DependencyContainer.this.new AnonymousClass32(continuation);
            anonymousClass32.L$0 = str;
            anonymousClass32.L$1 = paywallResult;
            return anonymousClass32.invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.dependencies.DependencyContainer$37, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.dependencies.DependencyContainer$37", f = "DependencyContainer.kt", l = {}, m = "invokeSuspend")
    static final class AnonymousClass37 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass37(Continuation<? super AnonymousClass37> continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return DependencyContainer.this.new AnonymousClass37(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            DependencyContainer.this.showWebRestoreSuccesful();
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass37) create(continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.dependencies.DependencyContainer$38, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.dependencies.DependencyContainer$38", f = "DependencyContainer.kt", l = {597}, m = "invokeSuspend")
    static final class AnonymousClass38 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass38(Continuation<? super AnonymousClass38> continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return DependencyContainer.this.new AnonymousClass38(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass38) create(continuation)).invokeSuspend(Unit.f139807a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 != 0) {
                if (i3 == 1) {
                    ResultKt.b(obj);
                } else {
                    throw new IllegalStateException(CbYNFSEGaQj.vxjQ);
                }
            } else {
                ResultKt.b(obj);
                WebPaywallRedeemer reedemer = DependencyContainer.this.getReedemer();
                WebPaywallRedeemer.RedeemType.Existing existing = WebPaywallRedeemer.RedeemType.Existing.INSTANCE;
                this.label = 1;
                if (reedemer.redeem(existing, this) == objF) {
                    return objF;
                }
            }
            return Unit.f139807a;
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.dependencies.DependencyContainer$41, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.dependencies.DependencyContainer$41", f = "DependencyContainer.kt", l = {}, m = "invokeSuspend")
    static final class AnonymousClass41 extends SuspendLambda implements Function5<String, Long, String, Boolean, Continuation<? super Unit>, Object> {
        final /* synthetic */ ActivityProvider $activityProvider;
        /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        /* synthetic */ Object L$2;
        /* synthetic */ boolean Z$0;
        int label;

        /* JADX INFO: renamed from: com.superwall.sdk.dependencies.DependencyContainer$41$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @DebugMetadata(c = "com.superwall.sdk.dependencies.DependencyContainer$41$1", f = "DependencyContainer.kt", l = {684}, m = "invokeSuspend")
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ SuperwallPaywallActivity $paywallActivity;
            final /* synthetic */ List<LocalNotification> $trialNotifications;
            int label;
            final /* synthetic */ DependencyContainer this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(SuperwallPaywallActivity superwallPaywallActivity, List<LocalNotification> list, DependencyContainer dependencyContainer, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$paywallActivity = superwallPaywallActivity;
                this.$trialNotifications = list;
                this.this$0 = dependencyContainer;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.$paywallActivity, this.$trialNotifications, this.this$0, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objF = IntrinsicsKt.f();
                int i3 = this.label;
                if (i3 == 0) {
                    ResultKt.b(obj);
                    SuperwallPaywallActivity superwallPaywallActivity = this.$paywallActivity;
                    List<LocalNotification> list = this.$trialNotifications;
                    DependencyContainer dependencyContainer = this.this$0;
                    this.label = 1;
                    if (SuperwallPaywallActivity.attemptToScheduleNotifications$default(superwallPaywallActivity, list, dependencyContainer, false, this, 4, null) == objF) {
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

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass41(ActivityProvider activityProvider, Continuation<? super AnonymousClass41> continuation) {
            super(5, continuation);
            this.$activityProvider = activityProvider;
        }

        @Override // kotlin.jvm.functions.Function5
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
            return invoke((String) obj, (Long) obj2, (String) obj3, ((Boolean) obj4).booleanValue(), (Continuation<? super Unit>) obj5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Activity currentActivity;
            IntrinsicsKt.f();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            String str = (String) this.L$0;
            Long l3 = (Long) this.L$1;
            String str2 = (String) this.L$2;
            boolean z2 = this.Z$0;
            PaywallView paywallViewResolvePaywallViewForKey = ViewResolutionKt.resolvePaywallViewForKey(DependencyContainer.this.makeViewStore(), Superwall.Companion.getInstance().getPaywallView(), str);
            if (paywallViewResolvePaywallViewForKey == null) {
                Logger.debug$default(Logger.INSTANCE, LogLevel.error, LogScope.paywallView, "No active paywall to use - did the app close?", (Map) null, (Throwable) null, 24, (Object) null);
                return Unit.f139807a;
            }
            paywallViewResolvePaywallViewForKey.getWebView$superwall_release().getMessageHandler().handle(new PaywallMessage.TransactionComplete(str2));
            List<LocalNotification> listFallbackTrialNotifications = TrialReminderLogic.INSTANCE.fallbackTrialNotifications(paywallViewResolvePaywallViewForKey.getState().getInfo(), z2);
            if (!listFallbackTrialNotifications.isEmpty()) {
                WeakReference<Activity> encapsulatingActivity = paywallViewResolvePaywallViewForKey.getEncapsulatingActivity();
                if (encapsulatingActivity == null || (currentActivity = encapsulatingActivity.get()) == null) {
                    ActivityProvider activityProvider = this.$activityProvider;
                    currentActivity = activityProvider != null ? activityProvider.getCurrentActivity() : null;
                }
                SuperwallPaywallActivity superwallPaywallActivity = currentActivity instanceof SuperwallPaywallActivity ? (SuperwallPaywallActivity) currentActivity : null;
                if (superwallPaywallActivity != null) {
                    BuildersKt__Builders_commonKt.d(DependencyContainer.this.getIoScope(), null, null, new AnonymousClass1(superwallPaywallActivity, listFallbackTrialNotifications, DependencyContainer.this, null), 3, null);
                } else {
                    Logger.debug$default(Logger.INSTANCE, LogLevel.warn, LogScope.paywallView, "No paywall activity available to schedule fallback notifications", (Map) null, (Throwable) null, 24, (Object) null);
                }
            }
            if (z2) {
                paywallViewResolvePaywallViewForKey.getWebView$superwall_release().getMessageHandler().handle(new PaywallMessage.TrialStarted(l3, str2));
            }
            return Unit.f139807a;
        }

        public final Object invoke(String str, Long l3, String str2, boolean z2, Continuation<? super Unit> continuation) {
            AnonymousClass41 anonymousClass41 = DependencyContainer.this.new AnonymousClass41(this.$activityProvider, continuation);
            anonymousClass41.L$0 = str;
            anonymousClass41.L$1 = l3;
            anonymousClass41.L$2 = str2;
            anonymousClass41.Z$0 = z2;
            return anonymousClass41.invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.dependencies.DependencyContainer$42, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.dependencies.DependencyContainer$42", f = "DependencyContainer.kt", l = {}, m = "invokeSuspend")
    static final class AnonymousClass42 extends SuspendLambda implements Function2<String, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;

        AnonymousClass42(Continuation<? super AnonymousClass42> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass42 anonymousClass42 = DependencyContainer.this.new AnonymousClass42(continuation);
            anonymousClass42.L$0 = obj;
            return anonymousClass42;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            PaywallView paywallViewResolvePaywallViewForKey = ViewResolutionKt.resolvePaywallViewForKey(DependencyContainer.this.makeViewStore(), Superwall.Companion.getInstance().getPaywallView(), (String) this.L$0);
            if (paywallViewResolvePaywallViewForKey == null) {
                return Unit.f139807a;
            }
            paywallViewResolvePaywallViewForKey.getWebView$superwall_release().getMessageHandler().handle(PaywallMessage.TransactionAbandon.INSTANCE);
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(String str, Continuation<? super Unit> continuation) {
            return ((AnonymousClass42) create(str, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.dependencies.DependencyContainer$45, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.dependencies.DependencyContainer$45", f = "DependencyContainer.kt", l = {731}, m = "invokeSuspend")
    static final class AnonymousClass45 extends SuspendLambda implements Function2<TrackableSuperwallEvent, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;

        AnonymousClass45(Continuation<? super AnonymousClass45> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass45 anonymousClass45 = DependencyContainer.this.new AnonymousClass45(continuation);
            anonymousClass45.L$0 = obj;
            return anonymousClass45;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(TrackableSuperwallEvent trackableSuperwallEvent, Continuation<? super Unit> continuation) {
            return ((AnonymousClass45) create(trackableSuperwallEvent, continuation)).invokeSuspend(Unit.f139807a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                TrackableSuperwallEvent trackableSuperwallEvent = (TrackableSuperwallEvent) this.L$0;
                DependencyContainer dependencyContainer = DependencyContainer.this;
                this.label = 1;
                if (dependencyContainer.mo1271trackgIAlus(trackableSuperwallEvent, this) == objF) {
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
    }

    /* JADX INFO: renamed from: com.superwall.sdk.dependencies.DependencyContainer$46, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.dependencies.DependencyContainer$46", f = "DependencyContainer.kt", l = {737}, m = "invokeSuspend")
    static final class AnonymousClass46 extends SuspendLambda implements Function2<TrackableSuperwallEvent, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;

        AnonymousClass46(Continuation<? super AnonymousClass46> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass46 anonymousClass46 = DependencyContainer.this.new AnonymousClass46(continuation);
            anonymousClass46.L$0 = obj;
            return anonymousClass46;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(TrackableSuperwallEvent trackableSuperwallEvent, Continuation<? super Unit> continuation) {
            return ((AnonymousClass46) create(trackableSuperwallEvent, continuation)).invokeSuspend(Unit.f139807a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                TrackableSuperwallEvent trackableSuperwallEvent = (TrackableSuperwallEvent) this.L$0;
                DependencyContainer dependencyContainer = DependencyContainer.this;
                this.label = 1;
                if (dependencyContainer.mo1271trackgIAlus(trackableSuperwallEvent, this) == objF) {
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
    }

    /* JADX INFO: renamed from: com.superwall.sdk.dependencies.DependencyContainer$49, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.dependencies.DependencyContainer$49", f = "DependencyContainer.kt", l = {}, m = "invokeSuspend")
    static final class AnonymousClass49 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        AnonymousClass49(Continuation<? super AnonymousClass49> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass49 anonymousClass49 = DependencyContainer.this.new AnonymousClass49(continuation);
            anonymousClass49.L$0 = obj;
            return anonymousClass49;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objB;
            IntrinsicsKt.f();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            if (WebviewChecker.INSTANCE.getWebviewExists()) {
                DependencyContainer dependencyContainer = DependencyContainer.this;
                try {
                    Result.Companion companion = Result.f139772b;
                    objB = Result.b(WebSettings.getDefaultUserAgent(dependencyContainer.getContext()));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.f139772b;
                    objB = Result.b(ResultKt.a(th));
                }
                DependencyContainer dependencyContainer2 = DependencyContainer.this;
                if (Result.e(objB) != null) {
                    try {
                        Result.b(WebSettings.getDefaultUserAgent(dependencyContainer2.getContext()));
                    } catch (Throwable th2) {
                        Result.Companion companion3 = Result.f139772b;
                        Result.b(ResultKt.a(th2));
                    }
                }
            }
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass49) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.dependencies.DependencyContainer$8, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.dependencies.DependencyContainer$8", f = "DependencyContainer.kt", l = {298}, m = "invokeSuspend")
    static final class AnonymousClass8 extends SuspendLambda implements Function2<InternalSuperwallEvent, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;

        AnonymousClass8(Continuation<? super AnonymousClass8> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass8 anonymousClass8 = new AnonymousClass8(continuation);
            anonymousClass8.L$0 = obj;
            return anonymousClass8;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(InternalSuperwallEvent internalSuperwallEvent, Continuation<? super Unit> continuation) {
            return ((AnonymousClass8) create(internalSuperwallEvent, continuation)).invokeSuspend(Unit.f139807a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                InternalSuperwallEvent internalSuperwallEvent = (InternalSuperwallEvent) this.L$0;
                Superwall companion = Superwall.Companion.getInstance();
                this.label = 1;
                if (TrackingKt.track(companion, internalSuperwallEvent, this) == objF) {
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
    }

    /* JADX INFO: renamed from: com.superwall.sdk.dependencies.DependencyContainer$closePaywallIfExists$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.dependencies.DependencyContainer$closePaywallIfExists$1", f = "DependencyContainer.kt", l = {1315}, m = "invokeSuspend")
    static final class C27991 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C27991(Continuation<? super C27991> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C27991(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                Superwall companion = Superwall.Companion.getInstance();
                this.label = 1;
                if (PublicPresentationKt.dismiss(companion, this) == objF) {
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
            return ((C27991) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.dependencies.DependencyContainer$makeJsonVariables$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.dependencies.DependencyContainer", f = "DependencyContainer.kt", l = {1060}, m = "makeJsonVariables")
    static final class C28001 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C28001(Continuation<? super C28001> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DependencyContainer.this.makeJsonVariables(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.dependencies.DependencyContainer$makePaywallView$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.dependencies.DependencyContainer", f = "DependencyContainer.kt", l = {884}, m = "makePaywallView")
    static final class C28011 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C28011(Continuation<? super C28011> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DependencyContainer.this.makePaywallView(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.dependencies.DependencyContainer$makeRuleAttributes$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.dependencies.DependencyContainer", f = "DependencyContainer.kt", l = {1029}, m = "makeRuleAttributes")
    static final class C28021 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C28021(Continuation<? super C28021> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DependencyContainer.this.makeRuleAttributes(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.dependencies.DependencyContainer$makeSessionDeviceAttributes$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.dependencies.DependencyContainer", f = "DependencyContainer.kt", l = {931}, m = "makeSessionDeviceAttributes")
    static final class C28031 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C28031(Continuation<? super C28031> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DependencyContainer.this.makeSessionDeviceAttributes(this);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.dependencies.DependencyContainer$receipts$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.dependencies.DependencyContainer", f = "DependencyContainer.kt", l = {1291, 1293}, m = "receipts")
    static final class C28041 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        C28041(Continuation<? super C28041> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DependencyContainer.this.receipts(this);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.dependencies.DependencyContainer$scheduleTrialNotifications$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.dependencies.DependencyContainer$scheduleTrialNotifications$2", f = "DependencyContainer.kt", l = {1327}, m = "invokeSuspend")
    static final class C28052 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<LocalNotification> $notifications;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C28052(List<LocalNotification> list, Continuation<? super C28052> continuation) {
            super(2, continuation);
            this.$notifications = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return DependencyContainer.this.new C28052(this.$notifications, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Activity currentActivity;
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                PaywallView paywallView = Superwall.Companion.getInstance().getPaywallView();
                if (paywallView == null) {
                    return Unit.f139807a;
                }
                WeakReference<Activity> encapsulatingActivity = paywallView.getEncapsulatingActivity();
                if (encapsulatingActivity == null || (currentActivity = encapsulatingActivity.get()) == null) {
                    ActivityProvider activityProvider = DependencyContainer.this.getActivityProvider();
                    currentActivity = activityProvider != null ? activityProvider.getCurrentActivity() : null;
                }
                SuperwallPaywallActivity superwallPaywallActivity = currentActivity instanceof SuperwallPaywallActivity ? (SuperwallPaywallActivity) currentActivity : null;
                if (superwallPaywallActivity == null) {
                    return Unit.f139807a;
                }
                if (!superwallPaywallActivity.isFinishing() && !superwallPaywallActivity.isDestroyed()) {
                    List<LocalNotification> list = this.$notifications;
                    DependencyContainer dependencyContainer = DependencyContainer.this;
                    this.label = 1;
                    if (superwallPaywallActivity.attemptToScheduleNotifications$superwall_release(list, dependencyContainer, false, false, this) == objF) {
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
            return ((C28052) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.dependencies.DependencyContainer$showWebRestoreSuccesful$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.dependencies.DependencyContainer$showWebRestoreSuccesful$1", f = "DependencyContainer.kt", l = {1148}, m = "invokeSuspend")
    static final class C28061 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PaywallView $paywallView;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C28061(PaywallView paywallView, Continuation<? super C28061> continuation) {
            super(2, continuation);
            this.$paywallView = paywallView;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C28061(this.$paywallView, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                Superwall companion = Superwall.Companion.getInstance();
                InternalSuperwallEvent.Restore restore = new InternalSuperwallEvent.Restore(InternalSuperwallEvent.Restore.State.Complete.INSTANCE, this.$paywallView.getInfo());
                this.label = 1;
                if (TrackingKt.track(companion, restore, this) == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                ((Result) obj).j();
            }
            this.$paywallView.handle(PaywallMessage.Restore.INSTANCE);
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C28061) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.dependencies.DependencyContainer$showWebRestoreSuccesful$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.dependencies.DependencyContainer$showWebRestoreSuccesful$2", f = "DependencyContainer.kt", l = {1158}, m = "invokeSuspend")
    static final class C28072 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C28072(Continuation<? super C28072> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C28072(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                Superwall companion = Superwall.Companion.getInstance();
                this.label = 1;
                if (PublicPresentationKt.dismiss(companion, this) == objF) {
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
            return ((C28072) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.dependencies.DependencyContainer$track$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.dependencies.DependencyContainer", f = "DependencyContainer.kt", l = {1198}, m = "track-gIAlu-s")
    static final class C28081 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C28081(Continuation<? super C28081> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            Object objMo1271trackgIAlus = DependencyContainer.this.mo1271trackgIAlus(null, this);
            return objMo1271trackgIAlus == IntrinsicsKt.f() ? objMo1271trackgIAlus : Result.a(objMo1271trackgIAlus);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.dependencies.DependencyContainer$track$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.dependencies.DependencyContainer", f = "DependencyContainer.kt", l = {1262}, m = "track")
    static final class C28092 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C28092(Continuation<? super C28092> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DependencyContainer.this.track(null, this);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.dependencies.DependencyContainer$trackRestorationFailure$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.dependencies.DependencyContainer$trackRestorationFailure$1", f = "DependencyContainer.kt", l = {1175}, m = "invokeSuspend")
    static final class C28101 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ InternalSuperwallEvent.Restore $trackedEvent;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C28101(InternalSuperwallEvent.Restore restore, Continuation<? super C28101> continuation) {
            super(2, continuation);
            this.$trackedEvent = restore;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C28101(this.$trackedEvent, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                Superwall companion = Superwall.Companion.getInstance();
                InternalSuperwallEvent.Restore restore = this.$trackedEvent;
                this.label = 1;
                if (TrackingKt.track(companion, restore, this) == objF) {
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
            return ((C28101) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DependencyContainer(Context context, PurchaseController purchaseController, SuperwallOptions superwallOptions, ActivityProvider activityProvider, String apiKey) {
        Context context2;
        PurchaseController automaticPurchaseController;
        Context context3;
        ReviewManager reviewManagerImpl;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(apiKey, "apiKey");
        this.context = context;
        this.activityProvider = activityProvider;
        this.apiKey = apiKey;
        this.getPaywallComponentsFactory$delegate = LazyKt.b(new Function0() { // from class: com.superwall.sdk.dependencies.i0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DependencyContainer.getPaywallComponentsFactory_delegate$lambda$0();
            }
        });
        this.appLifecycleObserver = new AppLifecycleObserver();
        this.evaluator$delegate = LazyKt.b(new Function0() { // from class: com.superwall.sdk.dependencies.g
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DependencyContainer.evaluator_delegate$lambda$2(this.f93536a);
            }
        });
        CoroutineScope coroutineScope = null;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        Object[] objArr3 = 0;
        BuildersKt__Builders_commonKt.d(getUiScope(), null, null, new AnonymousClass1(null), 3, null);
        final CurrentActivityTracker currentActivityTracker = new CurrentActivityTracker();
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNull(applicationContext, "null cannot be cast to non-null type android.app.Application");
        ((Application) applicationContext).registerActivityLifecycleCallbacks(currentActivityTracker);
        ActivityProvider activityProvider2 = this.activityProvider;
        ActivityProvider activityProvider3 = activityProvider2 == null ? currentActivityTracker : activityProvider2;
        this.activityProvider = activityProvider3;
        GoogleBillingWrapper googleBillingWrapper = new GoogleBillingWrapper(context, getIoScope(), getAppLifecycleObserver(), this, null, 16, null);
        this.googleBillingWrapper = googleBillingWrapper;
        setStorage(new LocalStorage(context, json(), apiKey, this, ioScope(), null, 0 == true ? 1 : 0, 96, null));
        int i3 = 2;
        this.entitlements = new Entitlements(getStorage(), coroutineScope, i3, objArr3 == true ? 1 : 0);
        final SuperwallOptions superwallOptions2 = superwallOptions == null ? new SuperwallOptions() : superwallOptions;
        TestMode testMode = new TestMode(getStorage(), false, new AnonymousClass2(null), this.entitlements, new Function0() { // from class: com.superwall.sdk.dependencies.s
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f93551a.activityProvider;
            }
        }, new Function0() { // from class: com.superwall.sdk.dependencies.y
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DependencyContainer._init_$lambda$4(currentActivityTracker);
            }
        }, new Function0() { // from class: com.superwall.sdk.dependencies.z
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(this.f93556a.makeHasExternalPurchaseController());
            }
        }, new Function0() { // from class: com.superwall.sdk.dependencies.a0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DependencyContainer._init_$lambda$6(this.f93527a);
            }
        }, new Function0() { // from class: com.superwall.sdk.dependencies.b0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DependencyContainer._init_$lambda$7(superwallOptions2);
            }
        }, new AnonymousClass8(null), 2, null);
        this.testMode = testMode;
        TestModeTransactionHandler testModeTransactionHandler = new TestModeTransactionHandler(testMode, activityProvider3, currentActivityTracker);
        this.testModeTransactionHandler = testModeTransactionHandler;
        setCustomerInfoManager$superwall_release(new CustomerInfoManager(getStorage(), new Function1() { // from class: com.superwall.sdk.dependencies.c0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DependencyContainer._init_$lambda$8((CustomerInfo) obj);
            }
        }, getIoScope(), new Function0() { // from class: com.superwall.sdk.dependencies.d0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(DependencyContainer._init_$lambda$9(this.f93532a));
            }
        }, new Function0() { // from class: com.superwall.sdk.dependencies.e0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DependencyContainer._init_$lambda$10(this.f93534a);
            }
        }));
        if (purchaseController == null) {
            automaticPurchaseController = new AutomaticPurchaseController(context, getIoScope(), new Function0() { // from class: com.superwall.sdk.dependencies.j0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return this.f93541a.entitlements;
                }
            }, null, 8, null);
            context2 = context;
        } else {
            context2 = context;
            automaticPurchaseController = purchaseController;
        }
        InternalPurchaseController internalPurchaseController = new InternalPurchaseController(automaticPurchaseController, null, context2);
        this.storeManager = new StoreManager(internalPurchaseController, googleBillingWrapper, new Function0() { // from class: com.superwall.sdk.dependencies.k0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DependencyContainer._init_$lambda$13(this.f93543a);
            }
        }, null, new AnonymousClass13(null), testMode, 8, null);
        BuildersKt__Builders_commonKt.d(getIoScope(), null, null, new AnonymousClass14(null), 3, null);
        this.delegateAdapter = new SuperwallDelegateAdapter();
        CustomHttpUrlConnection customHttpUrlConnection = new CustomHttpUrlConnection(json(), new RequestExecutor(new DependencyContainer$httpConnection$1(this, null)), null, 4, null);
        setApi(new Api(superwallOptions2.getNetworkEnvironment()));
        DefaultConstructorMarker defaultConstructorMarker = null;
        this.network = new Network(new BaseHostService(getApi().getBase().getHost(), Api.version1, this, json(), customHttpUrlConnection), new CollectorService(getApi().getCollector().getHost(), Api.version1, this, json(), customHttpUrlConnection), new EnrichmentService(getApi().getEnrichment().getHost(), Api.version1, this, customHttpUrlConnection), this, new SubscriptionService(getApi().getSubscription().getHost(), Api.subscriptionsv1, this, JsonKt.a(json(), new Function1() { // from class: com.superwall.sdk.dependencies.l0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DependencyContainer._init_$lambda$14((JsonBuilder) obj);
            }
        }), new CustomHttpUrlConnection(JsonKt.a(json(), new Function1() { // from class: com.superwall.sdk.dependencies.m0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DependencyContainer._init_$lambda$15((JsonBuilder) obj);
            }
        }), new RequestExecutor(new AnonymousClass17(null)), null, 4, defaultConstructorMarker)));
        DefaultConstructorMarker defaultConstructorMarker2 = null;
        this.errorTracker = new ErrorTracker(getIoScope(), getStorage(), null, 4, defaultConstructorMarker2);
        PaywallRequestManager paywallRequestManager = new PaywallRequestManager(this.storeManager, this.network, this, getIoScope(), null, null, 0 == true ? 1 : 0, 112, defaultConstructorMarker2);
        this.paywallRequestManager = paywallRequestManager;
        this.paywallManager = new PaywallManager(this, paywallRequestManager);
        setDeviceHelper(new DeviceHelper(context, getStorage(), this.network, this, new DeviceClassifier(new DefaultClassifierDataFactory(new Function0() { // from class: com.superwall.sdk.dependencies.n0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f93545a.context;
            }
        }))));
        Assignments assignments = new Assignments(getStorage(), this.network, getIoScope(), null, 8, null);
        this.assignments = assignments;
        PaywallPreload paywallPreload = new PaywallPreload(this, getIoScope(), getStorage(), assignments, this.paywallManager, new AnonymousClass19(null));
        this.paywallPreload = paywallPreload;
        SequentialActor sequentialActor = new SequentialActor(IdentityManagerActorKt.createInitialIdentityState(getStorage(), getDeviceHelper().getAppInstalledAtString()), objArr2 == true ? 1 : 0, i3, objArr == true ? 1 : 0);
        IdentityPendingInterceptor.INSTANCE.install(sequentialActor);
        IdentityPersistenceInterceptor.INSTANCE.install(sequentialActor, getStorage());
        SdkContextImpl sdkContextImpl = new SdkContextImpl(new Function0() { // from class: com.superwall.sdk.dependencies.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f93528a.getConfigManager();
            }
        });
        SequentialActor sequentialActor2 = new SequentialActor(ConfigState.None.INSTANCE, getIoScope());
        ActivityProvider activityProvider4 = activityProvider3;
        final SuperwallOptions superwallOptions3 = superwallOptions2;
        setConfigManager(new ConfigManager(context, this.storeManager, this.entitlements, getStorage(), this.network, getDeviceHelper(), superwallOptions3, this.paywallManager, new Function0() { // from class: com.superwall.sdk.dependencies.c
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f93530a.getReedemer();
            }
        }, this, assignments, paywallPreload, getIoScope(), new AnonymousClass21(null), testMode, new Function0() { // from class: com.superwall.sdk.dependencies.d
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f93531a.getIdentityManager();
            }
        }, new Function1() { // from class: com.superwall.sdk.dependencies.e
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DependencyContainer._init_$lambda$20(this.f93533a, (SubscriptionStatus) obj);
            }
        }, null, new AnonymousClass24(null), sequentialActor2, 131072, defaultConstructorMarker));
        setIdentityManager(new IdentityManager(getStorage(), getIoScope(), new Function1() { // from class: com.superwall.sdk.dependencies.f
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DependencyContainer._init_$lambda$22((String) obj);
            }
        }, new Function1() { // from class: com.superwall.sdk.dependencies.h
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DependencyContainer._init_$lambda$23(this.f93537a, (Map) obj);
            }
        }, null, null, new Function0() { // from class: com.superwall.sdk.dependencies.i
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DependencyContainer._init_$lambda$24(superwallOptions3);
            }
        }, new Function0() { // from class: com.superwall.sdk.dependencies.j
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f93540a.getReedemer();
            }
        }, sequentialActor, sdkContextImpl, 48, null));
        setReedemer(new WebPaywallRedeemer(context, getIoScope(), new DeepLinkReferrer(new Function0() { // from class: com.superwall.sdk.dependencies.k
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f93542a.context;
            }
        }, getIoScope()), this.network, getStorage(), getCustomerInfoManager$superwall_release(), this));
        this.eventsQueue = new EventsQueue(context, this.network, ioScope(), mainScope(), getConfigManager());
        this.sessionEventsManager = new SessionEventsManager(getStorage(), this.network, getConfigManager());
        this.appSessionManager = new AppSessionManager(getConfigManager(), getStorage(), this, getIoScope());
        this.debugManager = new DebugManager(context, getStorage(), this);
        BuildersKt__Builders_commonKt.d(getUiScope(), null, null, new AnonymousClass30(null), 3, null);
        this.transactionManager = new TransactionManager(this.storeManager, internalPurchaseController, this.eventsQueue, getStorage(), activityProvider4, this, ioScope(), new AnonymousClass31(null), new AnonymousClass32(null), new Function1() { // from class: com.superwall.sdk.dependencies.m
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DependencyContainer._init_$lambda$27((AlertControllerFactory.AlertProps) obj);
            }
        }, null, new Function1() { // from class: com.superwall.sdk.dependencies.n
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DependencyContainer._init_$lambda$28(this.f93544a, (String) obj);
            }
        }, new Function0() { // from class: com.superwall.sdk.dependencies.o
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DependencyContainer._init_$lambda$29(this.f93546a);
            }
        }, new Function0() { // from class: com.superwall.sdk.dependencies.p
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DependencyContainer._init_$lambda$30(this.f93548a);
            }
        }, null, new AnonymousClass37(null), new AnonymousClass38(null), new Function0() { // from class: com.superwall.sdk.dependencies.q
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DependencyContainer._init_$lambda$31(this.f93549a);
            }
        }, new Function2() { // from class: com.superwall.sdk.dependencies.r
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return DependencyContainer._init_$lambda$32(this.f93550a, (String) obj, (PaywallViewState.Updates) obj2);
            }
        }, new AnonymousClass41(activityProvider4, null), new AnonymousClass42(null), testMode, testModeTransactionHandler, new Function1() { // from class: com.superwall.sdk.dependencies.t
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DependencyContainer._init_$lambda$33(this.f93552a, (SubscriptionStatus) obj);
            }
        }, 17408, null);
        if (superwallOptions3.getUseMockReviews()) {
            context3 = context;
            reviewManagerImpl = new MockReviewManager(context3);
        } else {
            context3 = context;
            reviewManagerImpl = new ReviewManagerImpl(context3, new Function0() { // from class: com.superwall.sdk.dependencies.u
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Boolean.valueOf(this.f93553a.makeIsSandbox());
                }
            });
        }
        this.reviewManager = reviewManagerImpl;
        this.userPermissions = new UserPermissionsImpl(context3);
        this.customCallbackRegistry = new CustomCallbackRegistry();
        this.deepLinkRouter = new DeepLinkRouter(getReedemer(), getIoScope(), this.debugManager, new AnonymousClass45(null));
        this.attributionManager = new AttributionManager(getStorage(), new AnonymousClass46(null), getIoScope(), new Function0() { // from class: com.superwall.sdk.dependencies.v
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DependencyContainer._init_$lambda$35(this.f93554a);
            }
        }, new Function0<VendorId>() { // from class: com.superwall.sdk.dependencies.DependencyContainer.48
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                return VendorId.m1284boximpl(m1272invoke6xTLGo0());
            }

            /* JADX INFO: renamed from: invoke-6xTLGo0, reason: not valid java name */
            public final String m1272invoke6xTLGo0() {
                return VendorId.m1285constructorimpl(DependencyContainer.this.getDeviceHelper().getVendorId());
            }
        });
        BuildersKt__Builders_commonKt.d(getIoScope(), null, null, new AnonymousClass49(null), 3, null);
        this.paywallJson = JsonKt.b(null, new Function1() { // from class: com.superwall.sdk.dependencies.x
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DependencyContainer.paywallJson$lambda$37((JsonBuilder) obj);
            }
        }, 1, null);
        this.vmProvider = new ViewModelProvider(getStoreOwner(), getVmFactory());
    }

    public static CustomerInfoManager N(DependencyContainer dependencyContainer) {
        return dependencyContainer.getCustomerInfoManager$superwall_release();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SubscriptionStatus _init_$lambda$10(DependencyContainer dependencyContainer) {
        return (SubscriptionStatus) dependencyContainer.entitlements.getStatus().getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ReceiptManager _init_$lambda$13(final DependencyContainer dependencyContainer) {
        return new ReceiptManager(dependencyContainer.storeManager, dependencyContainer.googleBillingWrapper, null, dependencyContainer.getStorage(), new Function0() { // from class: com.superwall.sdk.dependencies.f0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DependencyContainer.N(this.f93535a);
            }
        }, null, null, 100, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$14(JsonBuilder Json) {
        Intrinsics.checkNotNullParameter(Json, "$this$Json");
        Json.h(true);
        Json.j(null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$15(JsonBuilder Json) {
        Intrinsics.checkNotNullParameter(Json, "$this$Json");
        Json.h(true);
        Json.j(null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$20(DependencyContainer dependencyContainer, SubscriptionStatus status) {
        Intrinsics.checkNotNullParameter(status, "status");
        dependencyContainer.entitlements.setSubscriptionStatus(status);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String _init_$lambda$22(String userId) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        String strSha256Hex = String_SHA256Kt.sha256Hex(userId);
        if (strSha256Hex != null) {
            return strSha256Hex;
        }
        throw new IllegalStateException("SHA-256 is unavailable");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$23(DependencyContainer dependencyContainer, Map it) {
        Intrinsics.checkNotNullParameter(it, "it");
        dependencyContainer.delegate().userAttributesDidChange(it);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$27(AlertControllerFactory.AlertProps it) {
        Intrinsics.checkNotNullParameter(it, "it");
        PaywallView paywallView = Superwall.Companion.getInstance().getPaywallView();
        if (paywallView != null) {
            paywallView.showAlert(it.getTitle(), it.getMessage(), it.getActionTitle(), it.getCloseActionTitle(), it.getAction(), it.getOnClose());
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Set _init_$lambda$28(DependencyContainer dependencyContainer, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return dependencyContainer.entitlements.byProductId$superwall_release(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map _init_$lambda$29(DependencyContainer dependencyContainer) {
        return dependencyContainer.entitlements.getEntitlementsByProductId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Set _init_$lambda$30(DependencyContainer dependencyContainer) {
        return dependencyContainer.entitlements.getWeb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$31(DependencyContainer dependencyContainer) {
        dependencyContainer.storeManager.refreshReceipt();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$32(DependencyContainer dependencyContainer, String key, PaywallViewState.Updates state) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(state, "state");
        PaywallView paywallViewResolvePaywallViewForKey = ViewResolutionKt.resolvePaywallViewForKey(dependencyContainer.makeViewStore(), Superwall.Companion.getInstance().getPaywallView(), key);
        if (paywallViewResolvePaywallViewForKey == null) {
            return Unit.f139807a;
        }
        paywallViewResolvePaywallViewForKey.updateState(state);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$33(DependencyContainer dependencyContainer, SubscriptionStatus status) {
        Intrinsics.checkNotNullParameter(status, "status");
        dependencyContainer.entitlements.setSubscriptionStatus(status);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$35(DependencyContainer dependencyContainer) {
        BuildersKt__Builders_commonKt.d(dependencyContainer.getIoScope(), null, null, new DependencyContainer$47$1(dependencyContainer, null), 3, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String _init_$lambda$6(DependencyContainer dependencyContainer) {
        return dependencyContainer.getStorage().getApiKey();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String _init_$lambda$7(SuperwallOptions superwallOptions) {
        return superwallOptions.getNetworkEnvironment() instanceof SuperwallOptions.NetworkEnvironment.Developer ? "https://superwall.dev" : "https://superwall.com";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$8(CustomerInfo it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Superwall.Companion.getInstance().get_customerInfo$superwall_release().setValue(it);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _init_$lambda$9(DependencyContainer dependencyContainer) {
        return dependencyContainer.storeManager.getPurchaseController().getHasExternalPurchaseController();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CombinedExpressionEvaluator evaluator_delegate$lambda$2(DependencyContainer dependencyContainer) {
        return new CombinedExpressionEvaluator(dependencyContainer.getStorage(), new SuperscriptEvaluator(JsonKt.a(dependencyContainer.json(), new Function1() { // from class: com.superwall.sdk.dependencies.g0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DependencyContainer.evaluator_delegate$lambda$2$lambda$1((JsonBuilder) obj);
            }
        }), dependencyContainer.getIoScope(), dependencyContainer.getStorage().getCoreDataManager(), dependencyContainer, null, 16, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit evaluator_delegate$lambda$2$lambda$1(JsonBuilder Json) {
        Intrinsics.checkNotNullParameter(Json, "$this$Json");
        Json.d(ClassDiscriminatorMode.f142951c);
        Json.c("type");
        return Unit.f139807a;
    }

    private final CombinedExpressionEvaluator getEvaluator() {
        return (CombinedExpressionEvaluator) this.evaluator$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IOScope getIoScope() {
        return ioScope();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DefaultGetPaywallComponentsFactory getPaywallComponentsFactory_delegate$lambda$0() {
        return new DefaultGetPaywallComponentsFactory(Superwall.Companion.getInstance());
    }

    private final SuperwallStoreOwner getStoreOwner() {
        return new SuperwallStoreOwner();
    }

    private final MainScope getUiScope() {
        return mainScope();
    }

    private final ViewModelFactory getVmFactory() {
        return new ViewModelFactory();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit makePaywallView$lambda$38(DependencyContainer dependencyContainer, Map it) {
        Intrinsics.checkNotNullParameter(it, "it");
        IdentityManager.mergeAndNotify$superwall_release$default(dependencyContainer.getIdentityManager(), it, false, 2, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PaywallView makePaywallView$lambda$39() {
        return Superwall.Companion.getInstance().getPaywallView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String makePaywallView$lambda$40(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Charset UTF_8 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
        byte[] bytes = it.getBytes(UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        String strEncodeToString = Base64.encodeToString(bytes, 2);
        Intrinsics.checkNotNullExpressionValue(strEncodeToString, "encodeToString(...)");
        return strEncodeToString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Activity makePaywallView$lambda$41(DependencyContainer dependencyContainer) {
        ActivityProvider activityProvider = dependencyContainer.activityProvider;
        if (activityProvider != null) {
            return activityProvider.getCurrentActivity();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit paywallJson$lambda$37(JsonBuilder Json) {
        Intrinsics.checkNotNullParameter(Json, "$this$Json");
        Json.f(true);
        SerializersModuleBuilder serializersModuleBuilder = new SerializersModuleBuilder();
        serializersModuleBuilder.c(Reflection.b(Date.class), DateSerializer.INSTANCE);
        Json.k(serializersModuleBuilder.f());
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showWebRestoreSuccesful() {
        PaywallView paywallView = Superwall.Companion.getInstance().getPaywallView();
        if (paywallView != null) {
            BuildersKt__Builders_commonKt.d(getIoScope(), null, null, new C28061(paywallView, null), 3, null);
            if (makeSuperwallOptions().getPaywalls().getAutomaticallyDismiss()) {
                BuildersKt__Builders_commonKt.d(getIoScope(), null, null, new C28072(null), 3, null);
            }
        }
    }

    private final void trackRestorationFailure(String str) {
        PaywallView paywallView = Superwall.Companion.getInstance().getPaywallView();
        SuperwallOptions superwallOptionsMakeSuperwallOptions = makeSuperwallOptions();
        if (paywallView != null) {
            BuildersKt__Builders_commonKt.d(getIoScope(), null, null, new C28101(new InternalSuperwallEvent.Restore(new InternalSuperwallEvent.Restore.State.Failure(str), paywallView.getInfo()), null), 3, null);
            paywallView.handle(new PaywallMessage.RestoreFailed(str));
            PaywallView.showAlert$default(paywallView, superwallOptionsMakeSuperwallOptions.getPaywalls().getRestoreFailed().getTitle(), superwallOptionsMakeSuperwallOptions.getPaywalls().getRestoreFailed().getMessage(), null, superwallOptionsMakeSuperwallOptions.getPaywalls().getRestoreFailed().getCloseButtonTitle(), null, null, 52, null);
        }
    }

    @Override // com.superwall.sdk.dependencies.ActiveEntitlementsFactory
    public Set<Entitlement> activeEntitlements() {
        return this.entitlements.getActive();
    }

    @Override // com.superwall.sdk.paywall.request.PaywallRequestManagerDepFactory
    public String activePaywallId() {
        PaywallViewState state;
        Paywall paywall;
        PaywallView currentView = this.paywallManager.getCurrentView();
        if (currentView == null || (state = currentView.getState()) == null || (paywall = state.getPaywall()) == null) {
            return null;
        }
        return paywall.getIdentifier();
    }

    @Override // com.superwall.sdk.dependencies.StoreTransactionFactory
    public Object activeProductIds(Continuation<? super List<String>> continuation) {
        return CollectionsKt.toList(this.storeManager.getReceiptManager().getPurchases());
    }

    @Override // com.superwall.sdk.analytics.ClassifierDataFactory
    public long advertisedMemory() {
        return ClassifierDataFactory.DefaultImpls.advertisedMemory(this);
    }

    @Override // com.superwall.sdk.web.WebPaywallRedeemer.Factory
    public void closePaywallIfExists() {
        BuildersKt__Builders_commonKt.d(getIoScope(), null, null, new C27991(null), 3, null);
    }

    @Override // com.superwall.sdk.analytics.ClassifierDataFactory
    public List<String> codecs() {
        return ClassifierDataFactory.DefaultImpls.codecs(this);
    }

    @Override // com.superwall.sdk.analytics.ClassifierDataFactory
    public Context context() {
        return this.context;
    }

    @Override // com.superwall.sdk.paywall.request.PaywallRequestManagerDepFactory
    public CustomerInfo currentCustomerInfo() {
        return Superwall.Companion.getInstance().getCustomerInfo();
    }

    @Override // com.superwall.sdk.web.WebPaywallRedeemer.Factory
    public Set<Entitlement> currentPaywallEntitlements() {
        PaywallViewState state;
        Paywall paywall;
        List<String> productIds;
        PaywallView paywallView = Superwall.Companion.getInstance().getPaywallView();
        if (paywallView != null && (state = paywallView.getState()) != null && (paywall = state.getPaywall()) != null && (productIds = paywall.getProductIds()) != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = productIds.iterator();
            while (it.hasNext()) {
                CollectionsKt.addAll(arrayList, this.entitlements.byProductId$superwall_release((String) it.next()));
            }
            Set<Entitlement> set = CollectionsKt.toSet(arrayList);
            if (set != null) {
                return set;
            }
        }
        return SetsKt.emptySet();
    }

    @Override // com.superwall.sdk.web.WebPaywallRedeemer.Factory
    public long currentTimeMillis() {
        return WebPaywallRedeemer.Factory.DefaultImpls.currentTimeMillis(this);
    }

    @Override // com.superwall.sdk.dependencies.CustomerInfoFactory
    public StateFlow<CustomerInfo> customerInfoFlow() {
        return Superwall.Companion.getInstance().m1255getCustomerInfo();
    }

    @Override // com.superwall.sdk.dependencies.DelegateAdapterFactory
    public SuperwallDelegateAdapter delegate() {
        return this.delegateAdapter;
    }

    @Override // com.superwall.sdk.dependencies.EnrichmentFactory
    public Integer demandScore() {
        return getDeviceHelper().getDemandScore$superwall_release();
    }

    @Override // com.superwall.sdk.dependencies.EnrichmentFactory
    public String demandTier() {
        return getDeviceHelper().getDemandTier$superwall_release();
    }

    @Override // com.superwall.sdk.web.WebPaywallRedeemer.Factory
    public void didRedeemLink(RedemptionResult redemptionResult) {
        Intrinsics.checkNotNullParameter(redemptionResult, "redemptionResult");
        this.delegateAdapter.didRedeemLink(redemptionResult);
    }

    @Override // com.superwall.sdk.analytics.session.AppManagerDelegate
    public Object didUpdateAppSession(AppSession appSession, Continuation<? super Unit> continuation) {
        return Unit.f139807a;
    }

    @Override // com.superwall.sdk.dependencies.ExperimentalPropertiesFactory
    public Map<String, Object> experimentalProperties() {
        return this.storeManager.getReceiptManager().experimentalProperties();
    }

    @Override // com.superwall.sdk.web.WebPaywallRedeemer.Factory
    public Set<Entitlement> getActiveDeviceEntitlements() {
        return this.entitlements.getActiveDeviceEntitlements$superwall_release();
    }

    public final ActivityProvider getActivityProvider() {
        return this.activityProvider;
    }

    @Override // com.superwall.sdk.web.WebPaywallRedeemer.Factory
    public String getAliasId() {
        return getIdentityManager().getAliasId();
    }

    @Override // com.superwall.sdk.dependencies.ApiFactory
    public Api getApi() {
        return this.api;
    }

    public final String getApiKey() {
        return this.apiKey;
    }

    @Override // com.superwall.sdk.dependencies.ApiFactory
    public AppLifecycleObserver getAppLifecycleObserver() {
        return this.appLifecycleObserver;
    }

    public final AppSessionManager getAppSessionManager() {
        return this.appSessionManager;
    }

    public final Assignments getAssignments$superwall_release() {
        return this.assignments;
    }

    public final AttributionManager getAttributionManager$superwall_release() {
        return this.attributionManager;
    }

    @Override // com.superwall.sdk.dependencies.ApiFactory
    public ConfigManager getConfigManager() {
        ConfigManager configManager = this.configManager;
        if (configManager != null) {
            return configManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("configManager");
        return null;
    }

    public final Context getContext() {
        return this.context;
    }

    @Override // com.superwall.sdk.analytics.ClassifierDataFactory
    public CPUInfo.Data getCpuInfo() {
        return ClassifierDataFactory.DefaultImpls.getCpuInfo(this);
    }

    @Override // com.superwall.sdk.dependencies.AttributesFactory
    public Map<String, Object> getCurrentUserAttributes() {
        return getIdentityManager().getUserAttributes();
    }

    public final CustomCallbackRegistry getCustomCallbackRegistry$superwall_release() {
        return this.customCallbackRegistry;
    }

    public final CustomerInfoManager getCustomerInfoManager$superwall_release() {
        CustomerInfoManager customerInfoManager = this.customerInfoManager;
        if (customerInfoManager != null) {
            return customerInfoManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("customerInfoManager");
        return null;
    }

    public final DebugManager getDebugManager() {
        return this.debugManager;
    }

    public final DeepLinkRouter getDeepLinkRouter$superwall_release() {
        return this.deepLinkRouter;
    }

    public final SuperwallDelegateAdapter getDelegateAdapter() {
        return this.delegateAdapter;
    }

    @Override // com.superwall.sdk.dependencies.ApiFactory
    public DeviceHelper getDeviceHelper() {
        return this.deviceHelper;
    }

    @Override // com.superwall.sdk.web.WebPaywallRedeemer.Factory
    public DeviceVendorId getDeviceId() {
        return new DeviceVendorId(VendorId.m1285constructorimpl(getDeviceHelper().getVendorId()), null);
    }

    public final Entitlements getEntitlements() {
        return this.entitlements;
    }

    public final ErrorTracker getErrorTracker$superwall_release() {
        return this.errorTracker;
    }

    public final EventsQueue getEventsQueue() {
        return this.eventsQueue;
    }

    @Override // com.superwall.sdk.web.WebPaywallRedeemer.Factory
    public String getExternalAccountId() {
        return getIdentityManager().getExternalAccountId();
    }

    public final GetPaywallComponentsFactory getGetPaywallComponentsFactory$superwall_release() {
        return (GetPaywallComponentsFactory) this.getPaywallComponentsFactory$delegate.getValue();
    }

    public final GoogleBillingWrapper getGoogleBillingWrapper() {
        return this.googleBillingWrapper;
    }

    @Override // com.superwall.sdk.dependencies.ApiFactory
    public IdentityManager getIdentityManager() {
        return this.identityManager;
    }

    @Override // com.superwall.sdk.web.WebPaywallRedeemer.Factory
    public Map<String, Object> getIntegrationProps() {
        Map mapEmptyMap = (Map) getStorage().read(IntegrationAttributes.INSTANCE);
        if (mapEmptyMap == null) {
            mapEmptyMap = MapsKt.emptyMap();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(mapEmptyMap.size()));
        for (Map.Entry entry : mapEmptyMap.entrySet()) {
            linkedHashMap.put(((AttributionProvider) entry.getKey()).toString(), entry.getValue());
        }
        return linkedHashMap;
    }

    public final Network getNetwork() {
        return this.network;
    }

    @Override // com.superwall.sdk.analytics.ClassifierDataFactory
    public DeviceClassifier.Orientation getOrientation() {
        return ClassifierDataFactory.DefaultImpls.getOrientation(this);
    }

    @Override // com.superwall.sdk.web.WebPaywallRedeemer.Factory
    public PaywallInfo getPaywallInfo() {
        PaywallInfo info;
        PaywallView paywallView = Superwall.Companion.getInstance().getPaywallView();
        return (paywallView == null || (info = paywallView.getInfo()) == null) ? PaywallInfo.Companion.empty() : info;
    }

    public final PaywallManager getPaywallManager() {
        return this.paywallManager;
    }

    public final PaywallRequestManager getPaywallRequestManager() {
        return this.paywallRequestManager;
    }

    public final WebPaywallRedeemer getReedemer() {
        WebPaywallRedeemer webPaywallRedeemer = this.reedemer;
        if (webPaywallRedeemer != null) {
            return webPaywallRedeemer;
        }
        Intrinsics.throwUninitializedPropertyAccessException("reedemer");
        return null;
    }

    public final ReviewManager getReviewManager$superwall_release() {
        return this.reviewManager;
    }

    @Override // com.superwall.sdk.analytics.ClassifierDataFactory
    public int getScreenHeight() {
        return ClassifierDataFactory.DefaultImpls.getScreenHeight(this);
    }

    @Override // com.superwall.sdk.analytics.ClassifierDataFactory
    public double getScreenSize() {
        return ClassifierDataFactory.DefaultImpls.getScreenSize(this);
    }

    @Override // com.superwall.sdk.analytics.ClassifierDataFactory
    public int getScreenWidth() {
        return ClassifierDataFactory.DefaultImpls.getScreenWidth(this);
    }

    public final SessionEventsManager getSessionEventsManager() {
        return this.sessionEventsManager;
    }

    @Override // com.superwall.sdk.dependencies.ApiFactory
    public LocalStorage getStorage() {
        LocalStorage localStorage = this.storage;
        if (localStorage != null) {
            return localStorage;
        }
        Intrinsics.throwUninitializedPropertyAccessException("storage");
        return null;
    }

    public final StoreManager getStoreManager() {
        return this.storeManager;
    }

    public final TestMode getTestMode$superwall_release() {
        return this.testMode;
    }

    public final TestModeTransactionHandler getTestModeTransactionHandler$superwall_release() {
        return this.testModeTransactionHandler;
    }

    public final TransactionManager getTransactionManager() {
        return this.transactionManager;
    }

    @Override // com.superwall.sdk.web.WebPaywallRedeemer.Factory
    /* JADX INFO: renamed from: getUserId-P5Wmf0A, reason: not valid java name */
    public String mo1270getUserIdP5Wmf0A() {
        String appUserId = getIdentityManager().getAppUserId();
        if (appUserId != null) {
            return UserId.m1278constructorimpl(appUserId);
        }
        return null;
    }

    public final UserPermissions getUserPermissions$superwall_release() {
        return this.userPermissions;
    }

    @Override // com.superwall.sdk.dependencies.PresentationFactory
    public Object internallyGetPresentationResult(Trackable trackable, boolean z2, Continuation<? super Unit> continuation) {
        Object objInternallyGetPresentationResult = PublicGetPresentationResultKt.internallyGetPresentationResult(Superwall.Companion.getInstance(), trackable, z2, continuation);
        return objInternallyGetPresentationResult == IntrinsicsKt.f() ? objInternallyGetPresentationResult : Unit.f139807a;
    }

    @Override // com.superwall.sdk.web.WebPaywallRedeemer.Factory
    public void internallySetSubscriptionStatus(SubscriptionStatus status) {
        Intrinsics.checkNotNullParameter(status, "status");
        Superwall.Companion.getInstance().internallySetSubscriptionStatus$superwall_release(status);
    }

    @Override // com.superwall.sdk.dependencies.SuperwallScopeFactory
    public IOScope ioScope() {
        if (this._ioScope == null) {
            this._ioScope = new IOScope(null, 1, null);
        }
        IOScope iOScope = this._ioScope;
        Intrinsics.checkNotNull(iOScope);
        return iOScope;
    }

    @Override // com.superwall.sdk.web.WebPaywallRedeemer.Factory
    public boolean isPaymentSheetOpen() {
        return false;
    }

    @Override // com.superwall.sdk.web.WebPaywallRedeemer.Factory
    public Object isPaywallVisible(Continuation<? super Boolean> continuation) {
        return Boxing.a(Superwall.Companion.getInstance().isPaywallPresented());
    }

    @Override // com.superwall.sdk.analytics.ClassifierDataFactory
    public boolean isTabletMinWidth() {
        return ClassifierDataFactory.DefaultImpls.isTabletMinWidth(this);
    }

    @Override // com.superwall.sdk.dependencies.WebToAppFactory, com.superwall.sdk.web.WebPaywallRedeemer.Factory
    public boolean isWebToAppEnabled() {
        FeatureFlags featureFlags;
        Config config = getConfigManager().getConfig();
        if (config == null || (featureFlags = config.getFeatureFlags()) == null) {
            return false;
        }
        return featureFlags.getWeb2App();
    }

    @Override // com.superwall.sdk.network.JsonFactory
    public Json json() {
        return ApiFactory.DefaultImpls.json(this);
    }

    @Override // com.superwall.sdk.dependencies.SuperwallScopeFactory
    public MainScope mainScope() {
        if (this._mainScope == null) {
            this._mainScope = new MainScope(null, 1, null);
        }
        MainScope mainScope = this._mainScope;
        Intrinsics.checkNotNull(mainScope);
        return mainScope;
    }

    @Override // com.superwall.sdk.dependencies.CacheFactory
    public PaywallViewCache makeCache() {
        Context context = this.context;
        ViewStorageViewModel viewStorageViewModelMakeViewStore = makeViewStore();
        ActivityProvider activityProvider = this.activityProvider;
        Intrinsics.checkNotNull(activityProvider);
        return new PaywallViewCache(context, viewStorageViewModelMakeViewStore, activityProvider, getDeviceHelper(), getConfigManager().getOptions().getPaywalls().getLoadingColor());
    }

    @Override // com.superwall.sdk.dependencies.ComputedPropertyRequestsFactory
    public List<ComputedPropertyRequest> makeComputedPropertyRequests() {
        List<ComputedPropertyRequest> allComputedProperties;
        Config config = getConfigManager().getConfig();
        return (config == null || (allComputedProperties = config.getAllComputedProperties()) == null) ? CollectionsKt.emptyList() : allComputedProperties;
    }

    @Override // com.superwall.sdk.dependencies.ConfigAttributesFactory
    public InternalSuperwallEvent.ConfigAttributes makeConfigAttributes() {
        return new InternalSuperwallEvent.ConfigAttributes(getConfigManager().getOptions(), makeHasExternalPurchaseController(), (this.delegateAdapter.getKotlinDelegate() == null && this.delegateAdapter.getJavaDelegate() == null) ? false : true);
    }

    @Override // com.superwall.sdk.dependencies.ViewFactory
    public DebugView makeDebugView(String str) {
        DebugView debugView = new DebugView(this.context, this.storeManager, this.network, this.paywallRequestManager, this.paywallManager, this.debugManager, this);
        debugView.setPaywallDatabaseId$superwall_release(str);
        return debugView;
    }

    @Override // com.superwall.sdk.dependencies.DeviceInfoFactory, com.superwall.sdk.dependencies.DeviceHelperFactory
    public DeviceInfo makeDeviceInfo() {
        return new DeviceInfo(getDeviceHelper().getAppInstalledAtString(), getDeviceHelper().getLocale());
    }

    @Override // com.superwall.sdk.dependencies.FeatureFlagsFactory
    public FeatureFlags makeFeatureFlags() {
        Config config = getConfigManager().getConfig();
        if (config != null) {
            return config.getFeatureFlags();
        }
        return null;
    }

    @Override // com.superwall.sdk.dependencies.HasExternalPurchaseControllerFactory
    public boolean makeHasExternalPurchaseController() {
        return this.storeManager.getPurchaseController().getHasExternalPurchaseController();
    }

    @Override // com.superwall.sdk.dependencies.HasInternalPurchaseControllerFactory
    public boolean makeHasInternalPurchaseController() {
        return this.storeManager.getPurchaseController().getHasInternalPurchaseController();
    }

    @Override // com.superwall.sdk.dependencies.ApiFactory
    public Object makeHeaders(boolean z2, String str, Continuation<? super Map<String, String>> continuation) {
        String gitSha;
        String buildTime;
        String buildId;
        LocalStorage storage = getStorage();
        Pair pairA = TuplesKt.a("Authorization", "Bearer " + (z2 ? storage.getDebugKey() : storage.getApiKey()));
        Pair pairA2 = TuplesKt.a("X-Platform", "Android");
        Pair pairA3 = TuplesKt.a("X-Platform-Environment", "SDK");
        Pair pairA4 = TuplesKt.a("X-Platform-Wrapper", getDeviceHelper().getPlatformWrapper());
        String appUserId = getIdentityManager().getAppUserId();
        if (appUserId == null) {
            appUserId = "";
        }
        Pair pairA5 = TuplesKt.a("X-App-User-ID", appUserId);
        Pair pairA6 = TuplesKt.a("X-Alias-ID", getIdentityManager().getAliasId());
        Pair pairA7 = TuplesKt.a("X-URL-Scheme", getDeviceHelper().getUrlScheme());
        Pair pairA8 = TuplesKt.a("X-Vendor-ID", getDeviceHelper().getVendorId());
        Pair pairA9 = TuplesKt.a("X-App-Version", getDeviceHelper().getAppVersion());
        Pair pairA10 = TuplesKt.a("X-OS-Version", getDeviceHelper().getOsVersion());
        Pair pairA11 = TuplesKt.a("X-Device-Model", getDeviceHelper().getModel());
        Pair pairA12 = TuplesKt.a("X-Device-Locale", getDeviceHelper().getLocale());
        Pair pairA13 = TuplesKt.a("X-Device-Language-Code", getDeviceHelper().getLanguageCode());
        Pair pairA14 = TuplesKt.a("X-Device-Currency-Code", getDeviceHelper().getCurrencyCode());
        Pair pairA15 = TuplesKt.a("X-Device-Currency-Symbol", getDeviceHelper().getCurrencySymbol());
        Pair pairA16 = TuplesKt.a("X-Device-Timezone-Offset", getDeviceHelper().getSecondsFromGMT());
        Pair pairA17 = TuplesKt.a("X-App-Install-Date", getDeviceHelper().getAppInstalledAtString());
        Pair pairA18 = TuplesKt.a("X-Radio-Type", getDeviceHelper().getRadioType());
        Pair pairA19 = TuplesKt.a("X-Device-Interface-Style", getDeviceHelper().getInterfaceStyle());
        Pair pairA20 = TuplesKt.a("X-SDK-Version", getDeviceHelper().getSdkVersion());
        if (getDeviceHelper().getGitSha() != null) {
            gitSha = getDeviceHelper().getGitSha();
            Intrinsics.checkNotNull(gitSha);
        } else {
            gitSha = "";
        }
        Pair pairA21 = TuplesKt.a("X-Git-Sha", gitSha);
        if (getDeviceHelper().getBuildTime() != null) {
            buildTime = getDeviceHelper().getBuildTime();
            Intrinsics.checkNotNull(buildTime);
        } else {
            buildTime = "";
        }
        Pair pairA22 = TuplesKt.a("X-Build-Time", buildTime);
        Pair pairA23 = TuplesKt.a("X-Bundle-ID", getDeviceHelper().getBundleId());
        Pair pairA24 = TuplesKt.a("X-Low-Power-Mode", getDeviceHelper().isLowPowerModeEnabled().toString());
        Pair pairA25 = TuplesKt.a("X-Is-Sandbox", String.valueOf(getDeviceHelper().isSandbox()));
        Pair pairA26 = TuplesKt.a("X-Entitlement-Status", ((SubscriptionStatus) Superwall.Companion.getInstance().getEntitlements().getStatus().getValue()).toString());
        Pair pairA27 = TuplesKt.a("Content-Type", "application/json");
        Pair pairA28 = TuplesKt.a("X-Current-Time", DateUtilsKt.dateFormat(DateUtils.INSTANCE.getISO_MILLIS()).format(new Date()));
        Config config = getConfigManager().getConfig();
        return MapsKt.mapOf(pairA, pairA2, pairA3, pairA4, pairA5, pairA6, pairA7, pairA8, pairA9, pairA10, pairA11, pairA12, pairA13, pairA14, pairA15, pairA16, pairA17, pairA18, pairA19, pairA20, pairA21, pairA22, pairA23, pairA24, pairA25, pairA26, pairA27, pairA28, TuplesKt.a("X-Static-Config-Build-Id", (config == null || (buildId = config.getBuildId()) == null) ? "" : buildId));
    }

    @Override // com.superwall.sdk.dependencies.IdentityInfoFactory
    public Object makeIdentityInfo(Continuation<? super IdentityInfo> continuation) {
        return new IdentityInfo(getIdentityManager().getAliasId(), getIdentityManager().getAppUserId());
    }

    @Override // com.superwall.sdk.dependencies.IdentityManagerFactory
    public Object makeIdentityManager(Continuation<? super IdentityManager> continuation) {
        return getIdentityManager();
    }

    @Override // com.superwall.sdk.dependencies.DeviceHelperFactory
    public boolean makeIsSandbox() {
        return this.testMode.isTestMode() || getDeviceHelper().isSandbox();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.superwall.sdk.dependencies.VariablesFactory
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object makeJsonVariables(java.util.List<com.superwall.sdk.models.product.ProductVariable> r5, java.util.List<com.superwall.sdk.models.config.ComputedPropertyRequest> r6, com.superwall.sdk.models.events.EventData r7, kotlin.coroutines.Continuation<? super com.superwall.sdk.paywall.view.webview.templating.models.JsonVariables> r8) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r8 instanceof com.superwall.sdk.dependencies.DependencyContainer.C28001
            if (r0 == 0) goto L13
            r0 = r8
            com.superwall.sdk.dependencies.DependencyContainer$makeJsonVariables$1 r0 = (com.superwall.sdk.dependencies.DependencyContainer.C28001) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.superwall.sdk.dependencies.DependencyContainer$makeJsonVariables$1 r0 = new com.superwall.sdk.dependencies.DependencyContainer$makeJsonVariables$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3e
            if (r2 != r3) goto L36
            java.lang.Object r5 = r0.L$2
            r7 = r5
            com.superwall.sdk.models.events.EventData r7 = (com.superwall.sdk.models.events.EventData) r7
            java.lang.Object r5 = r0.L$1
            java.util.List r5 = (java.util.List) r5
            java.lang.Object r6 = r0.L$0
            com.superwall.sdk.dependencies.DependencyContainer r6 = (com.superwall.sdk.dependencies.DependencyContainer) r6
            kotlin.ResultKt.b(r8)
            goto L55
        L36:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3e:
            kotlin.ResultKt.b(r8)
            com.superwall.sdk.network.device.DeviceHelper r8 = r4.getDeviceHelper()
            r0.L$0 = r4
            r0.L$1 = r5
            r0.L$2 = r7
            r0.label = r3
            java.lang.Object r8 = r8.getDeviceAttributes(r7, r6, r0)
            if (r8 != r1) goto L54
            return r1
        L54:
            r6 = r4
        L55:
            java.util.Map r8 = (java.util.Map) r8
            com.superwall.sdk.paywall.view.webview.templating.models.Variables r0 = new com.superwall.sdk.paywall.view.webview.templating.models.Variables
            if (r5 != 0) goto L5f
            java.util.List r5 = kotlin.collections.CollectionsKt.emptyList()
        L5f:
            if (r7 == 0) goto L67
            java.util.Map r7 = r7.getParameters()
            if (r7 != 0) goto L6b
        L67:
            java.util.Map r7 = kotlin.collections.MapsKt.emptyMap()
        L6b:
            com.superwall.sdk.identity.IdentityManager r6 = r6.getIdentityManager()
            java.util.Map r6 = r6.getUserAttributes()
            r0.<init>(r5, r7, r6, r8)
            com.superwall.sdk.paywall.view.webview.templating.models.JsonVariables r5 = r0.templated()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.dependencies.DependencyContainer.makeJsonVariables(java.util.List, java.util.List, com.superwall.sdk.models.events.EventData, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.superwall.sdk.dependencies.LocaleIdentifierFactory
    public String makeLocaleIdentifier() {
        SuperwallOptions options = getConfigManager().getOptions();
        if (options != null) {
            return options.getLocaleIdentifier();
        }
        return null;
    }

    @Override // com.superwall.sdk.dependencies.RequestFactory
    public PaywallRequest makePaywallRequest(EventData eventData, ResponseIdentifiers responseIdentifiers, PaywallRequest.Overrides overrides, boolean z2, String str) {
        Intrinsics.checkNotNullParameter(responseIdentifiers, "responseIdentifiers");
        if (overrides == null) {
            overrides = new PaywallRequest.Overrides(null, null);
        }
        return new PaywallRequest(eventData, responseIdentifiers, overrides, z2, str, 6);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    @Override // com.superwall.sdk.dependencies.ViewFactory
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object makePaywallView(com.superwall.sdk.models.paywall.Paywall r44, com.superwall.sdk.paywall.manager.PaywallViewCache r45, com.superwall.sdk.paywall.view.delegate.PaywallViewDelegateAdapter r46, kotlin.coroutines.Continuation<? super com.superwall.sdk.paywall.view.PaywallView> r47) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 239
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.dependencies.DependencyContainer.makePaywallView(com.superwall.sdk.models.paywall.Paywall, com.superwall.sdk.paywall.manager.PaywallViewCache, com.superwall.sdk.paywall.view.delegate.PaywallViewDelegateAdapter, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.superwall.sdk.dependencies.RequestFactory
    public PresentationRequest makePresentationRequest(PresentationInfo presentationInfo, PaywallOverrides paywallOverrides, Activity activity, Boolean bool, StateFlow<? extends SubscriptionStatus> stateFlow, boolean z2, PresentationRequestType type) {
        Intrinsics.checkNotNullParameter(presentationInfo, "presentationInfo");
        Intrinsics.checkNotNullParameter(type, "type");
        WeakReference weakReference = new WeakReference(activity);
        boolean zBooleanValue = bool != null ? bool.booleanValue() : this.debugManager.isDebuggerLaunched();
        if (stateFlow == null) {
            stateFlow = Superwall.Companion.getInstance().getEntitlements().getStatus();
        }
        return new PresentationRequest(presentationInfo, weakReference, paywallOverrides, new PresentationRequest.Flags(zBooleanValue, stateFlow, z2, type));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.superwall.sdk.dependencies.RuleAttributesFactory
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object makeRuleAttributes(com.superwall.sdk.models.events.EventData r7, java.util.List<com.superwall.sdk.models.config.ComputedPropertyRequest> r8, kotlin.coroutines.Continuation<? super java.util.Map<java.lang.String, ? extends java.lang.Object>> r9) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r9 instanceof com.superwall.sdk.dependencies.DependencyContainer.C28021
            if (r0 == 0) goto L13
            r0 = r9
            com.superwall.sdk.dependencies.DependencyContainer$makeRuleAttributes$1 r0 = (com.superwall.sdk.dependencies.DependencyContainer.C28021) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.superwall.sdk.dependencies.DependencyContainer$makeRuleAttributes$1 r0 = new com.superwall.sdk.dependencies.DependencyContainer$makeRuleAttributes$1
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r7 = r0.L$1
            java.util.Map r7 = (java.util.Map) r7
            java.lang.Object r8 = r0.L$0
            com.superwall.sdk.models.events.EventData r8 = (com.superwall.sdk.models.events.EventData) r8
            kotlin.ResultKt.b(r9)
            goto L6e
        L31:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L39:
            kotlin.ResultKt.b(r9)
            com.superwall.sdk.identity.IdentityManager r9 = r6.getIdentityManager()
            java.util.Map r9 = r9.getUserAttributes()
            java.util.Map r9 = kotlin.collections.MapsKt.toMutableMap(r9)
            com.superwall.sdk.identity.IdentityManager r2 = r6.getIdentityManager()
            boolean r2 = r2.isLoggedIn()
            java.lang.Boolean r2 = kotlin.coroutines.jvm.internal.Boxing.a(r2)
            java.lang.String r4 = "isLoggedIn"
            r9.put(r4, r2)
            com.superwall.sdk.network.device.DeviceHelper r2 = r6.getDeviceHelper()
            r0.L$0 = r7
            r0.L$1 = r9
            r0.label = r3
            java.lang.Object r8 = r2.getDeviceAttributes(r7, r8, r0)
            if (r8 != r1) goto L6a
            return r1
        L6a:
            r5 = r8
            r8 = r7
            r7 = r9
            r9 = r5
        L6e:
            java.util.Map r9 = (java.util.Map) r9
            java.lang.String r0 = "user"
            kotlin.Pair r7 = kotlin.TuplesKt.a(r0, r7)
            java.lang.String r0 = "device"
            kotlin.Pair r9 = kotlin.TuplesKt.a(r0, r9)
            if (r8 == 0) goto L84
            java.util.Map r8 = r8.getParameters()
            if (r8 != 0) goto L86
        L84:
            java.lang.String r8 = ""
        L86:
            java.lang.String r0 = "params"
            kotlin.Pair r8 = kotlin.TuplesKt.a(r0, r8)
            kotlin.Pair[] r7 = new kotlin.Pair[]{r7, r9, r8}
            java.util.Map r7 = kotlin.collections.MapsKt.mapOf(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.dependencies.DependencyContainer.makeRuleAttributes(com.superwall.sdk.models.events.EventData, java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.superwall.sdk.dependencies.DeviceHelperFactory
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object makeSessionDeviceAttributes(kotlin.coroutines.Continuation<? super java.util.HashMap<java.lang.String, java.lang.Object>> r5) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.superwall.sdk.dependencies.DependencyContainer.C28031
            if (r0 == 0) goto L13
            r0 = r5
            com.superwall.sdk.dependencies.DependencyContainer$makeSessionDeviceAttributes$1 r0 = (com.superwall.sdk.dependencies.DependencyContainer.C28031) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.superwall.sdk.dependencies.DependencyContainer$makeSessionDeviceAttributes$1 r0 = new com.superwall.sdk.dependencies.DependencyContainer$makeSessionDeviceAttributes$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.b(r5)
            goto L41
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L31:
            kotlin.ResultKt.b(r5)
            com.superwall.sdk.network.device.DeviceHelper r5 = r4.getDeviceHelper()
            r0.label = r3
            java.lang.Object r5 = r5.getTemplateDevice(r0)
            if (r5 != r1) goto L41
            return r1
        L41:
            java.util.Map r5 = (java.util.Map) r5
            java.util.Map r5 = kotlin.collections.MapsKt.toMutableMap(r5)
            java.lang.String r0 = "utcDate"
            r5.remove(r0)
            java.lang.String r0 = "localDate"
            r5.remove(r0)
            java.lang.String r0 = "localTime"
            r5.remove(r0)
            java.lang.String r0 = "utcTime"
            r5.remove(r0)
            java.lang.String r0 = "utcDateTime"
            r5.remove(r0)
            java.lang.String r0 = "localDateTime"
            r5.remove(r0)
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>(r5)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.dependencies.DependencyContainer.makeSessionDeviceAttributes(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.superwall.sdk.dependencies.ConfigManagerFactory
    public Paywall makeStaticPaywall(String str, boolean z2) {
        if (z2) {
            return null;
        }
        return ConfigLogic.INSTANCE.getStaticPaywall(str, getConfigManager().getConfig(), makeDeviceInfo().getLocale());
    }

    @Override // com.superwall.sdk.dependencies.StoreTransactionFactory
    public Object makeStoreTransaction(Purchase purchase, Continuation<? super StoreTransaction> continuation) {
        String requestId;
        GoogleBillingPurchaseTransaction googleBillingPurchaseTransaction = new GoogleBillingPurchaseTransaction(purchase);
        Config config = getConfigManager().getConfig();
        if (config == null || (requestId = config.getRequestId()) == null) {
            requestId = "";
        }
        return new StoreTransaction(googleBillingPurchaseTransaction, requestId, this.appSessionManager.getAppSession().getId());
    }

    @Override // com.superwall.sdk.dependencies.OptionsFactory
    public SuperwallOptions makeSuperwallOptions() {
        return getConfigManager().getOptions();
    }

    @Override // com.superwall.sdk.dependencies.TransactionVerifierFactory
    public GoogleBillingWrapper makeTransactionVerifier() {
        return this.googleBillingWrapper;
    }

    @Override // com.superwall.sdk.dependencies.TriggerFactory
    public Object makeTriggers(Continuation<? super Set<String>> continuation) {
        return getConfigManager().getTriggersByEventName().keySet();
    }

    @Override // com.superwall.sdk.dependencies.UserAttributesEventFactory
    public InternalSuperwallEvent.Attributes makeUserAttributesEvent() {
        return new InternalSuperwallEvent.Attributes(getDeviceHelper().getAppInstalledAtString(), new HashMap(getIdentityManager().getUserAttributes()));
    }

    @Override // com.superwall.sdk.web.WebPaywallRedeemer.Factory
    public long maxAge() {
        WebToAppConfig webToAppConfig;
        Config config = getConfigManager().getConfig();
        if (config == null || (webToAppConfig = config.getWebToAppConfig()) == null) {
            return 86400000L;
        }
        return webToAppConfig.getEntitlementsMaxAgeMs();
    }

    @Override // com.superwall.sdk.paywall.presentation.rule_logic.javascript.RuleEvaluator.Factory
    public Object provideRuleEvaluator(Context context, Continuation<? super ExpressionEvaluating> continuation) {
        return getEvaluator();
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x00e7, code lost:
    
        r11 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x00b8 -> B:31:0x00b9). Please report as a decompilation issue!!! */
    @Override // com.superwall.sdk.web.WebPaywallRedeemer.Factory
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object receipts(kotlin.coroutines.Continuation<? super java.util.List<com.superwall.sdk.models.entitlements.TransactionReceipt>> r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 245
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.dependencies.DependencyContainer.receipts(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.superwall.sdk.dependencies.WebToAppFactory
    public String restoreUrl() {
        Config config;
        WebToAppConfig webToAppConfig;
        String restoreAccesUrl;
        ConfigManager configManager = getConfigManager();
        return (configManager == null || (config = configManager.getConfig()) == null || (webToAppConfig = config.getWebToAppConfig()) == null || (restoreAccesUrl = webToAppConfig.getRestoreAccesUrl()) == null) ? "" : restoreAccesUrl;
    }

    @Override // com.superwall.sdk.web.WebPaywallRedeemer.Factory
    public Object scheduleTrialNotifications(List<LocalNotification> list, Continuation<? super Unit> continuation) {
        Object objG = BuildersKt.g(Dispatchers.c().w0(), new C28052(list, null), continuation);
        return objG == IntrinsicsKt.f() ? objG : Unit.f139807a;
    }

    public final void setActivityProvider(ActivityProvider activityProvider) {
        this.activityProvider = activityProvider;
    }

    @Override // com.superwall.sdk.dependencies.ApiFactory
    public void setApi(Api api) {
        Intrinsics.checkNotNullParameter(api, "<set-?>");
        this.api = api;
    }

    @Override // com.superwall.sdk.dependencies.ApiFactory
    public void setAppLifecycleObserver(AppLifecycleObserver appLifecycleObserver) {
        Intrinsics.checkNotNullParameter(appLifecycleObserver, "<set-?>");
        this.appLifecycleObserver = appLifecycleObserver;
    }

    public final void setAppSessionManager(AppSessionManager appSessionManager) {
        Intrinsics.checkNotNullParameter(appSessionManager, "<set-?>");
        this.appSessionManager = appSessionManager;
    }

    @Override // com.superwall.sdk.dependencies.ApiFactory
    public void setConfigManager(ConfigManager configManager) {
        Intrinsics.checkNotNullParameter(configManager, "<set-?>");
        this.configManager = configManager;
    }

    public final void setCustomerInfoManager$superwall_release(CustomerInfoManager customerInfoManager) {
        Intrinsics.checkNotNullParameter(customerInfoManager, "<set-?>");
        this.customerInfoManager = customerInfoManager;
    }

    public final void setDebugManager(DebugManager debugManager) {
        Intrinsics.checkNotNullParameter(debugManager, "<set-?>");
        this.debugManager = debugManager;
    }

    public final void setDelegateAdapter(SuperwallDelegateAdapter superwallDelegateAdapter) {
        Intrinsics.checkNotNullParameter(superwallDelegateAdapter, "<set-?>");
        this.delegateAdapter = superwallDelegateAdapter;
    }

    @Override // com.superwall.sdk.dependencies.ApiFactory
    public void setDeviceHelper(DeviceHelper deviceHelper) {
        Intrinsics.checkNotNullParameter(deviceHelper, "<set-?>");
        this.deviceHelper = deviceHelper;
    }

    public final void setEntitlements(Entitlements entitlements) {
        Intrinsics.checkNotNullParameter(entitlements, "<set-?>");
        this.entitlements = entitlements;
    }

    public final void setEventsQueue(EventsQueue eventsQueue) {
        Intrinsics.checkNotNullParameter(eventsQueue, "<set-?>");
        this.eventsQueue = eventsQueue;
    }

    @Override // com.superwall.sdk.dependencies.ApiFactory
    public void setIdentityManager(IdentityManager identityManager) {
        Intrinsics.checkNotNullParameter(identityManager, "<set-?>");
        this.identityManager = identityManager;
    }

    public final void setNetwork(Network network) {
        Intrinsics.checkNotNullParameter(network, "<set-?>");
        this.network = network;
    }

    public final void setPaywallManager(PaywallManager paywallManager) {
        Intrinsics.checkNotNullParameter(paywallManager, "<set-?>");
        this.paywallManager = paywallManager;
    }

    public final void setPaywallRequestManager(PaywallRequestManager paywallRequestManager) {
        Intrinsics.checkNotNullParameter(paywallRequestManager, "<set-?>");
        this.paywallRequestManager = paywallRequestManager;
    }

    public final void setReedemer(WebPaywallRedeemer webPaywallRedeemer) {
        Intrinsics.checkNotNullParameter(webPaywallRedeemer, "<set-?>");
        this.reedemer = webPaywallRedeemer;
    }

    public final void setSessionEventsManager(SessionEventsManager sessionEventsManager) {
        Intrinsics.checkNotNullParameter(sessionEventsManager, "<set-?>");
        this.sessionEventsManager = sessionEventsManager;
    }

    @Override // com.superwall.sdk.dependencies.ApiFactory
    public void setStorage(LocalStorage localStorage) {
        Intrinsics.checkNotNullParameter(localStorage, "<set-?>");
        this.storage = localStorage;
    }

    public final void setStoreManager(StoreManager storeManager) {
        Intrinsics.checkNotNullParameter(storeManager, "<set-?>");
        this.storeManager = storeManager;
    }

    @Override // com.superwall.sdk.dependencies.PresentationFactory
    public Object storePresentationObject(PresentationRequest presentationRequest, MutableSharedFlow<PaywallState> mutableSharedFlow, Continuation<? super Unit> continuation) {
        Object objStorePresentationObjects = StorePresentationObjectsKt.storePresentationObjects(Superwall.Companion.getInstance(), presentationRequest, mutableSharedFlow, continuation);
        return objStorePresentationObjects == IntrinsicsKt.f() ? objStorePresentationObjects : Unit.f139807a;
    }

    @Override // com.superwall.sdk.dependencies.StorefrontCountryFactory
    public String storefrontCountryCode() {
        return this.storeManager.getStorefrontCountryCode();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.superwall.sdk.dependencies.ApiFactory, com.superwall.sdk.web.WebPaywallRedeemer.Factory
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object track(com.superwall.sdk.analytics.internal.trackable.Trackable r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.superwall.sdk.dependencies.DependencyContainer.C28092
            if (r0 == 0) goto L13
            r0 = r6
            com.superwall.sdk.dependencies.DependencyContainer$track$2 r0 = (com.superwall.sdk.dependencies.DependencyContainer.C28092) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.superwall.sdk.dependencies.DependencyContainer$track$2 r0 = new com.superwall.sdk.dependencies.DependencyContainer$track$2
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
            goto L48
        L2e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L36:
            kotlin.ResultKt.b(r6)
            com.superwall.sdk.Superwall$Companion r6 = com.superwall.sdk.Superwall.Companion
            com.superwall.sdk.Superwall r6 = r6.getInstance()
            r0.label = r3
            java.lang.Object r5 = com.superwall.sdk.analytics.internal.TrackingKt.track(r6, r5, r0)
            if (r5 != r1) goto L48
            return r1
        L48:
            kotlin.Unit r5 = kotlin.Unit.f139807a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.dependencies.DependencyContainer.track(com.superwall.sdk.analytics.internal.trackable.Trackable, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.superwall.sdk.dependencies.TrackingFactory
    /* JADX INFO: renamed from: track-gIAlu-s, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object mo1271trackgIAlus(com.superwall.sdk.analytics.internal.trackable.TrackableSuperwallEvent r5, kotlin.coroutines.Continuation<? super kotlin.Result<com.superwall.sdk.analytics.internal.TrackingResult>> r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.superwall.sdk.dependencies.DependencyContainer.C28081
            if (r0 == 0) goto L13
            r0 = r6
            com.superwall.sdk.dependencies.DependencyContainer$track$1 r0 = (com.superwall.sdk.dependencies.DependencyContainer.C28081) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.superwall.sdk.dependencies.DependencyContainer$track$1 r0 = new com.superwall.sdk.dependencies.DependencyContainer$track$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            kotlin.ResultKt.b(r6)
            kotlin.Result r6 = (kotlin.Result) r6
            java.lang.Object r5 = r6.j()
            return r5
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L37:
            kotlin.ResultKt.b(r6)
            com.superwall.sdk.Superwall$Companion r6 = com.superwall.sdk.Superwall.Companion
            com.superwall.sdk.Superwall r6 = r6.getInstance()
            r0.label = r3
            java.lang.Object r5 = com.superwall.sdk.analytics.internal.TrackingKt.track(r6, r5, r0)
            if (r5 != r1) goto L49
            return r1
        L49:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.dependencies.DependencyContainer.mo1271trackgIAlus(com.superwall.sdk.analytics.internal.trackable.TrackableSuperwallEvent, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.superwall.sdk.web.WebPaywallRedeemer.Factory
    public void trackRestorationFailed(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        trackRestorationFailure(message);
    }

    @Override // com.superwall.sdk.web.WebPaywallRedeemer.Factory
    public Object triggerRestoreInPaywall(Continuation<? super Unit> continuation) {
        showWebRestoreSuccesful();
        return Unit.f139807a;
    }

    @Override // com.superwall.sdk.dependencies.PresentationFactory
    public void updatePaywallInfo(PaywallInfo paywallInfo) {
        Intrinsics.checkNotNullParameter(paywallInfo, "paywallInfo");
        Superwall.Companion.getInstance().getPresentationItems$superwall_release().setPaywallInfo(paywallInfo);
    }

    @Override // com.superwall.sdk.web.WebPaywallRedeemer.Factory
    public void willRedeemLink() {
        this.delegateAdapter.willRedeemLink();
    }

    @Override // com.superwall.sdk.dependencies.ViewStoreFactory
    public ViewStorageViewModel makeViewStore() {
        return (ViewStorageViewModel) this.vmProvider.a(ViewStorageViewModel.class);
    }

    @Override // com.superwall.sdk.dependencies.StoreTransactionFactory
    public Object makeStoreTransaction(String str, String str2, Date date, Continuation<? super StoreTransaction> continuation) {
        String requestId;
        Config config = getConfigManager().getConfig();
        if (config == null || (requestId = config.getRequestId()) == null) {
            requestId = "";
        }
        return new StoreTransaction(str, str2, date, requestId, this.appSessionManager.getAppSession().getId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SuperwallOptions _init_$lambda$24(SuperwallOptions superwallOptions) {
        return superwallOptions;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CurrentActivityTracker _init_$lambda$4(CurrentActivityTracker currentActivityTracker) {
        return currentActivityTracker;
    }

    public /* synthetic */ DependencyContainer(Context context, PurchaseController purchaseController, SuperwallOptions superwallOptions, ActivityProvider activityProvider, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : purchaseController, superwallOptions, activityProvider, str);
    }
}
