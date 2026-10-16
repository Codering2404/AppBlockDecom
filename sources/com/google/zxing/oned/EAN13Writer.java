package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.FormatException;
import com.google.zxing.common.BitMatrix;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class EAN13Writer extends UPCEANWriter {
    @Override // com.google.zxing.oned.OneDimensionalCodeWriter, com.google.zxing.Writer
    public BitMatrix a(String str, BarcodeFormat barcodeFormat, int i3, int i4, Map map) {
        if (barcodeFormat == BarcodeFormat.EAN_13) {
            return super.a(str, barcodeFormat, i3, i4, map);
        }
        throw new IllegalArgumentException("Can only encode EAN_13, but got ".concat(String.valueOf(barcodeFormat)));
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter
    public boolean[] c(String str) {
        int length = str.length();
        if (length == 12) {
            try {
                str = str + UPCEANReader.b(str);
            } catch (FormatException e3) {
                throw new IllegalArgumentException(e3);
            }
        } else {
            if (length != 13) {
                throw new IllegalArgumentException("Requested contents should be 12 or 13 digits long, but got ".concat(String.valueOf(length)));
            }
            try {
                if (!UPCEANReader.a(str)) {
                    throw new IllegalArgumentException("Contents do not pass checksum");
                }
            } catch (FormatException unused) {
                throw new IllegalArgumentException("Illegal contents");
            }
        }
        int i3 = EAN13Reader.f91925f[Character.digit(str.charAt(0), 10)];
        boolean[] zArr = new boolean[95];
        int iB = OneDimensionalCodeWriter.b(zArr, 0, UPCEANReader.f91936a, true);
        for (int i4 = 1; i4 <= 6; i4++) {
            int iDigit = Character.digit(str.charAt(i4), 10);
            if (((i3 >> (6 - i4)) & 1) == 1) {
                iDigit += 10;
            }
            iB += OneDimensionalCodeWriter.b(zArr, iB, UPCEANReader.f91940e[iDigit], false);
        }
        int iB2 = iB + OneDimensionalCodeWriter.b(zArr, iB, UPCEANReader.f91937b, false);
        for (int i5 = 7; i5 <= 12; i5++) {
            iB2 += OneDimensionalCodeWriter.b(zArr, iB2, UPCEANReader.f91939d[Character.digit(str.charAt(i5), 10)], true);
        }
        OneDimensionalCodeWriter.b(zArr, iB2, UPCEANReader.f91936a, true);
        return zArr;
    }
}
