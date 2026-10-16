package cz.mobilesoft.coreblock.storage.room.entity.blocking;

import coil.target.Yb.oUcQRqOVfOC;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import cz.mobilesoft.coreblock.scene.streaks.StreakDayStatus;
import cz.mobilesoft.coreblock.scene.streaks.StreakLossReason;
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
public final class StreakDayEntity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f126487a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f126488b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f126489c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final StreakDayStatus f126490d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final StreakLossReason f126491e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f126492f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Long f126493g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f126494h;

    public StreakDayEntity(String dayKey, long j3, String timeZoneId, StreakDayStatus status, StreakLossReason lossReason, long j4, Long l3, int i3) {
        Intrinsics.checkNotNullParameter(dayKey, "dayKey");
        Intrinsics.checkNotNullParameter(timeZoneId, "timeZoneId");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(lossReason, "lossReason");
        this.f126487a = dayKey;
        this.f126488b = j3;
        this.f126489c = timeZoneId;
        this.f126490d = status;
        this.f126491e = lossReason;
        this.f126492f = j4;
        this.f126493g = l3;
        this.f126494h = i3;
    }

    public final String a() {
        return this.f126487a;
    }

    public final long b() {
        return this.f126488b;
    }

    public final Long c() {
        return this.f126493g;
    }

    public final long d() {
        return this.f126492f;
    }

    public final StreakLossReason e() {
        return this.f126491e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StreakDayEntity)) {
            return false;
        }
        StreakDayEntity streakDayEntity = (StreakDayEntity) obj;
        return Intrinsics.areEqual(this.f126487a, streakDayEntity.f126487a) && this.f126488b == streakDayEntity.f126488b && Intrinsics.areEqual(this.f126489c, streakDayEntity.f126489c) && this.f126490d == streakDayEntity.f126490d && this.f126491e == streakDayEntity.f126491e && this.f126492f == streakDayEntity.f126492f && Intrinsics.areEqual(this.f126493g, streakDayEntity.f126493g) && this.f126494h == streakDayEntity.f126494h;
    }

    public final int f() {
        return this.f126494h;
    }

    public final StreakDayStatus g() {
        return this.f126490d;
    }

    public final String h() {
        return this.f126489c;
    }

    public int hashCode() {
        int iHashCode = ((((((((((this.f126487a.hashCode() * 31) + Long.hashCode(this.f126488b)) * 31) + this.f126489c.hashCode()) * 31) + this.f126490d.hashCode()) * 31) + this.f126491e.hashCode()) * 31) + Long.hashCode(this.f126492f)) * 31;
        Long l3 = this.f126493g;
        return ((iHashCode + (l3 == null ? 0 : l3.hashCode())) * 31) + Integer.hashCode(this.f126494h);
    }

    public String toString() {
        return "StreakDayEntity(dayKey=" + this.f126487a + ", dayStartMillis=" + this.f126488b + ", timeZoneId=" + this.f126489c + ", status=" + this.f126490d + ", lossReason=" + this.f126491e + ", evaluatedAtMillis=" + this.f126492f + ", earnedAtMillis=" + this.f126493g + ", rulesVersion=" + this.f126494h + oUcQRqOVfOC.moGNaHJNOwgtCt;
    }

    public /* synthetic */ StreakDayEntity(String str, long j3, String str2, StreakDayStatus streakDayStatus, StreakLossReason streakLossReason, long j4, Long l3, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j3, str2, (i4 & 8) != 0 ? StreakDayStatus.INACTIVE : streakDayStatus, (i4 & 16) != 0 ? StreakLossReason.NONE : streakLossReason, j4, (i4 & 64) != 0 ? null : l3, (i4 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? 2 : i3);
    }
}
