package com.google.android.gms.maps.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.facebook.share.HKJ.pnxuebdT;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.StreetViewPanoramaOptions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zze extends com.google.android.gms.internal.maps.zza implements zzf {
    zze(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.internal.ICreator");
    }

    @Override // com.google.android.gms.maps.internal.zzf
    public final void P2(IObjectWrapper iObjectWrapper, int i3) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.maps.zzc.zze(parcelZza, iObjectWrapper);
        parcelZza.writeInt(i3);
        zzc(10, parcelZza);
    }

    @Override // com.google.android.gms.maps.internal.zzf
    public final IMapViewDelegate f4(IObjectWrapper iObjectWrapper, GoogleMapOptions googleMapOptions) throws RemoteException {
        IMapViewDelegate zzlVar;
        Parcel parcelZza = zza();
        com.google.android.gms.internal.maps.zzc.zze(parcelZza, iObjectWrapper);
        com.google.android.gms.internal.maps.zzc.zzd(parcelZza, googleMapOptions);
        Parcel parcelZzJ = zzJ(3, parcelZza);
        IBinder strongBinder = parcelZzJ.readStrongBinder();
        if (strongBinder == null) {
            zzlVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.maps.internal.IMapViewDelegate");
            zzlVar = iInterfaceQueryLocalInterface instanceof IMapViewDelegate ? (IMapViewDelegate) iInterfaceQueryLocalInterface : new zzl(strongBinder);
        }
        parcelZzJ.recycle();
        return zzlVar;
    }

    @Override // com.google.android.gms.maps.internal.zzf
    public final IStreetViewPanoramaViewDelegate m1(IObjectWrapper iObjectWrapper, StreetViewPanoramaOptions streetViewPanoramaOptions) throws RemoteException {
        IStreetViewPanoramaViewDelegate zzbzVar;
        Parcel parcelZza = zza();
        com.google.android.gms.internal.maps.zzc.zze(parcelZza, iObjectWrapper);
        com.google.android.gms.internal.maps.zzc.zzd(parcelZza, streetViewPanoramaOptions);
        Parcel parcelZzJ = zzJ(7, parcelZza);
        IBinder strongBinder = parcelZzJ.readStrongBinder();
        if (strongBinder == null) {
            zzbzVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate");
            zzbzVar = iInterfaceQueryLocalInterface instanceof IStreetViewPanoramaViewDelegate ? (IStreetViewPanoramaViewDelegate) iInterfaceQueryLocalInterface : new zzbz(strongBinder);
        }
        parcelZzJ.recycle();
        return zzbzVar;
    }

    @Override // com.google.android.gms.maps.internal.zzf
    public final void y2(IObjectWrapper iObjectWrapper, int i3) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.maps.zzc.zze(parcelZza, iObjectWrapper);
        parcelZza.writeInt(18020000);
        zzc(6, parcelZza);
    }

    @Override // com.google.android.gms.maps.internal.zzf
    public final int zzd() throws RemoteException {
        Parcel parcelZzJ = zzJ(9, zza());
        int i3 = parcelZzJ.readInt();
        parcelZzJ.recycle();
        return i3;
    }

    @Override // com.google.android.gms.maps.internal.zzf
    public final ICameraUpdateFactoryDelegate zze() throws RemoteException {
        ICameraUpdateFactoryDelegate zzbVar;
        Parcel parcelZzJ = zzJ(4, zza());
        IBinder strongBinder = parcelZzJ.readStrongBinder();
        if (strongBinder == null) {
            zzbVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
            zzbVar = iInterfaceQueryLocalInterface instanceof ICameraUpdateFactoryDelegate ? (ICameraUpdateFactoryDelegate) iInterfaceQueryLocalInterface : new zzb(strongBinder);
        }
        parcelZzJ.recycle();
        return zzbVar;
    }

    @Override // com.google.android.gms.maps.internal.zzf
    public final IMapFragmentDelegate zzf(IObjectWrapper iObjectWrapper) throws RemoteException {
        IMapFragmentDelegate zzkVar;
        Parcel parcelZza = zza();
        com.google.android.gms.internal.maps.zzc.zze(parcelZza, iObjectWrapper);
        Parcel parcelZzJ = zzJ(2, parcelZza);
        IBinder strongBinder = parcelZzJ.readStrongBinder();
        if (strongBinder == null) {
            zzkVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.maps.internal.IMapFragmentDelegate");
            zzkVar = iInterfaceQueryLocalInterface instanceof IMapFragmentDelegate ? (IMapFragmentDelegate) iInterfaceQueryLocalInterface : new zzk(strongBinder);
        }
        parcelZzJ.recycle();
        return zzkVar;
    }

    @Override // com.google.android.gms.maps.internal.zzf
    public final com.google.android.gms.internal.maps.zzi zzj() throws RemoteException {
        Parcel parcelZzJ = zzJ(5, zza());
        com.google.android.gms.internal.maps.zzi zziVarZzb = com.google.android.gms.internal.maps.zzh.zzb(parcelZzJ.readStrongBinder());
        parcelZzJ.recycle();
        return zziVarZzb;
    }

    @Override // com.google.android.gms.maps.internal.zzf
    public final void zzm(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.maps.zzc.zze(parcelZza, iObjectWrapper);
        zzc(11, parcelZza);
    }

    @Override // com.google.android.gms.maps.internal.zzf
    public final IStreetViewPanoramaFragmentDelegate zzh(IObjectWrapper iObjectWrapper) throws RemoteException {
        IStreetViewPanoramaFragmentDelegate zzbyVar;
        Parcel parcelZza = zza();
        com.google.android.gms.internal.maps.zzc.zze(parcelZza, iObjectWrapper);
        Parcel parcelZzJ = zzJ(8, parcelZza);
        IBinder strongBinder = parcelZzJ.readStrongBinder();
        if (strongBinder == null) {
            zzbyVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface(pnxuebdT.uRq);
            if (iInterfaceQueryLocalInterface instanceof IStreetViewPanoramaFragmentDelegate) {
                zzbyVar = (IStreetViewPanoramaFragmentDelegate) iInterfaceQueryLocalInterface;
            } else {
                zzbyVar = new zzby(strongBinder);
            }
        }
        parcelZzJ.recycle();
        return zzbyVar;
    }
}
