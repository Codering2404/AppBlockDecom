package com.superwall.sdk.models.paywall;

import com.superwall.sdk.models.paywall.LocalNotificationType;
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
public final class LocalNotificationTypeSerializer implements KSerializer<LocalNotificationType> {
    public static final LocalNotificationTypeSerializer INSTANCE = new LocalNotificationTypeSerializer();
    private static final SerialDescriptor descriptor;

    static {
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.superwall.sdk.models.paywall.LocalNotificationType", null, 1);
        pluginGeneratedSerialDescriptor.p("raw", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private LocalNotificationTypeSerializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public LocalNotificationType deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        return Intrinsics.areEqual(decoder.z(), "TRIAL_STARTED") ? LocalNotificationType.TrialStarted.INSTANCE : LocalNotificationType.Unsupported.INSTANCE;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, LocalNotificationType value) {
        String str;
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        if (Intrinsics.areEqual(value, LocalNotificationType.TrialStarted.INSTANCE)) {
            str = "TRIAL_STARTED";
        } else {
            if (!Intrinsics.areEqual(value, LocalNotificationType.Unsupported.INSTANCE)) {
                throw new NoWhenBranchMatchedException();
            }
            str = "UNSUPPORTED";
        }
        encoder.G(str);
    }
}
