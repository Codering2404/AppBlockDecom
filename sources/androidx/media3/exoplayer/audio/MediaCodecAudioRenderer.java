package androidx.media3.exoplayer.audio;

import android.content.Context;
import android.media.AudioDeviceInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.AuxEffectInfo;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.MediaFormatUtil;
import androidx.media3.common.util.Util;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.DecoderReuseEvaluation;
import androidx.media3.exoplayer.ExoPlaybackException;
import androidx.media3.exoplayer.FormatHolder;
import androidx.media3.exoplayer.MediaClock;
import androidx.media3.exoplayer.Renderer;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.exoplayer.audio.AudioRendererEventListener;
import androidx.media3.exoplayer.audio.AudioSink;
import androidx.media3.exoplayer.mediacodec.LoudnessCodecController;
import androidx.media3.exoplayer.mediacodec.MediaCodecAdapter;
import androidx.media3.exoplayer.mediacodec.MediaCodecInfo;
import androidx.media3.exoplayer.mediacodec.MediaCodecRenderer;
import androidx.media3.exoplayer.mediacodec.MediaCodecSelector;
import androidx.media3.exoplayer.mediacodec.MediaCodecUtil;
import androidx.media3.extractor.VorbisUtil;
import com.google.common.collect.ImmutableList;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class MediaCodecAudioRenderer extends MediaCodecRenderer implements MediaClock {
    private final Context G0;
    private final AudioRendererEventListener.EventDispatcher H0;
    private final AudioSink I0;
    private final LoudnessCodecController J0;
    private int K0;
    private boolean L0;
    private boolean M0;
    private Format N0;
    private Format O0;
    private long P0;
    private boolean Q0;
    private boolean R0;
    private boolean S0;
    private int T0;
    private boolean U0;
    private long V0;
    private boolean W0;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class Api23 {
        public static void a(AudioSink audioSink, Object obj) {
            audioSink.setPreferredDevice((AudioDeviceInfo) obj);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private final class AudioSinkListener implements AudioSink.Listener {
        private AudioSinkListener() {
        }

        @Override // androidx.media3.exoplayer.audio.AudioSink.Listener
        public void a(AudioSink.AudioTrackConfig audioTrackConfig) {
            MediaCodecAudioRenderer.this.H0.o(audioTrackConfig);
        }

        @Override // androidx.media3.exoplayer.audio.AudioSink.Listener
        public void b(long j3) {
            MediaCodecAudioRenderer.this.H0.v(j3);
        }

        @Override // androidx.media3.exoplayer.audio.AudioSink.Listener
        public void c(AudioSink.AudioTrackConfig audioTrackConfig) {
            MediaCodecAudioRenderer.this.H0.p(audioTrackConfig);
        }

        @Override // androidx.media3.exoplayer.audio.AudioSink.Listener
        public void d(boolean z2) {
            MediaCodecAudioRenderer.this.H0.w(z2);
        }

        @Override // androidx.media3.exoplayer.audio.AudioSink.Listener
        public void e(Exception exc) {
            Log.e("MediaCodecAudioRenderer", "Audio sink error", exc);
            MediaCodecAudioRenderer.this.H0.n(exc);
        }

        @Override // androidx.media3.exoplayer.audio.AudioSink.Listener
        public void f() {
            MediaCodecAudioRenderer.this.S0 = true;
        }

        @Override // androidx.media3.exoplayer.audio.AudioSink.Listener
        public void g() {
            Renderer.WakeupListener wakeupListenerB1 = MediaCodecAudioRenderer.this.b1();
            if (wakeupListenerB1 != null) {
                wakeupListenerB1.a();
            }
        }

        @Override // androidx.media3.exoplayer.audio.AudioSink.Listener
        public void h(int i3, long j3, long j4) {
            MediaCodecAudioRenderer.this.H0.x(i3, j3, j4);
        }

        @Override // androidx.media3.exoplayer.audio.AudioSink.Listener
        public void i() {
            MediaCodecAudioRenderer.this.j0();
        }

        @Override // androidx.media3.exoplayer.audio.AudioSink.Listener
        public void j() {
            MediaCodecAudioRenderer.this.n2();
        }

        @Override // androidx.media3.exoplayer.audio.AudioSink.Listener
        public void k() {
            Renderer.WakeupListener wakeupListenerB1 = MediaCodecAudioRenderer.this.b1();
            if (wakeupListenerB1 != null) {
                wakeupListenerB1.b();
            }
        }
    }

    public MediaCodecAudioRenderer(Context context, MediaCodecSelector mediaCodecSelector, Handler handler, AudioRendererEventListener audioRendererEventListener, AudioSink audioSink) {
        this(context, MediaCodecAdapter.Factory.a(context), mediaCodecSelector, false, handler, audioRendererEventListener, audioSink);
    }

    private static boolean f2(String str) {
        if (Util.f41609a >= 24 || !"OMX.SEC.aac.dec".equals(str) || !"samsung".equals(Build.MANUFACTURER)) {
            return false;
        }
        String str2 = Build.DEVICE;
        return str2.startsWith("zeroflte") || str2.startsWith("herolte") || str2.startsWith("heroqlte");
    }

    private static boolean g2(String str) {
        return str.equals("OMX.google.opus.decoder") || str.equals("c2.android.opus.decoder") || str.equals("OMX.google.vorbis.decoder") || str.equals("c2.android.vorbis.decoder");
    }

    private static boolean h2() {
        if (Util.f41609a != 23) {
            return false;
        }
        String str = Build.MODEL;
        return "ZTE B2017G".equals(str) || "AXON 7 mini".equals(str);
    }

    private int i2(Format format) {
        AudioOffloadSupport audioOffloadSupportG = this.I0.g(format);
        if (!audioOffloadSupportG.f43694a) {
            return 0;
        }
        int i3 = audioOffloadSupportG.f43695b ? 1536 : 512;
        return audioOffloadSupportG.f43696c ? i3 | 2048 : i3;
    }

    private int j2(MediaCodecInfo mediaCodecInfo, Format format) {
        int i3;
        if (!"OMX.google.raw.decoder".equals(mediaCodecInfo.f44264a) || (i3 = Util.f41609a) >= 24 || (i3 == 23 && Util.H0(this.G0))) {
            return format.f40633p;
        }
        return -1;
    }

    private static List l2(MediaCodecSelector mediaCodecSelector, Format format, boolean z2, AudioSink audioSink) {
        MediaCodecInfo mediaCodecInfoR;
        return format.f40632o == null ? ImmutableList.y() : (!audioSink.a(format) || (mediaCodecInfoR = MediaCodecUtil.r()) == null) ? MediaCodecUtil.n(mediaCodecSelector, format, z2, false) : ImmutableList.z(mediaCodecInfoR);
    }

    private void o2(int i3) {
        LoudnessCodecController loudnessCodecController;
        this.I0.i(i3);
        if (Util.f41609a < 35 || (loudnessCodecController = this.J0) == null) {
            return;
        }
        loudnessCodecController.e(i3);
    }

    private void p2() {
        MediaCodecAdapter mediaCodecAdapterO0 = O0();
        if (mediaCodecAdapterO0 != null && Util.f41609a >= 35) {
            Bundle bundle = new Bundle();
            bundle.putInt("importance", Math.max(0, -this.T0));
            mediaCodecAdapterO0.f(bundle);
        }
    }

    private void q2() {
        long jC = this.I0.c(b());
        if (jC != Long.MIN_VALUE) {
            if (!this.Q0) {
                jC = Math.max(this.P0, jC);
            }
            this.P0 = jC;
            this.Q0 = false;
        }
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected boolean A1(long j3, long j4, MediaCodecAdapter mediaCodecAdapter, ByteBuffer byteBuffer, int i3, int i4, int i5, long j5, boolean z2, boolean z3, Format format) throws ExoPlaybackException {
        Assertions.e(byteBuffer);
        this.V0 = -9223372036854775807L;
        if (this.O0 != null && (i4 & 2) != 0) {
            ((MediaCodecAdapter) Assertions.e(mediaCodecAdapter)).q(i3, false);
            return true;
        }
        if (z2) {
            if (mediaCodecAdapter != null) {
                mediaCodecAdapter.q(i3, false);
            }
            this.A0.f42866f += i5;
            this.I0.u();
            return true;
        }
        try {
            if (!this.I0.n(byteBuffer, j5, i5)) {
                this.V0 = j5;
                return false;
            }
            if (mediaCodecAdapter != null) {
                mediaCodecAdapter.q(i3, false);
            }
            this.A0.f42865e += i5;
            return true;
        } catch (AudioSink.InitializationException e3) {
            throw T(e3, this.N0, e3.f43710b, (!i1() || V().f43288a == 0) ? 5001 : 5004);
        } catch (AudioSink.WriteException e4) {
            throw T(e4, format, e4.f43715b, (!i1() || V().f43288a == 0) ? 5002 : 5003);
        }
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected void F1() throws ExoPlaybackException {
        try {
            this.I0.p();
            if (W0() != -9223372036854775807L) {
                this.V0 = W0();
            }
            this.W0 = true;
        } catch (AudioSink.WriteException e3) {
            throw T(e3, e3.f43716c, e3.f43715b, i1() ? 5003 : 5002);
        }
    }

    @Override // androidx.media3.exoplayer.MediaClock
    public long K() {
        if (getState() == 2) {
            q2();
        }
        return this.P0;
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected float S0(float f3, Format format, Format[] formatArr) {
        int iMax = -1;
        for (Format format2 : formatArr) {
            int i3 = format2.F;
            if (i3 != -1) {
                iMax = Math.max(iMax, i3);
            }
        }
        if (iMax == -1) {
            return -1.0f;
        }
        return iMax * f3;
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected List U0(MediaCodecSelector mediaCodecSelector, Format format, boolean z2) {
        return MediaCodecUtil.o(l2(mediaCodecSelector, format, z2, this.I0), format);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected boolean U1(Format format) {
        if (V().f43288a != 0) {
            int iI2 = i2(format);
            if ((iI2 & 512) != 0) {
                if (V().f43288a == 2 || (iI2 & 1024) != 0) {
                    return true;
                }
                if (format.H == 0 && format.I == 0) {
                    return true;
                }
            }
        }
        return this.I0.a(format);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected long V0(long j3, long j4, boolean z2) {
        if (this.V0 == -9223372036854775807L) {
            return super.V0(j3, j4, z2);
        }
        long j5 = this.I0.j();
        if (!this.W0 && j5 == -9223372036854775807L) {
            return super.V0(j3, j4, z2);
        }
        long jMin = this.V0 - j3;
        if (j5 != -9223372036854775807L) {
            jMin = Math.min(j5, jMin);
        }
        long jP0 = (long) ((jMin / (d() != null ? d().f40953a : 1.0f)) / 2.0f);
        if (this.U0) {
            jP0 -= Util.P0(U().a()) - j4;
        }
        return Math.max(10000L, jP0);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected int V1(MediaCodecSelector mediaCodecSelector, Format format) {
        int iI2;
        boolean z2;
        if (!MimeTypes.n(format.f40632o)) {
            return RendererCapabilities.u(0);
        }
        boolean z3 = true;
        boolean z4 = format.N != 0;
        boolean zW1 = MediaCodecRenderer.W1(format);
        int i3 = 8;
        if (!zW1 || (z4 && MediaCodecUtil.r() == null)) {
            iI2 = 0;
        } else {
            iI2 = i2(format);
            if (this.I0.a(format)) {
                return RendererCapabilities.r(4, 8, 32, iI2);
            }
        }
        if ("audio/raw".equals(format.f40632o) && !this.I0.a(format)) {
            return RendererCapabilities.u(1);
        }
        if (!this.I0.a(Util.i0(2, format.E, format.F))) {
            return RendererCapabilities.u(1);
        }
        List listL2 = l2(mediaCodecSelector, format, false, this.I0);
        if (listL2.isEmpty()) {
            return RendererCapabilities.u(1);
        }
        if (!zW1) {
            return RendererCapabilities.u(2);
        }
        MediaCodecInfo mediaCodecInfo = (MediaCodecInfo) listL2.get(0);
        boolean zO = mediaCodecInfo.o(format);
        if (zO) {
            z2 = true;
            z3 = zO;
        } else {
            for (int i4 = 1; i4 < listL2.size(); i4++) {
                MediaCodecInfo mediaCodecInfo2 = (MediaCodecInfo) listL2.get(i4);
                if (mediaCodecInfo2.o(format)) {
                    z2 = false;
                    mediaCodecInfo = mediaCodecInfo2;
                    break;
                }
            }
            z2 = true;
            z3 = zO;
        }
        int i5 = z3 ? 4 : 3;
        if (z3 && mediaCodecInfo.r(format)) {
            i3 = 16;
        }
        return RendererCapabilities.D(i5, i3, 32, mediaCodecInfo.f44271h ? 64 : 0, z2 ? ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD : 0, iI2);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected MediaCodecAdapter.Configuration X0(MediaCodecInfo mediaCodecInfo, Format format, MediaCrypto mediaCrypto, float f3) {
        this.K0 = k2(mediaCodecInfo, format, a0());
        this.L0 = f2(mediaCodecInfo.f44264a);
        this.M0 = g2(mediaCodecInfo.f44264a);
        MediaFormat mediaFormatM2 = m2(format, mediaCodecInfo.f44266c, this.K0, f3);
        this.O0 = (!"audio/raw".equals(mediaCodecInfo.f44265b) || "audio/raw".equals(format.f40632o)) ? null : format;
        return MediaCodecAdapter.Configuration.a(mediaCodecInfo, mediaFormatM2, format, mediaCrypto, this.J0);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.Renderer
    public boolean b() {
        return super.b() && this.I0.b();
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected void c1(DecoderInputBuffer decoderInputBuffer) {
        Format format;
        if (Util.f41609a < 29 || (format = decoderInputBuffer.f42136b) == null || !Objects.equals(format.f40632o, "audio/opus") || !i1()) {
            return;
        }
        ByteBuffer byteBuffer = (ByteBuffer) Assertions.e(decoderInputBuffer.f42141h);
        int i3 = ((Format) Assertions.e(decoderInputBuffer.f42136b)).H;
        if (byteBuffer.remaining() == 8) {
            this.I0.r(i3, (int) ((byteBuffer.order(ByteOrder.LITTLE_ENDIAN).getLong() * 48000) / 1000000000));
        }
    }

    @Override // androidx.media3.exoplayer.MediaClock
    public PlaybackParameters d() {
        return this.I0.d();
    }

    @Override // androidx.media3.exoplayer.MediaClock
    public void e(PlaybackParameters playbackParameters) {
        this.I0.e(playbackParameters);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.BaseRenderer
    protected void e0() {
        this.R0 = true;
        this.N0 = null;
        this.V0 = -9223372036854775807L;
        this.W0 = false;
        try {
            this.I0.flush();
            try {
                super.e0();
            } finally {
            }
        } catch (Throwable th) {
            try {
                super.e0();
                throw th;
            } finally {
            }
        }
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.BaseRenderer
    protected void f0(boolean z2, boolean z3) {
        super.f0(z2, z3);
        this.H0.t(this.A0);
        if (V().f43289b) {
            this.I0.v();
        } else {
            this.I0.m();
        }
        this.I0.s(Z());
        this.I0.z(U());
    }

    @Override // androidx.media3.exoplayer.Renderer, androidx.media3.exoplayer.RendererCapabilities
    public String getName() {
        return "MediaCodecAudioRenderer";
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.BaseRenderer
    protected void h0(long j3, boolean z2) throws ExoPlaybackException {
        super.h0(j3, z2);
        this.I0.flush();
        this.P0 = j3;
        this.V0 = -9223372036854775807L;
        this.W0 = false;
        this.S0 = false;
        this.Q0 = true;
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    protected void i0() {
        LoudnessCodecController loudnessCodecController;
        this.I0.release();
        if (Util.f41609a < 35 || (loudnessCodecController = this.J0) == null) {
            return;
        }
        loudnessCodecController.c();
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.Renderer
    public boolean isReady() {
        return this.I0.h() || super.isReady();
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.BaseRenderer
    protected void k0() {
        this.S0 = false;
        this.V0 = -9223372036854775807L;
        this.W0 = false;
        try {
            super.k0();
        } finally {
            if (this.R0) {
                this.R0 = false;
                this.I0.reset();
            }
        }
    }

    protected int k2(MediaCodecInfo mediaCodecInfo, Format format, Format[] formatArr) {
        int iJ2 = j2(mediaCodecInfo, format);
        if (formatArr.length == 1) {
            return iJ2;
        }
        for (Format format2 : formatArr) {
            if (mediaCodecInfo.e(format, format2).f42876d != 0) {
                iJ2 = Math.max(iJ2, j2(mediaCodecInfo, format2));
            }
        }
        return iJ2;
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.BaseRenderer
    protected void l0() {
        super.l0();
        this.I0.q();
        this.U0 = true;
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.BaseRenderer
    protected void m0() {
        q2();
        this.U0 = false;
        this.I0.pause();
        super.m0();
    }

    protected MediaFormat m2(Format format, String str, int i3, float f3) {
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", str);
        mediaFormat.setInteger("channel-count", format.E);
        mediaFormat.setInteger("sample-rate", format.F);
        MediaFormatUtil.u(mediaFormat, format.f40635r);
        MediaFormatUtil.p(mediaFormat, "max-input-size", i3);
        int i4 = Util.f41609a;
        if (i4 >= 23) {
            mediaFormat.setInteger("priority", 0);
            if (f3 != -1.0f && !h2()) {
                mediaFormat.setFloat("operating-rate", f3);
            }
        }
        if (i4 <= 28 && "audio/ac4".equals(format.f40632o)) {
            mediaFormat.setInteger("ac4-is-sync", 1);
        }
        if (i4 >= 24 && this.I0.w(Util.i0(4, format.E, format.F)) == 2) {
            mediaFormat.setInteger("pcm-encoding", 4);
        }
        if (i4 >= 32) {
            mediaFormat.setInteger("max-output-channel-count", 99);
        }
        if (i4 >= 35) {
            mediaFormat.setInteger("importance", Math.max(0, -this.T0));
        }
        return mediaFormat;
    }

    protected void n2() {
        this.Q0 = true;
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected void p1(Exception exc) {
        Log.e("MediaCodecAudioRenderer", "Audio codec error", exc);
        this.H0.m(exc);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected void q1(String str, MediaCodecAdapter.Configuration configuration, long j3, long j4) {
        this.H0.q(str, j3, j4);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected void r1(String str) {
        this.H0.r(str);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected DecoderReuseEvaluation s1(FormatHolder formatHolder) throws ExoPlaybackException {
        Format format = (Format) Assertions.e(formatHolder.f43108b);
        this.N0 = format;
        DecoderReuseEvaluation decoderReuseEvaluationS1 = super.s1(formatHolder);
        this.H0.u(format, decoderReuseEvaluationS1);
        return decoderReuseEvaluationS1;
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected void t1(Format format, MediaFormat mediaFormat) throws ExoPlaybackException {
        int i3;
        Format format2 = this.O0;
        int[] iArrA = null;
        if (format2 != null) {
            format = format2;
        } else if (O0() != null) {
            Assertions.e(mediaFormat);
            Format formatN = new Format.Builder().u0("audio/raw").o0("audio/raw".equals(format.f40632o) ? format.G : (Util.f41609a < 24 || !mediaFormat.containsKey("pcm-encoding")) ? mediaFormat.containsKey("v-bits-per-sample") ? Util.h0(mediaFormat.getInteger("v-bits-per-sample")) : 2 : mediaFormat.getInteger("pcm-encoding")).Z(format.H).a0(format.I).n0(format.f40629l).X(format.f40630m).f0(format.f40618a).h0(format.f40619b).i0(format.f40620c).j0(format.f40621d).w0(format.f40622e).s0(format.f40623f).R(mediaFormat.getInteger("channel-count")).v0(mediaFormat.getInteger("sample-rate")).N();
            if (this.L0 && formatN.E == 6 && (i3 = format.E) < 6) {
                iArrA = new int[i3];
                for (int i4 = 0; i4 < format.E; i4++) {
                    iArrA[i4] = i4;
                }
            } else if (this.M0) {
                iArrA = VorbisUtil.a(formatN.E);
            }
            format = formatN;
        }
        try {
            if (Util.f41609a >= 29) {
                if (!i1() || V().f43288a == 0) {
                    this.I0.l(0);
                } else {
                    this.I0.l(V().f43288a);
                }
            }
            this.I0.o(format, 0, iArrA);
        } catch (AudioSink.ConfigurationException e3) {
            throw S(e3, e3.f43708a, 5001);
        }
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected void u1(long j3) {
        this.I0.t(j3);
    }

    @Override // androidx.media3.exoplayer.MediaClock
    public boolean v() {
        boolean z2 = this.S0;
        this.S0 = false;
        return z2;
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected DecoderReuseEvaluation v0(MediaCodecInfo mediaCodecInfo, Format format, Format format2) {
        DecoderReuseEvaluation decoderReuseEvaluationE = mediaCodecInfo.e(format, format2);
        int i3 = decoderReuseEvaluationE.f42877e;
        if (j1(format2)) {
            i3 |= 32768;
        }
        if (j2(mediaCodecInfo, format2) > this.K0) {
            i3 |= 64;
        }
        int i4 = i3;
        return new DecoderReuseEvaluation(mediaCodecInfo.f44264a, format, format2, i4 != 0 ? 0 : decoderReuseEvaluationE.f42876d, i4);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.BaseRenderer, androidx.media3.exoplayer.PlayerMessage.Target
    public void w(int i3, Object obj) {
        if (i3 == 2) {
            this.I0.setVolume(((Float) Assertions.e(obj)).floatValue());
            return;
        }
        if (i3 == 3) {
            this.I0.f((AudioAttributes) Assertions.e((AudioAttributes) obj));
            return;
        }
        if (i3 == 6) {
            this.I0.y((AuxEffectInfo) Assertions.e((AuxEffectInfo) obj));
            return;
        }
        if (i3 == 12) {
            if (Util.f41609a >= 23) {
                Api23.a(this.I0, obj);
            }
        } else if (i3 == 16) {
            this.T0 = ((Integer) Assertions.e(obj)).intValue();
            p2();
        } else if (i3 == 9) {
            this.I0.x(((Boolean) Assertions.e(obj)).booleanValue());
        } else if (i3 != 10) {
            super.w(i3, obj);
        } else {
            o2(((Integer) Assertions.e(obj)).intValue());
        }
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected void w1() {
        super.w1();
        this.I0.u();
    }

    public MediaCodecAudioRenderer(Context context, MediaCodecAdapter.Factory factory, MediaCodecSelector mediaCodecSelector, boolean z2, Handler handler, AudioRendererEventListener audioRendererEventListener, AudioSink audioSink) {
        this(context, factory, mediaCodecSelector, z2, handler, audioRendererEventListener, audioSink, Util.f41609a >= 35 ? new LoudnessCodecController() : null);
    }

    public MediaCodecAudioRenderer(Context context, MediaCodecAdapter.Factory factory, MediaCodecSelector mediaCodecSelector, boolean z2, Handler handler, AudioRendererEventListener audioRendererEventListener, AudioSink audioSink, LoudnessCodecController loudnessCodecController) {
        super(1, factory, mediaCodecSelector, z2, 44100.0f);
        this.G0 = context.getApplicationContext();
        this.I0 = audioSink;
        this.J0 = loudnessCodecController;
        this.T0 = -1000;
        this.H0 = new AudioRendererEventListener.EventDispatcher(handler, audioRendererEventListener);
        this.V0 = -9223372036854775807L;
        audioSink.k(new AudioSinkListener());
    }

    @Override // androidx.media3.exoplayer.BaseRenderer, androidx.media3.exoplayer.Renderer
    public MediaClock Q() {
        return this;
    }
}
