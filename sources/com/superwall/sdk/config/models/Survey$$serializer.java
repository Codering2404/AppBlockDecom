package com.superwall.sdk.config.models;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import java.util.List;
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
import kotlinx.serialization.internal.DoubleSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@Deprecated
public /* synthetic */ class Survey$$serializer implements GeneratedSerializer<Survey> {
    public static final Survey$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        Survey$$serializer survey$$serializer = new Survey$$serializer();
        INSTANCE = survey$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.superwall.sdk.config.models.Survey", survey$$serializer, 9);
        pluginGeneratedSerialDescriptor.p("id", false);
        pluginGeneratedSerialDescriptor.p("assignmentKey", false);
        pluginGeneratedSerialDescriptor.p("title", false);
        pluginGeneratedSerialDescriptor.p("message", false);
        pluginGeneratedSerialDescriptor.p(SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, false);
        pluginGeneratedSerialDescriptor.p("presentationCondition", false);
        pluginGeneratedSerialDescriptor.p("presentationProbability", false);
        pluginGeneratedSerialDescriptor.p("includeOtherOption", false);
        pluginGeneratedSerialDescriptor.p("includeCloseOption", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private Survey$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        KSerializer<?> kSerializer = Survey.$childSerializers[4];
        StringSerializer stringSerializer = StringSerializer.f142891a;
        BooleanSerializer booleanSerializer = BooleanSerializer.f142767a;
        return new KSerializer[]{stringSerializer, stringSerializer, stringSerializer, stringSerializer, kSerializer, SurveyShowConditionSerializer.INSTANCE, DoubleSerializer.f142796a, booleanSerializer, booleanSerializer};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Survey deserialize(Decoder decoder) {
        boolean zC;
        SurveyShowCondition surveyShowCondition;
        List list;
        boolean zC2;
        int i3;
        double d3;
        String str;
        String str2;
        String str3;
        String str4;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderB = decoder.b(serialDescriptor);
        KSerializer[] kSerializerArr = Survey.$childSerializers;
        int i4 = 7;
        if (compositeDecoderB.p()) {
            String strM = compositeDecoderB.m(serialDescriptor, 0);
            String strM2 = compositeDecoderB.m(serialDescriptor, 1);
            String strM3 = compositeDecoderB.m(serialDescriptor, 2);
            String strM4 = compositeDecoderB.m(serialDescriptor, 3);
            List list2 = (List) compositeDecoderB.y(serialDescriptor, 4, kSerializerArr[4], null);
            SurveyShowCondition surveyShowCondition2 = (SurveyShowCondition) compositeDecoderB.y(serialDescriptor, 5, SurveyShowConditionSerializer.INSTANCE, null);
            double dF = compositeDecoderB.F(serialDescriptor, 6);
            list = list2;
            str = strM;
            zC = compositeDecoderB.C(serialDescriptor, 7);
            zC2 = compositeDecoderB.C(serialDescriptor, 8);
            surveyShowCondition = surveyShowCondition2;
            str4 = strM4;
            i3 = 511;
            str3 = strM3;
            str2 = strM2;
            d3 = dF;
        } else {
            boolean z2 = true;
            boolean zC3 = false;
            SurveyShowCondition surveyShowCondition3 = null;
            String strM5 = null;
            String strM6 = null;
            String strM7 = null;
            String strM8 = null;
            double dF2 = 0.0d;
            boolean zC4 = false;
            int i5 = 0;
            List list3 = null;
            while (z2) {
                int iO = compositeDecoderB.o(serialDescriptor);
                switch (iO) {
                    case -1:
                        z2 = false;
                        i4 = 7;
                        break;
                    case 0:
                        strM5 = compositeDecoderB.m(serialDescriptor, 0);
                        i5 |= 1;
                        i4 = 7;
                        break;
                    case 1:
                        strM6 = compositeDecoderB.m(serialDescriptor, 1);
                        i5 |= 2;
                        i4 = 7;
                        break;
                    case 2:
                        strM7 = compositeDecoderB.m(serialDescriptor, 2);
                        i5 |= 4;
                        break;
                    case 3:
                        strM8 = compositeDecoderB.m(serialDescriptor, 3);
                        i5 |= 8;
                        break;
                    case 4:
                        list3 = (List) compositeDecoderB.y(serialDescriptor, 4, kSerializerArr[4], list3);
                        i5 |= 16;
                        break;
                    case 5:
                        surveyShowCondition3 = (SurveyShowCondition) compositeDecoderB.y(serialDescriptor, 5, SurveyShowConditionSerializer.INSTANCE, surveyShowCondition3);
                        i5 |= 32;
                        break;
                    case 6:
                        dF2 = compositeDecoderB.F(serialDescriptor, 6);
                        i5 |= 64;
                        break;
                    case 7:
                        zC3 = compositeDecoderB.C(serialDescriptor, i4);
                        i5 |= ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
                        break;
                    case 8:
                        zC4 = compositeDecoderB.C(serialDescriptor, 8);
                        i5 |= Function.MAX_NARGS;
                        break;
                    default:
                        throw new UnknownFieldException(iO);
                }
            }
            zC = zC3;
            surveyShowCondition = surveyShowCondition3;
            list = list3;
            zC2 = zC4;
            i3 = i5;
            d3 = dF2;
            str = strM5;
            str2 = strM6;
            str3 = strM7;
            str4 = strM8;
        }
        compositeDecoderB.c(serialDescriptor);
        return new Survey(i3, str, str2, str3, str4, list, surveyShowCondition, d3, zC, zC2, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Survey value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderB = encoder.b(serialDescriptor);
        Survey.write$Self$superwall_release(value, compositeEncoderB, serialDescriptor);
        compositeEncoderB.c(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
