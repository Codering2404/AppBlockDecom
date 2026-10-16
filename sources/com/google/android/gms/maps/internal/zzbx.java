package com.google.android.gms.maps.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.StreetViewPanoramaLocation;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbx extends com.google.android.gms.internal.maps.zza implements IStreetViewPanoramaDelegate {
    zzbx(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
    }

    @Override // com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate
    public final void E2(boolean z2) throws RemoteException {
        Parcel parcelZza = zza();
        int i3 = com.google.android.gms.internal.maps.zzc.zza;
        parcelZza.writeInt(z2 ? 1 : 0);
        zzc(2, parcelZza);
    }

    @Override // com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate
    public final void I1(zzbl zzblVar) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.maps.zzc.zze(parcelZza, zzblVar);
        zzc(16, parcelZza);
    }

    @Override // com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate
    public final void J2(zzbn zzbnVar) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.maps.zzc.zze(parcelZza, zzbnVar);
        zzc(15, parcelZza);
    }

    @Override // com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate
    public final void P(zzbr zzbrVar) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.maps.zzc.zze(parcelZza, zzbrVar);
        zzc(20, parcelZza);
    }

    @Override // com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate
    public final void Z3(boolean z2) throws RemoteException {
        Parcel parcelZza = zza();
        int i3 = com.google.android.gms.internal.maps.zzc.zza;
        parcelZza.writeInt(z2 ? 1 : 0);
        zzc(4, parcelZza);
    }

    @Override // com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate
    public final void d3(boolean z2) throws RemoteException {
        Parcel parcelZza = zza();
        int i3 = com.google.android.gms.internal.maps.zzc.zza;
        parcelZza.writeInt(z2 ? 1 : 0);
        zzc(1, parcelZza);
    }

    @Override // com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate
    public final void o3(zzbp zzbpVar) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.maps.zzc.zze(parcelZza, zzbpVar);
        zzc(17, parcelZza);
    }

    @Override // com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate
    public final StreetViewPanoramaLocation r0() throws RemoteException {
        Parcel parcelZzJ = zzJ(14, zza());
        StreetViewPanoramaLocation streetViewPanoramaLocation = (StreetViewPanoramaLocation) com.google.android.gms.internal.maps.zzc.zza(parcelZzJ, StreetViewPanoramaLocation.CREATOR);
        parcelZzJ.recycle();
        return streetViewPanoramaLocation;
    }

    @Override // com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate
    public final void z1(boolean z2) throws RemoteException {
        Parcel parcelZza = zza();
        int i3 = com.google.android.gms.internal.maps.zzc.zza;
        parcelZza.writeInt(z2 ? 1 : 0);
        zzc(3, parcelZza);
    }
}
