package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Future;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbit {
    private final String zza = (String) zzbkk.zza.zze();
    private final Map zzb;
    private final Context zzc;
    private final String zzd;

    public zzbit(Context context, String str) {
        this.zzc = context;
        this.zzd = str;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.zzb = linkedHashMap;
        linkedHashMap.put("s", "gmob_sdk");
        linkedHashMap.put("v", "3");
        linkedHashMap.put("os", Build.VERSION.RELEASE);
        linkedHashMap.put("api_v", Build.VERSION.SDK);
        com.google.android.gms.ads.internal.zzt.g();
        linkedHashMap.put(DeviceRequestsHelper.DEVICE_INFO_DEVICE, com.google.android.gms.ads.internal.util.zzs.e0());
        linkedHashMap.put("app", context.getApplicationContext() != null ? context.getApplicationContext().getPackageName() : context.getPackageName());
        com.google.android.gms.ads.internal.zzt.g();
        boolean zH = com.google.android.gms.ads.internal.util.zzs.h(context);
        String str2 = AppEventsConstants.EVENT_PARAM_VALUE_YES;
        linkedHashMap.put("is_lite_sdk", true != zH ? AppEventsConstants.EVENT_PARAM_VALUE_NO : AppEventsConstants.EVENT_PARAM_VALUE_YES);
        Future futureZza = com.google.android.gms.ads.internal.zzt.t().zza(context);
        try {
            linkedHashMap.put("network_coarse", Integer.toString(((zzcbh) futureZza.get()).zzj));
            linkedHashMap.put("network_fine", Integer.toString(((zzcbh) futureZza.get()).zzk));
        } catch (Exception e3) {
            com.google.android.gms.ads.internal.zzt.l().zzg(e3, "CsiConfiguration.CsiConfiguration");
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzmL)).booleanValue()) {
            Map map = this.zzb;
            com.google.android.gms.ads.internal.zzt.g();
            map.put("is_bstar", true != com.google.android.gms.ads.internal.util.zzs.e(context) ? AppEventsConstants.EVENT_PARAM_VALUE_NO : str2);
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzkP)).booleanValue()) {
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzdg)).booleanValue() || zzgua.zzc(com.google.android.gms.ads.internal.zzt.l().zzu())) {
                return;
            }
            this.zzb.put("plugin", com.google.android.gms.ads.internal.zzt.l().zzu());
        }
    }

    final String zza() {
        return this.zza;
    }

    final Context zzb() {
        return this.zzc;
    }

    final String zzc() {
        return this.zzd;
    }

    final Map zzd() {
        return this.zzb;
    }
}
