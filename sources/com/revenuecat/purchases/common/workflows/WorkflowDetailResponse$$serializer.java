package com.revenuecat.purchases.common.workflows;

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
public final class WorkflowDetailResponse$$serializer implements GeneratedSerializer<WorkflowDetailResponse> {
    public static final WorkflowDetailResponse$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        WorkflowDetailResponse$$serializer workflowDetailResponse$$serializer = new WorkflowDetailResponse$$serializer();
        INSTANCE = workflowDetailResponse$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.common.workflows.WorkflowDetailResponse", workflowDetailResponse$$serializer, 5);
        pluginGeneratedSerialDescriptor.p("action", false);
        pluginGeneratedSerialDescriptor.p("data", true);
        pluginGeneratedSerialDescriptor.p("url", true);
        pluginGeneratedSerialDescriptor.p("hash", true);
        pluginGeneratedSerialDescriptor.p("enrolled_variants", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private WorkflowDetailResponse$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr = WorkflowDetailResponse.$childSerializers;
        KSerializer<?> kSerializer = kSerializerArr[0];
        KSerializer<?> kSerializerU = BuiltinSerializersKt.u(PublishedWorkflow$$serializer.INSTANCE);
        StringSerializer stringSerializer = StringSerializer.f142891a;
        return new KSerializer[]{kSerializer, kSerializerU, BuiltinSerializersKt.u(stringSerializer), BuiltinSerializersKt.u(stringSerializer), BuiltinSerializersKt.u(kSerializerArr[4])};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public WorkflowDetailResponse deserialize(Decoder decoder) {
        int i3;
        WorkflowResponseAction workflowResponseAction;
        PublishedWorkflow publishedWorkflow;
        String str;
        String str2;
        Map map;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderB = decoder.b(descriptor2);
        KSerializer[] kSerializerArr = WorkflowDetailResponse.$childSerializers;
        int i4 = 0;
        WorkflowResponseAction workflowResponseAction2 = null;
        if (compositeDecoderB.p()) {
            WorkflowResponseAction workflowResponseAction3 = (WorkflowResponseAction) compositeDecoderB.y(descriptor2, 0, kSerializerArr[0], null);
            PublishedWorkflow publishedWorkflow2 = (PublishedWorkflow) compositeDecoderB.n(descriptor2, 1, PublishedWorkflow$$serializer.INSTANCE, null);
            StringSerializer stringSerializer = StringSerializer.f142891a;
            String str3 = (String) compositeDecoderB.n(descriptor2, 2, stringSerializer, null);
            String str4 = (String) compositeDecoderB.n(descriptor2, 3, stringSerializer, null);
            map = (Map) compositeDecoderB.n(descriptor2, 4, kSerializerArr[4], null);
            workflowResponseAction = workflowResponseAction3;
            str2 = str4;
            str = str3;
            i3 = 31;
            publishedWorkflow = publishedWorkflow2;
        } else {
            int i5 = 1;
            int i6 = 0;
            PublishedWorkflow publishedWorkflow3 = null;
            String str5 = null;
            String str6 = null;
            Map map2 = null;
            while (i5 != 0) {
                int iO = compositeDecoderB.o(descriptor2);
                int i7 = i4;
                if (iO == -1) {
                    i4 = i7;
                    i5 = i4;
                } else if (iO != 0) {
                    if (iO == 1) {
                        publishedWorkflow3 = (PublishedWorkflow) compositeDecoderB.n(descriptor2, 1, PublishedWorkflow$$serializer.INSTANCE, publishedWorkflow3);
                        i6 |= 2;
                    } else if (iO == 2) {
                        str5 = (String) compositeDecoderB.n(descriptor2, 2, StringSerializer.f142891a, str5);
                        i6 |= 4;
                    } else if (iO == 3) {
                        str6 = (String) compositeDecoderB.n(descriptor2, 3, StringSerializer.f142891a, str6);
                        i6 |= 8;
                    } else {
                        if (iO != 4) {
                            throw new UnknownFieldException(iO);
                        }
                        map2 = (Map) compositeDecoderB.n(descriptor2, 4, kSerializerArr[4], map2);
                        i6 |= 16;
                    }
                    i4 = i7;
                } else {
                    workflowResponseAction2 = (WorkflowResponseAction) compositeDecoderB.y(descriptor2, i7, kSerializerArr[i7], workflowResponseAction2);
                    i6 |= 1;
                    i4 = i7;
                }
            }
            i3 = i6;
            workflowResponseAction = workflowResponseAction2;
            publishedWorkflow = publishedWorkflow3;
            str = str5;
            str2 = str6;
            map = map2;
        }
        compositeDecoderB.c(descriptor2);
        return new WorkflowDetailResponse(i3, workflowResponseAction, publishedWorkflow, str, str2, map, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, WorkflowDetailResponse value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderB = encoder.b(descriptor2);
        WorkflowDetailResponse.write$Self$purchases_defaultsBc8Release(value, compositeEncoderB, descriptor2);
        compositeEncoderB.c(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
