package com.google.zxing.oned;

import com.facebook.appevents.AppEventsConstants;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.Writer;
import com.google.zxing.common.BitMatrix;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class UPCAWriter implements Writer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final EAN13Writer f91933a = new EAN13Writer();

    @Override // com.google.zxing.Writer
    public BitMatrix a(String str, BarcodeFormat barcodeFormat, int i3, int i4, Map map) {
        if (barcodeFormat == BarcodeFormat.UPC_A) {
            return this.f91933a.a(AppEventsConstants.EVENT_PARAM_VALUE_NO.concat(String.valueOf(str)), BarcodeFormat.EAN_13, i3, i4, map);
        }
        throw new IllegalArgumentException("Can only encode UPC-A, but got ".concat(String.valueOf(barcodeFormat)));
    }
}
