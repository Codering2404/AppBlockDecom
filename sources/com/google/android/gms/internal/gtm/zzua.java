package com.google.android.gms.internal.gtm;

import java.io.IOException;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
class zzua extends zztz {
    protected final byte[] zza;

    zzua(byte[] bArr) {
        bArr.getClass();
        this.zza = bArr;
    }

    @Override // com.google.android.gms.internal.gtm.zzud
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzud) || zzd() != ((zzud) obj).zzd()) {
            return false;
        }
        if (zzd() == 0) {
            return true;
        }
        if (!(obj instanceof zzua)) {
            return obj.equals(this);
        }
        zzua zzuaVar = (zzua) obj;
        int iZzk = zzk();
        int iZzk2 = zzuaVar.zzk();
        if (iZzk != 0 && iZzk2 != 0 && iZzk != iZzk2) {
            return false;
        }
        int iZzd = zzd();
        if (iZzd > zzuaVar.zzd()) {
            throw new IllegalArgumentException("Length too large: " + iZzd + zzd());
        }
        if (iZzd > zzuaVar.zzd()) {
            throw new IllegalArgumentException("Ran off end of other: 0, " + iZzd + ", " + zzuaVar.zzd());
        }
        byte[] bArr = this.zza;
        byte[] bArr2 = zzuaVar.zza;
        zzuaVar.zzc();
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

    @Override // com.google.android.gms.internal.gtm.zzud
    public byte zza(int i3) {
        return this.zza[i3];
    }

    @Override // com.google.android.gms.internal.gtm.zzud
    byte zzb(int i3) {
        return this.zza[i3];
    }

    protected int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.gtm.zzud
    public int zzd() {
        return this.zza.length;
    }

    @Override // com.google.android.gms.internal.gtm.zzud
    protected final int zze(int i3, int i4, int i5) {
        return zzye.zzb(i3, this.zza, 0, i5);
    }

    @Override // com.google.android.gms.internal.gtm.zzud
    public final zzud zzf(int i3, int i4) {
        int iZzj = zzud.zzj(0, i4, zzd());
        return iZzj == 0 ? zzud.zzb : new zztx(this.zza, 0, iZzj);
    }

    @Override // com.google.android.gms.internal.gtm.zzud
    protected final String zzg(Charset charset) {
        return new String(this.zza, 0, zzd(), charset);
    }

    @Override // com.google.android.gms.internal.gtm.zzud
    final void zzh(zztt zzttVar) throws IOException {
        zzttVar.zza(this.zza, 0, zzd());
    }

    @Override // com.google.android.gms.internal.gtm.zzud
    public final boolean zzi() {
        return zzaaz.zzf(this.zza, 0, zzd());
    }
}
