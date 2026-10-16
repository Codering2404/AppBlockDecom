package androidx.media3.exoplayer.source;

import androidx.glance.session.ecY.lisODU;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.upstream.Allocator;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class ClippingMediaSource extends WrappingMediaSource {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final long f44563n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final long f44564o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final boolean f44565p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final boolean f44566q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final boolean f44567r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final boolean f44568s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final ArrayList f44569t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final Timeline.Window f44570u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private ClippingTimeline f44571v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private IllegalClippingException f44572w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private long f44573x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private long f44574y;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final MediaSource f44575a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f44576b;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f44579e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f44580f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f44581g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private boolean f44582h;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f44578d = true;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private long f44577c = Long.MIN_VALUE;

        public Builder(MediaSource mediaSource) {
            this.f44575a = (MediaSource) Assertions.e(mediaSource);
        }

        public ClippingMediaSource h() {
            this.f44582h = true;
            return new ClippingMediaSource(this);
        }

        public Builder i(boolean z2) {
            Assertions.g(!this.f44582h);
            this.f44579e = z2;
            return this;
        }

        public Builder j(boolean z2) {
            Assertions.g(!this.f44582h);
            this.f44578d = z2;
            return this;
        }

        public Builder k(long j3) {
            Assertions.g(!this.f44582h);
            this.f44577c = j3;
            return this;
        }

        public Builder l(boolean z2) {
            Assertions.g(!this.f44582h);
            this.f44580f = z2;
            return this;
        }

        public Builder m(long j3) {
            Assertions.a(j3 >= 0);
            Assertions.g(!this.f44582h);
            this.f44576b = j3;
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class ClippingTimeline extends ForwardingTimeline {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final long f44583f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final long f44584g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final long f44585h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final boolean f44586i;

        public ClippingTimeline(Timeline timeline, long j3, long j4, boolean z2) throws IllegalClippingException {
            super(timeline);
            if (j4 != Long.MIN_VALUE && j4 < j3) {
                throw new IllegalClippingException(2, j3, j4);
            }
            boolean z3 = false;
            if (timeline.i() != 1) {
                throw new IllegalClippingException(0);
            }
            Timeline.Window windowN = timeline.n(0, new Timeline.Window());
            long jMax = Math.max(0L, j3);
            if (!z2 && !windowN.f41145k && jMax != 0 && !windowN.f41142h) {
                throw new IllegalClippingException(1);
            }
            long jMax2 = j4 == Long.MIN_VALUE ? windowN.f41147m : Math.max(0L, j4);
            long j5 = windowN.f41147m;
            if (j5 != -9223372036854775807L) {
                jMax2 = jMax2 > j5 ? j5 : jMax2;
                if (jMax > jMax2) {
                    jMax = jMax2;
                }
            }
            this.f44583f = jMax;
            this.f44584g = jMax2;
            this.f44585h = jMax2 == -9223372036854775807L ? -9223372036854775807L : jMax2 - jMax;
            if (windowN.f41143i && (jMax2 == -9223372036854775807L || (j5 != -9223372036854775807L && jMax2 == j5))) {
                z3 = true;
            }
            this.f44586i = z3;
        }

        @Override // androidx.media3.exoplayer.source.ForwardingTimeline, androidx.media3.common.Timeline
        public Timeline.Period g(int i3, Timeline.Period period, boolean z2) {
            this.f44698e.g(0, period, z2);
            long jO = period.o() - this.f44583f;
            long j3 = this.f44585h;
            return period.t(period.f41114a, period.f41115b, 0, j3 != -9223372036854775807L ? j3 - jO : -9223372036854775807L, jO);
        }

        @Override // androidx.media3.exoplayer.source.ForwardingTimeline, androidx.media3.common.Timeline
        public Timeline.Window o(int i3, Timeline.Window window, long j3) {
            this.f44698e.o(0, window, 0L);
            long j4 = window.f41150p;
            long j5 = this.f44583f;
            window.f41150p = j4 + j5;
            window.f41147m = this.f44585h;
            window.f41143i = this.f44586i;
            long j6 = window.f41146l;
            if (j6 != -9223372036854775807L) {
                long jMax = Math.max(j6, j5);
                window.f41146l = jMax;
                long j7 = this.f44584g;
                if (j7 != -9223372036854775807L) {
                    jMax = Math.min(jMax, j7);
                }
                window.f41146l = jMax - this.f44583f;
            }
            long jT1 = Util.t1(this.f44583f);
            long j8 = window.f41139e;
            if (j8 != -9223372036854775807L) {
                window.f41139e = j8 + jT1;
            }
            long j9 = window.f41140f;
            if (j9 != -9223372036854775807L) {
                window.f41140f = j9 + jT1;
            }
            return window;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes2.dex */
    public static final class IllegalClippingException extends IOException {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f44587a;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        /* JADX INFO: loaded from: classes3.dex */
        @Target({ElementType.TYPE_USE})
        @Documented
        @Retention(RetentionPolicy.SOURCE)
        public @interface Reason {
        }

        public IllegalClippingException(int i3) {
            this(i3, -9223372036854775807L, -9223372036854775807L);
        }

        public IllegalClippingException(int i3, long j3, long j4) {
            super("Illegal clipping: " + a(i3, j3, j4));
            this.f44587a = i3;
        }

        private static String a(int i3, long j3, long j4) {
            if (i3 == 0) {
                return "invalid period count";
            }
            if (i3 == 1) {
                return lisODU.yTUKPREyKe;
            }
            if (i3 != 2) {
                return "unknown";
            }
            Assertions.g((j3 == -9223372036854775807L || j4 == -9223372036854775807L) ? false : true);
            return "start exceeds end. Start time: " + j3 + ", End time: " + j4;
        }
    }

    private void I0(Timeline timeline) {
        long j3;
        timeline.n(0, this.f44570u);
        long jE = this.f44570u.e();
        if (this.f44571v == null || this.f44569t.isEmpty() || this.f44566q) {
            j3 = this.f44563n;
            long j4 = this.f44564o;
            if (this.f44567r) {
                long jC = this.f44570u.c();
                j3 += jC;
                j4 += jC;
            }
            this.f44573x = jE + j3;
            this.f44574y = this.f44564o != Long.MIN_VALUE ? jE + j4 : Long.MIN_VALUE;
            int size = this.f44569t.size();
            for (int i3 = 0; i3 < size; i3++) {
                ((ClippingMediaPeriod) this.f44569t.get(i3)).v(this.f44573x, this.f44574y);
            }
            j = j4;
        } else {
            j3 = this.f44573x - jE;
            if (this.f44564o != Long.MIN_VALUE) {
                j = this.f44574y - jE;
            }
        }
        try {
            ClippingTimeline clippingTimeline = new ClippingTimeline(timeline, j3, j, this.f44568s);
            this.f44571v = clippingTimeline;
            j0(clippingTimeline);
        } catch (IllegalClippingException e3) {
            this.f44572w = e3;
            for (int i4 = 0; i4 < this.f44569t.size(); i4++) {
                ((ClippingMediaPeriod) this.f44569t.get(i4)).q(this.f44572w);
            }
        }
    }

    @Override // androidx.media3.exoplayer.source.WrappingMediaSource, androidx.media3.exoplayer.source.MediaSource
    public void B(MediaPeriod mediaPeriod) {
        Assertions.g(this.f44569t.remove(mediaPeriod));
        this.f44993l.B(((ClippingMediaPeriod) mediaPeriod).f44553a);
        if (!this.f44569t.isEmpty() || this.f44566q) {
            return;
        }
        I0(((ClippingTimeline) Assertions.e(this.f44571v)).f44698e);
    }

    @Override // androidx.media3.exoplayer.source.WrappingMediaSource
    protected void E0(Timeline timeline) {
        if (this.f44572w != null) {
            return;
        }
        I0(timeline);
    }

    @Override // androidx.media3.exoplayer.source.CompositeMediaSource, androidx.media3.exoplayer.source.MediaSource
    public void L() throws IllegalClippingException {
        IllegalClippingException illegalClippingException = this.f44572w;
        if (illegalClippingException != null) {
            throw illegalClippingException;
        }
        super.L();
    }

    @Override // androidx.media3.exoplayer.source.WrappingMediaSource, androidx.media3.exoplayer.source.MediaSource
    public MediaPeriod j(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j3) {
        ClippingMediaPeriod clippingMediaPeriod = new ClippingMediaPeriod(this.f44993l.j(mediaPeriodId, allocator, j3), this.f44565p, this.f44573x, this.f44574y);
        this.f44569t.add(clippingMediaPeriod);
        return clippingMediaPeriod;
    }

    @Override // androidx.media3.exoplayer.source.CompositeMediaSource, androidx.media3.exoplayer.source.BaseMediaSource
    protected void l0() {
        super.l0();
        this.f44572w = null;
        this.f44571v = null;
    }

    private ClippingMediaSource(Builder builder) {
        super(builder.f44575a);
        this.f44563n = builder.f44576b;
        this.f44564o = builder.f44577c;
        this.f44565p = builder.f44578d;
        this.f44566q = builder.f44579e;
        this.f44567r = builder.f44580f;
        this.f44568s = builder.f44581g;
        this.f44569t = new ArrayList();
        this.f44570u = new Timeline.Window();
    }
}
