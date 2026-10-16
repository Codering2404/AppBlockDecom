package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzarq implements zzafy {
    private zzagb zza;
    private zzahk zzb;
    private zzarn zze;
    private int zzc = 0;
    private long zzd = -1;
    private int zzf = -1;
    private long zzg = -1;

    static {
        int i3 = zzarp.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final boolean zza(zzafz zzafzVar) throws IOException {
        return zzart.zza(zzafzVar);
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final void zzc(zzagb zzagbVar) {
        this.zza = zzagbVar;
        this.zzb = zzagbVar.zzu(0, 1);
        zzagbVar.zzv();
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x011f  */
    @Override // com.google.android.gms.internal.ads.zzafy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int zzd(com.google.android.gms.internal.ads.zzafz r19, com.google.android.gms.internal.ads.zzagy r20) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 428
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzarq.zzd(com.google.android.gms.internal.ads.zzafz, com.google.android.gms.internal.ads.zzagy):int");
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final void zze(long j3, long j4) {
        this.zzc = j3 == 0 ? 0 : 4;
        zzarn zzarnVar = this.zze;
        if (zzarnVar != null) {
            zzarnVar.zza(j4);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final void zzf() {
    }
}
