package androidx.media3.exoplayer.video;

import android.os.SystemClock;
import android.view.Surface;
import androidx.media3.common.Format;
import androidx.media3.common.VideoSize;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.TimedValueQueue;
import androidx.media3.common.util.TraceUtil;
import androidx.media3.common.util.Util;
import androidx.media3.decoder.CryptoConfig;
import androidx.media3.decoder.Decoder;
import androidx.media3.decoder.DecoderException;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.decoder.VideoDecoderOutputBuffer;
import androidx.media3.exoplayer.BaseRenderer;
import androidx.media3.exoplayer.DecoderCounters;
import androidx.media3.exoplayer.DecoderReuseEvaluation;
import androidx.media3.exoplayer.ExoPlaybackException;
import androidx.media3.exoplayer.FormatHolder;
import androidx.media3.exoplayer.drm.DrmSession;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.video.VideoRendererEventListener;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class DecoderVideoRenderer extends BaseRenderer {
    private DecoderInputBuffer A;
    private VideoDecoderOutputBuffer B;
    private int C;
    private Object D;
    private Surface E;
    private VideoDecoderOutputBufferRenderer F;
    private VideoFrameMetadataListener G;
    private DrmSession H;
    private DrmSession I;
    private int J;
    private boolean K;
    private int L;
    private long M;
    private long N;
    private boolean O;
    private boolean P;
    private boolean Q;
    private VideoSize R;
    private long S;
    private int T;
    private int U;
    private int V;
    private long W;
    protected DecoderCounters X;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final long f45664s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final int f45665t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final VideoRendererEventListener.EventDispatcher f45666u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final TimedValueQueue f45667v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final DecoderInputBuffer f45668w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private Format f45669x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private Format f45670y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private Decoder f45671z;

    private static boolean A0(long j3) {
        return j3 < -500000;
    }

    private void B0(int i3) {
        this.L = Math.min(this.L, i3);
    }

    private void D0() throws ExoPlaybackException {
        CryptoConfig cryptoConfigD;
        if (this.f45671z != null) {
            return;
        }
        T0(this.I);
        DrmSession drmSession = this.H;
        if (drmSession != null) {
            cryptoConfigD = drmSession.d();
            if (cryptoConfigD == null && this.H.getError() == null) {
                return;
            }
        } else {
            cryptoConfigD = null;
        }
        try {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            Decoder decoderT0 = t0((Format) Assertions.e(this.f45669x), cryptoConfigD);
            this.f45671z = decoderT0;
            decoderT0.e(Y());
            U0(this.C);
            long jElapsedRealtime2 = SystemClock.elapsedRealtime();
            this.f45666u.k(((Decoder) Assertions.e(this.f45671z)).getName(), jElapsedRealtime2, jElapsedRealtime2 - jElapsedRealtime);
            this.X.f42861a++;
        } catch (DecoderException e3) {
            Log.e("DecoderVideoRenderer", "Video codec error", e3);
            this.f45666u.s(e3);
            throw S(e3, this.f45669x, 4001);
        } catch (OutOfMemoryError e4) {
            throw S(e4, this.f45669x, 4001);
        }
    }

    private void E0() {
        if (this.T > 0) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            this.f45666u.n(this.T, jElapsedRealtime - this.S);
            this.T = 0;
            this.S = jElapsedRealtime;
        }
    }

    private void F0() {
        if (this.L != 3) {
            this.L = 3;
            Object obj = this.D;
            if (obj != null) {
                this.f45666u.q(obj);
            }
        }
    }

    private void G0(int i3, int i4) {
        VideoSize videoSize = this.R;
        if (videoSize != null && videoSize.f41258a == i3 && videoSize.f41259b == i4) {
            return;
        }
        VideoSize videoSize2 = new VideoSize(i3, i4);
        this.R = videoSize2;
        this.f45666u.t(videoSize2);
    }

    private void H0() {
        Object obj;
        if (this.L != 3 || (obj = this.D) == null) {
            return;
        }
        this.f45666u.q(obj);
    }

    private void I0() {
        VideoSize videoSize = this.R;
        if (videoSize != null) {
            this.f45666u.t(videoSize);
        }
    }

    private void K0() {
        I0();
        B0(1);
        if (getState() == 2) {
            V0();
        }
    }

    private void L0() {
        this.R = null;
        B0(1);
    }

    private void M0() {
        I0();
        H0();
    }

    private boolean P0(long j3, long j4) {
        if (this.M == -9223372036854775807L) {
            this.M = j3;
        }
        VideoDecoderOutputBuffer videoDecoderOutputBuffer = (VideoDecoderOutputBuffer) Assertions.e(this.B);
        long j5 = videoDecoderOutputBuffer.f42146b;
        long j6 = j5 - j3;
        if (!y0()) {
            if (!z0(j6)) {
                return false;
            }
            c1(videoDecoderOutputBuffer);
            return true;
        }
        Format format = (Format) this.f45667v.j(j5);
        if (format != null) {
            this.f45670y = format;
        } else if (this.f45670y == null) {
            this.f45670y = (Format) this.f45667v.i();
        }
        long jB0 = j5 - b0();
        if (a1(j6)) {
            R0(videoDecoderOutputBuffer, jB0, (Format) Assertions.e(this.f45670y));
            return true;
        }
        if (getState() != 2 || j3 == this.M || (Y0(j6, j4) && C0(j3))) {
            return false;
        }
        if (Z0(j6, j4)) {
            v0(videoDecoderOutputBuffer);
            return true;
        }
        if (j6 < 30000) {
            R0(videoDecoderOutputBuffer, jB0, (Format) Assertions.e(this.f45670y));
            return true;
        }
        return false;
    }

    private void T0(DrmSession drmSession) {
        DrmSession.c(this.H, drmSession);
        this.H = drmSession;
    }

    private void V0() {
        this.N = this.f45664s > 0 ? SystemClock.elapsedRealtime() + this.f45664s : -9223372036854775807L;
    }

    private void X0(DrmSession drmSession) {
        DrmSession.c(this.I, drmSession);
        this.I = drmSession;
    }

    private boolean a1(long j3) {
        boolean z2 = getState() == 2;
        int i3 = this.L;
        if (i3 == 0) {
            return z2;
        }
        if (i3 == 1) {
            return true;
        }
        if (i3 == 3) {
            return z2 && b1(j3, Util.P0(SystemClock.elapsedRealtime()) - this.W);
        }
        throw new IllegalStateException();
    }

    private boolean u0(long j3, long j4) throws ExoPlaybackException {
        if (this.B == null) {
            VideoDecoderOutputBuffer videoDecoderOutputBuffer = (VideoDecoderOutputBuffer) ((Decoder) Assertions.e(this.f45671z)).a();
            this.B = videoDecoderOutputBuffer;
            if (videoDecoderOutputBuffer == null) {
                return false;
            }
            DecoderCounters decoderCounters = this.X;
            int i3 = decoderCounters.f42866f;
            int i4 = videoDecoderOutputBuffer.f42147c;
            decoderCounters.f42866f = i3 + i4;
            this.V -= i4;
        }
        if (!this.B.i()) {
            boolean zP0 = P0(j3, j4);
            if (zP0) {
                N0(((VideoDecoderOutputBuffer) Assertions.e(this.B)).f42146b);
                this.B = null;
            }
            return zP0;
        }
        if (this.J == 2) {
            Q0();
            D0();
        } else {
            this.B.o();
            this.B = null;
            this.Q = true;
        }
        return false;
    }

    private boolean w0() throws ExoPlaybackException {
        Decoder decoder = this.f45671z;
        if (decoder == null || this.J == 2 || this.P) {
            return false;
        }
        if (this.A == null) {
            DecoderInputBuffer decoderInputBuffer = (DecoderInputBuffer) decoder.f();
            this.A = decoderInputBuffer;
            if (decoderInputBuffer == null) {
                return false;
            }
        }
        DecoderInputBuffer decoderInputBuffer2 = (DecoderInputBuffer) Assertions.e(this.A);
        if (this.J == 1) {
            decoderInputBuffer2.n(4);
            ((Decoder) Assertions.e(this.f45671z)).b(decoderInputBuffer2);
            this.A = null;
            this.J = 2;
            return false;
        }
        FormatHolder formatHolderW = W();
        int iP0 = p0(formatHolderW, decoderInputBuffer2, 0);
        if (iP0 == -5) {
            J0(formatHolderW);
            return true;
        }
        if (iP0 != -4) {
            if (iP0 == -3) {
                return false;
            }
            throw new IllegalStateException();
        }
        if (decoderInputBuffer2.i()) {
            this.P = true;
            ((Decoder) Assertions.e(this.f45671z)).b(decoderInputBuffer2);
            this.A = null;
            return false;
        }
        if (this.O) {
            this.f45667v.a(decoderInputBuffer2.f42140g, (Format) Assertions.e(this.f45669x));
            this.O = false;
        }
        decoderInputBuffer2.q();
        decoderInputBuffer2.f42136b = this.f45669x;
        O0(decoderInputBuffer2);
        ((Decoder) Assertions.e(this.f45671z)).b(decoderInputBuffer2);
        this.V++;
        this.K = true;
        this.X.f42863c++;
        this.A = null;
        return true;
    }

    private boolean y0() {
        return this.C != -1;
    }

    private static boolean z0(long j3) {
        return j3 < -30000;
    }

    protected boolean C0(long j3) throws ExoPlaybackException {
        int iR0 = r0(j3);
        if (iR0 == 0) {
            return false;
        }
        this.X.f42870j++;
        d1(iR0, this.V);
        x0();
        return true;
    }

    protected void J0(FormatHolder formatHolder) throws ExoPlaybackException {
        this.O = true;
        Format format = (Format) Assertions.e(formatHolder.f43108b);
        X0(formatHolder.f43107a);
        Format format2 = this.f45669x;
        this.f45669x = format;
        Decoder decoder = this.f45671z;
        if (decoder == null) {
            D0();
            this.f45666u.p((Format) Assertions.e(this.f45669x), null);
            return;
        }
        DecoderReuseEvaluation decoderReuseEvaluation = this.I != this.H ? new DecoderReuseEvaluation(decoder.getName(), (Format) Assertions.e(format2), format, 0, ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) : s0(decoder.getName(), (Format) Assertions.e(format2), format);
        if (decoderReuseEvaluation.f42876d == 0) {
            if (this.K) {
                this.J = 1;
            } else {
                Q0();
                D0();
            }
        }
        this.f45666u.p((Format) Assertions.e(this.f45669x), decoderReuseEvaluation);
    }

    protected void N0(long j3) {
        this.V--;
    }

    protected void Q0() {
        this.A = null;
        this.B = null;
        this.J = 0;
        this.K = false;
        this.V = 0;
        Decoder decoder = this.f45671z;
        if (decoder != null) {
            this.X.f42862b++;
            decoder.release();
            this.f45666u.l(this.f45671z.getName());
            this.f45671z = null;
        }
        T0(null);
    }

    protected void R0(VideoDecoderOutputBuffer videoDecoderOutputBuffer, long j3, Format format) {
        VideoFrameMetadataListener videoFrameMetadataListener = this.G;
        if (videoFrameMetadataListener != null) {
            videoFrameMetadataListener.e(j3, U().b(), format, null);
        }
        this.W = Util.P0(SystemClock.elapsedRealtime());
        int i3 = videoDecoderOutputBuffer.f42166f;
        boolean z2 = i3 == 1 && this.E != null;
        boolean z3 = i3 == 0 && this.F != null;
        if (!z3 && !z2) {
            v0(videoDecoderOutputBuffer);
            return;
        }
        G0(videoDecoderOutputBuffer.f42167g, videoDecoderOutputBuffer.f42168h);
        if (z3) {
            ((VideoDecoderOutputBufferRenderer) Assertions.e(this.F)).setOutputBuffer(videoDecoderOutputBuffer);
        } else {
            S0(videoDecoderOutputBuffer, (Surface) Assertions.e(this.E));
        }
        this.U = 0;
        this.X.f42865e++;
        F0();
    }

    protected abstract void S0(VideoDecoderOutputBuffer videoDecoderOutputBuffer, Surface surface);

    protected abstract void U0(int i3);

    protected final void W0(Object obj) {
        if (obj instanceof Surface) {
            this.E = (Surface) obj;
            this.F = null;
            this.C = 1;
        } else if (obj instanceof VideoDecoderOutputBufferRenderer) {
            this.E = null;
            this.F = (VideoDecoderOutputBufferRenderer) obj;
            this.C = 0;
        } else {
            this.E = null;
            this.F = null;
            this.C = -1;
            obj = null;
        }
        if (this.D == obj) {
            if (obj != null) {
                M0();
                return;
            }
            return;
        }
        this.D = obj;
        if (obj == null) {
            L0();
            return;
        }
        if (this.f45671z != null) {
            U0(this.C);
        }
        K0();
    }

    protected boolean Y0(long j3, long j4) {
        return A0(j3);
    }

    protected boolean Z0(long j3, long j4) {
        return z0(j3);
    }

    @Override // androidx.media3.exoplayer.Renderer
    public boolean b() {
        return this.Q;
    }

    protected boolean b1(long j3, long j4) {
        return z0(j3) && j4 > 100000;
    }

    protected void c1(VideoDecoderOutputBuffer videoDecoderOutputBuffer) {
        this.X.f42866f++;
        videoDecoderOutputBuffer.o();
    }

    protected void d1(int i3, int i4) {
        DecoderCounters decoderCounters = this.X;
        decoderCounters.f42868h += i3;
        int i5 = i3 + i4;
        decoderCounters.f42867g += i5;
        this.T += i5;
        int i6 = this.U + i5;
        this.U = i6;
        decoderCounters.f42869i = Math.max(i6, decoderCounters.f42869i);
        int i7 = this.f45665t;
        if (i7 <= 0 || this.T < i7) {
            return;
        }
        E0();
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    protected void e0() {
        this.f45669x = null;
        this.R = null;
        B0(0);
        try {
            X0(null);
            Q0();
        } finally {
            this.f45666u.m(this.X);
        }
    }

    @Override // androidx.media3.exoplayer.Renderer
    public void f() {
        if (this.L == 0) {
            this.L = 1;
        }
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    protected void f0(boolean z2, boolean z3) {
        DecoderCounters decoderCounters = new DecoderCounters();
        this.X = decoderCounters;
        this.f45666u.o(decoderCounters);
        this.L = z3 ? 1 : 0;
    }

    @Override // androidx.media3.exoplayer.Renderer
    public void h(long j3, long j4) throws ExoPlaybackException {
        if (this.Q) {
            return;
        }
        if (this.f45669x == null) {
            FormatHolder formatHolderW = W();
            this.f45668w.f();
            int iP0 = p0(formatHolderW, this.f45668w, 2);
            if (iP0 != -5) {
                if (iP0 == -4) {
                    Assertions.g(this.f45668w.i());
                    this.P = true;
                    this.Q = true;
                    return;
                }
                return;
            }
            J0(formatHolderW);
        }
        D0();
        if (this.f45671z != null) {
            try {
                TraceUtil.a("drainAndFeed");
                while (u0(j3, j4)) {
                }
                while (w0()) {
                }
                TraceUtil.b();
                this.X.c();
            } catch (DecoderException e3) {
                Log.e("DecoderVideoRenderer", "Video codec error", e3);
                this.f45666u.s(e3);
                throw S(e3, this.f45669x, 4003);
            }
        }
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    protected void h0(long j3, boolean z2) throws ExoPlaybackException {
        this.P = false;
        this.Q = false;
        B0(1);
        this.M = -9223372036854775807L;
        this.U = 0;
        if (this.f45671z != null) {
            x0();
        }
        if (z2) {
            V0();
        } else {
            this.N = -9223372036854775807L;
        }
        this.f45667v.c();
    }

    @Override // androidx.media3.exoplayer.Renderer
    public boolean isReady() {
        if (this.f45669x != null && ((d0() || this.B != null) && (this.L == 3 || !y0()))) {
            this.N = -9223372036854775807L;
            return true;
        }
        if (this.N == -9223372036854775807L) {
            return false;
        }
        if (SystemClock.elapsedRealtime() < this.N) {
            return true;
        }
        this.N = -9223372036854775807L;
        return false;
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    protected void l0() {
        this.T = 0;
        this.S = SystemClock.elapsedRealtime();
        this.W = Util.P0(SystemClock.elapsedRealtime());
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    protected void m0() {
        this.N = -9223372036854775807L;
        E0();
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    protected void n0(Format[] formatArr, long j3, long j4, MediaSource.MediaPeriodId mediaPeriodId) {
        super.n0(formatArr, j3, j4, mediaPeriodId);
    }

    protected DecoderReuseEvaluation s0(String str, Format format, Format format2) {
        return new DecoderReuseEvaluation(str, format, format2, 0, 1);
    }

    protected abstract Decoder t0(Format format, CryptoConfig cryptoConfig);

    protected void v0(VideoDecoderOutputBuffer videoDecoderOutputBuffer) {
        d1(0, 1);
        videoDecoderOutputBuffer.o();
    }

    @Override // androidx.media3.exoplayer.BaseRenderer, androidx.media3.exoplayer.PlayerMessage.Target
    public void w(int i3, Object obj) {
        if (i3 == 1) {
            W0(obj);
        } else if (i3 == 7) {
            this.G = (VideoFrameMetadataListener) obj;
        } else {
            super.w(i3, obj);
        }
    }

    protected void x0() throws ExoPlaybackException {
        this.V = 0;
        if (this.J != 0) {
            Q0();
            D0();
            return;
        }
        this.A = null;
        VideoDecoderOutputBuffer videoDecoderOutputBuffer = this.B;
        if (videoDecoderOutputBuffer != null) {
            videoDecoderOutputBuffer.o();
            this.B = null;
        }
        Decoder decoder = (Decoder) Assertions.e(this.f45671z);
        decoder.flush();
        decoder.e(Y());
        this.K = false;
    }

    protected void O0(DecoderInputBuffer decoderInputBuffer) {
    }
}
