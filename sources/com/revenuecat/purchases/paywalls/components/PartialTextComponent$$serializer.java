package com.revenuecat.purchases.paywalls.components;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.AnalyticsEvents;
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
import cz.mobilesoft.coreblock.storage.room.dao.cI.KrzujOtzIk;
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
public final class PartialTextComponent$$serializer implements GeneratedSerializer<PartialTextComponent> {
    public static final PartialTextComponent$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    private PartialTextComponent$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        KSerializer<?> kSerializerU = BuiltinSerializersKt.u(BooleanSerializer.f142767a);
        KSerializer<?> kSerializerU2 = BuiltinSerializersKt.u(LocalizationKey$$serializer.INSTANCE);
        ColorScheme$$serializer colorScheme$$serializer = ColorScheme$$serializer.INSTANCE;
        KSerializer<?> kSerializerU3 = BuiltinSerializersKt.u(colorScheme$$serializer);
        KSerializer<?> kSerializerU4 = BuiltinSerializersKt.u(colorScheme$$serializer);
        KSerializer<?> kSerializerU5 = BuiltinSerializersKt.u(FontAlias$$serializer.INSTANCE);
        KSerializer<?> kSerializerU6 = BuiltinSerializersKt.u(FontWeightDeserializer.INSTANCE);
        KSerializer<?> kSerializerU7 = BuiltinSerializersKt.u(IntSerializer.f142823a);
        KSerializer<?> kSerializerU8 = BuiltinSerializersKt.u(FontSizeSerializer.INSTANCE);
        KSerializer<?> kSerializerU9 = BuiltinSerializersKt.u(HorizontalAlignmentDeserializer.INSTANCE);
        KSerializer<?> kSerializerU10 = BuiltinSerializersKt.u(Size$$serializer.INSTANCE);
        Padding$$serializer padding$$serializer = Padding$$serializer.INSTANCE;
        return new KSerializer[]{kSerializerU, kSerializerU2, kSerializerU3, kSerializerU4, kSerializerU5, kSerializerU6, kSerializerU7, kSerializerU8, kSerializerU9, kSerializerU10, BuiltinSerializersKt.u(padding$$serializer), BuiltinSerializersKt.u(padding$$serializer)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public PartialTextComponent deserialize(Decoder decoder) {
        Boolean bool;
        ColorScheme colorScheme;
        ColorScheme colorScheme2;
        int i3;
        HorizontalAlignment horizontalAlignment;
        Integer num;
        FontWeight fontWeight;
        Integer num2;
        Size size;
        Padding padding;
        Padding padding2;
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderB = decoder.b(descriptor2);
        int i4 = 11;
        int i5 = 10;
        int i6 = 9;
        int i7 = 8;
        Padding padding3 = null;
        if (compositeDecoderB.p()) {
            bool = (Boolean) compositeDecoderB.n(descriptor2, 0, BooleanSerializer.f142767a, null);
            LocalizationKey localizationKey = (LocalizationKey) compositeDecoderB.n(descriptor2, 1, LocalizationKey$$serializer.INSTANCE, null);
            String strM654unboximpl = localizationKey != null ? localizationKey.m654unboximpl() : null;
            ColorScheme$$serializer colorScheme$$serializer = ColorScheme$$serializer.INSTANCE;
            ColorScheme colorScheme3 = (ColorScheme) compositeDecoderB.n(descriptor2, 2, colorScheme$$serializer, null);
            ColorScheme colorScheme4 = (ColorScheme) compositeDecoderB.n(descriptor2, 3, colorScheme$$serializer, null);
            FontAlias fontAlias = (FontAlias) compositeDecoderB.n(descriptor2, 4, FontAlias$$serializer.INSTANCE, null);
            String strM439unboximpl = fontAlias != null ? fontAlias.m439unboximpl() : null;
            FontWeight fontWeight2 = (FontWeight) compositeDecoderB.n(descriptor2, 5, FontWeightDeserializer.INSTANCE, null);
            Integer num3 = (Integer) compositeDecoderB.n(descriptor2, 6, IntSerializer.f142823a, null);
            Integer num4 = (Integer) compositeDecoderB.n(descriptor2, 7, FontSizeSerializer.INSTANCE, null);
            HorizontalAlignment horizontalAlignment2 = (HorizontalAlignment) compositeDecoderB.n(descriptor2, 8, HorizontalAlignmentDeserializer.INSTANCE, null);
            Size size2 = (Size) compositeDecoderB.n(descriptor2, 9, Size$$serializer.INSTANCE, null);
            Padding$$serializer padding$$serializer = Padding$$serializer.INSTANCE;
            Padding padding4 = (Padding) compositeDecoderB.n(descriptor2, 10, padding$$serializer, null);
            padding2 = (Padding) compositeDecoderB.n(descriptor2, 11, padding$$serializer, null);
            padding = padding4;
            size = size2;
            num2 = num4;
            num = num3;
            fontWeight = fontWeight2;
            colorScheme2 = colorScheme4;
            horizontalAlignment = horizontalAlignment2;
            str = strM439unboximpl;
            colorScheme = colorScheme3;
            str2 = strM654unboximpl;
            i3 = 4095;
        } else {
            boolean z2 = true;
            int i8 = 0;
            bool = null;
            HorizontalAlignment horizontalAlignment3 = null;
            Integer num5 = null;
            FontWeight fontWeight3 = null;
            Integer num6 = null;
            Size size3 = null;
            Padding padding5 = null;
            ColorScheme colorScheme5 = null;
            String strM439unboximpl2 = null;
            ColorScheme colorScheme6 = null;
            String strM654unboximpl2 = null;
            while (z2) {
                int iO = compositeDecoderB.o(descriptor2);
                switch (iO) {
                    case -1:
                        z2 = false;
                        i5 = 10;
                        i6 = 9;
                        i7 = 8;
                        break;
                    case 0:
                        bool = (Boolean) compositeDecoderB.n(descriptor2, 0, BooleanSerializer.f142767a, bool);
                        i8 |= 1;
                        i4 = 11;
                        i5 = 10;
                        i6 = 9;
                        i7 = 8;
                        break;
                    case 1:
                        ColorScheme colorScheme7 = colorScheme5;
                        ColorScheme colorScheme8 = colorScheme6;
                        LocalizationKey localizationKey2 = (LocalizationKey) compositeDecoderB.n(descriptor2, 1, LocalizationKey$$serializer.INSTANCE, strM654unboximpl2 != null ? LocalizationKey.m648boximpl(strM654unboximpl2) : null);
                        strM654unboximpl2 = localizationKey2 != null ? localizationKey2.m654unboximpl() : null;
                        i8 |= 2;
                        colorScheme6 = colorScheme8;
                        colorScheme5 = colorScheme7;
                        i4 = 11;
                        i5 = 10;
                        i6 = 9;
                        i7 = 8;
                        break;
                    case 2:
                        colorScheme6 = (ColorScheme) compositeDecoderB.n(descriptor2, 2, ColorScheme$$serializer.INSTANCE, colorScheme6);
                        i8 |= 4;
                        i4 = 11;
                        i5 = 10;
                        i6 = 9;
                        break;
                    case 3:
                        colorScheme5 = (ColorScheme) compositeDecoderB.n(descriptor2, 3, ColorScheme$$serializer.INSTANCE, colorScheme5);
                        i8 |= 8;
                        i4 = 11;
                        i5 = 10;
                        break;
                    case 4:
                        FontAlias fontAlias2 = (FontAlias) compositeDecoderB.n(descriptor2, 4, FontAlias$$serializer.INSTANCE, strM439unboximpl2 != null ? FontAlias.m433boximpl(strM439unboximpl2) : null);
                        strM439unboximpl2 = fontAlias2 != null ? fontAlias2.m439unboximpl() : null;
                        i8 |= 16;
                        i4 = 11;
                        i5 = 10;
                        break;
                    case 5:
                        fontWeight3 = (FontWeight) compositeDecoderB.n(descriptor2, 5, FontWeightDeserializer.INSTANCE, fontWeight3);
                        i8 |= 32;
                        i4 = 11;
                        break;
                    case 6:
                        num5 = (Integer) compositeDecoderB.n(descriptor2, 6, IntSerializer.f142823a, num5);
                        i8 |= 64;
                        i4 = 11;
                        break;
                    case 7:
                        num6 = (Integer) compositeDecoderB.n(descriptor2, 7, FontSizeSerializer.INSTANCE, num6);
                        i8 |= ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
                        i4 = 11;
                        break;
                    case 8:
                        horizontalAlignment3 = (HorizontalAlignment) compositeDecoderB.n(descriptor2, i7, HorizontalAlignmentDeserializer.INSTANCE, horizontalAlignment3);
                        i8 |= Function.MAX_NARGS;
                        break;
                    case 9:
                        size3 = (Size) compositeDecoderB.n(descriptor2, i6, Size$$serializer.INSTANCE, size3);
                        i8 |= 512;
                        break;
                    case 10:
                        padding5 = (Padding) compositeDecoderB.n(descriptor2, i5, Padding$$serializer.INSTANCE, padding5);
                        i8 |= 1024;
                        break;
                    case 11:
                        padding3 = (Padding) compositeDecoderB.n(descriptor2, i4, Padding$$serializer.INSTANCE, padding3);
                        i8 |= 2048;
                        break;
                    default:
                        throw new UnknownFieldException(iO);
                }
            }
            colorScheme = colorScheme6;
            colorScheme2 = colorScheme5;
            i3 = i8;
            horizontalAlignment = horizontalAlignment3;
            num = num5;
            fontWeight = fontWeight3;
            num2 = num6;
            size = size3;
            padding = padding5;
            padding2 = padding3;
            str = strM439unboximpl2;
            str2 = strM654unboximpl2;
        }
        Boolean bool2 = bool;
        compositeDecoderB.c(descriptor2);
        return new PartialTextComponent(i3, bool2, str2, colorScheme, colorScheme2, str, fontWeight, num, num2, horizontalAlignment, size, padding, padding2, null, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, PartialTextComponent value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderB = encoder.b(descriptor2);
        PartialTextComponent.write$Self$purchases_defaultsBc8Release(value, compositeEncoderB, descriptor2);
        compositeEncoderB.c(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }

    static {
        PartialTextComponent$$serializer partialTextComponent$$serializer = new PartialTextComponent$$serializer();
        INSTANCE = partialTextComponent$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.paywalls.components.PartialTextComponent", partialTextComponent$$serializer, 12);
        pluginGeneratedSerialDescriptor.p("visible", true);
        pluginGeneratedSerialDescriptor.p("text_lid", true);
        pluginGeneratedSerialDescriptor.p("color", true);
        pluginGeneratedSerialDescriptor.p("background_color", true);
        pluginGeneratedSerialDescriptor.p("font_name", true);
        pluginGeneratedSerialDescriptor.p("font_weight", true);
        pluginGeneratedSerialDescriptor.p("font_weight_int", true);
        pluginGeneratedSerialDescriptor.p(ViewHierarchyConstants.TEXT_SIZE, true);
        pluginGeneratedSerialDescriptor.p(AnalyticsEvents.PARAMETER_LIKE_VIEW_HORIZONTAL_ALIGNMENT, true);
        pluginGeneratedSerialDescriptor.p("size", true);
        pluginGeneratedSerialDescriptor.p(KrzujOtzIk.uSoBViLIPRLc, true);
        pluginGeneratedSerialDescriptor.p("margin", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }
}
