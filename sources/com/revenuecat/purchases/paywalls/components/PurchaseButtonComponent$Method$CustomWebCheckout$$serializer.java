package com.revenuecat.purchases.paywalls.components;

import com.revenuecat.purchases.paywalls.components.ButtonComponent;
import com.revenuecat.purchases.paywalls.components.PurchaseButtonComponent;
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
import kotlinx.serialization.internal.BooleanSerializer;
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
public final class PurchaseButtonComponent$Method$CustomWebCheckout$$serializer implements GeneratedSerializer<PurchaseButtonComponent.Method.CustomWebCheckout> {
    public static final PurchaseButtonComponent$Method$CustomWebCheckout$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        PurchaseButtonComponent$Method$CustomWebCheckout$$serializer purchaseButtonComponent$Method$CustomWebCheckout$$serializer = new PurchaseButtonComponent$Method$CustomWebCheckout$$serializer();
        INSTANCE = purchaseButtonComponent$Method$CustomWebCheckout$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.paywalls.components.PurchaseButtonComponent.Method.CustomWebCheckout", purchaseButtonComponent$Method$CustomWebCheckout$$serializer, 3);
        pluginGeneratedSerialDescriptor.p("custom_url", false);
        pluginGeneratedSerialDescriptor.p("auto_dismiss", true);
        pluginGeneratedSerialDescriptor.p("open_method", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private PurchaseButtonComponent$Method$CustomWebCheckout$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{PurchaseButtonComponent$CustomUrl$$serializer.INSTANCE, BuiltinSerializersKt.u(BooleanSerializer.f142767a), BuiltinSerializersKt.u(UrlMethodDeserializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public PurchaseButtonComponent.Method.CustomWebCheckout deserialize(Decoder decoder) {
        int i3;
        PurchaseButtonComponent.CustomUrl customUrl;
        Boolean bool;
        ButtonComponent.UrlMethod urlMethod;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderB = decoder.b(descriptor2);
        PurchaseButtonComponent.CustomUrl customUrl2 = null;
        if (compositeDecoderB.p()) {
            PurchaseButtonComponent.CustomUrl customUrl3 = (PurchaseButtonComponent.CustomUrl) compositeDecoderB.y(descriptor2, 0, PurchaseButtonComponent$CustomUrl$$serializer.INSTANCE, null);
            Boolean bool2 = (Boolean) compositeDecoderB.n(descriptor2, 1, BooleanSerializer.f142767a, null);
            customUrl = customUrl3;
            urlMethod = (ButtonComponent.UrlMethod) compositeDecoderB.n(descriptor2, 2, UrlMethodDeserializer.INSTANCE, null);
            bool = bool2;
            i3 = 7;
        } else {
            boolean z2 = true;
            int i4 = 0;
            Boolean bool3 = null;
            ButtonComponent.UrlMethod urlMethod2 = null;
            while (z2) {
                int iO = compositeDecoderB.o(descriptor2);
                if (iO == -1) {
                    z2 = false;
                } else if (iO == 0) {
                    customUrl2 = (PurchaseButtonComponent.CustomUrl) compositeDecoderB.y(descriptor2, 0, PurchaseButtonComponent$CustomUrl$$serializer.INSTANCE, customUrl2);
                    i4 |= 1;
                } else if (iO == 1) {
                    bool3 = (Boolean) compositeDecoderB.n(descriptor2, 1, BooleanSerializer.f142767a, bool3);
                    i4 |= 2;
                } else {
                    if (iO != 2) {
                        throw new UnknownFieldException(iO);
                    }
                    urlMethod2 = (ButtonComponent.UrlMethod) compositeDecoderB.n(descriptor2, 2, UrlMethodDeserializer.INSTANCE, urlMethod2);
                    i4 |= 4;
                }
            }
            i3 = i4;
            customUrl = customUrl2;
            bool = bool3;
            urlMethod = urlMethod2;
        }
        compositeDecoderB.c(descriptor2);
        return new PurchaseButtonComponent.Method.CustomWebCheckout(i3, customUrl, bool, urlMethod, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, PurchaseButtonComponent.Method.CustomWebCheckout value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderB = encoder.b(descriptor2);
        PurchaseButtonComponent.Method.CustomWebCheckout.write$Self$purchases_defaultsBc8Release(value, compositeEncoderB, descriptor2);
        compositeEncoderB.c(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
