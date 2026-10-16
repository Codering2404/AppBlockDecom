package androidx.media3.exoplayer.source;

import android.os.Handler;
import androidx.media3.common.MediaItem;
import androidx.media3.common.Timeline;
import androidx.media3.datasource.TransferListener;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.drm.DrmSessionEventListener;
import androidx.media3.exoplayer.drm.DrmSessionManagerProvider;
import androidx.media3.exoplayer.upstream.Allocator;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy;
import androidx.media3.extractor.text.SubtitleParser;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public interface MediaSource {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class MediaPeriodId {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f44754a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f44755b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f44756c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f44757d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f44758e;

        public MediaPeriodId(Object obj) {
            this(obj, -1L);
        }

        public MediaPeriodId a(Object obj) {
            return this.f44754a.equals(obj) ? this : new MediaPeriodId(obj, this.f44755b, this.f44756c, this.f44757d, this.f44758e);
        }

        public MediaPeriodId b(long j3) {
            return this.f44757d == j3 ? this : new MediaPeriodId(this.f44754a, this.f44755b, this.f44756c, j3, this.f44758e);
        }

        public boolean c() {
            return this.f44755b != -1;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MediaPeriodId)) {
                return false;
            }
            MediaPeriodId mediaPeriodId = (MediaPeriodId) obj;
            return this.f44754a.equals(mediaPeriodId.f44754a) && this.f44755b == mediaPeriodId.f44755b && this.f44756c == mediaPeriodId.f44756c && this.f44757d == mediaPeriodId.f44757d && this.f44758e == mediaPeriodId.f44758e;
        }

        public int hashCode() {
            return ((((((((527 + this.f44754a.hashCode()) * 31) + this.f44755b) * 31) + this.f44756c) * 31) + ((int) this.f44757d)) * 31) + this.f44758e;
        }

        public MediaPeriodId(Object obj, long j3) {
            this(obj, -1, -1, j3, -1);
        }

        public MediaPeriodId(Object obj, long j3, int i3) {
            this(obj, -1, -1, j3, i3);
        }

        public MediaPeriodId(Object obj, int i3, int i4, long j3) {
            this(obj, i3, i4, j3, -1);
        }

        private MediaPeriodId(Object obj, int i3, int i4, long j3, int i5) {
            this.f44754a = obj;
            this.f44755b = i3;
            this.f44756c = i4;
            this.f44757d = j3;
            this.f44758e = i5;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface MediaSourceCaller {
        void z(MediaSource mediaSource, Timeline timeline);
    }

    void B(MediaPeriod mediaPeriod);

    void C(MediaSourceCaller mediaSourceCaller, TransferListener transferListener, PlayerId playerId);

    void G(MediaSourceCaller mediaSourceCaller);

    void J(MediaSourceCaller mediaSourceCaller);

    void K(MediaSourceCaller mediaSourceCaller);

    void L();

    default boolean M() {
        return true;
    }

    default Timeline O() {
        return null;
    }

    void b(Handler handler, MediaSourceEventListener mediaSourceEventListener);

    void d(MediaSourceEventListener mediaSourceEventListener);

    MediaPeriod j(MediaPeriodId mediaPeriodId, Allocator allocator, long j3);

    MediaItem m();

    void t(Handler handler, DrmSessionEventListener drmSessionEventListener);

    void u(DrmSessionEventListener drmSessionEventListener);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface Factory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Factory f44753a = MediaSourceFactory.f44764b;

        MediaSource c(MediaItem mediaItem);

        Factory d(DrmSessionManagerProvider drmSessionManagerProvider);

        int[] e();

        Factory f(LoadErrorHandlingPolicy loadErrorHandlingPolicy);

        default Factory a(SubtitleParser.Factory factory) {
            return this;
        }

        default Factory b(int i3) {
            return this;
        }

        default Factory g(boolean z2) {
            return this;
        }

        default Factory h(CmcdConfiguration.Factory factory) {
            return this;
        }
    }

    default void H(MediaItem mediaItem) {
    }
}
