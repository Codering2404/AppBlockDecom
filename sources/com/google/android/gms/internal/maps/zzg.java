package com.google.android.gms.internal.maps;

import android.graphics.Bitmap;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.maps.model.PinConfig;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzg extends zza implements zzi {
    zzg(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
    }

    @Override // com.google.android.gms.internal.maps.zzi
    public final IObjectWrapper zzd() throws RemoteException {
        Parcel parcelZzJ = zzJ(4, zza());
        IObjectWrapper iObjectWrapperX3 = IObjectWrapper.Stub.x3(parcelZzJ.readStrongBinder());
        parcelZzJ.recycle();
        return iObjectWrapperX3;
    }

    @Override // com.google.android.gms.internal.maps.zzi
    public final IObjectWrapper zze(float f3) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeFloat(f3);
        Parcel parcelZzJ = zzJ(5, parcelZza);
        IObjectWrapper iObjectWrapperX3 = IObjectWrapper.Stub.x3(parcelZzJ.readStrongBinder());
        parcelZzJ.recycle();
        return iObjectWrapperX3;
    }

    @Override // com.google.android.gms.internal.maps.zzi
    public final IObjectWrapper zzf(String str) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        Parcel parcelZzJ = zzJ(2, parcelZza);
        IObjectWrapper iObjectWrapperX3 = IObjectWrapper.Stub.x3(parcelZzJ.readStrongBinder());
        parcelZzJ.recycle();
        return iObjectWrapperX3;
    }

    @Override // com.google.android.gms.internal.maps.zzi
    public final IObjectWrapper zzg(Bitmap bitmap) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zzd(parcelZza, bitmap);
        Parcel parcelZzJ = zzJ(6, parcelZza);
        IObjectWrapper iObjectWrapperX3 = IObjectWrapper.Stub.x3(parcelZzJ.readStrongBinder());
        parcelZzJ.recycle();
        return iObjectWrapperX3;
    }

    @Override // com.google.android.gms.internal.maps.zzi
    public final IObjectWrapper zzh(String str) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        Parcel parcelZzJ = zzJ(3, parcelZza);
        IObjectWrapper iObjectWrapperX3 = IObjectWrapper.Stub.x3(parcelZzJ.readStrongBinder());
        parcelZzJ.recycle();
        return iObjectWrapperX3;
    }

    @Override // com.google.android.gms.internal.maps.zzi
    public final IObjectWrapper zzi(String str) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        Parcel parcelZzJ = zzJ(7, parcelZza);
        IObjectWrapper iObjectWrapperX3 = IObjectWrapper.Stub.x3(parcelZzJ.readStrongBinder());
        parcelZzJ.recycle();
        return iObjectWrapperX3;
    }

    @Override // com.google.android.gms.internal.maps.zzi
    public final IObjectWrapper zzj(PinConfig pinConfig) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zzd(parcelZza, pinConfig);
        Parcel parcelZzJ = zzJ(8, parcelZza);
        IObjectWrapper iObjectWrapperX3 = IObjectWrapper.Stub.x3(parcelZzJ.readStrongBinder());
        parcelZzJ.recycle();
        return iObjectWrapperX3;
    }

    @Override // com.google.android.gms.internal.maps.zzi
    public final IObjectWrapper zzk(int i3) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeInt(i3);
        Parcel parcelZzJ = zzJ(1, parcelZza);
        IObjectWrapper iObjectWrapperX3 = IObjectWrapper.Stub.x3(parcelZzJ.readStrongBinder());
        parcelZzJ.recycle();
        return iObjectWrapperX3;
    }
}
