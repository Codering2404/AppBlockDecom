package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzzj implements zzzc {
    private final zzzc zza;
    private final long zzb;

    public zzzj(zzzc zzzcVar, long j3) {
        this.zza = zzzcVar;
        this.zzb = j3;
    }

    public final zzzc zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzzc
    public final boolean zzb() {
        return this.zza.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzzc
    public final void zzc() throws IOException {
        this.zza.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzzc
    public final int zzd(zzlw zzlwVar, zziv zzivVar, int i3) {
        int iZzd = this.zza.zzd(zzlwVar, zzivVar, i3);
        if (iZzd != -4) {
            return iZzd;
        }
        zzivVar.zze += this.zzb;
        return -4;
    }

    @Override // com.google.android.gms.internal.ads.zzzc
    public final int zze(long j3) {
        return this.zza.zze(j3 - this.zzb);
    }
}
