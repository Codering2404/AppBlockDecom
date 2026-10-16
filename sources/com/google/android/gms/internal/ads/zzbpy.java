package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbpy implements zzbpq {
    private final zzeao zza;

    public zzbpy(zzeao zzeaoVar) {
        this.zza = zzeaoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbpq
    public final void zza(Object obj, Map map) {
        if (map == null || !map.containsKey("id") || TextUtils.isEmpty((CharSequence) map.get("id")) || !map.containsKey("event_type") || TextUtils.isEmpty((CharSequence) map.get("event_type"))) {
            com.google.android.gms.ads.internal.util.zze.k("Ignoring onDeviceStorageEvent GMSG: missing required parameters.");
            return;
        }
        try {
            this.zza.zza(Long.parseLong((String) map.get("id")), Integer.parseInt((String) map.get("event_type")), com.google.android.gms.ads.internal.zzt.o().currentTimeMillis());
        } catch (NumberFormatException e3) {
            com.google.android.gms.ads.internal.util.zze.l("Ignoring onDeviceStorageEvent GMSG: invalid number format for ID or eventType.", e3);
        }
    }
}
