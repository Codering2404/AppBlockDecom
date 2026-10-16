package com.google.android.gms.internal.identity_credentials;

import android.os.BadParcelableException;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public class zzb extends Binder implements IInterface {
    private static zzd globalInterceptor;

    protected zzb(String str) {
        attachInterface(this, "com.google.android.gms.identitycredentials.internal.IIdentityCredentialCallbacks");
    }

    private boolean routeToSuperOrEnforceInterface(int i3, Parcel parcel, Parcel parcel2, int i4) throws RemoteException {
        if (i3 > 16777215) {
            return super.onTransact(i3, parcel, parcel2, i4);
        }
        parcel.enforceInterface(getInterfaceDescriptor());
        return false;
    }

    protected boolean dispatchTransaction(int i3, Parcel parcel, Parcel parcel2, int i4) throws RemoteException {
        throw null;
    }

    protected void enforceNoDataAvail(Parcel parcel) {
        zzd zzdVar = globalInterceptor;
        if (zzdVar != null) {
            zzdVar.zza();
            return;
        }
        int i3 = zzc.zza;
        int iDataAvail = parcel.dataAvail();
        if (iDataAvail <= 0) {
            return;
        }
        throw new BadParcelableException("Parcel data not fully consumed, unread size: " + iDataAvail);
    }

    @Override // android.os.Binder
    public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i4) throws RemoteException {
        if (routeToSuperOrEnforceInterface(i3, parcel, parcel2, i4)) {
            return true;
        }
        zzd zzdVar = globalInterceptor;
        return zzdVar == null ? dispatchTransaction(i3, parcel, parcel2, i4) : zzdVar.zzb();
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }
}
