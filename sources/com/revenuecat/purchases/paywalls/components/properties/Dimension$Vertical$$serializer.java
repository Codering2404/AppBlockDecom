package com.revenuecat.purchases.paywalls.components.properties;

import com.revenuecat.purchases.paywalls.components.properties.Dimension;
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
public final class Dimension$Vertical$$serializer implements GeneratedSerializer<Dimension.Vertical> {
    public static final Dimension$Vertical$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        Dimension$Vertical$$serializer dimension$Vertical$$serializer = new Dimension$Vertical$$serializer();
        INSTANCE = dimension$Vertical$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("vertical", dimension$Vertical$$serializer, 2);
        pluginGeneratedSerialDescriptor.p("alignment", false);
        pluginGeneratedSerialDescriptor.p("distribution", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private Dimension$Vertical$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{HorizontalAlignmentDeserializer.INSTANCE, FlexDistributionDeserializer.INSTANCE};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public Dimension.Vertical deserialize(Decoder decoder) {
        HorizontalAlignment horizontalAlignment;
        FlexDistribution flexDistribution;
        int i3;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderB = decoder.b(descriptor2);
        SerializationConstructorMarker serializationConstructorMarker = null;
        if (compositeDecoderB.p()) {
            horizontalAlignment = (HorizontalAlignment) compositeDecoderB.y(descriptor2, 0, HorizontalAlignmentDeserializer.INSTANCE, null);
            flexDistribution = (FlexDistribution) compositeDecoderB.y(descriptor2, 1, FlexDistributionDeserializer.INSTANCE, null);
            i3 = 3;
        } else {
            boolean z2 = true;
            int i4 = 0;
            horizontalAlignment = null;
            FlexDistribution flexDistribution2 = null;
            while (z2) {
                int iO = compositeDecoderB.o(descriptor2);
                if (iO == -1) {
                    z2 = false;
                } else if (iO == 0) {
                    horizontalAlignment = (HorizontalAlignment) compositeDecoderB.y(descriptor2, 0, HorizontalAlignmentDeserializer.INSTANCE, horizontalAlignment);
                    i4 |= 1;
                } else {
                    if (iO != 1) {
                        throw new UnknownFieldException(iO);
                    }
                    flexDistribution2 = (FlexDistribution) compositeDecoderB.y(descriptor2, 1, FlexDistributionDeserializer.INSTANCE, flexDistribution2);
                    i4 |= 2;
                }
            }
            flexDistribution = flexDistribution2;
            i3 = i4;
        }
        compositeDecoderB.c(descriptor2);
        return new Dimension.Vertical(i3, horizontalAlignment, flexDistribution, serializationConstructorMarker);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, Dimension.Vertical value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderB = encoder.b(descriptor2);
        Dimension.Vertical.write$Self$purchases_defaultsBc8Release(value, compositeEncoderB, descriptor2);
        compositeEncoderB.c(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
