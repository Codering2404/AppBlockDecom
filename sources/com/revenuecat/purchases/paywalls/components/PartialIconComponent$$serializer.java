package com.revenuecat.purchases.paywalls.components;

import com.revenuecat.purchases.paywalls.components.IconComponent;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Padding;
import com.revenuecat.purchases.paywalls.components.properties.Padding$$serializer;
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
public final class PartialIconComponent$$serializer implements GeneratedSerializer<PartialIconComponent> {
    public static final PartialIconComponent$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        PartialIconComponent$$serializer partialIconComponent$$serializer = new PartialIconComponent$$serializer();
        INSTANCE = partialIconComponent$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.paywalls.components.PartialIconComponent", partialIconComponent$$serializer, 9);
        pluginGeneratedSerialDescriptor.p("visible", true);
        pluginGeneratedSerialDescriptor.p("base_url", true);
        pluginGeneratedSerialDescriptor.p("icon_name", true);
        pluginGeneratedSerialDescriptor.p("formats", true);
        pluginGeneratedSerialDescriptor.p("size", true);
        pluginGeneratedSerialDescriptor.p("color", true);
        pluginGeneratedSerialDescriptor.p("padding", true);
        pluginGeneratedSerialDescriptor.p("margin", true);
        pluginGeneratedSerialDescriptor.p("icon_background", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private PartialIconComponent$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        KSerializer<?> kSerializerU = BuiltinSerializersKt.u(BooleanSerializer.f142767a);
        StringSerializer stringSerializer = StringSerializer.f142891a;
        KSerializer<?> kSerializerU2 = BuiltinSerializersKt.u(stringSerializer);
        KSerializer<?> kSerializerU3 = BuiltinSerializersKt.u(stringSerializer);
        KSerializer<?> kSerializerU4 = BuiltinSerializersKt.u(IconComponent$Formats$$serializer.INSTANCE);
        KSerializer<?> kSerializerU5 = BuiltinSerializersKt.u(Size$$serializer.INSTANCE);
        KSerializer<?> kSerializerU6 = BuiltinSerializersKt.u(ColorScheme$$serializer.INSTANCE);
        Padding$$serializer padding$$serializer = Padding$$serializer.INSTANCE;
        return new KSerializer[]{kSerializerU, kSerializerU2, kSerializerU3, kSerializerU4, kSerializerU5, kSerializerU6, BuiltinSerializersKt.u(padding$$serializer), BuiltinSerializersKt.u(padding$$serializer), BuiltinSerializersKt.u(IconComponent$IconBackground$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public PartialIconComponent deserialize(Decoder decoder) {
        int i3;
        Padding padding;
        IconComponent.IconBackground iconBackground;
        Padding padding2;
        ColorScheme colorScheme;
        Size size;
        Boolean bool;
        String str;
        String str2;
        IconComponent.Formats formats;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderB = decoder.b(descriptor2);
        int i4 = 7;
        Boolean bool2 = null;
        if (compositeDecoderB.p()) {
            Boolean bool3 = (Boolean) compositeDecoderB.n(descriptor2, 0, BooleanSerializer.f142767a, null);
            StringSerializer stringSerializer = StringSerializer.f142891a;
            String str3 = (String) compositeDecoderB.n(descriptor2, 1, stringSerializer, null);
            String str4 = (String) compositeDecoderB.n(descriptor2, 2, stringSerializer, null);
            IconComponent.Formats formats2 = (IconComponent.Formats) compositeDecoderB.n(descriptor2, 3, IconComponent$Formats$$serializer.INSTANCE, null);
            Size size2 = (Size) compositeDecoderB.n(descriptor2, 4, Size$$serializer.INSTANCE, null);
            ColorScheme colorScheme2 = (ColorScheme) compositeDecoderB.n(descriptor2, 5, ColorScheme$$serializer.INSTANCE, null);
            Padding$$serializer padding$$serializer = Padding$$serializer.INSTANCE;
            Padding padding3 = (Padding) compositeDecoderB.n(descriptor2, 6, padding$$serializer, null);
            bool = bool3;
            padding = (Padding) compositeDecoderB.n(descriptor2, 7, padding$$serializer, null);
            padding2 = padding3;
            colorScheme = colorScheme2;
            formats = formats2;
            iconBackground = (IconComponent.IconBackground) compositeDecoderB.n(descriptor2, 8, IconComponent$IconBackground$$serializer.INSTANCE, null);
            size = size2;
            str2 = str4;
            str = str3;
            i3 = 511;
        } else {
            boolean z2 = true;
            int i5 = 0;
            Padding padding4 = null;
            IconComponent.IconBackground iconBackground2 = null;
            Padding padding5 = null;
            ColorScheme colorScheme3 = null;
            Size size3 = null;
            String str5 = null;
            String str6 = null;
            IconComponent.Formats formats3 = null;
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
                        str5 = (String) compositeDecoderB.n(descriptor2, 1, StringSerializer.f142891a, str5);
                        i5 |= 2;
                        i4 = 7;
                        break;
                    case 2:
                        str6 = (String) compositeDecoderB.n(descriptor2, 2, StringSerializer.f142891a, str6);
                        i5 |= 4;
                        i4 = 7;
                        break;
                    case 3:
                        formats3 = (IconComponent.Formats) compositeDecoderB.n(descriptor2, 3, IconComponent$Formats$$serializer.INSTANCE, formats3);
                        i5 |= 8;
                        i4 = 7;
                        break;
                    case 4:
                        size3 = (Size) compositeDecoderB.n(descriptor2, 4, Size$$serializer.INSTANCE, size3);
                        i5 |= 16;
                        i4 = 7;
                        break;
                    case 5:
                        colorScheme3 = (ColorScheme) compositeDecoderB.n(descriptor2, 5, ColorScheme$$serializer.INSTANCE, colorScheme3);
                        i5 |= 32;
                        i4 = 7;
                        break;
                    case 6:
                        padding5 = (Padding) compositeDecoderB.n(descriptor2, 6, Padding$$serializer.INSTANCE, padding5);
                        i5 |= 64;
                        break;
                    case 7:
                        padding4 = (Padding) compositeDecoderB.n(descriptor2, i4, Padding$$serializer.INSTANCE, padding4);
                        i5 |= ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
                        break;
                    case 8:
                        iconBackground2 = (IconComponent.IconBackground) compositeDecoderB.n(descriptor2, 8, IconComponent$IconBackground$$serializer.INSTANCE, iconBackground2);
                        i5 |= Function.MAX_NARGS;
                        break;
                    default:
                        throw new UnknownFieldException(iO);
                }
            }
            i3 = i5;
            padding = padding4;
            iconBackground = iconBackground2;
            padding2 = padding5;
            colorScheme = colorScheme3;
            size = size3;
            bool = bool2;
            str = str5;
            str2 = str6;
            formats = formats3;
        }
        compositeDecoderB.c(descriptor2);
        return new PartialIconComponent(i3, bool, str, str2, formats, size, colorScheme, padding2, padding, iconBackground, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, PartialIconComponent value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderB = encoder.b(descriptor2);
        PartialIconComponent.write$Self$purchases_defaultsBc8Release(value, compositeEncoderB, descriptor2);
        compositeEncoderB.c(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
