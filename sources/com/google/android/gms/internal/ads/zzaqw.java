package com.google.android.gms.internal.ads;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzaqw {
    private final List zza;
    private final zzahk[] zzc;
    private final String zzb = "video/mp2t";
    private final zzgz zzd = new zzgz(new zzgy() { // from class: com.google.android.gms.internal.ads.zzaqv
        @Override // com.google.android.gms.internal.ads.zzgy
        public final /* synthetic */ void zza(long j3, zzet zzetVar) {
            this.zza.zzf(j3, zzetVar);
        }
    });

    public zzaqw(List list, String str) {
        this.zza = list;
        this.zzc = new zzahk[list.size()];
    }

    public final void zza(zzagb zzagbVar, zzarh zzarhVar) {
        int i3 = 0;
        while (true) {
            zzahk[] zzahkVarArr = this.zzc;
            if (i3 >= zzahkVarArr.length) {
                return;
            }
            zzarhVar.zza();
            zzahk zzahkVarZzu = zzagbVar.zzu(zzarhVar.zzb(), 3);
            zzv zzvVar = (zzv) this.zza.get(i3);
            String str = zzvVar.zzp;
            boolean z2 = true;
            if (!"application/cea-608".equals(str) && !"application/cea-708".equals(str)) {
                z2 = false;
            }
            zzgtj.zzf(z2, "Invalid closed caption MIME type provided: %s", str);
            String strZzc = zzvVar.zza;
            if (strZzc == null) {
                strZzc = zzarhVar.zzc();
            }
            zzt zztVar = new zzt();
            zztVar.zza(strZzc);
            zztVar.zzn(this.zzb);
            zztVar.zzo(str);
            zztVar.zzf(zzvVar.zze);
            zztVar.zze(zzvVar.zzd);
            zztVar.zzL(zzvVar.zzM);
            zztVar.zzr(zzvVar.zzs);
            zzahkVarZzu.zzA(zztVar.zzO());
            zzahkVarArr[i3] = zzahkVarZzu;
            i3++;
        }
    }

    public final void zzb(int i3) {
        this.zzd.zza(i3);
    }

    public final void zzc(long j3, zzet zzetVar) {
        this.zzd.zzc(j3, zzetVar);
    }

    public final void zzd() {
        this.zzd.zze();
    }

    public final void zze() {
        this.zzd.zze();
    }

    final /* synthetic */ void zzf(long j3, zzet zzetVar) {
        zzafl.zza(j3, zzetVar, this.zzc);
    }
}
