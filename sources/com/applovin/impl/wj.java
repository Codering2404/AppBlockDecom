package com.applovin.impl;

import java.util.Arrays;
import java.util.Random;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public interface wj {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class a implements wj {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Random f64670a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int[] f64671b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int[] f64672c;

        public a(int i3) {
            this(i3, new Random());
        }

        @Override // com.applovin.impl.wj
        public wj a(int i3, int i4) {
            int i5 = i4 - i3;
            int[] iArr = new int[this.f64671b.length - i5];
            int i6 = 0;
            int i7 = 0;
            while (true) {
                int[] iArr2 = this.f64671b;
                if (i6 >= iArr2.length) {
                    return new a(iArr, new Random(this.f64670a.nextLong()));
                }
                int i8 = iArr2[i6];
                if (i8 < i3 || i8 >= i4) {
                    int i9 = i6 - i7;
                    if (i8 >= i3) {
                        i8 -= i5;
                    }
                    iArr[i9] = i8;
                } else {
                    i7++;
                }
                i6++;
            }
        }

        @Override // com.applovin.impl.wj
        public wj b(int i3, int i4) {
            int[] iArr = new int[i4];
            int[] iArr2 = new int[i4];
            int i5 = 0;
            int i6 = 0;
            while (i6 < i4) {
                iArr[i6] = this.f64670a.nextInt(this.f64671b.length + 1);
                int i7 = i6 + 1;
                int iNextInt = this.f64670a.nextInt(i7);
                iArr2[i6] = iArr2[iNextInt];
                iArr2[iNextInt] = i6 + i3;
                i6 = i7;
            }
            Arrays.sort(iArr);
            int[] iArr3 = new int[this.f64671b.length + i4];
            int i8 = 0;
            int i9 = 0;
            while (true) {
                int[] iArr4 = this.f64671b;
                if (i5 >= iArr4.length + i4) {
                    return new a(iArr3, new Random(this.f64670a.nextLong()));
                }
                if (i8 >= i4 || i9 != iArr[i8]) {
                    int i10 = i9 + 1;
                    int i11 = iArr4[i9];
                    iArr3[i5] = i11;
                    if (i11 >= i3) {
                        iArr3[i5] = i11 + i4;
                    }
                    i9 = i10;
                } else {
                    iArr3[i5] = iArr2[i8];
                    i8++;
                }
                i5++;
            }
        }

        @Override // com.applovin.impl.wj
        public int c() {
            int[] iArr = this.f64671b;
            if (iArr.length > 0) {
                return iArr[iArr.length - 1];
            }
            return -1;
        }

        @Override // com.applovin.impl.wj
        public wj d() {
            return new a(0, new Random(this.f64670a.nextLong()));
        }

        private a(int i3, Random random) {
            this(a(i3, random), random);
        }

        private a(int[] iArr, Random random) {
            this.f64671b = iArr;
            this.f64670a = random;
            this.f64672c = new int[iArr.length];
            for (int i3 = 0; i3 < iArr.length; i3++) {
                this.f64672c[iArr[i3]] = i3;
            }
        }

        private static int[] a(int i3, Random random) {
            int[] iArr = new int[i3];
            int i4 = 0;
            while (i4 < i3) {
                int i5 = i4 + 1;
                int iNextInt = random.nextInt(i5);
                iArr[i4] = iArr[iNextInt];
                iArr[iNextInt] = i4;
                i4 = i5;
            }
            return iArr;
        }

        @Override // com.applovin.impl.wj
        public int a() {
            return this.f64671b.length;
        }

        @Override // com.applovin.impl.wj
        public int a(int i3) {
            int i4 = this.f64672c[i3] + 1;
            int[] iArr = this.f64671b;
            if (i4 < iArr.length) {
                return iArr[i4];
            }
            return -1;
        }

        @Override // com.applovin.impl.wj
        public int b() {
            int[] iArr = this.f64671b;
            if (iArr.length > 0) {
                return iArr[0];
            }
            return -1;
        }

        @Override // com.applovin.impl.wj
        public int b(int i3) {
            int i4 = this.f64672c[i3] - 1;
            if (i4 >= 0) {
                return this.f64671b[i4];
            }
            return -1;
        }
    }

    int a();

    int a(int i3);

    wj a(int i3, int i4);

    int b();

    int b(int i3);

    wj b(int i3, int i4);

    int c();

    wj d();
}
