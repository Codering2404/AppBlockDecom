package com.revenuecat.purchases.paywalls;

import com.revenuecat.purchases.paywalls.PaywallData;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.revenuecat.purchases.utils.serializers.GoogleListSerializer;
import com.revenuecat.purchases.utils.serializers.URLSerializer;
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
/* JADX INFO: loaded from: classes6.dex */
@Metadata
@Deprecated
public final class PaywallData$$serializer implements GeneratedSerializer<PaywallData> {
    public static final PaywallData$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        PaywallData$$serializer paywallData$$serializer = new PaywallData$$serializer();
        INSTANCE = paywallData$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.paywalls.PaywallData", paywallData$$serializer, 9);
        pluginGeneratedSerialDescriptor.p("id", true);
        pluginGeneratedSerialDescriptor.p("template_name", false);
        pluginGeneratedSerialDescriptor.p("config", false);
        pluginGeneratedSerialDescriptor.p("asset_base_url", false);
        pluginGeneratedSerialDescriptor.p("revision", true);
        pluginGeneratedSerialDescriptor.p("localized_strings", false);
        pluginGeneratedSerialDescriptor.p("localized_strings_by_tier", true);
        pluginGeneratedSerialDescriptor.p("zero_decimal_place_countries", true);
        pluginGeneratedSerialDescriptor.p("default_locale", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private PaywallData$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr = PaywallData.$childSerializers;
        StringSerializer stringSerializer = StringSerializer.f142891a;
        return new KSerializer[]{BuiltinSerializersKt.u(stringSerializer), stringSerializer, PaywallData$Configuration$$serializer.INSTANCE, URLSerializer.INSTANCE, IntSerializer.f142823a, kSerializerArr[5], kSerializerArr[6], GoogleListSerializer.INSTANCE, BuiltinSerializersKt.u(stringSerializer)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public PaywallData deserialize(Decoder decoder) {
        int i3;
        Map map;
        List list;
        Map map2;
        String str;
        URL url;
        PaywallData.Configuration configuration;
        int i4;
        String str2;
        String str3;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderB = decoder.b(descriptor2);
        KSerializer[] kSerializerArr = PaywallData.$childSerializers;
        int i5 = 7;
        int i6 = 8;
        int i7 = 6;
        if (compositeDecoderB.p()) {
            StringSerializer stringSerializer = StringSerializer.f142891a;
            String str4 = (String) compositeDecoderB.n(descriptor2, 0, stringSerializer, null);
            String strM = compositeDecoderB.m(descriptor2, 1);
            PaywallData.Configuration configuration2 = (PaywallData.Configuration) compositeDecoderB.y(descriptor2, 2, PaywallData$Configuration$$serializer.INSTANCE, null);
            URL url2 = (URL) compositeDecoderB.y(descriptor2, 3, URLSerializer.INSTANCE, null);
            int i8 = compositeDecoderB.i(descriptor2, 4);
            Map map3 = (Map) compositeDecoderB.y(descriptor2, 5, kSerializerArr[5], null);
            Map map4 = (Map) compositeDecoderB.y(descriptor2, 6, kSerializerArr[6], null);
            List list2 = (List) compositeDecoderB.y(descriptor2, 7, GoogleListSerializer.INSTANCE, null);
            map = map4;
            str = (String) compositeDecoderB.n(descriptor2, 8, stringSerializer, null);
            list = list2;
            url = url2;
            i3 = 511;
            i4 = i8;
            configuration = configuration2;
            map2 = map3;
            str3 = strM;
            str2 = str4;
        } else {
            int i9 = 5;
            boolean z2 = true;
            int i10 = 0;
            Map map5 = null;
            List list3 = null;
            Map map6 = null;
            String str5 = null;
            URL url3 = null;
            String str6 = null;
            String strM2 = null;
            int i11 = 0;
            PaywallData.Configuration configuration3 = null;
            while (z2) {
                int i12 = i7;
                int iO = compositeDecoderB.o(descriptor2);
                switch (iO) {
                    case -1:
                        z2 = false;
                        i6 = 8;
                        i7 = 6;
                        i9 = 5;
                        break;
                    case 0:
                        str6 = (String) compositeDecoderB.n(descriptor2, 0, StringSerializer.f142891a, str6);
                        i10 |= 1;
                        i5 = 7;
                        i6 = 8;
                        i7 = 6;
                        i9 = 5;
                        break;
                    case 1:
                        strM2 = compositeDecoderB.m(descriptor2, 1);
                        i10 |= 2;
                        i5 = 7;
                        i6 = 8;
                        i7 = 6;
                        i9 = 5;
                        break;
                    case 2:
                        configuration3 = (PaywallData.Configuration) compositeDecoderB.y(descriptor2, 2, PaywallData$Configuration$$serializer.INSTANCE, configuration3);
                        i10 |= 4;
                        i5 = 7;
                        i6 = 8;
                        i7 = 6;
                        i9 = 5;
                        break;
                    case 3:
                        url3 = (URL) compositeDecoderB.y(descriptor2, 3, URLSerializer.INSTANCE, url3);
                        i10 |= 8;
                        i5 = 7;
                        i6 = 8;
                        i7 = 6;
                        i9 = 5;
                        break;
                    case 4:
                        i11 = compositeDecoderB.i(descriptor2, 4);
                        i10 |= 16;
                        i5 = 7;
                        i7 = 6;
                        break;
                    case 5:
                        map6 = (Map) compositeDecoderB.y(descriptor2, i9, kSerializerArr[i9], map6);
                        i10 |= 32;
                        i5 = 7;
                        i7 = 6;
                        break;
                    case 6:
                        map5 = (Map) compositeDecoderB.y(descriptor2, i12, kSerializerArr[i12], map5);
                        i10 |= 64;
                        i7 = i12;
                        i5 = 7;
                        break;
                    case 7:
                        list3 = (List) compositeDecoderB.y(descriptor2, i5, GoogleListSerializer.INSTANCE, list3);
                        i10 |= ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
                        i7 = i12;
                        break;
                    case 8:
                        str5 = (String) compositeDecoderB.n(descriptor2, i6, StringSerializer.f142891a, str5);
                        i10 |= Function.MAX_NARGS;
                        i7 = i12;
                        break;
                    default:
                        throw new UnknownFieldException(iO);
                }
            }
            i3 = i10;
            map = map5;
            list = list3;
            map2 = map6;
            str = str5;
            url = url3;
            configuration = configuration3;
            i4 = i11;
            str2 = str6;
            str3 = strM2;
        }
        compositeDecoderB.c(descriptor2);
        return new PaywallData(i3, str2, str3, configuration, url, i4, map2, map, list, str, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, PaywallData value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderB = encoder.b(descriptor2);
        PaywallData.write$Self$purchases_defaultsBc8Release(value, compositeEncoderB, descriptor2);
        compositeEncoderB.c(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
