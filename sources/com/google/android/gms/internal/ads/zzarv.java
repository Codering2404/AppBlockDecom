package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzarv implements zzafy {
    private final zzet zza = new zzet(4);
    private final zzahd zzb = new zzahd(-1, -1, "image/webp");

    @Override // com.google.android.gms.internal.ads.zzafy
    public final boolean zza(zzafz zzafzVar) throws IOException {
        zzet zzetVar = this.zza;
        zzetVar.zza(4);
        zzafp zzafpVar = (zzafp) zzafzVar;
        zzafpVar.zzh(zzetVar.zzi(), 0, 4, false);
        if (zzetVar.zzz() == 1380533830) {
            zzafpVar.zzj(4, false);
            zzetVar.zza(4);
            zzafpVar.zzh(zzetVar.zzi(), 0, 4, false);
            if (zzetVar.zzz() == 1464156752) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final void zzc(zzagb zzagbVar) {
        this.zzb.zzc(zzagbVar);
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final int zzd(zzafz zzafzVar, zzagy zzagyVar) throws IOException {
        return this.zzb.zzd(zzafzVar, zzagyVar);
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final void zze(long j3, long j4) {
        this.zzb.zze(j3, j4);
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final void zzf() {
    }
}
