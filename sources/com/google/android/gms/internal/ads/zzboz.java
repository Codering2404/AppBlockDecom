package com.google.android.gms.internal.ads;

import com.facebook.LegacyTokenHelper;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzboz implements zzbpq {
    zzboz() {
    }

    @Override // com.google.android.gms.internal.ads.zzbpq
    public final void zza(Object obj, Map map) {
        String strValueOf = String.valueOf((String) map.get(LegacyTokenHelper.TYPE_STRING));
        int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
        com.google.android.gms.ads.internal.util.client.zzo.e("Received log message: ".concat(strValueOf));
    }
}
