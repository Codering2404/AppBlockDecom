package androidx.media3.effect;

import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import androidx.media3.common.GlObjectsProvider;
import androidx.media3.common.GlTextureInfo;
import androidx.media3.common.util.GlUtil;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class DefaultGlObjectsProvider implements GlObjectsProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final EGLContext f42283a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f42284b;

    public DefaultGlObjectsProvider() {
        this(null);
    }

    @Override // androidx.media3.common.GlObjectsProvider
    public EGLSurface a(EGLDisplay eGLDisplay, Object obj, int i3, boolean z2) {
        return GlUtil.m(eGLDisplay, obj, i3, z2);
    }

    @Override // androidx.media3.common.GlObjectsProvider
    public GlTextureInfo b(int i3, int i4, int i5) {
        return new GlTextureInfo(i3, GlUtil.o(i3), -1, i4, i5);
    }

    @Override // androidx.media3.common.GlObjectsProvider
    public EGLSurface c(EGLContext eGLContext, EGLDisplay eGLDisplay) {
        return GlUtil.p(eGLContext, eGLDisplay);
    }

    @Override // androidx.media3.common.GlObjectsProvider
    public EGLContext d(EGLDisplay eGLDisplay, int i3, int[] iArr) throws GlUtil.GlException {
        EGLContext eGLContextK = GlUtil.k(this.f42283a, eGLDisplay, i3, iArr);
        this.f42284b.add(eGLContextK);
        return eGLContextK;
    }

    @Override // androidx.media3.common.GlObjectsProvider
    public void e(EGLDisplay eGLDisplay) throws GlUtil.GlException {
        for (int i3 = 0; i3 < this.f42284b.size(); i3++) {
            GlUtil.E(eGLDisplay, (EGLContext) this.f42284b.get(i3));
        }
    }

    public DefaultGlObjectsProvider(EGLContext eGLContext) {
        this.f42283a = eGLContext == null ? EGL14.EGL_NO_CONTEXT : eGLContext;
        this.f42284b = new ArrayList();
    }
}
