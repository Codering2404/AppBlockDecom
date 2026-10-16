package com.google.android.gms.maps.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.maps.StreetViewPanoramaOptions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzby extends com.google.android.gms.internal.maps.zza implements IStreetViewPanoramaFragmentDelegate {
    zzby(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate");
    }

    @Override // com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate
    public final void B(zzbt zzbtVar) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.maps.zzc.zze(parcelZza, zzbtVar);
        zzc(12, parcelZza);
    }

    @Override // com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate
    public final void d() throws RemoteException {
        zzc(7, zza());
    }

    @Override // com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate
    public final void onCreate(Bundle bundle) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.maps.zzc.zzd(parcelZza, bundle);
        zzc(3, parcelZza);
    }

    @Override // com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate
    public final void onDestroy() throws RemoteException {
        zzc(8, zza());
    }

    @Override // com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate
    public final void onLowMemory() throws RemoteException {
        zzc(9, zza());
    }

    @Override // com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate
    public final void onPause() throws RemoteException {
        zzc(6, zza());
    }

    @Override // com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate
    public final void onResume() throws RemoteException {
        zzc(5, zza());
    }

    @Override // com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate
    public final void onSaveInstanceState(Bundle bundle) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.maps.zzc.zzd(parcelZza, bundle);
        Parcel parcelZzJ = zzJ(10, parcelZza);
        if (parcelZzJ.readInt() != 0) {
            bundle.readFromParcel(parcelZzJ);
        }
        parcelZzJ.recycle();
    }

    @Override // com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate
    public final void onStart() throws RemoteException {
        zzc(13, zza());
    }

    @Override // com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate
    public final void onStop() throws RemoteException {
        zzc(14, zza());
    }

    @Override // com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate
    public final IObjectWrapper t(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, Bundle bundle) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.maps.zzc.zze(parcelZza, iObjectWrapper);
        com.google.android.gms.internal.maps.zzc.zze(parcelZza, iObjectWrapper2);
        com.google.android.gms.internal.maps.zzc.zzd(parcelZza, bundle);
        Parcel parcelZzJ = zzJ(4, parcelZza);
        IObjectWrapper iObjectWrapperX3 = IObjectWrapper.Stub.x3(parcelZzJ.readStrongBinder());
        parcelZzJ.recycle();
        return iObjectWrapperX3;
    }

    @Override // com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate
    public final void u3(IObjectWrapper iObjectWrapper, StreetViewPanoramaOptions streetViewPanoramaOptions, Bundle bundle) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.maps.zzc.zze(parcelZza, iObjectWrapper);
        com.google.android.gms.internal.maps.zzc.zzd(parcelZza, streetViewPanoramaOptions);
        com.google.android.gms.internal.maps.zzc.zzd(parcelZza, bundle);
        zzc(2, parcelZza);
    }
}
