package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final /* synthetic */ class zzbpl implements zzbpq {
    static final /* synthetic */ zzbpl zza = new zzbpl();

    private /* synthetic */ zzbpl() {
    }

    @Override // com.google.android.gms.internal.ads.zzbpq
    public final /* synthetic */ void zza(Object obj, Map map) {
        zzcmg zzcmgVar = (zzcmg) obj;
        zzbpq zzbpqVar = zzbpp.zza;
        String str = (String) map.get("u");
        if (str == null) {
            int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.f("URL missing from httpTrack GMSG.");
            return;
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzg)).booleanValue() && str.isEmpty()) {
            int i4 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.f("URL is empty from httpTrack GMSG.");
        } else {
            zzckl zzcklVar = (zzckl) zzcmgVar;
            new com.google.android.gms.ads.internal.util.zzbt(zzcmgVar.getContext(), ((zzcmo) zzcmgVar).zzs().f70149a, str, null, zzcklVar.zzC() != null ? zzcklVar.zzC().zzax : null).zzb();
        }
    }
}
