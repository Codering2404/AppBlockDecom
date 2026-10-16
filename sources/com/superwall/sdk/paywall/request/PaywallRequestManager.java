package com.superwall.sdk.paywall.request;

import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import com.superwall.sdk.Superwall;
import com.superwall.sdk.analytics.internal.TrackingKt;
import com.superwall.sdk.analytics.internal.trackable.InternalSuperwallEvent;
import com.superwall.sdk.analytics.internal.trackable.TrackableSuperwallEvent;
import com.superwall.sdk.logger.LogLevel;
import com.superwall.sdk.logger.LogScope;
import com.superwall.sdk.logger.Logger;
import com.superwall.sdk.misc.Either;
import com.superwall.sdk.misc.EitherKt;
import com.superwall.sdk.misc.IOScope;
import com.superwall.sdk.models.events.EventData;
import com.superwall.sdk.models.paywall.Paywall;
import com.superwall.sdk.models.product.ProductItem;
import com.superwall.sdk.models.triggers.Experiment;
import com.superwall.sdk.network.Network;
import com.superwall.sdk.paywall.presentation.PaywallInfo;
import com.superwall.sdk.store.StoreManager;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;

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
public final class PaywallRequestManager {
    private final ConcurrentHashMap<String, Deferred<Paywall>> activeTasks;
    private final AtomicLong cacheGeneration;
    private final PaywallRequestManagerDepFactory factory;
    private final Function0<Map<String, String>> getGlobalOverrides;
    private final IOScope ioScope;
    private final Network network;
    private final ConcurrentHashMap<String, Paywall> paywallsByHash;
    private final StoreManager storeManager;
    private final Function2<TrackableSuperwallEvent, Continuation<? super Unit>, Object> track;
    private final CoroutineScope trackScope;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: renamed from: com.superwall.sdk.paywall.request.PaywallRequestManager$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.request.PaywallRequestManager$1", f = "PaywallRequestManager.kt", l = {55}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<TrackableSuperwallEvent, Continuation<? super Unit>, Object> {
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
        public final Object invoke(TrackableSuperwallEvent trackableSuperwallEvent, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(trackableSuperwallEvent, continuation)).invokeSuspend(Unit.f139807a);
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

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.request.PaywallRequestManager$addProducts$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.request.PaywallRequestManager$addProducts$2", f = "PaywallRequestManager.kt", l = {360, 372}, m = "invokeSuspend")
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Paywall>, Object> {
        final /* synthetic */ Paywall $paywall;
        final /* synthetic */ PaywallRequest $request;
        Object L$0;
        int label;
        final /* synthetic */ PaywallRequestManager this$0;

        /* JADX INFO: renamed from: com.superwall.sdk.paywall.request.PaywallRequestManager$addProducts$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @DebugMetadata(c = "com.superwall.sdk.paywall.request.PaywallRequestManager$addProducts$2$1", f = "PaywallRequestManager.kt", l = {369}, m = "invokeSuspend")
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ InternalSuperwallEvent.PaywallProductsLoad $productLoadFailEvent;
            int label;
            final /* synthetic */ PaywallRequestManager this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(PaywallRequestManager paywallRequestManager, InternalSuperwallEvent.PaywallProductsLoad paywallProductsLoad, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = paywallRequestManager;
                this.$productLoadFailEvent = paywallProductsLoad;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, this.$productLoadFailEvent, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objF = IntrinsicsKt.f();
                int i3 = this.label;
                if (i3 == 0) {
                    ResultKt.b(obj);
                    Function2 function2 = this.this$0.track;
                    InternalSuperwallEvent.PaywallProductsLoad paywallProductsLoad = this.$productLoadFailEvent;
                    this.label = 1;
                    if (function2.invoke(paywallProductsLoad, this) == objF) {
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
        AnonymousClass2(Paywall paywall, PaywallRequestManager paywallRequestManager, PaywallRequest paywallRequest, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$paywall = paywall;
            this.this$0 = paywallRequestManager;
            this.$request = paywallRequest;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$paywall, this.this$0, this.$request, continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x004c, code lost:
        
            if (r10 == r0) goto L20;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v0, types: [int] */
        /* JADX WARN: Type inference failed for: r1v12 */
        /* JADX WARN: Type inference failed for: r1v13 */
        /* JADX WARN: Type inference failed for: r1v7, types: [com.superwall.sdk.models.paywall.Paywall] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r10) throws java.lang.Throwable {
            /*
                r9 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r1 = r9.label
                r2 = 0
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L26
                if (r1 == r4) goto L1b
                if (r1 != r3) goto L13
                kotlin.ResultKt.b(r10)
                goto L4f
            L13:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r0)
                throw r10
            L1b:
                java.lang.Object r1 = r9.L$0
                com.superwall.sdk.models.paywall.Paywall r1 = (com.superwall.sdk.models.paywall.Paywall) r1
                kotlin.ResultKt.b(r10)     // Catch: java.lang.Throwable -> L23
                goto L40
            L23:
                r0 = move-exception
                r10 = r0
                goto L5e
            L26:
                kotlin.ResultKt.b(r10)
                com.superwall.sdk.models.paywall.Paywall r10 = r9.$paywall
                com.superwall.sdk.paywall.request.PaywallRequestManager r1 = r9.this$0
                com.superwall.sdk.paywall.request.PaywallRequest r5 = r9.$request
                com.superwall.sdk.models.paywall.Paywall r1 = com.superwall.sdk.paywall.request.PaywallRequestManager.access$trackProductsLoadStart(r1, r10, r5)
                com.superwall.sdk.paywall.request.PaywallRequestManager r10 = r9.this$0     // Catch: java.lang.Throwable -> L23
                r9.L$0 = r1     // Catch: java.lang.Throwable -> L23
                r9.label = r4     // Catch: java.lang.Throwable -> L23
                java.lang.Object r10 = com.superwall.sdk.paywall.request.PaywallRequestManager.access$fetchAndCacheCustomProducts(r10, r1, r9)     // Catch: java.lang.Throwable -> L23
                if (r10 != r0) goto L40
                goto L4e
            L40:
                com.superwall.sdk.paywall.request.PaywallRequestManager r10 = r9.this$0
                com.superwall.sdk.paywall.request.PaywallRequest r4 = r9.$request
                r9.L$0 = r2
                r9.label = r3
                java.lang.Object r10 = com.superwall.sdk.paywall.request.PaywallRequestManager.access$getProducts(r10, r1, r4, r9)
                if (r10 != r0) goto L4f
            L4e:
                return r0
            L4f:
                com.superwall.sdk.models.paywall.Paywall r10 = (com.superwall.sdk.models.paywall.Paywall) r10
                com.superwall.sdk.paywall.request.PaywallRequestManager r0 = r9.this$0
                com.superwall.sdk.paywall.request.PaywallRequest r1 = r9.$request
                com.superwall.sdk.models.events.EventData r1 = r1.getEventData()
                com.superwall.sdk.models.paywall.Paywall r10 = com.superwall.sdk.paywall.request.PaywallRequestManager.access$trackProductsLoadFinish(r0, r10, r1)
                return r10
            L5e:
                com.superwall.sdk.models.paywall.Paywall$LoadingInfo r0 = r1.getProductsLoadingInfo()
                java.util.Date r3 = new java.util.Date
                r3.<init>()
                r0.setFailAt(r3)
                com.superwall.sdk.analytics.internal.trackable.InternalSuperwallEvent$PaywallProductsLoad r0 = new com.superwall.sdk.analytics.internal.trackable.InternalSuperwallEvent$PaywallProductsLoad
                com.superwall.sdk.analytics.internal.trackable.InternalSuperwallEvent$PaywallProductsLoad$State$Fail r3 = new com.superwall.sdk.analytics.internal.trackable.InternalSuperwallEvent$PaywallProductsLoad$State$Fail
                java.lang.String r4 = r10.getMessage()
                r3.<init>(r4)
                com.superwall.sdk.paywall.request.PaywallRequest r4 = r9.$request
                com.superwall.sdk.models.events.EventData r4 = r4.getEventData()
                com.superwall.sdk.paywall.presentation.PaywallInfo r1 = r1.getInfo(r4)
                com.superwall.sdk.paywall.request.PaywallRequest r4 = r9.$request
                com.superwall.sdk.models.events.EventData r4 = r4.getEventData()
                r0.<init>(r3, r1, r4)
                com.superwall.sdk.paywall.request.PaywallRequestManager r1 = r9.this$0
                kotlinx.coroutines.CoroutineScope r3 = com.superwall.sdk.paywall.request.PaywallRequestManager.access$getTrackScope$p(r1)
                com.superwall.sdk.paywall.request.PaywallRequestManager$addProducts$2$1 r6 = new com.superwall.sdk.paywall.request.PaywallRequestManager$addProducts$2$1
                com.superwall.sdk.paywall.request.PaywallRequestManager r1 = r9.this$0
                r6.<init>(r1, r0, r2)
                r7 = 3
                r8 = 0
                r4 = 0
                r5 = 0
                kotlinx.coroutines.BuildersKt.d(r3, r4, r5, r6, r7, r8)
                throw r10
            */
            throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.paywall.request.PaywallRequestManager.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Paywall> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.request.PaywallRequestManager$convertProductOverrides$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.request.PaywallRequestManager", f = "PaywallRequestManager.kt", l = {497}, m = "convertProductOverrides")
    static final class C28511 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C28511(Continuation<? super C28511> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PaywallRequestManager.this.convertProductOverrides(null, this);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.request.PaywallRequestManager$getPaywall$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.request.PaywallRequestManager", f = "PaywallRequestManager.kt", l = {80}, m = "getPaywall")
    static final class C28521 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C28521(Continuation<? super C28521> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PaywallRequestManager.this.getPaywall(null, false, this);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.request.PaywallRequestManager$getPaywallResponse$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.request.PaywallRequestManager$getPaywallResponse$2", f = "PaywallRequestManager.kt", l = {291, 295, 308}, m = "invokeSuspend")
    static final class C28532 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Either<? extends Paywall, ?>>, Object> {
        final /* synthetic */ boolean $isPreloading;
        final /* synthetic */ PaywallRequest $request;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        final /* synthetic */ PaywallRequestManager this$0;

        /* JADX INFO: renamed from: com.superwall.sdk.paywall.request.PaywallRequestManager$getPaywallResponse$2$2, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @DebugMetadata(c = "com.superwall.sdk.paywall.request.PaywallRequestManager$getPaywallResponse$2$2", f = "PaywallRequestManager.kt", l = {}, m = "invokeSuspend")
        static final class C02442 extends SuspendLambda implements Function2<Paywall, Continuation<? super Unit>, Object> {
            final /* synthetic */ String $paywallId;
            /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C02442(String str, Continuation<? super C02442> continuation) {
                super(2, continuation);
                this.$paywallId = str;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C02442 c02442 = new C02442(this.$paywallId, continuation);
                c02442.L$0 = obj;
                return c02442;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Paywall paywall, Continuation<? super Unit> continuation) {
                return ((C02442) create(paywall, continuation)).invokeSuspend(Unit.f139807a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                IntrinsicsKt.f();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                Paywall paywall = (Paywall) this.L$0;
                Logger.debug$default(Logger.INSTANCE, LogLevel.debug, LogScope.all, "!!getPaywallResponse - " + this.$paywallId + " - " + paywall, (Map) null, (Throwable) null, 24, (Object) null);
                return Unit.f139807a;
            }
        }

        /* JADX INFO: renamed from: com.superwall.sdk.paywall.request.PaywallRequestManager$getPaywallResponse$2$4, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @DebugMetadata(c = "com.superwall.sdk.paywall.request.PaywallRequestManager$getPaywallResponse$2$4", f = "PaywallRequestManager.kt", l = {}, m = "invokeSuspend")
        static final class AnonymousClass4 extends SuspendLambda implements Function2<Paywall, Continuation<? super Unit>, Object> {
            final /* synthetic */ String $paywallId;
            /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass4(String str, Continuation<? super AnonymousClass4> continuation) {
                super(2, continuation);
                this.$paywallId = str;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass4 anonymousClass4 = new AnonymousClass4(this.$paywallId, continuation);
                anonymousClass4.L$0 = obj;
                return anonymousClass4;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Paywall paywall, Continuation<? super Unit> continuation) {
                return ((AnonymousClass4) create(paywall, continuation)).invokeSuspend(Unit.f139807a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                IntrinsicsKt.f();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                Paywall paywall = (Paywall) this.L$0;
                Logger.debug$default(Logger.INSTANCE, LogLevel.debug, LogScope.all, "!!getPaywallResponse - " + this.$paywallId + " - " + paywall + " - " + paywall.getExperiment(), (Map) null, (Throwable) null, 24, (Object) null);
                return Unit.f139807a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C28532(PaywallRequest paywallRequest, PaywallRequestManager paywallRequestManager, boolean z2, Continuation<? super C28532> continuation) {
            super(2, continuation);
            this.$request = paywallRequest;
            this.this$0 = paywallRequestManager;
            this.$isPreloading = z2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Paywall invokeSuspend$lambda$1(boolean z2, PaywallRequestManager paywallRequestManager, PaywallRequest paywallRequest, Date date, Paywall paywall) {
            if (z2 && Intrinsics.areEqual(paywall.getIdentifier(), paywallRequestManager.factory.activePaywallId())) {
                return paywall;
            }
            paywall.setExperiment(paywallRequest.getResponseIdentifiers().getExperiment());
            paywall.getResponseLoadingInfo().setStartAt(date);
            paywall.getResponseLoadingInfo().setEndAt(new Date());
            return paywall;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C28532(this.$request, this.this$0, this.$isPreloading, continuation);
        }

        /* JADX WARN: Removed duplicated region for block: B:24:0x00a9  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x00d1  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r12) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 222
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.paywall.request.PaywallRequestManager.C28532.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Either<Paywall, ?>> continuation) {
            return ((C28532) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.request.PaywallRequestManager$getProducts$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.request.PaywallRequestManager$getProducts$2", f = "PaywallRequestManager.kt", l = {413, 420}, m = "invokeSuspend")
    static final class C28542 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Paywall>, Object> {
        final /* synthetic */ Paywall $paywall;
        final /* synthetic */ PaywallRequest $request;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ PaywallRequestManager this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C28542(Paywall paywall, PaywallRequest paywallRequest, PaywallRequestManager paywallRequestManager, Continuation<? super C28542> continuation) {
            super(2, continuation);
            this.$paywall = paywall;
            this.$request = paywallRequest;
            this.this$0 = paywallRequestManager;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C28542 c28542 = new C28542(this.$paywall, this.$request, this.this$0, continuation);
            c28542.L$0 = obj;
            return c28542;
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x008c, code lost:
        
            if (r10 == r0) goto L25;
         */
        /* JADX WARN: Removed duplicated region for block: B:26:0x00a6  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x00af  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r10) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 239
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.paywall.request.PaywallRequestManager.C28542.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Paywall> continuation) {
            return ((C28542) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.request.PaywallRequestManager$getRawPaywall$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.request.PaywallRequestManager$getRawPaywall$2", f = "PaywallRequestManager.kt", l = {262, 263}, m = "invokeSuspend")
    static final class C28552 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Either<? extends Paywall, ?>>, Object> {
        final /* synthetic */ boolean $isPreloading;
        final /* synthetic */ PaywallRequest $request;
        int label;
        final /* synthetic */ PaywallRequestManager this$0;

        /* JADX INFO: renamed from: com.superwall.sdk.paywall.request.PaywallRequestManager$getRawPaywall$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @DebugMetadata(c = "com.superwall.sdk.paywall.request.PaywallRequestManager$getRawPaywall$2$1", f = "PaywallRequestManager.kt", l = {}, m = "invokeSuspend")
        static final class AnonymousClass1 extends SuspendLambda implements Function2<Paywall, Continuation<? super Unit>, Object> {
            final /* synthetic */ PaywallRequest $request;
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ PaywallRequestManager this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(PaywallRequest paywallRequest, PaywallRequestManager paywallRequestManager, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$request = paywallRequest;
                this.this$0 = paywallRequestManager;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$request, this.this$0, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Paywall paywall, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(paywall, continuation)).invokeSuspend(Unit.f139807a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                IntrinsicsKt.f();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                this.this$0.trackResponseLoaded(((Paywall) this.L$0).getInfo(this.$request.getEventData()), this.$request.getEventData());
                return Unit.f139807a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C28552(PaywallRequest paywallRequest, PaywallRequestManager paywallRequestManager, boolean z2, Continuation<? super C28552> continuation) {
            super(2, continuation);
            this.$request = paywallRequest;
            this.this$0 = paywallRequestManager;
            this.$isPreloading = z2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C28552(this.$request, this.this$0, this.$isPreloading, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                Logger.debug$default(Logger.INSTANCE, LogLevel.debug, LogScope.all, "!!getRawPaywall - " + this.$request.getResponseIdentifiers().getPaywallId(), (Map) null, (Throwable) null, 24, (Object) null);
                this.this$0.trackResponseStarted(this.$request.getEventData());
                PaywallRequestManager paywallRequestManager = this.this$0;
                PaywallRequest paywallRequest = this.$request;
                boolean z2 = this.$isPreloading;
                this.label = 1;
                obj = paywallRequestManager.getPaywallResponse(paywallRequest, z2, this);
                if (obj != objF) {
                }
            }
            if (i3 != 1) {
                if (i3 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                return obj;
            }
            ResultKt.b(obj);
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$request, this.this$0, null);
            this.label = 2;
            Object objThen = EitherKt.then((Either) obj, anonymousClass1, this);
            return objThen == objF ? objF : objThen;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Either<Paywall, ?>> continuation) {
            return ((C28552) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.request.PaywallRequestManager$saveRequestHash$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.request.PaywallRequestManager$saveRequestHash$2", f = "PaywallRequestManager.kt", l = {}, m = "invokeSuspend")
    static final class C28562 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        final /* synthetic */ long $fetchGeneration;
        final /* synthetic */ boolean $isDebuggerLaunched;
        final /* synthetic */ Paywall $paywall;
        final /* synthetic */ String $requestHash;
        final /* synthetic */ Deferred<Paywall> $task;
        int label;
        final /* synthetic */ PaywallRequestManager this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C28562(boolean z2, PaywallRequestManager paywallRequestManager, long j3, String str, Paywall paywall, Deferred<Paywall> deferred, Continuation<? super C28562> continuation) {
            super(2, continuation);
            this.$isDebuggerLaunched = z2;
            this.this$0 = paywallRequestManager;
            this.$fetchGeneration = j3;
            this.$requestHash = str;
            this.$paywall = paywall;
            this.$task = deferred;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C28562(this.$isDebuggerLaunched, this.this$0, this.$fetchGeneration, this.$requestHash, this.$paywall, this.$task, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            if (!this.$isDebuggerLaunched && this.this$0.cacheGeneration.get() == this.$fetchGeneration) {
                this.this$0.paywallsByHash.put(this.$requestHash, this.$paywall);
            }
            return Boxing.a(this.this$0.activeTasks.remove(this.$requestHash, this.$task));
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
            return ((C28562) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.request.PaywallRequestManager$trackProductsLoadFinish$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.request.PaywallRequestManager$trackProductsLoadFinish$1", f = "PaywallRequestManager.kt", l = {473}, m = "invokeSuspend")
    static final class C28571 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ InternalSuperwallEvent.PaywallProductsLoad $productLoadEvent;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C28571(InternalSuperwallEvent.PaywallProductsLoad paywallProductsLoad, Continuation<? super C28571> continuation) {
            super(2, continuation);
            this.$productLoadEvent = paywallProductsLoad;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PaywallRequestManager.this.new C28571(this.$productLoadEvent, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                Function2 function2 = PaywallRequestManager.this.track;
                InternalSuperwallEvent.PaywallProductsLoad paywallProductsLoad = this.$productLoadEvent;
                this.label = 1;
                if (function2.invoke(paywallProductsLoad, this) == objF) {
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
            return ((C28571) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.request.PaywallRequestManager$trackProductsLoadStart$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.request.PaywallRequestManager$trackProductsLoadStart$1", f = "PaywallRequestManager.kt", l = {457}, m = "invokeSuspend")
    static final class C28581 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ InternalSuperwallEvent.PaywallProductsLoad $productLoadEvent;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C28581(InternalSuperwallEvent.PaywallProductsLoad paywallProductsLoad, Continuation<? super C28581> continuation) {
            super(2, continuation);
            this.$productLoadEvent = paywallProductsLoad;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PaywallRequestManager.this.new C28581(this.$productLoadEvent, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                Function2 function2 = PaywallRequestManager.this.track;
                InternalSuperwallEvent.PaywallProductsLoad paywallProductsLoad = this.$productLoadEvent;
                this.label = 1;
                if (function2.invoke(paywallProductsLoad, this) == objF) {
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
            return ((C28581) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.request.PaywallRequestManager$trackResponseLoaded$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.request.PaywallRequestManager$trackResponseLoaded$1", f = "PaywallRequestManager.kt", l = {346}, m = "invokeSuspend")
    static final class C28591 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ InternalSuperwallEvent.PaywallLoad $responseLoadEvent;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C28591(InternalSuperwallEvent.PaywallLoad paywallLoad, Continuation<? super C28591> continuation) {
            super(2, continuation);
            this.$responseLoadEvent = paywallLoad;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PaywallRequestManager.this.new C28591(this.$responseLoadEvent, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                Function2 function2 = PaywallRequestManager.this.track;
                InternalSuperwallEvent.PaywallLoad paywallLoad = this.$responseLoadEvent;
                this.label = 1;
                if (function2.invoke(paywallLoad, this) == objF) {
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
            return ((C28591) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.request.PaywallRequestManager$trackResponseStarted$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.request.PaywallRequestManager$trackResponseStarted$1", f = "PaywallRequestManager.kt", l = {334}, m = "invokeSuspend")
    static final class C28601 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ InternalSuperwallEvent.PaywallLoad $trackedEvent;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C28601(InternalSuperwallEvent.PaywallLoad paywallLoad, Continuation<? super C28601> continuation) {
            super(2, continuation);
            this.$trackedEvent = paywallLoad;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PaywallRequestManager.this.new C28601(this.$trackedEvent, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                Function2 function2 = PaywallRequestManager.this.track;
                InternalSuperwallEvent.PaywallLoad paywallLoad = this.$trackedEvent;
                this.label = 1;
                if (function2.invoke(paywallLoad, this) == objF) {
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
            return ((C28601) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.request.PaywallRequestManager$updatePaywall$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.request.PaywallRequestManager$updatePaywall$2", f = "PaywallRequestManager.kt", l = {}, m = "invokeSuspend")
    static final class C28612 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Paywall>, Object> {
        final /* synthetic */ Paywall $paywall;
        final /* synthetic */ PaywallRequest $request;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C28612(PaywallRequest paywallRequest, Paywall paywall, Continuation<? super C28612> continuation) {
            super(2, continuation);
            this.$request = paywallRequest;
            this.$paywall = paywall;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C28612(this.$request, this.$paywall, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            Experiment experiment = this.$request.getResponseIdentifiers().getExperiment();
            String presentationSourceType = this.$request.getPresentationSourceType();
            String string = UUID.randomUUID().toString();
            Paywall paywall = this.$paywall;
            return paywall.m1294copyBiBlP3E(((-553648129) & 1) != 0 ? paywall.databaseId : null, ((-553648129) & 2) != 0 ? paywall.identifier : null, ((-553648129) & 4) != 0 ? paywall.name : null, ((-553648129) & 8) != 0 ? paywall.url : null, ((-553648129) & 16) != 0 ? paywall.htmlSubstitutions : null, ((-553648129) & 32) != 0 ? paywall.presentationStyle : null, ((-553648129) & 64) != 0 ? paywall.expandedPresentationStyle : null, ((-553648129) & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? paywall.presentationDelay : 0L, ((-553648129) & Function.MAX_NARGS) != 0 ? paywall.presentationCondition : null, ((-553648129) & 512) != 0 ? paywall.presentation : null, ((-553648129) & 1024) != 0 ? paywall.backgroundColorHex : null, ((-553648129) & 2048) != 0 ? paywall.darkBackgroundColorHex : null, ((-553648129) & 4096) != 0 ? paywall._products : null, ((-553648129) & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? paywall._productItemsV3 : null, ((-553648129) & 16384) != 0 ? paywall._productItems : null, ((-553648129) & 32768) != 0 ? paywall.productIds : null, ((-553648129) & NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) != 0 ? paywall.responseLoadingInfo : null, ((-553648129) & 131072) != 0 ? paywall.webviewLoadingInfo : null, ((-553648129) & 262144) != 0 ? paywall.productsLoadingInfo : null, ((-553648129) & 524288) != 0 ? paywall.shimmerLoadingInfo : null, ((-553648129) & 1048576) != 0 ? paywall.productVariables : null, ((-553648129) & 2097152) != 0 ? paywall.swProductVariablesTemplate : null, ((-553648129) & 4194304) != 0 ? paywall.paywalljsVersion : null, ((-553648129) & 8388608) != 0 ? paywall.isFreeTrialAvailable : false, ((-553648129) & 16777216) != 0 ? paywall.presentationSourceType : presentationSourceType, ((-553648129) & 33554432) != 0 ? paywall.featureGating : null, ((-553648129) & 67108864) != 0 ? paywall.computedPropertyRequests : null, ((-553648129) & 134217728) != 0 ? paywall.localNotifications : null, ((-553648129) & 268435456) != 0 ? paywall.onDeviceCache : null, ((-553648129) & 536870912) != 0 ? paywall.experiment : experiment, ((-553648129) & 1073741824) != 0 ? paywall.closeReason : null, ((-553648129) & Integer.MIN_VALUE) != 0 ? paywall.state : null, (254 & 1) != 0 ? paywall.presentationId : string, (254 & 2) != 0 ? paywall.urlConfig : null, (254 & 4) != 0 ? paywall.cacheKey : null, (254 & 8) != 0 ? paywall.buildId : null, (254 & 16) != 0 ? paywall.surveys : null, (254 & 32) != 0 ? paywall.isScrollEnabled : null, (254 & 64) != 0 ? paywall.rerouteBackButton : null, (254 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? paywall.introOfferEligibility : null);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Paywall> continuation) {
            return ((C28612) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PaywallRequestManager(StoreManager storeManager, Network network, PaywallRequestManagerDepFactory factory, IOScope ioScope, Function2<? super TrackableSuperwallEvent, ? super Continuation<? super Unit>, ? extends Object> track, Function0<? extends Map<String, String>> getGlobalOverrides, CoroutineScope trackScope) {
        Intrinsics.checkNotNullParameter(storeManager, "storeManager");
        Intrinsics.checkNotNullParameter(network, "network");
        Intrinsics.checkNotNullParameter(factory, "factory");
        Intrinsics.checkNotNullParameter(ioScope, "ioScope");
        Intrinsics.checkNotNullParameter(track, "track");
        Intrinsics.checkNotNullParameter(getGlobalOverrides, "getGlobalOverrides");
        Intrinsics.checkNotNullParameter(trackScope, "trackScope");
        this.storeManager = storeManager;
        this.network = network;
        this.factory = factory;
        this.ioScope = ioScope;
        this.track = track;
        this.getGlobalOverrides = getGlobalOverrides;
        this.trackScope = trackScope;
        this.activeTasks = new ConcurrentHashMap<>();
        this.paywallsByHash = new ConcurrentHashMap<>();
        this.cacheGeneration = new AtomicLong(0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map _init_$lambda$0() {
        return Superwall.Companion.getInstance().getOverrideProductsByName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object convertProductOverrides(java.util.Map<java.lang.String, ? extends com.superwall.sdk.paywall.presentation.internal.request.ProductOverride> r10, kotlin.coroutines.Continuation<? super java.util.Map<java.lang.String, com.superwall.sdk.store.abstractions.product.StoreProduct>> r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 300
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.paywall.request.PaywallRequestManager.convertProductOverrides(java.util.Map, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object fetchAndCacheCustomProducts(Paywall paywall, Continuation<? super Unit> continuation) throws Throwable {
        List<ProductItem> productItems = paywall.getProductItems();
        ArrayList arrayList = new ArrayList();
        for (Object obj : productItems) {
            if (((ProductItem) obj).getType() instanceof ProductItem.StoreProductType.Custom) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj2 = arrayList.get(i3);
            i3++;
            arrayList2.add(((ProductItem) obj2).getFullProductId());
        }
        Set<String> set = CollectionsKt.toSet(arrayList2);
        if (set.isEmpty()) {
            return Unit.f139807a;
        }
        Object objFetchAndCacheCustomProducts = this.storeManager.fetchAndCacheCustomProducts(set, true, continuation);
        return objFetchAndCacheCustomProducts == IntrinsicsKt.f() ? objFetchAndCacheCustomProducts : Unit.f139807a;
    }

    public static /* synthetic */ Object getPaywall$default(PaywallRequestManager paywallRequestManager, PaywallRequest paywallRequest, boolean z2, Continuation continuation, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z2 = false;
        }
        return paywallRequestManager.getPaywall(paywallRequest, z2, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object getPaywallResponse(PaywallRequest paywallRequest, boolean z2, Continuation<? super Either<Paywall, ?>> continuation) {
        return BuildersKt.g(this.ioScope.getCoroutineContext(), new C28532(paywallRequest, this, z2, null), continuation);
    }

    static /* synthetic */ Object getPaywallResponse$default(PaywallRequestManager paywallRequestManager, PaywallRequest paywallRequest, boolean z2, Continuation continuation, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z2 = false;
        }
        return paywallRequestManager.getPaywallResponse(paywallRequest, z2, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object getProducts(Paywall paywall, PaywallRequest paywallRequest, Continuation<? super Paywall> continuation) {
        return BuildersKt.g(this.ioScope.getCoroutineContext(), new C28542(paywall, paywallRequest, this, null), continuation);
    }

    public static /* synthetic */ Object getRawPaywall$default(PaywallRequestManager paywallRequestManager, PaywallRequest paywallRequest, boolean z2, Continuation continuation, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z2 = false;
        }
        return paywallRequestManager.getRawPaywall(paywallRequest, z2, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean removeCachedPaywalls$lambda$4(Set set, Map.Entry it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return set.contains(((Paywall) it.getValue()).getIdentifier());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object saveRequestHash(String str, Deferred<Paywall> deferred, Paywall paywall, boolean z2, long j3, Continuation<? super Boolean> continuation) {
        return BuildersKt.g(this.ioScope.getCoroutineContext(), new C28562(z2, this, j3, str, paywall, deferred, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Paywall trackProductsLoadFinish(Paywall paywall, EventData eventData) {
        paywall.getProductsLoadingInfo().setEndAt(new Date());
        BuildersKt__Builders_commonKt.d(this.trackScope, null, null, new C28571(new InternalSuperwallEvent.PaywallProductsLoad(new InternalSuperwallEvent.PaywallProductsLoad.State.Complete(), paywall.getInfo(eventData), eventData), null), 3, null);
        return paywall;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Paywall trackProductsLoadStart(Paywall paywall, PaywallRequest paywallRequest) {
        paywall.getProductsLoadingInfo().setStartAt(new Date());
        BuildersKt__Builders_commonKt.d(this.trackScope, null, null, new C28581(new InternalSuperwallEvent.PaywallProductsLoad(new InternalSuperwallEvent.PaywallProductsLoad.State.Start(), paywall.getInfo(paywallRequest.getEventData()), paywallRequest.getEventData()), null), 3, null);
        return paywall;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void trackResponseLoaded(PaywallInfo paywallInfo, EventData eventData) {
        BuildersKt__Builders_commonKt.d(this.trackScope, null, null, new C28591(new InternalSuperwallEvent.PaywallLoad(new InternalSuperwallEvent.PaywallLoad.State.Complete(paywallInfo), eventData), null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void trackResponseStarted(EventData eventData) {
        BuildersKt__Builders_commonKt.d(this.trackScope, null, null, new C28601(new InternalSuperwallEvent.PaywallLoad(new InternalSuperwallEvent.PaywallLoad.State.Start(), eventData), null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object updatePaywall(Paywall paywall, PaywallRequest paywallRequest, Continuation<? super Paywall> continuation) {
        return BuildersKt.g(this.ioScope.getCoroutineContext(), new C28612(paywallRequest, paywall, null), continuation);
    }

    public final Object addProducts(Paywall paywall, PaywallRequest paywallRequest, Continuation<? super Paywall> continuation) {
        return BuildersKt.g(this.ioScope.getCoroutineContext(), new AnonymousClass2(paywall, this, paywallRequest, null), continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getPaywall(com.superwall.sdk.paywall.request.PaywallRequest r6, boolean r7, kotlin.coroutines.Continuation<? super com.superwall.sdk.misc.Either<com.superwall.sdk.models.paywall.Paywall, java.lang.Throwable>> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof com.superwall.sdk.paywall.request.PaywallRequestManager.C28521
            if (r0 == 0) goto L13
            r0 = r8
            com.superwall.sdk.paywall.request.PaywallRequestManager$getPaywall$1 r0 = (com.superwall.sdk.paywall.request.PaywallRequestManager.C28521) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.superwall.sdk.paywall.request.PaywallRequestManager$getPaywall$1 r0 = new com.superwall.sdk.paywall.request.PaywallRequestManager$getPaywall$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            kotlin.ResultKt.b(r8)     // Catch: java.lang.Throwable -> L29
            goto L4b
        L29:
            r6 = move-exception
            goto L53
        L2b:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L33:
            kotlin.ResultKt.b(r8)
            com.superwall.sdk.misc.IOScope r8 = r5.ioScope     // Catch: java.lang.Throwable -> L29
            kotlin.coroutines.CoroutineContext r8 = r8.getCoroutineContext()     // Catch: java.lang.Throwable -> L29
            com.superwall.sdk.paywall.request.PaywallRequestManager$getPaywall$2$1 r2 = new com.superwall.sdk.paywall.request.PaywallRequestManager$getPaywall$2$1     // Catch: java.lang.Throwable -> L29
            r4 = 0
            r2.<init>(r5, r6, r7, r4)     // Catch: java.lang.Throwable -> L29
            r0.label = r3     // Catch: java.lang.Throwable -> L29
            java.lang.Object r8 = kotlinx.coroutines.BuildersKt.g(r8, r2, r0)     // Catch: java.lang.Throwable -> L29
            if (r8 != r1) goto L4b
            return r1
        L4b:
            com.superwall.sdk.models.paywall.Paywall r8 = (com.superwall.sdk.models.paywall.Paywall) r8     // Catch: java.lang.Throwable -> L29
            com.superwall.sdk.misc.Either$Success r6 = new com.superwall.sdk.misc.Either$Success     // Catch: java.lang.Throwable -> L29
            r6.<init>(r8)     // Catch: java.lang.Throwable -> L29
            return r6
        L53:
            boolean r7 = com.superwall.sdk.utilities.ErrorTrackingKt.shouldLog(r6)
            if (r7 == 0) goto L68
            com.superwall.sdk.Superwall$Companion r7 = com.superwall.sdk.Superwall.Companion
            boolean r8 = r7.getInitialized()
            if (r8 == 0) goto L68
            com.superwall.sdk.Superwall r7 = r7.getInstance()
            com.superwall.sdk.utilities.ErrorTrackingKt.trackError(r7, r6)
        L68:
            com.superwall.sdk.misc.Either$Failure r7 = new com.superwall.sdk.misc.Either$Failure
            r7.<init>(r6)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.paywall.request.PaywallRequestManager.getPaywall(com.superwall.sdk.paywall.request.PaywallRequest, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object getRawPaywall(PaywallRequest paywallRequest, boolean z2, Continuation<? super Either<Paywall, ?>> continuation) {
        return BuildersKt.g(this.ioScope.getCoroutineContext(), new C28552(paywallRequest, this, z2, null), continuation);
    }

    public final void removeCachedPaywalls(final Set<String> identifiers) {
        Intrinsics.checkNotNullParameter(identifiers, "identifiers");
        this.cacheGeneration.incrementAndGet();
        Set<Map.Entry<String, Paywall>> setEntrySet = this.paywallsByHash.entrySet();
        Intrinsics.checkNotNullExpressionValue(setEntrySet, "<get-entries>(...)");
        CollectionsKt.removeAll(setEntrySet, new Function1() { // from class: com.superwall.sdk.paywall.request.d
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(PaywallRequestManager.removeCachedPaywalls$lambda$4(identifiers, (Map.Entry) obj));
            }
        });
    }

    public final void resetCache$superwall_release() {
        this.cacheGeneration.incrementAndGet();
        this.paywallsByHash.clear();
    }

    public /* synthetic */ PaywallRequestManager(StoreManager storeManager, Network network, PaywallRequestManagerDepFactory paywallRequestManagerDepFactory, IOScope iOScope, Function2 function2, Function0 function0, CoroutineScope coroutineScope, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(storeManager, network, paywallRequestManagerDepFactory, iOScope, (i3 & 16) != 0 ? new AnonymousClass1(null) : function2, (i3 & 32) != 0 ? new Function0() { // from class: com.superwall.sdk.paywall.request.c
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PaywallRequestManager._init_$lambda$0();
            }
        } : function0, (i3 & 64) != 0 ? new IOScope(CoroutineDispatcher.q0(Dispatchers.b(), 1, null, 2, null)) : coroutineScope);
    }
}
