package androidx.media3.exoplayer.upstream.experimental;

import android.os.Handler;
import androidx.media3.datasource.DataSource;
import androidx.media3.exoplayer.upstream.BandwidthMeter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public interface BandwidthEstimator {
    void a(BandwidthMeter.EventListener eventListener);

    void b(Handler handler, BandwidthMeter.EventListener eventListener);

    void c(DataSource dataSource, int i3);

    void d(DataSource dataSource);

    void e(DataSource dataSource);

    void f(DataSource dataSource);
}
