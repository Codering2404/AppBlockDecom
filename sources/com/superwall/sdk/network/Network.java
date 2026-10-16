package com.superwall.sdk.network;

import com.superwall.sdk.dependencies.ApiFactory;
import com.superwall.sdk.logger.LogLevel;
import com.superwall.sdk.logger.LogScope;
import com.superwall.sdk.logger.Logger;
import com.superwall.sdk.misc.Either;
import com.superwall.sdk.misc.EitherKt;
import com.superwall.sdk.models.assignment.Assignment;
import com.superwall.sdk.models.assignment.AssignmentPostback;
import com.superwall.sdk.models.assignment.ConfirmedAssignmentResponse;
import com.superwall.sdk.models.config.Config;
import com.superwall.sdk.models.enrichment.Enrichment;
import com.superwall.sdk.models.enrichment.EnrichmentRequest;
import com.superwall.sdk.models.entitlements.Redeemable;
import com.superwall.sdk.models.entitlements.TransactionReceipt;
import com.superwall.sdk.models.entitlements.WebEntitlements;
import com.superwall.sdk.models.events.EventData;
import com.superwall.sdk.models.events.EventsRequest;
import com.superwall.sdk.models.events.EventsResponse;
import com.superwall.sdk.models.internal.DeviceVendorId;
import com.superwall.sdk.models.internal.WebRedemptionResponse;
import com.superwall.sdk.models.paywall.Paywall;
import com.superwall.sdk.models.paywall.Paywalls;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.serialization.json.JsonElement;

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
public class Network implements SuperwallAPI {
    private final BaseHostService baseHostService;
    private final CollectorService collectorService;
    private final EnrichmentService enrichmentService;
    private final ApiFactory factory;
    private final SubscriptionService subscriptionService;

    /* JADX INFO: renamed from: com.superwall.sdk.network.Network$confirmAssignments$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.network.Network", f = "Network.kt", l = {73}, m = "confirmAssignments$suspendImpl")
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
            return Network.confirmAssignments$suspendImpl(Network.this, null, this);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.network.Network$getAssignments$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.network.Network", f = "Network.kt", l = {126}, m = "getAssignments$suspendImpl")
    static final class C28181 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C28181(Continuation<? super C28181> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Network.getAssignments$suspendImpl(Network.this, this);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.network.Network$getConfig$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.network.Network", f = "Network.kt", l = {57, 62}, m = "getConfig$suspendImpl")
    static final class C28191 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C28191(Continuation<? super C28191> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Network.getConfig$suspendImpl(Network.this, null, this);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.network.Network$getPaywall$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.network.Network", f = "Network.kt", l = {82}, m = "getPaywall$suspendImpl")
    static final class C28201 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C28201(Continuation<? super C28201> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Network.getPaywall$suspendImpl(Network.this, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.network.Network$getPaywalls$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.network.Network", f = "Network.kt", l = {97}, m = "getPaywalls$suspendImpl")
    static final class C28211 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C28211(Continuation<? super C28211> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Network.getPaywalls$suspendImpl(Network.this, false, this);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.network.Network$getSuperwallProducts$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.network.Network", f = "Network.kt", l = {158}, m = "getSuperwallProducts")
    static final class C28221 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C28221(Continuation<? super C28221> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Network.this.getSuperwallProducts(this);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.network.Network$sendEvents$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.network.Network", f = "Network.kt", l = {43}, m = "sendEvents$suspendImpl")
    static final class C28231 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C28231(Continuation<? super C28231> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Network.sendEvents$suspendImpl(Network.this, null, this);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.network.Network$webEntitlementsByDeviceID$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.network.Network", f = "Network.kt", l = {153}, m = "webEntitlementsByDeviceID$suspendImpl")
    static final class C28241 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C28241(Continuation<? super C28241> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Network.webEntitlementsByDeviceID$suspendImpl(Network.this, null, this);
        }
    }

    public Network(BaseHostService baseHostService, CollectorService collectorService, EnrichmentService enrichmentService, ApiFactory factory, SubscriptionService subscriptionService) {
        Intrinsics.checkNotNullParameter(baseHostService, "baseHostService");
        Intrinsics.checkNotNullParameter(collectorService, "collectorService");
        Intrinsics.checkNotNullParameter(enrichmentService, "enrichmentService");
        Intrinsics.checkNotNullParameter(factory, "factory");
        Intrinsics.checkNotNullParameter(subscriptionService, "subscriptionService");
        this.baseHostService = baseHostService;
        this.collectorService = collectorService;
        this.enrichmentService = enrichmentService;
        this.factory = factory;
        this.subscriptionService = subscriptionService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object awaitUntilAppInForeground(Continuation<? super Unit> continuation) {
        final StateFlow<Boolean> stateFlowIsInBackground = this.factory.getAppLifecycleObserver().isInBackground();
        Object objD = FlowKt.D(new Flow<Boolean>() { // from class: com.superwall.sdk.network.Network$awaitUntilAppInForeground$$inlined$filter$1

            /* JADX INFO: renamed from: com.superwall.sdk.network.Network$awaitUntilAppInForeground$$inlined$filter$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: com.superwall.sdk.network.Network$awaitUntilAppInForeground$$inlined$filter$1$2$1, reason: invalid class name */
                @Metadata
                @DebugMetadata(c = "com.superwall.sdk.network.Network$awaitUntilAppInForeground$$inlined$filter$1$2", f = "Network.kt", l = {50}, m = "emit")
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
                        boolean r0 = r6 instanceof com.superwall.sdk.network.Network$awaitUntilAppInForeground$$inlined$filter$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r6
                        com.superwall.sdk.network.Network$awaitUntilAppInForeground$$inlined$filter$1$2$1 r0 = (com.superwall.sdk.network.Network$awaitUntilAppInForeground$$inlined$filter$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.superwall.sdk.network.Network$awaitUntilAppInForeground$$inlined$filter$1$2$1 r0 = new com.superwall.sdk.network.Network$awaitUntilAppInForeground$$inlined$filter$1$2$1
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
                        if (r2 != 0) goto L48
                        r0.label = r3
                        java.lang.Object r5 = r6.emit(r5, r0)
                        if (r5 != r1) goto L48
                        return r1
                    L48:
                        kotlin.Unit r5 = kotlin.Unit.f139807a
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.network.Network$awaitUntilAppInForeground$$inlined$filter$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector flowCollector, Continuation continuation2) {
                Object objCollect = stateFlowIsInBackground.collect(new AnonymousClass2(flowCollector), continuation2);
                return objCollect == IntrinsicsKt.f() ? objCollect : Unit.f139807a;
            }
        }, continuation);
        return objD == IntrinsicsKt.f() ? objD : Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit confirmAssignments$lambda$2(ConfirmedAssignmentResponse it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ java.lang.Object confirmAssignments$suspendImpl(com.superwall.sdk.network.Network r4, com.superwall.sdk.models.assignment.AssignmentPostback r5, kotlin.coroutines.Continuation<? super com.superwall.sdk.misc.Either<kotlin.Unit, com.superwall.sdk.network.NetworkError>> r6) throws java.lang.Throwable {
        /*
            boolean r0 = r6 instanceof com.superwall.sdk.network.Network.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r6
            com.superwall.sdk.network.Network$confirmAssignments$1 r0 = (com.superwall.sdk.network.Network.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.superwall.sdk.network.Network$confirmAssignments$1 r0 = new com.superwall.sdk.network.Network$confirmAssignments$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r4 = r0.L$1
            com.superwall.sdk.network.Network r4 = (com.superwall.sdk.network.Network) r4
            java.lang.Object r5 = r0.L$0
            com.superwall.sdk.models.assignment.AssignmentPostback r5 = (com.superwall.sdk.models.assignment.AssignmentPostback) r5
            kotlin.ResultKt.b(r6)
            goto L4b
        L31:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L39:
            kotlin.ResultKt.b(r6)
            com.superwall.sdk.network.BaseHostService r6 = r4.baseHostService
            r0.L$0 = r5
            r0.L$1 = r4
            r0.label = r3
            java.lang.Object r6 = r6.confirmAssignments(r5, r0)
            if (r6 != r1) goto L4b
            return r1
        L4b:
            com.superwall.sdk.misc.Either r6 = (com.superwall.sdk.misc.Either) r6
            com.superwall.sdk.network.e r0 = new com.superwall.sdk.network.e
            r0.<init>()
            com.superwall.sdk.misc.Either r6 = com.superwall.sdk.misc.EitherKt.map(r6, r0)
            java.lang.String r0 = "assignments"
            kotlin.Pair r5 = kotlin.TuplesKt.a(r0, r5)
            java.util.Map r5 = kotlin.collections.MapsKt.mapOf(r5)
            java.lang.String r0 = "/confirm_assignments"
            com.superwall.sdk.misc.Either r4 = r4.logError(r6, r0, r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.network.Network.confirmAssignments$suspendImpl(com.superwall.sdk.network.Network, com.superwall.sdk.models.assignment.AssignmentPostback, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getAssignments$lambda$5(ConfirmedAssignmentResponse it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getAssignments();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ java.lang.Object getAssignments$suspendImpl(com.superwall.sdk.network.Network r8, kotlin.coroutines.Continuation<? super com.superwall.sdk.misc.Either<? extends java.util.List<com.superwall.sdk.models.assignment.Assignment>, com.superwall.sdk.network.NetworkError>> r9) throws java.lang.Throwable {
        /*
            boolean r0 = r9 instanceof com.superwall.sdk.network.Network.C28181
            if (r0 == 0) goto L13
            r0 = r9
            com.superwall.sdk.network.Network$getAssignments$1 r0 = (com.superwall.sdk.network.Network.C28181) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.superwall.sdk.network.Network$getAssignments$1 r0 = new com.superwall.sdk.network.Network$getAssignments$1
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r8 = r0.L$0
            com.superwall.sdk.network.Network r8 = (com.superwall.sdk.network.Network) r8
            kotlin.ResultKt.b(r9)
        L2c:
            r2 = r8
            goto L46
        L2e:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L36:
            kotlin.ResultKt.b(r9)
            com.superwall.sdk.network.BaseHostService r9 = r8.baseHostService
            r0.L$0 = r8
            r0.label = r3
            java.lang.Object r9 = r9.assignments(r0)
            if (r9 != r1) goto L2c
            return r1
        L46:
            com.superwall.sdk.misc.Either r9 = (com.superwall.sdk.misc.Either) r9
            com.superwall.sdk.network.i r8 = new com.superwall.sdk.network.i
            r8.<init>()
            com.superwall.sdk.misc.Either r3 = com.superwall.sdk.misc.EitherKt.map(r9, r8)
            r6 = 2
            r7 = 0
            java.lang.String r4 = "/assignments"
            r5 = 0
            com.superwall.sdk.misc.Either r8 = logError$default(r2, r3, r4, r5, r6, r7)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.network.Network.getAssignments$suspendImpl(com.superwall.sdk.network.Network, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Config getConfig$lambda$1(String str, Config config) {
        Intrinsics.checkNotNullParameter(config, "config");
        config.setRequestId(str);
        return config;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ java.lang.Object getConfig$suspendImpl(com.superwall.sdk.network.Network r8, kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> r9, kotlin.coroutines.Continuation<? super com.superwall.sdk.misc.Either<com.superwall.sdk.models.config.Config, com.superwall.sdk.network.NetworkError>> r10) throws java.lang.Throwable {
        /*
            boolean r0 = r10 instanceof com.superwall.sdk.network.Network.C28191
            if (r0 == 0) goto L13
            r0 = r10
            com.superwall.sdk.network.Network$getConfig$1 r0 = (com.superwall.sdk.network.Network.C28191) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.superwall.sdk.network.Network$getConfig$1 r0 = new com.superwall.sdk.network.Network$getConfig$1
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L4a
            if (r2 == r4) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r8 = r0.L$1
            com.superwall.sdk.network.Network r8 = (com.superwall.sdk.network.Network) r8
            java.lang.Object r9 = r0.L$0
            java.lang.String r9 = (java.lang.String) r9
            kotlin.ResultKt.b(r10)
        L33:
            r2 = r8
            goto L7a
        L35:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L3d:
            java.lang.Object r8 = r0.L$1
            r9 = r8
            kotlin.jvm.functions.Function1 r9 = (kotlin.jvm.functions.Function1) r9
            java.lang.Object r8 = r0.L$0
            com.superwall.sdk.network.Network r8 = (com.superwall.sdk.network.Network) r8
            kotlin.ResultKt.b(r10)
            goto L5a
        L4a:
            kotlin.ResultKt.b(r10)
            r0.L$0 = r8
            r0.L$1 = r9
            r0.label = r4
            java.lang.Object r10 = r8.awaitUntilAppInForeground(r0)
            if (r10 != r1) goto L5a
            goto L75
        L5a:
            java.util.UUID r10 = java.util.UUID.randomUUID()
            java.lang.String r10 = r10.toString()
            java.lang.String r2 = "toString(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r2)
            com.superwall.sdk.network.BaseHostService r2 = r8.baseHostService
            r0.L$0 = r10
            r0.L$1 = r8
            r0.label = r3
            java.lang.Object r9 = r2.config(r10, r9, r0)
            if (r9 != r1) goto L76
        L75:
            return r1
        L76:
            r2 = r10
            r10 = r9
            r9 = r2
            goto L33
        L7a:
            com.superwall.sdk.misc.Either r10 = (com.superwall.sdk.misc.Either) r10
            com.superwall.sdk.network.f r8 = new com.superwall.sdk.network.f
            r8.<init>()
            com.superwall.sdk.misc.Either r3 = com.superwall.sdk.misc.EitherKt.map(r10, r8)
            r6 = 2
            r7 = 0
            java.lang.String r4 = "/static_config"
            r5 = 0
            com.superwall.sdk.misc.Either r8 = logError$default(r2, r3, r4, r5, r6, r7)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.network.Network.getConfig$suspendImpl(com.superwall.sdk.network.Network, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x00f9, code lost:
    
        if (r0 != r2) goto L16;
     */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00e8 A[PHI: r0 r3 r14
      0x00e8: PHI (r0v9 java.lang.Object) = (r0v8 java.lang.Object), (r0v1 java.lang.Object) binds: [B:36:0x00e5, B:19:0x0046] A[DONT_GENERATE, DONT_INLINE]
      0x00e8: PHI (r3v7 com.superwall.sdk.network.Network) = (r3v6 com.superwall.sdk.network.Network), (r3v17 com.superwall.sdk.network.Network) binds: [B:36:0x00e5, B:19:0x0046] A[DONT_GENERATE, DONT_INLINE]
      0x00e8: PHI (r14v7 com.superwall.sdk.network.Network) = (r14v6 com.superwall.sdk.network.Network), (r14v16 com.superwall.sdk.network.Network) binds: [B:36:0x00e5, B:19:0x0046] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /* JADX INFO: renamed from: getEnrichment-exY8QGI$suspendImpl, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ java.lang.Object m1307getEnrichmentexY8QGI$suspendImpl(com.superwall.sdk.network.Network r14, com.superwall.sdk.models.enrichment.EnrichmentRequest r15, int r16, long r17, kotlin.coroutines.Continuation<? super com.superwall.sdk.misc.Either<com.superwall.sdk.models.enrichment.Enrichment, com.superwall.sdk.network.NetworkError>> r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 265
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.network.Network.m1307getEnrichmentexY8QGI$suspendImpl(com.superwall.sdk.network.Network, com.superwall.sdk.models.enrichment.EnrichmentRequest, int, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ java.lang.Object getPaywall$suspendImpl(com.superwall.sdk.network.Network r4, java.lang.String r5, com.superwall.sdk.models.events.EventData r6, kotlin.coroutines.Continuation<? super com.superwall.sdk.misc.Either<com.superwall.sdk.models.paywall.Paywall, com.superwall.sdk.network.NetworkError>> r7) throws java.lang.Throwable {
        /*
            boolean r0 = r7 instanceof com.superwall.sdk.network.Network.C28201
            if (r0 == 0) goto L13
            r0 = r7
            com.superwall.sdk.network.Network$getPaywall$1 r0 = (com.superwall.sdk.network.Network.C28201) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.superwall.sdk.network.Network$getPaywall$1 r0 = new com.superwall.sdk.network.Network$getPaywall$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3e
            if (r2 != r3) goto L36
            java.lang.Object r4 = r0.L$2
            com.superwall.sdk.network.Network r4 = (com.superwall.sdk.network.Network) r4
            java.lang.Object r5 = r0.L$1
            r6 = r5
            com.superwall.sdk.models.events.EventData r6 = (com.superwall.sdk.models.events.EventData) r6
            java.lang.Object r5 = r0.L$0
            java.lang.String r5 = (java.lang.String) r5
            kotlin.ResultKt.b(r7)
            goto L52
        L36:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3e:
            kotlin.ResultKt.b(r7)
            com.superwall.sdk.network.BaseHostService r7 = r4.baseHostService
            r0.L$0 = r5
            r0.L$1 = r6
            r0.L$2 = r4
            r0.label = r3
            java.lang.Object r7 = r7.paywall(r5, r0)
            if (r7 != r1) goto L52
            return r1
        L52:
            com.superwall.sdk.misc.Either r7 = (com.superwall.sdk.misc.Either) r7
            java.lang.String r0 = ""
            if (r5 == 0) goto L6b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "/:"
            r1.append(r2)
            r1.append(r5)
            java.lang.String r1 = r1.toString()
            if (r1 != 0) goto L6c
        L6b:
            r1 = r0
        L6c:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "/paywall"
            r2.append(r3)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            if (r5 != 0) goto La0
            java.lang.String r5 = "identifier"
            java.lang.String r2 = "none"
            kotlin.Pair r5 = kotlin.TuplesKt.a(r5, r2)
            if (r6 == 0) goto L91
            java.lang.String r6 = r6.getName()
            if (r6 != 0) goto L90
            goto L91
        L90:
            r0 = r6
        L91:
            java.lang.String r6 = "event"
            kotlin.Pair r6 = kotlin.TuplesKt.a(r6, r0)
            kotlin.Pair[] r5 = new kotlin.Pair[]{r5, r6}
            java.util.Map r5 = kotlin.collections.MapsKt.mapOf(r5)
            goto La1
        La0:
            r5 = 0
        La1:
            com.superwall.sdk.misc.Either r4 = r4.logError(r7, r1, r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.network.Network.getPaywall$suspendImpl(com.superwall.sdk.network.Network, java.lang.String, com.superwall.sdk.models.events.EventData, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getPaywalls$lambda$4(Paywalls it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getPaywalls();
    }

    private final <T> Either<T, NetworkError> logError(Either<? extends T, NetworkError> either, final String str, final Map<String, ? extends Object> map) {
        return EitherKt.onError(either, new Function1() { // from class: com.superwall.sdk.network.g
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Network.logError$lambda$7(str, map, (NetworkError) obj);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ Either logError$default(Network network, Either either, String str, Map map, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: logError");
        }
        if ((i3 & 2) != 0) {
            map = null;
        }
        return network.logError(either, str, map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit logError$lambda$7(String str, Map map, NetworkError it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Logger.INSTANCE.debug(LogLevel.error, LogScope.network, "Request Failed: " + str, (Map<String, ? extends Object>) map, it);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0016  */
    /* JADX INFO: renamed from: redeemToken-Jf2YlNw$suspendImpl, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ java.lang.Object m1308redeemTokenJf2YlNw$suspendImpl(com.superwall.sdk.network.Network r11, java.util.List<com.superwall.sdk.models.entitlements.Redeemable> r12, java.lang.String r13, java.lang.String r14, com.superwall.sdk.models.internal.DeviceVendorId r15, java.util.List<com.superwall.sdk.models.entitlements.TransactionReceipt> r16, java.lang.String r17, java.util.Map<java.lang.String, ? extends kotlinx.serialization.json.JsonElement> r18, kotlin.coroutines.Continuation<? super com.superwall.sdk.misc.Either<com.superwall.sdk.models.internal.WebRedemptionResponse, com.superwall.sdk.network.NetworkError>> r19) throws java.lang.Throwable {
        /*
            r0 = r19
            boolean r1 = r0 instanceof com.superwall.sdk.network.Network$redeemToken$1
            if (r1 == 0) goto L16
            r1 = r0
            com.superwall.sdk.network.Network$redeemToken$1 r1 = (com.superwall.sdk.network.Network$redeemToken$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L16
            int r2 = r2 - r3
            r1.label = r2
        L14:
            r10 = r1
            goto L1c
        L16:
            com.superwall.sdk.network.Network$redeemToken$1 r1 = new com.superwall.sdk.network.Network$redeemToken$1
            r1.<init>(r11, r0)
            goto L14
        L1c:
            java.lang.Object r0 = r10.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r10.label
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r11 = r10.L$0
            com.superwall.sdk.network.Network r11 = (com.superwall.sdk.network.Network) r11
            kotlin.ResultKt.b(r0)
            goto L53
        L31:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L39:
            kotlin.ResultKt.b(r0)
            com.superwall.sdk.network.SubscriptionService r2 = r11.subscriptionService
            r10.L$0 = r11
            r10.label = r3
            r3 = r12
            r4 = r13
            r5 = r14
            r6 = r15
            r7 = r16
            r8 = r17
            r9 = r18
            java.lang.Object r0 = r2.m1318redeemTokenJf2YlNw(r3, r4, r5, r6, r7, r8, r9, r10)
            if (r0 != r1) goto L53
            return r1
        L53:
            r12 = r0
            com.superwall.sdk.misc.Either r12 = (com.superwall.sdk.misc.Either) r12
            r13 = 2
            r14 = 0
            java.lang.String r0 = "/redeem"
            r1 = 0
            r15 = r13
            r16 = r14
            r13 = r0
            r14 = r1
            com.superwall.sdk.misc.Either r11 = logError$default(r11, r12, r13, r14, r15, r16)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.network.Network.m1308redeemTokenJf2YlNw$suspendImpl(com.superwall.sdk.network.Network, java.util.List, java.lang.String, java.lang.String, com.superwall.sdk.models.internal.DeviceVendorId, java.util.List, java.lang.String, java.util.Map, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit sendEvents$lambda$0(EventsResponse it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (it.getStatus() == EventsResponse.Status.PARTIAL_SUCCESS) {
            Logger.debug$default(Logger.INSTANCE, LogLevel.warn, LogScope.network, "Request had partial success: /events", (Map) null, (Throwable) null, 24, (Object) null);
        }
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ java.lang.Object sendEvents$suspendImpl(com.superwall.sdk.network.Network r4, com.superwall.sdk.models.events.EventsRequest r5, kotlin.coroutines.Continuation<? super com.superwall.sdk.misc.Either<kotlin.Unit, com.superwall.sdk.network.NetworkError>> r6) throws java.lang.Throwable {
        /*
            boolean r0 = r6 instanceof com.superwall.sdk.network.Network.C28231
            if (r0 == 0) goto L13
            r0 = r6
            com.superwall.sdk.network.Network$sendEvents$1 r0 = (com.superwall.sdk.network.Network.C28231) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.superwall.sdk.network.Network$sendEvents$1 r0 = new com.superwall.sdk.network.Network$sendEvents$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r4 = r0.L$1
            com.superwall.sdk.network.Network r4 = (com.superwall.sdk.network.Network) r4
            java.lang.Object r5 = r0.L$0
            com.superwall.sdk.models.events.EventsRequest r5 = (com.superwall.sdk.models.events.EventsRequest) r5
            kotlin.ResultKt.b(r6)
            goto L4b
        L31:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L39:
            kotlin.ResultKt.b(r6)
            com.superwall.sdk.network.CollectorService r6 = r4.collectorService
            r0.L$0 = r5
            r0.L$1 = r4
            r0.label = r3
            java.lang.Object r6 = r6.events(r5, r0)
            if (r6 != r1) goto L4b
            return r1
        L4b:
            com.superwall.sdk.misc.Either r6 = (com.superwall.sdk.misc.Either) r6
            com.superwall.sdk.network.d r0 = new com.superwall.sdk.network.d
            r0.<init>()
            com.superwall.sdk.misc.Either r6 = com.superwall.sdk.misc.EitherKt.map(r6, r0)
            java.lang.String r0 = "payload"
            kotlin.Pair r5 = kotlin.TuplesKt.a(r0, r5)
            java.util.Map r5 = kotlin.collections.MapsKt.mapOf(r5)
            java.lang.String r0 = "/events"
            com.superwall.sdk.misc.Either r4 = r4.logError(r6, r0, r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.network.Network.sendEvents$suspendImpl(com.superwall.sdk.network.Network, com.superwall.sdk.models.events.EventsRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ java.lang.Object webEntitlementsByDeviceID$suspendImpl(com.superwall.sdk.network.Network r8, com.superwall.sdk.models.internal.DeviceVendorId r9, kotlin.coroutines.Continuation<? super com.superwall.sdk.misc.Either<com.superwall.sdk.models.entitlements.WebEntitlements, com.superwall.sdk.network.NetworkError>> r10) throws java.lang.Throwable {
        /*
            boolean r0 = r10 instanceof com.superwall.sdk.network.Network.C28241
            if (r0 == 0) goto L13
            r0 = r10
            com.superwall.sdk.network.Network$webEntitlementsByDeviceID$1 r0 = (com.superwall.sdk.network.Network.C28241) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.superwall.sdk.network.Network$webEntitlementsByDeviceID$1 r0 = new com.superwall.sdk.network.Network$webEntitlementsByDeviceID$1
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r8 = r0.L$0
            com.superwall.sdk.network.Network r8 = (com.superwall.sdk.network.Network) r8
            kotlin.ResultKt.b(r10)
        L2c:
            r2 = r8
            goto L46
        L2e:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L36:
            kotlin.ResultKt.b(r10)
            com.superwall.sdk.network.SubscriptionService r10 = r8.subscriptionService
            r0.L$0 = r8
            r0.label = r3
            java.lang.Object r10 = r10.webEntitlementsByDeviceId(r9, r0)
            if (r10 != r1) goto L2c
            return r1
        L46:
            r3 = r10
            com.superwall.sdk.misc.Either r3 = (com.superwall.sdk.misc.Either) r3
            r6 = 2
            r7 = 0
            java.lang.String r4 = "/redeem"
            r5 = 0
            com.superwall.sdk.misc.Either r8 = logError$default(r2, r3, r4, r5, r6, r7)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.network.Network.webEntitlementsByDeviceID$suspendImpl(com.superwall.sdk.network.Network, com.superwall.sdk.models.internal.DeviceVendorId, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX INFO: renamed from: webEntitlementsByUserId-5PBZuVg$suspendImpl, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ java.lang.Object m1309webEntitlementsByUserId5PBZuVg$suspendImpl(com.superwall.sdk.network.Network r8, java.lang.String r9, com.superwall.sdk.models.internal.DeviceVendorId r10, kotlin.coroutines.Continuation<? super com.superwall.sdk.misc.Either<com.superwall.sdk.models.entitlements.WebEntitlements, com.superwall.sdk.network.NetworkError>> r11) throws java.lang.Throwable {
        /*
            boolean r0 = r11 instanceof com.superwall.sdk.network.Network$webEntitlementsByUserId$1
            if (r0 == 0) goto L13
            r0 = r11
            com.superwall.sdk.network.Network$webEntitlementsByUserId$1 r0 = (com.superwall.sdk.network.Network$webEntitlementsByUserId$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.superwall.sdk.network.Network$webEntitlementsByUserId$1 r0 = new com.superwall.sdk.network.Network$webEntitlementsByUserId$1
            r0.<init>(r8, r11)
        L18:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r8 = r0.L$0
            com.superwall.sdk.network.Network r8 = (com.superwall.sdk.network.Network) r8
            kotlin.ResultKt.b(r11)
        L2c:
            r2 = r8
            goto L46
        L2e:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L36:
            kotlin.ResultKt.b(r11)
            com.superwall.sdk.network.SubscriptionService r11 = r8.subscriptionService
            r0.L$0 = r8
            r0.label = r3
            java.lang.Object r11 = r11.m1319webEntitlementsByUserIdAKGx8qU(r9, r10, r0)
            if (r11 != r1) goto L2c
            return r1
        L46:
            r3 = r11
            com.superwall.sdk.misc.Either r3 = (com.superwall.sdk.misc.Either) r3
            r6 = 2
            r7 = 0
            java.lang.String r4 = "/redeem"
            r5 = 0
            com.superwall.sdk.misc.Either r8 = logError$default(r2, r3, r4, r5, r6, r7)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.network.Network.m1309webEntitlementsByUserId5PBZuVg$suspendImpl(com.superwall.sdk.network.Network, java.lang.String, com.superwall.sdk.models.internal.DeviceVendorId, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.superwall.sdk.network.SuperwallAPI
    public Object confirmAssignments(AssignmentPostback assignmentPostback, Continuation<? super Either<Unit, NetworkError>> continuation) {
        return confirmAssignments$suspendImpl(this, assignmentPostback, continuation);
    }

    @Override // com.superwall.sdk.network.SuperwallAPI
    public Object getAssignments(Continuation<? super Either<? extends List<Assignment>, NetworkError>> continuation) {
        return getAssignments$suspendImpl(this, continuation);
    }

    @Override // com.superwall.sdk.network.SuperwallAPI
    public Object getConfig(Function1<? super Continuation<? super Unit>, ? extends Object> function1, Continuation<? super Either<Config, NetworkError>> continuation) {
        return getConfig$suspendImpl(this, function1, continuation);
    }

    @Override // com.superwall.sdk.network.SuperwallAPI
    /* JADX INFO: renamed from: getEnrichment-exY8QGI, reason: not valid java name */
    public Object mo1310getEnrichmentexY8QGI(EnrichmentRequest enrichmentRequest, int i3, long j3, Continuation<? super Either<Enrichment, NetworkError>> continuation) {
        return m1307getEnrichmentexY8QGI$suspendImpl(this, enrichmentRequest, i3, j3, continuation);
    }

    @Override // com.superwall.sdk.network.SuperwallAPI
    public Object getPaywall(String str, EventData eventData, Continuation<? super Either<Paywall, NetworkError>> continuation) {
        return getPaywall$suspendImpl(this, str, eventData, continuation);
    }

    @Override // com.superwall.sdk.network.SuperwallAPI
    public Object getPaywalls(boolean z2, Continuation<? super Either<? extends List<Paywall>, NetworkError>> continuation) {
        return getPaywalls$suspendImpl(this, z2, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getSuperwallProducts(kotlin.coroutines.Continuation<? super com.superwall.sdk.misc.Either<com.superwall.sdk.store.testmode.models.SuperwallProductsResponse, com.superwall.sdk.network.NetworkError>> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof com.superwall.sdk.network.Network.C28221
            if (r0 == 0) goto L13
            r0 = r7
            com.superwall.sdk.network.Network$getSuperwallProducts$1 r0 = (com.superwall.sdk.network.Network.C28221) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.superwall.sdk.network.Network$getSuperwallProducts$1 r0 = new com.superwall.sdk.network.Network$getSuperwallProducts$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r0 = r0.L$0
            com.superwall.sdk.network.Network r0 = (com.superwall.sdk.network.Network) r0
            kotlin.ResultKt.b(r7)
            goto L46
        L2d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L35:
            kotlin.ResultKt.b(r7)
            com.superwall.sdk.network.SubscriptionService r7 = r6.subscriptionService
            r0.L$0 = r6
            r0.label = r3
            java.lang.Object r7 = r7.getProducts(r0)
            if (r7 != r1) goto L45
            return r1
        L45:
            r0 = r6
        L46:
            r1 = r7
            com.superwall.sdk.misc.Either r1 = (com.superwall.sdk.misc.Either) r1
            r4 = 2
            r5 = 0
            java.lang.String r2 = "/products"
            r3 = 0
            com.superwall.sdk.misc.Either r7 = logError$default(r0, r1, r2, r3, r4, r5)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.network.Network.getSuperwallProducts(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.superwall.sdk.network.SuperwallAPI
    /* JADX INFO: renamed from: redeemToken-Jf2YlNw, reason: not valid java name */
    public Object mo1311redeemTokenJf2YlNw(List<Redeemable> list, String str, String str2, DeviceVendorId deviceVendorId, List<TransactionReceipt> list2, String str3, Map<String, ? extends JsonElement> map, Continuation<? super Either<WebRedemptionResponse, NetworkError>> continuation) {
        return m1308redeemTokenJf2YlNw$suspendImpl(this, list, str, str2, deviceVendorId, list2, str3, map, continuation);
    }

    @Override // com.superwall.sdk.network.SuperwallAPI
    public Object sendEvents(EventsRequest eventsRequest, Continuation<? super Either<Unit, NetworkError>> continuation) {
        return sendEvents$suspendImpl(this, eventsRequest, continuation);
    }

    @Override // com.superwall.sdk.network.SuperwallAPI
    public Object webEntitlementsByDeviceID(DeviceVendorId deviceVendorId, Continuation<? super Either<WebEntitlements, NetworkError>> continuation) {
        return webEntitlementsByDeviceID$suspendImpl(this, deviceVendorId, continuation);
    }

    @Override // com.superwall.sdk.network.SuperwallAPI
    /* JADX INFO: renamed from: webEntitlementsByUserId-5PBZuVg, reason: not valid java name */
    public Object mo1312webEntitlementsByUserId5PBZuVg(String str, DeviceVendorId deviceVendorId, Continuation<? super Either<WebEntitlements, NetworkError>> continuation) {
        return m1309webEntitlementsByUserId5PBZuVg$suspendImpl(this, str, deviceVendorId, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ java.lang.Object getPaywalls$suspendImpl(com.superwall.sdk.network.Network r8, boolean r9, kotlin.coroutines.Continuation<? super com.superwall.sdk.misc.Either<? extends java.util.List<com.superwall.sdk.models.paywall.Paywall>, com.superwall.sdk.network.NetworkError>> r10) throws java.lang.Throwable {
        /*
            boolean r0 = r10 instanceof com.superwall.sdk.network.Network.C28211
            if (r0 == 0) goto L13
            r0 = r10
            com.superwall.sdk.network.Network$getPaywalls$1 r0 = (com.superwall.sdk.network.Network.C28211) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.superwall.sdk.network.Network$getPaywalls$1 r0 = new com.superwall.sdk.network.Network$getPaywalls$1
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r8 = r0.L$0
            com.superwall.sdk.network.Network r8 = (com.superwall.sdk.network.Network) r8
            kotlin.ResultKt.b(r10)
        L2c:
            r2 = r8
            goto L46
        L2e:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L36:
            kotlin.ResultKt.b(r10)
            com.superwall.sdk.network.BaseHostService r10 = r8.baseHostService
            r0.L$0 = r8
            r0.label = r3
            java.lang.Object r10 = r10.paywalls(r9, r0)
            if (r10 != r1) goto L2c
            return r1
        L46:
            com.superwall.sdk.misc.Either r10 = (com.superwall.sdk.misc.Either) r10
            com.superwall.sdk.network.h r8 = new com.superwall.sdk.network.h
            r8.<init>()
            com.superwall.sdk.misc.Either r3 = com.superwall.sdk.misc.EitherKt.map(r10, r8)
            r6 = 2
            r7 = 0
            r4 = 0
            java.lang.String r4 = com.facebook.internal.instrument.anrreport.jRA.jlWo.xQroKCZyxro
            r5 = 0
            com.superwall.sdk.misc.Either r8 = logError$default(r2, r3, r4, r5, r6, r7)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.network.Network.getPaywalls$suspendImpl(com.superwall.sdk.network.Network, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
