package androidx.media3.exoplayer;

import androidx.media3.common.Format;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Clock;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.SampleStream;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class NoSampleRenderer implements Renderer, RendererCapabilities {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private RendererConfiguration f43228a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f43229b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f43230c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private SampleStream f43231d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f43232f;

    @Override // androidx.media3.exoplayer.Renderer
    public final boolean B() {
        return this.f43232f;
    }

    @Override // androidx.media3.exoplayer.RendererCapabilities
    public int N() {
        return 0;
    }

    @Override // androidx.media3.exoplayer.Renderer
    public long O() {
        return Long.MIN_VALUE;
    }

    @Override // androidx.media3.exoplayer.Renderer
    public final void P(long j3) {
        this.f43232f = false;
        v(j3, false);
    }

    @Override // androidx.media3.exoplayer.Renderer
    public MediaClock Q() {
        return null;
    }

    @Override // androidx.media3.exoplayer.RendererCapabilities
    public int a(Format format) {
        return RendererCapabilities.u(0);
    }

    @Override // androidx.media3.exoplayer.Renderer
    public boolean b() {
        return true;
    }

    @Override // androidx.media3.exoplayer.Renderer
    public final void c() {
        Assertions.g(this.f43230c == 1);
        this.f43230c = 0;
        this.f43231d = null;
        this.f43232f = false;
        d();
    }

    @Override // androidx.media3.exoplayer.Renderer, androidx.media3.exoplayer.RendererCapabilities
    public final int g() {
        return -2;
    }

    @Override // androidx.media3.exoplayer.Renderer
    public final int getState() {
        return this.f43230c;
    }

    @Override // androidx.media3.exoplayer.Renderer
    public final SampleStream i() {
        return this.f43231d;
    }

    @Override // androidx.media3.exoplayer.Renderer
    public boolean isReady() {
        return true;
    }

    @Override // androidx.media3.exoplayer.Renderer
    public final boolean k() {
        return true;
    }

    @Override // androidx.media3.exoplayer.Renderer
    public final void m(RendererConfiguration rendererConfiguration, Format[] formatArr, SampleStream sampleStream, long j3, boolean z2, boolean z3, long j4, long j5, MediaSource.MediaPeriodId mediaPeriodId) {
        Assertions.g(this.f43230c == 0);
        this.f43228a = rendererConfiguration;
        this.f43230c = 1;
        e(z2);
        x(formatArr, sampleStream, j4, j5, mediaPeriodId);
        v(j3, z2);
    }

    @Override // androidx.media3.exoplayer.Renderer
    public final void o(int i3, PlayerId playerId, Clock clock) {
        this.f43229b = i3;
    }

    @Override // androidx.media3.exoplayer.Renderer
    public final void p() {
        this.f43232f = true;
    }

    @Override // androidx.media3.exoplayer.Renderer
    public final void reset() {
        Assertions.g(this.f43230c == 0);
        C();
    }

    @Override // androidx.media3.exoplayer.Renderer
    public final void start() {
        Assertions.g(this.f43230c == 1);
        this.f43230c = 2;
        K();
    }

    @Override // androidx.media3.exoplayer.Renderer
    public final void stop() {
        Assertions.g(this.f43230c == 2);
        this.f43230c = 1;
        M();
    }

    @Override // androidx.media3.exoplayer.Renderer
    public final void x(Format[] formatArr, SampleStream sampleStream, long j3, long j4, MediaSource.MediaPeriodId mediaPeriodId) {
        Assertions.g(!this.f43232f);
        this.f43231d = sampleStream;
        A(j4);
    }

    protected void C() {
    }

    @Override // androidx.media3.exoplayer.Renderer
    public final RendererCapabilities H() {
        return this;
    }

    protected void K() {
    }

    protected void M() {
    }

    protected void d() {
    }

    @Override // androidx.media3.exoplayer.Renderer
    public final void y() {
    }

    protected void A(long j3) {
    }

    @Override // androidx.media3.exoplayer.Renderer
    public void F(Timeline timeline) {
    }

    protected void e(boolean z2) {
    }

    protected void v(long j3, boolean z2) {
    }

    @Override // androidx.media3.exoplayer.PlayerMessage.Target
    public void w(int i3, Object obj) {
    }
}
