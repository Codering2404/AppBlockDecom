package com.revenuecat.purchases.paywalls.components;

import com.facebook.internal.NativeProtocol;
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
import java.util.List;
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
/* JADX INFO: loaded from: classes6.dex */
@Metadata
@Deprecated
public final class CarouselComponent$$serializer implements GeneratedSerializer<CarouselComponent> {
    public static final CarouselComponent$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        CarouselComponent$$serializer carouselComponent$$serializer = new CarouselComponent$$serializer();
        INSTANCE = carouselComponent$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("carousel", carouselComponent$$serializer, 19);
        pluginGeneratedSerialDescriptor.p("pages", false);
        pluginGeneratedSerialDescriptor.p("visible", true);
        pluginGeneratedSerialDescriptor.p("initial_page_index", true);
        pluginGeneratedSerialDescriptor.p("page_alignment", false);
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
        pluginGeneratedSerialDescriptor.p("overrides", true);
        pluginGeneratedSerialDescriptor.p("name", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private CarouselComponent$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr = CarouselComponent.$childSerializers;
        KSerializer<?> kSerializer = kSerializerArr[0];
        BooleanSerializer booleanSerializer = BooleanSerializer.f142767a;
        KSerializer<?> kSerializerU = BuiltinSerializersKt.u(booleanSerializer);
        IntSerializer intSerializer = IntSerializer.f142823a;
        KSerializer<?> kSerializerU2 = BuiltinSerializersKt.u(intSerializer);
        KSerializer<?> kSerializerU3 = BuiltinSerializersKt.u(intSerializer);
        KSerializer<?> kSerializerU4 = BuiltinSerializersKt.u(FloatSerializer.f142814a);
        KSerializer<?> kSerializerU5 = BuiltinSerializersKt.u(ColorScheme$$serializer.INSTANCE);
        KSerializer<?> kSerializerU6 = BuiltinSerializersKt.u(BackgroundDeserializer.INSTANCE);
        KSerializer<?> kSerializerU7 = BuiltinSerializersKt.u(ShapeDeserializer.INSTANCE);
        KSerializer<?> kSerializerU8 = BuiltinSerializersKt.u(Border$$serializer.INSTANCE);
        KSerializer<?> kSerializerU9 = BuiltinSerializersKt.u(Shadow$$serializer.INSTANCE);
        KSerializer<?> kSerializerU10 = BuiltinSerializersKt.u(CarouselComponent$PageControl$$serializer.INSTANCE);
        KSerializer<?> kSerializerU11 = BuiltinSerializersKt.u(booleanSerializer);
        KSerializer<?> kSerializerU12 = BuiltinSerializersKt.u(CarouselComponent$AutoAdvancePages$$serializer.INSTANCE);
        KSerializer<?> kSerializer2 = kSerializerArr[17];
        KSerializer<?> kSerializerU13 = BuiltinSerializersKt.u(StringSerializer.f142891a);
        Padding$$serializer padding$$serializer = Padding$$serializer.INSTANCE;
        return new KSerializer[]{kSerializer, kSerializerU, kSerializerU2, VerticalAlignmentDeserializer.INSTANCE, Size$$serializer.INSTANCE, kSerializerU3, kSerializerU4, kSerializerU5, kSerializerU6, padding$$serializer, padding$$serializer, kSerializerU7, kSerializerU8, kSerializerU9, kSerializerU10, kSerializerU11, kSerializerU12, kSerializer2, kSerializerU13};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public CarouselComponent deserialize(Decoder decoder) {
        int i3;
        List list;
        Border border;
        Background background;
        ColorScheme colorScheme;
        String str;
        List list2;
        Boolean bool;
        CarouselComponent.AutoAdvancePages autoAdvancePages;
        Shape shape;
        Padding padding;
        Padding padding2;
        Boolean bool2;
        Integer num;
        VerticalAlignment verticalAlignment;
        Size size;
        Integer num2;
        Float f3;
        CarouselComponent.PageControl pageControl;
        Shadow shadow;
        ColorScheme colorScheme2;
        int i4;
        CarouselComponent.PageControl pageControl2;
        Shadow shadow2;
        CarouselComponent.PageControl pageControl3;
        Float f4;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderB = decoder.b(descriptor2);
        KSerializer[] kSerializerArr = CarouselComponent.$childSerializers;
        if (compositeDecoderB.p()) {
            List list3 = (List) compositeDecoderB.y(descriptor2, 0, kSerializerArr[0], null);
            BooleanSerializer booleanSerializer = BooleanSerializer.f142767a;
            Boolean bool3 = (Boolean) compositeDecoderB.n(descriptor2, 1, booleanSerializer, null);
            IntSerializer intSerializer = IntSerializer.f142823a;
            Integer num3 = (Integer) compositeDecoderB.n(descriptor2, 2, intSerializer, null);
            VerticalAlignment verticalAlignment2 = (VerticalAlignment) compositeDecoderB.y(descriptor2, 3, VerticalAlignmentDeserializer.INSTANCE, null);
            Size size2 = (Size) compositeDecoderB.y(descriptor2, 4, Size$$serializer.INSTANCE, null);
            Integer num4 = (Integer) compositeDecoderB.n(descriptor2, 5, intSerializer, null);
            Float f5 = (Float) compositeDecoderB.n(descriptor2, 6, FloatSerializer.f142814a, null);
            ColorScheme colorScheme3 = (ColorScheme) compositeDecoderB.n(descriptor2, 7, ColorScheme$$serializer.INSTANCE, null);
            Background background2 = (Background) compositeDecoderB.n(descriptor2, 8, BackgroundDeserializer.INSTANCE, null);
            Padding$$serializer padding$$serializer = Padding$$serializer.INSTANCE;
            Padding padding3 = (Padding) compositeDecoderB.y(descriptor2, 9, padding$$serializer, null);
            Padding padding4 = (Padding) compositeDecoderB.y(descriptor2, 10, padding$$serializer, null);
            Shape shape2 = (Shape) compositeDecoderB.n(descriptor2, 11, ShapeDeserializer.INSTANCE, null);
            Border border2 = (Border) compositeDecoderB.n(descriptor2, 12, Border$$serializer.INSTANCE, null);
            Shadow shadow3 = (Shadow) compositeDecoderB.n(descriptor2, 13, Shadow$$serializer.INSTANCE, null);
            CarouselComponent.PageControl pageControl4 = (CarouselComponent.PageControl) compositeDecoderB.n(descriptor2, 14, CarouselComponent$PageControl$$serializer.INSTANCE, null);
            Boolean bool4 = (Boolean) compositeDecoderB.n(descriptor2, 15, booleanSerializer, null);
            CarouselComponent.AutoAdvancePages autoAdvancePages2 = (CarouselComponent.AutoAdvancePages) compositeDecoderB.n(descriptor2, 16, CarouselComponent$AutoAdvancePages$$serializer.INSTANCE, null);
            List list4 = (List) compositeDecoderB.y(descriptor2, 17, kSerializerArr[17], null);
            i3 = 524287;
            str = (String) compositeDecoderB.n(descriptor2, 18, StringSerializer.f142891a, null);
            list = list3;
            background = background2;
            size = size2;
            num = num3;
            bool2 = bool3;
            bool = bool4;
            num2 = num4;
            verticalAlignment = verticalAlignment2;
            colorScheme = colorScheme3;
            f3 = f5;
            padding2 = padding3;
            autoAdvancePages = autoAdvancePages2;
            pageControl = pageControl4;
            list2 = list4;
            shadow = shadow3;
            border = border2;
            shape = shape2;
            padding = padding4;
        } else {
            int i5 = 1;
            int i6 = 0;
            Shadow shadow4 = null;
            CarouselComponent.PageControl pageControl5 = null;
            Border border3 = null;
            Background background3 = null;
            Float f6 = null;
            String str2 = null;
            Boolean bool5 = null;
            CarouselComponent.AutoAdvancePages autoAdvancePages3 = null;
            Shape shape3 = null;
            Padding padding5 = null;
            Padding padding6 = null;
            ColorScheme colorScheme4 = null;
            List list5 = null;
            Boolean bool6 = null;
            Integer num5 = null;
            VerticalAlignment verticalAlignment3 = null;
            Size size3 = null;
            Integer num6 = null;
            i3 = 0;
            List list6 = null;
            while (i5 != 0) {
                Float f7 = f6;
                int iO = compositeDecoderB.o(descriptor2);
                switch (iO) {
                    case -1:
                        pageControl2 = pageControl5;
                        i5 = i6;
                        f6 = f7;
                        shadow4 = shadow4;
                        i6 = i5;
                        pageControl5 = pageControl2;
                        break;
                    case 0:
                        Shadow shadow5 = shadow4;
                        pageControl2 = pageControl5;
                        ColorScheme colorScheme5 = colorScheme4;
                        KSerializer kSerializer = kSerializerArr[i6];
                        int i7 = i6;
                        list5 = (List) compositeDecoderB.y(descriptor2, i7, kSerializer, list5);
                        i3 |= 1;
                        colorScheme4 = colorScheme5;
                        bool6 = bool6;
                        f6 = f7;
                        shadow4 = shadow5;
                        i6 = i7;
                        pageControl5 = pageControl2;
                        break;
                    case 1:
                        shadow2 = shadow4;
                        pageControl3 = pageControl5;
                        f4 = f7;
                        bool6 = (Boolean) compositeDecoderB.n(descriptor2, 1, BooleanSerializer.f142767a, bool6);
                        i3 |= 2;
                        colorScheme4 = colorScheme4;
                        num5 = num5;
                        f6 = f4;
                        pageControl5 = pageControl3;
                        shadow4 = shadow2;
                        break;
                    case 2:
                        shadow2 = shadow4;
                        pageControl3 = pageControl5;
                        f4 = f7;
                        num5 = (Integer) compositeDecoderB.n(descriptor2, 2, IntSerializer.f142823a, num5);
                        i3 |= 4;
                        colorScheme4 = colorScheme4;
                        verticalAlignment3 = verticalAlignment3;
                        f6 = f4;
                        pageControl5 = pageControl3;
                        shadow4 = shadow2;
                        break;
                    case 3:
                        shadow2 = shadow4;
                        pageControl3 = pageControl5;
                        f4 = f7;
                        verticalAlignment3 = (VerticalAlignment) compositeDecoderB.y(descriptor2, 3, VerticalAlignmentDeserializer.INSTANCE, verticalAlignment3);
                        i3 |= 8;
                        colorScheme4 = colorScheme4;
                        size3 = size3;
                        f6 = f4;
                        pageControl5 = pageControl3;
                        shadow4 = shadow2;
                        break;
                    case 4:
                        shadow2 = shadow4;
                        pageControl3 = pageControl5;
                        f4 = f7;
                        size3 = (Size) compositeDecoderB.y(descriptor2, 4, Size$$serializer.INSTANCE, size3);
                        i3 |= 16;
                        colorScheme4 = colorScheme4;
                        num6 = num6;
                        f6 = f4;
                        pageControl5 = pageControl3;
                        shadow4 = shadow2;
                        break;
                    case 5:
                        shadow2 = shadow4;
                        pageControl3 = pageControl5;
                        f4 = f7;
                        num6 = (Integer) compositeDecoderB.n(descriptor2, 5, IntSerializer.f142823a, num6);
                        i3 |= 32;
                        colorScheme4 = colorScheme4;
                        f6 = f4;
                        pageControl5 = pageControl3;
                        shadow4 = shadow2;
                        break;
                    case 6:
                        shadow2 = shadow4;
                        i3 |= 64;
                        colorScheme4 = colorScheme4;
                        pageControl5 = pageControl5;
                        f6 = (Float) compositeDecoderB.n(descriptor2, 6, FloatSerializer.f142814a, f7);
                        shadow4 = shadow2;
                        break;
                    case 7:
                        colorScheme4 = (ColorScheme) compositeDecoderB.n(descriptor2, 7, ColorScheme$$serializer.INSTANCE, colorScheme4);
                        i3 |= ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
                        shadow4 = shadow4;
                        f6 = f7;
                        break;
                    case 8:
                        colorScheme2 = colorScheme4;
                        background3 = (Background) compositeDecoderB.n(descriptor2, 8, BackgroundDeserializer.INSTANCE, background3);
                        i3 |= Function.MAX_NARGS;
                        f6 = f7;
                        colorScheme4 = colorScheme2;
                        break;
                    case 9:
                        colorScheme2 = colorScheme4;
                        padding6 = (Padding) compositeDecoderB.y(descriptor2, 9, Padding$$serializer.INSTANCE, padding6);
                        i3 |= 512;
                        f6 = f7;
                        colorScheme4 = colorScheme2;
                        break;
                    case 10:
                        colorScheme2 = colorScheme4;
                        padding5 = (Padding) compositeDecoderB.y(descriptor2, 10, Padding$$serializer.INSTANCE, padding5);
                        i3 |= 1024;
                        f6 = f7;
                        colorScheme4 = colorScheme2;
                        break;
                    case 11:
                        colorScheme2 = colorScheme4;
                        shape3 = (Shape) compositeDecoderB.n(descriptor2, 11, ShapeDeserializer.INSTANCE, shape3);
                        i3 |= 2048;
                        f6 = f7;
                        colorScheme4 = colorScheme2;
                        break;
                    case 12:
                        colorScheme2 = colorScheme4;
                        border3 = (Border) compositeDecoderB.n(descriptor2, 12, Border$$serializer.INSTANCE, border3);
                        i3 |= 4096;
                        f6 = f7;
                        colorScheme4 = colorScheme2;
                        break;
                    case 13:
                        colorScheme2 = colorScheme4;
                        shadow4 = (Shadow) compositeDecoderB.n(descriptor2, 13, Shadow$$serializer.INSTANCE, shadow4);
                        i3 |= Utility.DEFAULT_STREAM_BUFFER_SIZE;
                        f6 = f7;
                        colorScheme4 = colorScheme2;
                        break;
                    case 14:
                        colorScheme2 = colorScheme4;
                        pageControl5 = (CarouselComponent.PageControl) compositeDecoderB.n(descriptor2, 14, CarouselComponent$PageControl$$serializer.INSTANCE, pageControl5);
                        i3 |= 16384;
                        f6 = f7;
                        colorScheme4 = colorScheme2;
                        break;
                    case 15:
                        colorScheme2 = colorScheme4;
                        bool5 = (Boolean) compositeDecoderB.n(descriptor2, 15, BooleanSerializer.f142767a, bool5);
                        i4 = 32768;
                        i3 |= i4;
                        f6 = f7;
                        colorScheme4 = colorScheme2;
                        break;
                    case 16:
                        colorScheme2 = colorScheme4;
                        autoAdvancePages3 = (CarouselComponent.AutoAdvancePages) compositeDecoderB.n(descriptor2, 16, CarouselComponent$AutoAdvancePages$$serializer.INSTANCE, autoAdvancePages3);
                        i4 = NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
                        i3 |= i4;
                        f6 = f7;
                        colorScheme4 = colorScheme2;
                        break;
                    case 17:
                        colorScheme2 = colorScheme4;
                        list6 = (List) compositeDecoderB.y(descriptor2, 17, kSerializerArr[17], list6);
                        i4 = 131072;
                        i3 |= i4;
                        f6 = f7;
                        colorScheme4 = colorScheme2;
                        break;
                    case 18:
                        colorScheme2 = colorScheme4;
                        str2 = (String) compositeDecoderB.n(descriptor2, 18, StringSerializer.f142891a, str2);
                        i3 |= 262144;
                        f6 = f7;
                        colorScheme4 = colorScheme2;
                        break;
                    default:
                        throw new UnknownFieldException(iO);
                }
            }
            list = list5;
            border = border3;
            background = background3;
            colorScheme = colorScheme4;
            str = str2;
            list2 = list6;
            bool = bool5;
            autoAdvancePages = autoAdvancePages3;
            shape = shape3;
            padding = padding5;
            padding2 = padding6;
            bool2 = bool6;
            num = num5;
            verticalAlignment = verticalAlignment3;
            size = size3;
            num2 = num6;
            f3 = f6;
            pageControl = pageControl5;
            shadow = shadow4;
        }
        int i8 = i3;
        compositeDecoderB.c(descriptor2);
        return new CarouselComponent(i8, list, bool2, num, verticalAlignment, size, num2, f3, colorScheme, background, padding2, padding, shape, border, shadow, pageControl, bool, autoAdvancePages, list2, str, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, CarouselComponent value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderB = encoder.b(descriptor2);
        CarouselComponent.write$Self$purchases_defaultsBc8Release(value, compositeEncoderB, descriptor2);
        compositeEncoderB.c(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
