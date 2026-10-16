package com.revenuecat.purchases.common.workflows;

import com.revenuecat.purchases.UiConfig;
import com.revenuecat.purchases.UiConfig$$serializer;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.revenuecat.purchases.utils.serializers.JsonObjectToMapSerializer;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
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
public final class PublishedWorkflow {
    private static final KSerializer<Object>[] $childSerializers;
    public static final Companion Companion = new Companion(null);
    private final String displayName;
    private final String hash;
    private final String id;
    private final String initialStepId;
    private final Map<String, Object> metadata;
    private final Map<String, WorkflowScreen> screens;
    private final Map<String, WorkflowStep> steps;
    private final UiConfig uiConfig;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<PublishedWorkflow> serializer() {
            return PublishedWorkflow$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    static {
        StringSerializer stringSerializer = StringSerializer.f142891a;
        $childSerializers = new KSerializer[]{null, null, null, new LinkedHashMapSerializer(stringSerializer, WorkflowStep$$serializer.INSTANCE), new LinkedHashMapSerializer(stringSerializer, WorkflowScreen$$serializer.INSTANCE), null, null, null};
    }

    @Deprecated
    public /* synthetic */ PublishedWorkflow(int i3, String str, @SerialName String str2, @SerialName String str3, Map map, Map map2, @SerialName UiConfig uiConfig, @Serializable(with = JsonObjectToMapSerializer.class) Map map3, String str4, SerializationConstructorMarker serializationConstructorMarker) {
        if (63 != (i3 & 63)) {
            PluginExceptionsKt.b(i3, 63, PublishedWorkflow$$serializer.INSTANCE.getDescriptor());
        }
        this.id = str;
        this.displayName = str2;
        this.initialStepId = str3;
        this.steps = map;
        this.screens = map2;
        this.uiConfig = uiConfig;
        if ((i3 & 64) == 0) {
            this.metadata = MapsKt.emptyMap();
        } else {
            this.metadata = map3;
        }
        if ((i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) == 0) {
            this.hash = null;
        } else {
            this.hash = str4;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PublishedWorkflow copy$default(PublishedWorkflow publishedWorkflow, String str, String str2, String str3, Map map, Map map2, UiConfig uiConfig, Map map3, String str4, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = publishedWorkflow.id;
        }
        if ((i3 & 2) != 0) {
            str2 = publishedWorkflow.displayName;
        }
        if ((i3 & 4) != 0) {
            str3 = publishedWorkflow.initialStepId;
        }
        if ((i3 & 8) != 0) {
            map = publishedWorkflow.steps;
        }
        if ((i3 & 16) != 0) {
            map2 = publishedWorkflow.screens;
        }
        if ((i3 & 32) != 0) {
            uiConfig = publishedWorkflow.uiConfig;
        }
        if ((i3 & 64) != 0) {
            map3 = publishedWorkflow.metadata;
        }
        if ((i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0) {
            str4 = publishedWorkflow.hash;
        }
        Map map4 = map3;
        String str5 = str4;
        Map map5 = map2;
        UiConfig uiConfig2 = uiConfig;
        return publishedWorkflow.copy(str, str2, str3, map, map5, uiConfig2, map4, str5);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(PublishedWorkflow publishedWorkflow, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        compositeEncoder.y(serialDescriptor, 0, publishedWorkflow.id);
        compositeEncoder.y(serialDescriptor, 1, publishedWorkflow.displayName);
        compositeEncoder.y(serialDescriptor, 2, publishedWorkflow.initialStepId);
        compositeEncoder.C(serialDescriptor, 3, kSerializerArr[3], publishedWorkflow.steps);
        compositeEncoder.C(serialDescriptor, 4, kSerializerArr[4], publishedWorkflow.screens);
        compositeEncoder.C(serialDescriptor, 5, UiConfig$$serializer.INSTANCE, publishedWorkflow.uiConfig);
        if (compositeEncoder.z(serialDescriptor, 6) || !Intrinsics.areEqual(publishedWorkflow.metadata, MapsKt.emptyMap())) {
            compositeEncoder.C(serialDescriptor, 6, JsonObjectToMapSerializer.INSTANCE, publishedWorkflow.metadata);
        }
        if (!compositeEncoder.z(serialDescriptor, 7) && publishedWorkflow.hash == null) {
            return;
        }
        compositeEncoder.i(serialDescriptor, 7, StringSerializer.f142891a, publishedWorkflow.hash);
    }

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.displayName;
    }

    public final String component3() {
        return this.initialStepId;
    }

    public final Map<String, WorkflowStep> component4() {
        return this.steps;
    }

    public final Map<String, WorkflowScreen> component5() {
        return this.screens;
    }

    public final UiConfig component6() {
        return this.uiConfig;
    }

    public final Map<String, Object> component7() {
        return this.metadata;
    }

    public final String component8() {
        return this.hash;
    }

    public final PublishedWorkflow copy(String id, String displayName, String initialStepId, Map<String, WorkflowStep> steps, Map<String, WorkflowScreen> screens, UiConfig uiConfig, Map<String, ? extends Object> metadata, String str) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(displayName, "displayName");
        Intrinsics.checkNotNullParameter(initialStepId, "initialStepId");
        Intrinsics.checkNotNullParameter(steps, "steps");
        Intrinsics.checkNotNullParameter(screens, "screens");
        Intrinsics.checkNotNullParameter(uiConfig, "uiConfig");
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        return new PublishedWorkflow(id, displayName, initialStepId, steps, screens, uiConfig, metadata, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PublishedWorkflow)) {
            return false;
        }
        PublishedWorkflow publishedWorkflow = (PublishedWorkflow) obj;
        return Intrinsics.areEqual(this.id, publishedWorkflow.id) && Intrinsics.areEqual(this.displayName, publishedWorkflow.displayName) && Intrinsics.areEqual(this.initialStepId, publishedWorkflow.initialStepId) && Intrinsics.areEqual(this.steps, publishedWorkflow.steps) && Intrinsics.areEqual(this.screens, publishedWorkflow.screens) && Intrinsics.areEqual(this.uiConfig, publishedWorkflow.uiConfig) && Intrinsics.areEqual(this.metadata, publishedWorkflow.metadata) && Intrinsics.areEqual(this.hash, publishedWorkflow.hash);
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final String getHash() {
        return this.hash;
    }

    public final String getId() {
        return this.id;
    }

    public final String getInitialStepId() {
        return this.initialStepId;
    }

    public final Map<String, Object> getMetadata() {
        return this.metadata;
    }

    public final Map<String, WorkflowScreen> getScreens() {
        return this.screens;
    }

    public final Map<String, WorkflowStep> getSteps() {
        return this.steps;
    }

    public final UiConfig getUiConfig() {
        return this.uiConfig;
    }

    public int hashCode() {
        int iHashCode = ((((((((((((this.id.hashCode() * 31) + this.displayName.hashCode()) * 31) + this.initialStepId.hashCode()) * 31) + this.steps.hashCode()) * 31) + this.screens.hashCode()) * 31) + this.uiConfig.hashCode()) * 31) + this.metadata.hashCode()) * 31;
        String str = this.hash;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "PublishedWorkflow(id=" + this.id + ", displayName=" + this.displayName + ", initialStepId=" + this.initialStepId + ", steps=" + this.steps + ", screens=" + this.screens + ", uiConfig=" + this.uiConfig + ", metadata=" + this.metadata + ", hash=" + this.hash + ')';
    }

    public PublishedWorkflow(String id, String displayName, String initialStepId, Map<String, WorkflowStep> steps, Map<String, WorkflowScreen> screens, UiConfig uiConfig, Map<String, ? extends Object> metadata, String str) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(displayName, "displayName");
        Intrinsics.checkNotNullParameter(initialStepId, "initialStepId");
        Intrinsics.checkNotNullParameter(steps, "steps");
        Intrinsics.checkNotNullParameter(screens, "screens");
        Intrinsics.checkNotNullParameter(uiConfig, "uiConfig");
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        this.id = id;
        this.displayName = displayName;
        this.initialStepId = initialStepId;
        this.steps = steps;
        this.screens = screens;
        this.uiConfig = uiConfig;
        this.metadata = metadata;
        this.hash = str;
    }

    public /* synthetic */ PublishedWorkflow(String str, String str2, String str3, Map map, Map map2, UiConfig uiConfig, Map map3, String str4, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, map, map2, uiConfig, (i3 & 64) != 0 ? MapsKt.emptyMap() : map3, (i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? null : str4);
    }

    @SerialName
    public static /* synthetic */ void getDisplayName$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getInitialStepId$annotations() {
    }

    @Serializable(with = JsonObjectToMapSerializer.class)
    public static /* synthetic */ void getMetadata$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getUiConfig$annotations() {
    }
}
