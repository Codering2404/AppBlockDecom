package com.google.android.gms.internal.ads;

import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzalq {
    public final zzahk zza;
    public zzaml zzd;
    public zzalk zze;
    public int zzf;
    public int zzg;
    public int zzh;
    public int zzi;
    private final zzv zzj;
    private boolean zzm;
    public final zzamk zzb = new zzamk();
    public final zzet zzc = new zzet();
    private final zzet zzk = new zzet(1);
    private final zzet zzl = new zzet();

    public zzalq(zzahk zzahkVar, zzaml zzamlVar, zzalk zzalkVar, zzv zzvVar) {
        this.zza = zzahkVar;
        this.zzd = zzamlVar;
        this.zze = zzalkVar;
        this.zzj = zzvVar;
        zza(zzamlVar, zzalkVar);
    }

    public final void zza(zzaml zzamlVar, zzalk zzalkVar) {
        this.zzd = zzamlVar;
        this.zze = zzalkVar;
        this.zza.zzA(this.zzj);
        zzc();
    }

    public final void zzb(zzq zzqVar) {
        zzami zzamiVar = this.zzd.zza;
        zzalk zzalkVar = this.zzb.zza;
        String str = zzfl.zza;
        zzamj zzamjVarZza = zzamiVar.zza(zzalkVar.zza);
        zzq zzqVarZzb = zzqVar.zzb(zzamjVarZza != null ? zzamjVarZza.zzb : null);
        zzt zztVarZza = this.zzj.zza();
        zztVarZza.zzs(zzqVarZzb);
        this.zza.zzA(zztVarZza.zzO());
    }

    public final void zzc() {
        zzamk zzamkVar = this.zzb;
        zzamkVar.zzd = 0;
        zzamkVar.zzp = 0L;
        zzamkVar.zzq = false;
        zzamkVar.zzk = false;
        zzamkVar.zzo = false;
        zzamkVar.zzm = null;
        this.zzf = 0;
        this.zzh = 0;
        this.zzg = 0;
        this.zzi = 0;
        this.zzm = false;
    }

    public final long zzd() {
        if (!this.zzm) {
            return this.zzd.zzf[this.zzf];
        }
        zzamk zzamkVar = this.zzb;
        return zzamkVar.zzi[this.zzf];
    }

    public final long zze() {
        return !this.zzm ? this.zzd.zzc[this.zzf] : this.zzb.zzf[this.zzh];
    }

    public final int zzf() {
        return !this.zzm ? this.zzd.zzd[this.zzf] : this.zzb.zzh[this.zzf];
    }

    public final int zzg() {
        int i3 = !this.zzm ? this.zzd.zzg[this.zzf] : this.zzb.zzj[this.zzf] ? 1 : 0;
        return zzj() != null ? i3 | 1073741824 : i3;
    }

    public final boolean zzh() {
        this.zzf++;
        if (!this.zzm) {
            return false;
        }
        int i3 = this.zzg + 1;
        this.zzg = i3;
        int[] iArr = this.zzb.zzg;
        int i4 = this.zzh;
        if (i3 != iArr[i4]) {
            return true;
        }
        this.zzh = i4 + 1;
        this.zzg = 0;
        return false;
    }

    public final int zzi(int i3, int i4) {
        zzet zzetVar;
        zzamj zzamjVarZzj = zzj();
        if (zzamjVarZzj == null) {
            return 0;
        }
        int i5 = zzamjVarZzj.zzd;
        if (i5 != 0) {
            zzetVar = this.zzb.zzn;
        } else {
            byte[] bArr = zzamjVarZzj.zze;
            String str = zzfl.zza;
            zzet zzetVar2 = this.zzl;
            int length = bArr.length;
            zzetVar2.zzb(bArr, length);
            zzetVar = zzetVar2;
            i5 = length;
        }
        zzamk zzamkVar = this.zzb;
        boolean zZzb = zzamkVar.zzb(this.zzf);
        boolean z2 = zZzb || i4 != 0;
        zzet zzetVar3 = this.zzk;
        zzetVar3.zzi()[0] = (byte) ((true != z2 ? 0 : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) | i5);
        zzetVar3.zzh(0);
        zzahk zzahkVar = this.zza;
        zzahkVar.zzd(zzetVar3, 1, 1);
        zzahkVar.zzd(zzetVar, i5, 1);
        if (!z2) {
            return i5 + 1;
        }
        if (!zZzb) {
            zzet zzetVar4 = this.zzc;
            zzetVar4.zza(8);
            byte[] bArrZzi = zzetVar4.zzi();
            bArrZzi[0] = 0;
            bArrZzi[1] = 1;
            bArrZzi[2] = 0;
            bArrZzi[3] = (byte) i4;
            bArrZzi[4] = (byte) ((i3 >> 24) & 255);
            bArrZzi[5] = (byte) ((i3 >> 16) & 255);
            bArrZzi[6] = (byte) ((i3 >> 8) & 255);
            bArrZzi[7] = (byte) (i3 & 255);
            zzahkVar.zzd(zzetVar4, 8, 1);
            return i5 + 9;
        }
        int i6 = i5 + 1;
        zzet zzetVar5 = zzamkVar.zzn;
        int iZzt = zzetVar5.zzt();
        zzetVar5.zzk(-2);
        int i7 = (iZzt * 6) + 2;
        if (i4 != 0) {
            zzet zzetVar6 = this.zzc;
            zzetVar6.zza(i7);
            byte[] bArrZzi2 = zzetVar6.zzi();
            zzetVar5.zzm(bArrZzi2, 0, i7);
            int i8 = (((bArrZzi2[2] & 255) << 8) | (bArrZzi2[3] & 255)) + i4;
            bArrZzi2[2] = (byte) ((i8 >> 8) & 255);
            bArrZzi2[3] = (byte) (i8 & 255);
            zzetVar5 = zzetVar6;
        }
        zzahkVar.zzd(zzetVar5, i7, 1);
        return i6 + i7;
    }

    public final zzamj zzj() {
        if (!this.zzm) {
            return null;
        }
        zzamk zzamkVar = this.zzb;
        zzalk zzalkVar = zzamkVar.zza;
        String str = zzfl.zza;
        int i3 = zzalkVar.zza;
        zzamj zzamjVarZza = zzamkVar.zzm;
        if (zzamjVarZza == null) {
            zzamjVarZza = this.zzd.zza.zza(i3);
        }
        if (zzamjVarZza == null || !zzamjVarZza.zza) {
            return null;
        }
        return zzamjVarZza;
    }

    final /* synthetic */ boolean zzk() {
        return this.zzm;
    }

    final /* synthetic */ void zzl(boolean z2) {
        this.zzm = true;
    }
}
