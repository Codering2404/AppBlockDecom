package com.revenuecat.purchases.common.workflows;

import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
@Metadata
@Serializable
public final class WorkflowStep {
    private static final KSerializer<Object>[] $childSerializers;
    public static final Companion Companion = new Companion(null);
    private final String id;
    private final JsonElement metadata;
    private final Map<String, JsonElement> outputs;
    private final Map<String, JsonElement> paramValues;
    private final String screenId;
    private final Map<String, WorkflowTriggerAction> triggerActions;
    private final List<WorkflowTrigger> triggers;
    private final String type;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<WorkflowStep> serializer() {
            return WorkflowStep$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    static {
        StringSerializer stringSerializer = StringSerializer.f142891a;
        JsonElementSerializer jsonElementSerializer = JsonElementSerializer.f143009a;
        $childSerializers = new KSerializer[]{null, null, null, new LinkedHashMapSerializer(stringSerializer, jsonElementSerializer), new ArrayListSerializer(WorkflowTrigger$$serializer.INSTANCE), new LinkedHashMapSerializer(stringSerializer, jsonElementSerializer), new LinkedHashMapSerializer(stringSerializer, WorkflowTriggerActionSerializer.INSTANCE), null};
    }

    @Deprecated
    public /* synthetic */ WorkflowStep(int i3, String str, String str2, @SerialName String str3, @SerialName Map map, List list, Map map2, @SerialName Map map3, JsonElement jsonElement, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (i3 & 3)) {
            PluginExceptionsKt.b(i3, 3, WorkflowStep$$serializer.INSTANCE.getDescriptor());
        }
        this.id = str;
        this.type = str2;
        if ((i3 & 4) == 0) {
            this.screenId = null;
        } else {
            this.screenId = str3;
        }
        if ((i3 & 8) == 0) {
            this.paramValues = MapsKt.emptyMap();
        } else {
            this.paramValues = map;
        }
        if ((i3 & 16) == 0) {
            this.triggers = CollectionsKt.emptyList();
        } else {
            this.triggers = list;
        }
        if ((i3 & 32) == 0) {
            this.outputs = MapsKt.emptyMap();
        } else {
            this.outputs = map2;
        }
        if ((i3 & 64) == 0) {
            this.triggerActions = MapsKt.emptyMap();
        } else {
            this.triggerActions = map3;
        }
        if ((i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) == 0) {
            this.metadata = null;
        } else {
            this.metadata = jsonElement;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WorkflowStep copy$default(WorkflowStep workflowStep, String str, String str2, String str3, Map map, List list, Map map2, Map map3, JsonElement jsonElement, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = workflowStep.id;
        }
        if ((i3 & 2) != 0) {
            str2 = workflowStep.type;
        }
        if ((i3 & 4) != 0) {
            str3 = workflowStep.screenId;
        }
        if ((i3 & 8) != 0) {
            map = workflowStep.paramValues;
        }
        if ((i3 & 16) != 0) {
            list = workflowStep.triggers;
        }
        if ((i3 & 32) != 0) {
            map2 = workflowStep.outputs;
        }
        if ((i3 & 64) != 0) {
            map3 = workflowStep.triggerActions;
        }
        if ((i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0) {
            jsonElement = workflowStep.metadata;
        }
        Map map4 = map3;
        JsonElement jsonElement2 = jsonElement;
        List list2 = list;
        Map map5 = map2;
        return workflowStep.copy(str, str2, str3, map, list2, map5, map4, jsonElement2);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(WorkflowStep workflowStep, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        compositeEncoder.y(serialDescriptor, 0, workflowStep.id);
        compositeEncoder.y(serialDescriptor, 1, workflowStep.type);
        if (compositeEncoder.z(serialDescriptor, 2) || workflowStep.screenId != null) {
            compositeEncoder.i(serialDescriptor, 2, StringSerializer.f142891a, workflowStep.screenId);
        }
        if (compositeEncoder.z(serialDescriptor, 3) || !Intrinsics.areEqual(workflowStep.paramValues, MapsKt.emptyMap())) {
            compositeEncoder.C(serialDescriptor, 3, kSerializerArr[3], workflowStep.paramValues);
        }
        if (compositeEncoder.z(serialDescriptor, 4) || !Intrinsics.areEqual(workflowStep.triggers, CollectionsKt.emptyList())) {
            compositeEncoder.C(serialDescriptor, 4, kSerializerArr[4], workflowStep.triggers);
        }
        if (compositeEncoder.z(serialDescriptor, 5) || !Intrinsics.areEqual(workflowStep.outputs, MapsKt.emptyMap())) {
            compositeEncoder.C(serialDescriptor, 5, kSerializerArr[5], workflowStep.outputs);
        }
        if (compositeEncoder.z(serialDescriptor, 6) || !Intrinsics.areEqual(workflowStep.triggerActions, MapsKt.emptyMap())) {
            compositeEncoder.C(serialDescriptor, 6, kSerializerArr[6], workflowStep.triggerActions);
        }
        if (!compositeEncoder.z(serialDescriptor, 7) && workflowStep.metadata == null) {
            return;
        }
        compositeEncoder.i(serialDescriptor, 7, JsonElementSerializer.f143009a, workflowStep.metadata);
    }

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.type;
    }

    public final String component3() {
        return this.screenId;
    }

    public final Map<String, JsonElement> component4() {
        return this.paramValues;
    }

    public final List<WorkflowTrigger> component5() {
        return this.triggers;
    }

    public final Map<String, JsonElement> component6() {
        return this.outputs;
    }

    public final Map<String, WorkflowTriggerAction> component7() {
        return this.triggerActions;
    }

    public final JsonElement component8() {
        return this.metadata;
    }

    public final WorkflowStep copy(String id, String type, String str, Map<String, ? extends JsonElement> paramValues, List<WorkflowTrigger> triggers, Map<String, ? extends JsonElement> outputs, Map<String, ? extends WorkflowTriggerAction> triggerActions, JsonElement jsonElement) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(paramValues, "paramValues");
        Intrinsics.checkNotNullParameter(triggers, "triggers");
        Intrinsics.checkNotNullParameter(outputs, "outputs");
        Intrinsics.checkNotNullParameter(triggerActions, "triggerActions");
        return new WorkflowStep(id, type, str, paramValues, triggers, outputs, triggerActions, jsonElement);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WorkflowStep)) {
            return false;
        }
        WorkflowStep workflowStep = (WorkflowStep) obj;
        return Intrinsics.areEqual(this.id, workflowStep.id) && Intrinsics.areEqual(this.type, workflowStep.type) && Intrinsics.areEqual(this.screenId, workflowStep.screenId) && Intrinsics.areEqual(this.paramValues, workflowStep.paramValues) && Intrinsics.areEqual(this.triggers, workflowStep.triggers) && Intrinsics.areEqual(this.outputs, workflowStep.outputs) && Intrinsics.areEqual(this.triggerActions, workflowStep.triggerActions) && Intrinsics.areEqual(this.metadata, workflowStep.metadata);
    }

    public final String getId() {
        return this.id;
    }

    public final JsonElement getMetadata() {
        return this.metadata;
    }

    public final Map<String, JsonElement> getOutputs() {
        return this.outputs;
    }

    public final Map<String, JsonElement> getParamValues() {
        return this.paramValues;
    }

    public final String getScreenId() {
        return this.screenId;
    }

    public final Map<String, WorkflowTriggerAction> getTriggerActions() {
        return this.triggerActions;
    }

    public final List<WorkflowTrigger> getTriggers() {
        return this.triggers;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        int iHashCode = ((this.id.hashCode() * 31) + this.type.hashCode()) * 31;
        String str = this.screenId;
        int iHashCode2 = (((((((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.paramValues.hashCode()) * 31) + this.triggers.hashCode()) * 31) + this.outputs.hashCode()) * 31) + this.triggerActions.hashCode()) * 31;
        JsonElement jsonElement = this.metadata;
        return iHashCode2 + (jsonElement != null ? jsonElement.hashCode() : 0);
    }

    public String toString() {
        return "WorkflowStep(id=" + this.id + ", type=" + this.type + ", screenId=" + this.screenId + ", paramValues=" + this.paramValues + ", triggers=" + this.triggers + ", outputs=" + this.outputs + ", triggerActions=" + this.triggerActions + ", metadata=" + this.metadata + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public WorkflowStep(String id, String type, String str, Map<String, ? extends JsonElement> paramValues, List<WorkflowTrigger> triggers, Map<String, ? extends JsonElement> outputs, Map<String, ? extends WorkflowTriggerAction> triggerActions, JsonElement jsonElement) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(paramValues, "paramValues");
        Intrinsics.checkNotNullParameter(triggers, "triggers");
        Intrinsics.checkNotNullParameter(outputs, "outputs");
        Intrinsics.checkNotNullParameter(triggerActions, "triggerActions");
        this.id = id;
        this.type = type;
        this.screenId = str;
        this.paramValues = paramValues;
        this.triggers = triggers;
        this.outputs = outputs;
        this.triggerActions = triggerActions;
        this.metadata = jsonElement;
    }

    @SerialName
    public static /* synthetic */ void getParamValues$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getScreenId$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getTriggerActions$annotations() {
    }

    public /* synthetic */ WorkflowStep(String str, String str2, String str3, Map map, List list, Map map2, Map map3, JsonElement jsonElement, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i3 & 4) != 0 ? null : str3, (i3 & 8) != 0 ? MapsKt.emptyMap() : map, (i3 & 16) != 0 ? CollectionsKt.emptyList() : list, (i3 & 32) != 0 ? MapsKt.emptyMap() : map2, (i3 & 64) != 0 ? MapsKt.emptyMap() : map3, (i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? null : jsonElement);
    }
}
