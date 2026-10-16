package com.google.android.gms.internal.ads;

import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzbta implements zzbpq {
    final /* synthetic */ zzbsp zza;
    final /* synthetic */ com.google.android.gms.ads.internal.util.zzbv zzb;
    final /* synthetic */ zzbtu zzc;

    zzbta(zzbtu zzbtuVar, zzbap zzbapVar, zzbsp zzbspVar, com.google.android.gms.ads.internal.util.zzbv zzbvVar) {
        this.zza = zzbspVar;
        this.zzb = zzbvVar;
        Objects.requireNonNull(zzbtuVar);
        this.zzc = zzbtuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbpq
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        com.google.android.gms.ads.internal.util.zze.k("loadJavascriptEngine > /requestReload handler: Trying to acquire lock");
        zzbtu zzbtuVar = this.zzc;
        synchronized (zzbtuVar.zzg()) {
            try {
                com.google.android.gms.ads.internal.util.zze.k("loadJavascriptEngine > /requestReload handler: Lock acquired");
                com.google.android.gms.ads.internal.util.client.zzo.e("JS Engine is requesting an update");
                if (zzbtuVar.zzk() == 0) {
                    com.google.android.gms.ads.internal.util.client.zzo.e("Starting reload.");
                    zzbtuVar.zzl(2);
                    zzbtuVar.zza(null);
                }
                this.zza.zzn("/requestReload", (zzbpq) this.zzb.a());
            } catch (Throwable th) {
                throw th;
            }
        }
        com.google.android.gms.ads.internal.util.zze.k("loadJavascriptEngine > /requestReload handler: Lock released");
    }
}
