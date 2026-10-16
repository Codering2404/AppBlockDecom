package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.common.BitMatrix;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class Code39Writer extends OneDimensionalCodeWriter {
    private static void f(int i3, int[] iArr) {
        for (int i4 = 0; i4 < 9; i4++) {
            int i5 = 1;
            if (((1 << (8 - i4)) & i3) != 0) {
                i5 = 2;
            }
            iArr[i4] = i5;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x00d4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String g(java.lang.String r7) {
        /*
            Method dump skipped, instruction units count: 230
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.oned.Code39Writer.g(java.lang.String):java.lang.String");
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter, com.google.zxing.Writer
    public BitMatrix a(String str, BarcodeFormat barcodeFormat, int i3, int i4, Map map) {
        if (barcodeFormat == BarcodeFormat.CODE_39) {
            return super.a(str, barcodeFormat, i3, i4, map);
        }
        throw new IllegalArgumentException("Can only encode CODE_39, but got ".concat(String.valueOf(barcodeFormat)));
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter
    public boolean[] c(String str) {
        int length = str.length();
        if (length > 80) {
            throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got ".concat(String.valueOf(length)));
        }
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                break;
            }
            if ("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".indexOf(str.charAt(i3)) < 0) {
                str = g(str);
                length = str.length();
                if (length > 80) {
                    throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got " + length + " (extended full ASCII mode)");
                }
            } else {
                i3++;
            }
        }
        int[] iArr = new int[9];
        int i4 = length + 25;
        for (int i5 = 0; i5 < length; i5++) {
            f(Code39Reader.f91921a["0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".indexOf(str.charAt(i5))], iArr);
            for (int i6 = 0; i6 < 9; i6++) {
                i4 += iArr[i6];
            }
        }
        boolean[] zArr = new boolean[i4];
        f(148, iArr);
        int iB = OneDimensionalCodeWriter.b(zArr, 0, iArr, true);
        int[] iArr2 = {1};
        int iB2 = iB + OneDimensionalCodeWriter.b(zArr, iB, iArr2, false);
        for (int i7 = 0; i7 < length; i7++) {
            f(Code39Reader.f91921a["0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".indexOf(str.charAt(i7))], iArr);
            int iB3 = iB2 + OneDimensionalCodeWriter.b(zArr, iB2, iArr, true);
            iB2 = iB3 + OneDimensionalCodeWriter.b(zArr, iB3, iArr2, false);
        }
        f(148, iArr);
        OneDimensionalCodeWriter.b(zArr, iB2, iArr, true);
        return zArr;
    }
}
