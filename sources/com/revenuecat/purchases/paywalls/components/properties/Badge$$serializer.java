package com.revenuecat.purchases.paywalls.components.properties;

import com.facebook.internal.AnalyticsEvents;
import com.revenuecat.purchases.paywalls.components.StackComponent;
import com.revenuecat.purchases.paywalls.components.StackComponent$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Badge;
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
/* JADX INFO: loaded from: classes6.dex */
@Metadata
@Deprecated
public final class Badge$$serializer implements GeneratedSerializer<Badge> {
    public static final Badge$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        Badge$$serializer badge$$serializer = new Badge$$serializer();
        INSTANCE = badge$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.paywalls.components.properties.Badge", badge$$serializer, 3);
        pluginGeneratedSerialDescriptor.p("stack", false);
        pluginGeneratedSerialDescriptor.p(AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, false);
        pluginGeneratedSerialDescriptor.p("alignment", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private Badge$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{StackComponent$$serializer.INSTANCE, BadgeStyleSerializer.INSTANCE, TwoDimensionalAlignmentDeserializer.INSTANCE};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public Badge deserialize(Decoder decoder) {
        int i3;
        StackComponent stackComponent;
        Badge.Style style;
        TwoDimensionalAlignment twoDimensionalAlignment;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderB = decoder.b(descriptor2);
        StackComponent stackComponent2 = null;
        if (compositeDecoderB.p()) {
            StackComponent stackComponent3 = (StackComponent) compositeDecoderB.y(descriptor2, 0, StackComponent$$serializer.INSTANCE, null);
            Badge.Style style2 = (Badge.Style) compositeDecoderB.y(descriptor2, 1, BadgeStyleSerializer.INSTANCE, null);
            stackComponent = stackComponent3;
            twoDimensionalAlignment = (TwoDimensionalAlignment) compositeDecoderB.y(descriptor2, 2, TwoDimensionalAlignmentDeserializer.INSTANCE, null);
            style = style2;
            i3 = 7;
        } else {
            boolean z2 = true;
            int i4 = 0;
            Badge.Style style3 = null;
            TwoDimensionalAlignment twoDimensionalAlignment2 = null;
            while (z2) {
                int iO = compositeDecoderB.o(descriptor2);
                if (iO == -1) {
                    z2 = false;
                } else if (iO == 0) {
                    stackComponent2 = (StackComponent) compositeDecoderB.y(descriptor2, 0, StackComponent$$serializer.INSTANCE, stackComponent2);
                    i4 |= 1;
                } else if (iO == 1) {
                    style3 = (Badge.Style) compositeDecoderB.y(descriptor2, 1, BadgeStyleSerializer.INSTANCE, style3);
                    i4 |= 2;
                } else {
                    if (iO != 2) {
                        throw new UnknownFieldException(iO);
                    }
                    twoDimensionalAlignment2 = (TwoDimensionalAlignment) compositeDecoderB.y(descriptor2, 2, TwoDimensionalAlignmentDeserializer.INSTANCE, twoDimensionalAlignment2);
                    i4 |= 4;
                }
            }
            i3 = i4;
            stackComponent = stackComponent2;
            style = style3;
            twoDimensionalAlignment = twoDimensionalAlignment2;
        }
        compositeDecoderB.c(descriptor2);
        return new Badge(i3, stackComponent, style, twoDimensionalAlignment, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, Badge value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderB = encoder.b(descriptor2);
        Badge.write$Self$purchases_defaultsBc8Release(value, compositeEncoderB, descriptor2);
        compositeEncoderB.c(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
