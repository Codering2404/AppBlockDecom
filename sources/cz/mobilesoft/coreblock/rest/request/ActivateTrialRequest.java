package cz.mobilesoft.coreblock.rest.request;

import com.google.gson.annotations.SerializedName;
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
public final class ActivateTrialRequest {
    public static final int $stable = 0;

    @SerializedName("revenueCatId")
    private final String revenueCatId;

    public ActivateTrialRequest(String revenueCatId) {
        Intrinsics.checkNotNullParameter(revenueCatId, "revenueCatId");
        this.revenueCatId = revenueCatId;
    }

    public static /* synthetic */ ActivateTrialRequest copy$default(ActivateTrialRequest activateTrialRequest, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = activateTrialRequest.revenueCatId;
        }
        return activateTrialRequest.copy(str);
    }

    public final String component1() {
        return this.revenueCatId;
    }

    public final ActivateTrialRequest copy(String revenueCatId) {
        Intrinsics.checkNotNullParameter(revenueCatId, "revenueCatId");
        return new ActivateTrialRequest(revenueCatId);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ActivateTrialRequest) && Intrinsics.areEqual(this.revenueCatId, ((ActivateTrialRequest) obj).revenueCatId);
    }

    public final String getRevenueCatId() {
        return this.revenueCatId;
    }

    public int hashCode() {
        return this.revenueCatId.hashCode();
    }

    public String toString() {
        return "ActivateTrialRequest(revenueCatId=" + this.revenueCatId + ")";
    }
}
