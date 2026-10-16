package com.google.android.gms.internal.ads;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzanf {
    public static void zza(zzang zzangVar, zzank zzankVar, zzdt zzdtVar) {
        for (int i3 = 0; i3 < zzangVar.zza(); i3++) {
            long jZzb = zzangVar.zzb(i3);
            List listZzc = zzangVar.zzc(jZzb);
            if (!listZzc.isEmpty()) {
                if (i3 == zzangVar.zza() - 1) {
                    throw new IllegalStateException();
                }
                long jZzb2 = zzangVar.zzb(i3 + 1) - zzangVar.zzb(i3);
                if (jZzb2 > 0) {
                    zzdtVar.zza(new zzand(listZzc, jZzb, jZzb2));
                }
            }
        }
    }
}
