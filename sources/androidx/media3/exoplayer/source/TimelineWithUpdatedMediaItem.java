package androidx.media3.exoplayer.source;

import androidx.media3.common.MediaItem;
import androidx.media3.common.Timeline;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class TimelineWithUpdatedMediaItem extends ForwardingTimeline {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final MediaItem f44984f;

    public TimelineWithUpdatedMediaItem(Timeline timeline, MediaItem mediaItem) {
        super(timeline);
        this.f44984f = mediaItem;
    }

    @Override // androidx.media3.exoplayer.source.ForwardingTimeline, androidx.media3.common.Timeline
    public Timeline.Window o(int i3, Timeline.Window window, long j3) {
        super.o(i3, window, j3);
        MediaItem mediaItem = this.f44984f;
        window.f41137c = mediaItem;
        MediaItem.LocalConfiguration localConfiguration = mediaItem.f40714b;
        window.f41136b = localConfiguration != null ? localConfiguration.f40818i : null;
        return window;
    }
}
