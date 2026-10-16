package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.ads.nativead.NativeCustomFormatAd;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbyj implements NativeCustomFormatAd.DisplayOpenMeasurement {
    private final zzbmv zza;

    public zzbyj(zzbmv zzbmvVar) {
        this.zza = zzbmvVar;
        try {
            zzbmvVar.zzr();
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.d("", e3);
        }
    }

    public final void setView(View view) {
        try {
            this.zza.zzq(ObjectWrapper.i5(view));
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.d("", e3);
        }
    }

    public final boolean start() {
        try {
            return this.zza.zzp();
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.d("", e3);
            return false;
        }
    }
}
