package com.revenuecat.purchases.paywalls.events;

import com.facebook.gamingservices.cloudgaming.internal.SDKAnalyticsEvents;
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
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
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
public final class PaywallPostReceiptData$$serializer implements GeneratedSerializer<PaywallPostReceiptData> {
    public static final PaywallPostReceiptData$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        PaywallPostReceiptData$$serializer paywallPostReceiptData$$serializer = new PaywallPostReceiptData$$serializer();
        INSTANCE = paywallPostReceiptData$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.paywalls.events.PaywallPostReceiptData", paywallPostReceiptData$$serializer, 7);
        pluginGeneratedSerialDescriptor.p("paywall_id", false);
        pluginGeneratedSerialDescriptor.p(SDKAnalyticsEvents.PARAMETER_SESSION_ID, false);
        pluginGeneratedSerialDescriptor.p("revision", false);
        pluginGeneratedSerialDescriptor.p("display_mode", false);
        pluginGeneratedSerialDescriptor.p("dark_mode", false);
        pluginGeneratedSerialDescriptor.p("locale", false);
        pluginGeneratedSerialDescriptor.p("offering_id", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private PaywallPostReceiptData$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        StringSerializer stringSerializer = StringSerializer.f142891a;
        return new KSerializer[]{BuiltinSerializersKt.u(stringSerializer), stringSerializer, IntSerializer.f142823a, stringSerializer, BooleanSerializer.f142767a, stringSerializer, stringSerializer};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public PaywallPostReceiptData deserialize(Decoder decoder) {
        boolean z2;
        int i3;
        int i4;
        String str;
        String str2;
        String str3;
        String str4;
        String strM;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderB = decoder.b(descriptor2);
        int i5 = 6;
        if (compositeDecoderB.p()) {
            String str5 = (String) compositeDecoderB.n(descriptor2, 0, StringSerializer.f142891a, null);
            String strM2 = compositeDecoderB.m(descriptor2, 1);
            int i6 = compositeDecoderB.i(descriptor2, 2);
            String strM3 = compositeDecoderB.m(descriptor2, 3);
            boolean zC = compositeDecoderB.C(descriptor2, 4);
            String strM4 = compositeDecoderB.m(descriptor2, 5);
            str = str5;
            strM = compositeDecoderB.m(descriptor2, 6);
            str4 = strM4;
            str3 = strM3;
            z2 = zC;
            i3 = i6;
            str2 = strM2;
            i4 = 127;
        } else {
            boolean z3 = true;
            boolean zC2 = false;
            int i7 = 0;
            String str6 = null;
            String strM5 = null;
            String strM6 = null;
            String strM7 = null;
            String strM8 = null;
            int i8 = 0;
            while (z3) {
                int iO = compositeDecoderB.o(descriptor2);
                switch (iO) {
                    case -1:
                        z3 = false;
                        i5 = 6;
                        break;
                    case 0:
                        str6 = (String) compositeDecoderB.n(descriptor2, 0, StringSerializer.f142891a, str6);
                        i7 |= 1;
                        i5 = 6;
                        break;
                    case 1:
                        strM5 = compositeDecoderB.m(descriptor2, 1);
                        i7 |= 2;
                        break;
                    case 2:
                        i8 = compositeDecoderB.i(descriptor2, 2);
                        i7 |= 4;
                        break;
                    case 3:
                        strM6 = compositeDecoderB.m(descriptor2, 3);
                        i7 |= 8;
                        break;
                    case 4:
                        zC2 = compositeDecoderB.C(descriptor2, 4);
                        i7 |= 16;
                        break;
                    case 5:
                        strM7 = compositeDecoderB.m(descriptor2, 5);
                        i7 |= 32;
                        break;
                    case 6:
                        strM8 = compositeDecoderB.m(descriptor2, i5);
                        i7 |= 64;
                        break;
                    default:
                        throw new UnknownFieldException(iO);
                }
            }
            z2 = zC2;
            i3 = i8;
            i4 = i7;
            str = str6;
            str2 = strM5;
            str3 = strM6;
            str4 = strM7;
            strM = strM8;
        }
        compositeDecoderB.c(descriptor2);
        return new PaywallPostReceiptData(i4, str, str2, i3, str3, z2, str4, strM, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, PaywallPostReceiptData value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderB = encoder.b(descriptor2);
        PaywallPostReceiptData.write$Self$purchases_defaultsBc8Release(value, compositeEncoderB, descriptor2);
        compositeEncoderB.c(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
