package com.google.zxing;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class LuminanceSource {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f91608a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f91609b;

    public final int a() {
        return this.f91609b;
    }

    public abstract byte[] b();

    public abstract byte[] c(int i3, byte[] bArr);

    public final int d() {
        return this.f91608a;
    }

    public final String toString() {
        int i3 = this.f91608a;
        byte[] bArrC = new byte[i3];
        StringBuilder sb = new StringBuilder(this.f91609b * (i3 + 1));
        for (int i4 = 0; i4 < this.f91609b; i4++) {
            bArrC = c(i4, bArrC);
            for (int i5 = 0; i5 < this.f91608a; i5++) {
                int i6 = bArrC[i5] & 255;
                sb.append(i6 < 64 ? '#' : i6 < 128 ? '+' : i6 < 192 ? '.' : ' ');
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}
