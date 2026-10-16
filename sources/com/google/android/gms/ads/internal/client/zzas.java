package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.IInterface;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final /* synthetic */ class zzas implements com.google.android.gms.ads.internal.util.client.zzq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ zzas f69813a = new zzas();

    private /* synthetic */ zzas() {
    }

    @Override // com.google.android.gms.ads.internal.util.client.zzq
    public final /* synthetic */ Object zza(Object obj) {
        IBinder iBinder = (IBinder) obj;
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManagerCreator");
        return iInterfaceQueryLocalInterface instanceof zzcz ? (zzcz) iInterfaceQueryLocalInterface : new zzcz(iBinder);
    }
}
