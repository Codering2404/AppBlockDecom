package com.superwall.sdk.models.assignment;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
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
public final class Assignment {
    public static final Companion Companion = new Companion(null);
    private String experimentId;
    private String variantId;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<Assignment> serializer() {
            return Assignment$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ Assignment(int i3, String str, String str2, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (i3 & 3)) {
            PluginExceptionsKt.b(i3, 3, Assignment$$serializer.INSTANCE.getDescriptor());
        }
        this.experimentId = str;
        this.variantId = str2;
    }

    public static /* synthetic */ Assignment copy$default(Assignment assignment, String str, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = assignment.experimentId;
        }
        if ((i3 & 2) != 0) {
            str2 = assignment.variantId;
        }
        return assignment.copy(str, str2);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$superwall_release(Assignment assignment, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        compositeEncoder.y(serialDescriptor, 0, assignment.experimentId);
        compositeEncoder.y(serialDescriptor, 1, assignment.variantId);
    }

    public final String component1() {
        return this.experimentId;
    }

    public final String component2() {
        return this.variantId;
    }

    public final Assignment copy(String experimentId, String variantId) {
        Intrinsics.checkNotNullParameter(experimentId, "experimentId");
        Intrinsics.checkNotNullParameter(variantId, "variantId");
        return new Assignment(experimentId, variantId);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Assignment)) {
            return false;
        }
        Assignment assignment = (Assignment) obj;
        return Intrinsics.areEqual(this.experimentId, assignment.experimentId) && Intrinsics.areEqual(this.variantId, assignment.variantId);
    }

    public final String getExperimentId() {
        return this.experimentId;
    }

    public final String getVariantId() {
        return this.variantId;
    }

    public int hashCode() {
        return (this.experimentId.hashCode() * 31) + this.variantId.hashCode();
    }

    public final void setExperimentId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.experimentId = str;
    }

    public final void setVariantId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.variantId = str;
    }

    public String toString() {
        return "Assignment(experimentId=" + this.experimentId + ", variantId=" + this.variantId + ")";
    }

    public Assignment(String experimentId, String variantId) {
        Intrinsics.checkNotNullParameter(experimentId, "experimentId");
        Intrinsics.checkNotNullParameter(variantId, "variantId");
        this.experimentId = experimentId;
        this.variantId = variantId;
    }
}
