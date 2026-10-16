package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzahd implements zzafy {
    private final int zza;
    private final int zzb;
    private final String zzc;
    private int zzd;
    private int zze;
    private zzagb zzf;
    private zzahk zzg;

    public zzahd(int i3, int i4, String str) {
        this.zza = i3;
        this.zzb = i4;
        this.zzc = str;
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final boolean zza(zzafz zzafzVar) throws IOException {
        int i3 = this.zza;
        zzgtj.zzi((i3 == -1 || this.zzb == -1) ? false : true);
        int i4 = this.zzb;
        zzet zzetVar = new zzet(i4);
        ((zzafp) zzafzVar).zzh(zzetVar.zzi(), 0, i4, false);
        return zzetVar.zzt() == i3;
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final void zzc(zzagb zzagbVar) {
        this.zzf = zzagbVar;
        zzahk zzahkVarZzu = zzagbVar.zzu(1024, 4);
        this.zzg = zzahkVarZzu;
        zzt zztVar = new zzt();
        String str = this.zzc;
        zztVar.zzn(str);
        zztVar.zzo(str);
        zzahkVarZzu.zzA(zztVar.zzO());
        this.zzf.zzv();
        this.zzf.zzw(new zzahe(-9223372036854775807L));
        this.zze = 1;
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final int zzd(zzafz zzafzVar, zzagy zzagyVar) throws IOException {
        int i3 = this.zze;
        if (i3 != 1) {
            if (i3 == 2) {
                return -1;
            }
            throw new IllegalStateException();
        }
        zzahk zzahkVar = this.zzg;
        zzahkVar.getClass();
        int iZza = zzahkVar.zza(zzafzVar, 1024, true);
        if (iZza == -1) {
            this.zze = 2;
            this.zzg.zze(0L, 1, this.zzd, 0, null);
            this.zzd = 0;
        } else {
            this.zzd += iZza;
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final void zze(long j3, long j4) {
        if (j3 == 0 || this.zze == 1) {
            this.zze = 1;
            this.zzd = 0;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final void zzf() {
    }
}
