package com.revenuecat.purchases.paywalls.components;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.revenuecat.purchases.paywalls.components.CarouselComponent;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme$$serializer;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.UInt;
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
import kotlinx.serialization.internal.UIntSerializer;

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
public final class CarouselComponent$PageControl$Indicator$$serializer implements GeneratedSerializer<CarouselComponent.PageControl.Indicator> {
    public static final CarouselComponent$PageControl$Indicator$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        CarouselComponent$PageControl$Indicator$$serializer carouselComponent$PageControl$Indicator$$serializer = new CarouselComponent$PageControl$Indicator$$serializer();
        INSTANCE = carouselComponent$PageControl$Indicator$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.paywalls.components.CarouselComponent.PageControl.Indicator", carouselComponent$PageControl$Indicator$$serializer, 5);
        pluginGeneratedSerialDescriptor.p(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, false);
        pluginGeneratedSerialDescriptor.p(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, false);
        pluginGeneratedSerialDescriptor.p("color", false);
        pluginGeneratedSerialDescriptor.p("stroke_color", true);
        pluginGeneratedSerialDescriptor.p("stroke_width", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private CarouselComponent$PageControl$Indicator$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        UIntSerializer uIntSerializer = UIntSerializer.f142909a;
        ColorScheme$$serializer colorScheme$$serializer = ColorScheme$$serializer.INSTANCE;
        return new KSerializer[]{uIntSerializer, uIntSerializer, colorScheme$$serializer, BuiltinSerializersKt.u(colorScheme$$serializer), BuiltinSerializersKt.u(uIntSerializer)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public CarouselComponent.PageControl.Indicator deserialize(Decoder decoder) {
        int i3;
        UInt uInt;
        UInt uInt2;
        ColorScheme colorScheme;
        ColorScheme colorScheme2;
        UInt uInt3;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderB = decoder.b(descriptor2);
        UInt uInt4 = null;
        if (compositeDecoderB.p()) {
            UIntSerializer uIntSerializer = UIntSerializer.f142909a;
            UInt uInt5 = (UInt) compositeDecoderB.y(descriptor2, 0, uIntSerializer, null);
            UInt uInt6 = (UInt) compositeDecoderB.y(descriptor2, 1, uIntSerializer, null);
            ColorScheme$$serializer colorScheme$$serializer = ColorScheme$$serializer.INSTANCE;
            ColorScheme colorScheme3 = (ColorScheme) compositeDecoderB.y(descriptor2, 2, colorScheme$$serializer, null);
            ColorScheme colorScheme4 = (ColorScheme) compositeDecoderB.n(descriptor2, 3, colorScheme$$serializer, null);
            uInt3 = (UInt) compositeDecoderB.n(descriptor2, 4, uIntSerializer, null);
            colorScheme2 = colorScheme4;
            i3 = 31;
            colorScheme = colorScheme3;
            uInt2 = uInt6;
            uInt = uInt5;
        } else {
            boolean z2 = true;
            int i4 = 0;
            UInt uInt7 = null;
            ColorScheme colorScheme5 = null;
            ColorScheme colorScheme6 = null;
            UInt uInt8 = null;
            while (z2) {
                int iO = compositeDecoderB.o(descriptor2);
                if (iO == -1) {
                    z2 = false;
                } else if (iO == 0) {
                    uInt4 = (UInt) compositeDecoderB.y(descriptor2, 0, UIntSerializer.f142909a, uInt4);
                    i4 |= 1;
                } else if (iO == 1) {
                    uInt7 = (UInt) compositeDecoderB.y(descriptor2, 1, UIntSerializer.f142909a, uInt7);
                    i4 |= 2;
                } else if (iO == 2) {
                    colorScheme5 = (ColorScheme) compositeDecoderB.y(descriptor2, 2, ColorScheme$$serializer.INSTANCE, colorScheme5);
                    i4 |= 4;
                } else if (iO == 3) {
                    colorScheme6 = (ColorScheme) compositeDecoderB.n(descriptor2, 3, ColorScheme$$serializer.INSTANCE, colorScheme6);
                    i4 |= 8;
                } else {
                    if (iO != 4) {
                        throw new UnknownFieldException(iO);
                    }
                    uInt8 = (UInt) compositeDecoderB.n(descriptor2, 4, UIntSerializer.f142909a, uInt8);
                    i4 |= 16;
                }
            }
            i3 = i4;
            uInt = uInt4;
            uInt2 = uInt7;
            colorScheme = colorScheme5;
            colorScheme2 = colorScheme6;
            uInt3 = uInt8;
        }
        compositeDecoderB.c(descriptor2);
        return new CarouselComponent.PageControl.Indicator(i3, uInt, uInt2, colorScheme, colorScheme2, uInt3, null, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, CarouselComponent.PageControl.Indicator value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderB = encoder.b(descriptor2);
        CarouselComponent.PageControl.Indicator.write$Self$purchases_defaultsBc8Release(value, compositeEncoderB, descriptor2);
        compositeEncoderB.c(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
