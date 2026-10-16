package com.superwall.sdk.config.models;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
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
public final class SurveyShowConditionSerializer implements KSerializer<SurveyShowCondition> {
    public static final SurveyShowConditionSerializer INSTANCE = new SurveyShowConditionSerializer();
    private static final SerialDescriptor descriptor;

    static {
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.superwall.sdk.config.models.SurveyShowCondition", null, 1);
        pluginGeneratedSerialDescriptor.p("rawValue", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private SurveyShowConditionSerializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public SurveyShowCondition deserialize(Decoder decoder) {
        SurveyShowCondition surveyShowCondition;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        String strZ = decoder.z();
        SurveyShowCondition[] surveyShowConditionArrValues = SurveyShowCondition.values();
        int length = surveyShowConditionArrValues.length;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                surveyShowCondition = null;
                break;
            }
            surveyShowCondition = surveyShowConditionArrValues[i3];
            if (Intrinsics.areEqual(surveyShowCondition.getRawValue(), strZ)) {
                break;
            }
            i3++;
        }
        if (surveyShowCondition != null) {
            return surveyShowCondition;
        }
        throw new IllegalArgumentException("Unsupported survey condition.");
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, SurveyShowCondition value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        encoder.G(value.getRawValue());
    }
}
