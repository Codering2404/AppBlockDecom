package com.google.firebase.sessions;

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
/* JADX INFO: loaded from: classes6.dex */
@Metadata
@Deprecated
public /* synthetic */ class SessionDetails$$serializer implements GeneratedSerializer<SessionDetails> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SessionDetails$$serializer f90022a;
    private static final SerialDescriptor descriptor;

    static {
        SessionDetails$$serializer sessionDetails$$serializer = new SessionDetails$$serializer();
        f90022a = sessionDetails$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.google.firebase.sessions.SessionDetails", sessionDetails$$serializer, 4);
        pluginGeneratedSerialDescriptor.p("sessionId", false);
        pluginGeneratedSerialDescriptor.p("firstSessionId", false);
        pluginGeneratedSerialDescriptor.p("sessionIndex", false);
        pluginGeneratedSerialDescriptor.p("sessionStartTimestampUs", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private SessionDetails$$serializer() {
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final SessionDetails deserialize(Decoder decoder) {
        String strM;
        int i3;
        int i4;
        String str;
        long jF;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderB = decoder.b(serialDescriptor);
        if (compositeDecoderB.p()) {
            strM = compositeDecoderB.m(serialDescriptor, 0);
            String strM2 = compositeDecoderB.m(serialDescriptor, 1);
            i3 = 15;
            i4 = compositeDecoderB.i(serialDescriptor, 2);
            str = strM2;
            jF = compositeDecoderB.f(serialDescriptor, 3);
        } else {
            strM = null;
            String strM3 = null;
            boolean z2 = true;
            long jF2 = 0;
            int i5 = 0;
            int i6 = 0;
            while (z2) {
                int iO = compositeDecoderB.o(serialDescriptor);
                if (iO == -1) {
                    z2 = false;
                } else if (iO == 0) {
                    strM = compositeDecoderB.m(serialDescriptor, 0);
                    i5 |= 1;
                } else if (iO == 1) {
                    strM3 = compositeDecoderB.m(serialDescriptor, 1);
                    i5 |= 2;
                } else if (iO == 2) {
                    i6 = compositeDecoderB.i(serialDescriptor, 2);
                    i5 |= 4;
                } else {
                    if (iO != 3) {
                        throw new UnknownFieldException(iO);
                    }
                    jF2 = compositeDecoderB.f(serialDescriptor, 3);
                    i5 |= 8;
                }
            }
            i3 = i5;
            i4 = i6;
            str = strM3;
            jF = jF2;
        }
        String str2 = strM;
        compositeDecoderB.c(serialDescriptor);
        return new SessionDetails(i3, str2, str, i4, jF, null);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final void serialize(Encoder encoder, SessionDetails value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderB = encoder.b(serialDescriptor);
        SessionDetails.e(value, compositeEncoderB, serialDescriptor);
        compositeEncoderB.c(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        StringSerializer stringSerializer = StringSerializer.f142891a;
        return new KSerializer[]{stringSerializer, stringSerializer, IntSerializer.f142823a, LongSerializer.f142836a};
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
