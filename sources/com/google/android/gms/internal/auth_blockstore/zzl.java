package com.google.android.gms.internal.auth_blockstore;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.blockstore.RetrieveBytesResponse;
import com.google.android.gms.common.api.Status;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzl extends zzb implements zzm {
    public zzl() {
        super("com.google.android.gms.auth.blockstore.internal.IRetrieveBytesCallback");
    }

    @Override // com.google.android.gms.internal.auth_blockstore.zzb
    protected final boolean dispatchTransaction(int i3, Parcel parcel, Parcel parcel2, int i4) throws RemoteException {
        if (i3 == 1) {
            Status status = (Status) zzc.zza(parcel, Status.CREATOR);
            byte[] bArrCreateByteArray = parcel.createByteArray();
            enforceNoDataAvail(parcel);
            zza(status, bArrCreateByteArray);
        } else {
            if (i3 != 2) {
                return false;
            }
            Status status2 = (Status) zzc.zza(parcel, Status.CREATOR);
            RetrieveBytesResponse retrieveBytesResponse = (RetrieveBytesResponse) zzc.zza(parcel, RetrieveBytesResponse.CREATOR);
            enforceNoDataAvail(parcel);
            zzb(status2, retrieveBytesResponse);
        }
        return true;
    }
}
