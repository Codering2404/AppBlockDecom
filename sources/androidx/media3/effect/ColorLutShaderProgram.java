package androidx.media3.effect;

import android.content.Context;
import android.opengl.GLES20;
import androidx.media3.common.VideoFrameProcessingException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.GlProgram;
import androidx.media3.common.util.GlUtil;
import androidx.media3.common.util.Size;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class ColorLutShaderProgram extends BaseGlShaderProgram {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final GlProgram f42234h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final ColorLut f42235i;

    public ColorLutShaderProgram(Context context, ColorLut colorLut, boolean z2) throws VideoFrameProcessingException {
        super(z2, 1);
        Assertions.b(!z2, "ColorLutShaderProgram does not support HDR colors.");
        this.f42235i = colorLut;
        try {
            GlProgram glProgram = new GlProgram(context, "shaders/vertex_shader_transformation_es2.glsl", "shaders/fragment_shader_lut_es2.glsl");
            this.f42234h = glProgram;
            glProgram.m("aFramePosition", GlUtil.O(), 4);
            float[] fArrH = GlUtil.h();
            glProgram.p("uTransformationMatrix", fArrH);
            glProgram.p("uTexTransformationMatrix", fArrH);
        } catch (GlUtil.GlException | IOException e3) {
            throw new VideoFrameProcessingException(e3);
        }
    }

    @Override // androidx.media3.effect.BaseGlShaderProgram
    public Size j(int i3, int i4) {
        return new Size(i3, i4);
    }

    @Override // androidx.media3.effect.BaseGlShaderProgram
    public void n(int i3, long j3) throws VideoFrameProcessingException {
        try {
            this.f42234h.u();
            this.f42234h.s("uTexSampler", i3, 0);
            this.f42234h.s("uColorLut", this.f42235i.f(j3), 1);
            this.f42234h.o("uColorLutLength", this.f42235i.h(j3));
            this.f42234h.e();
            GLES20.glDrawArrays(5, 0, 4);
        } catch (GlUtil.GlException e3) {
            throw new VideoFrameProcessingException(e3);
        }
    }

    @Override // androidx.media3.effect.BaseGlShaderProgram, androidx.media3.effect.GlShaderProgram
    public void release() throws VideoFrameProcessingException {
        super.release();
        try {
            this.f42235i.release();
            this.f42234h.f();
        } catch (GlUtil.GlException e3) {
            throw new VideoFrameProcessingException(e3);
        }
    }
}
