package com.revenuecat.purchases.customercenter;

import androidx.datastore.preferences.core.SfRj.rnFwbPAQmQTnL;
import com.revenuecat.purchases.customercenter.CustomerCenterConfigData;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
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
public final class CustomerCenterConfigData$HelpPath$$serializer implements GeneratedSerializer<CustomerCenterConfigData.HelpPath> {
    public static final CustomerCenterConfigData$HelpPath$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    private CustomerCenterConfigData$HelpPath$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr = CustomerCenterConfigData.HelpPath.$childSerializers;
        StringSerializer stringSerializer = StringSerializer.f142891a;
        return new KSerializer[]{stringSerializer, stringSerializer, kSerializerArr[2], BuiltinSerializersKt.u(CustomerCenterConfigData$HelpPath$PathDetail$PromotionalOffer$$serializer.INSTANCE), BuiltinSerializersKt.u(CustomerCenterConfigData$HelpPath$PathDetail$FeedbackSurvey$$serializer.INSTANCE), BuiltinSerializersKt.u(stringSerializer), BuiltinSerializersKt.u(kSerializerArr[6]), BuiltinSerializersKt.u(stringSerializer)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public CustomerCenterConfigData.HelpPath deserialize(Decoder decoder) {
        int i3;
        String str;
        CustomerCenterConfigData.HelpPath.OpenMethod openMethod;
        String str2;
        CustomerCenterConfigData.HelpPath.PathDetail.FeedbackSurvey feedbackSurvey;
        String str3;
        String str4;
        CustomerCenterConfigData.HelpPath.PathType pathType;
        CustomerCenterConfigData.HelpPath.PathDetail.PromotionalOffer promotionalOffer;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderB = decoder.b(descriptor2);
        KSerializer[] kSerializerArr = CustomerCenterConfigData.HelpPath.$childSerializers;
        int i4 = 7;
        String strM = null;
        if (compositeDecoderB.p()) {
            String strM2 = compositeDecoderB.m(descriptor2, 0);
            String strM3 = compositeDecoderB.m(descriptor2, 1);
            CustomerCenterConfigData.HelpPath.PathType pathType2 = (CustomerCenterConfigData.HelpPath.PathType) compositeDecoderB.y(descriptor2, 2, kSerializerArr[2], null);
            CustomerCenterConfigData.HelpPath.PathDetail.PromotionalOffer promotionalOffer2 = (CustomerCenterConfigData.HelpPath.PathDetail.PromotionalOffer) compositeDecoderB.n(descriptor2, 3, CustomerCenterConfigData$HelpPath$PathDetail$PromotionalOffer$$serializer.INSTANCE, null);
            CustomerCenterConfigData.HelpPath.PathDetail.FeedbackSurvey feedbackSurvey2 = (CustomerCenterConfigData.HelpPath.PathDetail.FeedbackSurvey) compositeDecoderB.n(descriptor2, 4, CustomerCenterConfigData$HelpPath$PathDetail$FeedbackSurvey$$serializer.INSTANCE, null);
            StringSerializer stringSerializer = StringSerializer.f142891a;
            String str5 = (String) compositeDecoderB.n(descriptor2, 5, stringSerializer, null);
            openMethod = (CustomerCenterConfigData.HelpPath.OpenMethod) compositeDecoderB.n(descriptor2, 6, kSerializerArr[6], null);
            str3 = strM2;
            str = (String) compositeDecoderB.n(descriptor2, 7, stringSerializer, null);
            str2 = str5;
            promotionalOffer = promotionalOffer2;
            feedbackSurvey = feedbackSurvey2;
            i3 = 255;
            pathType = pathType2;
            str4 = strM3;
        } else {
            boolean z2 = true;
            int i5 = 0;
            String str6 = null;
            CustomerCenterConfigData.HelpPath.OpenMethod openMethod2 = null;
            String str7 = null;
            CustomerCenterConfigData.HelpPath.PathDetail.FeedbackSurvey feedbackSurvey3 = null;
            String strM4 = null;
            CustomerCenterConfigData.HelpPath.PathType pathType3 = null;
            CustomerCenterConfigData.HelpPath.PathDetail.PromotionalOffer promotionalOffer3 = null;
            while (z2) {
                int iO = compositeDecoderB.o(descriptor2);
                switch (iO) {
                    case -1:
                        z2 = false;
                        break;
                    case 0:
                        i5 |= 1;
                        strM = compositeDecoderB.m(descriptor2, 0);
                        i4 = 7;
                        break;
                    case 1:
                        strM4 = compositeDecoderB.m(descriptor2, 1);
                        i5 |= 2;
                        i4 = 7;
                        break;
                    case 2:
                        pathType3 = (CustomerCenterConfigData.HelpPath.PathType) compositeDecoderB.y(descriptor2, 2, kSerializerArr[2], pathType3);
                        i5 |= 4;
                        i4 = 7;
                        break;
                    case 3:
                        promotionalOffer3 = (CustomerCenterConfigData.HelpPath.PathDetail.PromotionalOffer) compositeDecoderB.n(descriptor2, 3, CustomerCenterConfigData$HelpPath$PathDetail$PromotionalOffer$$serializer.INSTANCE, promotionalOffer3);
                        i5 |= 8;
                        i4 = 7;
                        break;
                    case 4:
                        feedbackSurvey3 = (CustomerCenterConfigData.HelpPath.PathDetail.FeedbackSurvey) compositeDecoderB.n(descriptor2, 4, CustomerCenterConfigData$HelpPath$PathDetail$FeedbackSurvey$$serializer.INSTANCE, feedbackSurvey3);
                        i5 |= 16;
                        i4 = 7;
                        break;
                    case 5:
                        str7 = (String) compositeDecoderB.n(descriptor2, 5, StringSerializer.f142891a, str7);
                        i5 |= 32;
                        break;
                    case 6:
                        openMethod2 = (CustomerCenterConfigData.HelpPath.OpenMethod) compositeDecoderB.n(descriptor2, 6, kSerializerArr[6], openMethod2);
                        i5 |= 64;
                        break;
                    case 7:
                        str6 = (String) compositeDecoderB.n(descriptor2, i4, StringSerializer.f142891a, str6);
                        i5 |= ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
                        break;
                    default:
                        throw new UnknownFieldException(iO);
                }
            }
            i3 = i5;
            str = str6;
            openMethod = openMethod2;
            str2 = str7;
            feedbackSurvey = feedbackSurvey3;
            str3 = strM;
            str4 = strM4;
            pathType = pathType3;
            promotionalOffer = promotionalOffer3;
        }
        compositeDecoderB.c(descriptor2);
        return new CustomerCenterConfigData.HelpPath(i3, str3, str4, pathType, promotionalOffer, feedbackSurvey, str2, openMethod, str, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, CustomerCenterConfigData.HelpPath value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderB = encoder.b(descriptor2);
        CustomerCenterConfigData.HelpPath.write$Self$purchases_defaultsBc8Release(value, compositeEncoderB, descriptor2);
        compositeEncoderB.c(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }

    static {
        CustomerCenterConfigData$HelpPath$$serializer customerCenterConfigData$HelpPath$$serializer = new CustomerCenterConfigData$HelpPath$$serializer();
        INSTANCE = customerCenterConfigData$HelpPath$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.customercenter.CustomerCenterConfigData.HelpPath", customerCenterConfigData$HelpPath$$serializer, 8);
        pluginGeneratedSerialDescriptor.p("id", false);
        pluginGeneratedSerialDescriptor.p("title", false);
        pluginGeneratedSerialDescriptor.p("type", false);
        pluginGeneratedSerialDescriptor.p("promotional_offer", true);
        pluginGeneratedSerialDescriptor.p(rnFwbPAQmQTnL.aBzGfMWQoCgqKfY, true);
        pluginGeneratedSerialDescriptor.p("url", true);
        pluginGeneratedSerialDescriptor.p("open_method", true);
        pluginGeneratedSerialDescriptor.p("action_identifier", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }
}
