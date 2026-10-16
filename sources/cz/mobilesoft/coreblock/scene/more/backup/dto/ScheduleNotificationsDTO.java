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
public final class ScheduleNotificationsDTO {

    @SerializedName("afterEnd")
    private final boolean afterEnd;

    @SerializedName("beforePauseEnds")
    private final int beforePauseEnds;

    @SerializedName("beforeStart")
    private final int beforeStart;

    @SerializedName("notificationBeforeUsageLimitReached")
    private final NotificationBeforeUsageLimitReachedDTO notificationBeforeUsageLimitReached;

    @SerializedName("showBlockedNotifications")
    private final boolean showBlockedNotifications;

    @SerializedName("showRemainingApplicationUsage")
    private final boolean showRemainingApplicationUsage;

    public ScheduleNotificationsDTO(int i3, boolean z2, boolean z3, boolean z4, int i4, NotificationBeforeUsageLimitReachedDTO notificationBeforeUsageLimitReached) {
        Intrinsics.checkNotNullParameter(notificationBeforeUsageLimitReached, "notificationBeforeUsageLimitReached");
        this.beforeStart = i3;
        this.afterEnd = z2;
        this.showBlockedNotifications = z3;
        this.showRemainingApplicationUsage = z4;
        this.beforePauseEnds = i4;
        this.notificationBeforeUsageLimitReached = notificationBeforeUsageLimitReached;
    }

    public final boolean a() {
        return this.afterEnd;
    }

    public final int b() {
        return this.beforePauseEnds;
    }

    public final int c() {
        return this.beforeStart;
    }

    public final NotificationBeforeUsageLimitReachedDTO d() {
        return this.notificationBeforeUsageLimitReached;
    }

    public final boolean e() {
        return this.showBlockedNotifications;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ScheduleNotificationsDTO)) {
            return false;
        }
        ScheduleNotificationsDTO scheduleNotificationsDTO = (ScheduleNotificationsDTO) obj;
        return this.beforeStart == scheduleNotificationsDTO.beforeStart && this.afterEnd == scheduleNotificationsDTO.afterEnd && this.showBlockedNotifications == scheduleNotificationsDTO.showBlockedNotifications && this.showRemainingApplicationUsage == scheduleNotificationsDTO.showRemainingApplicationUsage && this.beforePauseEnds == scheduleNotificationsDTO.beforePauseEnds && Intrinsics.areEqual(this.notificationBeforeUsageLimitReached, scheduleNotificationsDTO.notificationBeforeUsageLimitReached);
    }

    public final boolean f() {
        return this.showRemainingApplicationUsage;
    }

    public int hashCode() {
        return (((((((((Integer.hashCode(this.beforeStart) * 31) + Boolean.hashCode(this.afterEnd)) * 31) + Boolean.hashCode(this.showBlockedNotifications)) * 31) + Boolean.hashCode(this.showRemainingApplicationUsage)) * 31) + Integer.hashCode(this.beforePauseEnds)) * 31) + this.notificationBeforeUsageLimitReached.hashCode();
    }

    public String toString() {
        return "ScheduleNotificationsDTO(beforeStart=" + this.beforeStart + ", afterEnd=" + this.afterEnd + ", showBlockedNotifications=" + this.showBlockedNotifications + ", showRemainingApplicationUsage=" + this.showRemainingApplicationUsage + ", beforePauseEnds=" + this.beforePauseEnds + ", notificationBeforeUsageLimitReached=" + this.notificationBeforeUsageLimitReached + ")";
    }
}
