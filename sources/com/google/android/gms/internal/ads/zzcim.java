package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcim implements zzbpq {
    private final zzcil zza;

    public zzcim(zzcil zzcilVar) {
        this.zza = zzcilVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbpq
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        String str = (String) map.get("action");
        if (str == null) {
            int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.f("Action missing from video GMSG.");
        } else if (str.equals("src")) {
            String str2 = (String) map.get("src");
            if (str2 != null) {
                this.zza.zza(str2);
            } else {
                int i4 = com.google.android.gms.ads.internal.util.zze.f70328b;
                com.google.android.gms.ads.internal.util.client.zzo.f("src missing from video GMSG.");
            }
        }
    }
}
