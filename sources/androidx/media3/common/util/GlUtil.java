package androidx.media3.common.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.opengl.GLES30;
import android.opengl.GLU;
import android.opengl.GLUtils;
import android.opengl.Matrix;
import android.os.Build;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class GlUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f41535a = {12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 0, 12344};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f41536b = {12352, 4, 12324, 10, 12323, 10, 12322, 10, 12321, 2, 12325, 0, 12326, 0, 12344};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int[] f41537c = {12445, 13120, 12344, 12344};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int[] f41538d = {12445, 13632, 12344, 12344};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int[] f41539e = {12344};

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class GlException extends Exception {
        public GlException(String str) {
            super(str);
        }
    }

    public static void A(int i3) throws GlException {
        GLES20.glDeleteRenderbuffers(1, new int[]{i3}, 0);
        e();
    }

    public static void B(long j3) throws GlException {
        C(j3);
        e();
    }

    public static void C(long j3) {
        GLES30.glDeleteSync(j3);
    }

    public static void D(int i3) throws GlException {
        GLES20.glDeleteTextures(1, new int[]{i3}, 0);
        e();
    }

    public static void E(EGLDisplay eGLDisplay, EGLContext eGLContext) throws GlException {
        if (eGLDisplay == null || eGLDisplay.equals(EGL14.EGL_NO_DISPLAY)) {
            return;
        }
        EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
        EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
        d("Error releasing context");
        if (eGLContext != null && !eGLContext.equals(EGL14.EGL_NO_CONTEXT)) {
            EGL14.eglDestroyContext(eGLDisplay, eGLContext);
            d("Error destroying context");
        }
        EGL14.eglReleaseThread();
        d("Error releasing thread");
        EGL14.eglTerminate(eGLDisplay);
        d("Error terminating display");
    }

    public static void F(EGLDisplay eGLDisplay, EGLSurface eGLSurface) throws GlException {
        if (eGLDisplay == null || eGLDisplay.equals(EGL14.EGL_NO_DISPLAY) || eGLSurface == null || eGLSurface.equals(EGL14.EGL_NO_SURFACE)) {
            return;
        }
        EGL14.eglDestroySurface(eGLDisplay, eGLSurface);
        d("Error destroying surface");
    }

    public static void G(EGLDisplay eGLDisplay, EGLContext eGLContext, EGLSurface eGLSurface, int i3, int i4) throws GlException {
        I(eGLDisplay, eGLContext, eGLSurface, 0, i3, i4);
    }

    public static void H(int i3, int i4, int i5) throws GlException {
        int[] iArr = new int[1];
        GLES20.glGetIntegerv(36006, iArr, 0);
        if (iArr[0] != i3) {
            GLES20.glBindFramebuffer(36160, i3);
        }
        e();
        GLES20.glViewport(0, 0, i4, i5);
        e();
    }

    private static void I(EGLDisplay eGLDisplay, EGLContext eGLContext, EGLSurface eGLSurface, int i3, int i4, int i5) throws GlException {
        EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, eGLContext);
        d("Error making context current");
        H(i3, i4, i5);
    }

    public static int J() throws GlException {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        e();
        return iArr[0];
    }

    public static long K() throws GlException {
        EGL14.eglQueryContext(EGL14.eglGetDisplay(0), EGL14.eglGetCurrentContext(), 12440, new int[1], 0);
        e();
        return r0[0];
    }

    public static EGLContext L() {
        return EGL14.eglGetCurrentContext();
    }

    public static EGLDisplay M() throws GlException {
        EGLDisplay eGLDisplayEglGetDisplay = EGL14.eglGetDisplay(0);
        f(!eGLDisplayEglGetDisplay.equals(EGL14.EGL_NO_DISPLAY), "No EGL display.");
        f(EGL14.eglInitialize(eGLDisplayEglGetDisplay, new int[1], 0, new int[1], 0), "Error in eglInitialize.");
        e();
        return eGLDisplayEglGetDisplay;
    }

    private static EGLConfig N(EGLDisplay eGLDisplay, int[] iArr) throws GlException {
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        if (EGL14.eglChooseConfig(eGLDisplay, iArr, 0, eGLConfigArr, 0, 1, new int[1], 0)) {
            return eGLConfigArr[0];
        }
        throw new GlException("eglChooseConfig failed.");
    }

    public static float[] O() {
        return new float[]{-1.0f, -1.0f, 0.0f, 1.0f, 1.0f, -1.0f, 0.0f, 1.0f, -1.0f, 1.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f};
    }

    public static boolean P() {
        return R("EGL_EXT_gl_colorspace_bt2020_hlg");
    }

    public static boolean Q() {
        return Util.f41609a >= 33 && R("EGL_EXT_gl_colorspace_bt2020_pq");
    }

    private static boolean R(String str) {
        String strEglQueryString = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373);
        return strEglQueryString != null && strEglQueryString.contains(str);
    }

    public static boolean S(Context context) {
        int i3 = Util.f41609a;
        if (i3 < 24) {
            return false;
        }
        if (i3 < 26 && ("samsung".equals(Build.MANUFACTURER) || "XT1650".equals(Build.MODEL))) {
            return false;
        }
        if (i3 >= 26 || context.getPackageManager().hasSystemFeature("android.hardware.vr.high_performance")) {
            return R("EGL_EXT_protected_content");
        }
        return false;
    }

    public static boolean T() {
        return R("EGL_KHR_surfaceless_context");
    }

    public static boolean U() {
        String strGlGetString;
        if (Objects.equals(EGL14.eglGetCurrentContext(), EGL14.EGL_NO_CONTEXT)) {
            try {
                EGLDisplay eGLDisplayM = M();
                EGLContext eGLContextL = l(eGLDisplayM);
                p(eGLContextL, eGLDisplayM);
                strGlGetString = GLES20.glGetString(7939);
                E(eGLDisplayM, eGLContextL);
            } catch (GlException unused) {
                return false;
            }
        } else {
            strGlGetString = GLES20.glGetString(7939);
        }
        return strGlGetString != null && strGlGetString.contains("GL_EXT_YUV_target");
    }

    public static ByteBuffer V(int i3, int i4) throws GlException {
        GLES20.glBindBuffer(35051, i3);
        e();
        ByteBuffer byteBuffer = (ByteBuffer) GLES30.glMapBufferRange(35051, 0, i4, 1);
        e();
        GLES20.glBindBuffer(35051, 0);
        e();
        return byteBuffer;
    }

    public static void W(int i3, int i4, int i5, int i6) throws GlException {
        H(i3, i4, i5);
        GLES20.glBindBuffer(35051, i6);
        e();
        GLES30.glReadBuffer(36064);
        GLES30.glReadPixels(0, 0, i4, i5, 6408, 5121, 0);
        e();
        GLES20.glBindBuffer(35051, 0);
        e();
    }

    public static void X(int i3, Bitmap bitmap) throws GlException {
        a(bitmap.getWidth(), bitmap.getHeight());
        b(3553, i3, 9729);
        GLUtils.texImage2D(3553, 0, bitmap, 0);
        e();
    }

    public static void Y(float[] fArr) {
        Matrix.setIdentityM(fArr, 0);
    }

    public static void Z(int i3) throws GlException {
        GLES20.glBindBuffer(35051, i3);
        e();
        GLES30.glUnmapBuffer(35051);
        e();
        GLES20.glBindBuffer(35051, 0);
        e();
    }

    private static void a(int i3, int i4) throws GlException {
        int[] iArr = new int[1];
        GLES20.glGetIntegerv(3379, iArr, 0);
        int i5 = iArr[0];
        Assertions.h(i5 > 0, "Create a OpenGL context first or run the GL methods on an OpenGL thread.");
        if (i3 < 0 || i4 < 0) {
            throw new GlException("width or height is less than 0");
        }
        if (i3 > i5 || i4 > i5) {
            throw new GlException("width or height is greater than GL_MAX_TEXTURE_SIZE " + i5);
        }
    }

    public static void b(int i3, int i4, int i5) throws GlException {
        GLES20.glBindTexture(i3, i4);
        e();
        GLES20.glTexParameteri(i3, 10240, i5);
        e();
        GLES20.glTexParameteri(i3, 10241, i5);
        e();
        GLES20.glTexParameteri(i3, 10242, 33071);
        e();
        GLES20.glTexParameteri(i3, 10243, 33071);
        e();
    }

    public static void c(int i3, GlRect glRect, int i4, GlRect glRect2) throws GlException {
        int[] iArr = new int[1];
        GLES20.glGetIntegerv(36006, iArr, 0);
        e();
        GLES20.glBindFramebuffer(36008, i3);
        e();
        GLES20.glBindFramebuffer(36009, i4);
        e();
        GLES30.glBlitFramebuffer(glRect.f41531a, glRect.f41532b, glRect.f41533c, glRect.f41534d, glRect2.f41531a, glRect2.f41532b, glRect2.f41533c, glRect2.f41534d, 16384, 9729);
        e();
        GLES20.glBindFramebuffer(36160, iArr[0]);
        e();
    }

    private static void d(String str) throws GlException {
        int iEglGetError = EGL14.eglGetError();
        if (iEglGetError == 12288) {
            return;
        }
        throw new GlException(str + ", error code: 0x" + Integer.toHexString(iEglGetError));
    }

    public static void e() throws GlException {
        StringBuilder sb = new StringBuilder();
        boolean z2 = false;
        while (true) {
            int iGlGetError = GLES20.glGetError();
            if (iGlGetError == 0) {
                break;
            }
            if (z2) {
                sb.append('\n');
            }
            String strGluErrorString = GLU.gluErrorString(iGlGetError);
            if (strGluErrorString == null) {
                strGluErrorString = "error code: 0x" + Integer.toHexString(iGlGetError);
            }
            sb.append("glError: ");
            sb.append(strGluErrorString);
            z2 = true;
        }
        if (z2) {
            throw new GlException(sb.toString());
        }
    }

    public static void f(boolean z2, String str) throws GlException {
        if (!z2) {
            throw new GlException(str);
        }
    }

    public static void g() throws GlException {
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClearDepthf(1.0f);
        GLES20.glClear(16640);
        e();
    }

    public static float[] h() {
        float[] fArr = new float[16];
        Y(fArr);
        return fArr;
    }

    private static FloatBuffer i(int i3) {
        return ByteBuffer.allocateDirect(i3 * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    }

    public static FloatBuffer j(float[] fArr) {
        return (FloatBuffer) i(fArr.length).put(fArr).flip();
    }

    public static EGLContext k(EGLContext eGLContext, EGLDisplay eGLDisplay, int i3, int[] iArr) throws GlException {
        boolean z2 = true;
        Assertions.a(Arrays.equals(iArr, f41535a) || Arrays.equals(iArr, f41536b));
        if (i3 != 2 && i3 != 3) {
            z2 = false;
        }
        Assertions.a(z2);
        EGLContext eGLContextEglCreateContext = EGL14.eglCreateContext(eGLDisplay, N(eGLDisplay, iArr), eGLContext, new int[]{12440, i3, 12344}, 0);
        if (eGLContextEglCreateContext != null && !eGLContextEglCreateContext.equals(EGL14.EGL_NO_CONTEXT)) {
            e();
            return eGLContextEglCreateContext;
        }
        EGL14.eglTerminate(eGLDisplay);
        throw new GlException("eglCreateContext() failed to create a valid context. The device may not support EGL version " + i3);
    }

    public static EGLContext l(EGLDisplay eGLDisplay) {
        return k(EGL14.EGL_NO_CONTEXT, eGLDisplay, 2, f41535a);
    }

    public static EGLSurface m(EGLDisplay eGLDisplay, Object obj, int i3, boolean z2) throws GlException {
        int[] iArr;
        int[] iArr2;
        if (i3 == 3 || i3 == 10) {
            iArr = f41535a;
            iArr2 = f41539e;
        } else {
            if (i3 != 7 && i3 != 6) {
                throw new IllegalArgumentException("Unsupported color transfer: " + i3);
            }
            iArr = f41536b;
            if (z2) {
                iArr2 = f41539e;
            } else if (i3 == 6) {
                if (!Q()) {
                    throw new GlException("BT.2020 PQ OpenGL output isn't supported.");
                }
                iArr2 = f41537c;
            } else {
                if (!P()) {
                    throw new GlException("BT.2020 HLG OpenGL output isn't supported.");
                }
                iArr2 = f41538d;
            }
        }
        EGLSurface eGLSurfaceEglCreateWindowSurface = EGL14.eglCreateWindowSurface(eGLDisplay, N(eGLDisplay, iArr), obj, iArr2, 0);
        d("Error creating a new EGL surface");
        return eGLSurfaceEglCreateWindowSurface;
    }

    public static int n() throws GlException {
        int iJ = J();
        b(36197, iJ, 9729);
        return iJ;
    }

    public static int o(int i3) throws GlException {
        int[] iArr = new int[1];
        GLES20.glGenFramebuffers(1, iArr, 0);
        e();
        GLES20.glBindFramebuffer(36160, iArr[0]);
        e();
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, i3, 0);
        e();
        return iArr[0];
    }

    public static EGLSurface p(EGLContext eGLContext, EGLDisplay eGLDisplay) throws GlException {
        EGLSurface eGLSurfaceR = T() ? EGL14.EGL_NO_SURFACE : r(eGLDisplay, 1, 1, f41535a);
        G(eGLDisplay, eGLContext, eGLSurfaceR, 1, 1);
        return eGLSurfaceR;
    }

    public static long q() throws GlException {
        if (K() < 3) {
            return 0L;
        }
        long jGlFenceSync = GLES30.glFenceSync(37143, 0);
        e();
        GLES20.glFlush();
        e();
        return jGlFenceSync;
    }

    private static EGLSurface r(EGLDisplay eGLDisplay, int i3, int i4, int[] iArr) throws GlException {
        EGLSurface eGLSurfaceEglCreatePbufferSurface = EGL14.eglCreatePbufferSurface(eGLDisplay, N(eGLDisplay, iArr), new int[]{12375, i3, 12374, i4, 12344}, 0);
        d("Error creating a new EGL Pbuffer surface");
        return eGLSurfaceEglCreatePbufferSurface;
    }

    public static int s(int i3) throws GlException {
        int[] iArr = new int[1];
        GLES20.glGenBuffers(1, iArr, 0);
        e();
        GLES20.glBindBuffer(35051, iArr[0]);
        e();
        GLES20.glBufferData(35051, i3, null, 35049);
        e();
        GLES20.glBindBuffer(35051, 0);
        e();
        return iArr[0];
    }

    public static int t(int i3, int i4) {
        return w(i3, i4, 32857, 33640);
    }

    public static int u(int i3, int i4, boolean z2) {
        return z2 ? w(i3, i4, 34842, 5131) : w(i3, i4, 6408, 5121);
    }

    public static int v(Bitmap bitmap) throws GlException {
        int iJ = J();
        X(iJ, bitmap);
        return iJ;
    }

    private static int w(int i3, int i4, int i5, int i6) throws GlException {
        a(i3, i4);
        int iJ = J();
        b(3553, iJ, 9729);
        GLES20.glTexImage2D(3553, 0, i5, i3, i4, 0, 6408, i6, null);
        e();
        return iJ;
    }

    public static float[] x(List list) {
        float[] fArr = new float[list.size() * 4];
        for (int i3 = 0; i3 < list.size(); i3++) {
            System.arraycopy(list.get(i3), 0, fArr, i3 * 4, 4);
        }
        return fArr;
    }

    public static void y(int i3) throws GlException {
        GLES20.glDeleteBuffers(1, new int[]{i3}, 0);
        e();
    }

    public static void z(int i3) throws GlException {
        GLES20.glDeleteFramebuffers(1, new int[]{i3}, 0);
        e();
    }
}
