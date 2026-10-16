package com.google.android.gms.tagmanager;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzf extends zzbt {
    private static final String zza = com.google.android.gms.internal.gtm.zza.ADVERTISING_TRACKING_ENABLED.toString();
    private final zzd zzb;

    zzf(zzd zzdVar) {
        super(zza, new String[0]);
        this.zzb = zzdVar;
    }

    @Override // com.google.android.gms.tagmanager.zzbt
    public final com.google.android.gms.internal.gtm.zzam zza(Map map) {
        return zzfu.zzb(Boolean.valueOf(!this.zzb.zzf()));
    }

    @Override // com.google.android.gms.tagmanager.zzbt
    public final boolean zzb() {
        return false;
    }
}
