package com.revenuecat.purchases.customercenter;

import com.revenuecat.purchases.customercenter.CustomerCenterConfigData;
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
public final class CustomerCenterConfigData$ScreenOffering$$serializer implements GeneratedSerializer<CustomerCenterConfigData.ScreenOffering> {
    public static final CustomerCenterConfigData$ScreenOffering$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        CustomerCenterConfigData$ScreenOffering$$serializer customerCenterConfigData$ScreenOffering$$serializer = new CustomerCenterConfigData$ScreenOffering$$serializer();
        INSTANCE = customerCenterConfigData$ScreenOffering$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.customercenter.CustomerCenterConfigData.ScreenOffering", customerCenterConfigData$ScreenOffering$$serializer, 3);
        pluginGeneratedSerialDescriptor.p("type", false);
        pluginGeneratedSerialDescriptor.p("offering_id", true);
        pluginGeneratedSerialDescriptor.p("button_text", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private CustomerCenterConfigData$ScreenOffering$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        KSerializer<?> kSerializer = CustomerCenterConfigData.ScreenOffering.$childSerializers[0];
        StringSerializer stringSerializer = StringSerializer.f142891a;
        return new KSerializer[]{kSerializer, BuiltinSerializersKt.u(stringSerializer), BuiltinSerializersKt.u(stringSerializer)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public CustomerCenterConfigData.ScreenOffering deserialize(Decoder decoder) {
        int i3;
        CustomerCenterConfigData.ScreenOffering.ScreenOfferingType screenOfferingType;
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderB = decoder.b(descriptor2);
        KSerializer[] kSerializerArr = CustomerCenterConfigData.ScreenOffering.$childSerializers;
        CustomerCenterConfigData.ScreenOffering.ScreenOfferingType screenOfferingType2 = null;
        if (compositeDecoderB.p()) {
            CustomerCenterConfigData.ScreenOffering.ScreenOfferingType screenOfferingType3 = (CustomerCenterConfigData.ScreenOffering.ScreenOfferingType) compositeDecoderB.y(descriptor2, 0, kSerializerArr[0], null);
            StringSerializer stringSerializer = StringSerializer.f142891a;
            String str3 = (String) compositeDecoderB.n(descriptor2, 1, stringSerializer, null);
            screenOfferingType = screenOfferingType3;
            str2 = (String) compositeDecoderB.n(descriptor2, 2, stringSerializer, null);
            i3 = 7;
            str = str3;
        } else {
            boolean z2 = true;
            int i4 = 0;
            String str4 = null;
            String str5 = null;
            while (z2) {
                int iO = compositeDecoderB.o(descriptor2);
                if (iO == -1) {
                    z2 = false;
                } else if (iO == 0) {
                    screenOfferingType2 = (CustomerCenterConfigData.ScreenOffering.ScreenOfferingType) compositeDecoderB.y(descriptor2, 0, kSerializerArr[0], screenOfferingType2);
                    i4 |= 1;
                } else if (iO == 1) {
                    str4 = (String) compositeDecoderB.n(descriptor2, 1, StringSerializer.f142891a, str4);
                    i4 |= 2;
                } else {
                    if (iO != 2) {
                        throw new UnknownFieldException(iO);
                    }
                    str5 = (String) compositeDecoderB.n(descriptor2, 2, StringSerializer.f142891a, str5);
                    i4 |= 4;
                }
            }
            i3 = i4;
            screenOfferingType = screenOfferingType2;
            str = str4;
            str2 = str5;
        }
        compositeDecoderB.c(descriptor2);
        return new CustomerCenterConfigData.ScreenOffering(i3, screenOfferingType, str, str2, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, CustomerCenterConfigData.ScreenOffering value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderB = encoder.b(descriptor2);
        CustomerCenterConfigData.ScreenOffering.write$Self$purchases_defaultsBc8Release(value, compositeEncoderB, descriptor2);
        compositeEncoderB.c(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
