package com.superwall.sdk.store.abstractions.transactions;

import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
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
public /* synthetic */ class StoreTransaction$$serializer implements GeneratedSerializer<StoreTransaction> {
    public static final StoreTransaction$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        StoreTransaction$$serializer storeTransaction$$serializer = new StoreTransaction$$serializer();
        INSTANCE = storeTransaction$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.superwall.sdk.store.abstractions.transactions.StoreTransaction", storeTransaction$$serializer, 4);
        pluginGeneratedSerialDescriptor.p("transaction", false);
        pluginGeneratedSerialDescriptor.p("config_request_id", false);
        pluginGeneratedSerialDescriptor.p(DiagnosticsEntry.APP_SESSION_ID_KEY, false);
        pluginGeneratedSerialDescriptor.p("id", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private StoreTransaction$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        StringSerializer stringSerializer = StringSerializer.f142891a;
        return new KSerializer[]{GoogleBillingPurchaseTransaction$$serializer.INSTANCE, stringSerializer, stringSerializer, stringSerializer};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final StoreTransaction deserialize(Decoder decoder) {
        int i3;
        GoogleBillingPurchaseTransaction googleBillingPurchaseTransaction;
        String str;
        String str2;
        String strM;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderB = decoder.b(serialDescriptor);
        GoogleBillingPurchaseTransaction googleBillingPurchaseTransaction2 = null;
        if (compositeDecoderB.p()) {
            GoogleBillingPurchaseTransaction googleBillingPurchaseTransaction3 = (GoogleBillingPurchaseTransaction) compositeDecoderB.y(serialDescriptor, 0, GoogleBillingPurchaseTransaction$$serializer.INSTANCE, null);
            String strM2 = compositeDecoderB.m(serialDescriptor, 1);
            String strM3 = compositeDecoderB.m(serialDescriptor, 2);
            googleBillingPurchaseTransaction = googleBillingPurchaseTransaction3;
            strM = compositeDecoderB.m(serialDescriptor, 3);
            str2 = strM3;
            str = strM2;
            i3 = 15;
        } else {
            boolean z2 = true;
            int i4 = 0;
            String strM4 = null;
            String strM5 = null;
            String strM6 = null;
            while (z2) {
                int iO = compositeDecoderB.o(serialDescriptor);
                if (iO == -1) {
                    z2 = false;
                } else if (iO == 0) {
                    googleBillingPurchaseTransaction2 = (GoogleBillingPurchaseTransaction) compositeDecoderB.y(serialDescriptor, 0, GoogleBillingPurchaseTransaction$$serializer.INSTANCE, googleBillingPurchaseTransaction2);
                    i4 |= 1;
                } else if (iO == 1) {
                    strM4 = compositeDecoderB.m(serialDescriptor, 1);
                    i4 |= 2;
                } else if (iO == 2) {
                    strM5 = compositeDecoderB.m(serialDescriptor, 2);
                    i4 |= 4;
                } else {
                    if (iO != 3) {
                        throw new UnknownFieldException(iO);
                    }
                    strM6 = compositeDecoderB.m(serialDescriptor, 3);
                    i4 |= 8;
                }
            }
            i3 = i4;
            googleBillingPurchaseTransaction = googleBillingPurchaseTransaction2;
            str = strM4;
            str2 = strM5;
            strM = strM6;
        }
        compositeDecoderB.c(serialDescriptor);
        return new StoreTransaction(i3, googleBillingPurchaseTransaction, str, str2, strM, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, StoreTransaction value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderB = encoder.b(serialDescriptor);
        StoreTransaction.write$Self$superwall_release(value, compositeEncoderB, serialDescriptor);
        compositeEncoderB.c(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
