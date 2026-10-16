package com.revenuecat.purchases.paywalls.components;

import com.facebook.GraphRequest;
import com.revenuecat.purchases.paywalls.components.PurchaseButtonComponent;
import com.revenuecat.purchases.ui.revenuecatui.helpers.PaywallLegacyComponentInteraction;
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
public final class PurchaseButtonComponent$$serializer implements GeneratedSerializer<PurchaseButtonComponent> {
    public static final PurchaseButtonComponent$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        PurchaseButtonComponent$$serializer purchaseButtonComponent$$serializer = new PurchaseButtonComponent$$serializer();
        INSTANCE = purchaseButtonComponent$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor(PaywallLegacyComponentInteraction.PURCHASE_BUTTON_NAME, purchaseButtonComponent$$serializer, 4);
        pluginGeneratedSerialDescriptor.p("stack", false);
        pluginGeneratedSerialDescriptor.p("action", true);
        pluginGeneratedSerialDescriptor.p(GraphRequest.BATCH_METHOD_PARAM, true);
        pluginGeneratedSerialDescriptor.p("name", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private PurchaseButtonComponent$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{StackComponent$$serializer.INSTANCE, BuiltinSerializersKt.u(ActionDeserializer.INSTANCE), BuiltinSerializersKt.u(PurchaseButtonMethodDeserializer.INSTANCE), BuiltinSerializersKt.u(StringSerializer.f142891a)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public PurchaseButtonComponent deserialize(Decoder decoder) {
        int i3;
        StackComponent stackComponent;
        PurchaseButtonComponent.Action action;
        PurchaseButtonComponent.Method method;
        String str;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderB = decoder.b(descriptor2);
        StackComponent stackComponent2 = null;
        if (compositeDecoderB.p()) {
            StackComponent stackComponent3 = (StackComponent) compositeDecoderB.y(descriptor2, 0, StackComponent$$serializer.INSTANCE, null);
            PurchaseButtonComponent.Action action2 = (PurchaseButtonComponent.Action) compositeDecoderB.n(descriptor2, 1, ActionDeserializer.INSTANCE, null);
            PurchaseButtonComponent.Method method2 = (PurchaseButtonComponent.Method) compositeDecoderB.n(descriptor2, 2, PurchaseButtonMethodDeserializer.INSTANCE, null);
            stackComponent = stackComponent3;
            str = (String) compositeDecoderB.n(descriptor2, 3, StringSerializer.f142891a, null);
            method = method2;
            action = action2;
            i3 = 15;
        } else {
            boolean z2 = true;
            int i4 = 0;
            PurchaseButtonComponent.Action action3 = null;
            PurchaseButtonComponent.Method method3 = null;
            String str2 = null;
            while (z2) {
                int iO = compositeDecoderB.o(descriptor2);
                if (iO == -1) {
                    z2 = false;
                } else if (iO == 0) {
                    stackComponent2 = (StackComponent) compositeDecoderB.y(descriptor2, 0, StackComponent$$serializer.INSTANCE, stackComponent2);
                    i4 |= 1;
                } else if (iO == 1) {
                    action3 = (PurchaseButtonComponent.Action) compositeDecoderB.n(descriptor2, 1, ActionDeserializer.INSTANCE, action3);
                    i4 |= 2;
                } else if (iO == 2) {
                    method3 = (PurchaseButtonComponent.Method) compositeDecoderB.n(descriptor2, 2, PurchaseButtonMethodDeserializer.INSTANCE, method3);
                    i4 |= 4;
                } else {
                    if (iO != 3) {
                        throw new UnknownFieldException(iO);
                    }
                    str2 = (String) compositeDecoderB.n(descriptor2, 3, StringSerializer.f142891a, str2);
                    i4 |= 8;
                }
            }
            i3 = i4;
            stackComponent = stackComponent2;
            action = action3;
            method = method3;
            str = str2;
        }
        compositeDecoderB.c(descriptor2);
        return new PurchaseButtonComponent(i3, stackComponent, action, method, str, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, PurchaseButtonComponent value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderB = encoder.b(descriptor2);
        PurchaseButtonComponent.write$Self$purchases_defaultsBc8Release(value, compositeEncoderB, descriptor2);
        compositeEncoderB.c(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
