package com.superwall.sdk.models.assignment;

import com.superwall.sdk.models.SerializableEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.ArrayListSerializer;
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
public final class ConfirmedAssignmentResponse implements SerializableEntity {
    private final List<Assignment> assignments;
    public static final Companion Companion = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {new ArrayListSerializer(Assignment$$serializer.INSTANCE)};

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<ConfirmedAssignmentResponse> serializer() {
            return ConfirmedAssignmentResponse$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ ConfirmedAssignmentResponse(int i3, List list, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (i3 & 1)) {
            PluginExceptionsKt.b(i3, 1, ConfirmedAssignmentResponse$$serializer.INSTANCE.getDescriptor());
        }
        this.assignments = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ConfirmedAssignmentResponse copy$default(ConfirmedAssignmentResponse confirmedAssignmentResponse, List list, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            list = confirmedAssignmentResponse.assignments;
        }
        return confirmedAssignmentResponse.copy(list);
    }

    public final List<Assignment> component1() {
        return this.assignments;
    }

    public final ConfirmedAssignmentResponse copy(List<Assignment> assignments) {
        Intrinsics.checkNotNullParameter(assignments, "assignments");
        return new ConfirmedAssignmentResponse(assignments);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ConfirmedAssignmentResponse) && Intrinsics.areEqual(this.assignments, ((ConfirmedAssignmentResponse) obj).assignments);
    }

    public final List<Assignment> getAssignments() {
        return this.assignments;
    }

    public int hashCode() {
        return this.assignments.hashCode();
    }

    public String toString() {
        return "ConfirmedAssignmentResponse(assignments=" + this.assignments + ")";
    }

    public ConfirmedAssignmentResponse(List<Assignment> assignments) {
        Intrinsics.checkNotNullParameter(assignments, "assignments");
        this.assignments = assignments;
    }
}
