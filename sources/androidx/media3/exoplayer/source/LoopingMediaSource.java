package androidx.media3.exoplayer.source;

import androidx.media3.common.Timeline;
import androidx.media3.common.util.Assertions;
import androidx.media3.exoplayer.AbstractConcatenatedTimeline;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.ShuffleOrder;
import androidx.media3.exoplayer.upstream.Allocator;
import com.google.android.gms.common.api.Api;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public final class LoopingMediaSource extends WrappingMediaSource {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final int f44712n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Map f44713o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final Map f44714p;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class InfinitelyLoopingTimeline extends ForwardingTimeline {
        public InfinitelyLoopingTimeline(Timeline timeline) {
            super(timeline);
        }

        @Override // androidx.media3.exoplayer.source.ForwardingTimeline, androidx.media3.common.Timeline
        public int e(int i3, int i4, boolean z2) {
            int iE = this.f44698e.e(i3, i4, z2);
            return iE == -1 ? a(z2) : iE;
        }

        @Override // androidx.media3.exoplayer.source.ForwardingTimeline, androidx.media3.common.Timeline
        public int l(int i3, int i4, boolean z2) {
            int iL = this.f44698e.l(i3, i4, z2);
            return iL == -1 ? c(z2) : iL;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class LoopingTimeline extends AbstractConcatenatedTimeline {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final Timeline f44715h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final int f44716i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final int f44717j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private final int f44718k;

        public LoopingTimeline(Timeline timeline, int i3) {
            super(false, new ShuffleOrder.UnshuffledShuffleOrder(i3));
            this.f44715h = timeline;
            int i4 = timeline.i();
            this.f44716i = i4;
            this.f44717j = timeline.p();
            this.f44718k = i3;
            if (i4 > 0) {
                Assertions.h(i3 <= Api.BaseClientBuilder.API_PRIORITY_OTHER / i4, "LoopingMediaSource contains too many periods");
            }
        }

        @Override // androidx.media3.exoplayer.AbstractConcatenatedTimeline
        protected int A(int i3) {
            return i3 * this.f44717j;
        }

        @Override // androidx.media3.exoplayer.AbstractConcatenatedTimeline
        protected Timeline D(int i3) {
            return this.f44715h;
        }

        @Override // androidx.media3.common.Timeline
        public int i() {
            return this.f44716i * this.f44718k;
        }

        @Override // androidx.media3.common.Timeline
        public int p() {
            return this.f44717j * this.f44718k;
        }

        @Override // androidx.media3.exoplayer.AbstractConcatenatedTimeline
        protected int s(Object obj) {
            if (obj instanceof Integer) {
                return ((Integer) obj).intValue();
            }
            return -1;
        }

        @Override // androidx.media3.exoplayer.AbstractConcatenatedTimeline
        protected int t(int i3) {
            return i3 / this.f44716i;
        }

        @Override // androidx.media3.exoplayer.AbstractConcatenatedTimeline
        protected int u(int i3) {
            return i3 / this.f44717j;
        }

        @Override // androidx.media3.exoplayer.AbstractConcatenatedTimeline
        protected Object x(int i3) {
            return Integer.valueOf(i3);
        }

        @Override // androidx.media3.exoplayer.AbstractConcatenatedTimeline
        protected int z(int i3) {
            return i3 * this.f44716i;
        }
    }

    @Override // androidx.media3.exoplayer.source.WrappingMediaSource, androidx.media3.exoplayer.source.MediaSource
    public void B(MediaPeriod mediaPeriod) {
        this.f44993l.B(mediaPeriod);
        MediaSource.MediaPeriodId mediaPeriodId = (MediaSource.MediaPeriodId) this.f44714p.remove(mediaPeriod);
        if (mediaPeriodId != null) {
            this.f44713o.remove(mediaPeriodId);
        }
    }

    @Override // androidx.media3.exoplayer.source.WrappingMediaSource
    protected void E0(Timeline timeline) {
        j0(this.f44712n != Integer.MAX_VALUE ? new LoopingTimeline(timeline, this.f44712n) : new InfinitelyLoopingTimeline(timeline));
    }

    @Override // androidx.media3.exoplayer.source.WrappingMediaSource, androidx.media3.exoplayer.source.MediaSource
    public boolean M() {
        return false;
    }

    @Override // androidx.media3.exoplayer.source.WrappingMediaSource, androidx.media3.exoplayer.source.MediaSource
    public Timeline O() {
        MaskingMediaSource maskingMediaSource = (MaskingMediaSource) this.f44993l;
        return this.f44712n != Integer.MAX_VALUE ? new LoopingTimeline(maskingMediaSource.L0(), this.f44712n) : new InfinitelyLoopingTimeline(maskingMediaSource.L0());
    }

    @Override // androidx.media3.exoplayer.source.WrappingMediaSource, androidx.media3.exoplayer.source.MediaSource
    public MediaPeriod j(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j3) {
        if (this.f44712n == Integer.MAX_VALUE) {
            return this.f44993l.j(mediaPeriodId, allocator, j3);
        }
        MediaSource.MediaPeriodId mediaPeriodIdA = mediaPeriodId.a(AbstractConcatenatedTimeline.v(mediaPeriodId.f44754a));
        this.f44713o.put(mediaPeriodIdA, mediaPeriodId);
        MediaPeriod mediaPeriodJ = this.f44993l.j(mediaPeriodIdA, allocator, j3);
        this.f44714p.put(mediaPeriodJ, mediaPeriodIdA);
        return mediaPeriodJ;
    }

    @Override // androidx.media3.exoplayer.source.WrappingMediaSource
    protected MediaSource.MediaPeriodId y0(MediaSource.MediaPeriodId mediaPeriodId) {
        return this.f44712n != Integer.MAX_VALUE ? (MediaSource.MediaPeriodId) this.f44713o.get(mediaPeriodId) : mediaPeriodId;
    }
}
