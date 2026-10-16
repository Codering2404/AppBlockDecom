package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.FormatException;
import com.google.zxing.common.BitMatrix;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class EAN8Writer extends UPCEANWriter {
    @Override // com.google.zxing.oned.OneDimensionalCodeWriter, com.google.zxing.Writer
    public BitMatrix a(String str, BarcodeFormat barcodeFormat, int i3, int i4, Map map) {
        if (barcodeFormat == BarcodeFormat.EAN_8) {
            return super.a(str, barcodeFormat, i3, i4, map);
        }
        throw new IllegalArgumentException("Can only encode EAN_8, but got ".concat(String.valueOf(barcodeFormat)));
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter
    public boolean[] c(String str) {
        int length = str.length();
        if (length == 7) {
            try {
                str = str + UPCEANReader.b(str);
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
        boolean[] zArr = new boolean[67];
        int iB = OneDimensionalCodeWriter.b(zArr, 0, UPCEANReader.f91936a, true);
        for (int i3 = 0; i3 <= 3; i3++) {
            iB += OneDimensionalCodeWriter.b(zArr, iB, UPCEANReader.f91939d[Character.digit(str.charAt(i3), 10)], false);
        }
        int iB2 = iB + OneDimensionalCodeWriter.b(zArr, iB, UPCEANReader.f91937b, false);
        for (int i4 = 4; i4 <= 7; i4++) {
            iB2 += OneDimensionalCodeWriter.b(zArr, iB2, UPCEANReader.f91939d[Character.digit(str.charAt(i4), 10)], true);
        }
        OneDimensionalCodeWriter.b(zArr, iB2, UPCEANReader.f91936a, true);
        return zArr;
    }
}
