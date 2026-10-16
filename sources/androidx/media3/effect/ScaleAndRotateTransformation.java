package androidx.media3.effect;

import android.graphics.Matrix;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Size;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class ScaleAndRotateTransformation implements MatrixTransformation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f42558a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f42559b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f42560c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Matrix f42561d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Matrix f42562e;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private float f42563a = 1.0f;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private float f42564b = 1.0f;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private float f42565c = 0.0f;

        public ScaleAndRotateTransformation a() {
            return new ScaleAndRotateTransformation(this.f42563a, this.f42564b, this.f42565c);
        }

        public Builder b(float f3) {
            float f4 = f3 % 360.0f;
            this.f42565c = f4;
            if (f4 < 0.0f) {
                this.f42565c = f4 + 360.0f;
            }
            return this;
        }
    }

    @Override // androidx.media3.effect.GlMatrixTransformation
    public Size c(int i3, int i4) {
        Assertions.b(i3 > 0, "inputWidth must be positive");
        Assertions.b(i4 > 0, "inputHeight must be positive");
        this.f42562e = new Matrix(this.f42561d);
        if (this.f42561d.isIdentity()) {
            return new Size(i3, i4);
        }
        float f3 = i3;
        float f4 = i4;
        float f5 = f3 / f4;
        this.f42562e.preScale(f5, 1.0f);
        this.f42562e.postScale(1.0f / f5, 1.0f);
        float[][] fArr = {new float[]{-1.0f, -1.0f, 0.0f, 1.0f}, new float[]{-1.0f, 1.0f, 0.0f, 1.0f}, new float[]{1.0f, -1.0f, 0.0f, 1.0f}, new float[]{1.0f, 1.0f, 0.0f, 1.0f}};
        float fMax = Float.MIN_VALUE;
        float fMin = Float.MAX_VALUE;
        float fMin2 = Float.MAX_VALUE;
        float fMax2 = Float.MIN_VALUE;
        for (int i5 = 0; i5 < 4; i5++) {
            float[] fArr2 = fArr[i5];
            this.f42562e.mapPoints(fArr2);
            fMin = Math.min(fMin, fArr2[0]);
            fMax = Math.max(fMax, fArr2[0]);
            fMin2 = Math.min(fMin2, fArr2[1]);
            fMax2 = Math.max(fMax2, fArr2[1]);
        }
        float f6 = (fMax - fMin) / 2.0f;
        float f7 = (fMax2 - fMin2) / 2.0f;
        this.f42562e.postScale(1.0f / f6, 1.0f / f7);
        return new Size(Math.round(f3 * f6), Math.round(f4 * f7));
    }

    @Override // androidx.media3.effect.GlEffect
    public boolean i(int i3, int i4) {
        Size sizeC = c(i3, i4);
        return ((Matrix) Assertions.i(this.f42562e)).isIdentity() && i3 == sizeC.b() && i4 == sizeC.a();
    }

    @Override // androidx.media3.effect.MatrixTransformation
    public Matrix j(long j3) {
        return (Matrix) Assertions.j(this.f42562e, "configure must be called first");
    }

    private ScaleAndRotateTransformation(float f3, float f4, float f5) {
        this.f42558a = f3;
        this.f42559b = f4;
        this.f42560c = f5;
        Matrix matrix = new Matrix();
        this.f42561d = matrix;
        matrix.postScale(f3, f4);
        matrix.postRotate(f5);
    }
}
