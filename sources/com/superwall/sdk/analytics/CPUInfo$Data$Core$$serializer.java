package com.superwall.sdk.analytics;

import com.superwall.sdk.analytics.CPUInfo;
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
import kotlinx.serialization.internal.LongSerializer;
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
@Deprecated
public /* synthetic */ class CPUInfo$Data$Core$$serializer implements GeneratedSerializer<CPUInfo.Data.Core> {
    public static final CPUInfo$Data$Core$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        CPUInfo$Data$Core$$serializer cPUInfo$Data$Core$$serializer = new CPUInfo$Data$Core$$serializer();
        INSTANCE = cPUInfo$Data$Core$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.superwall.sdk.analytics.CPUInfo.Data.Core", cPUInfo$Data$Core$$serializer, 4);
        pluginGeneratedSerialDescriptor.p("number", false);
        pluginGeneratedSerialDescriptor.p("currentFreq", false);
        pluginGeneratedSerialDescriptor.p("maxFreq", false);
        pluginGeneratedSerialDescriptor.p("minFreq", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private CPUInfo$Data$Core$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        LongSerializer longSerializer = LongSerializer.f142836a;
        return new KSerializer[]{IntSerializer.f142823a, longSerializer, longSerializer, longSerializer};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final CPUInfo.Data.Core deserialize(Decoder decoder) {
        int i3;
        long jF;
        long j3;
        long j4;
        int i4;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderB = decoder.b(serialDescriptor);
        if (compositeDecoderB.p()) {
            i3 = compositeDecoderB.i(serialDescriptor, 0);
            long jF2 = compositeDecoderB.f(serialDescriptor, 1);
            long jF3 = compositeDecoderB.f(serialDescriptor, 2);
            jF = compositeDecoderB.f(serialDescriptor, 3);
            j3 = jF2;
            j4 = jF3;
            i4 = 15;
        } else {
            long jF4 = 0;
            boolean z2 = true;
            i3 = 0;
            int i5 = 0;
            long jF5 = 0;
            long jF6 = 0;
            while (z2) {
                int iO = compositeDecoderB.o(serialDescriptor);
                if (iO == -1) {
                    z2 = false;
                } else if (iO == 0) {
                    i3 = compositeDecoderB.i(serialDescriptor, 0);
                    i5 |= 1;
                } else if (iO == 1) {
                    jF5 = compositeDecoderB.f(serialDescriptor, 1);
                    i5 |= 2;
                } else if (iO == 2) {
                    jF6 = compositeDecoderB.f(serialDescriptor, 2);
                    i5 |= 4;
                } else {
                    if (iO != 3) {
                        throw new UnknownFieldException(iO);
                    }
                    jF4 = compositeDecoderB.f(serialDescriptor, 3);
                    i5 |= 8;
                }
            }
            jF = jF4;
            j3 = jF5;
            j4 = jF6;
            i4 = i5;
        }
        int i6 = i3;
        compositeDecoderB.c(serialDescriptor);
        return new CPUInfo.Data.Core(i4, i6, j3, j4, jF, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, CPUInfo.Data.Core value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderB = encoder.b(serialDescriptor);
        CPUInfo.Data.Core.write$Self$superwall_release(value, compositeEncoderB, serialDescriptor);
        compositeEncoderB.c(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
