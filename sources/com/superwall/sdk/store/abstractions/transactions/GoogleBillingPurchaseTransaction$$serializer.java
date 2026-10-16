package com.superwall.sdk.store.abstractions.transactions;

import com.facebook.AuthenticationToken;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.google.firebase.crashlytics.internal.breadcrumbs.PKU.tDEtWsFLJfe;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import com.superwall.sdk.models.serialization.DateSerializer;
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
public /* synthetic */ class GoogleBillingPurchaseTransaction$$serializer implements GeneratedSerializer<GoogleBillingPurchaseTransaction> {
    public static final GoogleBillingPurchaseTransaction$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    private GoogleBillingPurchaseTransaction$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        DateSerializer dateSerializer = DateSerializer.INSTANCE;
        KSerializer<?> kSerializerU = BuiltinSerializersKt.u(dateSerializer);
        StringSerializer stringSerializer = StringSerializer.f142891a;
        return new KSerializer[]{kSerializerU, BuiltinSerializersKt.u(stringSerializer), StoreTransactionStateSerializer.INSTANCE, BuiltinSerializersKt.u(stringSerializer), BuiltinSerializersKt.u(dateSerializer), BuiltinSerializersKt.u(stringSerializer), BuiltinSerializersKt.u(stringSerializer), BuiltinSerializersKt.u(stringSerializer), BuiltinSerializersKt.u(BooleanSerializer.f142767a), BuiltinSerializersKt.u(dateSerializer), BuiltinSerializersKt.u(stringSerializer), BuiltinSerializersKt.u(dateSerializer), BuiltinSerializersKt.u(stringSerializer), stringSerializer, StorePayment$$serializer.INSTANCE, BuiltinSerializersKt.u(stringSerializer)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final GoogleBillingPurchaseTransaction deserialize(Decoder decoder) {
        int i3;
        String str;
        Date date;
        StorePayment storePayment;
        String str2;
        String str3;
        String str4;
        Date date2;
        Boolean bool;
        String str5;
        Date date3;
        String str6;
        String str7;
        StoreTransactionState storeTransactionState;
        Date date4;
        String str8;
        String str9;
        String str10;
        String str11;
        Date date5;
        StoreTransactionState storeTransactionState2;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderB = decoder.b(serialDescriptor);
        if (compositeDecoderB.p()) {
            DateSerializer dateSerializer = DateSerializer.INSTANCE;
            Date date6 = (Date) compositeDecoderB.n(serialDescriptor, 0, dateSerializer, null);
            StringSerializer stringSerializer = StringSerializer.f142891a;
            String str12 = (String) compositeDecoderB.n(serialDescriptor, 1, stringSerializer, null);
            StoreTransactionState storeTransactionState3 = (StoreTransactionState) compositeDecoderB.y(serialDescriptor, 2, StoreTransactionStateSerializer.INSTANCE, null);
            str = (String) compositeDecoderB.n(serialDescriptor, 3, stringSerializer, null);
            Date date7 = (Date) compositeDecoderB.n(serialDescriptor, 4, dateSerializer, null);
            String str13 = (String) compositeDecoderB.n(serialDescriptor, 5, stringSerializer, null);
            String str14 = (String) compositeDecoderB.n(serialDescriptor, 6, stringSerializer, null);
            String str15 = (String) compositeDecoderB.n(serialDescriptor, 7, stringSerializer, null);
            Boolean bool2 = (Boolean) compositeDecoderB.n(serialDescriptor, 8, BooleanSerializer.f142767a, null);
            Date date8 = (Date) compositeDecoderB.n(serialDescriptor, 9, dateSerializer, null);
            String str16 = (String) compositeDecoderB.n(serialDescriptor, 10, stringSerializer, null);
            Date date9 = (Date) compositeDecoderB.n(serialDescriptor, 11, dateSerializer, null);
            String str17 = (String) compositeDecoderB.n(serialDescriptor, 12, stringSerializer, null);
            String strM = compositeDecoderB.m(serialDescriptor, 13);
            i3 = 65535;
            storePayment = (StorePayment) compositeDecoderB.y(serialDescriptor, 14, StorePayment$$serializer.INSTANCE, null);
            str2 = (String) compositeDecoderB.n(serialDescriptor, 15, stringSerializer, null);
            str7 = str12;
            str9 = strM;
            date2 = date8;
            str6 = str15;
            str5 = str14;
            str8 = str13;
            date4 = date7;
            bool = bool2;
            str4 = str16;
            date = date6;
            date3 = date9;
            str3 = str17;
            storeTransactionState = storeTransactionState3;
        } else {
            boolean z2 = true;
            String str18 = null;
            Date date10 = null;
            StorePayment storePayment2 = null;
            String str19 = null;
            StoreTransactionState storeTransactionState4 = null;
            String str20 = null;
            String str21 = null;
            Date date11 = null;
            Boolean bool3 = null;
            String str22 = null;
            Date date12 = null;
            String str23 = null;
            String strM2 = null;
            Date date13 = null;
            String str24 = null;
            i3 = 0;
            String str25 = null;
            while (z2) {
                StoreTransactionState storeTransactionState5 = storeTransactionState4;
                int iO = compositeDecoderB.o(serialDescriptor);
                switch (iO) {
                    case -1:
                        str11 = str18;
                        date5 = date10;
                        storeTransactionState2 = storeTransactionState5;
                        z2 = false;
                        storeTransactionState4 = storeTransactionState2;
                        date10 = date5;
                        str18 = str11;
                        break;
                    case 0:
                        str11 = str18;
                        date5 = date10;
                        storeTransactionState2 = storeTransactionState5;
                        date13 = (Date) compositeDecoderB.n(serialDescriptor, 0, DateSerializer.INSTANCE, date13);
                        i3 |= 1;
                        str25 = str25;
                        str24 = str24;
                        storeTransactionState4 = storeTransactionState2;
                        date10 = date5;
                        str18 = str11;
                        break;
                    case 1:
                        str11 = str18;
                        date5 = date10;
                        storeTransactionState2 = storeTransactionState5;
                        str24 = (String) compositeDecoderB.n(serialDescriptor, 1, StringSerializer.f142891a, str24);
                        i3 |= 2;
                        str25 = str25;
                        storeTransactionState4 = storeTransactionState2;
                        date10 = date5;
                        str18 = str11;
                        break;
                    case 2:
                        str11 = str18;
                        date5 = date10;
                        i3 |= 4;
                        storeTransactionState4 = (StoreTransactionState) compositeDecoderB.y(serialDescriptor, 2, StoreTransactionStateSerializer.INSTANCE, storeTransactionState5);
                        str25 = str25;
                        date10 = date5;
                        str18 = str11;
                        break;
                    case 3:
                        str25 = (String) compositeDecoderB.n(serialDescriptor, 3, StringSerializer.f142891a, str25);
                        i3 |= 8;
                        str18 = str18;
                        storeTransactionState4 = storeTransactionState5;
                        break;
                    case 4:
                        str10 = str25;
                        date10 = (Date) compositeDecoderB.n(serialDescriptor, 4, DateSerializer.INSTANCE, date10);
                        i3 |= 16;
                        storeTransactionState4 = storeTransactionState5;
                        str25 = str10;
                        break;
                    case 5:
                        str10 = str25;
                        str18 = (String) compositeDecoderB.n(serialDescriptor, 5, StringSerializer.f142891a, str18);
                        i3 |= 32;
                        storeTransactionState4 = storeTransactionState5;
                        str25 = str10;
                        break;
                    case 6:
                        str10 = str25;
                        str22 = (String) compositeDecoderB.n(serialDescriptor, 6, StringSerializer.f142891a, str22);
                        i3 |= 64;
                        storeTransactionState4 = storeTransactionState5;
                        str25 = str10;
                        break;
                    case 7:
                        str10 = str25;
                        str23 = (String) compositeDecoderB.n(serialDescriptor, 7, StringSerializer.f142891a, str23);
                        i3 |= ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
                        storeTransactionState4 = storeTransactionState5;
                        str25 = str10;
                        break;
                    case 8:
                        str10 = str25;
                        bool3 = (Boolean) compositeDecoderB.n(serialDescriptor, 8, BooleanSerializer.f142767a, bool3);
                        i3 |= Function.MAX_NARGS;
                        storeTransactionState4 = storeTransactionState5;
                        str25 = str10;
                        break;
                    case 9:
                        str10 = str25;
                        date11 = (Date) compositeDecoderB.n(serialDescriptor, 9, DateSerializer.INSTANCE, date11);
                        i3 |= 512;
                        storeTransactionState4 = storeTransactionState5;
                        str25 = str10;
                        break;
                    case 10:
                        str10 = str25;
                        str21 = (String) compositeDecoderB.n(serialDescriptor, 10, StringSerializer.f142891a, str21);
                        i3 |= 1024;
                        storeTransactionState4 = storeTransactionState5;
                        str25 = str10;
                        break;
                    case 11:
                        str10 = str25;
                        date12 = (Date) compositeDecoderB.n(serialDescriptor, 11, DateSerializer.INSTANCE, date12);
                        i3 |= 2048;
                        storeTransactionState4 = storeTransactionState5;
                        str25 = str10;
                        break;
                    case 12:
                        str10 = str25;
                        str20 = (String) compositeDecoderB.n(serialDescriptor, 12, StringSerializer.f142891a, str20);
                        i3 |= 4096;
                        storeTransactionState4 = storeTransactionState5;
                        str25 = str10;
                        break;
                    case 13:
                        str10 = str25;
                        strM2 = compositeDecoderB.m(serialDescriptor, 13);
                        i3 |= Utility.DEFAULT_STREAM_BUFFER_SIZE;
                        storeTransactionState4 = storeTransactionState5;
                        str25 = str10;
                        break;
                    case 14:
                        str10 = str25;
                        storePayment2 = (StorePayment) compositeDecoderB.y(serialDescriptor, 14, StorePayment$$serializer.INSTANCE, storePayment2);
                        i3 |= 16384;
                        storeTransactionState4 = storeTransactionState5;
                        str25 = str10;
                        break;
                    case 15:
                        str10 = str25;
                        str19 = (String) compositeDecoderB.n(serialDescriptor, 15, StringSerializer.f142891a, str19);
                        i3 |= 32768;
                        storeTransactionState4 = storeTransactionState5;
                        str25 = str10;
                        break;
                    default:
                        throw new UnknownFieldException(iO);
                }
            }
            StoreTransactionState storeTransactionState6 = storeTransactionState4;
            str = str25;
            date = date13;
            storePayment = storePayment2;
            str2 = str19;
            str3 = str20;
            str4 = str21;
            date2 = date11;
            bool = bool3;
            str5 = str22;
            date3 = date12;
            str6 = str23;
            str7 = str24;
            storeTransactionState = storeTransactionState6;
            date4 = date10;
            str8 = str18;
            str9 = strM2;
        }
        int i4 = i3;
        String str26 = str;
        compositeDecoderB.c(serialDescriptor);
        return new GoogleBillingPurchaseTransaction(i4, date, str7, storeTransactionState, str26, date4, str8, str5, str6, bool, date2, str4, date3, str3, str9, storePayment, str2, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, GoogleBillingPurchaseTransaction value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderB = encoder.b(serialDescriptor);
        GoogleBillingPurchaseTransaction.write$Self$superwall_release(value, compositeEncoderB, serialDescriptor);
        compositeEncoderB.c(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }

    static {
        GoogleBillingPurchaseTransaction$$serializer googleBillingPurchaseTransaction$$serializer = new GoogleBillingPurchaseTransaction$$serializer();
        INSTANCE = googleBillingPurchaseTransaction$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.superwall.sdk.store.abstractions.transactions.GoogleBillingPurchaseTransaction", googleBillingPurchaseTransaction$$serializer, 16);
        pluginGeneratedSerialDescriptor.p("transaction_date", false);
        pluginGeneratedSerialDescriptor.p("original_transaction_identifier", false);
        pluginGeneratedSerialDescriptor.p(ServerProtocol.DIALOG_PARAM_STATE, false);
        pluginGeneratedSerialDescriptor.p("store_transaction_id", false);
        pluginGeneratedSerialDescriptor.p("original_transaction_date", false);
        pluginGeneratedSerialDescriptor.p("web_order_line_item_id", false);
        pluginGeneratedSerialDescriptor.p("app_bundle_id", false);
        pluginGeneratedSerialDescriptor.p("subscription_group_id", false);
        pluginGeneratedSerialDescriptor.p("is_upgraded", false);
        pluginGeneratedSerialDescriptor.p("expiration_date", false);
        pluginGeneratedSerialDescriptor.p("offer_id", false);
        pluginGeneratedSerialDescriptor.p("revocation_date", false);
        pluginGeneratedSerialDescriptor.p("app_account_token", false);
        pluginGeneratedSerialDescriptor.p("purchase_token", false);
        pluginGeneratedSerialDescriptor.p(tDEtWsFLJfe.pldRQv, false);
        pluginGeneratedSerialDescriptor.p(AuthenticationToken.SIGNATURE_KEY, false);
        descriptor = pluginGeneratedSerialDescriptor;
    }
}
