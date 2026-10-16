package cz.mobilesoft.coreblock.storage.datastore.entity;

import com.google.gson.annotations.SerializedName;
import java.util.concurrent.TimeUnit;
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
public final class QuickBlockTimerUpsellState {
    public static final int $stable = 8;

    @SerializedName("dialogShownTime")
    private long dialogShownTime;

    @SerializedName("lastStopTime")
    private long lastStopTime;

    public QuickBlockTimerUpsellState() {
        this(0L, 0L, 3, null);
    }

    public static /* synthetic */ QuickBlockTimerUpsellState copy$default(QuickBlockTimerUpsellState quickBlockTimerUpsellState, long j3, long j4, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = quickBlockTimerUpsellState.lastStopTime;
        }
        if ((i3 & 2) != 0) {
            j4 = quickBlockTimerUpsellState.dialogShownTime;
        }
        return quickBlockTimerUpsellState.copy(j3, j4);
    }

    public final long component1() {
        return this.lastStopTime;
    }

    public final long component2() {
        return this.dialogShownTime;
    }

    public final QuickBlockTimerUpsellState copy(long j3, long j4) {
        return new QuickBlockTimerUpsellState(j3, j4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof QuickBlockTimerUpsellState)) {
            return false;
        }
        QuickBlockTimerUpsellState quickBlockTimerUpsellState = (QuickBlockTimerUpsellState) obj;
        return this.lastStopTime == quickBlockTimerUpsellState.lastStopTime && this.dialogShownTime == quickBlockTimerUpsellState.dialogShownTime;
    }

    public final long getDialogShownTime() {
        return this.dialogShownTime;
    }

    public final long getLastStopTime() {
        return this.lastStopTime;
    }

    public int hashCode() {
        return (Long.hashCode(this.lastStopTime) * 31) + Long.hashCode(this.dialogShownTime);
    }

    public final void setDialogShownTime(long j3) {
        this.dialogShownTime = j3;
    }

    public final void setLastStopTime(long j3) {
        this.lastStopTime = j3;
    }

    public final boolean shouldShowDialog() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jAbs = Math.abs(this.lastStopTime - jCurrentTimeMillis);
        TimeUnit timeUnit = TimeUnit.HOURS;
        return jAbs < timeUnit.toMillis(48L) && this.dialogShownTime < jCurrentTimeMillis - timeUnit.toMillis(24L);
    }

    public String toString() {
        return "QuickBlockTimerUpsellState(lastStopTime=" + this.lastStopTime + ", dialogShownTime=" + this.dialogShownTime + ")";
    }

    public QuickBlockTimerUpsellState(long j3, long j4) {
        this.lastStopTime = j3;
        this.dialogShownTime = j4;
    }

    public /* synthetic */ QuickBlockTimerUpsellState(long j3, long j4, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0L : j3, (i3 & 2) != 0 ? 0L : j4);
    }
}
