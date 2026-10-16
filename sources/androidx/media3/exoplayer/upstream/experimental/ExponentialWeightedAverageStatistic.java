package androidx.media3.exoplayer.upstream.experimental;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class ExponentialWeightedAverageStatistic implements BandwidthStatistic {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final double f45597a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f45598b;

    @Override // androidx.media3.exoplayer.upstream.experimental.BandwidthStatistic
    public long a() {
        return this.f45598b;
    }

    @Override // androidx.media3.exoplayer.upstream.experimental.BandwidthStatistic
    public void b(long j3, long j4) {
        long j5 = (8000000 * j3) / j4;
        if (this.f45598b == Long.MIN_VALUE) {
            this.f45598b = j5;
        } else {
            double dPow = Math.pow(this.f45597a, Math.sqrt(j3));
            this.f45598b = (long) ((this.f45598b * dPow) + ((1.0d - dPow) * j5));
        }
    }
}
