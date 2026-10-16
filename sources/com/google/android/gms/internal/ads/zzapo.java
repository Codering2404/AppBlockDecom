package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzapo implements zzafy {
    private final zzapp zza;
    private final zzet zzb;
    private final zzet zzc;
    private final zzes zzd;
    private zzagb zze;
    private long zzf;
    private long zzg;
    private boolean zzh;
    private boolean zzi;

    static {
        int i3 = zzapn.zza;
    }

    public zzapo() {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final boolean zza(zzafz zzafzVar) throws IOException {
        zzet zzetVar;
        int i3 = 0;
        while (true) {
            zzetVar = this.zzc;
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
        if (this.zzg == -1) {
            this.zzg = i3;
        }
        int i4 = 0;
        int i5 = 0;
        int i6 = i3;
        do {
            zzafpVar2.zzh(zzetVar.zzi(), 0, 2, false);
            zzetVar.zzh(0);
            if (zzapp.zzf(zzetVar.zzt())) {
                i4++;
                if (i4 >= 4 && i5 > 188) {
                    return true;
                }
                zzafpVar2.zzh(zzetVar.zzi(), 0, 4, false);
                zzes zzesVar = this.zzd;
                zzesVar.zzf(14);
                int iZzj = zzesVar.zzj(13);
                if (iZzj <= 6) {
                    i6++;
                    zzafzVar.zzl();
                    zzafpVar2.zzj(i6, false);
                } else {
                    zzafpVar2.zzj(iZzj - 6, false);
                    i5 += iZzj;
                }
            } else {
                i6++;
                zzafzVar.zzl();
                zzafpVar2.zzj(i6, false);
            }
            i4 = 0;
            i5 = 0;
        } while (i6 - i3 < 8192);
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final void zzc(zzagb zzagbVar) {
        this.zze = zzagbVar;
        this.zza.zzb(zzagbVar, new zzarh(Integer.MIN_VALUE, 0, 1));
        zzagbVar.zzv();
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final int zzd(zzafz zzafzVar, zzagy zzagyVar) throws IOException {
        this.zze.getClass();
        zzet zzetVar = this.zzb;
        int iZza = zzafzVar.zza(zzetVar.zzi(), 0, 2048);
        if (!this.zzi) {
            this.zze.zzw(new zzaha(-9223372036854775807L, 0L));
            this.zzi = true;
        }
        if (iZza == -1) {
            return -1;
        }
        zzetVar.zzh(0);
        zzetVar.zzf(iZza);
        if (!this.zzh) {
            this.zza.zzc(this.zzf, 4);
            this.zzh = true;
        }
        this.zza.zzd(zzetVar);
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final void zze(long j3, long j4) {
        this.zzh = false;
        this.zza.zza();
        this.zzf = j4;
    }

    public zzapo(int i3) {
        this.zza = new zzapp(true, null, 0, "audio/mp4a-latm");
        this.zzb = new zzet(2048);
        this.zzg = -1L;
        zzet zzetVar = new zzet(10);
        this.zzc = zzetVar;
        byte[] bArrZzi = zzetVar.zzi();
        this.zzd = new zzes(bArrZzi, bArrZzi.length);
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final void zzf() {
    }
}
