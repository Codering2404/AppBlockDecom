package com.superwall.sdk.models.internal;

import com.appsflyer.AppsFlyerProperties;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import com.superwall.sdk.models.internal.RedemptionResult;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@Deprecated
public /* synthetic */ class RedemptionResult$PaywallInfo$PaywallProduct$$serializer implements GeneratedSerializer<RedemptionResult.PaywallInfo.PaywallProduct> {
    public static final RedemptionResult$PaywallInfo$PaywallProduct$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        RedemptionResult$PaywallInfo$PaywallProduct$$serializer redemptionResult$PaywallInfo$PaywallProduct$$serializer = new RedemptionResult$PaywallInfo$PaywallProduct$$serializer();
        INSTANCE = redemptionResult$PaywallInfo$PaywallProduct$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.superwall.sdk.models.internal.RedemptionResult.PaywallInfo.PaywallProduct", redemptionResult$PaywallInfo$PaywallProduct$$serializer, 31);
        pluginGeneratedSerialDescriptor.p("identifier", false);
        pluginGeneratedSerialDescriptor.p("languageCode", true);
        pluginGeneratedSerialDescriptor.p("locale", true);
        pluginGeneratedSerialDescriptor.p(AppsFlyerProperties.CURRENCY_CODE, true);
        pluginGeneratedSerialDescriptor.p("currencySymbol", true);
        pluginGeneratedSerialDescriptor.p("period", true);
        pluginGeneratedSerialDescriptor.p("periodly", true);
        pluginGeneratedSerialDescriptor.p("localizedPeriod", true);
        pluginGeneratedSerialDescriptor.p("periodAlt", true);
        pluginGeneratedSerialDescriptor.p("periodDays", true);
        pluginGeneratedSerialDescriptor.p("periodWeeks", true);
        pluginGeneratedSerialDescriptor.p("periodMonths", true);
        pluginGeneratedSerialDescriptor.p("periodYears", true);
        pluginGeneratedSerialDescriptor.p("rawPrice", true);
        pluginGeneratedSerialDescriptor.p("price", true);
        pluginGeneratedSerialDescriptor.p("dailyPrice", true);
        pluginGeneratedSerialDescriptor.p("weeklyPrice", true);
        pluginGeneratedSerialDescriptor.p("monthlyPrice", true);
        pluginGeneratedSerialDescriptor.p("yearlyPrice", true);
        pluginGeneratedSerialDescriptor.p("rawTrialPeriodPrice", true);
        pluginGeneratedSerialDescriptor.p("trialPeriodPrice", true);
        pluginGeneratedSerialDescriptor.p("trialPeriodDailyPrice", true);
        pluginGeneratedSerialDescriptor.p("trialPeriodWeeklyPrice", true);
        pluginGeneratedSerialDescriptor.p("trialPeriodMonthlyPrice", true);
        pluginGeneratedSerialDescriptor.p("trialPeriodYearlyPrice", true);
        pluginGeneratedSerialDescriptor.p("trialPeriodDays", true);
        pluginGeneratedSerialDescriptor.p("trialPeriodWeeks", true);
        pluginGeneratedSerialDescriptor.p("trialPeriodMonths", true);
        pluginGeneratedSerialDescriptor.p("trialPeriodYears", true);
        pluginGeneratedSerialDescriptor.p("trialPeriodText", true);
        pluginGeneratedSerialDescriptor.p("trialPeriodEndDate", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private RedemptionResult$PaywallInfo$PaywallProduct$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        StringSerializer stringSerializer = StringSerializer.f142891a;
        IntSerializer intSerializer = IntSerializer.f142823a;
        DoubleSerializer doubleSerializer = DoubleSerializer.f142796a;
        return new KSerializer[]{stringSerializer, stringSerializer, stringSerializer, stringSerializer, stringSerializer, stringSerializer, stringSerializer, stringSerializer, stringSerializer, intSerializer, intSerializer, intSerializer, intSerializer, doubleSerializer, stringSerializer, stringSerializer, stringSerializer, stringSerializer, stringSerializer, doubleSerializer, stringSerializer, stringSerializer, stringSerializer, stringSerializer, stringSerializer, intSerializer, intSerializer, intSerializer, intSerializer, stringSerializer, stringSerializer};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final RedemptionResult.PaywallInfo.PaywallProduct deserialize(Decoder decoder) {
        String str;
        int i3;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        int i4;
        int i5;
        int i6;
        int i7;
        String str11;
        String strM;
        String str12;
        String str13;
        String str14;
        String str15;
        String str16;
        String str17;
        int i8;
        int i9;
        int i10;
        int i11;
        String str18;
        String str19;
        String str20;
        double d3;
        double d4;
        int i12;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderB = decoder.b(serialDescriptor);
        int i13 = 3;
        int i14 = 0;
        if (compositeDecoderB.p()) {
            String strM2 = compositeDecoderB.m(serialDescriptor, 0);
            String strM3 = compositeDecoderB.m(serialDescriptor, 1);
            String strM4 = compositeDecoderB.m(serialDescriptor, 2);
            String strM5 = compositeDecoderB.m(serialDescriptor, 3);
            String strM6 = compositeDecoderB.m(serialDescriptor, 4);
            String strM7 = compositeDecoderB.m(serialDescriptor, 5);
            String strM8 = compositeDecoderB.m(serialDescriptor, 6);
            String strM9 = compositeDecoderB.m(serialDescriptor, 7);
            String strM10 = compositeDecoderB.m(serialDescriptor, 8);
            int i15 = compositeDecoderB.i(serialDescriptor, 9);
            int i16 = compositeDecoderB.i(serialDescriptor, 10);
            int i17 = compositeDecoderB.i(serialDescriptor, 11);
            int i18 = compositeDecoderB.i(serialDescriptor, 12);
            double dF = compositeDecoderB.F(serialDescriptor, 13);
            String strM11 = compositeDecoderB.m(serialDescriptor, 14);
            String strM12 = compositeDecoderB.m(serialDescriptor, 15);
            String strM13 = compositeDecoderB.m(serialDescriptor, 16);
            String strM14 = compositeDecoderB.m(serialDescriptor, 17);
            String strM15 = compositeDecoderB.m(serialDescriptor, 18);
            double dF2 = compositeDecoderB.F(serialDescriptor, 19);
            String strM16 = compositeDecoderB.m(serialDescriptor, 20);
            String strM17 = compositeDecoderB.m(serialDescriptor, 21);
            String strM18 = compositeDecoderB.m(serialDescriptor, 22);
            String strM19 = compositeDecoderB.m(serialDescriptor, 23);
            String strM20 = compositeDecoderB.m(serialDescriptor, 24);
            int i19 = compositeDecoderB.i(serialDescriptor, 25);
            int i20 = compositeDecoderB.i(serialDescriptor, 26);
            int i21 = compositeDecoderB.i(serialDescriptor, 27);
            int i22 = compositeDecoderB.i(serialDescriptor, 28);
            String strM21 = compositeDecoderB.m(serialDescriptor, 29);
            str6 = strM16;
            strM = compositeDecoderB.m(serialDescriptor, 30);
            str12 = strM5;
            str13 = strM6;
            str14 = strM10;
            str15 = strM4;
            str16 = strM3;
            str17 = strM7;
            i8 = i18;
            i9 = i17;
            i10 = i16;
            i11 = i15;
            str18 = strM9;
            str19 = strM8;
            str20 = strM11;
            str5 = strM15;
            str4 = strM14;
            str3 = strM13;
            str2 = strM12;
            str = strM2;
            d3 = dF;
            d4 = dF2;
            str7 = strM17;
            str8 = strM18;
            str9 = strM19;
            str10 = strM20;
            i4 = i19;
            i5 = i20;
            i6 = i21;
            i7 = i22;
            str11 = strM21;
            i3 = Integer.MAX_VALUE;
        } else {
            String strM22 = null;
            String strM23 = null;
            String strM24 = null;
            String strM25 = null;
            String strM26 = null;
            String strM27 = null;
            String strM28 = null;
            String strM29 = null;
            String strM30 = null;
            String strM31 = null;
            String strM32 = null;
            String strM33 = null;
            String strM34 = null;
            String strM35 = null;
            String strM36 = null;
            String strM37 = null;
            String strM38 = null;
            String strM39 = null;
            String strM40 = null;
            boolean z2 = true;
            int i23 = 0;
            int i24 = 0;
            int i25 = 0;
            int i26 = 0;
            int i27 = 0;
            int i28 = 0;
            int i29 = 0;
            int i30 = 0;
            double dF3 = 0.0d;
            double dF4 = 0.0d;
            String strM41 = null;
            String strM42 = null;
            while (z2) {
                int iO = compositeDecoderB.o(serialDescriptor);
                switch (iO) {
                    case -1:
                        z2 = false;
                        break;
                    case 0:
                        i14 |= 1;
                        strM22 = compositeDecoderB.m(serialDescriptor, 0);
                        i13 = 3;
                        break;
                    case 1:
                        strM36 = compositeDecoderB.m(serialDescriptor, 1);
                        i14 |= 2;
                        i13 = 3;
                        break;
                    case 2:
                        strM35 = compositeDecoderB.m(serialDescriptor, 2);
                        i14 |= 4;
                        break;
                    case 3:
                        strM32 = compositeDecoderB.m(serialDescriptor, i13);
                        i14 |= 8;
                        break;
                    case 4:
                        strM33 = compositeDecoderB.m(serialDescriptor, 4);
                        i14 |= 16;
                        break;
                    case 5:
                        strM37 = compositeDecoderB.m(serialDescriptor, 5);
                        i14 |= 32;
                        break;
                    case 6:
                        strM39 = compositeDecoderB.m(serialDescriptor, 6);
                        i14 |= 64;
                        break;
                    case 7:
                        strM38 = compositeDecoderB.m(serialDescriptor, 7);
                        i14 |= ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
                        break;
                    case 8:
                        strM34 = compositeDecoderB.m(serialDescriptor, 8);
                        i14 |= Function.MAX_NARGS;
                        break;
                    case 9:
                        i30 = compositeDecoderB.i(serialDescriptor, 9);
                        i14 |= 512;
                        break;
                    case 10:
                        i29 = compositeDecoderB.i(serialDescriptor, 10);
                        i14 |= 1024;
                        break;
                    case 11:
                        i28 = compositeDecoderB.i(serialDescriptor, 11);
                        i14 |= 2048;
                        break;
                    case 12:
                        i27 = compositeDecoderB.i(serialDescriptor, 12);
                        i14 |= 4096;
                        break;
                    case 13:
                        dF3 = compositeDecoderB.F(serialDescriptor, 13);
                        i14 |= Utility.DEFAULT_STREAM_BUFFER_SIZE;
                        break;
                    case 14:
                        strM40 = compositeDecoderB.m(serialDescriptor, 14);
                        i14 |= 16384;
                        break;
                    case 15:
                        strM41 = compositeDecoderB.m(serialDescriptor, 15);
                        i14 |= 32768;
                        break;
                    case 16:
                        strM42 = compositeDecoderB.m(serialDescriptor, 16);
                        i14 |= NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
                        break;
                    case 17:
                        strM23 = compositeDecoderB.m(serialDescriptor, 17);
                        i14 |= 131072;
                        break;
                    case 18:
                        strM24 = compositeDecoderB.m(serialDescriptor, 18);
                        i14 |= 262144;
                        break;
                    case 19:
                        dF4 = compositeDecoderB.F(serialDescriptor, 19);
                        i14 |= 524288;
                        break;
                    case 20:
                        strM25 = compositeDecoderB.m(serialDescriptor, 20);
                        i12 = 1048576;
                        i14 |= i12;
                        break;
                    case 21:
                        strM26 = compositeDecoderB.m(serialDescriptor, 21);
                        i12 = 2097152;
                        i14 |= i12;
                        break;
                    case 22:
                        strM27 = compositeDecoderB.m(serialDescriptor, 22);
                        i12 = 4194304;
                        i14 |= i12;
                        break;
                    case 23:
                        strM28 = compositeDecoderB.m(serialDescriptor, 23);
                        i12 = 8388608;
                        i14 |= i12;
                        break;
                    case 24:
                        strM29 = compositeDecoderB.m(serialDescriptor, 24);
                        i12 = 16777216;
                        i14 |= i12;
                        break;
                    case 25:
                        i23 = compositeDecoderB.i(serialDescriptor, 25);
                        i12 = 33554432;
                        i14 |= i12;
                        break;
                    case 26:
                        i24 = compositeDecoderB.i(serialDescriptor, 26);
                        i12 = 67108864;
                        i14 |= i12;
                        break;
                    case 27:
                        i25 = compositeDecoderB.i(serialDescriptor, 27);
                        i12 = 134217728;
                        i14 |= i12;
                        break;
                    case 28:
                        i26 = compositeDecoderB.i(serialDescriptor, 28);
                        i12 = 268435456;
                        i14 |= i12;
                        break;
                    case 29:
                        strM30 = compositeDecoderB.m(serialDescriptor, 29);
                        i12 = 536870912;
                        i14 |= i12;
                        break;
                    case 30:
                        strM31 = compositeDecoderB.m(serialDescriptor, 30);
                        i12 = 1073741824;
                        i14 |= i12;
                        break;
                    default:
                        throw new UnknownFieldException(iO);
                }
            }
            str = strM22;
            i3 = i14;
            str2 = strM41;
            str3 = strM42;
            str4 = strM23;
            str5 = strM24;
            str6 = strM25;
            str7 = strM26;
            str8 = strM27;
            str9 = strM28;
            str10 = strM29;
            i4 = i23;
            i5 = i24;
            i6 = i25;
            i7 = i26;
            str11 = strM30;
            strM = strM31;
            str12 = strM32;
            str13 = strM33;
            str14 = strM34;
            str15 = strM35;
            str16 = strM36;
            str17 = strM37;
            i8 = i27;
            i9 = i28;
            i10 = i29;
            i11 = i30;
            str18 = strM38;
            str19 = strM39;
            str20 = strM40;
            d3 = dF3;
            d4 = dF4;
        }
        compositeDecoderB.c(serialDescriptor);
        return new RedemptionResult.PaywallInfo.PaywallProduct(i3, str, str16, str15, str12, str13, str17, str19, str18, str14, i11, i10, i9, i8, d3, str20, str2, str3, str4, str5, d4, str6, str7, str8, str9, str10, i4, i5, i6, i7, str11, strM, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, RedemptionResult.PaywallInfo.PaywallProduct value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderB = encoder.b(serialDescriptor);
        RedemptionResult.PaywallInfo.PaywallProduct.write$Self$superwall_release(value, compositeEncoderB, serialDescriptor);
        compositeEncoderB.c(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
