package com.revenuecat.purchases.common.responses;

import com.applovin.sdk.AppLovinEventParameters;
import com.revenuecat.purchases.common.responses.SubscriptionInfoResponse;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.DoubleSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
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
/* JADX INFO: loaded from: classes5.dex */
@Metadata
@Deprecated
public final class SubscriptionInfoResponse$PriceResponse$$serializer implements GeneratedSerializer<SubscriptionInfoResponse.PriceResponse> {
    public static final SubscriptionInfoResponse$PriceResponse$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        SubscriptionInfoResponse$PriceResponse$$serializer subscriptionInfoResponse$PriceResponse$$serializer = new SubscriptionInfoResponse$PriceResponse$$serializer();
        INSTANCE = subscriptionInfoResponse$PriceResponse$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.common.responses.SubscriptionInfoResponse.PriceResponse", subscriptionInfoResponse$PriceResponse$$serializer, 2);
        pluginGeneratedSerialDescriptor.p(AppLovinEventParameters.REVENUE_AMOUNT, false);
        pluginGeneratedSerialDescriptor.p(AppLovinEventParameters.REVENUE_CURRENCY, false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private SubscriptionInfoResponse$PriceResponse$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{DoubleSerializer.f142796a, StringSerializer.f142891a};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public SubscriptionInfoResponse.PriceResponse deserialize(Decoder decoder) {
        String strM;
        int i3;
        double d3;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderB = decoder.b(descriptor2);
        if (compositeDecoderB.p()) {
            double dF = compositeDecoderB.F(descriptor2, 0);
            strM = compositeDecoderB.m(descriptor2, 1);
            i3 = 3;
            d3 = dF;
        } else {
            strM = null;
            boolean z2 = true;
            double dF2 = 0.0d;
            int i4 = 0;
            while (z2) {
                int iO = compositeDecoderB.o(descriptor2);
                if (iO == -1) {
                    z2 = false;
                } else if (iO == 0) {
                    dF2 = compositeDecoderB.F(descriptor2, 0);
                    i4 |= 1;
                } else {
                    if (iO != 1) {
                        throw new UnknownFieldException(iO);
                    }
                    strM = compositeDecoderB.m(descriptor2, 1);
                    i4 |= 2;
                }
            }
            i3 = i4;
            d3 = dF2;
        }
        String str = strM;
        compositeDecoderB.c(descriptor2);
        return new SubscriptionInfoResponse.PriceResponse(i3, d3, str, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, SubscriptionInfoResponse.PriceResponse value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderB = encoder.b(descriptor2);
        SubscriptionInfoResponse.PriceResponse.write$Self$purchases_defaultsBc8Release(value, compositeEncoderB, descriptor2);
        compositeEncoderB.c(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
