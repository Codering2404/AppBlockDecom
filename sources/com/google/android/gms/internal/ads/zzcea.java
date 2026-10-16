package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzcea {
    static zzcea zzi;

    public static synchronized zzcea zzb(Context context) {
        try {
            zzcea zzceaVar = zzi;
            if (zzceaVar != null) {
                return zzceaVar;
            }
            Context applicationContext = context.getApplicationContext();
            zzbiq.zza(applicationContext);
            com.google.android.gms.ads.internal.util.zzg zzgVarZzo = com.google.android.gms.ads.internal.zzt.l().zzo();
            zzgVarZzo.zza(applicationContext);
            zzcdu zzcduVar = new zzcdu(null);
            zzcduVar.zza(applicationContext);
            zzcduVar.zzb(com.google.android.gms.ads.internal.zzt.o());
            zzcduVar.zzc(zzgVarZzo);
            zzcduVar.zzd(com.google.android.gms.ads.internal.zzt.d());
            zzcea zzceaVarZze = zzcduVar.zze();
            zzi = zzceaVarZze;
            ((zzcdo) ((zzcdv) zzceaVarZze).zzc.zzb()).zza();
            final zzcef zzcefVar = (zzcef) ((zzcdv) zzi).zzh.zzb();
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzbf)).booleanValue()) {
                com.google.android.gms.ads.internal.zzt.g();
                final Map mapI0 = com.google.android.gms.ads.internal.util.zzs.i0((String) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzbg));
                Iterator it = mapI0.keySet().iterator();
                while (it.hasNext()) {
                    zzcefVar.zzb((String) it.next());
                }
                zzcefVar.zza(new zzced() { // from class: com.google.android.gms.internal.ads.zzcee
                    @Override // com.google.android.gms.internal.ads.zzced
                    public final /* synthetic */ void zza(SharedPreferences sharedPreferences, String str, String str2) {
                        zzcefVar.zzc(mapI0, sharedPreferences, str, str2);
                    }
                });
            }
            return zzi;
        } catch (Throwable th) {
            throw th;
        }
    }

    abstract zzcds zza();
}
