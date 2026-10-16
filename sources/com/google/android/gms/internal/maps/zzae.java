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
public final class zzae extends zza implements zzag {
    zzae(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.model.internal.IPolygonDelegate");
    }

    @Override // com.google.android.gms.internal.maps.zzag
    public final void zzA(float f3) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeFloat(f3);
        zzc(13, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzag
    public final boolean zzB(zzag zzagVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zze(parcelZza, zzagVar);
        Parcel parcelZzJ = zzJ(19, parcelZza);
        boolean zZzf = zzc.zzf(parcelZzJ);
        parcelZzJ.recycle();
        return zZzf;
    }

    @Override // com.google.android.gms.internal.maps.zzag
    public final boolean zzC() throws RemoteException {
        Parcel parcelZzJ = zzJ(22, zza());
        boolean zZzf = zzc.zzf(parcelZzJ);
        parcelZzJ.recycle();
        return zZzf;
    }

    @Override // com.google.android.gms.internal.maps.zzag
    public final boolean zzD() throws RemoteException {
        Parcel parcelZzJ = zzJ(18, zza());
        boolean zZzf = zzc.zzf(parcelZzJ);
        parcelZzJ.recycle();
        return zZzf;
    }

    @Override // com.google.android.gms.internal.maps.zzag
    public final boolean zzE() throws RemoteException {
        Parcel parcelZzJ = zzJ(16, zza());
        boolean zZzf = zzc.zzf(parcelZzJ);
        parcelZzJ.recycle();
        return zZzf;
    }

    @Override // com.google.android.gms.internal.maps.zzag
    public final float zzd() throws RemoteException {
        Parcel parcelZzJ = zzJ(8, zza());
        float f3 = parcelZzJ.readFloat();
        parcelZzJ.recycle();
        return f3;
    }

    @Override // com.google.android.gms.internal.maps.zzag
    public final float zze() throws RemoteException {
        Parcel parcelZzJ = zzJ(14, zza());
        float f3 = parcelZzJ.readFloat();
        parcelZzJ.recycle();
        return f3;
    }

    @Override // com.google.android.gms.internal.maps.zzag
    public final int zzf() throws RemoteException {
        Parcel parcelZzJ = zzJ(12, zza());
        int i3 = parcelZzJ.readInt();
        parcelZzJ.recycle();
        return i3;
    }

    @Override // com.google.android.gms.internal.maps.zzag
    public final int zzg() throws RemoteException {
        Parcel parcelZzJ = zzJ(10, zza());
        int i3 = parcelZzJ.readInt();
        parcelZzJ.recycle();
        return i3;
    }

    @Override // com.google.android.gms.internal.maps.zzag
    public final int zzh() throws RemoteException {
        Parcel parcelZzJ = zzJ(24, zza());
        int i3 = parcelZzJ.readInt();
        parcelZzJ.recycle();
        return i3;
    }

    @Override // com.google.android.gms.internal.maps.zzag
    public final int zzi() throws RemoteException {
        Parcel parcelZzJ = zzJ(20, zza());
        int i3 = parcelZzJ.readInt();
        parcelZzJ.recycle();
        return i3;
    }

    @Override // com.google.android.gms.internal.maps.zzag
    public final IObjectWrapper zzj() throws RemoteException {
        Parcel parcelZzJ = zzJ(28, zza());
        IObjectWrapper iObjectWrapperX3 = IObjectWrapper.Stub.x3(parcelZzJ.readStrongBinder());
        parcelZzJ.recycle();
        return iObjectWrapperX3;
    }

    @Override // com.google.android.gms.internal.maps.zzag
    public final String zzk() throws RemoteException {
        Parcel parcelZzJ = zzJ(2, zza());
        String string = parcelZzJ.readString();
        parcelZzJ.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.maps.zzag
    public final List zzl() throws RemoteException {
        Parcel parcelZzJ = zzJ(6, zza());
        ArrayList arrayListZzb = zzc.zzb(parcelZzJ);
        parcelZzJ.recycle();
        return arrayListZzb;
    }

    @Override // com.google.android.gms.internal.maps.zzag
    public final List zzm() throws RemoteException {
        Parcel parcelZzJ = zzJ(4, zza());
        ArrayList arrayListCreateTypedArrayList = parcelZzJ.createTypedArrayList(LatLng.CREATOR);
        parcelZzJ.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // com.google.android.gms.internal.maps.zzag
    public final List zzn() throws RemoteException {
        Parcel parcelZzJ = zzJ(26, zza());
        ArrayList arrayListCreateTypedArrayList = parcelZzJ.createTypedArrayList(PatternItem.CREATOR);
        parcelZzJ.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // com.google.android.gms.internal.maps.zzag
    public final void zzo() throws RemoteException {
        zzc(1, zza());
    }

    @Override // com.google.android.gms.internal.maps.zzag
    public final void zzp(boolean z2) throws RemoteException {
        Parcel parcelZza = zza();
        int i3 = zzc.zza;
        parcelZza.writeInt(z2 ? 1 : 0);
        zzc(21, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzag
    public final void zzq(int i3) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeInt(i3);
        zzc(11, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzag
    public final void zzr(boolean z2) throws RemoteException {
        Parcel parcelZza = zza();
        int i3 = zzc.zza;
        parcelZza.writeInt(z2 ? 1 : 0);
        zzc(17, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzag
    public final void zzs(List list) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeList(list);
        zzc(5, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzag
    public final void zzt(List list) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeTypedList(list);
        zzc(3, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzag
    public final void zzu(int i3) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeInt(i3);
        zzc(9, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzag
    public final void zzv(int i3) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeInt(i3);
        zzc(23, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzag
    public final void zzw(List list) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeTypedList(list);
        zzc(25, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzag
    public final void zzx(float f3) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeFloat(f3);
        zzc(7, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzag
    public final void zzy(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zze(parcelZza, iObjectWrapper);
        zzc(27, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzag
    public final void zzz(boolean z2) throws RemoteException {
        Parcel parcelZza = zza();
        int i3 = zzc.zza;
        parcelZza.writeInt(z2 ? 1 : 0);
        zzc(15, parcelZza);
    }
}
