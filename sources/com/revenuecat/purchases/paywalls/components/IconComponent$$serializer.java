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
public final class IconComponent$$serializer implements GeneratedSerializer<IconComponent> {
    public static final IconComponent$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        IconComponent$$serializer iconComponent$$serializer = new IconComponent$$serializer();
        INSTANCE = iconComponent$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("icon", iconComponent$$serializer, 10);
        pluginGeneratedSerialDescriptor.p("base_url", false);
        pluginGeneratedSerialDescriptor.p("icon_name", false);
        pluginGeneratedSerialDescriptor.p("formats", false);
        pluginGeneratedSerialDescriptor.p("visible", true);
        pluginGeneratedSerialDescriptor.p("size", true);
        pluginGeneratedSerialDescriptor.p("color", true);
        pluginGeneratedSerialDescriptor.p("padding", true);
        pluginGeneratedSerialDescriptor.p("margin", true);
        pluginGeneratedSerialDescriptor.p("icon_background", true);
        pluginGeneratedSerialDescriptor.p("overrides", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private IconComponent$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr = IconComponent.$childSerializers;
        KSerializer<?> kSerializerU = BuiltinSerializersKt.u(BooleanSerializer.f142767a);
        KSerializer<?> kSerializerU2 = BuiltinSerializersKt.u(ColorScheme$$serializer.INSTANCE);
        KSerializer<?> kSerializerU3 = BuiltinSerializersKt.u(IconComponent$IconBackground$$serializer.INSTANCE);
        KSerializer<?> kSerializer = kSerializerArr[9];
        StringSerializer stringSerializer = StringSerializer.f142891a;
        Padding$$serializer padding$$serializer = Padding$$serializer.INSTANCE;
        return new KSerializer[]{stringSerializer, stringSerializer, IconComponent$Formats$$serializer.INSTANCE, kSerializerU, Size$$serializer.INSTANCE, kSerializerU2, padding$$serializer, padding$$serializer, kSerializerU3, kSerializer};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public IconComponent deserialize(Decoder decoder) {
        int i3;
        List list;
        IconComponent.IconBackground iconBackground;
        Padding padding;
        ColorScheme colorScheme;
        Padding padding2;
        Size size;
        Boolean bool;
        IconComponent.Formats formats;
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderB = decoder.b(descriptor2);
        KSerializer[] kSerializerArr = IconComponent.$childSerializers;
        int i4 = 9;
        String strM = null;
        if (compositeDecoderB.p()) {
            String strM2 = compositeDecoderB.m(descriptor2, 0);
            String strM3 = compositeDecoderB.m(descriptor2, 1);
            IconComponent.Formats formats2 = (IconComponent.Formats) compositeDecoderB.y(descriptor2, 2, IconComponent$Formats$$serializer.INSTANCE, null);
            Boolean bool2 = (Boolean) compositeDecoderB.n(descriptor2, 3, BooleanSerializer.f142767a, null);
            Size size2 = (Size) compositeDecoderB.y(descriptor2, 4, Size$$serializer.INSTANCE, null);
            ColorScheme colorScheme2 = (ColorScheme) compositeDecoderB.n(descriptor2, 5, ColorScheme$$serializer.INSTANCE, null);
            Padding$$serializer padding$$serializer = Padding$$serializer.INSTANCE;
            Padding padding3 = (Padding) compositeDecoderB.y(descriptor2, 6, padding$$serializer, null);
            Padding padding4 = (Padding) compositeDecoderB.y(descriptor2, 7, padding$$serializer, null);
            IconComponent.IconBackground iconBackground2 = (IconComponent.IconBackground) compositeDecoderB.n(descriptor2, 8, IconComponent$IconBackground$$serializer.INSTANCE, null);
            list = (List) compositeDecoderB.y(descriptor2, 9, kSerializerArr[9], null);
            str = strM2;
            padding = padding4;
            padding2 = padding3;
            colorScheme = colorScheme2;
            bool = bool2;
            iconBackground = iconBackground2;
            size = size2;
            formats = formats2;
            i3 = 1023;
            str2 = strM3;
        } else {
            boolean z2 = true;
            int i5 = 0;
            List list2 = null;
            IconComponent.IconBackground iconBackground3 = null;
            Padding padding5 = null;
            ColorScheme colorScheme3 = null;
            Padding padding6 = null;
            Size size3 = null;
            Boolean bool3 = null;
            IconComponent.Formats formats3 = null;
            String strM4 = null;
            while (z2) {
                int iO = compositeDecoderB.o(descriptor2);
                switch (iO) {
                    case -1:
                        z2 = false;
                        break;
                    case 0:
                        i5 |= 1;
                        strM = compositeDecoderB.m(descriptor2, 0);
                        i4 = 9;
                        break;
                    case 1:
                        strM4 = compositeDecoderB.m(descriptor2, 1);
                        i5 |= 2;
                        i4 = 9;
                        break;
                    case 2:
                        formats3 = (IconComponent.Formats) compositeDecoderB.y(descriptor2, 2, IconComponent$Formats$$serializer.INSTANCE, formats3);
                        i5 |= 4;
                        i4 = 9;
                        break;
                    case 3:
                        bool3 = (Boolean) compositeDecoderB.n(descriptor2, 3, BooleanSerializer.f142767a, bool3);
                        i5 |= 8;
                        i4 = 9;
                        break;
                    case 4:
                        size3 = (Size) compositeDecoderB.y(descriptor2, 4, Size$$serializer.INSTANCE, size3);
                        i5 |= 16;
                        i4 = 9;
                        break;
                    case 5:
                        colorScheme3 = (ColorScheme) compositeDecoderB.n(descriptor2, 5, ColorScheme$$serializer.INSTANCE, colorScheme3);
                        i5 |= 32;
                        i4 = 9;
                        break;
                    case 6:
                        padding6 = (Padding) compositeDecoderB.y(descriptor2, 6, Padding$$serializer.INSTANCE, padding6);
                        i5 |= 64;
                        i4 = 9;
                        break;
                    case 7:
                        padding5 = (Padding) compositeDecoderB.y(descriptor2, 7, Padding$$serializer.INSTANCE, padding5);
                        i5 |= ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
                        i4 = 9;
                        break;
                    case 8:
                        iconBackground3 = (IconComponent.IconBackground) compositeDecoderB.n(descriptor2, 8, IconComponent$IconBackground$$serializer.INSTANCE, iconBackground3);
                        i5 |= Function.MAX_NARGS;
                        i4 = 9;
                        break;
                    case 9:
                        list2 = (List) compositeDecoderB.y(descriptor2, i4, kSerializerArr[i4], list2);
                        i5 |= 512;
                        break;
                    default:
                        throw new UnknownFieldException(iO);
                }
            }
            i3 = i5;
            list = list2;
            iconBackground = iconBackground3;
            padding = padding5;
            colorScheme = colorScheme3;
            padding2 = padding6;
            size = size3;
            bool = bool3;
            formats = formats3;
            str = strM;
            str2 = strM4;
        }
        compositeDecoderB.c(descriptor2);
        return new IconComponent(i3, str, str2, formats, bool, size, colorScheme, padding2, padding, iconBackground, list, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, IconComponent value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderB = encoder.b(descriptor2);
        IconComponent.write$Self$purchases_defaultsBc8Release(value, compositeEncoderB, descriptor2);
        compositeEncoderB.c(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
