package com.google.android.gms.internal.fido;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzgr extends zzgu {
    private final int zzc;
    private final int zzd;

    zzgr(byte[] bArr, int i3, int i4) {
        super(bArr);
        zzgx.zzj(i3, i3 + i4, bArr.length);
        this.zzc = i3;
        this.zzd = i4;
    }

    @Override // com.google.android.gms.internal.fido.zzgu, com.google.android.gms.internal.fido.zzgx
    public final byte zza(int i3) {
        int i4 = this.zzd;
        if (((i4 - (i3 + 1)) | i3) >= 0) {
            return this.zza[this.zzc + i3];
        }
        if (i3 < 0) {
            throw new ArrayIndexOutOfBoundsException("Index < 0: " + i3);
        }
        throw new ArrayIndexOutOfBoundsException("Index > length: " + i3 + ", " + i4);
    }

    @Override // com.google.android.gms.internal.fido.zzgu, com.google.android.gms.internal.fido.zzgx
    final byte zzb(int i3) {
        return this.zza[this.zzc + i3];
    }

    @Override // com.google.android.gms.internal.fido.zzgu
    protected final int zzc() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.fido.zzgu, com.google.android.gms.internal.fido.zzgx
    public final int zzd() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.fido.zzgu, com.google.android.gms.internal.fido.zzgx
    protected final void zze(byte[] bArr, int i3, int i4, int i5) {
        System.arraycopy(this.zza, this.zzc, bArr, 0, i5);
    }
}
