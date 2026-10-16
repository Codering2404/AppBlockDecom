package androidx.media3.effect;

import android.content.Context;
import android.opengl.GLES20;
import androidx.media3.common.GlObjectsProvider;
import androidx.media3.common.GlTextureInfo;
import androidx.media3.common.VideoFrameProcessingException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.GlProgram;
import androidx.media3.common.util.GlUtil;
import androidx.media3.common.util.Size;
import androidx.media3.effect.ConvolutionFunction1D;
import androidx.media3.effect.GlShaderProgram;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.nio.FloatBuffer;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class SeparableConvolutionShaderProgram implements GlShaderProgram {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final GlProgram f42570a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f42571b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ConvolutionFunction1D.Provider f42572c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private GlShaderProgram.InputListener f42573d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private GlShaderProgram.OutputListener f42574e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private GlShaderProgram.ErrorListener f42575f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Executor f42576g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f42577h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private GlTextureInfo f42578i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private GlTextureInfo f42579j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private GlTextureInfo f42580k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private float f42581l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private float f42582m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private float f42583n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private float f42584o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private Size f42585p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private Size f42586q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private Size f42587r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private ConvolutionFunction1D f42588s;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class SeparableConvolutionWrapper implements ConvolutionFunction1D.Provider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final SeparableConvolution f42591a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final float f42592b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final float f42593c;

        public SeparableConvolutionWrapper(SeparableConvolution separableConvolution, float f3, float f4) {
            this.f42591a = separableConvolution;
            this.f42592b = f3;
            this.f42593c = f4;
        }

        @Override // androidx.media3.effect.ConvolutionFunction1D.Provider
        public Size a(Size size) {
            return new Size((int) (size.b() * this.f42592b), (int) (size.a() * this.f42593c));
        }

        @Override // androidx.media3.effect.ConvolutionFunction1D.Provider
        public ConvolutionFunction1D b(long j3) {
            return this.f42591a.k(j3);
        }
    }

    public SeparableConvolutionShaderProgram(Context context, boolean z2, SeparableConvolution separableConvolution, float f3, float f4) {
        this(context, z2, new SeparableConvolutionWrapper(separableConvolution, f3, f4));
    }

    private GlTextureInfo f(GlObjectsProvider glObjectsProvider, GlTextureInfo glTextureInfo, Size size) throws GlUtil.GlException {
        if (size.b() == glTextureInfo.f40693d && size.a() == glTextureInfo.f40694e) {
            return glTextureInfo;
        }
        glTextureInfo.a();
        return glObjectsProvider.b(GlUtil.u(size.b(), size.a(), this.f42571b), size.b(), size.a());
    }

    private void j(GlObjectsProvider glObjectsProvider, Size size, long j3) throws GlUtil.GlException {
        this.f42585p = this.f42572c.a(size);
        ConvolutionFunction1D convolutionFunction1DB = this.f42572c.b(j3);
        if (!convolutionFunction1DB.equals(this.f42588s)) {
            r(convolutionFunction1DB);
            this.f42588s = convolutionFunction1DB;
        }
        if (size.equals(this.f42586q)) {
            return;
        }
        this.f42570a.m("aFramePosition", GlUtil.O(), 4);
        float[] fArrH = GlUtil.h();
        this.f42570a.p("uTransformationMatrix", fArrH);
        this.f42570a.p("uTexTransformationMatrix", fArrH);
        Size size2 = new Size(this.f42585p.b(), size.a());
        this.f42587r = size2;
        this.f42579j = f(glObjectsProvider, this.f42579j, size2);
        this.f42578i = f(glObjectsProvider, this.f42578i, this.f42585p);
        this.f42586q = size;
    }

    private void o(GlTextureInfo glTextureInfo) throws GlUtil.GlException {
        GlTextureInfo glTextureInfo2 = this.f42579j;
        GlUtil.H(glTextureInfo2.f40691b, glTextureInfo2.f40693d, glTextureInfo2.f40694e);
        GlUtil.g();
        p(glTextureInfo.f40690a, true);
    }

    private void p(int i3, boolean z2) throws GlUtil.GlException {
        int iB = z2 ? this.f42586q.b() : this.f42587r.a();
        this.f42570a.u();
        this.f42570a.s("uTexSampler", i3, 0);
        this.f42570a.r("uIsHorizontal", z2 ? 1 : 0);
        float f3 = iB;
        this.f42570a.o("uSourceTexelSize", 1.0f / f3);
        this.f42570a.o("uSourceFullSize", f3);
        this.f42570a.o("uConvStartTexels", this.f42583n);
        this.f42570a.o("uConvWidthTexels", this.f42584o);
        this.f42570a.o("uFunctionLookupStepSize", this.f42581l);
        this.f42570a.p("uFunctionLookupCenter", new float[]{this.f42582m, 0.5f});
        this.f42570a.s("uFunctionLookupSampler", this.f42580k.f40690a, 1);
        this.f42570a.e();
        GLES20.glDrawArrays(5, 0, 4);
        GlUtil.e();
    }

    private void q() throws GlUtil.GlException {
        GlTextureInfo glTextureInfo = this.f42578i;
        GlUtil.H(glTextureInfo.f40691b, glTextureInfo.f40693d, glTextureInfo.f40694e);
        GlUtil.g();
        p(this.f42579j.f40690a, false);
    }

    private void r(ConvolutionFunction1D convolutionFunction1D) throws GlUtil.GlException {
        int i3;
        int iCeil = (int) Math.ceil((convolutionFunction1D.d() * 5.0f) + 10.0f);
        float f3 = iCeil;
        this.f42581l = 1.0f / (f3 / 5.0f);
        FloatBuffer floatBufferAllocate = FloatBuffer.allocate(iCeil);
        float fC = convolutionFunction1D.c();
        int i4 = 0;
        int i5 = 0;
        while (i4 < iCeil) {
            int i6 = i4 - 5;
            floatBufferAllocate.put(i5, (i6 < 0 || i4 > iCeil + (-5)) ? 0.0f : convolutionFunction1D.a((i6 * 0.2f) + fC));
            i4++;
            i5++;
        }
        this.f42582m = (-(fC - 1.1f)) / (0.2f * f3);
        this.f42583n = convolutionFunction1D.c();
        this.f42584o = convolutionFunction1D.d();
        GlTextureInfo glTextureInfo = this.f42580k;
        if (glTextureInfo == GlTextureInfo.f40689f || glTextureInfo.f40693d != iCeil) {
            glTextureInfo.a();
            i3 = iCeil;
            this.f42580k = new GlTextureInfo(GlUtil.J(), -1, -1, i3, 1);
        } else {
            i3 = iCeil;
        }
        GlUtil.b(3553, this.f42580k.f40690a, 9729);
        GLES20.glTexImage2D(3553, 0, 33325, i3, 1, 0, 6403, 5126, floatBufferAllocate);
        GlUtil.e();
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public final void c() {
        this.f42574e.c();
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public final void d(GlObjectsProvider glObjectsProvider, GlTextureInfo glTextureInfo, final long j3) {
        Assertions.h(!this.f42577h, "The shader program does not currently accept input frames. Release prior output frames first.");
        try {
            j(glObjectsProvider, new Size(glTextureInfo.f40693d, glTextureInfo.f40694e), j3);
            this.f42577h = true;
            o(glTextureInfo);
            q();
            n(glTextureInfo);
            GLES20.glDrawArrays(5, 0, 4);
            GlUtil.e();
            this.f42573d.e(glTextureInfo);
            this.f42574e.a(this.f42578i, j3);
        } catch (GlUtil.GlException e3) {
            this.f42576g.execute(new Runnable() { // from class: androidx.media3.effect.b2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f42693a.f42575f.a(VideoFrameProcessingException.b(e3, j3));
                }
            });
        }
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public final void flush() {
        this.f42577h = false;
        this.f42573d.b();
        this.f42573d.f();
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public final void g(Executor executor, GlShaderProgram.ErrorListener errorListener) {
        this.f42576g = executor;
        this.f42575f = errorListener;
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public final void k(GlShaderProgram.OutputListener outputListener) {
        this.f42574e = outputListener;
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public final void l(GlTextureInfo glTextureInfo) {
        this.f42577h = false;
        this.f42573d.f();
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public final void m(GlShaderProgram.InputListener inputListener) {
        this.f42573d = inputListener;
        if (this.f42577h) {
            return;
        }
        inputListener.f();
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void release() throws VideoFrameProcessingException {
        try {
            this.f42578i.a();
            this.f42579j.a();
            this.f42580k.a();
            this.f42570a.f();
        } catch (GlUtil.GlException e3) {
            throw new VideoFrameProcessingException(e3);
        }
    }

    public SeparableConvolutionShaderProgram(Context context, boolean z2, ConvolutionFunction1D.Provider provider) throws VideoFrameProcessingException {
        this.f42571b = z2;
        this.f42572c = provider;
        this.f42573d = new GlShaderProgram.InputListener() { // from class: androidx.media3.effect.SeparableConvolutionShaderProgram.1
        };
        this.f42574e = new GlShaderProgram.OutputListener() { // from class: androidx.media3.effect.SeparableConvolutionShaderProgram.2
        };
        this.f42575f = new GlShaderProgram.ErrorListener() { // from class: androidx.media3.effect.c2
            @Override // androidx.media3.effect.GlShaderProgram.ErrorListener
            public final void a(VideoFrameProcessingException videoFrameProcessingException) {
                SeparableConvolutionShaderProgram.e(videoFrameProcessingException);
            }
        };
        this.f42576g = MoreExecutors.a();
        GlTextureInfo glTextureInfo = GlTextureInfo.f40689f;
        this.f42580k = glTextureInfo;
        this.f42579j = glTextureInfo;
        this.f42578i = glTextureInfo;
        Size size = Size.f41594d;
        this.f42586q = size;
        this.f42587r = size;
        this.f42585p = size;
        this.f42588s = null;
        try {
            this.f42570a = new GlProgram(context, "shaders/vertex_shader_transformation_es2.glsl", "shaders/fragment_shader_separable_convolution_es2.glsl");
        } catch (GlUtil.GlException | IOException e3) {
            throw new VideoFrameProcessingException(e3);
        }
    }

    public static /* synthetic */ void e(VideoFrameProcessingException videoFrameProcessingException) {
    }

    protected void n(GlTextureInfo glTextureInfo) {
    }
}
