package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzcez extends com.google.android.gms.ads.internal.util.zzb {
    final /* synthetic */ zzcfd zza;

    zzcez(zzcfd zzcfdVar) {
        Objects.requireNonNull(zzcfdVar);
        this.zza = zzcfdVar;
    }

    @Override // com.google.android.gms.ads.internal.util.zzb
    public final void zza() {
        zzcfd zzcfdVar = this.zza;
        zzbit zzbitVar = new zzbit(zzcfdVar.zzz(), zzcfdVar.zzA().f70149a);
        synchronized (zzcfdVar.zzy()) {
            try {
                com.google.android.gms.ads.internal.zzt.q();
                zzbiw.zza(zzcfdVar.zzB(), zzbitVar);
            } catch (IllegalArgumentException e3) {
                int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
                com.google.android.gms.ads.internal.util.client.zzo.g("Cannot config CSI reporter.", e3);
            }
        }
    }
}
