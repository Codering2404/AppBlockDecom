package com.revenuecat.purchases.common.workflows;

import com.revenuecat.purchases.common.workflows.WorkflowTriggerAction;
import com.revenuecat.purchases.utils.serializers.SealedDeserializerWithDefault;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
@Metadata
public final class WorkflowTriggerActionSerializer extends SealedDeserializerWithDefault<WorkflowTriggerAction> {
    public static final WorkflowTriggerActionSerializer INSTANCE = new WorkflowTriggerActionSerializer();

    private WorkflowTriggerActionSerializer() {
        super("WorkflowTriggerAction", MapsKt.mapOf(TuplesKt.a("step", new Function0<KSerializer<WorkflowTriggerAction.Step>>() { // from class: com.revenuecat.purchases.common.workflows.WorkflowTriggerActionSerializer.1
            @Override // kotlin.jvm.functions.Function0
            public final KSerializer<WorkflowTriggerAction.Step> invoke() {
                return WorkflowTriggerAction.Step.Companion.serializer();
            }
        })), new Function1<String, WorkflowTriggerAction>() { // from class: com.revenuecat.purchases.common.workflows.WorkflowTriggerActionSerializer.2
            @Override // kotlin.jvm.functions.Function1
            public final WorkflowTriggerAction invoke(String it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return WorkflowTriggerAction.Unknown.INSTANCE;
            }
        }, null, 8, null);
    }
}
