package androidx.media3.transformer;

import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import androidx.media3.common.Format;
import androidx.media3.common.Metadata;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.MediaFormatUtil;
import androidx.media3.common.util.TraceUtil;
import androidx.media3.common.util.Util;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.effect.DebugTraceUtil;
import androidx.media3.transformer.ExportException;
import com.facebook.ads.AdError;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class DefaultCodec implements Codec {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MediaCodec.BufferInfo f48048a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MediaFormat f48049b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Format f48050c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final MediaCodec f48051d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Surface f48052e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f48053f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f48054g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f48055h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final AtomicBoolean f48056i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Format f48057j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private ByteBuffer f48058k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f48059l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f48060m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f48061n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f48062o;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class Api29 {
        public static String a(MediaCodec mediaCodec) {
            return mediaCodec.getCanonicalName();
        }
    }

    public DefaultCodec(Context context, Format format, MediaFormat mediaFormat, String str, boolean z2, Surface surface) throws ExportException {
        Exception exc;
        MediaCodec mediaCodecCreateByCodecName;
        this.f48050c = format;
        this.f48049b = mediaFormat;
        this.f48054g = z2;
        boolean zQ = MimeTypes.q((String) Assertions.e(format.f40632o));
        this.f48055h = zQ;
        this.f48048a = new MediaCodec.BufferInfo();
        this.f48059l = -1;
        this.f48060m = -1;
        this.f48056i = new AtomicBoolean();
        DebugTraceUtil.d(z2, zQ, "InputFormat", -9223372036854775807L, "%s", format);
        boolean zT = t(mediaFormat);
        Surface surfaceCreateInputSurface = null;
        try {
            mediaCodecCreateByCodecName = MediaCodec.createByCodecName(str);
        } catch (Exception e3) {
            exc = e3;
            mediaCodecCreateByCodecName = null;
        }
        try {
            n(mediaCodecCreateByCodecName, mediaFormat, z2, surface);
            if (zT) {
                Assertions.b(t(mediaCodecCreateByCodecName.getInputFormat()), "Tone-mapping requested but not supported by the decoder.");
            }
            if (zQ && !z2) {
                surfaceCreateInputSurface = mediaCodecCreateByCodecName.createInputSurface();
            }
            w(mediaCodecCreateByCodecName);
            this.f48051d = mediaCodecCreateByCodecName;
            this.f48052e = surfaceCreateInputSurface;
            this.f48053f = Util.e0(context);
        } catch (Exception e4) {
            exc = e4;
            Log.c("DefaultCodec", "MediaCodec error", exc);
            if (surfaceCreateInputSurface != null) {
                surfaceCreateInputSurface.release();
            }
            if (mediaCodecCreateByCodecName != null) {
                mediaCodecCreateByCodecName.release();
            }
            throw p(mediaFormat, this.f48055h, z2, exc, ((exc instanceof IOException) || (exc instanceof MediaCodec.CodecException)) ? z2 ? AdError.MEDIATION_ERROR_CODE : 4001 : exc instanceof IllegalArgumentException ? z2 ? 3003 : 4003 : AdError.NO_FILL_ERROR_CODE, str);
        }
    }

    private static void n(MediaCodec mediaCodec, MediaFormat mediaFormat, boolean z2, Surface surface) {
        TraceUtil.a("configureCodec");
        mediaCodec.configure(mediaFormat, surface, (MediaCrypto) null, !z2 ? 1 : 0);
        TraceUtil.b();
    }

    private static Format o(MediaFormat mediaFormat, boolean z2, Metadata metadata) {
        Format formatA = MediaFormatUtil.a(mediaFormat);
        Format.Builder builderN0 = formatA.b().n0(metadata);
        if (z2 && formatA.G == -1 && Objects.equals(formatA.f40632o, "audio/raw")) {
            builderN0.o0(2);
        }
        return builderN0.N();
    }

    private static ExportException p(MediaFormat mediaFormat, boolean z2, boolean z3, Exception exc, int i3, String str) {
        return ExportException.c(exc, i3, new ExportException.CodecInfo(mediaFormat.toString(), z2, z3, str));
    }

    private ExportException q(Exception exc) {
        MediaFormat mediaFormat = this.f48049b;
        boolean z2 = this.f48055h;
        boolean z3 = this.f48054g;
        return p(mediaFormat, z2, z3, exc, z3 ? 3002 : 4002, getName());
    }

    private void r(String str, long j3) {
        s(str, j3, "", new Object[0]);
    }

    private void s(String str, long j3, String str2, Object... objArr) {
        DebugTraceUtil.d(this.f48054g, this.f48055h, str, j3, str2, objArr);
    }

    private static boolean t(MediaFormat mediaFormat) {
        return Util.f41609a >= 31 && MediaFormatUtil.g(mediaFormat, "color-transfer-request", 0) == 3;
    }

    private boolean u(boolean z2) throws ExportException {
        if (this.f48060m >= 0) {
            return true;
        }
        if (this.f48062o) {
            return false;
        }
        try {
            int iDequeueOutputBuffer = this.f48051d.dequeueOutputBuffer(this.f48048a, 0L);
            this.f48060m = iDequeueOutputBuffer;
            if (iDequeueOutputBuffer < 0) {
                if (iDequeueOutputBuffer == -2) {
                    this.f48057j = o(this.f48051d.getOutputFormat(), this.f48054g, this.f48050c.f40629l);
                    if (this.f48054g && Objects.equals(this.f48050c.f40632o, "audio/raw")) {
                        this.f48057j = this.f48057j.b().R(this.f48050c.E).o0(this.f48050c.G).N();
                    }
                    if (!this.f48054g && this.f48055h) {
                        this.f48056i.set(true);
                    }
                    s("OutputFormat", this.f48048a.presentationTimeUs, "%s", this.f48057j);
                }
                return false;
            }
            if ((this.f48048a.flags & 4) != 0) {
                this.f48062o = true;
                r("OutputEnded", Long.MIN_VALUE);
                MediaCodec.BufferInfo bufferInfo = this.f48048a;
                if (bufferInfo.size == 0) {
                    h(false);
                    return false;
                }
                bufferInfo.flags &= -5;
            }
            if ((this.f48048a.flags & 2) != 0) {
                h(false);
                return false;
            }
            if (z2) {
                try {
                    ByteBuffer byteBuffer = (ByteBuffer) Assertions.e(this.f48051d.getOutputBuffer(this.f48060m));
                    this.f48058k = byteBuffer;
                    byteBuffer.position(this.f48048a.offset);
                    ByteBuffer byteBuffer2 = this.f48058k;
                    MediaCodec.BufferInfo bufferInfo2 = this.f48048a;
                    byteBuffer2.limit(bufferInfo2.offset + bufferInfo2.size);
                } catch (RuntimeException e3) {
                    Log.c("DefaultCodec", "MediaCodec error", e3);
                    throw q(e3);
                }
            }
            return true;
        } catch (RuntimeException e4) {
            Log.c("DefaultCodec", "MediaCodec error", e4);
            throw q(e4);
        }
    }

    private static void w(MediaCodec mediaCodec) {
        TraceUtil.a("startCodec");
        mediaCodec.start();
        TraceUtil.b();
    }

    @Override // androidx.media3.transformer.Codec
    public Surface a() {
        return (Surface) Assertions.i(this.f48052e);
    }

    @Override // androidx.media3.transformer.Codec
    public boolean b() {
        return this.f48062o && this.f48060m == -1;
    }

    @Override // androidx.media3.transformer.Codec
    public Format c() throws ExportException {
        u(false);
        return this.f48057j;
    }

    @Override // androidx.media3.transformer.Codec
    public void d(DecoderInputBuffer decoderInputBuffer) throws ExportException {
        int iPosition;
        int iRemaining;
        int i3;
        int i4;
        int i5;
        long j3;
        boolean z2 = true;
        Assertions.h(!this.f48061n, "Input buffer can not be queued after the input stream has ended.");
        ByteBuffer byteBuffer = decoderInputBuffer.f42138d;
        if (byteBuffer == null || !byteBuffer.hasRemaining()) {
            iPosition = 0;
            iRemaining = 0;
        } else {
            iPosition = decoderInputBuffer.f42138d.position();
            iRemaining = decoderInputBuffer.f42138d.remaining();
        }
        long j4 = decoderInputBuffer.f42140g;
        if (decoderInputBuffer.i()) {
            this.f48061n = true;
            r("InputEnded", Long.MIN_VALUE);
            if (this.f48054g) {
                ByteBuffer byteBuffer2 = decoderInputBuffer.f42138d;
                if (byteBuffer2 != null && byteBuffer2.hasRemaining()) {
                    z2 = false;
                }
                Assertions.g(z2);
                j4 = 0;
                i3 = 0;
                i5 = 0;
            } else {
                i3 = iPosition;
                i5 = iRemaining;
            }
            j3 = j4;
            i4 = 4;
        } else {
            i3 = iPosition;
            i4 = 0;
            i5 = iRemaining;
            j3 = j4;
        }
        try {
            this.f48051d.queueInputBuffer(this.f48059l, i3, i5, j3, i4);
            s("AcceptedInput", j3, "bytes=%s", Integer.valueOf(i5));
            this.f48059l = -1;
            decoderInputBuffer.f42138d = null;
        } catch (RuntimeException e3) {
            Log.c("DefaultCodec", "MediaCodec error", e3);
            throw q(e3);
        }
    }

    @Override // androidx.media3.transformer.Codec
    public Format e() throws ExportException {
        try {
            return o(this.f48051d.getInputFormat(), this.f48054g, this.f48050c.f40629l);
        } catch (RuntimeException e3) {
            Log.c("DefaultCodec", "MediaCodec error", e3);
            throw q(e3);
        }
    }

    @Override // androidx.media3.transformer.Codec
    public void f(long j3) throws ExportException {
        v(true, j3);
    }

    @Override // androidx.media3.transformer.Codec
    public MediaCodec.BufferInfo g() {
        if (u(false)) {
            return this.f48048a;
        }
        return null;
    }

    @Override // androidx.media3.transformer.Codec
    public String getName() {
        return Util.f41609a >= 29 ? Api29.a(this.f48051d) : this.f48051d.getName();
    }

    @Override // androidx.media3.transformer.Codec
    public void h(boolean z2) throws ExportException {
        v(z2, ((MediaCodec.BufferInfo) Assertions.i(this.f48048a)).presentationTimeUs);
    }

    @Override // androidx.media3.transformer.Codec
    public void i() throws ExportException {
        if (!this.f48056i.get()) {
            try {
                Thread.sleep(30L);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
        r("InputEnded", Long.MIN_VALUE);
        try {
            this.f48051d.signalEndOfInputStream();
        } catch (RuntimeException e3) {
            Log.c("DefaultCodec", "MediaCodec error", e3);
            throw q(e3);
        }
    }

    @Override // androidx.media3.transformer.Codec
    public ByteBuffer j() {
        if (!u(true)) {
            return null;
        }
        MediaCodec.BufferInfo bufferInfo = this.f48048a;
        s("ProducedOutput", bufferInfo.presentationTimeUs, "bytesOutput=%s", Integer.valueOf(bufferInfo.size));
        return this.f48058k;
    }

    @Override // androidx.media3.transformer.Codec
    public int k() {
        return this.f48053f;
    }

    @Override // androidx.media3.transformer.Codec
    public boolean l(DecoderInputBuffer decoderInputBuffer) throws ExportException {
        if (this.f48061n) {
            return false;
        }
        if (this.f48059l < 0) {
            try {
                int iDequeueInputBuffer = this.f48051d.dequeueInputBuffer(0L);
                this.f48059l = iDequeueInputBuffer;
                if (iDequeueInputBuffer < 0) {
                    return false;
                }
                try {
                    decoderInputBuffer.f42138d = this.f48051d.getInputBuffer(iDequeueInputBuffer);
                    decoderInputBuffer.f();
                } catch (RuntimeException e3) {
                    Log.c("DefaultCodec", "MediaCodec error", e3);
                    throw q(e3);
                }
            } catch (RuntimeException e4) {
                Log.c("DefaultCodec", "MediaCodec error", e4);
                throw q(e4);
            }
        }
        Assertions.e(decoderInputBuffer.f42138d);
        return true;
    }

    @Override // androidx.media3.transformer.Codec
    public Format m() {
        return this.f48050c;
    }

    @Override // androidx.media3.transformer.Codec
    public void release() {
        this.f48058k = null;
        Surface surface = this.f48052e;
        if (surface != null) {
            surface.release();
        }
        this.f48051d.release();
    }

    protected void v(boolean z2, long j3) throws ExportException {
        this.f48058k = null;
        try {
            if (z2) {
                this.f48051d.releaseOutputBuffer(this.f48060m, 1000 * j3);
                r("ProducedOutput", j3);
            } else {
                this.f48051d.releaseOutputBuffer(this.f48060m, false);
            }
            this.f48060m = -1;
        } catch (RuntimeException e3) {
            Log.c("DefaultCodec", "MediaCodec error", e3);
            throw q(e3);
        }
    }
}
