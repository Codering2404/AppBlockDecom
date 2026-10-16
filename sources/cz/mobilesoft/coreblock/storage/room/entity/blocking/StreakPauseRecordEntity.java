package cz.mobilesoft.coreblock.storage.room.entity.blocking;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

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
public final class StreakPauseRecordEntity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f126495a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f126496b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f126497c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f126498d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Long f126499e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f126500f;

    public StreakPauseRecordEntity(long j3, long j4, long j5, long j6, Long l3, boolean z2) {
        this.f126495a = j3;
        this.f126496b = j4;
        this.f126497c = j5;
        this.f126498d = j6;
        this.f126499e = l3;
        this.f126500f = z2;
    }

    public final long a(long j3) {
        Long l3 = this.f126499e;
        return l3 != null ? l3.longValue() : Math.min(this.f126498d, j3);
    }

    public final long b() {
        Long l3 = this.f126499e;
        return RangesKt.g((l3 != null ? l3.longValue() : this.f126498d) - this.f126497c, 0L);
    }

    public final Long c() {
        return this.f126499e;
    }

    public final long d() {
        return this.f126495a;
    }

    public final long e() {
        return this.f126498d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StreakPauseRecordEntity)) {
            return false;
        }
        StreakPauseRecordEntity streakPauseRecordEntity = (StreakPauseRecordEntity) obj;
        return this.f126495a == streakPauseRecordEntity.f126495a && this.f126496b == streakPauseRecordEntity.f126496b && this.f126497c == streakPauseRecordEntity.f126497c && this.f126498d == streakPauseRecordEntity.f126498d && Intrinsics.areEqual(this.f126499e, streakPauseRecordEntity.f126499e) && this.f126500f == streakPauseRecordEntity.f126500f;
    }

    public final long f() {
        return this.f126496b;
    }

    public final long g() {
        return this.f126497c;
    }

    public final boolean h() {
        return this.f126500f;
    }

    public int hashCode() {
        int iHashCode = ((((((Long.hashCode(this.f126495a) * 31) + Long.hashCode(this.f126496b)) * 31) + Long.hashCode(this.f126497c)) * 31) + Long.hashCode(this.f126498d)) * 31;
        Long l3 = this.f126499e;
        return ((iHashCode + (l3 == null ? 0 : l3.hashCode())) * 31) + Boolean.hashCode(this.f126500f);
    }

    public String toString() {
        return "StreakPauseRecordEntity(id=" + this.f126495a + ", profileId=" + this.f126496b + ", startMillis=" + this.f126497c + ", plannedEndMillis=" + this.f126498d + ", endedAtMillis=" + this.f126499e + ", isIndefinite=" + this.f126500f + ")";
    }

    public /* synthetic */ StreakPauseRecordEntity(long j3, long j4, long j5, long j6, Long l3, boolean z2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0L : j3, j4, j5, j6, (i3 & 16) != 0 ? null : l3, (i3 & 32) != 0 ? false : z2);
    }
}
