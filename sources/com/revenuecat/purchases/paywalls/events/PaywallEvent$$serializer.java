package com.revenuecat.purchases.paywalls.events;

import com.revenuecat.purchases.paywalls.events.PaywallEvent;
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
public final class PaywallEvent$$serializer implements GeneratedSerializer<PaywallEvent> {
    public static final PaywallEvent$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        PaywallEvent$$serializer paywallEvent$$serializer = new PaywallEvent$$serializer();
        INSTANCE = paywallEvent$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.paywalls.events.PaywallEvent", paywallEvent$$serializer, 4);
        pluginGeneratedSerialDescriptor.p("creationData", false);
        pluginGeneratedSerialDescriptor.p("data", false);
        pluginGeneratedSerialDescriptor.p("type", false);
        pluginGeneratedSerialDescriptor.p("componentInteraction", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private PaywallEvent$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{PaywallEvent$CreationData$$serializer.INSTANCE, PaywallEventDataSerializer.INSTANCE, PaywallEvent.$childSerializers[2], BuiltinSerializersKt.u(PaywallComponentInteractionData$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public PaywallEvent deserialize(Decoder decoder) {
        int i3;
        PaywallEvent.CreationData creationData;
        PaywallEvent.Data data;
        PaywallEventType paywallEventType;
        PaywallComponentInteractionData paywallComponentInteractionData;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderB = decoder.b(descriptor2);
        KSerializer[] kSerializerArr = PaywallEvent.$childSerializers;
        PaywallEvent.CreationData creationData2 = null;
        if (compositeDecoderB.p()) {
            PaywallEvent.CreationData creationData3 = (PaywallEvent.CreationData) compositeDecoderB.y(descriptor2, 0, PaywallEvent$CreationData$$serializer.INSTANCE, null);
            PaywallEvent.Data data2 = (PaywallEvent.Data) compositeDecoderB.y(descriptor2, 1, PaywallEventDataSerializer.INSTANCE, null);
            paywallEventType = (PaywallEventType) compositeDecoderB.y(descriptor2, 2, kSerializerArr[2], null);
            creationData = creationData3;
            paywallComponentInteractionData = (PaywallComponentInteractionData) compositeDecoderB.n(descriptor2, 3, PaywallComponentInteractionData$$serializer.INSTANCE, null);
            i3 = 15;
            data = data2;
        } else {
            boolean z2 = true;
            int i4 = 0;
            PaywallEvent.Data data3 = null;
            PaywallEventType paywallEventType2 = null;
            PaywallComponentInteractionData paywallComponentInteractionData2 = null;
            while (z2) {
                int iO = compositeDecoderB.o(descriptor2);
                if (iO == -1) {
                    z2 = false;
                } else if (iO == 0) {
                    creationData2 = (PaywallEvent.CreationData) compositeDecoderB.y(descriptor2, 0, PaywallEvent$CreationData$$serializer.INSTANCE, creationData2);
                    i4 |= 1;
                } else if (iO == 1) {
                    data3 = (PaywallEvent.Data) compositeDecoderB.y(descriptor2, 1, PaywallEventDataSerializer.INSTANCE, data3);
                    i4 |= 2;
                } else if (iO == 2) {
                    paywallEventType2 = (PaywallEventType) compositeDecoderB.y(descriptor2, 2, kSerializerArr[2], paywallEventType2);
                    i4 |= 4;
                } else {
                    if (iO != 3) {
                        throw new UnknownFieldException(iO);
                    }
                    paywallComponentInteractionData2 = (PaywallComponentInteractionData) compositeDecoderB.n(descriptor2, 3, PaywallComponentInteractionData$$serializer.INSTANCE, paywallComponentInteractionData2);
                    i4 |= 8;
                }
            }
            i3 = i4;
            creationData = creationData2;
            data = data3;
            paywallEventType = paywallEventType2;
            paywallComponentInteractionData = paywallComponentInteractionData2;
        }
        compositeDecoderB.c(descriptor2);
        return new PaywallEvent(i3, creationData, data, paywallEventType, paywallComponentInteractionData, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, PaywallEvent value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderB = encoder.b(descriptor2);
        PaywallEvent.write$Self$purchases_defaultsBc8Release(value, compositeEncoderB, descriptor2);
        compositeEncoderB.c(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
