package androidx.media3.exoplayer.source;

import androidx.media3.common.AdPlaybackState;
import androidx.media3.common.MediaItem;
import androidx.media3.common.Timeline;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.upstream.Allocator;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class MaskingMediaSource extends WrappingMediaSource {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final boolean f44728n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Timeline.Window f44729o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final Timeline.Period f44730p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private MaskingTimeline f44731q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private MaskingMediaPeriod f44732r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f44733s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f44734t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f44735u;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class MaskingTimeline extends ForwardingTimeline {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final Object f44736h = new Object();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final Object f44737f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final Object f44738g;

        private MaskingTimeline(Timeline timeline, Object obj, Object obj2) {
            super(timeline);
            this.f44737f = obj;
            this.f44738g = obj2;
        }

        public static MaskingTimeline u(MediaItem mediaItem) {
            return new MaskingTimeline(new PlaceholderTimeline(mediaItem), Timeline.Window.f41125q, f44736h);
        }

        public static MaskingTimeline v(Timeline timeline, Object obj, Object obj2) {
            return new MaskingTimeline(timeline, obj, obj2);
        }

        @Override // androidx.media3.exoplayer.source.ForwardingTimeline, androidx.media3.common.Timeline
        public int b(Object obj) {
            Object obj2;
            Timeline timeline = this.f44698e;
            if (f44736h.equals(obj) && (obj2 = this.f44738g) != null) {
                obj = obj2;
            }
            return timeline.b(obj);
        }

        @Override // androidx.media3.exoplayer.source.ForwardingTimeline, androidx.media3.common.Timeline
        public Timeline.Period g(int i3, Timeline.Period period, boolean z2) {
            this.f44698e.g(i3, period, z2);
            if (Objects.equals(period.f41115b, this.f44738g) && z2) {
                period.f41115b = f44736h;
            }
            return period;
        }

        @Override // androidx.media3.exoplayer.source.ForwardingTimeline, androidx.media3.common.Timeline
        public Object m(int i3) {
            Object objM = this.f44698e.m(i3);
            return Objects.equals(objM, this.f44738g) ? f44736h : objM;
        }

        @Override // androidx.media3.exoplayer.source.ForwardingTimeline, androidx.media3.common.Timeline
        public Timeline.Window o(int i3, Timeline.Window window, long j3) {
            this.f44698e.o(i3, window, j3);
            if (Objects.equals(window.f41135a, this.f44737f)) {
                window.f41135a = Timeline.Window.f41125q;
            }
            return window;
        }

        public MaskingTimeline t(Timeline timeline) {
            return new MaskingTimeline(timeline, this.f44737f, this.f44738g);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class PlaceholderTimeline extends Timeline {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final MediaItem f44739e;

        public PlaceholderTimeline(MediaItem mediaItem) {
            this.f44739e = mediaItem;
        }

        @Override // androidx.media3.common.Timeline
        public int b(Object obj) {
            return obj == MaskingTimeline.f44736h ? 0 : -1;
        }

        @Override // androidx.media3.common.Timeline
        public Timeline.Period g(int i3, Timeline.Period period, boolean z2) {
            period.u(z2 ? 0 : null, z2 ? MaskingTimeline.f44736h : null, 0, -9223372036854775807L, 0L, AdPlaybackState.f40484g, true);
            return period;
        }

        @Override // androidx.media3.common.Timeline
        public int i() {
            return 1;
        }

        @Override // androidx.media3.common.Timeline
        public Object m(int i3) {
            return MaskingTimeline.f44736h;
        }

        @Override // androidx.media3.common.Timeline
        public Timeline.Window o(int i3, Timeline.Window window, long j3) {
            window.g(Timeline.Window.f41125q, this.f44739e, null, -9223372036854775807L, -9223372036854775807L, -9223372036854775807L, false, true, null, 0L, -9223372036854775807L, 0, 0, 0L);
            window.f41145k = true;
            return window;
        }

        @Override // androidx.media3.common.Timeline
        public int p() {
            return 1;
        }
    }

    public MaskingMediaSource(MediaSource mediaSource, boolean z2) {
        super(mediaSource);
        this.f44728n = z2 && mediaSource.M();
        this.f44729o = new Timeline.Window();
        this.f44730p = new Timeline.Period();
        Timeline timelineO = mediaSource.O();
        if (timelineO == null) {
            this.f44731q = MaskingTimeline.u(mediaSource.m());
        } else {
            this.f44731q = MaskingTimeline.v(timelineO, null, null);
            this.f44735u = true;
        }
    }

    private Object J0(Object obj) {
        return (this.f44731q.f44738g == null || !this.f44731q.f44738g.equals(obj)) ? obj : MaskingTimeline.f44736h;
    }

    private Object K0(Object obj) {
        return (this.f44731q.f44738g == null || !obj.equals(MaskingTimeline.f44736h)) ? obj : this.f44731q.f44738g;
    }

    private boolean M0(long j3) {
        MaskingMediaPeriod maskingMediaPeriod = this.f44732r;
        int iB = this.f44731q.b(maskingMediaPeriod.f44719a.f44754a);
        if (iB == -1) {
            return false;
        }
        long j4 = this.f44731q.f(iB, this.f44730p).f41117d;
        if (j4 != -9223372036854775807L && j3 >= j4) {
            j3 = Math.max(0L, j4 - 1);
        }
        maskingMediaPeriod.t(j3);
        return true;
    }

    @Override // androidx.media3.exoplayer.source.WrappingMediaSource, androidx.media3.exoplayer.source.MediaSource
    public void B(MediaPeriod mediaPeriod) {
        ((MaskingMediaPeriod) mediaPeriod).v();
        if (mediaPeriod == this.f44732r) {
            this.f44732r = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    @Override // androidx.media3.exoplayer.source.WrappingMediaSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void E0(androidx.media3.common.Timeline r15) {
        /*
            Method dump skipped, instruction units count: 202
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.source.MaskingMediaSource.E0(androidx.media3.common.Timeline):void");
    }

    @Override // androidx.media3.exoplayer.source.WrappingMediaSource, androidx.media3.exoplayer.source.MediaSource
    public void H(MediaItem mediaItem) {
        if (this.f44735u) {
            this.f44731q = this.f44731q.t(new TimelineWithUpdatedMediaItem(this.f44731q.f44698e, mediaItem));
        } else {
            this.f44731q = MaskingTimeline.u(mediaItem);
        }
        this.f44993l.H(mediaItem);
    }

    @Override // androidx.media3.exoplayer.source.WrappingMediaSource
    public void H0() {
        if (this.f44728n) {
            return;
        }
        this.f44733s = true;
        G0();
    }

    @Override // androidx.media3.exoplayer.source.WrappingMediaSource, androidx.media3.exoplayer.source.MediaSource
    /* JADX INFO: renamed from: I0, reason: merged with bridge method [inline-methods] */
    public MaskingMediaPeriod j(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j3) {
        MaskingMediaPeriod maskingMediaPeriod = new MaskingMediaPeriod(mediaPeriodId, allocator, j3);
        maskingMediaPeriod.w(this.f44993l);
        if (this.f44734t) {
            maskingMediaPeriod.d(mediaPeriodId.a(K0(mediaPeriodId.f44754a)));
            return maskingMediaPeriod;
        }
        this.f44732r = maskingMediaPeriod;
        if (!this.f44733s) {
            this.f44733s = true;
            G0();
        }
        return maskingMediaPeriod;
    }

    public Timeline L0() {
        return this.f44731q;
    }

    @Override // androidx.media3.exoplayer.source.CompositeMediaSource, androidx.media3.exoplayer.source.BaseMediaSource
    public void l0() {
        this.f44734t = false;
        this.f44733s = false;
        super.l0();
    }

    @Override // androidx.media3.exoplayer.source.WrappingMediaSource
    protected MediaSource.MediaPeriodId y0(MediaSource.MediaPeriodId mediaPeriodId) {
        return mediaPeriodId.a(J0(mediaPeriodId.f44754a));
    }

    @Override // androidx.media3.exoplayer.source.CompositeMediaSource, androidx.media3.exoplayer.source.MediaSource
    public void L() {
    }
}
