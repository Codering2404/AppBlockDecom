package com.google.android.gms.maps.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzca extends com.google.android.gms.internal.maps.zza implements IUiSettingsDelegate {
    zzca(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.internal.IUiSettingsDelegate");
    }

    @Override // com.google.android.gms.maps.internal.IUiSettingsDelegate
    public final void A2(boolean z2) throws RemoteException {
        Parcel parcelZza = zza();
        int i3 = com.google.android.gms.internal.maps.zzc.zza;
        parcelZza.writeInt(z2 ? 1 : 0);
        zzc(20, parcelZza);
    }

    @Override // com.google.android.gms.maps.internal.IUiSettingsDelegate
    public final void B3(boolean z2) throws RemoteException {
        Parcel parcelZza = zza();
        int i3 = com.google.android.gms.internal.maps.zzc.zza;
        parcelZza.writeInt(z2 ? 1 : 0);
        zzc(7, parcelZza);
    }

    @Override // com.google.android.gms.maps.internal.IUiSettingsDelegate
    public final void T(boolean z2) throws RemoteException {
        Parcel parcelZza = zza();
        int i3 = com.google.android.gms.internal.maps.zzc.zza;
        parcelZza.writeInt(z2 ? 1 : 0);
        zzc(3, parcelZza);
    }

    @Override // com.google.android.gms.maps.internal.IUiSettingsDelegate
    public final void i3(boolean z2) throws RemoteException {
        Parcel parcelZza = zza();
        int i3 = com.google.android.gms.internal.maps.zzc.zza;
        parcelZza.writeInt(z2 ? 1 : 0);
        zzc(6, parcelZza);
    }

    @Override // com.google.android.gms.maps.internal.IUiSettingsDelegate
    public final void j2(boolean z2) throws RemoteException {
        Parcel parcelZza = zza();
        int i3 = com.google.android.gms.internal.maps.zzc.zza;
        parcelZza.writeInt(z2 ? 1 : 0);
        zzc(16, parcelZza);
    }

    @Override // com.google.android.gms.maps.internal.IUiSettingsDelegate
    public final void k3(boolean z2) throws RemoteException {
        Parcel parcelZza = zza();
        int i3 = com.google.android.gms.internal.maps.zzc.zza;
        parcelZza.writeInt(z2 ? 1 : 0);
        zzc(5, parcelZza);
    }

    @Override // com.google.android.gms.maps.internal.IUiSettingsDelegate
    public final void o4(boolean z2) throws RemoteException {
        Parcel parcelZza = zza();
        int i3 = com.google.android.gms.internal.maps.zzc.zza;
        parcelZza.writeInt(z2 ? 1 : 0);
        zzc(4, parcelZza);
    }

    @Override // com.google.android.gms.maps.internal.IUiSettingsDelegate
    public final void p1(boolean z2) throws RemoteException {
        Parcel parcelZza = zza();
        int i3 = com.google.android.gms.internal.maps.zzc.zza;
        parcelZza.writeInt(z2 ? 1 : 0);
        zzc(18, parcelZza);
    }

    @Override // com.google.android.gms.maps.internal.IUiSettingsDelegate
    public final void v3(boolean z2) throws RemoteException {
        Parcel parcelZza = zza();
        int i3 = com.google.android.gms.internal.maps.zzc.zza;
        parcelZza.writeInt(z2 ? 1 : 0);
        zzc(1, parcelZza);
    }

    @Override // com.google.android.gms.maps.internal.IUiSettingsDelegate
    public final void z2(boolean z2) throws RemoteException {
        Parcel parcelZza = zza();
        int i3 = com.google.android.gms.internal.maps.zzc.zza;
        parcelZza.writeInt(z2 ? 1 : 0);
        zzc(2, parcelZza);
    }
}
