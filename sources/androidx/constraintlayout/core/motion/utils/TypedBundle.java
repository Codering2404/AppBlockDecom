package androidx.constraintlayout.core.motion.utils;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class TypedBundle {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int[] f31881a = new int[10];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int[] f31882b = new int[10];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f31883c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int[] f31884d = new int[10];

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    float[] f31885e = new float[10];

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f31886f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int[] f31887g = new int[5];

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    String[] f31888h = new String[5];

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    int f31889i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    int[] f31890j = new int[4];

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    boolean[] f31891k = new boolean[4];

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    int f31892l = 0;

    public void a(int i3, float f3) {
        int i4 = this.f31886f;
        int[] iArr = this.f31884d;
        if (i4 >= iArr.length) {
            this.f31884d = Arrays.copyOf(iArr, iArr.length * 2);
            float[] fArr = this.f31885e;
            this.f31885e = Arrays.copyOf(fArr, fArr.length * 2);
        }
        int[] iArr2 = this.f31884d;
        int i5 = this.f31886f;
        iArr2[i5] = i3;
        float[] fArr2 = this.f31885e;
        this.f31886f = i5 + 1;
        fArr2[i5] = f3;
    }

    public void b(int i3, int i4) {
        int i5 = this.f31883c;
        int[] iArr = this.f31881a;
        if (i5 >= iArr.length) {
            this.f31881a = Arrays.copyOf(iArr, iArr.length * 2);
            int[] iArr2 = this.f31882b;
            this.f31882b = Arrays.copyOf(iArr2, iArr2.length * 2);
        }
        int[] iArr3 = this.f31881a;
        int i6 = this.f31883c;
        iArr3[i6] = i3;
        int[] iArr4 = this.f31882b;
        this.f31883c = i6 + 1;
        iArr4[i6] = i4;
    }

    public void c(int i3, String str) {
        int i4 = this.f31889i;
        int[] iArr = this.f31887g;
        if (i4 >= iArr.length) {
            this.f31887g = Arrays.copyOf(iArr, iArr.length * 2);
            String[] strArr = this.f31888h;
            this.f31888h = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
        }
        int[] iArr2 = this.f31887g;
        int i5 = this.f31889i;
        iArr2[i5] = i3;
        String[] strArr2 = this.f31888h;
        this.f31889i = i5 + 1;
        strArr2[i5] = str;
    }

    public void d(int i3, boolean z2) {
        int i4 = this.f31892l;
        int[] iArr = this.f31890j;
        if (i4 >= iArr.length) {
            this.f31890j = Arrays.copyOf(iArr, iArr.length * 2);
            boolean[] zArr = this.f31891k;
            this.f31891k = Arrays.copyOf(zArr, zArr.length * 2);
        }
        int[] iArr2 = this.f31890j;
        int i5 = this.f31892l;
        iArr2[i5] = i3;
        boolean[] zArr2 = this.f31891k;
        this.f31892l = i5 + 1;
        zArr2[i5] = z2;
    }

    public void e(int i3, String str) {
        if (str != null) {
            c(i3, str);
        }
    }

    public void f(TypedBundle typedBundle) {
        for (int i3 = 0; i3 < this.f31883c; i3++) {
            typedBundle.b(this.f31881a[i3], this.f31882b[i3]);
        }
        for (int i4 = 0; i4 < this.f31886f; i4++) {
            typedBundle.a(this.f31884d[i4], this.f31885e[i4]);
        }
        for (int i5 = 0; i5 < this.f31889i; i5++) {
            typedBundle.c(this.f31887g[i5], this.f31888h[i5]);
        }
        for (int i6 = 0; i6 < this.f31892l; i6++) {
            typedBundle.d(this.f31890j[i6], this.f31891k[i6]);
        }
    }

    public void g(TypedValues typedValues) {
        for (int i3 = 0; i3 < this.f31883c; i3++) {
            typedValues.b(this.f31881a[i3], this.f31882b[i3]);
        }
        for (int i4 = 0; i4 < this.f31886f; i4++) {
            typedValues.c(this.f31884d[i4], this.f31885e[i4]);
        }
        for (int i5 = 0; i5 < this.f31889i; i5++) {
            typedValues.e(this.f31887g[i5], this.f31888h[i5]);
        }
        for (int i6 = 0; i6 < this.f31892l; i6++) {
            typedValues.d(this.f31890j[i6], this.f31891k[i6]);
        }
    }

    public void h() {
        this.f31892l = 0;
        this.f31889i = 0;
        this.f31886f = 0;
        this.f31883c = 0;
    }

    public String toString() {
        return "TypedBundle{mCountInt=" + this.f31883c + ", mCountFloat=" + this.f31886f + ", mCountString=" + this.f31889i + ", mCountBoolean=" + this.f31892l + '}';
    }
}
