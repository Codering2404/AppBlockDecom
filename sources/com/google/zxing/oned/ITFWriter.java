package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.common.BitMatrix;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class ITFWriter extends OneDimensionalCodeWriter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f91930a = {1, 1, 1, 1};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int[] f91931b = {3, 1, 1};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int[][] f91932c = {new int[]{1, 1, 3, 3, 1}, new int[]{3, 1, 1, 1, 3}, new int[]{1, 3, 1, 1, 3}, new int[]{3, 3, 1, 1, 1}, new int[]{1, 1, 3, 1, 3}, new int[]{3, 1, 3, 1, 1}, new int[]{1, 3, 3, 1, 1}, new int[]{1, 1, 1, 3, 3}, new int[]{3, 1, 1, 3, 1}, new int[]{1, 3, 1, 3, 1}};

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter, com.google.zxing.Writer
    public BitMatrix a(String str, BarcodeFormat barcodeFormat, int i3, int i4, Map map) {
        if (barcodeFormat == BarcodeFormat.ITF) {
            return super.a(str, barcodeFormat, i3, i4, map);
        }
        throw new IllegalArgumentException("Can only encode ITF, but got ".concat(String.valueOf(barcodeFormat)));
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter
    public boolean[] c(String str) {
        int length = str.length();
        if (length % 2 != 0) {
            throw new IllegalArgumentException("The length of the input should be even");
        }
        if (length > 80) {
            throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got ".concat(String.valueOf(length)));
        }
        boolean[] zArr = new boolean[(length * 9) + 9];
        int iB = OneDimensionalCodeWriter.b(zArr, 0, f91930a, true);
        for (int i3 = 0; i3 < length; i3 += 2) {
            int iDigit = Character.digit(str.charAt(i3), 10);
            int iDigit2 = Character.digit(str.charAt(i3 + 1), 10);
            int[] iArr = new int[10];
            for (int i4 = 0; i4 < 5; i4++) {
                int i5 = i4 * 2;
                int[][] iArr2 = f91932c;
                iArr[i5] = iArr2[iDigit][i4];
                iArr[i5 + 1] = iArr2[iDigit2][i4];
            }
            iB += OneDimensionalCodeWriter.b(zArr, iB, iArr, true);
        }
        OneDimensionalCodeWriter.b(zArr, iB, f91931b, true);
        return zArr;
    }
}
