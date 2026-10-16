package com.superwall.sdk.models.triggers;

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
import kotlinx.serialization.internal.IntSerializer;
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
public /* synthetic */ class TriggerRuleOccurrence$$serializer implements GeneratedSerializer<TriggerRuleOccurrence> {
    public static final TriggerRuleOccurrence$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        TriggerRuleOccurrence$$serializer triggerRuleOccurrence$$serializer = new TriggerRuleOccurrence$$serializer();
        INSTANCE = triggerRuleOccurrence$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.superwall.sdk.models.triggers.TriggerRuleOccurrence", triggerRuleOccurrence$$serializer, 3);
        pluginGeneratedSerialDescriptor.p("key", false);
        pluginGeneratedSerialDescriptor.p("max_count", false);
        pluginGeneratedSerialDescriptor.p("interval", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private TriggerRuleOccurrence$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{StringSerializer.f142891a, IntSerializer.f142823a, RawInterval$$serializer.INSTANCE};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final TriggerRuleOccurrence deserialize(Decoder decoder) {
        int i3;
        int i4;
        String str;
        RawInterval rawInterval;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderB = decoder.b(serialDescriptor);
        if (compositeDecoderB.p()) {
            String strM = compositeDecoderB.m(serialDescriptor, 0);
            int i5 = compositeDecoderB.i(serialDescriptor, 1);
            str = strM;
            rawInterval = (RawInterval) compositeDecoderB.y(serialDescriptor, 2, RawInterval$$serializer.INSTANCE, null);
            i3 = i5;
            i4 = 7;
        } else {
            boolean z2 = true;
            int i6 = 0;
            String strM2 = null;
            RawInterval rawInterval2 = null;
            int i7 = 0;
            while (z2) {
                int iO = compositeDecoderB.o(serialDescriptor);
                if (iO == -1) {
                    z2 = false;
                } else if (iO == 0) {
                    strM2 = compositeDecoderB.m(serialDescriptor, 0);
                    i7 |= 1;
                } else if (iO == 1) {
                    i6 = compositeDecoderB.i(serialDescriptor, 1);
                    i7 |= 2;
                } else {
                    if (iO != 2) {
                        throw new UnknownFieldException(iO);
                    }
                    rawInterval2 = (RawInterval) compositeDecoderB.y(serialDescriptor, 2, RawInterval$$serializer.INSTANCE, rawInterval2);
                    i7 |= 4;
                }
            }
            i3 = i6;
            i4 = i7;
            str = strM2;
            rawInterval = rawInterval2;
        }
        compositeDecoderB.c(serialDescriptor);
        return new TriggerRuleOccurrence(i4, str, i3, rawInterval, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, TriggerRuleOccurrence value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderB = encoder.b(serialDescriptor);
        TriggerRuleOccurrence.write$Self$superwall_release(value, compositeEncoderB, serialDescriptor);
        compositeEncoderB.c(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
