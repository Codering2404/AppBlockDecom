package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final /* synthetic */ class zzbpm implements zzbpq {
    static final /* synthetic */ zzbpm zza = new zzbpm();

    private /* synthetic */ zzbpm() {
    }

    @Override // com.google.android.gms.internal.ads.zzbpq
    public final /* synthetic */ void zza(Object obj, Map map) {
        zzcmn zzcmnVar = (zzcmn) obj;
        zzbpq zzbpqVar = zzbpp.zza;
        String str = (String) map.get("tx");
        String str2 = (String) map.get("ty");
        String str3 = (String) map.get("td");
        try {
            int i3 = Integer.parseInt(str);
            int i4 = Integer.parseInt(str2);
            int i5 = Integer.parseInt(str3);
            zzbap zzbapVarZzS = zzcmnVar.zzS();
            if (zzbapVarZzS != null) {
                zzbapVarZzS.zzb().zze(i3, i4, i5);
            }
        } catch (NumberFormatException unused) {
            int i6 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.f("Could not parse touch parameters from gmsg.");
        }
    }
}
