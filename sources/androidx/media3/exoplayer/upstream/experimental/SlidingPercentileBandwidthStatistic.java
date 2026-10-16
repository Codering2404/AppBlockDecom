package androidx.media3.exoplayer.upstream.experimental;

import androidx.media3.common.util.Util;
import java.util.ArrayDeque;
import java.util.TreeSet;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class SlidingPercentileBandwidthStatistic implements BandwidthStatistic {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f45609a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final double f45610b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ArrayDeque f45611c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final TreeSet f45612d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private double f45613e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f45614f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Sample implements Comparable<Sample> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f45615a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final double f45616b;

        public Sample(long j3, double d3) {
            this.f45615a = j3;
            this.f45616b = d3;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public int compareTo(Sample sample) {
            return Util.p(this.f45615a, sample.f45615a);
        }
    }

    private long c() {
        if (this.f45611c.isEmpty()) {
            return Long.MIN_VALUE;
        }
        double d3 = this.f45613e * this.f45610b;
        double d4 = 0.0d;
        long j3 = 0;
        double d5 = 0.0d;
        for (Sample sample : this.f45612d) {
            double d6 = d4 + (sample.f45616b / 2.0d);
            if (d6 >= d3) {
                return j3 == 0 ? sample.f45615a : j3 + ((long) (((sample.f45615a - j3) * (d3 - d5)) / (d6 - d5)));
            }
            j3 = sample.f45615a;
            d5 = d6;
            d4 = (sample.f45616b / 2.0d) + d6;
        }
        return j3;
    }

    @Override // androidx.media3.exoplayer.upstream.experimental.BandwidthStatistic
    public long a() {
        return this.f45614f;
    }

    @Override // androidx.media3.exoplayer.upstream.experimental.BandwidthStatistic
    public void b(long j3, long j4) {
        while (this.f45611c.size() >= this.f45609a) {
            Sample sample = (Sample) this.f45611c.remove();
            this.f45612d.remove(sample);
            this.f45613e -= sample.f45616b;
        }
        double dSqrt = Math.sqrt(j3);
        Sample sample2 = new Sample((j3 * 8000000) / j4, dSqrt);
        this.f45611c.add(sample2);
        this.f45612d.add(sample2);
        this.f45613e += dSqrt;
        this.f45614f = c();
    }
}
