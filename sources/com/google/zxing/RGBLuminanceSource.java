package com.google.zxing;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class RGBLuminanceSource extends LuminanceSource {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final byte[] f91617c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f91618d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f91619e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f91620f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f91621g;

    @Override // com.google.zxing.LuminanceSource
    public byte[] b() {
        int iD = d();
        int iA = a();
        int i3 = this.f91618d;
        if (iD == i3 && iA == this.f91619e) {
            return this.f91617c;
        }
        int i4 = iD * iA;
        byte[] bArr = new byte[i4];
        int i5 = (this.f91621g * i3) + this.f91620f;
        if (iD == i3) {
            System.arraycopy(this.f91617c, i5, bArr, 0, i4);
            return bArr;
        }
        for (int i6 = 0; i6 < iA; i6++) {
            System.arraycopy(this.f91617c, i5, bArr, i6 * iD, iD);
            i5 += this.f91618d;
        }
        return bArr;
    }

    @Override // com.google.zxing.LuminanceSource
    public byte[] c(int i3, byte[] bArr) {
        if (i3 < 0 || i3 >= a()) {
            throw new IllegalArgumentException("Requested row is outside the image: ".concat(String.valueOf(i3)));
        }
        int iD = d();
        if (bArr == null || bArr.length < iD) {
            bArr = new byte[iD];
        }
        System.arraycopy(this.f91617c, ((i3 + this.f91621g) * this.f91618d) + this.f91620f, bArr, 0, iD);
        return bArr;
    }
}
