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
public final class StatisticsNotificationsDTO {

    @SerializedName("showUsageStatistics")
    private final boolean showUsageStatistics;

    @SerializedName("weeklyStatisticsReport")
    private final boolean weeklyStatisticsReport;

    public StatisticsNotificationsDTO(boolean z2, boolean z3) {
        this.showUsageStatistics = z2;
        this.weeklyStatisticsReport = z3;
    }

    public final boolean a() {
        return this.showUsageStatistics;
    }

    public final boolean b() {
        return this.weeklyStatisticsReport;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StatisticsNotificationsDTO)) {
            return false;
        }
        StatisticsNotificationsDTO statisticsNotificationsDTO = (StatisticsNotificationsDTO) obj;
        return this.showUsageStatistics == statisticsNotificationsDTO.showUsageStatistics && this.weeklyStatisticsReport == statisticsNotificationsDTO.weeklyStatisticsReport;
    }

    public int hashCode() {
        return (Boolean.hashCode(this.showUsageStatistics) * 31) + Boolean.hashCode(this.weeklyStatisticsReport);
    }

    public String toString() {
        return "StatisticsNotificationsDTO(showUsageStatistics=" + this.showUsageStatistics + ", weeklyStatisticsReport=" + this.weeklyStatisticsReport + ")";
    }
}
