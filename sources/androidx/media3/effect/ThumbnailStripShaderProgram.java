package androidx.media3.effect;

import android.content.Context;
import android.opengl.GLES20;
import androidx.media3.common.VideoFrameProcessingException;
import androidx.media3.common.util.GlProgram;
import androidx.media3.common.util.GlUtil;
import androidx.media3.common.util.Size;
import androidx.media3.common.util.Util;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class ThumbnailStripShaderProgram extends BaseGlShaderProgram {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final GlProgram f42650h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final ThumbnailStripEffect f42651i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f42652j;

    public ThumbnailStripShaderProgram(Context context, boolean z2, ThumbnailStripEffect thumbnailStripEffect) throws VideoFrameProcessingException {
        super(z2, 1);
        this.f42651i = thumbnailStripEffect;
        try {
            GlProgram glProgram = new GlProgram(context, "shaders/vertex_shader_thumbnail_strip_es2.glsl", "shaders/fragment_shader_copy_es2.glsl");
            this.f42650h = glProgram;
            glProgram.m("aFramePosition", GlUtil.O(), 4);
        } catch (GlUtil.GlException | IOException e3) {
            throw VideoFrameProcessingException.a(e3);
        }
    }

    @Override // androidx.media3.effect.BaseGlShaderProgram
    public Size j(int i3, int i4) {
        ThumbnailStripEffect thumbnailStripEffect = this.f42651i;
        return new Size(thumbnailStripEffect.f42646a, thumbnailStripEffect.f42647b);
    }

    @Override // androidx.media3.effect.BaseGlShaderProgram
    public void n(int i3, long j3) throws VideoFrameProcessingException {
        if (!this.f42652j) {
            try {
                GlUtil.g();
                this.f42652j = true;
            } catch (GlUtil.GlException e3) {
                throw new VideoFrameProcessingException(e3, j3);
            }
        }
        long jP0 = Util.P0(this.f42651i.l());
        if (this.f42651i.n() || j3 < jP0) {
            return;
        }
        try {
            this.f42650h.u();
            this.f42650h.s("uTexSampler", i3, 0);
            this.f42650h.r("uIndex", this.f42651i.k());
            this.f42650h.r("uCount", this.f42651i.m());
            this.f42650h.e();
            GLES20.glDrawArrays(5, 0, 4);
            this.f42651i.o();
        } catch (GlUtil.GlException e4) {
            throw new VideoFrameProcessingException(e4, j3);
        }
    }

    @Override // androidx.media3.effect.BaseGlShaderProgram
    public boolean r() {
        return false;
    }

    @Override // androidx.media3.effect.BaseGlShaderProgram, androidx.media3.effect.GlShaderProgram
    public void release() throws VideoFrameProcessingException {
        super.release();
        try {
            this.f42650h.f();
        } catch (GlUtil.GlException e3) {
            throw new VideoFrameProcessingException(e3);
        }
    }
}
