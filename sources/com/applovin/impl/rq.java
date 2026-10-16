package com.applovin.impl;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import java.util.concurrent.atomic.AtomicReference;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class rq extends GLSurfaceView implements tq {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f62904b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f62905a;

    public rq(Context context) {
        this(context, null);
    }

    public void setOutputBuffer(sq sqVar) {
        this.f62905a.a(sqVar);
    }

    public rq(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a aVar = new a(this);
        this.f62905a = aVar;
        setPreserveEGLContextOnPause(true);
        setEGLContextClientVersion(2);
        setRenderer(aVar);
        setRenderMode(0);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class a implements GLSurfaceView.Renderer {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private static final float[] f62906j = {1.164f, 1.164f, 1.164f, 0.0f, -0.392f, 2.017f, 1.596f, -0.813f, 0.0f};

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private static final float[] f62907k = {1.164f, 1.164f, 1.164f, 0.0f, -0.213f, 2.112f, 1.793f, -0.533f, 0.0f};

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private static final float[] f62908l = {1.168f, 1.168f, 1.168f, 0.0f, -0.188f, 2.148f, 1.683f, -0.652f, 0.0f};

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private static final String[] f62909m = {"y_tex", "u_tex", "v_tex"};

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private static final FloatBuffer f62910n = aa.a(new float[]{-1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f, -1.0f});

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final GLSurfaceView f62911a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int[] f62912b = new int[3];

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int[] f62913c = new int[3];

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int[] f62914d = new int[3];

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int[] f62915e = new int[3];

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final AtomicReference f62916f = new AtomicReference();

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final FloatBuffer[] f62917g = new FloatBuffer[3];

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f62918h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f62919i;

        public a(GLSurfaceView gLSurfaceView) {
            this.f62911a = gLSurfaceView;
            for (int i3 = 0; i3 < 3; i3++) {
                int[] iArr = this.f62914d;
                this.f62915e[i3] = -1;
                iArr[i3] = -1;
            }
        }

        public void a(sq sqVar) {
            c8.a(this.f62916f.getAndSet(sqVar));
            this.f62911a.requestRender();
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            c8.a(this.f62916f.getAndSet(null));
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i3, int i4) {
            GLES20.glViewport(0, 0, i3, i4);
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            int iA = aa.a("varying vec2 interp_tc_y;\nvarying vec2 interp_tc_u;\nvarying vec2 interp_tc_v;\nattribute vec4 in_pos;\nattribute vec2 in_tc_y;\nattribute vec2 in_tc_u;\nattribute vec2 in_tc_v;\nvoid main() {\n  gl_Position = in_pos;\n  interp_tc_y = in_tc_y;\n  interp_tc_u = in_tc_u;\n  interp_tc_v = in_tc_v;\n}\n", "precision mediump float;\nvarying vec2 interp_tc_y;\nvarying vec2 interp_tc_u;\nvarying vec2 interp_tc_v;\nuniform sampler2D y_tex;\nuniform sampler2D u_tex;\nuniform sampler2D v_tex;\nuniform mat3 mColorConversion;\nvoid main() {\n  vec3 yuv;\n  yuv.x = texture2D(y_tex, interp_tc_y).r - 0.0625;\n  yuv.y = texture2D(u_tex, interp_tc_u).r - 0.5;\n  yuv.z = texture2D(v_tex, interp_tc_v).r - 0.5;\n  gl_FragColor = vec4(mColorConversion * yuv, 1.0);\n}\n");
            this.f62918h = iA;
            GLES20.glUseProgram(iA);
            int iGlGetAttribLocation = GLES20.glGetAttribLocation(this.f62918h, "in_pos");
            GLES20.glEnableVertexAttribArray(iGlGetAttribLocation);
            GLES20.glVertexAttribPointer(iGlGetAttribLocation, 2, 5126, false, 0, (Buffer) f62910n);
            this.f62913c[0] = GLES20.glGetAttribLocation(this.f62918h, "in_tc_y");
            GLES20.glEnableVertexAttribArray(this.f62913c[0]);
            this.f62913c[1] = GLES20.glGetAttribLocation(this.f62918h, "in_tc_u");
            GLES20.glEnableVertexAttribArray(this.f62913c[1]);
            this.f62913c[2] = GLES20.glGetAttribLocation(this.f62918h, "in_tc_v");
            GLES20.glEnableVertexAttribArray(this.f62913c[2]);
            aa.a();
            this.f62919i = GLES20.glGetUniformLocation(this.f62918h, "mColorConversion");
            aa.a();
            a();
            aa.a();
        }

        private void a() {
            GLES20.glGenTextures(3, this.f62912b, 0);
            for (int i3 = 0; i3 < 3; i3++) {
                GLES20.glUniform1i(GLES20.glGetUniformLocation(this.f62918h, f62909m[i3]), i3);
                GLES20.glActiveTexture(33984 + i3);
                GLES20.glBindTexture(3553, this.f62912b[i3]);
                GLES20.glTexParameterf(3553, 10241, 9729.0f);
                GLES20.glTexParameterf(3553, 10240, 9729.0f);
                GLES20.glTexParameterf(3553, 10242, 33071.0f);
                GLES20.glTexParameterf(3553, 10243, 33071.0f);
            }
            aa.a();
        }
    }

    @Deprecated
    public tq getVideoDecoderOutputBufferRenderer() {
        return this;
    }
}
