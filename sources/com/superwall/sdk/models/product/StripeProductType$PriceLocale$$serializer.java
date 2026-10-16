package com.superwall.sdk.models.product;

import com.superwall.sdk.models.product.StripeProductType;
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
public /* synthetic */ class StripeProductType$PriceLocale$$serializer implements GeneratedSerializer<StripeProductType.PriceLocale> {
    public static final StripeProductType$PriceLocale$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        StripeProductType$PriceLocale$$serializer stripeProductType$PriceLocale$$serializer = new StripeProductType$PriceLocale$$serializer();
        INSTANCE = stripeProductType$PriceLocale$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.superwall.sdk.models.product.StripeProductType.PriceLocale", stripeProductType$PriceLocale$$serializer, 4);
        pluginGeneratedSerialDescriptor.p("identifier", false);
        pluginGeneratedSerialDescriptor.p("language_code", false);
        pluginGeneratedSerialDescriptor.p("currency_code", false);
        pluginGeneratedSerialDescriptor.p("currency_symbol", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private StripeProductType$PriceLocale$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        StringSerializer stringSerializer = StringSerializer.f142891a;
        return new KSerializer[]{stringSerializer, stringSerializer, stringSerializer, stringSerializer};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final StripeProductType.PriceLocale deserialize(Decoder decoder) {
        String strM;
        String strM2;
        String str;
        String str2;
        int i3;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderB = decoder.b(serialDescriptor);
        if (compositeDecoderB.p()) {
            strM = compositeDecoderB.m(serialDescriptor, 0);
            String strM3 = compositeDecoderB.m(serialDescriptor, 1);
            String strM4 = compositeDecoderB.m(serialDescriptor, 2);
            strM2 = compositeDecoderB.m(serialDescriptor, 3);
            str = strM4;
            str2 = strM3;
            i3 = 15;
        } else {
            strM = null;
            String strM5 = null;
            String strM6 = null;
            String strM7 = null;
            boolean z2 = true;
            int i4 = 0;
            while (z2) {
                int iO = compositeDecoderB.o(serialDescriptor);
                if (iO == -1) {
                    z2 = false;
                } else if (iO == 0) {
                    strM = compositeDecoderB.m(serialDescriptor, 0);
                    i4 |= 1;
                } else if (iO == 1) {
                    strM7 = compositeDecoderB.m(serialDescriptor, 1);
                    i4 |= 2;
                } else if (iO == 2) {
                    strM6 = compositeDecoderB.m(serialDescriptor, 2);
                    i4 |= 4;
                } else {
                    if (iO != 3) {
                        throw new UnknownFieldException(iO);
                    }
                    strM5 = compositeDecoderB.m(serialDescriptor, 3);
                    i4 |= 8;
                }
            }
            strM2 = strM5;
            str = strM6;
            str2 = strM7;
            i3 = i4;
        }
        String str3 = strM;
        compositeDecoderB.c(serialDescriptor);
        return new StripeProductType.PriceLocale(i3, str3, str2, str, strM2, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, StripeProductType.PriceLocale value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderB = encoder.b(serialDescriptor);
        StripeProductType.PriceLocale.write$Self$superwall_release(value, compositeEncoderB, serialDescriptor);
        compositeEncoderB.c(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
