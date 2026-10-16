package com.google.zxing.qrcode.encoder;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class MaskUtil {
    static int a(ByteMatrix byteMatrix) {
        return b(byteMatrix, true) + b(byteMatrix, false);
    }

    private static int b(ByteMatrix byteMatrix, boolean z2) {
        int iD = z2 ? byteMatrix.d() : byteMatrix.e();
        int iE = z2 ? byteMatrix.e() : byteMatrix.d();
        byte[][] bArrC = byteMatrix.c();
        int i3 = 0;
        for (int i4 = 0; i4 < iD; i4++) {
            byte b3 = -1;
            int i5 = 0;
            for (int i6 = 0; i6 < iE; i6++) {
                byte b4 = z2 ? bArrC[i4][i6] : bArrC[i6][i4];
                if (b4 == b3) {
                    i5++;
                } else {
                    if (i5 >= 5) {
                        i3 += i5 - 2;
                    }
                    i5 = 1;
                    b3 = b4;
                }
            }
            if (i5 >= 5) {
                i3 += i5 - 2;
            }
        }
        return i3;
    }

    static int c(ByteMatrix byteMatrix) {
        byte[][] bArrC = byteMatrix.c();
        int iE = byteMatrix.e();
        int iD = byteMatrix.d();
        int i3 = 0;
        for (int i4 = 0; i4 < iD - 1; i4++) {
            byte[] bArr = bArrC[i4];
            int i5 = 0;
            while (i5 < iE - 1) {
                byte b3 = bArr[i5];
                int i6 = i5 + 1;
                if (b3 == bArr[i6]) {
                    byte[] bArr2 = bArrC[i4 + 1];
                    if (b3 == bArr2[i5] && b3 == bArr2[i6]) {
                        i3++;
                    }
                }
                i5 = i6;
            }
        }
        return i3 * 3;
    }

    static int d(ByteMatrix byteMatrix) {
        byte[][] bArrC = byteMatrix.c();
        int iE = byteMatrix.e();
        int iD = byteMatrix.d();
        int i3 = 0;
        for (int i4 = 0; i4 < iD; i4++) {
            for (int i5 = 0; i5 < iE; i5++) {
                byte[] bArr = bArrC[i4];
                int i6 = i5 + 6;
                if (i6 < iE && bArr[i5] == 1 && bArr[i5 + 1] == 0 && bArr[i5 + 2] == 1 && bArr[i5 + 3] == 1 && bArr[i5 + 4] == 1 && bArr[i5 + 5] == 0 && bArr[i6] == 1 && (g(bArr, i5 - 4, i5) || g(bArr, i5 + 7, i5 + 11))) {
                    i3++;
                }
                int i7 = i4 + 6;
                if (i7 < iD && bArrC[i4][i5] == 1 && bArrC[i4 + 1][i5] == 0 && bArrC[i4 + 2][i5] == 1 && bArrC[i4 + 3][i5] == 1 && bArrC[i4 + 4][i5] == 1 && bArrC[i4 + 5][i5] == 0 && bArrC[i7][i5] == 1 && (h(bArrC, i5, i4 - 4, i4) || h(bArrC, i5, i4 + 7, i4 + 11))) {
                    i3++;
                }
            }
        }
        return i3 * 40;
    }

    static int e(ByteMatrix byteMatrix) {
        byte[][] bArrC = byteMatrix.c();
        int iE = byteMatrix.e();
        int iD = byteMatrix.d();
        int i3 = 0;
        for (int i4 = 0; i4 < iD; i4++) {
            byte[] bArr = bArrC[i4];
            for (int i5 = 0; i5 < iE; i5++) {
                if (bArr[i5] == 1) {
                    i3++;
                }
            }
        }
        int iD2 = byteMatrix.d() * byteMatrix.e();
        return ((Math.abs((i3 << 1) - iD2) * 10) / iD2) * 10;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003d A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static boolean f(int r1, int r2, int r3) {
        /*
            r0 = 1
            switch(r1) {
                case 0: goto L30;
                case 1: goto L31;
                case 2: goto L38;
                case 3: goto L34;
                case 4: goto L2c;
                case 5: goto L25;
                case 6: goto L1e;
                case 7: goto L14;
                default: goto L4;
            }
        L4:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r3 = "Invalid mask pattern: "
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r1 = r3.concat(r1)
            r2.<init>(r1)
            throw r2
        L14:
            int r1 = r3 * r2
            int r1 = r1 % 3
            int r3 = r3 + r2
            r2 = r3 & 1
            int r1 = r1 + r2
        L1c:
            r1 = r1 & r0
            goto L3a
        L1e:
            int r3 = r3 * r2
            r1 = r3 & 1
            int r3 = r3 % 3
            int r1 = r1 + r3
            goto L1c
        L25:
            int r3 = r3 * r2
            r1 = r3 & 1
            int r3 = r3 % 3
            int r1 = r1 + r3
            goto L3a
        L2c:
            int r3 = r3 / 2
            int r2 = r2 / 3
        L30:
            int r3 = r3 + r2
        L31:
            r1 = r3 & 1
            goto L3a
        L34:
            int r3 = r3 + r2
            int r1 = r3 % 3
            goto L3a
        L38:
            int r1 = r2 % 3
        L3a:
            if (r1 != 0) goto L3d
            return r0
        L3d:
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.qrcode.encoder.MaskUtil.f(int, int, int):boolean");
    }

    private static boolean g(byte[] bArr, int i3, int i4) {
        int iMin = Math.min(i4, bArr.length);
        for (int iMax = Math.max(i3, 0); iMax < iMin; iMax++) {
            if (bArr[iMax] == 1) {
                return false;
            }
        }
        return true;
    }

    private static boolean h(byte[][] bArr, int i3, int i4, int i5) {
        int iMin = Math.min(i5, bArr.length);
        for (int iMax = Math.max(i4, 0); iMax < iMin; iMax++) {
            if (bArr[iMax][i3] == 1) {
                return false;
            }
        }
        return true;
    }
}
