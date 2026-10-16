package com.google.android.gms.internal.ads;

import android.net.NetworkCapabilities;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzgio extends zzgix {
    private final Map zza;

    zzgio(zzaxm zzaxmVar, zzght zzghtVar, Map map, zzgqh zzgqhVar) {
        super("G2/bixlyGCE81T8XD1821hdaWkYSafkSwXLAJIGuuGqYRgIdSuokiuQCkAmmYtmy", "cUq8+LlkvVToJpkHwW06ohwTjEjO/Tpp50dyOy2nlqU=", zzaxmVar, zzghtVar, zzgqhVar.zza(118));
        this.zza = map;
    }

    @Override // com.google.android.gms.internal.ads.zzgix
    protected final void zza(Method method, zzaxm zzaxmVar) throws IllegalAccessException, InvocationTargetException {
        Map map = this.zza;
        Object[] objArr = (Object[]) method.invoke("", (NetworkCapabilities) map.get("ntc"), (Long) map.get("vs"), (Long) map.get("vf"));
        objArr.getClass();
        synchronized (zzaxmVar) {
            try {
                zzaxmVar.zzf(((Long) objArr[0]).longValue());
                long jLongValue = ((Long) objArr[1]).longValue();
                if (jLongValue >= 0) {
                    zzaxmVar.zzW(jLongValue);
                }
                long jLongValue2 = ((Long) objArr[2]).longValue();
                if (jLongValue2 >= 0) {
                    zzaxmVar.zzX(jLongValue2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
