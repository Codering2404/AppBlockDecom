package com.superwall.sdk.models.product;

import com.revenuecat.purchases.common.responses.EntitlementsResponseJsonKeys;
import com.revenuecat.purchases.common.responses.ProductResponseJsonKeys;
import com.superwall.sdk.models.product.CrossplatformProduct;
import com.superwall.sdk.models.product.Offer;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonEncoder;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonObjectBuilder;

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
@Metadata
public final class PlayStoreSerializer implements KSerializer<CrossplatformProduct.StoreProduct.PlayStore> {
    public static final PlayStoreSerializer INSTANCE = new PlayStoreSerializer();
    private static final SerialDescriptor descriptor = SerialDescriptorsKt.e("PlayStore", new SerialDescriptor[0], null, 4, null);

    private PlayStoreSerializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    /* JADX WARN: Removed duplicated region for block: B:68:0x00f0  */
    @Override // kotlinx.serialization.DeserializationStrategy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.superwall.sdk.models.product.CrossplatformProduct.StoreProduct.PlayStore deserialize(kotlinx.serialization.encoding.Decoder r8) {
        /*
            Method dump skipped, instruction units count: 264
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.models.product.PlayStoreSerializer.deserialize(kotlinx.serialization.encoding.Decoder):com.superwall.sdk.models.product.CrossplatformProduct$StoreProduct$PlayStore");
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, CrossplatformProduct.StoreProduct.PlayStore value) {
        JsonObject jsonObject;
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        JsonEncoder jsonEncoder = encoder instanceof JsonEncoder ? (JsonEncoder) encoder : null;
        if (jsonEncoder == null) {
            throw new SerializationException("This class can be saved only by Json");
        }
        JsonObjectBuilder jsonObjectBuilder = new JsonObjectBuilder();
        jsonObjectBuilder.b(ProductResponseJsonKeys.STORE, JsonElementKt.c("PLAY_STORE"));
        jsonObjectBuilder.b(EntitlementsResponseJsonKeys.PRODUCT_IDENTIFIER, JsonElementKt.c(value.getProductIdentifier()));
        jsonObjectBuilder.b("base_plan_identifier", JsonElementKt.c(value.getBasePlanIdentifier()));
        Offer offer = value.getOffer();
        if (offer instanceof Offer.Automatic) {
            jsonObject = new JsonObject(MapsKt.mapOf(TuplesKt.a("type", JsonElementKt.c(((Offer.Automatic) offer).getType()))));
        } else if (offer instanceof Offer.NoOffer) {
            jsonObject = new JsonObject(MapsKt.mapOf(TuplesKt.a("type", JsonElementKt.c(Offer.NoOffer.TYPE))));
        } else {
            if (!(offer instanceof Offer.Specified)) {
                throw new NoWhenBranchMatchedException();
            }
            Offer.Specified specified = (Offer.Specified) offer;
            jsonObject = new JsonObject(MapsKt.mapOf(TuplesKt.a("type", JsonElementKt.c(specified.getType())), TuplesKt.a("offer_identifier", JsonElementKt.c(specified.getOfferIdentifier()))));
        }
        jsonObjectBuilder.b("offer", jsonObject);
        jsonEncoder.A(jsonObjectBuilder.a());
    }
}
