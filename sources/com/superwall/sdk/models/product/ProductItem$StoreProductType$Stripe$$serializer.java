package com.superwall.sdk.models.product;

import com.applovin.sdk.AppLovinEventTypes;
import com.superwall.sdk.models.product.ProductItem;
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
public /* synthetic */ class ProductItem$StoreProductType$Stripe$$serializer implements GeneratedSerializer<ProductItem.StoreProductType.Stripe> {
    public static final ProductItem$StoreProductType$Stripe$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        ProductItem$StoreProductType$Stripe$$serializer productItem$StoreProductType$Stripe$$serializer = new ProductItem$StoreProductType$Stripe$$serializer();
        INSTANCE = productItem$StoreProductType$Stripe$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.superwall.sdk.models.product.ProductItem.StoreProductType.Stripe", productItem$StoreProductType$Stripe$$serializer, 1);
        pluginGeneratedSerialDescriptor.p(AppLovinEventTypes.USER_VIEWED_PRODUCT, false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private ProductItem$StoreProductType$Stripe$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{StripeProduct$$serializer.INSTANCE};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final ProductItem.StoreProductType.Stripe deserialize(Decoder decoder) {
        StripeProduct stripeProduct;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderB = decoder.b(serialDescriptor);
        int i3 = 1;
        if (compositeDecoderB.p()) {
            stripeProduct = (StripeProduct) compositeDecoderB.y(serialDescriptor, 0, StripeProduct$$serializer.INSTANCE, null);
        } else {
            boolean z2 = true;
            int i4 = 0;
            stripeProduct = null;
            while (z2) {
                int iO = compositeDecoderB.o(serialDescriptor);
                if (iO == -1) {
                    z2 = false;
                } else {
                    if (iO != 0) {
                        throw new UnknownFieldException(iO);
                    }
                    stripeProduct = (StripeProduct) compositeDecoderB.y(serialDescriptor, 0, StripeProduct$$serializer.INSTANCE, stripeProduct);
                    i4 = 1;
                }
            }
            i3 = i4;
        }
        compositeDecoderB.c(serialDescriptor);
        return new ProductItem.StoreProductType.Stripe(i3, stripeProduct, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, ProductItem.StoreProductType.Stripe value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderB = encoder.b(serialDescriptor);
        ProductItem.StoreProductType.Stripe.write$Self$superwall_release(value, compositeEncoderB, serialDescriptor);
        compositeEncoderB.c(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
