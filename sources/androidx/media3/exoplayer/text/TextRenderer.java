package androidx.media3.exoplayer.text;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.text.CueGroup;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.BaseRenderer;
import androidx.media3.exoplayer.FormatHolder;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.extractor.text.CueDecoder;
import androidx.media3.extractor.text.CuesWithTiming;
import androidx.media3.extractor.text.Subtitle;
import androidx.media3.extractor.text.SubtitleDecoder;
import androidx.media3.extractor.text.SubtitleDecoderException;
import androidx.media3.extractor.text.SubtitleInputBuffer;
import androidx.media3.extractor.text.SubtitleOutputBuffer;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class TextRenderer extends BaseRenderer implements Handler.Callback {
    private SubtitleOutputBuffer A;
    private SubtitleOutputBuffer B;
    private int C;
    private final Handler D;
    private final TextOutput E;
    private final FormatHolder F;
    private boolean G;
    private boolean H;
    private Format I;
    private long J;
    private long K;
    private boolean L;
    private IOException M;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final CueDecoder f45307s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final DecoderInputBuffer f45308t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private CuesResolver f45309u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final SubtitleDecoderFactory f45310v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f45311w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f45312x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private SubtitleDecoder f45313y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private SubtitleInputBuffer f45314z;

    public TextRenderer(TextOutput textOutput, Looper looper) {
        this(textOutput, looper, SubtitleDecoderFactory.f45305a);
    }

    private void A0(CueGroup cueGroup) {
        this.E.m(cueGroup.f41453a);
        this.E.t(cueGroup);
    }

    private static boolean B0(Format format) {
        return Objects.equals(format.f40632o, "application/x-media3-cues");
    }

    private boolean C0(long j3) {
        if (this.G || p0(this.F, this.f45308t, 0) != -4) {
            return false;
        }
        if (this.f45308t.i()) {
            this.G = true;
            return false;
        }
        this.f45308t.q();
        ByteBuffer byteBuffer = (ByteBuffer) Assertions.e(this.f45308t.f42138d);
        CuesWithTiming cuesWithTimingA = this.f45307s.a(this.f45308t.f42140g, byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.limit());
        this.f45308t.f();
        return this.f45309u.b(cuesWithTimingA, j3);
    }

    private void D0() {
        this.f45314z = null;
        this.C = -1;
        SubtitleOutputBuffer subtitleOutputBuffer = this.A;
        if (subtitleOutputBuffer != null) {
            subtitleOutputBuffer.o();
            this.A = null;
        }
        SubtitleOutputBuffer subtitleOutputBuffer2 = this.B;
        if (subtitleOutputBuffer2 != null) {
            subtitleOutputBuffer2.o();
            this.B = null;
        }
    }

    private void E0() {
        D0();
        ((SubtitleDecoder) Assertions.e(this.f45313y)).release();
        this.f45313y = null;
        this.f45312x = 0;
    }

    private void F0(long j3) {
        boolean zC0 = C0(j3);
        long jD = this.f45309u.d(this.J);
        if (jD == Long.MIN_VALUE && this.G && !zC0) {
            this.H = true;
        }
        if (jD != Long.MIN_VALUE && jD <= j3) {
            zC0 = true;
        }
        if (zC0) {
            ImmutableList immutableListA = this.f45309u.a(j3);
            long jC = this.f45309u.c(j3);
            J0(new CueGroup(immutableListA, w0(jC)));
            this.f45309u.e(jC);
        }
        this.J = j3;
    }

    private void G0(long j3) {
        boolean z2;
        this.J = j3;
        if (this.B == null) {
            ((SubtitleDecoder) Assertions.e(this.f45313y)).c(j3);
            try {
                this.B = (SubtitleOutputBuffer) ((SubtitleDecoder) Assertions.e(this.f45313y)).a();
            } catch (SubtitleDecoderException e3) {
                x0(e3);
                return;
            }
        }
        if (getState() != 2) {
            return;
        }
        if (this.A != null) {
            long jV0 = v0();
            z2 = false;
            while (jV0 <= j3) {
                this.C++;
                jV0 = v0();
                z2 = true;
            }
        } else {
            z2 = false;
        }
        SubtitleOutputBuffer subtitleOutputBuffer = this.B;
        if (subtitleOutputBuffer != null) {
            if (subtitleOutputBuffer.i()) {
                if (!z2 && v0() == Long.MAX_VALUE) {
                    if (this.f45312x == 2) {
                        H0();
                    } else {
                        D0();
                        this.H = true;
                    }
                }
            } else if (subtitleOutputBuffer.f42146b <= j3) {
                SubtitleOutputBuffer subtitleOutputBuffer2 = this.A;
                if (subtitleOutputBuffer2 != null) {
                    subtitleOutputBuffer2.o();
                }
                this.C = subtitleOutputBuffer.a(j3);
                this.A = subtitleOutputBuffer;
                this.B = null;
                z2 = true;
            }
        }
        if (z2) {
            Assertions.e(this.A);
            J0(new CueGroup(this.A.b(j3), w0(u0(j3))));
        }
        if (this.f45312x == 2) {
            return;
        }
        while (!this.G) {
            try {
                SubtitleInputBuffer subtitleInputBuffer = this.f45314z;
                if (subtitleInputBuffer == null) {
                    subtitleInputBuffer = (SubtitleInputBuffer) ((SubtitleDecoder) Assertions.e(this.f45313y)).f();
                    if (subtitleInputBuffer == null) {
                        return;
                    } else {
                        this.f45314z = subtitleInputBuffer;
                    }
                }
                if (this.f45312x == 1) {
                    subtitleInputBuffer.n(4);
                    ((SubtitleDecoder) Assertions.e(this.f45313y)).b(subtitleInputBuffer);
                    this.f45314z = null;
                    this.f45312x = 2;
                    return;
                }
                int iP0 = p0(this.F, subtitleInputBuffer, 0);
                if (iP0 == -4) {
                    if (subtitleInputBuffer.i()) {
                        this.G = true;
                        this.f45311w = false;
                    } else {
                        Format format = this.F.f43108b;
                        if (format == null) {
                            return;
                        }
                        subtitleInputBuffer.f46956k = format.f40637t;
                        subtitleInputBuffer.q();
                        this.f45311w &= !subtitleInputBuffer.k();
                    }
                    if (!this.f45311w) {
                        ((SubtitleDecoder) Assertions.e(this.f45313y)).b(subtitleInputBuffer);
                        this.f45314z = null;
                    }
                } else if (iP0 == -3) {
                    return;
                }
            } catch (SubtitleDecoderException e4) {
                x0(e4);
                return;
            }
        }
    }

    private void H0() {
        E0();
        z0();
    }

    private void J0(CueGroup cueGroup) {
        Handler handler = this.D;
        if (handler != null) {
            handler.obtainMessage(1, cueGroup).sendToTarget();
        } else {
            A0(cueGroup);
        }
    }

    private void s0() {
        Assertions.h(this.L || Objects.equals(this.I.f40632o, "application/cea-608") || Objects.equals(this.I.f40632o, "application/x-mp4-cea-608") || Objects.equals(this.I.f40632o, "application/cea-708"), "Legacy decoding is disabled, can't handle " + this.I.f40632o + " samples (expected application/x-media3-cues).");
    }

    private void t0() {
        J0(new CueGroup(ImmutableList.y(), w0(this.J)));
    }

    private long u0(long j3) {
        int iA = this.A.a(j3);
        if (iA == 0 || this.A.d() == 0) {
            return this.A.f42146b;
        }
        if (iA != -1) {
            return this.A.c(iA - 1);
        }
        return this.A.c(r2.d() - 1);
    }

    private long v0() {
        if (this.C == -1) {
            return Long.MAX_VALUE;
        }
        Assertions.e(this.A);
        if (this.C >= this.A.d()) {
            return Long.MAX_VALUE;
        }
        return this.A.c(this.C);
    }

    private long w0(long j3) {
        Assertions.g(j3 != -9223372036854775807L);
        return j3 - b0();
    }

    private void x0(SubtitleDecoderException subtitleDecoderException) {
        Log.e("TextRenderer", "Subtitle decoding failed. streamFormat=" + this.I, subtitleDecoderException);
        t0();
        H0();
    }

    private static boolean y0(Subtitle subtitle, long j3) {
        return subtitle == null || subtitle.c(subtitle.d() - 1) <= j3;
    }

    private void z0() {
        this.f45311w = true;
        SubtitleDecoder subtitleDecoderB = this.f45310v.b((Format) Assertions.e(this.I));
        this.f45313y = subtitleDecoderB;
        subtitleDecoderB.e(Y());
    }

    public void I0(long j3) {
        Assertions.g(B());
        this.K = j3;
    }

    @Override // androidx.media3.exoplayer.RendererCapabilities
    public int a(Format format) {
        if (B0(format) || this.f45310v.a(format)) {
            return RendererCapabilities.u(format.N == 0 ? 4 : 2);
        }
        return MimeTypes.p(format.f40632o) ? RendererCapabilities.u(1) : RendererCapabilities.u(0);
    }

    @Override // androidx.media3.exoplayer.Renderer
    public boolean b() {
        return this.H;
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    protected void e0() {
        this.I = null;
        this.K = -9223372036854775807L;
        t0();
        this.J = -9223372036854775807L;
        if (this.f45313y != null) {
            E0();
        }
    }

    @Override // androidx.media3.exoplayer.Renderer, androidx.media3.exoplayer.RendererCapabilities
    public String getName() {
        return "TextRenderer";
    }

    @Override // androidx.media3.exoplayer.Renderer
    public void h(long j3, long j4) {
        if (B()) {
            long j5 = this.K;
            if (j5 != -9223372036854775807L && j3 >= j5) {
                D0();
                this.H = true;
            }
        }
        if (this.H) {
            return;
        }
        if (B0((Format) Assertions.e(this.I))) {
            Assertions.e(this.f45309u);
            F0(j3);
        } else {
            s0();
            G0(j3);
        }
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    protected void h0(long j3, boolean z2) {
        this.J = j3;
        CuesResolver cuesResolver = this.f45309u;
        if (cuesResolver != null) {
            cuesResolver.clear();
        }
        t0();
        this.G = false;
        this.H = false;
        this.K = -9223372036854775807L;
        Format format = this.I;
        if (format == null || B0(format)) {
            return;
        }
        if (this.f45312x != 0) {
            H0();
            return;
        }
        D0();
        SubtitleDecoder subtitleDecoder = (SubtitleDecoder) Assertions.e(this.f45313y);
        subtitleDecoder.flush();
        subtitleDecoder.e(Y());
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 1) {
            throw new IllegalStateException();
        }
        A0((CueGroup) message.obj);
        return true;
    }

    @Override // androidx.media3.exoplayer.Renderer
    public boolean isReady() {
        if (this.I == null) {
            return true;
        }
        if (this.M == null) {
            try {
                y();
            } catch (IOException e3) {
                this.M = e3;
            }
        }
        if (this.M != null) {
            if (B0((Format) Assertions.e(this.I))) {
                return ((CuesResolver) Assertions.e(this.f45309u)).d(this.J) != Long.MIN_VALUE;
            }
            if (this.H || (this.G && y0(this.A, this.J) && y0(this.B, this.J) && this.f45314z != null)) {
                return false;
            }
        }
        return true;
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    protected void n0(Format[] formatArr, long j3, long j4, MediaSource.MediaPeriodId mediaPeriodId) {
        Format format = formatArr[0];
        this.I = format;
        if (B0(format)) {
            this.f45309u = this.I.K == 1 ? new MergingCuesResolver() : new ReplacingCuesResolver();
            return;
        }
        s0();
        if (this.f45313y != null) {
            this.f45312x = 1;
        } else {
            z0();
        }
    }

    public TextRenderer(TextOutput textOutput, Looper looper, SubtitleDecoderFactory subtitleDecoderFactory) {
        super(3);
        this.E = (TextOutput) Assertions.e(textOutput);
        this.D = looper == null ? null : Util.B(looper, this);
        this.f45310v = subtitleDecoderFactory;
        this.f45307s = new CueDecoder();
        this.f45308t = new DecoderInputBuffer(1);
        this.F = new FormatHolder();
        this.K = -9223372036854775807L;
        this.J = -9223372036854775807L;
        this.L = false;
    }
}
