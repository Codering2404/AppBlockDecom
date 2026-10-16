package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.util.Log;
import com.revenuecat.purchases.common.Constants;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.concurrent.CountDownLatch;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzchl extends Thread implements SurfaceTexture.OnFrameAvailableListener, zzchj {
    private static final float[] zza = {-1.0f, -1.0f, -1.0f, 1.0f, -1.0f, -1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f, -1.0f};
    private volatile boolean zzA;
    private volatile boolean zzB;
    private final zzchk zzb;
    private final float[] zzc;
    private final float[] zzd;
    private final float[] zze;
    private final float[] zzf;
    private final float[] zzg;
    private final float[] zzh;
    private final float[] zzi;
    private float zzj;
    private float zzk;
    private float zzl;
    private int zzm;
    private int zzn;
    private SurfaceTexture zzo;
    private SurfaceTexture zzp;
    private int zzq;
    private int zzr;
    private int zzs;
    private final FloatBuffer zzt;
    private final CountDownLatch zzu;
    private final Object zzv;
    private EGL10 zzw;
    private EGLDisplay zzx;
    private EGLContext zzy;
    private EGLSurface zzz;

    public zzchl(Context context) {
        super("SphericalVideoProcessor");
        float[] fArr = zza;
        int length = fArr.length;
        FloatBuffer floatBufferAsFloatBuffer = ByteBuffer.allocateDirect(48).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.zzt = floatBufferAsFloatBuffer;
        floatBufferAsFloatBuffer.put(fArr).position(0);
        this.zzc = new float[9];
        this.zzd = new float[9];
        this.zze = new float[9];
        this.zzf = new float[9];
        this.zzg = new float[9];
        this.zzh = new float[9];
        this.zzi = new float[9];
        this.zzj = Float.NaN;
        zzchk zzchkVar = new zzchk(context);
        this.zzb = zzchkVar;
        zzchkVar.zzc(this);
        this.zzu = new CountDownLatch(1);
        this.zzv = new Object();
    }

    private static final void zzh(String str) {
        int iGlGetError = GLES20.glGetError();
        if (iGlGetError != 0) {
            StringBuilder sb = new StringBuilder(str.length() + 10 + String.valueOf(iGlGetError).length());
            sb.append(str);
            sb.append(": glError ");
            sb.append(iGlGetError);
            Log.e("SphericalVideoRenderer", sb.toString());
        }
    }

    private static final void zzi(float[] fArr, float[] fArr2, float[] fArr3) {
        float f3 = fArr2[0] * fArr3[0];
        float f4 = fArr2[1];
        float f5 = fArr3[3];
        float f6 = fArr2[2];
        float f7 = fArr3[6];
        fArr[0] = f3 + (f4 * f5) + (f6 * f7);
        float f8 = fArr2[0];
        float f9 = fArr3[1] * f8;
        float f10 = fArr3[4];
        float f11 = fArr3[7];
        fArr[1] = f9 + (f4 * f10) + (f6 * f11);
        float f12 = f8 * fArr3[2];
        float f13 = fArr2[1];
        float f14 = fArr3[5];
        float f15 = fArr3[8];
        fArr[2] = f12 + (f13 * f14) + (f6 * f15);
        float f16 = fArr2[3];
        float f17 = fArr3[0];
        float f18 = fArr2[4];
        float f19 = fArr2[5];
        fArr[3] = (f16 * f17) + (f5 * f18) + (f19 * f7);
        float f20 = fArr2[3];
        float f21 = fArr3[1];
        fArr[4] = (f20 * f21) + (f18 * f10) + (f19 * f11);
        float f22 = fArr3[2];
        fArr[5] = (f20 * f22) + (fArr2[4] * f14) + (f19 * f15);
        float f23 = fArr2[6] * f17;
        float f24 = fArr2[7];
        float f25 = fArr3[3] * f24;
        float f26 = fArr2[8];
        fArr[6] = f23 + f25 + (f7 * f26);
        float f27 = fArr2[6];
        fArr[7] = (f21 * f27) + (f24 * fArr3[4]) + (f11 * f26);
        fArr[8] = (f27 * f22) + (fArr2[7] * fArr3[5]) + (f26 * f15);
    }

    private static final void zzj(float[] fArr, float f3) {
        fArr[0] = 1.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        double d3 = f3;
        fArr[4] = (float) Math.cos(d3);
        fArr[5] = (float) (-Math.sin(d3));
        fArr[6] = 0.0f;
        fArr[7] = (float) Math.sin(d3);
        fArr[8] = (float) Math.cos(d3);
    }

    private static final void zzk(float[] fArr, float f3) {
        double d3 = f3;
        fArr[0] = (float) Math.cos(d3);
        fArr[1] = (float) (-Math.sin(d3));
        fArr[2] = 0.0f;
        fArr[3] = (float) Math.sin(d3);
        fArr[4] = (float) Math.cos(d3);
        fArr[5] = 0.0f;
        fArr[6] = 0.0f;
        fArr[7] = 0.0f;
        fArr[8] = 1.0f;
    }

    private static final int zzl(int i3, String str) {
        int iGlCreateShader = GLES20.glCreateShader(i3);
        zzh("createShader");
        if (iGlCreateShader != 0) {
            GLES20.glShaderSource(iGlCreateShader, str);
            zzh("shaderSource");
            GLES20.glCompileShader(iGlCreateShader);
            zzh("compileShader");
            int[] iArr = new int[1];
            GLES20.glGetShaderiv(iGlCreateShader, 35713, iArr, 0);
            zzh("getShaderiv");
            if (iArr[0] == 0) {
                StringBuilder sb = new StringBuilder(String.valueOf(i3).length() + 26);
                sb.append("Could not compile shader ");
                sb.append(i3);
                sb.append(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
                Log.e("SphericalVideoRenderer", sb.toString());
                Log.e("SphericalVideoRenderer", GLES20.glGetShaderInfoLog(iGlCreateShader));
                GLES20.glDeleteShader(iGlCreateShader);
                zzh("deleteShader");
                return 0;
            }
        }
        return iGlCreateShader;
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.zzs++;
        Object obj = this.zzv;
        synchronized (obj) {
            obj.notifyAll();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzchj
    public final void zza() {
        Object obj = this.zzv;
        synchronized (obj) {
            obj.notifyAll();
        }
    }

    public final void zzb(SurfaceTexture surfaceTexture, int i3, int i4) {
        this.zzn = i3;
        this.zzm = i4;
        this.zzp = surfaceTexture;
    }

    public final void zzc(int i3, int i4) {
        Object obj = this.zzv;
        synchronized (obj) {
            this.zzn = i3;
            this.zzm = i4;
            this.zzA = true;
            obj.notifyAll();
        }
    }

    public final void zzd() {
        Object obj = this.zzv;
        synchronized (obj) {
            this.zzB = true;
            this.zzp = null;
            obj.notifyAll();
        }
    }

    public final SurfaceTexture zze() {
        if (this.zzp == null) {
            return null;
        }
        try {
            this.zzu.await();
        } catch (InterruptedException unused) {
        }
        return this.zzo;
    }

    public final void zzf(float f3, float f4) {
        int i3 = this.zzn;
        int i4 = this.zzm;
        if (i3 <= i4) {
            i3 = i4;
        }
        float f5 = i3;
        this.zzk -= (f3 * 1.7453293f) / f5;
        float f6 = this.zzl - ((f4 * 1.7453293f) / f5);
        this.zzl = f6;
        if (f6 < -1.5707964f) {
            this.zzl = -1.5707964f;
            f6 = -1.5707964f;
        }
        if (f6 > 1.5707964f) {
            this.zzl = 1.5707964f;
        }
    }

    final boolean zzg() {
        EGLSurface eGLSurface;
        EGLSurface eGLSurface2 = this.zzz;
        boolean zEglDestroyContext = false;
        if (eGLSurface2 != null && eGLSurface2 != (eGLSurface = EGL10.EGL_NO_SURFACE)) {
            zEglDestroyContext = this.zzw.eglDestroySurface(this.zzx, this.zzz) | this.zzw.eglMakeCurrent(this.zzx, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
            this.zzz = null;
        }
        EGLContext eGLContext = this.zzy;
        if (eGLContext != null) {
            zEglDestroyContext |= this.zzw.eglDestroyContext(this.zzx, eGLContext);
            this.zzy = null;
        }
        EGLDisplay eGLDisplay = this.zzx;
        if (eGLDisplay == null) {
            return zEglDestroyContext;
        }
        boolean zEglTerminate = this.zzw.eglTerminate(eGLDisplay) | zEglDestroyContext;
        this.zzx = null;
        return zEglTerminate;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x001e  */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void run() {
        /*
            Method dump skipped, instruction units count: 948
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzchl.run():void");
    }
}
