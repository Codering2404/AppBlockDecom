package com.revenuecat.purchases.paywalls.components.properties;

import com.revenuecat.purchases.ColorAlias;
import com.revenuecat.purchases.ColorAlias$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.ColorInfo;
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
/* JADX INFO: loaded from: classes6.dex */
@Metadata
@Deprecated
public final class ColorInfo$Alias$$serializer implements GeneratedSerializer<ColorInfo.Alias> {
    public static final ColorInfo$Alias$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        ColorInfo$Alias$$serializer colorInfo$Alias$$serializer = new ColorInfo$Alias$$serializer();
        INSTANCE = colorInfo$Alias$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("alias", colorInfo$Alias$$serializer, 1);
        pluginGeneratedSerialDescriptor.p("value", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private ColorInfo$Alias$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{ColorAlias$$serializer.INSTANCE};
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.serialization.DeserializationStrategy
    public ColorInfo.Alias deserialize(Decoder decoder) {
        String strM420unboximpl;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderB = decoder.b(descriptor2);
        int i3 = 1;
        SerializationConstructorMarker serializationConstructorMarker = null;
        Object[] objArr = 0;
        if (compositeDecoderB.p()) {
            ColorAlias colorAlias = (ColorAlias) compositeDecoderB.y(descriptor2, 0, ColorAlias$$serializer.INSTANCE, null);
            strM420unboximpl = colorAlias != null ? colorAlias.m420unboximpl() : null;
        } else {
            Object[] objArr2 = true;
            int i4 = 0;
            strM420unboximpl = null;
            while (objArr2 != false) {
                int iO = compositeDecoderB.o(descriptor2);
                if (iO == -1) {
                    objArr2 = false;
                } else {
                    if (iO != 0) {
                        throw new UnknownFieldException(iO);
                    }
                    ColorAlias colorAlias2 = (ColorAlias) compositeDecoderB.y(descriptor2, 0, ColorAlias$$serializer.INSTANCE, strM420unboximpl != null ? ColorAlias.m414boximpl(strM420unboximpl) : null);
                    strM420unboximpl = colorAlias2 != null ? colorAlias2.m420unboximpl() : null;
                    i4 = 1;
                }
            }
            i3 = i4;
        }
        compositeDecoderB.c(descriptor2);
        return new ColorInfo.Alias(i3, strM420unboximpl, serializationConstructorMarker, objArr == true ? 1 : 0);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, ColorInfo.Alias value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderB = encoder.b(descriptor2);
        compositeEncoderB.C(descriptor2, 0, ColorAlias$$serializer.INSTANCE, ColorAlias.m414boximpl(value.value));
        compositeEncoderB.c(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
