package com.revenuecat.purchases.common.workflows;

import com.revenuecat.purchases.JsonTools;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.Json;

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
public final class WorkflowJsonParser {
    public static final WorkflowJsonParser INSTANCE = new WorkflowJsonParser();

    private WorkflowJsonParser() {
    }

    public final PublishedWorkflow parsePublishedWorkflow(String payload) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        Json json = JsonTools.INSTANCE.getJson();
        json.a();
        return (PublishedWorkflow) json.d(PublishedWorkflow.Companion.serializer(), payload);
    }

    public final WorkflowDetailResponse parseWorkflowDetailResponse(String payload) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        Json json = JsonTools.INSTANCE.getJson();
        json.a();
        return (WorkflowDetailResponse) json.d(WorkflowDetailResponse.Companion.serializer(), payload);
    }
}
