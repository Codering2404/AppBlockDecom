package androidx.media3.common.util;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class ConstantRateTimestampIterator implements TimestampIterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f41495a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final double f41496b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f41497c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f41498d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f41499e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f41500f;

    public ConstantRateTimestampIterator(long j3, float f3) {
        this(0L, j3, f3);
    }

    private long d(int i3) {
        long jRound = this.f41498d + Math.round(this.f41496b * ((double) i3));
        Assertions.g(jRound >= 0);
        return jRound;
    }

    @Override // androidx.media3.common.util.TimestampIterator
    public long a() {
        int i3 = this.f41497c;
        if (i3 == 0) {
            return -9223372036854775807L;
        }
        return d(i3 - 1);
    }

    @Override // androidx.media3.common.util.TimestampIterator
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public ConstantRateTimestampIterator b() {
        return new ConstantRateTimestampIterator(this.f41498d, this.f41499e, this.f41495a);
    }

    @Override // androidx.media3.common.util.TimestampIterator
    public boolean hasNext() {
        return this.f41500f < this.f41497c;
    }

    @Override // androidx.media3.common.util.TimestampIterator
    public long next() {
        Assertions.g(hasNext());
        int i3 = this.f41500f;
        this.f41500f = i3 + 1;
        return d(i3);
    }

    public ConstantRateTimestampIterator(long j3, long j4, float f3) {
        boolean z2 = false;
        Assertions.a(j4 > 0);
        Assertions.a(f3 > 0.0f);
        if (0 <= j3 && j3 < j4) {
            z2 = true;
        }
        Assertions.a(z2);
        this.f41498d = j3;
        this.f41499e = j4;
        this.f41495a = f3;
        this.f41497c = Math.max(Math.round(((j4 - j3) / 1000000.0f) * f3), 1);
        this.f41496b = 1000000.0f / f3;
    }
}
