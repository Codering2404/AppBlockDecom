package com.revenuecat.purchases.paywalls.components;

import com.applovin.mediation.AppLovinExtras;
import com.facebook.internal.Utility;
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
import com.revenuecat.purchases.paywalls.components.properties.ThemeVideoUrls;
import com.revenuecat.purchases.paywalls.components.properties.ThemeVideoUrls$$serializer;
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
public final class PartialVideoComponent$$serializer implements GeneratedSerializer<PartialVideoComponent> {
    public static final PartialVideoComponent$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        PartialVideoComponent$$serializer partialVideoComponent$$serializer = new PartialVideoComponent$$serializer();
        INSTANCE = partialVideoComponent$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.paywalls.components.PartialVideoComponent", partialVideoComponent$$serializer, 16);
        pluginGeneratedSerialDescriptor.p("source", true);
        pluginGeneratedSerialDescriptor.p("fallback_source", true);
        pluginGeneratedSerialDescriptor.p("visible", true);
        pluginGeneratedSerialDescriptor.p("show_controls", true);
        pluginGeneratedSerialDescriptor.p("auto_play", true);
        pluginGeneratedSerialDescriptor.p("loop", true);
        pluginGeneratedSerialDescriptor.p(AppLovinExtras.Keys.MUTE_AUDIO, true);
        pluginGeneratedSerialDescriptor.p("size", true);
        pluginGeneratedSerialDescriptor.p("fit_mode", true);
        pluginGeneratedSerialDescriptor.p("mask_shape", true);
        pluginGeneratedSerialDescriptor.p("color_overlay", true);
        pluginGeneratedSerialDescriptor.p("padding", true);
        pluginGeneratedSerialDescriptor.p("margin", true);
        pluginGeneratedSerialDescriptor.p("border", true);
        pluginGeneratedSerialDescriptor.p("shadow", true);
        pluginGeneratedSerialDescriptor.p("override_source_lid", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private PartialVideoComponent$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        KSerializer<?> kSerializerU = BuiltinSerializersKt.u(ThemeVideoUrls$$serializer.INSTANCE);
        KSerializer<?> kSerializerU2 = BuiltinSerializersKt.u(ThemeImageUrls$$serializer.INSTANCE);
        BooleanSerializer booleanSerializer = BooleanSerializer.f142767a;
        KSerializer<?> kSerializerU3 = BuiltinSerializersKt.u(booleanSerializer);
        KSerializer<?> kSerializerU4 = BuiltinSerializersKt.u(booleanSerializer);
        KSerializer<?> kSerializerU5 = BuiltinSerializersKt.u(booleanSerializer);
        KSerializer<?> kSerializerU6 = BuiltinSerializersKt.u(booleanSerializer);
        KSerializer<?> kSerializerU7 = BuiltinSerializersKt.u(booleanSerializer);
        KSerializer<?> kSerializerU8 = BuiltinSerializersKt.u(Size$$serializer.INSTANCE);
        KSerializer<?> kSerializerU9 = BuiltinSerializersKt.u(FitModeDeserializer.INSTANCE);
        KSerializer<?> kSerializerU10 = BuiltinSerializersKt.u(MaskShapeDeserializer.INSTANCE);
        KSerializer<?> kSerializerU11 = BuiltinSerializersKt.u(ColorScheme$$serializer.INSTANCE);
        Padding$$serializer padding$$serializer = Padding$$serializer.INSTANCE;
        return new KSerializer[]{kSerializerU, kSerializerU2, kSerializerU3, kSerializerU4, kSerializerU5, kSerializerU6, kSerializerU7, kSerializerU8, kSerializerU9, kSerializerU10, kSerializerU11, BuiltinSerializersKt.u(padding$$serializer), BuiltinSerializersKt.u(padding$$serializer), BuiltinSerializersKt.u(Border$$serializer.INSTANCE), BuiltinSerializersKt.u(Shadow$$serializer.INSTANCE), BuiltinSerializersKt.u(LocalizationKey$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public PartialVideoComponent deserialize(Decoder decoder) {
        ThemeVideoUrls themeVideoUrls;
        ThemeImageUrls themeImageUrls;
        Padding padding;
        int i3;
        Size size;
        Boolean bool;
        FitMode fitMode;
        MaskShape maskShape;
        ColorScheme colorScheme;
        Boolean bool2;
        Boolean bool3;
        Padding padding2;
        Boolean bool4;
        Boolean bool5;
        Border border;
        String strM654unboximpl;
        Shadow shadow;
        Shadow shadow2;
        Border border2;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderB = decoder.b(descriptor2);
        int i4 = 11;
        char c3 = '\n';
        char c4 = '\t';
        if (compositeDecoderB.p()) {
            ThemeVideoUrls themeVideoUrls2 = (ThemeVideoUrls) compositeDecoderB.n(descriptor2, 0, ThemeVideoUrls$$serializer.INSTANCE, null);
            ThemeImageUrls themeImageUrls2 = (ThemeImageUrls) compositeDecoderB.n(descriptor2, 1, ThemeImageUrls$$serializer.INSTANCE, null);
            BooleanSerializer booleanSerializer = BooleanSerializer.f142767a;
            Boolean bool6 = (Boolean) compositeDecoderB.n(descriptor2, 2, booleanSerializer, null);
            Boolean bool7 = (Boolean) compositeDecoderB.n(descriptor2, 3, booleanSerializer, null);
            Boolean bool8 = (Boolean) compositeDecoderB.n(descriptor2, 4, booleanSerializer, null);
            Boolean bool9 = (Boolean) compositeDecoderB.n(descriptor2, 5, booleanSerializer, null);
            Boolean bool10 = (Boolean) compositeDecoderB.n(descriptor2, 6, booleanSerializer, null);
            Size size2 = (Size) compositeDecoderB.n(descriptor2, 7, Size$$serializer.INSTANCE, null);
            FitMode fitMode2 = (FitMode) compositeDecoderB.n(descriptor2, 8, FitModeDeserializer.INSTANCE, null);
            MaskShape maskShape2 = (MaskShape) compositeDecoderB.n(descriptor2, 9, MaskShapeDeserializer.INSTANCE, null);
            ColorScheme colorScheme2 = (ColorScheme) compositeDecoderB.n(descriptor2, 10, ColorScheme$$serializer.INSTANCE, null);
            Padding$$serializer padding$$serializer = Padding$$serializer.INSTANCE;
            Padding padding3 = (Padding) compositeDecoderB.n(descriptor2, 11, padding$$serializer, null);
            Padding padding4 = (Padding) compositeDecoderB.n(descriptor2, 12, padding$$serializer, null);
            Border border3 = (Border) compositeDecoderB.n(descriptor2, 13, Border$$serializer.INSTANCE, null);
            Shadow shadow3 = (Shadow) compositeDecoderB.n(descriptor2, 14, Shadow$$serializer.INSTANCE, null);
            LocalizationKey localizationKey = (LocalizationKey) compositeDecoderB.n(descriptor2, 15, LocalizationKey$$serializer.INSTANCE, null);
            i3 = 65535;
            bool4 = bool6;
            themeImageUrls = themeImageUrls2;
            bool2 = bool10;
            strM654unboximpl = localizationKey != null ? localizationKey.m654unboximpl() : null;
            padding2 = padding3;
            colorScheme = colorScheme2;
            maskShape = maskShape2;
            size = size2;
            fitMode = fitMode2;
            bool = bool9;
            bool5 = bool7;
            bool3 = bool8;
            shadow = shadow3;
            border = border3;
            padding = padding4;
            themeVideoUrls = themeVideoUrls2;
        } else {
            boolean z2 = true;
            ThemeVideoUrls themeVideoUrls3 = null;
            Shadow shadow4 = null;
            Border border4 = null;
            FitMode fitMode3 = null;
            MaskShape maskShape3 = null;
            ColorScheme colorScheme3 = null;
            Boolean bool11 = null;
            Padding padding5 = null;
            Boolean bool12 = null;
            ThemeImageUrls themeImageUrls3 = null;
            String strM654unboximpl2 = null;
            Size size3 = null;
            Boolean bool13 = null;
            Boolean bool14 = null;
            Boolean bool15 = null;
            int i5 = 0;
            Padding padding6 = null;
            while (z2) {
                int iO = compositeDecoderB.o(descriptor2);
                switch (iO) {
                    case -1:
                        z2 = false;
                        border4 = border4;
                        shadow4 = shadow4;
                        i4 = 11;
                        c3 = '\n';
                        break;
                    case 0:
                        shadow2 = shadow4;
                        border2 = border4;
                        themeVideoUrls3 = (ThemeVideoUrls) compositeDecoderB.n(descriptor2, 0, ThemeVideoUrls$$serializer.INSTANCE, themeVideoUrls3);
                        i5 |= 1;
                        border4 = border2;
                        shadow4 = shadow2;
                        i4 = 11;
                        c3 = '\n';
                        c4 = '\t';
                        break;
                    case 1:
                        shadow2 = shadow4;
                        border2 = border4;
                        themeImageUrls3 = (ThemeImageUrls) compositeDecoderB.n(descriptor2, 1, ThemeImageUrls$$serializer.INSTANCE, themeImageUrls3);
                        i5 |= 2;
                        bool12 = bool12;
                        border4 = border2;
                        shadow4 = shadow2;
                        i4 = 11;
                        c3 = '\n';
                        c4 = '\t';
                        break;
                    case 2:
                        shadow2 = shadow4;
                        border2 = border4;
                        bool12 = (Boolean) compositeDecoderB.n(descriptor2, 2, BooleanSerializer.f142767a, bool12);
                        i5 |= 4;
                        bool14 = bool14;
                        border4 = border2;
                        shadow4 = shadow2;
                        i4 = 11;
                        c3 = '\n';
                        c4 = '\t';
                        break;
                    case 3:
                        shadow2 = shadow4;
                        border2 = border4;
                        bool14 = (Boolean) compositeDecoderB.n(descriptor2, 3, BooleanSerializer.f142767a, bool14);
                        i5 |= 8;
                        border4 = border2;
                        shadow4 = shadow2;
                        i4 = 11;
                        c3 = '\n';
                        c4 = '\t';
                        break;
                    case 4:
                        shadow2 = shadow4;
                        bool15 = (Boolean) compositeDecoderB.n(descriptor2, 4, BooleanSerializer.f142767a, bool15);
                        i5 |= 16;
                        shadow4 = shadow2;
                        i4 = 11;
                        c3 = '\n';
                        c4 = '\t';
                        break;
                    case 5:
                        bool13 = (Boolean) compositeDecoderB.n(descriptor2, 5, BooleanSerializer.f142767a, bool13);
                        i5 |= 32;
                        i4 = 11;
                        c3 = '\n';
                        c4 = '\t';
                        break;
                    case 6:
                        bool11 = (Boolean) compositeDecoderB.n(descriptor2, 6, BooleanSerializer.f142767a, bool11);
                        i5 |= 64;
                        i4 = 11;
                        c3 = '\n';
                        c4 = '\t';
                        break;
                    case 7:
                        Size size4 = (Size) compositeDecoderB.n(descriptor2, 7, Size$$serializer.INSTANCE, size3);
                        i5 |= ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
                        size3 = size4;
                        i4 = 11;
                        c3 = '\n';
                        c4 = '\t';
                        break;
                    case 8:
                        fitMode3 = (FitMode) compositeDecoderB.n(descriptor2, 8, FitModeDeserializer.INSTANCE, fitMode3);
                        i5 |= Function.MAX_NARGS;
                        i4 = 11;
                        c3 = '\n';
                        c4 = '\t';
                        break;
                    case 9:
                        maskShape3 = (MaskShape) compositeDecoderB.n(descriptor2, 9, MaskShapeDeserializer.INSTANCE, maskShape3);
                        i5 |= 512;
                        c4 = '\t';
                        i4 = 11;
                        c3 = '\n';
                        break;
                    case 10:
                        colorScheme3 = (ColorScheme) compositeDecoderB.n(descriptor2, 10, ColorScheme$$serializer.INSTANCE, colorScheme3);
                        i5 |= 1024;
                        c3 = '\n';
                        i4 = 11;
                        c4 = '\t';
                        break;
                    case 11:
                        padding5 = (Padding) compositeDecoderB.n(descriptor2, i4, Padding$$serializer.INSTANCE, padding5);
                        i5 |= 2048;
                        c3 = '\n';
                        c4 = '\t';
                        break;
                    case 12:
                        padding6 = (Padding) compositeDecoderB.n(descriptor2, 12, Padding$$serializer.INSTANCE, padding6);
                        i5 |= 4096;
                        c3 = '\n';
                        c4 = '\t';
                        break;
                    case 13:
                        border4 = (Border) compositeDecoderB.n(descriptor2, 13, Border$$serializer.INSTANCE, border4);
                        i5 |= Utility.DEFAULT_STREAM_BUFFER_SIZE;
                        c3 = '\n';
                        c4 = '\t';
                        break;
                    case 14:
                        shadow4 = (Shadow) compositeDecoderB.n(descriptor2, 14, Shadow$$serializer.INSTANCE, shadow4);
                        i5 |= 16384;
                        c3 = '\n';
                        c4 = '\t';
                        break;
                    case 15:
                        LocalizationKey localizationKey2 = (LocalizationKey) compositeDecoderB.n(descriptor2, 15, LocalizationKey$$serializer.INSTANCE, strM654unboximpl2 != null ? LocalizationKey.m648boximpl(strM654unboximpl2) : null);
                        strM654unboximpl2 = localizationKey2 != null ? localizationKey2.m654unboximpl() : null;
                        i5 |= 32768;
                        c3 = '\n';
                        c4 = '\t';
                        break;
                    default:
                        throw new UnknownFieldException(iO);
                }
            }
            themeVideoUrls = themeVideoUrls3;
            themeImageUrls = themeImageUrls3;
            padding = padding6;
            i3 = i5;
            size = size3;
            bool = bool13;
            fitMode = fitMode3;
            maskShape = maskShape3;
            colorScheme = colorScheme3;
            bool2 = bool11;
            bool3 = bool15;
            padding2 = padding5;
            bool4 = bool12;
            bool5 = bool14;
            border = border4;
            strM654unboximpl = strM654unboximpl2;
            shadow = shadow4;
        }
        compositeDecoderB.c(descriptor2);
        return new PartialVideoComponent(i3, themeVideoUrls, themeImageUrls, bool4, bool5, bool3, bool, bool2, size, fitMode, maskShape, colorScheme, padding2, padding, border, shadow, strM654unboximpl, null, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, PartialVideoComponent value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderB = encoder.b(descriptor2);
        PartialVideoComponent.write$Self$purchases_defaultsBc8Release(value, compositeEncoderB, descriptor2);
        compositeEncoderB.c(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
