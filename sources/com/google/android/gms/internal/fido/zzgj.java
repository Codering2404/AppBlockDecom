package com.google.android.gms.internal.fido;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgj {
    public static byte[] zza(byte[]... bArr) {
        int i3 = 0;
        int length = 0;
        while (true) {
            if (i3 >= bArr.length) {
                break;
            }
            length += bArr[i3].length;
            i3++;
        }
        byte[] bArr2 = new byte[length];
        int i4 = 0;
        for (byte[] bArr3 : bArr) {
            int length2 = bArr3.length;
            System.arraycopy(bArr3, 0, bArr2, i4, length2);
            i4 += length2;
        }
        return bArr2;
    }
}
