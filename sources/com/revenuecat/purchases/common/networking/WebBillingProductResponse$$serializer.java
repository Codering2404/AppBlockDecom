package com.revenuecat.purchases.common.networking;

import com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker;
import java.util.Map;
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
/* JADX INFO: loaded from: classes5.dex */
@Metadata
@Deprecated
public final class WebBillingProductResponse$$serializer implements GeneratedSerializer<WebBillingProductResponse> {
    public static final WebBillingProductResponse$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        WebBillingProductResponse$$serializer webBillingProductResponse$$serializer = new WebBillingProductResponse$$serializer();
        INSTANCE = webBillingProductResponse$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.common.networking.WebBillingProductResponse", webBillingProductResponse$$serializer, 6);
        pluginGeneratedSerialDescriptor.p("identifier", false);
        pluginGeneratedSerialDescriptor.p(DiagnosticsTracker.PRODUCT_TYPE_KEY, false);
        pluginGeneratedSerialDescriptor.p("title", false);
        pluginGeneratedSerialDescriptor.p("description", true);
        pluginGeneratedSerialDescriptor.p("default_purchase_option_id", true);
        pluginGeneratedSerialDescriptor.p("purchase_options", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private WebBillingProductResponse$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr = WebBillingProductResponse.$childSerializers;
        StringSerializer stringSerializer = StringSerializer.f142891a;
        return new KSerializer[]{stringSerializer, stringSerializer, stringSerializer, BuiltinSerializersKt.u(stringSerializer), BuiltinSerializersKt.u(stringSerializer), kSerializerArr[5]};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public WebBillingProductResponse deserialize(Decoder decoder) {
        int i3;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        Map map;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderB = decoder.b(descriptor2);
        KSerializer[] kSerializerArr = WebBillingProductResponse.$childSerializers;
        String strM = null;
        if (compositeDecoderB.p()) {
            String strM2 = compositeDecoderB.m(descriptor2, 0);
            String strM3 = compositeDecoderB.m(descriptor2, 1);
            String strM4 = compositeDecoderB.m(descriptor2, 2);
            StringSerializer stringSerializer = StringSerializer.f142891a;
            String str6 = (String) compositeDecoderB.n(descriptor2, 3, stringSerializer, null);
            String str7 = (String) compositeDecoderB.n(descriptor2, 4, stringSerializer, null);
            map = (Map) compositeDecoderB.y(descriptor2, 5, kSerializerArr[5], null);
            str = strM2;
            str4 = str6;
            str5 = str7;
            str3 = strM4;
            i3 = 63;
            str2 = strM3;
        } else {
            boolean z2 = true;
            int i4 = 0;
            String strM5 = null;
            String strM6 = null;
            String str8 = null;
            String str9 = null;
            Map map2 = null;
            while (z2) {
                int iO = compositeDecoderB.o(descriptor2);
                switch (iO) {
                    case -1:
                        z2 = false;
                        continue;
                    case 0:
                        strM = compositeDecoderB.m(descriptor2, 0);
                        i4 |= 1;
                        continue;
                    case 1:
                        strM5 = compositeDecoderB.m(descriptor2, 1);
                        i4 |= 2;
                        break;
                    case 2:
                        strM6 = compositeDecoderB.m(descriptor2, 2);
                        i4 |= 4;
                        break;
                    case 3:
                        str8 = (String) compositeDecoderB.n(descriptor2, 3, StringSerializer.f142891a, str8);
                        i4 |= 8;
                        break;
                    case 4:
                        str9 = (String) compositeDecoderB.n(descriptor2, 4, StringSerializer.f142891a, str9);
                        i4 |= 16;
                        break;
                    case 5:
                        map2 = (Map) compositeDecoderB.y(descriptor2, 5, kSerializerArr[5], map2);
                        i4 |= 32;
                        break;
                    default:
                        throw new UnknownFieldException(iO);
                }
            }
            i3 = i4;
            str = strM;
            str2 = strM5;
            str3 = strM6;
            str4 = str8;
            str5 = str9;
            map = map2;
        }
        compositeDecoderB.c(descriptor2);
        return new WebBillingProductResponse(i3, str, str2, str3, str4, str5, map, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, WebBillingProductResponse value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderB = encoder.b(descriptor2);
        WebBillingProductResponse.write$Self$purchases_defaultsBc8Release(value, compositeEncoderB, descriptor2);
        compositeEncoderB.c(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
