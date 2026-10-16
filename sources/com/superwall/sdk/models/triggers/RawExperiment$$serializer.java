package com.superwall.sdk.models.triggers;

import java.util.List;
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
public /* synthetic */ class RawExperiment$$serializer implements GeneratedSerializer<RawExperiment> {
    public static final RawExperiment$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        RawExperiment$$serializer rawExperiment$$serializer = new RawExperiment$$serializer();
        INSTANCE = rawExperiment$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.superwall.sdk.models.triggers.RawExperiment", rawExperiment$$serializer, 3);
        pluginGeneratedSerialDescriptor.p("id", false);
        pluginGeneratedSerialDescriptor.p("groupId", false);
        pluginGeneratedSerialDescriptor.p("variants", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private RawExperiment$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        KSerializer<?> kSerializer = RawExperiment.$childSerializers[2];
        StringSerializer stringSerializer = StringSerializer.f142891a;
        return new KSerializer[]{stringSerializer, stringSerializer, kSerializer};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final RawExperiment deserialize(Decoder decoder) {
        int i3;
        String str;
        String str2;
        List list;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderB = decoder.b(serialDescriptor);
        KSerializer[] kSerializerArr = RawExperiment.$childSerializers;
        String strM = null;
        if (compositeDecoderB.p()) {
            String strM2 = compositeDecoderB.m(serialDescriptor, 0);
            String strM3 = compositeDecoderB.m(serialDescriptor, 1);
            list = (List) compositeDecoderB.y(serialDescriptor, 2, kSerializerArr[2], null);
            str = strM2;
            i3 = 7;
            str2 = strM3;
        } else {
            boolean z2 = true;
            int i4 = 0;
            String strM4 = null;
            List list2 = null;
            while (z2) {
                int iO = compositeDecoderB.o(serialDescriptor);
                if (iO == -1) {
                    z2 = false;
                } else if (iO == 0) {
                    strM = compositeDecoderB.m(serialDescriptor, 0);
                    i4 |= 1;
                } else if (iO == 1) {
                    strM4 = compositeDecoderB.m(serialDescriptor, 1);
                    i4 |= 2;
                } else {
                    if (iO != 2) {
                        throw new UnknownFieldException(iO);
                    }
                    list2 = (List) compositeDecoderB.y(serialDescriptor, 2, kSerializerArr[2], list2);
                    i4 |= 4;
                }
            }
            i3 = i4;
            str = strM;
            str2 = strM4;
            list = list2;
        }
        compositeDecoderB.c(serialDescriptor);
        return new RawExperiment(i3, str, str2, list, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, RawExperiment value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderB = encoder.b(serialDescriptor);
        RawExperiment.write$Self$superwall_release(value, compositeEncoderB, serialDescriptor);
        compositeEncoderB.c(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
