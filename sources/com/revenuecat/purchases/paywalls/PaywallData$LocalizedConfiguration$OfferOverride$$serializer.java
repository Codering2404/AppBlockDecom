package com.revenuecat.purchases.paywalls;

import com.revenuecat.purchases.paywalls.PaywallData;
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
public final class PaywallData$LocalizedConfiguration$OfferOverride$$serializer implements GeneratedSerializer<PaywallData.LocalizedConfiguration.OfferOverride> {
    public static final PaywallData$LocalizedConfiguration$OfferOverride$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        PaywallData$LocalizedConfiguration$OfferOverride$$serializer paywallData$LocalizedConfiguration$OfferOverride$$serializer = new PaywallData$LocalizedConfiguration$OfferOverride$$serializer();
        INSTANCE = paywallData$LocalizedConfiguration$OfferOverride$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.paywalls.PaywallData.LocalizedConfiguration.OfferOverride", paywallData$LocalizedConfiguration$OfferOverride$$serializer, 5);
        pluginGeneratedSerialDescriptor.p("offer_name", false);
        pluginGeneratedSerialDescriptor.p("offer_details", false);
        pluginGeneratedSerialDescriptor.p("offer_details_with_intro_offer", true);
        pluginGeneratedSerialDescriptor.p("offer_details_with_multiple_intro_offers", true);
        pluginGeneratedSerialDescriptor.p("offer_badge", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private PaywallData$LocalizedConfiguration$OfferOverride$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        EmptyStringToNullSerializer emptyStringToNullSerializer = EmptyStringToNullSerializer.INSTANCE;
        KSerializer<?> kSerializerU = BuiltinSerializersKt.u(emptyStringToNullSerializer);
        KSerializer<?> kSerializerU2 = BuiltinSerializersKt.u(emptyStringToNullSerializer);
        KSerializer<?> kSerializerU3 = BuiltinSerializersKt.u(emptyStringToNullSerializer);
        StringSerializer stringSerializer = StringSerializer.f142891a;
        return new KSerializer[]{stringSerializer, stringSerializer, kSerializerU, kSerializerU2, kSerializerU3};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public PaywallData.LocalizedConfiguration.OfferOverride deserialize(Decoder decoder) {
        int i3;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderB = decoder.b(descriptor2);
        String strM = null;
        if (compositeDecoderB.p()) {
            String strM2 = compositeDecoderB.m(descriptor2, 0);
            String strM3 = compositeDecoderB.m(descriptor2, 1);
            EmptyStringToNullSerializer emptyStringToNullSerializer = EmptyStringToNullSerializer.INSTANCE;
            String str6 = (String) compositeDecoderB.n(descriptor2, 2, emptyStringToNullSerializer, null);
            str = strM2;
            str4 = (String) compositeDecoderB.n(descriptor2, 3, emptyStringToNullSerializer, null);
            str5 = (String) compositeDecoderB.n(descriptor2, 4, emptyStringToNullSerializer, null);
            str3 = str6;
            str2 = strM3;
            i3 = 31;
        } else {
            boolean z2 = true;
            int i4 = 0;
            String strM4 = null;
            String str7 = null;
            String str8 = null;
            String str9 = null;
            while (z2) {
                int iO = compositeDecoderB.o(descriptor2);
                if (iO == -1) {
                    z2 = false;
                } else if (iO == 0) {
                    strM = compositeDecoderB.m(descriptor2, 0);
                    i4 |= 1;
                } else if (iO == 1) {
                    strM4 = compositeDecoderB.m(descriptor2, 1);
                    i4 |= 2;
                } else if (iO == 2) {
                    str7 = (String) compositeDecoderB.n(descriptor2, 2, EmptyStringToNullSerializer.INSTANCE, str7);
                    i4 |= 4;
                } else if (iO == 3) {
                    str8 = (String) compositeDecoderB.n(descriptor2, 3, EmptyStringToNullSerializer.INSTANCE, str8);
                    i4 |= 8;
                } else {
                    if (iO != 4) {
                        throw new UnknownFieldException(iO);
                    }
                    str9 = (String) compositeDecoderB.n(descriptor2, 4, EmptyStringToNullSerializer.INSTANCE, str9);
                    i4 |= 16;
                }
            }
            i3 = i4;
            str = strM;
            str2 = strM4;
            str3 = str7;
            str4 = str8;
            str5 = str9;
        }
        compositeDecoderB.c(descriptor2);
        return new PaywallData.LocalizedConfiguration.OfferOverride(i3, str, str2, str3, str4, str5, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, PaywallData.LocalizedConfiguration.OfferOverride value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderB = encoder.b(descriptor2);
        PaywallData.LocalizedConfiguration.OfferOverride.write$Self$purchases_defaultsBc8Release(value, compositeEncoderB, descriptor2);
        compositeEncoderB.c(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
