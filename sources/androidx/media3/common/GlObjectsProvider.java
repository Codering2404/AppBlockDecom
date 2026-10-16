package androidx.media3.common;

import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public interface GlObjectsProvider {
    EGLSurface a(EGLDisplay eGLDisplay, Object obj, int i3, boolean z2);

    GlTextureInfo b(int i3, int i4, int i5);

    EGLSurface c(EGLContext eGLContext, EGLDisplay eGLDisplay);

    EGLContext d(EGLDisplay eGLDisplay, int i3, int[] iArr);

    void e(EGLDisplay eGLDisplay);
}
