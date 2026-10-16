package com.google.zxing.multi.qrcode;

import com.google.zxing.Result;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.ResultPoint;
import com.google.zxing.multi.MultipleBarcodeReader;
import com.google.zxing.qrcode.QRCodeReader;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class QRCodeMultiReader extends QRCodeReader implements MultipleBarcodeReader {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Result[] f91904b = new Result[0];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ResultPoint[] f91905c = new ResultPoint[0];

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class SAComparator implements Serializable, Comparator<Result> {
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Result result, Result result2) {
            Map mapA = result.a();
            ResultMetadataType resultMetadataType = ResultMetadataType.STRUCTURED_APPEND_SEQUENCE;
            return Integer.compare(((Integer) mapA.get(resultMetadataType)).intValue(), ((Integer) result2.a().get(resultMetadataType)).intValue());
        }
    }
}
