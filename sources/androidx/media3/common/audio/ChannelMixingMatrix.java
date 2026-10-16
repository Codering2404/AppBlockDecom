package androidx.media3.common.audio;

import androidx.media3.common.util.Assertions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class ChannelMixingMatrix {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f41300a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f41301b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float[] f41302c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f41303d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f41304e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f41305f;

    public ChannelMixingMatrix(int i3, int i4, float[] fArr) {
        boolean z2 = false;
        Assertions.b(i3 > 0, "Input channel count must be positive.");
        Assertions.b(i4 > 0, "Output channel count must be positive.");
        Assertions.b(fArr.length == i3 * i4, "Coefficient array length is invalid.");
        this.f41300a = i3;
        this.f41301b = i4;
        this.f41302c = a(fArr);
        int i5 = 0;
        boolean z3 = true;
        boolean z4 = true;
        boolean z5 = true;
        while (i5 < i3) {
            int i6 = 0;
            while (i6 < i4) {
                float fE = e(i5, i6);
                boolean z6 = i5 == i6;
                if (fE != 1.0f && z6) {
                    z5 = false;
                }
                if (fE != 0.0f) {
                    z3 = false;
                    if (!z6) {
                        z4 = false;
                    }
                }
                i6++;
            }
            i5++;
        }
        this.f41303d = z3;
        boolean z7 = i() && z4;
        this.f41304e = z7;
        if (z7 && z5) {
            z2 = true;
        }
        this.f41305f = z2;
    }

    private static float[] a(float[] fArr) {
        for (int i3 = 0; i3 < fArr.length; i3++) {
            if (fArr[i3] < 0.0f) {
                throw new IllegalArgumentException("Coefficient at index " + i3 + " is negative.");
            }
        }
        return fArr;
    }

    public static ChannelMixingMatrix b(int i3, int i4) {
        return new ChannelMixingMatrix(i3, i4, c(i3, i4));
    }

    private static float[] c(int i3, int i4) {
        if (i3 == i4) {
            return g(i4);
        }
        if (i3 == 1 && i4 == 2) {
            return new float[]{1.0f, 1.0f};
        }
        if (i3 == 2 && i4 == 1) {
            return new float[]{0.5f, 0.5f};
        }
        throw new UnsupportedOperationException("Default channel mixing coefficients for " + i3 + "->" + i4 + " are not yet implemented.");
    }

    private static float[] g(int i3) {
        float[] fArr = new float[i3 * i3];
        for (int i4 = 0; i4 < i3; i4++) {
            fArr[(i3 * i4) + i4] = 1.0f;
        }
        return fArr;
    }

    public int d() {
        return this.f41300a;
    }

    public float e(int i3, int i4) {
        return this.f41302c[(i3 * this.f41301b) + i4];
    }

    public int f() {
        return this.f41301b;
    }

    public boolean h() {
        return this.f41305f;
    }

    public boolean i() {
        return this.f41300a == this.f41301b;
    }

    public boolean j() {
        return this.f41303d;
    }
}
