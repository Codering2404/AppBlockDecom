package cz.mobilesoft.coreblock.scene.streaks;

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
public final class StreakDay {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f120265a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f120266b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final StreakDayStatus f120267c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final StreakLossReason f120268d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Long f120269e;

    public StreakDay(String dayKey, long j3, StreakDayStatus status, StreakLossReason lossReason, Long l3) {
        Intrinsics.checkNotNullParameter(dayKey, "dayKey");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(lossReason, "lossReason");
        this.f120265a = dayKey;
        this.f120266b = j3;
        this.f120267c = status;
        this.f120268d = lossReason;
        this.f120269e = l3;
    }

    public final String a() {
        return this.f120265a;
    }

    public final StreakDayStatus b() {
        return this.f120267c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StreakDay)) {
            return false;
        }
        StreakDay streakDay = (StreakDay) obj;
        return Intrinsics.areEqual(this.f120265a, streakDay.f120265a) && this.f120266b == streakDay.f120266b && this.f120267c == streakDay.f120267c && this.f120268d == streakDay.f120268d && Intrinsics.areEqual(this.f120269e, streakDay.f120269e);
    }

    public int hashCode() {
        int iHashCode = ((((((this.f120265a.hashCode() * 31) + Long.hashCode(this.f120266b)) * 31) + this.f120267c.hashCode()) * 31) + this.f120268d.hashCode()) * 31;
        Long l3 = this.f120269e;
        return iHashCode + (l3 == null ? 0 : l3.hashCode());
    }

    public String toString() {
        return "StreakDay(dayKey=" + this.f120265a + ", dayStartMillis=" + this.f120266b + ", status=" + this.f120267c + ", lossReason=" + this.f120268d + ", earnedAtMillis=" + this.f120269e + ")";
    }
}
