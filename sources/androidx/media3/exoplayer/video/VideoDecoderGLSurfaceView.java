package androidx.media3.exoplayer.video;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.util.Log;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.GlProgram;
import androidx.media3.common.util.GlUtil;
import androidx.media3.decoder.VideoDecoderOutputBuffer;
import cz.mobilesoft.coreblock.scene.lockscreen.EI.MrGIhy;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.util.concurrent.atomic.AtomicReference;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class VideoDecoderGLSurfaceView extends GLSurfaceView implements VideoDecoderOutputBufferRenderer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Renderer f45809a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes2.dex */
    private static final class Renderer implements GLSurfaceView.Renderer {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private static final float[] f45810l = {1.164f, 1.164f, 1.164f, 0.0f, -0.392f, 2.017f, 1.596f, -0.813f, 0.0f};

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private static final float[] f45811m = {1.164f, 1.164f, 1.164f, 0.0f, -0.213f, 2.112f, 1.793f, -0.533f, 0.0f};

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private static final float[] f45812n = {1.168f, 1.168f, 1.168f, 0.0f, -0.188f, 2.148f, 1.683f, -0.652f, 0.0f};

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private static final String[] f45813o = {"y_tex", "u_tex", "v_tex"};

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private static final FloatBuffer f45814p = GlUtil.j(new float[]{-1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f, -1.0f});

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final GLSurfaceView f45815a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int[] f45816b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int[] f45817c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int[] f45818d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final int[] f45819f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final AtomicReference f45820g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final FloatBuffer[] f45821h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private GlProgram f45822i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private int f45823j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private VideoDecoderOutputBuffer f45824k;

        private void b() {
            try {
                GLES20.glGenTextures(3, this.f45816b, 0);
                for (int i3 = 0; i3 < 3; i3++) {
                    GLES20.glUniform1i(this.f45822i.l(f45813o[i3]), i3);
                    GLES20.glActiveTexture(33984 + i3);
                    GlUtil.b(3553, this.f45816b[i3], 9729);
                }
                GlUtil.e();
            } catch (GlUtil.GlException e3) {
                Log.e("VideoDecoderGLSV", "Failed to set up the textures", e3);
            }
        }

        public void a(VideoDecoderOutputBuffer videoDecoderOutputBuffer) {
            VideoDecoderOutputBuffer videoDecoderOutputBuffer2 = (VideoDecoderOutputBuffer) this.f45820g.getAndSet(videoDecoderOutputBuffer);
            if (videoDecoderOutputBuffer2 != null) {
                videoDecoderOutputBuffer2.o();
            }
            this.f45815a.requestRender();
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            VideoDecoderOutputBuffer videoDecoderOutputBuffer = (VideoDecoderOutputBuffer) this.f45820g.getAndSet(null);
            if (videoDecoderOutputBuffer == null && this.f45824k == null) {
                return;
            }
            if (videoDecoderOutputBuffer != null) {
                VideoDecoderOutputBuffer videoDecoderOutputBuffer2 = this.f45824k;
                if (videoDecoderOutputBuffer2 != null) {
                    videoDecoderOutputBuffer2.o();
                }
                this.f45824k = videoDecoderOutputBuffer;
            }
            VideoDecoderOutputBuffer videoDecoderOutputBuffer3 = (VideoDecoderOutputBuffer) Assertions.e(this.f45824k);
            float[] fArr = f45811m;
            int i3 = videoDecoderOutputBuffer3.f42171k;
            if (i3 == 1) {
                fArr = f45810l;
            } else if (i3 == 3) {
                fArr = f45812n;
            }
            GLES20.glUniformMatrix3fv(this.f45823j, 1, false, fArr, 0);
            int[] iArr = (int[]) Assertions.e(videoDecoderOutputBuffer3.f42170j);
            ByteBuffer[] byteBufferArr = (ByteBuffer[]) Assertions.e(videoDecoderOutputBuffer3.f42169i);
            int i4 = 0;
            while (i4 < 3) {
                int i5 = i4 == 0 ? videoDecoderOutputBuffer3.f42168h : (videoDecoderOutputBuffer3.f42168h + 1) / 2;
                GLES20.glActiveTexture(33984 + i4);
                GLES20.glBindTexture(3553, this.f45816b[i4]);
                GLES20.glPixelStorei(3317, 1);
                GLES20.glTexImage2D(3553, 0, 6409, iArr[i4], i5, 0, 6409, 5121, byteBufferArr[i4]);
                i4++;
            }
            int i6 = videoDecoderOutputBuffer3.f42167g;
            int i7 = (i6 + 1) / 2;
            int[] iArr2 = {i6, i7, i7};
            for (int i8 = 0; i8 < 3; i8++) {
                if (this.f45818d[i8] != iArr2[i8] || this.f45819f[i8] != iArr[i8]) {
                    Assertions.g(iArr[i8] != 0);
                    float f3 = iArr2[i8] / iArr[i8];
                    this.f45821h[i8] = GlUtil.j(new float[]{0.0f, 0.0f, 0.0f, 1.0f, f3, 0.0f, f3, 1.0f});
                    GLES20.glVertexAttribPointer(this.f45817c[i8], 2, 5126, false, 0, (Buffer) this.f45821h[i8]);
                    this.f45818d[i8] = iArr2[i8];
                    this.f45819f[i8] = iArr[i8];
                }
            }
            GLES20.glClear(16384);
            GLES20.glDrawArrays(5, 0, 4);
            try {
                GlUtil.e();
            } catch (GlUtil.GlException e3) {
                Log.e("VideoDecoderGLSV", "Failed to draw a frame", e3);
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i3, int i4) {
            GLES20.glViewport(0, 0, i3, i4);
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            try {
                GlProgram glProgram = new GlProgram("varying vec2 interp_tc_y;\nvarying vec2 interp_tc_u;\nvarying vec2 interp_tc_v;\nattribute vec4 in_pos;\nattribute vec2 in_tc_y;\nattribute vec2 in_tc_u;\nattribute vec2 in_tc_v;\nvoid main() {\n  gl_Position = in_pos;\n  interp_tc_y = in_tc_y;\n  interp_tc_u = in_tc_u;\n  interp_tc_v = in_tc_v;\n}\n", "precision mediump float;\nvarying vec2 interp_tc_y;\nvarying vec2 interp_tc_u;\nvarying vec2 interp_tc_v;\nuniform sampler2D y_tex;\nuniform sampler2D u_tex;\nuniform sampler2D v_tex;\nuniform mat3 mColorConversion;\nvoid main() {\n  vec3 yuv;\n  yuv.x = texture2D(y_tex, interp_tc_y).r - 0.0625;\n  yuv.y = texture2D(u_tex, interp_tc_u).r - 0.5;\n  yuv.z = texture2D(v_tex, interp_tc_v).r - 0.5;\n  gl_FragColor = vec4(mColorConversion * yuv, 1.0);\n}\n");
                this.f45822i = glProgram;
                GLES20.glVertexAttribPointer(glProgram.g(MrGIhy.nwoWRWdJrCJYCG), 2, 5126, false, 0, (Buffer) f45814p);
                this.f45817c[0] = this.f45822i.g("in_tc_y");
                this.f45817c[1] = this.f45822i.g("in_tc_u");
                this.f45817c[2] = this.f45822i.g("in_tc_v");
                this.f45823j = this.f45822i.l("mColorConversion");
                GlUtil.e();
                b();
                GlUtil.e();
            } catch (GlUtil.GlException e3) {
                Log.e("VideoDecoderGLSV", "Failed to set up the textures and program", e3);
            }
        }
    }

    @Override // androidx.media3.exoplayer.video.VideoDecoderOutputBufferRenderer
    public void setOutputBuffer(VideoDecoderOutputBuffer videoDecoderOutputBuffer) {
        this.f45809a.a(videoDecoderOutputBuffer);
    }

    @Deprecated
    public VideoDecoderOutputBufferRenderer getVideoDecoderOutputBufferRenderer() {
        return this;
    }
}
