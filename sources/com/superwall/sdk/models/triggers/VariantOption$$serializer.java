package com.superwall.sdk.models.triggers;

import com.superwall.sdk.models.triggers.Experiment;
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
public /* synthetic */ class VariantOption$$serializer implements GeneratedSerializer<VariantOption> {
    public static final VariantOption$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        VariantOption$$serializer variantOption$$serializer = new VariantOption$$serializer();
        INSTANCE = variantOption$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.superwall.sdk.models.triggers.VariantOption", variantOption$$serializer, 4);
        pluginGeneratedSerialDescriptor.p("variant_type", false);
        pluginGeneratedSerialDescriptor.p("variant_id", false);
        pluginGeneratedSerialDescriptor.p("percentage", false);
        pluginGeneratedSerialDescriptor.p("paywall_identifier", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private VariantOption$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        KSerializer<?> kSerializer = VariantOption.$childSerializers[0];
        StringSerializer stringSerializer = StringSerializer.f142891a;
        return new KSerializer[]{kSerializer, stringSerializer, IntSerializer.f142823a, BuiltinSerializersKt.u(stringSerializer)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final VariantOption deserialize(Decoder decoder) {
        int i3;
        int i4;
        Experiment.Variant.VariantType variantType;
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderB = decoder.b(serialDescriptor);
        KSerializer[] kSerializerArr = VariantOption.$childSerializers;
        if (compositeDecoderB.p()) {
            Experiment.Variant.VariantType variantType2 = (Experiment.Variant.VariantType) compositeDecoderB.y(serialDescriptor, 0, kSerializerArr[0], null);
            String strM = compositeDecoderB.m(serialDescriptor, 1);
            int i5 = compositeDecoderB.i(serialDescriptor, 2);
            variantType = variantType2;
            str = strM;
            str2 = (String) compositeDecoderB.n(serialDescriptor, 3, StringSerializer.f142891a, null);
            i3 = i5;
            i4 = 15;
        } else {
            boolean z2 = true;
            int i6 = 0;
            Experiment.Variant.VariantType variantType3 = null;
            String strM2 = null;
            String str3 = null;
            int i7 = 0;
            while (z2) {
                int iO = compositeDecoderB.o(serialDescriptor);
                if (iO == -1) {
                    z2 = false;
                } else if (iO == 0) {
                    variantType3 = (Experiment.Variant.VariantType) compositeDecoderB.y(serialDescriptor, 0, kSerializerArr[0], variantType3);
                    i7 |= 1;
                } else if (iO == 1) {
                    strM2 = compositeDecoderB.m(serialDescriptor, 1);
                    i7 |= 2;
                } else if (iO == 2) {
                    i6 = compositeDecoderB.i(serialDescriptor, 2);
                    i7 |= 4;
                } else {
                    if (iO != 3) {
                        throw new UnknownFieldException(iO);
                    }
                    str3 = (String) compositeDecoderB.n(serialDescriptor, 3, StringSerializer.f142891a, str3);
                    i7 |= 8;
                }
            }
            i3 = i6;
            i4 = i7;
            variantType = variantType3;
            str = strM2;
            str2 = str3;
        }
        compositeDecoderB.c(serialDescriptor);
        return new VariantOption(i4, variantType, str, i3, str2, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, VariantOption value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderB = encoder.b(serialDescriptor);
        VariantOption.write$Self$superwall_release(value, compositeEncoderB, serialDescriptor);
        compositeEncoderB.c(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
