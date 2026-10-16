package com.google.android.gms.internal.auth;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.accounttransfer.DeviceMetaData;
import com.google.android.gms.common.api.Status;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzas extends zzb implements zzat {
    public zzas() {
        super("com.google.android.gms.auth.api.accounttransfer.internal.IAccountTransferCallbacks");
    }

    @Override // com.google.android.gms.internal.auth.zzb
    protected final boolean zza(int i3, Parcel parcel, Parcel parcel2, int i4) throws RemoteException {
        switch (i3) {
            case 1:
                Status status = (Status) zzc.zza(parcel, Status.CREATOR);
                zzc.zzb(parcel);
                zzh(status);
                return true;
            case 2:
                Status status2 = (Status) zzc.zza(parcel, Status.CREATOR);
                com.google.android.gms.auth.api.accounttransfer.zzw zzwVar = (com.google.android.gms.auth.api.accounttransfer.zzw) zzc.zza(parcel, com.google.android.gms.auth.api.accounttransfer.zzw.CREATOR);
                zzc.zzb(parcel);
                zzf(status2, zzwVar);
                return true;
            case 3:
                Status status3 = (Status) zzc.zza(parcel, Status.CREATOR);
                com.google.android.gms.auth.api.accounttransfer.zzo zzoVar = (com.google.android.gms.auth.api.accounttransfer.zzo) zzc.zza(parcel, com.google.android.gms.auth.api.accounttransfer.zzo.CREATOR);
                zzc.zzb(parcel);
                zzg(status3, zzoVar);
                return true;
            case 4:
                zze();
                return true;
            case 5:
                Status status4 = (Status) zzc.zza(parcel, Status.CREATOR);
                zzc.zzb(parcel);
                zzd(status4);
                return true;
            case 6:
                byte[] bArrCreateByteArray = parcel.createByteArray();
                zzc.zzb(parcel);
                zzb(bArrCreateByteArray);
                return true;
            case 7:
                DeviceMetaData deviceMetaData = (DeviceMetaData) zzc.zza(parcel, DeviceMetaData.CREATOR);
                zzc.zzb(parcel);
                zzc(deviceMetaData);
                return true;
            default:
                return false;
        }
    }
}
