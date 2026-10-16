package cz.mobilesoft.coreblock.rest.response;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Date;
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
public final class CurrentCampaignResponse implements Serializable {
    public static final int $stable = 8;

    @SerializedName("endDate")
    private final Date expirationTime;

    @SerializedName("id")
    private final long id;

    public CurrentCampaignResponse(long j3, Date expirationTime) {
        Intrinsics.checkNotNullParameter(expirationTime, "expirationTime");
        this.id = j3;
        this.expirationTime = expirationTime;
    }

    public static /* synthetic */ CurrentCampaignResponse copy$default(CurrentCampaignResponse currentCampaignResponse, long j3, Date date, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = currentCampaignResponse.id;
        }
        if ((i3 & 2) != 0) {
            date = currentCampaignResponse.expirationTime;
        }
        return currentCampaignResponse.copy(j3, date);
    }

    public final long component1() {
        return this.id;
    }

    public final Date component2() {
        return this.expirationTime;
    }

    public final CurrentCampaignResponse copy(long j3, Date expirationTime) {
        Intrinsics.checkNotNullParameter(expirationTime, "expirationTime");
        return new CurrentCampaignResponse(j3, expirationTime);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CurrentCampaignResponse)) {
            return false;
        }
        CurrentCampaignResponse currentCampaignResponse = (CurrentCampaignResponse) obj;
        return this.id == currentCampaignResponse.id && Intrinsics.areEqual(this.expirationTime, currentCampaignResponse.expirationTime);
    }

    public final Date getExpirationTime() {
        return this.expirationTime;
    }

    public final long getId() {
        return this.id;
    }

    public int hashCode() {
        return (Long.hashCode(this.id) * 31) + this.expirationTime.hashCode();
    }

    public String toString() {
        return "CurrentCampaignResponse(id=" + this.id + ", expirationTime=" + this.expirationTime + ")";
    }
}
