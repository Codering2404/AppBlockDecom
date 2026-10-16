package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbpw implements zzbpq {
    private final Context zza;
    private final Map zzb;

    public zzbpw(Context context, Map map) {
        this.zza = context;
        this.zzb = map;
    }

    @Override // com.google.android.gms.internal.ads.zzbpq
    public final void zza(Object obj, Map map) {
        zzcdz zzcdzVarD = com.google.android.gms.ads.internal.zzt.d();
        Context context = this.zza;
        if (zzcdzVarD.zza(context)) {
            String str = (String) map.get("eventName");
            String str2 = (String) map.get("eventId");
            int iHashCode = str.hashCode();
            if (iHashCode != 94399) {
                if (iHashCode != 94401) {
                    if (iHashCode == 94407 && str.equals("_ai")) {
                        com.google.android.gms.ads.internal.zzt.d().zzl(context, str2, (Map) this.zzb.get("_ai"));
                        return;
                    }
                } else if (str.equals("_ac")) {
                    com.google.android.gms.ads.internal.zzt.d().zzk(context, str2, (Map) this.zzb.get("_ac"));
                    return;
                }
            } else if (str.equals("_aa")) {
                com.google.android.gms.ads.internal.zzt.d().zzn(context, str2);
                return;
            }
            int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.c("logScionEvent gmsg contained unsupported eventName");
        }
    }
}
