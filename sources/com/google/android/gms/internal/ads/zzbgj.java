package com.google.android.gms.internal.ads;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public interface zzbgj extends IInterface {
    com.google.android.gms.ads.internal.client.zzbu zze() throws RemoteException;

    void zzf(IObjectWrapper iObjectWrapper, zzbgq zzbgqVar) throws RemoteException;

    com.google.android.gms.ads.internal.client.zzdx zzg() throws RemoteException;

    void zzh(boolean z2) throws RemoteException;

    void zzi(com.google.android.gms.ads.internal.client.zzdq zzdqVar) throws RemoteException;

    String zzj() throws RemoteException;

    long zzk() throws RemoteException;

    void zzl(long j3) throws RemoteException;
}
