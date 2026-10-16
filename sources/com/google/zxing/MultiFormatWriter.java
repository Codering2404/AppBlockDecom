package com.google.zxing;

import com.google.zxing.aztec.AztecWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.datamatrix.DataMatrixWriter;
import com.google.zxing.oned.CodaBarWriter;
import com.google.zxing.oned.Code128Writer;
import com.google.zxing.oned.Code39Writer;
import com.google.zxing.oned.Code93Writer;
import com.google.zxing.oned.EAN13Writer;
import com.google.zxing.oned.EAN8Writer;
import com.google.zxing.oned.ITFWriter;
import com.google.zxing.oned.UPCAWriter;
import com.google.zxing.oned.UPCEWriter;
import com.google.zxing.pdf417.PDF417Writer;
import com.google.zxing.qrcode.QRCodeWriter;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class MultiFormatWriter implements Writer {

    /* JADX INFO: renamed from: com.google.zxing.MultiFormatWriter$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f91610a;

        static {
            int[] iArr = new int[BarcodeFormat.values().length];
            f91610a = iArr;
            try {
                iArr[BarcodeFormat.EAN_8.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f91610a[BarcodeFormat.UPC_E.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f91610a[BarcodeFormat.EAN_13.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f91610a[BarcodeFormat.UPC_A.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f91610a[BarcodeFormat.QR_CODE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f91610a[BarcodeFormat.CODE_39.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f91610a[BarcodeFormat.CODE_93.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f91610a[BarcodeFormat.CODE_128.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f91610a[BarcodeFormat.ITF.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f91610a[BarcodeFormat.PDF_417.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f91610a[BarcodeFormat.CODABAR.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f91610a[BarcodeFormat.DATA_MATRIX.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f91610a[BarcodeFormat.AZTEC.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    @Override // com.google.zxing.Writer
    public BitMatrix a(String str, BarcodeFormat barcodeFormat, int i3, int i4, Map map) {
        Writer eAN8Writer;
        switch (AnonymousClass1.f91610a[barcodeFormat.ordinal()]) {
            case 1:
                eAN8Writer = new EAN8Writer();
                break;
            case 2:
                eAN8Writer = new UPCEWriter();
                break;
            case 3:
                eAN8Writer = new EAN13Writer();
                break;
            case 4:
                eAN8Writer = new UPCAWriter();
                break;
            case 5:
                eAN8Writer = new QRCodeWriter();
                break;
            case 6:
                eAN8Writer = new Code39Writer();
                break;
            case 7:
                eAN8Writer = new Code93Writer();
                break;
            case 8:
                eAN8Writer = new Code128Writer();
                break;
            case 9:
                eAN8Writer = new ITFWriter();
                break;
            case 10:
                eAN8Writer = new PDF417Writer();
                break;
            case 11:
                eAN8Writer = new CodaBarWriter();
                break;
            case 12:
                eAN8Writer = new DataMatrixWriter();
                break;
            case 13:
                eAN8Writer = new AztecWriter();
                break;
            default:
                throw new IllegalArgumentException("No encoder available for format ".concat(String.valueOf(barcodeFormat)));
        }
        return eAN8Writer.a(str, barcodeFormat, i3, i4, map);
    }
}
