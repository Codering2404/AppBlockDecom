package androidx.media3.exoplayer.mediacodec;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaCryptoException;
import android.media.MediaFormat;
import android.media.metrics.LogSessionId;
import android.os.Build;
import android.os.Bundle;
import androidx.media3.common.C;
import androidx.media3.common.Format;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.TimedValueQueue;
import androidx.media3.common.util.TraceUtil;
import androidx.media3.common.util.Util;
import androidx.media3.decoder.CryptoConfig;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.BaseRenderer;
import androidx.media3.exoplayer.DecoderCounters;
import androidx.media3.exoplayer.DecoderReuseEvaluation;
import androidx.media3.exoplayer.ExoPlaybackException;
import androidx.media3.exoplayer.FormatHolder;
import androidx.media3.exoplayer.Renderer;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.audio.OggOpusAudioPacketizer;
import androidx.media3.exoplayer.drm.DrmSession;
import androidx.media3.exoplayer.drm.FrameworkCryptoConfig;
import androidx.media3.exoplayer.mediacodec.MediaCodecAdapter;
import androidx.media3.exoplayer.mediacodec.MediaCodecUtil;
import androidx.media3.extractor.OpusUtil;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.stetho.dumpapp.Framer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class MediaCodecRenderer extends BaseRenderer {
    private static final byte[] F0 = {0, 0, 1, 103, 66, -64, Ascii.VT, -38, 37, -112, 0, 0, 1, 104, -50, Ascii.SI, 19, 32, 0, 0, 1, 101, -120, -124, Ascii.CR, -50, 113, Ascii.CAN, -96, 0, 47, -65, Ascii.FS, Framer.STDOUT_FRAME_PREFIX, -61, 39, 93, Framer.EXIT_FRAME_PREFIX};
    private final MediaCodec.BufferInfo A;
    protected DecoderCounters A0;
    private final ArrayDeque B;
    private OutputStreamInfo B0;
    private final OggOpusAudioPacketizer C;
    private long C0;
    private Format D;
    private boolean D0;
    private Format E;
    private boolean E0;
    private DrmSession F;
    private DrmSession G;
    private Renderer.WakeupListener H;
    private MediaCrypto I;
    private long J;
    private float K;
    private float L;
    private MediaCodecAdapter M;
    private Format N;
    private MediaFormat O;
    private boolean P;
    private float Q;
    private ArrayDeque R;
    private DecoderInitializationException S;
    private MediaCodecInfo T;
    private int U;
    private boolean V;
    private boolean W;
    private boolean X;
    private boolean Y;
    private boolean Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private boolean f44277a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private long f44278b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    private boolean f44279c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    private long f44280d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    private int f44281e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    private int f44282f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    private ByteBuffer f44283g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    private boolean f44284h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    private boolean f44285i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    private boolean f44286j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    private boolean f44287k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    private boolean f44288l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    private boolean f44289m0;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    private int f44290n0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    private int f44291o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    private int f44292p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    private boolean f44293q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    private boolean f44294r0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final MediaCodecAdapter.Factory f44295s;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    private boolean f44296s0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final MediaCodecSelector f44297t;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    private long f44298t0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final boolean f44299u;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    private long f44300u0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final float f44301v;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    private boolean f44302v0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final DecoderInputBuffer f44303w;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    private boolean f44304w0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final DecoderInputBuffer f44305x;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    private boolean f44306x0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final DecoderInputBuffer f44307y;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    private boolean f44308y0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final BatchBuffer f44309z;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    private ExoPlaybackException f44310z0;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class Api31 {
        public static void a(MediaCodecAdapter.Configuration configuration, PlayerId playerId) {
            LogSessionId logSessionIdA = playerId.a();
            if (logSessionIdA.equals(LogSessionId.LOG_SESSION_ID_NONE)) {
                return;
            }
            configuration.f44255b.setString("log-session-id", logSessionIdA.getStringId());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private final class MediaCodecRendererCodecAdapterListener implements MediaCodecAdapter.OnBufferAvailableListener {
        private MediaCodecRendererCodecAdapterListener() {
        }

        @Override // androidx.media3.exoplayer.mediacodec.MediaCodecAdapter.OnBufferAvailableListener
        public void a() {
            if (MediaCodecRenderer.this.H != null) {
                MediaCodecRenderer.this.H.b();
            }
        }

        @Override // androidx.media3.exoplayer.mediacodec.MediaCodecAdapter.OnBufferAvailableListener
        public void b() {
            if (MediaCodecRenderer.this.H != null) {
                MediaCodecRenderer.this.H.b();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class OutputStreamInfo {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final OutputStreamInfo f44317e = new OutputStreamInfo(-9223372036854775807L, -9223372036854775807L, -9223372036854775807L);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f44318a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f44319b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f44320c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final TimedValueQueue f44321d = new TimedValueQueue();

        public OutputStreamInfo(long j3, long j4, long j5) {
            this.f44318a = j3;
            this.f44319b = j4;
            this.f44320c = j5;
        }
    }

    public MediaCodecRenderer(int i3, MediaCodecAdapter.Factory factory, MediaCodecSelector mediaCodecSelector, boolean z2, float f3) {
        super(i3);
        this.f44295s = factory;
        this.f44297t = (MediaCodecSelector) Assertions.e(mediaCodecSelector);
        this.f44299u = z2;
        this.f44301v = f3;
        this.f44303w = DecoderInputBuffer.s();
        this.f44305x = new DecoderInputBuffer(0);
        this.f44307y = new DecoderInputBuffer(2);
        BatchBuffer batchBuffer = new BatchBuffer();
        this.f44309z = batchBuffer;
        this.A = new MediaCodec.BufferInfo();
        this.K = 1.0f;
        this.L = 1.0f;
        this.J = -9223372036854775807L;
        this.B = new ArrayDeque();
        this.B0 = OutputStreamInfo.f44317e;
        batchBuffer.p(0);
        batchBuffer.f42138d.order(ByteOrder.nativeOrder());
        this.C = new OggOpusAudioPacketizer();
        this.Q = -1.0f;
        this.U = 0;
        this.f44290n0 = 0;
        this.f44281e0 = -1;
        this.f44282f0 = -1;
        this.f44280d0 = -9223372036854775807L;
        this.f44298t0 = -9223372036854775807L;
        this.f44300u0 = -9223372036854775807L;
        this.C0 = -9223372036854775807L;
        this.f44278b0 = -9223372036854775807L;
        this.f44291o0 = 0;
        this.f44292p0 = 0;
        this.A0 = new DecoderCounters();
    }

    private static boolean A0(String str) {
        return Util.f41609a == 29 && "c2.android.aac.decoder".equals(str);
    }

    private void B1() {
        this.f44296s0 = true;
        MediaFormat mediaFormatC = ((MediaCodecAdapter) Assertions.e(this.M)).c();
        if (this.U != 0 && mediaFormatC.getInteger(ViewHierarchyConstants.DIMENSION_WIDTH_KEY) == 32 && mediaFormatC.getInteger(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY) == 32) {
            this.Z = true;
        } else {
            this.O = mediaFormatC;
            this.P = true;
        }
    }

    private void C0() {
        this.f44288l0 = false;
        this.f44309z.f();
        this.f44307y.f();
        this.f44287k0 = false;
        this.f44286j0 = false;
        this.C.d();
    }

    private boolean C1(int i3) throws ExoPlaybackException {
        FormatHolder formatHolderW = W();
        this.f44303w.f();
        int iP0 = p0(formatHolderW, this.f44303w, i3 | 4);
        if (iP0 == -5) {
            s1(formatHolderW);
            return true;
        }
        if (iP0 != -4 || !this.f44303w.i()) {
            return false;
        }
        this.f44302v0 = true;
        z1();
        return false;
    }

    private boolean D0() {
        if (this.f44293q0) {
            this.f44291o0 = 1;
            if (this.W) {
                this.f44292p0 = 3;
                return false;
            }
            this.f44292p0 = 1;
        }
        return true;
    }

    private void D1() throws ExoPlaybackException {
        E1();
        m1();
    }

    private void E0() throws ExoPlaybackException {
        if (!this.f44293q0) {
            D1();
        } else {
            this.f44291o0 = 1;
            this.f44292p0 = 3;
        }
    }

    private boolean F0() throws ExoPlaybackException {
        if (this.f44293q0) {
            this.f44291o0 = 1;
            if (this.W) {
                this.f44292p0 = 3;
                return false;
            }
            this.f44292p0 = 2;
        } else {
            Y1();
        }
        return true;
    }

    private boolean G0(long j3, long j4) throws ExoPlaybackException {
        boolean z2;
        boolean zA1;
        ByteBuffer byteBuffer;
        int i3;
        MediaCodec.BufferInfo bufferInfo;
        int iP;
        MediaCodecAdapter mediaCodecAdapter = (MediaCodecAdapter) Assertions.e(this.M);
        if (!d1()) {
            if (this.X && this.f44294r0) {
                try {
                    iP = mediaCodecAdapter.p(this.A);
                } catch (IllegalStateException unused) {
                    z1();
                    if (this.f44304w0) {
                        E1();
                    }
                    return false;
                }
            } else {
                iP = mediaCodecAdapter.p(this.A);
            }
            if (iP < 0) {
                if (iP == -2) {
                    B1();
                    return true;
                }
                if (this.f44277a0 && (this.f44302v0 || this.f44291o0 == 2)) {
                    z1();
                }
                long j5 = this.f44278b0;
                if (j5 != -9223372036854775807L && j5 + 100 < U().currentTimeMillis()) {
                    z1();
                }
                return false;
            }
            if (this.Z) {
                this.Z = false;
                mediaCodecAdapter.q(iP, false);
                return true;
            }
            MediaCodec.BufferInfo bufferInfo2 = this.A;
            if (bufferInfo2.size == 0 && (bufferInfo2.flags & 4) != 0) {
                z1();
                return false;
            }
            this.f44282f0 = iP;
            ByteBuffer byteBufferR = mediaCodecAdapter.r(iP);
            this.f44283g0 = byteBufferR;
            if (byteBufferR != null) {
                byteBufferR.position(this.A.offset);
                ByteBuffer byteBuffer2 = this.f44283g0;
                MediaCodec.BufferInfo bufferInfo3 = this.A;
                byteBuffer2.limit(bufferInfo3.offset + bufferInfo3.size);
            }
            this.f44284h0 = this.A.presentationTimeUs < Y();
            long j6 = this.f44300u0;
            this.f44285i0 = j6 != -9223372036854775807L && j6 <= this.A.presentationTimeUs;
            Z1(this.A.presentationTimeUs);
        }
        if (this.X && this.f44294r0) {
            try {
                byteBuffer = this.f44283g0;
                i3 = this.f44282f0;
                bufferInfo = this.A;
                z2 = false;
            } catch (IllegalStateException unused2) {
                z2 = false;
            }
            try {
                zA1 = A1(j3, j4, mediaCodecAdapter, byteBuffer, i3, bufferInfo.flags, 1, bufferInfo.presentationTimeUs, this.f44284h0, this.f44285i0, (Format) Assertions.e(this.E));
            } catch (IllegalStateException unused3) {
                z1();
                if (this.f44304w0) {
                    E1();
                }
                return z2;
            }
        } else {
            z2 = false;
            ByteBuffer byteBuffer3 = this.f44283g0;
            int i4 = this.f44282f0;
            MediaCodec.BufferInfo bufferInfo4 = this.A;
            zA1 = A1(j3, j4, mediaCodecAdapter, byteBuffer3, i4, bufferInfo4.flags, 1, bufferInfo4.presentationTimeUs, this.f44284h0, this.f44285i0, (Format) Assertions.e(this.E));
        }
        if (zA1) {
            v1(this.A.presentationTimeUs);
            boolean z3 = (this.A.flags & 4) != 0 ? true : z2;
            if (!z3 && this.f44294r0 && this.f44285i0) {
                this.f44278b0 = U().currentTimeMillis();
            }
            J1();
            if (!z3) {
                return true;
            }
            z1();
        }
        return z2;
    }

    private boolean H0(MediaCodecInfo mediaCodecInfo, Format format, DrmSession drmSession, DrmSession drmSession2) {
        CryptoConfig cryptoConfigD;
        CryptoConfig cryptoConfigD2;
        if (drmSession == drmSession2) {
            return false;
        }
        if (drmSession2 != null && drmSession != null && (cryptoConfigD = drmSession2.d()) != null && (cryptoConfigD2 = drmSession.d()) != null && cryptoConfigD.getClass().equals(cryptoConfigD2.getClass())) {
            if (!(cryptoConfigD instanceof FrameworkCryptoConfig)) {
                return false;
            }
            if (!drmSession2.a().equals(drmSession.a()) || Util.f41609a < 23) {
                return true;
            }
            UUID uuid = C.f40545e;
            if (!uuid.equals(drmSession.a()) && !uuid.equals(drmSession2.a())) {
                return !mediaCodecInfo.f44270g && (drmSession2.getState() == 2 || ((drmSession2.getState() == 3 || drmSession2.getState() == 4) && drmSession2.h((String) Assertions.e(format.f40632o))));
            }
        }
        return true;
    }

    private void I1() {
        this.f44281e0 = -1;
        this.f44305x.f42138d = null;
    }

    private boolean J0() throws ExoPlaybackException {
        int i3;
        if (this.M == null || (i3 = this.f44291o0) == 2 || this.f44302v0) {
            return false;
        }
        if (i3 == 0 && S1()) {
            E0();
        }
        MediaCodecAdapter mediaCodecAdapter = (MediaCodecAdapter) Assertions.e(this.M);
        if (this.f44281e0 < 0) {
            int iO = mediaCodecAdapter.o();
            this.f44281e0 = iO;
            if (iO < 0) {
                return false;
            }
            this.f44305x.f42138d = mediaCodecAdapter.k(iO);
            this.f44305x.f();
        }
        if (this.f44291o0 == 1) {
            if (!this.f44277a0) {
                this.f44294r0 = true;
                mediaCodecAdapter.d(this.f44281e0, 0, 0, 0L, 4);
                I1();
            }
            this.f44291o0 = 2;
            return false;
        }
        if (this.Y) {
            this.Y = false;
            ByteBuffer byteBuffer = (ByteBuffer) Assertions.e(this.f44305x.f42138d);
            byte[] bArr = F0;
            byteBuffer.put(bArr);
            mediaCodecAdapter.d(this.f44281e0, 0, bArr.length, 0L, 0);
            I1();
            this.f44293q0 = true;
            return true;
        }
        if (this.f44290n0 == 1) {
            for (int i4 = 0; i4 < ((Format) Assertions.e(this.N)).f40635r.size(); i4++) {
                ((ByteBuffer) Assertions.e(this.f44305x.f42138d)).put((byte[]) this.N.f40635r.get(i4));
            }
            this.f44290n0 = 2;
        }
        int iPosition = ((ByteBuffer) Assertions.e(this.f44305x.f42138d)).position();
        FormatHolder formatHolderW = W();
        try {
            int iP0 = p0(formatHolderW, this.f44305x, 0);
            if (iP0 == -3) {
                if (k()) {
                    this.f44300u0 = this.f44298t0;
                }
                return false;
            }
            if (iP0 == -5) {
                if (this.f44290n0 == 2) {
                    this.f44305x.f();
                    this.f44290n0 = 1;
                }
                s1(formatHolderW);
                return true;
            }
            if (this.f44305x.i()) {
                this.f44300u0 = this.f44298t0;
                if (this.f44290n0 == 2) {
                    this.f44305x.f();
                    this.f44290n0 = 1;
                }
                this.f44302v0 = true;
                if (!this.f44293q0) {
                    z1();
                    return false;
                }
                if (!this.f44277a0) {
                    this.f44294r0 = true;
                    mediaCodecAdapter.d(this.f44281e0, 0, 0, 0L, 4);
                    I1();
                }
                return false;
            }
            if (!this.f44293q0 && !this.f44305x.k()) {
                this.f44305x.f();
                if (this.f44290n0 == 2) {
                    this.f44290n0 = 1;
                }
                return true;
            }
            if (Q1(this.f44305x)) {
                return true;
            }
            boolean zR = this.f44305x.r();
            if (zR) {
                this.f44305x.f42137c.b(iPosition);
            }
            long j3 = this.f44305x.f42140g;
            if (this.f44306x0) {
                if (this.B.isEmpty()) {
                    this.B0.f44321d.a(j3, (Format) Assertions.e(this.D));
                } else {
                    ((OutputStreamInfo) this.B.peekLast()).f44321d.a(j3, (Format) Assertions.e(this.D));
                }
                this.f44306x0 = false;
            }
            this.f44298t0 = Math.max(this.f44298t0, j3);
            if (k() || this.f44305x.l()) {
                this.f44300u0 = this.f44298t0;
            }
            this.f44305x.q();
            if (this.f44305x.h()) {
                c1(this.f44305x);
            }
            x1(this.f44305x);
            int iP02 = P0(this.f44305x);
            if (zR) {
                ((MediaCodecAdapter) Assertions.e(mediaCodecAdapter)).e(this.f44281e0, 0, this.f44305x.f42137c, j3, iP02);
            } else {
                ((MediaCodecAdapter) Assertions.e(mediaCodecAdapter)).d(this.f44281e0, 0, ((ByteBuffer) Assertions.e(this.f44305x.f42138d)).limit(), j3, iP02);
            }
            I1();
            this.f44293q0 = true;
            this.f44290n0 = 0;
            this.A0.f42863c++;
            return true;
        } catch (DecoderInputBuffer.InsufficientCapacityException e3) {
            p1(e3);
            C1(0);
            K0();
            return true;
        }
    }

    private void J1() {
        this.f44282f0 = -1;
        this.f44283g0 = null;
    }

    private void K0() {
        try {
            ((MediaCodecAdapter) Assertions.i(this.M)).flush();
        } finally {
            G1();
        }
    }

    private void K1(DrmSession drmSession) {
        DrmSession.c(this.F, drmSession);
        this.F = drmSession;
    }

    private void L1(OutputStreamInfo outputStreamInfo) {
        this.B0 = outputStreamInfo;
        long j3 = outputStreamInfo.f44320c;
        if (j3 != -9223372036854775807L) {
            this.D0 = true;
            u1(j3);
        }
    }

    private List N0(boolean z2) {
        Format format = (Format) Assertions.e(this.D);
        List listU0 = U0(this.f44297t, format, z2);
        if (!listU0.isEmpty() || !z2) {
            return listU0;
        }
        List listU02 = U0(this.f44297t, format, false);
        if (!listU02.isEmpty()) {
            Log.i("MediaCodecRenderer", "Drm session requires secure decoder for " + format.f40632o + ", but no secure decoder available. Trying to proceed with " + listU02 + ".");
        }
        return listU02;
    }

    private void O1(DrmSession drmSession) {
        DrmSession.c(this.G, drmSession);
        this.G = drmSession;
    }

    private boolean P1(long j3) {
        return this.J == -9223372036854775807L || U().a() - j3 < this.J;
    }

    protected static boolean W1(Format format) {
        int i3 = format.N;
        return i3 == 0 || i3 == 2;
    }

    private boolean X1(Format format) throws ExoPlaybackException {
        if (Util.f41609a >= 23 && this.M != null && this.f44292p0 != 3 && getState() != 0) {
            float fS0 = S0(this.L, (Format) Assertions.e(format), a0());
            float f3 = this.Q;
            if (f3 == fS0) {
                return true;
            }
            if (fS0 == -1.0f) {
                E0();
                return false;
            }
            if (f3 == -1.0f && fS0 <= this.f44301v) {
                return true;
            }
            Bundle bundle = new Bundle();
            bundle.putFloat("operating-rate", fS0);
            ((MediaCodecAdapter) Assertions.e(this.M)).f(bundle);
            this.Q = fS0;
        }
        return true;
    }

    private void Y1() throws ExoPlaybackException {
        CryptoConfig cryptoConfigD = ((DrmSession) Assertions.e(this.G)).d();
        if (cryptoConfigD instanceof FrameworkCryptoConfig) {
            try {
                ((MediaCrypto) Assertions.e(this.I)).setMediaDrmSession(((FrameworkCryptoConfig) cryptoConfigD).f44072b);
            } catch (MediaCryptoException e3) {
                throw S(e3, this.D, 6006);
            }
        }
        K1(this.G);
        this.f44291o0 = 0;
        this.f44292p0 = 0;
    }

    private boolean d1() {
        return this.f44282f0 >= 0;
    }

    private boolean e1() {
        if (!this.f44309z.z()) {
            return true;
        }
        long jY = Y();
        return k1(jY, this.f44309z.x()) == k1(jY, this.f44307y.f42140g);
    }

    private void f1(Format format) {
        C0();
        String str = format.f40632o;
        if ("audio/mp4a-latm".equals(str) || "audio/mpeg".equals(str) || "audio/opus".equals(str)) {
            this.f44309z.A(32);
        } else {
            this.f44309z.A(1);
        }
        this.f44286j0 = true;
    }

    private void g1(MediaCodecInfo mediaCodecInfo, MediaCrypto mediaCrypto) {
        Format format = (Format) Assertions.e(this.D);
        String str = mediaCodecInfo.f44264a;
        int i3 = Util.f41609a;
        float fS0 = i3 < 23 ? -1.0f : S0(this.L, format, a0());
        float f3 = fS0 > this.f44301v ? fS0 : -1.0f;
        long jA = U().a();
        MediaCodecAdapter.Configuration configurationX0 = X0(mediaCodecInfo, format, mediaCrypto, f3);
        if (i3 >= 31) {
            Api31.a(configurationX0, Z());
        }
        try {
            TraceUtil.a("createCodec:" + str);
            MediaCodecAdapter mediaCodecAdapterB = this.f44295s.b(configurationX0);
            this.M = mediaCodecAdapterB;
            this.f44279c0 = mediaCodecAdapterB.g(new MediaCodecRendererCodecAdapterListener());
            TraceUtil.b();
            long jA2 = U().a();
            if (!mediaCodecInfo.o(format)) {
                Log.i("MediaCodecRenderer", Util.J("Format exceeds selected codec's capabilities [%s, %s]", Format.h(format), str));
            }
            this.T = mediaCodecInfo;
            this.Q = f3;
            this.N = format;
            this.U = w0(str);
            this.V = A0(str);
            this.W = x0(str);
            this.X = y0(str);
            this.f44277a0 = z0(mediaCodecInfo) || R0();
            if (((MediaCodecAdapter) Assertions.e(this.M)).m()) {
                this.f44289m0 = true;
                this.f44290n0 = 1;
                this.Y = this.U != 0;
            }
            if (getState() == 2) {
                this.f44280d0 = U().a() + 1000;
            }
            this.A0.f42861a++;
            q1(str, configurationX0, jA2, jA2 - jA);
        } catch (Throwable th) {
            TraceUtil.b();
            throw th;
        }
    }

    private boolean h1() throws ExoPlaybackException {
        Assertions.g(this.I == null);
        DrmSession drmSession = this.F;
        CryptoConfig cryptoConfigD = drmSession.d();
        if (FrameworkCryptoConfig.f44070d && (cryptoConfigD instanceof FrameworkCryptoConfig)) {
            int state = drmSession.getState();
            if (state == 1) {
                DrmSession.DrmSessionException drmSessionException = (DrmSession.DrmSessionException) Assertions.e(drmSession.getError());
                throw S(drmSessionException, this.D, drmSessionException.f44055a);
            }
            if (state != 4) {
                return false;
            }
        }
        if (cryptoConfigD == null) {
            return drmSession.getError() != null;
        }
        if (cryptoConfigD instanceof FrameworkCryptoConfig) {
            FrameworkCryptoConfig frameworkCryptoConfig = (FrameworkCryptoConfig) cryptoConfigD;
            try {
                this.I = new MediaCrypto(frameworkCryptoConfig.f44071a, frameworkCryptoConfig.f44072b);
            } catch (MediaCryptoException e3) {
                throw S(e3, this.D, 6006);
            }
        }
        return true;
    }

    private boolean k1(long j3, long j4) {
        if (j4 >= j3) {
            return false;
        }
        Format format = this.E;
        return (format != null && Objects.equals(format.f40632o, "audio/opus") && OpusUtil.g(j3, j4)) ? false : true;
    }

    private static boolean l1(IllegalStateException illegalStateException) {
        if (illegalStateException instanceof MediaCodec.CodecException) {
            return true;
        }
        StackTraceElement[] stackTrace = illegalStateException.getStackTrace();
        return stackTrace.length > 0 && stackTrace[0].getClassName().equals("android.media.MediaCodec");
    }

    private void n1(MediaCrypto mediaCrypto, boolean z2) throws DecoderInitializationException {
        Format format = (Format) Assertions.e(this.D);
        if (this.R == null) {
            try {
                List listN0 = N0(z2);
                ArrayDeque arrayDeque = new ArrayDeque();
                this.R = arrayDeque;
                if (this.f44299u) {
                    arrayDeque.addAll(listN0);
                } else if (!listN0.isEmpty()) {
                    this.R.add((MediaCodecInfo) listN0.get(0));
                }
                this.S = null;
            } catch (MediaCodecUtil.DecoderQueryException e3) {
                throw new DecoderInitializationException(format, e3, z2, -49998);
            }
        }
        if (this.R.isEmpty()) {
            throw new DecoderInitializationException(format, (Throwable) null, z2, -49999);
        }
        ArrayDeque arrayDeque2 = (ArrayDeque) Assertions.e(this.R);
        while (this.M == null) {
            MediaCodecInfo mediaCodecInfo = (MediaCodecInfo) Assertions.e((MediaCodecInfo) arrayDeque2.peekFirst());
            if (!o1(format) || !R1(mediaCodecInfo)) {
                return;
            }
            try {
                g1(mediaCodecInfo, mediaCrypto);
            } catch (Exception e4) {
                Log.j("MediaCodecRenderer", "Failed to initialize decoder: " + mediaCodecInfo, e4);
                arrayDeque2.removeFirst();
                DecoderInitializationException decoderInitializationException = new DecoderInitializationException(format, e4, z2, mediaCodecInfo);
                p1(decoderInitializationException);
                if (this.S == null) {
                    this.S = decoderInitializationException;
                } else {
                    this.S = this.S.c(decoderInitializationException);
                }
                if (arrayDeque2.isEmpty()) {
                    throw this.S;
                }
            }
        }
        this.R = null;
    }

    private void t0() throws ExoPlaybackException {
        Assertions.g(!this.f44302v0);
        FormatHolder formatHolderW = W();
        this.f44307y.f();
        do {
            this.f44307y.f();
            int iP0 = p0(formatHolderW, this.f44307y, 0);
            if (iP0 == -5) {
                s1(formatHolderW);
                return;
            }
            if (iP0 == -4) {
                if (!this.f44307y.i()) {
                    this.f44298t0 = Math.max(this.f44298t0, this.f44307y.f42140g);
                    if (k() || this.f44305x.l()) {
                        this.f44300u0 = this.f44298t0;
                    }
                    if (this.f44306x0) {
                        Format format = (Format) Assertions.e(this.D);
                        this.E = format;
                        if (Objects.equals(format.f40632o, "audio/opus") && !this.E.f40635r.isEmpty()) {
                            this.E = this.E.b().Z(OpusUtil.f((byte[]) this.E.f40635r.get(0))).N();
                        }
                        t1(this.E, null);
                        this.f44306x0 = false;
                    }
                    this.f44307y.q();
                    Format format2 = this.E;
                    if (format2 != null && Objects.equals(format2.f40632o, "audio/opus")) {
                        if (this.f44307y.h()) {
                            DecoderInputBuffer decoderInputBuffer = this.f44307y;
                            decoderInputBuffer.f42136b = this.E;
                            c1(decoderInputBuffer);
                        }
                        if (OpusUtil.g(Y(), this.f44307y.f42140g)) {
                            this.C.a(this.f44307y, this.E.f40635r);
                        }
                    }
                    if (!e1()) {
                        break;
                    }
                } else {
                    this.f44302v0 = true;
                    this.f44300u0 = this.f44298t0;
                    return;
                }
            } else {
                if (iP0 != -3) {
                    throw new IllegalStateException();
                }
                if (k()) {
                    this.f44300u0 = this.f44298t0;
                    return;
                }
                return;
            }
        } while (this.f44309z.u(this.f44307y));
        this.f44287k0 = true;
    }

    private boolean u0(long j3, long j4) throws ExoPlaybackException {
        boolean z2;
        Assertions.g(!this.f44304w0);
        if (this.f44309z.z()) {
            BatchBuffer batchBuffer = this.f44309z;
            z2 = false;
            if (!A1(j3, j4, null, batchBuffer.f42138d, this.f44282f0, 0, batchBuffer.y(), this.f44309z.w(), k1(Y(), this.f44309z.x()), this.f44309z.i(), (Format) Assertions.e(this.E))) {
                return false;
            }
            v1(this.f44309z.x());
            this.f44309z.f();
        } else {
            z2 = false;
        }
        if (this.f44302v0) {
            this.f44304w0 = true;
            return z2;
        }
        if (this.f44287k0) {
            Assertions.g(this.f44309z.u(this.f44307y));
            this.f44287k0 = z2;
        }
        if (this.f44288l0) {
            if (this.f44309z.z()) {
                return true;
            }
            C0();
            this.f44288l0 = z2;
            m1();
            if (!this.f44286j0) {
                return z2;
            }
        }
        t0();
        if (this.f44309z.z()) {
            this.f44309z.q();
        }
        if (this.f44309z.z() || this.f44302v0 || this.f44288l0) {
            return true;
        }
        return z2;
    }

    private int w0(String str) {
        int i3 = Util.f41609a;
        if (i3 <= 25 && "OMX.Exynos.avc.dec.secure".equals(str)) {
            String str2 = Build.MODEL;
            if (str2.startsWith("SM-T585") || str2.startsWith("SM-A510") || str2.startsWith("SM-A520") || str2.startsWith("SM-J700")) {
                return 2;
            }
        }
        if (i3 >= 24) {
            return 0;
        }
        if (!"OMX.Nvidia.h264.decode".equals(str) && !"OMX.Nvidia.h264.decode.secure".equals(str)) {
            return 0;
        }
        String str3 = Build.DEVICE;
        return ("flounder".equals(str3) || "flounder_lte".equals(str3) || "grouper".equals(str3) || "tilapia".equals(str3)) ? 1 : 0;
    }

    private static boolean x0(String str) {
        return Util.f41609a <= 23 && "OMX.google.vorbis.decoder".equals(str);
    }

    private static boolean y0(String str) {
        return Util.f41609a == 21 && "OMX.google.aac.decoder".equals(str);
    }

    private static boolean z0(MediaCodecInfo mediaCodecInfo) {
        String str = mediaCodecInfo.f44264a;
        int i3 = Util.f41609a;
        if (i3 <= 25 && "OMX.rk.video_decoder.avc".equals(str)) {
            return true;
        }
        if (i3 > 29 || !("OMX.broadcom.video_decoder.tunnel".equals(str) || "OMX.broadcom.video_decoder.tunnel.secure".equals(str) || "OMX.bcm.vdec.avc.tunnel".equals(str) || "OMX.bcm.vdec.avc.tunnel.secure".equals(str) || "OMX.bcm.vdec.hevc.tunnel".equals(str) || "OMX.bcm.vdec.hevc.tunnel.secure".equals(str))) {
            return "Amazon".equals(Build.MANUFACTURER) && "AFTS".equals(Build.MODEL) && mediaCodecInfo.f44270g;
        }
        return true;
    }

    private void z1() throws ExoPlaybackException {
        int i3 = this.f44292p0;
        if (i3 == 1) {
            K0();
            return;
        }
        if (i3 == 2) {
            K0();
            Y1();
        } else if (i3 == 3) {
            D1();
        } else {
            this.f44304w0 = true;
            F1();
        }
    }

    protected abstract boolean A1(long j3, long j4, MediaCodecAdapter mediaCodecAdapter, ByteBuffer byteBuffer, int i3, int i4, int i5, long j5, boolean z2, boolean z3, Format format);

    protected MediaCodecDecoderException B0(Throwable th, MediaCodecInfo mediaCodecInfo) {
        return new MediaCodecDecoderException(th, mediaCodecInfo);
    }

    @Override // androidx.media3.exoplayer.Renderer
    public final long E(long j3, long j4) {
        return V0(j3, j4, this.f44279c0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void E1() {
        try {
            MediaCodecAdapter mediaCodecAdapter = this.M;
            if (mediaCodecAdapter != null) {
                mediaCodecAdapter.release();
                this.A0.f42862b++;
                r1(((MediaCodecInfo) Assertions.e(this.T)).f44264a);
            }
            this.M = null;
            try {
                MediaCrypto mediaCrypto = this.I;
                if (mediaCrypto != null) {
                    mediaCrypto.release();
                }
            } finally {
            }
        } catch (Throwable th) {
            this.M = null;
            try {
                MediaCrypto mediaCrypto2 = this.I;
                if (mediaCrypto2 != null) {
                    mediaCrypto2.release();
                }
                throw th;
            } finally {
            }
        }
    }

    protected void G1() {
        I1();
        J1();
        this.f44280d0 = -9223372036854775807L;
        this.f44294r0 = false;
        this.f44278b0 = -9223372036854775807L;
        this.f44293q0 = false;
        this.Y = false;
        this.Z = false;
        this.f44284h0 = false;
        this.f44285i0 = false;
        this.f44298t0 = -9223372036854775807L;
        this.f44300u0 = -9223372036854775807L;
        this.C0 = -9223372036854775807L;
        this.f44291o0 = 0;
        this.f44292p0 = 0;
        this.f44290n0 = this.f44289m0 ? 1 : 0;
    }

    protected void H1() {
        G1();
        this.f44310z0 = null;
        this.R = null;
        this.T = null;
        this.N = null;
        this.O = null;
        this.P = false;
        this.f44296s0 = false;
        this.Q = -1.0f;
        this.U = 0;
        this.V = false;
        this.W = false;
        this.X = false;
        this.f44277a0 = false;
        this.f44279c0 = false;
        this.f44289m0 = false;
        this.f44290n0 = 0;
    }

    public void I0() {
        this.E0 = true;
    }

    @Override // androidx.media3.exoplayer.Renderer
    public void L(float f3, float f4) throws ExoPlaybackException {
        this.K = f3;
        this.L = f4;
        X1(this.N);
    }

    protected final boolean L0() throws ExoPlaybackException {
        boolean zM0 = M0();
        if (zM0) {
            m1();
        }
        return zM0;
    }

    protected boolean M0() {
        if (this.M == null) {
            return false;
        }
        int i3 = this.f44292p0;
        if (i3 == 3 || ((this.V && !this.f44296s0) || (this.W && this.f44294r0))) {
            E1();
            return true;
        }
        if (i3 == 2) {
            int i4 = Util.f41609a;
            Assertions.g(i4 >= 23);
            if (i4 >= 23) {
                try {
                    Y1();
                } catch (ExoPlaybackException e3) {
                    Log.j("MediaCodecRenderer", "Failed to update the DRM session, releasing the codec instead.", e3);
                    E1();
                    return true;
                }
            }
        }
        K0();
        return false;
    }

    protected final void M1() {
        this.f44308y0 = true;
    }

    @Override // androidx.media3.exoplayer.BaseRenderer, androidx.media3.exoplayer.RendererCapabilities
    public final int N() {
        return 8;
    }

    protected final void N1(ExoPlaybackException exoPlaybackException) {
        this.f44310z0 = exoPlaybackException;
    }

    protected final MediaCodecAdapter O0() {
        return this.M;
    }

    protected int P0(DecoderInputBuffer decoderInputBuffer) {
        return 0;
    }

    protected final MediaCodecInfo Q0() {
        return this.T;
    }

    protected boolean Q1(DecoderInputBuffer decoderInputBuffer) {
        if (!T1(decoderInputBuffer)) {
            return false;
        }
        decoderInputBuffer.f();
        this.A0.f42864d++;
        return true;
    }

    protected boolean R0() {
        return false;
    }

    protected boolean R1(MediaCodecInfo mediaCodecInfo) {
        return true;
    }

    protected float S0(float f3, Format format, Format[] formatArr) {
        return -1.0f;
    }

    protected boolean S1() {
        return false;
    }

    protected final MediaFormat T0() {
        return this.O;
    }

    protected boolean T1(DecoderInputBuffer decoderInputBuffer) {
        return false;
    }

    protected abstract List U0(MediaCodecSelector mediaCodecSelector, Format format, boolean z2);

    protected boolean U1(Format format) {
        return false;
    }

    protected long V0(long j3, long j4, boolean z2) {
        return super.E(j3, j4);
    }

    protected abstract int V1(MediaCodecSelector mediaCodecSelector, Format format);

    protected long W0() {
        return this.f44300u0;
    }

    protected abstract MediaCodecAdapter.Configuration X0(MediaCodecInfo mediaCodecInfo, Format format, MediaCrypto mediaCrypto, float f3);

    protected final long Y0() {
        return this.B0.f44320c;
    }

    protected final long Z0() {
        return this.B0.f44319b;
    }

    protected final void Z1(long j3) {
        Format format = (Format) this.B0.f44321d.j(j3);
        if (format == null && this.D0 && this.O != null) {
            format = (Format) this.B0.f44321d.i();
        }
        if (format != null) {
            this.E = format;
        } else if (!this.P || this.E == null) {
            return;
        }
        t1((Format) Assertions.e(this.E), this.O);
        this.P = false;
        this.D0 = false;
    }

    @Override // androidx.media3.exoplayer.RendererCapabilities
    public final int a(Format format) throws ExoPlaybackException {
        try {
            return V1(this.f44297t, format);
        } catch (MediaCodecUtil.DecoderQueryException e3) {
            throw S(e3, format, 4002);
        }
    }

    protected float a1() {
        return this.K;
    }

    @Override // androidx.media3.exoplayer.Renderer
    public boolean b() {
        return this.f44304w0;
    }

    protected final Renderer.WakeupListener b1() {
        return this.H;
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    protected void e0() {
        this.D = null;
        L1(OutputStreamInfo.f44317e);
        this.B.clear();
        M0();
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    protected void f0(boolean z2, boolean z3) {
        this.A0 = new DecoderCounters();
    }

    @Override // androidx.media3.exoplayer.Renderer
    public void h(long j3, long j4) throws ExoPlaybackException {
        boolean z2 = false;
        if (this.f44308y0) {
            this.f44308y0 = false;
            z1();
        }
        ExoPlaybackException exoPlaybackException = this.f44310z0;
        if (exoPlaybackException != null) {
            this.f44310z0 = null;
            throw exoPlaybackException;
        }
        try {
            if (this.f44304w0) {
                F1();
                return;
            }
            if (this.D != null || C1(2)) {
                m1();
                if (this.f44286j0) {
                    TraceUtil.a("bypassRender");
                    while (u0(j3, j4)) {
                    }
                    TraceUtil.b();
                } else if (this.M != null) {
                    long jA = U().a();
                    TraceUtil.a("drainAndFeed");
                    while (G0(j3, j4) && P1(jA)) {
                    }
                    while (J0() && P1(jA)) {
                    }
                    TraceUtil.b();
                } else {
                    this.A0.f42864d += r0(j3);
                    C1(1);
                }
                this.A0.c();
            }
        } catch (MediaCodec.CryptoException e3) {
            throw S(e3, this.D, Util.a0(e3.getErrorCode()));
        } catch (IllegalStateException e4) {
            if (!l1(e4)) {
                throw e4;
            }
            p1(e4);
            if ((e4 instanceof MediaCodec.CodecException) && ((MediaCodec.CodecException) e4).isRecoverable()) {
                z2 = true;
            }
            if (z2) {
                E1();
            }
            MediaCodecDecoderException mediaCodecDecoderExceptionB0 = B0(e4, Q0());
            throw T(mediaCodecDecoderExceptionB0, this.D, z2, mediaCodecDecoderExceptionB0.f44263c == 1101 ? 4006 : 4003);
        }
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    protected void h0(long j3, boolean z2) throws ExoPlaybackException {
        this.f44302v0 = false;
        this.f44304w0 = false;
        this.f44308y0 = false;
        if (this.f44286j0) {
            this.f44309z.f();
            this.f44307y.f();
            this.f44287k0 = false;
            this.C.d();
        } else {
            L0();
        }
        if (this.B0.f44321d.l() > 0) {
            this.f44306x0 = true;
        }
        this.B0.f44321d.c();
        this.B.clear();
    }

    protected final boolean i1() {
        return this.f44286j0;
    }

    @Override // androidx.media3.exoplayer.Renderer
    public boolean isReady() {
        if (this.D == null) {
            return false;
        }
        if (d0() || d1()) {
            return true;
        }
        return this.f44280d0 != -9223372036854775807L && U().a() < this.f44280d0;
    }

    protected final boolean j1(Format format) {
        return this.G == null && U1(format);
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    protected void k0() {
        try {
            C0();
            E1();
        } finally {
            O1(null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected final void m1() throws androidx.media3.exoplayer.ExoPlaybackException {
        /*
            r3 = this;
            androidx.media3.exoplayer.mediacodec.MediaCodecAdapter r0 = r3.M
            if (r0 != 0) goto L6b
            boolean r0 = r3.f44286j0
            if (r0 != 0) goto L6b
            androidx.media3.common.Format r0 = r3.D
            if (r0 != 0) goto Ld
            goto L6b
        Ld:
            boolean r1 = r3.j1(r0)
            if (r1 == 0) goto L17
            r3.f1(r0)
            return
        L17:
            androidx.media3.exoplayer.drm.DrmSession r1 = r3.G
            r3.K1(r1)
            androidx.media3.exoplayer.drm.DrmSession r1 = r3.F
            if (r1 == 0) goto L26
            boolean r1 = r3.h1()
            if (r1 == 0) goto L55
        L26:
            androidx.media3.exoplayer.drm.DrmSession r1 = r3.F     // Catch: androidx.media3.exoplayer.mediacodec.MediaCodecRenderer.DecoderInitializationException -> L3b
            if (r1 == 0) goto L4f
            int r1 = r1.getState()     // Catch: androidx.media3.exoplayer.mediacodec.MediaCodecRenderer.DecoderInitializationException -> L3b
            r2 = 3
            if (r1 == r2) goto L3d
            androidx.media3.exoplayer.drm.DrmSession r1 = r3.F     // Catch: androidx.media3.exoplayer.mediacodec.MediaCodecRenderer.DecoderInitializationException -> L3b
            int r1 = r1.getState()     // Catch: androidx.media3.exoplayer.mediacodec.MediaCodecRenderer.DecoderInitializationException -> L3b
            r2 = 4
            if (r1 != r2) goto L4f
            goto L3d
        L3b:
            r1 = move-exception
            goto L64
        L3d:
            androidx.media3.exoplayer.drm.DrmSession r1 = r3.F     // Catch: androidx.media3.exoplayer.mediacodec.MediaCodecRenderer.DecoderInitializationException -> L3b
            java.lang.String r2 = r0.f40632o     // Catch: androidx.media3.exoplayer.mediacodec.MediaCodecRenderer.DecoderInitializationException -> L3b
            java.lang.Object r2 = androidx.media3.common.util.Assertions.i(r2)     // Catch: androidx.media3.exoplayer.mediacodec.MediaCodecRenderer.DecoderInitializationException -> L3b
            java.lang.String r2 = (java.lang.String) r2     // Catch: androidx.media3.exoplayer.mediacodec.MediaCodecRenderer.DecoderInitializationException -> L3b
            boolean r1 = r1.h(r2)     // Catch: androidx.media3.exoplayer.mediacodec.MediaCodecRenderer.DecoderInitializationException -> L3b
            if (r1 == 0) goto L4f
            r1 = 1
            goto L50
        L4f:
            r1 = 0
        L50:
            android.media.MediaCrypto r2 = r3.I     // Catch: androidx.media3.exoplayer.mediacodec.MediaCodecRenderer.DecoderInitializationException -> L3b
            r3.n1(r2, r1)     // Catch: androidx.media3.exoplayer.mediacodec.MediaCodecRenderer.DecoderInitializationException -> L3b
        L55:
            android.media.MediaCrypto r0 = r3.I
            if (r0 == 0) goto L6b
            androidx.media3.exoplayer.mediacodec.MediaCodecAdapter r1 = r3.M
            if (r1 != 0) goto L6b
            r0.release()
            r0 = 0
            r3.I = r0
            return
        L64:
            r2 = 4001(0xfa1, float:5.607E-42)
            androidx.media3.exoplayer.ExoPlaybackException r0 = r3.S(r1, r0, r2)
            throw r0
        L6b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.mediacodec.MediaCodecRenderer.m1():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x003a, code lost:
    
        if (r4 >= r0) goto L16;
     */
    @Override // androidx.media3.exoplayer.BaseRenderer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void n0(androidx.media3.common.Format[] r12, long r13, long r15, androidx.media3.exoplayer.source.MediaSource.MediaPeriodId r17) {
        /*
            r11 = this;
            androidx.media3.exoplayer.mediacodec.MediaCodecRenderer$OutputStreamInfo r12 = r11.B0
            long r0 = r12.f44320c
            r2 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r12 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r12 != 0) goto L24
            androidx.media3.exoplayer.mediacodec.MediaCodecRenderer$OutputStreamInfo r4 = new androidx.media3.exoplayer.mediacodec.MediaCodecRenderer$OutputStreamInfo
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r7 = r13
            r9 = r15
            r4.<init>(r5, r7, r9)
            r11.L1(r4)
            boolean r12 = r11.E0
            if (r12 == 0) goto L56
            r11.w1()
            return
        L24:
            java.util.ArrayDeque r12 = r11.B
            boolean r12 = r12.isEmpty()
            if (r12 == 0) goto L57
            long r0 = r11.f44298t0
            int r12 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r12 == 0) goto L3c
            long r4 = r11.C0
            int r12 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r12 == 0) goto L57
            int r12 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r12 < 0) goto L57
        L3c:
            androidx.media3.exoplayer.mediacodec.MediaCodecRenderer$OutputStreamInfo r4 = new androidx.media3.exoplayer.mediacodec.MediaCodecRenderer$OutputStreamInfo
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r7 = r13
            r9 = r15
            r4.<init>(r5, r7, r9)
            r11.L1(r4)
            androidx.media3.exoplayer.mediacodec.MediaCodecRenderer$OutputStreamInfo r12 = r11.B0
            long r12 = r12.f44320c
            int r12 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r12 == 0) goto L56
            r11.w1()
        L56:
            return
        L57:
            java.util.ArrayDeque r12 = r11.B
            androidx.media3.exoplayer.mediacodec.MediaCodecRenderer$OutputStreamInfo r0 = new androidx.media3.exoplayer.mediacodec.MediaCodecRenderer$OutputStreamInfo
            long r1 = r11.f44298t0
            r3 = r13
            r5 = r15
            r0.<init>(r1, r3, r5)
            r12.add(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.mediacodec.MediaCodecRenderer.n0(androidx.media3.common.Format[], long, long, androidx.media3.exoplayer.source.MediaSource$MediaPeriodId):void");
    }

    protected boolean o1(Format format) {
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00aa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected androidx.media3.exoplayer.DecoderReuseEvaluation s1(androidx.media3.exoplayer.FormatHolder r12) throws androidx.media3.exoplayer.ExoPlaybackException {
        /*
            Method dump skipped, instruction units count: 287
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.mediacodec.MediaCodecRenderer.s1(androidx.media3.exoplayer.FormatHolder):androidx.media3.exoplayer.DecoderReuseEvaluation");
    }

    protected DecoderReuseEvaluation v0(MediaCodecInfo mediaCodecInfo, Format format, Format format2) {
        return new DecoderReuseEvaluation(mediaCodecInfo.f44264a, format, format2, 0, 1);
    }

    protected void v1(long j3) {
        this.C0 = j3;
        while (!this.B.isEmpty() && j3 >= ((OutputStreamInfo) this.B.peek()).f44318a) {
            L1((OutputStreamInfo) Assertions.e((OutputStreamInfo) this.B.poll()));
            w1();
        }
    }

    @Override // androidx.media3.exoplayer.BaseRenderer, androidx.media3.exoplayer.PlayerMessage.Target
    public void w(int i3, Object obj) {
        if (i3 != 11) {
            super.w(i3, obj);
            return;
        }
        Renderer.WakeupListener wakeupListener = (Renderer.WakeupListener) Assertions.e((Renderer.WakeupListener) obj);
        this.H = wakeupListener;
        y1(wakeupListener);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class DecoderInitializationException extends Exception {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f44311a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f44312b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final MediaCodecInfo f44313c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f44314d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final DecoderInitializationException f44315f;

        public DecoderInitializationException(Format format, Throwable th, boolean z2, int i3) {
            this("Decoder init failed: [" + i3 + "], " + format, th, format.f40632o, z2, null, b(i3), null);
        }

        private static String b(int i3) {
            return "androidx.media3.exoplayer.mediacodec.MediaCodecRenderer_" + (i3 < 0 ? "neg_" : "") + Math.abs(i3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public DecoderInitializationException c(DecoderInitializationException decoderInitializationException) {
            return new DecoderInitializationException(getMessage(), getCause(), this.f44311a, this.f44312b, this.f44313c, this.f44314d, decoderInitializationException);
        }

        public DecoderInitializationException(Format format, Throwable th, boolean z2, MediaCodecInfo mediaCodecInfo) {
            this("Decoder init failed: " + mediaCodecInfo.f44264a + ", " + format, th, format.f40632o, z2, mediaCodecInfo, th instanceof MediaCodec.CodecException ? ((MediaCodec.CodecException) th).getDiagnosticInfo() : null, null);
        }

        private DecoderInitializationException(String str, Throwable th, String str2, boolean z2, MediaCodecInfo mediaCodecInfo, String str3, DecoderInitializationException decoderInitializationException) {
            super(str, th);
            this.f44311a = str2;
            this.f44312b = z2;
            this.f44313c = mediaCodecInfo;
            this.f44314d = str3;
            this.f44315f = decoderInitializationException;
        }
    }

    protected void F1() {
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    protected void l0() {
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    protected void m0() {
    }

    protected void w1() {
    }

    protected void c1(DecoderInputBuffer decoderInputBuffer) {
    }

    protected void p1(Exception exc) {
    }

    protected void r1(String str) {
    }

    protected void u1(long j3) {
    }

    protected void x1(DecoderInputBuffer decoderInputBuffer) {
    }

    protected void y1(Renderer.WakeupListener wakeupListener) {
    }

    protected void t1(Format format, MediaFormat mediaFormat) {
    }

    protected void q1(String str, MediaCodecAdapter.Configuration configuration, long j3, long j4) {
    }
}
