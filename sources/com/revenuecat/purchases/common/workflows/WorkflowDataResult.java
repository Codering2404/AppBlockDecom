package com.revenuecat.purchases.common.workflows;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

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
public final class WorkflowDataResult {
    private final Map<String, String> enrolledVariants;
    private final PublishedWorkflow workflow;

    public WorkflowDataResult(PublishedWorkflow workflow, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(workflow, "workflow");
        this.workflow = workflow;
        this.enrolledVariants = map;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WorkflowDataResult copy$default(WorkflowDataResult workflowDataResult, PublishedWorkflow publishedWorkflow, Map map, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            publishedWorkflow = workflowDataResult.workflow;
        }
        if ((i3 & 2) != 0) {
            map = workflowDataResult.enrolledVariants;
        }
        return workflowDataResult.copy(publishedWorkflow, map);
    }

    public final PublishedWorkflow component1() {
        return this.workflow;
    }

    public final Map<String, String> component2() {
        return this.enrolledVariants;
    }

    public final WorkflowDataResult copy(PublishedWorkflow workflow, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(workflow, "workflow");
        return new WorkflowDataResult(workflow, map);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WorkflowDataResult)) {
            return false;
        }
        WorkflowDataResult workflowDataResult = (WorkflowDataResult) obj;
        return Intrinsics.areEqual(this.workflow, workflowDataResult.workflow) && Intrinsics.areEqual(this.enrolledVariants, workflowDataResult.enrolledVariants);
    }

    public final Map<String, String> getEnrolledVariants() {
        return this.enrolledVariants;
    }

    public final PublishedWorkflow getWorkflow() {
        return this.workflow;
    }

    public int hashCode() {
        int iHashCode = this.workflow.hashCode() * 31;
        Map<String, String> map = this.enrolledVariants;
        return iHashCode + (map == null ? 0 : map.hashCode());
    }

    public String toString() {
        return "WorkflowDataResult(workflow=" + this.workflow + ", enrolledVariants=" + this.enrolledVariants + ')';
    }
}
