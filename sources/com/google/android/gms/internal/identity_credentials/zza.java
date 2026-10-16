package com.google.android.gms.internal.identity_credentials;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.legacy.content.Werj.QgXempTBEfV;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public class zza implements IInterface {
    private final String mDescriptor = QgXempTBEfV.YZlOLnxgx;
    private final IBinder mRemote;

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.mRemote;
    }

    protected Parcel obtainAndWriteInterfaceToken() {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(this.mDescriptor);
        return parcelObtain;
    }

    protected void transactAndReadExceptionReturnVoid(int i3, Parcel parcel) throws RemoteException {
        Parcel parcelObtain = Parcel.obtain();
        try {
            this.mRemote.transact(i3, parcel, parcelObtain, 0);
            parcelObtain.readException();
        } finally {
            parcel.recycle();
            parcelObtain.recycle();
        }
    }

    protected zza(IBinder iBinder, String str) {
        this.mRemote = iBinder;
    }
}
