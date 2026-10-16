package com.google.android.gms.internal.ads;

import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzbqb implements com.google.android.gms.ads.internal.overlay.zzaa {
    boolean zza;
    final /* synthetic */ boolean zzb;
    final /* synthetic */ com.google.android.gms.ads.internal.client.zza zzc;
    final /* synthetic */ Map zzd;
    final /* synthetic */ Map zze;

    zzbqb(zzbqd zzbqdVar, boolean z2, com.google.android.gms.ads.internal.client.zza zzaVar, Map map, Map map2) {
        this.zzb = z2;
        this.zzc = zzaVar;
        this.zzd = map;
        this.zze = map2;
        Objects.requireNonNull(zzbqdVar);
        this.zza = false;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzaa
    public final void zza(boolean z2) {
        if (this.zza) {
            return;
        }
        if (z2 && this.zzb) {
            ((zzdky) this.zzc).zzdu();
        }
        this.zza = true;
        Map map = this.zzd;
        map.put((String) this.zze.get("event_id"), Boolean.valueOf(z2));
        ((zzbsm) this.zzc).zze("openIntentAsync", map);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzaa
    public final void zzb(int i3) {
    }
}
