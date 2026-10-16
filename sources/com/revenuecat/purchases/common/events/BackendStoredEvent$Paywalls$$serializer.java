package com.revenuecat.purchases.common.events;

import com.revenuecat.purchases.common.events.BackendEvent;
import com.revenuecat.purchases.common.events.BackendStoredEvent;
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
public final class BackendStoredEvent$Paywalls$$serializer implements GeneratedSerializer<BackendStoredEvent.Paywalls> {
    public static final BackendStoredEvent$Paywalls$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        BackendStoredEvent$Paywalls$$serializer backendStoredEvent$Paywalls$$serializer = new BackendStoredEvent$Paywalls$$serializer();
        INSTANCE = backendStoredEvent$Paywalls$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("paywalls", backendStoredEvent$Paywalls$$serializer, 1);
        pluginGeneratedSerialDescriptor.p("event", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private BackendStoredEvent$Paywalls$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BackendEvent$Paywalls$$serializer.INSTANCE};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public BackendStoredEvent.Paywalls deserialize(Decoder decoder) {
        BackendEvent.Paywalls paywalls;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderB = decoder.b(descriptor2);
        int i3 = 1;
        if (compositeDecoderB.p()) {
            paywalls = (BackendEvent.Paywalls) compositeDecoderB.y(descriptor2, 0, BackendEvent$Paywalls$$serializer.INSTANCE, null);
        } else {
            boolean z2 = true;
            int i4 = 0;
            paywalls = null;
            while (z2) {
                int iO = compositeDecoderB.o(descriptor2);
                if (iO == -1) {
                    z2 = false;
                } else {
                    if (iO != 0) {
                        throw new UnknownFieldException(iO);
                    }
                    paywalls = (BackendEvent.Paywalls) compositeDecoderB.y(descriptor2, 0, BackendEvent$Paywalls$$serializer.INSTANCE, paywalls);
                    i4 = 1;
                }
            }
            i3 = i4;
        }
        compositeDecoderB.c(descriptor2);
        return new BackendStoredEvent.Paywalls(i3, paywalls, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, BackendStoredEvent.Paywalls value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderB = encoder.b(descriptor2);
        BackendStoredEvent.Paywalls.write$Self$purchases_defaultsBc8Release(value, compositeEncoderB, descriptor2);
        compositeEncoderB.c(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
