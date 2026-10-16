package com.revenuecat.purchases.paywalls.components;

import com.revenuecat.purchases.paywalls.components.CarouselComponent;
import com.revenuecat.purchases.paywalls.components.properties.Border;
import com.revenuecat.purchases.paywalls.components.properties.Border$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Padding;
import com.revenuecat.purchases.paywalls.components.properties.Padding$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Shadow;
import com.revenuecat.purchases.paywalls.components.properties.Shadow$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Shape;
import com.revenuecat.purchases.paywalls.components.properties.ShapeDeserializer;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
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
public final class CarouselComponent$PageControl$$serializer implements GeneratedSerializer<CarouselComponent.PageControl> {
    public static final CarouselComponent$PageControl$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        CarouselComponent$PageControl$$serializer carouselComponent$PageControl$$serializer = new CarouselComponent$PageControl$$serializer();
        INSTANCE = carouselComponent$PageControl$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.paywalls.components.CarouselComponent.PageControl", carouselComponent$PageControl$$serializer, 10);
        pluginGeneratedSerialDescriptor.p("position", false);
        pluginGeneratedSerialDescriptor.p("spacing", true);
        pluginGeneratedSerialDescriptor.p("padding", true);
        pluginGeneratedSerialDescriptor.p("margin", true);
        pluginGeneratedSerialDescriptor.p("background_color", true);
        pluginGeneratedSerialDescriptor.p("shape", true);
        pluginGeneratedSerialDescriptor.p("border", true);
        pluginGeneratedSerialDescriptor.p("shadow", true);
        pluginGeneratedSerialDescriptor.p("active", false);
        pluginGeneratedSerialDescriptor.p("default", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private CarouselComponent$PageControl$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        KSerializer<?> kSerializerU = BuiltinSerializersKt.u(IntSerializer.f142823a);
        KSerializer<?> kSerializerU2 = BuiltinSerializersKt.u(ColorScheme$$serializer.INSTANCE);
        KSerializer<?> kSerializerU3 = BuiltinSerializersKt.u(ShapeDeserializer.INSTANCE);
        KSerializer<?> kSerializerU4 = BuiltinSerializersKt.u(Border$$serializer.INSTANCE);
        KSerializer<?> kSerializerU5 = BuiltinSerializersKt.u(Shadow$$serializer.INSTANCE);
        Padding$$serializer padding$$serializer = Padding$$serializer.INSTANCE;
        CarouselComponent$PageControl$Indicator$$serializer carouselComponent$PageControl$Indicator$$serializer = CarouselComponent$PageControl$Indicator$$serializer.INSTANCE;
        return new KSerializer[]{CarouselPageControlPositionDeserializer.INSTANCE, kSerializerU, padding$$serializer, padding$$serializer, kSerializerU2, kSerializerU3, kSerializerU4, kSerializerU5, carouselComponent$PageControl$Indicator$$serializer, carouselComponent$PageControl$Indicator$$serializer};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public CarouselComponent.PageControl deserialize(Decoder decoder) {
        int i3;
        CarouselComponent.PageControl.Indicator indicator;
        CarouselComponent.PageControl.Indicator indicator2;
        Border border;
        Shadow shadow;
        Shape shape;
        ColorScheme colorScheme;
        Padding padding;
        CarouselComponent.PageControl.Position position;
        Integer num;
        Padding padding2;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderB = decoder.b(descriptor2);
        int i4 = 9;
        CarouselComponent.PageControl.Position position2 = null;
        if (compositeDecoderB.p()) {
            CarouselComponent.PageControl.Position position3 = (CarouselComponent.PageControl.Position) compositeDecoderB.y(descriptor2, 0, CarouselPageControlPositionDeserializer.INSTANCE, null);
            Integer num2 = (Integer) compositeDecoderB.n(descriptor2, 1, IntSerializer.f142823a, null);
            Padding$$serializer padding$$serializer = Padding$$serializer.INSTANCE;
            Padding padding3 = (Padding) compositeDecoderB.y(descriptor2, 2, padding$$serializer, null);
            Padding padding4 = (Padding) compositeDecoderB.y(descriptor2, 3, padding$$serializer, null);
            ColorScheme colorScheme2 = (ColorScheme) compositeDecoderB.n(descriptor2, 4, ColorScheme$$serializer.INSTANCE, null);
            Shape shape2 = (Shape) compositeDecoderB.n(descriptor2, 5, ShapeDeserializer.INSTANCE, null);
            Border border2 = (Border) compositeDecoderB.n(descriptor2, 6, Border$$serializer.INSTANCE, null);
            Shadow shadow2 = (Shadow) compositeDecoderB.n(descriptor2, 7, Shadow$$serializer.INSTANCE, null);
            CarouselComponent$PageControl$Indicator$$serializer carouselComponent$PageControl$Indicator$$serializer = CarouselComponent$PageControl$Indicator$$serializer.INSTANCE;
            CarouselComponent.PageControl.Indicator indicator3 = (CarouselComponent.PageControl.Indicator) compositeDecoderB.y(descriptor2, 8, carouselComponent$PageControl$Indicator$$serializer, null);
            position = position3;
            indicator = (CarouselComponent.PageControl.Indicator) compositeDecoderB.y(descriptor2, 9, carouselComponent$PageControl$Indicator$$serializer, null);
            shadow = shadow2;
            border = border2;
            shape = shape2;
            padding = padding4;
            indicator2 = indicator3;
            colorScheme = colorScheme2;
            padding2 = padding3;
            num = num2;
            i3 = 1023;
        } else {
            boolean z2 = true;
            int i5 = 0;
            CarouselComponent.PageControl.Indicator indicator4 = null;
            CarouselComponent.PageControl.Indicator indicator5 = null;
            Border border3 = null;
            Shadow shadow3 = null;
            Shape shape3 = null;
            ColorScheme colorScheme3 = null;
            Padding padding5 = null;
            Integer num3 = null;
            Padding padding6 = null;
            while (z2) {
                int iO = compositeDecoderB.o(descriptor2);
                switch (iO) {
                    case -1:
                        z2 = false;
                        i4 = 9;
                        break;
                    case 0:
                        position2 = (CarouselComponent.PageControl.Position) compositeDecoderB.y(descriptor2, 0, CarouselPageControlPositionDeserializer.INSTANCE, position2);
                        i5 |= 1;
                        i4 = 9;
                        break;
                    case 1:
                        num3 = (Integer) compositeDecoderB.n(descriptor2, 1, IntSerializer.f142823a, num3);
                        i5 |= 2;
                        i4 = 9;
                        break;
                    case 2:
                        padding6 = (Padding) compositeDecoderB.y(descriptor2, 2, Padding$$serializer.INSTANCE, padding6);
                        i5 |= 4;
                        i4 = 9;
                        break;
                    case 3:
                        padding5 = (Padding) compositeDecoderB.y(descriptor2, 3, Padding$$serializer.INSTANCE, padding5);
                        i5 |= 8;
                        i4 = 9;
                        break;
                    case 4:
                        colorScheme3 = (ColorScheme) compositeDecoderB.n(descriptor2, 4, ColorScheme$$serializer.INSTANCE, colorScheme3);
                        i5 |= 16;
                        i4 = 9;
                        break;
                    case 5:
                        shape3 = (Shape) compositeDecoderB.n(descriptor2, 5, ShapeDeserializer.INSTANCE, shape3);
                        i5 |= 32;
                        i4 = 9;
                        break;
                    case 6:
                        border3 = (Border) compositeDecoderB.n(descriptor2, 6, Border$$serializer.INSTANCE, border3);
                        i5 |= 64;
                        i4 = 9;
                        break;
                    case 7:
                        shadow3 = (Shadow) compositeDecoderB.n(descriptor2, 7, Shadow$$serializer.INSTANCE, shadow3);
                        i5 |= ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
                        i4 = 9;
                        break;
                    case 8:
                        indicator5 = (CarouselComponent.PageControl.Indicator) compositeDecoderB.y(descriptor2, 8, CarouselComponent$PageControl$Indicator$$serializer.INSTANCE, indicator5);
                        i5 |= Function.MAX_NARGS;
                        break;
                    case 9:
                        indicator4 = (CarouselComponent.PageControl.Indicator) compositeDecoderB.y(descriptor2, i4, CarouselComponent$PageControl$Indicator$$serializer.INSTANCE, indicator4);
                        i5 |= 512;
                        break;
                    default:
                        throw new UnknownFieldException(iO);
                }
            }
            i3 = i5;
            indicator = indicator4;
            indicator2 = indicator5;
            border = border3;
            shadow = shadow3;
            shape = shape3;
            colorScheme = colorScheme3;
            padding = padding5;
            position = position2;
            num = num3;
            padding2 = padding6;
        }
        compositeDecoderB.c(descriptor2);
        return new CarouselComponent.PageControl(i3, position, num, padding2, padding, colorScheme, shape, border, shadow, indicator2, indicator, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, CarouselComponent.PageControl value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderB = encoder.b(descriptor2);
        CarouselComponent.PageControl.write$Self$purchases_defaultsBc8Release(value, compositeEncoderB, descriptor2);
        compositeEncoderB.c(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
