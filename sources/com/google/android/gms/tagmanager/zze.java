package com.google.android.gms.tagmanager;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zze extends zzbt {
    private static final String zza = com.google.android.gms.internal.gtm.zza.ADVERTISER_ID.toString();
    private final zzd zzb;

    zze(zzd zzdVar) {
        super(zza, new String[0]);
        this.zzb = zzdVar;
        zzdVar.zzc();
    }

    @Override // com.google.android.gms.tagmanager.zzbt
    public final com.google.android.gms.internal.gtm.zzam zza(Map map) {
        String strZzc = this.zzb.zzc();
        return strZzc == null ? zzfu.zza() : zzfu.zzb(strZzc);
    }

    @Override // com.google.android.gms.tagmanager.zzbt
    public final boolean zzb() {
        return false;
    }
}
