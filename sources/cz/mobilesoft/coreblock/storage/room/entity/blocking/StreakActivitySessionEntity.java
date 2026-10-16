package cz.mobilesoft.coreblock.storage.room.entity.blocking;

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
public final class StreakActivitySessionEntity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f126482a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Long f126483b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f126484c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f126485d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f126486e;

    public StreakActivitySessionEntity(long j3, Long l3, long j4, long j5, long j6) {
        this.f126482a = j3;
        this.f126483b = l3;
        this.f126484c = j4;
        this.f126485d = j5;
        this.f126486e = j6;
    }

    public static /* synthetic */ StreakActivitySessionEntity b(StreakActivitySessionEntity streakActivitySessionEntity, long j3, Long l3, long j4, long j5, long j6, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = streakActivitySessionEntity.f126482a;
        }
        long j7 = j3;
        if ((i3 & 2) != 0) {
            l3 = streakActivitySessionEntity.f126483b;
        }
        Long l4 = l3;
        if ((i3 & 4) != 0) {
            j4 = streakActivitySessionEntity.f126484c;
        }
        return streakActivitySessionEntity.a(j7, l4, j4, (i3 & 8) != 0 ? streakActivitySessionEntity.f126485d : j5, (i3 & 16) != 0 ? streakActivitySessionEntity.f126486e : j6);
    }

    public final StreakActivitySessionEntity a(long j3, Long l3, long j4, long j5, long j6) {
        return new StreakActivitySessionEntity(j3, l3, j4, j5, j6);
    }

    public final long c() {
        return this.f126486e;
    }

    public final long d() {
        return this.f126485d;
    }

    public final long e() {
        return this.f126482a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StreakActivitySessionEntity)) {
            return false;
        }
        StreakActivitySessionEntity streakActivitySessionEntity = (StreakActivitySessionEntity) obj;
        return this.f126482a == streakActivitySessionEntity.f126482a && Intrinsics.areEqual(this.f126483b, streakActivitySessionEntity.f126483b) && this.f126484c == streakActivitySessionEntity.f126484c && this.f126485d == streakActivitySessionEntity.f126485d && this.f126486e == streakActivitySessionEntity.f126486e;
    }

    public final Long f() {
        return this.f126483b;
    }

    public final long g() {
        return this.f126484c;
    }

    public int hashCode() {
        int iHashCode = Long.hashCode(this.f126482a) * 31;
        Long l3 = this.f126483b;
        return ((((((iHashCode + (l3 == null ? 0 : l3.hashCode())) * 31) + Long.hashCode(this.f126484c)) * 31) + Long.hashCode(this.f126485d)) * 31) + Long.hashCode(this.f126486e);
    }

    public String toString() {
        return "StreakActivitySessionEntity(id=" + this.f126482a + ", profileId=" + this.f126483b + ", startMillis=" + this.f126484c + ", endMillis=" + this.f126485d + ", createdAtMillis=" + this.f126486e + ")";
    }

    public /* synthetic */ StreakActivitySessionEntity(long j3, Long l3, long j4, long j5, long j6, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0L : j3, (i3 & 2) != 0 ? null : l3, j4, j5, j6);
    }
}
