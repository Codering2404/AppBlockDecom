package androidx.media3.effect;

import android.graphics.Matrix;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Size;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class Presentation implements MatrixTransformation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f42527a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f42528b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f42529c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f42530d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f42531e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f42532f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f42533g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Matrix f42534h;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Layout {
    }

    private Presentation(int i3, int i4, float f3, int i5, int i6) {
        Assertions.b(f3 == -1.0f || i3 == -1, "width and aspect ratio should not both be set");
        this.f42527a = i3;
        this.f42528b = i4;
        this.f42529c = f3;
        this.f42530d = i5;
        this.f42531e = i6;
        this.f42532f = -1.0f;
        this.f42533g = -1.0f;
        this.f42534h = new Matrix();
    }

    private void k() {
        float f3 = this.f42532f;
        float f4 = this.f42533g;
        float f5 = f3 / f4;
        int i3 = this.f42530d;
        if (i3 == 0) {
            float f6 = this.f42529c;
            if (f6 > f5) {
                this.f42534h.setScale(f5 / f6, 1.0f);
                this.f42532f = this.f42533g * this.f42529c;
                return;
            } else {
                this.f42534h.setScale(1.0f, f6 / f5);
                this.f42533g = this.f42532f / this.f42529c;
                return;
            }
        }
        if (i3 == 1) {
            float f7 = this.f42529c;
            if (f7 > f5) {
                this.f42534h.setScale(1.0f, f7 / f5);
                this.f42533g = this.f42532f / this.f42529c;
                return;
            } else {
                this.f42534h.setScale(f5 / f7, 1.0f);
                this.f42532f = this.f42533g * this.f42529c;
                return;
            }
        }
        if (i3 == 2) {
            float f8 = this.f42529c;
            if (f8 > f5) {
                this.f42532f = f4 * f8;
            } else {
                this.f42533g = f3 / f8;
            }
        }
    }

    private static void l(int i3) {
        boolean z2 = true;
        if (i3 != 0 && i3 != 1 && i3 != 2) {
            z2 = false;
        }
        Assertions.b(z2, "invalid layout " + i3);
    }

    public static Presentation m(int i3, int i4, int i5) {
        Assertions.b(i3 > 0, "width " + i3 + " must be positive");
        Assertions.b(i4 > 0, "height " + i4 + " must be positive");
        l(i5);
        return new Presentation(i3, i4, -1.0f, i5, 9729);
    }

    @Override // androidx.media3.effect.GlMatrixTransformation
    public Size c(int i3, int i4) {
        int i5;
        Assertions.b(i3 > 0, "inputWidth must be positive");
        Assertions.b(i4 > 0, "inputHeight must be positive");
        this.f42534h = new Matrix();
        this.f42532f = i3;
        this.f42533g = i4;
        int i6 = this.f42527a;
        if (i6 != -1 && (i5 = this.f42528b) != -1) {
            this.f42529c = i6 / i5;
        }
        if (this.f42529c != -1.0f) {
            k();
        }
        int i7 = this.f42528b;
        if (i7 != -1) {
            int i8 = this.f42527a;
            if (i8 != -1) {
                this.f42532f = i8;
            } else {
                this.f42532f = (i7 * this.f42532f) / this.f42533g;
            }
            this.f42533g = i7;
        }
        return new Size(Math.round(this.f42532f), Math.round(this.f42533g));
    }

    @Override // androidx.media3.effect.GlMatrixTransformation
    public int d() {
        return this.f42531e;
    }

    @Override // androidx.media3.effect.GlEffect
    public boolean i(int i3, int i4) {
        c(i3, i4);
        return ((Matrix) Assertions.i(this.f42534h)).isIdentity() && i3 == Math.round(this.f42532f) && i4 == Math.round(this.f42533g);
    }

    @Override // androidx.media3.effect.MatrixTransformation
    public Matrix j(long j3) {
        return (Matrix) Assertions.j(this.f42534h, "configure must be called first");
    }
}
