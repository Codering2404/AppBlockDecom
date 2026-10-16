package com.revenuecat.purchases.paywalls;

import com.revenuecat.purchases.paywalls.PaywallData;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.revenuecat.purchases.utils.serializers.OptionalURLSerializer;
import com.sun.jna.Function;
import java.net.URL;
import java.util.List;
import java.util.Map;
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
public final class PaywallData$Configuration$$serializer implements GeneratedSerializer<PaywallData.Configuration> {
    public static final PaywallData$Configuration$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        PaywallData$Configuration$$serializer paywallData$Configuration$$serializer = new PaywallData$Configuration$$serializer();
        INSTANCE = paywallData$Configuration$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.paywalls.PaywallData.Configuration", paywallData$Configuration$$serializer, 13);
        pluginGeneratedSerialDescriptor.p("packages", true);
        pluginGeneratedSerialDescriptor.p("default_package", true);
        pluginGeneratedSerialDescriptor.p("images_webp", true);
        pluginGeneratedSerialDescriptor.p("images", true);
        pluginGeneratedSerialDescriptor.p("images_by_tier", true);
        pluginGeneratedSerialDescriptor.p("blurred_background_image", true);
        pluginGeneratedSerialDescriptor.p("display_restore_purchases", true);
        pluginGeneratedSerialDescriptor.p("tos_url", true);
        pluginGeneratedSerialDescriptor.p("privacy_url", true);
        pluginGeneratedSerialDescriptor.p("colors", false);
        pluginGeneratedSerialDescriptor.p("colors_by_tier", true);
        pluginGeneratedSerialDescriptor.p("tiers", true);
        pluginGeneratedSerialDescriptor.p("default_tier", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private PaywallData$Configuration$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr = PaywallData.Configuration.$childSerializers;
        KSerializer<?> kSerializer = kSerializerArr[0];
        StringSerializer stringSerializer = StringSerializer.f142891a;
        KSerializer<?> kSerializerU = BuiltinSerializersKt.u(stringSerializer);
        PaywallData$Configuration$Images$$serializer paywallData$Configuration$Images$$serializer = PaywallData$Configuration$Images$$serializer.INSTANCE;
        KSerializer<?> kSerializerU2 = BuiltinSerializersKt.u(paywallData$Configuration$Images$$serializer);
        KSerializer<?> kSerializerU3 = BuiltinSerializersKt.u(paywallData$Configuration$Images$$serializer);
        KSerializer<?> kSerializerU4 = BuiltinSerializersKt.u(kSerializerArr[4]);
        OptionalURLSerializer optionalURLSerializer = OptionalURLSerializer.INSTANCE;
        KSerializer<?> kSerializerU5 = BuiltinSerializersKt.u(optionalURLSerializer);
        KSerializer<?> kSerializerU6 = BuiltinSerializersKt.u(optionalURLSerializer);
        KSerializer<?> kSerializerU7 = BuiltinSerializersKt.u(kSerializerArr[10]);
        KSerializer<?> kSerializerU8 = BuiltinSerializersKt.u(kSerializerArr[11]);
        KSerializer<?> kSerializerU9 = BuiltinSerializersKt.u(stringSerializer);
        BooleanSerializer booleanSerializer = BooleanSerializer.f142767a;
        return new KSerializer[]{kSerializer, kSerializerU, kSerializerU2, kSerializerU3, kSerializerU4, booleanSerializer, booleanSerializer, kSerializerU5, kSerializerU6, PaywallData$Configuration$ColorInformation$$serializer.INSTANCE, kSerializerU7, kSerializerU8, kSerializerU9};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public PaywallData.Configuration deserialize(Decoder decoder) {
        int i3;
        String str;
        String str2;
        Map map;
        PaywallData.Configuration.ColorInformation colorInformation;
        URL url;
        Map map2;
        List list;
        PaywallData.Configuration.Images images;
        List list2;
        URL url2;
        PaywallData.Configuration.Images images2;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderB = decoder.b(descriptor2);
        KSerializer[] kSerializerArr = PaywallData.Configuration.$childSerializers;
        if (compositeDecoderB.p()) {
            List list3 = (List) compositeDecoderB.y(descriptor2, 0, kSerializerArr[0], null);
            StringSerializer stringSerializer = StringSerializer.f142891a;
            String str3 = (String) compositeDecoderB.n(descriptor2, 1, stringSerializer, null);
            PaywallData$Configuration$Images$$serializer paywallData$Configuration$Images$$serializer = PaywallData$Configuration$Images$$serializer.INSTANCE;
            PaywallData.Configuration.Images images3 = (PaywallData.Configuration.Images) compositeDecoderB.n(descriptor2, 2, paywallData$Configuration$Images$$serializer, null);
            PaywallData.Configuration.Images images4 = (PaywallData.Configuration.Images) compositeDecoderB.n(descriptor2, 3, paywallData$Configuration$Images$$serializer, null);
            Map map3 = (Map) compositeDecoderB.n(descriptor2, 4, kSerializerArr[4], null);
            boolean zC = compositeDecoderB.C(descriptor2, 5);
            boolean zC2 = compositeDecoderB.C(descriptor2, 6);
            OptionalURLSerializer optionalURLSerializer = OptionalURLSerializer.INSTANCE;
            URL url3 = (URL) compositeDecoderB.n(descriptor2, 7, optionalURLSerializer, null);
            URL url4 = (URL) compositeDecoderB.n(descriptor2, 8, optionalURLSerializer, null);
            PaywallData.Configuration.ColorInformation colorInformation2 = (PaywallData.Configuration.ColorInformation) compositeDecoderB.y(descriptor2, 9, PaywallData$Configuration$ColorInformation$$serializer.INSTANCE, null);
            Map map4 = (Map) compositeDecoderB.n(descriptor2, 10, kSerializerArr[10], null);
            i3 = 8191;
            list = (List) compositeDecoderB.n(descriptor2, 11, kSerializerArr[11], null);
            list2 = list3;
            str2 = (String) compositeDecoderB.n(descriptor2, 12, stringSerializer, null);
            colorInformation = colorInformation2;
            url2 = url3;
            z2 = zC2;
            z3 = zC;
            images = images4;
            url = url4;
            images2 = images3;
            map2 = map3;
            str = str3;
            map = map4;
        } else {
            boolean zC3 = false;
            boolean zC4 = false;
            String str4 = null;
            Map map5 = null;
            PaywallData.Configuration.ColorInformation colorInformation3 = null;
            URL url5 = null;
            Map map6 = null;
            List list4 = null;
            PaywallData.Configuration.Images images5 = null;
            List list5 = null;
            int i4 = 4;
            boolean z6 = true;
            i3 = 0;
            String str5 = null;
            URL url6 = null;
            PaywallData.Configuration.Images images6 = null;
            while (true) {
                boolean z7 = zC3;
                if (z6) {
                    int iO = compositeDecoderB.o(descriptor2);
                    switch (iO) {
                        case -1:
                            z5 = zC4;
                            z6 = false;
                            zC3 = z7;
                            zC4 = z5;
                            i4 = 4;
                            break;
                        case 0:
                            z5 = zC4;
                            list5 = (List) compositeDecoderB.y(descriptor2, 0, kSerializerArr[0], list5);
                            i3 |= 1;
                            zC3 = z7;
                            zC4 = z5;
                            i4 = 4;
                            break;
                        case 1:
                            z5 = zC4;
                            str5 = (String) compositeDecoderB.n(descriptor2, 1, StringSerializer.f142891a, str5);
                            i3 |= 2;
                            zC3 = z7;
                            zC4 = z5;
                            i4 = 4;
                            break;
                        case 2:
                            z5 = zC4;
                            images6 = (PaywallData.Configuration.Images) compositeDecoderB.n(descriptor2, 2, PaywallData$Configuration$Images$$serializer.INSTANCE, images6);
                            i3 |= 4;
                            zC3 = z7;
                            zC4 = z5;
                            i4 = 4;
                            break;
                        case 3:
                            z5 = zC4;
                            images5 = (PaywallData.Configuration.Images) compositeDecoderB.n(descriptor2, 3, PaywallData$Configuration$Images$$serializer.INSTANCE, images5);
                            i3 |= 8;
                            zC3 = z7;
                            zC4 = z5;
                            i4 = 4;
                            break;
                        case 4:
                            z4 = zC4;
                            map6 = (Map) compositeDecoderB.n(descriptor2, i4, kSerializerArr[i4], map6);
                            i3 |= 16;
                            zC3 = z7;
                            zC4 = z4;
                            break;
                        case 5:
                            i3 |= 32;
                            zC4 = compositeDecoderB.C(descriptor2, 5);
                            zC3 = z7;
                            break;
                        case 6:
                            z4 = zC4;
                            i3 |= 64;
                            zC3 = compositeDecoderB.C(descriptor2, 6);
                            zC4 = z4;
                            break;
                        case 7:
                            z4 = zC4;
                            url6 = (URL) compositeDecoderB.n(descriptor2, 7, OptionalURLSerializer.INSTANCE, url6);
                            i3 |= ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
                            zC3 = z7;
                            zC4 = z4;
                            break;
                        case 8:
                            z4 = zC4;
                            url5 = (URL) compositeDecoderB.n(descriptor2, 8, OptionalURLSerializer.INSTANCE, url5);
                            i3 |= Function.MAX_NARGS;
                            zC3 = z7;
                            zC4 = z4;
                            break;
                        case 9:
                            z4 = zC4;
                            colorInformation3 = (PaywallData.Configuration.ColorInformation) compositeDecoderB.y(descriptor2, 9, PaywallData$Configuration$ColorInformation$$serializer.INSTANCE, colorInformation3);
                            i3 |= 512;
                            zC3 = z7;
                            zC4 = z4;
                            break;
                        case 10:
                            z4 = zC4;
                            map5 = (Map) compositeDecoderB.n(descriptor2, 10, kSerializerArr[10], map5);
                            i3 |= 1024;
                            zC3 = z7;
                            zC4 = z4;
                            break;
                        case 11:
                            z4 = zC4;
                            list4 = (List) compositeDecoderB.n(descriptor2, 11, kSerializerArr[11], list4);
                            i3 |= 2048;
                            zC3 = z7;
                            zC4 = z4;
                            break;
                        case 12:
                            z4 = zC4;
                            str4 = (String) compositeDecoderB.n(descriptor2, 12, StringSerializer.f142891a, str4);
                            i3 |= 4096;
                            zC3 = z7;
                            zC4 = z4;
                            break;
                        default:
                            throw new UnknownFieldException(iO);
                    }
                } else {
                    str = str5;
                    str2 = str4;
                    map = map5;
                    colorInformation = colorInformation3;
                    url = url5;
                    map2 = map6;
                    list = list4;
                    images = images5;
                    list2 = list5;
                    url2 = url6;
                    images2 = images6;
                    z2 = z7;
                    z3 = zC4;
                }
            }
        }
        int i5 = i3;
        compositeDecoderB.c(descriptor2);
        return new PaywallData.Configuration(i5, list2, str, images2, images, map2, z3, z2, url2, url, colorInformation, map, list, str2, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, PaywallData.Configuration value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderB = encoder.b(descriptor2);
        PaywallData.Configuration.write$Self$purchases_defaultsBc8Release(value, compositeEncoderB, descriptor2);
        compositeEncoderB.c(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
