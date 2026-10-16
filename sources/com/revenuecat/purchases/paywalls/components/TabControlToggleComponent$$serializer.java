package com.revenuecat.purchases.paywalls.components;

import com.revenuecat.purchases.paywalls.components.properties.ColorScheme;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme$$serializer;
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
public final class TabControlToggleComponent$$serializer implements GeneratedSerializer<TabControlToggleComponent> {
    public static final TabControlToggleComponent$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        TabControlToggleComponent$$serializer tabControlToggleComponent$$serializer = new TabControlToggleComponent$$serializer();
        INSTANCE = tabControlToggleComponent$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("tab_control_toggle", tabControlToggleComponent$$serializer, 6);
        pluginGeneratedSerialDescriptor.p("default_value", false);
        pluginGeneratedSerialDescriptor.p("name", true);
        pluginGeneratedSerialDescriptor.p("thumb_color_on", false);
        pluginGeneratedSerialDescriptor.p("thumb_color_off", false);
        pluginGeneratedSerialDescriptor.p("track_color_on", false);
        pluginGeneratedSerialDescriptor.p("track_color_off", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private TabControlToggleComponent$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        KSerializer<?> kSerializerU = BuiltinSerializersKt.u(StringSerializer.f142891a);
        ColorScheme$$serializer colorScheme$$serializer = ColorScheme$$serializer.INSTANCE;
        return new KSerializer[]{BooleanSerializer.f142767a, kSerializerU, colorScheme$$serializer, colorScheme$$serializer, colorScheme$$serializer, colorScheme$$serializer};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public TabControlToggleComponent deserialize(Decoder decoder) {
        boolean zC;
        int i3;
        String str;
        ColorScheme colorScheme;
        ColorScheme colorScheme2;
        ColorScheme colorScheme3;
        ColorScheme colorScheme4;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderB = decoder.b(descriptor2);
        if (compositeDecoderB.p()) {
            zC = compositeDecoderB.C(descriptor2, 0);
            String str2 = (String) compositeDecoderB.n(descriptor2, 1, StringSerializer.f142891a, null);
            ColorScheme$$serializer colorScheme$$serializer = ColorScheme$$serializer.INSTANCE;
            ColorScheme colorScheme5 = (ColorScheme) compositeDecoderB.y(descriptor2, 2, colorScheme$$serializer, null);
            ColorScheme colorScheme6 = (ColorScheme) compositeDecoderB.y(descriptor2, 3, colorScheme$$serializer, null);
            ColorScheme colorScheme7 = (ColorScheme) compositeDecoderB.y(descriptor2, 4, colorScheme$$serializer, null);
            colorScheme4 = (ColorScheme) compositeDecoderB.y(descriptor2, 5, colorScheme$$serializer, null);
            colorScheme2 = colorScheme6;
            colorScheme3 = colorScheme7;
            colorScheme = colorScheme5;
            str = str2;
            i3 = 63;
        } else {
            boolean z2 = true;
            zC = false;
            String str3 = null;
            ColorScheme colorScheme8 = null;
            ColorScheme colorScheme9 = null;
            ColorScheme colorScheme10 = null;
            ColorScheme colorScheme11 = null;
            int i4 = 0;
            while (z2) {
                int iO = compositeDecoderB.o(descriptor2);
                switch (iO) {
                    case -1:
                        z2 = false;
                        continue;
                    case 0:
                        zC = compositeDecoderB.C(descriptor2, 0);
                        i4 |= 1;
                        continue;
                    case 1:
                        str3 = (String) compositeDecoderB.n(descriptor2, 1, StringSerializer.f142891a, str3);
                        i4 |= 2;
                        break;
                    case 2:
                        colorScheme8 = (ColorScheme) compositeDecoderB.y(descriptor2, 2, ColorScheme$$serializer.INSTANCE, colorScheme8);
                        i4 |= 4;
                        break;
                    case 3:
                        colorScheme9 = (ColorScheme) compositeDecoderB.y(descriptor2, 3, ColorScheme$$serializer.INSTANCE, colorScheme9);
                        i4 |= 8;
                        break;
                    case 4:
                        colorScheme10 = (ColorScheme) compositeDecoderB.y(descriptor2, 4, ColorScheme$$serializer.INSTANCE, colorScheme10);
                        i4 |= 16;
                        break;
                    case 5:
                        colorScheme11 = (ColorScheme) compositeDecoderB.y(descriptor2, 5, ColorScheme$$serializer.INSTANCE, colorScheme11);
                        i4 |= 32;
                        break;
                    default:
                        throw new UnknownFieldException(iO);
                }
            }
            i3 = i4;
            str = str3;
            colorScheme = colorScheme8;
            colorScheme2 = colorScheme9;
            colorScheme3 = colorScheme10;
            colorScheme4 = colorScheme11;
        }
        boolean z3 = zC;
        compositeDecoderB.c(descriptor2);
        return new TabControlToggleComponent(i3, z3, str, colorScheme, colorScheme2, colorScheme3, colorScheme4, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, TabControlToggleComponent value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderB = encoder.b(descriptor2);
        TabControlToggleComponent.write$Self$purchases_defaultsBc8Release(value, compositeEncoderB, descriptor2);
        compositeEncoderB.c(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
