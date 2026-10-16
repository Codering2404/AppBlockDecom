package androidx.media3.exoplayer.upstream.experimental;

import android.os.Handler;
import androidx.media3.common.util.Assertions;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DataSpec;
import androidx.media3.datasource.TransferListener;
import androidx.media3.exoplayer.upstream.BandwidthMeter;
import androidx.media3.exoplayer.upstream.TimeToFirstByteEstimator;
import com.google.common.collect.ImmutableList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class ExperimentalBandwidthMeter implements BandwidthMeter, TransferListener {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ImmutableList f45589c = ImmutableList.D(4300000L, 3200000L, 2400000L, 1700000L, 860000L);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ImmutableList f45590d = ImmutableList.D(1500000L, 980000L, 750000L, 520000L, 290000L);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ImmutableList f45591e = ImmutableList.D(2000000L, 1300000L, 1000000L, 860000L, 610000L);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ImmutableList f45592f = ImmutableList.D(2500000L, 1700000L, 1200000L, 970000L, 680000L);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ImmutableList f45593g = ImmutableList.D(4700000L, 2800000L, 2100000L, 1700000L, 980000L);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ImmutableList f45594h = ImmutableList.D(2700000L, 2000000L, 1600000L, 1300000L, 1000000L);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TimeToFirstByteEstimator f45595a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final BandwidthEstimator f45596b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {
    }

    private static boolean h(DataSpec dataSpec, boolean z2) {
        return z2 && !dataSpec.d(8);
    }

    @Override // androidx.media3.exoplayer.upstream.BandwidthMeter
    public synchronized void a(BandwidthMeter.EventListener eventListener) {
        this.f45596b.a(eventListener);
    }

    @Override // androidx.media3.exoplayer.upstream.BandwidthMeter
    public synchronized void b(Handler handler, BandwidthMeter.EventListener eventListener) {
        Assertions.e(handler);
        Assertions.e(eventListener);
        this.f45596b.b(handler, eventListener);
    }

    @Override // androidx.media3.datasource.TransferListener
    public synchronized void c(DataSource dataSource, DataSpec dataSpec, boolean z2, int i3) {
        if (h(dataSpec, z2)) {
            this.f45596b.c(dataSource, i3);
        }
    }

    @Override // androidx.media3.datasource.TransferListener
    public synchronized void e(DataSource dataSource, DataSpec dataSpec, boolean z2) {
        if (h(dataSpec, z2)) {
            this.f45595a.a(dataSpec);
            this.f45596b.e(dataSource);
        }
    }

    @Override // androidx.media3.datasource.TransferListener
    public synchronized void f(DataSource dataSource, DataSpec dataSpec, boolean z2) {
        if (h(dataSpec, z2)) {
            this.f45596b.f(dataSource);
        }
    }

    @Override // androidx.media3.datasource.TransferListener
    public synchronized void g(DataSource dataSource, DataSpec dataSpec, boolean z2) {
        if (h(dataSpec, z2)) {
            this.f45595a.b(dataSpec);
            this.f45596b.d(dataSource);
        }
    }

    @Override // androidx.media3.exoplayer.upstream.BandwidthMeter
    public TransferListener d() {
        return this;
    }
}
