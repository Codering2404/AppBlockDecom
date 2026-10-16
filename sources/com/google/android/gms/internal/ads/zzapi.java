package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzapi implements zzafy {
    private final zzapj zza = new zzapj(null, 0, "audio/ac3");
    private final zzet zzb = new zzet(2786);
    private boolean zzc;

    static {
        int i3 = zzaph.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final boolean zza(zzafz zzafzVar) throws IOException {
        zzet zzetVar = new zzet(10);
        int i3 = 0;
        while (true) {
            zzafp zzafpVar = (zzafp) zzafzVar;
            zzafpVar.zzh(zzetVar.zzi(), 0, 10, false);
            zzetVar.zzh(0);
            if (zzetVar.zzx() != 4801587) {
                break;
            }
            zzetVar.zzk(3);
            int iZzG = zzetVar.zzG();
            i3 += iZzG + 10;
            zzafpVar.zzj(iZzG, false);
        }
        zzafzVar.zzl();
        zzafp zzafpVar2 = (zzafp) zzafzVar;
        zzafpVar2.zzj(i3, false);
        int i4 = 0;
        int i5 = i3;
        while (true) {
            zzafpVar2.zzh(zzetVar.zzi(), 0, 6, false);
            zzetVar.zzh(0);
            if (zzetVar.zzt() != 2935) {
                zzafzVar.zzl();
                i5++;
                if (i5 - i3 >= 8192) {
                    return false;
                }
                zzafpVar2.zzj(i5, false);
                i4 = 0;
            } else {
                i4++;
                if (i4 >= 4) {
                    return true;
                }
                int iZzd = zzaey.zzd(zzetVar.zzi());
                if (iZzd == -1) {
                    return false;
                }
                zzafpVar2.zzj(iZzd - 6, false);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final void zzc(zzagb zzagbVar) {
        this.zza.zzb(zzagbVar, new zzarh(Integer.MIN_VALUE, 0, 1));
        zzagbVar.zzv();
        zzagbVar.zzw(new zzaha(-9223372036854775807L, 0L));
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final int zzd(zzafz zzafzVar, zzagy zzagyVar) throws IOException {
        zzet zzetVar = this.zzb;
        int iZza = zzafzVar.zza(zzetVar.zzi(), 0, 2786);
        if (iZza == -1) {
            return -1;
        }
        zzetVar.zzh(0);
        zzetVar.zzf(iZza);
        if (!this.zzc) {
            this.zza.zzc(0L, 4);
            this.zzc = true;
        }
        this.zza.zzd(zzetVar);
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final void zze(long j3, long j4) {
        this.zzc = false;
        this.zza.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final void zzf() {
    }
}
