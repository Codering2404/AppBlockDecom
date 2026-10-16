package com.google.zxing.pdf417.encoder;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class BarcodeRow {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f92012a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f92013b = 0;

    BarcodeRow(int i3) {
        this.f92012a = new byte[i3];
    }

    private void c(int i3, boolean z2) {
        this.f92012a[i3] = z2 ? (byte) 1 : (byte) 0;
    }

    void a(boolean z2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = this.f92013b;
            this.f92013b = i5 + 1;
            c(i5, z2);
        }
    }

    byte[] b(int i3) {
        int length = this.f92012a.length * i3;
        byte[] bArr = new byte[length];
        for (int i4 = 0; i4 < length; i4++) {
            bArr[i4] = this.f92012a[i4 / i3];
        }
        return bArr;
    }
}
