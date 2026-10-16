package com.revenuecat.purchases.google;

import com.android.billingclient.api.BillingFlowParams;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.ReplaceProductInfo;
import com.revenuecat.purchases.models.StoreReplacementMode;
import com.revenuecat.purchases.models.StoreReplacementModeConversionsKt;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata
public final class BillingFlowParamsExtensionsKt {
    public static final void setUpgradeInfo(BillingFlowParams.Builder builder, ReplaceProductInfo replaceProductInfo) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(replaceProductInfo, "replaceProductInfo");
        BillingFlowParams.SubscriptionUpdateParams.Builder builderA = BillingFlowParams.SubscriptionUpdateParams.a();
        builderA.b(replaceProductInfo.getOldPurchase().getPurchaseToken());
        StoreReplacementMode storeReplacementModeOrNull = StoreReplacementModeConversionsKt.toStoreReplacementModeOrNull(replaceProductInfo.getReplacementMode());
        if (storeReplacementModeOrNull != null) {
            builderA.d(StoreReplacementModeConversionsKt.toPlayBillingClientMode(storeReplacementModeOrNull));
        } else if (replaceProductInfo.getReplacementMode() != null) {
            LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Got unidentified replacement mode", null);
        }
        Intrinsics.checkNotNullExpressionValue(builderA, "newBuilder().apply {\n   …t mode\" }\n        }\n    }");
        builder.f(builderA.a());
    }
}
