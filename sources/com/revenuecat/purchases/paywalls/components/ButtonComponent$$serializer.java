package com.revenuecat.purchases.paywalls.components;

import com.revenuecat.purchases.paywalls.components.ButtonComponent;
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
public final class ButtonComponent$$serializer implements GeneratedSerializer<ButtonComponent> {
    public static final ButtonComponent$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        ButtonComponent$$serializer buttonComponent$$serializer = new ButtonComponent$$serializer();
        INSTANCE = buttonComponent$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("button", buttonComponent$$serializer, 5);
        pluginGeneratedSerialDescriptor.p("action", false);
        pluginGeneratedSerialDescriptor.p("stack", false);
        pluginGeneratedSerialDescriptor.p("transition", true);
        pluginGeneratedSerialDescriptor.p("name", true);
        pluginGeneratedSerialDescriptor.p("id", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private ButtonComponent$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        KSerializer<?> kSerializerU = BuiltinSerializersKt.u(PaywallTransition$$serializer.INSTANCE);
        StringSerializer stringSerializer = StringSerializer.f142891a;
        return new KSerializer[]{ActionSerializer.INSTANCE, StackComponent$$serializer.INSTANCE, kSerializerU, BuiltinSerializersKt.u(stringSerializer), BuiltinSerializersKt.u(stringSerializer)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public ButtonComponent deserialize(Decoder decoder) {
        int i3;
        ButtonComponent.Action action;
        StackComponent stackComponent;
        PaywallTransition paywallTransition;
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderB = decoder.b(descriptor2);
        ButtonComponent.Action action2 = null;
        if (compositeDecoderB.p()) {
            ButtonComponent.Action action3 = (ButtonComponent.Action) compositeDecoderB.y(descriptor2, 0, ActionSerializer.INSTANCE, null);
            StackComponent stackComponent2 = (StackComponent) compositeDecoderB.y(descriptor2, 1, StackComponent$$serializer.INSTANCE, null);
            PaywallTransition paywallTransition2 = (PaywallTransition) compositeDecoderB.n(descriptor2, 2, PaywallTransition$$serializer.INSTANCE, null);
            StringSerializer stringSerializer = StringSerializer.f142891a;
            action = action3;
            str = (String) compositeDecoderB.n(descriptor2, 3, stringSerializer, null);
            str2 = (String) compositeDecoderB.n(descriptor2, 4, stringSerializer, null);
            paywallTransition = paywallTransition2;
            stackComponent = stackComponent2;
            i3 = 31;
        } else {
            boolean z2 = true;
            int i4 = 0;
            StackComponent stackComponent3 = null;
            PaywallTransition paywallTransition3 = null;
            String str3 = null;
            String str4 = null;
            while (z2) {
                int iO = compositeDecoderB.o(descriptor2);
                if (iO == -1) {
                    z2 = false;
                } else if (iO == 0) {
                    action2 = (ButtonComponent.Action) compositeDecoderB.y(descriptor2, 0, ActionSerializer.INSTANCE, action2);
                    i4 |= 1;
                } else if (iO == 1) {
                    stackComponent3 = (StackComponent) compositeDecoderB.y(descriptor2, 1, StackComponent$$serializer.INSTANCE, stackComponent3);
                    i4 |= 2;
                } else if (iO == 2) {
                    paywallTransition3 = (PaywallTransition) compositeDecoderB.n(descriptor2, 2, PaywallTransition$$serializer.INSTANCE, paywallTransition3);
                    i4 |= 4;
                } else if (iO == 3) {
                    str3 = (String) compositeDecoderB.n(descriptor2, 3, StringSerializer.f142891a, str3);
                    i4 |= 8;
                } else {
                    if (iO != 4) {
                        throw new UnknownFieldException(iO);
                    }
                    str4 = (String) compositeDecoderB.n(descriptor2, 4, StringSerializer.f142891a, str4);
                    i4 |= 16;
                }
            }
            i3 = i4;
            action = action2;
            stackComponent = stackComponent3;
            paywallTransition = paywallTransition3;
            str = str3;
            str2 = str4;
        }
        compositeDecoderB.c(descriptor2);
        return new ButtonComponent(i3, action, stackComponent, paywallTransition, str, str2, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, ButtonComponent value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderB = encoder.b(descriptor2);
        ButtonComponent.write$Self$purchases_defaultsBc8Release(value, compositeEncoderB, descriptor2);
        compositeEncoderB.c(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
