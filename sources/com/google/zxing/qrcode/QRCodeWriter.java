package com.google.zxing.qrcode;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.Writer;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.encoder.ByteMatrix;
import com.google.zxing.qrcode.encoder.Encoder;
import com.google.zxing.qrcode.encoder.QRCode;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class QRCodeWriter implements Writer {
    private static BitMatrix b(QRCode qRCode, int i3, int i4, int i5) {
        ByteMatrix byteMatrixA = qRCode.a();
        if (byteMatrixA == null) {
            throw new IllegalStateException();
        }
        int iE = byteMatrixA.e();
        int iD = byteMatrixA.d();
        int i6 = i5 << 1;
        int i7 = iE + i6;
        int i8 = i6 + iD;
        int iMax = Math.max(i3, i7);
        int iMax2 = Math.max(i4, i8);
        int iMin = Math.min(iMax / i7, iMax2 / i8);
        int i9 = (iMax - (iE * iMin)) / 2;
        int i10 = (iMax2 - (iD * iMin)) / 2;
        BitMatrix bitMatrix = new BitMatrix(iMax, iMax2);
        int i11 = 0;
        while (i11 < iD) {
            int i12 = 0;
            int i13 = i9;
            while (i12 < iE) {
                if (byteMatrixA.b(i12, i11) == 1) {
                    bitMatrix.j(i13, i10, iMin, iMin);
                }
                i12++;
                i13 += iMin;
            }
            i11++;
            i10 += iMin;
        }
        return bitMatrix;
    }

    @Override // com.google.zxing.Writer
    public BitMatrix a(String str, BarcodeFormat barcodeFormat, int i3, int i4, Map map) {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        }
        if (barcodeFormat != BarcodeFormat.QR_CODE) {
            throw new IllegalArgumentException("Can only encode QR_CODE, but got ".concat(String.valueOf(barcodeFormat)));
        }
        if (i3 < 0 || i4 < 0) {
            throw new IllegalArgumentException("Requested dimensions are too small: " + i3 + 'x' + i4);
        }
        ErrorCorrectionLevel errorCorrectionLevelValueOf = ErrorCorrectionLevel.L;
        int i5 = 4;
        if (map != null) {
            EncodeHintType encodeHintType = EncodeHintType.ERROR_CORRECTION;
            if (map.containsKey(encodeHintType)) {
                errorCorrectionLevelValueOf = ErrorCorrectionLevel.valueOf(map.get(encodeHintType).toString());
            }
            EncodeHintType encodeHintType2 = EncodeHintType.MARGIN;
            if (map.containsKey(encodeHintType2)) {
                i5 = Integer.parseInt(map.get(encodeHintType2).toString());
            }
        }
        return b(Encoder.n(str, errorCorrectionLevelValueOf, map), i3, i4, i5);
    }
}
