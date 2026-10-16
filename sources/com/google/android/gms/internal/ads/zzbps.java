package com.google.android.gms.internal.ads;

import com.facebook.appevents.AppEventsConstants;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbps implements zzbpq {
    private final zzbpt zza;

    public zzbps(zzbpt zzbptVar) {
        this.zza = zzbptVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbpq
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcku zzckuVar = (zzcku) obj;
        boolean zEquals = AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(map.get("transparentBackground"));
        boolean zEquals2 = AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(map.get("blur"));
        float f3 = 0.0f;
        try {
            if (map.get("blurRadius") != null) {
                f3 = Float.parseFloat((String) map.get("blurRadius"));
            }
        } catch (NumberFormatException e3) {
            int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.d("Fail to parse float", e3);
        }
        zzbpt zzbptVar = this.zza;
        zzbptVar.zza(zEquals);
        zzbptVar.zzb(zEquals2, f3);
        zzckuVar.zzaE(zEquals);
    }
}
