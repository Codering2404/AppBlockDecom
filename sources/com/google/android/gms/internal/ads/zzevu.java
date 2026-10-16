package com.google.android.gms.internal.ads;

import com.google.android.gms.appset.AppSetIdInfo;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final /* synthetic */ class zzevu implements zzhbe {
    static final /* synthetic */ zzevu zza = new zzevu();

    private /* synthetic */ zzevu() {
    }

    @Override // com.google.android.gms.internal.ads.zzhbe
    public final /* synthetic */ ListenableFuture zza(Object obj) {
        AppSetIdInfo appSetIdInfo = (AppSetIdInfo) obj;
        return appSetIdInfo == null ? zzhbw.zza(new zzevy(null, -1)) : zzhbw.zza(new zzevy(appSetIdInfo.getId(), appSetIdInfo.getScope()));
    }
}
