package cz.mobilesoft.coreblock.scene.more.backup.dto;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
public final class BackupRequest {

    @SerializedName("deviceId")
    private final String deviceId;

    @SerializedName("history")
    private final HistoryDTO history;

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

    public BackupRequest(String deviceId, List profiles, int i3, StrictModeDTO strictModeDTO, SettingsDTO settings, StatisticsDTO statisticsDTO, HistoryDTO historyDTO) {
        Intrinsics.checkNotNullParameter(deviceId, "deviceId");
        Intrinsics.checkNotNullParameter(profiles, "profiles");
        Intrinsics.checkNotNullParameter(settings, "settings");
        this.deviceId = deviceId;
        this.profiles = profiles;
        this.version = i3;
        this.strictMode = strictModeDTO;
        this.settings = settings;
        this.statistics = statisticsDTO;
        this.history = historyDTO;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BackupRequest)) {
            return false;
        }
        BackupRequest backupRequest = (BackupRequest) obj;
        return Intrinsics.areEqual(this.deviceId, backupRequest.deviceId) && Intrinsics.areEqual(this.profiles, backupRequest.profiles) && this.version == backupRequest.version && Intrinsics.areEqual(this.strictMode, backupRequest.strictMode) && Intrinsics.areEqual(this.settings, backupRequest.settings) && Intrinsics.areEqual(this.statistics, backupRequest.statistics) && Intrinsics.areEqual(this.history, backupRequest.history);
    }

    public int hashCode() {
        int iHashCode = ((((this.deviceId.hashCode() * 31) + this.profiles.hashCode()) * 31) + Integer.hashCode(this.version)) * 31;
        StrictModeDTO strictModeDTO = this.strictMode;
        int iHashCode2 = (((iHashCode + (strictModeDTO == null ? 0 : strictModeDTO.hashCode())) * 31) + this.settings.hashCode()) * 31;
        StatisticsDTO statisticsDTO = this.statistics;
        int iHashCode3 = (iHashCode2 + (statisticsDTO == null ? 0 : statisticsDTO.hashCode())) * 31;
        HistoryDTO historyDTO = this.history;
        return iHashCode3 + (historyDTO != null ? historyDTO.hashCode() : 0);
    }

    public String toString() {
        return "BackupRequest(deviceId=" + this.deviceId + ", profiles=" + this.profiles + ", version=" + this.version + ", strictMode=" + this.strictMode + ", settings=" + this.settings + ", statistics=" + this.statistics + ", history=" + this.history + ")";
    }

    public /* synthetic */ BackupRequest(String str, List list, int i3, StrictModeDTO strictModeDTO, SettingsDTO settingsDTO, StatisticsDTO statisticsDTO, HistoryDTO historyDTO, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, list, (i4 & 4) != 0 ? 9 : i3, strictModeDTO, settingsDTO, statisticsDTO, historyDTO);
    }
}
