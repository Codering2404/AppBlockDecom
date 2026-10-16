package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfz extends com.google.android.gms.internal.measurement.zzbl implements zzgb {
    zzfz(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.internal.IMeasurementService");
    }

    @Override // com.google.android.gms.measurement.internal.zzgb
    public final void E4(zzr zzrVar) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.measurement.zzbn.zzc(parcelZza, zzrVar);
        zzc(27, parcelZza);
    }

    @Override // com.google.android.gms.measurement.internal.zzgb
    public final void F(zzr zzrVar, zzoo zzooVar, zzgh zzghVar) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.measurement.zzbn.zzc(parcelZza, zzrVar);
        com.google.android.gms.internal.measurement.zzbn.zzc(parcelZza, zzooVar);
        com.google.android.gms.internal.measurement.zzbn.zzd(parcelZza, zzghVar);
        zzc(29, parcelZza);
    }

    @Override // com.google.android.gms.measurement.internal.zzgb
    public final void F0(zzr zzrVar) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.measurement.zzbn.zzc(parcelZza, zzrVar);
        zzc(25, parcelZza);
    }

    @Override // com.google.android.gms.measurement.internal.zzgb
    public final List I(String str, String str2, String str3, boolean z2) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(null);
        parcelZza.writeString(str2);
        parcelZza.writeString(str3);
        int i3 = com.google.android.gms.internal.measurement.zzbn.zza;
        parcelZza.writeInt(z2 ? 1 : 0);
        Parcel parcelZzP = zzP(15, parcelZza);
        ArrayList arrayListCreateTypedArrayList = parcelZzP.createTypedArrayList(zzpl.CREATOR);
        parcelZzP.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // com.google.android.gms.measurement.internal.zzgb
    public final void K(zzah zzahVar, zzr zzrVar) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.measurement.zzbn.zzc(parcelZza, zzahVar);
        com.google.android.gms.internal.measurement.zzbn.zzc(parcelZza, zzrVar);
        zzc(12, parcelZza);
    }

    @Override // com.google.android.gms.measurement.internal.zzgb
    public final List K4(String str, String str2, boolean z2, zzr zzrVar) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        int i3 = com.google.android.gms.internal.measurement.zzbn.zza;
        parcelZza.writeInt(z2 ? 1 : 0);
        com.google.android.gms.internal.measurement.zzbn.zzc(parcelZza, zzrVar);
        Parcel parcelZzP = zzP(14, parcelZza);
        ArrayList arrayListCreateTypedArrayList = parcelZzP.createTypedArrayList(zzpl.CREATOR);
        parcelZzP.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // com.google.android.gms.measurement.internal.zzgb
    public final void L3(zzr zzrVar, zzaf zzafVar) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.measurement.zzbn.zzc(parcelZza, zzrVar);
        com.google.android.gms.internal.measurement.zzbn.zzc(parcelZza, zzafVar);
        zzc(30, parcelZza);
    }

    @Override // com.google.android.gms.measurement.internal.zzgb
    public final void M2(long j3, String str, String str2, String str3) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeLong(j3);
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        parcelZza.writeString(str3);
        zzc(10, parcelZza);
    }

    @Override // com.google.android.gms.measurement.internal.zzgb
    public final void O2(zzr zzrVar) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.measurement.zzbn.zzc(parcelZza, zzrVar);
        zzc(18, parcelZza);
    }

    @Override // com.google.android.gms.measurement.internal.zzgb
    public final List S4(String str, String str2, zzr zzrVar) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        com.google.android.gms.internal.measurement.zzbn.zzc(parcelZza, zzrVar);
        Parcel parcelZzP = zzP(16, parcelZza);
        ArrayList arrayListCreateTypedArrayList = parcelZzP.createTypedArrayList(zzah.CREATOR);
        parcelZzP.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // com.google.android.gms.measurement.internal.zzgb
    public final void W0(zzbg zzbgVar, zzr zzrVar) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.measurement.zzbn.zzc(parcelZza, zzbgVar);
        com.google.android.gms.internal.measurement.zzbn.zzc(parcelZza, zzrVar);
        zzc(1, parcelZza);
    }

    @Override // com.google.android.gms.measurement.internal.zzgb
    public final String W1(zzr zzrVar) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.measurement.zzbn.zzc(parcelZza, zzrVar);
        Parcel parcelZzP = zzP(11, parcelZza);
        String string = parcelZzP.readString();
        parcelZzP.recycle();
        return string;
    }

    @Override // com.google.android.gms.measurement.internal.zzgb
    public final void X0(zzr zzrVar) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.measurement.zzbn.zzc(parcelZza, zzrVar);
        zzc(6, parcelZza);
    }

    @Override // com.google.android.gms.measurement.internal.zzgb
    public final void Z0(zzr zzrVar) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.measurement.zzbn.zzc(parcelZza, zzrVar);
        zzc(26, parcelZza);
    }

    @Override // com.google.android.gms.measurement.internal.zzgb
    public final zzao b4(zzr zzrVar) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.measurement.zzbn.zzc(parcelZza, zzrVar);
        Parcel parcelZzP = zzP(21, parcelZza);
        zzao zzaoVar = (zzao) com.google.android.gms.internal.measurement.zzbn.zzb(parcelZzP, zzao.CREATOR);
        parcelZzP.recycle();
        return zzaoVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzgb
    public final byte[] d1(zzbg zzbgVar, String str) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.measurement.zzbn.zzc(parcelZza, zzbgVar);
        parcelZza.writeString(str);
        Parcel parcelZzP = zzP(9, parcelZza);
        byte[] bArrCreateByteArray = parcelZzP.createByteArray();
        parcelZzP.recycle();
        return bArrCreateByteArray;
    }

    @Override // com.google.android.gms.measurement.internal.zzgb
    public final void e4(Bundle bundle, zzr zzrVar) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.measurement.zzbn.zzc(parcelZza, bundle);
        com.google.android.gms.internal.measurement.zzbn.zzc(parcelZza, zzrVar);
        zzc(19, parcelZza);
    }

    @Override // com.google.android.gms.measurement.internal.zzgb
    public final void e5(zzr zzrVar) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.measurement.zzbn.zzc(parcelZza, zzrVar);
        zzc(20, parcelZza);
    }

    @Override // com.google.android.gms.measurement.internal.zzgb
    public final List h2(zzr zzrVar, boolean z2) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.measurement.zzbn.zzc(parcelZza, zzrVar);
        parcelZza.writeInt(z2 ? 1 : 0);
        Parcel parcelZzP = zzP(7, parcelZza);
        ArrayList arrayListCreateTypedArrayList = parcelZzP.createTypedArrayList(zzpl.CREATOR);
        parcelZzP.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // com.google.android.gms.measurement.internal.zzgb
    public final void n1(zzpl zzplVar, zzr zzrVar) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.measurement.zzbn.zzc(parcelZza, zzplVar);
        com.google.android.gms.internal.measurement.zzbn.zzc(parcelZza, zzrVar);
        zzc(2, parcelZza);
    }

    @Override // com.google.android.gms.measurement.internal.zzgb
    public final void q4(zzr zzrVar) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.measurement.zzbn.zzc(parcelZza, zzrVar);
        zzc(4, parcelZza);
    }

    @Override // com.google.android.gms.measurement.internal.zzgb
    public final List t0(String str, String str2, String str3) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(null);
        parcelZza.writeString(str2);
        parcelZza.writeString(str3);
        Parcel parcelZzP = zzP(17, parcelZza);
        ArrayList arrayListCreateTypedArrayList = parcelZzP.createTypedArrayList(zzah.CREATOR);
        parcelZzP.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // com.google.android.gms.measurement.internal.zzgb
    public final void w3(zzr zzrVar, Bundle bundle, zzge zzgeVar) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.measurement.zzbn.zzc(parcelZza, zzrVar);
        com.google.android.gms.internal.measurement.zzbn.zzc(parcelZza, bundle);
        com.google.android.gms.internal.measurement.zzbn.zzd(parcelZza, zzgeVar);
        zzc(31, parcelZza);
    }
}
