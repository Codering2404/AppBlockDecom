package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.common.BitMatrix;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class Code93Writer extends OneDimensionalCodeWriter {
    private static int f(boolean[] zArr, int i3, int[] iArr) {
        int length = iArr.length;
        int i4 = 0;
        while (i4 < length) {
            int i5 = i3 + 1;
            zArr[i3] = iArr[i4] != 0;
            i4++;
            i3 = i5;
        }
        return 9;
    }

    private static int g(String str, int i3) {
        int iIndexOf = 0;
        int i4 = 1;
        for (int length = str.length() - 1; length >= 0; length--) {
            iIndexOf += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(str.charAt(length)) * i4;
            i4++;
            if (i4 > i3) {
                i4 = 1;
            }
        }
        return iIndexOf % 47;
    }

    private static void h(int i3, int[] iArr) {
        for (int i4 = 0; i4 < 9; i4++) {
            int i5 = 1;
            if (((1 << (8 - i4)) & i3) == 0) {
                i5 = 0;
            }
            iArr[i4] = i5;
        }
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter, com.google.zxing.Writer
    public BitMatrix a(String str, BarcodeFormat barcodeFormat, int i3, int i4, Map map) {
        if (barcodeFormat == BarcodeFormat.CODE_93) {
            return super.a(str, barcodeFormat, i3, i4, map);
        }
        throw new IllegalArgumentException("Can only encode CODE_93, but got ".concat(String.valueOf(barcodeFormat)));
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter
    public boolean[] c(String str) {
        int length = str.length();
        if (length > 80) {
            throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got ".concat(String.valueOf(length)));
        }
        int[] iArr = new int[9];
        int length2 = ((str.length() + 4) * 9) + 1;
        h(Code93Reader.f91923b[47], iArr);
        boolean[] zArr = new boolean[length2];
        int iF = f(zArr, 0, iArr);
        for (int i3 = 0; i3 < length; i3++) {
            h(Code93Reader.f91923b["0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(str.charAt(i3))], iArr);
            iF += f(zArr, iF, iArr);
        }
        int iG = g(str, 20);
        int[] iArr2 = Code93Reader.f91923b;
        h(iArr2[iG], iArr);
        int iF2 = iF + f(zArr, iF, iArr);
        h(iArr2[g(str + "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".charAt(iG), 15)], iArr);
        int iF3 = iF2 + f(zArr, iF2, iArr);
        h(iArr2[47], iArr);
        zArr[iF3 + f(zArr, iF3, iArr)] = true;
        return zArr;
    }
}
