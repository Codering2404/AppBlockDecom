package com.revenuecat.purchases.paywalls.components;

import com.facebook.internal.Utility;
import com.revenuecat.purchases.paywalls.components.CarouselComponent;
import com.revenuecat.purchases.paywalls.components.common.Background;
import com.revenuecat.purchases.paywalls.components.common.BackgroundDeserializer;
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
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.paywalls.components.properties.Size$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.VerticalAlignment;
import com.revenuecat.purchases.paywalls.components.properties.VerticalAlignmentDeserializer;
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
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.FloatSerializer;
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
public final class PartialCarouselComponent$$serializer implements GeneratedSerializer<PartialCarouselComponent> {
    public static final PartialCarouselComponent$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        PartialCarouselComponent$$serializer partialCarouselComponent$$serializer = new PartialCarouselComponent$$serializer();
        INSTANCE = partialCarouselComponent$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.paywalls.components.PartialCarouselComponent", partialCarouselComponent$$serializer, 16);
        pluginGeneratedSerialDescriptor.p("visible", true);
        pluginGeneratedSerialDescriptor.p("initial_page_index", true);
        pluginGeneratedSerialDescriptor.p("page_alignment", true);
        pluginGeneratedSerialDescriptor.p("size", true);
        pluginGeneratedSerialDescriptor.p("page_peek", true);
        pluginGeneratedSerialDescriptor.p("page_spacing", true);
        pluginGeneratedSerialDescriptor.p("background_color", true);
        pluginGeneratedSerialDescriptor.p("background", true);
        pluginGeneratedSerialDescriptor.p("padding", true);
        pluginGeneratedSerialDescriptor.p("margin", true);
        pluginGeneratedSerialDescriptor.p("shape", true);
        pluginGeneratedSerialDescriptor.p("border", true);
        pluginGeneratedSerialDescriptor.p("shadow", true);
        pluginGeneratedSerialDescriptor.p("page_control", true);
        pluginGeneratedSerialDescriptor.p("loop", true);
        pluginGeneratedSerialDescriptor.p("auto_advance", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private PartialCarouselComponent$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        BooleanSerializer booleanSerializer = BooleanSerializer.f142767a;
        KSerializer<?> kSerializerU = BuiltinSerializersKt.u(booleanSerializer);
        IntSerializer intSerializer = IntSerializer.f142823a;
        KSerializer<?> kSerializerU2 = BuiltinSerializersKt.u(intSerializer);
        KSerializer<?> kSerializerU3 = BuiltinSerializersKt.u(VerticalAlignmentDeserializer.INSTANCE);
        KSerializer<?> kSerializerU4 = BuiltinSerializersKt.u(Size$$serializer.INSTANCE);
        KSerializer<?> kSerializerU5 = BuiltinSerializersKt.u(intSerializer);
        KSerializer<?> kSerializerU6 = BuiltinSerializersKt.u(FloatSerializer.f142814a);
        KSerializer<?> kSerializerU7 = BuiltinSerializersKt.u(ColorScheme$$serializer.INSTANCE);
        KSerializer<?> kSerializerU8 = BuiltinSerializersKt.u(BackgroundDeserializer.INSTANCE);
        Padding$$serializer padding$$serializer = Padding$$serializer.INSTANCE;
        return new KSerializer[]{kSerializerU, kSerializerU2, kSerializerU3, kSerializerU4, kSerializerU5, kSerializerU6, kSerializerU7, kSerializerU8, BuiltinSerializersKt.u(padding$$serializer), BuiltinSerializersKt.u(padding$$serializer), BuiltinSerializersKt.u(ShapeDeserializer.INSTANCE), BuiltinSerializersKt.u(Border$$serializer.INSTANCE), BuiltinSerializersKt.u(Shadow$$serializer.INSTANCE), BuiltinSerializersKt.u(CarouselComponent$PageControl$$serializer.INSTANCE), BuiltinSerializersKt.u(booleanSerializer), BuiltinSerializersKt.u(CarouselComponent$AutoAdvancePages$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public PartialCarouselComponent deserialize(Decoder decoder) {
        int i3;
        Boolean bool;
        Integer num;
        Boolean bool2;
        CarouselComponent.AutoAdvancePages autoAdvancePages;
        Shadow shadow;
        Shape shape;
        Padding padding;
        Padding padding2;
        ColorScheme colorScheme;
        Border border;
        Background background;
        Integer num2;
        VerticalAlignment verticalAlignment;
        Size size;
        Float f3;
        CarouselComponent.PageControl pageControl;
        Integer num3;
        CarouselComponent.PageControl pageControl2;
        Float f4;
        Size size2;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderB = decoder.b(descriptor2);
        if (compositeDecoderB.p()) {
            BooleanSerializer booleanSerializer = BooleanSerializer.f142767a;
            Boolean bool3 = (Boolean) compositeDecoderB.n(descriptor2, 0, booleanSerializer, null);
            IntSerializer intSerializer = IntSerializer.f142823a;
            Integer num4 = (Integer) compositeDecoderB.n(descriptor2, 1, intSerializer, null);
            VerticalAlignment verticalAlignment2 = (VerticalAlignment) compositeDecoderB.n(descriptor2, 2, VerticalAlignmentDeserializer.INSTANCE, null);
            Size size3 = (Size) compositeDecoderB.n(descriptor2, 3, Size$$serializer.INSTANCE, null);
            Integer num5 = (Integer) compositeDecoderB.n(descriptor2, 4, intSerializer, null);
            Float f5 = (Float) compositeDecoderB.n(descriptor2, 5, FloatSerializer.f142814a, null);
            ColorScheme colorScheme2 = (ColorScheme) compositeDecoderB.n(descriptor2, 6, ColorScheme$$serializer.INSTANCE, null);
            Background background2 = (Background) compositeDecoderB.n(descriptor2, 7, BackgroundDeserializer.INSTANCE, null);
            Padding$$serializer padding$$serializer = Padding$$serializer.INSTANCE;
            Padding padding3 = (Padding) compositeDecoderB.n(descriptor2, 8, padding$$serializer, null);
            Padding padding4 = (Padding) compositeDecoderB.n(descriptor2, 9, padding$$serializer, null);
            Shape shape2 = (Shape) compositeDecoderB.n(descriptor2, 10, ShapeDeserializer.INSTANCE, null);
            Border border2 = (Border) compositeDecoderB.n(descriptor2, 11, Border$$serializer.INSTANCE, null);
            Shadow shadow2 = (Shadow) compositeDecoderB.n(descriptor2, 12, Shadow$$serializer.INSTANCE, null);
            CarouselComponent.PageControl pageControl3 = (CarouselComponent.PageControl) compositeDecoderB.n(descriptor2, 13, CarouselComponent$PageControl$$serializer.INSTANCE, null);
            Boolean bool4 = (Boolean) compositeDecoderB.n(descriptor2, 14, booleanSerializer, null);
            i3 = 65535;
            autoAdvancePages = (CarouselComponent.AutoAdvancePages) compositeDecoderB.n(descriptor2, 15, CarouselComponent$AutoAdvancePages$$serializer.INSTANCE, null);
            pageControl = pageControl3;
            num2 = num4;
            bool = bool3;
            num = num5;
            size = size3;
            padding = padding4;
            background = background2;
            colorScheme = colorScheme2;
            f3 = f5;
            shape = shape2;
            padding2 = padding3;
            bool2 = bool4;
            shadow = shadow2;
            border = border2;
            verticalAlignment = verticalAlignment2;
        } else {
            boolean z2 = true;
            CarouselComponent.PageControl pageControl4 = null;
            Float f6 = null;
            Integer num6 = null;
            Boolean bool5 = null;
            CarouselComponent.AutoAdvancePages autoAdvancePages2 = null;
            Shadow shadow3 = null;
            Shape shape3 = null;
            Padding padding5 = null;
            Padding padding6 = null;
            ColorScheme colorScheme3 = null;
            Border border3 = null;
            Background background3 = null;
            Boolean bool6 = null;
            Integer num7 = null;
            VerticalAlignment verticalAlignment3 = null;
            i3 = 0;
            Size size4 = null;
            while (z2) {
                Size size5 = size4;
                int iO = compositeDecoderB.o(descriptor2);
                switch (iO) {
                    case -1:
                        pageControl2 = pageControl4;
                        f4 = f6;
                        size2 = size5;
                        z2 = false;
                        size4 = size2;
                        f6 = f4;
                        pageControl4 = pageControl2;
                        break;
                    case 0:
                        pageControl2 = pageControl4;
                        f4 = f6;
                        size2 = size5;
                        bool6 = (Boolean) compositeDecoderB.n(descriptor2, 0, BooleanSerializer.f142767a, bool6);
                        i3 |= 1;
                        num7 = num7;
                        size4 = size2;
                        f6 = f4;
                        pageControl4 = pageControl2;
                        break;
                    case 1:
                        pageControl2 = pageControl4;
                        f4 = f6;
                        size2 = size5;
                        num7 = (Integer) compositeDecoderB.n(descriptor2, 1, IntSerializer.f142823a, num7);
                        i3 |= 2;
                        verticalAlignment3 = verticalAlignment3;
                        size4 = size2;
                        f6 = f4;
                        pageControl4 = pageControl2;
                        break;
                    case 2:
                        pageControl2 = pageControl4;
                        f4 = f6;
                        size2 = size5;
                        verticalAlignment3 = (VerticalAlignment) compositeDecoderB.n(descriptor2, 2, VerticalAlignmentDeserializer.INSTANCE, verticalAlignment3);
                        i3 |= 4;
                        size4 = size2;
                        f6 = f4;
                        pageControl4 = pageControl2;
                        break;
                    case 3:
                        pageControl2 = pageControl4;
                        f4 = f6;
                        size4 = (Size) compositeDecoderB.n(descriptor2, 3, Size$$serializer.INSTANCE, size5);
                        i3 |= 8;
                        f6 = f4;
                        pageControl4 = pageControl2;
                        break;
                    case 4:
                        num6 = (Integer) compositeDecoderB.n(descriptor2, 4, IntSerializer.f142823a, num6);
                        i3 |= 16;
                        pageControl4 = pageControl4;
                        size4 = size5;
                        break;
                    case 5:
                        num3 = num6;
                        f6 = (Float) compositeDecoderB.n(descriptor2, 5, FloatSerializer.f142814a, f6);
                        i3 |= 32;
                        size4 = size5;
                        num6 = num3;
                        break;
                    case 6:
                        num3 = num6;
                        colorScheme3 = (ColorScheme) compositeDecoderB.n(descriptor2, 6, ColorScheme$$serializer.INSTANCE, colorScheme3);
                        i3 |= 64;
                        size4 = size5;
                        num6 = num3;
                        break;
                    case 7:
                        num3 = num6;
                        background3 = (Background) compositeDecoderB.n(descriptor2, 7, BackgroundDeserializer.INSTANCE, background3);
                        i3 |= ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
                        size4 = size5;
                        num6 = num3;
                        break;
                    case 8:
                        num3 = num6;
                        padding6 = (Padding) compositeDecoderB.n(descriptor2, 8, Padding$$serializer.INSTANCE, padding6);
                        i3 |= Function.MAX_NARGS;
                        size4 = size5;
                        num6 = num3;
                        break;
                    case 9:
                        num3 = num6;
                        padding5 = (Padding) compositeDecoderB.n(descriptor2, 9, Padding$$serializer.INSTANCE, padding5);
                        i3 |= 512;
                        size4 = size5;
                        num6 = num3;
                        break;
                    case 10:
                        num3 = num6;
                        shape3 = (Shape) compositeDecoderB.n(descriptor2, 10, ShapeDeserializer.INSTANCE, shape3);
                        i3 |= 1024;
                        size4 = size5;
                        num6 = num3;
                        break;
                    case 11:
                        num3 = num6;
                        border3 = (Border) compositeDecoderB.n(descriptor2, 11, Border$$serializer.INSTANCE, border3);
                        i3 |= 2048;
                        size4 = size5;
                        num6 = num3;
                        break;
                    case 12:
                        num3 = num6;
                        shadow3 = (Shadow) compositeDecoderB.n(descriptor2, 12, Shadow$$serializer.INSTANCE, shadow3);
                        i3 |= 4096;
                        size4 = size5;
                        num6 = num3;
                        break;
                    case 13:
                        num3 = num6;
                        pageControl4 = (CarouselComponent.PageControl) compositeDecoderB.n(descriptor2, 13, CarouselComponent$PageControl$$serializer.INSTANCE, pageControl4);
                        i3 |= Utility.DEFAULT_STREAM_BUFFER_SIZE;
                        size4 = size5;
                        num6 = num3;
                        break;
                    case 14:
                        num3 = num6;
                        bool5 = (Boolean) compositeDecoderB.n(descriptor2, 14, BooleanSerializer.f142767a, bool5);
                        i3 |= 16384;
                        size4 = size5;
                        num6 = num3;
                        break;
                    case 15:
                        num3 = num6;
                        autoAdvancePages2 = (CarouselComponent.AutoAdvancePages) compositeDecoderB.n(descriptor2, 15, CarouselComponent$AutoAdvancePages$$serializer.INSTANCE, autoAdvancePages2);
                        i3 |= 32768;
                        size4 = size5;
                        num6 = num3;
                        break;
                    default:
                        throw new UnknownFieldException(iO);
                }
            }
            bool = bool6;
            num = num6;
            bool2 = bool5;
            autoAdvancePages = autoAdvancePages2;
            shadow = shadow3;
            shape = shape3;
            padding = padding5;
            padding2 = padding6;
            colorScheme = colorScheme3;
            border = border3;
            background = background3;
            num2 = num7;
            verticalAlignment = verticalAlignment3;
            size = size4;
            f3 = f6;
            pageControl = pageControl4;
        }
        int i4 = i3;
        compositeDecoderB.c(descriptor2);
        return new PartialCarouselComponent(i4, bool, num2, verticalAlignment, size, num, f3, colorScheme, background, padding2, padding, shape, border, shadow, pageControl, bool2, autoAdvancePages, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, PartialCarouselComponent value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderB = encoder.b(descriptor2);
        PartialCarouselComponent.write$Self$purchases_defaultsBc8Release(value, compositeEncoderB, descriptor2);
        compositeEncoderB.c(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
