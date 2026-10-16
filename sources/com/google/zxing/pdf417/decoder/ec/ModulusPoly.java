package com.google.zxing.pdf417.decoder.ec;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class ModulusPoly {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ModulusGF f92002a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int[] f92003b;

    ModulusPoly(ModulusGF modulusGF, int[] iArr) {
        if (iArr.length == 0) {
            throw new IllegalArgumentException();
        }
        this.f92002a = modulusGF;
        int length = iArr.length;
        int i3 = 1;
        if (length <= 1 || iArr[0] != 0) {
            this.f92003b = iArr;
            return;
        }
        while (i3 < length && iArr[i3] == 0) {
            i3++;
        }
        if (i3 == length) {
            this.f92003b = new int[]{0};
            return;
        }
        int[] iArr2 = new int[length - i3];
        this.f92003b = iArr2;
        System.arraycopy(iArr, i3, iArr2, 0, iArr2.length);
    }

    int a(int i3) {
        return this.f92003b[(r0.length - 1) - i3];
    }

    int b() {
        return this.f92003b.length - 1;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(b() * 8);
        for (int iB = b(); iB >= 0; iB--) {
            int iA = a(iB);
            if (iA != 0) {
                if (iA < 0) {
                    sb.append(" - ");
                    iA = -iA;
                } else if (sb.length() > 0) {
                    sb.append(" + ");
                }
                if (iB == 0 || iA != 1) {
                    sb.append(iA);
                }
                if (iB != 0) {
                    if (iB == 1) {
                        sb.append('x');
                    } else {
                        sb.append("x^");
                        sb.append(iB);
                    }
                }
            }
        }
        return sb.toString();
    }
}
