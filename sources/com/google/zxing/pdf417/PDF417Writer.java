package com.google.zxing.pdf417;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.Writer;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.pdf417.encoder.Compaction;
import com.google.zxing.pdf417.encoder.Dimensions;
import com.google.zxing.pdf417.encoder.PDF417;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class PDF417Writer implements Writer {
    private static BitMatrix b(byte[][] bArr, int i3) {
        int i4 = i3 * 2;
        BitMatrix bitMatrix = new BitMatrix(bArr[0].length + i4, bArr.length + i4);
        bitMatrix.b();
        int iG = (bitMatrix.g() - i3) - 1;
        int i5 = 0;
        while (i5 < bArr.length) {
            byte[] bArr2 = bArr[i5];
            for (int i6 = 0; i6 < bArr[0].length; i6++) {
                if (bArr2[i6] == 1) {
                    bitMatrix.i(i6 + i3, iG);
                }
            }
            i5++;
            iG--;
        }
        return bitMatrix;
    }

    private static BitMatrix c(PDF417 pdf417, String str, int i3, int i4, int i5, int i6) throws WriterException {
        boolean z2;
        pdf417.e(str, i3);
        byte[][] bArrB = pdf417.f().b(1, 4);
        if ((i5 > i4) != (bArrB[0].length < bArrB.length)) {
            bArrB = d(bArrB);
            z2 = true;
        } else {
            z2 = false;
        }
        int length = i4 / bArrB[0].length;
        int length2 = i5 / bArrB.length;
        if (length >= length2) {
            length = length2;
        }
        if (length <= 1) {
            return b(bArrB, i6);
        }
        byte[][] bArrB2 = pdf417.f().b(length, length << 2);
        if (z2) {
            bArrB2 = d(bArrB2);
        }
        return b(bArrB2, i6);
    }

    private static byte[][] d(byte[][] bArr) {
        byte[][] bArr2 = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, bArr[0].length, bArr.length);
        for (int i3 = 0; i3 < bArr.length; i3++) {
            int length = (bArr.length - i3) - 1;
            for (int i4 = 0; i4 < bArr[0].length; i4++) {
                bArr2[i4][length] = bArr[i3][i4];
            }
        }
        return bArr2;
    }

    @Override // com.google.zxing.Writer
    public BitMatrix a(String str, BarcodeFormat barcodeFormat, int i3, int i4, Map map) {
        if (barcodeFormat != BarcodeFormat.PDF_417) {
            throw new IllegalArgumentException("Can only encode PDF_417, but got ".concat(String.valueOf(barcodeFormat)));
        }
        PDF417 pdf417 = new PDF417();
        if (map != null) {
            EncodeHintType encodeHintType = EncodeHintType.PDF417_COMPACT;
            if (map.containsKey(encodeHintType)) {
                pdf417.h(Boolean.valueOf(map.get(encodeHintType).toString()).booleanValue());
            }
            EncodeHintType encodeHintType2 = EncodeHintType.PDF417_COMPACTION;
            if (map.containsKey(encodeHintType2)) {
                pdf417.i(Compaction.valueOf(map.get(encodeHintType2).toString()));
            }
            EncodeHintType encodeHintType3 = EncodeHintType.PDF417_DIMENSIONS;
            if (map.containsKey(encodeHintType3)) {
                Dimensions dimensions = (Dimensions) map.get(encodeHintType3);
                pdf417.j(dimensions.a(), dimensions.c(), dimensions.b(), dimensions.d());
            }
            EncodeHintType encodeHintType4 = EncodeHintType.MARGIN;
            i = map.containsKey(encodeHintType4) ? Integer.parseInt(map.get(encodeHintType4).toString()) : 30;
            EncodeHintType encodeHintType5 = EncodeHintType.ERROR_CORRECTION;
            i = map.containsKey(encodeHintType5) ? Integer.parseInt(map.get(encodeHintType5).toString()) : 2;
            EncodeHintType encodeHintType6 = EncodeHintType.CHARACTER_SET;
            if (map.containsKey(encodeHintType6)) {
                pdf417.k(Charset.forName(map.get(encodeHintType6).toString()));
            }
        }
        return c(pdf417, str, i, i3, i4, i);
    }
}
