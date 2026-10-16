package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzbox implements zzbpq {
    zzbox() {
    }

    @Override // com.google.android.gms.internal.ads.zzbpq
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcku zzckuVar = (zzcku) obj;
        if (zzckuVar.zzaz() != null) {
            zzckuVar.zzaz().zza();
        }
        com.google.android.gms.ads.internal.overlay.zzm zzmVarZzL = zzckuVar.zzL();
        if (zzmVarZzL != null) {
            zzmVarZzL.zzb();
            return;
        }
        com.google.android.gms.ads.internal.overlay.zzm zzmVarZzM = zzckuVar.zzM();
        if (zzmVarZzM != null) {
            zzmVarZzM.zzb();
        } else {
            int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.f("A GMSG tried to close something that wasn't an overlay.");
        }
    }
}
