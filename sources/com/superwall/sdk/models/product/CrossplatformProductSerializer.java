package com.superwall.sdk.models.product;

import com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker;
import com.revenuecat.purchases.common.responses.CustomerInfoResponseJsonKeys;
import com.superwall.sdk.models.entitlements.Entitlement;
import com.superwall.sdk.models.product.CrossplatformProduct;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonEncoder;
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
public final class CrossplatformProductSerializer implements KSerializer<CrossplatformProduct> {
    public static final CrossplatformProductSerializer INSTANCE = new CrossplatformProductSerializer();
    private static final SerialDescriptor descriptor;

    static {
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.superwall.sdk.models.product.CrossplatformProduct", null, 4);
        pluginGeneratedSerialDescriptor.p("sw_composite_product_id", false);
        pluginGeneratedSerialDescriptor.p("store_product", false);
        pluginGeneratedSerialDescriptor.p(CustomerInfoResponseJsonKeys.ENTITLEMENTS, false);
        pluginGeneratedSerialDescriptor.p("reference_name", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private CrossplatformProductSerializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01a2 A[Catch: SerializationException -> 0x00a9, TryCatch #0 {SerializationException -> 0x00a9, blocks: (B:28:0x0096, B:30:0x009e, B:32:0x00a4, B:39:0x00b2, B:40:0x00b6, B:42:0x00bb, B:45:0x00c5, B:46:0x00de, B:49:0x00e8, B:50:0x0101, B:55:0x0123, B:56:0x013c, B:59:0x0145, B:60:0x015e, B:63:0x0167, B:64:0x0180, B:67:0x0189, B:68:0x01a2, B:72:0x01a9, B:74:0x01b3, B:76:0x01b9, B:81:0x01c5, B:53:0x0109), top: B:100:0x0096, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01b3 A[Catch: SerializationException -> 0x00a9, TryCatch #0 {SerializationException -> 0x00a9, blocks: (B:28:0x0096, B:30:0x009e, B:32:0x00a4, B:39:0x00b2, B:40:0x00b6, B:42:0x00bb, B:45:0x00c5, B:46:0x00de, B:49:0x00e8, B:50:0x0101, B:55:0x0123, B:56:0x013c, B:59:0x0145, B:60:0x015e, B:63:0x0167, B:64:0x0180, B:67:0x0189, B:68:0x01a2, B:72:0x01a9, B:74:0x01b3, B:76:0x01b9, B:81:0x01c5, B:53:0x0109), top: B:100:0x0096, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01c3  */
    @Override // kotlinx.serialization.DeserializationStrategy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.superwall.sdk.models.product.CrossplatformProduct deserialize(kotlinx.serialization.encoding.Decoder r21) {
        /*
            Method dump skipped, instruction units count: 584
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.models.product.CrossplatformProductSerializer.deserialize(kotlinx.serialization.encoding.Decoder):com.superwall.sdk.models.product.CrossplatformProduct");
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, CrossplatformProduct value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        JsonEncoder jsonEncoder = encoder instanceof JsonEncoder ? (JsonEncoder) encoder : null;
        if (jsonEncoder == null) {
            throw new SerializationException("This class can be saved only by Json");
        }
        JsonObjectBuilder jsonObjectBuilder = new JsonObjectBuilder();
        jsonObjectBuilder.b("sw_composite_product_id", JsonElementKt.c(value.getCompositeId()));
        jsonObjectBuilder.b(DiagnosticsTracker.PRODUCT_ID_KEY, JsonElementKt.c(value.getFullProductId()));
        JsonEncoder jsonEncoder2 = (JsonEncoder) encoder;
        Json jsonD = jsonEncoder2.d();
        CrossplatformProduct.StoreProduct storeProduct = value.getStoreProduct();
        jsonD.a();
        jsonObjectBuilder.b("store_product", jsonD.e(CrossplatformProduct.StoreProduct.Companion.serializer(), storeProduct));
        Json jsonD2 = jsonEncoder2.d();
        List<Entitlement> entitlements = value.getEntitlements();
        jsonD2.a();
        jsonObjectBuilder.b(CustomerInfoResponseJsonKeys.ENTITLEMENTS, jsonD2.e(new ArrayListSerializer(Entitlement.Companion.serializer()), entitlements));
        jsonEncoder.A(jsonObjectBuilder.a());
    }
}
