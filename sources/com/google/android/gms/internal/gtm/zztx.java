package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zztx extends zzua {
    private final int zzc;

    zztx(byte[] bArr, int i3, int i4) {
        super(bArr);
        zzud.zzj(0, i4, bArr.length);
        this.zzc = i4;
    }

    @Override // com.google.android.gms.internal.gtm.zzua, com.google.android.gms.internal.gtm.zzud
    public final byte zza(int i3) {
        int i4 = this.zzc;
        if (((i4 - (i3 + 1)) | i3) >= 0) {
            return this.zza[i3];
        }
        if (i3 < 0) {
            throw new ArrayIndexOutOfBoundsException("Index < 0: " + i3);
        }
        throw new ArrayIndexOutOfBoundsException("Index > length: " + i3 + ", " + i4);
    }

    @Override // com.google.android.gms.internal.gtm.zzua, com.google.android.gms.internal.gtm.zzud
    final byte zzb(int i3) {
        return this.zza[i3];
    }

    @Override // com.google.android.gms.internal.gtm.zzua
    protected final int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.gtm.zzua, com.google.android.gms.internal.gtm.zzud
    public final int zzd() {
        return this.zzc;
    }
}
