package com.revenuecat.purchases.ui.revenuecatui;

import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.models.StoreTransaction;
import com.revenuecat.purchases.ui.revenuecatui.utils.Resumable;
import kotlin.Metadata;
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
public interface PaywallListener {
    void onPurchaseCancelled();

    void onPurchaseCompleted(CustomerInfo customerInfo, StoreTransaction storeTransaction);

    void onPurchaseError(PurchasesError purchasesError);

    void onPurchasePackageInitiated(Package r12, Resumable resumable);

    void onPurchaseStarted(Package r12);

    void onRestoreCompleted(CustomerInfo customerInfo);

    void onRestoreError(PurchasesError purchasesError);

    void onRestoreInitiated(Resumable resumable);

    void onRestoreStarted();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class DefaultImpls {
        public static void onPurchaseCompleted(PaywallListener paywallListener, CustomerInfo customerInfo, StoreTransaction storeTransaction) {
            Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
            Intrinsics.checkNotNullParameter(storeTransaction, "storeTransaction");
        }

        public static void onPurchaseError(PaywallListener paywallListener, PurchasesError error) {
            Intrinsics.checkNotNullParameter(error, "error");
        }

        public static void onPurchasePackageInitiated(PaywallListener paywallListener, Package rcPackage, Resumable resume) {
            Intrinsics.checkNotNullParameter(rcPackage, "rcPackage");
            Intrinsics.checkNotNullParameter(resume, "resume");
            Resumable.DefaultImpls.invoke$default(resume, false, 1, null);
        }

        public static void onPurchaseStarted(PaywallListener paywallListener, Package rcPackage) {
            Intrinsics.checkNotNullParameter(rcPackage, "rcPackage");
        }

        public static void onRestoreCompleted(PaywallListener paywallListener, CustomerInfo customerInfo) {
            Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
        }

        public static void onRestoreError(PaywallListener paywallListener, PurchasesError error) {
            Intrinsics.checkNotNullParameter(error, "error");
        }

        public static void onRestoreInitiated(PaywallListener paywallListener, Resumable resume) {
            Intrinsics.checkNotNullParameter(resume, "resume");
            Resumable.DefaultImpls.invoke$default(resume, false, 1, null);
        }

        public static void onPurchaseCancelled(PaywallListener paywallListener) {
        }

        public static void onRestoreStarted(PaywallListener paywallListener) {
        }
    }
}
