package com.google.android.gms.internal.maps;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzp extends zza implements zzr {
    zzp(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
    }

    @Override // com.google.android.gms.internal.maps.zzr
    public final boolean zzA() throws RemoteException {
        Parcel parcelZzJ = zzJ(23, zza());
        boolean zZzf = zzc.zzf(parcelZzJ);
        parcelZzJ.recycle();
        return zZzf;
    }

    @Override // com.google.android.gms.internal.maps.zzr
    public final boolean zzB() throws RemoteException {
        Parcel parcelZzJ = zzJ(16, zza());
        boolean zZzf = zzc.zzf(parcelZzJ);
        parcelZzJ.recycle();
        return zZzf;
    }

    @Override // com.google.android.gms.internal.maps.zzr
    public final float zzd() throws RemoteException {
        Parcel parcelZzJ = zzJ(12, zza());
        float f3 = parcelZzJ.readFloat();
        parcelZzJ.recycle();
        return f3;
    }

    @Override // com.google.android.gms.internal.maps.zzr
    public final float zze() throws RemoteException {
        Parcel parcelZzJ = zzJ(8, zza());
        float f3 = parcelZzJ.readFloat();
        parcelZzJ.recycle();
        return f3;
    }

    @Override // com.google.android.gms.internal.maps.zzr
    public final float zzf() throws RemoteException {
        Parcel parcelZzJ = zzJ(18, zza());
        float f3 = parcelZzJ.readFloat();
        parcelZzJ.recycle();
        return f3;
    }

    @Override // com.google.android.gms.internal.maps.zzr
    public final float zzg() throws RemoteException {
        Parcel parcelZzJ = zzJ(7, zza());
        float f3 = parcelZzJ.readFloat();
        parcelZzJ.recycle();
        return f3;
    }

    @Override // com.google.android.gms.internal.maps.zzr
    public final float zzh() throws RemoteException {
        Parcel parcelZzJ = zzJ(14, zza());
        float f3 = parcelZzJ.readFloat();
        parcelZzJ.recycle();
        return f3;
    }

    @Override // com.google.android.gms.internal.maps.zzr
    public final int zzi() throws RemoteException {
        Parcel parcelZzJ = zzJ(20, zza());
        int i3 = parcelZzJ.readInt();
        parcelZzJ.recycle();
        return i3;
    }

    @Override // com.google.android.gms.internal.maps.zzr
    public final IObjectWrapper zzj() throws RemoteException {
        Parcel parcelZzJ = zzJ(25, zza());
        IObjectWrapper iObjectWrapperX3 = IObjectWrapper.Stub.x3(parcelZzJ.readStrongBinder());
        parcelZzJ.recycle();
        return iObjectWrapperX3;
    }

    @Override // com.google.android.gms.internal.maps.zzr
    public final LatLng zzk() throws RemoteException {
        Parcel parcelZzJ = zzJ(4, zza());
        LatLng latLng = (LatLng) zzc.zza(parcelZzJ, LatLng.CREATOR);
        parcelZzJ.recycle();
        return latLng;
    }

    @Override // com.google.android.gms.internal.maps.zzr
    public final LatLngBounds zzl() throws RemoteException {
        Parcel parcelZzJ = zzJ(10, zza());
        LatLngBounds latLngBounds = (LatLngBounds) zzc.zza(parcelZzJ, LatLngBounds.CREATOR);
        parcelZzJ.recycle();
        return latLngBounds;
    }

    @Override // com.google.android.gms.internal.maps.zzr
    public final String zzm() throws RemoteException {
        Parcel parcelZzJ = zzJ(2, zza());
        String string = parcelZzJ.readString();
        parcelZzJ.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.maps.zzr
    public final void zzn() throws RemoteException {
        zzc(1, zza());
    }

    @Override // com.google.android.gms.internal.maps.zzr
    public final void zzo(float f3) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeFloat(f3);
        zzc(11, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzr
    public final void zzp(boolean z2) throws RemoteException {
        Parcel parcelZza = zza();
        int i3 = zzc.zza;
        parcelZza.writeInt(z2 ? 1 : 0);
        zzc(22, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzr
    public final void zzq(float f3) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeFloat(f3);
        zzc(5, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzr
    public final void zzr(float f3, float f4) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeFloat(f3);
        parcelZza.writeFloat(f4);
        zzc(6, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzr
    public final void zzs(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zze(parcelZza, iObjectWrapper);
        zzc(21, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzr
    public final void zzt(LatLng latLng) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zzd(parcelZza, latLng);
        zzc(3, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzr
    public final void zzu(LatLngBounds latLngBounds) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zzd(parcelZza, latLngBounds);
        zzc(9, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzr
    public final void zzv(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zze(parcelZza, iObjectWrapper);
        zzc(24, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzr
    public final void zzw(float f3) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeFloat(f3);
        zzc(17, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzr
    public final void zzx(boolean z2) throws RemoteException {
        Parcel parcelZza = zza();
        int i3 = zzc.zza;
        parcelZza.writeInt(z2 ? 1 : 0);
        zzc(15, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzr
    public final void zzy(float f3) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeFloat(f3);
        zzc(13, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzr
    public final boolean zzz(zzr zzrVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zze(parcelZza, zzrVar);
        Parcel parcelZzJ = zzJ(19, parcelZza);
        boolean zZzf = zzc.zzf(parcelZzJ);
        parcelZzJ.recycle();
        return zZzf;
    }
}
