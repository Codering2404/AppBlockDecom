package com.revenuecat.purchases.paywalls.components;

import com.revenuecat.purchases.paywalls.components.PaywallAnimation;
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
/* JADX INFO: loaded from: classes6.dex */
@Metadata
@Deprecated
public final class PaywallAnimation$$serializer implements GeneratedSerializer<PaywallAnimation> {
    public static final PaywallAnimation$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        PaywallAnimation$$serializer paywallAnimation$$serializer = new PaywallAnimation$$serializer();
        INSTANCE = paywallAnimation$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("animation", paywallAnimation$$serializer, 3);
        pluginGeneratedSerialDescriptor.p("type", false);
        pluginGeneratedSerialDescriptor.p("ms_delay", false);
        pluginGeneratedSerialDescriptor.p("ms_duration", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private PaywallAnimation$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        IntSerializer intSerializer = IntSerializer.f142823a;
        return new KSerializer[]{AnimationTypeSerializer.INSTANCE, intSerializer, intSerializer};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public PaywallAnimation deserialize(Decoder decoder) {
        int i3;
        int i4;
        int i5;
        PaywallAnimation.AnimationType animationType;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderB = decoder.b(descriptor2);
        if (compositeDecoderB.p()) {
            PaywallAnimation.AnimationType animationType2 = (PaywallAnimation.AnimationType) compositeDecoderB.y(descriptor2, 0, AnimationTypeSerializer.INSTANCE, null);
            int i6 = compositeDecoderB.i(descriptor2, 1);
            animationType = animationType2;
            i3 = compositeDecoderB.i(descriptor2, 2);
            i4 = i6;
            i5 = 7;
        } else {
            boolean z2 = true;
            int i7 = 0;
            int i8 = 0;
            PaywallAnimation.AnimationType animationType3 = null;
            int i9 = 0;
            while (z2) {
                int iO = compositeDecoderB.o(descriptor2);
                if (iO == -1) {
                    z2 = false;
                } else if (iO == 0) {
                    animationType3 = (PaywallAnimation.AnimationType) compositeDecoderB.y(descriptor2, 0, AnimationTypeSerializer.INSTANCE, animationType3);
                    i8 |= 1;
                } else if (iO == 1) {
                    i9 = compositeDecoderB.i(descriptor2, 1);
                    i8 |= 2;
                } else {
                    if (iO != 2) {
                        throw new UnknownFieldException(iO);
                    }
                    i7 = compositeDecoderB.i(descriptor2, 2);
                    i8 |= 4;
                }
            }
            i3 = i7;
            i4 = i9;
            i5 = i8;
            animationType = animationType3;
        }
        compositeDecoderB.c(descriptor2);
        return new PaywallAnimation(i5, animationType, i4, i3, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, PaywallAnimation value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderB = encoder.b(descriptor2);
        PaywallAnimation.write$Self$purchases_defaultsBc8Release(value, compositeEncoderB, descriptor2);
        compositeEncoderB.c(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
