package com.revenuecat.purchases.paywalls.components;

import com.revenuecat.purchases.paywalls.components.IconComponent;
import com.revenuecat.purchases.paywalls.components.properties.Border;
import com.revenuecat.purchases.paywalls.components.properties.Border$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.MaskShape;
import com.revenuecat.purchases.paywalls.components.properties.MaskShapeDeserializer;
import com.revenuecat.purchases.paywalls.components.properties.Shadow;
import com.revenuecat.purchases.paywalls.components.properties.Shadow$$serializer;
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
public final class IconComponent$IconBackground$$serializer implements GeneratedSerializer<IconComponent.IconBackground> {
    public static final IconComponent$IconBackground$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        IconComponent$IconBackground$$serializer iconComponent$IconBackground$$serializer = new IconComponent$IconBackground$$serializer();
        INSTANCE = iconComponent$IconBackground$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.paywalls.components.IconComponent.IconBackground", iconComponent$IconBackground$$serializer, 4);
        pluginGeneratedSerialDescriptor.p("color", false);
        pluginGeneratedSerialDescriptor.p("shape", false);
        pluginGeneratedSerialDescriptor.p("border", true);
        pluginGeneratedSerialDescriptor.p("shadow", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private IconComponent$IconBackground$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{ColorScheme$$serializer.INSTANCE, MaskShapeDeserializer.INSTANCE, BuiltinSerializersKt.u(Border$$serializer.INSTANCE), BuiltinSerializersKt.u(Shadow$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public IconComponent.IconBackground deserialize(Decoder decoder) {
        int i3;
        ColorScheme colorScheme;
        MaskShape maskShape;
        Border border;
        Shadow shadow;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderB = decoder.b(descriptor2);
        ColorScheme colorScheme2 = null;
        if (compositeDecoderB.p()) {
            ColorScheme colorScheme3 = (ColorScheme) compositeDecoderB.y(descriptor2, 0, ColorScheme$$serializer.INSTANCE, null);
            MaskShape maskShape2 = (MaskShape) compositeDecoderB.y(descriptor2, 1, MaskShapeDeserializer.INSTANCE, null);
            Border border2 = (Border) compositeDecoderB.n(descriptor2, 2, Border$$serializer.INSTANCE, null);
            colorScheme = colorScheme3;
            shadow = (Shadow) compositeDecoderB.n(descriptor2, 3, Shadow$$serializer.INSTANCE, null);
            border = border2;
            maskShape = maskShape2;
            i3 = 15;
        } else {
            boolean z2 = true;
            int i4 = 0;
            MaskShape maskShape3 = null;
            Border border3 = null;
            Shadow shadow2 = null;
            while (z2) {
                int iO = compositeDecoderB.o(descriptor2);
                if (iO == -1) {
                    z2 = false;
                } else if (iO == 0) {
                    colorScheme2 = (ColorScheme) compositeDecoderB.y(descriptor2, 0, ColorScheme$$serializer.INSTANCE, colorScheme2);
                    i4 |= 1;
                } else if (iO == 1) {
                    maskShape3 = (MaskShape) compositeDecoderB.y(descriptor2, 1, MaskShapeDeserializer.INSTANCE, maskShape3);
                    i4 |= 2;
                } else if (iO == 2) {
                    border3 = (Border) compositeDecoderB.n(descriptor2, 2, Border$$serializer.INSTANCE, border3);
                    i4 |= 4;
                } else {
                    if (iO != 3) {
                        throw new UnknownFieldException(iO);
                    }
                    shadow2 = (Shadow) compositeDecoderB.n(descriptor2, 3, Shadow$$serializer.INSTANCE, shadow2);
                    i4 |= 8;
                }
            }
            i3 = i4;
            colorScheme = colorScheme2;
            maskShape = maskShape3;
            border = border3;
            shadow = shadow2;
        }
        compositeDecoderB.c(descriptor2);
        return new IconComponent.IconBackground(i3, colorScheme, maskShape, border, shadow, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, IconComponent.IconBackground value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderB = encoder.b(descriptor2);
        IconComponent.IconBackground.write$Self$purchases_defaultsBc8Release(value, compositeEncoderB, descriptor2);
        compositeEncoderB.c(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
