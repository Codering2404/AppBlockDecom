package com.google.android.gms.internal.ads;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public interface zzbse extends IInterface {
    com.google.android.gms.ads.internal.client.zzea zzb() throws RemoteException;

    void zzc() throws RemoteException;

    void zzd(IObjectWrapper iObjectWrapper, zzbsh zzbshVar) throws RemoteException;

    void zze(IObjectWrapper iObjectWrapper) throws RemoteException;

    zzbmb zzf() throws RemoteException;
}
