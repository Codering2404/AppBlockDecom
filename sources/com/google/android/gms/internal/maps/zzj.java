package com.google.android.gms.internal.maps;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PatternItem;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzj extends zza implements zzl {
    zzj(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.model.internal.ICircleDelegate");
    }

    @Override // com.google.android.gms.internal.maps.zzl
    public final boolean zzA() throws RemoteException {
        Parcel parcelZzJ = zzJ(16, zza());
        boolean zZzf = zzc.zzf(parcelZzJ);
        parcelZzJ.recycle();
        return zZzf;
    }

    @Override // com.google.android.gms.internal.maps.zzl
    public final double zzd() throws RemoteException {
        Parcel parcelZzJ = zzJ(6, zza());
        double d3 = parcelZzJ.readDouble();
        parcelZzJ.recycle();
        return d3;
    }

    @Override // com.google.android.gms.internal.maps.zzl
    public final float zze() throws RemoteException {
        Parcel parcelZzJ = zzJ(8, zza());
        float f3 = parcelZzJ.readFloat();
        parcelZzJ.recycle();
        return f3;
    }

    @Override // com.google.android.gms.internal.maps.zzl
    public final float zzf() throws RemoteException {
        Parcel parcelZzJ = zzJ(14, zza());
        float f3 = parcelZzJ.readFloat();
        parcelZzJ.recycle();
        return f3;
    }

    @Override // com.google.android.gms.internal.maps.zzl
    public final int zzg() throws RemoteException {
        Parcel parcelZzJ = zzJ(12, zza());
        int i3 = parcelZzJ.readInt();
        parcelZzJ.recycle();
        return i3;
    }

    @Override // com.google.android.gms.internal.maps.zzl
    public final int zzh() throws RemoteException {
        Parcel parcelZzJ = zzJ(10, zza());
        int i3 = parcelZzJ.readInt();
        parcelZzJ.recycle();
        return i3;
    }

    @Override // com.google.android.gms.internal.maps.zzl
    public final int zzi() throws RemoteException {
        Parcel parcelZzJ = zzJ(18, zza());
        int i3 = parcelZzJ.readInt();
        parcelZzJ.recycle();
        return i3;
    }

    @Override // com.google.android.gms.internal.maps.zzl
    public final IObjectWrapper zzj() throws RemoteException {
        Parcel parcelZzJ = zzJ(24, zza());
        IObjectWrapper iObjectWrapperX3 = IObjectWrapper.Stub.x3(parcelZzJ.readStrongBinder());
        parcelZzJ.recycle();
        return iObjectWrapperX3;
    }

    @Override // com.google.android.gms.internal.maps.zzl
    public final LatLng zzk() throws RemoteException {
        Parcel parcelZzJ = zzJ(4, zza());
        LatLng latLng = (LatLng) zzc.zza(parcelZzJ, LatLng.CREATOR);
        parcelZzJ.recycle();
        return latLng;
    }

    @Override // com.google.android.gms.internal.maps.zzl
    public final String zzl() throws RemoteException {
        Parcel parcelZzJ = zzJ(2, zza());
        String string = parcelZzJ.readString();
        parcelZzJ.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.maps.zzl
    public final List zzm() throws RemoteException {
        Parcel parcelZzJ = zzJ(22, zza());
        ArrayList arrayListCreateTypedArrayList = parcelZzJ.createTypedArrayList(PatternItem.CREATOR);
        parcelZzJ.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // com.google.android.gms.internal.maps.zzl
    public final void zzn() throws RemoteException {
        zzc(1, zza());
    }

    @Override // com.google.android.gms.internal.maps.zzl
    public final void zzo(LatLng latLng) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zzd(parcelZza, latLng);
        zzc(3, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzl
    public final void zzp(boolean z2) throws RemoteException {
        Parcel parcelZza = zza();
        int i3 = zzc.zza;
        parcelZza.writeInt(z2 ? 1 : 0);
        zzc(19, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzl
    public final void zzq(int i3) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeInt(i3);
        zzc(11, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzl
    public final void zzr(double d3) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeDouble(d3);
        zzc(5, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzl
    public final void zzs(int i3) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeInt(i3);
        zzc(9, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzl
    public final void zzt(List list) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeTypedList(list);
        zzc(21, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzl
    public final void zzu(float f3) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeFloat(f3);
        zzc(7, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzl
    public final void zzv(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zze(parcelZza, iObjectWrapper);
        zzc(23, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzl
    public final void zzw(boolean z2) throws RemoteException {
        Parcel parcelZza = zza();
        int i3 = zzc.zza;
        parcelZza.writeInt(z2 ? 1 : 0);
        zzc(15, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzl
    public final void zzx(float f3) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeFloat(f3);
        zzc(13, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzl
    public final boolean zzy(zzl zzlVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zze(parcelZza, zzlVar);
        Parcel parcelZzJ = zzJ(17, parcelZza);
        boolean zZzf = zzc.zzf(parcelZzJ);
        parcelZzJ.recycle();
        return zZzf;
    }

    @Override // com.google.android.gms.internal.maps.zzl
    public final boolean zzz() throws RemoteException {
        Parcel parcelZzJ = zzJ(20, zza());
        boolean zZzf = zzc.zzf(parcelZzJ);
        parcelZzJ.recycle();
        return zZzf;
    }
}
