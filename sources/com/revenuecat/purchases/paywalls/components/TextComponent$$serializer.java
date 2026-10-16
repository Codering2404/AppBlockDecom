package com.revenuecat.purchases.paywalls.components;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.FontAlias;
import com.revenuecat.purchases.FontAlias$$serializer;
import com.revenuecat.purchases.paywalls.components.common.LocalizationKey;
import com.revenuecat.purchases.paywalls.components.common.LocalizationKey$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.FontWeight;
import com.revenuecat.purchases.paywalls.components.properties.FontWeightDeserializer;
import com.revenuecat.purchases.paywalls.components.properties.HorizontalAlignment;
import com.revenuecat.purchases.paywalls.components.properties.HorizontalAlignmentDeserializer;
import com.revenuecat.purchases.paywalls.components.properties.Padding;
import com.revenuecat.purchases.paywalls.components.properties.Padding$$serializer;
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
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
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
public final class TextComponent$$serializer implements GeneratedSerializer<TextComponent> {
    public static final TextComponent$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        TextComponent$$serializer textComponent$$serializer = new TextComponent$$serializer();
        INSTANCE = textComponent$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("text", textComponent$$serializer, 14);
        pluginGeneratedSerialDescriptor.p("text_lid", false);
        pluginGeneratedSerialDescriptor.p("color", false);
        pluginGeneratedSerialDescriptor.p("visible", true);
        pluginGeneratedSerialDescriptor.p("background_color", true);
        pluginGeneratedSerialDescriptor.p("font_name", true);
        pluginGeneratedSerialDescriptor.p("font_weight", true);
        pluginGeneratedSerialDescriptor.p("font_weight_int", true);
        pluginGeneratedSerialDescriptor.p(ViewHierarchyConstants.TEXT_SIZE, true);
        pluginGeneratedSerialDescriptor.p(AnalyticsEvents.PARAMETER_LIKE_VIEW_HORIZONTAL_ALIGNMENT, true);
        pluginGeneratedSerialDescriptor.p("size", true);
        pluginGeneratedSerialDescriptor.p("padding", true);
        pluginGeneratedSerialDescriptor.p("margin", true);
        pluginGeneratedSerialDescriptor.p("overrides", true);
        pluginGeneratedSerialDescriptor.p("name", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private TextComponent$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr = TextComponent.$childSerializers;
        ColorScheme$$serializer colorScheme$$serializer = ColorScheme$$serializer.INSTANCE;
        KSerializer<?> kSerializerU = BuiltinSerializersKt.u(BooleanSerializer.f142767a);
        KSerializer<?> kSerializerU2 = BuiltinSerializersKt.u(colorScheme$$serializer);
        KSerializer<?> kSerializerU3 = BuiltinSerializersKt.u(FontAlias$$serializer.INSTANCE);
        KSerializer<?> kSerializerU4 = BuiltinSerializersKt.u(IntSerializer.f142823a);
        KSerializer<?> kSerializer = kSerializerArr[12];
        KSerializer<?> kSerializerU5 = BuiltinSerializersKt.u(StringSerializer.f142891a);
        Padding$$serializer padding$$serializer = Padding$$serializer.INSTANCE;
        return new KSerializer[]{LocalizationKey$$serializer.INSTANCE, colorScheme$$serializer, kSerializerU, kSerializerU2, kSerializerU3, FontWeightDeserializer.INSTANCE, kSerializerU4, FontSizeSerializer.INSTANCE, HorizontalAlignmentDeserializer.INSTANCE, Size$$serializer.INSTANCE, padding$$serializer, padding$$serializer, kSerializer, kSerializerU5};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public TextComponent deserialize(Decoder decoder) {
        List list;
        int i3;
        ColorScheme colorScheme;
        String str;
        ColorScheme colorScheme2;
        Padding padding;
        HorizontalAlignment horizontalAlignment;
        Integer num;
        Boolean bool;
        FontWeight fontWeight;
        Size size;
        String str2;
        Padding padding2;
        int i4;
        String str3;
        Boolean bool2;
        Padding padding3;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderB = decoder.b(descriptor2);
        KSerializer[] kSerializerArr = TextComponent.$childSerializers;
        int i5 = 9;
        char c3 = '\b';
        ColorScheme colorScheme3 = null;
        if (compositeDecoderB.p()) {
            LocalizationKey localizationKey = (LocalizationKey) compositeDecoderB.y(descriptor2, 0, LocalizationKey$$serializer.INSTANCE, null);
            String strM654unboximpl = localizationKey != null ? localizationKey.m654unboximpl() : null;
            ColorScheme$$serializer colorScheme$$serializer = ColorScheme$$serializer.INSTANCE;
            ColorScheme colorScheme4 = (ColorScheme) compositeDecoderB.y(descriptor2, 1, colorScheme$$serializer, null);
            Boolean bool3 = (Boolean) compositeDecoderB.n(descriptor2, 2, BooleanSerializer.f142767a, null);
            ColorScheme colorScheme5 = (ColorScheme) compositeDecoderB.n(descriptor2, 3, colorScheme$$serializer, null);
            FontAlias fontAlias = (FontAlias) compositeDecoderB.n(descriptor2, 4, FontAlias$$serializer.INSTANCE, null);
            String strM439unboximpl = fontAlias != null ? fontAlias.m439unboximpl() : null;
            FontWeight fontWeight2 = (FontWeight) compositeDecoderB.y(descriptor2, 5, FontWeightDeserializer.INSTANCE, null);
            Integer num2 = (Integer) compositeDecoderB.n(descriptor2, 6, IntSerializer.f142823a, null);
            int iIntValue = ((Number) compositeDecoderB.y(descriptor2, 7, FontSizeSerializer.INSTANCE, 0)).intValue();
            HorizontalAlignment horizontalAlignment2 = (HorizontalAlignment) compositeDecoderB.y(descriptor2, 8, HorizontalAlignmentDeserializer.INSTANCE, null);
            Size size2 = (Size) compositeDecoderB.y(descriptor2, 9, Size$$serializer.INSTANCE, null);
            Padding$$serializer padding$$serializer = Padding$$serializer.INSTANCE;
            Padding padding4 = (Padding) compositeDecoderB.y(descriptor2, 10, padding$$serializer, null);
            Padding padding5 = (Padding) compositeDecoderB.y(descriptor2, 11, padding$$serializer, null);
            List list2 = (List) compositeDecoderB.y(descriptor2, 12, kSerializerArr[12], null);
            str = (String) compositeDecoderB.n(descriptor2, 13, StringSerializer.f142891a, null);
            str2 = strM654unboximpl;
            colorScheme = colorScheme4;
            i3 = 16383;
            bool = bool3;
            size = size2;
            i4 = iIntValue;
            num = num2;
            fontWeight = fontWeight2;
            colorScheme2 = colorScheme5;
            horizontalAlignment = horizontalAlignment2;
            str3 = strM439unboximpl;
            padding = padding4;
            list = list2;
            padding2 = padding5;
        } else {
            int i6 = 0;
            int i7 = 1;
            Padding padding6 = null;
            List list3 = null;
            String str4 = null;
            Padding padding7 = null;
            HorizontalAlignment horizontalAlignment3 = null;
            Integer num3 = null;
            FontWeight fontWeight3 = null;
            Size size3 = null;
            String strM654unboximpl2 = null;
            Boolean bool4 = null;
            ColorScheme colorScheme6 = null;
            String strM439unboximpl2 = null;
            int i8 = 0;
            int iIntValue2 = 0;
            while (i7 != 0) {
                int iO = compositeDecoderB.o(descriptor2);
                switch (iO) {
                    case -1:
                        bool2 = bool4;
                        i7 = i6;
                        padding6 = padding6;
                        bool4 = bool2;
                        c3 = '\b';
                        break;
                    case 0:
                        bool2 = bool4;
                        ColorScheme colorScheme7 = colorScheme6;
                        padding3 = padding6;
                        int i9 = i6;
                        LocalizationKey localizationKey2 = (LocalizationKey) compositeDecoderB.y(descriptor2, i9, LocalizationKey$$serializer.INSTANCE, strM654unboximpl2 != null ? LocalizationKey.m648boximpl(strM654unboximpl2) : null);
                        strM654unboximpl2 = localizationKey2 != null ? localizationKey2.m654unboximpl() : null;
                        i8 |= 1;
                        i6 = i9;
                        colorScheme6 = colorScheme7;
                        padding6 = padding3;
                        i5 = 9;
                        bool4 = bool2;
                        c3 = '\b';
                        break;
                    case 1:
                        bool2 = bool4;
                        padding3 = padding6;
                        colorScheme3 = (ColorScheme) compositeDecoderB.y(descriptor2, 1, ColorScheme$$serializer.INSTANCE, colorScheme3);
                        i8 |= 2;
                        padding6 = padding3;
                        i5 = 9;
                        bool4 = bool2;
                        c3 = '\b';
                        break;
                    case 2:
                        i8 |= 4;
                        padding6 = padding6;
                        c3 = '\b';
                        bool4 = (Boolean) compositeDecoderB.n(descriptor2, 2, BooleanSerializer.f142767a, bool4);
                        i5 = 9;
                        break;
                    case 3:
                        colorScheme6 = (ColorScheme) compositeDecoderB.n(descriptor2, 3, ColorScheme$$serializer.INSTANCE, colorScheme6);
                        i8 |= 8;
                        i5 = 9;
                        c3 = '\b';
                        break;
                    case 4:
                        FontAlias fontAlias2 = (FontAlias) compositeDecoderB.n(descriptor2, 4, FontAlias$$serializer.INSTANCE, strM439unboximpl2 != null ? FontAlias.m433boximpl(strM439unboximpl2) : null);
                        strM439unboximpl2 = fontAlias2 != null ? fontAlias2.m439unboximpl() : null;
                        i8 |= 16;
                        i5 = 9;
                        c3 = '\b';
                        break;
                    case 5:
                        fontWeight3 = (FontWeight) compositeDecoderB.y(descriptor2, 5, FontWeightDeserializer.INSTANCE, fontWeight3);
                        i8 |= 32;
                        i5 = 9;
                        c3 = '\b';
                        break;
                    case 6:
                        num3 = (Integer) compositeDecoderB.n(descriptor2, 6, IntSerializer.f142823a, num3);
                        i8 |= 64;
                        i5 = 9;
                        c3 = '\b';
                        break;
                    case 7:
                        iIntValue2 = ((Number) compositeDecoderB.y(descriptor2, 7, FontSizeSerializer.INSTANCE, Integer.valueOf(iIntValue2))).intValue();
                        i8 |= ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
                        i5 = 9;
                        c3 = '\b';
                        break;
                    case 8:
                        horizontalAlignment3 = (HorizontalAlignment) compositeDecoderB.y(descriptor2, 8, HorizontalAlignmentDeserializer.INSTANCE, horizontalAlignment3);
                        i8 |= Function.MAX_NARGS;
                        c3 = '\b';
                        i5 = 9;
                        break;
                    case 9:
                        size3 = (Size) compositeDecoderB.y(descriptor2, i5, Size$$serializer.INSTANCE, size3);
                        i8 |= 512;
                        c3 = '\b';
                        break;
                    case 10:
                        padding7 = (Padding) compositeDecoderB.y(descriptor2, 10, Padding$$serializer.INSTANCE, padding7);
                        i8 |= 1024;
                        c3 = '\b';
                        break;
                    case 11:
                        padding6 = (Padding) compositeDecoderB.y(descriptor2, 11, Padding$$serializer.INSTANCE, padding6);
                        i8 |= 2048;
                        c3 = '\b';
                        break;
                    case 12:
                        list3 = (List) compositeDecoderB.y(descriptor2, 12, kSerializerArr[12], list3);
                        i8 |= 4096;
                        c3 = '\b';
                        break;
                    case 13:
                        str4 = (String) compositeDecoderB.n(descriptor2, 13, StringSerializer.f142891a, str4);
                        i8 |= Utility.DEFAULT_STREAM_BUFFER_SIZE;
                        c3 = '\b';
                        break;
                    default:
                        throw new UnknownFieldException(iO);
                }
            }
            list = list3;
            i3 = i8;
            colorScheme = colorScheme3;
            str = str4;
            colorScheme2 = colorScheme6;
            padding = padding7;
            horizontalAlignment = horizontalAlignment3;
            num = num3;
            bool = bool4;
            fontWeight = fontWeight3;
            size = size3;
            str2 = strM654unboximpl2;
            padding2 = padding6;
            i4 = iIntValue2;
            str3 = strM439unboximpl2;
        }
        compositeDecoderB.c(descriptor2);
        return new TextComponent(i3, str2, colorScheme, bool, colorScheme2, str3, fontWeight, num, i4, horizontalAlignment, size, padding, padding2, list, str, null, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, TextComponent value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderB = encoder.b(descriptor2);
        TextComponent.write$Self$purchases_defaultsBc8Release(value, compositeEncoderB, descriptor2);
        compositeEncoderB.c(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
