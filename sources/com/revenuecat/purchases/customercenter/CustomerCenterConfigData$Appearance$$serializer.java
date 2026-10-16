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
public final class CustomerCenterConfigData$Appearance$$serializer implements GeneratedSerializer<CustomerCenterConfigData.Appearance> {
    public static final CustomerCenterConfigData$Appearance$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        CustomerCenterConfigData$Appearance$$serializer customerCenterConfigData$Appearance$$serializer = new CustomerCenterConfigData$Appearance$$serializer();
        INSTANCE = customerCenterConfigData$Appearance$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.customercenter.CustomerCenterConfigData.Appearance", customerCenterConfigData$Appearance$$serializer, 2);
        pluginGeneratedSerialDescriptor.p("light", true);
        pluginGeneratedSerialDescriptor.p("dark", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private CustomerCenterConfigData$Appearance$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        CustomerCenterConfigData$Appearance$ColorInformation$$serializer customerCenterConfigData$Appearance$ColorInformation$$serializer = CustomerCenterConfigData$Appearance$ColorInformation$$serializer.INSTANCE;
        return new KSerializer[]{BuiltinSerializersKt.u(customerCenterConfigData$Appearance$ColorInformation$$serializer), BuiltinSerializersKt.u(customerCenterConfigData$Appearance$ColorInformation$$serializer)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public CustomerCenterConfigData.Appearance deserialize(Decoder decoder) {
        CustomerCenterConfigData.Appearance.ColorInformation colorInformation;
        int i3;
        CustomerCenterConfigData.Appearance.ColorInformation colorInformation2;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderB = decoder.b(descriptor2);
        if (compositeDecoderB.p()) {
            CustomerCenterConfigData$Appearance$ColorInformation$$serializer customerCenterConfigData$Appearance$ColorInformation$$serializer = CustomerCenterConfigData$Appearance$ColorInformation$$serializer.INSTANCE;
            colorInformation2 = (CustomerCenterConfigData.Appearance.ColorInformation) compositeDecoderB.n(descriptor2, 0, customerCenterConfigData$Appearance$ColorInformation$$serializer, null);
            colorInformation = (CustomerCenterConfigData.Appearance.ColorInformation) compositeDecoderB.n(descriptor2, 1, customerCenterConfigData$Appearance$ColorInformation$$serializer, null);
            i3 = 3;
        } else {
            boolean z2 = true;
            int i4 = 0;
            colorInformation = null;
            CustomerCenterConfigData.Appearance.ColorInformation colorInformation3 = null;
            while (z2) {
                int iO = compositeDecoderB.o(descriptor2);
                if (iO == -1) {
                    z2 = false;
                } else if (iO == 0) {
                    colorInformation3 = (CustomerCenterConfigData.Appearance.ColorInformation) compositeDecoderB.n(descriptor2, 0, CustomerCenterConfigData$Appearance$ColorInformation$$serializer.INSTANCE, colorInformation3);
                    i4 |= 1;
                } else {
                    if (iO != 1) {
                        throw new UnknownFieldException(iO);
                    }
                    colorInformation = (CustomerCenterConfigData.Appearance.ColorInformation) compositeDecoderB.n(descriptor2, 1, CustomerCenterConfigData$Appearance$ColorInformation$$serializer.INSTANCE, colorInformation);
                    i4 |= 2;
                }
            }
            i3 = i4;
            colorInformation2 = colorInformation3;
        }
        compositeDecoderB.c(descriptor2);
        return new CustomerCenterConfigData.Appearance(i3, colorInformation2, colorInformation, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, CustomerCenterConfigData.Appearance value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderB = encoder.b(descriptor2);
        CustomerCenterConfigData.Appearance.write$Self$purchases_defaultsBc8Release(value, compositeEncoderB, descriptor2);
        compositeEncoderB.c(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
