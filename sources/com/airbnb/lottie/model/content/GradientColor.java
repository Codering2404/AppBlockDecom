package com.airbnb.lottie.model.content;

import com.airbnb.lottie.utils.GammaEvaluator;
import com.airbnb.lottie.utils.MiscUtils;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class GradientColor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float[] f56741a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int[] f56742b;

    public GradientColor(float[] fArr, int[] iArr) {
        this.f56741a = fArr;
        this.f56742b = iArr;
    }

    private int b(float f3) {
        int iBinarySearch = Arrays.binarySearch(this.f56741a, f3);
        if (iBinarySearch >= 0) {
            return this.f56742b[iBinarySearch];
        }
        int i3 = -(iBinarySearch + 1);
        if (i3 == 0) {
            return this.f56742b[0];
        }
        int[] iArr = this.f56742b;
        if (i3 == iArr.length - 1) {
            return iArr[iArr.length - 1];
        }
        float[] fArr = this.f56741a;
        int i4 = i3 - 1;
        float f4 = fArr[i4];
        return GammaEvaluator.c((f3 - f4) / (fArr[i3] - f4), iArr[i4], iArr[i3]);
    }

    public GradientColor a(float[] fArr) {
        int[] iArr = new int[fArr.length];
        for (int i3 = 0; i3 < fArr.length; i3++) {
            iArr[i3] = b(fArr[i3]);
        }
        return new GradientColor(fArr, iArr);
    }

    public int[] c() {
        return this.f56742b;
    }

    public float[] d() {
        return this.f56741a;
    }

    public int e() {
        return this.f56742b.length;
    }

    public void f(GradientColor gradientColor, GradientColor gradientColor2, float f3) {
        if (gradientColor.f56742b.length == gradientColor2.f56742b.length) {
            for (int i3 = 0; i3 < gradientColor.f56742b.length; i3++) {
                this.f56741a[i3] = MiscUtils.i(gradientColor.f56741a[i3], gradientColor2.f56741a[i3], f3);
                this.f56742b[i3] = GammaEvaluator.c(f3, gradientColor.f56742b[i3], gradientColor2.f56742b[i3]);
            }
            return;
        }
        throw new IllegalArgumentException("Cannot interpolate between gradients. Lengths vary (" + gradientColor.f56742b.length + " vs " + gradientColor2.f56742b.length + ")");
    }
}
