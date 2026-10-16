package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.Writer;
import com.google.zxing.common.BitMatrix;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class OneDimensionalCodeWriter implements Writer {
    protected static int b(boolean[] zArr, int i3, int[] iArr, boolean z2) {
        int i4 = 0;
        for (int i5 : iArr) {
            int i6 = 0;
            while (i6 < i5) {
                zArr[i3] = z2;
                i6++;
                i3++;
            }
            i4 += i5;
            z2 = !z2;
        }
        return i4;
    }

    private static BitMatrix e(boolean[] zArr, int i3, int i4, int i5) {
        int length = zArr.length;
        int i6 = i5 + length;
        int iMax = Math.max(i3, i6);
        int iMax2 = Math.max(1, i4);
        int i7 = iMax / i6;
        int i8 = (iMax - (length * i7)) / 2;
        BitMatrix bitMatrix = new BitMatrix(iMax, iMax2);
        int i9 = 0;
        while (i9 < length) {
            if (zArr[i9]) {
                bitMatrix.j(i8, 0, i7, iMax2);
            }
            i9++;
            i8 += i7;
        }
        return bitMatrix;
    }

    @Override // com.google.zxing.Writer
    public BitMatrix a(String str, BarcodeFormat barcodeFormat, int i3, int i4, Map map) {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        }
        if (i3 < 0 || i4 < 0) {
            throw new IllegalArgumentException("Negative size is not allowed. Input: " + i3 + 'x' + i4);
        }
        int iD = d();
        if (map != null) {
            EncodeHintType encodeHintType = EncodeHintType.MARGIN;
            if (map.containsKey(encodeHintType)) {
                iD = Integer.parseInt(map.get(encodeHintType).toString());
            }
        }
        return e(c(str), i3, i4, iD);
    }

    public abstract boolean[] c(String str);

    public int d() {
        return 10;
    }
}
