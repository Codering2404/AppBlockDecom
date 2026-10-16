package com.google.android.gms.internal.auth;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.auth.api.accounttransfer.DeviceMetaData;
import com.google.android.gms.common.api.Status;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public interface zzat extends IInterface {
    void zzb(byte[] bArr) throws RemoteException;

    void zzc(DeviceMetaData deviceMetaData) throws RemoteException;

    void zzd(Status status) throws RemoteException;

    void zze() throws RemoteException;

    void zzf(Status status, com.google.android.gms.auth.api.accounttransfer.zzw zzwVar) throws RemoteException;

    void zzg(Status status, com.google.android.gms.auth.api.accounttransfer.zzo zzoVar) throws RemoteException;

    void zzh(Status status) throws RemoteException;
}
