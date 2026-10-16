package com.superwall.sdk.store.testmode;

import android.app.Activity;
import com.superwall.sdk.misc.ActivityProvider;
import com.superwall.sdk.misc.CurrentActivityTracker;
import com.superwall.sdk.models.entitlements.Entitlement;
import com.superwall.sdk.store.testmode.models.SuperwallEntitlementRef;
import com.superwall.sdk.store.testmode.models.SuperwallProduct;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
public final class TestModeTransactionHandler {
    private final ActivityProvider activityProvider;
    private final CurrentActivityTracker activityTracker;
    private final TestMode testMode;

    /* JADX INFO: renamed from: com.superwall.sdk.store.testmode.TestModeTransactionHandler$handlePurchase$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.store.testmode.TestModeTransactionHandler", f = "TestModeTransactionHandler.kt", l = {52}, m = "handlePurchase")
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
            return TestModeTransactionHandler.this.handlePurchase(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.store.testmode.TestModeTransactionHandler$handleRestore$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.store.testmode.TestModeTransactionHandler", f = "TestModeTransactionHandler.kt", l = {92}, m = "handleRestore")
    static final class C29321 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C29321(Continuation<? super C29321> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TestModeTransactionHandler.this.handleRestore(this);
        }
    }

    public TestModeTransactionHandler(TestMode testMode, ActivityProvider activityProvider, CurrentActivityTracker currentActivityTracker) {
        Intrinsics.checkNotNullParameter(testMode, "testMode");
        Intrinsics.checkNotNullParameter(activityProvider, "activityProvider");
        this.testMode = testMode;
        this.activityProvider = activityProvider;
        this.activityTracker = currentActivityTracker;
    }

    private final Activity getForegroundActivity() {
        Activity currentActivity;
        CurrentActivityTracker currentActivityTracker = this.activityTracker;
        return (currentActivityTracker == null || (currentActivity = currentActivityTracker.getCurrentActivity()) == null) ? this.activityProvider.getCurrentActivity() : currentActivity;
    }

    public final Set<Entitlement> entitlementsForProduct(String productId) {
        Intrinsics.checkNotNullParameter(productId, "productId");
        SuperwallProduct superwallProductFindSuperwallProductForId = findSuperwallProductForId(productId);
        if (superwallProductFindSuperwallProductForId == null) {
            return SetsKt.emptySet();
        }
        List<SuperwallEntitlementRef> entitlements = superwallProductFindSuperwallProductForId.getEntitlements();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(entitlements, 10));
        Iterator<T> it = entitlements.iterator();
        while (it.hasNext()) {
            arrayList.add(new Entitlement(((SuperwallEntitlementRef) it.next()).getIdentifier()));
        }
        return CollectionsKt.toSet(arrayList);
    }

    public final SuperwallProduct findSuperwallProductForId(String productId) {
        Object next;
        Intrinsics.checkNotNullParameter(productId, "productId");
        Iterator<T> it = this.testMode.getProducts().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (Intrinsics.areEqual(((SuperwallProduct) next).getIdentifier(), productId)) {
                break;
            }
        }
        return (SuperwallProduct) next;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object handlePurchase(com.superwall.sdk.store.abstractions.product.StoreProductType r22, com.superwall.sdk.store.transactions.TransactionManager.PurchaseSource r23, kotlin.coroutines.Continuation<? super com.superwall.sdk.delegate.PurchaseResult> r24) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 317
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.store.testmode.TestModeTransactionHandler.handlePurchase(com.superwall.sdk.store.abstractions.product.StoreProductType, com.superwall.sdk.store.transactions.TransactionManager$PurchaseSource, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object handleRestore(kotlin.coroutines.Continuation<? super com.superwall.sdk.delegate.RestorationResult> r13) throws java.lang.Throwable {
        /*
            r12 = this;
            boolean r0 = r13 instanceof com.superwall.sdk.store.testmode.TestModeTransactionHandler.C29321
            if (r0 == 0) goto L13
            r0 = r13
            com.superwall.sdk.store.testmode.TestModeTransactionHandler$handleRestore$1 r0 = (com.superwall.sdk.store.testmode.TestModeTransactionHandler.C29321) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.superwall.sdk.store.testmode.TestModeTransactionHandler$handleRestore$1 r0 = new com.superwall.sdk.store.testmode.TestModeTransactionHandler$handleRestore$1
            r0.<init>(r13)
        L18:
            java.lang.Object r13 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r0 = r0.L$0
            com.superwall.sdk.store.testmode.TestModeTransactionHandler r0 = (com.superwall.sdk.store.testmode.TestModeTransactionHandler) r0
            kotlin.ResultKt.b(r13)
            goto L93
        L2d:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L35:
            kotlin.ResultKt.b(r13)
            android.app.Activity r13 = r12.getForegroundActivity()
            if (r13 != 0) goto L4b
            com.superwall.sdk.delegate.RestorationResult$Failed r13 = new com.superwall.sdk.delegate.RestorationResult$Failed
            java.lang.Throwable r0 = new java.lang.Throwable
            java.lang.String r1 = "Activity not found"
            r0.<init>(r1)
            r13.<init>(r0)
            return r13
        L4b:
            com.superwall.sdk.store.testmode.TestMode r2 = r12.testMode
            java.util.Set r2 = r2.allEntitlements()
            com.superwall.sdk.logger.Logger r4 = com.superwall.sdk.logger.Logger.INSTANCE
            com.superwall.sdk.logger.LogLevel r5 = com.superwall.sdk.logger.LogLevel.debug
            com.superwall.sdk.logger.LogScope r6 = com.superwall.sdk.logger.LogScope.paywallTransactions
            int r7 = r2.size()
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "Test mode: showing restore drawer with "
            r8.append(r9)
            r8.append(r7)
            java.lang.String r7 = " entitlements"
            r8.append(r7)
            java.lang.String r7 = r8.toString()
            r10 = 24
            r11 = 0
            r8 = 0
            r9 = 0
            com.superwall.sdk.logger.Logger.debug$default(r4, r5, r6, r7, r8, r9, r10, r11)
            com.superwall.sdk.store.testmode.ui.TestModeRestoreDrawer r4 = com.superwall.sdk.store.testmode.ui.TestModeRestoreDrawer.INSTANCE
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.List r2 = kotlin.collections.CollectionsKt.toList(r2)
            com.superwall.sdk.store.testmode.TestMode r5 = r12.testMode
            java.util.List r5 = r5.getTestEntitlementSelections()
            r0.L$0 = r12
            r0.label = r3
            java.lang.Object r13 = r4.show(r13, r2, r5, r0)
            if (r13 != r1) goto L92
            return r1
        L92:
            r0 = r12
        L93:
            com.superwall.sdk.store.testmode.ui.RestoreSimulationResult r13 = (com.superwall.sdk.store.testmode.ui.RestoreSimulationResult) r13
            boolean r1 = r13 instanceof com.superwall.sdk.store.testmode.ui.RestoreSimulationResult.Restored
            if (r1 == 0) goto Lb5
            com.superwall.sdk.store.testmode.TestMode r1 = r0.testMode
            com.superwall.sdk.store.testmode.ui.RestoreSimulationResult$Restored r13 = (com.superwall.sdk.store.testmode.ui.RestoreSimulationResult.Restored) r13
            java.util.List r13 = r13.getSelectedEntitlements()
            r1.setEntitlements(r13)
            com.superwall.sdk.store.testmode.TestMode r13 = r0.testMode
            com.superwall.sdk.models.entitlements.SubscriptionStatus r13 = r13.buildSubscriptionStatus()
            com.superwall.sdk.store.testmode.TestMode r0 = r0.testMode
            r0.setOverriddenSubscriptionStatus(r13)
            com.superwall.sdk.delegate.RestorationResult$Restored r13 = new com.superwall.sdk.delegate.RestorationResult$Restored
            r13.<init>()
            return r13
        Lb5:
            boolean r13 = r13 instanceof com.superwall.sdk.store.testmode.ui.RestoreSimulationResult.Cancelled
            if (r13 == 0) goto Lc0
            com.superwall.sdk.delegate.RestorationResult$Failed r13 = new com.superwall.sdk.delegate.RestorationResult$Failed
            r0 = 0
            r13.<init>(r0)
            return r13
        Lc0:
            kotlin.NoWhenBranchMatchedException r13 = new kotlin.NoWhenBranchMatchedException
            r13.<init>()
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.store.testmode.TestModeTransactionHandler.handleRestore(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public /* synthetic */ TestModeTransactionHandler(TestMode testMode, ActivityProvider activityProvider, CurrentActivityTracker currentActivityTracker, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(testMode, activityProvider, (i3 & 4) != 0 ? null : currentActivityTracker);
    }
}
