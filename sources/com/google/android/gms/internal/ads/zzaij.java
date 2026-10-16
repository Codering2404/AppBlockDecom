package com.google.android.gms.internal.ads;

import java.io.IOException;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzaij implements zzafy {
    private zzagb zzf;
    private boolean zzh;
    private long zzi;
    private int zzj;
    private int zzk;
    private int zzl;
    private long zzm;
    private boolean zzn;
    private zzaih zzo;
    private zzain zzp;
    private final zzet zza = new zzet(4);
    private final zzet zzb = new zzet(9);
    private final zzet zzc = new zzet(11);
    private final zzet zzd = new zzet();
    private final zzaik zze = new zzaik();
    private int zzg = 1;

    static {
        int i3 = zzaii.zza;
    }

    private final zzet zzh(zzafz zzafzVar) throws IOException {
        zzet zzetVar = this.zzd;
        if (this.zzl > zzetVar.zzj()) {
            int iZzj = zzetVar.zzj();
            zzetVar.zzb(new byte[Math.max(iZzj + iZzj, this.zzl)], 0);
        } else {
            zzetVar.zzh(0);
        }
        zzetVar.zzf(this.zzl);
        zzafzVar.zzc(zzetVar.zzi(), 0, this.zzl);
        return zzetVar;
    }

    @RequiresNonNull
    private final void zzi() {
        if (this.zzn) {
            return;
        }
        this.zzf.zzw(new zzaha(-9223372036854775807L, 0L));
        this.zzn = true;
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final boolean zza(zzafz zzafzVar) throws IOException {
        zzet zzetVar = this.zza;
        zzafp zzafpVar = (zzafp) zzafzVar;
        zzafpVar.zzh(zzetVar.zzi(), 0, 3, false);
        zzetVar.zzh(0);
        if (zzetVar.zzx() != 4607062) {
            return false;
        }
        zzafpVar.zzh(zzetVar.zzi(), 0, 2, false);
        zzetVar.zzh(0);
        if ((zzetVar.zzt() & 250) != 0) {
            return false;
        }
        zzafpVar.zzh(zzetVar.zzi(), 0, 4, false);
        zzetVar.zzh(0);
        int iZzB = zzetVar.zzB();
        zzafzVar.zzl();
        zzafp zzafpVar2 = (zzafp) zzafzVar;
        zzafpVar2.zzj(iZzB, false);
        zzafpVar2.zzh(zzetVar.zzi(), 0, 4, false);
        zzetVar.zzh(0);
        return zzetVar.zzB() == 0;
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final void zzc(zzagb zzagbVar) {
        this.zzf = zzagbVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00bd A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0009 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzafy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int zzd(com.google.android.gms.internal.ads.zzafz r17, com.google.android.gms.internal.ads.zzagy r18) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 348
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaij.zzd(com.google.android.gms.internal.ads.zzafz, com.google.android.gms.internal.ads.zzagy):int");
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final void zze(long j3, long j4) {
        if (j3 == 0) {
            this.zzg = 1;
            this.zzh = false;
        } else {
            this.zzg = 3;
        }
        this.zzj = 0;
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final void zzf() {
    }
}
