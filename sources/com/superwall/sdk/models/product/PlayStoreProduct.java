package com.superwall.sdk.models.product;

import com.revenuecat.purchases.common.Constants;
import com.superwall.sdk.models.product.Offer;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;

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
@Serializable(with = PlayStoreProductSerializer.class)
public final class PlayStoreProduct {
    public static final Companion Companion = new Companion(null);
    private final String basePlanIdentifier;
    private final Offer offer;
    private final String productIdentifier;
    private final Store store;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<PlayStoreProduct> serializer() {
            return PlayStoreProductSerializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public PlayStoreProduct(Store store, String productIdentifier, String basePlanIdentifier, Offer offer) {
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(productIdentifier, "productIdentifier");
        Intrinsics.checkNotNullParameter(basePlanIdentifier, "basePlanIdentifier");
        Intrinsics.checkNotNullParameter(offer, "offer");
        this.store = store;
        this.productIdentifier = productIdentifier;
        this.basePlanIdentifier = basePlanIdentifier;
        this.offer = offer;
    }

    public static /* synthetic */ PlayStoreProduct copy$default(PlayStoreProduct playStoreProduct, Store store, String str, String str2, Offer offer, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            store = playStoreProduct.store;
        }
        if ((i3 & 2) != 0) {
            str = playStoreProduct.productIdentifier;
        }
        if ((i3 & 4) != 0) {
            str2 = playStoreProduct.basePlanIdentifier;
        }
        if ((i3 & 8) != 0) {
            offer = playStoreProduct.offer;
        }
        return playStoreProduct.copy(store, str, str2, offer);
    }

    public final Store component1() {
        return this.store;
    }

    public final String component2() {
        return this.productIdentifier;
    }

    public final String component3() {
        return this.basePlanIdentifier;
    }

    public final Offer component4() {
        return this.offer;
    }

    public final PlayStoreProduct copy(Store store, String productIdentifier, String basePlanIdentifier, Offer offer) {
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(productIdentifier, "productIdentifier");
        Intrinsics.checkNotNullParameter(basePlanIdentifier, "basePlanIdentifier");
        Intrinsics.checkNotNullParameter(offer, "offer");
        return new PlayStoreProduct(store, productIdentifier, basePlanIdentifier, offer);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlayStoreProduct)) {
            return false;
        }
        PlayStoreProduct playStoreProduct = (PlayStoreProduct) obj;
        return this.store == playStoreProduct.store && Intrinsics.areEqual(this.productIdentifier, playStoreProduct.productIdentifier) && Intrinsics.areEqual(this.basePlanIdentifier, playStoreProduct.basePlanIdentifier) && Intrinsics.areEqual(this.offer, playStoreProduct.offer);
    }

    public final String getBasePlanIdentifier() {
        return this.basePlanIdentifier;
    }

    public final String getFullIdentifier() {
        if (this.basePlanIdentifier.length() == 0) {
            return this.productIdentifier;
        }
        Offer offer = this.offer;
        if (offer instanceof Offer.Automatic) {
            return this.productIdentifier + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + this.basePlanIdentifier + ":sw-auto";
        }
        if (offer instanceof Offer.NoOffer) {
            return this.productIdentifier + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + this.basePlanIdentifier + ":sw-none";
        }
        if (!(offer instanceof Offer.Specified)) {
            return this.productIdentifier + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + this.basePlanIdentifier;
        }
        return this.productIdentifier + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + this.basePlanIdentifier + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + ((Offer.Specified) offer).getOfferIdentifier();
    }

    public final Offer getOffer() {
        return this.offer;
    }

    public final String getProductIdentifier() {
        return this.productIdentifier;
    }

    public final Store getStore() {
        return this.store;
    }

    public int hashCode() {
        return (((((this.store.hashCode() * 31) + this.productIdentifier.hashCode()) * 31) + this.basePlanIdentifier.hashCode()) * 31) + this.offer.hashCode();
    }

    public String toString() {
        return "PlayStoreProduct(store=" + this.store + ", productIdentifier=" + this.productIdentifier + ", basePlanIdentifier=" + this.basePlanIdentifier + ", offer=" + this.offer + ")";
    }

    public /* synthetic */ PlayStoreProduct(Store store, String str, String str2, Offer offer, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? Store.PLAY_STORE : store, str, str2, offer);
    }

    @SerialName
    public static /* synthetic */ void getBasePlanIdentifier$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getOffer$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getProductIdentifier$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getStore$annotations() {
    }
}
