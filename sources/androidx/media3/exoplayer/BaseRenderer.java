package androidx.media3.exoplayer;

import androidx.media3.common.Format;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Clock;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.SampleStream;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseRenderer implements Renderer, RendererCapabilities {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f42845b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private RendererConfiguration f42847d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f42848f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private PlayerId f42849g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Clock f42850h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f42851i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private SampleStream f42852j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Format[] f42853k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f42854l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private long f42855m;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f42857o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f42858p;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private RendererCapabilities.Listener f42860r;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f42844a = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final FormatHolder f42846c = new FormatHolder();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private long f42856n = Long.MIN_VALUE;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private Timeline f42859q = Timeline.f41105a;

    public BaseRenderer(int i3) {
        this.f42845b = i3;
    }

    private void q0(long j3, boolean z2) {
        this.f42857o = false;
        this.f42855m = j3;
        this.f42856n = j3;
        h0(j3, z2);
    }

    @Override // androidx.media3.exoplayer.Renderer
    public final boolean B() {
        return this.f42857o;
    }

    @Override // androidx.media3.exoplayer.Renderer
    public final void F(Timeline timeline) {
        if (Objects.equals(this.f42859q, timeline)) {
            return;
        }
        this.f42859q = timeline;
        o0(timeline);
    }

    @Override // androidx.media3.exoplayer.RendererCapabilities
    public final void I(RendererCapabilities.Listener listener) {
        synchronized (this.f42844a) {
            this.f42860r = listener;
        }
    }

    @Override // androidx.media3.exoplayer.RendererCapabilities
    public int N() {
        return 0;
    }

    @Override // androidx.media3.exoplayer.Renderer
    public final long O() {
        return this.f42856n;
    }

    @Override // androidx.media3.exoplayer.Renderer
    public final void P(long j3) {
        q0(j3, false);
    }

    @Override // androidx.media3.exoplayer.Renderer
    public MediaClock Q() {
        return null;
    }

    protected final ExoPlaybackException S(Throwable th, Format format, int i3) {
        return T(th, format, false, i3);
    }

    protected final ExoPlaybackException T(Throwable th, Format format, boolean z2, int i3) {
        int iR;
        if (format == null || this.f42858p) {
            iR = 4;
        } else {
            this.f42858p = true;
            try {
                iR = RendererCapabilities.R(a(format));
            } catch (ExoPlaybackException unused) {
                iR = 4;
            } finally {
                this.f42858p = false;
            }
        }
        return ExoPlaybackException.d(th, getName(), X(), format, iR, z2, i3);
    }

    protected final Clock U() {
        return (Clock) Assertions.e(this.f42850h);
    }

    protected final RendererConfiguration V() {
        return (RendererConfiguration) Assertions.e(this.f42847d);
    }

    protected final FormatHolder W() {
        this.f42846c.a();
        return this.f42846c;
    }

    protected final int X() {
        return this.f42848f;
    }

    protected final long Y() {
        return this.f42855m;
    }

    protected final PlayerId Z() {
        return (PlayerId) Assertions.e(this.f42849g);
    }

    protected final Format[] a0() {
        return (Format[]) Assertions.e(this.f42853k);
    }

    protected final long b0() {
        return this.f42854l;
    }

    @Override // androidx.media3.exoplayer.Renderer
    public final void c() {
        Assertions.g(this.f42851i == 1);
        this.f42846c.a();
        this.f42851i = 0;
        this.f42852j = null;
        this.f42853k = null;
        this.f42857o = false;
        e0();
    }

    protected final Timeline c0() {
        return this.f42859q;
    }

    protected final boolean d0() {
        return k() ? this.f42857o : ((SampleStream) Assertions.e(this.f42852j)).isReady();
    }

    @Override // androidx.media3.exoplayer.Renderer, androidx.media3.exoplayer.RendererCapabilities
    public final int g() {
        return this.f42845b;
    }

    @Override // androidx.media3.exoplayer.Renderer
    public final int getState() {
        return this.f42851i;
    }

    @Override // androidx.media3.exoplayer.Renderer
    public final SampleStream i() {
        return this.f42852j;
    }

    @Override // androidx.media3.exoplayer.RendererCapabilities
    public final void j() {
        synchronized (this.f42844a) {
            this.f42860r = null;
        }
    }

    protected final void j0() {
        RendererCapabilities.Listener listener;
        synchronized (this.f42844a) {
            listener = this.f42860r;
        }
        if (listener != null) {
            listener.a(this);
        }
    }

    @Override // androidx.media3.exoplayer.Renderer
    public final boolean k() {
        return this.f42856n == Long.MIN_VALUE;
    }

    @Override // androidx.media3.exoplayer.Renderer
    public final void m(RendererConfiguration rendererConfiguration, Format[] formatArr, SampleStream sampleStream, long j3, boolean z2, boolean z3, long j4, long j5, MediaSource.MediaPeriodId mediaPeriodId) {
        Assertions.g(this.f42851i == 0);
        this.f42847d = rendererConfiguration;
        this.f42851i = 1;
        f0(z2, z3);
        x(formatArr, sampleStream, j4, j5, mediaPeriodId);
        q0(j4, z2);
    }

    @Override // androidx.media3.exoplayer.Renderer
    public final void o(int i3, PlayerId playerId, Clock clock) {
        this.f42848f = i3;
        this.f42849g = playerId;
        this.f42850h = clock;
        g0();
    }

    @Override // androidx.media3.exoplayer.Renderer
    public final void p() {
        this.f42857o = true;
    }

    protected final int p0(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i3) {
        int iN = ((SampleStream) Assertions.e(this.f42852j)).n(formatHolder, decoderInputBuffer, i3);
        if (iN != -4) {
            if (iN == -5) {
                Format format = (Format) Assertions.e(formatHolder.f43108b);
                if (format.f40637t != Long.MAX_VALUE) {
                    formatHolder.f43108b = format.b().y0(format.f40637t + this.f42854l).N();
                }
            }
            return iN;
        }
        if (decoderInputBuffer.i()) {
            this.f42856n = Long.MIN_VALUE;
            return this.f42857o ? -4 : -3;
        }
        long j3 = decoderInputBuffer.f42140g + this.f42854l;
        decoderInputBuffer.f42140g = j3;
        this.f42856n = Math.max(this.f42856n, j3);
        return iN;
    }

    protected int r0(long j3) {
        return ((SampleStream) Assertions.e(this.f42852j)).h(j3 - this.f42854l);
    }

    @Override // androidx.media3.exoplayer.Renderer
    public final void release() {
        Assertions.g(this.f42851i == 0);
        i0();
    }

    @Override // androidx.media3.exoplayer.Renderer
    public final void reset() {
        Assertions.g(this.f42851i == 0);
        this.f42846c.a();
        k0();
    }

    @Override // androidx.media3.exoplayer.Renderer
    public final void start() {
        Assertions.g(this.f42851i == 1);
        this.f42851i = 2;
        l0();
    }

    @Override // androidx.media3.exoplayer.Renderer
    public final void stop() {
        Assertions.g(this.f42851i == 2);
        this.f42851i = 1;
        m0();
    }

    @Override // androidx.media3.exoplayer.Renderer
    public final void x(Format[] formatArr, SampleStream sampleStream, long j3, long j4, MediaSource.MediaPeriodId mediaPeriodId) {
        Assertions.g(!this.f42857o);
        this.f42852j = sampleStream;
        if (this.f42856n == Long.MIN_VALUE) {
            this.f42856n = j3;
        }
        this.f42853k = formatArr;
        this.f42854l = j4;
        n0(formatArr, j3, j4, mediaPeriodId);
    }

    @Override // androidx.media3.exoplayer.Renderer
    public final void y() {
        ((SampleStream) Assertions.e(this.f42852j)).d();
    }

    @Override // androidx.media3.exoplayer.Renderer
    public final RendererCapabilities H() {
        return this;
    }

    protected void e0() {
    }

    protected void g0() {
    }

    protected void i0() {
    }

    protected void k0() {
    }

    protected void l0() {
    }

    protected void m0() {
    }

    protected void o0(Timeline timeline) {
    }

    protected void f0(boolean z2, boolean z3) {
    }

    protected void h0(long j3, boolean z2) {
    }

    @Override // androidx.media3.exoplayer.PlayerMessage.Target
    public void w(int i3, Object obj) {
    }

    protected void n0(Format[] formatArr, long j3, long j4, MediaSource.MediaPeriodId mediaPeriodId) {
    }
}
