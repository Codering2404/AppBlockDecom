package com.google.zxing.pdf417.encoder;

import java.lang.reflect.Array;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class BarcodeMatrix {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final BarcodeRow[] f92008a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f92009b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f92010c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f92011d;

    BarcodeMatrix(int i3, int i4) {
        BarcodeRow[] barcodeRowArr = new BarcodeRow[i3];
        this.f92008a = barcodeRowArr;
        int length = barcodeRowArr.length;
        for (int i5 = 0; i5 < length; i5++) {
            this.f92008a[i5] = new BarcodeRow(((i4 + 4) * 17) + 1);
        }
        this.f92011d = i4 * 17;
        this.f92010c = i3;
        this.f92009b = -1;
    }

    BarcodeRow a() {
        return this.f92008a[this.f92009b];
    }

    public byte[][] b(int i3, int i4) {
        byte[][] bArr = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, this.f92010c * i4, this.f92011d * i3);
        int i5 = this.f92010c * i4;
        for (int i6 = 0; i6 < i5; i6++) {
            bArr[(i5 - i6) - 1] = this.f92008a[i6 / i4].b(i3);
        }
        return bArr;
    }

    void c() {
        this.f92009b++;
    }
}
