package com.revenuecat.purchases.paywalls.components;

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
public final class PartialTabsComponent$$serializer implements GeneratedSerializer<PartialTabsComponent> {
    public static final PartialTabsComponent$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        PartialTabsComponent$$serializer partialTabsComponent$$serializer = new PartialTabsComponent$$serializer();
        INSTANCE = partialTabsComponent$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.paywalls.components.PartialTabsComponent", partialTabsComponent$$serializer, 9);
        pluginGeneratedSerialDescriptor.p("visible", true);
        pluginGeneratedSerialDescriptor.p("size", true);
        pluginGeneratedSerialDescriptor.p("padding", true);
        pluginGeneratedSerialDescriptor.p("margin", true);
        pluginGeneratedSerialDescriptor.p("background_color", true);
        pluginGeneratedSerialDescriptor.p("background", true);
        pluginGeneratedSerialDescriptor.p("shape", true);
        pluginGeneratedSerialDescriptor.p("border", true);
        pluginGeneratedSerialDescriptor.p("shadow", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private PartialTabsComponent$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        KSerializer<?> kSerializerU = BuiltinSerializersKt.u(BooleanSerializer.f142767a);
        KSerializer<?> kSerializerU2 = BuiltinSerializersKt.u(Size$$serializer.INSTANCE);
        Padding$$serializer padding$$serializer = Padding$$serializer.INSTANCE;
        return new KSerializer[]{kSerializerU, kSerializerU2, BuiltinSerializersKt.u(padding$$serializer), BuiltinSerializersKt.u(padding$$serializer), BuiltinSerializersKt.u(ColorScheme$$serializer.INSTANCE), BuiltinSerializersKt.u(BackgroundDeserializer.INSTANCE), BuiltinSerializersKt.u(ShapeDeserializer.INSTANCE), BuiltinSerializersKt.u(Border$$serializer.INSTANCE), BuiltinSerializersKt.u(Shadow$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public PartialTabsComponent deserialize(Decoder decoder) {
        int i3;
        Border border;
        Shadow shadow;
        Shape shape;
        Background background;
        ColorScheme colorScheme;
        Boolean bool;
        Size size;
        Padding padding;
        Padding padding2;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderB = decoder.b(descriptor2);
        int i4 = 7;
        Boolean bool2 = null;
        if (compositeDecoderB.p()) {
            Boolean bool3 = (Boolean) compositeDecoderB.n(descriptor2, 0, BooleanSerializer.f142767a, null);
            Size size2 = (Size) compositeDecoderB.n(descriptor2, 1, Size$$serializer.INSTANCE, null);
            Padding$$serializer padding$$serializer = Padding$$serializer.INSTANCE;
            Padding padding3 = (Padding) compositeDecoderB.n(descriptor2, 2, padding$$serializer, null);
            Padding padding4 = (Padding) compositeDecoderB.n(descriptor2, 3, padding$$serializer, null);
            ColorScheme colorScheme2 = (ColorScheme) compositeDecoderB.n(descriptor2, 4, ColorScheme$$serializer.INSTANCE, null);
            Background background2 = (Background) compositeDecoderB.n(descriptor2, 5, BackgroundDeserializer.INSTANCE, null);
            Shape shape2 = (Shape) compositeDecoderB.n(descriptor2, 6, ShapeDeserializer.INSTANCE, null);
            bool = bool3;
            border = (Border) compositeDecoderB.n(descriptor2, 7, Border$$serializer.INSTANCE, null);
            shape = shape2;
            background = background2;
            padding2 = padding4;
            shadow = (Shadow) compositeDecoderB.n(descriptor2, 8, Shadow$$serializer.INSTANCE, null);
            colorScheme = colorScheme2;
            padding = padding3;
            size = size2;
            i3 = 511;
        } else {
            boolean z2 = true;
            int i5 = 0;
            Border border2 = null;
            Shadow shadow2 = null;
            Shape shape3 = null;
            Background background3 = null;
            ColorScheme colorScheme3 = null;
            Size size3 = null;
            Padding padding5 = null;
            Padding padding6 = null;
            while (z2) {
                int iO = compositeDecoderB.o(descriptor2);
                switch (iO) {
                    case -1:
                        z2 = false;
                        i4 = 7;
                        break;
                    case 0:
                        bool2 = (Boolean) compositeDecoderB.n(descriptor2, 0, BooleanSerializer.f142767a, bool2);
                        i5 |= 1;
                        i4 = 7;
                        break;
                    case 1:
                        size3 = (Size) compositeDecoderB.n(descriptor2, 1, Size$$serializer.INSTANCE, size3);
                        i5 |= 2;
                        i4 = 7;
                        break;
                    case 2:
                        padding5 = (Padding) compositeDecoderB.n(descriptor2, 2, Padding$$serializer.INSTANCE, padding5);
                        i5 |= 4;
                        i4 = 7;
                        break;
                    case 3:
                        padding6 = (Padding) compositeDecoderB.n(descriptor2, 3, Padding$$serializer.INSTANCE, padding6);
                        i5 |= 8;
                        i4 = 7;
                        break;
                    case 4:
                        colorScheme3 = (ColorScheme) compositeDecoderB.n(descriptor2, 4, ColorScheme$$serializer.INSTANCE, colorScheme3);
                        i5 |= 16;
                        i4 = 7;
                        break;
                    case 5:
                        background3 = (Background) compositeDecoderB.n(descriptor2, 5, BackgroundDeserializer.INSTANCE, background3);
                        i5 |= 32;
                        i4 = 7;
                        break;
                    case 6:
                        shape3 = (Shape) compositeDecoderB.n(descriptor2, 6, ShapeDeserializer.INSTANCE, shape3);
                        i5 |= 64;
                        break;
                    case 7:
                        border2 = (Border) compositeDecoderB.n(descriptor2, i4, Border$$serializer.INSTANCE, border2);
                        i5 |= ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
                        break;
                    case 8:
                        shadow2 = (Shadow) compositeDecoderB.n(descriptor2, 8, Shadow$$serializer.INSTANCE, shadow2);
                        i5 |= Function.MAX_NARGS;
                        break;
                    default:
                        throw new UnknownFieldException(iO);
                }
            }
            i3 = i5;
            border = border2;
            shadow = shadow2;
            shape = shape3;
            background = background3;
            colorScheme = colorScheme3;
            bool = bool2;
            size = size3;
            padding = padding5;
            padding2 = padding6;
        }
        compositeDecoderB.c(descriptor2);
        return new PartialTabsComponent(i3, bool, size, padding, padding2, colorScheme, background, shape, border, shadow, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, PartialTabsComponent value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderB = encoder.b(descriptor2);
        PartialTabsComponent.write$Self$purchases_defaultsBc8Release(value, compositeEncoderB, descriptor2);
        compositeEncoderB.c(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
