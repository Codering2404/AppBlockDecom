package com.google.android.gms.internal.auth;

import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
class zzec extends zzeb {
    protected final byte[] zza;

    zzec(byte[] bArr) {
        bArr.getClass();
        this.zza = bArr;
    }

    @Override // com.google.android.gms.internal.auth.zzef
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzef) || zzd() != ((zzef) obj).zzd()) {
            return false;
        }
        if (zzd() == 0) {
            return true;
        }
        if (!(obj instanceof zzec)) {
            return obj.equals(this);
        }
        zzec zzecVar = (zzec) obj;
        int iZzj = zzj();
        int iZzj2 = zzecVar.zzj();
        if (iZzj != 0 && iZzj2 != 0 && iZzj != iZzj2) {
            return false;
        }
        int iZzd = zzd();
        if (iZzd > zzecVar.zzd()) {
            throw new IllegalArgumentException("Length too large: " + iZzd + zzd());
        }
        if (iZzd > zzecVar.zzd()) {
            throw new IllegalArgumentException("Ran off end of other: 0, " + iZzd + ", " + zzecVar.zzd());
        }
        byte[] bArr = this.zza;
        byte[] bArr2 = zzecVar.zza;
        zzecVar.zzc();
        int i3 = 0;
        int i4 = 0;
        while (i3 < iZzd) {
            if (bArr[i3] != bArr2[i4]) {
                return false;
            }
            i3++;
            i4++;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.auth.zzef
    public byte zza(int i3) {
        return this.zza[i3];
    }

    @Override // com.google.android.gms.internal.auth.zzef
    byte zzb(int i3) {
        return this.zza[i3];
    }

    protected int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.auth.zzef
    public int zzd() {
        return this.zza.length;
    }

    @Override // com.google.android.gms.internal.auth.zzef
    protected final int zze(int i3, int i4, int i5) {
        return zzfa.zzb(i3, this.zza, 0, i5);
    }

    @Override // com.google.android.gms.internal.auth.zzef
    public final zzef zzf(int i3, int i4) {
        int iZzi = zzef.zzi(0, i4, zzd());
        return iZzi == 0 ? zzef.zzb : new zzdz(this.zza, 0, iZzi);
    }

    @Override // com.google.android.gms.internal.auth.zzef
    protected final String zzg(Charset charset) {
        return new String(this.zza, 0, zzd(), charset);
    }

    @Override // com.google.android.gms.internal.auth.zzef
    public final boolean zzh() {
        return zzhn.zzc(this.zza, 0, zzd());
    }
}
