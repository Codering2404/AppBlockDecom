package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzapl implements zzafy {
    private final zzapm zza = new zzapm(null, 0, "audio/ac4");
    private final zzet zzb = new zzet(16384);
    private boolean zzc;

    static {
        int i3 = zzapk.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final boolean zza(zzafz zzafzVar) throws IOException {
        int i3;
        zzet zzetVar = new zzet(10);
        int i4 = 0;
        while (true) {
            zzafp zzafpVar = (zzafp) zzafzVar;
            zzafpVar.zzh(zzetVar.zzi(), 0, 10, false);
            zzetVar.zzh(0);
            if (zzetVar.zzx() != 4801587) {
                break;
            }
            zzetVar.zzk(3);
            int iZzG = zzetVar.zzG();
            i4 += iZzG + 10;
            zzafpVar.zzj(iZzG, false);
        }
        zzafzVar.zzl();
        zzafp zzafpVar2 = (zzafp) zzafzVar;
        zzafpVar2.zzj(i4, false);
        int i5 = 0;
        int i6 = i4;
        while (true) {
            int i7 = 7;
            zzafpVar2.zzh(zzetVar.zzi(), 0, 7, false);
            zzetVar.zzh(0);
            int iZzt = zzetVar.zzt();
            if (iZzt == 44096 || iZzt == 44097) {
                i5++;
                if (i5 >= 4) {
                    return true;
                }
                byte[] bArrZzi = zzetVar.zzi();
                int i8 = zzafb.zza;
                if (bArrZzi.length < 7) {
                    i3 = -1;
                } else {
                    int i9 = ((bArrZzi[2] & 255) << 8) | (bArrZzi[3] & 255);
                    if (i9 == 65535) {
                        i9 = ((bArrZzi[4] & 255) << 16) | ((bArrZzi[5] & 255) << 8) | (bArrZzi[6] & 255);
                    } else {
                        i7 = 4;
                    }
                    if (iZzt == 44097) {
                        i7 += 2;
                    }
                    i3 = i9 + i7;
                }
                if (i3 == -1) {
                    return false;
                }
                zzafpVar2.zzj(i3 - 7, false);
            } else {
                zzafzVar.zzl();
                i6++;
                if (i6 - i4 >= 8192) {
                    return false;
                }
                zzafpVar2.zzj(i6, false);
                i5 = 0;
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
        int iZza = zzafzVar.zza(zzetVar.zzi(), 0, 16384);
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
