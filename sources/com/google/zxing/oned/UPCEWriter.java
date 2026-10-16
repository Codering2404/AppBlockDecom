package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.FormatException;
import com.google.zxing.common.BitMatrix;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class UPCEWriter extends UPCEANWriter {
    @Override // com.google.zxing.oned.OneDimensionalCodeWriter, com.google.zxing.Writer
    public BitMatrix a(String str, BarcodeFormat barcodeFormat, int i3, int i4, Map map) {
        if (barcodeFormat == BarcodeFormat.UPC_E) {
            return super.a(str, barcodeFormat, i3, i4, map);
        }
        throw new IllegalArgumentException("Can only encode UPC_E, but got ".concat(String.valueOf(barcodeFormat)));
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter
    public boolean[] c(String str) {
        int length = str.length();
        if (length == 7) {
            try {
                str = str + UPCEANReader.b(UPCEReader.c(str));
            } catch (FormatException e3) {
                throw new IllegalArgumentException(e3);
            }
        } else {
            if (length != 8) {
                throw new IllegalArgumentException("Requested contents should be 8 digits long, but got ".concat(String.valueOf(length)));
            }
            try {
                if (!UPCEANReader.a(str)) {
                    throw new IllegalArgumentException("Contents do not pass checksum");
                }
            } catch (FormatException unused) {
                throw new IllegalArgumentException("Illegal contents");
            }
        }
        int iDigit = Character.digit(str.charAt(0), 10);
        if (iDigit != 0 && iDigit != 1) {
            throw new IllegalArgumentException("Number system must be 0 or 1");
        }
        int i3 = UPCEReader.f91942g[iDigit][Character.digit(str.charAt(7), 10)];
        boolean[] zArr = new boolean[51];
        int iB = OneDimensionalCodeWriter.b(zArr, 0, UPCEANReader.f91936a, true);
        for (int i4 = 1; i4 <= 6; i4++) {
            int iDigit2 = Character.digit(str.charAt(i4), 10);
            if (((i3 >> (6 - i4)) & 1) == 1) {
                iDigit2 += 10;
            }
            iB += OneDimensionalCodeWriter.b(zArr, iB, UPCEANReader.f91940e[iDigit2], false);
        }
        OneDimensionalCodeWriter.b(zArr, iB, UPCEANReader.f91938c, false);
        return zArr;
    }
}
