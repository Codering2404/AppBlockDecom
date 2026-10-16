package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhpm {
    public static byte[] zza(byte[] bArr) {
        if (bArr.length != 16) {
            throw new IllegalArgumentException("value must be a block.");
        }
        byte[] bArr2 = new byte[16];
        int i3 = 0;
        while (i3 < 16) {
            int i4 = i3 + 1;
            byte b3 = bArr[i3];
            byte b4 = (byte) ((b3 + b3) & 254);
            bArr2[i3] = b4;
            if (i3 < 15) {
                bArr2[i3] = (byte) (((bArr[i4] >> 7) & 1) | b4);
            }
            i3 = i4;
        }
        bArr2[15] = (byte) (((byte) ((bArr[0] >> 7) & 135)) ^ bArr2[15]);
        return bArr2;
    }
}
