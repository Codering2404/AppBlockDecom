package com.google.android.gms.internal.measurement;

import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzu extends zzai {
    private final Callable zza;

    public zzu(String str, Callable callable) {
        super("internal.appMetadata");
        this.zza = callable;
    }

    @Override // com.google.android.gms.internal.measurement.zzai
    public final zzao zza(zzg zzgVar, List list) {
        try {
            return zzi.zza(this.zza.call());
        } catch (Exception unused) {
            return zzao.zzf;
        }
    }
}
