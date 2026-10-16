package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhu implements zzho {
    private final Context zza;
    private final zzho zzb;

    public zzhu(Context context) {
        zzhw zzhwVar = new zzhw();
        this.zza = context.getApplicationContext();
        this.zzb = zzhwVar;
    }

    @Override // com.google.android.gms.internal.ads.zzho
    public final /* bridge */ /* synthetic */ zzhp zza() {
        return new zzhv(this.zza, this.zzb.zza());
    }
}
