package androidx.media3.exoplayer.upstream.experimental;

import androidx.media3.common.util.Clock;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSpec;
import androidx.media3.exoplayer.upstream.SlidingPercentile;
import androidx.media3.exoplayer.upstream.TimeToFirstByteEstimator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class PercentileTimeToFirstByteEstimator implements TimeToFirstByteEstimator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LinkedHashMap f45604a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SlidingPercentile f45605b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Clock f45606c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f45607d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class FixedSizeLinkedHashMap<K, V> extends LinkedHashMap<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f45608a;

        @Override // java.util.LinkedHashMap
        protected boolean removeEldestEntry(Map.Entry entry) {
            return size() > this.f45608a;
        }
    }

    @Override // androidx.media3.exoplayer.upstream.TimeToFirstByteEstimator
    public void a(DataSpec dataSpec) {
        if (((Long) this.f45604a.remove(dataSpec)) == null) {
            return;
        }
        this.f45605b.c(1, Util.P0(this.f45606c.a()) - r6.longValue());
        this.f45607d = false;
    }

    @Override // androidx.media3.exoplayer.upstream.TimeToFirstByteEstimator
    public void b(DataSpec dataSpec) {
        this.f45604a.remove(dataSpec);
        this.f45604a.put(dataSpec, Long.valueOf(Util.P0(this.f45606c.a())));
    }
}
