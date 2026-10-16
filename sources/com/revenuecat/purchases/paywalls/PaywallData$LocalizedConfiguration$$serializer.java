package com.revenuecat.purchases.paywalls;

import com.revenuecat.purchases.paywalls.PaywallData;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
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
public final class PaywallData$LocalizedConfiguration$$serializer implements GeneratedSerializer<PaywallData.LocalizedConfiguration> {
    public static final PaywallData$LocalizedConfiguration$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        PaywallData$LocalizedConfiguration$$serializer paywallData$LocalizedConfiguration$$serializer = new PaywallData$LocalizedConfiguration$$serializer();
        INSTANCE = paywallData$LocalizedConfiguration$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.paywalls.PaywallData.LocalizedConfiguration", paywallData$LocalizedConfiguration$$serializer, 12);
        pluginGeneratedSerialDescriptor.p("title", false);
        pluginGeneratedSerialDescriptor.p("subtitle", true);
        pluginGeneratedSerialDescriptor.p("call_to_action", false);
        pluginGeneratedSerialDescriptor.p("call_to_action_with_intro_offer", true);
        pluginGeneratedSerialDescriptor.p("call_to_action_with_multiple_intro_offers", true);
        pluginGeneratedSerialDescriptor.p("offer_details", true);
        pluginGeneratedSerialDescriptor.p("offer_details_with_intro_offer", true);
        pluginGeneratedSerialDescriptor.p("offer_details_with_multiple_intro_offers", true);
        pluginGeneratedSerialDescriptor.p("offer_name", true);
        pluginGeneratedSerialDescriptor.p("features", true);
        pluginGeneratedSerialDescriptor.p("tier_name", true);
        pluginGeneratedSerialDescriptor.p("offer_overrides", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private PaywallData$LocalizedConfiguration$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr = PaywallData.LocalizedConfiguration.$childSerializers;
        EmptyStringToNullSerializer emptyStringToNullSerializer = EmptyStringToNullSerializer.INSTANCE;
        KSerializer<?> kSerializerU = BuiltinSerializersKt.u(emptyStringToNullSerializer);
        KSerializer<?> kSerializerU2 = BuiltinSerializersKt.u(emptyStringToNullSerializer);
        KSerializer<?> kSerializerU3 = BuiltinSerializersKt.u(emptyStringToNullSerializer);
        KSerializer<?> kSerializerU4 = BuiltinSerializersKt.u(emptyStringToNullSerializer);
        KSerializer<?> kSerializerU5 = BuiltinSerializersKt.u(emptyStringToNullSerializer);
        KSerializer<?> kSerializerU6 = BuiltinSerializersKt.u(emptyStringToNullSerializer);
        KSerializer<?> kSerializerU7 = BuiltinSerializersKt.u(emptyStringToNullSerializer);
        KSerializer<?> kSerializer = kSerializerArr[9];
        KSerializer<?> kSerializerU8 = BuiltinSerializersKt.u(emptyStringToNullSerializer);
        KSerializer<?> kSerializer2 = kSerializerArr[11];
        StringSerializer stringSerializer = StringSerializer.f142891a;
        return new KSerializer[]{stringSerializer, kSerializerU, stringSerializer, kSerializerU2, kSerializerU3, kSerializerU4, kSerializerU5, kSerializerU6, kSerializerU7, kSerializer, kSerializerU8, kSerializer2};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public PaywallData.LocalizedConfiguration deserialize(Decoder decoder) {
        int i3;
        String str;
        List list;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        Map map;
        String str8;
        String str9;
        String str10;
        KSerializer[] kSerializerArr;
        KSerializer[] kSerializerArr2;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderB = decoder.b(descriptor2);
        KSerializer[] kSerializerArr3 = PaywallData.LocalizedConfiguration.$childSerializers;
        if (compositeDecoderB.p()) {
            String strM = compositeDecoderB.m(descriptor2, 0);
            EmptyStringToNullSerializer emptyStringToNullSerializer = EmptyStringToNullSerializer.INSTANCE;
            String str11 = (String) compositeDecoderB.n(descriptor2, 1, emptyStringToNullSerializer, null);
            String strM2 = compositeDecoderB.m(descriptor2, 2);
            String str12 = (String) compositeDecoderB.n(descriptor2, 3, emptyStringToNullSerializer, null);
            String str13 = (String) compositeDecoderB.n(descriptor2, 4, emptyStringToNullSerializer, null);
            String str14 = (String) compositeDecoderB.n(descriptor2, 5, emptyStringToNullSerializer, null);
            String str15 = (String) compositeDecoderB.n(descriptor2, 6, emptyStringToNullSerializer, null);
            String str16 = (String) compositeDecoderB.n(descriptor2, 7, emptyStringToNullSerializer, null);
            String str17 = (String) compositeDecoderB.n(descriptor2, 8, emptyStringToNullSerializer, null);
            List list2 = (List) compositeDecoderB.y(descriptor2, 9, kSerializerArr3[9], null);
            String str18 = (String) compositeDecoderB.n(descriptor2, 10, emptyStringToNullSerializer, null);
            i3 = 4095;
            map = (Map) compositeDecoderB.y(descriptor2, 11, kSerializerArr3[11], null);
            str = strM;
            list = list2;
            str3 = str16;
            str6 = str15;
            str4 = str14;
            str8 = str12;
            str2 = str17;
            str7 = str13;
            str10 = strM2;
            str5 = str18;
            str9 = str11;
        } else {
            int i4 = 11;
            String strM3 = null;
            List list3 = null;
            String str19 = null;
            String str20 = null;
            String str21 = null;
            String str22 = null;
            String str23 = null;
            String str24 = null;
            String strM4 = null;
            int i5 = 9;
            boolean z2 = true;
            Map map2 = null;
            String str25 = null;
            i3 = 0;
            String str26 = null;
            while (z2) {
                int i6 = i4;
                int iO = compositeDecoderB.o(descriptor2);
                switch (iO) {
                    case -1:
                        kSerializerArr = kSerializerArr3;
                        z2 = false;
                        kSerializerArr3 = kSerializerArr;
                        i4 = 11;
                        i5 = 9;
                        break;
                    case 0:
                        kSerializerArr = kSerializerArr3;
                        strM3 = compositeDecoderB.m(descriptor2, 0);
                        i3 |= 1;
                        kSerializerArr3 = kSerializerArr;
                        i4 = 11;
                        i5 = 9;
                        break;
                    case 1:
                        kSerializerArr = kSerializerArr3;
                        str26 = (String) compositeDecoderB.n(descriptor2, 1, EmptyStringToNullSerializer.INSTANCE, str26);
                        i3 |= 2;
                        kSerializerArr3 = kSerializerArr;
                        i4 = 11;
                        i5 = 9;
                        break;
                    case 2:
                        kSerializerArr = kSerializerArr3;
                        strM4 = compositeDecoderB.m(descriptor2, 2);
                        i3 |= 4;
                        kSerializerArr3 = kSerializerArr;
                        i4 = 11;
                        i5 = 9;
                        break;
                    case 3:
                        kSerializerArr = kSerializerArr3;
                        str25 = (String) compositeDecoderB.n(descriptor2, 3, EmptyStringToNullSerializer.INSTANCE, str25);
                        i3 |= 8;
                        kSerializerArr3 = kSerializerArr;
                        i4 = 11;
                        i5 = 9;
                        break;
                    case 4:
                        kSerializerArr = kSerializerArr3;
                        str24 = (String) compositeDecoderB.n(descriptor2, 4, EmptyStringToNullSerializer.INSTANCE, str24);
                        i3 |= 16;
                        kSerializerArr3 = kSerializerArr;
                        i4 = 11;
                        i5 = 9;
                        break;
                    case 5:
                        kSerializerArr = kSerializerArr3;
                        str21 = (String) compositeDecoderB.n(descriptor2, 5, EmptyStringToNullSerializer.INSTANCE, str21);
                        i3 |= 32;
                        kSerializerArr3 = kSerializerArr;
                        i4 = 11;
                        i5 = 9;
                        break;
                    case 6:
                        kSerializerArr = kSerializerArr3;
                        str23 = (String) compositeDecoderB.n(descriptor2, 6, EmptyStringToNullSerializer.INSTANCE, str23);
                        i3 |= 64;
                        kSerializerArr3 = kSerializerArr;
                        i4 = 11;
                        i5 = 9;
                        break;
                    case 7:
                        kSerializerArr = kSerializerArr3;
                        str20 = (String) compositeDecoderB.n(descriptor2, 7, EmptyStringToNullSerializer.INSTANCE, str20);
                        i3 |= ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
                        kSerializerArr3 = kSerializerArr;
                        i4 = 11;
                        i5 = 9;
                        break;
                    case 8:
                        kSerializerArr = kSerializerArr3;
                        str19 = (String) compositeDecoderB.n(descriptor2, 8, EmptyStringToNullSerializer.INSTANCE, str19);
                        i3 |= Function.MAX_NARGS;
                        kSerializerArr3 = kSerializerArr;
                        i4 = 11;
                        i5 = 9;
                        break;
                    case 9:
                        kSerializerArr2 = kSerializerArr3;
                        list3 = (List) compositeDecoderB.y(descriptor2, i5, kSerializerArr2[i5], list3);
                        i3 |= 512;
                        kSerializerArr3 = kSerializerArr2;
                        i4 = 11;
                        break;
                    case 10:
                        kSerializerArr2 = kSerializerArr3;
                        str22 = (String) compositeDecoderB.n(descriptor2, 10, EmptyStringToNullSerializer.INSTANCE, str22);
                        i3 |= 1024;
                        kSerializerArr3 = kSerializerArr2;
                        i4 = 11;
                        break;
                    case 11:
                        map2 = (Map) compositeDecoderB.y(descriptor2, i6, kSerializerArr3[i6], map2);
                        i3 |= 2048;
                        i4 = i6;
                        kSerializerArr3 = kSerializerArr3;
                        break;
                    default:
                        throw new UnknownFieldException(iO);
                }
            }
            str = strM3;
            list = list3;
            str2 = str19;
            str3 = str20;
            str4 = str21;
            str5 = str22;
            str6 = str23;
            str7 = str24;
            map = map2;
            str8 = str25;
            str9 = str26;
            str10 = strM4;
        }
        int i7 = i3;
        compositeDecoderB.c(descriptor2);
        return new PaywallData.LocalizedConfiguration(i7, str, str9, str10, str8, str7, str4, str6, str3, str2, list, str5, map, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, PaywallData.LocalizedConfiguration value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderB = encoder.b(descriptor2);
        PaywallData.LocalizedConfiguration.write$Self$purchases_defaultsBc8Release(value, compositeEncoderB, descriptor2);
        compositeEncoderB.c(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
