package com.superwall.sdk.models.product;

import com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker;
import com.revenuecat.purchases.common.responses.CustomerInfoResponseJsonKeys;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import com.superwall.sdk.models.product.StripeProductType;
import com.superwall.sdk.models.serialization.BigDecimalSerializer;
import java.math.BigDecimal;
import java.util.List;
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
public /* synthetic */ class StripeProductType$$serializer implements GeneratedSerializer<StripeProductType> {
    public static final StripeProductType$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        StripeProductType$$serializer stripeProductType$$serializer = new StripeProductType$$serializer();
        INSTANCE = stripeProductType$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.superwall.sdk.models.product.StripeProductType", stripeProductType$$serializer, 9);
        pluginGeneratedSerialDescriptor.p(DiagnosticsTracker.PRODUCT_ID_KEY, false);
        pluginGeneratedSerialDescriptor.p("raw_price", false);
        pluginGeneratedSerialDescriptor.p("price", false);
        pluginGeneratedSerialDescriptor.p("currency_code", false);
        pluginGeneratedSerialDescriptor.p("currency_symbol", false);
        pluginGeneratedSerialDescriptor.p("price_locale", false);
        pluginGeneratedSerialDescriptor.p("subscription_period", false);
        pluginGeneratedSerialDescriptor.p("subscription_introductory_offer", false);
        pluginGeneratedSerialDescriptor.p(CustomerInfoResponseJsonKeys.ENTITLEMENTS, false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private StripeProductType$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr = StripeProductType.$childSerializers;
        KSerializer<?> kSerializerU = BuiltinSerializersKt.u(StripeProductType$StripeSubscriptionPeriod$$serializer.INSTANCE);
        KSerializer<?> kSerializerU2 = BuiltinSerializersKt.u(StripeProductType$SubscriptionIntroductoryOffer$$serializer.INSTANCE);
        KSerializer<?> kSerializer = kSerializerArr[8];
        StringSerializer stringSerializer = StringSerializer.f142891a;
        return new KSerializer[]{stringSerializer, BigDecimalSerializer.INSTANCE, stringSerializer, stringSerializer, stringSerializer, StripeProductType$PriceLocale$$serializer.INSTANCE, kSerializerU, kSerializerU2, kSerializer};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final StripeProductType deserialize(Decoder decoder) {
        int i3;
        List list;
        StripeProductType.SubscriptionIntroductoryOffer subscriptionIntroductoryOffer;
        StripeProductType.StripeSubscriptionPeriod stripeSubscriptionPeriod;
        StripeProductType.PriceLocale priceLocale;
        String str;
        BigDecimal bigDecimal;
        String str2;
        String str3;
        String str4;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderB = decoder.b(serialDescriptor);
        KSerializer[] kSerializerArr = StripeProductType.$childSerializers;
        int i4 = 7;
        int i5 = 6;
        String strM = null;
        if (compositeDecoderB.p()) {
            String strM2 = compositeDecoderB.m(serialDescriptor, 0);
            BigDecimal bigDecimal2 = (BigDecimal) compositeDecoderB.y(serialDescriptor, 1, BigDecimalSerializer.INSTANCE, null);
            String strM3 = compositeDecoderB.m(serialDescriptor, 2);
            String strM4 = compositeDecoderB.m(serialDescriptor, 3);
            String strM5 = compositeDecoderB.m(serialDescriptor, 4);
            StripeProductType.PriceLocale priceLocale2 = (StripeProductType.PriceLocale) compositeDecoderB.y(serialDescriptor, 5, StripeProductType$PriceLocale$$serializer.INSTANCE, null);
            StripeProductType.StripeSubscriptionPeriod stripeSubscriptionPeriod2 = (StripeProductType.StripeSubscriptionPeriod) compositeDecoderB.n(serialDescriptor, 6, StripeProductType$StripeSubscriptionPeriod$$serializer.INSTANCE, null);
            StripeProductType.SubscriptionIntroductoryOffer subscriptionIntroductoryOffer2 = (StripeProductType.SubscriptionIntroductoryOffer) compositeDecoderB.n(serialDescriptor, 7, StripeProductType$SubscriptionIntroductoryOffer$$serializer.INSTANCE, null);
            list = (List) compositeDecoderB.y(serialDescriptor, 8, kSerializerArr[8], null);
            str = strM2;
            subscriptionIntroductoryOffer = subscriptionIntroductoryOffer2;
            stripeSubscriptionPeriod = stripeSubscriptionPeriod2;
            priceLocale = priceLocale2;
            str3 = strM4;
            str4 = strM5;
            str2 = strM3;
            i3 = 511;
            bigDecimal = bigDecimal2;
        } else {
            boolean z2 = true;
            int i6 = 0;
            List list2 = null;
            StripeProductType.SubscriptionIntroductoryOffer subscriptionIntroductoryOffer3 = null;
            StripeProductType.StripeSubscriptionPeriod stripeSubscriptionPeriod3 = null;
            StripeProductType.PriceLocale priceLocale3 = null;
            BigDecimal bigDecimal3 = null;
            String strM6 = null;
            String strM7 = null;
            String strM8 = null;
            while (z2) {
                int iO = compositeDecoderB.o(serialDescriptor);
                switch (iO) {
                    case -1:
                        z2 = false;
                        i4 = 7;
                        break;
                    case 0:
                        strM = compositeDecoderB.m(serialDescriptor, 0);
                        i6 |= 1;
                        i4 = 7;
                        i5 = 6;
                        break;
                    case 1:
                        bigDecimal3 = (BigDecimal) compositeDecoderB.y(serialDescriptor, 1, BigDecimalSerializer.INSTANCE, bigDecimal3);
                        i6 |= 2;
                        i4 = 7;
                        i5 = 6;
                        break;
                    case 2:
                        i6 |= 4;
                        strM6 = compositeDecoderB.m(serialDescriptor, 2);
                        i4 = 7;
                        break;
                    case 3:
                        strM7 = compositeDecoderB.m(serialDescriptor, 3);
                        i6 |= 8;
                        i4 = 7;
                        break;
                    case 4:
                        strM8 = compositeDecoderB.m(serialDescriptor, 4);
                        i6 |= 16;
                        break;
                    case 5:
                        priceLocale3 = (StripeProductType.PriceLocale) compositeDecoderB.y(serialDescriptor, 5, StripeProductType$PriceLocale$$serializer.INSTANCE, priceLocale3);
                        i6 |= 32;
                        break;
                    case 6:
                        stripeSubscriptionPeriod3 = (StripeProductType.StripeSubscriptionPeriod) compositeDecoderB.n(serialDescriptor, i5, StripeProductType$StripeSubscriptionPeriod$$serializer.INSTANCE, stripeSubscriptionPeriod3);
                        i6 |= 64;
                        break;
                    case 7:
                        subscriptionIntroductoryOffer3 = (StripeProductType.SubscriptionIntroductoryOffer) compositeDecoderB.n(serialDescriptor, i4, StripeProductType$SubscriptionIntroductoryOffer$$serializer.INSTANCE, subscriptionIntroductoryOffer3);
                        i6 |= ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
                        break;
                    case 8:
                        list2 = (List) compositeDecoderB.y(serialDescriptor, 8, kSerializerArr[8], list2);
                        i6 |= Function.MAX_NARGS;
                        break;
                    default:
                        throw new UnknownFieldException(iO);
                }
            }
            i3 = i6;
            list = list2;
            subscriptionIntroductoryOffer = subscriptionIntroductoryOffer3;
            stripeSubscriptionPeriod = stripeSubscriptionPeriod3;
            priceLocale = priceLocale3;
            str = strM;
            bigDecimal = bigDecimal3;
            str2 = strM6;
            str3 = strM7;
            str4 = strM8;
        }
        compositeDecoderB.c(serialDescriptor);
        return new StripeProductType(i3, str, bigDecimal, str2, str3, str4, priceLocale, stripeSubscriptionPeriod, subscriptionIntroductoryOffer, list, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, StripeProductType value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderB = encoder.b(serialDescriptor);
        StripeProductType.write$Self$superwall_release(value, compositeEncoderB, serialDescriptor);
        compositeEncoderB.c(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
