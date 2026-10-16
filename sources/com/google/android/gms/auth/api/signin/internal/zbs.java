package com.google.android.gms.auth.api.signin.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zbs extends com.google.android.gms.internal.p000authapi.zba implements IInterface {
    zbs(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.api.signin.internal.ISignInService");
    }

    public final void h5(zbr zbrVar, GoogleSignInOptions googleSignInOptions) throws RemoteException {
        Parcel parcelZba = zba();
        com.google.android.gms.internal.p000authapi.zbc.zbd(parcelZba, zbrVar);
        com.google.android.gms.internal.p000authapi.zbc.zbc(parcelZba, googleSignInOptions);
        zbb(102, parcelZba);
    }

    public final void i5(zbr zbrVar, GoogleSignInOptions googleSignInOptions) throws RemoteException {
        Parcel parcelZba = zba();
        com.google.android.gms.internal.p000authapi.zbc.zbd(parcelZba, zbrVar);
        com.google.android.gms.internal.p000authapi.zbc.zbc(parcelZba, googleSignInOptions);
        zbb(101, parcelZba);
    }

    public final void x3(zbr zbrVar, GoogleSignInOptions googleSignInOptions) throws RemoteException {
        Parcel parcelZba = zba();
        com.google.android.gms.internal.p000authapi.zbc.zbd(parcelZba, zbrVar);
        com.google.android.gms.internal.p000authapi.zbc.zbc(parcelZba, googleSignInOptions);
        zbb(103, parcelZba);
    }
}
