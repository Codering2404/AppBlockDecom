package androidx.media3.exoplayer.audio;

import android.media.AudioDeviceInfo;
import android.os.SystemClock;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.AuxEffectInfo;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.TraceUtil;
import androidx.media3.common.util.Util;
import androidx.media3.decoder.CryptoConfig;
import androidx.media3.decoder.Decoder;
import androidx.media3.decoder.DecoderException;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.decoder.SimpleDecoderOutputBuffer;
import androidx.media3.exoplayer.BaseRenderer;
import androidx.media3.exoplayer.DecoderCounters;
import androidx.media3.exoplayer.DecoderReuseEvaluation;
import androidx.media3.exoplayer.ExoPlaybackException;
import androidx.media3.exoplayer.FormatHolder;
import androidx.media3.exoplayer.MediaClock;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.exoplayer.audio.AudioRendererEventListener;
import androidx.media3.exoplayer.audio.AudioSink;
import androidx.media3.exoplayer.drm.DrmSession;
import androidx.media3.exoplayer.source.MediaSource;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class DecoderAudioRenderer<T extends Decoder<DecoderInputBuffer, ? extends SimpleDecoderOutputBuffer, ? extends DecoderException>> extends BaseRenderer implements MediaClock {
    private Decoder A;
    private DecoderInputBuffer B;
    private SimpleDecoderOutputBuffer C;
    private DrmSession D;
    private DrmSession E;
    private int F;
    private boolean G;
    private boolean H;
    private long I;
    private boolean J;
    private boolean K;
    private boolean L;
    private long M;
    private final long[] N;
    private int O;
    private boolean P;
    private boolean Q;
    private long R;
    private long S;
    private long T;
    private boolean U;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final AudioRendererEventListener.EventDispatcher f43758s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final AudioSink f43759t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final DecoderInputBuffer f43760u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private DecoderCounters f43761v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private Format f43762w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f43763x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f43764y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private boolean f43765z;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class Api23 {
        public static void a(AudioSink audioSink, Object obj) {
            audioSink.setPreferredDevice((AudioDeviceInfo) obj);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private final class AudioSinkListener implements AudioSink.Listener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ DecoderAudioRenderer f43766a;

        @Override // androidx.media3.exoplayer.audio.AudioSink.Listener
        public void a(AudioSink.AudioTrackConfig audioTrackConfig) {
            this.f43766a.f43758s.o(audioTrackConfig);
        }

        @Override // androidx.media3.exoplayer.audio.AudioSink.Listener
        public void b(long j3) {
            this.f43766a.f43758s.v(j3);
        }

        @Override // androidx.media3.exoplayer.audio.AudioSink.Listener
        public void c(AudioSink.AudioTrackConfig audioTrackConfig) {
            this.f43766a.f43758s.p(audioTrackConfig);
        }

        @Override // androidx.media3.exoplayer.audio.AudioSink.Listener
        public void d(boolean z2) {
            this.f43766a.f43758s.w(z2);
        }

        @Override // androidx.media3.exoplayer.audio.AudioSink.Listener
        public void e(Exception exc) {
            Log.e("DecoderAudioRenderer", "Audio sink error", exc);
            this.f43766a.f43758s.n(exc);
        }

        @Override // androidx.media3.exoplayer.audio.AudioSink.Listener
        public void f() {
            this.f43766a.P = true;
        }

        @Override // androidx.media3.exoplayer.audio.AudioSink.Listener
        public void h(int i3, long j3, long j4) {
            this.f43766a.f43758s.x(i3, j3, j4);
        }

        @Override // androidx.media3.exoplayer.audio.AudioSink.Listener
        public void j() {
            this.f43766a.D0();
        }
    }

    private void B0() throws ExoPlaybackException {
        CryptoConfig cryptoConfigD;
        if (this.A != null) {
            return;
        }
        H0(this.E);
        DrmSession drmSession = this.D;
        if (drmSession != null) {
            cryptoConfigD = drmSession.d();
            if (cryptoConfigD == null && this.D.getError() == null) {
                return;
            }
        } else {
            cryptoConfigD = null;
        }
        try {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            TraceUtil.a("createAudioDecoder");
            Decoder decoderV0 = v0(this.f43762w, cryptoConfigD);
            this.A = decoderV0;
            decoderV0.e(Y());
            TraceUtil.b();
            long jElapsedRealtime2 = SystemClock.elapsedRealtime();
            this.f43758s.q(this.A.getName(), jElapsedRealtime2, jElapsedRealtime2 - jElapsedRealtime);
            this.f43761v.f42861a++;
        } catch (DecoderException e3) {
            Log.e("DecoderAudioRenderer", "Audio codec error", e3);
            this.f43758s.m(e3);
            throw S(e3, this.f43762w, 4001);
        } catch (OutOfMemoryError e4) {
            throw S(e4, this.f43762w, 4001);
        }
    }

    private void C0(FormatHolder formatHolder) throws ExoPlaybackException {
        Format format = (Format) Assertions.e(formatHolder.f43108b);
        J0(formatHolder.f43107a);
        Format format2 = this.f43762w;
        this.f43762w = format;
        this.f43763x = format.H;
        this.f43764y = format.I;
        Decoder decoder = this.A;
        if (decoder == null) {
            B0();
            this.f43758s.u(this.f43762w, null);
            return;
        }
        DecoderReuseEvaluation decoderReuseEvaluation = this.E != this.D ? new DecoderReuseEvaluation(decoder.getName(), format2, format, 0, ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) : u0(decoder.getName(), format2, format);
        if (decoderReuseEvaluation.f42876d == 0) {
            if (this.G) {
                this.F = 1;
            } else {
                G0();
                B0();
                this.H = true;
            }
        }
        this.f43758s.u(this.f43762w, decoderReuseEvaluation);
    }

    private void E0() {
        this.L = true;
        this.f43759t.p();
        this.T = this.S;
        this.U = true;
    }

    private void F0() {
        this.f43759t.u();
        if (this.O != 0) {
            I0(this.N[0]);
            int i3 = this.O - 1;
            this.O = i3;
            long[] jArr = this.N;
            System.arraycopy(jArr, 1, jArr, 0, i3);
        }
    }

    private void G0() {
        this.B = null;
        this.C = null;
        this.F = 0;
        this.G = false;
        this.R = -9223372036854775807L;
        this.S = -9223372036854775807L;
        Decoder decoder = this.A;
        if (decoder != null) {
            this.f43761v.f42862b++;
            decoder.release();
            this.f43758s.r(this.A.getName());
            this.A = null;
        }
        H0(null);
    }

    private void H0(DrmSession drmSession) {
        DrmSession.c(this.D, drmSession);
        this.D = drmSession;
    }

    private void I0(long j3) {
        this.M = j3;
        if (j3 != -9223372036854775807L) {
            this.f43759t.t(j3);
        }
    }

    private void J0(DrmSession drmSession) {
        DrmSession.c(this.E, drmSession);
        this.E = drmSession;
    }

    private void L0() {
        long jC = this.f43759t.c(b());
        if (jC != Long.MIN_VALUE) {
            if (!this.J) {
                jC = Math.max(this.I, jC);
            }
            this.I = jC;
            this.J = false;
        }
    }

    private boolean w0() throws ExoPlaybackException {
        if (this.C == null) {
            SimpleDecoderOutputBuffer simpleDecoderOutputBuffer = (SimpleDecoderOutputBuffer) this.A.a();
            this.C = simpleDecoderOutputBuffer;
            if (simpleDecoderOutputBuffer == null) {
                return false;
            }
            int i3 = simpleDecoderOutputBuffer.f42147c;
            if (i3 > 0) {
                this.f43761v.f42866f += i3;
                this.f43759t.u();
            }
            if (this.C.j()) {
                F0();
            }
        }
        if (this.C.i()) {
            if (this.F == 2) {
                G0();
                B0();
                this.H = true;
            } else {
                this.C.o();
                this.C = null;
                try {
                    E0();
                } catch (AudioSink.WriteException e3) {
                    throw T(e3, e3.f43716c, e3.f43715b, 5002);
                }
            }
            return false;
        }
        this.T = -9223372036854775807L;
        if (this.H) {
            this.f43759t.o(A0(this.A).b().Z(this.f43763x).a0(this.f43764y).n0(this.f43762w.f40629l).X(this.f43762w.f40630m).f0(this.f43762w.f40618a).h0(this.f43762w.f40619b).i0(this.f43762w.f40620c).j0(this.f43762w.f40621d).w0(this.f43762w.f40622e).s0(this.f43762w.f40623f).N(), 0, z0(this.A));
            this.H = false;
        }
        AudioSink audioSink = this.f43759t;
        SimpleDecoderOutputBuffer simpleDecoderOutputBuffer2 = this.C;
        if (!audioSink.n(simpleDecoderOutputBuffer2.f42165g, simpleDecoderOutputBuffer2.f42146b, 1)) {
            this.T = this.C.f42146b;
            return false;
        }
        this.f43761v.f42865e++;
        this.C.o();
        this.C = null;
        return true;
    }

    private boolean x0() throws ExoPlaybackException {
        Decoder decoder = this.A;
        if (decoder == null || this.F == 2 || this.K) {
            return false;
        }
        if (this.B == null) {
            DecoderInputBuffer decoderInputBuffer = (DecoderInputBuffer) decoder.f();
            this.B = decoderInputBuffer;
            if (decoderInputBuffer == null) {
                return false;
            }
        }
        if (this.F == 1) {
            this.B.n(4);
            this.A.b(this.B);
            this.B = null;
            this.F = 2;
            return false;
        }
        FormatHolder formatHolderW = W();
        int iP0 = p0(formatHolderW, this.B, 0);
        if (iP0 == -5) {
            C0(formatHolderW);
            return true;
        }
        if (iP0 != -4) {
            if (iP0 != -3) {
                throw new IllegalStateException();
            }
            if (k()) {
                this.S = this.R;
            }
            return false;
        }
        if (this.B.i()) {
            this.K = true;
            this.S = this.R;
            this.A.b(this.B);
            this.B = null;
            return false;
        }
        if (!this.f43765z) {
            this.f43765z = true;
            this.B.e(134217728);
        }
        this.R = this.B.f42140g;
        if (k() || this.B.l()) {
            this.S = this.R;
        }
        this.B.q();
        DecoderInputBuffer decoderInputBuffer2 = this.B;
        decoderInputBuffer2.f42136b = this.f43762w;
        this.A.b(decoderInputBuffer2);
        this.G = true;
        this.f43761v.f42863c++;
        this.B = null;
        return true;
    }

    private void y0() throws ExoPlaybackException {
        if (this.F != 0) {
            G0();
            B0();
            return;
        }
        this.B = null;
        SimpleDecoderOutputBuffer simpleDecoderOutputBuffer = this.C;
        if (simpleDecoderOutputBuffer != null) {
            simpleDecoderOutputBuffer.o();
            this.C = null;
        }
        Decoder decoder = (Decoder) Assertions.e(this.A);
        decoder.flush();
        decoder.e(Y());
        this.G = false;
    }

    protected abstract Format A0(Decoder decoder);

    protected void D0() {
        this.J = true;
    }

    @Override // androidx.media3.exoplayer.Renderer
    public long E(long j3, long j4) {
        if (this.T == -9223372036854775807L) {
            return super.E(j3, j4);
        }
        long j5 = this.f43759t.j();
        if (!this.U && j5 == -9223372036854775807L) {
            return super.E(j3, j4);
        }
        long jMin = this.T - j3;
        if (j5 != -9223372036854775807L) {
            jMin = Math.min(j5, jMin);
        }
        long jP0 = (long) ((jMin / (d() != null ? d().f40953a : 1.0f)) / 2.0f);
        if (this.Q) {
            jP0 -= Util.P0(U().a()) - j4;
        }
        return Math.max(10000L, jP0);
    }

    @Override // androidx.media3.exoplayer.MediaClock
    public long K() {
        if (getState() == 2) {
            L0();
        }
        return this.I;
    }

    protected abstract int K0(Format format);

    @Override // androidx.media3.exoplayer.RendererCapabilities
    public final int a(Format format) {
        if (!MimeTypes.n(format.f40632o)) {
            return RendererCapabilities.u(0);
        }
        int iK0 = K0(format);
        return iK0 <= 2 ? RendererCapabilities.u(iK0) : RendererCapabilities.J(iK0, 8, 32);
    }

    @Override // androidx.media3.exoplayer.Renderer
    public boolean b() {
        return this.L && this.f43759t.b();
    }

    @Override // androidx.media3.exoplayer.MediaClock
    public PlaybackParameters d() {
        return this.f43759t.d();
    }

    @Override // androidx.media3.exoplayer.MediaClock
    public void e(PlaybackParameters playbackParameters) {
        this.f43759t.e(playbackParameters);
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    protected void e0() {
        this.f43762w = null;
        this.H = true;
        I0(-9223372036854775807L);
        this.P = false;
        this.T = -9223372036854775807L;
        this.U = false;
        try {
            J0(null);
            G0();
            this.f43759t.reset();
        } finally {
            this.f43758s.s(this.f43761v);
        }
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    protected void f0(boolean z2, boolean z3) {
        DecoderCounters decoderCounters = new DecoderCounters();
        this.f43761v = decoderCounters;
        this.f43758s.t(decoderCounters);
        if (V().f43289b) {
            this.f43759t.v();
        } else {
            this.f43759t.m();
        }
        this.f43759t.s(Z());
        this.f43759t.z(U());
    }

    @Override // androidx.media3.exoplayer.Renderer
    public void h(long j3, long j4) throws ExoPlaybackException {
        if (this.L) {
            try {
                this.f43759t.p();
                this.T = this.S;
                this.U = true;
                return;
            } catch (AudioSink.WriteException e3) {
                throw T(e3, e3.f43716c, e3.f43715b, 5002);
            }
        }
        if (this.f43762w == null) {
            FormatHolder formatHolderW = W();
            this.f43760u.f();
            int iP0 = p0(formatHolderW, this.f43760u, 2);
            if (iP0 != -5) {
                if (iP0 == -4) {
                    Assertions.g(this.f43760u.i());
                    this.K = true;
                    try {
                        E0();
                        return;
                    } catch (AudioSink.WriteException e4) {
                        throw S(e4, null, 5002);
                    }
                }
                return;
            }
            C0(formatHolderW);
        }
        B0();
        if (this.A != null) {
            try {
                TraceUtil.a("drainAndFeed");
                while (w0()) {
                }
                while (x0()) {
                }
                TraceUtil.b();
                this.f43761v.c();
            } catch (DecoderException e5) {
                Log.e("DecoderAudioRenderer", "Audio codec error", e5);
                this.f43758s.m(e5);
                throw S(e5, this.f43762w, 4003);
            } catch (AudioSink.ConfigurationException e6) {
                throw S(e6, e6.f43708a, 5001);
            } catch (AudioSink.InitializationException e7) {
                throw T(e7, e7.f43711c, e7.f43710b, 5001);
            } catch (AudioSink.WriteException e8) {
                throw T(e8, e8.f43716c, e8.f43715b, 5002);
            }
        }
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    protected void h0(long j3, boolean z2) throws ExoPlaybackException {
        this.f43759t.flush();
        this.I = j3;
        this.T = -9223372036854775807L;
        this.U = false;
        this.P = false;
        this.J = true;
        this.K = false;
        this.L = false;
        if (this.A != null) {
            y0();
        }
    }

    @Override // androidx.media3.exoplayer.Renderer
    public boolean isReady() {
        if (this.f43759t.h()) {
            return true;
        }
        if (this.f43762w != null) {
            return d0() || this.C != null;
        }
        return false;
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    protected void l0() {
        this.f43759t.q();
        this.Q = true;
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    protected void m0() {
        L0();
        this.f43759t.pause();
        this.Q = false;
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    protected void n0(Format[] formatArr, long j3, long j4, MediaSource.MediaPeriodId mediaPeriodId) {
        super.n0(formatArr, j3, j4, mediaPeriodId);
        this.f43765z = false;
        if (this.M == -9223372036854775807L) {
            I0(j4);
            return;
        }
        int i3 = this.O;
        if (i3 == this.N.length) {
            Log.i("DecoderAudioRenderer", "Too many stream changes, so dropping offset: " + this.N[this.O - 1]);
        } else {
            this.O = i3 + 1;
        }
        this.N[this.O - 1] = j4;
    }

    protected DecoderReuseEvaluation u0(String str, Format format, Format format2) {
        return new DecoderReuseEvaluation(str, format, format2, 0, 1);
    }

    @Override // androidx.media3.exoplayer.MediaClock
    public boolean v() {
        boolean z2 = this.P;
        this.P = false;
        return z2;
    }

    protected abstract Decoder v0(Format format, CryptoConfig cryptoConfig);

    @Override // androidx.media3.exoplayer.BaseRenderer, androidx.media3.exoplayer.PlayerMessage.Target
    public void w(int i3, Object obj) {
        if (i3 == 2) {
            this.f43759t.setVolume(((Float) obj).floatValue());
            return;
        }
        if (i3 == 3) {
            this.f43759t.f((AudioAttributes) obj);
            return;
        }
        if (i3 == 6) {
            this.f43759t.y((AuxEffectInfo) obj);
            return;
        }
        if (i3 == 12) {
            if (Util.f41609a >= 23) {
                Api23.a(this.f43759t, obj);
            }
        } else if (i3 == 9) {
            this.f43759t.x(((Boolean) obj).booleanValue());
        } else if (i3 != 10) {
            super.w(i3, obj);
        } else {
            this.f43759t.i(((Integer) obj).intValue());
        }
    }

    protected int[] z0(Decoder decoder) {
        return null;
    }

    @Override // androidx.media3.exoplayer.BaseRenderer, androidx.media3.exoplayer.Renderer
    public MediaClock Q() {
        return this;
    }
}
