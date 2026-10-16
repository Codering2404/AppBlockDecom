package com.revenuecat.purchases.customercenter;

import com.revenuecat.purchases.customercenter.CustomerCenterConfigData;
import java.util.Map;
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
public final class CustomerCenterConfigData$HelpPath$PathDetail$PromotionalOffer$$serializer implements GeneratedSerializer<CustomerCenterConfigData.HelpPath.PathDetail.PromotionalOffer> {
    public static final CustomerCenterConfigData$HelpPath$PathDetail$PromotionalOffer$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        CustomerCenterConfigData$HelpPath$PathDetail$PromotionalOffer$$serializer customerCenterConfigData$HelpPath$PathDetail$PromotionalOffer$$serializer = new CustomerCenterConfigData$HelpPath$PathDetail$PromotionalOffer$$serializer();
        INSTANCE = customerCenterConfigData$HelpPath$PathDetail$PromotionalOffer$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.customercenter.CustomerCenterConfigData.HelpPath.PathDetail.PromotionalOffer", customerCenterConfigData$HelpPath$PathDetail$PromotionalOffer$$serializer, 6);
        pluginGeneratedSerialDescriptor.p("android_offer_id", false);
        pluginGeneratedSerialDescriptor.p("eligible", false);
        pluginGeneratedSerialDescriptor.p("title", false);
        pluginGeneratedSerialDescriptor.p("subtitle", false);
        pluginGeneratedSerialDescriptor.p("product_mapping", false);
        pluginGeneratedSerialDescriptor.p("cross_product_promotions", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private CustomerCenterConfigData$HelpPath$PathDetail$PromotionalOffer$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr = CustomerCenterConfigData.HelpPath.PathDetail.PromotionalOffer.$childSerializers;
        KSerializer<?> kSerializer = kSerializerArr[4];
        KSerializer<?> kSerializer2 = kSerializerArr[5];
        StringSerializer stringSerializer = StringSerializer.f142891a;
        return new KSerializer[]{stringSerializer, BooleanSerializer.f142767a, stringSerializer, stringSerializer, kSerializer, kSerializer2};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public CustomerCenterConfigData.HelpPath.PathDetail.PromotionalOffer deserialize(Decoder decoder) {
        int i3;
        boolean z2;
        String str;
        String str2;
        String str3;
        Map map;
        Map map2;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderB = decoder.b(descriptor2);
        KSerializer[] kSerializerArr = CustomerCenterConfigData.HelpPath.PathDetail.PromotionalOffer.$childSerializers;
        if (compositeDecoderB.p()) {
            String strM = compositeDecoderB.m(descriptor2, 0);
            boolean zC = compositeDecoderB.C(descriptor2, 1);
            String strM2 = compositeDecoderB.m(descriptor2, 2);
            String strM3 = compositeDecoderB.m(descriptor2, 3);
            Map map3 = (Map) compositeDecoderB.y(descriptor2, 4, kSerializerArr[4], null);
            map2 = (Map) compositeDecoderB.y(descriptor2, 5, kSerializerArr[5], null);
            str = strM;
            str3 = strM3;
            str2 = strM2;
            i3 = 63;
            map = map3;
            z2 = zC;
        } else {
            boolean z3 = true;
            int i4 = 0;
            String strM4 = null;
            String strM5 = null;
            String strM6 = null;
            Map map4 = null;
            Map map5 = null;
            boolean zC2 = false;
            while (z3) {
                int iO = compositeDecoderB.o(descriptor2);
                switch (iO) {
                    case -1:
                        z3 = false;
                        continue;
                    case 0:
                        strM4 = compositeDecoderB.m(descriptor2, 0);
                        i4 |= 1;
                        continue;
                    case 1:
                        zC2 = compositeDecoderB.C(descriptor2, 1);
                        i4 |= 2;
                        break;
                    case 2:
                        strM5 = compositeDecoderB.m(descriptor2, 2);
                        i4 |= 4;
                        break;
                    case 3:
                        strM6 = compositeDecoderB.m(descriptor2, 3);
                        i4 |= 8;
                        break;
                    case 4:
                        map4 = (Map) compositeDecoderB.y(descriptor2, 4, kSerializerArr[4], map4);
                        i4 |= 16;
                        break;
                    case 5:
                        map5 = (Map) compositeDecoderB.y(descriptor2, 5, kSerializerArr[5], map5);
                        i4 |= 32;
                        break;
                    default:
                        throw new UnknownFieldException(iO);
                }
            }
            i3 = i4;
            z2 = zC2;
            str = strM4;
            str2 = strM5;
            str3 = strM6;
            map = map4;
            map2 = map5;
        }
        compositeDecoderB.c(descriptor2);
        return new CustomerCenterConfigData.HelpPath.PathDetail.PromotionalOffer(i3, str, z2, str2, str3, map, map2, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, CustomerCenterConfigData.HelpPath.PathDetail.PromotionalOffer value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderB = encoder.b(descriptor2);
        CustomerCenterConfigData.HelpPath.PathDetail.PromotionalOffer.write$Self$purchases_defaultsBc8Release(value, compositeEncoderB, descriptor2);
        compositeEncoderB.c(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
