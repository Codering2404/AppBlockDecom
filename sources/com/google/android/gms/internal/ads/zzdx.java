package com.google.android.gms.internal.ads;

import android.content.Context;
import android.opengl.EGL14;
import android.opengl.EGLDisplay;
import android.os.Build;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzdx {
    public static boolean zza(Context context) throws zzdw {
        return zzf("EGL_EXT_protected_content");
    }

    public static boolean zzb() throws zzdw {
        return zzf("EGL_KHR_surfaceless_context");
    }

    public static boolean zzc(int i3) throws zzdw {
        if (i3 == 6) {
            return zzd();
        }
        if (i3 == 7) {
            return zzf("EGL_EXT_gl_colorspace_bt2020_hlg");
        }
        return true;
    }

    public static boolean zzd() throws zzdw {
        return Build.VERSION.SDK_INT >= 33 && zzf("EGL_EXT_gl_colorspace_bt2020_pq");
    }

    public static void zze(boolean z2, String str) throws zzdw {
        if (!z2) {
            throw new zzdw(str, zzgwm.zzi());
        }
    }

    private static boolean zzf(String str) throws zzdw {
        EGLDisplay eGLDisplayEglGetDisplay = EGL14.eglGetDisplay(0);
        zze(!eGLDisplayEglGetDisplay.equals(EGL14.EGL_NO_DISPLAY), "No EGL display.");
        zze(EGL14.eglInitialize(eGLDisplayEglGetDisplay, new int[1], 0, new int[1], 0), "Error in eglInitialize.");
        int iEglGetError = EGL14.eglGetError();
        if (iEglGetError == 12288) {
            String strEglQueryString = EGL14.eglQueryString(eGLDisplayEglGetDisplay, 12373);
            return strEglQueryString != null && strEglQueryString.contains(str);
        }
        throw new zzdw("Error in getDefaultEglDisplay, error code: 0x".concat(String.valueOf(Integer.toHexString(iEglGetError))), zzgwm.zzj(Integer.valueOf(iEglGetError)));
    }
}
