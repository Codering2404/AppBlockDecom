package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.MediaView;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbmw {
    private final zzbmv zza;

    public zzbmw(zzbmv zzbmvVar) {
        Context context;
        this.zza = zzbmvVar;
        try {
            context = (Context) ObjectWrapper.h5(zzbmvVar.zzm());
        } catch (RemoteException | NullPointerException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.d("", e3);
            context = null;
        }
        if (context != null) {
            try {
                this.zza.zzn(ObjectWrapper.i5(new MediaView(context)));
            } catch (RemoteException e4) {
                com.google.android.gms.ads.internal.util.client.zzo.d("", e4);
            }
        }
    }

    public final zzbmv zza() {
        return this.zza;
    }

    public final String zzb() {
        try {
            return this.zza.zzh();
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.d("", e3);
            return null;
        }
    }
}
