package com.google.zxing;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class InvertedLuminanceSource extends LuminanceSource {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final LuminanceSource f91607c;

    @Override // com.google.zxing.LuminanceSource
    public byte[] b() {
        byte[] bArrB = this.f91607c.b();
        int iD = d() * a();
        byte[] bArr = new byte[iD];
        for (int i3 = 0; i3 < iD; i3++) {
            bArr[i3] = (byte) (255 - (bArrB[i3] & 255));
        }
        return bArr;
    }

    @Override // com.google.zxing.LuminanceSource
    public byte[] c(int i3, byte[] bArr) {
        byte[] bArrC = this.f91607c.c(i3, bArr);
        int iD = d();
        for (int i4 = 0; i4 < iD; i4++) {
            bArrC[i4] = (byte) (255 - (bArrC[i4] & 255));
        }
        return bArrC;
    }
}
