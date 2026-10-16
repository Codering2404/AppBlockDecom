package com.revenuecat.purchases.common.networking;

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
/* JADX INFO: loaded from: classes5.dex */
@Metadata
@Deprecated
public final class WebBillingPurchaseOption$$serializer implements GeneratedSerializer<WebBillingPurchaseOption> {
    public static final WebBillingPurchaseOption$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        WebBillingPurchaseOption$$serializer webBillingPurchaseOption$$serializer = new WebBillingPurchaseOption$$serializer();
        INSTANCE = webBillingPurchaseOption$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.common.networking.WebBillingPurchaseOption", webBillingPurchaseOption$$serializer, 4);
        pluginGeneratedSerialDescriptor.p("base_price", true);
        pluginGeneratedSerialDescriptor.p("base", true);
        pluginGeneratedSerialDescriptor.p("trial", true);
        pluginGeneratedSerialDescriptor.p("intro_price", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private WebBillingPurchaseOption$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        KSerializer<?> kSerializerU = BuiltinSerializersKt.u(WebBillingPrice$$serializer.INSTANCE);
        WebBillingPhase$$serializer webBillingPhase$$serializer = WebBillingPhase$$serializer.INSTANCE;
        return new KSerializer[]{kSerializerU, BuiltinSerializersKt.u(webBillingPhase$$serializer), BuiltinSerializersKt.u(webBillingPhase$$serializer), BuiltinSerializersKt.u(webBillingPhase$$serializer)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public WebBillingPurchaseOption deserialize(Decoder decoder) {
        int i3;
        WebBillingPrice webBillingPrice;
        WebBillingPhase webBillingPhase;
        WebBillingPhase webBillingPhase2;
        WebBillingPhase webBillingPhase3;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderB = decoder.b(descriptor2);
        WebBillingPrice webBillingPrice2 = null;
        if (compositeDecoderB.p()) {
            WebBillingPrice webBillingPrice3 = (WebBillingPrice) compositeDecoderB.n(descriptor2, 0, WebBillingPrice$$serializer.INSTANCE, null);
            WebBillingPhase$$serializer webBillingPhase$$serializer = WebBillingPhase$$serializer.INSTANCE;
            WebBillingPhase webBillingPhase4 = (WebBillingPhase) compositeDecoderB.n(descriptor2, 1, webBillingPhase$$serializer, null);
            WebBillingPhase webBillingPhase5 = (WebBillingPhase) compositeDecoderB.n(descriptor2, 2, webBillingPhase$$serializer, null);
            webBillingPrice = webBillingPrice3;
            webBillingPhase3 = (WebBillingPhase) compositeDecoderB.n(descriptor2, 3, webBillingPhase$$serializer, null);
            webBillingPhase2 = webBillingPhase5;
            webBillingPhase = webBillingPhase4;
            i3 = 15;
        } else {
            boolean z2 = true;
            int i4 = 0;
            WebBillingPhase webBillingPhase6 = null;
            WebBillingPhase webBillingPhase7 = null;
            WebBillingPhase webBillingPhase8 = null;
            while (z2) {
                int iO = compositeDecoderB.o(descriptor2);
                if (iO == -1) {
                    z2 = false;
                } else if (iO == 0) {
                    webBillingPrice2 = (WebBillingPrice) compositeDecoderB.n(descriptor2, 0, WebBillingPrice$$serializer.INSTANCE, webBillingPrice2);
                    i4 |= 1;
                } else if (iO == 1) {
                    webBillingPhase6 = (WebBillingPhase) compositeDecoderB.n(descriptor2, 1, WebBillingPhase$$serializer.INSTANCE, webBillingPhase6);
                    i4 |= 2;
                } else if (iO == 2) {
                    webBillingPhase7 = (WebBillingPhase) compositeDecoderB.n(descriptor2, 2, WebBillingPhase$$serializer.INSTANCE, webBillingPhase7);
                    i4 |= 4;
                } else {
                    if (iO != 3) {
                        throw new UnknownFieldException(iO);
                    }
                    webBillingPhase8 = (WebBillingPhase) compositeDecoderB.n(descriptor2, 3, WebBillingPhase$$serializer.INSTANCE, webBillingPhase8);
                    i4 |= 8;
                }
            }
            i3 = i4;
            webBillingPrice = webBillingPrice2;
            webBillingPhase = webBillingPhase6;
            webBillingPhase2 = webBillingPhase7;
            webBillingPhase3 = webBillingPhase8;
        }
        compositeDecoderB.c(descriptor2);
        return new WebBillingPurchaseOption(i3, webBillingPrice, webBillingPhase, webBillingPhase2, webBillingPhase3, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, WebBillingPurchaseOption value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderB = encoder.b(descriptor2);
        WebBillingPurchaseOption.write$Self$purchases_defaultsBc8Release(value, compositeEncoderB, descriptor2);
        compositeEncoderB.c(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
