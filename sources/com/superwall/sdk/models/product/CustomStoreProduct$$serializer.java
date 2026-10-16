package com.superwall.sdk.models.product;

import com.revenuecat.purchases.common.responses.EntitlementsResponseJsonKeys;
import com.revenuecat.purchases.common.responses.ProductResponseJsonKeys;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

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
@Deprecated
public /* synthetic */ class CustomStoreProduct$$serializer implements GeneratedSerializer<CustomStoreProduct> {
    public static final CustomStoreProduct$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        CustomStoreProduct$$serializer customStoreProduct$$serializer = new CustomStoreProduct$$serializer();
        INSTANCE = customStoreProduct$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.superwall.sdk.models.product.CustomStoreProduct", customStoreProduct$$serializer, 2);
        pluginGeneratedSerialDescriptor.p(ProductResponseJsonKeys.STORE, true);
        pluginGeneratedSerialDescriptor.p(EntitlementsResponseJsonKeys.PRODUCT_IDENTIFIER, false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private CustomStoreProduct$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{StoreSerializer.INSTANCE, StringSerializer.f142891a};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final CustomStoreProduct deserialize(Decoder decoder) {
        Store store;
        String strM;
        int i3;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderB = decoder.b(serialDescriptor);
        if (compositeDecoderB.p()) {
            store = (Store) compositeDecoderB.y(serialDescriptor, 0, StoreSerializer.INSTANCE, null);
            strM = compositeDecoderB.m(serialDescriptor, 1);
            i3 = 3;
        } else {
            boolean z2 = true;
            int i4 = 0;
            store = null;
            String strM2 = null;
            while (z2) {
                int iO = compositeDecoderB.o(serialDescriptor);
                if (iO == -1) {
                    z2 = false;
                } else if (iO == 0) {
                    store = (Store) compositeDecoderB.y(serialDescriptor, 0, StoreSerializer.INSTANCE, store);
                    i4 |= 1;
                } else {
                    if (iO != 1) {
                        throw new UnknownFieldException(iO);
                    }
                    strM2 = compositeDecoderB.m(serialDescriptor, 1);
                    i4 |= 2;
                }
            }
            strM = strM2;
            i3 = i4;
        }
        compositeDecoderB.c(serialDescriptor);
        return new CustomStoreProduct(i3, store, strM, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, CustomStoreProduct value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderB = encoder.b(serialDescriptor);
        CustomStoreProduct.write$Self$superwall_release(value, compositeEncoderB, serialDescriptor);
        compositeEncoderB.c(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
