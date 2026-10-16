package com.revenuecat.purchases.paywalls.components;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.paywalls.components.StackComponent;
import com.revenuecat.purchases.paywalls.components.common.Background;
import com.revenuecat.purchases.paywalls.components.common.BackgroundDeserializer;
import com.revenuecat.purchases.paywalls.components.properties.Badge;
import com.revenuecat.purchases.paywalls.components.properties.Badge$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Border;
import com.revenuecat.purchases.paywalls.components.properties.Border$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Dimension;
import com.revenuecat.purchases.paywalls.components.properties.Padding;
import com.revenuecat.purchases.paywalls.components.properties.Padding$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Shadow;
import com.revenuecat.purchases.paywalls.components.properties.Shadow$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Shape;
import com.revenuecat.purchases.paywalls.components.properties.ShapeDeserializer;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.paywalls.components.properties.Size$$serializer;
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
public final class StackComponent$$serializer implements GeneratedSerializer<StackComponent> {
    public static final StackComponent$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        StackComponent$$serializer stackComponent$$serializer = new StackComponent$$serializer();
        INSTANCE = stackComponent$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("stack", stackComponent$$serializer, 16);
        pluginGeneratedSerialDescriptor.p("components", false);
        pluginGeneratedSerialDescriptor.p("visible", true);
        pluginGeneratedSerialDescriptor.p(ViewHierarchyConstants.DIMENSION_KEY, true);
        pluginGeneratedSerialDescriptor.p("size", true);
        pluginGeneratedSerialDescriptor.p("spacing", true);
        pluginGeneratedSerialDescriptor.p("background_color", true);
        pluginGeneratedSerialDescriptor.p("background", true);
        pluginGeneratedSerialDescriptor.p("padding", true);
        pluginGeneratedSerialDescriptor.p("margin", true);
        pluginGeneratedSerialDescriptor.p("shape", true);
        pluginGeneratedSerialDescriptor.p("border", true);
        pluginGeneratedSerialDescriptor.p("shadow", true);
        pluginGeneratedSerialDescriptor.p("badge", true);
        pluginGeneratedSerialDescriptor.p("overflow", true);
        pluginGeneratedSerialDescriptor.p("overrides", true);
        pluginGeneratedSerialDescriptor.p("name", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private StackComponent$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr = StackComponent.$childSerializers;
        KSerializer<?> kSerializer = kSerializerArr[0];
        KSerializer<?> kSerializerU = BuiltinSerializersKt.u(BooleanSerializer.f142767a);
        KSerializer<?> kSerializer2 = kSerializerArr[2];
        KSerializer<?> kSerializerU2 = BuiltinSerializersKt.u(FloatSerializer.f142814a);
        KSerializer<?> kSerializerU3 = BuiltinSerializersKt.u(ColorScheme$$serializer.INSTANCE);
        KSerializer<?> kSerializerU4 = BuiltinSerializersKt.u(BackgroundDeserializer.INSTANCE);
        KSerializer<?> kSerializerU5 = BuiltinSerializersKt.u(ShapeDeserializer.INSTANCE);
        KSerializer<?> kSerializerU6 = BuiltinSerializersKt.u(Border$$serializer.INSTANCE);
        KSerializer<?> kSerializerU7 = BuiltinSerializersKt.u(Shadow$$serializer.INSTANCE);
        KSerializer<?> kSerializerU8 = BuiltinSerializersKt.u(Badge$$serializer.INSTANCE);
        KSerializer<?> kSerializerU9 = BuiltinSerializersKt.u(StackOverflowDeserializer.INSTANCE);
        KSerializer<?> kSerializer3 = kSerializerArr[14];
        KSerializer<?> kSerializerU10 = BuiltinSerializersKt.u(StringSerializer.f142891a);
        Padding$$serializer padding$$serializer = Padding$$serializer.INSTANCE;
        return new KSerializer[]{kSerializer, kSerializerU, kSerializer2, Size$$serializer.INSTANCE, kSerializerU2, kSerializerU3, kSerializerU4, padding$$serializer, padding$$serializer, kSerializerU5, kSerializerU6, kSerializerU7, kSerializerU8, kSerializerU9, kSerializer3, kSerializerU10};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public StackComponent deserialize(Decoder decoder) {
        int i3;
        List list;
        Float f3;
        String str;
        Badge badge;
        Shadow shadow;
        Shape shape;
        Padding padding;
        Padding padding2;
        ColorScheme colorScheme;
        Border border;
        Background background;
        Boolean bool;
        Dimension dimension;
        Size size;
        List list2;
        StackComponent.Overflow overflow;
        Float f4;
        StackComponent.Overflow overflow2;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderB = decoder.b(descriptor2);
        KSerializer[] kSerializerArr = StackComponent.$childSerializers;
        if (compositeDecoderB.p()) {
            list = (List) compositeDecoderB.y(descriptor2, 0, kSerializerArr[0], null);
            Boolean bool2 = (Boolean) compositeDecoderB.n(descriptor2, 1, BooleanSerializer.f142767a, null);
            Dimension dimension2 = (Dimension) compositeDecoderB.y(descriptor2, 2, kSerializerArr[2], null);
            Size size2 = (Size) compositeDecoderB.y(descriptor2, 3, Size$$serializer.INSTANCE, null);
            Float f5 = (Float) compositeDecoderB.n(descriptor2, 4, FloatSerializer.f142814a, null);
            ColorScheme colorScheme2 = (ColorScheme) compositeDecoderB.n(descriptor2, 5, ColorScheme$$serializer.INSTANCE, null);
            Background background2 = (Background) compositeDecoderB.n(descriptor2, 6, BackgroundDeserializer.INSTANCE, null);
            Padding$$serializer padding$$serializer = Padding$$serializer.INSTANCE;
            Padding padding3 = (Padding) compositeDecoderB.y(descriptor2, 7, padding$$serializer, null);
            Padding padding4 = (Padding) compositeDecoderB.y(descriptor2, 8, padding$$serializer, null);
            Shape shape2 = (Shape) compositeDecoderB.n(descriptor2, 9, ShapeDeserializer.INSTANCE, null);
            Border border2 = (Border) compositeDecoderB.n(descriptor2, 10, Border$$serializer.INSTANCE, null);
            Shadow shadow2 = (Shadow) compositeDecoderB.n(descriptor2, 11, Shadow$$serializer.INSTANCE, null);
            Badge badge2 = (Badge) compositeDecoderB.n(descriptor2, 12, Badge$$serializer.INSTANCE, null);
            StackComponent.Overflow overflow3 = (StackComponent.Overflow) compositeDecoderB.n(descriptor2, 13, StackOverflowDeserializer.INSTANCE, null);
            List list3 = (List) compositeDecoderB.y(descriptor2, 14, kSerializerArr[14], null);
            i3 = 65535;
            str = (String) compositeDecoderB.n(descriptor2, 15, StringSerializer.f142891a, null);
            dimension = dimension2;
            bool = bool2;
            size = size2;
            border = border2;
            shape = shape2;
            padding2 = padding3;
            background = background2;
            colorScheme = colorScheme2;
            f3 = f5;
            padding = padding4;
            list2 = list3;
            overflow = overflow3;
            badge = badge2;
            shadow = shadow2;
        } else {
            int i4 = 2;
            int i5 = 1;
            int i6 = 0;
            StackComponent.Overflow overflow4 = null;
            List list4 = null;
            Float f6 = null;
            Size size3 = null;
            Badge badge3 = null;
            Shadow shadow3 = null;
            Shape shape3 = null;
            Padding padding5 = null;
            Padding padding6 = null;
            ColorScheme colorScheme3 = null;
            Border border3 = null;
            Background background3 = null;
            List list5 = null;
            Boolean bool3 = null;
            Dimension dimension3 = null;
            i3 = 0;
            String str2 = null;
            while (i5 != 0) {
                Size size4 = size3;
                int iO = compositeDecoderB.o(descriptor2);
                switch (iO) {
                    case -1:
                        overflow2 = overflow4;
                        i5 = i6;
                        size3 = size4;
                        list4 = list4;
                        i4 = 2;
                        i6 = i5;
                        overflow4 = overflow2;
                        break;
                    case 0:
                        overflow2 = overflow4;
                        List list6 = list4;
                        int i7 = i6;
                        list5 = (List) compositeDecoderB.y(descriptor2, i7, kSerializerArr[i6], list5);
                        i3 |= 1;
                        f6 = f6;
                        bool3 = bool3;
                        size3 = size4;
                        list4 = list6;
                        i4 = 2;
                        i6 = i7;
                        overflow4 = overflow2;
                        break;
                    case 1:
                        bool3 = (Boolean) compositeDecoderB.n(descriptor2, 1, BooleanSerializer.f142767a, bool3);
                        i3 |= 2;
                        f6 = f6;
                        dimension3 = dimension3;
                        size3 = size4;
                        list4 = list4;
                        overflow4 = overflow4;
                        i4 = 2;
                        break;
                    case 2:
                        overflow2 = overflow4;
                        List list7 = list4;
                        int i8 = i4;
                        dimension3 = (Dimension) compositeDecoderB.y(descriptor2, i8, kSerializerArr[i4], dimension3);
                        i3 |= 4;
                        f6 = f6;
                        size3 = size4;
                        list4 = list7;
                        i4 = i8;
                        overflow4 = overflow2;
                        break;
                    case 3:
                        overflow2 = overflow4;
                        i3 |= 8;
                        f6 = f6;
                        list4 = list4;
                        size3 = (Size) compositeDecoderB.y(descriptor2, 3, Size$$serializer.INSTANCE, size4);
                        overflow4 = overflow2;
                        break;
                    case 4:
                        f6 = (Float) compositeDecoderB.n(descriptor2, 4, FloatSerializer.f142814a, f6);
                        i3 |= 16;
                        overflow4 = overflow4;
                        size3 = size4;
                        break;
                    case 5:
                        f4 = f6;
                        colorScheme3 = (ColorScheme) compositeDecoderB.n(descriptor2, 5, ColorScheme$$serializer.INSTANCE, colorScheme3);
                        i3 |= 32;
                        size3 = size4;
                        f6 = f4;
                        break;
                    case 6:
                        f4 = f6;
                        background3 = (Background) compositeDecoderB.n(descriptor2, 6, BackgroundDeserializer.INSTANCE, background3);
                        i3 |= 64;
                        size3 = size4;
                        f6 = f4;
                        break;
                    case 7:
                        f4 = f6;
                        padding6 = (Padding) compositeDecoderB.y(descriptor2, 7, Padding$$serializer.INSTANCE, padding6);
                        i3 |= ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
                        size3 = size4;
                        f6 = f4;
                        break;
                    case 8:
                        f4 = f6;
                        padding5 = (Padding) compositeDecoderB.y(descriptor2, 8, Padding$$serializer.INSTANCE, padding5);
                        i3 |= Function.MAX_NARGS;
                        size3 = size4;
                        f6 = f4;
                        break;
                    case 9:
                        f4 = f6;
                        shape3 = (Shape) compositeDecoderB.n(descriptor2, 9, ShapeDeserializer.INSTANCE, shape3);
                        i3 |= 512;
                        size3 = size4;
                        f6 = f4;
                        break;
                    case 10:
                        f4 = f6;
                        border3 = (Border) compositeDecoderB.n(descriptor2, 10, Border$$serializer.INSTANCE, border3);
                        i3 |= 1024;
                        size3 = size4;
                        f6 = f4;
                        break;
                    case 11:
                        f4 = f6;
                        shadow3 = (Shadow) compositeDecoderB.n(descriptor2, 11, Shadow$$serializer.INSTANCE, shadow3);
                        i3 |= 2048;
                        size3 = size4;
                        f6 = f4;
                        break;
                    case 12:
                        f4 = f6;
                        badge3 = (Badge) compositeDecoderB.n(descriptor2, 12, Badge$$serializer.INSTANCE, badge3);
                        i3 |= 4096;
                        size3 = size4;
                        f6 = f4;
                        break;
                    case 13:
                        f4 = f6;
                        overflow4 = (StackComponent.Overflow) compositeDecoderB.n(descriptor2, 13, StackOverflowDeserializer.INSTANCE, overflow4);
                        i3 |= Utility.DEFAULT_STREAM_BUFFER_SIZE;
                        size3 = size4;
                        f6 = f4;
                        break;
                    case 14:
                        f4 = f6;
                        list4 = (List) compositeDecoderB.y(descriptor2, 14, kSerializerArr[14], list4);
                        i3 |= 16384;
                        size3 = size4;
                        f6 = f4;
                        break;
                    case 15:
                        f4 = f6;
                        str2 = (String) compositeDecoderB.n(descriptor2, 15, StringSerializer.f142891a, str2);
                        i3 |= 32768;
                        size3 = size4;
                        f6 = f4;
                        break;
                    default:
                        throw new UnknownFieldException(iO);
                }
            }
            List list8 = list4;
            list = list5;
            f3 = f6;
            str = str2;
            badge = badge3;
            shadow = shadow3;
            shape = shape3;
            padding = padding5;
            padding2 = padding6;
            colorScheme = colorScheme3;
            border = border3;
            background = background3;
            bool = bool3;
            dimension = dimension3;
            size = size3;
            list2 = list8;
            overflow = overflow4;
        }
        List list9 = list;
        int i9 = i3;
        compositeDecoderB.c(descriptor2);
        return new StackComponent(i9, list9, bool, dimension, size, f3, colorScheme, background, padding2, padding, shape, border, shadow, badge, overflow, list2, str, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, StackComponent value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderB = encoder.b(descriptor2);
        StackComponent.write$Self$purchases_defaultsBc8Release(value, compositeEncoderB, descriptor2);
        compositeEncoderB.c(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
