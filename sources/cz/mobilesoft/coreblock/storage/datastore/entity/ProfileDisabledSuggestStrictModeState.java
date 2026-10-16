package cz.mobilesoft.coreblock.storage.datastore.entity;

import com.google.gson.annotations.SerializedName;
import cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
public final class ProfileDisabledSuggestStrictModeState implements Serializable {
    public static final int $stable = 8;

    @SerializedName("dialogShowCount")
    private long dialogShowCount;

    @SerializedName("dialogShownTime")
    private long dialogShownTime;

    @SerializedName("disabledCount")
    private long disabledCount;

    @SerializedName("lastAppsRemovedTime")
    private long lastAppsRemovedTime;

    @SerializedName("lastDisabledTime")
    private long lastDisabledTime;

    @SerializedName("lastQBCancelTime")
    private long lastQBCancelTime;

    @SerializedName("qbCancelCount")
    private long qbCancelCount;

    public ProfileDisabledSuggestStrictModeState() {
        this(0L, 0L, 0L, 0L, 0L, 0L, 0L, 127, null);
    }

    public final long component1() {
        return this.lastDisabledTime;
    }

    public final long component2() {
        return this.disabledCount;
    }

    public final long component3() {
        return this.dialogShownTime;
    }

    public final long component4() {
        return this.dialogShowCount;
    }

    public final long component5() {
        return this.qbCancelCount;
    }

    public final long component6() {
        return this.lastQBCancelTime;
    }

    public final long component7() {
        return this.lastAppsRemovedTime;
    }

    public final ProfileDisabledSuggestStrictModeState copy(long j3, long j4, long j5, long j6, long j7, long j8, long j9) {
        return new ProfileDisabledSuggestStrictModeState(j3, j4, j5, j6, j7, j8, j9);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProfileDisabledSuggestStrictModeState)) {
            return false;
        }
        ProfileDisabledSuggestStrictModeState profileDisabledSuggestStrictModeState = (ProfileDisabledSuggestStrictModeState) obj;
        return this.lastDisabledTime == profileDisabledSuggestStrictModeState.lastDisabledTime && this.disabledCount == profileDisabledSuggestStrictModeState.disabledCount && this.dialogShownTime == profileDisabledSuggestStrictModeState.dialogShownTime && this.dialogShowCount == profileDisabledSuggestStrictModeState.dialogShowCount && this.qbCancelCount == profileDisabledSuggestStrictModeState.qbCancelCount && this.lastQBCancelTime == profileDisabledSuggestStrictModeState.lastQBCancelTime && this.lastAppsRemovedTime == profileDisabledSuggestStrictModeState.lastAppsRemovedTime;
    }

    public final long getDialogShowCount() {
        return this.dialogShowCount;
    }

    public final long getDialogShownTime() {
        return this.dialogShownTime;
    }

    public final long getDisabledCount() {
        return this.disabledCount;
    }

    public final long getLastAppsRemovedTime() {
        return this.lastAppsRemovedTime;
    }

    public final long getLastDisabledTime() {
        return this.lastDisabledTime;
    }

    public final long getLastQBCancelTime() {
        return this.lastQBCancelTime;
    }

    public final long getQbCancelCount() {
        return this.qbCancelCount;
    }

    public int hashCode() {
        return (((((((((((Long.hashCode(this.lastDisabledTime) * 31) + Long.hashCode(this.disabledCount)) * 31) + Long.hashCode(this.dialogShownTime)) * 31) + Long.hashCode(this.dialogShowCount)) * 31) + Long.hashCode(this.qbCancelCount)) * 31) + Long.hashCode(this.lastQBCancelTime)) * 31) + Long.hashCode(this.lastAppsRemovedTime);
    }

    public final void setDialogShowCount(long j3) {
        this.dialogShowCount = j3;
    }

    public final void setDialogShownTime(long j3) {
        this.dialogShownTime = j3;
    }

    public final void setDisabledCount(long j3) {
        this.disabledCount = j3;
    }

    public final void setLastAppsRemovedTime(long j3) {
        this.lastAppsRemovedTime = j3;
    }

    public final void setLastDisabledTime(long j3) {
        this.lastDisabledTime = j3;
    }

    public final void setLastQBCancelTime(long j3) {
        this.lastQBCancelTime = j3;
    }

    public final void setQbCancelCount(long j3) {
        this.qbCancelCount = j3;
    }

    public final boolean shouldShowDialog() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jL = jCurrentTimeMillis - TimeHelperExt.f128663a.l();
        if (this.dialogShownTime < jL) {
            if (this.qbCancelCount > 1) {
                this.lastQBCancelTime = 0L;
                this.qbCancelCount = 0L;
                return true;
            }
            if (jCurrentTimeMillis - this.lastAppsRemovedTime < jL) {
                this.lastAppsRemovedTime = 0L;
                return true;
            }
        }
        return false;
    }

    public final boolean shouldShowSchedulePausedDialog() {
        return this.disabledCount % ((long) 3) == 0;
    }

    public String toString() {
        return "ProfileDisabledSuggestStrictModeState(lastDisabledTime=" + this.lastDisabledTime + ", disabledCount=" + this.disabledCount + ", dialogShownTime=" + this.dialogShownTime + ", dialogShowCount=" + this.dialogShowCount + ", qbCancelCount=" + this.qbCancelCount + ", lastQBCancelTime=" + this.lastQBCancelTime + ", lastAppsRemovedTime=" + this.lastAppsRemovedTime + ")";
    }

    public ProfileDisabledSuggestStrictModeState(long j3, long j4, long j5, long j6, long j7, long j8, long j9) {
        this.lastDisabledTime = j3;
        this.disabledCount = j4;
        this.dialogShownTime = j5;
        this.dialogShowCount = j6;
        this.qbCancelCount = j7;
        this.lastQBCancelTime = j8;
        this.lastAppsRemovedTime = j9;
    }

    public /* synthetic */ ProfileDisabledSuggestStrictModeState(long j3, long j4, long j5, long j6, long j7, long j8, long j9, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0L : j3, (i3 & 2) != 0 ? 0L : j4, (i3 & 4) != 0 ? 0L : j5, (i3 & 8) != 0 ? 0L : j6, (i3 & 16) != 0 ? 0L : j7, (i3 & 32) != 0 ? 0L : j8, (i3 & 64) != 0 ? 0L : j9);
    }
}
