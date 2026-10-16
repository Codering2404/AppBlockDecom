package androidx.media3.exoplayer.video.spherical;

import android.opengl.Matrix;
import androidx.media3.common.util.GlUtil;
import androidx.media3.common.util.TimedValueQueue;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class FrameRotationQueue {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float[] f45916a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float[] f45917b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final TimedValueQueue f45918c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f45919d;

    public static void a(float[] fArr, float[] fArr2) {
        GlUtil.Y(fArr);
        float f3 = fArr2[10];
        float f4 = fArr2[8];
        float fSqrt = (float) Math.sqrt((f3 * f3) + (f4 * f4));
        float f5 = fArr2[10];
        fArr[0] = f5 / fSqrt;
        float f6 = fArr2[8];
        fArr[2] = f6 / fSqrt;
        fArr[8] = (-f6) / fSqrt;
        fArr[10] = f5 / fSqrt;
    }

    private static void b(float[] fArr, float[] fArr2) {
        float f3 = fArr2[0];
        float f4 = -fArr2[1];
        float f5 = -fArr2[2];
        float length = Matrix.length(f3, f4, f5);
        if (length != 0.0f) {
            Matrix.setRotateM(fArr, 0, (float) Math.toDegrees(length), f3 / length, f4 / length, f5 / length);
        } else {
            GlUtil.Y(fArr);
        }
    }

    public boolean c(float[] fArr, long j3) {
        float[] fArr2 = (float[]) this.f45918c.j(j3);
        if (fArr2 == null) {
            return false;
        }
        b(this.f45917b, fArr2);
        if (!this.f45919d) {
            a(this.f45916a, this.f45917b);
            this.f45919d = true;
        }
        Matrix.multiplyMM(fArr, 0, this.f45916a, 0, this.f45917b, 0);
        return true;
    }

    public void d() {
        this.f45918c.c();
        this.f45919d = false;
    }

    public void e(long j3, float[] fArr) {
        this.f45918c.a(j3, fArr);
    }
}
