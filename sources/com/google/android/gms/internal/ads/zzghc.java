package com.google.android.gms.internal.ads;

import com.sun.jna.Function;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzghc {
    private final byte[] zza = new byte[Function.MAX_NARGS];
    private int zzb;
    private int zzc;

    public zzghc(byte[] bArr) {
        for (int i3 = 0; i3 < 256; i3++) {
            this.zza[i3] = (byte) i3;
        }
        int i4 = 0;
        for (int i5 = 0; i5 < 256; i5++) {
            byte[] bArr2 = this.zza;
            byte b3 = bArr2[i5];
            i4 = (i4 + b3 + bArr[i5 % bArr.length]) & 255;
            bArr2[i5] = bArr2[i4];
            bArr2[i4] = b3;
        }
        this.zzb = 0;
        this.zzc = 0;
    }

    public final void zza(byte[] bArr) {
        int i3 = this.zzb;
        int i4 = this.zzc;
        for (int i5 = 0; i5 < 256; i5++) {
            byte[] bArr2 = this.zza;
            i3 = (i3 + 1) & 255;
            byte b3 = bArr2[i3];
            i4 = (i4 + b3) & 255;
            bArr2[i3] = bArr2[i4];
            bArr2[i4] = b3;
            bArr[i5] = (byte) (bArr2[(bArr2[i3] + b3) & 255] ^ bArr[i5]);
        }
        this.zzb = i3;
        this.zzc = i4;
    }
}
