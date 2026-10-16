package com.superwall.sdk.models.entitlements;

import com.superwall.sdk.identity.Keys;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@Deprecated
public /* synthetic */ class RedeemRequest$$serializer implements GeneratedSerializer<RedeemRequest> {
    public static final RedeemRequest$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        RedeemRequest$$serializer redeemRequest$$serializer = new RedeemRequest$$serializer();
        INSTANCE = redeemRequest$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.superwall.sdk.models.entitlements.RedeemRequest", redeemRequest$$serializer, 7);
        pluginGeneratedSerialDescriptor.p("deviceId", false);
        pluginGeneratedSerialDescriptor.p(Keys.APP_USER_ID, false);
        pluginGeneratedSerialDescriptor.p(Keys.ALIAS_ID, true);
        pluginGeneratedSerialDescriptor.p("codes", false);
        pluginGeneratedSerialDescriptor.p("receipts", false);
        pluginGeneratedSerialDescriptor.p("externalAccountId", false);
        pluginGeneratedSerialDescriptor.p("metadata", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private RedeemRequest$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr = RedeemRequest.$childSerializers;
        StringSerializer stringSerializer = StringSerializer.f142891a;
        return new KSerializer[]{stringSerializer, BuiltinSerializersKt.u(stringSerializer), BuiltinSerializersKt.u(stringSerializer), kSerializerArr[3], kSerializerArr[4], stringSerializer, BuiltinSerializersKt.u(kSerializerArr[6])};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final RedeemRequest deserialize(Decoder decoder) {
        int i3;
        Map map;
        String str;
        String str2;
        String str3;
        List list;
        List list2;
        String str4;
        boolean z2;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderB = decoder.b(serialDescriptor);
        KSerializer[] kSerializerArr = RedeemRequest.$childSerializers;
        int i4 = 5;
        String strM = null;
        if (compositeDecoderB.p()) {
            String strM2 = compositeDecoderB.m(serialDescriptor, 0);
            StringSerializer stringSerializer = StringSerializer.f142891a;
            String str5 = (String) compositeDecoderB.n(serialDescriptor, 1, stringSerializer, null);
            String str6 = (String) compositeDecoderB.n(serialDescriptor, 2, stringSerializer, null);
            List list3 = (List) compositeDecoderB.y(serialDescriptor, 3, kSerializerArr[3], null);
            List list4 = (List) compositeDecoderB.y(serialDescriptor, 4, kSerializerArr[4], null);
            String strM3 = compositeDecoderB.m(serialDescriptor, 5);
            map = (Map) compositeDecoderB.n(serialDescriptor, 6, kSerializerArr[6], null);
            str = strM2;
            str4 = strM3;
            str3 = str6;
            i3 = 127;
            list = list3;
            list2 = list4;
            str2 = str5;
        } else {
            boolean z3 = true;
            int i5 = 0;
            Map map2 = null;
            String str7 = null;
            String str8 = null;
            List list5 = null;
            List list6 = null;
            String strM4 = null;
            while (z3) {
                int iO = compositeDecoderB.o(serialDescriptor);
                switch (iO) {
                    case -1:
                        z3 = false;
                        break;
                    case 0:
                        z2 = true;
                        strM = compositeDecoderB.m(serialDescriptor, 0);
                        i5 |= 1;
                        i4 = 5;
                        break;
                    case 1:
                        z2 = true;
                        str7 = (String) compositeDecoderB.n(serialDescriptor, 1, StringSerializer.f142891a, str7);
                        i5 |= 2;
                        i4 = 5;
                        break;
                    case 2:
                        str8 = (String) compositeDecoderB.n(serialDescriptor, 2, StringSerializer.f142891a, str8);
                        i5 |= 4;
                        break;
                    case 3:
                        list5 = (List) compositeDecoderB.y(serialDescriptor, 3, kSerializerArr[3], list5);
                        i5 |= 8;
                        break;
                    case 4:
                        list6 = (List) compositeDecoderB.y(serialDescriptor, 4, kSerializerArr[4], list6);
                        i5 |= 16;
                        break;
                    case 5:
                        strM4 = compositeDecoderB.m(serialDescriptor, i4);
                        i5 |= 32;
                        break;
                    case 6:
                        map2 = (Map) compositeDecoderB.n(serialDescriptor, 6, kSerializerArr[6], map2);
                        i5 |= 64;
                        break;
                    default:
                        throw new UnknownFieldException(iO);
                }
            }
            i3 = i5;
            map = map2;
            str = strM;
            str2 = str7;
            str3 = str8;
            list = list5;
            list2 = list6;
            str4 = strM4;
        }
        compositeDecoderB.c(serialDescriptor);
        return new RedeemRequest(i3, str, str2, str3, list, list2, str4, map, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, RedeemRequest value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderB = encoder.b(serialDescriptor);
        RedeemRequest.write$Self$superwall_release(value, compositeEncoderB, serialDescriptor);
        compositeEncoderB.c(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
