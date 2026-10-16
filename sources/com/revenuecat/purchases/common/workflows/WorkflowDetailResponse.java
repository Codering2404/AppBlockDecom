package com.revenuecat.purchases.common.workflows;

import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
@Metadata
@Serializable
public final class WorkflowDetailResponse {
    private static final KSerializer<Object>[] $childSerializers;
    public static final Companion Companion = new Companion(null);
    private final WorkflowResponseAction action;
    private final PublishedWorkflow data;
    private final Map<String, String> enrolledVariants;
    private final String hash;
    private final String url;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<WorkflowDetailResponse> serializer() {
            return WorkflowDetailResponse$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    static {
        KSerializer<WorkflowResponseAction> kSerializerSerializer = WorkflowResponseAction.Companion.serializer();
        StringSerializer stringSerializer = StringSerializer.f142891a;
        $childSerializers = new KSerializer[]{kSerializerSerializer, null, null, null, new LinkedHashMapSerializer(stringSerializer, stringSerializer)};
    }

    @Deprecated
    public /* synthetic */ WorkflowDetailResponse(int i3, WorkflowResponseAction workflowResponseAction, PublishedWorkflow publishedWorkflow, String str, String str2, @SerialName Map map, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (i3 & 1)) {
            PluginExceptionsKt.b(i3, 1, WorkflowDetailResponse$$serializer.INSTANCE.getDescriptor());
        }
        this.action = workflowResponseAction;
        if ((i3 & 2) == 0) {
            this.data = null;
        } else {
            this.data = publishedWorkflow;
        }
        if ((i3 & 4) == 0) {
            this.url = null;
        } else {
            this.url = str;
        }
        if ((i3 & 8) == 0) {
            this.hash = null;
        } else {
            this.hash = str2;
        }
        if ((i3 & 16) == 0) {
            this.enrolledVariants = null;
        } else {
            this.enrolledVariants = map;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WorkflowDetailResponse copy$default(WorkflowDetailResponse workflowDetailResponse, WorkflowResponseAction workflowResponseAction, PublishedWorkflow publishedWorkflow, String str, String str2, Map map, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            workflowResponseAction = workflowDetailResponse.action;
        }
        if ((i3 & 2) != 0) {
            publishedWorkflow = workflowDetailResponse.data;
        }
        if ((i3 & 4) != 0) {
            str = workflowDetailResponse.url;
        }
        if ((i3 & 8) != 0) {
            str2 = workflowDetailResponse.hash;
        }
        if ((i3 & 16) != 0) {
            map = workflowDetailResponse.enrolledVariants;
        }
        Map map2 = map;
        String str3 = str;
        return workflowDetailResponse.copy(workflowResponseAction, publishedWorkflow, str3, str2, map2);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(WorkflowDetailResponse workflowDetailResponse, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        compositeEncoder.C(serialDescriptor, 0, kSerializerArr[0], workflowDetailResponse.action);
        if (compositeEncoder.z(serialDescriptor, 1) || workflowDetailResponse.data != null) {
            compositeEncoder.i(serialDescriptor, 1, PublishedWorkflow$$serializer.INSTANCE, workflowDetailResponse.data);
        }
        if (compositeEncoder.z(serialDescriptor, 2) || workflowDetailResponse.url != null) {
            compositeEncoder.i(serialDescriptor, 2, StringSerializer.f142891a, workflowDetailResponse.url);
        }
        if (compositeEncoder.z(serialDescriptor, 3) || workflowDetailResponse.hash != null) {
            compositeEncoder.i(serialDescriptor, 3, StringSerializer.f142891a, workflowDetailResponse.hash);
        }
        if (!compositeEncoder.z(serialDescriptor, 4) && workflowDetailResponse.enrolledVariants == null) {
            return;
        }
        compositeEncoder.i(serialDescriptor, 4, kSerializerArr[4], workflowDetailResponse.enrolledVariants);
    }

    public final WorkflowResponseAction component1() {
        return this.action;
    }

    public final PublishedWorkflow component2() {
        return this.data;
    }

    public final String component3() {
        return this.url;
    }

    public final String component4() {
        return this.hash;
    }

    public final Map<String, String> component5() {
        return this.enrolledVariants;
    }

    public final WorkflowDetailResponse copy(WorkflowResponseAction action, PublishedWorkflow publishedWorkflow, String str, String str2, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(action, "action");
        return new WorkflowDetailResponse(action, publishedWorkflow, str, str2, map);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WorkflowDetailResponse)) {
            return false;
        }
        WorkflowDetailResponse workflowDetailResponse = (WorkflowDetailResponse) obj;
        return this.action == workflowDetailResponse.action && Intrinsics.areEqual(this.data, workflowDetailResponse.data) && Intrinsics.areEqual(this.url, workflowDetailResponse.url) && Intrinsics.areEqual(this.hash, workflowDetailResponse.hash) && Intrinsics.areEqual(this.enrolledVariants, workflowDetailResponse.enrolledVariants);
    }

    public final WorkflowResponseAction getAction() {
        return this.action;
    }

    public final PublishedWorkflow getData() {
        return this.data;
    }

    public final Map<String, String> getEnrolledVariants() {
        return this.enrolledVariants;
    }

    public final String getHash() {
        return this.hash;
    }

    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        int iHashCode = this.action.hashCode() * 31;
        PublishedWorkflow publishedWorkflow = this.data;
        int iHashCode2 = (iHashCode + (publishedWorkflow == null ? 0 : publishedWorkflow.hashCode())) * 31;
        String str = this.url;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.hash;
        int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Map<String, String> map = this.enrolledVariants;
        return iHashCode4 + (map != null ? map.hashCode() : 0);
    }

    public String toString() {
        return "WorkflowDetailResponse(action=" + this.action + ", data=" + this.data + ", url=" + this.url + ", hash=" + this.hash + ", enrolledVariants=" + this.enrolledVariants + ')';
    }

    public WorkflowDetailResponse(WorkflowResponseAction action, PublishedWorkflow publishedWorkflow, String str, String str2, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(action, "action");
        this.action = action;
        this.data = publishedWorkflow;
        this.url = str;
        this.hash = str2;
        this.enrolledVariants = map;
    }

    public /* synthetic */ WorkflowDetailResponse(WorkflowResponseAction workflowResponseAction, PublishedWorkflow publishedWorkflow, String str, String str2, Map map, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(workflowResponseAction, (i3 & 2) != 0 ? null : publishedWorkflow, (i3 & 4) != 0 ? null : str, (i3 & 8) != 0 ? null : str2, (i3 & 16) != 0 ? null : map);
    }

    @SerialName
    public static /* synthetic */ void getEnrolledVariants$annotations() {
    }
}
