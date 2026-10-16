package com.google.zxing.common.reedsolomon;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class GenericGFPoly {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final GenericGF f91836a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int[] f91837b;

    GenericGFPoly(GenericGF genericGF, int[] iArr) {
        if (iArr.length == 0) {
            throw new IllegalArgumentException();
        }
        this.f91836a = genericGF;
        int length = iArr.length;
        int i3 = 1;
        if (length <= 1 || iArr[0] != 0) {
            this.f91837b = iArr;
            return;
        }
        while (i3 < length && iArr[i3] == 0) {
            i3++;
        }
        if (i3 == length) {
            this.f91837b = new int[]{0};
            return;
        }
        int[] iArr2 = new int[length - i3];
        this.f91837b = iArr2;
        System.arraycopy(iArr, i3, iArr2, 0, iArr2.length);
    }

    GenericGFPoly a(GenericGFPoly genericGFPoly) {
        if (!this.f91836a.equals(genericGFPoly.f91836a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        }
        if (f()) {
            return genericGFPoly;
        }
        if (genericGFPoly.f()) {
            return this;
        }
        int[] iArr = this.f91837b;
        int[] iArr2 = genericGFPoly.f91837b;
        if (iArr.length <= iArr2.length) {
            iArr = iArr2;
            iArr2 = iArr;
        }
        int[] iArr3 = new int[iArr.length];
        int length = iArr.length - iArr2.length;
        System.arraycopy(iArr, 0, iArr3, 0, length);
        for (int i3 = length; i3 < iArr.length; i3++) {
            iArr3[i3] = GenericGF.a(iArr2[i3 - length], iArr[i3]);
        }
        return new GenericGFPoly(this.f91836a, iArr3);
    }

    GenericGFPoly[] b(GenericGFPoly genericGFPoly) {
        if (!this.f91836a.equals(genericGFPoly.f91836a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        }
        if (genericGFPoly.f()) {
            throw new IllegalArgumentException("Divide by 0");
        }
        GenericGFPoly genericGFPolyE = this.f91836a.e();
        int iF = this.f91836a.f(genericGFPoly.c(genericGFPoly.e()));
        GenericGFPoly genericGFPolyA = this;
        while (genericGFPolyA.e() >= genericGFPoly.e() && !genericGFPolyA.f()) {
            int iE = genericGFPolyA.e() - genericGFPoly.e();
            int iH = this.f91836a.h(genericGFPolyA.c(genericGFPolyA.e()), iF);
            GenericGFPoly genericGFPolyH = genericGFPoly.h(iE, iH);
            genericGFPolyE = genericGFPolyE.a(this.f91836a.b(iE, iH));
            genericGFPolyA = genericGFPolyA.a(genericGFPolyH);
        }
        return new GenericGFPoly[]{genericGFPolyE, genericGFPolyA};
    }

    int c(int i3) {
        return this.f91837b[(r0.length - 1) - i3];
    }

    int[] d() {
        return this.f91837b;
    }

    int e() {
        return this.f91837b.length - 1;
    }

    boolean f() {
        return this.f91837b[0] == 0;
    }

    GenericGFPoly g(GenericGFPoly genericGFPoly) {
        if (!this.f91836a.equals(genericGFPoly.f91836a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        }
        if (f() || genericGFPoly.f()) {
            return this.f91836a.e();
        }
        int[] iArr = this.f91837b;
        int length = iArr.length;
        int[] iArr2 = genericGFPoly.f91837b;
        int length2 = iArr2.length;
        int[] iArr3 = new int[(length + length2) - 1];
        for (int i3 = 0; i3 < length; i3++) {
            int i4 = iArr[i3];
            for (int i5 = 0; i5 < length2; i5++) {
                int i6 = i3 + i5;
                iArr3[i6] = GenericGF.a(iArr3[i6], this.f91836a.h(i4, iArr2[i5]));
            }
        }
        return new GenericGFPoly(this.f91836a, iArr3);
    }

    GenericGFPoly h(int i3, int i4) {
        if (i3 < 0) {
            throw new IllegalArgumentException();
        }
        if (i4 == 0) {
            return this.f91836a.e();
        }
        int length = this.f91837b.length;
        int[] iArr = new int[i3 + length];
        for (int i5 = 0; i5 < length; i5++) {
            iArr[i5] = this.f91836a.h(this.f91837b[i5], i4);
        }
        return new GenericGFPoly(this.f91836a, iArr);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(e() * 8);
        for (int iE = e(); iE >= 0; iE--) {
            int iC = c(iE);
            if (iC != 0) {
                if (iC < 0) {
                    sb.append(" - ");
                    iC = -iC;
                } else if (sb.length() > 0) {
                    sb.append(" + ");
                }
                if (iE == 0 || iC != 1) {
                    int iG = this.f91836a.g(iC);
                    if (iG == 0) {
                        sb.append('1');
                    } else if (iG == 1) {
                        sb.append('a');
                    } else {
                        sb.append("a^");
                        sb.append(iG);
                    }
                }
                if (iE != 0) {
                    if (iE == 1) {
                        sb.append('x');
                    } else {
                        sb.append("x^");
                        sb.append(iE);
                    }
                }
            }
        }
        return sb.toString();
    }
}
