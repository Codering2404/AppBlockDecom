package com.superwall.sdk.store.abstractions.transactions;

import com.superwall.sdk.store.abstractions.transactions.StoreTransactionState;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;

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
public final class StoreTransactionStateSerializer implements KSerializer<StoreTransactionState> {
    public static final StoreTransactionStateSerializer INSTANCE = new StoreTransactionStateSerializer();
    private static final SerialDescriptor descriptor = new PluginGeneratedSerialDescriptor("com.superwall.sdk.store.abstractions.transactions.StoreTransactionState", null, 0);

    private StoreTransactionStateSerializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // kotlinx.serialization.DeserializationStrategy
    public StoreTransactionState deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        String strZ = decoder.z();
        switch (strZ.hashCode()) {
            case -1791517821:
                if (strZ.equals("purchased")) {
                    return StoreTransactionState.Purchased.INSTANCE;
                }
                break;
            case -1281977283:
                if (strZ.equals("failed")) {
                    return StoreTransactionState.Failed.INSTANCE;
                }
                break;
            case -336625770:
                if (strZ.equals("restored")) {
                    return StoreTransactionState.Restored.INSTANCE;
                }
                break;
            case 297526654:
                if (strZ.equals("purchasing")) {
                    return StoreTransactionState.Purchasing.INSTANCE;
                }
                break;
            case 647890911:
                if (strZ.equals("deferred")) {
                    return StoreTransactionState.Deferred.INSTANCE;
                }
                break;
        }
        throw new SerializationException("Unknown string value: " + strZ);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, StoreTransactionState value) {
        String str;
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        if (value instanceof StoreTransactionState.Purchasing) {
            str = "purchasing";
        } else if (value instanceof StoreTransactionState.Purchased) {
            str = "purchased";
        } else if (value instanceof StoreTransactionState.Failed) {
            str = "failed";
        } else if (value instanceof StoreTransactionState.Restored) {
            str = "restored";
        } else {
            if (!(value instanceof StoreTransactionState.Deferred)) {
                throw new NoWhenBranchMatchedException();
            }
            str = "deferred";
        }
        encoder.G(str);
    }
}
