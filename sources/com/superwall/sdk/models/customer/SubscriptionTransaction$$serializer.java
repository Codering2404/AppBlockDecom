package com.superwall.sdk.models.customer;

import com.revenuecat.purchases.common.responses.ProductResponseJsonKeys;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import com.superwall.sdk.models.product.Store;
import com.superwall.sdk.models.product.StoreSerializer;
import com.superwall.sdk.models.serialization.DateSerializer;
import com.superwall.sdk.store.abstractions.product.receipt.LatestPeriodType;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@Deprecated
public /* synthetic */ class SubscriptionTransaction$$serializer implements GeneratedSerializer<SubscriptionTransaction> {
    public static final SubscriptionTransaction$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        SubscriptionTransaction$$serializer subscriptionTransaction$$serializer = new SubscriptionTransaction$$serializer();
        INSTANCE = subscriptionTransaction$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.superwall.sdk.models.customer.SubscriptionTransaction", subscriptionTransaction$$serializer, 12);
        pluginGeneratedSerialDescriptor.p("transactionId", false);
        pluginGeneratedSerialDescriptor.p("productId", false);
        pluginGeneratedSerialDescriptor.p("purchaseDate", false);
        pluginGeneratedSerialDescriptor.p("willRenew", false);
        pluginGeneratedSerialDescriptor.p("isRevoked", false);
        pluginGeneratedSerialDescriptor.p("isInGracePeriod", false);
        pluginGeneratedSerialDescriptor.p("isInBillingRetryPeriod", false);
        pluginGeneratedSerialDescriptor.p("isActive", false);
        pluginGeneratedSerialDescriptor.p("expirationDate", false);
        pluginGeneratedSerialDescriptor.p(ProductResponseJsonKeys.STORE, true);
        pluginGeneratedSerialDescriptor.p("offerType", true);
        pluginGeneratedSerialDescriptor.p("subscriptionGroupId", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private SubscriptionTransaction$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        KSerializer[] kSerializerArr = SubscriptionTransaction.$childSerializers;
        StringSerializer stringSerializer = StringSerializer.f142891a;
        DateSerializer dateSerializer = DateSerializer.INSTANCE;
        KSerializer<?> kSerializerU = BuiltinSerializersKt.u(dateSerializer);
        KSerializer<?> kSerializerU2 = BuiltinSerializersKt.u(kSerializerArr[10]);
        KSerializer<?> kSerializerU3 = BuiltinSerializersKt.u(stringSerializer);
        BooleanSerializer booleanSerializer = BooleanSerializer.f142767a;
        return new KSerializer[]{stringSerializer, stringSerializer, dateSerializer, booleanSerializer, booleanSerializer, booleanSerializer, booleanSerializer, booleanSerializer, kSerializerU, StoreSerializer.INSTANCE, kSerializerU2, kSerializerU3};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final SubscriptionTransaction deserialize(Decoder decoder) {
        String str;
        String str2;
        int i3;
        LatestPeriodType latestPeriodType;
        String str3;
        Store store;
        Date date;
        Date date2;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        int i4;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderB = decoder.b(serialDescriptor);
        KSerializer[] kSerializerArr = SubscriptionTransaction.$childSerializers;
        int i5 = 9;
        int i6 = 7;
        String strM = null;
        if (compositeDecoderB.p()) {
            String strM2 = compositeDecoderB.m(serialDescriptor, 0);
            String strM3 = compositeDecoderB.m(serialDescriptor, 1);
            DateSerializer dateSerializer = DateSerializer.INSTANCE;
            Date date3 = (Date) compositeDecoderB.y(serialDescriptor, 2, dateSerializer, null);
            boolean zC = compositeDecoderB.C(serialDescriptor, 3);
            boolean zC2 = compositeDecoderB.C(serialDescriptor, 4);
            boolean zC3 = compositeDecoderB.C(serialDescriptor, 5);
            boolean zC4 = compositeDecoderB.C(serialDescriptor, 6);
            boolean zC5 = compositeDecoderB.C(serialDescriptor, 7);
            Date date4 = (Date) compositeDecoderB.n(serialDescriptor, 8, dateSerializer, null);
            Store store2 = (Store) compositeDecoderB.y(serialDescriptor, 9, StoreSerializer.INSTANCE, null);
            latestPeriodType = (LatestPeriodType) compositeDecoderB.n(serialDescriptor, 10, kSerializerArr[10], null);
            str2 = strM2;
            str3 = (String) compositeDecoderB.n(serialDescriptor, 11, StringSerializer.f142891a, null);
            store = store2;
            z2 = zC5;
            z3 = zC4;
            z4 = zC3;
            z5 = zC;
            date = date4;
            z6 = zC2;
            date2 = date3;
            i3 = 4095;
            str = strM3;
        } else {
            String strM4 = null;
            LatestPeriodType latestPeriodType2 = null;
            String str4 = null;
            Store store3 = null;
            boolean z7 = true;
            int i7 = 0;
            boolean zC6 = false;
            boolean zC7 = false;
            boolean zC8 = false;
            boolean zC9 = false;
            boolean zC10 = false;
            Date date5 = null;
            Date date6 = null;
            while (z7) {
                int iO = compositeDecoderB.o(serialDescriptor);
                switch (iO) {
                    case -1:
                        z7 = false;
                        break;
                    case 0:
                        i7 |= 1;
                        i6 = i6;
                        strM = compositeDecoderB.m(serialDescriptor, 0);
                        i5 = 9;
                        break;
                    case 1:
                        i4 = i6;
                        strM4 = compositeDecoderB.m(serialDescriptor, 1);
                        i7 |= 2;
                        i6 = i4;
                        i5 = 9;
                        break;
                    case 2:
                        i4 = i6;
                        date6 = (Date) compositeDecoderB.y(serialDescriptor, 2, DateSerializer.INSTANCE, date6);
                        i7 |= 4;
                        i6 = i4;
                        i5 = 9;
                        break;
                    case 3:
                        i4 = i6;
                        zC9 = compositeDecoderB.C(serialDescriptor, 3);
                        i7 |= 8;
                        i6 = i4;
                        i5 = 9;
                        break;
                    case 4:
                        i4 = i6;
                        zC10 = compositeDecoderB.C(serialDescriptor, 4);
                        i7 |= 16;
                        i6 = i4;
                        i5 = 9;
                        break;
                    case 5:
                        i4 = i6;
                        zC8 = compositeDecoderB.C(serialDescriptor, 5);
                        i7 |= 32;
                        i6 = i4;
                        i5 = 9;
                        break;
                    case 6:
                        zC7 = compositeDecoderB.C(serialDescriptor, 6);
                        i7 |= 64;
                        i6 = i6;
                        i5 = 9;
                        break;
                    case 7:
                        int i8 = i6;
                        zC6 = compositeDecoderB.C(serialDescriptor, i8);
                        i7 |= ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
                        i6 = i8;
                        break;
                    case 8:
                        date5 = (Date) compositeDecoderB.n(serialDescriptor, 8, DateSerializer.INSTANCE, date5);
                        i7 |= Function.MAX_NARGS;
                        i6 = 7;
                        break;
                    case 9:
                        store3 = (Store) compositeDecoderB.y(serialDescriptor, i5, StoreSerializer.INSTANCE, store3);
                        i7 |= 512;
                        i6 = 7;
                        break;
                    case 10:
                        latestPeriodType2 = (LatestPeriodType) compositeDecoderB.n(serialDescriptor, 10, kSerializerArr[10], latestPeriodType2);
                        i7 |= 1024;
                        i6 = 7;
                        break;
                    case 11:
                        str4 = (String) compositeDecoderB.n(serialDescriptor, 11, StringSerializer.f142891a, str4);
                        i7 |= 2048;
                        i6 = 7;
                        break;
                    default:
                        throw new UnknownFieldException(iO);
                }
            }
            str = strM4;
            str2 = strM;
            i3 = i7;
            latestPeriodType = latestPeriodType2;
            str3 = str4;
            store = store3;
            date = date5;
            date2 = date6;
            z2 = zC6;
            z3 = zC7;
            z4 = zC8;
            z5 = zC9;
            z6 = zC10;
        }
        compositeDecoderB.c(serialDescriptor);
        return new SubscriptionTransaction(i3, str2, str, date2, z5, z6, z4, z3, z2, date, store, latestPeriodType, str3, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, SubscriptionTransaction value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderB = encoder.b(serialDescriptor);
        SubscriptionTransaction.write$Self$superwall_release(value, compositeEncoderB, serialDescriptor);
        compositeEncoderB.c(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
