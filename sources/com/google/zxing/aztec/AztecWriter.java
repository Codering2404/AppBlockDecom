package com.google.zxing.aztec;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.Writer;
import com.google.zxing.aztec.encoder.AztecCode;
import com.google.zxing.aztec.encoder.Encoder;
import com.google.zxing.common.BitMatrix;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class AztecWriter implements Writer {
    private static BitMatrix b(String str, BarcodeFormat barcodeFormat, int i3, int i4, Charset charset, int i5, int i6) {
        if (barcodeFormat == BarcodeFormat.AZTEC) {
            return c(Encoder.d(str.getBytes(charset), i5, i6), i3, i4);
        }
        throw new IllegalArgumentException("Can only encode AZTEC, but got ".concat(String.valueOf(barcodeFormat)));
    }

    private static BitMatrix c(AztecCode aztecCode, int i3, int i4) {
        BitMatrix bitMatrixA = aztecCode.a();
        if (bitMatrixA == null) {
            throw new IllegalStateException();
        }
        int iH = bitMatrixA.h();
        int iG = bitMatrixA.g();
        int iMax = Math.max(i3, iH);
        int iMax2 = Math.max(i4, iG);
        int iMin = Math.min(iMax / iH, iMax2 / iG);
        int i5 = (iMax - (iH * iMin)) / 2;
        int i6 = (iMax2 - (iG * iMin)) / 2;
        BitMatrix bitMatrix = new BitMatrix(iMax, iMax2);
        int i7 = 0;
        while (i7 < iG) {
            int i8 = 0;
            int i9 = i5;
            while (i8 < iH) {
                if (bitMatrixA.e(i8, i7)) {
                    bitMatrix.j(i9, i6, iMin, iMin);
                }
                i8++;
                i9 += iMin;
            }
            i7++;
            i6 += iMin;
        }
        return bitMatrix;
    }

    @Override // com.google.zxing.Writer
    public BitMatrix a(String str, BarcodeFormat barcodeFormat, int i3, int i4, Map map) {
        Charset charsetForName = StandardCharsets.ISO_8859_1;
        int i5 = 0;
        if (map != null) {
            EncodeHintType encodeHintType = EncodeHintType.CHARACTER_SET;
            if (map.containsKey(encodeHintType)) {
                charsetForName = Charset.forName(map.get(encodeHintType).toString());
            }
            EncodeHintType encodeHintType2 = EncodeHintType.ERROR_CORRECTION;
            i = map.containsKey(encodeHintType2) ? Integer.parseInt(map.get(encodeHintType2).toString()) : 33;
            EncodeHintType encodeHintType3 = EncodeHintType.AZTEC_LAYERS;
            if (map.containsKey(encodeHintType3)) {
                i5 = Integer.parseInt(map.get(encodeHintType3).toString());
            }
        }
        return b(str, barcodeFormat, i3, i4, charsetForName, i, i5);
    }
}
