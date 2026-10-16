package com.google.android.gms.internal.ads;

import java.security.InvalidKeyException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhjs extends zzhjp {
    public zzhjs(byte[] bArr, int i3) throws InvalidKeyException {
        super(bArr, i3);
    }

    @Override // com.google.android.gms.internal.ads.zzhjp
    final int[] zza(int[] iArr, int i3) {
        int length = iArr.length;
        if (length != 6) {
            throw new IllegalArgumentException(String.format("XChaCha20 uses 192-bit nonces, but got a %d-bit nonce", Integer.valueOf(length * 32)));
        }
        int[] iArr2 = new int[16];
        zzhjn.zza(iArr2, zzhjn.zze(this.zza, iArr));
        iArr2[12] = i3;
        iArr2[13] = 0;
        iArr2[14] = iArr[4];
        iArr2[15] = iArr[5];
        return iArr2;
    }

    @Override // com.google.android.gms.internal.ads.zzhjp
    final int zzb() {
        return 24;
    }
}
