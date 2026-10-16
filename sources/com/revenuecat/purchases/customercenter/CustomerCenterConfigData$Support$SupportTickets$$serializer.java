package com.revenuecat.purchases.customercenter;

import com.revenuecat.purchases.customercenter.CustomerCenterConfigData;
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
public final class CustomerCenterConfigData$Support$SupportTickets$$serializer implements GeneratedSerializer<CustomerCenterConfigData.Support.SupportTickets> {
    public static final CustomerCenterConfigData$Support$SupportTickets$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        CustomerCenterConfigData$Support$SupportTickets$$serializer customerCenterConfigData$Support$SupportTickets$$serializer = new CustomerCenterConfigData$Support$SupportTickets$$serializer();
        INSTANCE = customerCenterConfigData$Support$SupportTickets$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.customercenter.CustomerCenterConfigData.Support.SupportTickets", customerCenterConfigData$Support$SupportTickets$$serializer, 3);
        pluginGeneratedSerialDescriptor.p("allow_creation", true);
        pluginGeneratedSerialDescriptor.p("customer_details", true);
        pluginGeneratedSerialDescriptor.p("customer_type", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private CustomerCenterConfigData$Support$SupportTickets$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BooleanSerializer.f142767a, CustomerCenterConfigData$Support$SupportTickets$CustomerDetails$$serializer.INSTANCE, CustomerCenterConfigData.Support.SupportTickets.$childSerializers[2]};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public CustomerCenterConfigData.Support.SupportTickets deserialize(Decoder decoder) {
        boolean zC;
        int i3;
        CustomerCenterConfigData.Support.SupportTickets.CustomerDetails customerDetails;
        CustomerCenterConfigData.Support.SupportTickets.CustomerType customerType;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderB = decoder.b(descriptor2);
        KSerializer[] kSerializerArr = CustomerCenterConfigData.Support.SupportTickets.$childSerializers;
        if (compositeDecoderB.p()) {
            zC = compositeDecoderB.C(descriptor2, 0);
            CustomerCenterConfigData.Support.SupportTickets.CustomerDetails customerDetails2 = (CustomerCenterConfigData.Support.SupportTickets.CustomerDetails) compositeDecoderB.y(descriptor2, 1, CustomerCenterConfigData$Support$SupportTickets$CustomerDetails$$serializer.INSTANCE, null);
            customerType = (CustomerCenterConfigData.Support.SupportTickets.CustomerType) compositeDecoderB.y(descriptor2, 2, kSerializerArr[2], null);
            i3 = 7;
            customerDetails = customerDetails2;
        } else {
            boolean z2 = true;
            zC = false;
            CustomerCenterConfigData.Support.SupportTickets.CustomerDetails customerDetails3 = null;
            CustomerCenterConfigData.Support.SupportTickets.CustomerType customerType2 = null;
            int i4 = 0;
            while (z2) {
                int iO = compositeDecoderB.o(descriptor2);
                if (iO == -1) {
                    z2 = false;
                } else if (iO == 0) {
                    zC = compositeDecoderB.C(descriptor2, 0);
                    i4 |= 1;
                } else if (iO == 1) {
                    customerDetails3 = (CustomerCenterConfigData.Support.SupportTickets.CustomerDetails) compositeDecoderB.y(descriptor2, 1, CustomerCenterConfigData$Support$SupportTickets$CustomerDetails$$serializer.INSTANCE, customerDetails3);
                    i4 |= 2;
                } else {
                    if (iO != 2) {
                        throw new UnknownFieldException(iO);
                    }
                    customerType2 = (CustomerCenterConfigData.Support.SupportTickets.CustomerType) compositeDecoderB.y(descriptor2, 2, kSerializerArr[2], customerType2);
                    i4 |= 4;
                }
            }
            i3 = i4;
            customerDetails = customerDetails3;
            customerType = customerType2;
        }
        boolean z3 = zC;
        compositeDecoderB.c(descriptor2);
        return new CustomerCenterConfigData.Support.SupportTickets(i3, z3, customerDetails, customerType, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, CustomerCenterConfigData.Support.SupportTickets value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderB = encoder.b(descriptor2);
        CustomerCenterConfigData.Support.SupportTickets.write$Self$purchases_defaultsBc8Release(value, compositeEncoderB, descriptor2);
        compositeEncoderB.c(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
