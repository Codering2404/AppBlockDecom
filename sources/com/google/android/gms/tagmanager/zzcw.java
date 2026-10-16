package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcw {
    static final Map zza = new HashMap();
    private static String zzb;

    public static String zza(String str, String str2) {
        if (str2 != null) {
            return Uri.parse("http://hostname/?".concat(String.valueOf(str))).getQueryParameter(str2);
        }
        if (str.length() > 0) {
            return str;
        }
        return null;
    }

    public static String zzb(Context context, String str) {
        if (zzb == null) {
            synchronized (zzcw.class) {
                try {
                    if (zzb == null) {
                        SharedPreferences sharedPreferences = context.getSharedPreferences("gtm_install_referrer", 0);
                        if (sharedPreferences != null) {
                            zzb = sharedPreferences.getString("referrer", "");
                        } else {
                            zzb = "";
                        }
                    }
                } finally {
                }
            }
        }
        return zza(zzb, str);
    }

    public static void zzc(Context context, String str) {
        String strZza = zza(str, "conv");
        if (strZza == null || strZza.length() <= 0) {
            return;
        }
        zza.put(strZza, str);
        zzff.zza(context, "gtm_click_referrers", strZza, str);
    }

    public static void zzd(String str) {
        synchronized (zzcw.class) {
            zzb = str;
        }
    }
}
