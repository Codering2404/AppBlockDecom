package androidx.media3.exoplayer.image;

import android.graphics.Bitmap;
import androidx.media3.common.Format;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.TraceUtil;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.BaseRenderer;
import androidx.media3.exoplayer.ExoPlaybackException;
import androidx.media3.exoplayer.FormatHolder;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.exoplayer.image.ImageDecoder;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class ImageRenderer extends BaseRenderer {
    private int A;
    private int B;
    private Format C;
    private ImageDecoder D;
    private DecoderInputBuffer E;
    private ImageOutput F;
    private Bitmap G;
    private boolean H;
    private TileInfo I;
    private TileInfo J;
    private int K;
    private boolean L;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final ImageDecoder.Factory f44160s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final DecoderInputBuffer f44161t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final ArrayDeque f44162u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f44163v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f44164w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private OutputStreamInfo f44165x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private long f44166y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private long f44167z;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class OutputStreamInfo {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final OutputStreamInfo f44168c = new OutputStreamInfo(-9223372036854775807L, -9223372036854775807L);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f44169a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f44170b;

        public OutputStreamInfo(long j3, long j4) {
            this.f44169a = j3;
            this.f44170b = j4;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class TileInfo {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f44171a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f44172b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Bitmap f44173c;

        public TileInfo(int i3, long j3) {
            this.f44171a = i3;
            this.f44172b = j3;
        }

        public long a() {
            return this.f44172b;
        }

        public Bitmap b() {
            return this.f44173c;
        }

        public int c() {
            return this.f44171a;
        }

        public boolean d() {
            return this.f44173c != null;
        }

        public void e(Bitmap bitmap) {
            this.f44173c = bitmap;
        }
    }

    public ImageRenderer(ImageDecoder.Factory factory, ImageOutput imageOutput) {
        super(4);
        this.f44160s = factory;
        this.F = w0(imageOutput);
        this.f44161t = DecoderInputBuffer.s();
        this.f44165x = OutputStreamInfo.f44168c;
        this.f44162u = new ArrayDeque();
        this.f44167z = -9223372036854775807L;
        this.f44166y = -9223372036854775807L;
        this.A = 0;
        this.B = 1;
    }

    private boolean A0() throws ExoPlaybackException {
        if (!B0()) {
            return false;
        }
        if (!this.L) {
            return true;
        }
        if (!s0((Format) Assertions.e(this.C))) {
            throw S(new ImageDecoderException("Provided decoder factory can't create decoder for format."), this.C, 4005);
        }
        ImageDecoder imageDecoder = this.D;
        if (imageDecoder != null) {
            imageDecoder.release();
        }
        this.D = this.f44160s.b();
        this.L = false;
        return true;
    }

    private void C0(long j3) {
        this.f44166y = j3;
        while (!this.f44162u.isEmpty() && j3 >= ((OutputStreamInfo) this.f44162u.peek()).f44169a) {
            this.f44165x = (OutputStreamInfo) this.f44162u.removeFirst();
        }
    }

    private void E0() {
        this.E = null;
        this.A = 0;
        this.f44167z = -9223372036854775807L;
        ImageDecoder imageDecoder = this.D;
        if (imageDecoder != null) {
            imageDecoder.release();
            this.D = null;
        }
    }

    private void F0(ImageOutput imageOutput) {
        this.F = w0(imageOutput);
    }

    private boolean G0() {
        boolean z2 = getState() == 2;
        int i3 = this.B;
        if (i3 == 0) {
            return z2;
        }
        if (i3 == 1) {
            return true;
        }
        if (i3 == 3) {
            return false;
        }
        throw new IllegalStateException();
    }

    private boolean s0(Format format) {
        int iA = this.f44160s.a(format);
        return iA == RendererCapabilities.u(4) || iA == RendererCapabilities.u(3);
    }

    private Bitmap t0(int i3) {
        Assertions.i(this.G);
        int width = this.G.getWidth() / ((Format) Assertions.i(this.C)).L;
        int height = this.G.getHeight() / ((Format) Assertions.i(this.C)).M;
        int i4 = this.C.L;
        return Bitmap.createBitmap(this.G, (i3 % i4) * width, (i3 / i4) * height, width, height);
    }

    private boolean u0(long j3, long j4) throws ExoPlaybackException {
        if (this.G != null && this.I == null) {
            return false;
        }
        if (this.B == 0 && getState() != 2) {
            return false;
        }
        if (this.G == null) {
            Assertions.i(this.D);
            ImageOutputBuffer imageOutputBufferA = this.D.a();
            if (imageOutputBufferA == null) {
                return false;
            }
            if (((ImageOutputBuffer) Assertions.i(imageOutputBufferA)).i()) {
                if (this.A == 3) {
                    E0();
                    Assertions.i(this.C);
                    A0();
                } else {
                    ((ImageOutputBuffer) Assertions.i(imageOutputBufferA)).o();
                    if (this.f44162u.isEmpty()) {
                        this.f44164w = true;
                    }
                }
                return false;
            }
            Assertions.j(imageOutputBufferA.f44159f, "Non-EOS buffer came back from the decoder without bitmap.");
            this.G = imageOutputBufferA.f44159f;
            ((ImageOutputBuffer) Assertions.i(imageOutputBufferA)).o();
        }
        if (!this.H || this.G == null || this.I == null) {
            return false;
        }
        Assertions.i(this.C);
        Format format = this.C;
        int i3 = format.L;
        boolean z2 = ((i3 == 1 && format.M == 1) || i3 == -1 || format.M == -1) ? false : true;
        if (!this.I.d()) {
            TileInfo tileInfo = this.I;
            tileInfo.e(z2 ? t0(tileInfo.c()) : (Bitmap) Assertions.i(this.G));
        }
        if (!D0(j3, j4, (Bitmap) Assertions.i(this.I.b()), this.I.a())) {
            return false;
        }
        C0(((TileInfo) Assertions.i(this.I)).a());
        this.B = 3;
        if (!z2 || ((TileInfo) Assertions.i(this.I)).c() == (((Format) Assertions.i(this.C)).M * ((Format) Assertions.i(this.C)).L) - 1) {
            this.G = null;
        }
        this.I = this.J;
        this.J = null;
        return true;
    }

    private boolean v0(long j3) {
        if (this.H && this.I != null) {
            return false;
        }
        FormatHolder formatHolderW = W();
        ImageDecoder imageDecoder = this.D;
        if (imageDecoder == null || this.A == 3 || this.f44163v) {
            return false;
        }
        if (this.E == null) {
            DecoderInputBuffer decoderInputBuffer = (DecoderInputBuffer) imageDecoder.f();
            this.E = decoderInputBuffer;
            if (decoderInputBuffer == null) {
                return false;
            }
        }
        if (this.A == 2) {
            Assertions.i(this.E);
            this.E.n(4);
            ((ImageDecoder) Assertions.i(this.D)).b(this.E);
            this.E = null;
            this.A = 3;
            return false;
        }
        int iP0 = p0(formatHolderW, this.E, 0);
        if (iP0 == -5) {
            this.C = (Format) Assertions.i(formatHolderW.f43108b);
            this.L = true;
            this.A = 2;
            return true;
        }
        if (iP0 != -4) {
            if (iP0 == -3) {
                return false;
            }
            throw new IllegalStateException();
        }
        this.E.q();
        ByteBuffer byteBuffer = this.E.f42138d;
        boolean z2 = (byteBuffer != null && byteBuffer.remaining() > 0) || ((DecoderInputBuffer) Assertions.i(this.E)).i();
        if (z2) {
            ((ImageDecoder) Assertions.i(this.D)).b((DecoderInputBuffer) Assertions.i(this.E));
            this.K = 0;
        }
        z0(j3, (DecoderInputBuffer) Assertions.i(this.E));
        if (((DecoderInputBuffer) Assertions.i(this.E)).i()) {
            this.f44163v = true;
            this.E = null;
            return false;
        }
        this.f44167z = Math.max(this.f44167z, ((DecoderInputBuffer) Assertions.i(this.E)).f42140g);
        if (z2) {
            this.E = null;
        } else {
            ((DecoderInputBuffer) Assertions.i(this.E)).f();
        }
        return !this.H;
    }

    private static ImageOutput w0(ImageOutput imageOutput) {
        return imageOutput == null ? ImageOutput.f44158a : imageOutput;
    }

    private boolean x0(TileInfo tileInfo) {
        return ((Format) Assertions.i(this.C)).L == -1 || this.C.M == -1 || tileInfo.c() == (((Format) Assertions.i(this.C)).M * this.C.L) - 1;
    }

    private void y0(int i3) {
        this.B = Math.min(this.B, i3);
    }

    private void z0(long j3, DecoderInputBuffer decoderInputBuffer) {
        boolean z2 = true;
        if (decoderInputBuffer.i()) {
            this.H = true;
            return;
        }
        TileInfo tileInfo = new TileInfo(this.K, decoderInputBuffer.f42140g);
        this.J = tileInfo;
        this.K++;
        if (!this.H) {
            long jA = tileInfo.a();
            boolean z3 = jA - 30000 <= j3 && j3 <= 30000 + jA;
            TileInfo tileInfo2 = this.I;
            boolean z4 = tileInfo2 != null && tileInfo2.a() <= j3 && j3 < jA;
            boolean zX0 = x0((TileInfo) Assertions.i(this.J));
            if (!z3 && !z4 && !zX0) {
                z2 = false;
            }
            this.H = z2;
            if (z4 && !z3) {
                return;
            }
        }
        this.I = this.J;
        this.J = null;
    }

    protected boolean B0() {
        return true;
    }

    protected boolean D0(long j3, long j4, Bitmap bitmap, long j5) {
        long j6 = j5 - j3;
        if (!G0() && j6 >= 30000) {
            return false;
        }
        this.F.b(j5 - this.f44165x.f44170b, bitmap);
        return true;
    }

    @Override // androidx.media3.exoplayer.RendererCapabilities
    public int a(Format format) {
        return this.f44160s.a(format);
    }

    @Override // androidx.media3.exoplayer.Renderer
    public boolean b() {
        return this.f44164w;
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    protected void e0() {
        this.C = null;
        this.f44165x = OutputStreamInfo.f44168c;
        this.f44162u.clear();
        E0();
        this.F.a();
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    protected void f0(boolean z2, boolean z3) {
        this.B = z3 ? 1 : 0;
    }

    @Override // androidx.media3.exoplayer.Renderer, androidx.media3.exoplayer.RendererCapabilities
    public String getName() {
        return "ImageRenderer";
    }

    @Override // androidx.media3.exoplayer.Renderer
    public void h(long j3, long j4) throws ExoPlaybackException {
        if (this.f44164w) {
            return;
        }
        if (this.C == null) {
            FormatHolder formatHolderW = W();
            this.f44161t.f();
            int iP0 = p0(formatHolderW, this.f44161t, 2);
            if (iP0 != -5) {
                if (iP0 == -4) {
                    Assertions.g(this.f44161t.i());
                    this.f44163v = true;
                    this.f44164w = true;
                    return;
                }
                return;
            }
            this.C = (Format) Assertions.i(formatHolderW.f43108b);
            this.L = true;
        }
        if (this.D != null || A0()) {
            try {
                TraceUtil.a("drainAndFeedDecoder");
                while (u0(j3, j4)) {
                }
                while (v0(j3)) {
                }
                TraceUtil.b();
            } catch (ImageDecoderException e3) {
                throw S(e3, null, 4003);
            }
        }
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    protected void h0(long j3, boolean z2) {
        y0(1);
        this.f44164w = false;
        this.f44163v = false;
        this.G = null;
        this.I = null;
        this.J = null;
        this.H = false;
        this.E = null;
        ImageDecoder imageDecoder = this.D;
        if (imageDecoder != null) {
            imageDecoder.flush();
        }
        this.f44162u.clear();
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    protected void i0() {
        E0();
    }

    @Override // androidx.media3.exoplayer.Renderer
    public boolean isReady() {
        int i3 = this.B;
        if (i3 != 3) {
            return i3 == 0 && this.H;
        }
        return true;
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    protected void k0() {
        E0();
        y0(1);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0027, code lost:
    
        if (r2 >= r6) goto L15;
     */
    @Override // androidx.media3.exoplayer.BaseRenderer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void n0(androidx.media3.common.Format[] r5, long r6, long r8, androidx.media3.exoplayer.source.MediaSource.MediaPeriodId r10) {
        /*
            r4 = this;
            super.n0(r5, r6, r8, r10)
            r5 = r4
            androidx.media3.exoplayer.image.ImageRenderer$OutputStreamInfo r6 = r5.f44165x
            long r6 = r6.f44170b
            r0 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r6 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r6 == 0) goto L37
            java.util.ArrayDeque r6 = r5.f44162u
            boolean r6 = r6.isEmpty()
            if (r6 == 0) goto L2a
            long r6 = r5.f44167z
            int r10 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r10 == 0) goto L37
            long r2 = r5.f44166y
            int r10 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r10 == 0) goto L2a
            int r6 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r6 < 0) goto L2a
            goto L37
        L2a:
            java.util.ArrayDeque r6 = r5.f44162u
            androidx.media3.exoplayer.image.ImageRenderer$OutputStreamInfo r7 = new androidx.media3.exoplayer.image.ImageRenderer$OutputStreamInfo
            long r0 = r5.f44167z
            r7.<init>(r0, r8)
            r6.add(r7)
            return
        L37:
            androidx.media3.exoplayer.image.ImageRenderer$OutputStreamInfo r6 = new androidx.media3.exoplayer.image.ImageRenderer$OutputStreamInfo
            r6.<init>(r0, r8)
            r5.f44165x = r6
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.image.ImageRenderer.n0(androidx.media3.common.Format[], long, long, androidx.media3.exoplayer.source.MediaSource$MediaPeriodId):void");
    }

    @Override // androidx.media3.exoplayer.BaseRenderer, androidx.media3.exoplayer.PlayerMessage.Target
    public void w(int i3, Object obj) {
        if (i3 != 15) {
            super.w(i3, obj);
        } else {
            F0(obj instanceof ImageOutput ? (ImageOutput) obj : null);
        }
    }
}
