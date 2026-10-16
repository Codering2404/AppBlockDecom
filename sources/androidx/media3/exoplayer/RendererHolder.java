package androidx.media3.exoplayer;

import androidx.media3.common.Format;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Assertions;
import androidx.media3.exoplayer.metadata.MetadataRenderer;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.SampleStream;
import androidx.media3.exoplayer.text.TextRenderer;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import androidx.media3.exoplayer.trackselection.TrackSelectorResult;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
class RendererHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Renderer f43290a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f43291b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Renderer f43292c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f43293d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f43294e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f43295f = false;

    public RendererHolder(Renderer renderer, Renderer renderer2, int i3) {
        this.f43290a = renderer;
        this.f43291b = i3;
        this.f43292c = renderer2;
    }

    private boolean A() {
        return this.f43293d == 3;
    }

    private void C(Renderer renderer, SampleStream sampleStream, DefaultMediaClock defaultMediaClock, long j3, boolean z2) {
        if (y(renderer)) {
            if (sampleStream != renderer.i()) {
                d(renderer, defaultMediaClock);
            } else if (z2) {
                renderer.P(j3);
            }
        }
    }

    private void E(boolean z2) {
        if (z2) {
            if (this.f43294e) {
                this.f43290a.reset();
                this.f43294e = false;
                return;
            }
            return;
        }
        if (this.f43295f) {
            ((Renderer) Assertions.e(this.f43292c)).reset();
            this.f43295f = false;
        }
    }

    private int K(Renderer renderer, MediaPeriodHolder mediaPeriodHolder, TrackSelectorResult trackSelectorResult, DefaultMediaClock defaultMediaClock) {
        if (renderer == null || !y(renderer) || ((renderer == this.f43290a && v()) || (renderer == this.f43292c && A()))) {
            return 1;
        }
        SampleStream sampleStreamI = renderer.i();
        SampleStream[] sampleStreamArr = mediaPeriodHolder.f43145c;
        int i3 = this.f43291b;
        boolean z2 = sampleStreamI != sampleStreamArr[i3];
        boolean zC = trackSelectorResult.c(i3);
        if (zC && !z2) {
            return 1;
        }
        if (!renderer.B()) {
            renderer.x(i(trackSelectorResult.f45457c[this.f43291b]), (SampleStream) Assertions.e(mediaPeriodHolder.f43145c[this.f43291b]), mediaPeriodHolder.n(), mediaPeriodHolder.m(), mediaPeriodHolder.f43150h.f43160a);
            return 3;
        }
        if (!renderer.b()) {
            return 0;
        }
        d(renderer, defaultMediaClock);
        if (!zC || u()) {
            E(renderer == this.f43290a);
        }
        return 1;
    }

    private void P(Renderer renderer, long j3) {
        renderer.p();
        if (renderer instanceof TextRenderer) {
            ((TextRenderer) renderer).I0(j3);
        }
    }

    private void X(boolean z2) {
        if (z2) {
            ((Renderer) Assertions.e(this.f43292c)).w(17, this.f43290a);
        } else {
            this.f43290a.w(17, Assertions.e(this.f43292c));
        }
    }

    private void d(Renderer renderer, DefaultMediaClock defaultMediaClock) {
        Assertions.g(this.f43290a == renderer || this.f43292c == renderer);
        if (y(renderer)) {
            defaultMediaClock.a(renderer);
            g(renderer);
            renderer.c();
        }
    }

    private void g(Renderer renderer) {
        if (renderer.getState() == 2) {
            renderer.stop();
        }
    }

    private static Format[] i(ExoTrackSelection exoTrackSelection) {
        int length = exoTrackSelection != null ? exoTrackSelection.length() : 0;
        Format[] formatArr = new Format[length];
        for (int i3 = 0; i3 < length; i3++) {
            formatArr[i3] = ((ExoTrackSelection) Assertions.e(exoTrackSelection)).b(i3);
        }
        return formatArr;
    }

    private Renderer l(MediaPeriodHolder mediaPeriodHolder) {
        if (mediaPeriodHolder != null && mediaPeriodHolder.f43145c[this.f43291b] != null) {
            if (this.f43290a.i() == mediaPeriodHolder.f43145c[this.f43291b]) {
                return this.f43290a;
            }
            Renderer renderer = this.f43292c;
            if (renderer != null && renderer.i() == mediaPeriodHolder.f43145c[this.f43291b]) {
                return this.f43292c;
            }
        }
        return null;
    }

    private boolean p(MediaPeriodHolder mediaPeriodHolder, Renderer renderer) {
        if (renderer == null) {
            return true;
        }
        SampleStream sampleStream = mediaPeriodHolder.f43145c[this.f43291b];
        if (renderer.i() == null || (renderer.i() == sampleStream && (sampleStream == null || renderer.k() || q(renderer, mediaPeriodHolder)))) {
            return true;
        }
        MediaPeriodHolder mediaPeriodHolderK = mediaPeriodHolder.k();
        return mediaPeriodHolderK != null && mediaPeriodHolderK.f43145c[this.f43291b] == renderer.i();
    }

    private boolean q(Renderer renderer, MediaPeriodHolder mediaPeriodHolder) {
        MediaPeriodHolder mediaPeriodHolderK = mediaPeriodHolder.k();
        if (mediaPeriodHolder.f43150h.f43166g && mediaPeriodHolderK != null && mediaPeriodHolderK.f43148f) {
            return (renderer instanceof TextRenderer) || (renderer instanceof MetadataRenderer) || renderer.O() >= mediaPeriodHolderK.n();
        }
        return false;
    }

    private boolean v() {
        int i3 = this.f43293d;
        return i3 == 2 || i3 == 4;
    }

    private static boolean y(Renderer renderer) {
        return renderer.getState() != 0;
    }

    public void B(SampleStream sampleStream, DefaultMediaClock defaultMediaClock, long j3, boolean z2) {
        C(this.f43290a, sampleStream, defaultMediaClock, j3, z2);
        Renderer renderer = this.f43292c;
        if (renderer != null) {
            C(renderer, sampleStream, defaultMediaClock, j3, z2);
        }
    }

    public void D() {
        int i3 = this.f43293d;
        if (i3 == 3 || i3 == 4) {
            X(i3 == 4);
            this.f43293d = this.f43293d != 4 ? 1 : 0;
        } else if (i3 == 2) {
            this.f43293d = 0;
        }
    }

    public void F(TrackSelectorResult trackSelectorResult, TrackSelectorResult trackSelectorResult2, long j3) {
        int i3;
        boolean zC = trackSelectorResult.c(this.f43291b);
        boolean zC2 = trackSelectorResult2.c(this.f43291b);
        Renderer renderer = (this.f43292c == null || (i3 = this.f43293d) == 3 || (i3 == 0 && y(this.f43290a))) ? this.f43290a : (Renderer) Assertions.e(this.f43292c);
        if (!zC || renderer.B()) {
            return;
        }
        boolean z2 = m() == -2;
        RendererConfiguration[] rendererConfigurationArr = trackSelectorResult.f45456b;
        int i4 = this.f43291b;
        RendererConfiguration rendererConfiguration = rendererConfigurationArr[i4];
        RendererConfiguration rendererConfiguration2 = trackSelectorResult2.f45456b[i4];
        if (!zC2 || !Objects.equals(rendererConfiguration2, rendererConfiguration) || z2 || u()) {
            P(renderer, j3);
        }
    }

    public void G(MediaPeriodHolder mediaPeriodHolder) {
        ((Renderer) Assertions.e(l(mediaPeriodHolder))).y();
    }

    public void H() {
        this.f43290a.release();
        this.f43294e = false;
        Renderer renderer = this.f43292c;
        if (renderer != null) {
            renderer.release();
            this.f43295f = false;
        }
    }

    public void I(long j3, long j4) {
        if (y(this.f43290a)) {
            this.f43290a.h(j3, j4);
        }
        Renderer renderer = this.f43292c;
        if (renderer == null || !y(renderer)) {
            return;
        }
        this.f43292c.h(j3, j4);
    }

    public int J(MediaPeriodHolder mediaPeriodHolder, TrackSelectorResult trackSelectorResult, DefaultMediaClock defaultMediaClock) {
        int iK = K(this.f43290a, mediaPeriodHolder, trackSelectorResult, defaultMediaClock);
        return iK == 1 ? K(this.f43292c, mediaPeriodHolder, trackSelectorResult, defaultMediaClock) : iK;
    }

    public void L() {
        if (!y(this.f43290a)) {
            E(true);
        }
        Renderer renderer = this.f43292c;
        if (renderer == null || y(renderer)) {
            return;
        }
        E(false);
    }

    public void M(MediaPeriodHolder mediaPeriodHolder, long j3) {
        Renderer rendererL = l(mediaPeriodHolder);
        if (rendererL != null) {
            rendererL.P(j3);
        }
    }

    public void N(long j3) {
        int i3;
        if (y(this.f43290a) && (i3 = this.f43293d) != 4 && i3 != 2) {
            P(this.f43290a, j3);
        }
        Renderer renderer = this.f43292c;
        if (renderer == null || !y(renderer) || this.f43293d == 3) {
            return;
        }
        P(this.f43292c, j3);
    }

    public void O(MediaPeriodHolder mediaPeriodHolder, long j3) {
        P((Renderer) Assertions.e(l(mediaPeriodHolder)), j3);
    }

    public void Q(float f3, float f4) {
        this.f43290a.L(f3, f4);
        Renderer renderer = this.f43292c;
        if (renderer != null) {
            renderer.L(f3, f4);
        }
    }

    public void R(Timeline timeline) {
        this.f43290a.F(timeline);
        Renderer renderer = this.f43292c;
        if (renderer != null) {
            renderer.F(timeline);
        }
    }

    public void S(Object obj) {
        if (m() != 2) {
            return;
        }
        int i3 = this.f43293d;
        if (i3 == 4 || i3 == 1) {
            ((Renderer) Assertions.e(this.f43292c)).w(1, obj);
        } else {
            this.f43290a.w(1, obj);
        }
    }

    public void T(float f3) {
        if (m() != 1) {
            return;
        }
        this.f43290a.w(2, Float.valueOf(f3));
        Renderer renderer = this.f43292c;
        if (renderer != null) {
            renderer.w(2, Float.valueOf(f3));
        }
    }

    public void U() {
        if (this.f43290a.getState() == 1 && this.f43293d != 4) {
            this.f43290a.start();
            return;
        }
        Renderer renderer = this.f43292c;
        if (renderer == null || renderer.getState() != 1 || this.f43293d == 3) {
            return;
        }
        this.f43292c.start();
    }

    public void V() {
        int i3;
        Assertions.g(!u());
        if (y(this.f43290a)) {
            i3 = 3;
        } else {
            Renderer renderer = this.f43292c;
            i3 = (renderer == null || !y(renderer)) ? 2 : 4;
        }
        this.f43293d = i3;
    }

    public void W() {
        if (y(this.f43290a)) {
            g(this.f43290a);
        }
        Renderer renderer = this.f43292c;
        if (renderer == null || !y(renderer)) {
            return;
        }
        g(this.f43292c);
    }

    public boolean a(MediaPeriodHolder mediaPeriodHolder) {
        Renderer rendererL = l(mediaPeriodHolder);
        return rendererL == null || rendererL.k() || rendererL.isReady() || rendererL.b();
    }

    public void b(DefaultMediaClock defaultMediaClock) {
        d(this.f43290a, defaultMediaClock);
        Renderer renderer = this.f43292c;
        if (renderer != null) {
            boolean z2 = y(renderer) && this.f43293d != 3;
            d(this.f43292c, defaultMediaClock);
            E(false);
            if (z2) {
                X(true);
            }
        }
        this.f43293d = 0;
    }

    public void c(DefaultMediaClock defaultMediaClock) {
        if (u()) {
            int i3 = this.f43293d;
            boolean z2 = i3 == 4 || i3 == 2;
            int i4 = i3 != 4 ? 0 : 1;
            d(z2 ? this.f43290a : (Renderer) Assertions.e(this.f43292c), defaultMediaClock);
            E(z2);
            this.f43293d = i4;
        }
    }

    public void e(RendererConfiguration rendererConfiguration, ExoTrackSelection exoTrackSelection, SampleStream sampleStream, long j3, boolean z2, boolean z3, long j4, long j5, MediaSource.MediaPeriodId mediaPeriodId, DefaultMediaClock defaultMediaClock) throws ExoPlaybackException {
        Format[] formatArrI = i(exoTrackSelection);
        int i3 = this.f43293d;
        if (i3 == 0 || i3 == 2 || i3 == 4) {
            this.f43294e = true;
            this.f43290a.m(rendererConfiguration, formatArrI, sampleStream, j3, z2, z3, j4, j5, mediaPeriodId);
            defaultMediaClock.b(this.f43290a);
        } else {
            this.f43295f = true;
            ((Renderer) Assertions.e(this.f43292c)).m(rendererConfiguration, formatArrI, sampleStream, j3, z2, z3, j4, j5, mediaPeriodId);
            defaultMediaClock.b(this.f43292c);
        }
    }

    public void f() {
        if (y(this.f43290a)) {
            this.f43290a.f();
            return;
        }
        Renderer renderer = this.f43292c;
        if (renderer == null || !y(renderer)) {
            return;
        }
        this.f43292c.f();
    }

    public int h() {
        boolean zY = y(this.f43290a);
        Renderer renderer = this.f43292c;
        return (zY ? 1 : 0) + ((renderer == null || !y(renderer)) ? 0 : 1);
    }

    public long j(long j3, long j4) {
        long jE = y(this.f43290a) ? this.f43290a.E(j3, j4) : Long.MAX_VALUE;
        Renderer renderer = this.f43292c;
        return (renderer == null || !y(renderer)) ? jE : Math.min(jE, this.f43292c.E(j3, j4));
    }

    public long k(MediaPeriodHolder mediaPeriodHolder) {
        Renderer rendererL = l(mediaPeriodHolder);
        Objects.requireNonNull(rendererL);
        return rendererL.O();
    }

    public int m() {
        return this.f43290a.g();
    }

    public void n(int i3, Object obj, MediaPeriodHolder mediaPeriodHolder) {
        ((Renderer) Assertions.e(l(mediaPeriodHolder))).w(i3, obj);
    }

    public boolean o(MediaPeriodHolder mediaPeriodHolder) {
        return p(mediaPeriodHolder, this.f43290a) && p(mediaPeriodHolder, this.f43292c);
    }

    public boolean r(MediaPeriodHolder mediaPeriodHolder) {
        return ((Renderer) Assertions.e(l(mediaPeriodHolder))).k();
    }

    public boolean s() {
        return this.f43292c != null;
    }

    public boolean t() {
        boolean zB = y(this.f43290a) ? this.f43290a.b() : true;
        Renderer renderer = this.f43292c;
        return (renderer == null || !y(renderer)) ? zB : zB & this.f43292c.b();
    }

    public boolean u() {
        return v() || A();
    }

    public boolean w(MediaPeriodHolder mediaPeriodHolder) {
        return l(mediaPeriodHolder) != null;
    }

    public boolean x() {
        int i3 = this.f43293d;
        return (i3 == 0 || i3 == 2 || i3 == 4) ? y(this.f43290a) : y((Renderer) Assertions.e(this.f43292c));
    }

    public boolean z(int i3) {
        return (v() && i3 == this.f43291b) || (A() && i3 != this.f43291b);
    }
}
