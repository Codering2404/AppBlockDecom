package androidx.media3.exoplayer.source;

import android.os.Handler;
import android.os.Message;
import android.util.Pair;
import androidx.media3.common.MediaItem;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.TransferListener;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.upstream.Allocator;
import com.google.common.collect.ImmutableList;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class ConcatenatingMediaSource2 extends CompositeMediaSource<Integer> {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final ImmutableList f44633l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final IdentityHashMap f44634m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private Handler f44635n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f44636o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private MediaItem f44637p;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class ConcatenatedTimeline extends Timeline {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final MediaItem f44638e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final ImmutableList f44639f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final ImmutableList f44640g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final ImmutableList f44641h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final boolean f44642i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final boolean f44643j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private final long f44644k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private final long f44645l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private final Object f44646m;

        public ConcatenatedTimeline(MediaItem mediaItem, ImmutableList immutableList, ImmutableList immutableList2, ImmutableList immutableList3, boolean z2, boolean z3, long j3, long j4, Object obj) {
            this.f44638e = mediaItem;
            this.f44639f = immutableList;
            this.f44640g = immutableList2;
            this.f44641h = immutableList3;
            this.f44642i = z2;
            this.f44643j = z3;
            this.f44644k = j3;
            this.f44645l = j4;
            this.f44646m = obj;
        }

        private int s(int i3) {
            return Util.h(this.f44640g, Integer.valueOf(i3 + 1), false, false);
        }

        /* JADX WARN: Multi-variable type inference failed */
        private long t(Timeline.Period period, int i3) {
            if (period.f41117d == -9223372036854775807L) {
                return -9223372036854775807L;
            }
            return (i3 == this.f44641h.size() + (-1) ? this.f44644k : ((Long) this.f44641h.get(i3 + 1)).longValue()) - ((Long) this.f44641h.get(i3)).longValue();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.media3.common.Timeline
        public int b(Object obj) {
            if (!(obj instanceof Pair) || !(((Pair) obj).first instanceof Integer)) {
                return -1;
            }
            int iD0 = ConcatenatingMediaSource2.D0(obj);
            int iB = ((Timeline) this.f44639f.get(iD0)).b(ConcatenatingMediaSource2.F0(obj));
            if (iB == -1) {
                return -1;
            }
            return ((Integer) this.f44640g.get(iD0)).intValue() + iB;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.media3.common.Timeline
        public Timeline.Period g(int i3, Timeline.Period period, boolean z2) {
            int iS = s(i3);
            ((Timeline) this.f44639f.get(iS)).g(i3 - ((Integer) this.f44640g.get(iS)).intValue(), period, z2);
            period.f41116c = 0;
            period.f41118e = ((Long) this.f44641h.get(i3)).longValue();
            period.f41117d = t(period, i3);
            if (z2) {
                period.f41115b = ConcatenatingMediaSource2.J0(iS, Assertions.e(period.f41115b));
            }
            return period;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.media3.common.Timeline
        public Timeline.Period h(Object obj, Timeline.Period period) {
            int iD0 = ConcatenatingMediaSource2.D0(obj);
            Object objF0 = ConcatenatingMediaSource2.F0(obj);
            Timeline timeline = (Timeline) this.f44639f.get(iD0);
            int iIntValue = ((Integer) this.f44640g.get(iD0)).intValue() + timeline.b(objF0);
            timeline.h(objF0, period);
            period.f41116c = 0;
            period.f41118e = ((Long) this.f44641h.get(iIntValue)).longValue();
            period.f41117d = t(period, iIntValue);
            period.f41115b = obj;
            return period;
        }

        @Override // androidx.media3.common.Timeline
        public int i() {
            return this.f44641h.size();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.media3.common.Timeline
        public Object m(int i3) {
            int iS = s(i3);
            return ConcatenatingMediaSource2.J0(iS, ((Timeline) this.f44639f.get(iS)).m(i3 - ((Integer) this.f44640g.get(iS)).intValue()));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.media3.common.Timeline
        public Timeline.Window o(int i3, Timeline.Window window, long j3) {
            return window.g(Timeline.Window.f41125q, this.f44638e, this.f44646m, -9223372036854775807L, -9223372036854775807L, -9223372036854775807L, this.f44642i, this.f44643j, null, this.f44645l, this.f44644k, 0, i() - 1, -((Long) this.f44641h.get(0)).longValue());
        }

        @Override // androidx.media3.common.Timeline
        public int p() {
            return 1;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class MediaSourceHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final MaskingMediaSource f44647a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f44648b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f44649c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final HashMap f44650d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f44651e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void C0() {
        for (int i3 = 0; i3 < this.f44633l.size(); i3++) {
            MediaSourceHolder mediaSourceHolder = (MediaSourceHolder) this.f44633l.get(i3);
            if (mediaSourceHolder.f44651e == 0) {
                o0(Integer.valueOf(mediaSourceHolder.f44648b));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int D0(Object obj) {
        return ((Integer) ((Pair) obj).first).intValue();
    }

    private static int E0(long j3, int i3) {
        return (int) (j3 % ((long) i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object F0(Object obj) {
        return ((Pair) obj).second;
    }

    private static long G0(long j3, int i3, int i4) {
        return (j3 * ((long) i3)) + ((long) i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object J0(int i3, Object obj) {
        return Pair.create(Integer.valueOf(i3), obj);
    }

    private static long L0(long j3, int i3) {
        return j3 / ((long) i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean M0(Message message) {
        if (message.what == 1) {
            Q0();
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ConcatenatedTimeline N0() {
        ImmutableList.Builder builder;
        ImmutableList.Builder builder2;
        int i3;
        long j3;
        long j4;
        Timeline.Window window;
        boolean z2;
        ConcatenatingMediaSource2 concatenatingMediaSource2 = this;
        Timeline.Window window2 = new Timeline.Window();
        Timeline.Period period = new Timeline.Period();
        ImmutableList.Builder builderO = ImmutableList.o();
        ImmutableList.Builder builderO2 = ImmutableList.o();
        ImmutableList.Builder builderO3 = ImmutableList.o();
        int size = concatenatingMediaSource2.f44633l.size();
        boolean z3 = true;
        boolean z4 = true;
        boolean z5 = true;
        int i4 = 0;
        Object obj = null;
        int i5 = 0;
        boolean z6 = false;
        boolean z7 = false;
        long j5 = 0;
        long j6 = 0;
        long j7 = 0;
        while (i4 < size) {
            MediaSourceHolder mediaSourceHolder = (MediaSourceHolder) concatenatingMediaSource2.f44633l.get(i4);
            Timeline timelineL0 = mediaSourceHolder.f44647a.L0();
            Assertions.b(timelineL0.q() ^ z3, "Can't concatenate empty child Timeline.");
            builderO.a(timelineL0);
            builderO2.a(Integer.valueOf(i5));
            i5 += timelineL0.i();
            int i6 = 0;
            while (i6 < timelineL0.p()) {
                timelineL0.n(i6, window2);
                if (!z6) {
                    z6 = z3;
                    obj = window2.f41138d;
                }
                z4 = (z4 && Objects.equals(obj, window2.f41138d)) ? z3 : false;
                Timeline timeline = timelineL0;
                long j8 = window2.f41147m;
                if (j8 == -9223372036854775807L) {
                    j8 = mediaSourceHolder.f44649c;
                    if (j8 == -9223372036854775807L) {
                        return null;
                    }
                }
                j5 += j8;
                if (mediaSourceHolder.f44648b == 0 && i6 == 0) {
                    builder = builderO;
                    builder2 = builderO2;
                    j6 = window2.f41146l;
                    j7 = -window2.f41150p;
                } else {
                    builder = builderO;
                    builder2 = builderO2;
                }
                z5 &= window2.f41142h || window2.f41145k;
                z7 |= window2.f41143i;
                int i7 = window2.f41148n;
                while (i7 <= window2.f41149o) {
                    builderO3.a(Long.valueOf(j7));
                    Timeline timeline2 = timeline;
                    timeline2.g(i7, period, true);
                    ImmutableList.Builder builder3 = builderO3;
                    long j9 = period.f41117d;
                    if (j9 == -9223372036854775807L) {
                        Assertions.b(window2.f41148n == window2.f41149o, "Can't apply placeholder duration to multiple periods with unknown duration in a single window.");
                        j9 = window2.f41150p + j8;
                    }
                    if (i7 != window2.f41148n || ((mediaSourceHolder.f44648b == 0 && i6 == 0) || j9 == -9223372036854775807L)) {
                        i3 = i7;
                        j3 = j9;
                        j4 = 0;
                    } else {
                        i3 = i7;
                        j4 = -window2.f41150p;
                        j3 = j9 + j4;
                    }
                    Object objE = Assertions.e(period.f41115b);
                    int i8 = i3;
                    if (mediaSourceHolder.f44651e == 0 || !mediaSourceHolder.f44650d.containsKey(objE)) {
                        window = window2;
                    } else {
                        window = window2;
                        if (!((Long) mediaSourceHolder.f44650d.get(objE)).equals(Long.valueOf(j4))) {
                            z2 = false;
                        }
                        Assertions.b(z2, "Can't handle windows with changing offset in first period.");
                        mediaSourceHolder.f44650d.put(objE, Long.valueOf(j4));
                        j7 += j3;
                        i7 = i8 + 1;
                        builderO3 = builder3;
                        timeline = timeline2;
                        window2 = window;
                    }
                    z2 = true;
                    Assertions.b(z2, "Can't handle windows with changing offset in first period.");
                    mediaSourceHolder.f44650d.put(objE, Long.valueOf(j4));
                    j7 += j3;
                    i7 = i8 + 1;
                    builderO3 = builder3;
                    timeline = timeline2;
                    window2 = window;
                }
                i6++;
                builderO = builder;
                builderO2 = builder2;
                timelineL0 = timeline;
                z3 = true;
            }
            i4++;
            concatenatingMediaSource2 = this;
            z3 = true;
        }
        return new ConcatenatedTimeline(m(), builderO.m(), builderO2.m(), builderO3.m(), z5, z7, j5, j6, z4 ? obj : null);
    }

    private void P0() {
        if (this.f44636o) {
            return;
        }
        ((Handler) Assertions.e(this.f44635n)).obtainMessage(1).sendToTarget();
        this.f44636o = true;
    }

    private void Q0() {
        this.f44636o = false;
        ConcatenatedTimeline concatenatedTimelineN0 = N0();
        if (concatenatedTimelineN0 != null) {
            j0(concatenatedTimelineN0);
        }
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public void B(MediaPeriod mediaPeriod) {
        ((MediaSourceHolder) Assertions.e((MediaSourceHolder) this.f44634m.remove(mediaPeriod))).f44647a.B(((TimeOffsetMediaPeriod) mediaPeriod).d());
        r0.f44651e--;
        if (this.f44634m.isEmpty()) {
            return;
        }
        C0();
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public synchronized void H(MediaItem mediaItem) {
        this.f44637p = mediaItem;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.media3.exoplayer.source.CompositeMediaSource
    /* JADX INFO: renamed from: H0, reason: merged with bridge method [inline-methods] */
    public MediaSource.MediaPeriodId q0(Integer num, MediaSource.MediaPeriodId mediaPeriodId) {
        if (num.intValue() != E0(mediaPeriodId.f44757d, this.f44633l.size())) {
            return null;
        }
        return mediaPeriodId.a(J0(num.intValue(), mediaPeriodId.f44754a)).b(L0(mediaPeriodId.f44757d, this.f44633l.size()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.media3.exoplayer.source.CompositeMediaSource
    /* JADX INFO: renamed from: I0, reason: merged with bridge method [inline-methods] */
    public long r0(Integer num, long j3, MediaSource.MediaPeriodId mediaPeriodId) {
        Long l3;
        return (j3 == -9223372036854775807L || mediaPeriodId == null || mediaPeriodId.c() || (l3 = (Long) ((MediaSourceHolder) this.f44633l.get(num.intValue())).f44650d.get(mediaPeriodId.f44754a)) == null) ? j3 : j3 + Util.t1(l3.longValue());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.media3.exoplayer.source.CompositeMediaSource
    /* JADX INFO: renamed from: K0, reason: merged with bridge method [inline-methods] */
    public int s0(Integer num, int i3) {
        return 0;
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public Timeline O() {
        return N0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.media3.exoplayer.source.CompositeMediaSource
    /* JADX INFO: renamed from: O0, reason: merged with bridge method [inline-methods] */
    public void v0(Integer num, MediaSource mediaSource, Timeline timeline) {
        P0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.media3.exoplayer.source.CompositeMediaSource, androidx.media3.exoplayer.source.BaseMediaSource
    protected void f0(TransferListener transferListener) {
        super.f0(transferListener);
        this.f44635n = new Handler(new Handler.Callback() { // from class: androidx.media3.exoplayer.source.d
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                return this.f45158a.M0(message);
            }
        });
        for (int i3 = 0; i3 < this.f44633l.size(); i3++) {
            w0(Integer.valueOf(i3), ((MediaSourceHolder) this.f44633l.get(i3)).f44647a);
        }
        P0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.media3.exoplayer.source.MediaSource
    public MediaPeriod j(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j3) {
        MediaSourceHolder mediaSourceHolder = (MediaSourceHolder) this.f44633l.get(D0(mediaPeriodId.f44754a));
        MediaSource.MediaPeriodId mediaPeriodIdB = mediaPeriodId.a(F0(mediaPeriodId.f44754a)).b(G0(mediaPeriodId.f44757d, this.f44633l.size(), mediaSourceHolder.f44648b));
        p0(Integer.valueOf(mediaSourceHolder.f44648b));
        mediaSourceHolder.f44651e++;
        long jLongValue = mediaPeriodId.c() ? 0L : ((Long) Assertions.e((Long) mediaSourceHolder.f44650d.get(mediaPeriodIdB.f44754a))).longValue();
        TimeOffsetMediaPeriod timeOffsetMediaPeriod = new TimeOffsetMediaPeriod(mediaSourceHolder.f44647a.j(mediaPeriodIdB, allocator, j3 - jLongValue), jLongValue);
        this.f44634m.put(timeOffsetMediaPeriod, mediaSourceHolder);
        C0();
        return timeOffsetMediaPeriod;
    }

    @Override // androidx.media3.exoplayer.source.CompositeMediaSource, androidx.media3.exoplayer.source.BaseMediaSource
    protected void l0() {
        super.l0();
        Handler handler = this.f44635n;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f44635n = null;
        }
        this.f44636o = false;
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public synchronized MediaItem m() {
        return this.f44637p;
    }

    @Override // androidx.media3.exoplayer.source.CompositeMediaSource, androidx.media3.exoplayer.source.BaseMediaSource
    protected void a0() {
    }
}
