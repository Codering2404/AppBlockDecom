package com.revenuecat.purchases.paywalls.components;

import com.revenuecat.purchases.paywalls.components.common.LocalizationKey;
import com.revenuecat.purchases.paywalls.components.common.LocalizationKey$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Border;
import com.revenuecat.purchases.paywalls.components.properties.Border$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.FitMode;
import com.revenuecat.purchases.paywalls.components.properties.FitModeDeserializer;
import com.revenuecat.purchases.paywalls.components.properties.MaskShape;
import com.revenuecat.purchases.paywalls.components.properties.MaskShapeDeserializer;
import com.revenuecat.purchases.paywalls.components.properties.Padding;
import com.revenuecat.purchases.paywalls.components.properties.Padding$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Shadow;
import com.revenuecat.purchases.paywalls.components.properties.Shadow$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.paywalls.components.properties.Size$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.ThemeImageUrls;
import com.revenuecat.purchases.paywalls.components.properties.ThemeImageUrls$$serializer;
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
public final class PartialImageComponent$$serializer implements GeneratedSerializer<PartialImageComponent> {
    public static final PartialImageComponent$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        PartialImageComponent$$serializer partialImageComponent$$serializer = new PartialImageComponent$$serializer();
        INSTANCE = partialImageComponent$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.paywalls.components.PartialImageComponent", partialImageComponent$$serializer, 11);
        pluginGeneratedSerialDescriptor.p("visible", true);
        pluginGeneratedSerialDescriptor.p("source", true);
        pluginGeneratedSerialDescriptor.p("size", true);
        pluginGeneratedSerialDescriptor.p("override_source_lid", true);
        pluginGeneratedSerialDescriptor.p("fit_mode", true);
        pluginGeneratedSerialDescriptor.p("mask_shape", true);
        pluginGeneratedSerialDescriptor.p("color_overlay", true);
        pluginGeneratedSerialDescriptor.p("padding", true);
        pluginGeneratedSerialDescriptor.p("margin", true);
        pluginGeneratedSerialDescriptor.p("border", true);
        pluginGeneratedSerialDescriptor.p("shadow", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private PartialImageComponent$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        KSerializer<?> kSerializerU = BuiltinSerializersKt.u(BooleanSerializer.f142767a);
        KSerializer<?> kSerializerU2 = BuiltinSerializersKt.u(ThemeImageUrls$$serializer.INSTANCE);
        KSerializer<?> kSerializerU3 = BuiltinSerializersKt.u(Size$$serializer.INSTANCE);
        KSerializer<?> kSerializerU4 = BuiltinSerializersKt.u(LocalizationKey$$serializer.INSTANCE);
        KSerializer<?> kSerializerU5 = BuiltinSerializersKt.u(FitModeDeserializer.INSTANCE);
        KSerializer<?> kSerializerU6 = BuiltinSerializersKt.u(MaskShapeDeserializer.INSTANCE);
        KSerializer<?> kSerializerU7 = BuiltinSerializersKt.u(ColorScheme$$serializer.INSTANCE);
        Padding$$serializer padding$$serializer = Padding$$serializer.INSTANCE;
        return new KSerializer[]{kSerializerU, kSerializerU2, kSerializerU3, kSerializerU4, kSerializerU5, kSerializerU6, kSerializerU7, BuiltinSerializersKt.u(padding$$serializer), BuiltinSerializersKt.u(padding$$serializer), BuiltinSerializersKt.u(Border$$serializer.INSTANCE), BuiltinSerializersKt.u(Shadow$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public PartialImageComponent deserialize(Decoder decoder) {
        Boolean bool;
        FitMode fitMode;
        ThemeImageUrls themeImageUrls;
        Size size;
        Padding padding;
        int i3;
        MaskShape maskShape;
        ColorScheme colorScheme;
        Padding padding2;
        Border border;
        Shadow shadow;
        String str;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderB = decoder.b(descriptor2);
        int i4 = 10;
        int i5 = 9;
        int i6 = 7;
        int i7 = 6;
        Border border2 = null;
        if (compositeDecoderB.p()) {
            bool = (Boolean) compositeDecoderB.n(descriptor2, 0, BooleanSerializer.f142767a, null);
            ThemeImageUrls themeImageUrls2 = (ThemeImageUrls) compositeDecoderB.n(descriptor2, 1, ThemeImageUrls$$serializer.INSTANCE, null);
            Size size2 = (Size) compositeDecoderB.n(descriptor2, 2, Size$$serializer.INSTANCE, null);
            LocalizationKey localizationKey = (LocalizationKey) compositeDecoderB.n(descriptor2, 3, LocalizationKey$$serializer.INSTANCE, null);
            String strM654unboximpl = localizationKey != null ? localizationKey.m654unboximpl() : null;
            FitMode fitMode2 = (FitMode) compositeDecoderB.n(descriptor2, 4, FitModeDeserializer.INSTANCE, null);
            MaskShape maskShape2 = (MaskShape) compositeDecoderB.n(descriptor2, 5, MaskShapeDeserializer.INSTANCE, null);
            ColorScheme colorScheme2 = (ColorScheme) compositeDecoderB.n(descriptor2, 6, ColorScheme$$serializer.INSTANCE, null);
            Padding$$serializer padding$$serializer = Padding$$serializer.INSTANCE;
            Padding padding3 = (Padding) compositeDecoderB.n(descriptor2, 7, padding$$serializer, null);
            Padding padding4 = (Padding) compositeDecoderB.n(descriptor2, 8, padding$$serializer, null);
            Border border3 = (Border) compositeDecoderB.n(descriptor2, 9, Border$$serializer.INSTANCE, null);
            shadow = (Shadow) compositeDecoderB.n(descriptor2, 10, Shadow$$serializer.INSTANCE, null);
            border = border3;
            padding2 = padding3;
            colorScheme = colorScheme2;
            maskShape = maskShape2;
            str = strM654unboximpl;
            padding = padding4;
            fitMode = fitMode2;
            size = size2;
            themeImageUrls = themeImageUrls2;
            i3 = 2047;
        } else {
            boolean z2 = true;
            int i8 = 0;
            bool = null;
            Padding padding5 = null;
            MaskShape maskShape3 = null;
            ColorScheme colorScheme3 = null;
            Padding padding6 = null;
            Shadow shadow2 = null;
            String strM654unboximpl2 = null;
            FitMode fitMode3 = null;
            Size size3 = null;
            ThemeImageUrls themeImageUrls3 = null;
            while (z2) {
                int iO = compositeDecoderB.o(descriptor2);
                switch (iO) {
                    case -1:
                        z2 = false;
                        i4 = 10;
                        i6 = 7;
                        i7 = 6;
                        break;
                    case 0:
                        bool = (Boolean) compositeDecoderB.n(descriptor2, 0, BooleanSerializer.f142767a, bool);
                        i8 |= 1;
                        i4 = 10;
                        i5 = 9;
                        i6 = 7;
                        i7 = 6;
                        break;
                    case 1:
                        themeImageUrls3 = (ThemeImageUrls) compositeDecoderB.n(descriptor2, 1, ThemeImageUrls$$serializer.INSTANCE, themeImageUrls3);
                        i8 |= 2;
                        i4 = 10;
                        i5 = 9;
                        i6 = 7;
                        i7 = 6;
                        break;
                    case 2:
                        size3 = (Size) compositeDecoderB.n(descriptor2, 2, Size$$serializer.INSTANCE, size3);
                        i8 |= 4;
                        i4 = 10;
                        i5 = 9;
                        i6 = 7;
                        break;
                    case 3:
                        FitMode fitMode4 = fitMode3;
                        LocalizationKey localizationKey2 = (LocalizationKey) compositeDecoderB.n(descriptor2, 3, LocalizationKey$$serializer.INSTANCE, strM654unboximpl2 != null ? LocalizationKey.m648boximpl(strM654unboximpl2) : null);
                        strM654unboximpl2 = localizationKey2 != null ? localizationKey2.m654unboximpl() : null;
                        i8 |= 8;
                        fitMode3 = fitMode4;
                        i4 = 10;
                        i5 = 9;
                        i6 = 7;
                        break;
                    case 4:
                        i8 |= 16;
                        fitMode3 = (FitMode) compositeDecoderB.n(descriptor2, 4, FitModeDeserializer.INSTANCE, fitMode3);
                        i4 = 10;
                        i5 = 9;
                        break;
                    case 5:
                        maskShape3 = (MaskShape) compositeDecoderB.n(descriptor2, 5, MaskShapeDeserializer.INSTANCE, maskShape3);
                        i8 |= 32;
                        i4 = 10;
                        break;
                    case 6:
                        colorScheme3 = (ColorScheme) compositeDecoderB.n(descriptor2, i7, ColorScheme$$serializer.INSTANCE, colorScheme3);
                        i8 |= 64;
                        break;
                    case 7:
                        padding6 = (Padding) compositeDecoderB.n(descriptor2, i6, Padding$$serializer.INSTANCE, padding6);
                        i8 |= ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
                        break;
                    case 8:
                        padding5 = (Padding) compositeDecoderB.n(descriptor2, 8, Padding$$serializer.INSTANCE, padding5);
                        i8 |= Function.MAX_NARGS;
                        break;
                    case 9:
                        border2 = (Border) compositeDecoderB.n(descriptor2, i5, Border$$serializer.INSTANCE, border2);
                        i8 |= 512;
                        break;
                    case 10:
                        shadow2 = (Shadow) compositeDecoderB.n(descriptor2, i4, Shadow$$serializer.INSTANCE, shadow2);
                        i8 |= 1024;
                        break;
                    default:
                        throw new UnknownFieldException(iO);
                }
            }
            fitMode = fitMode3;
            themeImageUrls = themeImageUrls3;
            size = size3;
            padding = padding5;
            i3 = i8;
            maskShape = maskShape3;
            colorScheme = colorScheme3;
            padding2 = padding6;
            border = border2;
            shadow = shadow2;
            str = strM654unboximpl2;
        }
        Boolean bool2 = bool;
        compositeDecoderB.c(descriptor2);
        return new PartialImageComponent(i3, bool2, themeImageUrls, size, str, fitMode, maskShape, colorScheme, padding2, padding, border, shadow, null, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, PartialImageComponent value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderB = encoder.b(descriptor2);
        PartialImageComponent.write$Self$purchases_defaultsBc8Release(value, compositeEncoderB, descriptor2);
        compositeEncoderB.c(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
