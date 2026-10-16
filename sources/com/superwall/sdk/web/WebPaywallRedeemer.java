package com.superwall.sdk.web;

import android.content.Context;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.superwall.sdk.analytics.internal.trackable.InternalSuperwallEvent;
import com.superwall.sdk.analytics.internal.trackable.Trackable;
import com.superwall.sdk.customer.CustomerInfoManager;
import com.superwall.sdk.misc.IOScope;
import com.superwall.sdk.models.entitlements.Entitlement;
import com.superwall.sdk.models.entitlements.SubscriptionStatus;
import com.superwall.sdk.models.entitlements.TransactionReceipt;
import com.superwall.sdk.models.internal.DeviceVendorId;
import com.superwall.sdk.models.internal.RedemptionOwnership;
import com.superwall.sdk.models.internal.RedemptionOwnershipType;
import com.superwall.sdk.models.internal.RedemptionResult;
import com.superwall.sdk.models.internal.WebRedemptionResponse;
import com.superwall.sdk.models.paywall.LocalNotification;
import com.superwall.sdk.models.paywall.LocalNotificationType;
import com.superwall.sdk.network.Network;
import com.superwall.sdk.paywall.presentation.PaywallInfo;
import com.superwall.sdk.storage.LatestRedemptionResponse;
import com.superwall.sdk.storage.Storage;
import com.superwall.sdk.storage.TrackedWebTrialCodes;
import com.superwall.sdk.store.abstractions.product.StoreProduct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonObjectBuilder;

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
public final class WebPaywallRedeemer {
    private final Context context;
    private final CustomerInfoManager customerInfoManager;
    private final CheckForReferral deepLinkReferrer;
    private final Factory factory;
    private final IOScope ioScope;
    private final Network network;
    private Job pollingJob;
    private Job redemptionJob;
    private final Storage storage;
    private final Mutex trialTrackingMutex;

    /* JADX INFO: renamed from: com.superwall.sdk.web.WebPaywallRedeemer$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.web.WebPaywallRedeemer$1", f = "WebPaywallRedeemer.kt", l = {147}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return WebPaywallRedeemer.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                if (WebPaywallRedeemer.this.factory.isWebToAppEnabled()) {
                    WebPaywallRedeemer webPaywallRedeemer = WebPaywallRedeemer.this;
                    this.label = 1;
                    if (webPaywallRedeemer.checkForRefferal(this) == objF) {
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
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public interface Factory {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class DefaultImpls {
            public static long currentTimeMillis(Factory factory) {
                return System.currentTimeMillis();
            }

            public static Object scheduleTrialNotifications(Factory factory, List<LocalNotification> list, Continuation<? super Unit> continuation) {
                return Unit.f139807a;
            }
        }

        void closePaywallIfExists();

        Set<Entitlement> currentPaywallEntitlements();

        long currentTimeMillis();

        void didRedeemLink(RedemptionResult redemptionResult);

        Set<Entitlement> getActiveDeviceEntitlements();

        String getAliasId();

        DeviceVendorId getDeviceId();

        String getExternalAccountId();

        Map<String, Object> getIntegrationProps();

        PaywallInfo getPaywallInfo();

        /* JADX INFO: renamed from: getUserId-P5Wmf0A */
        String mo1270getUserIdP5Wmf0A();

        void internallySetSubscriptionStatus(SubscriptionStatus subscriptionStatus);

        boolean isPaymentSheetOpen();

        Object isPaywallVisible(Continuation<? super Boolean> continuation);

        boolean isWebToAppEnabled();

        long maxAge();

        Object receipts(Continuation<? super List<TransactionReceipt>> continuation);

        Object scheduleTrialNotifications(List<LocalNotification> list, Continuation<? super Unit> continuation);

        Object track(Trackable trackable, Continuation<? super Unit> continuation);

        void trackRestorationFailed(String str);

        Object triggerRestoreInPaywall(Continuation<? super Unit> continuation);

        void willRedeemLink();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public interface RedeemType {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Code implements RedeemType {
            private final String code;
            private final String description;

            public Code(String code) {
                Intrinsics.checkNotNullParameter(code, "code");
                this.code = code;
                this.description = "CODE";
            }

            public static /* synthetic */ Code copy$default(Code code, String str, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    str = code.code;
                }
                return code.copy(str);
            }

            public final String component1() {
                return this.code;
            }

            public final Code copy(String code) {
                Intrinsics.checkNotNullParameter(code, "code");
                return new Code(code);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Code) && Intrinsics.areEqual(this.code, ((Code) obj).code);
            }

            @Override // com.superwall.sdk.web.WebPaywallRedeemer.RedeemType
            public String getCode() {
                return this.code;
            }

            @Override // com.superwall.sdk.web.WebPaywallRedeemer.RedeemType
            public String getDescription() {
                return this.description;
            }

            public int hashCode() {
                return this.code.hashCode();
            }

            public String toString() {
                return "Code(code=" + this.code + ")";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Existing implements RedeemType {
            private static final String code = null;
            public static final Existing INSTANCE = new Existing();
            private static final String description = "EXISTING_CODES";

            private Existing() {
            }

            @Override // com.superwall.sdk.web.WebPaywallRedeemer.RedeemType
            public String getCode() {
                return code;
            }

            @Override // com.superwall.sdk.web.WebPaywallRedeemer.RedeemType
            public String getDescription() {
                return description;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class IntegrationAttributes implements RedeemType {
            public static final IntegrationAttributes INSTANCE = new IntegrationAttributes();
            private static final String description = "INTEGRATION_ATTRIBUTES";

            private IntegrationAttributes() {
            }

            @Override // com.superwall.sdk.web.WebPaywallRedeemer.RedeemType
            public String getCode() {
                return null;
            }

            @Override // com.superwall.sdk.web.WebPaywallRedeemer.RedeemType
            public String getDescription() {
                return description;
            }
        }

        String getCode();

        String getDescription();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[RedemptionOwnershipType.values().length];
            try {
                iArr[RedemptionOwnershipType.AppUser.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RedemptionOwnershipType.Device.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.web.WebPaywallRedeemer$attemptTrialSideEffect$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.web.WebPaywallRedeemer", f = "WebPaywallRedeemer.kt", l = {383}, m = "attemptTrialSideEffect")
    static final class C29501 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C29501(Continuation<? super C29501> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return WebPaywallRedeemer.this.attemptTrialSideEffect(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.web.WebPaywallRedeemer$checkForRefferal$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.web.WebPaywallRedeemer", f = "WebPaywallRedeemer.kt", l = {ModuleDescriptor.MODULE_VERSION, 158}, m = "checkForRefferal")
    static final class C29511 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C29511(Continuation<? super C29511> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return WebPaywallRedeemer.this.checkForRefferal(this);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.web.WebPaywallRedeemer$clear$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.web.WebPaywallRedeemer$clear$1", f = "WebPaywallRedeemer.kt", l = {477}, m = "invokeSuspend")
    static final class C29521 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C29521(Continuation<? super C29521> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return WebPaywallRedeemer.this.new C29521(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                WebPaywallRedeemer webPaywallRedeemer = WebPaywallRedeemer.this;
                RedeemType.Existing existing = RedeemType.Existing.INSTANCE;
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

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C29521) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.web.WebPaywallRedeemer$handleTrialRedemption$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.web.WebPaywallRedeemer", f = "WebPaywallRedeemer.kt", l = {343, 349, 360}, m = "handleTrialRedemption")
    static final class C29531 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C29531(Continuation<? super C29531> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return WebPaywallRedeemer.this.handleTrialRedemption(null, this);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.web.WebPaywallRedeemer$handleTrialRedemption$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.web.WebPaywallRedeemer$handleTrialRedemption$2", f = "WebPaywallRedeemer.kt", l = {550, 353}, m = "invokeSuspend")
    static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ PaywallInfo $paywallInfo;
        final /* synthetic */ RedemptionResult.PaywallInfo.PaywallProduct $product;
        final /* synthetic */ RedemptionResult $result;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(RedemptionResult redemptionResult, PaywallInfo paywallInfo, RedemptionResult.PaywallInfo.PaywallProduct paywallProduct, Continuation<? super AnonymousClass2> continuation) {
            super(1, continuation);
            this.$result = redemptionResult;
            this.$paywallInfo = paywallInfo;
            this.$product = paywallProduct;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return WebPaywallRedeemer.this.new AnonymousClass2(this.$result, this.$paywallInfo, this.$product, continuation);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v0 */
        /* JADX WARN: Type inference failed for: r3v1, types: [kotlinx.coroutines.sync.Mutex] */
        /* JADX WARN: Type inference failed for: r3v14 */
        /* JADX WARN: Type inference failed for: r3v15 */
        /* JADX WARN: Type inference failed for: r3v5, types: [kotlinx.coroutines.sync.Mutex] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            RedemptionResult redemptionResult;
            RedemptionResult.PaywallInfo.PaywallProduct paywallProduct;
            Mutex mutex;
            PaywallInfo paywallInfo;
            WebPaywallRedeemer webPaywallRedeemer;
            RedemptionResult redemptionResult2;
            Set set;
            WebPaywallRedeemer webPaywallRedeemer2;
            Mutex mutex2;
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            ?? r3 = 1;
            try {
                if (i3 == 0) {
                    ResultKt.b(obj);
                    Mutex mutex3 = WebPaywallRedeemer.this.trialTrackingMutex;
                    WebPaywallRedeemer webPaywallRedeemer3 = WebPaywallRedeemer.this;
                    redemptionResult = this.$result;
                    PaywallInfo paywallInfo2 = this.$paywallInfo;
                    paywallProduct = this.$product;
                    this.L$0 = mutex3;
                    this.L$1 = webPaywallRedeemer3;
                    this.L$2 = redemptionResult;
                    this.L$3 = paywallInfo2;
                    this.L$4 = paywallProduct;
                    this.label = 1;
                    if (mutex3.f(null, this) != objF) {
                        mutex = mutex3;
                        paywallInfo = paywallInfo2;
                        webPaywallRedeemer = webPaywallRedeemer3;
                    }
                    return objF;
                }
                if (i3 != 1) {
                    if (i3 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    set = (Set) this.L$3;
                    redemptionResult2 = (RedemptionResult) this.L$2;
                    webPaywallRedeemer2 = (WebPaywallRedeemer) this.L$1;
                    Mutex mutex4 = (Mutex) this.L$0;
                    ResultKt.b(obj);
                    mutex2 = mutex4;
                    webPaywallRedeemer2.storage.write(TrackedWebTrialCodes.INSTANCE, SetsKt.plus((Set<? extends String>) set, ((RedemptionResult.Success) redemptionResult2).getCode()));
                    r3 = mutex2;
                    Unit unit = Unit.f139807a;
                    r3.i(null);
                    return Unit.f139807a;
                }
                RedemptionResult.PaywallInfo.PaywallProduct paywallProduct2 = (RedemptionResult.PaywallInfo.PaywallProduct) this.L$4;
                PaywallInfo paywallInfo3 = (PaywallInfo) this.L$3;
                redemptionResult = (RedemptionResult) this.L$2;
                webPaywallRedeemer = (WebPaywallRedeemer) this.L$1;
                Mutex mutex5 = (Mutex) this.L$0;
                ResultKt.b(obj);
                paywallInfo = paywallInfo3;
                mutex = mutex5;
                paywallProduct = paywallProduct2;
                redemptionResult2 = redemptionResult;
                Set setEmptySet = (Set) webPaywallRedeemer.storage.read(TrackedWebTrialCodes.INSTANCE);
                if (setEmptySet == null) {
                    setEmptySet = SetsKt.emptySet();
                }
                r3 = mutex;
                if (!setEmptySet.contains(((RedemptionResult.Success) redemptionResult2).getCode())) {
                    InternalSuperwallEvent.FreeTrialStart freeTrialStart = new InternalSuperwallEvent.FreeTrialStart(paywallInfo, new StoreProduct(new RedemptionStoreProduct(paywallProduct)));
                    this.L$0 = mutex;
                    this.L$1 = webPaywallRedeemer;
                    this.L$2 = redemptionResult2;
                    this.L$3 = setEmptySet;
                    this.L$4 = null;
                    this.label = 2;
                    if (webPaywallRedeemer.track(freeTrialStart, this) != objF) {
                        set = setEmptySet;
                        webPaywallRedeemer2 = webPaywallRedeemer;
                        mutex2 = mutex;
                        webPaywallRedeemer2.storage.write(TrackedWebTrialCodes.INSTANCE, SetsKt.plus((Set<? extends String>) set, ((RedemptionResult.Success) redemptionResult2).getCode()));
                        r3 = mutex2;
                    }
                    return objF;
                }
                Unit unit2 = Unit.f139807a;
                r3.i(null);
                return Unit.f139807a;
            } catch (Throwable th) {
                r3.i(null);
                throw th;
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.web.WebPaywallRedeemer$handleTrialRedemption$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.web.WebPaywallRedeemer$handleTrialRedemption$3", f = "WebPaywallRedeemer.kt", l = {361}, m = "invokeSuspend")
    static final class AnonymousClass3 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ List<LocalNotification> $reminders;
        int label;

        /* JADX INFO: renamed from: com.superwall.sdk.web.WebPaywallRedeemer$handleTrialRedemption$3$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @DebugMetadata(c = "com.superwall.sdk.web.WebPaywallRedeemer$handleTrialRedemption$3$1", f = "WebPaywallRedeemer.kt", l = {362}, m = "invokeSuspend")
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ List<LocalNotification> $reminders;
            int label;
            final /* synthetic */ WebPaywallRedeemer this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(WebPaywallRedeemer webPaywallRedeemer, List<LocalNotification> list, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = webPaywallRedeemer;
                this.$reminders = list;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, this.$reminders, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objF = IntrinsicsKt.f();
                int i3 = this.label;
                if (i3 == 0) {
                    ResultKt.b(obj);
                    Factory factory = this.this$0.factory;
                    List<LocalNotification> list = this.$reminders;
                    this.label = 1;
                    if (factory.scheduleTrialNotifications(list, this) == objF) {
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
        AnonymousClass3(List<LocalNotification> list, Continuation<? super AnonymousClass3> continuation) {
            super(1, continuation);
            this.$reminders = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return WebPaywallRedeemer.this.new AnonymousClass3(this.$reminders, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(WebPaywallRedeemer.this, this.$reminders, null);
                this.label = 1;
                if (TimeoutKt.e(30000L, anonymousClass1, this) == objF) {
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
            return ((AnonymousClass3) create(continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.web.WebPaywallRedeemer$redeem$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.web.WebPaywallRedeemer", f = "WebPaywallRedeemer.kt", l = {211, 212, 220, 227, 222, 238, 279, 280, 285, 305, 332}, m = "redeem")
    static final class C29541 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        /* synthetic */ Object result;

        C29541(Continuation<? super C29541> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return WebPaywallRedeemer.this.redeem(null, this);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.web.WebPaywallRedeemer$startPolling$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.web.WebPaywallRedeemer$startPolling$1", f = "WebPaywallRedeemer.kt", l = {486, 539}, m = "invokeSuspend")
    static final class C29551 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ long $maxAge;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C29551(long j3, Continuation<? super C29551> continuation) {
            super(2, continuation);
            this.$maxAge = j3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return WebPaywallRedeemer.this.new C29551(this.$maxAge, continuation);
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0022  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0040 A[PHI: r2
          0x0040: PHI (r2v3 java.lang.Object) = (r2v2 java.lang.Object), (r2v15 java.lang.Object) binds: [B:12:0x003c, B:9:0x0019] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:16:0x0048  */
        /* JADX WARN: Removed duplicated region for block: B:59:0x0191  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:63:0x01a6 -> B:11:0x0022). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r19) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 431
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.web.WebPaywallRedeemer.C29551.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C29551) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    public WebPaywallRedeemer(Context context, IOScope ioScope, CheckForReferral deepLinkReferrer, Network network, Storage storage, CustomerInfoManager customerInfoManager, Factory factory) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(ioScope, "ioScope");
        Intrinsics.checkNotNullParameter(deepLinkReferrer, "deepLinkReferrer");
        Intrinsics.checkNotNullParameter(network, "network");
        Intrinsics.checkNotNullParameter(storage, "storage");
        Intrinsics.checkNotNullParameter(customerInfoManager, "customerInfoManager");
        Intrinsics.checkNotNullParameter(factory, "factory");
        this.context = context;
        this.ioScope = ioScope;
        this.deepLinkReferrer = deepLinkReferrer;
        this.network = network;
        this.storage = storage;
        this.customerInfoManager = customerInfoManager;
        this.factory = factory;
        this.trialTrackingMutex = MutexKt.b(false, 1, null);
        BuildersKt__Builders_commonKt.d(ioScope, null, null, new AnonymousClass1(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object attemptTrialSideEffect(java.lang.String r9, kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11) throws java.lang.Throwable {
        /*
            r8 = this;
            boolean r0 = r11 instanceof com.superwall.sdk.web.WebPaywallRedeemer.C29501
            if (r0 == 0) goto L13
            r0 = r11
            com.superwall.sdk.web.WebPaywallRedeemer$attemptTrialSideEffect$1 r0 = (com.superwall.sdk.web.WebPaywallRedeemer.C29501) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.superwall.sdk.web.WebPaywallRedeemer$attemptTrialSideEffect$1 r0 = new com.superwall.sdk.web.WebPaywallRedeemer$attemptTrialSideEffect$1
            r0.<init>(r11)
        L18:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r9 = r0.L$0
            java.lang.String r9 = (java.lang.String) r9
            kotlin.ResultKt.b(r11)     // Catch: java.lang.Exception -> L2d java.util.concurrent.CancellationException -> L31
            goto L68
        L2d:
            r0 = move-exception
            r10 = r0
            r5 = r10
            goto L4a
        L31:
            r0 = move-exception
            r9 = r0
            goto L6b
        L34:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L3c:
            kotlin.ResultKt.b(r11)
            r0.L$0 = r9     // Catch: java.lang.Exception -> L2d java.util.concurrent.CancellationException -> L31
            r0.label = r3     // Catch: java.lang.Exception -> L2d java.util.concurrent.CancellationException -> L31
            java.lang.Object r9 = r10.invoke(r0)     // Catch: java.lang.Exception -> L2d java.util.concurrent.CancellationException -> L31
            if (r9 != r1) goto L68
            return r1
        L4a:
            com.superwall.sdk.logger.Logger r0 = com.superwall.sdk.logger.Logger.INSTANCE
            com.superwall.sdk.logger.LogLevel r1 = com.superwall.sdk.logger.LogLevel.error
            com.superwall.sdk.logger.LogScope r2 = com.superwall.sdk.logger.LogScope.webEntitlements
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "Failed to "
            r10.append(r11)
            r10.append(r9)
            java.lang.String r3 = r10.toString()
            r6 = 8
            r7 = 0
            r4 = 0
            com.superwall.sdk.logger.Logger.debug$default(r0, r1, r2, r3, r4, r5, r6, r7)
        L68:
            kotlin.Unit r9 = kotlin.Unit.f139807a
            return r9
        L6b:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.web.WebPaywallRedeemer.attemptTrialSideEffect(java.lang.String, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final JsonElement convertToJsonElement(Object obj) {
        JsonElement jsonElementConvertToJsonElement;
        if (obj == null) {
            return null;
        }
        if (obj instanceof String) {
            return JsonElementKt.c((String) obj);
        }
        if (obj instanceof Number) {
            return JsonElementKt.b((Number) obj);
        }
        if (obj instanceof Boolean) {
            return JsonElementKt.a((Boolean) obj);
        }
        if (!(obj instanceof Map)) {
            if (!(obj instanceof Collection)) {
                return JsonElementKt.c(obj.toString());
            }
            ArrayList arrayList = new ArrayList();
            Iterator it = ((Iterable) obj).iterator();
            while (it.hasNext()) {
                JsonElement jsonElementConvertToJsonElement2 = convertToJsonElement(it.next());
                if (jsonElementConvertToJsonElement2 != null) {
                    arrayList.add(jsonElementConvertToJsonElement2);
                }
            }
            return new JsonArray(arrayList);
        }
        JsonObjectBuilder jsonObjectBuilder = new JsonObjectBuilder();
        for (Map.Entry entry : ((Map) obj).entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            if ((key instanceof String) && value != null && (jsonElementConvertToJsonElement = convertToJsonElement(value)) != null) {
                jsonObjectBuilder.b((String) key, jsonElementConvertToJsonElement);
            }
        }
        return jsonObjectBuilder.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00ec, code lost:
    
        if (r4.attemptTrialSideEffect("schedule web trial notifications", r15, r0) == r1) goto L53;
     */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object handleTrialRedemption(com.superwall.sdk.models.internal.RedemptionResult r14, kotlin.coroutines.Continuation<? super kotlin.Unit> r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 248
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.web.WebPaywallRedeemer.handleTrialRedemption(com.superwall.sdk.models.internal.RedemptionResult, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void startPolling(long j3) {
        Job job = this.pollingJob;
        if (job != null) {
            Job.DefaultImpls.b(job, null, 1, null);
        }
        this.pollingJob = BuildersKt__Builders_commonKt.d(CoroutineScopeKt.i(this.ioScope, Dispatchers.b()), null, null, new C29551(j3, null), 3, null);
    }

    static /* synthetic */ void startPolling$default(WebPaywallRedeemer webPaywallRedeemer, long j3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = webPaywallRedeemer.factory.maxAge();
        }
        webPaywallRedeemer.startPolling(j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object track(Trackable trackable, Continuation<? super Unit> continuation) {
        Object objTrack = this.factory.track(trackable, continuation);
        return objTrack == IntrinsicsKt.f() ? objTrack : Unit.f139807a;
    }

    private final List<LocalNotification> trialReminders(PaywallInfo paywallInfo, RedemptionResult.PaywallInfo.PaywallProduct paywallProduct) {
        Long lWebTrialReminderDelay;
        List<LocalNotification> localNotifications = paywallInfo.getLocalNotifications();
        ArrayList arrayList = new ArrayList();
        for (LocalNotification localNotification : localNotifications) {
            LocalNotification localNotificationCopy$default = null;
            if (Intrinsics.areEqual(localNotification.getType(), LocalNotificationType.TrialStarted.INSTANCE) && (lWebTrialReminderDelay = WebTrialReminderKt.webTrialReminderDelay(paywallProduct, localNotification.getDelay(), this.factory.currentTimeMillis())) != null) {
                localNotificationCopy$default = LocalNotification.copy$default(localNotification, paywallInfo.getIdentifier() + "_" + localNotification.getType().getRaw(), null, null, null, null, lWebTrialReminderDelay.longValue(), 30, null);
            }
            if (localNotificationCopy$default != null) {
                arrayList.add(localNotificationCopy$default);
            }
        }
        return arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x006b, code lost:
    
        if (r2.redeem(r4, r0) == r1) goto L30;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object checkForRefferal(kotlin.coroutines.Continuation<? super com.superwall.sdk.misc.Either<kotlin.Unit, java.lang.Throwable>> r6) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.superwall.sdk.web.WebPaywallRedeemer.C29511
            if (r0 == 0) goto L13
            r0 = r6
            com.superwall.sdk.web.WebPaywallRedeemer$checkForRefferal$1 r0 = (com.superwall.sdk.web.WebPaywallRedeemer.C29511) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.superwall.sdk.web.WebPaywallRedeemer$checkForRefferal$1 r0 = new com.superwall.sdk.web.WebPaywallRedeemer$checkForRefferal$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L44
            if (r2 == r4) goto L36
            if (r2 != r3) goto L2e
            kotlin.ResultKt.b(r6)     // Catch: java.lang.Throwable -> L2c
            goto L6e
        L2c:
            r6 = move-exception
            goto L77
        L2e:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L36:
            java.lang.Object r2 = r0.L$0
            com.superwall.sdk.web.WebPaywallRedeemer r2 = (com.superwall.sdk.web.WebPaywallRedeemer) r2
            kotlin.ResultKt.b(r6)     // Catch: java.lang.Throwable -> L2c
            kotlin.Result r6 = (kotlin.Result) r6     // Catch: java.lang.Throwable -> L2c
            java.lang.Object r6 = r6.j()     // Catch: java.lang.Throwable -> L2c
            goto L55
        L44:
            kotlin.ResultKt.b(r6)
            com.superwall.sdk.web.CheckForReferral r6 = r5.deepLinkReferrer     // Catch: java.lang.Throwable -> L2c
            r0.L$0 = r5     // Catch: java.lang.Throwable -> L2c
            r0.label = r4     // Catch: java.lang.Throwable -> L2c
            java.lang.Object r6 = r6.mo1345checkForReferralIoAF18A(r0)     // Catch: java.lang.Throwable -> L2c
            if (r6 != r1) goto L54
            goto L6d
        L54:
            r2 = r5
        L55:
            java.lang.Throwable r4 = kotlin.Result.e(r6)     // Catch: java.lang.Throwable -> L2c
            if (r4 != 0) goto L76
            java.lang.String r6 = (java.lang.String) r6     // Catch: java.lang.Throwable -> L2c
            com.superwall.sdk.web.WebPaywallRedeemer$RedeemType$Code r4 = new com.superwall.sdk.web.WebPaywallRedeemer$RedeemType$Code     // Catch: java.lang.Throwable -> L2c
            r4.<init>(r6)     // Catch: java.lang.Throwable -> L2c
            r6 = 0
            r0.L$0 = r6     // Catch: java.lang.Throwable -> L2c
            r0.label = r3     // Catch: java.lang.Throwable -> L2c
            java.lang.Object r6 = r2.redeem(r4, r0)     // Catch: java.lang.Throwable -> L2c
            if (r6 != r1) goto L6e
        L6d:
            return r1
        L6e:
            kotlin.Unit r6 = kotlin.Unit.f139807a     // Catch: java.lang.Throwable -> L2c
            com.superwall.sdk.misc.Either$Success r0 = new com.superwall.sdk.misc.Either$Success     // Catch: java.lang.Throwable -> L2c
            r0.<init>(r6)     // Catch: java.lang.Throwable -> L2c
            return r0
        L76:
            throw r4     // Catch: java.lang.Throwable -> L2c
        L77:
            com.superwall.sdk.misc.Either$Failure r0 = new com.superwall.sdk.misc.Either$Failure
            r0.<init>(r6)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.web.WebPaywallRedeemer.checkForRefferal(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    /* JADX INFO: renamed from: checkForWebEntitlements-AKGx8qU, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object m1347checkForWebEntitlementsAKGx8qU(java.lang.String r18, com.superwall.sdk.models.internal.DeviceVendorId r19, kotlin.coroutines.Continuation<? super com.superwall.sdk.misc.Either<? extends java.util.Set<com.superwall.sdk.models.entitlements.Entitlement>, java.lang.Throwable>> r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 305
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.web.WebPaywallRedeemer.m1347checkForWebEntitlementsAKGx8qU(java.lang.String, com.superwall.sdk.models.internal.DeviceVendorId, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void clear(RedemptionOwnershipType ownership) {
        ArrayList arrayList;
        WebRedemptionResponse webRedemptionResponseCopy$default;
        List<RedemptionResult> codes;
        boolean z2;
        Intrinsics.checkNotNullParameter(ownership, "ownership");
        WebRedemptionResponse webRedemptionResponse = (WebRedemptionResponse) this.storage.read(LatestRedemptionResponse.INSTANCE);
        if (webRedemptionResponse == null || (codes = webRedemptionResponse.getCodes()) == null) {
            arrayList = null;
        } else {
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : codes) {
                if (obj instanceof RedemptionResult.Success) {
                    arrayList2.add(obj);
                }
            }
            arrayList = new ArrayList();
            int size = arrayList2.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj2 = arrayList2.get(i3);
                i3++;
                RedemptionResult.Success success = (RedemptionResult.Success) obj2;
                int i4 = WhenMappings.$EnumSwitchMapping$0[ownership.ordinal()];
                if (i4 == 1) {
                    z2 = success.getRedemptionInfo().getOwnership() instanceof RedemptionOwnership.AppUser;
                } else {
                    if (i4 != 2) {
                        throw new NoWhenBranchMatchedException();
                    }
                    z2 = success.getRedemptionInfo().getOwnership() instanceof RedemptionOwnership.Device;
                }
                if (z2) {
                    arrayList.add(obj2);
                }
            }
        }
        if (webRedemptionResponse != null) {
            List<RedemptionResult> codes2 = webRedemptionResponse.getCodes();
            ArrayList arrayList3 = arrayList;
            ArrayList arrayList4 = new ArrayList();
            for (Object obj3 : codes2) {
                if (!CollectionsKt.contains(arrayList3 == null ? CollectionsKt.emptyList() : arrayList3, (RedemptionResult) obj3)) {
                    arrayList4.add(obj3);
                }
            }
            webRedemptionResponseCopy$default = WebRedemptionResponse.copy$default(webRedemptionResponse, arrayList4, null, null, 6, null);
        } else {
            webRedemptionResponseCopy$default = null;
        }
        if (webRedemptionResponseCopy$default != null) {
            this.storage.write(LatestRedemptionResponse.INSTANCE, webRedemptionResponseCopy$default);
        }
        this.factory.internallySetSubscriptionStatus(new SubscriptionStatus.Active(this.factory.getActiveDeviceEntitlements()));
        Job job = this.redemptionJob;
        if (job != null) {
            Job.DefaultImpls.b(job, null, 1, null);
        }
        this.redemptionJob = BuildersKt__Builders_commonKt.d(this.ioScope, null, null, new C29521(null), 3, null);
    }

    public final CustomerInfoManager getCustomerInfoManager$superwall_release() {
        return this.customerInfoManager;
    }

    public final CheckForReferral getDeepLinkReferrer$superwall_release() {
        return this.deepLinkReferrer;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:111:0x03c1  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x03c4  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x03e2  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0424  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0427  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0475 A[PHI: r0 r1 r2 r4 r7 r15
      0x0475: PHI (r0v22 java.util.Set) = (r0v20 java.util.Set), (r0v23 java.util.Set) binds: [B:139:0x0471, B:16:0x006e] A[DONT_GENERATE, DONT_INLINE]
      0x0475: PHI (r1v34 ??) = (r1v59 ??), (r1v60 ??) binds: [B:139:0x0471, B:16:0x006e] A[DONT_GENERATE, DONT_INLINE]
      0x0475: PHI (r2v55 java.lang.Object) = (r2v54 java.lang.Object), (r2v1 java.lang.Object) binds: [B:139:0x0471, B:16:0x006e] A[DONT_GENERATE, DONT_INLINE]
      0x0475: PHI (r4v59 com.superwall.sdk.models.internal.WebRedemptionResponse) = 
      (r4v56 com.superwall.sdk.models.internal.WebRedemptionResponse)
      (r4v63 com.superwall.sdk.models.internal.WebRedemptionResponse)
     binds: [B:139:0x0471, B:16:0x006e] A[DONT_GENERATE, DONT_INLINE]
      0x0475: PHI (r7v27 com.superwall.sdk.web.WebPaywallRedeemer) = (r7v24 com.superwall.sdk.web.WebPaywallRedeemer), (r7v29 com.superwall.sdk.web.WebPaywallRedeemer) binds: [B:139:0x0471, B:16:0x006e] A[DONT_GENERATE, DONT_INLINE]
      0x0475: PHI (r15v22 int) = (r15v20 int), (r15v23 int) binds: [B:139:0x0471, B:16:0x006e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:158:0x04ea  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x04ed  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0507  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0512  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x052b  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x053b  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0564  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x05d8  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0221 A[PHI: r1 r2 r7
      0x0221: PHI (r1v5 com.superwall.sdk.web.WebPaywallRedeemer$RedeemType) = 
      (r1v0 com.superwall.sdk.web.WebPaywallRedeemer$RedeemType)
      (r1v1 com.superwall.sdk.web.WebPaywallRedeemer$RedeemType)
      (r1v1 com.superwall.sdk.web.WebPaywallRedeemer$RedeemType)
      (r1v1 com.superwall.sdk.web.WebPaywallRedeemer$RedeemType)
      (r1v8 com.superwall.sdk.web.WebPaywallRedeemer$RedeemType)
     binds: [B:61:0x0220, B:55:0x01f8, B:57:0x0200, B:59:0x021c, B:22:0x00f0] A[DONT_GENERATE, DONT_INLINE]
      0x0221: PHI (r2v22 java.util.List<com.superwall.sdk.models.entitlements.Redeemable>) = 
      (r2v15 java.util.List<com.superwall.sdk.models.entitlements.Redeemable>)
      (r2v20 java.util.List<com.superwall.sdk.models.entitlements.Redeemable>)
      (r2v20 java.util.List<com.superwall.sdk.models.entitlements.Redeemable>)
      (r2v20 java.util.List<com.superwall.sdk.models.entitlements.Redeemable>)
      (r2v23 java.util.List<com.superwall.sdk.models.entitlements.Redeemable>)
     binds: [B:61:0x0220, B:55:0x01f8, B:57:0x0200, B:59:0x021c, B:22:0x00f0] A[DONT_GENERATE, DONT_INLINE]
      0x0221: PHI (r7v9 com.superwall.sdk.web.WebPaywallRedeemer) = 
      (r7v2 com.superwall.sdk.web.WebPaywallRedeemer)
      (r7v6 com.superwall.sdk.web.WebPaywallRedeemer)
      (r7v6 com.superwall.sdk.web.WebPaywallRedeemer)
      (r7v6 com.superwall.sdk.web.WebPaywallRedeemer)
      (r7v11 com.superwall.sdk.web.WebPaywallRedeemer)
     binds: [B:61:0x0220, B:55:0x01f8, B:57:0x0200, B:59:0x021c, B:22:0x00f0] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0239  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x026a  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x028b  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x028e  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x032c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001a  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0352  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x035e  */
    /* JADX WARN: Type inference failed for: r1v28 */
    /* JADX WARN: Type inference failed for: r1v31, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v34, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v38, types: [com.superwall.sdk.web.WebPaywallRedeemer$Factory] */
    /* JADX WARN: Type inference failed for: r1v39 */
    /* JADX WARN: Type inference failed for: r1v57 */
    /* JADX WARN: Type inference failed for: r1v58 */
    /* JADX WARN: Type inference failed for: r1v59 */
    /* JADX WARN: Type inference failed for: r1v60 */
    /* JADX WARN: Type inference failed for: r1v61 */
    /* JADX WARN: Type inference failed for: r6v22 */
    /* JADX WARN: Type inference failed for: r6v23, types: [com.superwall.sdk.models.internal.RedemptionResult, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v33 */
    /* JADX WARN: Type inference failed for: r6v41, types: [com.superwall.sdk.models.internal.RedemptionResult] */
    /* JADX WARN: Type inference failed for: r6v42 */
    /* JADX WARN: Type inference failed for: r6v46 */
    /* JADX WARN: Type inference failed for: r6v47 */
    /* JADX WARN: Type inference failed for: r6v48 */
    /* JADX WARN: Type inference failed for: r6v49 */
    /* JADX WARN: Type inference failed for: r6v50 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object redeem(com.superwall.sdk.web.WebPaywallRedeemer.RedeemType r27, kotlin.coroutines.Continuation<? super kotlin.Unit> r28) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 1546
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.web.WebPaywallRedeemer.redeem(com.superwall.sdk.web.WebPaywallRedeemer$RedeemType, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
