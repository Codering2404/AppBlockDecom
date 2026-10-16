package androidx.media3.transformer;

import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Assertions;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.BaseRenderer;
import androidx.media3.exoplayer.FormatHolder;
import androidx.media3.exoplayer.MediaClock;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.transformer.AssetLoader;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
abstract class ExoAssetLoaderBaseRenderer extends BaseRenderer {
    private final DecoderInputBuffer A;
    private boolean B;
    private boolean C;
    private boolean D;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    protected long f48141s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    protected SampleConsumer f48142t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    protected Codec f48143u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    protected boolean f48144v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private Format f48145w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private Format f48146x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final TransformerMediaClock f48147y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final AssetLoader.Listener f48148z;

    public ExoAssetLoaderBaseRenderer(int i3, TransformerMediaClock transformerMediaClock, AssetLoader.Listener listener) {
        super(i3);
        this.f48147y = transformerMediaClock;
        this.f48148z = listener;
        this.A = new DecoderInputBuffer(0);
    }

    private boolean B0(DecoderInputBuffer decoderInputBuffer) {
        int iP0 = p0(W(), decoderInputBuffer, 0);
        if (iP0 == -5) {
            throw new IllegalStateException("Format changes are not supported.");
        }
        if (iP0 != -4) {
            return false;
        }
        decoderInputBuffer.q();
        if (decoderInputBuffer.i()) {
            return true;
        }
        this.f48147y.a(g(), decoderInputBuffer.f42140g);
        return true;
    }

    private boolean C0() {
        Format format = this.f48145w;
        if (format != null && !this.C) {
            return true;
        }
        if (format == null) {
            FormatHolder formatHolderW = W();
            if (p0(formatHolderW, this.A, 2) != -5) {
                return false;
            }
            Format formatZ0 = z0((Format) Assertions.e(formatHolderW.f43108b));
            this.f48145w = formatZ0;
            y0(formatZ0);
            this.C = this.f48148z.b(this.f48145w, 3);
        }
        if (this.C) {
            if (TransformerUtil.g(this.f48145w.f40632o) == 2 && !s0()) {
                return false;
            }
            w0(this.f48145w);
            this.C = false;
        }
        return true;
    }

    private boolean s0() {
        if (this.f48142t != null) {
            return true;
        }
        if (this.f48146x == null) {
            if (this.f48143u == null || TransformerUtil.g(this.f48145w.f40632o) != 1) {
                this.f48146x = A0(this.f48145w);
            } else {
                Format formatC = this.f48143u.c();
                if (formatC == null) {
                    return false;
                }
                this.f48146x = A0(formatC);
            }
        }
        SampleConsumer sampleConsumerA = this.f48148z.a(this.f48146x);
        if (sampleConsumerA == null) {
            return false;
        }
        this.f48142t = sampleConsumerA;
        return true;
    }

    private boolean u0() {
        DecoderInputBuffer decoderInputBufferF = this.f48142t.f();
        if (decoderInputBufferF == null) {
            return false;
        }
        if (!this.D) {
            if (!B0(decoderInputBufferF)) {
                return false;
            }
            if (D0(decoderInputBufferF)) {
                return true;
            }
            this.D = true;
        }
        boolean zI = decoderInputBufferF.i();
        if (!this.f48142t.c()) {
            return false;
        }
        this.D = false;
        this.f48144v = zI;
        return !zI;
    }

    private boolean v0() {
        if (!this.f48143u.l(this.A) || !B0(this.A)) {
            return false;
        }
        if (D0(this.A)) {
            return true;
        }
        x0(this.A);
        this.f48143u.d(this.A);
        return true;
    }

    protected abstract boolean D0(DecoderInputBuffer decoderInputBuffer);

    @Override // androidx.media3.exoplayer.BaseRenderer, androidx.media3.exoplayer.Renderer
    public MediaClock Q() {
        return this.f48147y;
    }

    @Override // androidx.media3.exoplayer.RendererCapabilities
    public int a(Format format) {
        return RendererCapabilities.u(MimeTypes.k(format.f40632o) == g() ? 4 : 0);
    }

    @Override // androidx.media3.exoplayer.Renderer
    public boolean b() {
        return this.f48144v;
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    protected void f0(boolean z2, boolean z3) {
        this.f48147y.a(g(), 0L);
    }

    @Override // androidx.media3.exoplayer.Renderer
    public void h(long j3, long j4) {
        try {
            if (this.B && !b() && C0()) {
                if (this.f48143u != null) {
                    do {
                    } while ((s0() ? t0() : false) | v0());
                } else if (s0()) {
                    while (u0()) {
                    }
                }
            }
        } catch (ExportException e3) {
            this.B = false;
            this.f48148z.d(e3);
        }
    }

    @Override // androidx.media3.exoplayer.Renderer
    public boolean isReady() {
        return true;
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    protected void k0() {
        Codec codec = this.f48143u;
        if (codec != null) {
            codec.release();
        }
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    protected void l0() {
        this.B = true;
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    protected void m0() {
        this.B = false;
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    protected void n0(Format[] formatArr, long j3, long j4, MediaSource.MediaPeriodId mediaPeriodId) {
        this.f48141s = j3;
    }

    protected abstract boolean t0();

    protected abstract void w0(Format format);

    protected Format A0(Format format) {
        return format;
    }

    protected void x0(DecoderInputBuffer decoderInputBuffer) {
    }

    protected void y0(Format format) {
    }

    protected Format z0(Format format) {
        return format;
    }
}
