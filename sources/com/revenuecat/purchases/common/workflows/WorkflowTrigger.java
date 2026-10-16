package com.revenuecat.purchases.common.workflows;

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
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

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
public final class WorkflowTrigger {
    public static final Companion Companion = new Companion(null);
    private final String actionId;
    private final String componentId;
    private final String name;
    private final WorkflowTriggerType type;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<WorkflowTrigger> serializer() {
            return WorkflowTrigger$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    @Deprecated
    public /* synthetic */ WorkflowTrigger(int i3, String str, WorkflowTriggerType workflowTriggerType, @SerialName String str2, @SerialName String str3, SerializationConstructorMarker serializationConstructorMarker) {
        if (15 != (i3 & 15)) {
            PluginExceptionsKt.b(i3, 15, WorkflowTrigger$$serializer.INSTANCE.getDescriptor());
        }
        this.name = str;
        this.type = workflowTriggerType;
        this.actionId = str2;
        this.componentId = str3;
    }

    public static /* synthetic */ WorkflowTrigger copy$default(WorkflowTrigger workflowTrigger, String str, WorkflowTriggerType workflowTriggerType, String str2, String str3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = workflowTrigger.name;
        }
        if ((i3 & 2) != 0) {
            workflowTriggerType = workflowTrigger.type;
        }
        if ((i3 & 4) != 0) {
            str2 = workflowTrigger.actionId;
        }
        if ((i3 & 8) != 0) {
            str3 = workflowTrigger.componentId;
        }
        return workflowTrigger.copy(str, workflowTriggerType, str2, str3);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(WorkflowTrigger workflowTrigger, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        compositeEncoder.y(serialDescriptor, 0, workflowTrigger.name);
        compositeEncoder.C(serialDescriptor, 1, WorkflowTriggerTypeDeserializer.INSTANCE, workflowTrigger.type);
        compositeEncoder.y(serialDescriptor, 2, workflowTrigger.actionId);
        compositeEncoder.y(serialDescriptor, 3, workflowTrigger.componentId);
    }

    public final String component1() {
        return this.name;
    }

    public final WorkflowTriggerType component2() {
        return this.type;
    }

    public final String component3() {
        return this.actionId;
    }

    public final String component4() {
        return this.componentId;
    }

    public final WorkflowTrigger copy(String name, WorkflowTriggerType type, String actionId, String componentId) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(actionId, "actionId");
        Intrinsics.checkNotNullParameter(componentId, "componentId");
        return new WorkflowTrigger(name, type, actionId, componentId);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WorkflowTrigger)) {
            return false;
        }
        WorkflowTrigger workflowTrigger = (WorkflowTrigger) obj;
        return Intrinsics.areEqual(this.name, workflowTrigger.name) && this.type == workflowTrigger.type && Intrinsics.areEqual(this.actionId, workflowTrigger.actionId) && Intrinsics.areEqual(this.componentId, workflowTrigger.componentId);
    }

    public final String getActionId() {
        return this.actionId;
    }

    public final String getComponentId() {
        return this.componentId;
    }

    public final String getName() {
        return this.name;
    }

    public final WorkflowTriggerType getType() {
        return this.type;
    }

    public int hashCode() {
        return (((((this.name.hashCode() * 31) + this.type.hashCode()) * 31) + this.actionId.hashCode()) * 31) + this.componentId.hashCode();
    }

    public String toString() {
        return "WorkflowTrigger(name=" + this.name + ", type=" + this.type + ", actionId=" + this.actionId + ", componentId=" + this.componentId + ')';
    }

    public WorkflowTrigger(String name, WorkflowTriggerType type, String actionId, String componentId) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(actionId, "actionId");
        Intrinsics.checkNotNullParameter(componentId, "componentId");
        this.name = name;
        this.type = type;
        this.actionId = actionId;
        this.componentId = componentId;
    }

    @SerialName
    public static /* synthetic */ void getActionId$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getComponentId$annotations() {
    }
}
