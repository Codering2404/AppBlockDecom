package com.superwall.sdk.models.config;

import com.superwall.sdk.models.config.FeatureGatingBehavior;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
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
public final class FeatureGatingBehaviorSerializer implements KSerializer<FeatureGatingBehavior> {
    public static final FeatureGatingBehaviorSerializer INSTANCE = new FeatureGatingBehaviorSerializer();
    private static final SerialDescriptor descriptor = new PluginGeneratedSerialDescriptor("com.superwall.sdk.models.config.FeatureGatingBehavior", null, 0);

    private FeatureGatingBehaviorSerializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public FeatureGatingBehavior deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        String strZ = decoder.z();
        return Intrinsics.areEqual(strZ, "GATED") ? FeatureGatingBehavior.Gated.INSTANCE : Intrinsics.areEqual(strZ, "NON_GATED") ? FeatureGatingBehavior.NonGated.INSTANCE : FeatureGatingBehavior.NonGated.INSTANCE;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, FeatureGatingBehavior value) {
        String str;
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        if (value instanceof FeatureGatingBehavior.Gated) {
            str = "GATED";
        } else {
            if (!(value instanceof FeatureGatingBehavior.NonGated)) {
                throw new NoWhenBranchMatchedException();
            }
            str = "NON_GATED";
        }
        encoder.G(str);
    }
}
