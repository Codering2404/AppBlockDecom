package com.google.android.gms.internal.gtm;

import android.util.Log;
import com.google.android.gms.analytics.Logger;
import com.revenuecat.purchases.common.Constants;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public final class zzfc {
    private static volatile Logger zza = new zzcw();

    public static Logger zza() {
        return zza;
    }

    public static void zzb(String str, Object obj) {
        String str2;
        zzfd zzfdVarZza = zzfd.zza();
        if (zzfdVarZza != null) {
            zzfdVarZza.zzJ(str, obj);
        } else if (zzf(3)) {
            if (obj != null) {
                str2 = str + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + ((String) obj);
            } else {
                str2 = str;
            }
            Log.e((String) zzew.zzc.zzb(), str2);
        }
        Logger logger = zza;
        if (logger != null) {
            logger.error(str);
        }
    }

    public static void zzc(Logger logger) {
        zza = logger;
    }

    public static void zzd(String str) {
        zzfd zzfdVarZza = zzfd.zza();
        if (zzfdVarZza != null) {
            zzfdVarZza.zzN(str);
        } else if (zzf(0)) {
            Log.v((String) zzew.zzc.zzb(), str);
        }
        Logger logger = zza;
        if (logger != null) {
            logger.verbose(str);
        }
    }

    public static void zze(String str) {
        zzfd zzfdVarZza = zzfd.zza();
        if (zzfdVarZza != null) {
            zzfdVarZza.zzQ(str);
        } else if (zzf(2)) {
            Log.w((String) zzew.zzc.zzb(), str);
        }
        Logger logger = zza;
        if (logger != null) {
            logger.warn(str);
        }
    }

    public static boolean zzf(int i3) {
        return zza != null && zza.getLogLevel() <= i3;
    }
}
