package com.google.android.gms.internal.maps;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.maps.model.Cap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PatternItem;
import com.google.android.gms.maps.model.StyleSpan;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzah extends zza implements zzaj {
    zzah(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.model.internal.IPolylineDelegate");
    }

    @Override // com.google.android.gms.internal.maps.zzaj
    public final void zzA(boolean z2) throws RemoteException {
        Parcel parcelZza = zza();
        int i3 = zzc.zza;
        parcelZza.writeInt(z2 ? 1 : 0);
        zzc(11, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzaj
    public final void zzB(float f3) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeFloat(f3);
        zzc(5, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzaj
    public final void zzC(float f3) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeFloat(f3);
        zzc(9, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzaj
    public final boolean zzD(zzaj zzajVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zze(parcelZza, zzajVar);
        Parcel parcelZzJ = zzJ(15, parcelZza);
        boolean zZzf = zzc.zzf(parcelZzJ);
        parcelZzJ.recycle();
        return zZzf;
    }

    @Override // com.google.android.gms.internal.maps.zzaj
    public final boolean zzE() throws RemoteException {
        Parcel parcelZzJ = zzJ(18, zza());
        boolean zZzf = zzc.zzf(parcelZzJ);
        parcelZzJ.recycle();
        return zZzf;
    }

    @Override // com.google.android.gms.internal.maps.zzaj
    public final boolean zzF() throws RemoteException {
        Parcel parcelZzJ = zzJ(14, zza());
        boolean zZzf = zzc.zzf(parcelZzJ);
        parcelZzJ.recycle();
        return zZzf;
    }

    @Override // com.google.android.gms.internal.maps.zzaj
    public final boolean zzG() throws RemoteException {
        Parcel parcelZzJ = zzJ(12, zza());
        boolean zZzf = zzc.zzf(parcelZzJ);
        parcelZzJ.recycle();
        return zZzf;
    }

    @Override // com.google.android.gms.internal.maps.zzaj
    public final float zzd() throws RemoteException {
        Parcel parcelZzJ = zzJ(6, zza());
        float f3 = parcelZzJ.readFloat();
        parcelZzJ.recycle();
        return f3;
    }

    @Override // com.google.android.gms.internal.maps.zzaj
    public final float zze() throws RemoteException {
        Parcel parcelZzJ = zzJ(10, zza());
        float f3 = parcelZzJ.readFloat();
        parcelZzJ.recycle();
        return f3;
    }

    @Override // com.google.android.gms.internal.maps.zzaj
    public final int zzf() throws RemoteException {
        Parcel parcelZzJ = zzJ(8, zza());
        int i3 = parcelZzJ.readInt();
        parcelZzJ.recycle();
        return i3;
    }

    @Override // com.google.android.gms.internal.maps.zzaj
    public final int zzg() throws RemoteException {
        Parcel parcelZzJ = zzJ(24, zza());
        int i3 = parcelZzJ.readInt();
        parcelZzJ.recycle();
        return i3;
    }

    @Override // com.google.android.gms.internal.maps.zzaj
    public final int zzh() throws RemoteException {
        Parcel parcelZzJ = zzJ(16, zza());
        int i3 = parcelZzJ.readInt();
        parcelZzJ.recycle();
        return i3;
    }

    @Override // com.google.android.gms.internal.maps.zzaj
    public final IObjectWrapper zzi() throws RemoteException {
        Parcel parcelZzJ = zzJ(28, zza());
        IObjectWrapper iObjectWrapperX3 = IObjectWrapper.Stub.x3(parcelZzJ.readStrongBinder());
        parcelZzJ.recycle();
        return iObjectWrapperX3;
    }

    @Override // com.google.android.gms.internal.maps.zzaj
    public final Cap zzj() throws RemoteException {
        Parcel parcelZzJ = zzJ(22, zza());
        Cap cap = (Cap) zzc.zza(parcelZzJ, Cap.CREATOR);
        parcelZzJ.recycle();
        return cap;
    }

    @Override // com.google.android.gms.internal.maps.zzaj
    public final Cap zzk() throws RemoteException {
        Parcel parcelZzJ = zzJ(20, zza());
        Cap cap = (Cap) zzc.zza(parcelZzJ, Cap.CREATOR);
        parcelZzJ.recycle();
        return cap;
    }

    @Override // com.google.android.gms.internal.maps.zzaj
    public final String zzl() throws RemoteException {
        Parcel parcelZzJ = zzJ(2, zza());
        String string = parcelZzJ.readString();
        parcelZzJ.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.maps.zzaj
    public final List zzm() throws RemoteException {
        Parcel parcelZzJ = zzJ(26, zza());
        ArrayList arrayListCreateTypedArrayList = parcelZzJ.createTypedArrayList(PatternItem.CREATOR);
        parcelZzJ.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // com.google.android.gms.internal.maps.zzaj
    public final List zzn() throws RemoteException {
        Parcel parcelZzJ = zzJ(4, zza());
        ArrayList arrayListCreateTypedArrayList = parcelZzJ.createTypedArrayList(LatLng.CREATOR);
        parcelZzJ.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // com.google.android.gms.internal.maps.zzaj
    public final List zzo() throws RemoteException {
        Parcel parcelZzJ = zzJ(30, zza());
        ArrayList arrayListCreateTypedArrayList = parcelZzJ.createTypedArrayList(StyleSpan.CREATOR);
        parcelZzJ.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // com.google.android.gms.internal.maps.zzaj
    public final void zzp() throws RemoteException {
        zzc(1, zza());
    }

    @Override // com.google.android.gms.internal.maps.zzaj
    public final void zzq(boolean z2) throws RemoteException {
        Parcel parcelZza = zza();
        int i3 = zzc.zza;
        parcelZza.writeInt(z2 ? 1 : 0);
        zzc(17, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzaj
    public final void zzr(int i3) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeInt(i3);
        zzc(7, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzaj
    public final void zzs(Cap cap) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zzd(parcelZza, cap);
        zzc(21, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzaj
    public final void zzt(boolean z2) throws RemoteException {
        Parcel parcelZza = zza();
        int i3 = zzc.zza;
        parcelZza.writeInt(z2 ? 1 : 0);
        zzc(13, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzaj
    public final void zzu(int i3) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeInt(i3);
        zzc(23, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzaj
    public final void zzv(List list) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeTypedList(list);
        zzc(25, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzaj
    public final void zzw(List list) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeTypedList(list);
        zzc(3, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzaj
    public final void zzx(List list) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeTypedList(list);
        zzc(29, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzaj
    public final void zzy(Cap cap) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zzd(parcelZza, cap);
        zzc(19, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzaj
    public final void zzz(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zze(parcelZza, iObjectWrapper);
        zzc(27, parcelZza);
    }
}
