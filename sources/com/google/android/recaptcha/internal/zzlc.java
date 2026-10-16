package com.google.android.recaptcha.internal;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class zzlc extends zzlb {
    protected final byte[] zza;

    zzlc(byte[] bArr) {
        super(null);
        bArr.getClass();
        this.zza = bArr;
    }

    @Override // com.google.android.recaptcha.internal.zzle
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzle) || zzd() != ((zzle) obj).zzd()) {
            return false;
        }
        if (zzd() == 0) {
            return true;
        }
        if (!(obj instanceof zzlc)) {
            return obj.equals(this);
        }
        zzlc zzlcVar = (zzlc) obj;
        int iZzj = zzj();
        int iZzj2 = zzlcVar.zzj();
        if (iZzj != 0 && iZzj2 != 0 && iZzj != iZzj2) {
            return false;
        }
        int iZzd = zzd();
        if (iZzd > zzlcVar.zzd()) {
            throw new IllegalArgumentException("Length too large: " + iZzd + zzd());
        }
        if (iZzd > zzlcVar.zzd()) {
            throw new IllegalArgumentException("Ran off end of other: 0, " + iZzd + ", " + zzlcVar.zzd());
        }
        byte[] bArr = this.zza;
        byte[] bArr2 = zzlcVar.zza;
        zzlcVar.zzc();
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

    @Override // com.google.android.recaptcha.internal.zzle
    public byte zza(int i3) {
        return this.zza[i3];
    }

    @Override // com.google.android.recaptcha.internal.zzle
    byte zzb(int i3) {
        return this.zza[i3];
    }

    protected int zzc() {
        return 0;
    }

    @Override // com.google.android.recaptcha.internal.zzle
    public int zzd() {
        return this.zza.length;
    }

    @Override // com.google.android.recaptcha.internal.zzle
    protected void zze(byte[] bArr, int i3, int i4, int i5) {
        System.arraycopy(this.zza, 0, bArr, 0, i5);
    }

    @Override // com.google.android.recaptcha.internal.zzle
    protected final int zzf(int i3, int i4, int i5) {
        return zznl.zzb(i3, this.zza, 0, i5);
    }

    @Override // com.google.android.recaptcha.internal.zzle
    public final zzle zzg(int i3, int i4) {
        int iZzi = zzle.zzi(0, i4, zzd());
        return iZzi == 0 ? zzle.zzb : new zzkz(this.zza, 0, iZzi);
    }

    @Override // com.google.android.recaptcha.internal.zzle
    final void zzh(zzkw zzkwVar) throws IOException {
        ((zzlk) zzkwVar).zzc(this.zza, 0, zzd());
    }
}
