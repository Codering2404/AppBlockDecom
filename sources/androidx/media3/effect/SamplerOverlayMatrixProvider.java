package androidx.media3.effect;

import android.opengl.Matrix;
import androidx.media3.common.OverlaySettings;
import androidx.media3.common.util.GlUtil;
import androidx.media3.common.util.Size;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class SamplerOverlayMatrixProvider extends OverlayMatrixProvider {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final float[] f42557k = GlUtil.h();

    @Override // androidx.media3.effect.OverlayMatrixProvider
    public float[] b(Size size, OverlaySettings overlaySettings) {
        Matrix.invertM(this.f42557k, 0, super.b(size, overlaySettings), 0);
        return this.f42557k;
    }
}
