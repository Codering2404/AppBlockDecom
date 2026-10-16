package com.superwall.sdk.models.entitlements;

import com.superwall.sdk.models.entitlements.TransactionReceipt;
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
public /* synthetic */ class TransactionReceipt$$serializer implements GeneratedSerializer<TransactionReceipt> {
    public static final TransactionReceipt$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        TransactionReceipt$$serializer transactionReceipt$$serializer = new TransactionReceipt$$serializer();
        INSTANCE = transactionReceipt$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.superwall.sdk.models.entitlements.TransactionReceipt", transactionReceipt$$serializer, 5);
        pluginGeneratedSerialDescriptor.p("jwsRepresentation", false);
        pluginGeneratedSerialDescriptor.p("orderId", true);
        pluginGeneratedSerialDescriptor.p("productId", false);
        pluginGeneratedSerialDescriptor.p("productType", false);
        pluginGeneratedSerialDescriptor.p("type", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private TransactionReceipt$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr = TransactionReceipt.$childSerializers;
        StringSerializer stringSerializer = StringSerializer.f142891a;
        return new KSerializer[]{stringSerializer, BuiltinSerializersKt.u(stringSerializer), stringSerializer, kSerializerArr[3], stringSerializer};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final TransactionReceipt deserialize(Decoder decoder) {
        int i3;
        String str;
        String str2;
        String str3;
        TransactionReceipt.ProductType productType;
        String strM;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderB = decoder.b(serialDescriptor);
        KSerializer[] kSerializerArr = TransactionReceipt.$childSerializers;
        String strM2 = null;
        if (compositeDecoderB.p()) {
            String strM3 = compositeDecoderB.m(serialDescriptor, 0);
            String str4 = (String) compositeDecoderB.n(serialDescriptor, 1, StringSerializer.f142891a, null);
            String strM4 = compositeDecoderB.m(serialDescriptor, 2);
            productType = (TransactionReceipt.ProductType) compositeDecoderB.y(serialDescriptor, 3, kSerializerArr[3], null);
            str = strM3;
            strM = compositeDecoderB.m(serialDescriptor, 4);
            str3 = strM4;
            i3 = 31;
            str2 = str4;
        } else {
            boolean z2 = true;
            int i4 = 0;
            String str5 = null;
            String strM5 = null;
            TransactionReceipt.ProductType productType2 = null;
            String strM6 = null;
            while (z2) {
                int iO = compositeDecoderB.o(serialDescriptor);
                if (iO == -1) {
                    z2 = false;
                } else if (iO == 0) {
                    strM2 = compositeDecoderB.m(serialDescriptor, 0);
                    i4 |= 1;
                } else if (iO == 1) {
                    str5 = (String) compositeDecoderB.n(serialDescriptor, 1, StringSerializer.f142891a, str5);
                    i4 |= 2;
                } else if (iO == 2) {
                    strM5 = compositeDecoderB.m(serialDescriptor, 2);
                    i4 |= 4;
                } else if (iO == 3) {
                    productType2 = (TransactionReceipt.ProductType) compositeDecoderB.y(serialDescriptor, 3, kSerializerArr[3], productType2);
                    i4 |= 8;
                } else {
                    if (iO != 4) {
                        throw new UnknownFieldException(iO);
                    }
                    strM6 = compositeDecoderB.m(serialDescriptor, 4);
                    i4 |= 16;
                }
            }
            i3 = i4;
            str = strM2;
            str2 = str5;
            str3 = strM5;
            productType = productType2;
            strM = strM6;
        }
        compositeDecoderB.c(serialDescriptor);
        return new TransactionReceipt(i3, str, str2, str3, productType, strM, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, TransactionReceipt value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderB = encoder.b(serialDescriptor);
        TransactionReceipt.write$Self$superwall_release(value, compositeEncoderB, serialDescriptor);
        compositeEncoderB.c(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
