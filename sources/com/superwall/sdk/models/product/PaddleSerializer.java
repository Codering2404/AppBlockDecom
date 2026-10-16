package com.superwall.sdk.models.product;

import com.revenuecat.purchases.common.responses.EntitlementsResponseJsonKeys;
import com.revenuecat.purchases.common.responses.ProductResponseJsonKeys;
import com.superwall.sdk.models.product.CrossplatformProduct;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.json.JsonDecoder;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonEncoder;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonObjectBuilder;
import kotlinx.serialization.json.JsonPrimitive;

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
public final class PaddleSerializer implements KSerializer<CrossplatformProduct.StoreProduct.Paddle> {
    public static final PaddleSerializer INSTANCE = new PaddleSerializer();
    private static final SerialDescriptor descriptor = SerialDescriptorsKt.e("Paddle", new SerialDescriptor[0], null, 4, null);

    private PaddleSerializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public CrossplatformProduct.StoreProduct.Paddle deserialize(Decoder decoder) {
        JsonPrimitive jsonPrimitiveP;
        String strA;
        JsonPrimitive jsonPrimitiveP2;
        String strA2;
        JsonPrimitive jsonPrimitiveP3;
        String strA3;
        Integer numU;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        JsonDecoder jsonDecoder = decoder instanceof JsonDecoder ? (JsonDecoder) decoder : null;
        if (jsonDecoder == null) {
            throw new SerializationException("This class can be loaded only by Json");
        }
        JsonElement jsonElementG = jsonDecoder.g();
        Intrinsics.checkNotNull(jsonElementG, "null cannot be cast to non-null type kotlinx.serialization.json.JsonObject");
        JsonObject jsonObject = (JsonObject) jsonElementG;
        JsonElement jsonElement = (JsonElement) jsonObject.get("environment");
        if (jsonElement == null || (jsonPrimitiveP = JsonElementKt.p(jsonElement)) == null || (strA = jsonPrimitiveP.a()) == null) {
            throw new SerializationException("environment is missing");
        }
        JsonElement jsonElement2 = (JsonElement) jsonObject.get(EntitlementsResponseJsonKeys.PRODUCT_IDENTIFIER);
        if (jsonElement2 == null || (jsonPrimitiveP2 = JsonElementKt.p(jsonElement2)) == null || (strA2 = jsonPrimitiveP2.a()) == null) {
            throw new SerializationException("product_identifier is missing");
        }
        JsonElement jsonElement3 = (JsonElement) jsonObject.get("trial_days");
        int iIntValue = (jsonElement3 == null || (jsonPrimitiveP3 = JsonElementKt.p(jsonElement3)) == null || (strA3 = jsonPrimitiveP3.a()) == null || (numU = StringsKt.u(strA3)) == null) ? 0 : numU.intValue();
        Object obj = jsonObject.get("meta");
        JsonObject jsonObject2 = obj instanceof JsonObject ? (JsonObject) obj : null;
        if (jsonObject2 == null) {
            jsonObject2 = new JsonObject(MapsKt.emptyMap());
        }
        return new CrossplatformProduct.StoreProduct.Paddle(strA, strA2, iIntValue, jsonObject2);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, CrossplatformProduct.StoreProduct.Paddle value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        JsonEncoder jsonEncoder = encoder instanceof JsonEncoder ? (JsonEncoder) encoder : null;
        if (jsonEncoder == null) {
            throw new SerializationException("This class can be saved only by Json");
        }
        JsonObjectBuilder jsonObjectBuilder = new JsonObjectBuilder();
        jsonObjectBuilder.b(ProductResponseJsonKeys.STORE, JsonElementKt.c("PADDLE"));
        jsonObjectBuilder.b("environment", JsonElementKt.c(value.getEnvironment()));
        jsonObjectBuilder.b(EntitlementsResponseJsonKeys.PRODUCT_IDENTIFIER, JsonElementKt.c(value.getProductIdentifier()));
        jsonObjectBuilder.b("trial_days", JsonElementKt.b(Integer.valueOf(value.getTrialDays())));
        jsonObjectBuilder.b("meta", value.getMeta());
        jsonEncoder.A(jsonObjectBuilder.a());
    }
}
