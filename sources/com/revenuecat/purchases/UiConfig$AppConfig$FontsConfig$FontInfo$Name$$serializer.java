package com.revenuecat.purchases;

import com.facebook.internal.AnalyticsEvents;
import com.revenuecat.purchases.UiConfig;
import com.revenuecat.purchases.paywalls.components.properties.FontStyle;
import com.revenuecat.purchases.paywalls.components.properties.FontStyleDeserializer;
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
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
@Deprecated
public final class UiConfig$AppConfig$FontsConfig$FontInfo$Name$$serializer implements GeneratedSerializer<UiConfig.AppConfig.FontsConfig.FontInfo.Name> {
    public static final UiConfig$AppConfig$FontsConfig$FontInfo$Name$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        UiConfig$AppConfig$FontsConfig$FontInfo$Name$$serializer uiConfig$AppConfig$FontsConfig$FontInfo$Name$$serializer = new UiConfig$AppConfig$FontsConfig$FontInfo$Name$$serializer();
        INSTANCE = uiConfig$AppConfig$FontsConfig$FontInfo$Name$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("name", uiConfig$AppConfig$FontsConfig$FontInfo$Name$$serializer, 6);
        pluginGeneratedSerialDescriptor.p("value", false);
        pluginGeneratedSerialDescriptor.p("url", true);
        pluginGeneratedSerialDescriptor.p("hash", true);
        pluginGeneratedSerialDescriptor.p("family", true);
        pluginGeneratedSerialDescriptor.p("weight", true);
        pluginGeneratedSerialDescriptor.p(AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private UiConfig$AppConfig$FontsConfig$FontInfo$Name$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        StringSerializer stringSerializer = StringSerializer.f142891a;
        return new KSerializer[]{stringSerializer, BuiltinSerializersKt.u(stringSerializer), BuiltinSerializersKt.u(stringSerializer), BuiltinSerializersKt.u(stringSerializer), BuiltinSerializersKt.u(IntSerializer.f142823a), BuiltinSerializersKt.u(FontStyleDeserializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public UiConfig.AppConfig.FontsConfig.FontInfo.Name deserialize(Decoder decoder) {
        int i3;
        String str;
        String str2;
        String str3;
        String str4;
        Integer num;
        FontStyle fontStyle;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderB = decoder.b(descriptor2);
        String strM = null;
        if (compositeDecoderB.p()) {
            String strM2 = compositeDecoderB.m(descriptor2, 0);
            StringSerializer stringSerializer = StringSerializer.f142891a;
            String str5 = (String) compositeDecoderB.n(descriptor2, 1, stringSerializer, null);
            String str6 = (String) compositeDecoderB.n(descriptor2, 2, stringSerializer, null);
            String str7 = (String) compositeDecoderB.n(descriptor2, 3, stringSerializer, null);
            Integer num2 = (Integer) compositeDecoderB.n(descriptor2, 4, IntSerializer.f142823a, null);
            str = strM2;
            fontStyle = (FontStyle) compositeDecoderB.n(descriptor2, 5, FontStyleDeserializer.INSTANCE, null);
            str4 = str7;
            num = num2;
            str3 = str6;
            str2 = str5;
            i3 = 63;
        } else {
            boolean z2 = true;
            int i4 = 0;
            String str8 = null;
            String str9 = null;
            String str10 = null;
            Integer num3 = null;
            FontStyle fontStyle2 = null;
            while (z2) {
                int iO = compositeDecoderB.o(descriptor2);
                switch (iO) {
                    case -1:
                        z2 = false;
                        continue;
                    case 0:
                        strM = compositeDecoderB.m(descriptor2, 0);
                        i4 |= 1;
                        continue;
                    case 1:
                        str8 = (String) compositeDecoderB.n(descriptor2, 1, StringSerializer.f142891a, str8);
                        i4 |= 2;
                        break;
                    case 2:
                        str9 = (String) compositeDecoderB.n(descriptor2, 2, StringSerializer.f142891a, str9);
                        i4 |= 4;
                        break;
                    case 3:
                        str10 = (String) compositeDecoderB.n(descriptor2, 3, StringSerializer.f142891a, str10);
                        i4 |= 8;
                        break;
                    case 4:
                        num3 = (Integer) compositeDecoderB.n(descriptor2, 4, IntSerializer.f142823a, num3);
                        i4 |= 16;
                        break;
                    case 5:
                        fontStyle2 = (FontStyle) compositeDecoderB.n(descriptor2, 5, FontStyleDeserializer.INSTANCE, fontStyle2);
                        i4 |= 32;
                        break;
                    default:
                        throw new UnknownFieldException(iO);
                }
            }
            i3 = i4;
            str = strM;
            str2 = str8;
            str3 = str9;
            str4 = str10;
            num = num3;
            fontStyle = fontStyle2;
        }
        compositeDecoderB.c(descriptor2);
        return new UiConfig.AppConfig.FontsConfig.FontInfo.Name(i3, str, str2, str3, str4, num, fontStyle, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, UiConfig.AppConfig.FontsConfig.FontInfo.Name value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderB = encoder.b(descriptor2);
        UiConfig.AppConfig.FontsConfig.FontInfo.Name.write$Self$purchases_defaultsBc8Release(value, compositeEncoderB, descriptor2);
        compositeEncoderB.c(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
