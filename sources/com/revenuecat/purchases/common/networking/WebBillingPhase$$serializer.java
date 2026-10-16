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
import kotlinx.serialization.internal.IntSerializer;
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
/* JADX INFO: loaded from: classes5.dex */
@Metadata
@Deprecated
public final class WebBillingPhase$$serializer implements GeneratedSerializer<WebBillingPhase> {
    public static final WebBillingPhase$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        WebBillingPhase$$serializer webBillingPhase$$serializer = new WebBillingPhase$$serializer();
        INSTANCE = webBillingPhase$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.common.networking.WebBillingPhase", webBillingPhase$$serializer, 3);
        pluginGeneratedSerialDescriptor.p("price", true);
        pluginGeneratedSerialDescriptor.p("period_duration", true);
        pluginGeneratedSerialDescriptor.p("cycle_count", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private WebBillingPhase$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BuiltinSerializersKt.u(WebBillingPrice$$serializer.INSTANCE), BuiltinSerializersKt.u(StringSerializer.f142891a), IntSerializer.f142823a};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public WebBillingPhase deserialize(Decoder decoder) {
        int i3;
        int i4;
        WebBillingPrice webBillingPrice;
        String str;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderB = decoder.b(descriptor2);
        if (compositeDecoderB.p()) {
            WebBillingPrice webBillingPrice2 = (WebBillingPrice) compositeDecoderB.n(descriptor2, 0, WebBillingPrice$$serializer.INSTANCE, null);
            String str2 = (String) compositeDecoderB.n(descriptor2, 1, StringSerializer.f142891a, null);
            webBillingPrice = webBillingPrice2;
            i3 = compositeDecoderB.i(descriptor2, 2);
            str = str2;
            i4 = 7;
        } else {
            boolean z2 = true;
            int i5 = 0;
            WebBillingPrice webBillingPrice3 = null;
            String str3 = null;
            int i6 = 0;
            while (z2) {
                int iO = compositeDecoderB.o(descriptor2);
                if (iO == -1) {
                    z2 = false;
                } else if (iO == 0) {
                    webBillingPrice3 = (WebBillingPrice) compositeDecoderB.n(descriptor2, 0, WebBillingPrice$$serializer.INSTANCE, webBillingPrice3);
                    i6 |= 1;
                } else if (iO == 1) {
                    str3 = (String) compositeDecoderB.n(descriptor2, 1, StringSerializer.f142891a, str3);
                    i6 |= 2;
                } else {
                    if (iO != 2) {
                        throw new UnknownFieldException(iO);
                    }
                    i5 = compositeDecoderB.i(descriptor2, 2);
                    i6 |= 4;
                }
            }
            i3 = i5;
            i4 = i6;
            webBillingPrice = webBillingPrice3;
            str = str3;
        }
        compositeDecoderB.c(descriptor2);
        return new WebBillingPhase(i4, webBillingPrice, str, i3, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, WebBillingPhase value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderB = encoder.b(descriptor2);
        WebBillingPhase.write$Self$purchases_defaultsBc8Release(value, compositeEncoderB, descriptor2);
        compositeEncoderB.c(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
