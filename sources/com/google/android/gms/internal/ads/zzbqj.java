package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.applovin.sdk.AppLovinEventParameters;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbqj implements zzbpq {
    private final zzbqi zza;

    public zzbqj(zzbqi zzbqiVar) {
        this.zza = zzbqiVar;
    }

    public static void zzb(zzcku zzckuVar, zzbqi zzbqiVar) {
        zzckuVar.zzab("/reward", new zzbqj(zzbqiVar));
    }

    @Override // com.google.android.gms.internal.ads.zzbpq
    public final void zza(Object obj, Map map) {
        String str = (String) map.get("action");
        if (!"grant".equals(str)) {
            if ("video_start".equals(str)) {
                this.zza.zza();
                return;
            } else {
                if ("video_complete".equals(str)) {
                    this.zza.zzc();
                    return;
                }
                return;
            }
        }
        zzccb zzccbVar = null;
        try {
            int i3 = Integer.parseInt((String) map.get(AppLovinEventParameters.REVENUE_AMOUNT));
            String str2 = (String) map.get("type");
            if (!TextUtils.isEmpty(str2)) {
                zzccbVar = new zzccb(str2, i3);
            }
        } catch (NumberFormatException e3) {
            int i4 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.g("Unable to parse reward amount.", e3);
        }
        this.zza.zzb(zzccbVar);
    }
}
