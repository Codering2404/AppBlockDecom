package com.revenuecat.purchases.paywalls.components;

import com.facebook.share.internal.ShareConstants;
import com.revenuecat.purchases.paywalls.components.ButtonComponent;
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
public final class ButtonComponent$Action$NavigateTo$$serializer implements GeneratedSerializer<ButtonComponent.Action.NavigateTo> {
    public static final ButtonComponent$Action$NavigateTo$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        ButtonComponent$Action$NavigateTo$$serializer buttonComponent$Action$NavigateTo$$serializer = new ButtonComponent$Action$NavigateTo$$serializer();
        INSTANCE = buttonComponent$Action$NavigateTo$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.paywalls.components.ButtonComponent.Action.NavigateTo", buttonComponent$Action$NavigateTo$$serializer, 1);
        pluginGeneratedSerialDescriptor.p(ShareConstants.DESTINATION, false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private ButtonComponent$Action$NavigateTo$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{ButtonComponent.Action.NavigateTo.$childSerializers[0]};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public ButtonComponent.Action.NavigateTo deserialize(Decoder decoder) {
        ButtonComponent.Destination destination;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderB = decoder.b(descriptor2);
        KSerializer[] kSerializerArr = ButtonComponent.Action.NavigateTo.$childSerializers;
        int i3 = 1;
        if (compositeDecoderB.p()) {
            destination = (ButtonComponent.Destination) compositeDecoderB.y(descriptor2, 0, kSerializerArr[0], null);
        } else {
            boolean z2 = true;
            int i4 = 0;
            ButtonComponent.Destination destination2 = null;
            while (z2) {
                int iO = compositeDecoderB.o(descriptor2);
                if (iO == -1) {
                    z2 = false;
                } else {
                    if (iO != 0) {
                        throw new UnknownFieldException(iO);
                    }
                    destination2 = (ButtonComponent.Destination) compositeDecoderB.y(descriptor2, 0, kSerializerArr[0], destination2);
                    i4 = 1;
                }
            }
            destination = destination2;
            i3 = i4;
        }
        compositeDecoderB.c(descriptor2);
        return new ButtonComponent.Action.NavigateTo(i3, destination, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, ButtonComponent.Action.NavigateTo value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderB = encoder.b(descriptor2);
        compositeEncoderB.C(descriptor2, 0, ButtonComponent.Action.NavigateTo.$childSerializers[0], value.destination);
        compositeEncoderB.c(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
