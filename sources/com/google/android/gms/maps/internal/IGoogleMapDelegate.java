package com.google.android.gms.maps.internal;

import android.os.IInterface;
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
public interface IGoogleMapDelegate extends IInterface {
    void A3(float f3);

    void B0(zzv zzvVar);

    void C2(zzr zzrVar);

    void E3(zzav zzavVar);

    com.google.android.gms.internal.maps.zzaj G4(PolylineOptions polylineOptions);

    IProjectionDelegate H1();

    void J3(zzx zzxVar);

    void L(zzad zzadVar);

    void L0(zzaz zzazVar);

    com.google.android.gms.internal.maps.zzr N0(GroundOverlayOptions groundOverlayOptions);

    void N4(boolean z2);

    void R0(float f3);

    void R2(int i3, int i4, int i5, int i6);

    void T0(zzt zztVar);

    void T2(ILocationSourceDelegate iLocationSourceDelegate);

    void U0(zzbh zzbhVar);

    void U4(zzbd zzbdVar);

    void V(zzaf zzafVar);

    void W(LatLngBounds latLngBounds);

    void W3(zzar zzarVar);

    void X(zzab zzabVar);

    com.google.android.gms.internal.maps.zzl Y(CircleOptions circleOptions);

    void Z2(zzp zzpVar);

    void a3(IObjectWrapper iObjectWrapper);

    com.google.android.gms.internal.maps.zzam a5(TileOverlayOptions tileOverlayOptions);

    void c1(int i3);

    IUiSettingsDelegate c4();

    void clear();

    com.google.android.gms.internal.maps.zzad d2(MarkerOptions markerOptions);

    com.google.android.gms.internal.maps.zzag g1(PolygonOptions polygonOptions);

    boolean g3(MapStyleOptions mapStyleOptions);

    void g4(zzbj zzbjVar);

    void h3(IObjectWrapper iObjectWrapper, int i3, zzd zzdVar);

    void i2(String str);

    void j();

    void l1(zzah zzahVar);

    void n2(boolean z2);

    void o0(zzi zziVar);

    void q2(IObjectWrapper iObjectWrapper, zzd zzdVar);

    void r4(zzap zzapVar);

    void t3(zzax zzaxVar);

    CameraPosition u0();

    void v0(zzbf zzbfVar);

    void w1(zzan zzanVar);

    boolean x2(boolean z2);

    void y1(zzz zzzVar);

    void y3(boolean z2);
}
