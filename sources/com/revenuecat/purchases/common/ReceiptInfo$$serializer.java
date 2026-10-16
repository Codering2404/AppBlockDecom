package com.revenuecat.purchases.common;

import com.applovin.sdk.AppLovinEventParameters;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.PresentedOfferingContext;
import com.revenuecat.purchases.PresentedOfferingContextSerializer;
import com.revenuecat.purchases.ReplacementMode;
import com.revenuecat.purchases.ReplacementModeSerializer;
import com.revenuecat.purchases.models.Period;
import com.revenuecat.purchases.models.PeriodSerializer;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
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
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.DoubleSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.LongSerializer;
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
public final class ReceiptInfo$$serializer implements GeneratedSerializer<ReceiptInfo> {
    public static final ReceiptInfo$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        ReceiptInfo$$serializer receiptInfo$$serializer = new ReceiptInfo$$serializer();
        INSTANCE = receiptInfo$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.common.ReceiptInfo", receiptInfo$$serializer, 14);
        pluginGeneratedSerialDescriptor.p("productIDs", false);
        pluginGeneratedSerialDescriptor.p(com.facebook.appevents.internal.Constants.GP_IAP_PURCHASE_TIME, true);
        pluginGeneratedSerialDescriptor.p("presentedOfferingContext", true);
        pluginGeneratedSerialDescriptor.p("price", true);
        pluginGeneratedSerialDescriptor.p("formattedPrice", true);
        pluginGeneratedSerialDescriptor.p(AppLovinEventParameters.REVENUE_CURRENCY, true);
        pluginGeneratedSerialDescriptor.p("period", true);
        pluginGeneratedSerialDescriptor.p(com.facebook.appevents.internal.Constants.GP_IAP_SUBSCRIPTION_PRICING_PHASES, true);
        pluginGeneratedSerialDescriptor.p("replacementMode", true);
        pluginGeneratedSerialDescriptor.p("platformProductIds", true);
        pluginGeneratedSerialDescriptor.p("sdkOriginated", true);
        pluginGeneratedSerialDescriptor.p("storeUserID", true);
        pluginGeneratedSerialDescriptor.p("marketplace", true);
        pluginGeneratedSerialDescriptor.p("duration", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private ReceiptInfo$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr = ReceiptInfo.$childSerializers;
        KSerializer<?> kSerializer = kSerializerArr[0];
        KSerializer<?> kSerializerU = BuiltinSerializersKt.u(LongSerializer.f142836a);
        KSerializer<?> kSerializerU2 = BuiltinSerializersKt.u(PresentedOfferingContextSerializer.INSTANCE);
        KSerializer<?> kSerializerU3 = BuiltinSerializersKt.u(DoubleSerializer.f142796a);
        StringSerializer stringSerializer = StringSerializer.f142891a;
        return new KSerializer[]{kSerializer, kSerializerU, kSerializerU2, kSerializerU3, BuiltinSerializersKt.u(stringSerializer), BuiltinSerializersKt.u(stringSerializer), BuiltinSerializersKt.u(PeriodSerializer.INSTANCE), BuiltinSerializersKt.u(kSerializerArr[7]), BuiltinSerializersKt.u(ReplacementModeSerializer.INSTANCE), kSerializerArr[9], BooleanSerializer.f142767a, BuiltinSerializersKt.u(stringSerializer), BuiltinSerializersKt.u(stringSerializer), BuiltinSerializersKt.u(stringSerializer)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public ReceiptInfo deserialize(Decoder decoder) {
        int i3;
        PresentedOfferingContext presentedOfferingContext;
        List list;
        Long l3;
        ReplacementMode replacementMode;
        List list2;
        String str;
        String str2;
        Period period;
        String str3;
        String str4;
        List list3;
        Double d3;
        String str5;
        boolean z2;
        Long l4;
        Long l5;
        Long l6;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderB = decoder.b(descriptor2);
        KSerializer[] kSerializerArr = ReceiptInfo.$childSerializers;
        if (compositeDecoderB.p()) {
            List list4 = (List) compositeDecoderB.y(descriptor2, 0, kSerializerArr[0], null);
            Long l7 = (Long) compositeDecoderB.n(descriptor2, 1, LongSerializer.f142836a, null);
            presentedOfferingContext = (PresentedOfferingContext) compositeDecoderB.n(descriptor2, 2, PresentedOfferingContextSerializer.INSTANCE, null);
            Double d4 = (Double) compositeDecoderB.n(descriptor2, 3, DoubleSerializer.f142796a, null);
            StringSerializer stringSerializer = StringSerializer.f142891a;
            String str6 = (String) compositeDecoderB.n(descriptor2, 4, stringSerializer, null);
            String str7 = (String) compositeDecoderB.n(descriptor2, 5, stringSerializer, null);
            Period period2 = (Period) compositeDecoderB.n(descriptor2, 6, PeriodSerializer.INSTANCE, null);
            List list5 = (List) compositeDecoderB.n(descriptor2, 7, kSerializerArr[7], null);
            ReplacementMode replacementMode2 = (ReplacementMode) compositeDecoderB.n(descriptor2, 8, ReplacementModeSerializer.INSTANCE, null);
            List list6 = (List) compositeDecoderB.y(descriptor2, 9, kSerializerArr[9], null);
            boolean zC = compositeDecoderB.C(descriptor2, 10);
            String str8 = (String) compositeDecoderB.n(descriptor2, 11, stringSerializer, null);
            String str9 = (String) compositeDecoderB.n(descriptor2, 12, stringSerializer, null);
            i3 = 16383;
            str5 = (String) compositeDecoderB.n(descriptor2, 13, stringSerializer, null);
            list = list4;
            l3 = l7;
            period = period2;
            list2 = list5;
            str = str7;
            d3 = d4;
            replacementMode = replacementMode2;
            str3 = str6;
            z2 = zC;
            str2 = str8;
            str4 = str9;
            list3 = list6;
        } else {
            int i4 = 1;
            int i5 = 0;
            boolean zC2 = false;
            String str10 = null;
            List list7 = null;
            Double d5 = null;
            Long l8 = null;
            ReplacementMode replacementMode3 = null;
            List list8 = null;
            String str11 = null;
            String str12 = null;
            Period period3 = null;
            String str13 = null;
            int i6 = 9;
            int i7 = 7;
            i3 = 0;
            presentedOfferingContext = null;
            String str14 = null;
            List list9 = null;
            while (i4 != 0) {
                List list10 = list7;
                int iO = compositeDecoderB.o(descriptor2);
                switch (iO) {
                    case -1:
                        list7 = list10;
                        i4 = i5;
                        str10 = str10;
                        i7 = 7;
                        i6 = 9;
                        d5 = d5;
                        i5 = i4;
                        break;
                    case 0:
                        String str15 = str10;
                        KSerializer kSerializer = kSerializerArr[i5];
                        int i8 = i5;
                        list7 = (List) compositeDecoderB.y(descriptor2, i8, kSerializer, list10);
                        i3 |= 1;
                        i5 = i8;
                        d5 = d5;
                        str10 = str15;
                        i7 = 7;
                        i6 = 9;
                        break;
                    case 1:
                        l8 = (Long) compositeDecoderB.n(descriptor2, 1, LongSerializer.f142836a, l8);
                        i3 |= 2;
                        str10 = str10;
                        list7 = list10;
                        i7 = 7;
                        i6 = 9;
                        break;
                    case 2:
                        l5 = l8;
                        presentedOfferingContext = (PresentedOfferingContext) compositeDecoderB.n(descriptor2, 2, PresentedOfferingContextSerializer.INSTANCE, presentedOfferingContext);
                        i3 |= 4;
                        list7 = list10;
                        l8 = l5;
                        i7 = 7;
                        i6 = 9;
                        break;
                    case 3:
                        l5 = l8;
                        d5 = (Double) compositeDecoderB.n(descriptor2, 3, DoubleSerializer.f142796a, d5);
                        i3 |= 8;
                        list7 = list10;
                        l8 = l5;
                        i7 = 7;
                        i6 = 9;
                        break;
                    case 4:
                        l5 = l8;
                        str13 = (String) compositeDecoderB.n(descriptor2, 4, StringSerializer.f142891a, str13);
                        i3 |= 16;
                        list7 = list10;
                        l8 = l5;
                        i7 = 7;
                        i6 = 9;
                        break;
                    case 5:
                        l5 = l8;
                        str11 = (String) compositeDecoderB.n(descriptor2, 5, StringSerializer.f142891a, str11);
                        i3 |= 32;
                        list7 = list10;
                        l8 = l5;
                        i7 = 7;
                        i6 = 9;
                        break;
                    case 6:
                        l5 = l8;
                        period3 = (Period) compositeDecoderB.n(descriptor2, 6, PeriodSerializer.INSTANCE, period3);
                        i3 |= 64;
                        list7 = list10;
                        l8 = l5;
                        i7 = 7;
                        i6 = 9;
                        break;
                    case 7:
                        l6 = l8;
                        list8 = (List) compositeDecoderB.n(descriptor2, i7, kSerializerArr[i7], list8);
                        i3 |= ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
                        list7 = list10;
                        l8 = l6;
                        i6 = 9;
                        break;
                    case 8:
                        l6 = l8;
                        replacementMode3 = (ReplacementMode) compositeDecoderB.n(descriptor2, 8, ReplacementModeSerializer.INSTANCE, replacementMode3);
                        i3 |= Function.MAX_NARGS;
                        list7 = list10;
                        l8 = l6;
                        i6 = 9;
                        break;
                    case 9:
                        l4 = l8;
                        list9 = (List) compositeDecoderB.y(descriptor2, i6, kSerializerArr[i6], list9);
                        i3 |= 512;
                        list7 = list10;
                        l8 = l4;
                        break;
                    case 10:
                        l4 = l8;
                        zC2 = compositeDecoderB.C(descriptor2, 10);
                        i3 |= 1024;
                        list7 = list10;
                        l8 = l4;
                        break;
                    case 11:
                        l4 = l8;
                        str12 = (String) compositeDecoderB.n(descriptor2, 11, StringSerializer.f142891a, str12);
                        i3 |= 2048;
                        list7 = list10;
                        l8 = l4;
                        break;
                    case 12:
                        l4 = l8;
                        str14 = (String) compositeDecoderB.n(descriptor2, 12, StringSerializer.f142891a, str14);
                        i3 |= 4096;
                        list7 = list10;
                        l8 = l4;
                        break;
                    case 13:
                        l4 = l8;
                        str10 = (String) compositeDecoderB.n(descriptor2, 13, StringSerializer.f142891a, str10);
                        i3 |= Utility.DEFAULT_STREAM_BUFFER_SIZE;
                        list7 = list10;
                        l8 = l4;
                        break;
                    default:
                        throw new UnknownFieldException(iO);
                }
            }
            list = list7;
            l3 = l8;
            replacementMode = replacementMode3;
            list2 = list8;
            str = str11;
            str2 = str12;
            period = period3;
            str3 = str13;
            str4 = str14;
            list3 = list9;
            d3 = d5;
            str5 = str10;
            z2 = zC2;
        }
        PresentedOfferingContext presentedOfferingContext2 = presentedOfferingContext;
        int i9 = i3;
        compositeDecoderB.c(descriptor2);
        return new ReceiptInfo(i9, list, l3, presentedOfferingContext2, d3, str3, str, period, list2, replacementMode, list3, z2, str2, str4, str5, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, ReceiptInfo value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderB = encoder.b(descriptor2);
        ReceiptInfo.write$Self$purchases_defaultsBc8Release(value, compositeEncoderB, descriptor2);
        compositeEncoderB.c(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
