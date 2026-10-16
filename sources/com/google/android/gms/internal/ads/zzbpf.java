package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final /* synthetic */ class zzbpf implements zzbpq {
    static final /* synthetic */ zzbpf zza = new zzbpf();

    private /* synthetic */ zzbpf() {
    }

    @Override // com.google.android.gms.internal.ads.zzbpq
    public final /* synthetic */ void zza(Object obj, Map map) {
        zzcmg zzcmgVar = (zzcmg) obj;
        zzbpq zzbpqVar = zzbpp.zza;
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzjy)).booleanValue()) {
            int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.f("canOpenAppGmsgHandler disabled.");
            return;
        }
        String str = (String) map.get("package_name");
        if (TextUtils.isEmpty(str)) {
            int i4 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.f("Package name missing in canOpenApp GMSG.");
            return;
        }
        HashMap map2 = new HashMap();
        Boolean boolValueOf = Boolean.valueOf(zzcmgVar.getContext().getPackageManager().getLaunchIntentForPackage(str) != null);
        map2.put(str, boolValueOf);
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 13 + boolValueOf.toString().length());
        sb.append("/canOpenApp;");
        sb.append(str);
        sb.append(";");
        sb.append(boolValueOf);
        com.google.android.gms.ads.internal.util.zze.k(sb.toString());
        ((zzbsm) zzcmgVar).zze("openableApp", map2);
    }
}
