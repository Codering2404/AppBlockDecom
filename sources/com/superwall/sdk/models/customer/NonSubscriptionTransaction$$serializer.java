package com.superwall.sdk.models.customer;

import com.revenuecat.purchases.common.responses.ProductResponseJsonKeys;
import com.superwall.sdk.models.product.Store;
import com.superwall.sdk.models.product.StoreSerializer;
import com.superwall.sdk.models.serialization.DateSerializer;
import java.util.Date;
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
public /* synthetic */ class NonSubscriptionTransaction$$serializer implements GeneratedSerializer<NonSubscriptionTransaction> {
    public static final NonSubscriptionTransaction$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        NonSubscriptionTransaction$$serializer nonSubscriptionTransaction$$serializer = new NonSubscriptionTransaction$$serializer();
        INSTANCE = nonSubscriptionTransaction$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.superwall.sdk.models.customer.NonSubscriptionTransaction", nonSubscriptionTransaction$$serializer, 6);
        pluginGeneratedSerialDescriptor.p("transactionId", false);
        pluginGeneratedSerialDescriptor.p("productId", false);
        pluginGeneratedSerialDescriptor.p("purchaseDate", false);
        pluginGeneratedSerialDescriptor.p("isConsumable", false);
        pluginGeneratedSerialDescriptor.p("isRevoked", false);
        pluginGeneratedSerialDescriptor.p(ProductResponseJsonKeys.STORE, true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private NonSubscriptionTransaction$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        StringSerializer stringSerializer = StringSerializer.f142891a;
        BooleanSerializer booleanSerializer = BooleanSerializer.f142767a;
        return new KSerializer[]{stringSerializer, stringSerializer, DateSerializer.INSTANCE, booleanSerializer, booleanSerializer, StoreSerializer.INSTANCE};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final NonSubscriptionTransaction deserialize(Decoder decoder) {
        boolean z2;
        boolean z3;
        int i3;
        String str;
        String str2;
        Date date;
        Store store;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderB = decoder.b(serialDescriptor);
        if (compositeDecoderB.p()) {
            String strM = compositeDecoderB.m(serialDescriptor, 0);
            String strM2 = compositeDecoderB.m(serialDescriptor, 1);
            Date date2 = (Date) compositeDecoderB.y(serialDescriptor, 2, DateSerializer.INSTANCE, null);
            boolean zC = compositeDecoderB.C(serialDescriptor, 3);
            boolean zC2 = compositeDecoderB.C(serialDescriptor, 4);
            str = strM;
            store = (Store) compositeDecoderB.y(serialDescriptor, 5, StoreSerializer.INSTANCE, null);
            z2 = zC;
            z3 = zC2;
            date = date2;
            str2 = strM2;
            i3 = 63;
        } else {
            boolean z4 = true;
            boolean zC3 = false;
            int i4 = 0;
            String strM3 = null;
            String strM4 = null;
            Date date3 = null;
            Store store2 = null;
            boolean zC4 = false;
            while (z4) {
                int iO = compositeDecoderB.o(serialDescriptor);
                switch (iO) {
                    case -1:
                        z4 = false;
                        continue;
                    case 0:
                        strM3 = compositeDecoderB.m(serialDescriptor, 0);
                        i4 |= 1;
                        continue;
                    case 1:
                        strM4 = compositeDecoderB.m(serialDescriptor, 1);
                        i4 |= 2;
                        break;
                    case 2:
                        date3 = (Date) compositeDecoderB.y(serialDescriptor, 2, DateSerializer.INSTANCE, date3);
                        i4 |= 4;
                        break;
                    case 3:
                        zC3 = compositeDecoderB.C(serialDescriptor, 3);
                        i4 |= 8;
                        break;
                    case 4:
                        zC4 = compositeDecoderB.C(serialDescriptor, 4);
                        i4 |= 16;
                        break;
                    case 5:
                        store2 = (Store) compositeDecoderB.y(serialDescriptor, 5, StoreSerializer.INSTANCE, store2);
                        i4 |= 32;
                        break;
                    default:
                        throw new UnknownFieldException(iO);
                }
            }
            z2 = zC3;
            z3 = zC4;
            i3 = i4;
            str = strM3;
            str2 = strM4;
            date = date3;
            store = store2;
        }
        compositeDecoderB.c(serialDescriptor);
        return new NonSubscriptionTransaction(i3, str, str2, date, z2, z3, store, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, NonSubscriptionTransaction value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderB = encoder.b(serialDescriptor);
        NonSubscriptionTransaction.write$Self$superwall_release(value, compositeEncoderB, serialDescriptor);
        compositeEncoderB.c(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
