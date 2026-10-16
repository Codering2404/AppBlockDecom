package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzair implements zzafy {
    private zzagb zzb;
    private int zzc;
    private int zzd;
    private int zze;
    private zzaix zzg;
    private zzafz zzh;
    private zzahg zzi;
    private zzamc zzj;
    private final zzet zza = new zzet(2);
    private long zzf = -1;

    private final int zzh(zzafz zzafzVar) throws IOException {
        zzet zzetVar = this.zza;
        zzetVar.zza(2);
        ((zzafp) zzafzVar).zzh(zzetVar.zzi(), 0, 2, false);
        return zzetVar.zzt();
    }

    private final int zzi(zzafz zzafzVar) throws IOException {
        zzet zzetVar = this.zza;
        zzetVar.zza(2);
        zzafzVar.zzi(zzetVar.zzi(), 0, 2);
        return zzetVar.zzt() - 2;
    }

    private final void zzj() {
        zzagb zzagbVar = this.zzb;
        zzagbVar.getClass();
        zzagbVar.zzv();
        this.zzb.zzw(new zzaha(-9223372036854775807L, 0L));
        this.zzc = 6;
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final boolean zza(zzafz zzafzVar) throws IOException {
        int iZzi;
        if (zzh(zzafzVar) == 65496) {
            while (true) {
                int iZzh = zzh(zzafzVar);
                this.zzd = iZzh;
                if (iZzh == 65498 || (iZzi = zzi(zzafzVar)) < 0) {
                    break;
                }
                if (this.zzd != 65505) {
                    ((zzafp) zzafzVar).zzj(iZzi, false);
                } else {
                    zzet zzetVar = this.zza;
                    zzetVar.zza(iZzi);
                    ((zzafp) zzafzVar).zzh(zzetVar.zzi(), 0, iZzi, false);
                    if (!Objects.equals(zzetVar.zzM((char) 0), "http://ns.adobe.com/xap/1.0/") ? false : zzaiu.zzb(zzetVar.zzM((char) 0))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final void zzc(zzagb zzagbVar) {
        this.zzb = zzagbVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0190  */
    @Override // com.google.android.gms.internal.ads.zzafy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int zzd(com.google.android.gms.internal.ads.zzafz r26, com.google.android.gms.internal.ads.zzagy r27) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 481
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzair.zzd(com.google.android.gms.internal.ads.zzafz, com.google.android.gms.internal.ads.zzagy):int");
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final void zze(long j3, long j4) {
        if (j3 == 0) {
            this.zzc = 0;
            this.zzj = null;
        } else if (this.zzc == 5) {
            zzamc zzamcVar = this.zzj;
            zzamcVar.getClass();
            zzamcVar.zze(j3, j4);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final void zzf() {
    }
}
