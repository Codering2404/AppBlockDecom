package com.google.android.gms.maps.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.TileOverlayOptions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzg extends com.google.android.gms.internal.maps.zza implements IGoogleMapDelegate {
    zzg(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.internal.IGoogleMapDelegate");
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void A3(float f3) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeFloat(f3);
        zzc(92, parcelZza);
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void B0(zzv zzvVar) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.maps.zzc.zze(parcelZza, zzvVar);
        zzc(96, parcelZza);
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void C2(zzr zzrVar) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.maps.zzc.zze(parcelZza, zzrVar);
        zzc(98, parcelZza);
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void E3(zzav zzavVar) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.maps.zzc.zze(parcelZza, zzavVar);
        zzc(30, parcelZza);
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final com.google.android.gms.internal.maps.zzaj G4(PolylineOptions polylineOptions) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.maps.zzc.zzd(parcelZza, polylineOptions);
        Parcel parcelZzJ = zzJ(9, parcelZza);
        com.google.android.gms.internal.maps.zzaj zzajVarZzb = com.google.android.gms.internal.maps.zzai.zzb(parcelZzJ.readStrongBinder());
        parcelZzJ.recycle();
        return zzajVarZzb;
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final IProjectionDelegate H1() throws RemoteException {
        IProjectionDelegate zzbuVar;
        Parcel parcelZzJ = zzJ(26, zza());
        IBinder strongBinder = parcelZzJ.readStrongBinder();
        if (strongBinder == null) {
            zzbuVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.maps.internal.IProjectionDelegate");
            zzbuVar = iInterfaceQueryLocalInterface instanceof IProjectionDelegate ? (IProjectionDelegate) iInterfaceQueryLocalInterface : new zzbu(strongBinder);
        }
        parcelZzJ.recycle();
        return zzbuVar;
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void J3(zzx zzxVar) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.maps.zzc.zze(parcelZza, zzxVar);
        zzc(89, parcelZza);
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void L(zzad zzadVar) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.maps.zzc.zze(parcelZza, zzadVar);
        zzc(32, parcelZza);
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void L0(zzaz zzazVar) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.maps.zzc.zze(parcelZza, zzazVar);
        zzc(37, parcelZza);
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final com.google.android.gms.internal.maps.zzr N0(GroundOverlayOptions groundOverlayOptions) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.maps.zzc.zzd(parcelZza, groundOverlayOptions);
        Parcel parcelZzJ = zzJ(12, parcelZza);
        com.google.android.gms.internal.maps.zzr zzrVarZzb = com.google.android.gms.internal.maps.zzq.zzb(parcelZzJ.readStrongBinder());
        parcelZzJ.recycle();
        return zzrVarZzb;
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void N4(boolean z2) throws RemoteException {
        Parcel parcelZza = zza();
        int i3 = com.google.android.gms.internal.maps.zzc.zza;
        parcelZza.writeInt(z2 ? 1 : 0);
        zzc(22, parcelZza);
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void R0(float f3) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeFloat(f3);
        zzc(93, parcelZza);
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void R2(int i3, int i4, int i5, int i6) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeInt(i3);
        parcelZza.writeInt(i4);
        parcelZza.writeInt(i5);
        parcelZza.writeInt(i6);
        zzc(39, parcelZza);
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void T0(zzt zztVar) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.maps.zzc.zze(parcelZza, zztVar);
        zzc(97, parcelZza);
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void T2(ILocationSourceDelegate iLocationSourceDelegate) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.maps.zzc.zze(parcelZza, iLocationSourceDelegate);
        zzc(24, parcelZza);
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void U0(zzbh zzbhVar) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.maps.zzc.zze(parcelZza, zzbhVar);
        zzc(85, parcelZza);
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void U4(zzbd zzbdVar) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.maps.zzc.zze(parcelZza, zzbdVar);
        zzc(107, parcelZza);
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void V(zzaf zzafVar) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.maps.zzc.zze(parcelZza, zzafVar);
        zzc(86, parcelZza);
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void W(LatLngBounds latLngBounds) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.maps.zzc.zzd(parcelZza, latLngBounds);
        zzc(95, parcelZza);
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void W3(zzar zzarVar) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.maps.zzc.zze(parcelZza, zzarVar);
        zzc(29, parcelZza);
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void X(zzab zzabVar) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.maps.zzc.zze(parcelZza, zzabVar);
        zzc(45, parcelZza);
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final com.google.android.gms.internal.maps.zzl Y(CircleOptions circleOptions) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.maps.zzc.zzd(parcelZza, circleOptions);
        Parcel parcelZzJ = zzJ(35, parcelZza);
        com.google.android.gms.internal.maps.zzl zzlVarZzb = com.google.android.gms.internal.maps.zzk.zzb(parcelZzJ.readStrongBinder());
        parcelZzJ.recycle();
        return zzlVarZzb;
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void Z2(zzp zzpVar) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.maps.zzc.zze(parcelZza, zzpVar);
        zzc(99, parcelZza);
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void a3(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.maps.zzc.zze(parcelZza, iObjectWrapper);
        zzc(4, parcelZza);
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final com.google.android.gms.internal.maps.zzam a5(TileOverlayOptions tileOverlayOptions) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.maps.zzc.zzd(parcelZza, tileOverlayOptions);
        Parcel parcelZzJ = zzJ(13, parcelZza);
        com.google.android.gms.internal.maps.zzam zzamVarZzb = com.google.android.gms.internal.maps.zzal.zzb(parcelZzJ.readStrongBinder());
        parcelZzJ.recycle();
        return zzamVarZzb;
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void c1(int i3) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeInt(i3);
        zzc(16, parcelZza);
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final IUiSettingsDelegate c4() throws RemoteException {
        IUiSettingsDelegate zzcaVar;
        Parcel parcelZzJ = zzJ(25, zza());
        IBinder strongBinder = parcelZzJ.readStrongBinder();
        if (strongBinder == null) {
            zzcaVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
            zzcaVar = iInterfaceQueryLocalInterface instanceof IUiSettingsDelegate ? (IUiSettingsDelegate) iInterfaceQueryLocalInterface : new zzca(strongBinder);
        }
        parcelZzJ.recycle();
        return zzcaVar;
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void clear() throws RemoteException {
        zzc(14, zza());
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final com.google.android.gms.internal.maps.zzad d2(MarkerOptions markerOptions) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.maps.zzc.zzd(parcelZza, markerOptions);
        Parcel parcelZzJ = zzJ(11, parcelZza);
        com.google.android.gms.internal.maps.zzad zzadVarZzb = com.google.android.gms.internal.maps.zzac.zzb(parcelZzJ.readStrongBinder());
        parcelZzJ.recycle();
        return zzadVarZzb;
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final com.google.android.gms.internal.maps.zzag g1(PolygonOptions polygonOptions) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.maps.zzc.zzd(parcelZza, polygonOptions);
        Parcel parcelZzJ = zzJ(10, parcelZza);
        com.google.android.gms.internal.maps.zzag zzagVarZzb = com.google.android.gms.internal.maps.zzaf.zzb(parcelZzJ.readStrongBinder());
        parcelZzJ.recycle();
        return zzagVarZzb;
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final boolean g3(MapStyleOptions mapStyleOptions) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.maps.zzc.zzd(parcelZza, mapStyleOptions);
        Parcel parcelZzJ = zzJ(91, parcelZza);
        boolean zZzf = com.google.android.gms.internal.maps.zzc.zzf(parcelZzJ);
        parcelZzJ.recycle();
        return zZzf;
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void g4(zzbj zzbjVar) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.maps.zzc.zze(parcelZza, zzbjVar);
        zzc(87, parcelZza);
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void h3(IObjectWrapper iObjectWrapper, int i3, zzd zzdVar) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.maps.zzc.zze(parcelZza, iObjectWrapper);
        parcelZza.writeInt(i3);
        com.google.android.gms.internal.maps.zzc.zze(parcelZza, zzdVar);
        zzc(7, parcelZza);
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void i2(String str) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        zzc(61, parcelZza);
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void j() throws RemoteException {
        zzc(8, zza());
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void l1(zzah zzahVar) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.maps.zzc.zze(parcelZza, zzahVar);
        zzc(84, parcelZza);
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void n2(boolean z2) throws RemoteException {
        Parcel parcelZza = zza();
        int i3 = com.google.android.gms.internal.maps.zzc.zza;
        parcelZza.writeInt(z2 ? 1 : 0);
        zzc(41, parcelZza);
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void o0(zzi zziVar) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.maps.zzc.zze(parcelZza, zziVar);
        zzc(33, parcelZza);
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void q2(IObjectWrapper iObjectWrapper, zzd zzdVar) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.maps.zzc.zze(parcelZza, iObjectWrapper);
        com.google.android.gms.internal.maps.zzc.zze(parcelZza, zzdVar);
        zzc(6, parcelZza);
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void r4(zzap zzapVar) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.maps.zzc.zze(parcelZza, zzapVar);
        zzc(42, parcelZza);
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void t3(zzax zzaxVar) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.maps.zzc.zze(parcelZza, zzaxVar);
        zzc(31, parcelZza);
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final CameraPosition u0() throws RemoteException {
        Parcel parcelZzJ = zzJ(1, zza());
        CameraPosition cameraPosition = (CameraPosition) com.google.android.gms.internal.maps.zzc.zza(parcelZzJ, CameraPosition.CREATOR);
        parcelZzJ.recycle();
        return cameraPosition;
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void v0(zzbf zzbfVar) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.maps.zzc.zze(parcelZza, zzbfVar);
        zzc(80, parcelZza);
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void w1(zzan zzanVar) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.maps.zzc.zze(parcelZza, zzanVar);
        zzc(28, parcelZza);
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final boolean x2(boolean z2) throws RemoteException {
        Parcel parcelZza = zza();
        int i3 = com.google.android.gms.internal.maps.zzc.zza;
        parcelZza.writeInt(z2 ? 1 : 0);
        Parcel parcelZzJ = zzJ(20, parcelZza);
        boolean zZzf = com.google.android.gms.internal.maps.zzc.zzf(parcelZzJ);
        parcelZzJ.recycle();
        return zZzf;
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void y1(zzz zzzVar) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.maps.zzc.zze(parcelZza, zzzVar);
        zzc(83, parcelZza);
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void y3(boolean z2) throws RemoteException {
        Parcel parcelZza = zza();
        int i3 = com.google.android.gms.internal.maps.zzc.zza;
        parcelZza.writeInt(z2 ? 1 : 0);
        zzc(18, parcelZza);
    }
}
