package com.google.android.gms.tagmanager;

import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzbe extends zzfs {
    private static final String zza = com.google.android.gms.internal.gtm.zza.DATA_LAYER_WRITE.toString();
    private static final String zzb = com.google.android.gms.internal.gtm.zzb.VALUE.toString();
    private static final String zzc = com.google.android.gms.internal.gtm.zzb.CLEAR_PERSISTENT_DATA_LAYER_PREFIX.toString();
    private final DataLayer zzd;

    public zzbe(DataLayer dataLayer) {
        super(zza, zzb);
        this.zzd = dataLayer;
    }

    @Override // com.google.android.gms.tagmanager.zzfs
    public final void zzc(Map map) {
        String strZzm;
        com.google.android.gms.internal.gtm.zzam zzamVar = (com.google.android.gms.internal.gtm.zzam) map.get(zzb);
        if (zzamVar != null) {
            Object objZzk = zzfu.zzk(zzamVar);
            if (objZzk instanceof List) {
                for (Object obj : (List) objZzk) {
                    if (obj instanceof Map) {
                        this.zzd.push((Map) obj);
                    }
                }
            }
        }
        com.google.android.gms.internal.gtm.zzam zzamVar2 = (com.google.android.gms.internal.gtm.zzam) map.get(zzc);
        if (zzamVar2 == null || (strZzm = zzfu.zzm(zzfu.zzk(zzamVar2))) == zzfu.zzl()) {
            return;
        }
        this.zzd.zzd(strZzm);
    }
}
