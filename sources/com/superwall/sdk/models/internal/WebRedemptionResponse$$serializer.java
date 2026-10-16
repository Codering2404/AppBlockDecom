package com.superwall.sdk.models.internal;

import com.superwall.sdk.models.customer.CustomerInfo;
import com.superwall.sdk.models.customer.CustomerInfo$$serializer;
import java.util.List;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@Deprecated
public /* synthetic */ class WebRedemptionResponse$$serializer implements GeneratedSerializer<WebRedemptionResponse> {
    public static final WebRedemptionResponse$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        WebRedemptionResponse$$serializer webRedemptionResponse$$serializer = new WebRedemptionResponse$$serializer();
        INSTANCE = webRedemptionResponse$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.superwall.sdk.models.internal.WebRedemptionResponse", webRedemptionResponse$$serializer, 2);
        pluginGeneratedSerialDescriptor.p("codes", false);
        pluginGeneratedSerialDescriptor.p("customerInfo", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private WebRedemptionResponse$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{WebRedemptionResponse.$childSerializers[0], BuiltinSerializersKt.u(CustomerInfo$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final WebRedemptionResponse deserialize(Decoder decoder) {
        List list;
        CustomerInfo customerInfo;
        int i3;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderB = decoder.b(serialDescriptor);
        KSerializer[] kSerializerArr = WebRedemptionResponse.$childSerializers;
        if (compositeDecoderB.p()) {
            list = (List) compositeDecoderB.y(serialDescriptor, 0, kSerializerArr[0], null);
            customerInfo = (CustomerInfo) compositeDecoderB.n(serialDescriptor, 1, CustomerInfo$$serializer.INSTANCE, null);
            i3 = 3;
        } else {
            boolean z2 = true;
            int i4 = 0;
            List list2 = null;
            CustomerInfo customerInfo2 = null;
            while (z2) {
                int iO = compositeDecoderB.o(serialDescriptor);
                if (iO == -1) {
                    z2 = false;
                } else if (iO == 0) {
                    list2 = (List) compositeDecoderB.y(serialDescriptor, 0, kSerializerArr[0], list2);
                    i4 |= 1;
                } else {
                    if (iO != 1) {
                        throw new UnknownFieldException(iO);
                    }
                    customerInfo2 = (CustomerInfo) compositeDecoderB.n(serialDescriptor, 1, CustomerInfo$$serializer.INSTANCE, customerInfo2);
                    i4 |= 2;
                }
            }
            list = list2;
            customerInfo = customerInfo2;
            i3 = i4;
        }
        compositeDecoderB.c(serialDescriptor);
        return new WebRedemptionResponse(i3, list, customerInfo, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, WebRedemptionResponse value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderB = encoder.b(serialDescriptor);
        WebRedemptionResponse.write$Self$superwall_release(value, compositeEncoderB, serialDescriptor);
        compositeEncoderB.c(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
