package com.superwall.sdk.models.paywall;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@Deprecated
public /* synthetic */ class PaywallWebviewUrl$$serializer implements GeneratedSerializer<PaywallWebviewUrl> {
    public static final PaywallWebviewUrl$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        PaywallWebviewUrl$$serializer paywallWebviewUrl$$serializer = new PaywallWebviewUrl$$serializer();
        INSTANCE = paywallWebviewUrl$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.superwall.sdk.models.paywall.PaywallWebviewUrl", paywallWebviewUrl$$serializer, 3);
        pluginGeneratedSerialDescriptor.p("url", false);
        pluginGeneratedSerialDescriptor.p("timeout_ms", false);
        pluginGeneratedSerialDescriptor.p("percentage", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private PaywallWebviewUrl$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{StringSerializer.f142891a, LongSerializer.f142836a, IntSerializer.f142823a};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final PaywallWebviewUrl deserialize(Decoder decoder) {
        String strM;
        int i3;
        long j3;
        int i4;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderB = decoder.b(serialDescriptor);
        if (compositeDecoderB.p()) {
            strM = compositeDecoderB.m(serialDescriptor, 0);
            long jF = compositeDecoderB.f(serialDescriptor, 1);
            i3 = compositeDecoderB.i(serialDescriptor, 2);
            j3 = jF;
            i4 = 7;
        } else {
            strM = null;
            boolean z2 = true;
            int i5 = 0;
            long jF2 = 0;
            int i6 = 0;
            while (z2) {
                int iO = compositeDecoderB.o(serialDescriptor);
                if (iO == -1) {
                    z2 = false;
                } else if (iO == 0) {
                    strM = compositeDecoderB.m(serialDescriptor, 0);
                    i5 |= 1;
                } else if (iO == 1) {
                    jF2 = compositeDecoderB.f(serialDescriptor, 1);
                    i5 |= 2;
                } else {
                    if (iO != 2) {
                        throw new UnknownFieldException(iO);
                    }
                    i6 = compositeDecoderB.i(serialDescriptor, 2);
                    i5 |= 4;
                }
            }
            i3 = i6;
            j3 = jF2;
            i4 = i5;
        }
        String str = strM;
        compositeDecoderB.c(serialDescriptor);
        return new PaywallWebviewUrl(i4, str, j3, i3, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, PaywallWebviewUrl value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderB = encoder.b(serialDescriptor);
        PaywallWebviewUrl.write$Self$superwall_release(value, compositeEncoderB, serialDescriptor);
        compositeEncoderB.c(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
