package cz.mobilesoft.coreblock.scene.more.backup.dto;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class BackupInfoDTO implements Serializable {

    @SerializedName("createdAt")
    private final Date createdAt;

    @SerializedName("deviceName")
    private final String deviceName;

    @SerializedName("id")
    private final long id;

    @SerializedName("version")
    private final int version;

    public final Date a() {
        return this.createdAt;
    }

    public final String b() {
        return this.deviceName;
    }

    public final long c() {
        return this.id;
    }

    public final int d() {
        return this.version;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BackupInfoDTO)) {
            return false;
        }
        BackupInfoDTO backupInfoDTO = (BackupInfoDTO) obj;
        return this.id == backupInfoDTO.id && this.version == backupInfoDTO.version && Intrinsics.areEqual(this.createdAt, backupInfoDTO.createdAt) && Intrinsics.areEqual(this.deviceName, backupInfoDTO.deviceName);
    }

    public int hashCode() {
        int iHashCode = ((((Long.hashCode(this.id) * 31) + Integer.hashCode(this.version)) * 31) + this.createdAt.hashCode()) * 31;
        String str = this.deviceName;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "BackupInfoDTO(id=" + this.id + ", version=" + this.version + ", createdAt=" + this.createdAt + ", deviceName=" + this.deviceName + ")";
    }
}
