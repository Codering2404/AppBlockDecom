package cz.mobilesoft.coreblock.storage.room.entity.blocking;

import cz.mobilesoft.coreblock.util.profile.IntervalHolder;
import java.io.Serializable;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class Interval implements IntervalHolder, Serializable {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Companion f126426i = new Companion(null);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f126427j = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f126428a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f126429b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f126430c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f126431d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Long f126432f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f126433g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f126434h;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public Interval(long j3, long j4, long j5, long j6, Long l3, boolean z2, boolean z3) {
        this.f126428a = j3;
        this.f126429b = j4;
        this.f126430c = j5;
        this.f126431d = j6;
        this.f126432f = l3;
        this.f126433g = z2;
        this.f126434h = z3;
    }

    public static /* synthetic */ Interval d(Interval interval, long j3, long j4, long j5, long j6, Long l3, boolean z2, boolean z3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = interval.f126428a;
        }
        return interval.c(j3, (i3 & 2) != 0 ? interval.f126429b : j4, (i3 & 4) != 0 ? interval.f126430c : j5, (i3 & 8) != 0 ? interval.f126431d : j6, (i3 & 16) != 0 ? interval.f126432f : l3, (i3 & 32) != 0 ? interval.f126433g : z2, (i3 & 64) != 0 ? interval.f126434h : z3);
    }

    @Override // cz.mobilesoft.coreblock.util.profile.IntervalHolder
    public long a() {
        return this.f126431d;
    }

    @Override // cz.mobilesoft.coreblock.util.profile.IntervalHolder
    public long b() {
        return this.f126430c;
    }

    public final Interval c(long j3, long j4, long j5, long j6, Long l3, boolean z2, boolean z3) {
        return new Interval(j3, j4, j5, j6, l3, z2, z3);
    }

    public final long e() {
        return this.f126428a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Interval)) {
            return false;
        }
        Interval interval = (Interval) obj;
        return this.f126428a == interval.f126428a && this.f126429b == interval.f126429b && this.f126430c == interval.f126430c && this.f126431d == interval.f126431d && Intrinsics.areEqual(this.f126432f, interval.f126432f) && this.f126433g == interval.f126433g && this.f126434h == interval.f126434h;
    }

    public final Long f() {
        return this.f126432f;
    }

    public final long g() {
        return this.f126429b;
    }

    public final boolean h() {
        return this.f126433g;
    }

    public int hashCode() {
        int iHashCode = ((((((Long.hashCode(this.f126428a) * 31) + Long.hashCode(this.f126429b)) * 31) + Long.hashCode(this.f126430c)) * 31) + Long.hashCode(this.f126431d)) * 31;
        Long l3 = this.f126432f;
        return ((((iHashCode + (l3 == null ? 0 : l3.hashCode())) * 31) + Boolean.hashCode(this.f126433g)) * 31) + Boolean.hashCode(this.f126434h);
    }

    public final boolean i() {
        return this.f126434h;
    }

    public final void j(boolean z2) {
        this.f126434h = z2;
    }

    public String toString() {
        return "Interval(id=" + this.f126428a + ", profileId=" + this.f126429b + ", fromInMinutes=" + this.f126430c + ", toInMinutes=" + this.f126431d + ", parentId=" + this.f126432f + ", isAllDayAuto=" + this.f126433g + ", isEnabled=" + this.f126434h + ")";
    }

    public /* synthetic */ Interval(long j3, long j4, long j5, long j6, Long l3, boolean z2, boolean z3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0L : j3, j4, j5, j6, (i3 & 16) != 0 ? null : l3, (i3 & 32) != 0 ? false : z2, (i3 & 64) != 0 ? true : z3);
    }
}
