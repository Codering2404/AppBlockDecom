package androidx.media3.exoplayer.source;

import androidx.media3.common.MediaItem;
import androidx.media3.exoplayer.drm.DrmSessionManagerProvider;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public interface MediaSourceFactory extends MediaSource.Factory {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final MediaSourceFactory f44764b = new MediaSourceFactory() { // from class: androidx.media3.exoplayer.source.MediaSourceFactory.1
        @Override // androidx.media3.exoplayer.source.MediaSource.Factory
        public MediaSource c(MediaItem mediaItem) {
            throw new UnsupportedOperationException();
        }

        @Override // androidx.media3.exoplayer.source.MediaSource.Factory
        public int[] e() {
            throw new UnsupportedOperationException();
        }

        @Override // androidx.media3.exoplayer.source.MediaSource.Factory
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public MediaSourceFactory d(DrmSessionManagerProvider drmSessionManagerProvider) {
            return this;
        }

        @Override // androidx.media3.exoplayer.source.MediaSource.Factory
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public MediaSourceFactory f(LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
            return this;
        }
    };
}
