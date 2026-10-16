package com.applovin.impl;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class ci {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f58908a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f58909b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f58910c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f58911d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final b[] f58912a;

        public a(b... bVarArr) {
            this.f58912a = bVarArr;
        }

        public b a(int i3) {
            return this.f58912a[i3];
        }

        public int a() {
            return this.f58912a.length;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f58913a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f58914b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float[] f58915c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float[] f58916d;

        public b(int i3, float[] fArr, float[] fArr2, int i4) {
            this.f58913a = i3;
            b1.a(((long) fArr.length) * 2 == ((long) fArr2.length) * 3);
            this.f58915c = fArr;
            this.f58916d = fArr2;
            this.f58914b = i4;
        }

        public int a() {
            return this.f58915c.length / 3;
        }
    }

    public ci(a aVar, int i3) {
        this(aVar, aVar, i3);
    }

    public static ci a(float f3, int i3, int i4, float f4, float f5, int i5) {
        int i6;
        int i7 = i3;
        b1.a(f3 > 0.0f);
        b1.a(i7 >= 1);
        b1.a(i4 >= 1);
        b1.a(f4 > 0.0f && f4 <= 180.0f);
        b1.a(f5 > 0.0f && f5 <= 360.0f);
        float radians = (float) Math.toRadians(f4);
        float radians2 = (float) Math.toRadians(f5);
        float f6 = radians / i7;
        float f7 = radians2 / i4;
        int i8 = i4 + 1;
        int i9 = ((i8 * 2) + 2) * i7;
        float[] fArr = new float[i9 * 3];
        float[] fArr2 = new float[i9 * 2];
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        while (i10 < i7) {
            float f8 = radians / 2.0f;
            float f9 = (i10 * f6) - f8;
            int i13 = i10 + 1;
            float f10 = (i13 * f6) - f8;
            int i14 = 0;
            while (i14 < i8) {
                float f11 = radians;
                float f12 = radians2;
                int i15 = 0;
                int i16 = 2;
                while (i15 < i16) {
                    float f13 = f6;
                    float f14 = i14 * f7;
                    float f15 = f7;
                    float f16 = f9;
                    double d3 = f3;
                    double d4 = (f14 + 3.1415927f) - (f12 / 2.0f);
                    double d5 = i15 == 0 ? f9 : f10;
                    fArr[i11] = -((float) (Math.cos(d5) * Math.sin(d4) * d3));
                    fArr[i11 + 1] = (float) (d3 * Math.sin(d5));
                    int i17 = i11 + 3;
                    fArr[i11 + 2] = (float) (d3 * Math.cos(d4) * Math.cos(d5));
                    fArr2[i12] = f14 / f12;
                    int i18 = i12 + 2;
                    fArr2[i12 + 1] = ((i10 + i15) * f13) / f11;
                    if ((i14 == 0 && i15 == 0) || (i14 == i4 && i15 == 1)) {
                        System.arraycopy(fArr, i11, fArr, i17, 3);
                        i11 += 6;
                        i6 = 2;
                        System.arraycopy(fArr2, i12, fArr2, i18, 2);
                        i12 += 4;
                    } else {
                        i6 = 2;
                        i11 = i17;
                        i12 = i18;
                    }
                    i15++;
                    i16 = i6;
                    f6 = f13;
                    f7 = f15;
                    f9 = f16;
                }
                i14++;
                radians2 = f12;
                radians = f11;
                f6 = f6;
            }
            i7 = i3;
            i10 = i13;
        }
        return new ci(new a(new b(0, fArr, fArr2, 1)), i5);
    }

    public ci(a aVar, a aVar2, int i3) {
        this.f58908a = aVar;
        this.f58909b = aVar2;
        this.f58910c = i3;
        this.f58911d = aVar == aVar2;
    }

    public static ci a(int i3) {
        return a(50.0f, 36, 72, 180.0f, 360.0f, i3);
    }
}
