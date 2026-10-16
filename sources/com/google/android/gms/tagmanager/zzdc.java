package com.google.android.gms.tagmanager;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzdc extends zzdq {
    private static final String zza = com.google.android.gms.internal.gtm.zza.LESS_EQUALS.toString();

    public zzdc() {
        super(zza);
    }

    @Override // com.google.android.gms.tagmanager.zzdq
    protected final boolean zzc(zzft zzftVar, zzft zzftVar2, Map map) {
        return zzftVar.compareTo(zzftVar2) <= 0;
    }
}
