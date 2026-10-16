package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzaip implements zzafy {
    private final zzafy zza;

    public zzaip() {
        this(0);
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final boolean zza(zzafz zzafzVar) throws IOException {
        return this.zza.zza(zzafzVar);
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final void zzc(zzagb zzagbVar) {
        this.zza.zzc(zzagbVar);
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final int zzd(zzafz zzafzVar, zzagy zzagyVar) throws IOException {
        return this.zza.zzd(zzafzVar, zzagyVar);
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final void zze(long j3, long j4) {
        this.zza.zze(j3, j4);
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final void zzf() {
        this.zza.zzf();
    }

    public zzaip(int i3) {
        this.zza = new zzaio();
    }
}
