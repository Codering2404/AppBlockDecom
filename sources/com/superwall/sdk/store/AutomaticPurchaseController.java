package com.superwall.sdk.store;

import android.app.Activity;
import android.content.Context;
import androidx.compose.material.icons.twotone.Phg.QaXmqxvjHhxVy;
import com.android.billingclient.api.AcknowledgePurchaseParams;
import com.android.billingclient.api.AcknowledgePurchaseResponseListener;
import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingClientStateListener;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.PendingPurchasesParams;
import com.android.billingclient.api.ProductDetails;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.PurchasesUpdatedListener;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.ads_identifier.mrU.pMpIcGE;
import com.superwall.sdk.Superwall;
import com.superwall.sdk.billing.GoogleBillingWrapperKt;
import com.superwall.sdk.delegate.PurchaseResult;
import com.superwall.sdk.delegate.subscription_controller.PurchaseController;
import com.superwall.sdk.logger.LogLevel;
import com.superwall.sdk.logger.LogScope;
import com.superwall.sdk.logger.Logger;
import com.superwall.sdk.misc.IOScope;
import com.superwall.sdk.models.entitlements.Entitlement;
import com.superwall.sdk.store.abstractions.product.StoreProduct;
import com.superwall.sdk.store.transactions.PlayBillingErrors;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
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
public final class AutomaticPurchaseController implements PurchaseController, PurchasesUpdatedListener {
    private static final long CONNECTION_TIMEOUT_MS = 10000;
    public static final Companion Companion = new Companion(null);
    private static final int MAX_RETRIES = 3;
    private static final long QUERY_TIMEOUT_MS = 10000;
    private BillingClient billingClient;
    private final MutableStateFlow<ConnectionState> connectionState;
    private Context context;
    private final Function0<Entitlements> entitlementsInfo;
    private final Function2<Context, PurchasesUpdatedListener, BillingClient> getBilling;
    private final MutableStateFlow<PurchaseResult> purchaseResults;
    private long reconnectMilliseconds;
    private final IOScope scope;

    /* JADX INFO: renamed from: com.superwall.sdk.store.AutomaticPurchaseController$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.store.AutomaticPurchaseController$3", f = "AutomaticPurchaseController.kt", l = {}, m = "invokeSuspend")
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass3(Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AutomaticPurchaseController.this.new AnonymousClass3(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            AutomaticPurchaseController.this.startConnection();
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class ConnectionState {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ConnectionState[] $VALUES;
        public static final ConnectionState Connecting = new ConnectionState("Connecting", 0);
        public static final ConnectionState Connected = new ConnectionState("Connected", 1);
        public static final ConnectionState Failed = new ConnectionState(AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_FAILED, 2);

        private static final /* synthetic */ ConnectionState[] $values() {
            return new ConnectionState[]{Connecting, Connected, Failed};
        }

        static {
            ConnectionState[] connectionStateArr$values = $values();
            $VALUES = connectionStateArr$values;
            $ENTRIES = EnumEntriesKt.a(connectionStateArr$values);
        }

        private ConnectionState(String str, int i3) {
        }

        public static EnumEntries<ConnectionState> getEntries() {
            return $ENTRIES;
        }

        public static ConnectionState valueOf(String str) {
            return (ConnectionState) Enum.valueOf(ConnectionState.class, str);
        }

        public static ConnectionState[] values() {
            return (ConnectionState[]) $VALUES.clone();
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.store.AutomaticPurchaseController$onPurchasesUpdated$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.store.AutomaticPurchaseController$onPurchasesUpdated$1", f = "AutomaticPurchaseController.kt", l = {333}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PurchaseResult $result;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(PurchaseResult purchaseResult, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$result = purchaseResult;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AutomaticPurchaseController.this.new AnonymousClass1(this.$result, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                MutableStateFlow mutableStateFlow = AutomaticPurchaseController.this.purchaseResults;
                PurchaseResult purchaseResult = this.$result;
                this.label = 1;
                if (mutableStateFlow.emit(purchaseResult, this) == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            AutomaticPurchaseController.this.syncSubscriptionStatus();
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.store.AutomaticPurchaseController$purchase$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.store.AutomaticPurchaseController", f = "AutomaticPurchaseController.kt", l = {279, 290}, m = "purchase")
    static final class C29121 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C29121(Continuation<? super C29121> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AutomaticPurchaseController.this.purchase((Activity) null, (ProductDetails) null, (String) null, (String) null, this);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.store.AutomaticPurchaseController$purchase$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.store.AutomaticPurchaseController$purchase$2", f = "AutomaticPurchaseController.kt", l = {}, m = "invokeSuspend")
    static final class AnonymousClass2 extends SuspendLambda implements Function2<ConnectionState, Continuation<? super Boolean>, Object> {
        /* synthetic */ Object L$0;
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ConnectionState connectionState, Continuation<? super Boolean> continuation) {
            return ((AnonymousClass2) create(connectionState, continuation)).invokeSuspend(Unit.f139807a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            return Boxing.a(((ConnectionState) this.L$0) == ConnectionState.Connected);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.store.AutomaticPurchaseController$restorePurchases$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.store.AutomaticPurchaseController", f = "AutomaticPurchaseController.kt", l = {296}, m = "restorePurchases")
    static final class C29131 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C29131(Continuation<? super C29131> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AutomaticPurchaseController.this.restorePurchases(this);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.store.AutomaticPurchaseController$syncSubscriptionStatus$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.store.AutomaticPurchaseController$syncSubscriptionStatus$1", f = "AutomaticPurchaseController.kt", l = {159, 160}, m = "invokeSuspend")
    static final class C29151 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        /* JADX INFO: renamed from: com.superwall.sdk.store.AutomaticPurchaseController$syncSubscriptionStatus$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @DebugMetadata(c = "com.superwall.sdk.store.AutomaticPurchaseController$syncSubscriptionStatus$1$1", f = "AutomaticPurchaseController.kt", l = {}, m = "invokeSuspend")
        static final class C02541 extends SuspendLambda implements Function2<Boolean, Continuation<? super Boolean>, Object> {
            /* synthetic */ boolean Z$0;
            int label;

            C02541(Continuation<? super C02541> continuation) {
                super(2, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C02541 c02541 = new C02541(continuation);
                c02541.Z$0 = ((Boolean) obj).booleanValue();
                return c02541;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return invoke(((Boolean) obj).booleanValue(), (Continuation<? super Boolean>) obj2);
            }

            public final Object invoke(boolean z2, Continuation<? super Boolean> continuation) {
                return ((C02541) create(Boolean.valueOf(z2), continuation)).invokeSuspend(Unit.f139807a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                IntrinsicsKt.f();
                if (this.label == 0) {
                    ResultKt.b(obj);
                    return Boxing.a(this.Z$0);
                }
                throw new IllegalStateException(QaXmqxvjHhxVy.vFJi);
            }
        }

        C29151(Continuation<? super C29151> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AutomaticPurchaseController.this.new C29151(continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x003f, code lost:
        
            if (com.superwall.sdk.store.AutomaticPurchaseController.syncSubscriptionStatusAndWait$default(r6, 0, r5, 1, null) == r0) goto L15;
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
                r2 = 0
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L1f
                if (r1 == r4) goto L1b
                if (r1 != r3) goto L13
                kotlin.ResultKt.b(r6)
                goto L42
            L13:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            L1b:
                kotlin.ResultKt.b(r6)
                goto L36
            L1f:
                kotlin.ResultKt.b(r6)
                com.superwall.sdk.Superwall$Companion r6 = com.superwall.sdk.Superwall.Companion
                kotlinx.coroutines.flow.Flow r6 = r6.getHasInitialized()
                com.superwall.sdk.store.AutomaticPurchaseController$syncSubscriptionStatus$1$1 r1 = new com.superwall.sdk.store.AutomaticPurchaseController$syncSubscriptionStatus$1$1
                r1.<init>(r2)
                r5.label = r4
                java.lang.Object r6 = kotlinx.coroutines.flow.FlowKt.E(r6, r1, r5)
                if (r6 != r0) goto L36
                goto L41
            L36:
                com.superwall.sdk.store.AutomaticPurchaseController r6 = com.superwall.sdk.store.AutomaticPurchaseController.this
                r5.label = r3
                r1 = 0
                java.lang.Object r6 = com.superwall.sdk.store.AutomaticPurchaseController.syncSubscriptionStatusAndWait$default(r6, r1, r5, r4, r2)
                if (r6 != r0) goto L42
            L41:
                return r0
            L42:
                kotlin.Unit r6 = kotlin.Unit.f139807a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.store.AutomaticPurchaseController.C29151.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C29151) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.store.AutomaticPurchaseController$syncSubscriptionStatusAndWait$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.store.AutomaticPurchaseController", f = "AutomaticPurchaseController.kt", l = {349, 351, 381, 410}, m = "syncSubscriptionStatusAndWait")
    static final class C29161 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C29161(Continuation<? super C29161> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AutomaticPurchaseController.this.syncSubscriptionStatusAndWait(0, this);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.store.AutomaticPurchaseController$syncSubscriptionStatusAndWait$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.store.AutomaticPurchaseController$syncSubscriptionStatusAndWait$2", f = "AutomaticPurchaseController.kt", l = {349}, m = "invokeSuspend")
    static final class C29172 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ConnectionState>, Object> {
        int label;

        /* JADX INFO: renamed from: com.superwall.sdk.store.AutomaticPurchaseController$syncSubscriptionStatusAndWait$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @DebugMetadata(c = "com.superwall.sdk.store.AutomaticPurchaseController$syncSubscriptionStatusAndWait$2$1", f = "AutomaticPurchaseController.kt", l = {}, m = "invokeSuspend")
        static final class AnonymousClass1 extends SuspendLambda implements Function2<ConnectionState, Continuation<? super Boolean>, Object> {
            /* synthetic */ Object L$0;
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
            public final Object invoke(ConnectionState connectionState, Continuation<? super Boolean> continuation) {
                return ((AnonymousClass1) create(connectionState, continuation)).invokeSuspend(Unit.f139807a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                IntrinsicsKt.f();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                return Boxing.a(((ConnectionState) this.L$0) != ConnectionState.Connecting);
            }
        }

        C29172(Continuation<? super C29172> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AutomaticPurchaseController.this.new C29172(continuation);
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
            MutableStateFlow mutableStateFlow = AutomaticPurchaseController.this.connectionState;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(null);
            this.label = 1;
            Object objE = FlowKt.E(mutableStateFlow, anonymousClass1, this);
            return objE == objF ? objF : objE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ConnectionState> continuation) {
            return ((C29172) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.store.AutomaticPurchaseController$syncSubscriptionStatusAndWait$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.store.AutomaticPurchaseController$syncSubscriptionStatusAndWait$3", f = "AutomaticPurchaseController.kt", l = {360, 360}, m = "invokeSuspend")
    static final class C29183 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Pair<? extends List<? extends Purchase>, ? extends List<? extends Purchase>>>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        C29183(Continuation<? super C29183> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C29183 c29183 = AutomaticPurchaseController.this.new C29183(continuation);
            c29183.L$0 = obj;
            return c29183;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Deferred deferredB;
            Object obj2;
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                Deferred deferredB2 = BuildersKt__Builders_commonKt.b(coroutineScope, null, null, new AutomaticPurchaseController$syncSubscriptionStatusAndWait$3$subs$1(AutomaticPurchaseController.this, null), 3, null);
                deferredB = BuildersKt__Builders_commonKt.b(coroutineScope, null, null, new AutomaticPurchaseController$syncSubscriptionStatusAndWait$3$inApps$1(AutomaticPurchaseController.this, null), 3, null);
                this.L$0 = deferredB;
                this.label = 1;
                obj = deferredB2.await(this);
                if (obj != objF) {
                }
                return objF;
            }
            if (i3 != 1) {
                if (i3 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                obj2 = this.L$0;
                ResultKt.b(obj);
                return TuplesKt.a(obj2, obj);
            }
            deferredB = (Deferred) this.L$0;
            ResultKt.b(obj);
            this.L$0 = obj;
            this.label = 2;
            Object objAwait = deferredB.await(this);
            if (objAwait != objF) {
                obj2 = obj;
                obj = objAwait;
                return TuplesKt.a(obj2, obj);
            }
            return objF;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Pair<? extends List<? extends Purchase>, ? extends List<? extends Purchase>>> continuation) {
            return ((C29183) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.store.AutomaticPurchaseController$syncSubscriptionStatusAndWait$5, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.store.AutomaticPurchaseController$syncSubscriptionStatusAndWait$5", f = "AutomaticPurchaseController.kt", l = {426, 427}, m = "invokeSuspend")
    static final class AnonymousClass5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $count;
        int label;
        final /* synthetic */ AutomaticPurchaseController this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass5(int i3, AutomaticPurchaseController automaticPurchaseController, Continuation<? super AnonymousClass5> continuation) {
            super(2, continuation);
            this.$count = i3;
            this.this$0 = automaticPurchaseController;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass5(this.$count, this.this$0, continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x003f, code lost:
        
            if (r7.syncSubscriptionStatusAndWait(r1, r6) == r0) goto L15;
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
                if (r1 == 0) goto L1e
                if (r1 == r3) goto L1a
                if (r1 != r2) goto L12
                kotlin.ResultKt.b(r7)
                goto L42
            L12:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L1a:
                kotlin.ResultKt.b(r7)
                goto L34
            L1e:
                kotlin.ResultKt.b(r7)
                kotlin.time.Duration$Companion r7 = kotlin.time.Duration.f140631b
                int r7 = r6.$count
                kotlin.time.DurationUnit r1 = kotlin.time.DurationUnit.f140641f
                long r4 = kotlin.time.DurationKt.s(r7, r1)
                r6.label = r3
                java.lang.Object r7 = kotlinx.coroutines.DelayKt.c(r4, r6)
                if (r7 != r0) goto L34
                goto L41
            L34:
                com.superwall.sdk.store.AutomaticPurchaseController r7 = r6.this$0
                int r1 = r6.$count
                int r1 = r1 + r3
                r6.label = r2
                java.lang.Object r7 = com.superwall.sdk.store.AutomaticPurchaseController.access$syncSubscriptionStatusAndWait(r7, r1, r6)
                if (r7 != r0) goto L42
            L41:
                return r0
            L42:
                kotlin.Unit r7 = kotlin.Unit.f139807a
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.store.AutomaticPurchaseController.AnonymousClass5.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass5) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AutomaticPurchaseController(Context context, IOScope scope, Function0<Entitlements> entitlementsInfo, Function2<? super Context, ? super PurchasesUpdatedListener, ? extends BillingClient> getBilling) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(entitlementsInfo, "entitlementsInfo");
        Intrinsics.checkNotNullParameter(getBilling, "getBilling");
        this.context = context;
        this.scope = scope;
        this.entitlementsInfo = entitlementsInfo;
        this.getBilling = getBilling;
        this.billingClient = (BillingClient) getBilling.invoke(context, this);
        this.connectionState = StateFlowKt.a(ConnectionState.Connecting);
        this.purchaseResults = StateFlowKt.a(null);
        this.reconnectMilliseconds = 1000L;
        BuildersKt__Builders_commonKt.d(scope, null, null, new AnonymousClass3(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Entitlements _init_$lambda$0() {
        return Superwall.Companion.getInstance().getDependencyContainer$superwall_release().getEntitlements();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BillingClient _init_$lambda$1(Context ctx, PurchasesUpdatedListener listener) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(listener, "listener");
        try {
            return BillingClient.h(ctx).c(listener).b(PendingPurchasesParams.c().b().a()).a();
        } catch (Throwable th) {
            Logger logger = Logger.INSTANCE;
            LogLevel logLevel = LogLevel.error;
            LogScope logScope = LogScope.nativePurchaseController;
            String str = AutomaticPurchaseControllerKt.BILLING_INSANTIATION_ERROR;
            String message = th.getMessage();
            if (message == null) {
                message = "Unknown message";
            }
            logger.debug(logLevel, logScope, str, MapsKt.mapOf(TuplesKt.a("error_message", message)), th);
            throw th;
        }
    }

    private final void acknowledgePurchasesIfNecessary(List<? extends Purchase> list) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            Purchase purchase = (Purchase) obj;
            if (purchase.d() == 1 && !purchase.h()) {
                arrayList.add(obj);
            }
        }
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj2 = arrayList.get(i3);
            i3++;
            AcknowledgePurchaseParams acknowledgePurchaseParamsA = AcknowledgePurchaseParams.b().b(((Purchase) obj2).f()).a();
            Intrinsics.checkNotNullExpressionValue(acknowledgePurchaseParamsA, "build(...)");
            this.billingClient.a(acknowledgePurchaseParamsA, new AcknowledgePurchaseResponseListener() { // from class: com.superwall.sdk.store.c
                @Override // com.android.billingclient.api.AcknowledgePurchaseResponseListener
                public final void b(BillingResult billingResult) {
                    AutomaticPurchaseController.acknowledgePurchasesIfNecessary$lambda$18$lambda$17(billingResult);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void acknowledgePurchasesIfNecessary$lambda$18$lambda$17(BillingResult billingResult) {
        Intrinsics.checkNotNullParameter(billingResult, "billingResult");
        if (billingResult.c() != 0) {
            Logger.debug$default(Logger.INSTANCE, LogLevel.error, LogScope.nativePurchaseController, "Unable to acknowledge purchase.", (Map) null, (Throwable) null, 24, (Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX INFO: renamed from: queryPurchasesOfType-gIAlu-s, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object m1341queryPurchasesOfTypegIAlus(java.lang.String r7, kotlin.coroutines.Continuation<? super kotlin.Result<? extends java.util.List<? extends com.android.billingclient.api.Purchase>>> r8) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.superwall.sdk.store.AutomaticPurchaseController$queryPurchasesOfType$1
            if (r0 == 0) goto L13
            r0 = r8
            com.superwall.sdk.store.AutomaticPurchaseController$queryPurchasesOfType$1 r0 = (com.superwall.sdk.store.AutomaticPurchaseController$queryPurchasesOfType$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.superwall.sdk.store.AutomaticPurchaseController$queryPurchasesOfType$1 r0 = new com.superwall.sdk.store.AutomaticPurchaseController$queryPurchasesOfType$1
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.b(r8)
            goto L7e
        L29:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L31:
            kotlin.ResultKt.b(r8)
            r8 = 0
            kotlinx.coroutines.CompletableDeferred r2 = kotlinx.coroutines.CompletableDeferredKt.b(r8, r3, r8)
            com.android.billingclient.api.QueryPurchasesParams$Builder r4 = com.android.billingclient.api.QueryPurchasesParams.b()
            com.android.billingclient.api.QueryPurchasesParams$Builder r7 = r4.b(r7)
            com.android.billingclient.api.QueryPurchasesParams r7 = r7.a()
            java.lang.String r4 = "build(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r4)
            com.android.billingclient.api.BillingClient r4 = r6.billingClient
            boolean r4 = r4.f()
            if (r4 != 0) goto L64
            kotlin.Result$Companion r7 = kotlin.Result.f139772b
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "Billing client not ready"
            r7.<init>(r8)
            java.lang.Object r7 = kotlin.ResultKt.a(r7)
            java.lang.Object r7 = kotlin.Result.b(r7)
            return r7
        L64:
            com.android.billingclient.api.BillingClient r4 = r6.billingClient
            com.superwall.sdk.store.a r5 = new com.superwall.sdk.store.a
            r5.<init>()
            r4.j(r7, r5)
            com.superwall.sdk.store.AutomaticPurchaseController$queryPurchasesOfType$3 r7 = new com.superwall.sdk.store.AutomaticPurchaseController$queryPurchasesOfType$3
            r7.<init>(r2, r8)
            r0.label = r3
            r2 = 10000(0x2710, double:4.9407E-320)
            java.lang.Object r8 = kotlinx.coroutines.TimeoutKt.e(r2, r7, r0)
            if (r8 != r1) goto L7e
            return r1
        L7e:
            kotlin.Result r8 = (kotlin.Result) r8
            if (r8 == 0) goto L87
            java.lang.Object r7 = r8.j()
            return r7
        L87:
            kotlin.Result$Companion r7 = kotlin.Result.f139772b
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "Query purchases timed out"
            r7.<init>(r8)
            java.lang.Object r7 = kotlin.ResultKt.a(r7)
            java.lang.Object r7 = kotlin.Result.b(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.store.AutomaticPurchaseController.m1341queryPurchasesOfTypegIAlus(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void queryPurchasesOfType_gIAlu_s$lambda$15(CompletableDeferred completableDeferred, BillingResult billingResult, List purchasesList) {
        Intrinsics.checkNotNullParameter(billingResult, "billingResult");
        Intrinsics.checkNotNullParameter(purchasesList, "purchasesList");
        if (billingResult.c() == 0) {
            completableDeferred.J(Result.a(Result.b(purchasesList)));
            return;
        }
        Logger.debug$default(Logger.INSTANCE, LogLevel.error, LogScope.nativePurchaseController, "Unable to query for purchases.", (Map) null, (Throwable) null, 24, (Object) null);
        Result.Companion companion = Result.f139772b;
        completableDeferred.J(Result.a(Result.b(ResultKt.a(new Throwable("Billing query failed with code " + billingResult.c())))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startConnection() {
        try {
            this.billingClient.l(new BillingClientStateListener() { // from class: com.superwall.sdk.store.AutomaticPurchaseController.startConnection.1
                @Override // com.android.billingclient.api.BillingClientStateListener
                public void onBillingServiceDisconnected() {
                    AutomaticPurchaseController.this.connectionState.setValue(ConnectionState.Connecting);
                    Logger.debug$default(Logger.INSTANCE, LogLevel.error, LogScope.nativePurchaseController, "ExternalNativePurchaseController billing client disconnected, retrying in " + AutomaticPurchaseController.this.reconnectMilliseconds + " milliseconds", (Map) null, (Throwable) null, 24, (Object) null);
                    BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(Dispatchers.b()), null, null, new AutomaticPurchaseController$startConnection$1$onBillingServiceDisconnected$1(AutomaticPurchaseController.this, null), 3, null);
                    AutomaticPurchaseController automaticPurchaseController = AutomaticPurchaseController.this;
                    automaticPurchaseController.reconnectMilliseconds = Math.min(automaticPurchaseController.reconnectMilliseconds * ((long) 2), GoogleBillingWrapperKt.RECONNECT_TIMER_MAX_TIME_MILLISECONDS);
                }

                @Override // com.android.billingclient.api.BillingClientStateListener
                public void onBillingSetupFinished(BillingResult billingResult) {
                    Intrinsics.checkNotNullParameter(billingResult, "billingResult");
                    AutomaticPurchaseController.this.connectionState.setValue(billingResult.c() == 0 ? ConnectionState.Connected : ConnectionState.Failed);
                    AutomaticPurchaseController.this.syncSubscriptionStatus();
                }
            });
        } catch (IllegalStateException e3) {
            this.connectionState.setValue(ConnectionState.Failed);
            Logger.debug$default(Logger.INSTANCE, LogLevel.error, LogScope.nativePurchaseController, "IllegalStateException when connecting to billing client for ExternalNativePurchaseController: " + e3.getMessage(), (Map) null, (Throwable) null, 24, (Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void syncSubscriptionStatus() {
        BuildersKt__Builders_commonKt.d(this.scope, null, null, new C29151(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01ee A[LOOP:0: B:64:0x01e8->B:66:0x01ee, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0216 A[LOOP:1: B:68:0x0210->B:70:0x0216, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x02bf  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x02c2  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x02ee  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0301  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object syncSubscriptionStatusAndWait(int r33, kotlin.coroutines.Continuation<? super kotlin.Unit> r34) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 799
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.store.AutomaticPurchaseController.syncSubscriptionStatusAndWait(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object syncSubscriptionStatusAndWait$default(AutomaticPurchaseController automaticPurchaseController, int i3, Continuation continuation, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i3 = 0;
        }
        return automaticPurchaseController.syncSubscriptionStatusAndWait(i3, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence syncSubscriptionStatusAndWait$lambda$14$lambda$12(Entitlement it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getId();
    }

    public final Context getContext() {
        return this.context;
    }

    public final Function0<Entitlements> getEntitlementsInfo() {
        return this.entitlementsInfo;
    }

    public final Function2<Context, PurchasesUpdatedListener, BillingClient> getGetBilling() {
        return this.getBilling;
    }

    public final IOScope getScope() {
        return this.scope;
    }

    @Override // com.android.billingclient.api.PurchasesUpdatedListener
    public void onPurchasesUpdated(BillingResult billingResult, List<Purchase> list) {
        PurchaseResult purchased;
        String message;
        Intrinsics.checkNotNullParameter(billingResult, "billingResult");
        int iC = billingResult.c();
        if (iC == 0) {
            if (list != null) {
                acknowledgePurchasesIfNecessary(list);
            }
            purchased = new PurchaseResult.Purchased();
        } else if (iC != 1) {
            PlayBillingErrors playBillingErrorsFromCode = PlayBillingErrors.Companion.fromCode(billingResult.c());
            if (playBillingErrorsFromCode == null || (message = playBillingErrorsFromCode.getMessage()) == null) {
                message = "Unknown error " + billingResult.c();
            }
            purchased = new PurchaseResult.Failed(message);
        } else {
            purchased = new PurchaseResult.Cancelled();
        }
        BuildersKt__Builders_commonKt.d(this.scope, null, null, new AnonymousClass1(purchased, null), 3, null);
    }

    @Override // com.superwall.sdk.delegate.subscription_controller.PurchaseController
    public Object purchase(Activity activity, StoreProduct storeProduct, String str, String str2, Continuation<? super PurchaseResult> continuation) {
        return PurchaseController.DefaultImpls.purchase(this, activity, storeProduct, str, str2, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.superwall.sdk.delegate.subscription_controller.PurchaseController
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object restorePurchases(kotlin.coroutines.Continuation<? super com.superwall.sdk.delegate.RestorationResult> r5) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.superwall.sdk.store.AutomaticPurchaseController.C29131
            if (r0 == 0) goto L13
            r0 = r5
            com.superwall.sdk.store.AutomaticPurchaseController$restorePurchases$1 r0 = (com.superwall.sdk.store.AutomaticPurchaseController.C29131) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.superwall.sdk.store.AutomaticPurchaseController$restorePurchases$1 r0 = new com.superwall.sdk.store.AutomaticPurchaseController$restorePurchases$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.b(r5)
            goto L3f
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L31:
            kotlin.ResultKt.b(r5)
            r0.label = r3
            r5 = 0
            r2 = 0
            java.lang.Object r5 = syncSubscriptionStatusAndWait$default(r4, r5, r0, r3, r2)
            if (r5 != r1) goto L3f
            return r1
        L3f:
            com.superwall.sdk.delegate.RestorationResult$Restored r5 = new com.superwall.sdk.delegate.RestorationResult$Restored
            r5.<init>()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.store.AutomaticPurchaseController.restorePurchases(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void setContext(Context context) {
        Intrinsics.checkNotNullParameter(context, "<set-?>");
        this.context = context;
    }

    private final String buildFullId(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        String str4 = pMpIcGE.osnVgsJvGljDWpr;
        if (str2 != null) {
            sb.append(str4 + str2);
        }
        if (str3 != null) {
            sb.append(str4 + str3);
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x017f, code lost:
    
        if (r4 == r6) goto L51;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001d  */
    @Override // com.superwall.sdk.delegate.subscription_controller.PurchaseController
    @kotlin.Deprecated
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object purchase(android.app.Activity r20, com.android.billingclient.api.ProductDetails r21, java.lang.String r22, java.lang.String r23, kotlin.coroutines.Continuation<? super com.superwall.sdk.delegate.PurchaseResult> r24) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 404
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.store.AutomaticPurchaseController.purchase(android.app.Activity, com.android.billingclient.api.ProductDetails, java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public /* synthetic */ AutomaticPurchaseController(Context context, IOScope iOScope, Function0 function0, Function2 function2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, iOScope, (i3 & 4) != 0 ? new Function0() { // from class: com.superwall.sdk.store.d
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return AutomaticPurchaseController._init_$lambda$0();
            }
        } : function0, (i3 & 8) != 0 ? new Function2() { // from class: com.superwall.sdk.store.e
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AutomaticPurchaseController._init_$lambda$1((Context) obj, (PurchasesUpdatedListener) obj2);
            }
        } : function2);
    }
}
