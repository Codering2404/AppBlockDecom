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
public final class ImageComponent$$serializer implements GeneratedSerializer<ImageComponent> {
    public static final ImageComponent$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        ImageComponent$$serializer imageComponent$$serializer = new ImageComponent$$serializer();
        INSTANCE = imageComponent$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("image", imageComponent$$serializer, 12);
        pluginGeneratedSerialDescriptor.p("source", false);
        pluginGeneratedSerialDescriptor.p("visible", true);
        pluginGeneratedSerialDescriptor.p("size", true);
        pluginGeneratedSerialDescriptor.p("override_source_lid", true);
        pluginGeneratedSerialDescriptor.p("mask_shape", true);
        pluginGeneratedSerialDescriptor.p("color_overlay", true);
        pluginGeneratedSerialDescriptor.p("fit_mode", true);
        pluginGeneratedSerialDescriptor.p("padding", true);
        pluginGeneratedSerialDescriptor.p("margin", true);
        pluginGeneratedSerialDescriptor.p("border", true);
        pluginGeneratedSerialDescriptor.p("shadow", true);
        pluginGeneratedSerialDescriptor.p("overrides", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private ImageComponent$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr = ImageComponent.$childSerializers;
        KSerializer<?> kSerializerU = BuiltinSerializersKt.u(BooleanSerializer.f142767a);
        KSerializer<?> kSerializerU2 = BuiltinSerializersKt.u(LocalizationKey$$serializer.INSTANCE);
        KSerializer<?> kSerializerU3 = BuiltinSerializersKt.u(MaskShapeDeserializer.INSTANCE);
        KSerializer<?> kSerializerU4 = BuiltinSerializersKt.u(ColorScheme$$serializer.INSTANCE);
        KSerializer<?> kSerializerU5 = BuiltinSerializersKt.u(Border$$serializer.INSTANCE);
        KSerializer<?> kSerializerU6 = BuiltinSerializersKt.u(Shadow$$serializer.INSTANCE);
        KSerializer<?> kSerializer = kSerializerArr[11];
        Padding$$serializer padding$$serializer = Padding$$serializer.INSTANCE;
        return new KSerializer[]{ThemeImageUrls$$serializer.INSTANCE, kSerializerU, Size$$serializer.INSTANCE, kSerializerU2, kSerializerU3, kSerializerU4, FitModeDeserializer.INSTANCE, padding$$serializer, padding$$serializer, kSerializerU5, kSerializerU6, kSerializer};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public ImageComponent deserialize(Decoder decoder) {
        MaskShape maskShape;
        Boolean bool;
        Size size;
        int i3;
        Padding padding;
        FitMode fitMode;
        ThemeImageUrls themeImageUrls;
        ColorScheme colorScheme;
        Padding padding2;
        List list;
        Border border;
        Shadow shadow;
        String str;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderB = decoder.b(descriptor2);
        KSerializer[] kSerializerArr = ImageComponent.$childSerializers;
        int i4 = 10;
        int i5 = 9;
        int i6 = 8;
        List list2 = null;
        if (compositeDecoderB.p()) {
            ThemeImageUrls themeImageUrls2 = (ThemeImageUrls) compositeDecoderB.y(descriptor2, 0, ThemeImageUrls$$serializer.INSTANCE, null);
            Boolean bool2 = (Boolean) compositeDecoderB.n(descriptor2, 1, BooleanSerializer.f142767a, null);
            Size size2 = (Size) compositeDecoderB.y(descriptor2, 2, Size$$serializer.INSTANCE, null);
            LocalizationKey localizationKey = (LocalizationKey) compositeDecoderB.n(descriptor2, 3, LocalizationKey$$serializer.INSTANCE, null);
            String strM654unboximpl = localizationKey != null ? localizationKey.m654unboximpl() : null;
            MaskShape maskShape2 = (MaskShape) compositeDecoderB.n(descriptor2, 4, MaskShapeDeserializer.INSTANCE, null);
            ColorScheme colorScheme2 = (ColorScheme) compositeDecoderB.n(descriptor2, 5, ColorScheme$$serializer.INSTANCE, null);
            FitMode fitMode2 = (FitMode) compositeDecoderB.y(descriptor2, 6, FitModeDeserializer.INSTANCE, null);
            Padding$$serializer padding$$serializer = Padding$$serializer.INSTANCE;
            Padding padding3 = (Padding) compositeDecoderB.y(descriptor2, 7, padding$$serializer, null);
            Padding padding4 = (Padding) compositeDecoderB.y(descriptor2, 8, padding$$serializer, null);
            Border border2 = (Border) compositeDecoderB.n(descriptor2, 9, Border$$serializer.INSTANCE, null);
            Shadow shadow2 = (Shadow) compositeDecoderB.n(descriptor2, 10, Shadow$$serializer.INSTANCE, null);
            list = (List) compositeDecoderB.y(descriptor2, 11, kSerializerArr[11], null);
            themeImageUrls = themeImageUrls2;
            shadow = shadow2;
            border = border2;
            padding2 = padding3;
            fitMode = fitMode2;
            colorScheme = colorScheme2;
            str = strM654unboximpl;
            padding = padding4;
            maskShape = maskShape2;
            size = size2;
            i3 = 4095;
            bool = bool2;
        } else {
            int i7 = 11;
            Padding padding5 = null;
            FitMode fitMode3 = null;
            ColorScheme colorScheme3 = null;
            Padding padding6 = null;
            ThemeImageUrls themeImageUrls3 = null;
            String strM654unboximpl2 = null;
            MaskShape maskShape3 = null;
            Size size3 = null;
            Boolean bool3 = null;
            boolean z2 = true;
            int i8 = 0;
            Border border3 = null;
            Shadow shadow3 = null;
            while (z2) {
                int iO = compositeDecoderB.o(descriptor2);
                switch (iO) {
                    case -1:
                        z2 = false;
                        kSerializerArr = kSerializerArr;
                        i7 = 11;
                        i5 = 9;
                        themeImageUrls3 = themeImageUrls3;
                        i6 = 8;
                        break;
                    case 0:
                        i8 |= 1;
                        kSerializerArr = kSerializerArr;
                        i7 = 11;
                        i5 = 9;
                        i6 = 8;
                        themeImageUrls3 = (ThemeImageUrls) compositeDecoderB.y(descriptor2, 0, ThemeImageUrls$$serializer.INSTANCE, themeImageUrls3);
                        i4 = 10;
                        break;
                    case 1:
                        bool3 = (Boolean) compositeDecoderB.n(descriptor2, 1, BooleanSerializer.f142767a, bool3);
                        i8 |= 2;
                        i7 = 11;
                        i4 = 10;
                        i5 = 9;
                        i6 = 8;
                        break;
                    case 2:
                        size3 = (Size) compositeDecoderB.y(descriptor2, 2, Size$$serializer.INSTANCE, size3);
                        i8 |= 4;
                        i7 = 11;
                        i4 = 10;
                        i5 = 9;
                        break;
                    case 3:
                        MaskShape maskShape4 = maskShape3;
                        LocalizationKey localizationKey2 = (LocalizationKey) compositeDecoderB.n(descriptor2, 3, LocalizationKey$$serializer.INSTANCE, strM654unboximpl2 != null ? LocalizationKey.m648boximpl(strM654unboximpl2) : null);
                        strM654unboximpl2 = localizationKey2 != null ? localizationKey2.m654unboximpl() : null;
                        i8 |= 8;
                        maskShape3 = maskShape4;
                        i7 = 11;
                        i4 = 10;
                        i5 = 9;
                        break;
                    case 4:
                        maskShape3 = (MaskShape) compositeDecoderB.n(descriptor2, 4, MaskShapeDeserializer.INSTANCE, maskShape3);
                        i8 |= 16;
                        i7 = 11;
                        i4 = 10;
                        break;
                    case 5:
                        colorScheme3 = (ColorScheme) compositeDecoderB.n(descriptor2, 5, ColorScheme$$serializer.INSTANCE, colorScheme3);
                        i8 |= 32;
                        i7 = 11;
                        break;
                    case 6:
                        fitMode3 = (FitMode) compositeDecoderB.y(descriptor2, 6, FitModeDeserializer.INSTANCE, fitMode3);
                        i8 |= 64;
                        i7 = 11;
                        break;
                    case 7:
                        padding6 = (Padding) compositeDecoderB.y(descriptor2, 7, Padding$$serializer.INSTANCE, padding6);
                        i8 |= ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
                        i7 = 11;
                        break;
                    case 8:
                        padding5 = (Padding) compositeDecoderB.y(descriptor2, i6, Padding$$serializer.INSTANCE, padding5);
                        i8 |= Function.MAX_NARGS;
                        break;
                    case 9:
                        border3 = (Border) compositeDecoderB.n(descriptor2, i5, Border$$serializer.INSTANCE, border3);
                        i8 |= 512;
                        break;
                    case 10:
                        shadow3 = (Shadow) compositeDecoderB.n(descriptor2, i4, Shadow$$serializer.INSTANCE, shadow3);
                        i8 |= 1024;
                        break;
                    case 11:
                        list2 = (List) compositeDecoderB.y(descriptor2, i7, kSerializerArr[i7], list2);
                        i8 |= 2048;
                        break;
                    default:
                        throw new UnknownFieldException(iO);
                }
            }
            maskShape = maskShape3;
            bool = bool3;
            size = size3;
            i3 = i8;
            padding = padding5;
            fitMode = fitMode3;
            themeImageUrls = themeImageUrls3;
            colorScheme = colorScheme3;
            padding2 = padding6;
            list = list2;
            border = border3;
            shadow = shadow3;
            str = strM654unboximpl2;
        }
        compositeDecoderB.c(descriptor2);
        return new ImageComponent(i3, themeImageUrls, bool, size, str, maskShape, colorScheme, fitMode, padding2, padding, border, shadow, list, null, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, ImageComponent value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderB = encoder.b(descriptor2);
        ImageComponent.write$Self$purchases_defaultsBc8Release(value, compositeEncoderB, descriptor2);
        compositeEncoderB.c(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
