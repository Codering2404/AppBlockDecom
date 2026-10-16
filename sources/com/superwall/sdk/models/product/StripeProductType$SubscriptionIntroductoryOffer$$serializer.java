package com.superwall.sdk.models.product;

import com.superwall.sdk.models.product.StripeProductType;
import com.superwall.sdk.models.serialization.BigDecimalSerializer;
import java.math.BigDecimal;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@Deprecated
public /* synthetic */ class StripeProductType$SubscriptionIntroductoryOffer$$serializer implements GeneratedSerializer<StripeProductType.SubscriptionIntroductoryOffer> {
    public static final StripeProductType$SubscriptionIntroductoryOffer$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        StripeProductType$SubscriptionIntroductoryOffer$$serializer stripeProductType$SubscriptionIntroductoryOffer$$serializer = new StripeProductType$SubscriptionIntroductoryOffer$$serializer();
        INSTANCE = stripeProductType$SubscriptionIntroductoryOffer$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.superwall.sdk.models.product.StripeProductType.SubscriptionIntroductoryOffer", stripeProductType$SubscriptionIntroductoryOffer$$serializer, 5);
        pluginGeneratedSerialDescriptor.p("period", false);
        pluginGeneratedSerialDescriptor.p("price", false);
        pluginGeneratedSerialDescriptor.p("raw_price", false);
        pluginGeneratedSerialDescriptor.p("period_count", false);
        pluginGeneratedSerialDescriptor.p("payment_method", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private StripeProductType$SubscriptionIntroductoryOffer$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{StripeProductType$StripeSubscriptionPeriod$$serializer.INSTANCE, StringSerializer.f142891a, BigDecimalSerializer.INSTANCE, IntSerializer.f142823a, StripeProductType.SubscriptionIntroductoryOffer.$childSerializers[4]};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final StripeProductType.SubscriptionIntroductoryOffer deserialize(Decoder decoder) {
        int i3;
        int i4;
        StripeProductType.StripeSubscriptionPeriod stripeSubscriptionPeriod;
        String str;
        BigDecimal bigDecimal;
        StripeProductType.SubscriptionIntroductoryOffer.PaymentMethod paymentMethod;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderB = decoder.b(serialDescriptor);
        KSerializer[] kSerializerArr = StripeProductType.SubscriptionIntroductoryOffer.$childSerializers;
        if (compositeDecoderB.p()) {
            StripeProductType.StripeSubscriptionPeriod stripeSubscriptionPeriod2 = (StripeProductType.StripeSubscriptionPeriod) compositeDecoderB.y(serialDescriptor, 0, StripeProductType$StripeSubscriptionPeriod$$serializer.INSTANCE, null);
            String strM = compositeDecoderB.m(serialDescriptor, 1);
            BigDecimal bigDecimal2 = (BigDecimal) compositeDecoderB.y(serialDescriptor, 2, BigDecimalSerializer.INSTANCE, null);
            int i5 = compositeDecoderB.i(serialDescriptor, 3);
            paymentMethod = (StripeProductType.SubscriptionIntroductoryOffer.PaymentMethod) compositeDecoderB.y(serialDescriptor, 4, kSerializerArr[4], null);
            stripeSubscriptionPeriod = stripeSubscriptionPeriod2;
            i3 = i5;
            bigDecimal = bigDecimal2;
            i4 = 31;
            str = strM;
        } else {
            boolean z2 = true;
            int i6 = 0;
            StripeProductType.StripeSubscriptionPeriod stripeSubscriptionPeriod3 = null;
            String strM2 = null;
            BigDecimal bigDecimal3 = null;
            StripeProductType.SubscriptionIntroductoryOffer.PaymentMethod paymentMethod2 = null;
            int i7 = 0;
            while (z2) {
                int iO = compositeDecoderB.o(serialDescriptor);
                if (iO == -1) {
                    z2 = false;
                } else if (iO == 0) {
                    stripeSubscriptionPeriod3 = (StripeProductType.StripeSubscriptionPeriod) compositeDecoderB.y(serialDescriptor, 0, StripeProductType$StripeSubscriptionPeriod$$serializer.INSTANCE, stripeSubscriptionPeriod3);
                    i7 |= 1;
                } else if (iO == 1) {
                    strM2 = compositeDecoderB.m(serialDescriptor, 1);
                    i7 |= 2;
                } else if (iO == 2) {
                    bigDecimal3 = (BigDecimal) compositeDecoderB.y(serialDescriptor, 2, BigDecimalSerializer.INSTANCE, bigDecimal3);
                    i7 |= 4;
                } else if (iO == 3) {
                    i6 = compositeDecoderB.i(serialDescriptor, 3);
                    i7 |= 8;
                } else {
                    if (iO != 4) {
                        throw new UnknownFieldException(iO);
                    }
                    paymentMethod2 = (StripeProductType.SubscriptionIntroductoryOffer.PaymentMethod) compositeDecoderB.y(serialDescriptor, 4, kSerializerArr[4], paymentMethod2);
                    i7 |= 16;
                }
            }
            i3 = i6;
            i4 = i7;
            stripeSubscriptionPeriod = stripeSubscriptionPeriod3;
            str = strM2;
            bigDecimal = bigDecimal3;
            paymentMethod = paymentMethod2;
        }
        compositeDecoderB.c(serialDescriptor);
        return new StripeProductType.SubscriptionIntroductoryOffer(i4, stripeSubscriptionPeriod, str, bigDecimal, i3, paymentMethod, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, StripeProductType.SubscriptionIntroductoryOffer value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderB = encoder.b(serialDescriptor);
        StripeProductType.SubscriptionIntroductoryOffer.write$Self$superwall_release(value, compositeEncoderB, serialDescriptor);
        compositeEncoderB.c(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
