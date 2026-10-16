package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.os.IInterface;
import android.os.RemoteException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public interface zzt extends IInterface {
    void zzb(int i3, String[] strArr) throws RemoteException;

    void zzc(int i3, String[] strArr) throws RemoteException;

    void zzd(int i3, PendingIntent pendingIntent) throws RemoteException;
}
