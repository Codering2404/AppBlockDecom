package androidx.media3.exoplayer.upstream.experimental;

import android.os.Handler;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Clock;
import androidx.media3.datasource.DataSource;
import androidx.media3.exoplayer.upstream.BandwidthMeter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class CombinedParallelSampleBandwidthEstimator implements BandwidthEstimator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final BandwidthStatistic f45577a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f45578b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f45579c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final BandwidthMeter.EventListener.EventDispatcher f45580d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Clock f45581e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f45582f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f45583g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f45584h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f45585i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f45586j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f45587k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f45588l;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Builder {
    }

    private void g(int i3, long j3, long j4) {
        if (j4 != Long.MIN_VALUE) {
            if (i3 == 0 && j3 == 0 && j4 == this.f45586j) {
                return;
            }
            this.f45586j = j4;
            this.f45580d.c(i3, j3, j4);
        }
    }

    @Override // androidx.media3.exoplayer.upstream.experimental.BandwidthEstimator
    public void a(BandwidthMeter.EventListener eventListener) {
        this.f45580d.d(eventListener);
    }

    @Override // androidx.media3.exoplayer.upstream.experimental.BandwidthEstimator
    public void b(Handler handler, BandwidthMeter.EventListener eventListener) {
        this.f45580d.b(handler, eventListener);
    }

    @Override // androidx.media3.exoplayer.upstream.experimental.BandwidthEstimator
    public void c(DataSource dataSource, int i3) {
        long j3 = i3;
        this.f45584h += j3;
        this.f45588l += j3;
    }

    @Override // androidx.media3.exoplayer.upstream.experimental.BandwidthEstimator
    public void e(DataSource dataSource) {
        if (this.f45582f == 0) {
            this.f45583g = this.f45581e.a();
        }
        this.f45582f++;
    }

    @Override // androidx.media3.exoplayer.upstream.experimental.BandwidthEstimator
    public void f(DataSource dataSource) {
        Assertions.g(this.f45582f > 0);
        int i3 = this.f45582f - 1;
        this.f45582f = i3;
        if (i3 <= 0) {
            long jA = (int) (this.f45581e.a() - this.f45583g);
            if (jA > 0) {
                this.f45577a.b(this.f45584h, 1000 * jA);
                int i4 = this.f45587k + 1;
                this.f45587k = i4;
                if (i4 > this.f45578b && this.f45588l > this.f45579c) {
                    this.f45585i = this.f45577a.a();
                }
                g((int) jA, this.f45584h, this.f45585i);
                this.f45584h = 0L;
            }
        }
    }

    @Override // androidx.media3.exoplayer.upstream.experimental.BandwidthEstimator
    public void d(DataSource dataSource) {
    }
}
