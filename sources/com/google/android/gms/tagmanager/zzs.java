package com.google.android.gms.tagmanager;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzs extends zzbt {
    private static final String zza = com.google.android.gms.internal.gtm.zza.CONSTANT.toString();
    private static final String zzb = com.google.android.gms.internal.gtm.zzb.VALUE.toString();

    public zzs() {
        super(zza, zzb);
    }

    @Override // com.google.android.gms.tagmanager.zzbt
    public final com.google.android.gms.internal.gtm.zzam zza(Map map) {
        return (com.google.android.gms.internal.gtm.zzam) map.get(zzb);
    }

    @Override // com.google.android.gms.tagmanager.zzbt
    public final boolean zzb() {
        return true;
    }
}
