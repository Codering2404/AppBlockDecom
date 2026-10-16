package com.revenuecat.purchases.common.caching;

import com.facebook.AccessToken;
import com.revenuecat.purchases.PurchasesAreCompletedBy;
import com.revenuecat.purchases.common.ReceiptInfo;
import com.revenuecat.purchases.common.ReceiptInfo$$serializer;
import com.revenuecat.purchases.paywalls.events.PaywallPostReceiptData;
import com.revenuecat.purchases.paywalls.events.PaywallPostReceiptData$$serializer;
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
public final class LocalTransactionMetadata$$serializer implements GeneratedSerializer<LocalTransactionMetadata> {
    public static final LocalTransactionMetadata$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        LocalTransactionMetadata$$serializer localTransactionMetadata$$serializer = new LocalTransactionMetadata$$serializer();
        INSTANCE = localTransactionMetadata$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.common.caching.LocalTransactionMetadata", localTransactionMetadata$$serializer, 4);
        pluginGeneratedSerialDescriptor.p(AccessToken.TOKEN_KEY, false);
        pluginGeneratedSerialDescriptor.p("receipt_info", false);
        pluginGeneratedSerialDescriptor.p("paywall_data", true);
        pluginGeneratedSerialDescriptor.p("purchases_are_completed_by", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private LocalTransactionMetadata$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{StringSerializer.f142891a, ReceiptInfo$$serializer.INSTANCE, BuiltinSerializersKt.u(PaywallPostReceiptData$$serializer.INSTANCE), LocalTransactionMetadata.$childSerializers[3]};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public LocalTransactionMetadata deserialize(Decoder decoder) {
        int i3;
        String str;
        ReceiptInfo receiptInfo;
        PaywallPostReceiptData paywallPostReceiptData;
        PurchasesAreCompletedBy purchasesAreCompletedBy;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderB = decoder.b(descriptor2);
        KSerializer[] kSerializerArr = LocalTransactionMetadata.$childSerializers;
        String strM = null;
        if (compositeDecoderB.p()) {
            String strM2 = compositeDecoderB.m(descriptor2, 0);
            ReceiptInfo receiptInfo2 = (ReceiptInfo) compositeDecoderB.y(descriptor2, 1, ReceiptInfo$$serializer.INSTANCE, null);
            PaywallPostReceiptData paywallPostReceiptData2 = (PaywallPostReceiptData) compositeDecoderB.n(descriptor2, 2, PaywallPostReceiptData$$serializer.INSTANCE, null);
            purchasesAreCompletedBy = (PurchasesAreCompletedBy) compositeDecoderB.y(descriptor2, 3, kSerializerArr[3], null);
            str = strM2;
            paywallPostReceiptData = paywallPostReceiptData2;
            i3 = 15;
            receiptInfo = receiptInfo2;
        } else {
            boolean z2 = true;
            int i4 = 0;
            ReceiptInfo receiptInfo3 = null;
            PaywallPostReceiptData paywallPostReceiptData3 = null;
            PurchasesAreCompletedBy purchasesAreCompletedBy2 = null;
            while (z2) {
                int iO = compositeDecoderB.o(descriptor2);
                if (iO == -1) {
                    z2 = false;
                } else if (iO == 0) {
                    strM = compositeDecoderB.m(descriptor2, 0);
                    i4 |= 1;
                } else if (iO == 1) {
                    receiptInfo3 = (ReceiptInfo) compositeDecoderB.y(descriptor2, 1, ReceiptInfo$$serializer.INSTANCE, receiptInfo3);
                    i4 |= 2;
                } else if (iO == 2) {
                    paywallPostReceiptData3 = (PaywallPostReceiptData) compositeDecoderB.n(descriptor2, 2, PaywallPostReceiptData$$serializer.INSTANCE, paywallPostReceiptData3);
                    i4 |= 4;
                } else {
                    if (iO != 3) {
                        throw new UnknownFieldException(iO);
                    }
                    purchasesAreCompletedBy2 = (PurchasesAreCompletedBy) compositeDecoderB.y(descriptor2, 3, kSerializerArr[3], purchasesAreCompletedBy2);
                    i4 |= 8;
                }
            }
            i3 = i4;
            str = strM;
            receiptInfo = receiptInfo3;
            paywallPostReceiptData = paywallPostReceiptData3;
            purchasesAreCompletedBy = purchasesAreCompletedBy2;
        }
        compositeDecoderB.c(descriptor2);
        return new LocalTransactionMetadata(i3, str, receiptInfo, paywallPostReceiptData, purchasesAreCompletedBy, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, LocalTransactionMetadata value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderB = encoder.b(descriptor2);
        LocalTransactionMetadata.write$Self$purchases_defaultsBc8Release(value, compositeEncoderB, descriptor2);
        compositeEncoderB.c(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
