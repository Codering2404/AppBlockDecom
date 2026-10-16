package androidx.media3.effect;

import android.graphics.Matrix;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Size;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class Crop implements MatrixTransformation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f42238a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f42239b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f42240c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f42241d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Matrix f42242e;

    @Override // androidx.media3.effect.GlMatrixTransformation
    public Size c(int i3, int i4) {
        Assertions.b(i3 > 0, "inputWidth must be positive");
        Assertions.b(i4 > 0, "inputHeight must be positive");
        Matrix matrix = new Matrix();
        this.f42242e = matrix;
        float f3 = this.f42238a;
        if (f3 == -1.0f && this.f42239b == 1.0f && this.f42240c == -1.0f && this.f42241d == 1.0f) {
            return new Size(i3, i4);
        }
        float f4 = this.f42239b;
        float f5 = (f4 - f3) / 2.0f;
        float f6 = this.f42241d;
        float f7 = this.f42240c;
        float f8 = (f6 - f7) / 2.0f;
        matrix.postTranslate(-((f3 + f4) / 2.0f), -((f7 + f6) / 2.0f));
        this.f42242e.postScale(1.0f / f5, 1.0f / f8);
        return new Size(Math.round(i3 * f5), Math.round(i4 * f8));
    }

    @Override // androidx.media3.effect.GlEffect
    public boolean i(int i3, int i4) {
        Size sizeC = c(i3, i4);
        return ((Matrix) Assertions.i(this.f42242e)).isIdentity() && i3 == sizeC.b() && i4 == sizeC.a();
    }

    @Override // androidx.media3.effect.MatrixTransformation
    public Matrix j(long j3) {
        return (Matrix) Assertions.j(this.f42242e, "configure must be called first");
    }
}
