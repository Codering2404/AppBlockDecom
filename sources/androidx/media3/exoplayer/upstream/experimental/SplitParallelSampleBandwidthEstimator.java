package androidx.media3.exoplayer.upstream.experimental;

import android.os.Handler;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Clock;
import androidx.media3.datasource.DataSource;
import androidx.media3.exoplayer.upstream.BandwidthMeter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class SplitParallelSampleBandwidthEstimator implements BandwidthEstimator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final BandwidthStatistic f45625a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f45626b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f45627c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Clock f45628d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final BandwidthMeter.EventListener.EventDispatcher f45629e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f45630f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f45631g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f45632h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f45633i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f45634j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f45635k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f45636l;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Builder {
    }

    private void g(int i3, long j3, long j4) {
        if (j4 != Long.MIN_VALUE) {
            if (i3 == 0 && j3 == 0 && j4 == this.f45634j) {
                return;
            }
            this.f45634j = j4;
            this.f45629e.c(i3, j3, j4);
        }
    }

    @Override // androidx.media3.exoplayer.upstream.experimental.BandwidthEstimator
    public void a(BandwidthMeter.EventListener eventListener) {
        this.f45629e.d(eventListener);
    }

    @Override // androidx.media3.exoplayer.upstream.experimental.BandwidthEstimator
    public void b(Handler handler, BandwidthMeter.EventListener eventListener) {
        this.f45629e.b(handler, eventListener);
    }

    @Override // androidx.media3.exoplayer.upstream.experimental.BandwidthEstimator
    public void c(DataSource dataSource, int i3) {
        long j3 = i3;
        this.f45632h += j3;
        this.f45636l += j3;
    }

    @Override // androidx.media3.exoplayer.upstream.experimental.BandwidthEstimator
    public void e(DataSource dataSource) {
        if (this.f45630f == 0) {
            this.f45631g = this.f45628d.a();
        }
        this.f45630f++;
    }

    @Override // androidx.media3.exoplayer.upstream.experimental.BandwidthEstimator
    public void f(DataSource dataSource) {
        Assertions.g(this.f45630f > 0);
        long jA = this.f45628d.a();
        long j3 = (int) (jA - this.f45631g);
        if (j3 > 0) {
            this.f45625a.b(this.f45632h, 1000 * j3);
            int i3 = this.f45635k + 1;
            this.f45635k = i3;
            if (i3 > this.f45626b && this.f45636l > this.f45627c) {
                this.f45633i = this.f45625a.a();
            }
            g((int) j3, this.f45632h, this.f45633i);
            this.f45631g = jA;
            this.f45632h = 0L;
        }
        this.f45630f--;
    }

    @Override // androidx.media3.exoplayer.upstream.experimental.BandwidthEstimator
    public void d(DataSource dataSource) {
    }
}
