package com.superwall.sdk.config.models;

import android.content.Context;
import androidx.media3.extractor.jpeg.xWt.jTYhJgqLBN;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.revenuecat.purchases.ui.revenuecatui.components.SensibleDefaults;
import com.superwall.sdk.analytics.internal.trackable.InternalSuperwallEvent;
import com.superwall.sdk.config.ConfigContext;
import com.superwall.sdk.config.ConfigLogic;
import com.superwall.sdk.config.PaywallPreload;
import com.superwall.sdk.config.models.ConfigState;
import com.superwall.sdk.config.options.PaywallOptionsKt;
import com.superwall.sdk.identity.IdentityManager;
import com.superwall.sdk.logger.LogLevel;
import com.superwall.sdk.logger.LogScope;
import com.superwall.sdk.logger.Logger;
import com.superwall.sdk.misc.Either;
import com.superwall.sdk.misc.primitives.Reducer;
import com.superwall.sdk.misc.primitives.TypedAction;
import com.superwall.sdk.models.config.Config;
import com.superwall.sdk.models.enrichment.Enrichment;
import com.superwall.sdk.models.entitlements.Entitlement;
import com.superwall.sdk.models.entitlements.SubscriptionStatus;
import com.superwall.sdk.models.paywall.Paywall;
import com.superwall.sdk.models.product.CrossplatformProduct;
import com.superwall.sdk.network.NetworkError;
import com.superwall.sdk.network.device.DeviceHelper;
import com.superwall.sdk.storage.DisableVerboseEvents;
import com.superwall.sdk.storage.LatestConfig;
import com.superwall.sdk.store.StoreManager;
import com.superwall.sdk.store.testmode.TestMode;
import com.superwall.sdk.web.WebPaywallRedeemer;
import cz.mobilesoft.coreblock.scene.lockscreen.EI.MrGIhy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.TimeoutKt;

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
public abstract class ConfigState {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static abstract class Actions implements TypedAction<ConfigContext> {
        private final Function2<ConfigContext, Continuation<? super Unit>, Object> execute;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class ApplyConfig extends Actions {
            private final Config config;

            /* JADX INFO: renamed from: com.superwall.sdk.config.models.ConfigState$Actions$ApplyConfig$1, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            @DebugMetadata(c = "com.superwall.sdk.config.models.ConfigState$Actions$ApplyConfig$1", f = "ConfigState.kt", l = {}, m = "invokeSuspend")
            static final class AnonymousClass1 extends SuspendLambda implements Function2<ConfigContext, Continuation<? super Unit>, Object> {
                final /* synthetic */ Config $config;
                private /* synthetic */ Object L$0;
                int label;

                /* JADX INFO: renamed from: com.superwall.sdk.config.models.ConfigState$Actions$ApplyConfig$1$3, reason: invalid class name */
                /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                @Metadata
                @DebugMetadata(c = "com.superwall.sdk.config.models.ConfigState$Actions$ApplyConfig$1$3", f = "ConfigState.kt", l = {329}, m = "invokeSuspend")
                static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ Config $config;
                    final /* synthetic */ boolean $testModeJustActivated;
                    final /* synthetic */ ConfigContext $this;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass3(ConfigContext configContext, Config config, boolean z2, Continuation<? super AnonymousClass3> continuation) {
                        super(2, continuation);
                        this.$this = configContext;
                        this.$config = config;
                        this.$testModeJustActivated = z2;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new AnonymousClass3(this.$this, this.$config, this.$testModeJustActivated, continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) throws Throwable {
                        Object objF = IntrinsicsKt.f();
                        int i3 = this.label;
                        if (i3 == 0) {
                            ResultKt.b(obj);
                            Function3<Config, Boolean, Continuation<? super Unit>, Object> activateTestMode = this.$this.getActivateTestMode();
                            Config config = this.$config;
                            Boolean boolA = Boxing.a(this.$testModeJustActivated);
                            this.label = 1;
                            if (activateTestMode.invoke(config, boolA, this) == objF) {
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

                /* JADX INFO: renamed from: com.superwall.sdk.config.models.ConfigState$Actions$ApplyConfig$1$4, reason: invalid class name */
                /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                @Metadata
                @DebugMetadata(c = "com.superwall.sdk.config.models.ConfigState$Actions$ApplyConfig$1$4", f = "ConfigState.kt", l = {336}, m = "invokeSuspend")
                static final class AnonymousClass4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ ConfigContext $this;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass4(ConfigContext configContext, Continuation<? super AnonymousClass4> continuation) {
                        super(2, continuation);
                        this.$this = configContext;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new AnonymousClass4(this.$this, continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) throws Throwable {
                        Object objF = IntrinsicsKt.f();
                        int i3 = this.label;
                        if (i3 == 0) {
                            ResultKt.b(obj);
                            StoreManager storeManager = this.$this.getStoreManager();
                            Map<String, Set<Entitlement>> entitlementsByProductId = this.$this.getEntitlements().getEntitlementsByProductId();
                            this.label = 1;
                            if (storeManager.loadPurchasedProducts(entitlementsByProductId, this) == objF) {
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

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(Config config, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.$config = config;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$config, continuation);
                    anonymousClass1.L$0 = obj;
                    return anonymousClass1;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(ConfigContext configContext, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(configContext, continuation)).invokeSuspend(Unit.f139807a);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) throws Throwable {
                    IdentityManager identityManager;
                    IdentityManager identityManager2;
                    IntrinsicsKt.f();
                    if (this.label != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                    ConfigContext configContext = (ConfigContext) this.L$0;
                    configContext.getStorage().write(DisableVerboseEvents.INSTANCE, Boxing.a(this.$config.getFeatureFlags().getDisableVerboseEvents()));
                    if (this.$config.getFeatureFlags().getEnableConfigRefresh()) {
                        configContext.getStorage().write(LatestConfig.INSTANCE, this.$config);
                    }
                    ConfigLogic configLogic = ConfigLogic.INSTANCE;
                    configContext.setTriggers(configLogic.getTriggersByEventName(this.$config.getTriggers()));
                    configContext.getAssignments().choosePaywallVariants(this.$config.getTriggers());
                    configContext.getEntitlements().addEntitlementsByProductId$superwall_release(configLogic.extractEntitlementsByProductId(this.$config.getProducts()));
                    List<CrossplatformProduct> productsV3 = this.$config.getProductsV3();
                    if (productsV3 != null) {
                        configContext.getEntitlements().addEntitlementsByProductId$superwall_release(configLogic.extractEntitlementsByProductIdFromCrossplatform(productsV3));
                    }
                    TestMode testMode = configContext.getTestMode();
                    boolean z2 = false;
                    boolean z3 = testMode != null && testMode.isTestMode();
                    if (testMode != null) {
                        Config config = this.$config;
                        String bundleId = configContext.getDeviceHelper().getBundleId();
                        Function0<IdentityManager> identityManager3 = configContext.getIdentityManager();
                        String appUserId = (identityManager3 == null || (identityManager2 = (IdentityManager) identityManager3.invoke()) == null) ? null : identityManager2.getAppUserId();
                        Function0<IdentityManager> identityManager4 = configContext.getIdentityManager();
                        testMode.evaluateTestMode(config, bundleId, appUserId, (identityManager4 == null || (identityManager = (IdentityManager) identityManager4.invoke()) == null) ? null : identityManager.getAliasId(), configContext.getOptions().getTestModeBehavior());
                    }
                    if (!z3 && testMode != null && testMode.isTestMode()) {
                        z2 = true;
                    }
                    if (testMode == null || !testMode.isTestMode()) {
                        if (z3) {
                            if (testMode != null) {
                                testMode.clearTestModeState();
                            }
                            Function1<SubscriptionStatus, Unit> setSubscriptionStatus = configContext.getSetSubscriptionStatus();
                            if (setSubscriptionStatus != null) {
                                setSubscriptionStatus.invoke(SubscriptionStatus.Inactive.INSTANCE);
                            }
                        }
                        BuildersKt__Builders_commonKt.d(configContext.getScope(), null, null, new AnonymousClass4(configContext, null), 3, null);
                    } else {
                        if (z2) {
                            SubscriptionStatus subscriptionStatusBuildSubscriptionStatus = testMode.buildSubscriptionStatus();
                            testMode.setOverriddenSubscriptionStatus(subscriptionStatusBuildSubscriptionStatus);
                            configContext.getEntitlements().setSubscriptionStatus(subscriptionStatusBuildSubscriptionStatus);
                        }
                        BuildersKt__Builders_commonKt.d(configContext.getScope(), null, null, new AnonymousClass3(configContext, this.$config, z2, null), 3, null);
                    }
                    return Unit.f139807a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ApplyConfig(Config config) {
                super(new AnonymousClass1(config, null), null);
                Intrinsics.checkNotNullParameter(config, "config");
                this.config = config;
            }

            public static /* synthetic */ ApplyConfig copy$default(ApplyConfig applyConfig, Config config, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    config = applyConfig.config;
                }
                return applyConfig.copy(config);
            }

            public final Config component1() {
                return this.config;
            }

            public final ApplyConfig copy(Config config) {
                Intrinsics.checkNotNullParameter(config, "config");
                return new ApplyConfig(config);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof ApplyConfig) && Intrinsics.areEqual(this.config, ((ApplyConfig) obj).config);
            }

            public final Config getConfig() {
                return this.config;
            }

            public int hashCode() {
                return this.config.hashCode();
            }

            public String toString() {
                return "ApplyConfig(config=" + this.config + ")";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class FetchConfig extends Actions {
            public static final FetchConfig INSTANCE = new FetchConfig();

            /* JADX INFO: renamed from: com.superwall.sdk.config.models.ConfigState$Actions$FetchConfig$1, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            @DebugMetadata(c = "com.superwall.sdk.config.models.ConfigState$Actions$FetchConfig$1", f = "ConfigState.kt", l = {154, ModuleDescriptor.MODULE_VERSION, 162, 171, 172, 178, 182, 202, 218}, m = "invokeSuspend")
            static final class AnonymousClass1 extends SuspendLambda implements Function2<ConfigContext, Continuation<? super Unit>, Object> {
                int I$0;
                private /* synthetic */ Object L$0;
                Object L$1;
                Object L$2;
                Object L$3;
                Object L$4;
                Object L$5;
                Object L$6;
                int label;

                /* JADX INFO: renamed from: com.superwall.sdk.config.models.ConfigState$Actions$FetchConfig$1$1, reason: invalid class name and collision with other inner class name */
                /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                @Metadata
                @DebugMetadata(c = "com.superwall.sdk.config.models.ConfigState$Actions$FetchConfig$1$1", f = "ConfigState.kt", l = {}, m = "invokeSuspend")
                static final class C02291 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ ConfigContext $$this$exec;
                    final /* synthetic */ HashMap<String, Object> $attributes;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C02291(ConfigContext configContext, HashMap<String, Object> map, Continuation<? super C02291> continuation) {
                        super(2, continuation);
                        this.$$this$exec = configContext;
                        this.$attributes = map;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new C02291(this.$$this$exec, this.$attributes, continuation);
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) throws Throwable {
                        IntrinsicsKt.f();
                        if (this.label != 0) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.b(obj);
                        ConfigContext configContext = this.$$this$exec;
                        HashMap<String, Object> map = this.$attributes;
                        Intrinsics.checkNotNull(map, "null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.Any>");
                        configContext.track(new InternalSuperwallEvent.DeviceAttributes(map, null, 2, 0 == true ? 1 : 0));
                        return Unit.f139807a;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return ((C02291) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
                    }
                }

                /* JADX INFO: renamed from: com.superwall.sdk.config.models.ConfigState$Actions$FetchConfig$1$2, reason: invalid class name */
                /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                @Metadata
                @DebugMetadata(c = "com.superwall.sdk.config.models.ConfigState$Actions$FetchConfig$1$2", f = "ConfigState.kt", l = {}, m = "invokeSuspend")
                static final class AnonymousClass2 extends SuspendLambda implements Function2<Config, Continuation<? super Unit>, Object> {
                    final /* synthetic */ ConfigContext $$this$exec;
                    final /* synthetic */ Ref.LongRef $configDuration;
                    final /* synthetic */ AtomicInteger $configRetryCount;
                    final /* synthetic */ Ref.BooleanRef $isConfigFromCache;
                    /* synthetic */ Object L$0;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass2(ConfigContext configContext, Ref.BooleanRef booleanRef, Ref.LongRef longRef, AtomicInteger atomicInteger, Continuation<? super AnonymousClass2> continuation) {
                        super(2, continuation);
                        this.$$this$exec = configContext;
                        this.$isConfigFromCache = booleanRef;
                        this.$configDuration = longRef;
                        this.$configRetryCount = atomicInteger;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$$this$exec, this.$isConfigFromCache, this.$configDuration, this.$configRetryCount, continuation);
                        anonymousClass2.L$0 = obj;
                        return anonymousClass2;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Config config, Continuation<? super Unit> continuation) {
                        return ((AnonymousClass2) create(config, continuation)).invokeSuspend(Unit.f139807a);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) throws Throwable {
                        IntrinsicsKt.f();
                        if (this.label != 0) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.b(obj);
                        Config config = (Config) this.L$0;
                        this.$$this$exec.track(new InternalSuperwallEvent.ConfigRefresh(this.$isConfigFromCache.f140137a, config.getBuildId(), this.$configRetryCount.get(), this.$configDuration.f140143a));
                        return Unit.f139807a;
                    }
                }

                /* JADX INFO: renamed from: com.superwall.sdk.config.models.ConfigState$Actions$FetchConfig$1$3, reason: invalid class name */
                /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                @Metadata
                @DebugMetadata(c = "com.superwall.sdk.config.models.ConfigState$Actions$FetchConfig$1$3", f = "ConfigState.kt", l = {171}, m = "invokeSuspend")
                static final class AnonymousClass3 extends SuspendLambda implements Function2<Config, Continuation<? super Unit>, Object> {
                    final /* synthetic */ ConfigContext $$this$exec;
                    /* synthetic */ Object L$0;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass3(ConfigContext configContext, Continuation<? super AnonymousClass3> continuation) {
                        super(2, continuation);
                        this.$$this$exec = configContext;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.$$this$exec, continuation);
                        anonymousClass3.L$0 = obj;
                        return anonymousClass3;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Config config, Continuation<? super Unit> continuation) {
                        return ((AnonymousClass3) create(config, continuation)).invokeSuspend(Unit.f139807a);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) throws Throwable {
                        Object objF = IntrinsicsKt.f();
                        int i3 = this.label;
                        if (i3 == 0) {
                            ResultKt.b(obj);
                            Config config = (Config) this.L$0;
                            ConfigContext configContext = this.$$this$exec;
                            ApplyConfig applyConfig = new ApplyConfig(config);
                            this.label = 1;
                            if (configContext.immediate(applyConfig, this) == objF) {
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
                }

                /* JADX INFO: renamed from: com.superwall.sdk.config.models.ConfigState$Actions$FetchConfig$1$4, reason: invalid class name */
                /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                @Metadata
                @DebugMetadata(c = "com.superwall.sdk.config.models.ConfigState$Actions$FetchConfig$1$4", f = "ConfigState.kt", l = {176}, m = "invokeSuspend")
                static final class AnonymousClass4 extends SuspendLambda implements Function2<Config, Continuation<? super Unit>, Object> {
                    final /* synthetic */ ConfigContext $$this$exec;
                    final /* synthetic */ Deferred<Either<Enrichment, NetworkError>> $enrichmentDeferred;
                    /* synthetic */ Object L$0;
                    int label;

                    /* JADX INFO: renamed from: com.superwall.sdk.config.models.ConfigState$Actions$FetchConfig$1$4$1, reason: invalid class name and collision with other inner class name */
                    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                    @Metadata
                    @DebugMetadata(c = "com.superwall.sdk.config.models.ConfigState$Actions$FetchConfig$1$4$1", f = "ConfigState.kt", l = {176}, m = "invokeSuspend")
                    static final class C02301 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Either<? extends Enrichment, NetworkError>>, Object> {
                        final /* synthetic */ Deferred<Either<Enrichment, NetworkError>> $enrichmentDeferred;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        C02301(Deferred<? extends Either<Enrichment, NetworkError>> deferred, Continuation<? super C02301> continuation) {
                            super(2, continuation);
                            this.$enrichmentDeferred = deferred;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new C02301(this.$enrichmentDeferred, continuation);
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
                            Deferred<Either<Enrichment, NetworkError>> deferred = this.$enrichmentDeferred;
                            this.label = 1;
                            Object objAwait = deferred.await(this);
                            return objAwait == objF ? objF : objAwait;
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Either<Enrichment, NetworkError>> continuation) {
                            return ((C02301) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
                        }
                    }

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    AnonymousClass4(ConfigContext configContext, Deferred<? extends Either<Enrichment, NetworkError>> deferred, Continuation<? super AnonymousClass4> continuation) {
                        super(2, continuation);
                        this.$$this$exec = configContext;
                        this.$enrichmentDeferred = deferred;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        AnonymousClass4 anonymousClass4 = new AnonymousClass4(this.$$this$exec, this.$enrichmentDeferred, continuation);
                        anonymousClass4.L$0 = obj;
                        return anonymousClass4;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Config config, Continuation<? super Unit> continuation) {
                        return ((AnonymousClass4) create(config, continuation)).invokeSuspend(Unit.f139807a);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) throws Throwable {
                        Config config;
                        Object objF = IntrinsicsKt.f();
                        int i3 = this.label;
                        if (i3 == 0) {
                            ResultKt.b(obj);
                            Config config2 = (Config) this.L$0;
                            Duration.Companion companion = Duration.f140631b;
                            long jS = DurationKt.s(1, DurationUnit.f140641f);
                            C02301 c02301 = new C02301(this.$enrichmentDeferred, null);
                            this.L$0 = config2;
                            this.label = 1;
                            if (TimeoutKt.f(jS, c02301, this) == objF) {
                                return objF;
                            }
                            config = config2;
                        } else {
                            if (i3 != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            config = (Config) this.L$0;
                            ResultKt.b(obj);
                        }
                        this.$$this$exec.update(new Updates.SetRetrieved(config));
                        return Unit.f139807a;
                    }
                }

                /* JADX INFO: renamed from: com.superwall.sdk.config.models.ConfigState$Actions$FetchConfig$1$5, reason: invalid class name */
                /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                @Metadata
                @DebugMetadata(c = "com.superwall.sdk.config.models.ConfigState$Actions$FetchConfig$1$5", f = "ConfigState.kt", l = {}, m = "invokeSuspend")
                static final class AnonymousClass5 extends SuspendLambda implements Function2<Config, Continuation<? super Unit>, Object> {
                    final /* synthetic */ ConfigContext $$this$exec;
                    int label;

                    /* JADX INFO: renamed from: com.superwall.sdk.config.models.ConfigState$Actions$FetchConfig$1$5$1, reason: invalid class name and collision with other inner class name */
                    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                    @Metadata
                    @DebugMetadata(c = "com.superwall.sdk.config.models.ConfigState$Actions$FetchConfig$1$5$1", f = "ConfigState.kt", l = {SensibleDefaults.X_OFFSET}, m = "invokeSuspend")
                    static final class C02311 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
                        final /* synthetic */ ConfigContext $$this$exec;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        C02311(ConfigContext configContext, Continuation<? super C02311> continuation) {
                            super(1, continuation);
                            this.$$this$exec = configContext;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Continuation<?> continuation) {
                            return new C02311(this.$$this$exec, continuation);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) throws Throwable {
                            Object objF = IntrinsicsKt.f();
                            int i3 = this.label;
                            if (i3 == 0) {
                                ResultKt.b(obj);
                                WebPaywallRedeemer webPaywallRedeemer = (WebPaywallRedeemer) this.$$this$exec.getWebPaywallRedeemer().invoke();
                                WebPaywallRedeemer.RedeemType.Existing existing = WebPaywallRedeemer.RedeemType.Existing.INSTANCE;
                                this.label = 1;
                                if (webPaywallRedeemer.redeem(existing, this) == objF) {
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
                            return ((C02311) create(continuation)).invokeSuspend(Unit.f139807a);
                        }
                    }

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass5(ConfigContext configContext, Continuation<? super AnonymousClass5> continuation) {
                        super(2, continuation);
                        this.$$this$exec = configContext;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new AnonymousClass5(this.$$this$exec, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Config config, Continuation<? super Unit> continuation) {
                        return ((AnonymousClass5) create(config, continuation)).invokeSuspend(Unit.f139807a);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) throws Throwable {
                        IntrinsicsKt.f();
                        if (this.label != 0) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.b(obj);
                        ConfigContext configContext = this.$$this$exec;
                        configContext.sideEffect(new C02311(configContext, null));
                        return Unit.f139807a;
                    }
                }

                /* JADX INFO: renamed from: com.superwall.sdk.config.models.ConfigState$Actions$FetchConfig$1$6, reason: invalid class name */
                /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                @Metadata
                @DebugMetadata(c = "com.superwall.sdk.config.models.ConfigState$Actions$FetchConfig$1$6", f = "ConfigState.kt", l = {}, m = "invokeSuspend")
                static final class AnonymousClass6 extends SuspendLambda implements Function2<Config, Continuation<? super Unit>, Object> {
                    final /* synthetic */ ConfigContext $$this$exec;
                    /* synthetic */ Object L$0;
                    int label;

                    /* JADX INFO: renamed from: com.superwall.sdk.config.models.ConfigState$Actions$FetchConfig$1$6$1, reason: invalid class name and collision with other inner class name */
                    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                    @Metadata
                    @DebugMetadata(c = "com.superwall.sdk.config.models.ConfigState$Actions$FetchConfig$1$6$1", f = "ConfigState.kt", l = {191}, m = "invokeSuspend")
                    static final class C02321 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        final /* synthetic */ ConfigContext $$this$exec;
                        final /* synthetic */ Set<String> $productIds;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        C02321(ConfigContext configContext, Set<String> set, Continuation<? super C02321> continuation) {
                            super(2, continuation);
                            this.$$this$exec = configContext;
                            this.$productIds = set;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new C02321(this.$$this$exec, this.$productIds, continuation);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) throws Throwable {
                            Object objF = IntrinsicsKt.f();
                            int i3 = this.label;
                            try {
                                if (i3 == 0) {
                                    ResultKt.b(obj);
                                    StoreManager storeManager = this.$$this$exec.getStoreManager();
                                    Set<String> set = this.$productIds;
                                    this.label = 1;
                                    if (storeManager.products(set, this) == objF) {
                                        return objF;
                                    }
                                } else {
                                    if (i3 != 1) {
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                    ResultKt.b(obj);
                                }
                            } catch (Throwable th) {
                                Logger.debug$default(Logger.INSTANCE, LogLevel.error, LogScope.productsManager, "Failed to preload products", (Map) null, th, 8, (Object) null);
                            }
                            return Unit.f139807a;
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return ((C02321) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
                        }
                    }

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass6(ConfigContext configContext, Continuation<? super AnonymousClass6> continuation) {
                        super(2, continuation);
                        this.$$this$exec = configContext;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        AnonymousClass6 anonymousClass6 = new AnonymousClass6(this.$$this$exec, continuation);
                        anonymousClass6.L$0 = obj;
                        return anonymousClass6;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Config config, Continuation<? super Unit> continuation) {
                        return ((AnonymousClass6) create(config, continuation)).invokeSuspend(Unit.f139807a);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) throws Throwable {
                        IntrinsicsKt.f();
                        if (this.label != 0) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.b(obj);
                        Config config = (Config) this.L$0;
                        TestMode testMode = this.$$this$exec.getTestMode();
                        if ((testMode == null || !testMode.isTestMode()) && PaywallOptionsKt.computedShouldPreload(this.$$this$exec.getOptions(), this.$$this$exec.getDeviceHelper().getDeviceTier())) {
                            List<Paywall> paywalls = config.getPaywalls();
                            ArrayList arrayList = new ArrayList();
                            Iterator<T> it = paywalls.iterator();
                            while (it.hasNext()) {
                                CollectionsKt.addAll(arrayList, ((Paywall) it.next()).getProductIds());
                            }
                            BuildersKt__Builders_commonKt.d(this.$$this$exec.getScope(), null, null, new C02321(this.$$this$exec, CollectionsKt.toSet(arrayList), null), 3, null);
                        }
                        return Unit.f139807a;
                    }
                }

                /* JADX INFO: renamed from: com.superwall.sdk.config.models.ConfigState$Actions$FetchConfig$1$7, reason: invalid class name */
                /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                @Metadata
                @DebugMetadata(c = "com.superwall.sdk.config.models.ConfigState$Actions$FetchConfig$1$7", f = "ConfigState.kt", l = {}, m = "invokeSuspend")
                static final class AnonymousClass7 extends SuspendLambda implements Function2<Config, Continuation<? super Unit>, Object> {
                    final /* synthetic */ ConfigContext $$this$exec;
                    final /* synthetic */ Deferred<Either<Enrichment, NetworkError>> $enrichmentDeferred;
                    final /* synthetic */ Ref.BooleanRef $isEnrichmentFromCache;
                    int label;

                    /* JADX INFO: renamed from: com.superwall.sdk.config.models.ConfigState$Actions$FetchConfig$1$7$1, reason: invalid class name and collision with other inner class name */
                    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                    @Metadata
                    @DebugMetadata(c = "com.superwall.sdk.config.models.ConfigState$Actions$FetchConfig$1$7$1", f = "ConfigState.kt", l = {204, 206}, m = "invokeSuspend")
                    static final class C02331 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        final /* synthetic */ ConfigContext $$this$exec;
                        final /* synthetic */ Deferred<Either<Enrichment, NetworkError>> $enrichmentDeferred;
                        final /* synthetic */ Ref.BooleanRef $isEnrichmentFromCache;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        C02331(Deferred<? extends Either<Enrichment, NetworkError>> deferred, Ref.BooleanRef booleanRef, ConfigContext configContext, Continuation<? super C02331> continuation) {
                            super(2, continuation);
                            this.$enrichmentDeferred = deferred;
                            this.$isEnrichmentFromCache = booleanRef;
                            this.$$this$exec = configContext;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new C02331(this.$enrichmentDeferred, this.$isEnrichmentFromCache, this.$$this$exec, continuation);
                        }

                        /* JADX WARN: Code restructure failed: missing block: B:18:0x004f, code lost:
                        
                            if (r6.m1320getEnrichment8Mi8wO0(6, r3, r5) == r0) goto L19;
                         */
                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct code enable 'Show inconsistent code' option in preferences
                        */
                        public final java.lang.Object invokeSuspend(java.lang.Object r6) throws java.lang.Throwable {
                            /*
                                r5 = this;
                                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                                int r1 = r5.label
                                r2 = 2
                                r3 = 1
                                if (r1 == 0) goto L1e
                                if (r1 == r3) goto L1a
                                if (r1 != r2) goto L12
                                kotlin.ResultKt.b(r6)
                                goto L52
                            L12:
                                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                                r6.<init>(r0)
                                throw r6
                            L1a:
                                kotlin.ResultKt.b(r6)
                                goto L2c
                            L1e:
                                kotlin.ResultKt.b(r6)
                                kotlinx.coroutines.Deferred<com.superwall.sdk.misc.Either<com.superwall.sdk.models.enrichment.Enrichment, com.superwall.sdk.network.NetworkError>> r6 = r5.$enrichmentDeferred
                                r5.label = r3
                                java.lang.Object r6 = r6.await(r5)
                                if (r6 != r0) goto L2c
                                goto L51
                            L2c:
                                com.superwall.sdk.misc.Either r6 = (com.superwall.sdk.misc.Either) r6
                                kotlin.jvm.internal.Ref$BooleanRef r1 = r5.$isEnrichmentFromCache
                                boolean r1 = r1.f140137a
                                if (r1 != 0) goto L3a
                                java.lang.Throwable r6 = r6.getThrowable()
                                if (r6 == 0) goto L52
                            L3a:
                                com.superwall.sdk.config.ConfigContext r6 = r5.$$this$exec
                                com.superwall.sdk.network.device.DeviceHelper r6 = r6.getDeviceHelper()
                                kotlin.time.Duration$Companion r1 = kotlin.time.Duration.f140631b
                                kotlin.time.DurationUnit r1 = kotlin.time.DurationUnit.f140641f
                                long r3 = kotlin.time.DurationKt.s(r3, r1)
                                r5.label = r2
                                r1 = 6
                                java.lang.Object r6 = r6.m1320getEnrichment8Mi8wO0(r1, r3, r5)
                                if (r6 != r0) goto L52
                            L51:
                                return r0
                            L52:
                                kotlin.Unit r6 = kotlin.Unit.f139807a
                                return r6
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.config.models.ConfigState.Actions.FetchConfig.AnonymousClass1.AnonymousClass7.C02331.invokeSuspend(java.lang.Object):java.lang.Object");
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return ((C02331) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
                        }
                    }

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    AnonymousClass7(ConfigContext configContext, Deferred<? extends Either<Enrichment, NetworkError>> deferred, Ref.BooleanRef booleanRef, Continuation<? super AnonymousClass7> continuation) {
                        super(2, continuation);
                        this.$$this$exec = configContext;
                        this.$enrichmentDeferred = deferred;
                        this.$isEnrichmentFromCache = booleanRef;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new AnonymousClass7(this.$$this$exec, this.$enrichmentDeferred, this.$isEnrichmentFromCache, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Config config, Continuation<? super Unit> continuation) {
                        return ((AnonymousClass7) create(config, continuation)).invokeSuspend(Unit.f139807a);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) throws Throwable {
                        IntrinsicsKt.f();
                        if (this.label != 0) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.b(obj);
                        BuildersKt__Builders_commonKt.d(this.$$this$exec.getScope(), null, null, new C02331(this.$enrichmentDeferred, this.$isEnrichmentFromCache, this.$$this$exec, null), 3, null);
                        return Unit.f139807a;
                    }
                }

                AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation);
                    anonymousClass1.L$0 = obj;
                    return anonymousClass1;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(ConfigContext configContext, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(configContext, continuation)).invokeSuspend(Unit.f139807a);
                }

                /* JADX WARN: Code restructure failed: missing block: B:74:0x0318, code lost:
                
                    if (r7.immediate(r4, r24) == r1) goto L75;
                 */
                /* JADX WARN: Removed duplicated region for block: B:14:0x00d0 A[PHI: r2 r3 r6 r7 r8 r9 r10 r11 r12
                  0x00d0: PHI (r2v13 int) = (r2v11 int), (r2v14 int) binds: [B:37:0x01f7, B:13:0x00ac] A[DONT_GENERATE, DONT_INLINE]
                  0x00d0: PHI (r3v6 com.superwall.sdk.misc.Either) = (r3v4 com.superwall.sdk.misc.Either), (r3v8 com.superwall.sdk.misc.Either) binds: [B:37:0x01f7, B:13:0x00ac] A[DONT_GENERATE, DONT_INLINE]
                  0x00d0: PHI (r6v24 java.lang.Object) = (r6v21 java.lang.Object), (r6v30 java.lang.Object) binds: [B:37:0x01f7, B:13:0x00ac] A[DONT_GENERATE, DONT_INLINE]
                  0x00d0: PHI (r7v8 kotlinx.coroutines.Deferred) = (r7v5 kotlinx.coroutines.Deferred), (r7v11 kotlinx.coroutines.Deferred) binds: [B:37:0x01f7, B:13:0x00ac] A[DONT_GENERATE, DONT_INLINE]
                  0x00d0: PHI (r8v11 kotlin.jvm.internal.Ref$LongRef) = (r8v8 kotlin.jvm.internal.Ref$LongRef), (r8v15 kotlin.jvm.internal.Ref$LongRef) binds: [B:37:0x01f7, B:13:0x00ac] A[DONT_GENERATE, DONT_INLINE]
                  0x00d0: PHI (r9v9 java.util.concurrent.atomic.AtomicInteger) = (r9v6 java.util.concurrent.atomic.AtomicInteger), (r9v12 java.util.concurrent.atomic.AtomicInteger) binds: [B:37:0x01f7, B:13:0x00ac] A[DONT_GENERATE, DONT_INLINE]
                  0x00d0: PHI (r10v5 kotlin.jvm.internal.Ref$BooleanRef) = (r10v2 kotlin.jvm.internal.Ref$BooleanRef), (r10v7 kotlin.jvm.internal.Ref$BooleanRef) binds: [B:37:0x01f7, B:13:0x00ac] A[DONT_GENERATE, DONT_INLINE]
                  0x00d0: PHI (r11v7 kotlin.jvm.internal.Ref$BooleanRef) = (r11v4 kotlin.jvm.internal.Ref$BooleanRef), (r11v10 kotlin.jvm.internal.Ref$BooleanRef) binds: [B:37:0x01f7, B:13:0x00ac] A[DONT_GENERATE, DONT_INLINE]
                  0x00d0: PHI (r12v6 com.superwall.sdk.config.ConfigContext) = (r12v3 com.superwall.sdk.config.ConfigContext), (r12v8 com.superwall.sdk.config.ConfigContext) binds: [B:37:0x01f7, B:13:0x00ac] A[DONT_GENERATE, DONT_INLINE]] */
                /* JADX WARN: Removed duplicated region for block: B:42:0x0235  */
                /* JADX WARN: Removed duplicated region for block: B:46:0x0255 A[PHI: r2 r3 r6 r7 r8 r9
                  0x0255: PHI (r2v17 int) = (r2v15 int), (r2v18 int) binds: [B:44:0x0251, B:11:0x007a] A[DONT_GENERATE, DONT_INLINE]
                  0x0255: PHI (r3v13 java.lang.Object) = (r3v11 java.lang.Object), (r3v16 java.lang.Object) binds: [B:44:0x0251, B:11:0x007a] A[DONT_GENERATE, DONT_INLINE]
                  0x0255: PHI (r6v34 kotlinx.coroutines.Deferred) = (r6v31 kotlinx.coroutines.Deferred), (r6v36 kotlinx.coroutines.Deferred) binds: [B:44:0x0251, B:11:0x007a] A[DONT_GENERATE, DONT_INLINE]
                  0x0255: PHI (r7v15 kotlin.jvm.internal.Ref$BooleanRef) = (r7v12 kotlin.jvm.internal.Ref$BooleanRef), (r7v17 kotlin.jvm.internal.Ref$BooleanRef) binds: [B:44:0x0251, B:11:0x007a] A[DONT_GENERATE, DONT_INLINE]
                  0x0255: PHI (r8v19 kotlin.jvm.internal.Ref$BooleanRef) = (r8v16 kotlin.jvm.internal.Ref$BooleanRef), (r8v21 kotlin.jvm.internal.Ref$BooleanRef) binds: [B:44:0x0251, B:11:0x007a] A[DONT_GENERATE, DONT_INLINE]
                  0x0255: PHI (r9v16 com.superwall.sdk.config.ConfigContext) = (r9v13 com.superwall.sdk.config.ConfigContext), (r9v18 com.superwall.sdk.config.ConfigContext) binds: [B:44:0x0251, B:11:0x007a] A[DONT_GENERATE, DONT_INLINE]] */
                /* JADX WARN: Removed duplicated region for block: B:49:0x0271 A[PHI: r2 r3 r6 r7 r8 r9
                  0x0271: PHI (r2v19 int) = (r2v17 int), (r2v20 int) binds: [B:47:0x026d, B:10:0x0061] A[DONT_GENERATE, DONT_INLINE]
                  0x0271: PHI (r3v17 java.lang.Object) = (r3v15 java.lang.Object), (r3v20 java.lang.Object) binds: [B:47:0x026d, B:10:0x0061] A[DONT_GENERATE, DONT_INLINE]
                  0x0271: PHI (r6v37 kotlinx.coroutines.Deferred) = (r6v34 kotlinx.coroutines.Deferred), (r6v39 kotlinx.coroutines.Deferred) binds: [B:47:0x026d, B:10:0x0061] A[DONT_GENERATE, DONT_INLINE]
                  0x0271: PHI (r7v18 kotlin.jvm.internal.Ref$BooleanRef) = (r7v15 kotlin.jvm.internal.Ref$BooleanRef), (r7v20 kotlin.jvm.internal.Ref$BooleanRef) binds: [B:47:0x026d, B:10:0x0061] A[DONT_GENERATE, DONT_INLINE]
                  0x0271: PHI (r8v22 kotlin.jvm.internal.Ref$BooleanRef) = (r8v19 kotlin.jvm.internal.Ref$BooleanRef), (r8v24 kotlin.jvm.internal.Ref$BooleanRef) binds: [B:47:0x026d, B:10:0x0061] A[DONT_GENERATE, DONT_INLINE]
                  0x0271: PHI (r9v19 com.superwall.sdk.config.ConfigContext) = (r9v16 com.superwall.sdk.config.ConfigContext), (r9v21 com.superwall.sdk.config.ConfigContext) binds: [B:47:0x026d, B:10:0x0061] A[DONT_GENERATE, DONT_INLINE]] */
                /* JADX WARN: Removed duplicated region for block: B:58:0x029d A[PHI: r2 r3 r6 r7 r8 r9
                  0x029d: PHI (r2v21 int) = (r2v19 int), (r2v22 int) binds: [B:56:0x0299, B:9:0x0048] A[DONT_GENERATE, DONT_INLINE]
                  0x029d: PHI (r3v21 java.lang.Object) = (r3v19 java.lang.Object), (r3v24 java.lang.Object) binds: [B:56:0x0299, B:9:0x0048] A[DONT_GENERATE, DONT_INLINE]
                  0x029d: PHI (r6v40 kotlinx.coroutines.Deferred) = (r6v37 kotlinx.coroutines.Deferred), (r6v42 kotlinx.coroutines.Deferred) binds: [B:56:0x0299, B:9:0x0048] A[DONT_GENERATE, DONT_INLINE]
                  0x029d: PHI (r7v21 kotlin.jvm.internal.Ref$BooleanRef) = (r7v18 kotlin.jvm.internal.Ref$BooleanRef), (r7v24 kotlin.jvm.internal.Ref$BooleanRef) binds: [B:56:0x0299, B:9:0x0048] A[DONT_GENERATE, DONT_INLINE]
                  0x029d: PHI (r8v25 kotlin.jvm.internal.Ref$BooleanRef) = (r8v22 kotlin.jvm.internal.Ref$BooleanRef), (r8v27 kotlin.jvm.internal.Ref$BooleanRef) binds: [B:56:0x0299, B:9:0x0048] A[DONT_GENERATE, DONT_INLINE]
                  0x029d: PHI (r9v22 com.superwall.sdk.config.ConfigContext) = (r9v19 com.superwall.sdk.config.ConfigContext), (r9v25 com.superwall.sdk.config.ConfigContext) binds: [B:56:0x0299, B:9:0x0048] A[DONT_GENERATE, DONT_INLINE]] */
                /* JADX WARN: Removed duplicated region for block: B:61:0x02b8  */
                /* JADX WARN: Removed duplicated region for block: B:65:0x02d9  */
                /* JADX WARN: Removed duplicated region for block: B:68:0x02e0  */
                /* JADX WARN: Removed duplicated region for block: B:71:0x02fb  */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object invokeSuspend(java.lang.Object r25) throws java.lang.Throwable {
                    /*
                        Method dump skipped, instruction units count: 832
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.config.models.ConfigState.Actions.FetchConfig.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
                }
            }

            private FetchConfig() {
                super(new AnonymousClass1(null), null);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class GetAssignments extends Actions {
            public static final GetAssignments INSTANCE = new GetAssignments();

            /* JADX INFO: renamed from: com.superwall.sdk.config.models.ConfigState$Actions$GetAssignments$1, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            @DebugMetadata(c = "com.superwall.sdk.config.models.ConfigState$Actions$GetAssignments$1", f = "ConfigState.kt", l = {391, 392}, m = "invokeSuspend")
            static final class AnonymousClass1 extends SuspendLambda implements Function2<ConfigContext, Continuation<? super Unit>, Object> {
                private /* synthetic */ Object L$0;
                int label;

                AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final Unit invokeSuspend$lambda$2$lambda$1(NetworkError networkError) {
                    Logger.debug$default(Logger.INSTANCE, LogLevel.error, LogScope.configManager, "Error retrieving assignments.", (Map) null, networkError, 8, (Object) null);
                    return Unit.f139807a;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation);
                    anonymousClass1.L$0 = obj;
                    return anonymousClass1;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(ConfigContext configContext, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(configContext, continuation)).invokeSuspend(Unit.f139807a);
                }

                /* JADX WARN: Code restructure failed: missing block: B:28:0x006e, code lost:
                
                    if (r9 == r0) goto L29;
                 */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object invokeSuspend(java.lang.Object r9) throws java.lang.Throwable {
                    /*
                        r8 = this;
                        java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                        int r1 = r8.label
                        r2 = 2
                        r3 = 1
                        r4 = 0
                        if (r1 == 0) goto L27
                        if (r1 == r3) goto L1f
                        if (r1 != r2) goto L17
                        kotlin.ResultKt.b(r9)     // Catch: java.lang.Throwable -> L13
                        goto L71
                    L13:
                        r0 = move-exception
                        r9 = r0
                        r5 = r9
                        goto L7c
                    L17:
                        java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                        java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                        r9.<init>(r0)
                        throw r9
                    L1f:
                        java.lang.Object r1 = r8.L$0
                        com.superwall.sdk.config.ConfigContext r1 = (com.superwall.sdk.config.ConfigContext) r1
                        kotlin.ResultKt.b(r9)     // Catch: java.lang.Throwable -> L13
                        goto L5f
                    L27:
                        kotlin.ResultKt.b(r9)
                        java.lang.Object r9 = r8.L$0
                        r1 = r9
                        com.superwall.sdk.config.ConfigContext r1 = (com.superwall.sdk.config.ConfigContext) r1
                        kotlinx.coroutines.flow.StateFlow r9 = r1.getState()
                        java.lang.Object r9 = r9.getValue()
                        com.superwall.sdk.config.models.ConfigState r9 = (com.superwall.sdk.config.models.ConfigState) r9
                        com.superwall.sdk.models.config.Config r9 = com.superwall.sdk.config.models.ConfigStateKt.getConfig(r9)
                        if (r9 != 0) goto L42
                        kotlin.Unit r9 = kotlin.Unit.f139807a
                        return r9
                    L42:
                        java.util.Set r9 = r9.getTriggers()
                        boolean r5 = r9.isEmpty()
                        if (r5 != 0) goto L4d
                        goto L4e
                    L4d:
                        r9 = r4
                    L4e:
                        if (r9 == 0) goto L8e
                        com.superwall.sdk.config.Assignments r5 = r1.getAssignments()     // Catch: java.lang.Throwable -> L13
                        r8.L$0 = r1     // Catch: java.lang.Throwable -> L13
                        r8.label = r3     // Catch: java.lang.Throwable -> L13
                        java.lang.Object r9 = r5.getAssignments(r9, r8)     // Catch: java.lang.Throwable -> L13
                        if (r9 != r0) goto L5f
                        goto L70
                    L5f:
                        com.superwall.sdk.misc.Either r9 = (com.superwall.sdk.misc.Either) r9     // Catch: java.lang.Throwable -> L13
                        com.superwall.sdk.config.models.ConfigState$Actions$GetAssignments$1$2$1 r3 = new com.superwall.sdk.config.models.ConfigState$Actions$GetAssignments$1$2$1     // Catch: java.lang.Throwable -> L13
                        r3.<init>(r1, r4)     // Catch: java.lang.Throwable -> L13
                        r8.L$0 = r4     // Catch: java.lang.Throwable -> L13
                        r8.label = r2     // Catch: java.lang.Throwable -> L13
                        java.lang.Object r9 = com.superwall.sdk.misc.EitherKt.then(r9, r3, r8)     // Catch: java.lang.Throwable -> L13
                        if (r9 != r0) goto L71
                    L70:
                        return r0
                    L71:
                        com.superwall.sdk.misc.Either r9 = (com.superwall.sdk.misc.Either) r9     // Catch: java.lang.Throwable -> L13
                        com.superwall.sdk.config.models.a r0 = new com.superwall.sdk.config.models.a     // Catch: java.lang.Throwable -> L13
                        r0.<init>()     // Catch: java.lang.Throwable -> L13
                        com.superwall.sdk.misc.EitherKt.onError(r9, r0)     // Catch: java.lang.Throwable -> L13
                        goto L8e
                    L7c:
                        r5.printStackTrace()
                        com.superwall.sdk.logger.Logger r0 = com.superwall.sdk.logger.Logger.INSTANCE
                        com.superwall.sdk.logger.LogLevel r1 = com.superwall.sdk.logger.LogLevel.error
                        com.superwall.sdk.logger.LogScope r2 = com.superwall.sdk.logger.LogScope.configManager
                        r6 = 8
                        r7 = 0
                        java.lang.String r3 = "Error retrieving assignments."
                        r4 = 0
                        com.superwall.sdk.logger.Logger.debug$default(r0, r1, r2, r3, r4, r5, r6, r7)
                    L8e:
                        kotlin.Unit r9 = kotlin.Unit.f139807a
                        return r9
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.config.models.ConfigState.Actions.GetAssignments.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
                }
            }

            private GetAssignments() {
                super(new AnonymousClass1(null), null);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class HandleFetchFailure extends Actions {
            private final Throwable error;
            private final boolean isConfigFromCache;
            private final int priorRetries;

            /* JADX INFO: renamed from: com.superwall.sdk.config.models.ConfigState$Actions$HandleFetchFailure$1, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            @DebugMetadata(c = "com.superwall.sdk.config.models.ConfigState$Actions$HandleFetchFailure$1", f = "ConfigState.kt", l = {}, m = "invokeSuspend")
            static final class AnonymousClass1 extends SuspendLambda implements Function2<ConfigContext, Continuation<? super Unit>, Object> {
                final /* synthetic */ Throwable $error;
                final /* synthetic */ boolean $isConfigFromCache;
                final /* synthetic */ int $priorRetries;
                private /* synthetic */ Object L$0;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(Throwable th, int i3, boolean z2, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.$error = th;
                    this.$priorRetries = i3;
                    this.$isConfigFromCache = z2;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$error, this.$priorRetries, this.$isConfigFromCache, continuation);
                    anonymousClass1.L$0 = obj;
                    return anonymousClass1;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(ConfigContext configContext, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(configContext, continuation)).invokeSuspend(Unit.f139807a);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) throws Throwable {
                    IntrinsicsKt.f();
                    if (this.label != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                    ConfigContext configContext = (ConfigContext) this.L$0;
                    this.$error.printStackTrace();
                    int i3 = this.$priorRetries + 1;
                    configContext.update(new Updates.SetFailed(this.$error, i3));
                    if (!this.$isConfigFromCache && i3 <= 1) {
                        configContext.effect(FetchConfig.INSTANCE);
                    }
                    String message = this.$error.getMessage();
                    if (message == null) {
                        message = "Unknown error";
                    }
                    configContext.track(new InternalSuperwallEvent.ConfigFail(message));
                    Logger.debug$default(Logger.INSTANCE, LogLevel.error, LogScope.superwallCore, "Failed to Fetch Configuration", (Map) null, this.$error, 8, (Object) null);
                    return Unit.f139807a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public HandleFetchFailure(Throwable error, int i3, boolean z2) {
                super(new AnonymousClass1(error, i3, z2, null), null);
                Intrinsics.checkNotNullParameter(error, "error");
                this.error = error;
                this.priorRetries = i3;
                this.isConfigFromCache = z2;
            }

            public static /* synthetic */ HandleFetchFailure copy$default(HandleFetchFailure handleFetchFailure, Throwable th, int i3, boolean z2, int i4, Object obj) {
                if ((i4 & 1) != 0) {
                    th = handleFetchFailure.error;
                }
                if ((i4 & 2) != 0) {
                    i3 = handleFetchFailure.priorRetries;
                }
                if ((i4 & 4) != 0) {
                    z2 = handleFetchFailure.isConfigFromCache;
                }
                return handleFetchFailure.copy(th, i3, z2);
            }

            public final Throwable component1() {
                return this.error;
            }

            public final int component2() {
                return this.priorRetries;
            }

            public final boolean component3() {
                return this.isConfigFromCache;
            }

            public final HandleFetchFailure copy(Throwable error, int i3, boolean z2) {
                Intrinsics.checkNotNullParameter(error, "error");
                return new HandleFetchFailure(error, i3, z2);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof HandleFetchFailure)) {
                    return false;
                }
                HandleFetchFailure handleFetchFailure = (HandleFetchFailure) obj;
                return Intrinsics.areEqual(this.error, handleFetchFailure.error) && this.priorRetries == handleFetchFailure.priorRetries && this.isConfigFromCache == handleFetchFailure.isConfigFromCache;
            }

            public final Throwable getError() {
                return this.error;
            }

            public final int getPriorRetries() {
                return this.priorRetries;
            }

            public int hashCode() {
                return (((this.error.hashCode() * 31) + Integer.hashCode(this.priorRetries)) * 31) + Boolean.hashCode(this.isConfigFromCache);
            }

            public final boolean isConfigFromCache() {
                return this.isConfigFromCache;
            }

            public String toString() {
                return "HandleFetchFailure(error=" + this.error + ", priorRetries=" + this.priorRetries + ", isConfigFromCache=" + this.isConfigFromCache + ")";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class PreloadAll extends Actions {
            public static final PreloadAll INSTANCE = new PreloadAll();

            /* JADX INFO: renamed from: com.superwall.sdk.config.models.ConfigState$Actions$PreloadAll$1, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            @DebugMetadata(c = "com.superwall.sdk.config.models.ConfigState$Actions$PreloadAll$1", f = "ConfigState.kt", l = {376}, m = "invokeSuspend")
            static final class AnonymousClass1 extends SuspendLambda implements Function2<ConfigContext, Continuation<? super Unit>, Object> {
                private /* synthetic */ Object L$0;
                int label;

                AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation);
                    anonymousClass1.L$0 = obj;
                    return anonymousClass1;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(ConfigContext configContext, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(configContext, continuation)).invokeSuspend(Unit.f139807a);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) throws Throwable {
                    Object objF = IntrinsicsKt.f();
                    int i3 = this.label;
                    if (i3 == 0) {
                        ResultKt.b(obj);
                        ConfigContext configContext = (ConfigContext) this.L$0;
                        Config config = ConfigStateKt.getConfig((ConfigState) configContext.getState().getValue());
                        if (config == null) {
                            return Unit.f139807a;
                        }
                        PaywallPreload paywallPreload = configContext.getPaywallPreload();
                        Context context = configContext.getContext();
                        this.label = 1;
                        if (PaywallPreload.preloadAllPaywalls$default(paywallPreload, config, context, null, this, 4, null) == objF) {
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
            }

            private PreloadAll() {
                super(new AnonymousClass1(null), null);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class PreloadByNames extends Actions {
            private final Set<String> eventNames;

            /* JADX INFO: renamed from: com.superwall.sdk.config.models.ConfigState$Actions$PreloadByNames$1, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            @DebugMetadata(c = "com.superwall.sdk.config.models.ConfigState$Actions$PreloadByNames$1", f = "ConfigState.kt", l = {383}, m = "invokeSuspend")
            static final class AnonymousClass1 extends SuspendLambda implements Function2<ConfigContext, Continuation<? super Unit>, Object> {
                final /* synthetic */ Set<String> $eventNames;
                private /* synthetic */ Object L$0;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(Set<String> set, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.$eventNames = set;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$eventNames, continuation);
                    anonymousClass1.L$0 = obj;
                    return anonymousClass1;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(ConfigContext configContext, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(configContext, continuation)).invokeSuspend(Unit.f139807a);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) throws Throwable {
                    Object objF = IntrinsicsKt.f();
                    int i3 = this.label;
                    if (i3 == 0) {
                        ResultKt.b(obj);
                        ConfigContext configContext = (ConfigContext) this.L$0;
                        Config config = ConfigStateKt.getConfig((ConfigState) configContext.getState().getValue());
                        if (config == null) {
                            return Unit.f139807a;
                        }
                        PaywallPreload paywallPreload = configContext.getPaywallPreload();
                        Set<String> set = this.$eventNames;
                        this.label = 1;
                        if (paywallPreload.preloadPaywallsByNames(config, set, this) == objF) {
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
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ PreloadByNames copy$default(PreloadByNames preloadByNames, Set set, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    set = preloadByNames.eventNames;
                }
                return preloadByNames.copy(set);
            }

            public final Set<String> component1() {
                return this.eventNames;
            }

            public final PreloadByNames copy(Set<String> eventNames) {
                Intrinsics.checkNotNullParameter(eventNames, "eventNames");
                return new PreloadByNames(eventNames);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof PreloadByNames) && Intrinsics.areEqual(this.eventNames, ((PreloadByNames) obj).eventNames);
            }

            public final Set<String> getEventNames() {
                return this.eventNames;
            }

            public int hashCode() {
                return this.eventNames.hashCode();
            }

            public String toString() {
                return "PreloadByNames(eventNames=" + this.eventNames + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public PreloadByNames(Set<String> set) {
                super(new AnonymousClass1(set, null), null);
                Intrinsics.checkNotNullParameter(set, MrGIhy.bsKCmdpkCMRcDPn);
                this.eventNames = set;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class PreloadIfEnabled extends Actions {
            public static final PreloadIfEnabled INSTANCE = new PreloadIfEnabled();

            /* JADX INFO: renamed from: com.superwall.sdk.config.models.ConfigState$Actions$PreloadIfEnabled$1, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            @DebugMetadata(c = "com.superwall.sdk.config.models.ConfigState$Actions$PreloadIfEnabled$1", f = "ConfigState.kt", l = {370, 367}, m = "invokeSuspend")
            static final class AnonymousClass1 extends SuspendLambda implements Function2<ConfigContext, Continuation<? super Unit>, Object> {
                private /* synthetic */ Object L$0;
                Object L$1;
                Object L$2;
                int label;

                AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation);
                    anonymousClass1.L$0 = obj;
                    return anonymousClass1;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(ConfigContext configContext, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(configContext, continuation)).invokeSuspend(Unit.f139807a);
                }

                /* JADX WARN: Code restructure failed: missing block: B:23:0x0086, code lost:
                
                    if (r4.preloadAllPaywalls(r3, r1, (java.lang.String) r7, r6) == r0) goto L24;
                 */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object invokeSuspend(java.lang.Object r7) throws java.lang.Throwable {
                    /*
                        r6 = this;
                        java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                        int r1 = r6.label
                        r2 = 2
                        r3 = 1
                        if (r1 == 0) goto L2b
                        if (r1 == r3) goto L1b
                        if (r1 != r2) goto L13
                        kotlin.ResultKt.b(r7)
                        goto L89
                    L13:
                        java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                        java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                        r7.<init>(r0)
                        throw r7
                    L1b:
                        java.lang.Object r1 = r6.L$2
                        android.content.Context r1 = (android.content.Context) r1
                        java.lang.Object r3 = r6.L$1
                        com.superwall.sdk.models.config.Config r3 = (com.superwall.sdk.models.config.Config) r3
                        java.lang.Object r4 = r6.L$0
                        com.superwall.sdk.config.PaywallPreload r4 = (com.superwall.sdk.config.PaywallPreload) r4
                        kotlin.ResultKt.b(r7)
                        goto L77
                    L2b:
                        kotlin.ResultKt.b(r7)
                        java.lang.Object r7 = r6.L$0
                        com.superwall.sdk.config.ConfigContext r7 = (com.superwall.sdk.config.ConfigContext) r7
                        com.superwall.sdk.config.options.SuperwallOptions r1 = r7.getOptions()
                        com.superwall.sdk.network.device.DeviceHelper r4 = r7.getDeviceHelper()
                        com.superwall.sdk.analytics.Tier r4 = r4.getDeviceTier()
                        boolean r1 = com.superwall.sdk.config.options.PaywallOptionsKt.computedShouldPreload(r1, r4)
                        if (r1 != 0) goto L47
                        kotlin.Unit r7 = kotlin.Unit.f139807a
                        return r7
                    L47:
                        kotlinx.coroutines.flow.StateFlow r1 = r7.getState()
                        java.lang.Object r1 = r1.getValue()
                        com.superwall.sdk.config.models.ConfigState r1 = (com.superwall.sdk.config.models.ConfigState) r1
                        com.superwall.sdk.models.config.Config r1 = com.superwall.sdk.config.models.ConfigStateKt.getConfig(r1)
                        if (r1 != 0) goto L5a
                        kotlin.Unit r7 = kotlin.Unit.f139807a
                        return r7
                    L5a:
                        com.superwall.sdk.config.PaywallPreload r4 = r7.getPaywallPreload()
                        android.content.Context r5 = r7.getContext()
                        com.superwall.sdk.network.device.DeviceHelper r7 = r7.getDeviceHelper()
                        r6.L$0 = r4
                        r6.L$1 = r1
                        r6.L$2 = r5
                        r6.label = r3
                        java.lang.Object r7 = r7.preloadFingerprint(r6)
                        if (r7 != r0) goto L75
                        goto L88
                    L75:
                        r3 = r1
                        r1 = r5
                    L77:
                        java.lang.String r7 = (java.lang.String) r7
                        r5 = 0
                        r6.L$0 = r5
                        r6.L$1 = r5
                        r6.L$2 = r5
                        r6.label = r2
                        java.lang.Object r7 = r4.preloadAllPaywalls(r3, r1, r7, r6)
                        if (r7 != r0) goto L89
                    L88:
                        return r0
                    L89:
                        kotlin.Unit r7 = kotlin.Unit.f139807a
                        return r7
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.config.models.ConfigState.Actions.PreloadIfEnabled.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
                }
            }

            private PreloadIfEnabled() {
                super(new AnonymousClass1(null), null);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class ReevaluateTestMode extends Actions {
            private final String aliasId;
            private final String appUserId;
            private final Config config;

            /* JADX INFO: renamed from: com.superwall.sdk.config.models.ConfigState$Actions$ReevaluateTestMode$1, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            @DebugMetadata(c = "com.superwall.sdk.config.models.ConfigState$Actions$ReevaluateTestMode$1", f = "ConfigState.kt", l = {}, m = "invokeSuspend")
            static final class AnonymousClass1 extends SuspendLambda implements Function2<ConfigContext, Continuation<? super Unit>, Object> {
                final /* synthetic */ String $aliasId;
                final /* synthetic */ String $appUserId;
                final /* synthetic */ Config $config;
                private /* synthetic */ Object L$0;
                int label;

                /* JADX INFO: renamed from: com.superwall.sdk.config.models.ConfigState$Actions$ReevaluateTestMode$1$1, reason: invalid class name and collision with other inner class name */
                /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                @Metadata
                @DebugMetadata(c = "com.superwall.sdk.config.models.ConfigState$Actions$ReevaluateTestMode$1$1", f = "ConfigState.kt", l = {360}, m = "invokeSuspend")
                static final class C02351 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ ConfigContext $$this$exec;
                    final /* synthetic */ Config $config;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C02351(ConfigContext configContext, Config config, Continuation<? super C02351> continuation) {
                        super(2, continuation);
                        this.$$this$exec = configContext;
                        this.$config = config;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new C02351(this.$$this$exec, this.$config, continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) throws Throwable {
                        Object objF = IntrinsicsKt.f();
                        int i3 = this.label;
                        if (i3 == 0) {
                            ResultKt.b(obj);
                            Function3<Config, Boolean, Continuation<? super Unit>, Object> activateTestMode = this.$$this$exec.getActivateTestMode();
                            Config config = this.$config;
                            Boolean boolA = Boxing.a(true);
                            this.label = 1;
                            if (activateTestMode.invoke(config, boolA, this) == objF) {
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
                        return ((C02351) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(Config config, String str, String str2, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.$config = config;
                    this.$appUserId = str;
                    this.$aliasId = str2;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$config, this.$appUserId, this.$aliasId, continuation);
                    anonymousClass1.L$0 = obj;
                    return anonymousClass1;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(ConfigContext configContext, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(configContext, continuation)).invokeSuspend(Unit.f139807a);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) throws Throwable {
                    IdentityManager identityManager;
                    IdentityManager identityManager2;
                    IntrinsicsKt.f();
                    if (this.label != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                    ConfigContext configContext = (ConfigContext) this.L$0;
                    TestMode testMode = configContext.getTestMode();
                    if (testMode == null) {
                        return Unit.f139807a;
                    }
                    boolean zIsTestMode = testMode.isTestMode();
                    Config config = this.$config;
                    String bundleId = configContext.getDeviceHelper().getBundleId();
                    String appUserId = this.$appUserId;
                    if (appUserId == null) {
                        Function0<IdentityManager> identityManager3 = configContext.getIdentityManager();
                        appUserId = (identityManager3 == null || (identityManager2 = (IdentityManager) identityManager3.invoke()) == null) ? null : identityManager2.getAppUserId();
                    }
                    String aliasId = this.$aliasId;
                    if (aliasId == null) {
                        Function0<IdentityManager> identityManager4 = configContext.getIdentityManager();
                        aliasId = (identityManager4 == null || (identityManager = (IdentityManager) identityManager4.invoke()) == null) ? null : identityManager.getAliasId();
                    }
                    testMode.evaluateTestMode(config, bundleId, appUserId, aliasId, configContext.getOptions().getTestModeBehavior());
                    boolean zIsTestMode2 = testMode.isTestMode();
                    if (zIsTestMode && !zIsTestMode2) {
                        testMode.clearTestModeState();
                        Function1<SubscriptionStatus, Unit> setSubscriptionStatus = configContext.getSetSubscriptionStatus();
                        if (setSubscriptionStatus != null) {
                            setSubscriptionStatus.invoke(SubscriptionStatus.Inactive.INSTANCE);
                        }
                    } else if (!zIsTestMode && zIsTestMode2) {
                        BuildersKt__Builders_commonKt.d(configContext.getScope(), null, null, new C02351(configContext, this.$config, null), 3, null);
                    }
                    return Unit.f139807a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ReevaluateTestMode(Config config, String str, String str2) {
                super(new AnonymousClass1(config, str, str2, null), null);
                Intrinsics.checkNotNullParameter(config, "config");
                this.config = config;
                this.appUserId = str;
                this.aliasId = str2;
            }

            public static /* synthetic */ ReevaluateTestMode copy$default(ReevaluateTestMode reevaluateTestMode, Config config, String str, String str2, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    config = reevaluateTestMode.config;
                }
                if ((i3 & 2) != 0) {
                    str = reevaluateTestMode.appUserId;
                }
                if ((i3 & 4) != 0) {
                    str2 = reevaluateTestMode.aliasId;
                }
                return reevaluateTestMode.copy(config, str, str2);
            }

            public final Config component1() {
                return this.config;
            }

            public final String component2() {
                return this.appUserId;
            }

            public final String component3() {
                return this.aliasId;
            }

            public final ReevaluateTestMode copy(Config config, String str, String str2) {
                Intrinsics.checkNotNullParameter(config, "config");
                return new ReevaluateTestMode(config, str, str2);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof ReevaluateTestMode)) {
                    return false;
                }
                ReevaluateTestMode reevaluateTestMode = (ReevaluateTestMode) obj;
                return Intrinsics.areEqual(this.config, reevaluateTestMode.config) && Intrinsics.areEqual(this.appUserId, reevaluateTestMode.appUserId) && Intrinsics.areEqual(this.aliasId, reevaluateTestMode.aliasId);
            }

            public final String getAliasId() {
                return this.aliasId;
            }

            public final String getAppUserId() {
                return this.appUserId;
            }

            public final Config getConfig() {
                return this.config;
            }

            public int hashCode() {
                int iHashCode = this.config.hashCode() * 31;
                String str = this.appUserId;
                int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
                String str2 = this.aliasId;
                return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
            }

            public String toString() {
                return "ReevaluateTestMode(config=" + this.config + ", appUserId=" + this.appUserId + ", aliasId=" + this.aliasId + ")";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class RefreshConfig extends Actions {
            private final boolean force;

            /* JADX INFO: renamed from: com.superwall.sdk.config.models.ConfigState$Actions$RefreshConfig$1, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            @DebugMetadata(c = "com.superwall.sdk.config.models.ConfigState$Actions$RefreshConfig$1", f = "ConfigState.kt", l = {252, 258, 269}, m = "invokeSuspend")
            static final class AnonymousClass1 extends SuspendLambda implements Function2<ConfigContext, Continuation<? super Unit>, Object> {
                final /* synthetic */ boolean $force;
                long J$0;
                private /* synthetic */ Object L$0;
                Object L$1;
                int label;

                /* JADX INFO: renamed from: com.superwall.sdk.config.models.ConfigState$Actions$RefreshConfig$1$1, reason: invalid class name and collision with other inner class name */
                /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                @Metadata
                @DebugMetadata(c = "com.superwall.sdk.config.models.ConfigState$Actions$RefreshConfig$1$1", f = "ConfigState.kt", l = {247}, m = "invokeSuspend")
                static final class C02361 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ ConfigContext $$this$exec;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C02361(ConfigContext configContext, Continuation<? super C02361> continuation) {
                        super(2, continuation);
                        this.$$this$exec = configContext;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new C02361(this.$$this$exec, continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) throws Throwable {
                        Object objF = IntrinsicsKt.f();
                        int i3 = this.label;
                        if (i3 == 0) {
                            ResultKt.b(obj);
                            DeviceHelper deviceHelper = this.$$this$exec.getDeviceHelper();
                            Duration.Companion companion = Duration.f140631b;
                            long jS = DurationKt.s(1, DurationUnit.f140641f);
                            this.label = 1;
                            if (deviceHelper.m1320getEnrichment8Mi8wO0(0, jS, this) == objF) {
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
                        return ((C02361) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
                    }
                }

                /* JADX INFO: renamed from: com.superwall.sdk.config.models.ConfigState$Actions$RefreshConfig$1$2, reason: invalid class name */
                /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                @Metadata
                @DebugMetadata(c = "com.superwall.sdk.config.models.ConfigState$Actions$RefreshConfig$1$2", f = "ConfigState.kt", l = {266}, m = "invokeSuspend")
                static final class AnonymousClass2 extends SuspendLambda implements Function2<Config, Continuation<? super Unit>, Object> {
                    final /* synthetic */ ConfigContext $$this$exec;
                    /* synthetic */ Object L$0;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass2(ConfigContext configContext, Continuation<? super AnonymousClass2> continuation) {
                        super(2, continuation);
                        this.$$this$exec = configContext;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$$this$exec, continuation);
                        anonymousClass2.L$0 = obj;
                        return anonymousClass2;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Config config, Continuation<? super Unit> continuation) {
                        return ((AnonymousClass2) create(config, continuation)).invokeSuspend(Unit.f139807a);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) throws Throwable {
                        Object objF = IntrinsicsKt.f();
                        int i3 = this.label;
                        if (i3 == 0) {
                            ResultKt.b(obj);
                            Config config = (Config) this.L$0;
                            Config config2 = ConfigStateKt.getConfig((ConfigState) this.$$this$exec.getState().getValue());
                            if (config2 != null) {
                                Set<String> setChangedPaywallIds$superwall_release = PaywallPreload.Companion.changedPaywallIds$superwall_release(config2, config);
                                if (!setChangedPaywallIds$superwall_release.isEmpty()) {
                                    this.$$this$exec.getPaywallManager().resetPaywallRequestCache$superwall_release(setChangedPaywallIds$superwall_release);
                                    this.$$this$exec.getPaywallPreload().invalidatePreloadFingerprint$superwall_release();
                                }
                                PaywallPreload paywallPreload = this.$$this$exec.getPaywallPreload();
                                this.L$0 = config;
                                this.label = 1;
                                if (paywallPreload.removeUnusedPaywallVCsFromCache$superwall_release(config2, config, this) == objF) {
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
                }

                /* JADX INFO: renamed from: com.superwall.sdk.config.models.ConfigState$Actions$RefreshConfig$1$3, reason: invalid class name */
                /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                @Metadata
                @DebugMetadata(c = "com.superwall.sdk.config.models.ConfigState$Actions$RefreshConfig$1$3", f = "ConfigState.kt", l = {270}, m = "invokeSuspend")
                static final class AnonymousClass3 extends SuspendLambda implements Function2<Config, Continuation<? super Unit>, Object> {
                    final /* synthetic */ ConfigContext $$this$exec;
                    final /* synthetic */ AtomicInteger $retryCount;
                    final /* synthetic */ long $startTime;
                    /* synthetic */ Object L$0;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass3(ConfigContext configContext, long j3, AtomicInteger atomicInteger, Continuation<? super AnonymousClass3> continuation) {
                        super(2, continuation);
                        this.$$this$exec = configContext;
                        this.$startTime = j3;
                        this.$retryCount = atomicInteger;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.$$this$exec, this.$startTime, this.$retryCount, continuation);
                        anonymousClass3.L$0 = obj;
                        return anonymousClass3;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Config config, Continuation<? super Unit> continuation) {
                        return ((AnonymousClass3) create(config, continuation)).invokeSuspend(Unit.f139807a);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) throws Throwable {
                        Config config;
                        Object objF = IntrinsicsKt.f();
                        int i3 = this.label;
                        if (i3 == 0) {
                            ResultKt.b(obj);
                            Config config2 = (Config) this.L$0;
                            ConfigContext configContext = this.$$this$exec;
                            ApplyConfig applyConfig = new ApplyConfig(config2);
                            this.L$0 = config2;
                            this.label = 1;
                            if (configContext.immediate(applyConfig, this) == objF) {
                                return objF;
                            }
                            config = config2;
                        } else {
                            if (i3 != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            config = (Config) this.L$0;
                            ResultKt.b(obj);
                        }
                        this.$$this$exec.update(new Updates.SetRetrieved(config));
                        this.$$this$exec.track(new InternalSuperwallEvent.ConfigRefresh(false, config.getBuildId(), this.$retryCount.get(), System.currentTimeMillis() - this.$startTime));
                        return Unit.f139807a;
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(boolean z2, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.$force = z2;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$force, continuation);
                    anonymousClass1.L$0 = obj;
                    return anonymousClass1;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(ConfigContext configContext, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(configContext, continuation)).invokeSuspend(Unit.f139807a);
                }

                /* JADX WARN: Removed duplicated region for block: B:34:0x00d2  */
                /* JADX WARN: Removed duplicated region for block: B:37:0x00d9  */
                /* JADX WARN: Removed duplicated region for block: B:38:0x00e7  */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object invokeSuspend(java.lang.Object r14) throws java.lang.Throwable {
                    /*
                        Method dump skipped, instruction units count: 265
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.config.models.ConfigState.Actions.RefreshConfig.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
                }
            }

            public RefreshConfig() {
                this(false, 1, null);
            }

            public static /* synthetic */ RefreshConfig copy$default(RefreshConfig refreshConfig, boolean z2, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    z2 = refreshConfig.force;
                }
                return refreshConfig.copy(z2);
            }

            public final boolean component1() {
                return this.force;
            }

            public final RefreshConfig copy(boolean z2) {
                return new RefreshConfig(z2);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof RefreshConfig) && this.force == ((RefreshConfig) obj).force;
            }

            public final boolean getForce() {
                return this.force;
            }

            public int hashCode() {
                return Boolean.hashCode(this.force);
            }

            public String toString() {
                return "RefreshConfig(force=" + this.force + ")";
            }

            public RefreshConfig(boolean z2) {
                super(new AnonymousClass1(z2, null), null);
                this.force = z2;
            }

            public /* synthetic */ RefreshConfig(boolean z2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
                this((i3 & 1) != 0 ? false : z2);
            }
        }

        public /* synthetic */ Actions(Function2 function2, DefaultConstructorMarker defaultConstructorMarker) {
            this(function2);
        }

        @Override // com.superwall.sdk.misc.primitives.TypedAction
        public Function2<ConfigContext, Continuation<? super Unit>, Object> getExecute() {
            return this.execute;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private Actions(Function2<? super ConfigContext, ? super Continuation<? super Unit>, ? extends Object> function2) {
            this.execute = function2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Failed extends ConfigState {
        private final int retryCount;
        private final Throwable throwable;

        public /* synthetic */ Failed(Throwable th, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
            this(th, (i4 & 2) != 0 ? 0 : i3);
        }

        public static /* synthetic */ Failed copy$default(Failed failed, Throwable th, int i3, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                th = failed.throwable;
            }
            if ((i4 & 2) != 0) {
                i3 = failed.retryCount;
            }
            return failed.copy(th, i3);
        }

        public final Throwable component1() {
            return this.throwable;
        }

        public final int component2() {
            return this.retryCount;
        }

        public final Failed copy(Throwable throwable, int i3) {
            Intrinsics.checkNotNullParameter(throwable, "throwable");
            return new Failed(throwable, i3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Failed)) {
                return false;
            }
            Failed failed = (Failed) obj;
            return Intrinsics.areEqual(this.throwable, failed.throwable) && this.retryCount == failed.retryCount;
        }

        public final int getRetryCount() {
            return this.retryCount;
        }

        public final Throwable getThrowable() {
            return this.throwable;
        }

        public int hashCode() {
            return (this.throwable.hashCode() * 31) + Integer.hashCode(this.retryCount);
        }

        public String toString() {
            return "Failed(throwable=" + this.throwable + ", retryCount=" + this.retryCount + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Failed(Throwable throwable, int i3) {
            super(null);
            Intrinsics.checkNotNullParameter(throwable, "throwable");
            this.throwable = throwable;
            this.retryCount = i3;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class None extends ConfigState {
        public static final None INSTANCE = new None();

        private None() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Retrieved extends ConfigState {
        private final Config config;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Retrieved(Config config) {
            super(null);
            Intrinsics.checkNotNullParameter(config, "config");
            this.config = config;
        }

        public static /* synthetic */ Retrieved copy$default(Retrieved retrieved, Config config, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                config = retrieved.config;
            }
            return retrieved.copy(config);
        }

        public final Config component1() {
            return this.config;
        }

        public final Retrieved copy(Config config) {
            Intrinsics.checkNotNullParameter(config, "config");
            return new Retrieved(config);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Retrieved) && Intrinsics.areEqual(this.config, ((Retrieved) obj).config);
        }

        public final Config getConfig() {
            return this.config;
        }

        public int hashCode() {
            return this.config.hashCode();
        }

        public String toString() {
            return "Retrieved(config=" + this.config + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Retrieving extends ConfigState {
        public static final Retrieving INSTANCE = new Retrieving();

        private Retrieving() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Retrying extends ConfigState {
        public static final Retrying INSTANCE = new Retrying();

        private Retrying() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static abstract class Updates implements Reducer<ConfigState> {
        private final Function1<ConfigState, ConfigState> reduce;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Set extends Updates {
            private final ConfigState state;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Set(final ConfigState state) {
                super(new Function1() { // from class: com.superwall.sdk.config.models.b
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ConfigState.Updates.Set._init_$lambda$0(state, (ConfigState) obj);
                    }
                }, null);
                Intrinsics.checkNotNullParameter(state, "state");
                this.state = state;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final ConfigState _init_$lambda$0(ConfigState configState, ConfigState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return configState;
            }

            public static /* synthetic */ Set copy$default(Set set, ConfigState configState, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    configState = set.state;
                }
                return set.copy(configState);
            }

            public final ConfigState component1() {
                return this.state;
            }

            public final Set copy(ConfigState state) {
                Intrinsics.checkNotNullParameter(state, "state");
                return new Set(state);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Set) && Intrinsics.areEqual(this.state, ((Set) obj).state);
            }

            public final ConfigState getState() {
                return this.state;
            }

            public int hashCode() {
                return this.state.hashCode();
            }

            public String toString() {
                return "Set(state=" + this.state + jTYhJgqLBN.wKwGGglrLTIbLZ;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class SetFailed extends Updates {
            private final Throwable error;
            private final int retryCount;

            public /* synthetic */ SetFailed(Throwable th, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
                this(th, (i4 & 2) != 0 ? 0 : i3);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final ConfigState _init_$lambda$0(Throwable th, int i3, ConfigState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return new Failed(th, i3);
            }

            public static /* synthetic */ SetFailed copy$default(SetFailed setFailed, Throwable th, int i3, int i4, Object obj) {
                if ((i4 & 1) != 0) {
                    th = setFailed.error;
                }
                if ((i4 & 2) != 0) {
                    i3 = setFailed.retryCount;
                }
                return setFailed.copy(th, i3);
            }

            public final Throwable component1() {
                return this.error;
            }

            public final int component2() {
                return this.retryCount;
            }

            public final SetFailed copy(Throwable error, int i3) {
                Intrinsics.checkNotNullParameter(error, "error");
                return new SetFailed(error, i3);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof SetFailed)) {
                    return false;
                }
                SetFailed setFailed = (SetFailed) obj;
                return Intrinsics.areEqual(this.error, setFailed.error) && this.retryCount == setFailed.retryCount;
            }

            public final Throwable getError() {
                return this.error;
            }

            public final int getRetryCount() {
                return this.retryCount;
            }

            public int hashCode() {
                return (this.error.hashCode() * 31) + Integer.hashCode(this.retryCount);
            }

            public String toString() {
                return "SetFailed(error=" + this.error + ", retryCount=" + this.retryCount + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SetFailed(final Throwable error, final int i3) {
                super(new Function1() { // from class: com.superwall.sdk.config.models.c
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ConfigState.Updates.SetFailed._init_$lambda$0(error, i3, (ConfigState) obj);
                    }
                }, null);
                Intrinsics.checkNotNullParameter(error, "error");
                this.error = error;
                this.retryCount = i3;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class SetRetrieved extends Updates {
            private final Config config;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SetRetrieved(final Config config) {
                super(new Function1() { // from class: com.superwall.sdk.config.models.d
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ConfigState.Updates.SetRetrieved._init_$lambda$0(config, (ConfigState) obj);
                    }
                }, null);
                Intrinsics.checkNotNullParameter(config, "config");
                this.config = config;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final ConfigState _init_$lambda$0(Config config, ConfigState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return new Retrieved(config);
            }

            public static /* synthetic */ SetRetrieved copy$default(SetRetrieved setRetrieved, Config config, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    config = setRetrieved.config;
                }
                return setRetrieved.copy(config);
            }

            public final Config component1() {
                return this.config;
            }

            public final SetRetrieved copy(Config config) {
                Intrinsics.checkNotNullParameter(config, "config");
                return new SetRetrieved(config);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof SetRetrieved) && Intrinsics.areEqual(this.config, ((SetRetrieved) obj).config);
            }

            public final Config getConfig() {
                return this.config;
            }

            public int hashCode() {
                return this.config.hashCode();
            }

            public String toString() {
                return "SetRetrieved(config=" + this.config + ")";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class SetRetrieving extends Updates {
            public static final SetRetrieving INSTANCE = new SetRetrieving();

            private SetRetrieving() {
                super(new Function1() { // from class: com.superwall.sdk.config.models.e
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ConfigState.Updates.SetRetrieving._init_$lambda$0((ConfigState) obj);
                    }
                }, null);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final ConfigState _init_$lambda$0(ConfigState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Retrieving.INSTANCE;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class SetRetrying extends Updates {
            public static final SetRetrying INSTANCE = new SetRetrying();

            private SetRetrying() {
                super(new Function1() { // from class: com.superwall.sdk.config.models.f
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ConfigState.Updates.SetRetrying._init_$lambda$0((ConfigState) obj);
                    }
                }, null);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final ConfigState _init_$lambda$0(ConfigState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Retrying.INSTANCE;
            }
        }

        public /* synthetic */ Updates(Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
            this(function1);
        }

        @Override // com.superwall.sdk.misc.primitives.Reducer
        public Function1<ConfigState, ConfigState> getReduce() {
            return this.reduce;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private Updates(Function1<? super ConfigState, ? extends ConfigState> function1) {
            this.reduce = function1;
        }
    }

    public /* synthetic */ ConfigState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private ConfigState() {
    }
}
