package com.revenuecat.purchases.paywalls.components.common;

import com.revenuecat.purchases.paywalls.components.common.ComponentOverride;
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
public final class ComponentOverride$Condition$IntroOfferRule$$serializer implements GeneratedSerializer<ComponentOverride.Condition.IntroOfferRule> {
    public static final ComponentOverride$Condition$IntroOfferRule$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        ComponentOverride$Condition$IntroOfferRule$$serializer componentOverride$Condition$IntroOfferRule$$serializer = new ComponentOverride$Condition$IntroOfferRule$$serializer();
        INSTANCE = componentOverride$Condition$IntroOfferRule$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.paywalls.components.common.ComponentOverride.Condition.IntroOfferRule", componentOverride$Condition$IntroOfferRule$$serializer, 2);
        pluginGeneratedSerialDescriptor.p("operator", false);
        pluginGeneratedSerialDescriptor.p("value", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private ComponentOverride$Condition$IntroOfferRule$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{ComponentOverride.Condition.IntroOfferRule.$childSerializers[0], BooleanSerializer.f142767a};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public ComponentOverride.Condition.IntroOfferRule deserialize(Decoder decoder) {
        ComponentOverride.EqualityOperator equalityOperator;
        boolean zC;
        int i3;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderB = decoder.b(descriptor2);
        KSerializer[] kSerializerArr = ComponentOverride.Condition.IntroOfferRule.$childSerializers;
        if (compositeDecoderB.p()) {
            equalityOperator = (ComponentOverride.EqualityOperator) compositeDecoderB.y(descriptor2, 0, kSerializerArr[0], null);
            zC = compositeDecoderB.C(descriptor2, 1);
            i3 = 3;
        } else {
            boolean z2 = true;
            boolean zC2 = false;
            int i4 = 0;
            ComponentOverride.EqualityOperator equalityOperator2 = null;
            while (z2) {
                int iO = compositeDecoderB.o(descriptor2);
                if (iO == -1) {
                    z2 = false;
                } else if (iO == 0) {
                    equalityOperator2 = (ComponentOverride.EqualityOperator) compositeDecoderB.y(descriptor2, 0, kSerializerArr[0], equalityOperator2);
                    i4 |= 1;
                } else {
                    if (iO != 1) {
                        throw new UnknownFieldException(iO);
                    }
                    zC2 = compositeDecoderB.C(descriptor2, 1);
                    i4 |= 2;
                }
            }
            equalityOperator = equalityOperator2;
            zC = zC2;
            i3 = i4;
        }
        compositeDecoderB.c(descriptor2);
        return new ComponentOverride.Condition.IntroOfferRule(i3, equalityOperator, zC, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, ComponentOverride.Condition.IntroOfferRule value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderB = encoder.b(descriptor2);
        ComponentOverride.Condition.IntroOfferRule.write$Self$purchases_defaultsBc8Release(value, compositeEncoderB, descriptor2);
        compositeEncoderB.c(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
