package com.superwall.sdk.models.paywall;

import com.superwall.sdk.models.paywall.PaywallWebviewUrl;
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
import kotlinx.serialization.internal.IntSerializer;
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
public /* synthetic */ class PaywallWebviewUrl$Config$$serializer implements GeneratedSerializer<PaywallWebviewUrl.Config> {
    public static final PaywallWebviewUrl$Config$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        PaywallWebviewUrl$Config$$serializer paywallWebviewUrl$Config$$serializer = new PaywallWebviewUrl$Config$$serializer();
        INSTANCE = paywallWebviewUrl$Config$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.superwall.sdk.models.paywall.PaywallWebviewUrl.Config", paywallWebviewUrl$Config$$serializer, 2);
        pluginGeneratedSerialDescriptor.p("max_attempts", false);
        pluginGeneratedSerialDescriptor.p("endpoints", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private PaywallWebviewUrl$Config$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{IntSerializer.f142823a, PaywallWebviewUrl.Config.$childSerializers[1]};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final PaywallWebviewUrl.Config deserialize(Decoder decoder) {
        List list;
        int i3;
        int i4;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderB = decoder.b(serialDescriptor);
        KSerializer[] kSerializerArr = PaywallWebviewUrl.Config.$childSerializers;
        if (compositeDecoderB.p()) {
            i3 = compositeDecoderB.i(serialDescriptor, 0);
            list = (List) compositeDecoderB.y(serialDescriptor, 1, kSerializerArr[1], null);
            i4 = 3;
        } else {
            boolean z2 = true;
            int i5 = 0;
            int i6 = 0;
            List list2 = null;
            while (z2) {
                int iO = compositeDecoderB.o(serialDescriptor);
                if (iO == -1) {
                    z2 = false;
                } else if (iO == 0) {
                    i5 = compositeDecoderB.i(serialDescriptor, 0);
                    i6 |= 1;
                } else {
                    if (iO != 1) {
                        throw new UnknownFieldException(iO);
                    }
                    list2 = (List) compositeDecoderB.y(serialDescriptor, 1, kSerializerArr[1], list2);
                    i6 |= 2;
                }
            }
            list = list2;
            i3 = i5;
            i4 = i6;
        }
        compositeDecoderB.c(serialDescriptor);
        return new PaywallWebviewUrl.Config(i4, i3, list, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, PaywallWebviewUrl.Config value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderB = encoder.b(serialDescriptor);
        PaywallWebviewUrl.Config.write$Self$superwall_release(value, compositeEncoderB, serialDescriptor);
        compositeEncoderB.c(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
