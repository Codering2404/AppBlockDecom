package androidx.media3.effect;

import android.content.Context;
import android.opengl.GLES20;
import androidx.media3.common.VideoFrameProcessingException;
import androidx.media3.common.util.GlProgram;
import androidx.media3.common.util.GlUtil;
import androidx.media3.common.util.Size;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
class FrameCacheGlShaderProgram extends BaseGlShaderProgram {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final GlProgram f42424h;

    public FrameCacheGlShaderProgram(Context context, int i3, boolean z2) throws VideoFrameProcessingException {
        super(z2, i3);
        try {
            GlProgram glProgram = new GlProgram(context, "shaders/vertex_shader_transformation_es2.glsl", "shaders/fragment_shader_transformation_es2.glsl");
            this.f42424h = glProgram;
            float[] fArrH = GlUtil.h();
            glProgram.p("uTexTransformationMatrix", fArrH);
            glProgram.p("uTransformationMatrix", fArrH);
            glProgram.p("uRgbMatrix", fArrH);
            glProgram.m("aFramePosition", GlUtil.O(), 4);
        } catch (GlUtil.GlException | IOException e3) {
            throw VideoFrameProcessingException.a(e3);
        }
    }

    @Override // androidx.media3.effect.BaseGlShaderProgram
    public Size j(int i3, int i4) {
        return new Size(i3, i4);
    }

    @Override // androidx.media3.effect.BaseGlShaderProgram
    public void n(int i3, long j3) throws VideoFrameProcessingException {
        try {
            this.f42424h.u();
            this.f42424h.s("uTexSampler", i3, 0);
            this.f42424h.e();
            GLES20.glDrawArrays(5, 0, 4);
        } catch (GlUtil.GlException e3) {
            throw VideoFrameProcessingException.a(e3);
        }
    }

    @Override // androidx.media3.effect.BaseGlShaderProgram, androidx.media3.effect.GlShaderProgram
    public void release() throws VideoFrameProcessingException {
        super.release();
        try {
            this.f42424h.f();
        } catch (GlUtil.GlException e3) {
            throw new VideoFrameProcessingException(e3);
        }
    }
}
