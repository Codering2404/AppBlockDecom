package com.superwall.sdk.models.assignment;

import com.superwall.sdk.models.triggers.Experiment;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class ConfirmableAssignment {
    private final String experimentId;
    private final Experiment.Variant variant;

    public ConfirmableAssignment(String experimentId, Experiment.Variant variant) {
        Intrinsics.checkNotNullParameter(experimentId, "experimentId");
        Intrinsics.checkNotNullParameter(variant, "variant");
        this.experimentId = experimentId;
        this.variant = variant;
    }

    public static /* synthetic */ ConfirmableAssignment copy$default(ConfirmableAssignment confirmableAssignment, String str, Experiment.Variant variant, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = confirmableAssignment.experimentId;
        }
        if ((i3 & 2) != 0) {
            variant = confirmableAssignment.variant;
        }
        return confirmableAssignment.copy(str, variant);
    }

    public final String component1() {
        return this.experimentId;
    }

    public final Experiment.Variant component2() {
        return this.variant;
    }

    public final ConfirmableAssignment copy(String experimentId, Experiment.Variant variant) {
        Intrinsics.checkNotNullParameter(experimentId, "experimentId");
        Intrinsics.checkNotNullParameter(variant, "variant");
        return new ConfirmableAssignment(experimentId, variant);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConfirmableAssignment)) {
            return false;
        }
        ConfirmableAssignment confirmableAssignment = (ConfirmableAssignment) obj;
        return Intrinsics.areEqual(this.experimentId, confirmableAssignment.experimentId) && Intrinsics.areEqual(this.variant, confirmableAssignment.variant);
    }

    public final String getExperimentId() {
        return this.experimentId;
    }

    public final Experiment.Variant getVariant() {
        return this.variant;
    }

    public int hashCode() {
        return (this.experimentId.hashCode() * 31) + this.variant.hashCode();
    }

    public String toString() {
        return "ConfirmableAssignment(experimentId=" + this.experimentId + ", variant=" + this.variant + ")";
    }
}
