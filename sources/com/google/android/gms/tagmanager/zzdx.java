package com.google.android.gms.tagmanager;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzdx extends zzbt {
    private static final String zza = com.google.android.gms.internal.gtm.zzb.ARG0.toString();
    private static final String zzb = com.google.android.gms.internal.gtm.zzb.ARG1.toString();

    public zzdx(String str) {
        super(str, zza, zzb);
    }

    @Override // com.google.android.gms.tagmanager.zzbt
    public final com.google.android.gms.internal.gtm.zzam zza(Map map) {
        Iterator it = map.values().iterator();
        while (it.hasNext()) {
            if (((com.google.android.gms.internal.gtm.zzam) it.next()) == zzfu.zza()) {
                return zzfu.zzb(Boolean.FALSE);
            }
        }
        com.google.android.gms.internal.gtm.zzam zzamVar = (com.google.android.gms.internal.gtm.zzam) map.get(zza);
        com.google.android.gms.internal.gtm.zzam zzamVar2 = (com.google.android.gms.internal.gtm.zzam) map.get(zzb);
        boolean zZzd = false;
        if (zzamVar != null && zzamVar2 != null) {
            zZzd = zzd(zzamVar, zzamVar2, map);
        }
        return zzfu.zzb(Boolean.valueOf(zZzd));
    }

    @Override // com.google.android.gms.tagmanager.zzbt
    public final boolean zzb() {
        return true;
    }

    protected abstract boolean zzd(com.google.android.gms.internal.gtm.zzam zzamVar, com.google.android.gms.internal.gtm.zzam zzamVar2, Map map);
}
