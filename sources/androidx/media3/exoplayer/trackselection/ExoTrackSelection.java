package androidx.media3.exoplayer.trackselection;

import androidx.media3.common.Format;
import androidx.media3.common.Timeline;
import androidx.media3.common.TrackGroup;
import androidx.media3.common.util.Log;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.upstream.BandwidthMeter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public interface ExoTrackSelection extends TrackSelection {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Definition {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TrackGroup f45435a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int[] f45436b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f45437c;

        public Definition(TrackGroup trackGroup, int... iArr) {
            this(trackGroup, iArr, 0);
        }

        public Definition(TrackGroup trackGroup, int[] iArr, int i3) {
            if (iArr.length == 0) {
                Log.e("ETSDefinition", "Empty tracks are not allowed", new IllegalArgumentException());
            }
            this.f45435a = trackGroup;
            this.f45436b = iArr;
            this.f45437c = i3;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface Factory {
        ExoTrackSelection[] a(Definition[] definitionArr, BandwidthMeter bandwidthMeter, MediaSource.MediaPeriodId mediaPeriodId, Timeline timeline);
    }

    int a();

    void c();

    void e(float f3);

    void j();

    int k();

    Format l();

    default void f() {
    }

    default void m() {
    }

    default void i(boolean z2) {
    }
}
