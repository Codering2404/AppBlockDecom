package cz.mobilesoft.coreblock.scene.more.backup.dto;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class ProfileIntervalDTO {

    @SerializedName("fromInMinutes")
    private final long fromInMinutes;

    @SerializedName("toInMinutes")
    private final long toInMinutes;

    public ProfileIntervalDTO(long j3, long j4) {
        this.fromInMinutes = j3;
        this.toInMinutes = j4;
    }

    public final long a() {
        return this.fromInMinutes;
    }

    public final long b() {
        return this.toInMinutes;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProfileIntervalDTO)) {
            return false;
        }
        ProfileIntervalDTO profileIntervalDTO = (ProfileIntervalDTO) obj;
        return this.fromInMinutes == profileIntervalDTO.fromInMinutes && this.toInMinutes == profileIntervalDTO.toInMinutes;
    }

    public int hashCode() {
        return (Long.hashCode(this.fromInMinutes) * 31) + Long.hashCode(this.toInMinutes);
    }

    public String toString() {
        return "ProfileIntervalDTO(fromInMinutes=" + this.fromInMinutes + ", toInMinutes=" + this.toInMinutes + ")";
    }
}
