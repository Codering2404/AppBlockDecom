package cz.mobilesoft.coreblock.rest.response;

import com.google.gson.annotations.SerializedName;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
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
public final class StreakSnapshotResponse {
    public static final int $stable = 0;

    @SerializedName("bestStreak")
    private final int bestStreak;

    @SerializedName("currentStreak")
    private final int currentStreak;

    @SerializedName("evaluatedThrough")
    private final String evaluatedThrough;

    @SerializedName("freshness")
    private final String freshness;

    @SerializedName("initialized")
    private final boolean initialized;

    @SerializedName("lastReportAt")
    private final String lastReportAt;

    @SerializedName("streakZoneId")
    private final String streakZoneId;

    @SerializedName("today")
    private final String today;

    public StreakSnapshotResponse(boolean z2, int i3, int i4, String str, String str2, String str3, String str4, String str5) {
        this.initialized = z2;
        this.currentStreak = i3;
        this.bestStreak = i4;
        this.freshness = str;
        this.streakZoneId = str2;
        this.evaluatedThrough = str3;
        this.lastReportAt = str4;
        this.today = str5;
    }

    public static /* synthetic */ StreakSnapshotResponse copy$default(StreakSnapshotResponse streakSnapshotResponse, boolean z2, int i3, int i4, String str, String str2, String str3, String str4, String str5, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            z2 = streakSnapshotResponse.initialized;
        }
        if ((i5 & 2) != 0) {
            i3 = streakSnapshotResponse.currentStreak;
        }
        if ((i5 & 4) != 0) {
            i4 = streakSnapshotResponse.bestStreak;
        }
        if ((i5 & 8) != 0) {
            str = streakSnapshotResponse.freshness;
        }
        if ((i5 & 16) != 0) {
            str2 = streakSnapshotResponse.streakZoneId;
        }
        if ((i5 & 32) != 0) {
            str3 = streakSnapshotResponse.evaluatedThrough;
        }
        if ((i5 & 64) != 0) {
            str4 = streakSnapshotResponse.lastReportAt;
        }
        if ((i5 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0) {
            str5 = streakSnapshotResponse.today;
        }
        String str6 = str4;
        String str7 = str5;
        String str8 = str2;
        String str9 = str3;
        return streakSnapshotResponse.copy(z2, i3, i4, str, str8, str9, str6, str7);
    }

    public final boolean component1() {
        return this.initialized;
    }

    public final int component2() {
        return this.currentStreak;
    }

    public final int component3() {
        return this.bestStreak;
    }

    public final String component4() {
        return this.freshness;
    }

    public final String component5() {
        return this.streakZoneId;
    }

    public final String component6() {
        return this.evaluatedThrough;
    }

    public final String component7() {
        return this.lastReportAt;
    }

    public final String component8() {
        return this.today;
    }

    public final StreakSnapshotResponse copy(boolean z2, int i3, int i4, String str, String str2, String str3, String str4, String str5) {
        return new StreakSnapshotResponse(z2, i3, i4, str, str2, str3, str4, str5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StreakSnapshotResponse)) {
            return false;
        }
        StreakSnapshotResponse streakSnapshotResponse = (StreakSnapshotResponse) obj;
        return this.initialized == streakSnapshotResponse.initialized && this.currentStreak == streakSnapshotResponse.currentStreak && this.bestStreak == streakSnapshotResponse.bestStreak && Intrinsics.areEqual(this.freshness, streakSnapshotResponse.freshness) && Intrinsics.areEqual(this.streakZoneId, streakSnapshotResponse.streakZoneId) && Intrinsics.areEqual(this.evaluatedThrough, streakSnapshotResponse.evaluatedThrough) && Intrinsics.areEqual(this.lastReportAt, streakSnapshotResponse.lastReportAt) && Intrinsics.areEqual(this.today, streakSnapshotResponse.today);
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

    public final String getFreshness() {
        return this.freshness;
    }

    public final boolean getInitialized() {
        return this.initialized;
    }

    public final String getLastReportAt() {
        return this.lastReportAt;
    }

    public final String getStreakZoneId() {
        return this.streakZoneId;
    }

    public final String getToday() {
        return this.today;
    }

    public int hashCode() {
        int iHashCode = ((((Boolean.hashCode(this.initialized) * 31) + Integer.hashCode(this.currentStreak)) * 31) + Integer.hashCode(this.bestStreak)) * 31;
        String str = this.freshness;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.streakZoneId;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.evaluatedThrough;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.lastReportAt;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.today;
        return iHashCode5 + (str5 != null ? str5.hashCode() : 0);
    }

    public String toString() {
        return "StreakSnapshotResponse(initialized=" + this.initialized + ", currentStreak=" + this.currentStreak + ", bestStreak=" + this.bestStreak + ", freshness=" + this.freshness + ", streakZoneId=" + this.streakZoneId + ", evaluatedThrough=" + this.evaluatedThrough + ", lastReportAt=" + this.lastReportAt + ", today=" + this.today + ")";
    }
}
