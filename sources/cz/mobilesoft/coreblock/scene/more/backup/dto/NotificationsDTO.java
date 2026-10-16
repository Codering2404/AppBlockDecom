package cz.mobilesoft.coreblock.scene.more.backup.dto;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class NotificationsDTO {

    @SerializedName("quickBlock")
    private final QuickBlockNotificationsDTO quickBlock;

    @SerializedName("schedules")
    private final ScheduleNotificationsDTO schedules;

    @SerializedName("statistics")
    private final StatisticsNotificationsDTO statistics;

    public NotificationsDTO(ScheduleNotificationsDTO schedules, QuickBlockNotificationsDTO quickBlock, StatisticsNotificationsDTO statistics) {
        Intrinsics.checkNotNullParameter(schedules, "schedules");
        Intrinsics.checkNotNullParameter(quickBlock, "quickBlock");
        Intrinsics.checkNotNullParameter(statistics, "statistics");
        this.schedules = schedules;
        this.quickBlock = quickBlock;
        this.statistics = statistics;
    }

    public final QuickBlockNotificationsDTO a() {
        return this.quickBlock;
    }

    public final ScheduleNotificationsDTO b() {
        return this.schedules;
    }

    public final StatisticsNotificationsDTO c() {
        return this.statistics;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NotificationsDTO)) {
            return false;
        }
        NotificationsDTO notificationsDTO = (NotificationsDTO) obj;
        return Intrinsics.areEqual(this.schedules, notificationsDTO.schedules) && Intrinsics.areEqual(this.quickBlock, notificationsDTO.quickBlock) && Intrinsics.areEqual(this.statistics, notificationsDTO.statistics);
    }

    public int hashCode() {
        return (((this.schedules.hashCode() * 31) + this.quickBlock.hashCode()) * 31) + this.statistics.hashCode();
    }

    public String toString() {
        return "NotificationsDTO(schedules=" + this.schedules + ", quickBlock=" + this.quickBlock + ", statistics=" + this.statistics + ")";
    }
}
