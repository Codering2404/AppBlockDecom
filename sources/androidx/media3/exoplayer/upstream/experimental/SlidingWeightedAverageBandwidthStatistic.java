package androidx.media3.exoplayer.upstream.experimental;

import androidx.media3.common.util.Clock;
import java.util.ArrayDeque;
import java.util.Deque;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class SlidingWeightedAverageBandwidthStatistic implements BandwidthStatistic {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ArrayDeque f45617a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SampleEvictionFunction f45618b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Clock f45619c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private double f45620d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private double f45621e;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Sample {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f45622a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final double f45623b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f45624c;

        public Sample(long j3, double d3, long j4) {
            this.f45622a = j3;
            this.f45623b = d3;
            this.f45624c = j4;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface SampleEvictionFunction {
        boolean a(Deque deque);
    }

    @Override // androidx.media3.exoplayer.upstream.experimental.BandwidthStatistic
    public long a() {
        if (this.f45617a.isEmpty()) {
            return Long.MIN_VALUE;
        }
        return (long) (this.f45620d / this.f45621e);
    }

    @Override // androidx.media3.exoplayer.upstream.experimental.BandwidthStatistic
    public void b(long j3, long j4) {
        while (this.f45618b.a(this.f45617a)) {
            Sample sample = (Sample) this.f45617a.remove();
            double d3 = this.f45620d;
            double d4 = sample.f45622a;
            double d5 = sample.f45623b;
            this.f45620d = d3 - (d4 * d5);
            this.f45621e -= d5;
        }
        Sample sample2 = new Sample((j3 * 8000000) / j4, Math.sqrt(j3), this.f45619c.a());
        this.f45617a.add(sample2);
        double d6 = this.f45620d;
        double d7 = sample2.f45622a;
        double d8 = sample2.f45623b;
        this.f45620d = d6 + (d7 * d8);
        this.f45621e += d8;
    }
}
