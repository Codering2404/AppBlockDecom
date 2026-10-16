package com.revenuecat.purchases.paywalls.components.common;

import com.applovin.mediation.AppLovinExtras;
import com.revenuecat.purchases.paywalls.components.common.Background;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.FitMode;
import com.revenuecat.purchases.paywalls.components.properties.FitModeDeserializer;
import com.revenuecat.purchases.paywalls.components.properties.ThemeImageUrls;
import com.revenuecat.purchases.paywalls.components.properties.ThemeImageUrls$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.ThemeVideoUrls;
import com.revenuecat.purchases.paywalls.components.properties.ThemeVideoUrls$$serializer;
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
public final class Background$Video$$serializer implements GeneratedSerializer<Background.Video> {
    public static final Background$Video$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        Background$Video$$serializer background$Video$$serializer = new Background$Video$$serializer();
        INSTANCE = background$Video$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.paywalls.components.common.Background.Video", background$Video$$serializer, 6);
        pluginGeneratedSerialDescriptor.p("value", false);
        pluginGeneratedSerialDescriptor.p("fallback_image", false);
        pluginGeneratedSerialDescriptor.p("loop", false);
        pluginGeneratedSerialDescriptor.p(AppLovinExtras.Keys.MUTE_AUDIO, false);
        pluginGeneratedSerialDescriptor.p("fit_mode", true);
        pluginGeneratedSerialDescriptor.p("color_overlay", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private Background$Video$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        KSerializer<?> kSerializerU = BuiltinSerializersKt.u(ColorScheme$$serializer.INSTANCE);
        BooleanSerializer booleanSerializer = BooleanSerializer.f142767a;
        return new KSerializer[]{ThemeVideoUrls$$serializer.INSTANCE, ThemeImageUrls$$serializer.INSTANCE, booleanSerializer, booleanSerializer, FitModeDeserializer.INSTANCE, kSerializerU};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public Background.Video deserialize(Decoder decoder) {
        boolean z2;
        boolean z3;
        int i3;
        ThemeVideoUrls themeVideoUrls;
        ThemeImageUrls themeImageUrls;
        FitMode fitMode;
        ColorScheme colorScheme;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderB = decoder.b(descriptor2);
        int i4 = 5;
        if (compositeDecoderB.p()) {
            ThemeVideoUrls themeVideoUrls2 = (ThemeVideoUrls) compositeDecoderB.y(descriptor2, 0, ThemeVideoUrls$$serializer.INSTANCE, null);
            ThemeImageUrls themeImageUrls2 = (ThemeImageUrls) compositeDecoderB.y(descriptor2, 1, ThemeImageUrls$$serializer.INSTANCE, null);
            boolean zC = compositeDecoderB.C(descriptor2, 2);
            boolean zC2 = compositeDecoderB.C(descriptor2, 3);
            FitMode fitMode2 = (FitMode) compositeDecoderB.y(descriptor2, 4, FitModeDeserializer.INSTANCE, null);
            themeVideoUrls = themeVideoUrls2;
            colorScheme = (ColorScheme) compositeDecoderB.n(descriptor2, 5, ColorScheme$$serializer.INSTANCE, null);
            z2 = zC2;
            fitMode = fitMode2;
            z3 = zC;
            themeImageUrls = themeImageUrls2;
            i3 = 63;
        } else {
            boolean z4 = true;
            boolean zC3 = false;
            int i5 = 0;
            ThemeVideoUrls themeVideoUrls3 = null;
            ThemeImageUrls themeImageUrls3 = null;
            FitMode fitMode3 = null;
            ColorScheme colorScheme2 = null;
            boolean zC4 = false;
            while (z4) {
                int iO = compositeDecoderB.o(descriptor2);
                switch (iO) {
                    case -1:
                        z4 = false;
                        i4 = 5;
                        break;
                    case 0:
                        themeVideoUrls3 = (ThemeVideoUrls) compositeDecoderB.y(descriptor2, 0, ThemeVideoUrls$$serializer.INSTANCE, themeVideoUrls3);
                        i5 |= 1;
                        i4 = 5;
                        break;
                    case 1:
                        themeImageUrls3 = (ThemeImageUrls) compositeDecoderB.y(descriptor2, 1, ThemeImageUrls$$serializer.INSTANCE, themeImageUrls3);
                        i5 |= 2;
                        break;
                    case 2:
                        zC4 = compositeDecoderB.C(descriptor2, 2);
                        i5 |= 4;
                        break;
                    case 3:
                        zC3 = compositeDecoderB.C(descriptor2, 3);
                        i5 |= 8;
                        break;
                    case 4:
                        fitMode3 = (FitMode) compositeDecoderB.y(descriptor2, 4, FitModeDeserializer.INSTANCE, fitMode3);
                        i5 |= 16;
                        break;
                    case 5:
                        colorScheme2 = (ColorScheme) compositeDecoderB.n(descriptor2, i4, ColorScheme$$serializer.INSTANCE, colorScheme2);
                        i5 |= 32;
                        break;
                    default:
                        throw new UnknownFieldException(iO);
                }
            }
            z2 = zC3;
            z3 = zC4;
            i3 = i5;
            themeVideoUrls = themeVideoUrls3;
            themeImageUrls = themeImageUrls3;
            fitMode = fitMode3;
            colorScheme = colorScheme2;
        }
        compositeDecoderB.c(descriptor2);
        return new Background.Video(i3, themeVideoUrls, themeImageUrls, z3, z2, fitMode, colorScheme, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, Background.Video value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderB = encoder.b(descriptor2);
        Background.Video.write$Self$purchases_defaultsBc8Release(value, compositeEncoderB, descriptor2);
        compositeEncoderB.c(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
