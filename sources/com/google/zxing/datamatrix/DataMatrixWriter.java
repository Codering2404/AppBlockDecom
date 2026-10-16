package com.google.zxing.datamatrix;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.Dimension;
import com.google.zxing.EncodeHintType;
import com.google.zxing.Writer;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.datamatrix.encoder.DefaultPlacement;
import com.google.zxing.datamatrix.encoder.ErrorCorrection;
import com.google.zxing.datamatrix.encoder.HighLevelEncoder;
import com.google.zxing.datamatrix.encoder.SymbolInfo;
import com.google.zxing.datamatrix.encoder.SymbolShapeHint;
import com.google.zxing.qrcode.encoder.ByteMatrix;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class DataMatrixWriter implements Writer {
    private static BitMatrix b(ByteMatrix byteMatrix, int i3, int i4) {
        BitMatrix bitMatrix;
        int iE = byteMatrix.e();
        int iD = byteMatrix.d();
        int iMax = Math.max(i3, iE);
        int iMax2 = Math.max(i4, iD);
        int iMin = Math.min(iMax / iE, iMax2 / iD);
        int i5 = (iMax - (iE * iMin)) / 2;
        int i6 = (iMax2 - (iD * iMin)) / 2;
        if (i4 < iD || i3 < iE) {
            bitMatrix = new BitMatrix(iE, iD);
            i5 = 0;
            i6 = 0;
        } else {
            bitMatrix = new BitMatrix(i3, i4);
        }
        bitMatrix.b();
        int i7 = 0;
        while (i7 < iD) {
            int i8 = i5;
            int i9 = 0;
            while (i9 < iE) {
                if (byteMatrix.b(i9, i7) == 1) {
                    bitMatrix.j(i8, i6, iMin, iMin);
                }
                i9++;
                i8 += iMin;
            }
            i7++;
            i6 += iMin;
        }
        return bitMatrix;
    }

    private static BitMatrix c(DefaultPlacement defaultPlacement, SymbolInfo symbolInfo, int i3, int i4) {
        int iH = symbolInfo.h();
        int iG = symbolInfo.g();
        ByteMatrix byteMatrix = new ByteMatrix(symbolInfo.j(), symbolInfo.i());
        int i5 = 0;
        for (int i6 = 0; i6 < iG; i6++) {
            if (i6 % symbolInfo.f91893e == 0) {
                int i7 = 0;
                for (int i8 = 0; i8 < symbolInfo.j(); i8++) {
                    byteMatrix.g(i7, i5, i8 % 2 == 0);
                    i7++;
                }
                i5++;
            }
            int i9 = 0;
            for (int i10 = 0; i10 < iH; i10++) {
                if (i10 % symbolInfo.f91892d == 0) {
                    byteMatrix.g(i9, i5, true);
                    i9++;
                }
                byteMatrix.g(i9, i5, defaultPlacement.e(i10, i6));
                int i11 = i9 + 1;
                int i12 = symbolInfo.f91892d;
                if (i10 % i12 == i12 - 1) {
                    byteMatrix.g(i11, i5, i6 % 2 == 0);
                    i9 += 2;
                } else {
                    i9 = i11;
                }
            }
            int i13 = i5 + 1;
            int i14 = symbolInfo.f91893e;
            if (i6 % i14 == i14 - 1) {
                int i15 = 0;
                for (int i16 = 0; i16 < symbolInfo.j(); i16++) {
                    byteMatrix.g(i15, i13, true);
                    i15++;
                }
                i5 += 2;
            } else {
                i5 = i13;
            }
        }
        return b(byteMatrix, i3, i4);
    }

    @Override // com.google.zxing.Writer
    public BitMatrix a(String str, BarcodeFormat barcodeFormat, int i3, int i4, Map map) {
        Dimension dimension;
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        }
        if (barcodeFormat != BarcodeFormat.DATA_MATRIX) {
            throw new IllegalArgumentException("Can only encode DATA_MATRIX, but got ".concat(String.valueOf(barcodeFormat)));
        }
        if (i3 < 0 || i4 < 0) {
            throw new IllegalArgumentException("Requested dimensions can't be negative: " + i3 + 'x' + i4);
        }
        SymbolShapeHint symbolShapeHint = SymbolShapeHint.FORCE_NONE;
        Dimension dimension2 = null;
        if (map != null) {
            SymbolShapeHint symbolShapeHint2 = (SymbolShapeHint) map.get(EncodeHintType.DATA_MATRIX_SHAPE);
            if (symbolShapeHint2 != null) {
                symbolShapeHint = symbolShapeHint2;
            }
            Dimension dimension3 = (Dimension) map.get(EncodeHintType.MIN_SIZE);
            if (dimension3 == null) {
                dimension3 = null;
            }
            dimension = (Dimension) map.get(EncodeHintType.MAX_SIZE);
            if (dimension == null) {
                dimension = null;
            }
            dimension2 = dimension3;
        } else {
            dimension = null;
        }
        String strB = HighLevelEncoder.b(str, symbolShapeHint, dimension2, dimension);
        SymbolInfo symbolInfoL = SymbolInfo.l(strB.length(), symbolShapeHint, dimension2, dimension, true);
        DefaultPlacement defaultPlacement = new DefaultPlacement(ErrorCorrection.c(strB, symbolInfoL), symbolInfoL.h(), symbolInfoL.g());
        defaultPlacement.h();
        return c(defaultPlacement, symbolInfoL, i3, i4);
    }
}
