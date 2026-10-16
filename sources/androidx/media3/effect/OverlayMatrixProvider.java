package androidx.media3.effect;

import android.opengl.Matrix;
import android.util.Pair;
import androidx.media3.common.OverlaySettings;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.GlUtil;
import androidx.media3.common.util.Size;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
class OverlayMatrixProvider {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Size f42513j;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float[] f42505b = GlUtil.h();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float[] f42504a = GlUtil.h();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final float[] f42508e = GlUtil.h();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final float[] f42509f = GlUtil.h();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float[] f42506c = GlUtil.h();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float[] f42507d = GlUtil.h();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final float[] f42510g = GlUtil.h();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final float[] f42511h = GlUtil.h();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final float[] f42512i = GlUtil.h();

    private void c() {
        GlUtil.Y(this.f42505b);
        GlUtil.Y(this.f42504a);
        GlUtil.Y(this.f42508e);
        GlUtil.Y(this.f42506c);
        GlUtil.Y(this.f42507d);
        GlUtil.Y(this.f42509f);
        GlUtil.Y(this.f42510g);
        GlUtil.Y(this.f42511h);
        GlUtil.Y(this.f42512i);
    }

    public void a(Size size) {
        this.f42513j = size;
    }

    public float[] b(Size size, OverlaySettings overlaySettings) {
        c();
        Pair pairC = overlaySettings.c();
        Matrix.translateM(this.f42504a, 0, ((Float) pairC.first).floatValue(), ((Float) pairC.second).floatValue(), 0.0f);
        Assertions.i(this.f42513j);
        Matrix.scaleM(this.f42505b, 0, size.b() / this.f42513j.b(), size.a() / this.f42513j.a(), 1.0f);
        Pair scale = overlaySettings.getScale();
        Matrix.scaleM(this.f42506c, 0, ((Float) scale.first).floatValue(), ((Float) scale.second).floatValue(), 1.0f);
        Matrix.invertM(this.f42507d, 0, this.f42506c, 0);
        Pair pairE = overlaySettings.e();
        Matrix.translateM(this.f42508e, 0, ((Float) pairE.first).floatValue() * (-1.0f), ((Float) pairE.second).floatValue() * (-1.0f), 0.0f);
        Matrix.rotateM(this.f42509f, 0, overlaySettings.d(), 0.0f, 0.0f, 1.0f);
        Matrix.scaleM(this.f42510g, 0, size.a() / size.b(), 1.0f, 1.0f);
        Matrix.invertM(this.f42511h, 0, this.f42510g, 0);
        float[] fArr = this.f42512i;
        Matrix.multiplyMM(fArr, 0, fArr, 0, this.f42504a, 0);
        float[] fArr2 = this.f42512i;
        Matrix.multiplyMM(fArr2, 0, fArr2, 0, this.f42505b, 0);
        float[] fArr3 = this.f42512i;
        Matrix.multiplyMM(fArr3, 0, fArr3, 0, this.f42506c, 0);
        float[] fArr4 = this.f42512i;
        Matrix.multiplyMM(fArr4, 0, fArr4, 0, this.f42508e, 0);
        float[] fArr5 = this.f42512i;
        Matrix.multiplyMM(fArr5, 0, fArr5, 0, this.f42507d, 0);
        float[] fArr6 = this.f42512i;
        Matrix.multiplyMM(fArr6, 0, fArr6, 0, this.f42510g, 0);
        float[] fArr7 = this.f42512i;
        Matrix.multiplyMM(fArr7, 0, fArr7, 0, this.f42509f, 0);
        float[] fArr8 = this.f42512i;
        Matrix.multiplyMM(fArr8, 0, fArr8, 0, this.f42511h, 0);
        float[] fArr9 = this.f42512i;
        Matrix.multiplyMM(fArr9, 0, fArr9, 0, this.f42506c, 0);
        return this.f42512i;
    }
}
