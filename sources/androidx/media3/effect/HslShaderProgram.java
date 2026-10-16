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
final class HslShaderProgram extends BaseGlShaderProgram {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final GlProgram f42443h;

    public HslShaderProgram(Context context, HslAdjustment hslAdjustment, boolean z2) throws VideoFrameProcessingException {
        super(z2, 1);
        Assertions.b(!z2, "HDR is not yet supported.");
        try {
            GlProgram glProgram = new GlProgram(context, "shaders/vertex_shader_transformation_es2.glsl", "shaders/fragment_shader_hsl_es2.glsl");
            this.f42443h = glProgram;
            glProgram.m("aFramePosition", GlUtil.O(), 4);
            float[] fArrH = GlUtil.h();
            glProgram.p("uTransformationMatrix", fArrH);
            glProgram.p("uTexTransformationMatrix", fArrH);
            glProgram.o("uHueAdjustmentDegrees", hslAdjustment.f42440a / 360.0f);
            glProgram.o("uSaturationAdjustment", hslAdjustment.f42441b / 100.0f);
            glProgram.o("uLightnessAdjustment", hslAdjustment.f42442c / 100.0f);
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
            this.f42443h.u();
            this.f42443h.s("uTexSampler", i3, 0);
            this.f42443h.e();
            GLES20.glDrawArrays(5, 0, 4);
        } catch (GlUtil.GlException e3) {
            throw new VideoFrameProcessingException(e3, j3);
        }
    }

    @Override // androidx.media3.effect.BaseGlShaderProgram, androidx.media3.effect.GlShaderProgram
    public void release() throws VideoFrameProcessingException {
        super.release();
        try {
            this.f42443h.f();
        } catch (GlUtil.GlException e3) {
            throw new VideoFrameProcessingException(e3);
        }
    }
}
