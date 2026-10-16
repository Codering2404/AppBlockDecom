package com.revenuecat.purchases.paywalls.components;

import com.applovin.mediation.AppLovinExtras;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.NativeProtocol;
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
public final class VideoComponent$$serializer implements GeneratedSerializer<VideoComponent> {
    public static final VideoComponent$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        VideoComponent$$serializer videoComponent$$serializer = new VideoComponent$$serializer();
        INSTANCE = videoComponent$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_VIDEO, videoComponent$$serializer, 17);
        pluginGeneratedSerialDescriptor.p("source", false);
        pluginGeneratedSerialDescriptor.p("fallback_source", false);
        pluginGeneratedSerialDescriptor.p("visible", false);
        pluginGeneratedSerialDescriptor.p("show_controls", false);
        pluginGeneratedSerialDescriptor.p("auto_play", false);
        pluginGeneratedSerialDescriptor.p("loop", false);
        pluginGeneratedSerialDescriptor.p(AppLovinExtras.Keys.MUTE_AUDIO, false);
        pluginGeneratedSerialDescriptor.p("size", false);
        pluginGeneratedSerialDescriptor.p("fit_mode", false);
        pluginGeneratedSerialDescriptor.p("mask_shape", false);
        pluginGeneratedSerialDescriptor.p("color_overlay", false);
        pluginGeneratedSerialDescriptor.p("padding", false);
        pluginGeneratedSerialDescriptor.p("margin", false);
        pluginGeneratedSerialDescriptor.p("border", false);
        pluginGeneratedSerialDescriptor.p("shadow", false);
        pluginGeneratedSerialDescriptor.p("overrides", false);
        pluginGeneratedSerialDescriptor.p("override_source_lid", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private VideoComponent$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        KSerializer[] kSerializerArr = VideoComponent.$childSerializers;
        KSerializer<?> kSerializerU = BuiltinSerializersKt.u(ThemeImageUrls$$serializer.INSTANCE);
        BooleanSerializer booleanSerializer = BooleanSerializer.f142767a;
        KSerializer<?> kSerializerU2 = BuiltinSerializersKt.u(booleanSerializer);
        KSerializer<?> kSerializerU3 = BuiltinSerializersKt.u(MaskShapeDeserializer.INSTANCE);
        KSerializer<?> kSerializerU4 = BuiltinSerializersKt.u(ColorScheme$$serializer.INSTANCE);
        Padding$$serializer padding$$serializer = Padding$$serializer.INSTANCE;
        return new KSerializer[]{ThemeVideoUrls$$serializer.INSTANCE, kSerializerU, kSerializerU2, booleanSerializer, booleanSerializer, booleanSerializer, booleanSerializer, Size$$serializer.INSTANCE, FitModeDeserializer.INSTANCE, kSerializerU3, kSerializerU4, BuiltinSerializersKt.u(padding$$serializer), BuiltinSerializersKt.u(padding$$serializer), BuiltinSerializersKt.u(Border$$serializer.INSTANCE), BuiltinSerializersKt.u(Shadow$$serializer.INSTANCE), BuiltinSerializersKt.u(kSerializerArr[15]), BuiltinSerializersKt.u(LocalizationKey$$serializer.INSTANCE)};
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.serialization.DeserializationStrategy
    public VideoComponent deserialize(Decoder decoder) {
        Padding padding;
        List list;
        Shadow shadow;
        Border border;
        Padding padding2;
        Boolean bool;
        ThemeImageUrls themeImageUrls;
        FitMode fitMode;
        Size size;
        ColorScheme colorScheme;
        MaskShape maskShape;
        ThemeVideoUrls themeVideoUrls;
        int i3;
        boolean z2;
        String strM654unboximpl;
        boolean z3;
        boolean z4;
        boolean z5;
        char c3;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderB = decoder.b(descriptor2);
        KSerializer[] kSerializerArr = VideoComponent.$childSerializers;
        int i4 = 10;
        char c4 = '\t';
        char c5 = '\b';
        if (compositeDecoderB.p()) {
            ThemeVideoUrls themeVideoUrls2 = (ThemeVideoUrls) compositeDecoderB.y(descriptor2, 0, ThemeVideoUrls$$serializer.INSTANCE, null);
            ThemeImageUrls themeImageUrls2 = (ThemeImageUrls) compositeDecoderB.n(descriptor2, 1, ThemeImageUrls$$serializer.INSTANCE, null);
            Boolean bool2 = (Boolean) compositeDecoderB.n(descriptor2, 2, BooleanSerializer.f142767a, null);
            boolean zC = compositeDecoderB.C(descriptor2, 3);
            boolean zC2 = compositeDecoderB.C(descriptor2, 4);
            boolean zC3 = compositeDecoderB.C(descriptor2, 5);
            boolean zC4 = compositeDecoderB.C(descriptor2, 6);
            Size size2 = (Size) compositeDecoderB.y(descriptor2, 7, Size$$serializer.INSTANCE, null);
            FitMode fitMode2 = (FitMode) compositeDecoderB.y(descriptor2, 8, FitModeDeserializer.INSTANCE, null);
            MaskShape maskShape2 = (MaskShape) compositeDecoderB.n(descriptor2, 9, MaskShapeDeserializer.INSTANCE, null);
            ColorScheme colorScheme2 = (ColorScheme) compositeDecoderB.n(descriptor2, 10, ColorScheme$$serializer.INSTANCE, null);
            Padding$$serializer padding$$serializer = Padding$$serializer.INSTANCE;
            Padding padding3 = (Padding) compositeDecoderB.n(descriptor2, 11, padding$$serializer, null);
            Padding padding4 = (Padding) compositeDecoderB.n(descriptor2, 12, padding$$serializer, null);
            Border border2 = (Border) compositeDecoderB.n(descriptor2, 13, Border$$serializer.INSTANCE, null);
            Shadow shadow2 = (Shadow) compositeDecoderB.n(descriptor2, 14, Shadow$$serializer.INSTANCE, null);
            List list2 = (List) compositeDecoderB.n(descriptor2, 15, kSerializerArr[15], null);
            LocalizationKey localizationKey = (LocalizationKey) compositeDecoderB.n(descriptor2, 16, LocalizationKey$$serializer.INSTANCE, null);
            i3 = 131071;
            themeVideoUrls = themeVideoUrls2;
            bool = bool2;
            themeImageUrls = themeImageUrls2;
            z2 = zC;
            strM654unboximpl = localizationKey != null ? localizationKey.m654unboximpl() : null;
            colorScheme = colorScheme2;
            maskShape = maskShape2;
            size = size2;
            z3 = zC4;
            z4 = zC3;
            z5 = zC2;
            fitMode = fitMode2;
            shadow = shadow2;
            border = border2;
            list = list2;
            padding2 = padding4;
            padding = padding3;
        } else {
            boolean z6 = true;
            int i5 = 0;
            boolean zC5 = false;
            boolean zC6 = false;
            boolean zC7 = false;
            boolean zC8 = false;
            Padding padding5 = null;
            List list3 = null;
            Shadow shadow3 = null;
            Border border3 = null;
            FitMode fitMode3 = null;
            Size size3 = null;
            ColorScheme colorScheme3 = null;
            MaskShape maskShape3 = null;
            ThemeVideoUrls themeVideoUrls3 = null;
            Boolean bool3 = null;
            ThemeImageUrls themeImageUrls3 = null;
            String strM654unboximpl2 = null;
            while (z6) {
                int iO = compositeDecoderB.o(descriptor2);
                switch (iO) {
                    case -1:
                        z6 = false;
                        i5 = i5;
                        c4 = '\t';
                        c5 = '\b';
                        break;
                    case 0:
                        themeVideoUrls3 = (ThemeVideoUrls) compositeDecoderB.y(descriptor2, 0, ThemeVideoUrls$$serializer.INSTANCE, themeVideoUrls3);
                        i5 |= 1;
                        i4 = 10;
                        c4 = '\t';
                        c5 = '\b';
                        break;
                    case 1:
                        themeImageUrls3 = (ThemeImageUrls) compositeDecoderB.n(descriptor2, 1, ThemeImageUrls$$serializer.INSTANCE, themeImageUrls3);
                        i5 |= 2;
                        i4 = 10;
                        c4 = '\t';
                        c5 = '\b';
                        break;
                    case 2:
                        bool3 = (Boolean) compositeDecoderB.n(descriptor2, 2, BooleanSerializer.f142767a, bool3);
                        i5 |= 4;
                        i4 = 10;
                        c4 = '\t';
                        c5 = '\b';
                        break;
                    case 3:
                        zC5 = compositeDecoderB.C(descriptor2, 3);
                        i5 |= 8;
                        i4 = 10;
                        c4 = '\t';
                        c5 = '\b';
                        break;
                    case 4:
                        zC8 = compositeDecoderB.C(descriptor2, 4);
                        i5 |= 16;
                        i4 = 10;
                        c4 = '\t';
                        c5 = '\b';
                        break;
                    case 5:
                        zC7 = compositeDecoderB.C(descriptor2, 5);
                        i5 |= 32;
                        i4 = 10;
                        c4 = '\t';
                        c5 = '\b';
                        break;
                    case 6:
                        c3 = 7;
                        zC6 = compositeDecoderB.C(descriptor2, 6);
                        i5 |= 64;
                        i4 = 10;
                        c4 = '\t';
                        c5 = '\b';
                        break;
                    case 7:
                        c3 = 7;
                        size3 = (Size) compositeDecoderB.y(descriptor2, 7, Size$$serializer.INSTANCE, size3);
                        i5 |= ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
                        i4 = 10;
                        c4 = '\t';
                        c5 = '\b';
                        break;
                    case 8:
                        fitMode3 = (FitMode) compositeDecoderB.y(descriptor2, 8, FitModeDeserializer.INSTANCE, fitMode3);
                        i5 |= Function.MAX_NARGS;
                        c5 = '\b';
                        i4 = 10;
                        c4 = '\t';
                        break;
                    case 9:
                        maskShape3 = (MaskShape) compositeDecoderB.n(descriptor2, 9, MaskShapeDeserializer.INSTANCE, maskShape3);
                        i5 |= 512;
                        c4 = '\t';
                        i4 = 10;
                        c5 = '\b';
                        break;
                    case 10:
                        colorScheme3 = (ColorScheme) compositeDecoderB.n(descriptor2, i4, ColorScheme$$serializer.INSTANCE, colorScheme3);
                        i5 |= 1024;
                        c4 = '\t';
                        c5 = '\b';
                        break;
                    case 11:
                        padding5 = (Padding) compositeDecoderB.n(descriptor2, 11, Padding$$serializer.INSTANCE, padding5);
                        i5 |= 2048;
                        c4 = '\t';
                        c5 = '\b';
                        break;
                    case 12:
                        obj = (Padding) compositeDecoderB.n(descriptor2, 12, Padding$$serializer.INSTANCE, obj);
                        i5 |= 4096;
                        c4 = '\t';
                        c5 = '\b';
                        break;
                    case 13:
                        border3 = (Border) compositeDecoderB.n(descriptor2, 13, Border$$serializer.INSTANCE, border3);
                        i5 |= Utility.DEFAULT_STREAM_BUFFER_SIZE;
                        c4 = '\t';
                        c5 = '\b';
                        break;
                    case 14:
                        shadow3 = (Shadow) compositeDecoderB.n(descriptor2, 14, Shadow$$serializer.INSTANCE, shadow3);
                        i5 |= 16384;
                        c4 = '\t';
                        c5 = '\b';
                        break;
                    case 15:
                        list3 = (List) compositeDecoderB.n(descriptor2, 15, kSerializerArr[15], list3);
                        i5 |= 32768;
                        c4 = '\t';
                        c5 = '\b';
                        break;
                    case 16:
                        LocalizationKey localizationKey2 = (LocalizationKey) compositeDecoderB.n(descriptor2, 16, LocalizationKey$$serializer.INSTANCE, strM654unboximpl2 != null ? LocalizationKey.m648boximpl(strM654unboximpl2) : null);
                        strM654unboximpl2 = localizationKey2 != null ? localizationKey2.m654unboximpl() : null;
                        i5 |= NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
                        c4 = '\t';
                        c5 = '\b';
                        break;
                    default:
                        throw new UnknownFieldException(iO);
                }
            }
            padding = padding5;
            list = list3;
            shadow = shadow3;
            border = border3;
            padding2 = obj;
            bool = bool3;
            themeImageUrls = themeImageUrls3;
            fitMode = fitMode3;
            size = size3;
            colorScheme = colorScheme3;
            maskShape = maskShape3;
            themeVideoUrls = themeVideoUrls3;
            i3 = i5;
            z2 = zC5;
            strM654unboximpl = strM654unboximpl2;
            z3 = zC6;
            z4 = zC7;
            z5 = zC8;
        }
        compositeDecoderB.c(descriptor2);
        return new VideoComponent(i3, themeVideoUrls, themeImageUrls, bool, z2, z5, z4, z3, size, fitMode, maskShape, colorScheme, padding, padding2, border, shadow, list, strM654unboximpl, null, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, VideoComponent value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderB = encoder.b(descriptor2);
        VideoComponent.write$Self$purchases_defaultsBc8Release(value, compositeEncoderB, descriptor2);
        compositeEncoderB.c(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
