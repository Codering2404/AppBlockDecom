package com.google.android.gms.internal.fido;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
class zzgu extends zzgt {
    protected final byte[] zza;

    zzgu(byte[] bArr) {
        bArr.getClass();
        this.zza = bArr;
    }

    @Override // com.google.android.gms.internal.fido.zzgx
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzgx) || zzd() != ((zzgx) obj).zzd()) {
            return false;
        }
        if (zzd() == 0) {
            return true;
        }
        if (!(obj instanceof zzgu)) {
            return obj.equals(this);
        }
        zzgu zzguVar = (zzgu) obj;
        int iZzk = zzk();
        int iZzk2 = zzguVar.zzk();
        if (iZzk != 0 && iZzk2 != 0 && iZzk != iZzk2) {
            return false;
        }
        int iZzd = zzd();
        if (iZzd > zzguVar.zzd()) {
            throw new IllegalArgumentException("Length too large: " + iZzd + zzd());
        }
        if (iZzd > zzguVar.zzd()) {
            throw new IllegalArgumentException("Ran off end of other: 0, " + iZzd + ", " + zzguVar.zzd());
        }
        byte[] bArr = this.zza;
        byte[] bArr2 = zzguVar.zza;
        int iZzc = zzc() + iZzd;
        int iZzc2 = zzc();
        int iZzc3 = zzguVar.zzc();
        while (iZzc2 < iZzc) {
            if (bArr[iZzc2] != bArr2[iZzc3]) {
                return false;
            }
            iZzc2++;
            iZzc3++;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.fido.zzgx
    public byte zza(int i3) {
        return this.zza[i3];
    }

    @Override // com.google.android.gms.internal.fido.zzgx
    byte zzb(int i3) {
        return this.zza[i3];
    }

    protected int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.fido.zzgx
    public int zzd() {
        return this.zza.length;
    }

    @Override // com.google.android.gms.internal.fido.zzgx
    protected void zze(byte[] bArr, int i3, int i4, int i5) {
        System.arraycopy(this.zza, 0, bArr, 0, i5);
    }

    @Override // com.google.android.gms.internal.fido.zzgx
    protected final int zzf(int i3, int i4, int i5) {
        int iZzc = zzc();
        byte[] bArr = zzhc.zzd;
        for (int i6 = iZzc; i6 < iZzc + i5; i6++) {
            i3 = (i3 * 31) + this.zza[i6];
        }
        return i3;
    }

    @Override // com.google.android.gms.internal.fido.zzgx
    public final zzgx zzg(int i3, int i4) {
        int iZzj = zzgx.zzj(i3, i4, zzd());
        return iZzj == 0 ? zzgx.zzb : new zzgr(this.zza, zzc() + i3, iZzj);
    }

    @Override // com.google.android.gms.internal.fido.zzgx
    public final InputStream zzh() {
        return new ByteArrayInputStream(this.zza, zzc(), zzd());
    }

    @Override // com.google.android.gms.internal.fido.zzgx
    public final ByteBuffer zzi() {
        return ByteBuffer.wrap(this.zza, zzc(), zzd()).asReadOnlyBuffer();
    }
}
