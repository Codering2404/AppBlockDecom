package com.google.android.gms.internal.auth_blockstore;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.auth.blockstore.RetrieveBytesResponse;
import com.google.android.gms.common.api.Status;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public interface zzm extends IInterface {
    void zza(Status status, byte[] bArr) throws RemoteException;

    void zzb(Status status, RetrieveBytesResponse retrieveBytesResponse) throws RemoteException;
}
