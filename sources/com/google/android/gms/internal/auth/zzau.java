package com.google.android.gms.internal.auth;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzau extends zza implements IInterface {
    zzau(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.api.accounttransfer.internal.IAccountTransferService");
    }

    public final void zzd(zzat zzatVar, zzaq zzaqVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zzd(parcelZza, zzatVar);
        zzc.zzc(parcelZza, zzaqVar);
        zzc(7, parcelZza);
    }

    public final void zze(zzat zzatVar, zzbb zzbbVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zzd(parcelZza, zzatVar);
        zzc.zzc(parcelZza, zzbbVar);
        zzc(8, parcelZza);
    }

    public final void zzf(zzat zzatVar, zzav zzavVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zzd(parcelZza, zzatVar);
        zzc.zzc(parcelZza, zzavVar);
        zzc(9, parcelZza);
    }

    public final void zzg(zzat zzatVar, zzax zzaxVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zzd(parcelZza, zzatVar);
        zzc.zzc(parcelZza, zzaxVar);
        zzc(6, parcelZza);
    }

    public final void zzh(zzat zzatVar, zzaz zzazVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zzd(parcelZza, zzatVar);
        zzc.zzc(parcelZza, zzazVar);
        zzc(5, parcelZza);
    }
}
