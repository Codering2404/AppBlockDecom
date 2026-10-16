package com.superwall.sdk.models.transactions;

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
public /* synthetic */ class SavedTransaction$$serializer implements GeneratedSerializer<SavedTransaction> {
    public static final SavedTransaction$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        SavedTransaction$$serializer savedTransaction$$serializer = new SavedTransaction$$serializer();
        INSTANCE = savedTransaction$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.superwall.sdk.models.transactions.SavedTransaction", savedTransaction$$serializer, 4);
        pluginGeneratedSerialDescriptor.p("id", false);
        pluginGeneratedSerialDescriptor.p("date", false);
        pluginGeneratedSerialDescriptor.p("hasExternalPurchaseController", false);
        pluginGeneratedSerialDescriptor.p("isExternal", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private SavedTransaction$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        BooleanSerializer booleanSerializer = BooleanSerializer.f142767a;
        return new KSerializer[]{StringSerializer.f142891a, LongSerializer.f142836a, booleanSerializer, booleanSerializer};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final SavedTransaction deserialize(Decoder decoder) {
        String strM;
        boolean zC;
        boolean z2;
        long j3;
        int i3;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderB = decoder.b(serialDescriptor);
        if (compositeDecoderB.p()) {
            strM = compositeDecoderB.m(serialDescriptor, 0);
            long jF = compositeDecoderB.f(serialDescriptor, 1);
            boolean zC2 = compositeDecoderB.C(serialDescriptor, 2);
            zC = compositeDecoderB.C(serialDescriptor, 3);
            z2 = zC2;
            j3 = jF;
            i3 = 15;
        } else {
            strM = null;
            boolean z3 = true;
            int i4 = 0;
            long jF2 = 0;
            boolean zC3 = false;
            boolean zC4 = false;
            while (z3) {
                int iO = compositeDecoderB.o(serialDescriptor);
                if (iO == -1) {
                    z3 = false;
                } else if (iO == 0) {
                    strM = compositeDecoderB.m(serialDescriptor, 0);
                    i4 |= 1;
                } else if (iO == 1) {
                    jF2 = compositeDecoderB.f(serialDescriptor, 1);
                    i4 |= 2;
                } else if (iO == 2) {
                    zC4 = compositeDecoderB.C(serialDescriptor, 2);
                    i4 |= 4;
                } else {
                    if (iO != 3) {
                        throw new UnknownFieldException(iO);
                    }
                    zC3 = compositeDecoderB.C(serialDescriptor, 3);
                    i4 |= 8;
                }
            }
            zC = zC3;
            z2 = zC4;
            j3 = jF2;
            i3 = i4;
        }
        String str = strM;
        compositeDecoderB.c(serialDescriptor);
        return new SavedTransaction(i3, str, j3, z2, zC, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, SavedTransaction value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderB = encoder.b(serialDescriptor);
        SavedTransaction.write$Self$superwall_release(value, compositeEncoderB, serialDescriptor);
        compositeEncoderB.c(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
