package com.revenuecat.purchases.paywalls;

import com.revenuecat.purchases.paywalls.PaywallData;
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
public final class PaywallData$Configuration$ColorInformation$$serializer implements GeneratedSerializer<PaywallData.Configuration.ColorInformation> {
    public static final PaywallData$Configuration$ColorInformation$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        PaywallData$Configuration$ColorInformation$$serializer paywallData$Configuration$ColorInformation$$serializer = new PaywallData$Configuration$ColorInformation$$serializer();
        INSTANCE = paywallData$Configuration$ColorInformation$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.paywalls.PaywallData.Configuration.ColorInformation", paywallData$Configuration$ColorInformation$$serializer, 2);
        pluginGeneratedSerialDescriptor.p("light", false);
        pluginGeneratedSerialDescriptor.p("dark", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private PaywallData$Configuration$ColorInformation$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        PaywallData$Configuration$Colors$$serializer paywallData$Configuration$Colors$$serializer = PaywallData$Configuration$Colors$$serializer.INSTANCE;
        return new KSerializer[]{paywallData$Configuration$Colors$$serializer, BuiltinSerializersKt.u(paywallData$Configuration$Colors$$serializer)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public PaywallData.Configuration.ColorInformation deserialize(Decoder decoder) {
        PaywallData.Configuration.Colors colors;
        int i3;
        PaywallData.Configuration.Colors colors2;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderB = decoder.b(descriptor2);
        if (compositeDecoderB.p()) {
            PaywallData$Configuration$Colors$$serializer paywallData$Configuration$Colors$$serializer = PaywallData$Configuration$Colors$$serializer.INSTANCE;
            colors2 = (PaywallData.Configuration.Colors) compositeDecoderB.y(descriptor2, 0, paywallData$Configuration$Colors$$serializer, null);
            colors = (PaywallData.Configuration.Colors) compositeDecoderB.n(descriptor2, 1, paywallData$Configuration$Colors$$serializer, null);
            i3 = 3;
        } else {
            boolean z2 = true;
            int i4 = 0;
            colors = null;
            PaywallData.Configuration.Colors colors3 = null;
            while (z2) {
                int iO = compositeDecoderB.o(descriptor2);
                if (iO == -1) {
                    z2 = false;
                } else if (iO == 0) {
                    colors3 = (PaywallData.Configuration.Colors) compositeDecoderB.y(descriptor2, 0, PaywallData$Configuration$Colors$$serializer.INSTANCE, colors3);
                    i4 |= 1;
                } else {
                    if (iO != 1) {
                        throw new UnknownFieldException(iO);
                    }
                    colors = (PaywallData.Configuration.Colors) compositeDecoderB.n(descriptor2, 1, PaywallData$Configuration$Colors$$serializer.INSTANCE, colors);
                    i4 |= 2;
                }
            }
            i3 = i4;
            colors2 = colors3;
        }
        compositeDecoderB.c(descriptor2);
        return new PaywallData.Configuration.ColorInformation(i3, colors2, colors, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, PaywallData.Configuration.ColorInformation value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderB = encoder.b(descriptor2);
        PaywallData.Configuration.ColorInformation.write$Self$purchases_defaultsBc8Release(value, compositeEncoderB, descriptor2);
        compositeEncoderB.c(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
