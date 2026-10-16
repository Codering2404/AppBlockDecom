package com.revenuecat.purchases.ui.revenuecatui;

import android.app.Activity;
import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.ui.revenuecatui.PurchaseLogic;
import com.revenuecat.purchases.ui.revenuecatui.helpers.CancellableContinuationExtensionsKt;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
@Metadata
public abstract class PurchaseLogicWithCallback implements PurchaseLogic {
    public static final int $stable = 0;

    @Override // com.revenuecat.purchases.ui.revenuecatui.PurchaseLogic, com.revenuecat.purchases.ui.revenuecatui.PaywallPurchaseLogic
    public Object performPurchase(Activity activity, PaywallPurchaseLogicParams paywallPurchaseLogicParams, Continuation<? super PurchaseLogicResult> continuation) {
        return PurchaseLogic.DefaultImpls.performPurchase(this, activity, paywallPurchaseLogicParams, continuation);
    }

    public abstract void performPurchaseWithCompletion(Activity activity, Package r2, Function1<? super PurchaseLogicResult, Unit> function1);

    @Override // com.revenuecat.purchases.ui.revenuecatui.PaywallPurchaseLogic
    public final Object performRestore(CustomerInfo customerInfo, Continuation<? super PurchaseLogicResult> continuation) {
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.c(continuation), 1);
        cancellableContinuationImpl.C();
        performRestoreWithCompletion(customerInfo, new Function1<PurchaseLogicResult, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.PurchaseLogicWithCallback$performRestore$2$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((PurchaseLogicResult) obj);
                return Unit.f139807a;
            }

            public final void invoke(PurchaseLogicResult result) {
                Intrinsics.checkNotNullParameter(result, "result");
                CancellableContinuationExtensionsKt.safeResume(cancellableContinuationImpl, result);
            }
        });
        Object objV = cancellableContinuationImpl.v();
        if (objV == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return objV;
    }

    public abstract void performRestoreWithCompletion(CustomerInfo customerInfo, Function1<? super PurchaseLogicResult, Unit> function1);

    @Override // com.revenuecat.purchases.ui.revenuecatui.PurchaseLogic
    public final Object performPurchase(Activity activity, Package r5, Continuation<? super PurchaseLogicResult> continuation) {
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.c(continuation), 1);
        cancellableContinuationImpl.C();
        performPurchaseWithCompletion(activity, r5, new Function1<PurchaseLogicResult, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.PurchaseLogicWithCallback$performPurchase$2$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((PurchaseLogicResult) obj);
                return Unit.f139807a;
            }

            public final void invoke(PurchaseLogicResult result) {
                Intrinsics.checkNotNullParameter(result, "result");
                CancellableContinuationExtensionsKt.safeResume(cancellableContinuationImpl, result);
            }
        });
        Object objV = cancellableContinuationImpl.v();
        if (objV == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return objV;
    }
}
