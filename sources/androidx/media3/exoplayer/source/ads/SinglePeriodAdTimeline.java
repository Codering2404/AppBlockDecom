package androidx.media3.exoplayer.source.ads;

import androidx.media3.common.AdPlaybackState;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Assertions;
import androidx.media3.exoplayer.source.ForwardingTimeline;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class SinglePeriodAdTimeline extends ForwardingTimeline {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final AdPlaybackState f45050f;

    public SinglePeriodAdTimeline(Timeline timeline, AdPlaybackState adPlaybackState) {
        super(timeline);
        Assertions.g(timeline.i() == 1);
        Assertions.g(timeline.p() == 1);
        this.f45050f = adPlaybackState;
    }

    @Override // androidx.media3.exoplayer.source.ForwardingTimeline, androidx.media3.common.Timeline
    public Timeline.Period g(int i3, Timeline.Period period, boolean z2) {
        this.f44698e.g(i3, period, z2);
        long j3 = period.f41117d;
        if (j3 == -9223372036854775807L) {
            j3 = this.f45050f.f40493d;
        }
        period.u(period.f41114a, period.f41115b, period.f41116c, j3, period.o(), this.f45050f, period.f41119f);
        return period;
    }
}
