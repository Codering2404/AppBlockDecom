package com.google.android.gms.ads.nonagon.signalgeneration;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.internal.ads.zzbiq;
import com.google.android.gms.internal.ads.zzcfr;
import com.google.android.gms.internal.ads.zzdzg;
import com.google.android.gms.internal.ads.zzdzq;
import com.google.android.gms.internal.ads.zzfkq;
import com.google.android.gms.internal.ads.zzfky;
import com.google.android.gms.internal.ads.zzfql;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzv {
    public static boolean a(zzfkq zzfkqVar) {
        return g(zzfkqVar.zza.zza) != 1;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "unspecified";
        }
        switch (str.hashCode()) {
            case 1743582862:
                return str.equals("requester_type_0") ? AppEventsConstants.EVENT_PARAM_VALUE_NO : str;
            case 1743582863:
                return str.equals("requester_type_1") ? AppEventsConstants.EVENT_PARAM_VALUE_YES : str;
            case 1743582864:
                return str.equals("requester_type_2") ? "2" : str;
            case 1743582865:
                return str.equals("requester_type_3") ? "3" : str;
            case 1743582866:
                return str.equals("requester_type_4") ? "4" : str;
            case 1743582867:
                return str.equals("requester_type_5") ? "5" : str;
            case 1743582868:
                return str.equals("requester_type_6") ? "6" : str;
            case 1743582869:
                return str.equals("requester_type_7") ? "7" : str;
            case 1743582870:
                return str.equals("requester_type_8") ? "8" : str;
            default:
                return str;
        }
    }

    public static String c(com.google.android.gms.ads.internal.client.zzm zzmVar) {
        Bundle bundle;
        return (zzmVar == null || (bundle = zzmVar.f69966c) == null) ? "unspecified" : bundle.getString("query_info_type");
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static zzfql d(Bundle bundle) {
        Bundle bundle2 = bundle.getBundle("com.google.ads.mediation.admob.AdMobAdapter");
        if (bundle2 != null) {
            bundle = bundle2;
        }
        String string = bundle.getString("query_info_type");
        if (TextUtils.isEmpty(string)) {
            return zzfql.SCAR_REQUEST_TYPE_UNSPECIFIED;
        }
        switch (string.hashCode()) {
            case 1743582862:
                if (string.equals("requester_type_0")) {
                    return zzfql.SCAR_REQUEST_TYPE_ADMOB;
                }
                break;
            case 1743582863:
                if (string.equals("requester_type_1")) {
                    return zzfql.SCAR_REQUEST_TYPE_INBOUND_MEDIATION;
                }
                break;
            case 1743582864:
                if (string.equals("requester_type_2")) {
                    return zzfql.SCAR_REQUEST_TYPE_GBID;
                }
                break;
            case 1743582865:
                if (string.equals("requester_type_3")) {
                    return zzfql.SCAR_REQUEST_TYPE_GOLDENEYE;
                }
                break;
            case 1743582866:
                if (string.equals("requester_type_4")) {
                    return zzfql.SCAR_REQUEST_TYPE_YAVIN;
                }
                break;
            case 1743582867:
                if (string.equals("requester_type_5")) {
                    return zzfql.SCAR_REQUEST_TYPE_UNITY;
                }
                break;
            case 1743582868:
                if (string.equals("requester_type_6")) {
                    return zzfql.SCAR_REQUEST_TYPE_PAW;
                }
                break;
            case 1743582869:
                if (string.equals("requester_type_7")) {
                    return zzfql.SCAR_REQUEST_TYPE_GUILDER;
                }
                break;
            case 1743582870:
                if (string.equals("requester_type_8")) {
                    return zzfql.SCAR_REQUEST_TYPE_GAM_S2S;
                }
                break;
        }
        return zzfql.SCAR_REQUEST_TYPE_UNSPECIFIED;
    }

    public static void e(final zzdzq zzdzqVar, zzdzg zzdzgVar, final String str, final Pair... pairArr) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzhT)).booleanValue()) {
            final zzdzg zzdzgVar2 = null;
            zzcfr.zza.execute(new Runnable(zzdzgVar2, str, pairArr) { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzu

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                private final /* synthetic */ String f70788b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                private final /* synthetic */ Pair[] f70789c;

                {
                    this.f70788b = str;
                    this.f70789c = pairArr;
                }

                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    zzv.f(this.f70787a, null, this.f70788b, this.f70789c);
                }
            });
        }
    }

    static /* synthetic */ void f(zzdzq zzdzqVar, zzdzg zzdzgVar, String str, Pair[] pairArr) {
        ConcurrentHashMap concurrentHashMapZzd = zzdzqVar.zzd();
        h(concurrentHashMapZzd, "action", str);
        for (Pair pair : pairArr) {
            h(concurrentHashMapZzd, (String) pair.first, (String) pair.second);
        }
        zzdzqVar.zzb(concurrentHashMapZzd);
    }

    public static int g(zzfky zzfkyVar) {
        if (zzfkyVar.zzs) {
            return 2;
        }
        com.google.android.gms.ads.internal.client.zzm zzmVar = zzfkyVar.zzd;
        com.google.android.gms.ads.internal.client.zzc zzcVar = zzmVar.f69982t;
        if (zzcVar == null && zzmVar.f69987y == null) {
            return 1;
        }
        if (zzcVar == null || zzmVar.f69987y == null) {
            return zzcVar != null ? 3 : 4;
        }
        return 5;
    }

    private static void h(Map map, String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        map.put(str, str2);
    }
}
