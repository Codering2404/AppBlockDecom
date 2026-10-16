package com.superwall.sdk.store.abstractions.product.receipt;

import com.android.billingclient.api.ProductDetails;
import com.android.billingclient.api.Purchase;
import com.superwall.sdk.store.abstractions.product.RawStoreProduct;
import com.superwall.sdk.store.abstractions.product.StoreProduct;
import com.superwall.sdk.store.abstractions.product.SubscriptionPeriod;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
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
public final class PlayStorePurchaseAdapter implements EntitlementTransaction {
    public static final Companion Companion = new Companion(null);
    private final StoreProduct product;
    private final String productId;
    private final Purchase purchase;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final List<PlayStorePurchaseAdapter> fromPurchase(Purchase purchase, Map<String, StoreProduct> productsById) {
            String fullIdentifier;
            Intrinsics.checkNotNullParameter(purchase, "purchase");
            Intrinsics.checkNotNullParameter(productsById, "productsById");
            List listC = purchase.c();
            Intrinsics.checkNotNullExpressionValue(listC, "getProducts(...)");
            List<String> list = listC;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (String str : list) {
                StoreProduct storeProduct = productsById.get(str);
                if (storeProduct != null && (fullIdentifier = storeProduct.getFullIdentifier()) != null) {
                    str = fullIdentifier;
                }
                Intrinsics.checkNotNull(str);
                arrayList.add(new PlayStorePurchaseAdapter(purchase, storeProduct, str));
            }
            return arrayList;
        }

        private Companion() {
        }
    }

    public PlayStorePurchaseAdapter(Purchase purchase, StoreProduct storeProduct, String productId) {
        Intrinsics.checkNotNullParameter(purchase, "purchase");
        Intrinsics.checkNotNullParameter(productId, "productId");
        this.purchase = purchase;
        this.product = storeProduct;
        this.productId = productId;
    }

    private final Date calculateExpirationDate() {
        ProductDetails underlyingProductDetails;
        StoreProduct storeProduct = this.product;
        if (storeProduct == null) {
            return null;
        }
        RawStoreProduct rawStoreProduct = storeProduct.getRawStoreProduct();
        String strF = (rawStoreProduct == null || (underlyingProductDetails = rawStoreProduct.getUnderlyingProductDetails()) == null) ? null : underlyingProductDetails.f();
        if (strF != null) {
            int iHashCode = strF.hashCode();
            if (iHashCode != 3541555) {
                if (iHashCode == 100343516) {
                    strF.equals("inapp");
                }
            } else if (strF.equals("subs")) {
                RawStoreProduct rawStoreProduct2 = this.product.getRawStoreProduct();
                SubscriptionPeriod subscriptionPeriod = rawStoreProduct2 != null ? rawStoreProduct2.getSubscriptionPeriod() : null;
                if (subscriptionPeriod != null) {
                    return new Date(this.purchase.e() + subscriptionPeriod.getToMillis());
                }
            }
        }
        return null;
    }

    private final boolean calculateIsActive() {
        int iD = this.purchase.d();
        return iD != 0 && iD == 1;
    }

    @Override // com.superwall.sdk.store.abstractions.product.receipt.EntitlementTransaction
    public Date getExpirationDate() {
        return calculateExpirationDate();
    }

    @Override // com.superwall.sdk.store.abstractions.product.receipt.EntitlementTransaction
    public Date getOriginalPurchaseDate() {
        return new Date(this.purchase.e());
    }

    @Override // com.superwall.sdk.store.abstractions.product.receipt.EntitlementTransaction
    public String getProductId() {
        return this.productId;
    }

    @Override // com.superwall.sdk.store.abstractions.product.receipt.EntitlementTransaction
    public EntitlementTransactionType getProductType() {
        RawStoreProduct rawStoreProduct;
        ProductDetails underlyingProductDetails;
        StoreProduct storeProduct = this.product;
        String strF = (storeProduct == null || (rawStoreProduct = storeProduct.getRawStoreProduct()) == null || (underlyingProductDetails = rawStoreProduct.getUnderlyingProductDetails()) == null) ? null : underlyingProductDetails.f();
        if (strF != null) {
            int iHashCode = strF.hashCode();
            if (iHashCode != 3541555) {
                if (iHashCode == 100343516 && strF.equals("inapp")) {
                    return EntitlementTransactionType.NON_CONSUMABLE;
                }
            } else if (strF.equals("subs")) {
                return this.purchase.i() ? EntitlementTransactionType.AUTO_RENEWABLE : EntitlementTransactionType.NON_RENEWABLE;
            }
        }
        return EntitlementTransactionType.CONSUMABLE;
    }

    @Override // com.superwall.sdk.store.abstractions.product.receipt.EntitlementTransaction
    public Date getPurchaseDate() {
        return new Date(this.purchase.e());
    }

    @Override // com.superwall.sdk.store.abstractions.product.receipt.EntitlementTransaction
    public Date getRenewedAt() {
        return null;
    }

    @Override // com.superwall.sdk.store.abstractions.product.receipt.EntitlementTransaction
    public String getTransactionId() {
        String strA = this.purchase.a();
        if (strA != null) {
            return strA;
        }
        String strF = this.purchase.f();
        Intrinsics.checkNotNullExpressionValue(strF, "getPurchaseToken(...)");
        return strF;
    }

    @Override // com.superwall.sdk.store.abstractions.product.receipt.EntitlementTransaction
    public boolean getWillRenew() {
        return this.purchase.i();
    }

    @Override // com.superwall.sdk.store.abstractions.product.receipt.EntitlementTransaction
    public boolean isActive() {
        return calculateIsActive();
    }

    @Override // com.superwall.sdk.store.abstractions.product.receipt.EntitlementTransaction
    public boolean isInBillingRetryPeriod() {
        return false;
    }

    @Override // com.superwall.sdk.store.abstractions.product.receipt.EntitlementTransaction
    public boolean isInGracePeriod() {
        return this.purchase.d() == 2 && this.purchase.i();
    }

    @Override // com.superwall.sdk.store.abstractions.product.receipt.EntitlementTransaction
    public boolean isRevoked() {
        return this.purchase.d() == 2 || this.purchase.d() == 0;
    }
}
