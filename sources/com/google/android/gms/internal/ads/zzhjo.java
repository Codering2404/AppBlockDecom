package com.google.android.gms.internal.ads;

import java.security.InvalidKeyException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhjo extends zzhjp {
    public zzhjo(byte[] bArr, int i3) throws InvalidKeyException {
        super(bArr, i3);
    }

    @Override // com.google.android.gms.internal.ads.zzhjp
    public final int[] zza(int[] iArr, int i3) {
        int length = iArr.length;
        if (length != 3) {
            throw new IllegalArgumentException(String.format("ChaCha20 uses 96-bit nonces, but got a %d-bit nonce", Integer.valueOf(length * 32)));
        }
        int[] iArr2 = new int[16];
        zzhjn.zza(iArr2, this.zza);
        iArr2[12] = i3;
        System.arraycopy(iArr, 0, iArr2, 13, 3);
        return iArr2;
    }

    @Override // com.google.android.gms.internal.ads.zzhjp
    public final int zzb() {
        return 12;
    }
}
