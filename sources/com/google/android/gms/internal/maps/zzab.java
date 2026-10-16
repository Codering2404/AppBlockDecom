package com.google.android.gms.internal.maps;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.maps.model.LatLng;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzab extends zza implements zzad {
    zzab(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.model.internal.IMarkerDelegate");
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final void zzA(String str) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        zzc(5, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final void zzB(boolean z2) throws RemoteException {
        Parcel parcelZza = zza();
        int i3 = zzc.zza;
        parcelZza.writeInt(z2 ? 1 : 0);
        zzc(14, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final void zzC(float f3) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeFloat(f3);
        zzc(27, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final void zzD() throws RemoteException {
        zzc(11, zza());
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final boolean zzE(zzad zzadVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zze(parcelZza, zzadVar);
        Parcel parcelZzJ = zzJ(16, parcelZza);
        boolean zZzf = zzc.zzf(parcelZzJ);
        parcelZzJ.recycle();
        return zZzf;
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final boolean zzF() throws RemoteException {
        Parcel parcelZzJ = zzJ(10, zza());
        boolean zZzf = zzc.zzf(parcelZzJ);
        parcelZzJ.recycle();
        return zZzf;
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final boolean zzG() throws RemoteException {
        Parcel parcelZzJ = zzJ(21, zza());
        boolean zZzf = zzc.zzf(parcelZzJ);
        parcelZzJ.recycle();
        return zZzf;
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final boolean zzH() throws RemoteException {
        Parcel parcelZzJ = zzJ(13, zza());
        boolean zZzf = zzc.zzf(parcelZzJ);
        parcelZzJ.recycle();
        return zZzf;
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final boolean zzI() throws RemoteException {
        Parcel parcelZzJ = zzJ(15, zza());
        boolean zZzf = zzc.zzf(parcelZzJ);
        parcelZzJ.recycle();
        return zZzf;
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final float zzd() throws RemoteException {
        Parcel parcelZzJ = zzJ(26, zza());
        float f3 = parcelZzJ.readFloat();
        parcelZzJ.recycle();
        return f3;
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final float zze() throws RemoteException {
        Parcel parcelZzJ = zzJ(23, zza());
        float f3 = parcelZzJ.readFloat();
        parcelZzJ.recycle();
        return f3;
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final float zzf() throws RemoteException {
        Parcel parcelZzJ = zzJ(28, zza());
        float f3 = parcelZzJ.readFloat();
        parcelZzJ.recycle();
        return f3;
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final int zzg() throws RemoteException {
        Parcel parcelZzJ = zzJ(17, zza());
        int i3 = parcelZzJ.readInt();
        parcelZzJ.recycle();
        return i3;
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final IObjectWrapper zzh() throws RemoteException {
        Parcel parcelZzJ = zzJ(34, zza());
        IObjectWrapper iObjectWrapperX3 = IObjectWrapper.Stub.x3(parcelZzJ.readStrongBinder());
        parcelZzJ.recycle();
        return iObjectWrapperX3;
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final IObjectWrapper zzi() throws RemoteException {
        Parcel parcelZzJ = zzJ(30, zza());
        IObjectWrapper iObjectWrapperX3 = IObjectWrapper.Stub.x3(parcelZzJ.readStrongBinder());
        parcelZzJ.recycle();
        return iObjectWrapperX3;
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final LatLng zzj() throws RemoteException {
        Parcel parcelZzJ = zzJ(4, zza());
        LatLng latLng = (LatLng) zzc.zza(parcelZzJ, LatLng.CREATOR);
        parcelZzJ.recycle();
        return latLng;
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final String zzk() throws RemoteException {
        Parcel parcelZzJ = zzJ(2, zza());
        String string = parcelZzJ.readString();
        parcelZzJ.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final String zzl() throws RemoteException {
        Parcel parcelZzJ = zzJ(8, zza());
        String string = parcelZzJ.readString();
        parcelZzJ.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final String zzm() throws RemoteException {
        Parcel parcelZzJ = zzJ(6, zza());
        String string = parcelZzJ.readString();
        parcelZzJ.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final void zzn() throws RemoteException {
        zzc(12, zza());
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final void zzo() throws RemoteException {
        zzc(1, zza());
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final void zzp(float f3) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeFloat(f3);
        zzc(25, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final void zzq(float f3, float f4) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeFloat(f3);
        parcelZza.writeFloat(f4);
        zzc(19, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final void zzr(boolean z2) throws RemoteException {
        Parcel parcelZza = zza();
        int i3 = zzc.zza;
        parcelZza.writeInt(z2 ? 1 : 0);
        zzc(9, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final void zzs(boolean z2) throws RemoteException {
        Parcel parcelZza = zza();
        int i3 = zzc.zza;
        parcelZza.writeInt(z2 ? 1 : 0);
        zzc(20, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final void zzt(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zze(parcelZza, iObjectWrapper);
        zzc(18, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final void zzu(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zze(parcelZza, iObjectWrapper);
        zzc(33, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final void zzv(float f3, float f4) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeFloat(f3);
        parcelZza.writeFloat(f4);
        zzc(24, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final void zzw(LatLng latLng) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zzd(parcelZza, latLng);
        zzc(3, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final void zzx(float f3) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeFloat(f3);
        zzc(22, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final void zzy(String str) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        zzc(7, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final void zzz(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zze(parcelZza, iObjectWrapper);
        zzc(29, parcelZza);
    }
}
