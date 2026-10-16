package androidx.media3.transformer;

import android.util.SparseLongArray;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.MediaClock;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class TransformerMediaClock implements MediaClock {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SparseLongArray f48577a = new SparseLongArray();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f48578b;

    @Override // androidx.media3.exoplayer.MediaClock
    public long K() {
        return this.f48578b;
    }

    public void a(int i3, long j3) {
        long j4 = this.f48577a.get(i3, -9223372036854775807L);
        if (j4 == -9223372036854775807L || j3 > j4) {
            this.f48577a.put(i3, j3);
            if (j4 == -9223372036854775807L || j4 == this.f48578b) {
                this.f48578b = Util.N0(this.f48577a);
            }
        }
    }

    @Override // androidx.media3.exoplayer.MediaClock
    public PlaybackParameters d() {
        return PlaybackParameters.f40950d;
    }

    @Override // androidx.media3.exoplayer.MediaClock
    public void e(PlaybackParameters playbackParameters) {
    }
}
