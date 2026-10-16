package com.google.android.gms.internal.ads;

import com.google.android.gms.appset.AppSetIdInfo;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final /* synthetic */ class zzevw implements zzgta {
    static final /* synthetic */ zzevw zza = new zzevw();

    private /* synthetic */ zzevw() {
    }

    @Override // com.google.android.gms.internal.ads.zzgta
    public final /* synthetic */ Object apply(Object obj) {
        AppSetIdInfo appSetIdInfo = (AppSetIdInfo) obj;
        return new zzevy(appSetIdInfo.getId(), appSetIdInfo.getScope());
    }
}
