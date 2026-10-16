package androidx.media3.effect;

import android.graphics.Matrix;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Size;
import com.google.common.collect.ImmutableList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class MatrixUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final float[][] f42469a = {new float[]{1.0f, 0.0f, 0.0f, 1.0f}, new float[]{-1.0f, 0.0f, 0.0f, 1.0f}, new float[]{0.0f, 1.0f, 0.0f, 1.0f}, new float[]{0.0f, -1.0f, 0.0f, 1.0f}, new float[]{0.0f, 0.0f, 1.0f, 1.0f}, new float[]{0.0f, 0.0f, -1.0f, 1.0f}};

    /* JADX WARN: Multi-variable type inference failed */
    public static ImmutableList a(ImmutableList immutableList) {
        Assertions.b(immutableList.size() >= 3, "A polygon must have at least 3 vertices.");
        ImmutableList.Builder builderK = new ImmutableList.Builder().k(immutableList);
        float[][] fArr = f42469a;
        int length = fArr.length;
        int i3 = 0;
        while (i3 < length) {
            float[] fArr2 = fArr[i3];
            ImmutableList immutableListM = builderK.m();
            ImmutableList.Builder builder = new ImmutableList.Builder();
            for (int i4 = 0; i4 < immutableListM.size(); i4++) {
                float[] fArr3 = (float[]) immutableListM.get(i4);
                float[] fArr4 = (float[]) immutableListM.get(((immutableListM.size() + i4) - 1) % immutableListM.size());
                if (f(fArr3, fArr2)) {
                    if (!f(fArr4, fArr2)) {
                        float[] fArrB = b(fArr2, fArr2, fArr4, fArr3);
                        if (!Arrays.equals(fArr3, fArrB)) {
                            builder.a(fArrB);
                        }
                    }
                    builder.a(fArr3);
                } else if (f(fArr4, fArr2)) {
                    float[] fArrB2 = b(fArr2, fArr2, fArr4, fArr3);
                    if (!Arrays.equals(fArr4, fArrB2)) {
                        builder.a(fArrB2);
                    }
                }
            }
            i3++;
            builderK = builder;
        }
        return builderK.m();
    }

    private static float[] b(float[] fArr, float[] fArr2, float[] fArr3, float[] fArr4) {
        Assertions.b(fArr2.length == 4, "Expecting 4 plane parameters");
        float f3 = fArr[0];
        float f4 = fArr3[0];
        float f5 = fArr2[0];
        float f6 = fArr[1];
        float f7 = fArr3[1];
        float f8 = fArr2[1];
        float f9 = fArr[2];
        float f10 = fArr3[2];
        float f11 = fArr2[2];
        float f12 = ((f3 - f4) * f5) + ((f6 - f7) * f8) + ((f9 - f10) * f11);
        float f13 = fArr4[0];
        float f14 = (f13 - f4) * f5;
        float f15 = fArr4[1];
        float f16 = fArr4[2];
        float f17 = f12 / ((f14 + ((f15 - f7) * f8)) + ((f16 - f10) * f11));
        return new float[]{f4 + ((f13 - f4) * f17), f7 + ((f15 - f7) * f17), f10 + ((f16 - f10) * f17), 1.0f};
    }

    public static Size c(int i3, int i4, List list) {
        Assertions.b(i3 > 0, "inputWidth must be positive");
        Assertions.b(i4 > 0, "inputHeight must be positive");
        Size size = new Size(i3, i4);
        for (int i5 = 0; i5 < list.size(); i5++) {
            size = ((GlMatrixTransformation) list.get(i5)).c(size.b(), size.a());
        }
        return size;
    }

    public static float[] d(Matrix matrix) {
        float[] fArr = new float[9];
        matrix.getValues(fArr);
        float[] fArrE = e(fArr);
        float[] fArr2 = new float[16];
        android.opengl.Matrix.transposeM(fArr2, 0, fArrE, 0);
        return fArr2;
    }

    private static float[] e(float[] fArr) {
        float[] fArr2 = new float[16];
        fArr2[10] = 1.0f;
        int i3 = 0;
        while (i3 < 3) {
            int i4 = 0;
            while (i4 < 3) {
                fArr2[((i3 == 2 ? 3 : i3) * 4) + (i4 == 2 ? 3 : i4)] = fArr[(i3 * 3) + i4];
                i4++;
            }
            i3++;
        }
        return fArr2;
    }

    private static boolean f(float[] fArr, float[] fArr2) {
        Assertions.b(fArr2.length == 4, "Expecting 4 plane parameters");
        return ((fArr2[0] * fArr[0]) + (fArr2[1] * fArr[1])) + (fArr2[2] * fArr[2]) <= fArr2[3];
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static ImmutableList g(float[] fArr, ImmutableList immutableList) {
        ImmutableList.Builder builder = new ImmutableList.Builder();
        int i3 = 0;
        while (i3 < immutableList.size()) {
            float[] fArr2 = new float[4];
            float[] fArr3 = fArr;
            android.opengl.Matrix.multiplyMV(fArr2, 0, fArr3, 0, (float[]) immutableList.get(i3), 0);
            float f3 = fArr2[0];
            float f4 = fArr2[3];
            fArr2[0] = f3 / f4;
            fArr2[1] = fArr2[1] / f4;
            fArr2[2] = fArr2[2] / f4;
            fArr2[3] = 1.0f;
            builder.a(fArr2);
            i3++;
            fArr = fArr3;
        }
        return builder.m();
    }
}
