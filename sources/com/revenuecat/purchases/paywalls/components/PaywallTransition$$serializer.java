package com.revenuecat.purchases.paywalls.components;

import com.revenuecat.purchases.paywalls.components.PaywallTransition;
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
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;

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
public final class PaywallTransition$$serializer implements GeneratedSerializer<PaywallTransition> {
    public static final PaywallTransition$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        PaywallTransition$$serializer paywallTransition$$serializer = new PaywallTransition$$serializer();
        INSTANCE = paywallTransition$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.paywalls.components.PaywallTransition", paywallTransition$$serializer, 3);
        pluginGeneratedSerialDescriptor.p("type", true);
        pluginGeneratedSerialDescriptor.p("displacement_strategy", false);
        pluginGeneratedSerialDescriptor.p("animation", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private PaywallTransition$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{TransitionTypeSerializer.INSTANCE, DisplacementStrategyDeserializer.INSTANCE, BuiltinSerializersKt.u(PaywallAnimation$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public PaywallTransition deserialize(Decoder decoder) {
        int i3;
        PaywallTransition.TransitionType transitionType;
        PaywallTransition.DisplacementStrategy displacementStrategy;
        PaywallAnimation paywallAnimation;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderB = decoder.b(descriptor2);
        PaywallTransition.TransitionType transitionType2 = null;
        if (compositeDecoderB.p()) {
            PaywallTransition.TransitionType transitionType3 = (PaywallTransition.TransitionType) compositeDecoderB.y(descriptor2, 0, TransitionTypeSerializer.INSTANCE, null);
            PaywallTransition.DisplacementStrategy displacementStrategy2 = (PaywallTransition.DisplacementStrategy) compositeDecoderB.y(descriptor2, 1, DisplacementStrategyDeserializer.INSTANCE, null);
            transitionType = transitionType3;
            paywallAnimation = (PaywallAnimation) compositeDecoderB.n(descriptor2, 2, PaywallAnimation$$serializer.INSTANCE, null);
            displacementStrategy = displacementStrategy2;
            i3 = 7;
        } else {
            boolean z2 = true;
            int i4 = 0;
            PaywallTransition.DisplacementStrategy displacementStrategy3 = null;
            PaywallAnimation paywallAnimation2 = null;
            while (z2) {
                int iO = compositeDecoderB.o(descriptor2);
                if (iO == -1) {
                    z2 = false;
                } else if (iO == 0) {
                    transitionType2 = (PaywallTransition.TransitionType) compositeDecoderB.y(descriptor2, 0, TransitionTypeSerializer.INSTANCE, transitionType2);
                    i4 |= 1;
                } else if (iO == 1) {
                    displacementStrategy3 = (PaywallTransition.DisplacementStrategy) compositeDecoderB.y(descriptor2, 1, DisplacementStrategyDeserializer.INSTANCE, displacementStrategy3);
                    i4 |= 2;
                } else {
                    if (iO != 2) {
                        throw new UnknownFieldException(iO);
                    }
                    paywallAnimation2 = (PaywallAnimation) compositeDecoderB.n(descriptor2, 2, PaywallAnimation$$serializer.INSTANCE, paywallAnimation2);
                    i4 |= 4;
                }
            }
            i3 = i4;
            transitionType = transitionType2;
            displacementStrategy = displacementStrategy3;
            paywallAnimation = paywallAnimation2;
        }
        compositeDecoderB.c(descriptor2);
        return new PaywallTransition(i3, transitionType, displacementStrategy, paywallAnimation, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, PaywallTransition value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderB = encoder.b(descriptor2);
        PaywallTransition.write$Self$purchases_defaultsBc8Release(value, compositeEncoderB, descriptor2);
        compositeEncoderB.c(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
