package com.revenuecat.purchases.common.workflows;

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
/* JADX INFO: loaded from: classes5.dex */
@Metadata
@Deprecated
public final class WorkflowTrigger$$serializer implements GeneratedSerializer<WorkflowTrigger> {
    public static final WorkflowTrigger$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        WorkflowTrigger$$serializer workflowTrigger$$serializer = new WorkflowTrigger$$serializer();
        INSTANCE = workflowTrigger$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.common.workflows.WorkflowTrigger", workflowTrigger$$serializer, 4);
        pluginGeneratedSerialDescriptor.p("name", false);
        pluginGeneratedSerialDescriptor.p("type", false);
        pluginGeneratedSerialDescriptor.p("action_id", false);
        pluginGeneratedSerialDescriptor.p("component_id", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private WorkflowTrigger$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        StringSerializer stringSerializer = StringSerializer.f142891a;
        return new KSerializer[]{stringSerializer, WorkflowTriggerTypeDeserializer.INSTANCE, stringSerializer, stringSerializer};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public WorkflowTrigger deserialize(Decoder decoder) {
        int i3;
        String str;
        WorkflowTriggerType workflowTriggerType;
        String str2;
        String strM;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderB = decoder.b(descriptor2);
        String strM2 = null;
        if (compositeDecoderB.p()) {
            String strM3 = compositeDecoderB.m(descriptor2, 0);
            WorkflowTriggerType workflowTriggerType2 = (WorkflowTriggerType) compositeDecoderB.y(descriptor2, 1, WorkflowTriggerTypeDeserializer.INSTANCE, null);
            String strM4 = compositeDecoderB.m(descriptor2, 2);
            str = strM3;
            strM = compositeDecoderB.m(descriptor2, 3);
            str2 = strM4;
            workflowTriggerType = workflowTriggerType2;
            i3 = 15;
        } else {
            boolean z2 = true;
            int i4 = 0;
            WorkflowTriggerType workflowTriggerType3 = null;
            String strM5 = null;
            String strM6 = null;
            while (z2) {
                int iO = compositeDecoderB.o(descriptor2);
                if (iO == -1) {
                    z2 = false;
                } else if (iO == 0) {
                    strM2 = compositeDecoderB.m(descriptor2, 0);
                    i4 |= 1;
                } else if (iO == 1) {
                    workflowTriggerType3 = (WorkflowTriggerType) compositeDecoderB.y(descriptor2, 1, WorkflowTriggerTypeDeserializer.INSTANCE, workflowTriggerType3);
                    i4 |= 2;
                } else if (iO == 2) {
                    strM5 = compositeDecoderB.m(descriptor2, 2);
                    i4 |= 4;
                } else {
                    if (iO != 3) {
                        throw new UnknownFieldException(iO);
                    }
                    strM6 = compositeDecoderB.m(descriptor2, 3);
                    i4 |= 8;
                }
            }
            i3 = i4;
            str = strM2;
            workflowTriggerType = workflowTriggerType3;
            str2 = strM5;
            strM = strM6;
        }
        compositeDecoderB.c(descriptor2);
        return new WorkflowTrigger(i3, str, workflowTriggerType, str2, strM, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, WorkflowTrigger value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderB = encoder.b(descriptor2);
        WorkflowTrigger.write$Self$purchases_defaultsBc8Release(value, compositeEncoderB, descriptor2);
        compositeEncoderB.c(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
