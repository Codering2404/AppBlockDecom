package com.superwall.sdk.utilities;

import androidx.media3.extractor.jpeg.xWt.jTYhJgqLBN;
import com.superwall.sdk.utilities.ErrorTracking;
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
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.LongSerializer;
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
public /* synthetic */ class ErrorTracking$ErrorOccurence$$serializer implements GeneratedSerializer<ErrorTracking.ErrorOccurence> {
    public static final ErrorTracking$ErrorOccurence$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        ErrorTracking$ErrorOccurence$$serializer errorTracking$ErrorOccurence$$serializer = new ErrorTracking$ErrorOccurence$$serializer();
        INSTANCE = errorTracking$ErrorOccurence$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.superwall.sdk.utilities.ErrorTracking.ErrorOccurence", errorTracking$ErrorOccurence$$serializer, 5);
        pluginGeneratedSerialDescriptor.p("type", false);
        pluginGeneratedSerialDescriptor.p("message", false);
        pluginGeneratedSerialDescriptor.p("stacktrace", false);
        pluginGeneratedSerialDescriptor.p("timestamp", false);
        pluginGeneratedSerialDescriptor.p("isFatal", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private ErrorTracking$ErrorOccurence$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        StringSerializer stringSerializer = StringSerializer.f142891a;
        return new KSerializer[]{stringSerializer, stringSerializer, stringSerializer, LongSerializer.f142836a, BooleanSerializer.f142767a};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final ErrorTracking.ErrorOccurence deserialize(Decoder decoder) {
        String strM;
        boolean zC;
        int i3;
        String str;
        String str2;
        long j3;
        Intrinsics.checkNotNullParameter(decoder, jTYhJgqLBN.BNTprrki);
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderB = decoder.b(serialDescriptor);
        if (compositeDecoderB.p()) {
            strM = compositeDecoderB.m(serialDescriptor, 0);
            String strM2 = compositeDecoderB.m(serialDescriptor, 1);
            String strM3 = compositeDecoderB.m(serialDescriptor, 2);
            long jF = compositeDecoderB.f(serialDescriptor, 3);
            zC = compositeDecoderB.C(serialDescriptor, 4);
            i3 = 31;
            str = strM3;
            str2 = strM2;
            j3 = jF;
        } else {
            strM = null;
            String strM4 = null;
            String strM5 = null;
            boolean z2 = true;
            long jF2 = 0;
            boolean zC2 = false;
            int i4 = 0;
            while (z2) {
                int iO = compositeDecoderB.o(serialDescriptor);
                if (iO == -1) {
                    z2 = false;
                } else if (iO == 0) {
                    strM = compositeDecoderB.m(serialDescriptor, 0);
                    i4 |= 1;
                } else if (iO == 1) {
                    strM5 = compositeDecoderB.m(serialDescriptor, 1);
                    i4 |= 2;
                } else if (iO == 2) {
                    strM4 = compositeDecoderB.m(serialDescriptor, 2);
                    i4 |= 4;
                } else if (iO == 3) {
                    jF2 = compositeDecoderB.f(serialDescriptor, 3);
                    i4 |= 8;
                } else {
                    if (iO != 4) {
                        throw new UnknownFieldException(iO);
                    }
                    zC2 = compositeDecoderB.C(serialDescriptor, 4);
                    i4 |= 16;
                }
            }
            zC = zC2;
            i3 = i4;
            str = strM4;
            str2 = strM5;
            j3 = jF2;
        }
        String str3 = strM;
        compositeDecoderB.c(serialDescriptor);
        return new ErrorTracking.ErrorOccurence(i3, str3, str2, str, j3, zC, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, ErrorTracking.ErrorOccurence value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderB = encoder.b(serialDescriptor);
        ErrorTracking.ErrorOccurence.write$Self$superwall_release(value, compositeEncoderB, serialDescriptor);
        compositeEncoderB.c(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
