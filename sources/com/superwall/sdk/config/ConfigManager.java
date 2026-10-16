package com.superwall.sdk.config;

import android.content.Context;
import com.superwall.sdk.analytics.internal.trackable.TrackableSuperwallEvent;
import com.superwall.sdk.config.ConfigContext;
import com.superwall.sdk.config.models.ConfigState;
import com.superwall.sdk.config.models.ConfigStateKt;
import com.superwall.sdk.config.options.SuperwallOptions;
import com.superwall.sdk.dependencies.DeviceHelperFactory;
import com.superwall.sdk.dependencies.DeviceInfoFactory;
import com.superwall.sdk.dependencies.HasExternalPurchaseControllerFactory;
import com.superwall.sdk.dependencies.RequestFactory;
import com.superwall.sdk.dependencies.RuleAttributesFactory;
import com.superwall.sdk.dependencies.StoreTransactionFactory;
import com.superwall.sdk.identity.IdentityManager;
import com.superwall.sdk.misc.IOScope;
import com.superwall.sdk.misc.primitives.Reducer;
import com.superwall.sdk.misc.primitives.StateActor;
import com.superwall.sdk.misc.primitives.TypedAction;
import com.superwall.sdk.models.config.Config;
import com.superwall.sdk.models.entitlements.SubscriptionStatus;
import com.superwall.sdk.models.triggers.Experiment;
import com.superwall.sdk.models.triggers.Trigger;
import com.superwall.sdk.network.AwaitUntilNetworkExistsKt;
import com.superwall.sdk.network.SuperwallAPI;
import com.superwall.sdk.network.device.DeviceHelper;
import com.superwall.sdk.paywall.manager.PaywallManager;
import com.superwall.sdk.storage.Storable;
import com.superwall.sdk.storage.Storage;
import com.superwall.sdk.store.Entitlements;
import com.superwall.sdk.store.StoreManager;
import com.superwall.sdk.store.testmode.TestMode;
import com.superwall.sdk.web.WebPaywallRedeemer;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;

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
public class ConfigManager implements ConfigContext {
    private Map<String, Trigger> _triggersByEventName;
    private final Function3<Config, Boolean, Continuation<? super Unit>, Object> activateTestMode;
    private final StateActor<ConfigContext, ConfigState> actor;
    private final Assignments assignments;
    private final Function1<Continuation<? super Unit>, Object> awaitUtilNetwork;
    private final Context context;
    private final DeviceHelper deviceHelper;
    private final Entitlements entitlements;
    private final Factory factory;
    private final Flow<Config> hasConfig;
    private final Function0<IdentityManager> identityManager;
    private final IOScope ioScope;
    private final SuperwallAPI network;
    private SuperwallOptions options;
    private final PaywallManager paywallManager;
    private final PaywallPreload paywallPreload;
    private final Function1<SubscriptionStatus, Unit> setSubscriptionStatus;
    private final Storage storage;
    private final StoreManager storeManager;
    private final TestMode testMode;
    private final Function2<TrackableSuperwallEvent, Continuation<? super Unit>, Object> tracker;
    private final Function0<WebPaywallRedeemer> webPaywallRedeemer;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: renamed from: com.superwall.sdk.config.ConfigManager$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.config.ConfigManager$1", f = "ConfigManager.kt", l = {60}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Context context, Continuation<? super AnonymousClass1> continuation) {
            super(1, continuation);
            this.$context = context;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass1(this.$context, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                Context context = this.$context;
                this.label = 1;
                if (AwaitUntilNetworkExistsKt.awaitUntilNetworkExists$default(context, 0L, this, 1, null) == objF) {
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

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: renamed from: com.superwall.sdk.config.ConfigManager$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.config.ConfigManager$2", f = "ConfigManager.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends SuspendLambda implements Function3<Config, Boolean, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(3, continuation);
        }

        public final Object invoke(Config config, boolean z2, Continuation<? super Unit> continuation) {
            return new AnonymousClass2(continuation).invokeSuspend(Unit.f139807a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return invoke((Config) obj, ((Boolean) obj2).booleanValue(), (Continuation<? super Unit>) obj3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public interface Factory extends RequestFactory, DeviceInfoFactory, RuleAttributesFactory, DeviceHelperFactory, StoreTransactionFactory, HasExternalPurchaseControllerFactory {
    }

    /* JADX INFO: renamed from: com.superwall.sdk.config.ConfigManager$getAssignments$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.config.ConfigManager", f = "ConfigManager.kt", l = {137, 138}, m = "getAssignments")
    static final class C27841 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C27841(Continuation<? super C27841> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ConfigManager.this.getAssignments(this);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.config.ConfigManager$preloadAllPaywalls$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.config.ConfigManager", f = "ConfigManager.kt", l = {142, 143}, m = "preloadAllPaywalls")
    static final class C27851 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C27851(Continuation<? super C27851> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ConfigManager.this.preloadAllPaywalls(this);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.config.ConfigManager$preloadPaywallsByNames$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.config.ConfigManager", f = "ConfigManager.kt", l = {170, 171}, m = "preloadPaywallsByNames")
    static final class C27861 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C27861(Continuation<? super C27861> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ConfigManager.this.preloadPaywallsByNames(null, this);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.config.ConfigManager$recheckPreloadIfNeeded$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.config.ConfigManager", f = "ConfigManager.kt", l = {164, 166}, m = "recheckPreloadIfNeeded")
    static final class C27871 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C27871(Continuation<? super C27871> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ConfigManager.this.recheckPreloadIfNeeded(this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ConfigManager(Context context, StoreManager storeManager, Entitlements entitlements, Storage storage, SuperwallAPI network, DeviceHelper deviceHelper, SuperwallOptions options, PaywallManager paywallManager, Function0<WebPaywallRedeemer> webPaywallRedeemer, Factory factory, Assignments assignments, PaywallPreload paywallPreload, IOScope ioScope, Function2<? super TrackableSuperwallEvent, ? super Continuation<? super Unit>, ? extends Object> tracker, TestMode testMode, Function0<IdentityManager> function0, Function1<? super SubscriptionStatus, Unit> function1, Function1<? super Continuation<? super Unit>, ? extends Object> awaitUtilNetwork, Function3<? super Config, ? super Boolean, ? super Continuation<? super Unit>, ? extends Object> activateTestMode, StateActor<ConfigContext, ConfigState> actor) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(storeManager, "storeManager");
        Intrinsics.checkNotNullParameter(entitlements, "entitlements");
        Intrinsics.checkNotNullParameter(storage, "storage");
        Intrinsics.checkNotNullParameter(network, "network");
        Intrinsics.checkNotNullParameter(deviceHelper, "deviceHelper");
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(paywallManager, "paywallManager");
        Intrinsics.checkNotNullParameter(webPaywallRedeemer, "webPaywallRedeemer");
        Intrinsics.checkNotNullParameter(factory, "factory");
        Intrinsics.checkNotNullParameter(assignments, "assignments");
        Intrinsics.checkNotNullParameter(paywallPreload, "paywallPreload");
        Intrinsics.checkNotNullParameter(ioScope, "ioScope");
        Intrinsics.checkNotNullParameter(tracker, "tracker");
        Intrinsics.checkNotNullParameter(awaitUtilNetwork, "awaitUtilNetwork");
        Intrinsics.checkNotNullParameter(activateTestMode, "activateTestMode");
        Intrinsics.checkNotNullParameter(actor, "actor");
        this.context = context;
        this.storeManager = storeManager;
        this.entitlements = entitlements;
        this.storage = storage;
        this.network = network;
        this.deviceHelper = deviceHelper;
        this.options = options;
        this.paywallManager = paywallManager;
        this.webPaywallRedeemer = webPaywallRedeemer;
        this.factory = factory;
        this.assignments = assignments;
        this.paywallPreload = paywallPreload;
        this.ioScope = ioScope;
        this.tracker = tracker;
        this.testMode = testMode;
        this.identityManager = function0;
        this.setSubscriptionStatus = function1;
        this.awaitUtilNetwork = awaitUtilNetwork;
        this.activateTestMode = activateTestMode;
        this.actor = actor;
        final StateFlow<ConfigState> state = getActor().getState();
        this.hasConfig = FlowKt.i0(new Flow<Config>() { // from class: com.superwall.sdk.config.ConfigManager$special$$inlined$mapNotNull$1

            /* JADX INFO: renamed from: com.superwall.sdk.config.ConfigManager$special$$inlined$mapNotNull$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: com.superwall.sdk.config.ConfigManager$special$$inlined$mapNotNull$1$2$1, reason: invalid class name */
                @Metadata
                @DebugMetadata(c = "com.superwall.sdk.config.ConfigManager$special$$inlined$mapNotNull$1$2", f = "ConfigManager.kt", l = {52}, m = "emit")
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
                        boolean r0 = r6 instanceof com.superwall.sdk.config.ConfigManager$special$$inlined$mapNotNull$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r6
                        com.superwall.sdk.config.ConfigManager$special$$inlined$mapNotNull$1$2$1 r0 = (com.superwall.sdk.config.ConfigManager$special$$inlined$mapNotNull$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.superwall.sdk.config.ConfigManager$special$$inlined$mapNotNull$1$2$1 r0 = new com.superwall.sdk.config.ConfigManager$special$$inlined$mapNotNull$1$2$1
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        kotlin.ResultKt.b(r6)
                        goto L47
                    L29:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L31:
                        kotlin.ResultKt.b(r6)
                        kotlinx.coroutines.flow.FlowCollector r6 = r4.$this_unsafeFlow
                        com.superwall.sdk.config.models.ConfigState r5 = (com.superwall.sdk.config.models.ConfigState) r5
                        com.superwall.sdk.models.config.Config r5 = com.superwall.sdk.config.models.ConfigStateKt.getConfig(r5)
                        if (r5 == 0) goto L47
                        r0.label = r3
                        java.lang.Object r5 = r6.emit(r5, r0)
                        if (r5 != r1) goto L47
                        return r1
                    L47:
                        kotlin.Unit r5 = kotlin.Unit.f139807a
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.config.ConfigManager$special$$inlined$mapNotNull$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector flowCollector, Continuation continuation) {
                Object objCollect = state.collect(new AnonymousClass2(flowCollector), continuation);
                return objCollect == IntrinsicsKt.f() ? objCollect : Unit.f139807a;
            }
        }, 1);
        this._triggersByEventName = new LinkedHashMap();
    }

    public static /* synthetic */ Object reevaluateTestMode$default(ConfigManager configManager, Config config, String str, String str2, Continuation continuation, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reevaluateTestMode");
        }
        if ((i3 & 1) != 0) {
            config = null;
        }
        if ((i3 & 2) != 0) {
            str = null;
        }
        if ((i3 & 4) != 0) {
            str2 = null;
        }
        return configManager.reevaluateTestMode(config, str, str2, continuation);
    }

    public static /* synthetic */ Object refreshConfiguration$superwall_release$default(ConfigManager configManager, boolean z2, Continuation continuation, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: refreshConfiguration");
        }
        if ((i3 & 1) != 0) {
            z2 = false;
        }
        return configManager.refreshConfiguration$superwall_release(z2, continuation);
    }

    public final void applyRetrievedConfigForTesting$superwall_release(Config config) {
        Intrinsics.checkNotNullParameter(config, "config");
        getActor().update(new ConfigState.Updates.SetRetrieved(config));
    }

    @Override // com.superwall.sdk.misc.primitives.BaseContext
    public void delete(Storable<?> storable) {
        ConfigContext.DefaultImpls.delete(this, storable);
    }

    @Override // com.superwall.sdk.misc.primitives.StoreContext
    public void effect(TypedAction<ConfigContext> typedAction) {
        ConfigContext.DefaultImpls.effect(this, typedAction);
    }

    public final Object fetchConfiguration(Continuation<? super Unit> continuation) {
        ConfigState configState = (ConfigState) getActor().getState().getValue();
        if ((configState instanceof ConfigState.Retrieving) || (configState instanceof ConfigState.Retrying)) {
            return Unit.f139807a;
        }
        Object objImmediate = immediate(ConfigState.Actions.FetchConfig.INSTANCE, continuation);
        return objImmediate == IntrinsicsKt.f() ? objImmediate : Unit.f139807a;
    }

    @Override // com.superwall.sdk.config.ConfigContext
    public Function3<Config, Boolean, Continuation<? super Unit>, Object> getActivateTestMode() {
        return this.activateTestMode;
    }

    @Override // com.superwall.sdk.misc.primitives.StoreContext
    public StateActor<ConfigContext, ConfigState> getActor() {
        return this.actor;
    }

    @Override // com.superwall.sdk.config.ConfigContext
    public Assignments getAssignments() {
        return this.assignments;
    }

    @Override // com.superwall.sdk.config.ConfigContext
    public Function1<Continuation<? super Unit>, Object> getAwaitUtilNetwork() {
        return this.awaitUtilNetwork;
    }

    public final Config getConfig() {
        ConfigState configState = (ConfigState) getActor().getState().getValue();
        if (configState instanceof ConfigState.Failed) {
            effect(ConfigState.Actions.FetchConfig.INSTANCE);
        }
        return ConfigStateKt.getConfig(configState);
    }

    public final StateFlow<ConfigState> getConfigState$superwall_release() {
        return getActor().getState();
    }

    @Override // com.superwall.sdk.config.ConfigContext
    public Context getContext() {
        return this.context;
    }

    @Override // com.superwall.sdk.config.ConfigContext
    public DeviceHelper getDeviceHelper() {
        return this.deviceHelper;
    }

    @Override // com.superwall.sdk.config.ConfigContext
    public Entitlements getEntitlements() {
        return this.entitlements;
    }

    @Override // com.superwall.sdk.config.ConfigContext
    public Factory getFactory() {
        return this.factory;
    }

    public final Flow<Config> getHasConfig() {
        return this.hasConfig;
    }

    @Override // com.superwall.sdk.config.ConfigContext
    public Function0<IdentityManager> getIdentityManager() {
        return this.identityManager;
    }

    @Override // com.superwall.sdk.config.ConfigContext
    public SuperwallAPI getNetwork() {
        return this.network;
    }

    @Override // com.superwall.sdk.config.ConfigContext
    public SuperwallOptions getOptions() {
        return this.options;
    }

    @Override // com.superwall.sdk.config.ConfigContext
    public PaywallManager getPaywallManager() {
        return this.paywallManager;
    }

    @Override // com.superwall.sdk.config.ConfigContext
    public PaywallPreload getPaywallPreload() {
        return this.paywallPreload;
    }

    @Override // com.superwall.sdk.misc.primitives.StoreContext
    public CoroutineScope getScope() {
        return this.ioScope;
    }

    @Override // com.superwall.sdk.config.ConfigContext
    public Function1<SubscriptionStatus, Unit> getSetSubscriptionStatus() {
        return this.setSubscriptionStatus;
    }

    @Override // com.superwall.sdk.misc.primitives.StoreContext, com.superwall.sdk.misc.primitives.StateStore
    public StateFlow<ConfigState> getState() {
        return ConfigContext.DefaultImpls.getState(this);
    }

    @Override // com.superwall.sdk.misc.primitives.BaseContext
    public Storage getStorage() {
        return this.storage;
    }

    @Override // com.superwall.sdk.config.ConfigContext
    public StoreManager getStoreManager() {
        return this.storeManager;
    }

    @Override // com.superwall.sdk.config.ConfigContext
    public TestMode getTestMode() {
        return this.testMode;
    }

    @Override // com.superwall.sdk.misc.primitives.BaseContext
    public Function2<TrackableSuperwallEvent, Continuation<? super Unit>, Object> getTracker() {
        return this.tracker;
    }

    public final Map<String, Trigger> getTriggersByEventName() {
        return this._triggersByEventName;
    }

    public final Map<String, Experiment.Variant> getUnconfirmedAssignments() {
        return getAssignments().getUnconfirmedAssignments();
    }

    @Override // com.superwall.sdk.config.ConfigContext
    public Function0<WebPaywallRedeemer> getWebPaywallRedeemer() {
        return this.webPaywallRedeemer;
    }

    @Override // com.superwall.sdk.misc.primitives.StoreContext
    public Object immediate(TypedAction<ConfigContext> typedAction, Continuation<? super Unit> continuation) {
        return ConfigContext.DefaultImpls.immediate(this, typedAction, continuation);
    }

    @Override // com.superwall.sdk.misc.primitives.StoreContext
    public Object immediateUntil(TypedAction<ConfigContext> typedAction, Function1<? super ConfigState, Boolean> function1, Continuation<? super Unit> continuation) {
        return ConfigContext.DefaultImpls.immediateUntil(this, typedAction, function1, continuation);
    }

    @Override // com.superwall.sdk.misc.primitives.BaseContext
    public <T> void persist(Storable<T> storable, T t2) {
        ConfigContext.DefaultImpls.persist(this, storable, t2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x005e, code lost:
    
        if (r2.immediate(r6, r0) == r1) goto L22;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object preloadAllPaywalls(kotlin.coroutines.Continuation<? super kotlin.Unit> r6) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.superwall.sdk.config.ConfigManager.C27851
            if (r0 == 0) goto L13
            r0 = r6
            com.superwall.sdk.config.ConfigManager$preloadAllPaywalls$1 r0 = (com.superwall.sdk.config.ConfigManager.C27851) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.superwall.sdk.config.ConfigManager$preloadAllPaywalls$1 r0 = new com.superwall.sdk.config.ConfigManager$preloadAllPaywalls$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3c
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.b(r6)
            goto L61
        L2c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L34:
            java.lang.Object r2 = r0.L$0
            com.superwall.sdk.config.ConfigManager r2 = (com.superwall.sdk.config.ConfigManager) r2
            kotlin.ResultKt.b(r6)
            goto L53
        L3c:
            kotlin.ResultKt.b(r6)
            com.superwall.sdk.misc.primitives.StateActor r6 = r5.getActor()
            kotlinx.coroutines.flow.StateFlow r6 = r6.getState()
            r0.L$0 = r5
            r0.label = r4
            java.lang.Object r6 = com.superwall.sdk.misc.Config_AwaitFirstValidConfigKt.awaitFirstValidConfig(r6, r0)
            if (r6 != r1) goto L52
            goto L60
        L52:
            r2 = r5
        L53:
            com.superwall.sdk.config.models.ConfigState$Actions$PreloadAll r6 = com.superwall.sdk.config.models.ConfigState.Actions.PreloadAll.INSTANCE
            r4 = 0
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r6 = r2.immediate(r6, r0)
            if (r6 != r1) goto L61
        L60:
            return r1
        L61:
            kotlin.Unit r6 = kotlin.Unit.f139807a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.config.ConfigManager.preloadAllPaywalls(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0069, code lost:
    
        if (r2.immediate(r7, r0) == r1) goto L22;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object preloadPaywallsByNames(java.util.Set<java.lang.String> r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.superwall.sdk.config.ConfigManager.C27861
            if (r0 == 0) goto L13
            r0 = r7
            com.superwall.sdk.config.ConfigManager$preloadPaywallsByNames$1 r0 = (com.superwall.sdk.config.ConfigManager.C27861) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.superwall.sdk.config.ConfigManager$preloadPaywallsByNames$1 r0 = new com.superwall.sdk.config.ConfigManager$preloadPaywallsByNames$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L40
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.b(r7)
            goto L6c
        L2c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L34:
            java.lang.Object r6 = r0.L$1
            java.util.Set r6 = (java.util.Set) r6
            java.lang.Object r2 = r0.L$0
            com.superwall.sdk.config.ConfigManager r2 = (com.superwall.sdk.config.ConfigManager) r2
            kotlin.ResultKt.b(r7)
            goto L59
        L40:
            kotlin.ResultKt.b(r7)
            com.superwall.sdk.misc.primitives.StateActor r7 = r5.getActor()
            kotlinx.coroutines.flow.StateFlow r7 = r7.getState()
            r0.L$0 = r5
            r0.L$1 = r6
            r0.label = r4
            java.lang.Object r7 = com.superwall.sdk.misc.Config_AwaitFirstValidConfigKt.awaitFirstValidConfig(r7, r0)
            if (r7 != r1) goto L58
            goto L6b
        L58:
            r2 = r5
        L59:
            com.superwall.sdk.config.models.ConfigState$Actions$PreloadByNames r7 = new com.superwall.sdk.config.models.ConfigState$Actions$PreloadByNames
            r7.<init>(r6)
            r6 = 0
            r0.L$0 = r6
            r0.L$1 = r6
            r0.label = r3
            java.lang.Object r6 = r2.immediate(r7, r0)
            if (r6 != r1) goto L6c
        L6b:
            return r1
        L6c:
            kotlin.Unit r6 = kotlin.Unit.f139807a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.config.ConfigManager.preloadPaywallsByNames(java.util.Set, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.superwall.sdk.misc.primitives.BaseContext
    /* JADX INFO: renamed from: read-IoAF18A, reason: not valid java name */
    public <T> Object mo1262readIoAF18A(Storable<T> storable) {
        return ConfigContext.DefaultImpls.m1261readIoAF18A(this, storable);
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x00df, code lost:
    
        if (r2.immediate(r8, r0) == r1) goto L48;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object recheckPreloadIfNeeded(kotlin.coroutines.Continuation<? super kotlin.Unit> r8) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 232
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.config.ConfigManager.recheckPreloadIfNeeded(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object reevaluateTestMode(Config config, String str, String str2, Continuation<? super Unit> continuation) {
        if (config == null && (config = ConfigStateKt.getConfig((ConfigState) getActor().getState().getValue())) == null) {
            return Unit.f139807a;
        }
        if (getTestMode() == null) {
            return Unit.f139807a;
        }
        Object objImmediate = immediate(new ConfigState.Actions.ReevaluateTestMode(config, str, str2), continuation);
        return objImmediate == IntrinsicsKt.f() ? objImmediate : Unit.f139807a;
    }

    public final Object refreshConfiguration$superwall_release(boolean z2, Continuation<? super Unit> continuation) {
        if (ConfigStateKt.getConfig((ConfigState) getActor().getState().getValue()) == null) {
            return Unit.f139807a;
        }
        Object objImmediate = immediate(new ConfigState.Actions.RefreshConfig(z2), continuation);
        return objImmediate == IntrinsicsKt.f() ? objImmediate : Unit.f139807a;
    }

    public final void reset() {
        Config config = ConfigStateKt.getConfig((ConfigState) getActor().getState().getValue());
        if (config == null) {
            return;
        }
        getAssignments().reset();
        getAssignments().choosePaywallVariants(config.getTriggers());
        effect(ConfigState.Actions.PreloadIfEnabled.INSTANCE);
    }

    public final void setConfigStateForTesting$superwall_release(ConfigState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        getActor().update(new ConfigState.Updates.Set(state));
    }

    public void setOptions(SuperwallOptions superwallOptions) {
        Intrinsics.checkNotNullParameter(superwallOptions, "<set-?>");
        this.options = superwallOptions;
    }

    @Override // com.superwall.sdk.config.ConfigContext
    public void setTriggers(Map<String, Trigger> triggers) {
        Intrinsics.checkNotNullParameter(triggers, "triggers");
        setTriggersByEventName(triggers);
    }

    public final void setTriggersByEventName(Map<String, Trigger> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this._triggersByEventName = MapsKt.toMutableMap(value);
    }

    @Override // com.superwall.sdk.misc.primitives.StoreContext
    public void sideEffect(Function1<? super Continuation<? super Unit>, ? extends Object> function1) {
        ConfigContext.DefaultImpls.sideEffect(this, function1);
    }

    @Override // com.superwall.sdk.misc.primitives.BaseContext
    public void track(TrackableSuperwallEvent trackableSuperwallEvent) {
        ConfigContext.DefaultImpls.track(this, trackableSuperwallEvent);
    }

    @Override // com.superwall.sdk.misc.primitives.StoreContext, com.superwall.sdk.misc.primitives.StateStore
    public void update(Reducer<ConfigState> reducer) {
        ConfigContext.DefaultImpls.update(this, reducer);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x005e, code lost:
    
        if (r2.immediate(r6, r0) == r1) goto L22;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getAssignments(kotlin.coroutines.Continuation<? super kotlin.Unit> r6) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.superwall.sdk.config.ConfigManager.C27841
            if (r0 == 0) goto L13
            r0 = r6
            com.superwall.sdk.config.ConfigManager$getAssignments$1 r0 = (com.superwall.sdk.config.ConfigManager.C27841) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.superwall.sdk.config.ConfigManager$getAssignments$1 r0 = new com.superwall.sdk.config.ConfigManager$getAssignments$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3c
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.b(r6)
            goto L61
        L2c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L34:
            java.lang.Object r2 = r0.L$0
            com.superwall.sdk.config.ConfigManager r2 = (com.superwall.sdk.config.ConfigManager) r2
            kotlin.ResultKt.b(r6)
            goto L53
        L3c:
            kotlin.ResultKt.b(r6)
            com.superwall.sdk.misc.primitives.StateActor r6 = r5.getActor()
            kotlinx.coroutines.flow.StateFlow r6 = r6.getState()
            r0.L$0 = r5
            r0.label = r4
            java.lang.Object r6 = com.superwall.sdk.misc.Config_AwaitFirstValidConfigKt.awaitFirstValidConfig(r6, r0)
            if (r6 != r1) goto L52
            goto L60
        L52:
            r2 = r5
        L53:
            com.superwall.sdk.config.models.ConfigState$Actions$GetAssignments r6 = com.superwall.sdk.config.models.ConfigState.Actions.GetAssignments.INSTANCE
            r4 = 0
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r6 = r2.immediate(r6, r0)
            if (r6 != r1) goto L61
        L60:
            return r1
        L61:
            kotlin.Unit r6 = kotlin.Unit.f139807a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.config.ConfigManager.getAssignments(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public /* synthetic */ ConfigManager(Context context, StoreManager storeManager, Entitlements entitlements, Storage storage, SuperwallAPI superwallAPI, DeviceHelper deviceHelper, SuperwallOptions superwallOptions, PaywallManager paywallManager, Function0 function0, Factory factory, Assignments assignments, PaywallPreload paywallPreload, IOScope iOScope, Function2 function2, TestMode testMode, Function0 function02, Function1 function1, Function1 function12, Function3 function3, StateActor stateActor, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        Context context2;
        Function1 anonymousClass1;
        TestMode testMode2 = (i3 & 16384) != 0 ? null : testMode;
        Function0 function03 = (32768 & i3) != 0 ? null : function02;
        Function1 function13 = (65536 & i3) != 0 ? null : function1;
        if ((131072 & i3) != 0) {
            context2 = context;
            anonymousClass1 = new AnonymousClass1(context2, null);
        } else {
            context2 = context;
            anonymousClass1 = function12;
        }
        this(context2, storeManager, entitlements, storage, superwallAPI, deviceHelper, superwallOptions, paywallManager, function0, factory, assignments, paywallPreload, iOScope, function2, testMode2, function03, function13, anonymousClass1, (i3 & 262144) != 0 ? new AnonymousClass2(null) : function3, stateActor);
    }
}
