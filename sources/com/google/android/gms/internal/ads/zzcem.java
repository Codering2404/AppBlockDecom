package com.google.android.gms.internal.ads;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public interface zzcem extends IInterface {
    void zze(IObjectWrapper iObjectWrapper, zzceq zzceqVar, zzcej zzcejVar) throws RemoteException;

    void zzf(IObjectWrapper iObjectWrapper) throws RemoteException;

    void zzg(List list, IObjectWrapper iObjectWrapper, zzbzq zzbzqVar) throws RemoteException;

    void zzh(List list, IObjectWrapper iObjectWrapper, zzbzq zzbzqVar) throws RemoteException;

    void zzi(zzbzt zzbztVar) throws RemoteException;

    void zzj(IObjectWrapper iObjectWrapper) throws RemoteException;

    void zzk(List list, IObjectWrapper iObjectWrapper, zzbzq zzbzqVar) throws RemoteException;

    void zzl(List list, IObjectWrapper iObjectWrapper, zzbzq zzbzqVar) throws RemoteException;

    IObjectWrapper zzm(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, String str, IObjectWrapper iObjectWrapper3) throws RemoteException;
}
