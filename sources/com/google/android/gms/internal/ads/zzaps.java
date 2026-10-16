package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzaps implements zzapt {
    private final List zza;
    private final zzahk[] zzc;
    private boolean zzd;
    private int zze;
    private int zzf;
    private final String zzb = "video/mp2t";
    private long zzg = -9223372036854775807L;

    public zzaps(List list, String str) {
        this.zza = list;
        this.zzc = new zzahk[list.size()];
    }

    private final boolean zzf(zzet zzetVar, int i3) {
        if (zzetVar.zzd() == 0) {
            return false;
        }
        if (zzetVar.zzs() != i3) {
            this.zzd = false;
        }
        this.zze--;
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzapt
    public final void zza() {
        this.zzd = false;
        this.zzg = -9223372036854775807L;
    }

    @Override // com.google.android.gms.internal.ads.zzapt
    public final void zzb(zzagb zzagbVar, zzarh zzarhVar) {
        int i3 = 0;
        while (true) {
            zzahk[] zzahkVarArr = this.zzc;
            if (i3 >= zzahkVarArr.length) {
                return;
            }
            zzare zzareVar = (zzare) this.zza.get(i3);
            zzarhVar.zza();
            zzahk zzahkVarZzu = zzagbVar.zzu(zzarhVar.zzb(), 3);
            zzt zztVar = new zzt();
            zztVar.zza(zzarhVar.zzc());
            zztVar.zzn(this.zzb);
            zztVar.zzo("application/dvbsubs");
            zztVar.zzr(Collections.singletonList(zzareVar.zzb));
            zztVar.zze(zzareVar.zza);
            zzahkVarZzu.zzA(zztVar.zzO());
            zzahkVarArr[i3] = zzahkVarZzu;
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzapt
    public final void zzc(long j3, int i3) {
        if ((i3 & 4) == 0) {
            return;
        }
        this.zzd = true;
        this.zzg = j3;
        this.zzf = 0;
        this.zze = 2;
    }

    @Override // com.google.android.gms.internal.ads.zzapt
    public final void zzd(zzet zzetVar) {
        if (this.zzd) {
            if (this.zze != 2 || zzf(zzetVar, 32)) {
                if (this.zze != 1 || zzf(zzetVar, 0)) {
                    int iZzg = zzetVar.zzg();
                    int iZzd = zzetVar.zzd();
                    for (zzahk zzahkVar : this.zzc) {
                        zzetVar.zzh(iZzg);
                        zzahkVar.zzc(zzetVar, iZzd);
                    }
                    this.zzf += iZzd;
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzapt
    public final void zze(boolean z2) {
        if (this.zzd) {
            zzgtj.zzi(this.zzg != -9223372036854775807L);
            for (zzahk zzahkVar : this.zzc) {
                zzahkVar.zze(this.zzg, 1, this.zzf, 0, null);
            }
            this.zzd = false;
        }
    }
}
