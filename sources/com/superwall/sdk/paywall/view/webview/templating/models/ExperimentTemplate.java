package com.superwall.sdk.paywall.view.webview.templating.models;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@Serializable
public final class ExperimentTemplate {
    public static final Companion Companion = new Companion(null);
    private final String campaignId;
    private final String eventName;
    private final String experimentId;
    private final String variantId;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<ExperimentTemplate> serializer() {
            return ExperimentTemplate$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ ExperimentTemplate(int i3, String str, String str2, String str3, String str4, SerializationConstructorMarker serializationConstructorMarker) {
        if (14 != (i3 & 14)) {
            PluginExceptionsKt.b(i3, 14, ExperimentTemplate$$serializer.INSTANCE.getDescriptor());
        }
        if ((i3 & 1) == 0) {
            this.eventName = "experiment";
        } else {
            this.eventName = str;
        }
        this.experimentId = str2;
        this.variantId = str3;
        this.campaignId = str4;
    }

    public static /* synthetic */ ExperimentTemplate copy$default(ExperimentTemplate experimentTemplate, String str, String str2, String str3, String str4, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = experimentTemplate.eventName;
        }
        if ((i3 & 2) != 0) {
            str2 = experimentTemplate.experimentId;
        }
        if ((i3 & 4) != 0) {
            str3 = experimentTemplate.variantId;
        }
        if ((i3 & 8) != 0) {
            str4 = experimentTemplate.campaignId;
        }
        return experimentTemplate.copy(str, str2, str3, str4);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$superwall_release(ExperimentTemplate experimentTemplate, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        if (compositeEncoder.z(serialDescriptor, 0) || !Intrinsics.areEqual(experimentTemplate.eventName, "experiment")) {
            compositeEncoder.y(serialDescriptor, 0, experimentTemplate.eventName);
        }
        compositeEncoder.y(serialDescriptor, 1, experimentTemplate.experimentId);
        compositeEncoder.y(serialDescriptor, 2, experimentTemplate.variantId);
        compositeEncoder.y(serialDescriptor, 3, experimentTemplate.campaignId);
    }

    public final String component1() {
        return this.eventName;
    }

    public final String component2() {
        return this.experimentId;
    }

    public final String component3() {
        return this.variantId;
    }

    public final String component4() {
        return this.campaignId;
    }

    public final ExperimentTemplate copy(String eventName, String experimentId, String variantId, String campaignId) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(experimentId, "experimentId");
        Intrinsics.checkNotNullParameter(variantId, "variantId");
        Intrinsics.checkNotNullParameter(campaignId, "campaignId");
        return new ExperimentTemplate(eventName, experimentId, variantId, campaignId);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ExperimentTemplate)) {
            return false;
        }
        ExperimentTemplate experimentTemplate = (ExperimentTemplate) obj;
        return Intrinsics.areEqual(this.eventName, experimentTemplate.eventName) && Intrinsics.areEqual(this.experimentId, experimentTemplate.experimentId) && Intrinsics.areEqual(this.variantId, experimentTemplate.variantId) && Intrinsics.areEqual(this.campaignId, experimentTemplate.campaignId);
    }

    public final String getCampaignId() {
        return this.campaignId;
    }

    public final String getEventName() {
        return this.eventName;
    }

    public final String getExperimentId() {
        return this.experimentId;
    }

    public final String getVariantId() {
        return this.variantId;
    }

    public int hashCode() {
        return (((((this.eventName.hashCode() * 31) + this.experimentId.hashCode()) * 31) + this.variantId.hashCode()) * 31) + this.campaignId.hashCode();
    }

    public String toString() {
        return "ExperimentTemplate(eventName=" + this.eventName + ", experimentId=" + this.experimentId + ", variantId=" + this.variantId + ", campaignId=" + this.campaignId + ")";
    }

    public ExperimentTemplate(String eventName, String experimentId, String variantId, String campaignId) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(experimentId, "experimentId");
        Intrinsics.checkNotNullParameter(variantId, "variantId");
        Intrinsics.checkNotNullParameter(campaignId, "campaignId");
        this.eventName = eventName;
        this.experimentId = experimentId;
        this.variantId = variantId;
        this.campaignId = campaignId;
    }

    public /* synthetic */ ExperimentTemplate(String str, String str2, String str3, String str4, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "experiment" : str, str2, str3, str4);
    }

    @SerialName
    public static /* synthetic */ void getCampaignId$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getEventName$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getExperimentId$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getVariantId$annotations() {
    }
}
