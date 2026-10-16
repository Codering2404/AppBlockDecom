package com.google.android.gms.ads.identifier;

import android.net.Uri;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zza extends Thread {
    final /* synthetic */ Map zza;

    zza(AdvertisingIdClient advertisingIdClient, Map map) {
        this.zza = map;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        Uri.Builder builderBuildUpon = Uri.parse("https://pagead2.googlesyndication.com/pagead/gen_204?id=gmob-apps").buildUpon();
        Map map = this.zza;
        for (String str : map.keySet()) {
            builderBuildUpon.appendQueryParameter(str, (String) map.get(str));
        }
        zze.zza(builderBuildUpon.build().toString());
    }
}
