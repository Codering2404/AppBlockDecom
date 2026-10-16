package com.applovin.impl;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.os.Handler;
import com.revenuecat.purchases.ui.revenuecatui.templates.VWmQ.cJfnYMIyomoWf;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class m7 implements SurfaceTexture.OnFrameAvailableListener, Runnable {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int[] f61383h = {12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12327, 12344, 12339, 4, 12344};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Handler f61384a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int[] f61385b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private EGLDisplay f61386c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private EGLContext f61387d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private EGLSurface f61388f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private SurfaceTexture f61389g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class b extends RuntimeException {
        private b(String str) {
            super(str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface c {
    }

    public m7(Handler handler) {
        this(handler, null);
    }

    private void a() {
    }

    private static EGLDisplay b() {
        EGLDisplay eGLDisplayEglGetDisplay = EGL14.eglGetDisplay(0);
        if (eGLDisplayEglGetDisplay == null) {
            throw new b("eglGetDisplay failed");
        }
        int[] iArr = new int[2];
        if (EGL14.eglInitialize(eGLDisplayEglGetDisplay, iArr, 0, iArr, 1)) {
            return eGLDisplayEglGetDisplay;
        }
        throw new b("eglInitialize failed");
    }

    public SurfaceTexture c() {
        return (SurfaceTexture) b1.a(this.f61389g);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void d() {
        this.f61384a.removeCallbacks(this);
        try {
            SurfaceTexture surfaceTexture = this.f61389g;
            if (surfaceTexture != null) {
                surfaceTexture.release();
                GLES20.glDeleteTextures(1, this.f61385b, 0);
            }
        } finally {
            EGLDisplay eGLDisplay = this.f61386c;
            if (eGLDisplay != null && !eGLDisplay.equals(EGL14.EGL_NO_DISPLAY)) {
                EGLDisplay eGLDisplay2 = this.f61386c;
                EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
                EGL14.eglMakeCurrent(eGLDisplay2, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
            }
            EGLSurface eGLSurface2 = this.f61388f;
            if (eGLSurface2 != null && !eGLSurface2.equals(EGL14.EGL_NO_SURFACE)) {
                EGL14.eglDestroySurface(this.f61386c, this.f61388f);
            }
            EGLContext eGLContext = this.f61387d;
            if (eGLContext != null) {
                EGL14.eglDestroyContext(this.f61386c, eGLContext);
            }
            if (xp.f65027a >= 19) {
                EGL14.eglReleaseThread();
            }
            EGLDisplay eGLDisplay3 = this.f61386c;
            if (eGLDisplay3 != null && !eGLDisplay3.equals(EGL14.EGL_NO_DISPLAY)) {
                EGL14.eglTerminate(this.f61386c);
            }
            this.f61386c = null;
            this.f61387d = null;
            this.f61388f = null;
            this.f61389g = null;
        }
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.f61384a.post(this);
    }

    @Override // java.lang.Runnable
    public void run() {
        a();
        SurfaceTexture surfaceTexture = this.f61389g;
        if (surfaceTexture != null) {
            try {
                surfaceTexture.updateTexImage();
            } catch (RuntimeException unused) {
            }
        }
    }

    public m7(Handler handler, c cVar) {
        this.f61384a = handler;
        this.f61385b = new int[1];
    }

    private static EGLConfig a(EGLDisplay eGLDisplay) {
        EGLConfig eGLConfig;
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        int[] iArr = new int[1];
        boolean zEglChooseConfig = EGL14.eglChooseConfig(eGLDisplay, f61383h, 0, eGLConfigArr, 0, 1, iArr, 0);
        if (!zEglChooseConfig || iArr[0] <= 0 || (eGLConfig = eGLConfigArr[0]) == null) {
            throw new b(xp.a("eglChooseConfig failed: success=%b, numConfigs[0]=%d, configs[0]=%s", Boolean.valueOf(zEglChooseConfig), Integer.valueOf(iArr[0]), eGLConfigArr[0]));
        }
        return eGLConfig;
    }

    private static EGLContext a(EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i3) {
        int[] iArr;
        if (i3 == 0) {
            iArr = new int[]{12440, 2, 12344};
        } else {
            iArr = new int[]{12440, 2, 12992, 1, 12344};
        }
        EGLContext eGLContextEglCreateContext = EGL14.eglCreateContext(eGLDisplay, eGLConfig, EGL14.EGL_NO_CONTEXT, iArr, 0);
        if (eGLContextEglCreateContext != null) {
            return eGLContextEglCreateContext;
        }
        throw new b("eglCreateContext failed");
    }

    private static EGLSurface a(EGLDisplay eGLDisplay, EGLConfig eGLConfig, EGLContext eGLContext, int i3) {
        int[] iArr;
        EGLSurface eGLSurfaceEglCreatePbufferSurface;
        if (i3 == 1) {
            eGLSurfaceEglCreatePbufferSurface = EGL14.EGL_NO_SURFACE;
        } else {
            if (i3 == 2) {
                iArr = new int[]{12375, 1, 12374, 1, 12992, 1, 12344};
            } else {
                iArr = new int[]{12375, 1, 12374, 1, 12344};
            }
            eGLSurfaceEglCreatePbufferSurface = EGL14.eglCreatePbufferSurface(eGLDisplay, eGLConfig, iArr, 0);
            if (eGLSurfaceEglCreatePbufferSurface == null) {
                throw new b("eglCreatePbufferSurface failed");
            }
        }
        if (EGL14.eglMakeCurrent(eGLDisplay, eGLSurfaceEglCreatePbufferSurface, eGLSurfaceEglCreatePbufferSurface, eGLContext)) {
            return eGLSurfaceEglCreatePbufferSurface;
        }
        throw new b(cJfnYMIyomoWf.NXVhWGwnVQEsmYF);
    }

    private static void a(int[] iArr) {
        GLES20.glGenTextures(1, iArr, 0);
        aa.a();
    }

    public void a(int i3) {
        EGLDisplay eGLDisplayB = b();
        this.f61386c = eGLDisplayB;
        EGLConfig eGLConfigA = a(eGLDisplayB);
        EGLContext eGLContextA = a(this.f61386c, eGLConfigA, i3);
        this.f61387d = eGLContextA;
        this.f61388f = a(this.f61386c, eGLConfigA, eGLContextA, i3);
        a(this.f61385b);
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.f61385b[0]);
        this.f61389g = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(this);
    }
}
