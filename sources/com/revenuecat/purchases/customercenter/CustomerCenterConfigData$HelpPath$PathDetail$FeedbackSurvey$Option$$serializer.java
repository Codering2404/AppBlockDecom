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
public final class CustomerCenterConfigData$HelpPath$PathDetail$FeedbackSurvey$Option$$serializer implements GeneratedSerializer<CustomerCenterConfigData.HelpPath.PathDetail.FeedbackSurvey.Option> {
    public static final CustomerCenterConfigData$HelpPath$PathDetail$FeedbackSurvey$Option$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        CustomerCenterConfigData$HelpPath$PathDetail$FeedbackSurvey$Option$$serializer customerCenterConfigData$HelpPath$PathDetail$FeedbackSurvey$Option$$serializer = new CustomerCenterConfigData$HelpPath$PathDetail$FeedbackSurvey$Option$$serializer();
        INSTANCE = customerCenterConfigData$HelpPath$PathDetail$FeedbackSurvey$Option$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.customercenter.CustomerCenterConfigData.HelpPath.PathDetail.FeedbackSurvey.Option", customerCenterConfigData$HelpPath$PathDetail$FeedbackSurvey$Option$$serializer, 3);
        pluginGeneratedSerialDescriptor.p("id", false);
        pluginGeneratedSerialDescriptor.p("title", false);
        pluginGeneratedSerialDescriptor.p("promotional_offer", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private CustomerCenterConfigData$HelpPath$PathDetail$FeedbackSurvey$Option$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        KSerializer<?> kSerializerU = BuiltinSerializersKt.u(CustomerCenterConfigData$HelpPath$PathDetail$PromotionalOffer$$serializer.INSTANCE);
        StringSerializer stringSerializer = StringSerializer.f142891a;
        return new KSerializer[]{stringSerializer, stringSerializer, kSerializerU};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public CustomerCenterConfigData.HelpPath.PathDetail.FeedbackSurvey.Option deserialize(Decoder decoder) {
        int i3;
        String str;
        String str2;
        CustomerCenterConfigData.HelpPath.PathDetail.PromotionalOffer promotionalOffer;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderB = decoder.b(descriptor2);
        String strM = null;
        if (compositeDecoderB.p()) {
            String strM2 = compositeDecoderB.m(descriptor2, 0);
            String strM3 = compositeDecoderB.m(descriptor2, 1);
            str = strM2;
            promotionalOffer = (CustomerCenterConfigData.HelpPath.PathDetail.PromotionalOffer) compositeDecoderB.n(descriptor2, 2, CustomerCenterConfigData$HelpPath$PathDetail$PromotionalOffer$$serializer.INSTANCE, null);
            str2 = strM3;
            i3 = 7;
        } else {
            boolean z2 = true;
            int i4 = 0;
            String strM4 = null;
            CustomerCenterConfigData.HelpPath.PathDetail.PromotionalOffer promotionalOffer2 = null;
            while (z2) {
                int iO = compositeDecoderB.o(descriptor2);
                if (iO == -1) {
                    z2 = false;
                } else if (iO == 0) {
                    strM = compositeDecoderB.m(descriptor2, 0);
                    i4 |= 1;
                } else if (iO == 1) {
                    strM4 = compositeDecoderB.m(descriptor2, 1);
                    i4 |= 2;
                } else {
                    if (iO != 2) {
                        throw new UnknownFieldException(iO);
                    }
                    promotionalOffer2 = (CustomerCenterConfigData.HelpPath.PathDetail.PromotionalOffer) compositeDecoderB.n(descriptor2, 2, CustomerCenterConfigData$HelpPath$PathDetail$PromotionalOffer$$serializer.INSTANCE, promotionalOffer2);
                    i4 |= 4;
                }
            }
            i3 = i4;
            str = strM;
            str2 = strM4;
            promotionalOffer = promotionalOffer2;
        }
        compositeDecoderB.c(descriptor2);
        return new CustomerCenterConfigData.HelpPath.PathDetail.FeedbackSurvey.Option(i3, str, str2, promotionalOffer, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, CustomerCenterConfigData.HelpPath.PathDetail.FeedbackSurvey.Option value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderB = encoder.b(descriptor2);
        CustomerCenterConfigData.HelpPath.PathDetail.FeedbackSurvey.Option.write$Self$purchases_defaultsBc8Release(value, compositeEncoderB, descriptor2);
        compositeEncoderB.c(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
