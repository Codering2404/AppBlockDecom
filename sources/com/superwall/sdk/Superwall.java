package com.superwall.sdk;

import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.net.Uri;
import androidx.work.WorkManager;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.ProductDetails;
import com.android.billingclient.api.Purchase;
import com.sun.jna.Function;
import com.superwall.sdk.Superwall;
import com.superwall.sdk.analytics.superwall.SuperwallEventInfo;
import com.superwall.sdk.config.ConfigManager;
import com.superwall.sdk.config.models.ConfigState;
import com.superwall.sdk.config.models.ConfigurationStatus;
import com.superwall.sdk.config.options.EventTrackingBehavior;
import com.superwall.sdk.config.options.SuperwallOptions;
import com.superwall.sdk.deeplinks.DeepLinkRouter;
import com.superwall.sdk.delegate.PurchaseResult;
import com.superwall.sdk.delegate.RestorationResult;
import com.superwall.sdk.delegate.SuperwallDelegate;
import com.superwall.sdk.delegate.SuperwallDelegateJava;
import com.superwall.sdk.delegate.subscription_controller.PurchaseController;
import com.superwall.sdk.dependencies.DependencyContainer;
import com.superwall.sdk.logger.LogLevel;
import com.superwall.sdk.logger.LogScope;
import com.superwall.sdk.logger.Logger;
import com.superwall.sdk.misc.ActivityProvider;
import com.superwall.sdk.misc.Either;
import com.superwall.sdk.misc.IOScope;
import com.superwall.sdk.misc.MainScope;
import com.superwall.sdk.misc.ScopesKt;
import com.superwall.sdk.misc.SerialTaskManager;
import com.superwall.sdk.models.assignment.ConfirmedAssignment;
import com.superwall.sdk.models.attribution.AttributionProvider;
import com.superwall.sdk.models.customer.CustomerInfo;
import com.superwall.sdk.models.entitlements.Entitlement;
import com.superwall.sdk.models.entitlements.SubscriptionStatus;
import com.superwall.sdk.models.internal.RedemptionOwnershipType;
import com.superwall.sdk.models.internal.VendorId;
import com.superwall.sdk.models.triggers.Experiment;
import com.superwall.sdk.network.device.InterfaceStyle;
import com.superwall.sdk.paywall.presentation.PaywallInfo;
import com.superwall.sdk.paywall.presentation.PresentationItems;
import com.superwall.sdk.paywall.view.PaywallView;
import com.superwall.sdk.paywall.view.PaywallViewState;
import com.superwall.sdk.paywall.view.SuperwallPaywallActivity;
import com.superwall.sdk.paywall.view.delegate.PaywallViewEventCallback;
import com.superwall.sdk.paywall.view.webview.PaywallResource;
import com.superwall.sdk.paywall.view.webview.messaging.PaywallWebEvent;
import com.superwall.sdk.storage.LatestCustomerInfo;
import com.superwall.sdk.storage.StoredSubscriptionStatus;
import com.superwall.sdk.store.Entitlements;
import com.superwall.sdk.store.PurchasingObserverState;
import com.superwall.sdk.store.abstractions.product.StoreProduct;
import com.superwall.sdk.store.transactions.TransactionManager;
import com.superwall.sdk.utilities.ErrorTrackingKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

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
public final class Superwall implements PaywallViewEventCallback {
    public static final Companion Companion = new Companion(null);
    private static final MutableStateFlow<Boolean> _hasInitialized;
    private static Superwall _instance;
    private static final Flow<Boolean> hasInitialized;
    private static boolean initialized;
    private static ActivityProvider retainedActivityProvider;
    private final MutableStateFlow<CustomerInfo> _customerInfo;
    private volatile DependencyContainer _dependencyContainer;
    private SuperwallOptions _options;
    private final MutableSharedFlow<SuperwallEventInfo> _placements;
    private ActivityProvider activityProvider;
    private String apiKey;
    private final Function1<Result<Unit>, Unit> completion;
    private ComponentCallbacks2 configurationChangeListener;
    private Context context;
    private final Lazy entitlements$delegate;
    private Map<String, ? extends PaywallResource> localResources;
    private final SharedFlow<SuperwallEventInfo> placements;
    private final PresentationItems presentationItems;
    private PurchaseController purchaseController;
    private Job purchaseTask;
    private final SerialTaskManager serialTaskManager;
    private final Lazy subscriptionStatus$delegate;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void configure$default(Companion companion, Application application, String str, PurchaseController purchaseController, SuperwallOptions superwallOptions, ActivityProvider activityProvider, Function1 function1, int i3, Object obj) {
            if ((i3 & 4) != 0) {
                purchaseController = null;
            }
            if ((i3 & 8) != 0) {
                superwallOptions = null;
            }
            if ((i3 & 16) != 0) {
                activityProvider = null;
            }
            if ((i3 & 32) != 0) {
                function1 = null;
            }
            companion.configure(application, str, purchaseController, superwallOptions, activityProvider, function1);
        }

        @JvmStatic
        public final void configure(Application applicationContext, String apiKey) {
            Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
            Intrinsics.checkNotNullParameter(apiKey, "apiKey");
            configure$default(this, applicationContext, apiKey, null, null, null, null, 60, null);
        }

        public final Flow<Boolean> getHasInitialized() {
            return Superwall.hasInitialized;
        }

        public final boolean getInitialized() {
            return Superwall.initialized;
        }

        public final Superwall getInstance() {
            Superwall superwall = Superwall._instance;
            if (superwall != null) {
                return superwall;
            }
            throw new IllegalStateException("Superwall has not been initialized or configured.");
        }

        /* JADX INFO: renamed from: handleDeepLink-IoAF18A, reason: not valid java name */
        public final Object m1257handleDeepLinkIoAF18A(Uri uri) {
            Intrinsics.checkNotNullParameter(uri, "uri");
            return DeepLinkRouter.Companion.m1269handleDeepLinkIoAF18A(uri);
        }

        public final void setInitialized(boolean z2) {
            Superwall.initialized = z2;
        }

        @JvmStatic
        public final void teardown() {
            Object value;
            DependencyContainer dependencyContainer$superwall_release;
            synchronized (this) {
                try {
                    Superwall superwall = Superwall._instance;
                    Superwall.retainedActivityProvider = (superwall == null || (dependencyContainer$superwall_release = superwall.getDependencyContainer$superwall_release()) == null) ? null : dependencyContainer$superwall_release.getActivityProvider();
                    Superwall superwall2 = Superwall._instance;
                    if (superwall2 != null) {
                        superwall2.teardown$superwall_release();
                    }
                    Superwall._instance = null;
                    Superwall.Companion.setInitialized(false);
                    MutableStateFlow mutableStateFlow = Superwall._hasInitialized;
                    do {
                        value = mutableStateFlow.getValue();
                        ((Boolean) value).getClass();
                    } while (!mutableStateFlow.compareAndSet(value, Boolean.FALSE));
                    Unit unit = Unit.f139807a;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        private Companion() {
        }

        @JvmStatic
        public final void configure(Application applicationContext, String apiKey, PurchaseController purchaseController) {
            Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
            Intrinsics.checkNotNullParameter(apiKey, "apiKey");
            configure$default(this, applicationContext, apiKey, purchaseController, null, null, null, 56, null);
        }

        @JvmStatic
        public final void configure(Application applicationContext, String apiKey, PurchaseController purchaseController, SuperwallOptions superwallOptions) {
            Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
            Intrinsics.checkNotNullParameter(apiKey, "apiKey");
            configure$default(this, applicationContext, apiKey, purchaseController, superwallOptions, null, null, 48, null);
        }

        @JvmStatic
        public final void configure(Application applicationContext, String apiKey, PurchaseController purchaseController, SuperwallOptions superwallOptions, ActivityProvider activityProvider) {
            Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
            Intrinsics.checkNotNullParameter(apiKey, "apiKey");
            configure$default(this, applicationContext, apiKey, purchaseController, superwallOptions, activityProvider, null, 32, null);
        }

        @JvmStatic
        public final void configure(Application applicationContext, String apiKey, PurchaseController purchaseController, SuperwallOptions superwallOptions, ActivityProvider activityProvider, Function1<? super Result<Unit>, Unit> function1) {
            Object objB;
            Object value;
            Object value2;
            Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
            Intrinsics.checkNotNullParameter(apiKey, "apiKey");
            if (((Boolean) Superwall._hasInitialized.getValue()).booleanValue() && Superwall._instance == null) {
                MutableStateFlow mutableStateFlow = Superwall._hasInitialized;
                do {
                    value2 = mutableStateFlow.getValue();
                    ((Boolean) value2).getClass();
                } while (!mutableStateFlow.compareAndSet(value2, Boolean.FALSE));
            }
            if (Superwall._instance == null) {
                if (activityProvider == null) {
                    activityProvider = Superwall.retainedActivityProvider;
                }
                Superwall.retainedActivityProvider = null;
                Superwall._instance = new Superwall(applicationContext, apiKey, purchaseController, superwallOptions, activityProvider, function1);
                Either<Unit, Throwable> either = getInstance().setup$superwall_release();
                if (either instanceof Either.Success) {
                    Result.Companion companion = Result.f139772b;
                    objB = Result.b(((Either.Success) either).getValue());
                } else {
                    if (!(either instanceof Either.Failure)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    Result.Companion companion2 = Result.f139772b;
                    objB = Result.b(ResultKt.a(((Either.Failure) either).getError()));
                }
                Throwable thE = Result.e(objB);
                if (thE == null) {
                    Companion companion3 = Superwall.Companion;
                    String sdkVersion = companion3.getInstance().getDependencyContainer$superwall_release().getDeviceHelper().getSdkVersion();
                    Logger.debug$default(Logger.INSTANCE, LogLevel.debug, LogScope.superwallCore, "SDK Version - " + sdkVersion, (Map) null, (Throwable) null, 24, (Object) null);
                    companion3.setInitialized(true);
                    MutableStateFlow mutableStateFlow2 = Superwall._hasInitialized;
                    do {
                        value = mutableStateFlow2.getValue();
                        ((Boolean) value).getClass();
                    } while (!mutableStateFlow2.compareAndSet(value, Boolean.TRUE));
                    return;
                }
                if (function1 != null) {
                    function1.invoke(Result.a(Result.b(ResultKt.a(thE))));
                }
                Logger.debug$default(Logger.INSTANCE, LogLevel.error, LogScope.superwallCore, "Superwall SDK failed to initialize - " + thE.getMessage(), (Map) null, thE, 8, (Object) null);
                return;
            }
            Logger.debug$default(Logger.INSTANCE, LogLevel.warn, LogScope.superwallCore, "Superwall.configure called multiple times. Please make sure you only call this once on app launch.", (Map) null, (Throwable) null, 24, (Object) null);
            if (function1 != null) {
                Result.Companion companion4 = Result.f139772b;
                function1.invoke(Result.a(Result.b(Unit.f139807a)));
            }
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.Superwall$addListeners$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.Superwall$addListeners$1", f = "Superwall.kt", l = {780}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean invokeSuspend$lambda$2(SubscriptionStatus subscriptionStatus, SubscriptionStatus subscriptionStatus2) {
            if (subscriptionStatus == subscriptionStatus2) {
                return true;
            }
            if (!(subscriptionStatus instanceof SubscriptionStatus.Active) || !(subscriptionStatus2 instanceof SubscriptionStatus.Active)) {
                return subscriptionStatus.getClass() == subscriptionStatus2.getClass();
            }
            SubscriptionStatus.Active active = (SubscriptionStatus.Active) subscriptionStatus;
            SubscriptionStatus.Active active2 = (SubscriptionStatus.Active) subscriptionStatus2;
            if (active.getEntitlements().size() != active2.getEntitlements().size()) {
                return false;
            }
            Set<Entitlement> entitlements = active2.getEntitlements();
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(entitlements, 10)), 16));
            for (Object obj : entitlements) {
                linkedHashMap.put(((Entitlement) obj).getId(), obj);
            }
            Set<Entitlement> entitlements2 = active.getEntitlements();
            if ((entitlements2 instanceof Collection) && entitlements2.isEmpty()) {
                return true;
            }
            for (Entitlement entitlement : entitlements2) {
                Entitlement entitlement2 = (Entitlement) linkedHashMap.get(entitlement.getId());
                if (entitlement2 == null || entitlement.isDistinct(entitlement2)) {
                    return false;
                }
            }
            return true;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return Superwall.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowX = FlowKt.x(FlowKt.v(Superwall.this.getEntitlements().getStatus(), new Function2() { // from class: com.superwall.sdk.c
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        return Boolean.valueOf(Superwall.AnonymousClass1.invokeSuspend$lambda$2((SubscriptionStatus) obj2, (SubscriptionStatus) obj3));
                    }
                }), 1);
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(Superwall.this);
                this.label = 1;
                if (flowX.collect(anonymousClass2, this) == objF) {
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

        /* JADX INFO: renamed from: com.superwall.sdk.Superwall$addListeners$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass2<T> implements FlowCollector {
            final /* synthetic */ Superwall this$0;

            AnonymousClass2(Superwall superwall) {
                this.this$0 = superwall;
            }

            /* JADX WARN: Code restructure failed: missing block: B:24:0x009a, code lost:
            
                if (r8.recheckPreloadIfNeeded(r0) == r1) goto L25;
             */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object emit(com.superwall.sdk.models.entitlements.SubscriptionStatus r8, kotlin.coroutines.Continuation<? super kotlin.Unit> r9) throws java.lang.Throwable {
                /*
                    r7 = this;
                    boolean r0 = r9 instanceof com.superwall.sdk.Superwall$addListeners$1$2$emit$1
                    if (r0 == 0) goto L13
                    r0 = r9
                    com.superwall.sdk.Superwall$addListeners$1$2$emit$1 r0 = (com.superwall.sdk.Superwall$addListeners$1$2$emit$1) r0
                    int r1 = r0.label
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.label = r1
                    goto L18
                L13:
                    com.superwall.sdk.Superwall$addListeners$1$2$emit$1 r0 = new com.superwall.sdk.Superwall$addListeners$1$2$emit$1
                    r0.<init>(r7, r9)
                L18:
                    java.lang.Object r9 = r0.result
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                    int r2 = r0.label
                    r3 = 1
                    r4 = 0
                    r5 = 2
                    if (r2 == 0) goto L42
                    if (r2 == r3) goto L35
                    if (r2 != r5) goto L2d
                    kotlin.ResultKt.b(r9)
                    goto L9d
                L2d:
                    java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                    java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                    r8.<init>(r9)
                    throw r8
                L35:
                    java.lang.Object r8 = r0.L$0
                    com.superwall.sdk.Superwall$addListeners$1$2 r8 = (com.superwall.sdk.Superwall.AnonymousClass1.AnonymousClass2) r8
                    kotlin.ResultKt.b(r9)
                    kotlin.Result r9 = (kotlin.Result) r9
                    r9.j()
                    goto L88
                L42:
                    kotlin.ResultKt.b(r9)
                    com.superwall.sdk.Superwall r9 = r7.this$0
                    com.superwall.sdk.dependencies.DependencyContainer r9 = r9.getDependencyContainer$superwall_release()
                    com.superwall.sdk.storage.LocalStorage r9 = r9.getStorage()
                    com.superwall.sdk.storage.StoredSubscriptionStatus r2 = com.superwall.sdk.storage.StoredSubscriptionStatus.INSTANCE
                    java.lang.Object r9 = r9.read(r2)
                    com.superwall.sdk.models.entitlements.SubscriptionStatus r9 = (com.superwall.sdk.models.entitlements.SubscriptionStatus) r9
                    if (r9 != 0) goto L5b
                    com.superwall.sdk.models.entitlements.SubscriptionStatus$Unknown r9 = com.superwall.sdk.models.entitlements.SubscriptionStatus.Unknown.INSTANCE
                L5b:
                    com.superwall.sdk.Superwall r6 = r7.this$0
                    com.superwall.sdk.dependencies.DependencyContainer r6 = r6.getDependencyContainer$superwall_release()
                    com.superwall.sdk.storage.LocalStorage r6 = r6.getStorage()
                    r6.write(r2, r8)
                    com.superwall.sdk.Superwall r2 = r7.this$0
                    com.superwall.sdk.dependencies.DependencyContainer r2 = r2.getDependencyContainer$superwall_release()
                    com.superwall.sdk.delegate.SuperwallDelegateAdapter r2 = r2.getDelegateAdapter()
                    r2.subscriptionStatusDidChange(r9, r8)
                    com.superwall.sdk.analytics.internal.trackable.InternalSuperwallEvent$SubscriptionStatusDidChange r9 = new com.superwall.sdk.analytics.internal.trackable.InternalSuperwallEvent$SubscriptionStatusDidChange
                    r9.<init>(r8, r4, r5, r4)
                    com.superwall.sdk.Superwall r8 = r7.this$0
                    r0.L$0 = r7
                    r0.label = r3
                    java.lang.Object r8 = com.superwall.sdk.analytics.internal.TrackingKt.track(r8, r9, r0)
                    if (r8 != r1) goto L87
                    goto L9c
                L87:
                    r8 = r7
                L88:
                    com.superwall.sdk.Superwall r8 = r8.this$0
                    com.superwall.sdk.dependencies.DependencyContainer r8 = r8.getDependencyContainer$superwall_release()
                    com.superwall.sdk.config.ConfigManager r8 = r8.getConfigManager()
                    r0.L$0 = r4
                    r0.label = r5
                    java.lang.Object r8 = r8.recheckPreloadIfNeeded(r0)
                    if (r8 != r1) goto L9d
                L9c:
                    return r1
                L9d:
                    kotlin.Unit r8 = kotlin.Unit.f139807a
                    return r8
                */
                throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.Superwall.AnonymousClass1.AnonymousClass2.emit(com.superwall.sdk.models.entitlements.SubscriptionStatus, kotlin.coroutines.Continuation):java.lang.Object");
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return emit((SubscriptionStatus) obj, (Continuation<? super Unit>) continuation);
            }
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.Superwall$addListeners$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.Superwall$addListeners$2", f = "Superwall.kt", l = {803}, m = "invokeSuspend")
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        /* JADX INFO: renamed from: com.superwall.sdk.Superwall$addListeners$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @DebugMetadata(c = "com.superwall.sdk.Superwall$addListeners$2$1", f = "Superwall.kt", l = {}, m = "invokeSuspend")
        static final class AnonymousClass1 extends SuspendLambda implements Function3<Pair<? extends CustomerInfo, ? extends CustomerInfo>, CustomerInfo, Continuation<? super Pair<? extends CustomerInfo, ? extends CustomerInfo>>, Object> {
            /* synthetic */ Object L$0;
            /* synthetic */ Object L$1;
            int label;

            AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
                super(3, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                IntrinsicsKt.f();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                Pair pair = (Pair) this.L$0;
                return new Pair(pair != null ? (CustomerInfo) pair.f() : null, (CustomerInfo) this.L$1);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Pair<CustomerInfo, CustomerInfo> pair, CustomerInfo customerInfo, Continuation<? super Pair<CustomerInfo, CustomerInfo>> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation);
                anonymousClass1.L$0 = pair;
                anonymousClass1.L$1 = customerInfo;
                return anonymousClass1.invokeSuspend(Unit.f139807a);
            }
        }

        /* JADX INFO: renamed from: com.superwall.sdk.Superwall$addListeners$2$3, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass3<T> implements FlowCollector {
            final /* synthetic */ Superwall this$0;

            AnonymousClass3(Superwall superwall) {
                this.this$0 = superwall;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return emit((Pair<CustomerInfo, CustomerInfo>) obj, (Continuation<? super Unit>) continuation);
            }

            /* JADX WARN: Code restructure failed: missing block: B:21:0x009a, code lost:
            
                if (r12.recheckPreloadIfNeeded(r0) == r1) goto L22;
             */
            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object emit(kotlin.Pair<com.superwall.sdk.models.customer.CustomerInfo, com.superwall.sdk.models.customer.CustomerInfo> r12, kotlin.coroutines.Continuation<? super kotlin.Unit> r13) throws java.lang.Throwable {
                /*
                    r11 = this;
                    boolean r0 = r13 instanceof com.superwall.sdk.Superwall$addListeners$2$3$emit$1
                    if (r0 == 0) goto L13
                    r0 = r13
                    com.superwall.sdk.Superwall$addListeners$2$3$emit$1 r0 = (com.superwall.sdk.Superwall$addListeners$2$3$emit$1) r0
                    int r1 = r0.label
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.label = r1
                    goto L18
                L13:
                    com.superwall.sdk.Superwall$addListeners$2$3$emit$1 r0 = new com.superwall.sdk.Superwall$addListeners$2$3$emit$1
                    r0.<init>(r11, r13)
                L18:
                    java.lang.Object r13 = r0.result
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                    int r2 = r0.label
                    r3 = 2
                    r4 = 1
                    if (r2 == 0) goto L41
                    if (r2 == r4) goto L34
                    if (r2 != r3) goto L2c
                    kotlin.ResultKt.b(r13)
                    goto L9d
                L2c:
                    java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                    java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
                    r12.<init>(r13)
                    throw r12
                L34:
                    java.lang.Object r12 = r0.L$0
                    com.superwall.sdk.Superwall$addListeners$2$3 r12 = (com.superwall.sdk.Superwall.AnonymousClass2.AnonymousClass3) r12
                    kotlin.ResultKt.b(r13)
                    kotlin.Result r13 = (kotlin.Result) r13
                    r13.j()
                    goto L87
                L41:
                    kotlin.ResultKt.b(r13)
                    java.lang.Object r13 = r12.a()
                    r6 = r13
                    com.superwall.sdk.models.customer.CustomerInfo r6 = (com.superwall.sdk.models.customer.CustomerInfo) r6
                    java.lang.Object r12 = r12.b()
                    r7 = r12
                    com.superwall.sdk.models.customer.CustomerInfo r7 = (com.superwall.sdk.models.customer.CustomerInfo) r7
                    com.superwall.sdk.Superwall r12 = r11.this$0
                    com.superwall.sdk.dependencies.DependencyContainer r12 = r12.getDependencyContainer$superwall_release()
                    com.superwall.sdk.storage.LocalStorage r12 = r12.getStorage()
                    com.superwall.sdk.storage.LatestCustomerInfo r13 = com.superwall.sdk.storage.LatestCustomerInfo.INSTANCE
                    r12.write(r13, r7)
                    com.superwall.sdk.Superwall r12 = r11.this$0
                    com.superwall.sdk.dependencies.DependencyContainer r12 = r12.getDependencyContainer$superwall_release()
                    com.superwall.sdk.delegate.SuperwallDelegateAdapter r12 = r12.getDelegateAdapter()
                    kotlin.jvm.internal.Intrinsics.checkNotNull(r6)
                    r12.customerInfoDidChange(r6, r7)
                    com.superwall.sdk.Superwall r12 = r11.this$0
                    com.superwall.sdk.analytics.internal.trackable.InternalSuperwallEvent$CustomerInfoDidChange r5 = new com.superwall.sdk.analytics.internal.trackable.InternalSuperwallEvent$CustomerInfoDidChange
                    r9 = 4
                    r10 = 0
                    r8 = 0
                    r5.<init>(r6, r7, r8, r9, r10)
                    r0.L$0 = r11
                    r0.label = r4
                    java.lang.Object r12 = com.superwall.sdk.analytics.internal.TrackingKt.track(r12, r5, r0)
                    if (r12 != r1) goto L86
                    goto L9c
                L86:
                    r12 = r11
                L87:
                    com.superwall.sdk.Superwall r12 = r12.this$0
                    com.superwall.sdk.dependencies.DependencyContainer r12 = r12.getDependencyContainer$superwall_release()
                    com.superwall.sdk.config.ConfigManager r12 = r12.getConfigManager()
                    r13 = 0
                    r0.L$0 = r13
                    r0.label = r3
                    java.lang.Object r12 = r12.recheckPreloadIfNeeded(r0)
                    if (r12 != r1) goto L9d
                L9c:
                    return r1
                L9d:
                    kotlin.Unit r12 = kotlin.Unit.f139807a
                    return r12
                */
                throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.Superwall.AnonymousClass2.AnonymousClass3.emit(kotlin.Pair, kotlin.coroutines.Continuation):java.lang.Object");
            }
        }

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return Superwall.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                final Flow flowC = FlowKt.C(FlowKt.c0(FlowKt.u(FlowKt.b(Superwall.this.get_customerInfo$superwall_release())), null, new AnonymousClass1(null)));
                Flow<Pair<? extends CustomerInfo, ? extends CustomerInfo>> flow = new Flow<Pair<? extends CustomerInfo, ? extends CustomerInfo>>() { // from class: com.superwall.sdk.Superwall$addListeners$2$invokeSuspend$$inlined$filter$1

                    /* JADX INFO: renamed from: com.superwall.sdk.Superwall$addListeners$2$invokeSuspend$$inlined$filter$1$2, reason: invalid class name */
                    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                    @Metadata
                    public static final class AnonymousClass2<T> implements FlowCollector {
                        final /* synthetic */ FlowCollector $this_unsafeFlow;

                        /* JADX INFO: renamed from: com.superwall.sdk.Superwall$addListeners$2$invokeSuspend$$inlined$filter$1$2$1, reason: invalid class name */
                        @Metadata
                        @DebugMetadata(c = "com.superwall.sdk.Superwall$addListeners$2$invokeSuspend$$inlined$filter$1$2", f = "Superwall.kt", l = {50}, m = "emit")
                        public static final class AnonymousClass1 extends ContinuationImpl {
                            Object L$0;
                            Object L$1;
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
                                boolean r0 = r6 instanceof com.superwall.sdk.Superwall$addListeners$2$invokeSuspend$$inlined$filter$1.AnonymousClass2.AnonymousClass1
                                if (r0 == 0) goto L13
                                r0 = r6
                                com.superwall.sdk.Superwall$addListeners$2$invokeSuspend$$inlined$filter$1$2$1 r0 = (com.superwall.sdk.Superwall$addListeners$2$invokeSuspend$$inlined$filter$1.AnonymousClass2.AnonymousClass1) r0
                                int r1 = r0.label
                                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                                r3 = r1 & r2
                                if (r3 == 0) goto L13
                                int r1 = r1 - r2
                                r0.label = r1
                                goto L18
                            L13:
                                com.superwall.sdk.Superwall$addListeners$2$invokeSuspend$$inlined$filter$1$2$1 r0 = new com.superwall.sdk.Superwall$addListeners$2$invokeSuspend$$inlined$filter$1$2$1
                                r0.<init>(r6)
                            L18:
                                java.lang.Object r6 = r0.result
                                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                                int r2 = r0.label
                                r3 = 1
                                if (r2 == 0) goto L31
                                if (r2 != r3) goto L29
                                kotlin.ResultKt.b(r6)
                                goto L48
                            L29:
                                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                                r5.<init>(r6)
                                throw r5
                            L31:
                                kotlin.ResultKt.b(r6)
                                kotlinx.coroutines.flow.FlowCollector r6 = r4.$this_unsafeFlow
                                r2 = r5
                                kotlin.Pair r2 = (kotlin.Pair) r2
                                java.lang.Object r2 = r2.e()
                                if (r2 == 0) goto L48
                                r0.label = r3
                                java.lang.Object r5 = r6.emit(r5, r0)
                                if (r5 != r1) goto L48
                                return r1
                            L48:
                                kotlin.Unit r5 = kotlin.Unit.f139807a
                                return r5
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.Superwall$addListeners$2$invokeSuspend$$inlined$filter$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                        }
                    }

                    @Override // kotlinx.coroutines.flow.Flow
                    public Object collect(FlowCollector flowCollector, Continuation continuation) {
                        Object objCollect = flowC.collect(new AnonymousClass2(flowCollector), continuation);
                        return objCollect == IntrinsicsKt.f() ? objCollect : Unit.f139807a;
                    }
                };
                AnonymousClass3 anonymousClass3 = new AnonymousClass3(Superwall.this);
                this.label = 1;
                if (flow.collect(anonymousClass3, this) == objF) {
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

    /* JADX INFO: renamed from: com.superwall.sdk.Superwall$confirmAllAssignments$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.Superwall", f = "Superwall.kt", l = {1069, 1090}, m = "confirmAllAssignments-IoAF18A")
    static final class C27621 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C27621(Continuation<? super C27621> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            Object objM1245confirmAllAssignmentsIoAF18A = Superwall.this.m1245confirmAllAssignmentsIoAF18A(this);
            return objM1245confirmAllAssignmentsIoAF18A == IntrinsicsKt.f() ? objM1245confirmAllAssignmentsIoAF18A : Result.a(objM1245confirmAllAssignmentsIoAF18A);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.Superwall$confirmAllAssignments$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.Superwall$confirmAllAssignments$3", f = "Superwall.kt", l = {1120}, m = "invokeSuspend")
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<Result<? extends List<ConfirmedAssignment>>, Unit> $callback;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass3(Function1<? super Result<? extends List<ConfirmedAssignment>>, Unit> function1, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.$callback = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return Superwall.this.new AnonymousClass3(this.$callback, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objM1245confirmAllAssignmentsIoAF18A;
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                Superwall superwall = Superwall.this;
                this.label = 1;
                objM1245confirmAllAssignmentsIoAF18A = superwall.m1245confirmAllAssignmentsIoAF18A(this);
                if (objM1245confirmAllAssignmentsIoAF18A == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                objM1245confirmAllAssignmentsIoAF18A = ((Result) obj).j();
            }
            this.$callback.invoke(Result.a(objM1245confirmAllAssignmentsIoAF18A));
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.Superwall$consume$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.Superwall", f = "Superwall.kt", l = {1259, 1261}, m = "consume-gIAlu-s")
    static final class C27631 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C27631(Continuation<? super C27631> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            Object objM1246consumegIAlus = Superwall.this.m1246consumegIAlus(null, this);
            return objM1246consumegIAlus == IntrinsicsKt.f() ? objM1246consumegIAlus : Result.a(objM1246consumegIAlus);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.Superwall$consume$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.Superwall$consume$3", f = "Superwall.kt", l = {1281}, m = "invokeSuspend")
    static final class C27643 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<Result<String>, Unit> $onConsumed;
        final /* synthetic */ String $purchaseToken;
        Object L$0;
        int label;
        final /* synthetic */ Superwall this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C27643(Function1<? super Result<String>, Unit> function1, Superwall superwall, String str, Continuation<? super C27643> continuation) {
            super(2, continuation);
            this.$onConsumed = function1;
            this.this$0 = superwall;
            this.$purchaseToken = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C27643(this.$onConsumed, this.this$0, this.$purchaseToken, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Function1<Result<String>, Unit> function1;
            Object objJ;
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                Function1<Result<String>, Unit> function12 = this.$onConsumed;
                Superwall superwall = this.this$0;
                String str = this.$purchaseToken;
                this.L$0 = function12;
                this.label = 1;
                Object objM1246consumegIAlus = superwall.m1246consumegIAlus(str, this);
                if (objM1246consumegIAlus == objF) {
                    return objF;
                }
                function1 = function12;
                objJ = objM1246consumegIAlus;
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                function1 = (Function1) this.L$0;
                ResultKt.b(obj);
                objJ = ((Result) obj).j();
            }
            function1.invoke(Result.a(objJ));
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C27643) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.Superwall$eventDidOccur$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.Superwall$eventDidOccur$2", f = "Superwall.kt", l = {1418, 1451, 1472, 1553}, m = "invokeSuspend")
    static final class C27652 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PaywallWebEvent $paywallEvent;
        final /* synthetic */ PaywallView $paywallView;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ Superwall this$0;

        /* JADX INFO: renamed from: com.superwall.sdk.Superwall$eventDidOccur$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @DebugMetadata(c = "com.superwall.sdk.Superwall$eventDidOccur$2$1", f = "Superwall.kt", l = {1436}, m = "invokeSuspend")
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ PaywallWebEvent $paywallEvent;
            final /* synthetic */ PaywallView $paywallView;
            int label;
            final /* synthetic */ Superwall this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(Superwall superwall, PaywallWebEvent paywallWebEvent, PaywallView paywallView, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = superwall;
                this.$paywallEvent = paywallWebEvent;
                this.$paywallView = paywallView;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, this.$paywallEvent, this.$paywallView, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objF = IntrinsicsKt.f();
                int i3 = this.label;
                try {
                    if (i3 == 0) {
                        ResultKt.b(obj);
                        TransactionManager transactionManager = this.this$0.getDependencyContainer$superwall_release().getTransactionManager();
                        TransactionManager.PurchaseSource.Internal internal = new TransactionManager.PurchaseSource.Internal(((PaywallWebEvent.InitiatePurchase) this.$paywallEvent).getProductId(), this.$paywallView.getController().getState());
                        boolean shouldDismiss = ((PaywallWebEvent.InitiatePurchase) this.$paywallEvent).getShouldDismiss();
                        this.label = 1;
                        obj = transactionManager.purchase(internal, shouldDismiss, this);
                        if (obj == objF) {
                            return objF;
                        }
                    } else {
                        if (i3 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.b(obj);
                    }
                    this.this$0.purchaseTask = null;
                    return Unit.f139807a;
                } catch (Throwable th) {
                    this.this$0.purchaseTask = null;
                    throw th;
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
            }
        }

        /* JADX INFO: renamed from: com.superwall.sdk.Superwall$eventDidOccur$2$2, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @DebugMetadata(c = "com.superwall.sdk.Superwall$eventDidOccur$2$2", f = "Superwall.kt", l = {1490, 1494, 1500, 1507, 1513}, m = "invokeSuspend")
        static final class C02282 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ PaywallWebEvent $paywallEvent;
            final /* synthetic */ PaywallView $paywallView;
            int label;
            final /* synthetic */ Superwall this$0;

            /* JADX INFO: renamed from: com.superwall.sdk.Superwall$eventDidOccur$2$2$WhenMappings */
            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[PaywallWebEvent.RequestReview.Type.values().length];
                    try {
                        iArr[PaywallWebEvent.RequestReview.Type.INAPP.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C02282(PaywallWebEvent paywallWebEvent, Superwall superwall, PaywallView paywallView, Continuation<? super C02282> continuation) {
                super(2, continuation);
                this.$paywallEvent = paywallWebEvent;
                this.this$0 = superwall;
                this.$paywallView = paywallView;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C02282(this.$paywallEvent, this.this$0, this.$paywallView, continuation);
            }

            /* JADX WARN: Code restructure failed: missing block: B:40:0x00ef, code lost:
            
                if (r15.recheckPreloadIfNeeded(r14) != r0) goto L55;
             */
            /* JADX WARN: Removed duplicated region for block: B:28:0x0077 A[Catch: Exception -> 0x001d, TryCatch #0 {Exception -> 0x001d, blocks: (B:9:0x0018, B:15:0x002a, B:39:0x00df, B:16:0x0034, B:36:0x00a3, B:17:0x0038, B:33:0x0090, B:18:0x003c, B:26:0x0069, B:28:0x0077, B:30:0x007d, B:21:0x0043, B:23:0x0055, B:42:0x00f2, B:44:0x0119, B:52:0x0133, B:48:0x0122, B:50:0x012a), top: B:57:0x000c }] */
            /* JADX WARN: Removed duplicated region for block: B:30:0x007d A[Catch: Exception -> 0x001d, TryCatch #0 {Exception -> 0x001d, blocks: (B:9:0x0018, B:15:0x002a, B:39:0x00df, B:16:0x0034, B:36:0x00a3, B:17:0x0038, B:33:0x0090, B:18:0x003c, B:26:0x0069, B:28:0x0077, B:30:0x007d, B:21:0x0043, B:23:0x0055, B:42:0x00f2, B:44:0x0119, B:52:0x0133, B:48:0x0122, B:50:0x012a), top: B:57:0x000c }] */
            /* JADX WARN: Removed duplicated region for block: B:35:0x00a2  */
            /* JADX WARN: Removed duplicated region for block: B:36:0x00a3 A[Catch: Exception -> 0x001d, PHI: r15
              0x00a3: PHI (r15v25 java.lang.Object) = (r15v24 java.lang.Object), (r15v0 java.lang.Object) binds: [B:34:0x00a0, B:16:0x0034] A[DONT_GENERATE, DONT_INLINE], TryCatch #0 {Exception -> 0x001d, blocks: (B:9:0x0018, B:15:0x002a, B:39:0x00df, B:16:0x0034, B:36:0x00a3, B:17:0x0038, B:33:0x0090, B:18:0x003c, B:26:0x0069, B:28:0x0077, B:30:0x007d, B:21:0x0043, B:23:0x0055, B:42:0x00f2, B:44:0x0119, B:52:0x0133, B:48:0x0122, B:50:0x012a), top: B:57:0x000c }] */
            /* JADX WARN: Removed duplicated region for block: B:38:0x00de  */
            /* JADX WARN: Removed duplicated region for block: B:39:0x00df A[Catch: Exception -> 0x001d, TryCatch #0 {Exception -> 0x001d, blocks: (B:9:0x0018, B:15:0x002a, B:39:0x00df, B:16:0x0034, B:36:0x00a3, B:17:0x0038, B:33:0x0090, B:18:0x003c, B:26:0x0069, B:28:0x0077, B:30:0x007d, B:21:0x0043, B:23:0x0055, B:42:0x00f2, B:44:0x0119, B:52:0x0133, B:48:0x0122, B:50:0x012a), top: B:57:0x000c }] */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r15) throws java.lang.Throwable {
                /*
                    Method dump skipped, instruction units count: 340
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.Superwall.C27652.C02282.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C02282) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C27652(PaywallWebEvent paywallWebEvent, PaywallView paywallView, Superwall superwall, Continuation<? super C27652> continuation) {
            super(2, continuation);
            this.$paywallEvent = paywallWebEvent;
            this.$paywallView = paywallView;
            this.this$0 = superwall;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C27652 c27652 = new C27652(this.$paywallEvent, this.$paywallView, this.this$0, continuation);
            c27652.L$0 = obj;
            return c27652;
        }

        /* JADX WARN: Code restructure failed: missing block: B:17:0x007a, code lost:
        
            if (com.superwall.sdk.paywall.presentation.internal.InternalPresentationKt.dismiss$default(r0, r1, r2, null, r17, 8, null) == r7) goto L77;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x00ce, code lost:
        
            if (r0.tryToRestorePurchases(r1, r17) == r7) goto L77;
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x017c, code lost:
        
            if (r0 == r7) goto L77;
         */
        /* JADX WARN: Code restructure failed: missing block: B:76:0x01ef, code lost:
        
            if (r12.attemptToScheduleNotifications(r0, r2, true, r17) == r7) goto L77;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r18) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 604
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.Superwall.C27652.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C27652) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.Superwall$observe$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.Superwall$observe$1", f = "Superwall.kt", l = {1314, 1323, 1331}, m = "invokeSuspend")
    static final class C27661 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PurchasingObserverState $state;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C27661(PurchasingObserverState purchasingObserverState, Continuation<? super C27661> continuation) {
            super(2, continuation);
            this.$state = purchasingObserverState;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return Superwall.this.new C27661(this.$state, continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x0078, code lost:
        
            if (r1.prepareToPurchase$superwall_release(r14, r2, r13) == r0) goto L33;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x00e0, code lost:
        
            if (r14.handle$superwall_release(r1, r3, r13) == r0) goto L33;
         */
        /* JADX WARN: Removed duplicated region for block: B:26:0x00a0  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r14) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 236
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.Superwall.C27661.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C27661) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.Superwall$preloadAllPaywalls$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.Superwall$preloadAllPaywalls$1", f = "Superwall.kt", l = {1021}, m = "invokeSuspend")
    static final class C27671 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C27671(Continuation<? super C27671> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return Superwall.this.new C27671(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                ConfigManager configManager = Superwall.this.getDependencyContainer$superwall_release().getConfigManager();
                this.label = 1;
                if (configManager.preloadAllPaywalls(this) == objF) {
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
            return ((C27671) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.Superwall$preloadPaywalls$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.Superwall$preloadPaywalls$1", f = "Superwall.kt", l = {1037}, m = "invokeSuspend")
    static final class C27681 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Set<String> $placementNames;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C27681(Set<String> set, Continuation<? super C27681> continuation) {
            super(2, continuation);
            this.$placementNames = set;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return Superwall.this.new C27681(this.$placementNames, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                ConfigManager configManager = Superwall.this.getDependencyContainer$superwall_release().getConfigManager();
                Set<String> set = this.$placementNames;
                this.label = 1;
                if (configManager.preloadPaywallsByNames(set, this) == objF) {
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
            return ((C27681) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.Superwall$purchase$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.Superwall", f = "Superwall.kt", l = {1140}, m = "purchase-gIAlu-s")
    static final class C27691 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C27691(Continuation<? super C27691> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            Object objM1251purchasegIAlus = Superwall.this.m1251purchasegIAlus((ProductDetails) null, this);
            return objM1251purchasegIAlus == IntrinsicsKt.f() ? objM1251purchasegIAlus : Result.a(objM1251purchasegIAlus);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.Superwall$purchase$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.Superwall", f = "Superwall.kt", l = {1163}, m = "purchase-gIAlu-s")
    static final class C27703 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C27703(Continuation<? super C27703> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            Object objM1252purchasegIAlus = Superwall.this.m1252purchasegIAlus((StoreProduct) null, this);
            return objM1252purchasegIAlus == IntrinsicsKt.f() ? objM1252purchasegIAlus : Result.a(objM1252purchasegIAlus);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.Superwall$purchase$5, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.Superwall", f = "Superwall.kt", l = {1186, 1187}, m = "purchase-gIAlu-s")
    static final class AnonymousClass5 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass5(Continuation<? super AnonymousClass5> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            Object objM1253purchasegIAlus = Superwall.this.m1253purchasegIAlus((String) null, this);
            return objM1253purchasegIAlus == IntrinsicsKt.f() ? objM1253purchasegIAlus : Result.a(objM1253purchasegIAlus);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.Superwall$purchase$7, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.Superwall$purchase$7", f = "Superwall.kt", l = {1226}, m = "invokeSuspend")
    static final class AnonymousClass7 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<Result<? extends PurchaseResult>, Unit> $onFinished;
        final /* synthetic */ StoreProduct $product;
        Object L$0;
        int label;
        final /* synthetic */ Superwall this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass7(Function1<? super Result<? extends PurchaseResult>, Unit> function1, Superwall superwall, StoreProduct storeProduct, Continuation<? super AnonymousClass7> continuation) {
            super(2, continuation);
            this.$onFinished = function1;
            this.this$0 = superwall;
            this.$product = storeProduct;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass7(this.$onFinished, this.this$0, this.$product, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Function1<Result<? extends PurchaseResult>, Unit> function1;
            Object objJ;
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                Function1<Result<? extends PurchaseResult>, Unit> function12 = this.$onFinished;
                Superwall superwall = this.this$0;
                StoreProduct storeProduct = this.$product;
                this.L$0 = function12;
                this.label = 1;
                Object objM1252purchasegIAlus = superwall.m1252purchasegIAlus(storeProduct, this);
                if (objM1252purchasegIAlus == objF) {
                    return objF;
                }
                function1 = function12;
                objJ = objM1252purchasegIAlus;
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                function1 = (Function1) this.L$0;
                ResultKt.b(obj);
                objJ = ((Result) obj).j();
            }
            function1.invoke(Result.a(objJ));
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass7) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.Superwall$purchase$8, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.Superwall$purchase$8", f = "Superwall.kt", l = {1235}, m = "invokeSuspend")
    static final class AnonymousClass8 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<Result<? extends PurchaseResult>, Unit> $onFinished;
        final /* synthetic */ ProductDetails $product;
        Object L$0;
        int label;
        final /* synthetic */ Superwall this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass8(Function1<? super Result<? extends PurchaseResult>, Unit> function1, Superwall superwall, ProductDetails productDetails, Continuation<? super AnonymousClass8> continuation) {
            super(2, continuation);
            this.$onFinished = function1;
            this.this$0 = superwall;
            this.$product = productDetails;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass8(this.$onFinished, this.this$0, this.$product, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Function1<Result<? extends PurchaseResult>, Unit> function1;
            Object objJ;
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                Function1<Result<? extends PurchaseResult>, Unit> function12 = this.$onFinished;
                Superwall superwall = this.this$0;
                ProductDetails productDetails = this.$product;
                this.L$0 = function12;
                this.label = 1;
                Object objM1251purchasegIAlus = superwall.m1251purchasegIAlus(productDetails, this);
                if (objM1251purchasegIAlus == objF) {
                    return objF;
                }
                function1 = function12;
                objJ = objM1251purchasegIAlus;
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                function1 = (Function1) this.L$0;
                ResultKt.b(obj);
                objJ = ((Result) obj).j();
            }
            function1.invoke(Result.a(objJ));
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass8) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.Superwall$purchase$9, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.Superwall$purchase$9", f = "Superwall.kt", l = {1244}, m = "invokeSuspend")
    static final class AnonymousClass9 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<Result<? extends PurchaseResult>, Unit> $onFinished;
        final /* synthetic */ String $productId;
        Object L$0;
        int label;
        final /* synthetic */ Superwall this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass9(Function1<? super Result<? extends PurchaseResult>, Unit> function1, Superwall superwall, String str, Continuation<? super AnonymousClass9> continuation) {
            super(2, continuation);
            this.$onFinished = function1;
            this.this$0 = superwall;
            this.$productId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass9(this.$onFinished, this.this$0, this.$productId, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Function1<Result<? extends PurchaseResult>, Unit> function1;
            Object objJ;
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                Function1<Result<? extends PurchaseResult>, Unit> function12 = this.$onFinished;
                Superwall superwall = this.this$0;
                String str = this.$productId;
                this.L$0 = function12;
                this.label = 1;
                Object objM1253purchasegIAlus = superwall.m1253purchasegIAlus(str, this);
                if (objM1253purchasegIAlus == objF) {
                    return objF;
                }
                function1 = function12;
                objJ = objM1253purchasegIAlus;
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                function1 = (Function1) this.L$0;
                ResultKt.b(obj);
                objJ = ((Result) obj).j();
            }
            function1.invoke(Result.a(objJ));
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass9) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.Superwall$refreshConfiguration$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.Superwall$refreshConfiguration$1", f = "Superwall.kt", l = {1597}, m = "invokeSuspend")
    static final class C27711 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C27711(Continuation<? super C27711> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return Superwall.this.new C27711(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                ConfigManager configManager = Superwall.this.getDependencyContainer$superwall_release().getConfigManager();
                this.label = 1;
                if (configManager.refreshConfiguration$superwall_release(true, this) == objF) {
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
            return ((C27711) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.Superwall$restorePurchases$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.Superwall", f = "Superwall.kt", l = {1391}, m = "restorePurchases-IoAF18A")
    static final class C27721 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C27721(Continuation<? super C27721> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            Object objM1254restorePurchasesIoAF18A = Superwall.this.m1254restorePurchasesIoAF18A(this);
            return objM1254restorePurchasesIoAF18A == IntrinsicsKt.f() ? objM1254restorePurchasesIoAF18A : Result.a(objM1254restorePurchasesIoAF18A);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.Superwall$restorePurchases$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.Superwall$restorePurchases$3", f = "Superwall.kt", l = {1401}, m = "invokeSuspend")
    static final class C27733 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<Result<? extends RestorationResult>, Unit> $onFinished;
        Object L$0;
        int label;
        final /* synthetic */ Superwall this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C27733(Function1<? super Result<? extends RestorationResult>, Unit> function1, Superwall superwall, Continuation<? super C27733> continuation) {
            super(2, continuation);
            this.$onFinished = function1;
            this.this$0 = superwall;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C27733(this.$onFinished, this.this$0, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Function1<Result<? extends RestorationResult>, Unit> function1;
            Object objJ;
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                Function1<Result<? extends RestorationResult>, Unit> function12 = this.$onFinished;
                Superwall superwall = this.this$0;
                this.L$0 = function12;
                this.label = 1;
                Object objM1254restorePurchasesIoAF18A = superwall.m1254restorePurchasesIoAF18A(this);
                if (objM1254restorePurchasesIoAF18A == objF) {
                    return objF;
                }
                function1 = function12;
                objJ = objM1254restorePurchasesIoAF18A;
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                function1 = (Function1) this.L$0;
                ResultKt.b(obj);
                objJ = ((Result) obj).j();
            }
            function1.invoke(Result.a(objJ));
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C27733) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.Superwall$togglePaywallSpinner$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.Superwall$togglePaywallSpinner$1", f = "Superwall.kt", l = {}, m = "invokeSuspend")
    static final class C27741 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $isHidden;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C27741(boolean z2, Continuation<? super C27741> continuation) {
            super(2, continuation);
            this.$isHidden = z2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return Superwall.this.new C27741(this.$isHidden, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            PaywallView currentView = Superwall.this.getDependencyContainer$superwall_release().getPaywallManager().getCurrentView();
            if (currentView == null) {
                return Unit.f139807a;
            }
            currentView.updateState(new PaywallViewState.Updates.ToggleSpinner(this.$isHidden));
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C27741) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    static {
        final MutableStateFlow<Boolean> mutableStateFlowA = StateFlowKt.a(Boolean.FALSE);
        _hasInitialized = mutableStateFlowA;
        hasInitialized = FlowKt.i0(new Flow<Boolean>() { // from class: com.superwall.sdk.Superwall$special$$inlined$filter$1

            /* JADX INFO: renamed from: com.superwall.sdk.Superwall$special$$inlined$filter$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: com.superwall.sdk.Superwall$special$$inlined$filter$1$2$1, reason: invalid class name */
                @Metadata
                @DebugMetadata(c = "com.superwall.sdk.Superwall$special$$inlined$filter$1$2", f = "Superwall.kt", l = {50}, m = "emit")
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    Object L$1;
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
                        boolean r0 = r6 instanceof com.superwall.sdk.Superwall$special$$inlined$filter$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r6
                        com.superwall.sdk.Superwall$special$$inlined$filter$1$2$1 r0 = (com.superwall.sdk.Superwall$special$$inlined$filter$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.superwall.sdk.Superwall$special$$inlined$filter$1$2$1 r0 = new com.superwall.sdk.Superwall$special$$inlined$filter$1$2$1
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        kotlin.ResultKt.b(r6)
                        goto L48
                    L29:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L31:
                        kotlin.ResultKt.b(r6)
                        kotlinx.coroutines.flow.FlowCollector r6 = r4.$this_unsafeFlow
                        r2 = r5
                        java.lang.Boolean r2 = (java.lang.Boolean) r2
                        boolean r2 = r2.booleanValue()
                        if (r2 == 0) goto L48
                        r0.label = r3
                        java.lang.Object r5 = r6.emit(r5, r0)
                        if (r5 != r1) goto L48
                        return r1
                    L48:
                        kotlin.Unit r5 = kotlin.Unit.f139807a
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.Superwall$special$$inlined$filter$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector flowCollector, Continuation continuation) {
                Object objCollect = mutableStateFlowA.collect(new AnonymousClass2(flowCollector), continuation);
                return objCollect == IntrinsicsKt.f() ? objCollect : Unit.f139807a;
            }
        }, 1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Superwall(Context context, String apiKey, PurchaseController purchaseController, SuperwallOptions superwallOptions, ActivityProvider activityProvider, Function1<? super Result<Unit>, Unit> function1) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(apiKey, "apiKey");
        this.apiKey = apiKey;
        this.purchaseController = purchaseController;
        this.activityProvider = activityProvider;
        this.completion = function1;
        this._options = superwallOptions;
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        this.context = applicationContext;
        this.presentationItems = new PresentationItems();
        MutableSharedFlow<SuperwallEventInfo> mutableSharedFlowA = SharedFlowKt.a(0, Function.MAX_NARGS, BufferOverflow.f141062a);
        this._placements = mutableSharedFlowA;
        this.placements = mutableSharedFlowA;
        this.localResources = MapsKt.emptyMap();
        this._customerInfo = StateFlowKt.a(CustomerInfo.Companion.empty());
        this.entitlements$delegate = LazyKt.b(new Function0() { // from class: com.superwall.sdk.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Superwall.entitlements_delegate$lambda$2(this.f93452a);
            }
        });
        this.subscriptionStatus$delegate = LazyKt.b(new Function0() { // from class: com.superwall.sdk.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Superwall.subscriptionStatus_delegate$lambda$3(this.f93454a);
            }
        });
        this.serialTaskManager = new SerialTaskManager(null, 1, 0 == true ? 1 : 0);
    }

    private final void addListeners() {
        ScopesKt.launchWithTracking(getIoScope$superwall_release(), new AnonymousClass1(null));
        ScopesKt.launchWithTracking(getIoScope$superwall_release(), new AnonymousClass2(null));
        registerConfigurationChangeListener();
    }

    @JvmStatic
    public static final void configure(Application application, String str) {
        Companion.configure(application, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Entitlements entitlements_delegate$lambda$2(Superwall superwall) {
        return superwall.getDependencyContainer$superwall_release().getEntitlements();
    }

    private final void registerConfigurationChangeListener() {
        ComponentCallbacks2 componentCallbacks2 = new ComponentCallbacks2() { // from class: com.superwall.sdk.Superwall$registerConfigurationChangeListener$listener$1
            @Override // android.content.ComponentCallbacks
            public void onConfigurationChanged(Configuration newConfig) {
                Intrinsics.checkNotNullParameter(newConfig, "newConfig");
                ScopesKt.launchWithTracking(this.this$0.getIoScope$superwall_release(), new Superwall$registerConfigurationChangeListener$listener$1$onConfigurationChanged$1(this.this$0, null));
            }

            @Override // android.content.ComponentCallbacks
            public void onLowMemory() {
            }

            @Override // android.content.ComponentCallbacks2
            public void onTrimMemory(int i3) {
            }
        };
        this.configurationChangeListener = componentCallbacks2;
        this.context.getApplicationContext().registerComponentCallbacks(componentCallbacks2);
    }

    public static /* synthetic */ void reset$superwall_release$default(Superwall superwall, boolean z2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z2 = false;
        }
        superwall.reset$superwall_release(z2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void showAlert$default(Superwall superwall, String str, String str2, String str3, String str4, Function0 function0, Function0 function02, int i3, Object obj) {
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
        superwall.showAlert(str, str2, str3, str4, function0, function02);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StateFlow subscriptionStatus_delegate$lambda$3(Superwall superwall) {
        return superwall.getDependencyContainer$superwall_release().getEntitlements().getStatus();
    }

    @JvmStatic
    public static final void teardown() {
        Companion.teardown();
    }

    public final void cancelAllScheduledNotifications() {
        try {
            new Either.Success(WorkManager.h(this.context).a(SuperwallPaywallActivity.NOTIFICATION_CHANNEL_ID));
        } catch (Throwable th) {
            if (ErrorTrackingKt.shouldLog(th)) {
                Companion companion = Companion;
                if (companion.getInitialized()) {
                    ErrorTrackingKt.trackError(companion.getInstance(), th);
                }
            }
            new Either.Failure(th);
        }
    }

    public final void confirmAllAssignments(Superwall superwall, Function1<? super Result<? extends List<ConfirmedAssignment>>, Unit> callback) {
        Intrinsics.checkNotNullParameter(superwall, "<this>");
        Intrinsics.checkNotNullParameter(callback, "callback");
        BuildersKt__Builders_commonKt.d(superwall.getIoScope$superwall_release(), null, null, superwall.new AnonymousClass3(callback, null), 3, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x0114, code lost:
    
        if (r0 == r3) goto L41;
     */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00cd A[Catch: all -> 0x003d, TryCatch #0 {all -> 0x003d, blocks: (B:13:0x0038, B:42:0x0117, B:44:0x011d, B:37:0x00c7, B:39:0x00cd, B:52:0x014b, B:54:0x0156, B:46:0x0127, B:47:0x012b, B:49:0x012f, B:50:0x0145, B:51:0x014a, B:20:0x004c, B:27:0x0067, B:29:0x0075, B:32:0x007d, B:33:0x009a, B:35:0x00a0, B:36:0x00bb, B:53:0x0152, B:23:0x0058), top: B:71:0x0026 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x014b A[Catch: all -> 0x003d, TryCatch #0 {all -> 0x003d, blocks: (B:13:0x0038, B:42:0x0117, B:44:0x011d, B:37:0x00c7, B:39:0x00cd, B:52:0x014b, B:54:0x0156, B:46:0x0127, B:47:0x012b, B:49:0x012f, B:50:0x0145, B:51:0x014a, B:20:0x004c, B:27:0x0067, B:29:0x0075, B:32:0x007d, B:33:0x009a, B:35:0x00a0, B:36:0x00bb, B:53:0x0152, B:23:0x0058), top: B:71:0x0026 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x0114 -> B:42:0x0117). Please report as a decompilation issue!!! */
    /* JADX INFO: renamed from: confirmAllAssignments-IoAF18A, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object m1245confirmAllAssignmentsIoAF18A(kotlin.coroutines.Continuation<? super kotlin.Result<? extends java.util.List<com.superwall.sdk.models.assignment.ConfirmedAssignment>>> r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 418
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.Superwall.m1245confirmAllAssignmentsIoAF18A(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void consume(String purchaseToken, Function1<? super Result<String>, Unit> onConsumed) {
        Intrinsics.checkNotNullParameter(purchaseToken, "purchaseToken");
        Intrinsics.checkNotNullParameter(onConsumed, "onConsumed");
        BuildersKt__Builders_commonKt.d(getIoScope$superwall_release(), null, null, new C27643(onConsumed, this, purchaseToken, null), 3, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0087, code lost:
    
        if (r8.restorePurchases(r0) == r1) goto L33;
     */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX INFO: renamed from: consume-gIAlu-s, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object m1246consumegIAlus(java.lang.String r7, kotlin.coroutines.Continuation<? super kotlin.Result<java.lang.String>> r8) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 304
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.Superwall.m1246consumegIAlus(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object deviceAttributes(Continuation<? super Map<String, ? extends Object>> continuation) {
        return getDependencyContainer$superwall_release().makeSessionDeviceAttributes(continuation);
    }

    public final void emitSuperwallEvent$superwall_release(SuperwallEventInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        BuildersKt__Builders_commonKt.d(getIoScope$superwall_release(), null, null, new Superwall$emitSuperwallEvent$1(this, info, null), 3, null);
    }

    @Override // com.superwall.sdk.paywall.view.delegate.PaywallViewEventCallback
    public Object eventDidOccur(PaywallWebEvent paywallWebEvent, PaywallView paywallView, Continuation<? super Unit> continuation) {
        ScopesKt.launchWithTracking(getMainScope$superwall_release(), new C27652(paywallWebEvent, paywallView, this, null));
        return Unit.f139807a;
    }

    /* JADX INFO: renamed from: getAssignments-d1pmJ48, reason: not valid java name */
    public final Object m1247getAssignmentsd1pmJ48() {
        Either failure;
        try {
            Map<String, Experiment.Variant> confirmedAssignments = getDependencyContainer$superwall_release().getStorage().getConfirmedAssignments();
            ArrayList arrayList = new ArrayList(confirmedAssignments.size());
            for (Map.Entry<String, Experiment.Variant> entry : confirmedAssignments.entrySet()) {
                arrayList.add(new ConfirmedAssignment(entry.getKey(), entry.getValue()));
            }
            failure = new Either.Success(arrayList);
        } catch (Throwable th) {
            if (ErrorTrackingKt.shouldLog(th)) {
                Companion companion = Companion;
                if (companion.getInitialized()) {
                    ErrorTrackingKt.trackError(companion.getInstance(), th);
                }
            }
            failure = new Either.Failure(th);
        }
        if (failure instanceof Either.Success) {
            Result.Companion companion2 = Result.f139772b;
            return Result.b(((Either.Success) failure).getValue());
        }
        if (!(failure instanceof Either.Failure)) {
            throw new NoWhenBranchMatchedException();
        }
        Result.Companion companion3 = Result.f139772b;
        return Result.b(ResultKt.a(((Either.Failure) failure).getError()));
    }

    public final ConfigurationStatus getConfigurationState() {
        ConfigState configState = (ConfigState) getDependencyContainer$superwall_release().getConfigManager().getConfigState$superwall_release().getValue();
        return configState instanceof ConfigState.Retrieved ? ConfigurationStatus.Configured.INSTANCE : configState instanceof ConfigState.Failed ? ConfigurationStatus.Failed.INSTANCE : ConfigurationStatus.Pending.INSTANCE;
    }

    public final Flow<ConfigurationStatus> getConfigurationStateListener() {
        final StateFlow<ConfigState> configState$superwall_release = getDependencyContainer$superwall_release().getConfigManager().getConfigState$superwall_release();
        return new Flow<ConfigurationStatus>() { // from class: com.superwall.sdk.Superwall$special$$inlined$map$1

            /* JADX INFO: renamed from: com.superwall.sdk.Superwall$special$$inlined$map$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: com.superwall.sdk.Superwall$special$$inlined$map$1$2$1, reason: invalid class name */
                @Metadata
                @DebugMetadata(c = "com.superwall.sdk.Superwall$special$$inlined$map$1$2", f = "Superwall.kt", l = {50}, m = "emit")
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
                        boolean r0 = r6 instanceof com.superwall.sdk.Superwall$special$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r6
                        com.superwall.sdk.Superwall$special$$inlined$map$1$2$1 r0 = (com.superwall.sdk.Superwall$special$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.superwall.sdk.Superwall$special$$inlined$map$1$2$1 r0 = new com.superwall.sdk.Superwall$special$$inlined$map$1$2$1
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        kotlin.ResultKt.b(r6)
                        goto L51
                    L29:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L31:
                        kotlin.ResultKt.b(r6)
                        kotlinx.coroutines.flow.FlowCollector r6 = r4.$this_unsafeFlow
                        com.superwall.sdk.config.models.ConfigState r5 = (com.superwall.sdk.config.models.ConfigState) r5
                        boolean r2 = r5 instanceof com.superwall.sdk.config.models.ConfigState.Retrieved
                        if (r2 == 0) goto L3f
                        com.superwall.sdk.config.models.ConfigurationStatus$Configured r5 = com.superwall.sdk.config.models.ConfigurationStatus.Configured.INSTANCE
                        goto L48
                    L3f:
                        boolean r5 = r5 instanceof com.superwall.sdk.config.models.ConfigState.Failed
                        if (r5 == 0) goto L46
                        com.superwall.sdk.config.models.ConfigurationStatus$Failed r5 = com.superwall.sdk.config.models.ConfigurationStatus.Failed.INSTANCE
                        goto L48
                    L46:
                        com.superwall.sdk.config.models.ConfigurationStatus$Pending r5 = com.superwall.sdk.config.models.ConfigurationStatus.Pending.INSTANCE
                    L48:
                        r0.label = r3
                        java.lang.Object r5 = r6.emit(r5, r0)
                        if (r5 != r1) goto L51
                        return r1
                    L51:
                        kotlin.Unit r5 = kotlin.Unit.f139807a
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.Superwall$special$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector flowCollector, Continuation continuation) {
                Object objCollect = configState$superwall_release.collect(new AnonymousClass2(flowCollector), continuation);
                return objCollect == IntrinsicsKt.f() ? objCollect : Unit.f139807a;
            }
        };
    }

    public final Context getContext$superwall_release() {
        return this.context;
    }

    /* JADX INFO: renamed from: getCustomerInfo, reason: collision with other method in class */
    public final StateFlow<CustomerInfo> m1255getCustomerInfo() {
        return this._customerInfo;
    }

    public final SuperwallDelegate getDelegate() {
        return getDependencyContainer$superwall_release().getDelegateAdapter().getKotlinDelegate();
    }

    public final DependencyContainer getDependencyContainer$superwall_release() {
        DependencyContainer dependencyContainer = this._dependencyContainer;
        if (dependencyContainer != null) {
            return dependencyContainer;
        }
        Intrinsics.throwUninitializedPropertyAccessException("_dependencyContainer");
        return null;
    }

    public final Entitlements getEntitlements() {
        return (Entitlements) this.entitlements$delegate.getValue();
    }

    public final EventTrackingBehavior getEventTrackingBehavior() {
        return getOptions().getEventTrackingBehavior();
    }

    public final String getExternalAccountId() {
        return getDependencyContainer$superwall_release().getIdentityManager().getExternalAccountId();
    }

    public final Map<String, String> getIntegrationAttributes() {
        return getDependencyContainer$superwall_release().getAttributionManager$superwall_release().getIntegrationAttributes();
    }

    public final IOScope getIoScope$superwall_release() {
        return getDependencyContainer$superwall_release().ioScope();
    }

    public final PaywallInfo getLatestPaywallInfo() {
        PaywallView currentView = getDependencyContainer$superwall_release().getPaywallManager().getCurrentView();
        PaywallInfo info = currentView != null ? currentView.getInfo() : null;
        return info == null ? this.presentationItems.getPaywallInfo() : info;
    }

    public final Map<String, PaywallResource> getLocalResources() {
        return this.localResources;
    }

    public final String getLocaleIdentifier() {
        return getDependencyContainer$superwall_release().getConfigManager().getOptions().getLocaleIdentifier();
    }

    public final LogLevel getLogLevel() {
        return getOptions().getLogging().getLevel();
    }

    public final MainScope getMainScope$superwall_release() {
        return getDependencyContainer$superwall_release().mainScope();
    }

    public final SuperwallOptions getOptions() {
        return getDependencyContainer$superwall_release().getConfigManager().getOptions();
    }

    public final Map<String, String> getOverrideProductsByName() {
        return getOptions().getPaywalls().getOverrideProductsByName();
    }

    public final PaywallView getPaywallView() {
        return getDependencyContainer$superwall_release().getPaywallManager().getCurrentView();
    }

    public final SharedFlow<SuperwallEventInfo> getPlacements() {
        return this.placements;
    }

    public final PresentationItems getPresentationItems$superwall_release() {
        return this.presentationItems;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /* JADX INFO: renamed from: getProducts-gIAlu-s, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object m1248getProductsgIAlus(java.lang.String[] r8, kotlin.coroutines.Continuation<? super kotlin.Result<? extends java.util.Map<java.lang.String, com.superwall.sdk.store.abstractions.product.StoreProduct>>> r9) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r9 instanceof com.superwall.sdk.Superwall$getProducts$1
            if (r0 == 0) goto L14
            r0 = r9
            com.superwall.sdk.Superwall$getProducts$1 r0 = (com.superwall.sdk.Superwall$getProducts$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.label = r1
        L12:
            r4 = r0
            goto L1a
        L14:
            com.superwall.sdk.Superwall$getProducts$1 r0 = new com.superwall.sdk.Superwall$getProducts$1
            r0.<init>(r7, r9)
            goto L12
        L1a:
            java.lang.Object r9 = r4.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r4.label
            r2 = 1
            if (r1 == 0) goto L36
            if (r1 != r2) goto L2e
            kotlin.ResultKt.b(r9)     // Catch: java.lang.Throwable -> L2b
            goto L52
        L2b:
            r0 = move-exception
            r8 = r0
            goto L5a
        L2e:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L36:
            kotlin.ResultKt.b(r9)
            com.superwall.sdk.dependencies.DependencyContainer r9 = r7.getDependencyContainer$superwall_release()     // Catch: java.lang.Throwable -> L2b
            com.superwall.sdk.store.StoreManager r1 = r9.getStoreManager()     // Catch: java.lang.Throwable -> L2b
            java.util.List r8 = kotlin.collections.ArraysKt.toList(r8)     // Catch: java.lang.Throwable -> L2b
            r4.label = r2     // Catch: java.lang.Throwable -> L2b
            r3 = 0
            r5 = 2
            r6 = 0
            r2 = r8
            java.lang.Object r9 = com.superwall.sdk.store.StoreKit.DefaultImpls.getProductsWithoutPaywall$default(r1, r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L2b
            if (r9 != r0) goto L52
            return r0
        L52:
            java.util.Map r9 = (java.util.Map) r9     // Catch: java.lang.Throwable -> L2b
            com.superwall.sdk.misc.Either$Success r8 = new com.superwall.sdk.misc.Either$Success     // Catch: java.lang.Throwable -> L2b
            r8.<init>(r9)     // Catch: java.lang.Throwable -> L2b
            goto L75
        L5a:
            boolean r9 = com.superwall.sdk.utilities.ErrorTrackingKt.shouldLog(r8)
            if (r9 == 0) goto L6f
            com.superwall.sdk.Superwall$Companion r9 = com.superwall.sdk.Superwall.Companion
            boolean r0 = r9.getInitialized()
            if (r0 == 0) goto L6f
            com.superwall.sdk.Superwall r9 = r9.getInstance()
            com.superwall.sdk.utilities.ErrorTrackingKt.trackError(r9, r8)
        L6f:
            com.superwall.sdk.misc.Either$Failure r9 = new com.superwall.sdk.misc.Either$Failure
            r9.<init>(r8)
            r8 = r9
        L75:
            boolean r9 = r8 instanceof com.superwall.sdk.misc.Either.Success
            if (r9 == 0) goto L87
            kotlin.Result$Companion r9 = kotlin.Result.f139772b
            com.superwall.sdk.misc.Either$Success r8 = (com.superwall.sdk.misc.Either.Success) r8
            java.lang.Object r8 = r8.getValue()
            java.lang.Object r8 = kotlin.Result.b(r8)
            goto L9b
        L87:
            boolean r9 = r8 instanceof com.superwall.sdk.misc.Either.Failure
            if (r9 == 0) goto L9c
            kotlin.Result$Companion r9 = kotlin.Result.f139772b
            com.superwall.sdk.misc.Either$Failure r8 = (com.superwall.sdk.misc.Either.Failure) r8
            java.lang.Throwable r8 = r8.getError()
            java.lang.Object r8 = kotlin.ResultKt.a(r8)
            java.lang.Object r8 = kotlin.Result.b(r8)
        L9b:
            return r8
        L9c:
            kotlin.NoWhenBranchMatchedException r8 = new kotlin.NoWhenBranchMatchedException
            r8.<init>()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.Superwall.m1248getProductsgIAlus(java.lang.String[], kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final SerialTaskManager getSerialTaskManager$superwall_release() {
        return this.serialTaskManager;
    }

    public final StateFlow<SubscriptionStatus> getSubscriptionStatus() {
        return (StateFlow) this.subscriptionStatus$delegate.getValue();
    }

    public final Map<String, Object> getUserAttributes() {
        return getDependencyContainer$superwall_release().getIdentityManager().getUserAttributes();
    }

    public final String getUserId() {
        return getDependencyContainer$superwall_release().getIdentityManager().getUserId();
    }

    /* JADX INFO: renamed from: getVendorId-6xTLGo0$superwall_release, reason: not valid java name */
    public final String m1249getVendorId6xTLGo0$superwall_release() {
        return VendorId.m1285constructorimpl(getDependencyContainer$superwall_release().getDeviceHelper().getVendorId());
    }

    public final MutableStateFlow<CustomerInfo> get_customerInfo$superwall_release() {
        return this._customerInfo;
    }

    /* JADX INFO: renamed from: handleDeepLink-IoAF18A, reason: not valid java name */
    public final Object m1250handleDeepLinkIoAF18A(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return DeepLinkRouter.Companion.m1269handleDeepLinkIoAF18A(uri);
    }

    public final void internallySetSubscriptionStatus$superwall_release(SubscriptionStatus toStatus) {
        Intrinsics.checkNotNullParameter(toStatus, "toStatus");
        if (getDependencyContainer$superwall_release().makeHasExternalPurchaseController() || getDependencyContainer$superwall_release().getTestMode$superwall_release().isTestMode()) {
            return;
        }
        Set<Entitlement> web = getDependencyContainer$superwall_release().getEntitlements().getWeb();
        if (toStatus instanceof SubscriptionStatus.Active) {
            Set setPlus = SetsKt.plus((Set) ((SubscriptionStatus.Active) toStatus).getEntitlements(), (Iterable) web);
            if (setPlus.isEmpty()) {
                getEntitlements().setSubscriptionStatus(SubscriptionStatus.Inactive.INSTANCE);
                return;
            } else {
                getEntitlements().setSubscriptionStatus(new SubscriptionStatus.Active(setPlus));
                return;
            }
        }
        SubscriptionStatus.Inactive inactive = SubscriptionStatus.Inactive.INSTANCE;
        if (Intrinsics.areEqual(toStatus, inactive)) {
            if (web.isEmpty()) {
                getEntitlements().setSubscriptionStatus(inactive);
                return;
            } else {
                getEntitlements().setSubscriptionStatus(new SubscriptionStatus.Active(web));
                return;
            }
        }
        SubscriptionStatus.Unknown unknown = SubscriptionStatus.Unknown.INSTANCE;
        if (!Intrinsics.areEqual(toStatus, unknown)) {
            throw new NoWhenBranchMatchedException();
        }
        getEntitlements().setSubscriptionStatus(unknown);
    }

    public final boolean isLoggedIn() {
        return getDependencyContainer$superwall_release().getIdentityManager().isLoggedIn();
    }

    public final boolean isPaywallPresented() {
        return getPaywallView() != null;
    }

    public final void observe(PurchasingObserverState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        ScopesKt.launchWithTracking(getIoScope$superwall_release(), new C27661(state, null));
    }

    public final void observePurchaseError(ProductDetails product, Throwable error) {
        Intrinsics.checkNotNullParameter(product, "product");
        Intrinsics.checkNotNullParameter(error, "error");
        observe(new PurchasingObserverState.PurchaseError(product, error));
    }

    public final void observePurchaseResult(BillingResult billingResult, List<? extends Purchase> purchases) {
        Intrinsics.checkNotNullParameter(billingResult, "billingResult");
        Intrinsics.checkNotNullParameter(purchases, "purchases");
        observe(new PurchasingObserverState.PurchaseResult(billingResult, purchases));
    }

    public final void observePurchaseStart(ProductDetails product) {
        Intrinsics.checkNotNullParameter(product, "product");
        observe(new PurchasingObserverState.PurchaseWillBegin(product));
    }

    public final void preloadAllPaywalls() {
        ScopesKt.launchWithTracking(getIoScope$superwall_release(), new C27671(null));
    }

    public final void preloadPaywalls(Set<String> placementNames) {
        Intrinsics.checkNotNullParameter(placementNames, "placementNames");
        ScopesKt.launchWithTracking(getIoScope$superwall_release(), new C27681(placementNames, null));
    }

    public final void purchase(StoreProduct product, Function1<? super Result<? extends PurchaseResult>, Unit> onFinished) {
        Intrinsics.checkNotNullParameter(product, "product");
        Intrinsics.checkNotNullParameter(onFinished, "onFinished");
        BuildersKt__Builders_commonKt.d(getIoScope$superwall_release(), null, null, new AnonymousClass7(onFinished, this, product, null), 3, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX INFO: renamed from: purchase-gIAlu-s, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object m1251purchasegIAlus(com.android.billingclient.api.ProductDetails r7, kotlin.coroutines.Continuation<? super kotlin.Result<? extends com.superwall.sdk.delegate.PurchaseResult>> r8) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.superwall.sdk.Superwall.C27691
            if (r0 == 0) goto L13
            r0 = r8
            com.superwall.sdk.Superwall$purchase$1 r0 = (com.superwall.sdk.Superwall.C27691) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.superwall.sdk.Superwall$purchase$1 r0 = new com.superwall.sdk.Superwall$purchase$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            kotlin.ResultKt.b(r8)     // Catch: java.lang.Throwable -> L29
            goto L57
        L29:
            r7 = move-exception
            goto L5f
        L2b:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L33:
            kotlin.ResultKt.b(r8)
            com.superwall.sdk.dependencies.DependencyContainer r8 = r6.getDependencyContainer$superwall_release()     // Catch: java.lang.Throwable -> L29
            com.superwall.sdk.store.transactions.TransactionManager r8 = r8.getTransactionManager()     // Catch: java.lang.Throwable -> L29
            com.superwall.sdk.store.transactions.TransactionManager$PurchaseSource$ExternalPurchase r2 = new com.superwall.sdk.store.transactions.TransactionManager$PurchaseSource$ExternalPurchase     // Catch: java.lang.Throwable -> L29
            com.superwall.sdk.store.abstractions.product.StoreProduct r4 = new com.superwall.sdk.store.abstractions.product.StoreProduct     // Catch: java.lang.Throwable -> L29
            com.superwall.sdk.store.abstractions.product.RawStoreProduct$Companion r5 = com.superwall.sdk.store.abstractions.product.RawStoreProduct.Companion     // Catch: java.lang.Throwable -> L29
            com.superwall.sdk.store.abstractions.product.RawStoreProduct r7 = r5.from(r7)     // Catch: java.lang.Throwable -> L29
            r4.<init>(r7)     // Catch: java.lang.Throwable -> L29
            r2.<init>(r4)     // Catch: java.lang.Throwable -> L29
            r0.label = r3     // Catch: java.lang.Throwable -> L29
            java.lang.Object r8 = r8.purchase(r2, r3, r0)     // Catch: java.lang.Throwable -> L29
            if (r8 != r1) goto L57
            return r1
        L57:
            com.superwall.sdk.delegate.PurchaseResult r8 = (com.superwall.sdk.delegate.PurchaseResult) r8     // Catch: java.lang.Throwable -> L29
            com.superwall.sdk.misc.Either$Success r7 = new com.superwall.sdk.misc.Either$Success     // Catch: java.lang.Throwable -> L29
            r7.<init>(r8)     // Catch: java.lang.Throwable -> L29
            goto L7a
        L5f:
            boolean r8 = com.superwall.sdk.utilities.ErrorTrackingKt.shouldLog(r7)
            if (r8 == 0) goto L74
            com.superwall.sdk.Superwall$Companion r8 = com.superwall.sdk.Superwall.Companion
            boolean r0 = r8.getInitialized()
            if (r0 == 0) goto L74
            com.superwall.sdk.Superwall r8 = r8.getInstance()
            com.superwall.sdk.utilities.ErrorTrackingKt.trackError(r8, r7)
        L74:
            com.superwall.sdk.misc.Either$Failure r8 = new com.superwall.sdk.misc.Either$Failure
            r8.<init>(r7)
            r7 = r8
        L7a:
            boolean r8 = r7 instanceof com.superwall.sdk.misc.Either.Success
            if (r8 == 0) goto L8c
            kotlin.Result$Companion r8 = kotlin.Result.f139772b
            com.superwall.sdk.misc.Either$Success r7 = (com.superwall.sdk.misc.Either.Success) r7
            java.lang.Object r7 = r7.getValue()
            java.lang.Object r7 = kotlin.Result.b(r7)
            goto La0
        L8c:
            boolean r8 = r7 instanceof com.superwall.sdk.misc.Either.Failure
            if (r8 == 0) goto La1
            kotlin.Result$Companion r8 = kotlin.Result.f139772b
            com.superwall.sdk.misc.Either$Failure r7 = (com.superwall.sdk.misc.Either.Failure) r7
            java.lang.Throwable r7 = r7.getError()
            java.lang.Object r7 = kotlin.ResultKt.a(r7)
            java.lang.Object r7 = kotlin.Result.b(r7)
        La0:
            return r7
        La1:
            kotlin.NoWhenBranchMatchedException r7 = new kotlin.NoWhenBranchMatchedException
            r7.<init>()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.Superwall.m1251purchasegIAlus(com.android.billingclient.api.ProductDetails, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void redeem$superwall_release(String code) {
        Intrinsics.checkNotNullParameter(code, "code");
        BuildersKt__Builders_commonKt.d(getIoScope$superwall_release(), null, null, new Superwall$redeem$1(this, code, null), 3, null);
    }

    public final void refreshConfiguration() {
        BuildersKt__Builders_commonKt.d(getIoScope$superwall_release(), null, null, new C27711(null), 3, null);
    }

    public final void reset() {
        try {
            reset$superwall_release(false);
            new Either.Success(Unit.f139807a);
        } catch (Throwable th) {
            if (ErrorTrackingKt.shouldLog(th)) {
                Companion companion = Companion;
                if (companion.getInitialized()) {
                    ErrorTrackingKt.trackError(companion.getInstance(), th);
                }
            }
            new Either.Failure(th);
        }
    }

    public final void reset$superwall_release(boolean z2) {
        Object objD;
        try {
            if (z2) {
                getDependencyContainer$superwall_release().getStorage().reset();
                getDependencyContainer$superwall_release().getPaywallManager().resetCache();
                this.presentationItems.reset();
                getDependencyContainer$superwall_release().getConfigManager().reset();
                getDependencyContainer$superwall_release().getReedemer().clear(RedemptionOwnershipType.AppUser);
                objD = BuildersKt__Builders_commonKt.d(getIoScope$superwall_release(), null, null, new Superwall$reset$2$1(this, null), 3, null);
            } else {
                getDependencyContainer$superwall_release().getIdentityManager().reset();
                objD = Unit.f139807a;
            }
            new Either.Success(objD);
        } catch (Throwable th) {
            if (ErrorTrackingKt.shouldLog(th)) {
                Companion companion = Companion;
                if (companion.getInitialized()) {
                    ErrorTrackingKt.trackError(companion.getInstance(), th);
                }
            }
            new Either.Failure(th);
        }
    }

    public final Job restorePurchases(Function1<? super Result<? extends RestorationResult>, Unit> onFinished) {
        Intrinsics.checkNotNullParameter(onFinished, "onFinished");
        return BuildersKt__Builders_commonKt.d(getIoScope$superwall_release(), null, null, new C27733(onFinished, this, null), 3, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX INFO: renamed from: restorePurchases-IoAF18A, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object m1254restorePurchasesIoAF18A(kotlin.coroutines.Continuation<? super kotlin.Result<? extends com.superwall.sdk.delegate.RestorationResult>> r5) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.superwall.sdk.Superwall.C27721
            if (r0 == 0) goto L13
            r0 = r5
            com.superwall.sdk.Superwall$restorePurchases$1 r0 = (com.superwall.sdk.Superwall.C27721) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.superwall.sdk.Superwall$restorePurchases$1 r0 = new com.superwall.sdk.Superwall$restorePurchases$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            kotlin.ResultKt.b(r5)     // Catch: java.lang.Throwable -> L29
            goto L48
        L29:
            r5 = move-exception
            goto L50
        L2b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L33:
            kotlin.ResultKt.b(r5)
            com.superwall.sdk.dependencies.DependencyContainer r5 = r4.getDependencyContainer$superwall_release()     // Catch: java.lang.Throwable -> L29
            com.superwall.sdk.store.transactions.TransactionManager r5 = r5.getTransactionManager()     // Catch: java.lang.Throwable -> L29
            r0.label = r3     // Catch: java.lang.Throwable -> L29
            r2 = 0
            java.lang.Object r5 = r5.tryToRestorePurchases(r2, r0)     // Catch: java.lang.Throwable -> L29
            if (r5 != r1) goto L48
            return r1
        L48:
            com.superwall.sdk.delegate.RestorationResult r5 = (com.superwall.sdk.delegate.RestorationResult) r5     // Catch: java.lang.Throwable -> L29
            com.superwall.sdk.misc.Either$Success r0 = new com.superwall.sdk.misc.Either$Success     // Catch: java.lang.Throwable -> L29
            r0.<init>(r5)     // Catch: java.lang.Throwable -> L29
            goto L6a
        L50:
            boolean r0 = com.superwall.sdk.utilities.ErrorTrackingKt.shouldLog(r5)
            if (r0 == 0) goto L65
            com.superwall.sdk.Superwall$Companion r0 = com.superwall.sdk.Superwall.Companion
            boolean r1 = r0.getInitialized()
            if (r1 == 0) goto L65
            com.superwall.sdk.Superwall r0 = r0.getInstance()
            com.superwall.sdk.utilities.ErrorTrackingKt.trackError(r0, r5)
        L65:
            com.superwall.sdk.misc.Either$Failure r0 = new com.superwall.sdk.misc.Either$Failure
            r0.<init>(r5)
        L6a:
            boolean r5 = r0 instanceof com.superwall.sdk.misc.Either.Success
            if (r5 == 0) goto L7b
            kotlin.Result$Companion r5 = kotlin.Result.f139772b
            com.superwall.sdk.misc.Either$Success r0 = (com.superwall.sdk.misc.Either.Success) r0
            java.lang.Object r5 = r0.getValue()
            java.lang.Object r5 = kotlin.Result.b(r5)
            goto L8f
        L7b:
            boolean r5 = r0 instanceof com.superwall.sdk.misc.Either.Failure
            if (r5 == 0) goto L90
            kotlin.Result$Companion r5 = kotlin.Result.f139772b
            com.superwall.sdk.misc.Either$Failure r0 = (com.superwall.sdk.misc.Either.Failure) r0
            java.lang.Throwable r5 = r0.getError()
            java.lang.Object r5 = kotlin.ResultKt.a(r5)
            java.lang.Object r5 = kotlin.Result.b(r5)
        L8f:
            return r5
        L90:
            kotlin.NoWhenBranchMatchedException r5 = new kotlin.NoWhenBranchMatchedException
            r5.<init>()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.Superwall.m1254restorePurchasesIoAF18A(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void setContext$superwall_release(Context context) {
        Intrinsics.checkNotNullParameter(context, "<set-?>");
        this.context = context;
    }

    public final void setDelegate(SuperwallDelegate superwallDelegate) {
        getDependencyContainer$superwall_release().getDelegateAdapter().setKotlinDelegate(superwallDelegate);
        BuildersKt__Builders_commonKt.d(getIoScope$superwall_release(), null, null, new Superwall$delegate$1(this, null), 3, null);
    }

    public final void setEventTrackingBehavior(EventTrackingBehavior newValue) {
        Intrinsics.checkNotNullParameter(newValue, "newValue");
        getOptions().setEventTrackingBehavior(newValue);
        getDependencyContainer$superwall_release().getEventsQueue().setTrackingBehavior(newValue);
        BuildersKt__Builders_commonKt.d(getMainScope$superwall_release(), null, null, new Superwall$eventTrackingBehavior$1(this, newValue, null), 3, null);
        if (newValue == EventTrackingBehavior.NONE) {
            return;
        }
        BuildersKt__Builders_commonKt.d(getIoScope$superwall_release(), null, null, new Superwall$eventTrackingBehavior$2(this, null), 3, null);
    }

    public final void setIntegrationAttributes(Map<AttributionProvider, String> attributes) {
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        getDependencyContainer$superwall_release().getAttributionManager$superwall_release().setIntegrationAttributes(attributes);
    }

    public final void setInterfaceStyle(InterfaceStyle interfaceStyle) {
        try {
            getDependencyContainer$superwall_release().getDeviceHelper().setInterfaceStyleOverride(interfaceStyle);
            new Either.Success(BuildersKt__Builders_commonKt.d(getIoScope$superwall_release(), null, null, new Superwall$setInterfaceStyle$1$1(this, null), 3, null));
        } catch (Throwable th) {
            if (ErrorTrackingKt.shouldLog(th)) {
                Companion companion = Companion;
                if (companion.getInitialized()) {
                    ErrorTrackingKt.trackError(companion.getInstance(), th);
                }
            }
            new Either.Failure(th);
        }
    }

    public final void setLocalResources(Map<String, ? extends PaywallResource> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.localResources = map;
    }

    public final void setLocaleIdentifier(String str) {
        getDependencyContainer$superwall_release().getConfigManager().getOptions().setLocaleIdentifier(str);
        BuildersKt__Builders_commonKt.d(getIoScope$superwall_release(), null, null, new Superwall$localeIdentifier$1(this, null), 3, null);
    }

    public final void setLogLevel(LogLevel newValue) {
        Intrinsics.checkNotNullParameter(newValue, "newValue");
        getOptions().getLogging().setLevel(newValue);
        BuildersKt__Builders_commonKt.d(getIoScope$superwall_release(), null, null, new Superwall$logLevel$1(this, null), 3, null);
    }

    public final void setOverrideProductsByName(Map<String, String> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        getOptions().getPaywalls().setOverrideProductsByName(value);
    }

    public final void setPlatformWrapper(String wrapper, String version) {
        Intrinsics.checkNotNullParameter(wrapper, "wrapper");
        Intrinsics.checkNotNullParameter(version, "version");
        try {
            getDependencyContainer$superwall_release().getDeviceHelper().setPlatformWrapper(wrapper);
            getDependencyContainer$superwall_release().getDeviceHelper().setPlatformWrapperVersion(version);
            new Either.Success(BuildersKt__Builders_commonKt.d(getIoScope$superwall_release(), null, null, new Superwall$setPlatformWrapper$1$1(this, null), 3, null));
        } catch (Throwable th) {
            if (ErrorTrackingKt.shouldLog(th)) {
                Companion companion = Companion;
                if (companion.getInitialized()) {
                    ErrorTrackingKt.trackError(companion.getInstance(), th);
                }
            }
            new Either.Failure(th);
        }
    }

    public final void setSubscriptionStatus(SubscriptionStatus subscriptionStatus) {
        Intrinsics.checkNotNullParameter(subscriptionStatus, "subscriptionStatus");
        if (getDependencyContainer$superwall_release().getTestMode$superwall_release().isTestMode()) {
            Logger.debug$default(Logger.INSTANCE, LogLevel.warn, LogScope.superwallCore, "setSubscriptionStatus ignored: test mode is active", (Map) null, (Throwable) null, 24, (Object) null);
        } else {
            getEntitlements().setSubscriptionStatus(subscriptionStatus);
        }
    }

    public final Either<Unit, Throwable> setup$superwall_release() {
        Either<Unit, Throwable> failure;
        synchronized (this) {
            try {
                try {
                    this._dependencyContainer = new DependencyContainer(this.context, this.purchaseController, this._options, this.activityProvider, this.apiKey);
                    getDependencyContainer$superwall_release().getStorage().configure(this.apiKey);
                    SubscriptionStatus subscriptionStatus = (SubscriptionStatus) getDependencyContainer$superwall_release().getStorage().read(StoredSubscriptionStatus.INSTANCE);
                    if (subscriptionStatus == null) {
                        subscriptionStatus = SubscriptionStatus.Unknown.INSTANCE;
                    }
                    MutableStateFlow<CustomerInfo> mutableStateFlow = this._customerInfo;
                    CustomerInfo customerInfoEmpty = (CustomerInfo) getDependencyContainer$superwall_release().getStorage().read(LatestCustomerInfo.INSTANCE);
                    if (customerInfoEmpty == null) {
                        customerInfoEmpty = CustomerInfo.Companion.empty();
                    }
                    mutableStateFlow.setValue(customerInfoEmpty);
                    setSubscriptionStatus(subscriptionStatus);
                    getDependencyContainer$superwall_release().getCustomerInfoManager$superwall_release().updateMergedCustomerInfo();
                    addListeners();
                    BuildersKt__Builders_commonKt.d(getIoScope$superwall_release(), null, null, new Superwall$setup$1$1$1(this, null), 3, null);
                    failure = new Either.Success<>(Unit.f139807a);
                } catch (Exception e3) {
                    e3.printStackTrace();
                    throw e3;
                }
            } catch (Throwable th) {
                try {
                    if (ErrorTrackingKt.shouldLog(th)) {
                        Companion companion = Companion;
                        if (companion.getInitialized()) {
                            ErrorTrackingKt.trackError(companion.getInstance(), th);
                        }
                    }
                    failure = new Either.Failure<>(th);
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return failure;
    }

    public final void showAlert(String str, String str2, String str3, String closeActionTitle, Function0<Unit> function0, Function0<Unit> function02) {
        Intrinsics.checkNotNullParameter(closeActionTitle, "closeActionTitle");
        PaywallView paywallView = getPaywallView();
        if (paywallView != null) {
            paywallView.showAlert(str, str2, str3, closeActionTitle, function0, function02);
        }
    }

    public final void teardown$superwall_release() {
        try {
            reset$superwall_release(false);
            getDependencyContainer$superwall_release().getPaywallRequestManager().resetCache$superwall_release();
            ComponentCallbacks2 componentCallbacks2 = this.configurationChangeListener;
            Unit unit = null;
            if (componentCallbacks2 != null) {
                this.context.getApplicationContext().unregisterComponentCallbacks(componentCallbacks2);
                this.configurationChangeListener = null;
                unit = Unit.f139807a;
            }
            new Either.Success(unit);
        } catch (Throwable th) {
            if (ErrorTrackingKt.shouldLog(th)) {
                Companion companion = Companion;
                if (companion.getInitialized()) {
                    ErrorTrackingKt.trackError(companion.getInstance(), th);
                }
            }
            new Either.Failure(th);
        }
    }

    public final void togglePaywallSpinner(boolean z2) {
        ScopesKt.launchWithTracking(getIoScope$superwall_release(), new C27741(z2, null));
    }

    @JvmStatic
    public static final void configure(Application application, String str, PurchaseController purchaseController) {
        Companion.configure(application, str, purchaseController);
    }

    public final CustomerInfo getCustomerInfo() {
        return (CustomerInfo) this._customerInfo.getValue();
    }

    /* JADX INFO: renamed from: getDelegate, reason: collision with other method in class */
    public final SuperwallDelegateJava m1256getDelegate() {
        return getDependencyContainer$superwall_release().getDelegateAdapter().getJavaDelegate();
    }

    public final void purchase(ProductDetails product, Function1<? super Result<? extends PurchaseResult>, Unit> onFinished) {
        Intrinsics.checkNotNullParameter(product, "product");
        Intrinsics.checkNotNullParameter(onFinished, "onFinished");
        BuildersKt__Builders_commonKt.d(getIoScope$superwall_release(), null, null, new AnonymousClass8(onFinished, this, product, null), 3, null);
    }

    @JvmStatic
    public static final void configure(Application application, String str, PurchaseController purchaseController, SuperwallOptions superwallOptions) {
        Companion.configure(application, str, purchaseController, superwallOptions);
    }

    public final void purchase(String productId, Function1<? super Result<? extends PurchaseResult>, Unit> onFinished) {
        Intrinsics.checkNotNullParameter(productId, "productId");
        Intrinsics.checkNotNullParameter(onFinished, "onFinished");
        BuildersKt__Builders_commonKt.d(getIoScope$superwall_release(), null, null, new AnonymousClass9(onFinished, this, productId, null), 3, null);
    }

    public final void setDelegate(SuperwallDelegateJava superwallDelegateJava) {
        try {
            getDependencyContainer$superwall_release().getDelegateAdapter().setJavaDelegate(superwallDelegateJava);
            new Either.Success(BuildersKt__Builders_commonKt.d(getIoScope$superwall_release(), null, null, new Superwall$setJavaDelegate$1$1(this, null), 3, null));
        } catch (Throwable th) {
            if (ErrorTrackingKt.shouldLog(th)) {
                Companion companion = Companion;
                if (companion.getInitialized()) {
                    ErrorTrackingKt.trackError(companion.getInstance(), th);
                }
            }
            new Either.Failure(th);
        }
    }

    @JvmStatic
    public static final void configure(Application application, String str, PurchaseController purchaseController, SuperwallOptions superwallOptions, ActivityProvider activityProvider) {
        Companion.configure(application, str, purchaseController, superwallOptions, activityProvider);
    }

    @JvmStatic
    public static final void configure(Application application, String str, PurchaseController purchaseController, SuperwallOptions superwallOptions, ActivityProvider activityProvider, Function1<? super Result<Unit>, Unit> function1) {
        Companion.configure(application, str, purchaseController, superwallOptions, activityProvider, function1);
    }

    public final void setSubscriptionStatus(String... entitlements) {
        Intrinsics.checkNotNullParameter(entitlements, "entitlements");
        if (getDependencyContainer$superwall_release().getTestMode$superwall_release().isTestMode()) {
            Logger.debug$default(Logger.INSTANCE, LogLevel.warn, LogScope.superwallCore, "setSubscriptionStatus ignored: test mode is active", (Map) null, (Throwable) null, 24, (Object) null);
            return;
        }
        if (entitlements.length == 0) {
            getEntitlements().setSubscriptionStatus(SubscriptionStatus.Inactive.INSTANCE);
            return;
        }
        Entitlements entitlements2 = getEntitlements();
        ArrayList arrayList = new ArrayList(entitlements.length);
        for (String str : entitlements) {
            arrayList.add(new Entitlement(str));
        }
        entitlements2.setSubscriptionStatus(new SubscriptionStatus.Active(CollectionsKt.toSet(arrayList)));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX INFO: renamed from: purchase-gIAlu-s, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object m1252purchasegIAlus(com.superwall.sdk.store.abstractions.product.StoreProduct r5, kotlin.coroutines.Continuation<? super kotlin.Result<? extends com.superwall.sdk.delegate.PurchaseResult>> r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.superwall.sdk.Superwall.C27703
            if (r0 == 0) goto L13
            r0 = r6
            com.superwall.sdk.Superwall$purchase$3 r0 = (com.superwall.sdk.Superwall.C27703) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.superwall.sdk.Superwall$purchase$3 r0 = new com.superwall.sdk.Superwall$purchase$3
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            kotlin.ResultKt.b(r6)     // Catch: java.lang.Throwable -> L29
            goto L4c
        L29:
            r5 = move-exception
            goto L54
        L2b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L33:
            kotlin.ResultKt.b(r6)
            com.superwall.sdk.dependencies.DependencyContainer r6 = r4.getDependencyContainer$superwall_release()     // Catch: java.lang.Throwable -> L29
            com.superwall.sdk.store.transactions.TransactionManager r6 = r6.getTransactionManager()     // Catch: java.lang.Throwable -> L29
            com.superwall.sdk.store.transactions.TransactionManager$PurchaseSource$ExternalPurchase r2 = new com.superwall.sdk.store.transactions.TransactionManager$PurchaseSource$ExternalPurchase     // Catch: java.lang.Throwable -> L29
            r2.<init>(r5)     // Catch: java.lang.Throwable -> L29
            r0.label = r3     // Catch: java.lang.Throwable -> L29
            java.lang.Object r6 = r6.purchase(r2, r3, r0)     // Catch: java.lang.Throwable -> L29
            if (r6 != r1) goto L4c
            return r1
        L4c:
            com.superwall.sdk.delegate.PurchaseResult r6 = (com.superwall.sdk.delegate.PurchaseResult) r6     // Catch: java.lang.Throwable -> L29
            com.superwall.sdk.misc.Either$Success r5 = new com.superwall.sdk.misc.Either$Success     // Catch: java.lang.Throwable -> L29
            r5.<init>(r6)     // Catch: java.lang.Throwable -> L29
            goto L6f
        L54:
            boolean r6 = com.superwall.sdk.utilities.ErrorTrackingKt.shouldLog(r5)
            if (r6 == 0) goto L69
            com.superwall.sdk.Superwall$Companion r6 = com.superwall.sdk.Superwall.Companion
            boolean r0 = r6.getInitialized()
            if (r0 == 0) goto L69
            com.superwall.sdk.Superwall r6 = r6.getInstance()
            com.superwall.sdk.utilities.ErrorTrackingKt.trackError(r6, r5)
        L69:
            com.superwall.sdk.misc.Either$Failure r6 = new com.superwall.sdk.misc.Either$Failure
            r6.<init>(r5)
            r5 = r6
        L6f:
            boolean r6 = r5 instanceof com.superwall.sdk.misc.Either.Success
            if (r6 == 0) goto L81
            kotlin.Result$Companion r6 = kotlin.Result.f139772b
            com.superwall.sdk.misc.Either$Success r5 = (com.superwall.sdk.misc.Either.Success) r5
            java.lang.Object r5 = r5.getValue()
            java.lang.Object r5 = kotlin.Result.b(r5)
            goto L95
        L81:
            boolean r6 = r5 instanceof com.superwall.sdk.misc.Either.Failure
            if (r6 == 0) goto L96
            kotlin.Result$Companion r6 = kotlin.Result.f139772b
            com.superwall.sdk.misc.Either$Failure r5 = (com.superwall.sdk.misc.Either.Failure) r5
            java.lang.Throwable r5 = r5.getError()
            java.lang.Object r5 = kotlin.ResultKt.a(r5)
            java.lang.Object r5 = kotlin.Result.b(r5)
        L95:
            return r5
        L96:
            kotlin.NoWhenBranchMatchedException r5 = new kotlin.NoWhenBranchMatchedException
            r5.<init>()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.Superwall.m1252purchasegIAlus(com.superwall.sdk.store.abstractions.product.StoreProduct, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0087, code lost:
    
        if (r8 == r1) goto L31;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX INFO: renamed from: purchase-gIAlu-s, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object m1253purchasegIAlus(java.lang.String r7, kotlin.coroutines.Continuation<? super kotlin.Result<? extends com.superwall.sdk.delegate.PurchaseResult>> r8) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 248
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.Superwall.m1253purchasegIAlus(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
