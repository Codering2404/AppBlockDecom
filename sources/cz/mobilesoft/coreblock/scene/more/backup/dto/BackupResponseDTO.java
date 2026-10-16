package cz.mobilesoft.coreblock.scene.more.backup.dto;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
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
public final class BackupResponseDTO implements Serializable {

    @SerializedName("history")
    private final HistoryDTO history;

    @SerializedName("id")
    private final long id;

    @SerializedName("profiles")
    private final List<ProfileDTO> profiles;

    @SerializedName("settings")
    private final SettingsDTO settings;

    @SerializedName("statistics")
    private final StatisticsDTO statistics;

    @SerializedName("strictMode")
    private final StrictModeDTO strictMode;

    @SerializedName("version")
    private final int version;

    public final HistoryDTO a() {
        return this.history;
    }

    public final List b() {
        return this.profiles;
    }

    public final SettingsDTO c() {
        return this.settings;
    }

    public final StatisticsDTO d() {
        return this.statistics;
    }

    public final StrictModeDTO e() {
        return this.strictMode;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BackupResponseDTO)) {
            return false;
        }
        BackupResponseDTO backupResponseDTO = (BackupResponseDTO) obj;
        return this.id == backupResponseDTO.id && this.version == backupResponseDTO.version && Intrinsics.areEqual(this.profiles, backupResponseDTO.profiles) && Intrinsics.areEqual(this.strictMode, backupResponseDTO.strictMode) && Intrinsics.areEqual(this.settings, backupResponseDTO.settings) && Intrinsics.areEqual(this.statistics, backupResponseDTO.statistics) && Intrinsics.areEqual(this.history, backupResponseDTO.history);
    }

    public int hashCode() {
        int iHashCode = ((Long.hashCode(this.id) * 31) + Integer.hashCode(this.version)) * 31;
        List<ProfileDTO> list = this.profiles;
        int iHashCode2 = (iHashCode + (list == null ? 0 : list.hashCode())) * 31;
        StrictModeDTO strictModeDTO = this.strictMode;
        int iHashCode3 = (iHashCode2 + (strictModeDTO == null ? 0 : strictModeDTO.hashCode())) * 31;
        SettingsDTO settingsDTO = this.settings;
        int iHashCode4 = (iHashCode3 + (settingsDTO == null ? 0 : settingsDTO.hashCode())) * 31;
        StatisticsDTO statisticsDTO = this.statistics;
        int iHashCode5 = (iHashCode4 + (statisticsDTO == null ? 0 : statisticsDTO.hashCode())) * 31;
        HistoryDTO historyDTO = this.history;
        return iHashCode5 + (historyDTO != null ? historyDTO.hashCode() : 0);
    }

    public String toString() {
        return "BackupResponseDTO(id=" + this.id + ", version=" + this.version + ", profiles=" + this.profiles + ", strictMode=" + this.strictMode + ", settings=" + this.settings + ", statistics=" + this.statistics + ", history=" + this.history + ")";
    }
}
