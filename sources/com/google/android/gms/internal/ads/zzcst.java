package com.google.android.gms.internal.ads;

import androidx.compose.material.icons.twotone.Phg.QaXmqxvjHhxVy;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcst implements zzcrt {
    private final com.google.android.gms.ads.internal.util.zzg zza;

    zzcst(com.google.android.gms.ads.internal.util.zzg zzgVar) {
        this.zza = zzgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcrt
    public final void zza(Map map) {
        int iIntValue;
        String str = (String) map.get(QaXmqxvjHhxVy.MCGo);
        if (str == null || (iIntValue = Float.valueOf(str).intValue()) <= 0) {
            return;
        }
        this.zza.a(iIntValue);
    }
}
