package androidx.media3.exoplayer.source;

import androidx.media3.common.MediaItem;
import androidx.media3.common.util.Assertions;
import androidx.media3.datasource.TransferListener;
import androidx.media3.exoplayer.drm.DrmSessionManagerProvider;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.upstream.Allocator;
import androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class ExternallyLoadedMediaSource extends BaseMediaSource {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final ExternalLoader f44688i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final long f44689j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private MediaItem f44690k;

    @Override // androidx.media3.exoplayer.source.MediaSource
    public void B(MediaPeriod mediaPeriod) {
        ((ExternallyLoadedMediaPeriod) mediaPeriod).n();
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public synchronized void H(MediaItem mediaItem) {
        this.f44690k = mediaItem;
    }

    @Override // androidx.media3.exoplayer.source.BaseMediaSource
    protected void f0(TransferListener transferListener) {
        j0(new SinglePeriodTimeline(this.f44689j, true, false, false, null, m()));
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public MediaPeriod j(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j3) {
        MediaItem mediaItemM = m();
        Assertions.e(mediaItemM.f40714b);
        Assertions.f(mediaItemM.f40714b.f40811b, "Externally loaded mediaItems require a MIME type.");
        MediaItem.LocalConfiguration localConfiguration = mediaItemM.f40714b;
        return new ExternallyLoadedMediaPeriod(localConfiguration.f40810a, localConfiguration.f40811b, this.f44688i);
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public synchronized MediaItem m() {
        return this.f44690k;
    }

    private ExternallyLoadedMediaSource(MediaItem mediaItem, long j3, ExternalLoader externalLoader) {
        this.f44690k = mediaItem;
        this.f44689j = j3;
        this.f44688i = externalLoader;
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public void L() {
    }

    @Override // androidx.media3.exoplayer.source.BaseMediaSource
    protected void l0() {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Factory implements MediaSource.Factory {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f44691c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final ExternalLoader f44692d;

        public Factory(long j3, ExternalLoader externalLoader) {
            this.f44691c = j3;
            this.f44692d = externalLoader;
        }

        @Override // androidx.media3.exoplayer.source.MediaSource.Factory
        public int[] e() {
            return new int[]{4};
        }

        @Override // androidx.media3.exoplayer.source.MediaSource.Factory
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public ExternallyLoadedMediaSource c(MediaItem mediaItem) {
            return new ExternallyLoadedMediaSource(mediaItem, this.f44691c, this.f44692d);
        }

        @Override // androidx.media3.exoplayer.source.MediaSource.Factory
        public MediaSource.Factory d(DrmSessionManagerProvider drmSessionManagerProvider) {
            return this;
        }

        @Override // androidx.media3.exoplayer.source.MediaSource.Factory
        public MediaSource.Factory f(LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
            return this;
        }
    }
}
