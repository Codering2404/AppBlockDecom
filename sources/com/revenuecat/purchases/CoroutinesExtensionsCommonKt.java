package com.revenuecat.purchases;

import android.content.Context;
import com.revenuecat.purchases.Purchases;
import com.revenuecat.purchases.common.CancellableContinuationExtensionsKt;
import com.revenuecat.purchases.interfaces.Callback;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.models.StoreTransaction;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class CoroutinesExtensionsCommonKt {

    /* JADX INFO: renamed from: com.revenuecat.purchases.CoroutinesExtensionsCommonKt$awaitGetProductsResult$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.revenuecat.purchases.CoroutinesExtensionsCommonKt", f = "CoroutinesExtensionsCommon.kt", l = {289}, m = "awaitGetProductsResult")
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            Object objAwaitGetProductsResult = CoroutinesExtensionsCommonKt.awaitGetProductsResult(null, null, null, this);
            return objAwaitGetProductsResult == IntrinsicsKt.f() ? objAwaitGetProductsResult : Result.a(objAwaitGetProductsResult);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.CoroutinesExtensionsCommonKt$awaitOfferingsResult$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.revenuecat.purchases.CoroutinesExtensionsCommonKt", f = "CoroutinesExtensionsCommon.kt", l = {289}, m = "awaitOfferingsResult")
    static final class C22731 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C22731(Continuation<? super C22731> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            Object objAwaitOfferingsResult = CoroutinesExtensionsCommonKt.awaitOfferingsResult(null, this);
            return objAwaitOfferingsResult == IntrinsicsKt.f() ? objAwaitOfferingsResult : Result.a(objAwaitOfferingsResult);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.CoroutinesExtensionsCommonKt$awaitPurchaseResult$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.revenuecat.purchases.CoroutinesExtensionsCommonKt", f = "CoroutinesExtensionsCommon.kt", l = {289}, m = "awaitPurchaseResult")
    static final class C22741 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C22741(Continuation<? super C22741> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            Object objAwaitPurchaseResult = CoroutinesExtensionsCommonKt.awaitPurchaseResult(null, null, this);
            return objAwaitPurchaseResult == IntrinsicsKt.f() ? objAwaitPurchaseResult : Result.a(objAwaitPurchaseResult);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.CoroutinesExtensionsCommonKt$awaitRestoreResult$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.revenuecat.purchases.CoroutinesExtensionsCommonKt", f = "CoroutinesExtensionsCommon.kt", l = {289}, m = "awaitRestoreResult")
    static final class C22751 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C22751(Continuation<? super C22751> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            Object objAwaitRestoreResult = CoroutinesExtensionsCommonKt.awaitRestoreResult(null, this);
            return objAwaitRestoreResult == IntrinsicsKt.f() ? objAwaitRestoreResult : Result.a(objAwaitRestoreResult);
        }
    }

    public static final /* synthetic */ Object awaitCanMakePayments(Purchases.Companion companion, Context context, List list, Continuation continuation) {
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.c(continuation), 1);
        cancellableContinuationImpl.C();
        companion.canMakePayments(context, list, new Callback() { // from class: com.revenuecat.purchases.CoroutinesExtensionsCommonKt$awaitCanMakePayments$2$1
            @Override // com.revenuecat.purchases.interfaces.Callback
            public final void onReceived(Boolean bool) {
                CancellableContinuationExtensionsKt.safeResume(cancellableContinuationImpl, bool);
            }
        });
        Object objV = cancellableContinuationImpl.v();
        if (objV == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return objV;
    }

    public static /* synthetic */ Object awaitCanMakePayments$default(Purchases.Companion companion, Context context, List list, Continuation continuation, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            list = CollectionsKt.emptyList();
        }
        return awaitCanMakePayments(companion, context, list, continuation);
    }

    public static final /* synthetic */ Object awaitGetProducts(Purchases purchases, List list, ProductType productType, Continuation continuation) throws PurchasesTransactionException {
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.c(continuation), 1);
        cancellableContinuationImpl.C();
        ListenerConversionsCommonKt.getProductsWith(purchases, list, productType, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.CoroutinesExtensionsCommonKt$awaitGetProducts$2$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((PurchasesError) obj);
                return Unit.f139807a;
            }

            public final void invoke(PurchasesError it) {
                Intrinsics.checkNotNullParameter(it, "it");
                CancellableContinuationExtensionsKt.safeResumeWithException(cancellableContinuationImpl, new PurchasesException(it));
            }
        }, new Function1<List<? extends StoreProduct>, Unit>() { // from class: com.revenuecat.purchases.CoroutinesExtensionsCommonKt$awaitGetProducts$2$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((List<? extends StoreProduct>) obj);
                return Unit.f139807a;
            }

            public final void invoke(List<? extends StoreProduct> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                CancellableContinuationExtensionsKt.safeResume(cancellableContinuationImpl, it);
            }
        });
        Object objV = cancellableContinuationImpl.v();
        if (objV == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return objV;
    }

    public static /* synthetic */ Object awaitGetProducts$default(Purchases purchases, List list, ProductType productType, Continuation continuation, int i3, Object obj) throws PurchasesTransactionException {
        if ((i3 & 2) != 0) {
            productType = null;
        }
        return awaitGetProducts(purchases, list, productType, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ java.lang.Object awaitGetProductsResult(com.revenuecat.purchases.Purchases r4, java.util.List r5, com.revenuecat.purchases.ProductType r6, kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
        /*
            boolean r0 = r7 instanceof com.revenuecat.purchases.CoroutinesExtensionsCommonKt.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r7
            com.revenuecat.purchases.CoroutinesExtensionsCommonKt$awaitGetProductsResult$1 r0 = (com.revenuecat.purchases.CoroutinesExtensionsCommonKt.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.revenuecat.purchases.CoroutinesExtensionsCommonKt$awaitGetProductsResult$1 r0 = new com.revenuecat.purchases.CoroutinesExtensionsCommonKt$awaitGetProductsResult$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r4 = r0.L$2
            com.revenuecat.purchases.ProductType r4 = (com.revenuecat.purchases.ProductType) r4
            java.lang.Object r4 = r0.L$1
            java.util.List r4 = (java.util.List) r4
            java.lang.Object r4 = r0.L$0
            com.revenuecat.purchases.Purchases r4 = (com.revenuecat.purchases.Purchases) r4
            kotlin.ResultKt.b(r7)
            goto L71
        L35:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3d:
            kotlin.ResultKt.b(r7)
            r0.L$0 = r4
            r0.L$1 = r5
            r0.L$2 = r6
            r0.label = r3
            kotlinx.coroutines.CancellableContinuationImpl r7 = new kotlinx.coroutines.CancellableContinuationImpl
            kotlin.coroutines.Continuation r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.c(r0)
            r7.<init>(r2, r3)
            r7.C()
            com.revenuecat.purchases.CoroutinesExtensionsCommonKt$awaitGetProductsResult$2$1 r2 = new com.revenuecat.purchases.CoroutinesExtensionsCommonKt$awaitGetProductsResult$2$1
            r2.<init>()
            com.revenuecat.purchases.CoroutinesExtensionsCommonKt$awaitGetProductsResult$2$2 r3 = new com.revenuecat.purchases.CoroutinesExtensionsCommonKt$awaitGetProductsResult$2$2
            r3.<init>()
            com.revenuecat.purchases.ListenerConversionsCommonKt.getProductsWith(r4, r5, r6, r2, r3)
            java.lang.Object r7 = r7.v()
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            if (r7 != r4) goto L6e
            kotlin.coroutines.jvm.internal.DebugProbesKt.c(r0)
        L6e:
            if (r7 != r1) goto L71
            return r1
        L71:
            kotlin.Result r7 = (kotlin.Result) r7
            java.lang.Object r4 = r7.j()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.CoroutinesExtensionsCommonKt.awaitGetProductsResult(com.revenuecat.purchases.Purchases, java.util.List, com.revenuecat.purchases.ProductType, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object awaitGetProductsResult$default(Purchases purchases, List list, ProductType productType, Continuation continuation, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            productType = null;
        }
        return awaitGetProductsResult(purchases, list, productType, continuation);
    }

    public static final /* synthetic */ Object awaitOfferings(Purchases purchases, Continuation continuation) throws PurchasesException {
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.c(continuation), 1);
        cancellableContinuationImpl.C();
        ListenerConversionsCommonKt.getOfferingsWith(purchases, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.CoroutinesExtensionsCommonKt$awaitOfferings$2$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((PurchasesError) obj);
                return Unit.f139807a;
            }

            public final void invoke(PurchasesError it) {
                Intrinsics.checkNotNullParameter(it, "it");
                CancellableContinuationExtensionsKt.safeResumeWithException(cancellableContinuationImpl, new PurchasesException(it));
            }
        }, new Function1<Offerings, Unit>() { // from class: com.revenuecat.purchases.CoroutinesExtensionsCommonKt$awaitOfferings$2$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Offerings) obj);
                return Unit.f139807a;
            }

            public final void invoke(Offerings it) {
                Intrinsics.checkNotNullParameter(it, "it");
                CancellableContinuationExtensionsKt.safeResume(cancellableContinuationImpl, it);
            }
        });
        Object objV = cancellableContinuationImpl.v();
        if (objV == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return objV;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ java.lang.Object awaitOfferingsResult(com.revenuecat.purchases.Purchases r4, kotlin.coroutines.Continuation r5) throws java.lang.Throwable {
        /*
            boolean r0 = r5 instanceof com.revenuecat.purchases.CoroutinesExtensionsCommonKt.C22731
            if (r0 == 0) goto L13
            r0 = r5
            com.revenuecat.purchases.CoroutinesExtensionsCommonKt$awaitOfferingsResult$1 r0 = (com.revenuecat.purchases.CoroutinesExtensionsCommonKt.C22731) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.revenuecat.purchases.CoroutinesExtensionsCommonKt$awaitOfferingsResult$1 r0 = new com.revenuecat.purchases.CoroutinesExtensionsCommonKt$awaitOfferingsResult$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r4 = r0.L$0
            com.revenuecat.purchases.Purchases r4 = (com.revenuecat.purchases.Purchases) r4
            kotlin.ResultKt.b(r5)
            goto L65
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            kotlin.ResultKt.b(r5)
            r0.L$0 = r4
            r0.label = r3
            kotlinx.coroutines.CancellableContinuationImpl r5 = new kotlinx.coroutines.CancellableContinuationImpl
            kotlin.coroutines.Continuation r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.c(r0)
            r5.<init>(r2, r3)
            r5.C()
            com.revenuecat.purchases.CoroutinesExtensionsCommonKt$awaitOfferingsResult$2$1 r2 = new com.revenuecat.purchases.CoroutinesExtensionsCommonKt$awaitOfferingsResult$2$1
            r2.<init>()
            com.revenuecat.purchases.CoroutinesExtensionsCommonKt$awaitOfferingsResult$2$2 r3 = new com.revenuecat.purchases.CoroutinesExtensionsCommonKt$awaitOfferingsResult$2$2
            r3.<init>()
            com.revenuecat.purchases.ListenerConversionsCommonKt.getOfferingsWith(r4, r2, r3)
            java.lang.Object r5 = r5.v()
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            if (r5 != r4) goto L62
            kotlin.coroutines.jvm.internal.DebugProbesKt.c(r0)
        L62:
            if (r5 != r1) goto L65
            return r1
        L65:
            kotlin.Result r5 = (kotlin.Result) r5
            java.lang.Object r4 = r5.j()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.CoroutinesExtensionsCommonKt.awaitOfferingsResult(com.revenuecat.purchases.Purchases, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final /* synthetic */ Object awaitPurchase(Purchases purchases, PurchaseParams purchaseParams, Continuation continuation) throws PurchasesException {
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.c(continuation), 1);
        cancellableContinuationImpl.C();
        purchases.purchase(purchaseParams, ListenerConversionsCommonKt.purchaseCompletedCallback(new Function2<StoreTransaction, CustomerInfo, Unit>() { // from class: com.revenuecat.purchases.CoroutinesExtensionsCommonKt$awaitPurchase$2$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((StoreTransaction) obj, (CustomerInfo) obj2);
                return Unit.f139807a;
            }

            public final void invoke(StoreTransaction storeTransaction, CustomerInfo customerInfo) {
                Intrinsics.checkNotNullParameter(storeTransaction, "storeTransaction");
                Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
                CancellableContinuationExtensionsKt.safeResume(cancellableContinuationImpl, new PurchaseResult(storeTransaction, customerInfo));
            }
        }, new Function2<PurchasesError, Boolean, Unit>() { // from class: com.revenuecat.purchases.CoroutinesExtensionsCommonKt$awaitPurchase$2$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((PurchasesError) obj, ((Boolean) obj2).booleanValue());
                return Unit.f139807a;
            }

            public final void invoke(PurchasesError purchasesError, boolean z2) {
                Intrinsics.checkNotNullParameter(purchasesError, "purchasesError");
                CancellableContinuationExtensionsKt.safeResumeWithException(cancellableContinuationImpl, new PurchasesTransactionException(purchasesError, z2));
            }
        }));
        Object objV = cancellableContinuationImpl.v();
        if (objV == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return objV;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ java.lang.Object awaitPurchaseResult(com.revenuecat.purchases.Purchases r4, com.revenuecat.purchases.PurchaseParams r5, kotlin.coroutines.Continuation r6) throws java.lang.Throwable {
        /*
            boolean r0 = r6 instanceof com.revenuecat.purchases.CoroutinesExtensionsCommonKt.C22741
            if (r0 == 0) goto L13
            r0 = r6
            com.revenuecat.purchases.CoroutinesExtensionsCommonKt$awaitPurchaseResult$1 r0 = (com.revenuecat.purchases.CoroutinesExtensionsCommonKt.C22741) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.revenuecat.purchases.CoroutinesExtensionsCommonKt$awaitPurchaseResult$1 r0 = new com.revenuecat.purchases.CoroutinesExtensionsCommonKt$awaitPurchaseResult$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r4 = r0.L$1
            com.revenuecat.purchases.PurchaseParams r4 = (com.revenuecat.purchases.PurchaseParams) r4
            java.lang.Object r4 = r0.L$0
            com.revenuecat.purchases.Purchases r4 = (com.revenuecat.purchases.Purchases) r4
            kotlin.ResultKt.b(r6)
            goto L6f
        L31:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L39:
            kotlin.ResultKt.b(r6)
            r0.L$0 = r4
            r0.L$1 = r5
            r0.label = r3
            kotlinx.coroutines.CancellableContinuationImpl r6 = new kotlinx.coroutines.CancellableContinuationImpl
            kotlin.coroutines.Continuation r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.c(r0)
            r6.<init>(r2, r3)
            r6.C()
            com.revenuecat.purchases.CoroutinesExtensionsCommonKt$awaitPurchaseResult$2$1 r2 = new com.revenuecat.purchases.CoroutinesExtensionsCommonKt$awaitPurchaseResult$2$1
            r2.<init>()
            com.revenuecat.purchases.CoroutinesExtensionsCommonKt$awaitPurchaseResult$2$2 r3 = new com.revenuecat.purchases.CoroutinesExtensionsCommonKt$awaitPurchaseResult$2$2
            r3.<init>()
            com.revenuecat.purchases.interfaces.PurchaseCallback r2 = com.revenuecat.purchases.ListenerConversionsCommonKt.purchaseCompletedCallback(r2, r3)
            r4.purchase(r5, r2)
            java.lang.Object r6 = r6.v()
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            if (r6 != r4) goto L6c
            kotlin.coroutines.jvm.internal.DebugProbesKt.c(r0)
        L6c:
            if (r6 != r1) goto L6f
            return r1
        L6f:
            kotlin.Result r6 = (kotlin.Result) r6
            java.lang.Object r4 = r6.j()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.CoroutinesExtensionsCommonKt.awaitPurchaseResult(com.revenuecat.purchases.Purchases, com.revenuecat.purchases.PurchaseParams, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final /* synthetic */ Object awaitRestore(Purchases purchases, Continuation continuation) throws PurchasesTransactionException {
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.c(continuation), 1);
        cancellableContinuationImpl.C();
        ListenerConversionsCommonKt.restorePurchasesWith(purchases, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.CoroutinesExtensionsCommonKt$awaitRestore$2$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((PurchasesError) obj);
                return Unit.f139807a;
            }

            public final void invoke(PurchasesError it) {
                Intrinsics.checkNotNullParameter(it, "it");
                CancellableContinuationExtensionsKt.safeResumeWithException(cancellableContinuationImpl, new PurchasesException(it));
            }
        }, new Function1<CustomerInfo, Unit>() { // from class: com.revenuecat.purchases.CoroutinesExtensionsCommonKt$awaitRestore$2$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((CustomerInfo) obj);
                return Unit.f139807a;
            }

            public final void invoke(CustomerInfo it) {
                Intrinsics.checkNotNullParameter(it, "it");
                CancellableContinuationExtensionsKt.safeResume(cancellableContinuationImpl, it);
            }
        });
        Object objV = cancellableContinuationImpl.v();
        if (objV == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return objV;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ java.lang.Object awaitRestoreResult(com.revenuecat.purchases.Purchases r4, kotlin.coroutines.Continuation r5) throws java.lang.Throwable {
        /*
            boolean r0 = r5 instanceof com.revenuecat.purchases.CoroutinesExtensionsCommonKt.C22751
            if (r0 == 0) goto L13
            r0 = r5
            com.revenuecat.purchases.CoroutinesExtensionsCommonKt$awaitRestoreResult$1 r0 = (com.revenuecat.purchases.CoroutinesExtensionsCommonKt.C22751) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.revenuecat.purchases.CoroutinesExtensionsCommonKt$awaitRestoreResult$1 r0 = new com.revenuecat.purchases.CoroutinesExtensionsCommonKt$awaitRestoreResult$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r4 = r0.L$0
            com.revenuecat.purchases.Purchases r4 = (com.revenuecat.purchases.Purchases) r4
            kotlin.ResultKt.b(r5)
            goto L65
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            kotlin.ResultKt.b(r5)
            r0.L$0 = r4
            r0.label = r3
            kotlinx.coroutines.CancellableContinuationImpl r5 = new kotlinx.coroutines.CancellableContinuationImpl
            kotlin.coroutines.Continuation r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.c(r0)
            r5.<init>(r2, r3)
            r5.C()
            com.revenuecat.purchases.CoroutinesExtensionsCommonKt$awaitRestoreResult$2$1 r2 = new com.revenuecat.purchases.CoroutinesExtensionsCommonKt$awaitRestoreResult$2$1
            r2.<init>()
            com.revenuecat.purchases.CoroutinesExtensionsCommonKt$awaitRestoreResult$2$2 r3 = new com.revenuecat.purchases.CoroutinesExtensionsCommonKt$awaitRestoreResult$2$2
            r3.<init>()
            com.revenuecat.purchases.ListenerConversionsCommonKt.restorePurchasesWith(r4, r2, r3)
            java.lang.Object r5 = r5.v()
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            if (r5 != r4) goto L62
            kotlin.coroutines.jvm.internal.DebugProbesKt.c(r0)
        L62:
            if (r5 != r1) goto L65
            return r1
        L65:
            kotlin.Result r5 = (kotlin.Result) r5
            java.lang.Object r4 = r5.j()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.CoroutinesExtensionsCommonKt.awaitRestoreResult(com.revenuecat.purchases.Purchases, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final Object awaitStorefrontCountryCode(Purchases purchases, Continuation<? super String> continuation) {
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.c(continuation), 1);
        cancellableContinuationImpl.C();
        ListenerConversionsCommonKt.getStorefrontCountryCodeWith(purchases, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.CoroutinesExtensionsCommonKt$awaitStorefrontCountryCode$2$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((PurchasesError) obj);
                return Unit.f139807a;
            }

            public final void invoke(PurchasesError it) {
                Intrinsics.checkNotNullParameter(it, "it");
                CancellableContinuationExtensionsKt.safeResumeWithException(cancellableContinuationImpl, new PurchasesException(it));
            }
        }, new Function1<String, Unit>() { // from class: com.revenuecat.purchases.CoroutinesExtensionsCommonKt$awaitStorefrontCountryCode$2$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return Unit.f139807a;
            }

            public final void invoke(String it) {
                Intrinsics.checkNotNullParameter(it, "it");
                CancellableContinuationExtensionsKt.safeResume(cancellableContinuationImpl, it);
            }
        });
        Object objV = cancellableContinuationImpl.v();
        if (objV == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return objV;
    }
}
