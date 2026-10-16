package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzaqd implements zzapt {
    private zzahk zzc;
    private boolean zzd;
    private int zzf;
    private int zzg;
    private final String zza = "video/mp2t";
    private final zzet zzb = new zzet(10);
    private long zze = -9223372036854775807L;

    public zzaqd(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzapt
    public final void zza() {
        this.zzd = false;
        this.zze = -9223372036854775807L;
    }

    @Override // com.google.android.gms.internal.ads.zzapt
    public final void zzb(zzagb zzagbVar, zzarh zzarhVar) {
        zzarhVar.zza();
        zzahk zzahkVarZzu = zzagbVar.zzu(zzarhVar.zzb(), 5);
        this.zzc = zzahkVarZzu;
        zzt zztVar = new zzt();
        zztVar.zza(zzarhVar.zzc());
        zztVar.zzn(this.zza);
        zztVar.zzo("application/id3");
        zzahkVarZzu.zzA(zztVar.zzO());
    }

    @Override // com.google.android.gms.internal.ads.zzapt
    public final void zzc(long j3, int i3) {
        if ((i3 & 4) == 0) {
            return;
        }
        this.zzd = true;
        this.zze = j3;
        this.zzf = 0;
        this.zzg = 0;
    }

    @Override // com.google.android.gms.internal.ads.zzapt
    public final void zzd(zzet zzetVar) {
        this.zzc.getClass();
        if (this.zzd) {
            int iZzd = zzetVar.zzd();
            int i3 = this.zzg;
            if (i3 < 10) {
                int iMin = Math.min(iZzd, 10 - i3);
                byte[] bArrZzi = zzetVar.zzi();
                int iZzg = zzetVar.zzg();
                zzet zzetVar2 = this.zzb;
                System.arraycopy(bArrZzi, iZzg, zzetVar2.zzi(), this.zzg, iMin);
                if (this.zzg + iMin == 10) {
                    zzetVar2.zzh(0);
                    if (zzetVar2.zzs() != 73 || zzetVar2.zzs() != 68 || zzetVar2.zzs() != 51) {
                        zzeg.zzc("Id3Reader", "Discarding invalid ID3 tag");
                        this.zzd = false;
                        return;
                    } else {
                        zzetVar2.zzk(3);
                        this.zzf = zzetVar2.zzG() + 10;
                    }
                }
            }
            int iMin2 = Math.min(iZzd, this.zzf - this.zzg);
            this.zzc.zzc(zzetVar, iMin2);
            this.zzg += iMin2;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzapt
    public final void zze(boolean z2) {
        int i3;
        this.zzc.getClass();
        if (this.zzd && (i3 = this.zzf) != 0 && this.zzg == i3) {
            zzgtj.zzi(this.zze != -9223372036854775807L);
            this.zzc.zze(this.zze, 1, this.zzf, 0, null);
            this.zzd = false;
        }
    }
}
