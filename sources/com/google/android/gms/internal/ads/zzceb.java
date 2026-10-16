package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzceb {
    public static String zza(String str, Context context, boolean z2, Map map) {
        String strZzj;
        if ((((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzbb)).booleanValue() && !z2) || !com.google.android.gms.ads.internal.zzt.d().zza(context) || TextUtils.isEmpty(str) || (strZzj = com.google.android.gms.ads.internal.zzt.d().zzj(context)) == null) {
            return str;
        }
        String str2 = (String) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzaU);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzaT)).booleanValue() && str.contains(str2)) {
            if (com.google.android.gms.ads.internal.zzt.g().S(str)) {
                com.google.android.gms.ads.internal.zzt.d().zzk(context, strZzj, (Map) map.get("_ac"));
                return zzd(str, context).replace(str2, strZzj);
            }
            if (!com.google.android.gms.ads.internal.zzt.g().T(str)) {
                return str;
            }
            com.google.android.gms.ads.internal.zzt.d().zzl(context, strZzj, (Map) map.get("_ai"));
            return zzd(str, context).replace(str2, strZzj);
        }
        if (str.contains("fbs_aeid")) {
            return str;
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzaS)).booleanValue()) {
            return str;
        }
        if (com.google.android.gms.ads.internal.zzt.g().S(str)) {
            com.google.android.gms.ads.internal.zzt.d().zzk(context, strZzj, (Map) map.get("_ac"));
            return zzc(zzd(str, context), "fbs_aeid", strZzj).toString();
        }
        if (!com.google.android.gms.ads.internal.zzt.g().T(str)) {
            return str;
        }
        com.google.android.gms.ads.internal.zzt.d().zzl(context, strZzj, (Map) map.get("_ai"));
        return zzc(zzd(str, context), "fbs_aeid", strZzj).toString();
    }

    public static String zzb(Uri uri, Context context, Map map) {
        if (!com.google.android.gms.ads.internal.zzt.d().zza(context)) {
            return uri.toString();
        }
        String strZzj = com.google.android.gms.ads.internal.zzt.d().zzj(context);
        if (strZzj == null) {
            return uri.toString();
        }
        String str = (String) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzaU);
        String string = uri.toString();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzaT)).booleanValue() && string.contains(str)) {
            com.google.android.gms.ads.internal.zzt.d().zzk(context, strZzj, (Map) map.get("_ac"));
            return zzd(string, context).replace(str, strZzj);
        }
        if (TextUtils.isEmpty(uri.getQueryParameter("fbs_aeid"))) {
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzaS)).booleanValue()) {
                String string2 = zzc(zzd(string, context), "fbs_aeid", strZzj).toString();
                com.google.android.gms.ads.internal.zzt.d().zzk(context, strZzj, (Map) map.get("_ac"));
                return string2;
            }
        }
        return string;
    }

    static Uri zzc(String str, String str2, String str3) {
        int iIndexOf = str.indexOf("&adurl");
        if (iIndexOf == -1) {
            iIndexOf = str.indexOf("?adurl");
        }
        if (iIndexOf == -1) {
            return Uri.parse(str).buildUpon().appendQueryParameter(str2, str3).build();
        }
        int i3 = iIndexOf + 1;
        return Uri.parse(str.substring(0, i3) + str2 + "=" + str3 + "&" + str.substring(i3));
    }

    private static String zzd(String str, Context context) {
        String strZzh = com.google.android.gms.ads.internal.zzt.d().zzh(context);
        String strZzi = com.google.android.gms.ads.internal.zzt.d().zzi(context);
        if (!str.contains("gmp_app_id") && !TextUtils.isEmpty(strZzh)) {
            str = zzc(str, "gmp_app_id", strZzh).toString();
        }
        return (str.contains("fbs_aiid") || TextUtils.isEmpty(strZzi)) ? str : zzc(str, "fbs_aiid", strZzi).toString();
    }
}
