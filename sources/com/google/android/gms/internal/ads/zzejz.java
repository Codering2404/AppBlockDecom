package com.google.android.gms.internal.ads;

import android.database.sqlite.SQLiteDatabase;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzejz implements zzhbt {
    final /* synthetic */ zzfok zza;

    zzejz(zzekg zzekgVar, zzfok zzfokVar) {
        this.zza = zzfokVar;
        Objects.requireNonNull(zzekgVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhbt
    public final void zza(Throwable th) {
        String strValueOf = String.valueOf(th.getMessage());
        int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
        com.google.android.gms.ads.internal.util.client.zzo.c("Failed to get offline buffered ping database: ".concat(strValueOf));
    }

    @Override // com.google.android.gms.internal.ads.zzhbt
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        try {
            this.zza.zza((SQLiteDatabase) obj);
        } catch (Exception e3) {
            String strValueOf = String.valueOf(e3.getMessage());
            int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.c("Error executing function on offline buffered ping database: ".concat(strValueOf));
        }
    }
}
