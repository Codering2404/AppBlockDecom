package cz.mobilesoft.coreblock.rest.request;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class StreakSnapshotRequest {
    public static final int $stable = 0;

    @SerializedName("bestStreak")
    private final int bestStreak;

    @SerializedName("currentStreak")
    private final int currentStreak;

    @SerializedName("evaluatedThrough")
    private final String evaluatedThrough;

    @SerializedName("streakZoneId")
    private final String streakZoneId;

    public StreakSnapshotRequest(int i3, int i4, String evaluatedThrough, String streakZoneId) {
        Intrinsics.checkNotNullParameter(evaluatedThrough, "evaluatedThrough");
        Intrinsics.checkNotNullParameter(streakZoneId, "streakZoneId");
        this.currentStreak = i3;
        this.bestStreak = i4;
        this.evaluatedThrough = evaluatedThrough;
        this.streakZoneId = streakZoneId;
    }

    public static /* synthetic */ StreakSnapshotRequest copy$default(StreakSnapshotRequest streakSnapshotRequest, int i3, int i4, String str, String str2, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i3 = streakSnapshotRequest.currentStreak;
        }
        if ((i5 & 2) != 0) {
            i4 = streakSnapshotRequest.bestStreak;
        }
        if ((i5 & 4) != 0) {
            str = streakSnapshotRequest.evaluatedThrough;
        }
        if ((i5 & 8) != 0) {
            str2 = streakSnapshotRequest.streakZoneId;
        }
        return streakSnapshotRequest.copy(i3, i4, str, str2);
    }

    public final int component1() {
        return this.currentStreak;
    }

    public final int component2() {
        return this.bestStreak;
    }

    public final String component3() {
        return this.evaluatedThrough;
    }

    public final String component4() {
        return this.streakZoneId;
    }

    public final StreakSnapshotRequest copy(int i3, int i4, String evaluatedThrough, String streakZoneId) {
        Intrinsics.checkNotNullParameter(evaluatedThrough, "evaluatedThrough");
        Intrinsics.checkNotNullParameter(streakZoneId, "streakZoneId");
        return new StreakSnapshotRequest(i3, i4, evaluatedThrough, streakZoneId);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StreakSnapshotRequest)) {
            return false;
        }
        StreakSnapshotRequest streakSnapshotRequest = (StreakSnapshotRequest) obj;
        return this.currentStreak == streakSnapshotRequest.currentStreak && this.bestStreak == streakSnapshotRequest.bestStreak && Intrinsics.areEqual(this.evaluatedThrough, streakSnapshotRequest.evaluatedThrough) && Intrinsics.areEqual(this.streakZoneId, streakSnapshotRequest.streakZoneId);
    }

    public final int getBestStreak() {
        return this.bestStreak;
    }

    public final int getCurrentStreak() {
        return this.currentStreak;
    }

    public final String getEvaluatedThrough() {
        return this.evaluatedThrough;
    }

    public final String getStreakZoneId() {
        return this.streakZoneId;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.currentStreak) * 31) + Integer.hashCode(this.bestStreak)) * 31) + this.evaluatedThrough.hashCode()) * 31) + this.streakZoneId.hashCode();
    }

    public String toString() {
        return "StreakSnapshotRequest(currentStreak=" + this.currentStreak + ", bestStreak=" + this.bestStreak + ", evaluatedThrough=" + this.evaluatedThrough + ", streakZoneId=" + this.streakZoneId + ")";
    }
}
