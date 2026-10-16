package com.revenuecat.purchases.common.responses;

import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.OwnershipType;
import com.revenuecat.purchases.PeriodType;
import com.revenuecat.purchases.Store;
import com.revenuecat.purchases.StoreSerializer;
import com.revenuecat.purchases.common.responses.SubscriptionInfoResponse;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.revenuecat.purchases.utils.serializers.ISO8601DateSerializer;
import com.sun.jna.Function;
import java.util.Date;
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
/* JADX INFO: loaded from: classes5.dex */
@Metadata
@Deprecated
public final class SubscriptionInfoResponse$$serializer implements GeneratedSerializer<SubscriptionInfoResponse> {
    public static final SubscriptionInfoResponse$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        SubscriptionInfoResponse$$serializer subscriptionInfoResponse$$serializer = new SubscriptionInfoResponse$$serializer();
        INSTANCE = subscriptionInfoResponse$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.common.responses.SubscriptionInfoResponse", subscriptionInfoResponse$$serializer, 17);
        pluginGeneratedSerialDescriptor.p("purchase_date", false);
        pluginGeneratedSerialDescriptor.p("original_purchase_date", true);
        pluginGeneratedSerialDescriptor.p("expires_date", true);
        pluginGeneratedSerialDescriptor.p(ProductResponseJsonKeys.STORE, false);
        pluginGeneratedSerialDescriptor.p(ProductResponseJsonKeys.IS_SANDBOX, false);
        pluginGeneratedSerialDescriptor.p(ProductResponseJsonKeys.UNSUBSCRIBE_DETECTED_AT, true);
        pluginGeneratedSerialDescriptor.p(ProductResponseJsonKeys.BILLING_ISSUES_DETECTED_AT, true);
        pluginGeneratedSerialDescriptor.p("grace_period_expires_date", true);
        pluginGeneratedSerialDescriptor.p(ProductResponseJsonKeys.OWNERSHIP_TYPE, true);
        pluginGeneratedSerialDescriptor.p(ProductResponseJsonKeys.PERIOD_TYPE, false);
        pluginGeneratedSerialDescriptor.p("refunded_at", true);
        pluginGeneratedSerialDescriptor.p("store_transaction_id", true);
        pluginGeneratedSerialDescriptor.p("auto_resume_date", true);
        pluginGeneratedSerialDescriptor.p("display_name", true);
        pluginGeneratedSerialDescriptor.p("price", true);
        pluginGeneratedSerialDescriptor.p("product_plan_identifier", true);
        pluginGeneratedSerialDescriptor.p("management_url", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private SubscriptionInfoResponse$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr = SubscriptionInfoResponse.$childSerializers;
        ISO8601DateSerializer iSO8601DateSerializer = ISO8601DateSerializer.INSTANCE;
        KSerializer<?> kSerializerU = BuiltinSerializersKt.u(iSO8601DateSerializer);
        KSerializer<?> kSerializerU2 = BuiltinSerializersKt.u(iSO8601DateSerializer);
        KSerializer<?> kSerializerU3 = BuiltinSerializersKt.u(iSO8601DateSerializer);
        KSerializer<?> kSerializerU4 = BuiltinSerializersKt.u(iSO8601DateSerializer);
        KSerializer<?> kSerializerU5 = BuiltinSerializersKt.u(iSO8601DateSerializer);
        KSerializer<?> kSerializer = kSerializerArr[8];
        KSerializer<?> kSerializer2 = kSerializerArr[9];
        KSerializer<?> kSerializerU6 = BuiltinSerializersKt.u(iSO8601DateSerializer);
        StringSerializer stringSerializer = StringSerializer.f142891a;
        return new KSerializer[]{iSO8601DateSerializer, kSerializerU, kSerializerU2, StoreSerializer.INSTANCE, BooleanSerializer.f142767a, kSerializerU3, kSerializerU4, kSerializerU5, kSerializer, kSerializer2, kSerializerU6, BuiltinSerializersKt.u(stringSerializer), BuiltinSerializersKt.u(iSO8601DateSerializer), BuiltinSerializersKt.u(stringSerializer), BuiltinSerializersKt.u(SubscriptionInfoResponse$PriceResponse$$serializer.INSTANCE), BuiltinSerializersKt.u(stringSerializer), BuiltinSerializersKt.u(stringSerializer)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public SubscriptionInfoResponse deserialize(Decoder decoder) {
        int i3;
        Date date;
        String str;
        Store store;
        String str2;
        String str3;
        Date date2;
        PeriodType periodType;
        OwnershipType ownershipType;
        Date date3;
        Date date4;
        Date date5;
        Date date6;
        Date date7;
        Date date8;
        SubscriptionInfoResponse.PriceResponse priceResponse;
        String str4;
        boolean z2;
        Date date9;
        int i4;
        String str5;
        SubscriptionInfoResponse.PriceResponse priceResponse2;
        Date date10;
        String str6;
        Date date11;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderB = decoder.b(descriptor2);
        KSerializer[] kSerializerArr = SubscriptionInfoResponse.$childSerializers;
        if (compositeDecoderB.p()) {
            ISO8601DateSerializer iSO8601DateSerializer = ISO8601DateSerializer.INSTANCE;
            Date date12 = (Date) compositeDecoderB.y(descriptor2, 0, iSO8601DateSerializer, null);
            Date date13 = (Date) compositeDecoderB.n(descriptor2, 1, iSO8601DateSerializer, null);
            Date date14 = (Date) compositeDecoderB.n(descriptor2, 2, iSO8601DateSerializer, null);
            Store store2 = (Store) compositeDecoderB.y(descriptor2, 3, StoreSerializer.INSTANCE, null);
            boolean zC = compositeDecoderB.C(descriptor2, 4);
            Date date15 = (Date) compositeDecoderB.n(descriptor2, 5, iSO8601DateSerializer, null);
            Date date16 = (Date) compositeDecoderB.n(descriptor2, 6, iSO8601DateSerializer, null);
            Date date17 = (Date) compositeDecoderB.n(descriptor2, 7, iSO8601DateSerializer, null);
            OwnershipType ownershipType2 = (OwnershipType) compositeDecoderB.y(descriptor2, 8, kSerializerArr[8], null);
            PeriodType periodType2 = (PeriodType) compositeDecoderB.y(descriptor2, 9, kSerializerArr[9], null);
            Date date18 = (Date) compositeDecoderB.n(descriptor2, 10, iSO8601DateSerializer, null);
            StringSerializer stringSerializer = StringSerializer.f142891a;
            String str7 = (String) compositeDecoderB.n(descriptor2, 11, stringSerializer, null);
            Date date19 = (Date) compositeDecoderB.n(descriptor2, 12, iSO8601DateSerializer, null);
            String str8 = (String) compositeDecoderB.n(descriptor2, 13, stringSerializer, null);
            SubscriptionInfoResponse.PriceResponse priceResponse3 = (SubscriptionInfoResponse.PriceResponse) compositeDecoderB.n(descriptor2, 14, SubscriptionInfoResponse$PriceResponse$$serializer.INSTANCE, null);
            String str9 = (String) compositeDecoderB.n(descriptor2, 15, stringSerializer, null);
            i3 = 131071;
            str2 = (String) compositeDecoderB.n(descriptor2, 16, stringSerializer, null);
            str3 = str9;
            date2 = date18;
            ownershipType = ownershipType2;
            date6 = date13;
            date = date12;
            store = store2;
            date5 = date17;
            date3 = date16;
            date4 = date15;
            z2 = zC;
            date7 = date14;
            priceResponse = priceResponse3;
            date8 = date19;
            str4 = str8;
            str = str7;
            periodType = periodType2;
        } else {
            int i5 = 9;
            int i6 = 8;
            boolean z3 = true;
            boolean zC2 = false;
            String str10 = null;
            SubscriptionInfoResponse.PriceResponse priceResponse4 = null;
            Date date20 = null;
            String str11 = null;
            Store store3 = null;
            String str12 = null;
            Date date21 = null;
            PeriodType periodType3 = null;
            OwnershipType ownershipType3 = null;
            Date date22 = null;
            Date date23 = null;
            Date date24 = null;
            Date date25 = null;
            Date date26 = null;
            Date date27 = null;
            i3 = 0;
            String str13 = null;
            while (z3) {
                Store store4 = store3;
                int iO = compositeDecoderB.o(descriptor2);
                switch (iO) {
                    case -1:
                        store3 = store4;
                        z3 = false;
                        date20 = date20;
                        priceResponse4 = priceResponse4;
                        i6 = 8;
                        i5 = 9;
                        break;
                    case 0:
                        str5 = str10;
                        priceResponse2 = priceResponse4;
                        date10 = date20;
                        store3 = store4;
                        date25 = (Date) compositeDecoderB.y(descriptor2, 0, ISO8601DateSerializer.INSTANCE, date25);
                        i3 |= 1;
                        date26 = date26;
                        date20 = date10;
                        priceResponse4 = priceResponse2;
                        str10 = str5;
                        i6 = 8;
                        i5 = 9;
                        break;
                    case 1:
                        str5 = str10;
                        priceResponse2 = priceResponse4;
                        date10 = date20;
                        store3 = store4;
                        date26 = (Date) compositeDecoderB.n(descriptor2, 1, ISO8601DateSerializer.INSTANCE, date26);
                        i3 |= 2;
                        date27 = date27;
                        date20 = date10;
                        priceResponse4 = priceResponse2;
                        str10 = str5;
                        i6 = 8;
                        i5 = 9;
                        break;
                    case 2:
                        str5 = str10;
                        priceResponse2 = priceResponse4;
                        store3 = store4;
                        date10 = date20;
                        date27 = (Date) compositeDecoderB.n(descriptor2, 2, ISO8601DateSerializer.INSTANCE, date27);
                        i3 |= 4;
                        date20 = date10;
                        priceResponse4 = priceResponse2;
                        str10 = str5;
                        i6 = 8;
                        i5 = 9;
                        break;
                    case 3:
                        str5 = str10;
                        priceResponse2 = priceResponse4;
                        store3 = (Store) compositeDecoderB.y(descriptor2, 3, StoreSerializer.INSTANCE, store4);
                        i3 |= 8;
                        priceResponse4 = priceResponse2;
                        str10 = str5;
                        i6 = 8;
                        i5 = 9;
                        break;
                    case 4:
                        str6 = str10;
                        zC2 = compositeDecoderB.C(descriptor2, 4);
                        i3 |= 16;
                        str10 = str6;
                        store3 = store4;
                        i6 = 8;
                        i5 = 9;
                        break;
                    case 5:
                        str6 = str10;
                        date23 = (Date) compositeDecoderB.n(descriptor2, 5, ISO8601DateSerializer.INSTANCE, date23);
                        i3 |= 32;
                        str10 = str6;
                        store3 = store4;
                        i6 = 8;
                        i5 = 9;
                        break;
                    case 6:
                        date11 = date23;
                        date22 = (Date) compositeDecoderB.n(descriptor2, 6, ISO8601DateSerializer.INSTANCE, date22);
                        i3 |= 64;
                        store3 = store4;
                        date23 = date11;
                        i6 = 8;
                        i5 = 9;
                        break;
                    case 7:
                        date11 = date23;
                        date24 = (Date) compositeDecoderB.n(descriptor2, 7, ISO8601DateSerializer.INSTANCE, date24);
                        i3 |= ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
                        store3 = store4;
                        date23 = date11;
                        i6 = 8;
                        i5 = 9;
                        break;
                    case 8:
                        ownershipType3 = (OwnershipType) compositeDecoderB.y(descriptor2, i6, kSerializerArr[i6], ownershipType3);
                        i3 |= Function.MAX_NARGS;
                        store3 = store4;
                        date23 = date23;
                        i5 = 9;
                        break;
                    case 9:
                        date9 = date23;
                        periodType3 = (PeriodType) compositeDecoderB.y(descriptor2, i5, kSerializerArr[i5], periodType3);
                        i3 |= 512;
                        store3 = store4;
                        date23 = date9;
                        break;
                    case 10:
                        date9 = date23;
                        date21 = (Date) compositeDecoderB.n(descriptor2, 10, ISO8601DateSerializer.INSTANCE, date21);
                        i3 |= 1024;
                        store3 = store4;
                        date23 = date9;
                        break;
                    case 11:
                        date9 = date23;
                        str11 = (String) compositeDecoderB.n(descriptor2, 11, StringSerializer.f142891a, str11);
                        i3 |= 2048;
                        store3 = store4;
                        date23 = date9;
                        break;
                    case 12:
                        date9 = date23;
                        date20 = (Date) compositeDecoderB.n(descriptor2, 12, ISO8601DateSerializer.INSTANCE, date20);
                        i3 |= 4096;
                        store3 = store4;
                        date23 = date9;
                        break;
                    case 13:
                        date9 = date23;
                        str10 = (String) compositeDecoderB.n(descriptor2, 13, StringSerializer.f142891a, str10);
                        i3 |= Utility.DEFAULT_STREAM_BUFFER_SIZE;
                        store3 = store4;
                        date23 = date9;
                        break;
                    case 14:
                        date9 = date23;
                        priceResponse4 = (SubscriptionInfoResponse.PriceResponse) compositeDecoderB.n(descriptor2, 14, SubscriptionInfoResponse$PriceResponse$$serializer.INSTANCE, priceResponse4);
                        i3 |= 16384;
                        store3 = store4;
                        date23 = date9;
                        break;
                    case 15:
                        date9 = date23;
                        str12 = (String) compositeDecoderB.n(descriptor2, 15, StringSerializer.f142891a, str12);
                        i4 = 32768;
                        i3 |= i4;
                        store3 = store4;
                        date23 = date9;
                        break;
                    case 16:
                        date9 = date23;
                        str13 = (String) compositeDecoderB.n(descriptor2, 16, StringSerializer.f142891a, str13);
                        i4 = NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
                        i3 |= i4;
                        store3 = store4;
                        date23 = date9;
                        break;
                    default:
                        throw new UnknownFieldException(iO);
                }
            }
            date = date25;
            str = str11;
            store = store3;
            str2 = str13;
            str3 = str12;
            date2 = date21;
            periodType = periodType3;
            ownershipType = ownershipType3;
            date3 = date22;
            date4 = date23;
            date5 = date24;
            date6 = date26;
            date7 = date27;
            date8 = date20;
            priceResponse = priceResponse4;
            str4 = str10;
            z2 = zC2;
        }
        int i7 = i3;
        compositeDecoderB.c(descriptor2);
        return new SubscriptionInfoResponse(i7, date, date6, date7, store, z2, date4, date3, date5, ownershipType, periodType, date2, str, date8, str4, priceResponse, str3, str2, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, SubscriptionInfoResponse value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderB = encoder.b(descriptor2);
        SubscriptionInfoResponse.write$Self$purchases_defaultsBc8Release(value, compositeEncoderB, descriptor2);
        compositeEncoderB.c(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
