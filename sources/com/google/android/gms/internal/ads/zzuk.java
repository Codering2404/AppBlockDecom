package com.google.android.gms.internal.ads;

import com.facebook.ads.AdError;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzuk implements zzun {
    zzuk() {
    }

    @Override // com.google.android.gms.internal.ads.zzun
    public final zzug zza(zzui zzuiVar, zzv zzvVar) {
        if (zzvVar.zzt == null) {
            return null;
        }
        return new zzuo(new zzuf(new zzup(1), AdError.MEDIAVIEW_MISSING_ERROR_CODE));
    }

    @Override // com.google.android.gms.internal.ads.zzun
    public final int zzb(zzv zzvVar) {
        return zzvVar.zzt != null ? 1 : 0;
    }
}
