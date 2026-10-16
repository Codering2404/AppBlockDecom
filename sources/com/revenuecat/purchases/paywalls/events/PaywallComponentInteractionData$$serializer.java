package com.revenuecat.purchases.paywalls.events;

import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
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
public final class PaywallComponentInteractionData$$serializer implements GeneratedSerializer<PaywallComponentInteractionData> {
    public static final PaywallComponentInteractionData$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        PaywallComponentInteractionData$$serializer paywallComponentInteractionData$$serializer = new PaywallComponentInteractionData$$serializer();
        INSTANCE = paywallComponentInteractionData$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.paywalls.events.PaywallComponentInteractionData", paywallComponentInteractionData$$serializer, 19);
        pluginGeneratedSerialDescriptor.p("componentType", false);
        pluginGeneratedSerialDescriptor.p("componentName", true);
        pluginGeneratedSerialDescriptor.p("componentValue", false);
        pluginGeneratedSerialDescriptor.p("componentUrl", true);
        pluginGeneratedSerialDescriptor.p("originIndex", true);
        pluginGeneratedSerialDescriptor.p("destinationIndex", true);
        pluginGeneratedSerialDescriptor.p("originContextName", true);
        pluginGeneratedSerialDescriptor.p("destinationContextName", true);
        pluginGeneratedSerialDescriptor.p("defaultIndex", true);
        pluginGeneratedSerialDescriptor.p("originPackageIdentifier", true);
        pluginGeneratedSerialDescriptor.p("destinationPackageIdentifier", true);
        pluginGeneratedSerialDescriptor.p("defaultPackageIdentifier", true);
        pluginGeneratedSerialDescriptor.p("originProductIdentifier", true);
        pluginGeneratedSerialDescriptor.p("destinationProductIdentifier", true);
        pluginGeneratedSerialDescriptor.p("defaultProductIdentifier", true);
        pluginGeneratedSerialDescriptor.p("currentPackageIdentifier", true);
        pluginGeneratedSerialDescriptor.p("resultingPackageIdentifier", true);
        pluginGeneratedSerialDescriptor.p("currentProductIdentifier", true);
        pluginGeneratedSerialDescriptor.p("resultingProductIdentifier", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private PaywallComponentInteractionData$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        KSerializer<?> kSerializer = PaywallComponentInteractionData.$childSerializers[0];
        StringSerializer stringSerializer = StringSerializer.f142891a;
        KSerializer<?> kSerializerU = BuiltinSerializersKt.u(stringSerializer);
        KSerializer<?> kSerializerU2 = BuiltinSerializersKt.u(stringSerializer);
        IntSerializer intSerializer = IntSerializer.f142823a;
        return new KSerializer[]{kSerializer, kSerializerU, stringSerializer, kSerializerU2, BuiltinSerializersKt.u(intSerializer), BuiltinSerializersKt.u(intSerializer), BuiltinSerializersKt.u(stringSerializer), BuiltinSerializersKt.u(stringSerializer), BuiltinSerializersKt.u(intSerializer), BuiltinSerializersKt.u(stringSerializer), BuiltinSerializersKt.u(stringSerializer), BuiltinSerializersKt.u(stringSerializer), BuiltinSerializersKt.u(stringSerializer), BuiltinSerializersKt.u(stringSerializer), BuiltinSerializersKt.u(stringSerializer), BuiltinSerializersKt.u(stringSerializer), BuiltinSerializersKt.u(stringSerializer), BuiltinSerializersKt.u(stringSerializer), BuiltinSerializersKt.u(stringSerializer)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public PaywallComponentInteractionData deserialize(Decoder decoder) {
        String str;
        PaywallComponentType paywallComponentType;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        Integer num;
        String str10;
        String str11;
        String str12;
        String str13;
        Integer num2;
        Integer num3;
        String str14;
        int i3;
        String str15;
        String str16;
        int i4;
        String str17;
        String str18;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderB = decoder.b(descriptor2);
        KSerializer[] kSerializerArr = PaywallComponentInteractionData.$childSerializers;
        String str19 = null;
        if (compositeDecoderB.p()) {
            PaywallComponentType paywallComponentType2 = (PaywallComponentType) compositeDecoderB.y(descriptor2, 0, kSerializerArr[0], null);
            StringSerializer stringSerializer = StringSerializer.f142891a;
            String str20 = (String) compositeDecoderB.n(descriptor2, 1, stringSerializer, null);
            String strM = compositeDecoderB.m(descriptor2, 2);
            String str21 = (String) compositeDecoderB.n(descriptor2, 3, stringSerializer, null);
            IntSerializer intSerializer = IntSerializer.f142823a;
            Integer num4 = (Integer) compositeDecoderB.n(descriptor2, 4, intSerializer, null);
            Integer num5 = (Integer) compositeDecoderB.n(descriptor2, 5, intSerializer, null);
            String str22 = (String) compositeDecoderB.n(descriptor2, 6, stringSerializer, null);
            String str23 = (String) compositeDecoderB.n(descriptor2, 7, stringSerializer, null);
            Integer num6 = (Integer) compositeDecoderB.n(descriptor2, 8, intSerializer, null);
            String str24 = (String) compositeDecoderB.n(descriptor2, 9, stringSerializer, null);
            String str25 = (String) compositeDecoderB.n(descriptor2, 10, stringSerializer, null);
            str = (String) compositeDecoderB.n(descriptor2, 11, stringSerializer, null);
            String str26 = (String) compositeDecoderB.n(descriptor2, 12, stringSerializer, null);
            String str27 = (String) compositeDecoderB.n(descriptor2, 13, stringSerializer, null);
            String str28 = (String) compositeDecoderB.n(descriptor2, 14, stringSerializer, null);
            String str29 = (String) compositeDecoderB.n(descriptor2, 15, stringSerializer, null);
            String str30 = (String) compositeDecoderB.n(descriptor2, 16, stringSerializer, null);
            String str31 = (String) compositeDecoderB.n(descriptor2, 17, stringSerializer, null);
            str11 = (String) compositeDecoderB.n(descriptor2, 18, stringSerializer, null);
            i3 = 524287;
            str13 = str21;
            num = num6;
            num2 = num4;
            str12 = strM;
            str3 = str20;
            str9 = str24;
            str2 = str25;
            str10 = str23;
            str14 = str22;
            num3 = num5;
            str4 = str31;
            str5 = str30;
            str6 = str29;
            str7 = str28;
            str15 = str27;
            str8 = str26;
            paywallComponentType = paywallComponentType2;
        } else {
            int i5 = 1;
            int i6 = 0;
            int i7 = 0;
            String str32 = null;
            String str33 = null;
            String str34 = null;
            String str35 = null;
            String str36 = null;
            String str37 = null;
            String str38 = null;
            String str39 = null;
            str = null;
            String str40 = null;
            Integer num7 = null;
            String str41 = null;
            String strM2 = null;
            PaywallComponentType paywallComponentType3 = null;
            String str42 = null;
            String str43 = null;
            Integer num8 = null;
            Integer num9 = null;
            while (i5 != 0) {
                String str44 = str35;
                int iO = compositeDecoderB.o(descriptor2);
                switch (iO) {
                    case -1:
                        i5 = i7;
                        str35 = str44;
                        i6 = i6;
                        str33 = str33;
                        i7 = i5;
                        break;
                    case 0:
                        str17 = str32;
                        int i8 = i6;
                        str18 = str44;
                        int i9 = i7;
                        paywallComponentType3 = (PaywallComponentType) compositeDecoderB.y(descriptor2, i9, kSerializerArr[i7], paywallComponentType3);
                        i6 = i8 | 1;
                        i7 = i9;
                        str33 = str33;
                        str35 = str18;
                        str32 = str17;
                        break;
                    case 1:
                        str17 = str32;
                        str18 = str44;
                        str42 = (String) compositeDecoderB.n(descriptor2, 1, StringSerializer.f142891a, str42);
                        i6 |= 2;
                        str43 = str43;
                        str35 = str18;
                        str32 = str17;
                        break;
                    case 2:
                        str17 = str32;
                        str18 = str44;
                        strM2 = compositeDecoderB.m(descriptor2, 2);
                        i6 |= 4;
                        str35 = str18;
                        str32 = str17;
                        break;
                    case 3:
                        str17 = str32;
                        str18 = str44;
                        str43 = (String) compositeDecoderB.n(descriptor2, 3, StringSerializer.f142891a, str43);
                        i6 |= 8;
                        num8 = num8;
                        str35 = str18;
                        str32 = str17;
                        break;
                    case 4:
                        str17 = str32;
                        str18 = str44;
                        num8 = (Integer) compositeDecoderB.n(descriptor2, 4, IntSerializer.f142823a, num8);
                        i6 |= 16;
                        num9 = num9;
                        str35 = str18;
                        str32 = str17;
                        break;
                    case 5:
                        str17 = str32;
                        str18 = str44;
                        num9 = (Integer) compositeDecoderB.n(descriptor2, 5, IntSerializer.f142823a, num9);
                        i6 |= 32;
                        str35 = str18;
                        str32 = str17;
                        break;
                    case 6:
                        str17 = str32;
                        str35 = (String) compositeDecoderB.n(descriptor2, 6, StringSerializer.f142891a, str44);
                        i6 |= 64;
                        str32 = str17;
                        break;
                    case 7:
                        str41 = (String) compositeDecoderB.n(descriptor2, 7, StringSerializer.f142891a, str41);
                        i6 |= ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
                        str32 = str32;
                        str35 = str44;
                        break;
                    case 8:
                        str16 = str41;
                        num7 = (Integer) compositeDecoderB.n(descriptor2, 8, IntSerializer.f142823a, num7);
                        i6 |= Function.MAX_NARGS;
                        str35 = str44;
                        str41 = str16;
                        break;
                    case 9:
                        str16 = str41;
                        str40 = (String) compositeDecoderB.n(descriptor2, 9, StringSerializer.f142891a, str40);
                        i6 |= 512;
                        str35 = str44;
                        str41 = str16;
                        break;
                    case 10:
                        str16 = str41;
                        str34 = (String) compositeDecoderB.n(descriptor2, 10, StringSerializer.f142891a, str34);
                        i6 |= 1024;
                        str35 = str44;
                        str41 = str16;
                        break;
                    case 11:
                        str16 = str41;
                        str = (String) compositeDecoderB.n(descriptor2, 11, StringSerializer.f142891a, str);
                        i6 |= 2048;
                        str35 = str44;
                        str41 = str16;
                        break;
                    case 12:
                        str16 = str41;
                        str39 = (String) compositeDecoderB.n(descriptor2, 12, StringSerializer.f142891a, str39);
                        i6 |= 4096;
                        str35 = str44;
                        str41 = str16;
                        break;
                    case 13:
                        str16 = str41;
                        str32 = (String) compositeDecoderB.n(descriptor2, 13, StringSerializer.f142891a, str32);
                        i6 |= Utility.DEFAULT_STREAM_BUFFER_SIZE;
                        str35 = str44;
                        str41 = str16;
                        break;
                    case 14:
                        str16 = str41;
                        str19 = (String) compositeDecoderB.n(descriptor2, 14, StringSerializer.f142891a, str19);
                        i6 |= 16384;
                        str35 = str44;
                        str41 = str16;
                        break;
                    case 15:
                        str16 = str41;
                        str38 = (String) compositeDecoderB.n(descriptor2, 15, StringSerializer.f142891a, str38);
                        i4 = 32768;
                        i6 |= i4;
                        str35 = str44;
                        str41 = str16;
                        break;
                    case 16:
                        str16 = str41;
                        str37 = (String) compositeDecoderB.n(descriptor2, 16, StringSerializer.f142891a, str37);
                        i4 = NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
                        i6 |= i4;
                        str35 = str44;
                        str41 = str16;
                        break;
                    case 17:
                        str16 = str41;
                        str36 = (String) compositeDecoderB.n(descriptor2, 17, StringSerializer.f142891a, str36);
                        i4 = 131072;
                        i6 |= i4;
                        str35 = str44;
                        str41 = str16;
                        break;
                    case 18:
                        str16 = str41;
                        str33 = (String) compositeDecoderB.n(descriptor2, 18, StringSerializer.f142891a, str33);
                        i4 = 262144;
                        i6 |= i4;
                        str35 = str44;
                        str41 = str16;
                        break;
                    default:
                        throw new UnknownFieldException(iO);
                }
            }
            paywallComponentType = paywallComponentType3;
            str2 = str34;
            str3 = str42;
            str4 = str36;
            str5 = str37;
            str6 = str38;
            str7 = str19;
            str8 = str39;
            str9 = str40;
            num = num7;
            str10 = str41;
            str11 = str33;
            str12 = strM2;
            str13 = str43;
            num2 = num8;
            num3 = num9;
            str14 = str35;
            i3 = i6;
            str15 = str32;
        }
        String str45 = str;
        compositeDecoderB.c(descriptor2);
        return new PaywallComponentInteractionData(i3, paywallComponentType, str3, str12, str13, num2, num3, str14, str10, num, str9, str2, str45, str8, str15, str7, str6, str5, str4, str11, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, PaywallComponentInteractionData value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderB = encoder.b(descriptor2);
        PaywallComponentInteractionData.write$Self$purchases_defaultsBc8Release(value, compositeEncoderB, descriptor2);
        compositeEncoderB.c(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
