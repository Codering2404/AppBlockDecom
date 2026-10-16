package cz.mobilesoft.coreblock.usecase;

import com.revenuecat.purchases.EntitlementInfo;
import com.revenuecat.purchases.PeriodType;
import com.revenuecat.purchases.ProductType;
import com.revenuecat.purchases.Store;
import com.revenuecat.purchases.models.StoreProduct;
import cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt;
import java.util.Date;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class MakeRevenueCatPurchaseUseCaseKt {
    public static final boolean a(EntitlementInfo entitlementInfo, StoreProduct purchasedProduct) {
        Date expirationDate;
        Intrinsics.checkNotNullParameter(entitlementInfo, "<this>");
        Intrinsics.checkNotNullParameter(purchasedProduct, "purchasedProduct");
        if (purchasedProduct.getType() != ProductType.SUBS || (expirationDate = entitlementInfo.getExpirationDate()) == null) {
            return false;
        }
        if (TimeHelperExt.f128663a.y(expirationDate.getTime()) && entitlementInfo.isActive() && entitlementInfo.getStore() == Store.PLAY_STORE) {
            return entitlementInfo.getPeriodType() == PeriodType.NORMAL || Intrinsics.areEqual(purchasedProduct.getPurchasingData().getProductId(), entitlementInfo.getProductIdentifier());
        }
        return false;
    }
}
