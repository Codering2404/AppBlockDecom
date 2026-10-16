package cz.mobilesoft.coreblock.rest.request;

import com.google.gson.annotations.SerializedName;
import cz.mobilesoft.coreblock.storage.room.entity.core.PurchasedOfferEntity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
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
public final class PurchasedOfferListRequest {

    @SerializedName("purchases")
    private final List<PurchasedOfferRequest> purchases;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PurchasedOfferListRequest fromEntities(Collection<PurchasedOfferEntity> entities) {
            Intrinsics.checkNotNullParameter(entities, "entities");
            Collection<PurchasedOfferEntity> collection = entities;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(collection, 10));
            Iterator<T> it = collection.iterator();
            while (it.hasNext()) {
                arrayList.add(PurchasedOfferRequest.Companion.fromEntity((PurchasedOfferEntity) it.next()));
            }
            return new PurchasedOfferListRequest(arrayList);
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class PurchasedOfferRequest {
        public static final int $stable = 0;
        public static final Companion Companion = new Companion(null);

        @SerializedName("offerTags")
        private final String offerTags;

        @SerializedName("productId")
        private final String productId;

        @SerializedName("purchaseDate")
        private final String purchaseDate;

        @SerializedName("purchaseToken")
        private final String purchaseToken;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final PurchasedOfferRequest fromEntity(PurchasedOfferEntity entity) {
                Intrinsics.checkNotNullParameter(entity, "entity");
                return new PurchasedOfferRequest(entity.d(), entity.b(), entity.a(), entity.c());
            }

            private Companion() {
            }
        }

        public PurchasedOfferRequest(String purchaseToken, String productId, String offerTags, String purchaseDate) {
            Intrinsics.checkNotNullParameter(purchaseToken, "purchaseToken");
            Intrinsics.checkNotNullParameter(productId, "productId");
            Intrinsics.checkNotNullParameter(offerTags, "offerTags");
            Intrinsics.checkNotNullParameter(purchaseDate, "purchaseDate");
            this.purchaseToken = purchaseToken;
            this.productId = productId;
            this.offerTags = offerTags;
            this.purchaseDate = purchaseDate;
        }

        public static /* synthetic */ PurchasedOfferRequest copy$default(PurchasedOfferRequest purchasedOfferRequest, String str, String str2, String str3, String str4, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = purchasedOfferRequest.purchaseToken;
            }
            if ((i3 & 2) != 0) {
                str2 = purchasedOfferRequest.productId;
            }
            if ((i3 & 4) != 0) {
                str3 = purchasedOfferRequest.offerTags;
            }
            if ((i3 & 8) != 0) {
                str4 = purchasedOfferRequest.purchaseDate;
            }
            return purchasedOfferRequest.copy(str, str2, str3, str4);
        }

        public final String component1() {
            return this.purchaseToken;
        }

        public final String component2() {
            return this.productId;
        }

        public final String component3() {
            return this.offerTags;
        }

        public final String component4() {
            return this.purchaseDate;
        }

        public final PurchasedOfferRequest copy(String purchaseToken, String productId, String offerTags, String purchaseDate) {
            Intrinsics.checkNotNullParameter(purchaseToken, "purchaseToken");
            Intrinsics.checkNotNullParameter(productId, "productId");
            Intrinsics.checkNotNullParameter(offerTags, "offerTags");
            Intrinsics.checkNotNullParameter(purchaseDate, "purchaseDate");
            return new PurchasedOfferRequest(purchaseToken, productId, offerTags, purchaseDate);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PurchasedOfferRequest)) {
                return false;
            }
            PurchasedOfferRequest purchasedOfferRequest = (PurchasedOfferRequest) obj;
            return Intrinsics.areEqual(this.purchaseToken, purchasedOfferRequest.purchaseToken) && Intrinsics.areEqual(this.productId, purchasedOfferRequest.productId) && Intrinsics.areEqual(this.offerTags, purchasedOfferRequest.offerTags) && Intrinsics.areEqual(this.purchaseDate, purchasedOfferRequest.purchaseDate);
        }

        public final String getOfferTags() {
            return this.offerTags;
        }

        public final String getProductId() {
            return this.productId;
        }

        public final String getPurchaseDate() {
            return this.purchaseDate;
        }

        public final String getPurchaseToken() {
            return this.purchaseToken;
        }

        public int hashCode() {
            return (((((this.purchaseToken.hashCode() * 31) + this.productId.hashCode()) * 31) + this.offerTags.hashCode()) * 31) + this.purchaseDate.hashCode();
        }

        public String toString() {
            return "PurchasedOfferRequest(purchaseToken=" + this.purchaseToken + ", productId=" + this.productId + ", offerTags=" + this.offerTags + ", purchaseDate=" + this.purchaseDate + ")";
        }
    }

    public PurchasedOfferListRequest(List<PurchasedOfferRequest> purchases) {
        Intrinsics.checkNotNullParameter(purchases, "purchases");
        this.purchases = purchases;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PurchasedOfferListRequest copy$default(PurchasedOfferListRequest purchasedOfferListRequest, List list, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            list = purchasedOfferListRequest.purchases;
        }
        return purchasedOfferListRequest.copy(list);
    }

    public final List<PurchasedOfferRequest> component1() {
        return this.purchases;
    }

    public final PurchasedOfferListRequest copy(List<PurchasedOfferRequest> purchases) {
        Intrinsics.checkNotNullParameter(purchases, "purchases");
        return new PurchasedOfferListRequest(purchases);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof PurchasedOfferListRequest) && Intrinsics.areEqual(this.purchases, ((PurchasedOfferListRequest) obj).purchases);
    }

    public final List<PurchasedOfferRequest> getPurchases() {
        return this.purchases;
    }

    public int hashCode() {
        return this.purchases.hashCode();
    }

    public String toString() {
        return "PurchasedOfferListRequest(purchases=" + this.purchases + ")";
    }
}
