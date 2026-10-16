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
public final class PartialStackComponent$$serializer implements GeneratedSerializer<PartialStackComponent> {
    public static final PartialStackComponent$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        PartialStackComponent$$serializer partialStackComponent$$serializer = new PartialStackComponent$$serializer();
        INSTANCE = partialStackComponent$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.paywalls.components.PartialStackComponent", partialStackComponent$$serializer, 14);
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
        pluginGeneratedSerialDescriptor.p("name", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private PartialStackComponent$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        KSerializer[] kSerializerArr = PartialStackComponent.$childSerializers;
        KSerializer<?> kSerializerU = BuiltinSerializersKt.u(BooleanSerializer.f142767a);
        KSerializer<?> kSerializerU2 = BuiltinSerializersKt.u(kSerializerArr[1]);
        KSerializer<?> kSerializerU3 = BuiltinSerializersKt.u(Size$$serializer.INSTANCE);
        KSerializer<?> kSerializerU4 = BuiltinSerializersKt.u(FloatSerializer.f142814a);
        KSerializer<?> kSerializerU5 = BuiltinSerializersKt.u(ColorScheme$$serializer.INSTANCE);
        KSerializer<?> kSerializerU6 = BuiltinSerializersKt.u(BackgroundDeserializer.INSTANCE);
        Padding$$serializer padding$$serializer = Padding$$serializer.INSTANCE;
        return new KSerializer[]{kSerializerU, kSerializerU2, kSerializerU3, kSerializerU4, kSerializerU5, kSerializerU6, BuiltinSerializersKt.u(padding$$serializer), BuiltinSerializersKt.u(padding$$serializer), BuiltinSerializersKt.u(ShapeDeserializer.INSTANCE), BuiltinSerializersKt.u(Border$$serializer.INSTANCE), BuiltinSerializersKt.u(Shadow$$serializer.INSTANCE), BuiltinSerializersKt.u(Badge$$serializer.INSTANCE), BuiltinSerializersKt.u(StackOverflowDeserializer.INSTANCE), BuiltinSerializersKt.u(StringSerializer.f142891a)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public PartialStackComponent deserialize(Decoder decoder) {
        Size size;
        ColorScheme colorScheme;
        int i3;
        Boolean bool;
        Badge badge;
        Shadow shadow;
        Shape shape;
        Padding padding;
        Padding padding2;
        Border border;
        Background background;
        Float f3;
        Dimension dimension;
        String str;
        StackComponent.Overflow overflow;
        Size size2;
        StackComponent.Overflow overflow2;
        String str2;
        Dimension dimension2;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderB = decoder.b(descriptor2);
        KSerializer[] kSerializerArr = PartialStackComponent.$childSerializers;
        if (compositeDecoderB.p()) {
            bool = (Boolean) compositeDecoderB.n(descriptor2, 0, BooleanSerializer.f142767a, null);
            Dimension dimension3 = (Dimension) compositeDecoderB.n(descriptor2, 1, kSerializerArr[1], null);
            size = (Size) compositeDecoderB.n(descriptor2, 2, Size$$serializer.INSTANCE, null);
            Float f4 = (Float) compositeDecoderB.n(descriptor2, 3, FloatSerializer.f142814a, null);
            colorScheme = (ColorScheme) compositeDecoderB.n(descriptor2, 4, ColorScheme$$serializer.INSTANCE, null);
            Background background2 = (Background) compositeDecoderB.n(descriptor2, 5, BackgroundDeserializer.INSTANCE, null);
            Padding$$serializer padding$$serializer = Padding$$serializer.INSTANCE;
            Padding padding3 = (Padding) compositeDecoderB.n(descriptor2, 6, padding$$serializer, null);
            Padding padding4 = (Padding) compositeDecoderB.n(descriptor2, 7, padding$$serializer, null);
            Shape shape2 = (Shape) compositeDecoderB.n(descriptor2, 8, ShapeDeserializer.INSTANCE, null);
            Border border2 = (Border) compositeDecoderB.n(descriptor2, 9, Border$$serializer.INSTANCE, null);
            Shadow shadow2 = (Shadow) compositeDecoderB.n(descriptor2, 10, Shadow$$serializer.INSTANCE, null);
            Badge badge2 = (Badge) compositeDecoderB.n(descriptor2, 11, Badge$$serializer.INSTANCE, null);
            StackComponent.Overflow overflow3 = (StackComponent.Overflow) compositeDecoderB.n(descriptor2, 12, StackOverflowDeserializer.INSTANCE, null);
            i3 = 16383;
            str = (String) compositeDecoderB.n(descriptor2, 13, StringSerializer.f142891a, null);
            f3 = f4;
            shadow = shadow2;
            border = border2;
            padding = padding4;
            padding2 = padding3;
            background = background2;
            shape = shape2;
            badge = badge2;
            overflow = overflow3;
            dimension = dimension3;
        } else {
            int i4 = 1;
            boolean z2 = true;
            StackComponent.Overflow overflow4 = null;
            String str3 = null;
            size = null;
            Badge badge3 = null;
            Shadow shadow3 = null;
            Shape shape3 = null;
            Padding padding5 = null;
            Padding padding6 = null;
            colorScheme = null;
            Border border3 = null;
            Background background3 = null;
            Float f5 = null;
            Boolean bool2 = null;
            i3 = 0;
            Dimension dimension4 = null;
            while (z2) {
                Dimension dimension5 = dimension4;
                int iO = compositeDecoderB.o(descriptor2);
                switch (iO) {
                    case -1:
                        overflow2 = overflow4;
                        str2 = str3;
                        dimension2 = dimension5;
                        z2 = false;
                        dimension4 = dimension2;
                        str3 = str2;
                        overflow4 = overflow2;
                        i4 = 1;
                        break;
                    case 0:
                        str2 = str3;
                        overflow2 = overflow4;
                        dimension2 = dimension5;
                        bool2 = (Boolean) compositeDecoderB.n(descriptor2, 0, BooleanSerializer.f142767a, bool2);
                        i3 |= 1;
                        dimension4 = dimension2;
                        str3 = str2;
                        overflow4 = overflow2;
                        i4 = 1;
                        break;
                    case 1:
                        StackComponent.Overflow overflow5 = overflow4;
                        KSerializer kSerializer = kSerializerArr[i4];
                        int i5 = i4;
                        dimension4 = (Dimension) compositeDecoderB.n(descriptor2, i5, kSerializer, dimension5);
                        i3 |= 2;
                        i4 = i5;
                        str3 = str3;
                        overflow4 = overflow5;
                        break;
                    case 2:
                        size = (Size) compositeDecoderB.n(descriptor2, 2, Size$$serializer.INSTANCE, size);
                        i3 |= 4;
                        overflow4 = overflow4;
                        dimension4 = dimension5;
                        break;
                    case 3:
                        size2 = size;
                        f5 = (Float) compositeDecoderB.n(descriptor2, 3, FloatSerializer.f142814a, f5);
                        i3 |= 8;
                        dimension4 = dimension5;
                        size = size2;
                        break;
                    case 4:
                        size2 = size;
                        colorScheme = (ColorScheme) compositeDecoderB.n(descriptor2, 4, ColorScheme$$serializer.INSTANCE, colorScheme);
                        i3 |= 16;
                        dimension4 = dimension5;
                        size = size2;
                        break;
                    case 5:
                        size2 = size;
                        background3 = (Background) compositeDecoderB.n(descriptor2, 5, BackgroundDeserializer.INSTANCE, background3);
                        i3 |= 32;
                        dimension4 = dimension5;
                        size = size2;
                        break;
                    case 6:
                        size2 = size;
                        padding6 = (Padding) compositeDecoderB.n(descriptor2, 6, Padding$$serializer.INSTANCE, padding6);
                        i3 |= 64;
                        dimension4 = dimension5;
                        size = size2;
                        break;
                    case 7:
                        size2 = size;
                        padding5 = (Padding) compositeDecoderB.n(descriptor2, 7, Padding$$serializer.INSTANCE, padding5);
                        i3 |= ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
                        dimension4 = dimension5;
                        size = size2;
                        break;
                    case 8:
                        size2 = size;
                        shape3 = (Shape) compositeDecoderB.n(descriptor2, 8, ShapeDeserializer.INSTANCE, shape3);
                        i3 |= Function.MAX_NARGS;
                        dimension4 = dimension5;
                        size = size2;
                        break;
                    case 9:
                        size2 = size;
                        border3 = (Border) compositeDecoderB.n(descriptor2, 9, Border$$serializer.INSTANCE, border3);
                        i3 |= 512;
                        dimension4 = dimension5;
                        size = size2;
                        break;
                    case 10:
                        size2 = size;
                        shadow3 = (Shadow) compositeDecoderB.n(descriptor2, 10, Shadow$$serializer.INSTANCE, shadow3);
                        i3 |= 1024;
                        dimension4 = dimension5;
                        size = size2;
                        break;
                    case 11:
                        size2 = size;
                        badge3 = (Badge) compositeDecoderB.n(descriptor2, 11, Badge$$serializer.INSTANCE, badge3);
                        i3 |= 2048;
                        dimension4 = dimension5;
                        size = size2;
                        break;
                    case 12:
                        size2 = size;
                        overflow4 = (StackComponent.Overflow) compositeDecoderB.n(descriptor2, 12, StackOverflowDeserializer.INSTANCE, overflow4);
                        i3 |= 4096;
                        dimension4 = dimension5;
                        size = size2;
                        break;
                    case 13:
                        size2 = size;
                        str3 = (String) compositeDecoderB.n(descriptor2, 13, StringSerializer.f142891a, str3);
                        i3 |= Utility.DEFAULT_STREAM_BUFFER_SIZE;
                        dimension4 = dimension5;
                        size = size2;
                        break;
                    default:
                        throw new UnknownFieldException(iO);
                }
            }
            String str4 = str3;
            bool = bool2;
            badge = badge3;
            shadow = shadow3;
            shape = shape3;
            padding = padding5;
            padding2 = padding6;
            border = border3;
            background = background3;
            f3 = f5;
            dimension = dimension4;
            str = str4;
            overflow = overflow4;
        }
        Boolean bool3 = bool;
        Size size3 = size;
        int i6 = i3;
        ColorScheme colorScheme2 = colorScheme;
        compositeDecoderB.c(descriptor2);
        return new PartialStackComponent(i6, bool3, dimension, size3, f3, colorScheme2, background, padding2, padding, shape, border, shadow, badge, overflow, str, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, PartialStackComponent value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderB = encoder.b(descriptor2);
        PartialStackComponent.write$Self$purchases_defaultsBc8Release(value, compositeEncoderB, descriptor2);
        compositeEncoderB.c(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
