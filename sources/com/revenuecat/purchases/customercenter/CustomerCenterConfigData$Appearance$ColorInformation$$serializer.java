package com.revenuecat.purchases.customercenter;

import com.revenuecat.purchases.customercenter.CustomerCenterConfigData;
import com.revenuecat.purchases.paywalls.PaywallColor;
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
public final class CustomerCenterConfigData$Appearance$ColorInformation$$serializer implements GeneratedSerializer<CustomerCenterConfigData.Appearance.ColorInformation> {
    public static final CustomerCenterConfigData$Appearance$ColorInformation$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        CustomerCenterConfigData$Appearance$ColorInformation$$serializer customerCenterConfigData$Appearance$ColorInformation$$serializer = new CustomerCenterConfigData$Appearance$ColorInformation$$serializer();
        INSTANCE = customerCenterConfigData$Appearance$ColorInformation$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.customercenter.CustomerCenterConfigData.Appearance.ColorInformation", customerCenterConfigData$Appearance$ColorInformation$$serializer, 5);
        pluginGeneratedSerialDescriptor.p("accent_color", true);
        pluginGeneratedSerialDescriptor.p("text_color", true);
        pluginGeneratedSerialDescriptor.p("background_color", true);
        pluginGeneratedSerialDescriptor.p("button_text_color", true);
        pluginGeneratedSerialDescriptor.p("button_background_color", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private CustomerCenterConfigData$Appearance$ColorInformation$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        PaywallColor.Serializer serializer = PaywallColor.Serializer.INSTANCE;
        return new KSerializer[]{BuiltinSerializersKt.u(serializer), BuiltinSerializersKt.u(serializer), BuiltinSerializersKt.u(serializer), BuiltinSerializersKt.u(serializer), BuiltinSerializersKt.u(serializer)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public CustomerCenterConfigData.Appearance.ColorInformation deserialize(Decoder decoder) {
        int i3;
        PaywallColor paywallColor;
        PaywallColor paywallColor2;
        PaywallColor paywallColor3;
        PaywallColor paywallColor4;
        PaywallColor paywallColor5;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderB = decoder.b(descriptor2);
        PaywallColor paywallColor6 = null;
        if (compositeDecoderB.p()) {
            PaywallColor.Serializer serializer = PaywallColor.Serializer.INSTANCE;
            PaywallColor paywallColor7 = (PaywallColor) compositeDecoderB.n(descriptor2, 0, serializer, null);
            PaywallColor paywallColor8 = (PaywallColor) compositeDecoderB.n(descriptor2, 1, serializer, null);
            PaywallColor paywallColor9 = (PaywallColor) compositeDecoderB.n(descriptor2, 2, serializer, null);
            PaywallColor paywallColor10 = (PaywallColor) compositeDecoderB.n(descriptor2, 3, serializer, null);
            paywallColor5 = (PaywallColor) compositeDecoderB.n(descriptor2, 4, serializer, null);
            paywallColor4 = paywallColor10;
            i3 = 31;
            paywallColor3 = paywallColor9;
            paywallColor2 = paywallColor8;
            paywallColor = paywallColor7;
        } else {
            boolean z2 = true;
            int i4 = 0;
            PaywallColor paywallColor11 = null;
            PaywallColor paywallColor12 = null;
            PaywallColor paywallColor13 = null;
            PaywallColor paywallColor14 = null;
            while (z2) {
                int iO = compositeDecoderB.o(descriptor2);
                if (iO == -1) {
                    z2 = false;
                } else if (iO == 0) {
                    paywallColor6 = (PaywallColor) compositeDecoderB.n(descriptor2, 0, PaywallColor.Serializer.INSTANCE, paywallColor6);
                    i4 |= 1;
                } else if (iO == 1) {
                    paywallColor11 = (PaywallColor) compositeDecoderB.n(descriptor2, 1, PaywallColor.Serializer.INSTANCE, paywallColor11);
                    i4 |= 2;
                } else if (iO == 2) {
                    paywallColor12 = (PaywallColor) compositeDecoderB.n(descriptor2, 2, PaywallColor.Serializer.INSTANCE, paywallColor12);
                    i4 |= 4;
                } else if (iO == 3) {
                    paywallColor13 = (PaywallColor) compositeDecoderB.n(descriptor2, 3, PaywallColor.Serializer.INSTANCE, paywallColor13);
                    i4 |= 8;
                } else {
                    if (iO != 4) {
                        throw new UnknownFieldException(iO);
                    }
                    paywallColor14 = (PaywallColor) compositeDecoderB.n(descriptor2, 4, PaywallColor.Serializer.INSTANCE, paywallColor14);
                    i4 |= 16;
                }
            }
            i3 = i4;
            paywallColor = paywallColor6;
            paywallColor2 = paywallColor11;
            paywallColor3 = paywallColor12;
            paywallColor4 = paywallColor13;
            paywallColor5 = paywallColor14;
        }
        compositeDecoderB.c(descriptor2);
        return new CustomerCenterConfigData.Appearance.ColorInformation(i3, paywallColor, paywallColor2, paywallColor3, paywallColor4, paywallColor5, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, CustomerCenterConfigData.Appearance.ColorInformation value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderB = encoder.b(descriptor2);
        CustomerCenterConfigData.Appearance.ColorInformation.write$Self$purchases_defaultsBc8Release(value, compositeEncoderB, descriptor2);
        compositeEncoderB.c(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
