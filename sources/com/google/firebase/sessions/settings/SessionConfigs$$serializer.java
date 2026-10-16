package com.google.firebase.sessions.settings;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.DoubleSerializer;
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
/* JADX INFO: loaded from: classes6.dex */
@Metadata
@Deprecated
public /* synthetic */ class SessionConfigs$$serializer implements GeneratedSerializer<SessionConfigs> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SessionConfigs$$serializer f90199a;
    private static final SerialDescriptor descriptor;

    static {
        SessionConfigs$$serializer sessionConfigs$$serializer = new SessionConfigs$$serializer();
        f90199a = sessionConfigs$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.google.firebase.sessions.settings.SessionConfigs", sessionConfigs$$serializer, 5);
        pluginGeneratedSerialDescriptor.p("sessionsEnabled", false);
        pluginGeneratedSerialDescriptor.p("sessionSamplingRate", false);
        pluginGeneratedSerialDescriptor.p("sessionTimeoutSeconds", false);
        pluginGeneratedSerialDescriptor.p("cacheDurationSeconds", false);
        pluginGeneratedSerialDescriptor.p("cacheUpdatedTimeSeconds", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private SessionConfigs$$serializer() {
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final SessionConfigs deserialize(Decoder decoder) {
        int i3;
        Boolean bool;
        Double d3;
        Integer num;
        Integer num2;
        Long l3;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderB = decoder.b(serialDescriptor);
        Boolean bool2 = null;
        if (compositeDecoderB.p()) {
            Boolean bool3 = (Boolean) compositeDecoderB.n(serialDescriptor, 0, BooleanSerializer.f142767a, null);
            Double d4 = (Double) compositeDecoderB.n(serialDescriptor, 1, DoubleSerializer.f142796a, null);
            IntSerializer intSerializer = IntSerializer.f142823a;
            Integer num3 = (Integer) compositeDecoderB.n(serialDescriptor, 2, intSerializer, null);
            bool = bool3;
            num2 = (Integer) compositeDecoderB.n(serialDescriptor, 3, intSerializer, null);
            l3 = (Long) compositeDecoderB.n(serialDescriptor, 4, LongSerializer.f142836a, null);
            num = num3;
            d3 = d4;
            i3 = 31;
        } else {
            boolean z2 = true;
            int i4 = 0;
            Double d5 = null;
            Integer num4 = null;
            Integer num5 = null;
            Long l4 = null;
            while (z2) {
                int iO = compositeDecoderB.o(serialDescriptor);
                if (iO == -1) {
                    z2 = false;
                } else if (iO == 0) {
                    bool2 = (Boolean) compositeDecoderB.n(serialDescriptor, 0, BooleanSerializer.f142767a, bool2);
                    i4 |= 1;
                } else if (iO == 1) {
                    d5 = (Double) compositeDecoderB.n(serialDescriptor, 1, DoubleSerializer.f142796a, d5);
                    i4 |= 2;
                } else if (iO == 2) {
                    num4 = (Integer) compositeDecoderB.n(serialDescriptor, 2, IntSerializer.f142823a, num4);
                    i4 |= 4;
                } else if (iO == 3) {
                    num5 = (Integer) compositeDecoderB.n(serialDescriptor, 3, IntSerializer.f142823a, num5);
                    i4 |= 8;
                } else {
                    if (iO != 4) {
                        throw new UnknownFieldException(iO);
                    }
                    l4 = (Long) compositeDecoderB.n(serialDescriptor, 4, LongSerializer.f142836a, l4);
                    i4 |= 16;
                }
            }
            i3 = i4;
            bool = bool2;
            d3 = d5;
            num = num4;
            num2 = num5;
            l3 = l4;
        }
        compositeDecoderB.c(serialDescriptor);
        return new SessionConfigs(i3, bool, d3, num, num2, l3, null);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final void serialize(Encoder encoder, SessionConfigs value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderB = encoder.b(serialDescriptor);
        SessionConfigs.f(value, compositeEncoderB, serialDescriptor);
        compositeEncoderB.c(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        KSerializer kSerializerU = BuiltinSerializersKt.u(BooleanSerializer.f142767a);
        KSerializer kSerializerU2 = BuiltinSerializersKt.u(DoubleSerializer.f142796a);
        IntSerializer intSerializer = IntSerializer.f142823a;
        return new KSerializer[]{kSerializerU, kSerializerU2, BuiltinSerializersKt.u(intSerializer), BuiltinSerializersKt.u(intSerializer), BuiltinSerializersKt.u(LongSerializer.f142836a)};
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
