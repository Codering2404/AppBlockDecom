package com.revenuecat.purchases.customercenter;

import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.models.StoreTransaction;
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
/* JADX INFO: loaded from: classes6.dex */
@Metadata
public interface CustomerCenterListener {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class DefaultImpls {
        @Deprecated
        public static void onCustomActionSelected(CustomerCenterListener customerCenterListener, String actionIdentifier, String str) {
            Intrinsics.checkNotNullParameter(actionIdentifier, "actionIdentifier");
            CustomerCenterListener.super.onCustomActionSelected(actionIdentifier, str);
        }

        @Deprecated
        public static void onFeedbackSurveyCompleted(CustomerCenterListener customerCenterListener, String feedbackSurveyOptionId) {
            Intrinsics.checkNotNullParameter(feedbackSurveyOptionId, "feedbackSurveyOptionId");
            CustomerCenterListener.super.onFeedbackSurveyCompleted(feedbackSurveyOptionId);
        }

        @Deprecated
        public static void onManagementOptionSelected(CustomerCenterListener customerCenterListener, CustomerCenterManagementOption action) {
            Intrinsics.checkNotNullParameter(action, "action");
            CustomerCenterListener.super.onManagementOptionSelected(action);
        }

        @Deprecated
        public static void onPromotionalOfferSucceeded(CustomerCenterListener customerCenterListener, CustomerInfo customerInfo, StoreTransaction transaction) {
            Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
            Intrinsics.checkNotNullParameter(transaction, "transaction");
            CustomerCenterListener.super.onPromotionalOfferSucceeded(customerInfo, transaction);
        }

        @Deprecated
        public static void onRestoreCompleted(CustomerCenterListener customerCenterListener, CustomerInfo customerInfo) {
            Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
            CustomerCenterListener.super.onRestoreCompleted(customerInfo);
        }

        @Deprecated
        public static void onRestoreFailed(CustomerCenterListener customerCenterListener, PurchasesError error) {
            Intrinsics.checkNotNullParameter(error, "error");
            CustomerCenterListener.super.onRestoreFailed(error);
        }

        @Deprecated
        public static void onRestoreInitiated(CustomerCenterListener customerCenterListener, Resumable resume) {
            Intrinsics.checkNotNullParameter(resume, "resume");
            CustomerCenterListener.super.onRestoreInitiated(resume);
        }

        @Deprecated
        public static void onRestoreStarted(CustomerCenterListener customerCenterListener) {
            CustomerCenterListener.super.onRestoreStarted();
        }

        @Deprecated
        public static void onShowingManageSubscriptions(CustomerCenterListener customerCenterListener) {
            CustomerCenterListener.super.onShowingManageSubscriptions();
        }
    }

    default void onCustomActionSelected(String actionIdentifier, String str) {
        Intrinsics.checkNotNullParameter(actionIdentifier, "actionIdentifier");
    }

    default void onFeedbackSurveyCompleted(String feedbackSurveyOptionId) {
        Intrinsics.checkNotNullParameter(feedbackSurveyOptionId, "feedbackSurveyOptionId");
    }

    default void onManagementOptionSelected(CustomerCenterManagementOption action) {
        Intrinsics.checkNotNullParameter(action, "action");
    }

    default void onPromotionalOfferSucceeded(CustomerInfo customerInfo, StoreTransaction transaction) {
        Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
        Intrinsics.checkNotNullParameter(transaction, "transaction");
    }

    default void onRestoreCompleted(CustomerInfo customerInfo) {
        Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
    }

    default void onRestoreFailed(PurchasesError error) {
        Intrinsics.checkNotNullParameter(error, "error");
    }

    default void onRestoreInitiated(Resumable resume) {
        Intrinsics.checkNotNullParameter(resume, "resume");
        Resumable.invoke$default(resume, false, 1, null);
    }

    default void onRestoreStarted() {
    }

    default void onShowingManageSubscriptions() {
    }
}
