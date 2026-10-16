package androidx.media3.exoplayer;

import androidx.media3.common.Format;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Clock;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.SampleStream;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class ForwardingRenderer implements Renderer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Renderer f43109a;

    @Override // androidx.media3.exoplayer.Renderer
    public boolean B() {
        return this.f43109a.B();
    }

    @Override // androidx.media3.exoplayer.Renderer
    public long E(long j3, long j4) {
        return this.f43109a.E(j3, j4);
    }

    @Override // androidx.media3.exoplayer.Renderer
    public void F(Timeline timeline) {
        this.f43109a.F(timeline);
    }

    @Override // androidx.media3.exoplayer.Renderer
    public RendererCapabilities H() {
        return this.f43109a.H();
    }

    @Override // androidx.media3.exoplayer.Renderer
    public void L(float f3, float f4) {
        this.f43109a.L(f3, f4);
    }

    @Override // androidx.media3.exoplayer.Renderer
    public long O() {
        return this.f43109a.O();
    }

    @Override // androidx.media3.exoplayer.Renderer
    public void P(long j3) {
        this.f43109a.P(j3);
    }

    @Override // androidx.media3.exoplayer.Renderer
    public MediaClock Q() {
        return this.f43109a.Q();
    }

    @Override // androidx.media3.exoplayer.Renderer
    public boolean b() {
        return this.f43109a.b();
    }

    @Override // androidx.media3.exoplayer.Renderer
    public void c() {
        this.f43109a.c();
    }

    @Override // androidx.media3.exoplayer.Renderer
    public void f() {
        this.f43109a.f();
    }

    @Override // androidx.media3.exoplayer.Renderer, androidx.media3.exoplayer.RendererCapabilities
    public int g() {
        return this.f43109a.g();
    }

    @Override // androidx.media3.exoplayer.Renderer
    public int getState() {
        return this.f43109a.getState();
    }

    @Override // androidx.media3.exoplayer.Renderer
    public void h(long j3, long j4) {
        this.f43109a.h(j3, j4);
    }

    @Override // androidx.media3.exoplayer.Renderer
    public SampleStream i() {
        return this.f43109a.i();
    }

    @Override // androidx.media3.exoplayer.Renderer
    public boolean isReady() {
        return this.f43109a.isReady();
    }

    @Override // androidx.media3.exoplayer.Renderer
    public boolean k() {
        return this.f43109a.k();
    }

    @Override // androidx.media3.exoplayer.Renderer
    public void m(RendererConfiguration rendererConfiguration, Format[] formatArr, SampleStream sampleStream, long j3, boolean z2, boolean z3, long j4, long j5, MediaSource.MediaPeriodId mediaPeriodId) {
        this.f43109a.m(rendererConfiguration, formatArr, sampleStream, j3, z2, z3, j4, j5, mediaPeriodId);
    }

    @Override // androidx.media3.exoplayer.Renderer
    public void o(int i3, PlayerId playerId, Clock clock) {
        this.f43109a.o(i3, playerId, clock);
    }

    @Override // androidx.media3.exoplayer.Renderer
    public void p() {
        this.f43109a.p();
    }

    @Override // androidx.media3.exoplayer.Renderer
    public void release() {
        this.f43109a.release();
    }

    @Override // androidx.media3.exoplayer.Renderer
    public void reset() {
        this.f43109a.reset();
    }

    @Override // androidx.media3.exoplayer.Renderer
    public void start() {
        this.f43109a.start();
    }

    @Override // androidx.media3.exoplayer.Renderer
    public void stop() {
        this.f43109a.stop();
    }

    @Override // androidx.media3.exoplayer.PlayerMessage.Target
    public void w(int i3, Object obj) {
        this.f43109a.w(i3, obj);
    }

    @Override // androidx.media3.exoplayer.Renderer
    public void x(Format[] formatArr, SampleStream sampleStream, long j3, long j4, MediaSource.MediaPeriodId mediaPeriodId) {
        this.f43109a.x(formatArr, sampleStream, j3, j4, mediaPeriodId);
    }

    @Override // androidx.media3.exoplayer.Renderer
    public void y() {
        this.f43109a.y();
    }
}
