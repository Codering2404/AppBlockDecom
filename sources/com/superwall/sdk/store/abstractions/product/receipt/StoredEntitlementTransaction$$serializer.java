package com.superwall.sdk.store.abstractions.product.receipt;

import com.applovin.sdk.AppLovinEventParameters;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import com.superwall.sdk.storage.DateSerializer;
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
public /* synthetic */ class StoredEntitlementTransaction$$serializer implements GeneratedSerializer<StoredEntitlementTransaction> {
    public static final StoredEntitlementTransaction$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        StoredEntitlementTransaction$$serializer storedEntitlementTransaction$$serializer = new StoredEntitlementTransaction$$serializer();
        INSTANCE = storedEntitlementTransaction$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.superwall.sdk.store.abstractions.product.receipt.StoredEntitlementTransaction", storedEntitlementTransaction$$serializer, 12);
        pluginGeneratedSerialDescriptor.p(DiagnosticsTracker.PRODUCT_ID_KEY, false);
        pluginGeneratedSerialDescriptor.p(AppLovinEventParameters.CHECKOUT_TRANSACTION_IDENTIFIER, false);
        pluginGeneratedSerialDescriptor.p("purchase_date", false);
        pluginGeneratedSerialDescriptor.p("original_purchase_date", false);
        pluginGeneratedSerialDescriptor.p("expiration_date", false);
        pluginGeneratedSerialDescriptor.p("is_revoked", false);
        pluginGeneratedSerialDescriptor.p(DiagnosticsTracker.PRODUCT_TYPE_KEY, false);
        pluginGeneratedSerialDescriptor.p("will_renew", false);
        pluginGeneratedSerialDescriptor.p("renewed_at", false);
        pluginGeneratedSerialDescriptor.p("is_in_grace_period", false);
        pluginGeneratedSerialDescriptor.p("is_in_billing_retry_period", false);
        pluginGeneratedSerialDescriptor.p("is_active", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private StoredEntitlementTransaction$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr = StoredEntitlementTransaction.$childSerializers;
        DateSerializer dateSerializer = DateSerializer.INSTANCE;
        KSerializer<?> kSerializerU = BuiltinSerializersKt.u(dateSerializer);
        KSerializer<?> kSerializer = kSerializerArr[6];
        KSerializer<?> kSerializerU2 = BuiltinSerializersKt.u(dateSerializer);
        StringSerializer stringSerializer = StringSerializer.f142891a;
        BooleanSerializer booleanSerializer = BooleanSerializer.f142767a;
        return new KSerializer[]{stringSerializer, stringSerializer, dateSerializer, dateSerializer, kSerializerU, booleanSerializer, kSerializer, booleanSerializer, kSerializerU2, booleanSerializer, booleanSerializer, booleanSerializer};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final StoredEntitlementTransaction deserialize(Decoder decoder) {
        String str;
        int i3;
        EntitlementTransactionType entitlementTransactionType;
        Date date;
        Date date2;
        Date date3;
        Date date4;
        String str2;
        boolean zC;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean zC2;
        int i4;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderB = decoder.b(serialDescriptor);
        KSerializer[] kSerializerArr = StoredEntitlementTransaction.$childSerializers;
        int i5 = 10;
        int i6 = 6;
        String strM = null;
        if (compositeDecoderB.p()) {
            String strM2 = compositeDecoderB.m(serialDescriptor, 0);
            String strM3 = compositeDecoderB.m(serialDescriptor, 1);
            DateSerializer dateSerializer = DateSerializer.INSTANCE;
            Date date5 = (Date) compositeDecoderB.y(serialDescriptor, 2, dateSerializer, null);
            Date date6 = (Date) compositeDecoderB.y(serialDescriptor, 3, dateSerializer, null);
            Date date7 = (Date) compositeDecoderB.n(serialDescriptor, 4, dateSerializer, null);
            boolean zC3 = compositeDecoderB.C(serialDescriptor, 5);
            EntitlementTransactionType entitlementTransactionType2 = (EntitlementTransactionType) compositeDecoderB.y(serialDescriptor, 6, kSerializerArr[6], null);
            boolean zC4 = compositeDecoderB.C(serialDescriptor, 7);
            Date date8 = (Date) compositeDecoderB.n(serialDescriptor, 8, dateSerializer, null);
            boolean zC5 = compositeDecoderB.C(serialDescriptor, 9);
            entitlementTransactionType = entitlementTransactionType2;
            str = strM2;
            date = date8;
            zC = compositeDecoderB.C(serialDescriptor, 10);
            z2 = zC5;
            z3 = zC4;
            z4 = zC3;
            date3 = date6;
            zC2 = compositeDecoderB.C(serialDescriptor, 11);
            date2 = date7;
            date4 = date5;
            i3 = 4095;
            str2 = strM3;
        } else {
            int i7 = 11;
            EntitlementTransactionType entitlementTransactionType3 = null;
            Date date9 = null;
            Date date10 = null;
            String strM4 = null;
            boolean z5 = true;
            int i8 = 0;
            boolean zC6 = false;
            boolean zC7 = false;
            boolean zC8 = false;
            boolean zC9 = false;
            boolean zC10 = false;
            Date date11 = null;
            Date date12 = null;
            while (z5) {
                int i9 = i6;
                int iO = compositeDecoderB.o(serialDescriptor);
                switch (iO) {
                    case -1:
                        z5 = false;
                        i7 = 11;
                        i6 = 6;
                        break;
                    case 0:
                        i8 |= 1;
                        strM = compositeDecoderB.m(serialDescriptor, 0);
                        i7 = 11;
                        i5 = 10;
                        i6 = 6;
                        break;
                    case 1:
                        strM4 = compositeDecoderB.m(serialDescriptor, 1);
                        i8 |= 2;
                        i7 = 11;
                        i5 = 10;
                        i6 = 6;
                        break;
                    case 2:
                        date12 = (Date) compositeDecoderB.y(serialDescriptor, 2, DateSerializer.INSTANCE, date12);
                        i8 |= 4;
                        i7 = 11;
                        i5 = 10;
                        i6 = 6;
                        break;
                    case 3:
                        date11 = (Date) compositeDecoderB.y(serialDescriptor, 3, DateSerializer.INSTANCE, date11);
                        i8 |= 8;
                        i7 = 11;
                        i5 = 10;
                        i6 = 6;
                        break;
                    case 4:
                        date10 = (Date) compositeDecoderB.n(serialDescriptor, 4, DateSerializer.INSTANCE, date10);
                        i8 |= 16;
                        i7 = 11;
                        i5 = 10;
                        i6 = 6;
                        break;
                    case 5:
                        i4 = i9;
                        zC9 = compositeDecoderB.C(serialDescriptor, 5);
                        i8 |= 32;
                        i6 = i4;
                        i7 = 11;
                        break;
                    case 6:
                        i4 = i9;
                        entitlementTransactionType3 = (EntitlementTransactionType) compositeDecoderB.y(serialDescriptor, i4, kSerializerArr[i9], entitlementTransactionType3);
                        i8 |= 64;
                        i6 = i4;
                        i7 = 11;
                        break;
                    case 7:
                        zC8 = compositeDecoderB.C(serialDescriptor, 7);
                        i8 |= ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
                        i6 = i9;
                        break;
                    case 8:
                        date9 = (Date) compositeDecoderB.n(serialDescriptor, 8, DateSerializer.INSTANCE, date9);
                        i8 |= Function.MAX_NARGS;
                        i6 = i9;
                        break;
                    case 9:
                        zC7 = compositeDecoderB.C(serialDescriptor, 9);
                        i8 |= 512;
                        i6 = i9;
                        break;
                    case 10:
                        zC6 = compositeDecoderB.C(serialDescriptor, i5);
                        i8 |= 1024;
                        i6 = i9;
                        break;
                    case 11:
                        zC10 = compositeDecoderB.C(serialDescriptor, i7);
                        i8 |= 2048;
                        i6 = i9;
                        break;
                    default:
                        throw new UnknownFieldException(iO);
                }
            }
            str = strM;
            i3 = i8;
            entitlementTransactionType = entitlementTransactionType3;
            date = date9;
            date2 = date10;
            date3 = date11;
            date4 = date12;
            str2 = strM4;
            zC = zC6;
            z2 = zC7;
            z3 = zC8;
            z4 = zC9;
            zC2 = zC10;
        }
        compositeDecoderB.c(serialDescriptor);
        return new StoredEntitlementTransaction(i3, str, str2, date4, date3, date2, z4, entitlementTransactionType, z3, date, z2, zC, zC2, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, StoredEntitlementTransaction value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderB = encoder.b(serialDescriptor);
        StoredEntitlementTransaction.write$Self$superwall_release(value, compositeEncoderB, serialDescriptor);
        compositeEncoderB.c(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
