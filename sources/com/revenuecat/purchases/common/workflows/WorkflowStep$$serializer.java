package com.revenuecat.purchases.common.workflows;

import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.util.List;
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
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementSerializer;

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
public final class WorkflowStep$$serializer implements GeneratedSerializer<WorkflowStep> {
    public static final WorkflowStep$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        WorkflowStep$$serializer workflowStep$$serializer = new WorkflowStep$$serializer();
        INSTANCE = workflowStep$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.common.workflows.WorkflowStep", workflowStep$$serializer, 8);
        pluginGeneratedSerialDescriptor.p("id", false);
        pluginGeneratedSerialDescriptor.p("type", false);
        pluginGeneratedSerialDescriptor.p("screen_id", true);
        pluginGeneratedSerialDescriptor.p("param_values", true);
        pluginGeneratedSerialDescriptor.p("triggers", true);
        pluginGeneratedSerialDescriptor.p("outputs", true);
        pluginGeneratedSerialDescriptor.p("trigger_actions", true);
        pluginGeneratedSerialDescriptor.p("metadata", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private WorkflowStep$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr = WorkflowStep.$childSerializers;
        StringSerializer stringSerializer = StringSerializer.f142891a;
        return new KSerializer[]{stringSerializer, stringSerializer, BuiltinSerializersKt.u(stringSerializer), kSerializerArr[3], kSerializerArr[4], kSerializerArr[5], kSerializerArr[6], BuiltinSerializersKt.u(JsonElementSerializer.f143009a)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public WorkflowStep deserialize(Decoder decoder) {
        int i3;
        Map map;
        JsonElement jsonElement;
        Map map2;
        List list;
        String str;
        String str2;
        String str3;
        Map map3;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderB = decoder.b(descriptor2);
        KSerializer[] kSerializerArr = WorkflowStep.$childSerializers;
        int i4 = 7;
        int i5 = 4;
        String strM = null;
        if (compositeDecoderB.p()) {
            String strM2 = compositeDecoderB.m(descriptor2, 0);
            String strM3 = compositeDecoderB.m(descriptor2, 1);
            String str4 = (String) compositeDecoderB.n(descriptor2, 2, StringSerializer.f142891a, null);
            Map map4 = (Map) compositeDecoderB.y(descriptor2, 3, kSerializerArr[3], null);
            List list2 = (List) compositeDecoderB.y(descriptor2, 4, kSerializerArr[4], null);
            Map map5 = (Map) compositeDecoderB.y(descriptor2, 5, kSerializerArr[5], null);
            map = (Map) compositeDecoderB.y(descriptor2, 6, kSerializerArr[6], null);
            str = strM2;
            jsonElement = (JsonElement) compositeDecoderB.n(descriptor2, 7, JsonElementSerializer.f143009a, null);
            str3 = str4;
            i3 = 255;
            map2 = map5;
            map3 = map4;
            list = list2;
            str2 = strM3;
        } else {
            int i6 = 3;
            boolean z2 = true;
            int i7 = 0;
            Map map6 = null;
            JsonElement jsonElement2 = null;
            Map map7 = null;
            List list3 = null;
            String strM4 = null;
            String str5 = null;
            Map map8 = null;
            while (z2) {
                int i8 = i5;
                int iO = compositeDecoderB.o(descriptor2);
                switch (iO) {
                    case -1:
                        z2 = false;
                        i5 = 4;
                        i6 = 3;
                        break;
                    case 0:
                        i7 |= 1;
                        strM = compositeDecoderB.m(descriptor2, 0);
                        i4 = 7;
                        i5 = 4;
                        i6 = 3;
                        break;
                    case 1:
                        strM4 = compositeDecoderB.m(descriptor2, 1);
                        i7 |= 2;
                        i4 = 7;
                        i5 = 4;
                        i6 = 3;
                        break;
                    case 2:
                        str5 = (String) compositeDecoderB.n(descriptor2, 2, StringSerializer.f142891a, str5);
                        i7 |= 4;
                        i4 = 7;
                        i5 = 4;
                        i6 = 3;
                        break;
                    case 3:
                        map8 = (Map) compositeDecoderB.y(descriptor2, i6, kSerializerArr[i6], map8);
                        i7 |= 8;
                        i4 = 7;
                        i5 = 4;
                        break;
                    case 4:
                        list3 = (List) compositeDecoderB.y(descriptor2, i8, kSerializerArr[i8], list3);
                        i7 |= 16;
                        i5 = i8;
                        i4 = 7;
                        break;
                    case 5:
                        map7 = (Map) compositeDecoderB.y(descriptor2, 5, kSerializerArr[5], map7);
                        i7 |= 32;
                        i5 = i8;
                        break;
                    case 6:
                        map6 = (Map) compositeDecoderB.y(descriptor2, 6, kSerializerArr[6], map6);
                        i7 |= 64;
                        i5 = i8;
                        break;
                    case 7:
                        jsonElement2 = (JsonElement) compositeDecoderB.n(descriptor2, i4, JsonElementSerializer.f143009a, jsonElement2);
                        i7 |= ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
                        i5 = i8;
                        break;
                    default:
                        throw new UnknownFieldException(iO);
                }
            }
            i3 = i7;
            map = map6;
            jsonElement = jsonElement2;
            map2 = map7;
            list = list3;
            str = strM;
            str2 = strM4;
            str3 = str5;
            map3 = map8;
        }
        compositeDecoderB.c(descriptor2);
        return new WorkflowStep(i3, str, str2, str3, map3, list, map2, map, jsonElement, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, WorkflowStep value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderB = encoder.b(descriptor2);
        WorkflowStep.write$Self$purchases_defaultsBc8Release(value, compositeEncoderB, descriptor2);
        compositeEncoderB.c(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
