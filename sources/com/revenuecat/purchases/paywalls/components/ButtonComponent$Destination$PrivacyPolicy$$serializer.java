package com.revenuecat.purchases.paywalls.components;

import com.facebook.GraphRequest;
import com.revenuecat.purchases.paywalls.components.ButtonComponent;
import com.revenuecat.purchases.paywalls.components.common.LocalizationKey;
import com.revenuecat.purchases.paywalls.components.common.LocalizationKey$$serializer;
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
public final class ButtonComponent$Destination$PrivacyPolicy$$serializer implements GeneratedSerializer<ButtonComponent.Destination.PrivacyPolicy> {
    public static final ButtonComponent$Destination$PrivacyPolicy$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        ButtonComponent$Destination$PrivacyPolicy$$serializer buttonComponent$Destination$PrivacyPolicy$$serializer = new ButtonComponent$Destination$PrivacyPolicy$$serializer();
        INSTANCE = buttonComponent$Destination$PrivacyPolicy$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.paywalls.components.ButtonComponent.Destination.PrivacyPolicy", buttonComponent$Destination$PrivacyPolicy$$serializer, 2);
        pluginGeneratedSerialDescriptor.p("urlLid", false);
        pluginGeneratedSerialDescriptor.p(GraphRequest.BATCH_METHOD_PARAM, false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private ButtonComponent$Destination$PrivacyPolicy$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{LocalizationKey$$serializer.INSTANCE, UrlMethodDeserializer.INSTANCE};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public ButtonComponent.Destination.PrivacyPolicy deserialize(Decoder decoder) {
        String strM654unboximpl;
        ButtonComponent.UrlMethod urlMethod;
        int i3;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderB = decoder.b(descriptor2);
        if (compositeDecoderB.p()) {
            LocalizationKey localizationKey = (LocalizationKey) compositeDecoderB.y(descriptor2, 0, LocalizationKey$$serializer.INSTANCE, null);
            strM654unboximpl = localizationKey != null ? localizationKey.m654unboximpl() : null;
            urlMethod = (ButtonComponent.UrlMethod) compositeDecoderB.y(descriptor2, 1, UrlMethodDeserializer.INSTANCE, null);
            i3 = 3;
        } else {
            boolean z2 = true;
            int i4 = 0;
            strM654unboximpl = null;
            ButtonComponent.UrlMethod urlMethod2 = null;
            while (z2) {
                int iO = compositeDecoderB.o(descriptor2);
                if (iO == -1) {
                    z2 = false;
                } else if (iO == 0) {
                    LocalizationKey localizationKey2 = (LocalizationKey) compositeDecoderB.y(descriptor2, 0, LocalizationKey$$serializer.INSTANCE, strM654unboximpl != null ? LocalizationKey.m648boximpl(strM654unboximpl) : null);
                    strM654unboximpl = localizationKey2 != null ? localizationKey2.m654unboximpl() : null;
                    i4 |= 1;
                } else {
                    if (iO != 1) {
                        throw new UnknownFieldException(iO);
                    }
                    urlMethod2 = (ButtonComponent.UrlMethod) compositeDecoderB.y(descriptor2, 1, UrlMethodDeserializer.INSTANCE, urlMethod2);
                    i4 |= 2;
                }
            }
            urlMethod = urlMethod2;
            i3 = i4;
        }
        String str = strM654unboximpl;
        compositeDecoderB.c(descriptor2);
        return new ButtonComponent.Destination.PrivacyPolicy(i3, str, urlMethod, null, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, ButtonComponent.Destination.PrivacyPolicy value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderB = encoder.b(descriptor2);
        ButtonComponent.Destination.PrivacyPolicy.write$Self$purchases_defaultsBc8Release(value, compositeEncoderB, descriptor2);
        compositeEncoderB.c(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
