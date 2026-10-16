package com.superwall.sdk.models.product;

import com.revenuecat.purchases.common.responses.EntitlementsResponseJsonKeys;
import com.revenuecat.purchases.common.responses.ProductResponseJsonKeys;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
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
public /* synthetic */ class StripeProduct$$serializer implements GeneratedSerializer<StripeProduct> {
    public static final StripeProduct$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        StripeProduct$$serializer stripeProduct$$serializer = new StripeProduct$$serializer();
        INSTANCE = stripeProduct$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.superwall.sdk.models.product.StripeProduct", stripeProduct$$serializer, 4);
        pluginGeneratedSerialDescriptor.p(ProductResponseJsonKeys.STORE, true);
        pluginGeneratedSerialDescriptor.p("environment", false);
        pluginGeneratedSerialDescriptor.p(EntitlementsResponseJsonKeys.PRODUCT_IDENTIFIER, false);
        pluginGeneratedSerialDescriptor.p("trial_days", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private StripeProduct$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        KSerializer<?> kSerializerU = BuiltinSerializersKt.u(IntSerializer.f142823a);
        StringSerializer stringSerializer = StringSerializer.f142891a;
        return new KSerializer[]{StoreSerializer.INSTANCE, stringSerializer, stringSerializer, kSerializerU};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final StripeProduct deserialize(Decoder decoder) {
        int i3;
        Store store;
        String str;
        String str2;
        Integer num;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderB = decoder.b(serialDescriptor);
        Store store2 = null;
        if (compositeDecoderB.p()) {
            Store store3 = (Store) compositeDecoderB.y(serialDescriptor, 0, StoreSerializer.INSTANCE, null);
            String strM = compositeDecoderB.m(serialDescriptor, 1);
            String strM2 = compositeDecoderB.m(serialDescriptor, 2);
            store = store3;
            num = (Integer) compositeDecoderB.n(serialDescriptor, 3, IntSerializer.f142823a, null);
            str2 = strM2;
            str = strM;
            i3 = 15;
        } else {
            boolean z2 = true;
            int i4 = 0;
            String strM3 = null;
            String strM4 = null;
            Integer num2 = null;
            while (z2) {
                int iO = compositeDecoderB.o(serialDescriptor);
                if (iO == -1) {
                    z2 = false;
                } else if (iO == 0) {
                    store2 = (Store) compositeDecoderB.y(serialDescriptor, 0, StoreSerializer.INSTANCE, store2);
                    i4 |= 1;
                } else if (iO == 1) {
                    strM3 = compositeDecoderB.m(serialDescriptor, 1);
                    i4 |= 2;
                } else if (iO == 2) {
                    strM4 = compositeDecoderB.m(serialDescriptor, 2);
                    i4 |= 4;
                } else {
                    if (iO != 3) {
                        throw new UnknownFieldException(iO);
                    }
                    num2 = (Integer) compositeDecoderB.n(serialDescriptor, 3, IntSerializer.f142823a, num2);
                    i4 |= 8;
                }
            }
            i3 = i4;
            store = store2;
            str = strM3;
            str2 = strM4;
            num = num2;
        }
        compositeDecoderB.c(serialDescriptor);
        return new StripeProduct(i3, store, str, str2, num, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, StripeProduct value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderB = encoder.b(serialDescriptor);
        StripeProduct.write$Self$superwall_release(value, compositeEncoderB, serialDescriptor);
        compositeEncoderB.c(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
