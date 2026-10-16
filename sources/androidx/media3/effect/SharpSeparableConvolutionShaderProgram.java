package androidx.media3.effect;

import android.content.Context;
import android.graphics.Matrix;
import androidx.media3.common.GlTextureInfo;
import androidx.media3.common.VideoFrameProcessingException;
import androidx.media3.common.util.GlProgram;
import androidx.media3.common.util.GlUtil;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class SharpSeparableConvolutionShaderProgram extends SeparableConvolutionShaderProgram {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final GlProgram f42594t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final float[] f42595u;

    public SharpSeparableConvolutionShaderProgram(Context context, boolean z2, SeparableConvolution separableConvolution, float f3, float f4) throws VideoFrameProcessingException {
        super(context, z2, separableConvolution, 1.0f / f3, 1.0f / f4);
        try {
            this.f42594t = new GlProgram(context, "shaders/vertex_shader_transformation_es2.glsl", "shaders/fragment_shader_copy_es2.glsl");
            Matrix matrix = new Matrix();
            matrix.setScale(f3, f4);
            this.f42595u = MatrixUtils.d(matrix);
        } catch (GlUtil.GlException | IOException e3) {
            throw new VideoFrameProcessingException(e3);
        }
    }

    @Override // androidx.media3.effect.SeparableConvolutionShaderProgram
    protected void n(GlTextureInfo glTextureInfo) {
        float[] fArrH = GlUtil.h();
        this.f42594t.u();
        this.f42594t.s("uTexSampler", glTextureInfo.f40690a, 0);
        this.f42594t.p("uTexTransformationMatrix", fArrH);
        this.f42594t.p("uTransformationMatrix", this.f42595u);
        this.f42594t.m("aFramePosition", GlUtil.O(), 4);
        this.f42594t.e();
    }

    @Override // androidx.media3.effect.SeparableConvolutionShaderProgram, androidx.media3.effect.GlShaderProgram
    public void release() throws VideoFrameProcessingException {
        super.release();
        try {
            this.f42594t.f();
        } catch (GlUtil.GlException e3) {
            throw new VideoFrameProcessingException(e3);
        }
    }
}
