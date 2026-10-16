package androidx.media3.exoplayer.upstream.experimental;

import androidx.media3.common.util.Clock;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSpec;
import androidx.media3.exoplayer.upstream.TimeToFirstByteEstimator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class ExponentialWeightedAverageTimeToFirstByteEstimator implements TimeToFirstByteEstimator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LinkedHashMap f45599a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final double f45600b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Clock f45601c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f45602d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class FixedSizeLinkedHashMap<K, V> extends LinkedHashMap<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f45603a;

        @Override // java.util.LinkedHashMap
        protected boolean removeEldestEntry(Map.Entry entry) {
            return size() > this.f45603a;
        }
    }

    @Override // androidx.media3.exoplayer.upstream.TimeToFirstByteEstimator
    public void a(DataSpec dataSpec) {
        Long l3 = (Long) this.f45599a.remove(dataSpec);
        if (l3 == null) {
            return;
        }
        long jP0 = Util.P0(this.f45601c.a()) - l3.longValue();
        long j3 = this.f45602d;
        if (j3 == -9223372036854775807L) {
            this.f45602d = jP0;
        } else {
            double d3 = this.f45600b;
            this.f45602d = (long) ((j3 * d3) + ((1.0d - d3) * jP0));
        }
    }

    @Override // androidx.media3.exoplayer.upstream.TimeToFirstByteEstimator
    public void b(DataSpec dataSpec) {
        this.f45599a.remove(dataSpec);
        this.f45599a.put(dataSpec, Long.valueOf(Util.P0(this.f45601c.a())));
    }
}
