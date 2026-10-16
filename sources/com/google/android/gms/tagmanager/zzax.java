package com.google.android.gms.tagmanager;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzax extends zzbt {
    private static final String zza = com.google.android.gms.internal.gtm.zza.CUSTOM_VAR.toString();
    private static final String zzb = com.google.android.gms.internal.gtm.zzb.NAME.toString();
    private static final String zzc = com.google.android.gms.internal.gtm.zzb.DEFAULT_VALUE.toString();
    private final DataLayer zzd;

    public zzax(DataLayer dataLayer) {
        super(zza, zzb);
        this.zzd = dataLayer;
    }

    @Override // com.google.android.gms.tagmanager.zzbt
    public final com.google.android.gms.internal.gtm.zzam zza(Map map) {
        Object obj = this.zzd.get(zzfu.zzm(zzfu.zzk((com.google.android.gms.internal.gtm.zzam) map.get(zzb))));
        if (obj != null) {
            return zzfu.zzb(obj);
        }
        com.google.android.gms.internal.gtm.zzam zzamVar = (com.google.android.gms.internal.gtm.zzam) map.get(zzc);
        return zzamVar != null ? zzamVar : zzfu.zza();
    }

    @Override // com.google.android.gms.tagmanager.zzbt
    public final boolean zzb() {
        return false;
    }
}
