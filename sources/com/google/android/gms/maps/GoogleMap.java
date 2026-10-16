package com.google.android.gms.maps;

import android.graphics.Bitmap;
import android.location.Location;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.model.AdvancedMarker;
import com.google.android.gms.maps.model.AdvancedMarkerOptions;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.GroundOverlay;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.IndoorBuilding;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MapCapabilities;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PointOfInterest;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.maps.model.TileOverlay;
import com.google.android.gms.maps.model.TileOverlayOptions;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public class GoogleMap {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final IGoogleMapDelegate f73041a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map f73042b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map f73043c = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private UiSettings f73044d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface CancelableCallback {
        void a();

        void onCancel();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface InfoWindowAdapter {
        View a(Marker marker);

        View b(Marker marker);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Deprecated
    public interface OnCameraChangeListener {
        void a(CameraPosition cameraPosition);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface OnCameraIdleListener {
        void a();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface OnCameraMoveCanceledListener {
        void a();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface OnCameraMoveListener {
        void a();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface OnCameraMoveStartedListener {
        void a(int i3);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface OnCircleClickListener {
        void a(Circle circle);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface OnGroundOverlayClickListener {
        void a(GroundOverlay groundOverlay);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface OnIndoorStateChangeListener {
        void a(IndoorBuilding indoorBuilding);

        void b();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface OnInfoWindowClickListener {
        void a(Marker marker);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface OnInfoWindowCloseListener {
        void a(Marker marker);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface OnInfoWindowLongClickListener {
        void a(Marker marker);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface OnMapCapabilitiesChangedListener {
        void a(MapCapabilities mapCapabilities);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface OnMapClickListener {
        void a(LatLng latLng);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface OnMapLoadedCallback {
        void a();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface OnMapLongClickListener {
        void a(LatLng latLng);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface OnMarkerClickListener {
        boolean a(Marker marker);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface OnMarkerDragListener {
        void a(Marker marker);

        void b(Marker marker);

        void c(Marker marker);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface OnMyLocationButtonClickListener {
        boolean a();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Deprecated
    public interface OnMyLocationChangeListener {
        void a(Location location);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface OnMyLocationClickListener {
        void a(Location location);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface OnPoiClickListener {
        void a(PointOfInterest pointOfInterest);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface OnPolygonClickListener {
        void a(Polygon polygon);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface OnPolylineClickListener {
        void a(Polyline polyline);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface SnapshotReadyCallback {
        void a(Bitmap bitmap);
    }

    public GoogleMap(IGoogleMapDelegate iGoogleMapDelegate) {
        this.f73041a = (IGoogleMapDelegate) Preconditions.m(iGoogleMapDelegate);
    }

    public final void A(OnCameraMoveListener onCameraMoveListener) {
        try {
            if (onCameraMoveListener == null) {
                this.f73041a.T0(null);
            } else {
                this.f73041a.T0(new zzw(this, onCameraMoveListener));
            }
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public final void B(OnCameraMoveStartedListener onCameraMoveStartedListener) {
        try {
            if (onCameraMoveStartedListener == null) {
                this.f73041a.B0(null);
            } else {
                this.f73041a.B0(new zzv(this, onCameraMoveStartedListener));
            }
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public final void C(OnCircleClickListener onCircleClickListener) {
        try {
            if (onCircleClickListener == null) {
                this.f73041a.J3(null);
            } else {
                this.f73041a.J3(new zzn(this, onCircleClickListener));
            }
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public final void D(OnGroundOverlayClickListener onGroundOverlayClickListener) {
        try {
            if (onGroundOverlayClickListener == null) {
                this.f73041a.y1(null);
            } else {
                this.f73041a.y1(new zzm(this, onGroundOverlayClickListener));
            }
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public final void E(OnIndoorStateChangeListener onIndoorStateChangeListener) {
        try {
            if (onIndoorStateChangeListener == null) {
                this.f73041a.X(null);
            } else {
                this.f73041a.X(new zzk(this, onIndoorStateChangeListener));
            }
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public final void F(OnInfoWindowClickListener onInfoWindowClickListener) {
        try {
            if (onInfoWindowClickListener == null) {
                this.f73041a.L(null);
            } else {
                this.f73041a.L(new zzc(this, onInfoWindowClickListener));
            }
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public final void G(OnInfoWindowCloseListener onInfoWindowCloseListener) {
        try {
            if (onInfoWindowCloseListener == null) {
                this.f73041a.V(null);
            } else {
                this.f73041a.V(new zze(this, onInfoWindowCloseListener));
            }
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public final void H(OnInfoWindowLongClickListener onInfoWindowLongClickListener) {
        try {
            if (onInfoWindowLongClickListener == null) {
                this.f73041a.l1(null);
            } else {
                this.f73041a.l1(new zzd(this, onInfoWindowLongClickListener));
            }
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public final void I(OnMapClickListener onMapClickListener) {
        try {
            if (onMapClickListener == null) {
                this.f73041a.w1(null);
            } else {
                this.f73041a.w1(new zzz(this, onMapClickListener));
            }
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void J(OnMapLoadedCallback onMapLoadedCallback) {
        try {
            if (onMapLoadedCallback == null) {
                this.f73041a.r4(null);
            } else {
                this.f73041a.r4(new zzj(this, onMapLoadedCallback));
            }
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public final void K(OnMapLongClickListener onMapLongClickListener) {
        try {
            if (onMapLongClickListener == null) {
                this.f73041a.W3(null);
            } else {
                this.f73041a.W3(new zzaa(this, onMapLongClickListener));
            }
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public final void L(OnMarkerClickListener onMarkerClickListener) {
        try {
            if (onMarkerClickListener == null) {
                this.f73041a.E3(null);
            } else {
                this.f73041a.E3(new zza(this, onMarkerClickListener));
            }
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public final void M(OnMarkerDragListener onMarkerDragListener) {
        try {
            if (onMarkerDragListener == null) {
                this.f73041a.t3(null);
            } else {
                this.f73041a.t3(new zzb(this, onMarkerDragListener));
            }
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public final void N(OnMyLocationButtonClickListener onMyLocationButtonClickListener) {
        try {
            if (onMyLocationButtonClickListener == null) {
                this.f73041a.L0(null);
            } else {
                this.f73041a.L0(new zzh(this, onMyLocationButtonClickListener));
            }
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public final void O(OnMyLocationClickListener onMyLocationClickListener) {
        try {
            if (onMyLocationClickListener == null) {
                this.f73041a.U4(null);
            } else {
                this.f73041a.U4(new zzi(this, onMyLocationClickListener));
            }
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public final void P(OnPoiClickListener onPoiClickListener) {
        try {
            if (onPoiClickListener == null) {
                this.f73041a.v0(null);
            } else {
                this.f73041a.v0(new zzr(this, onPoiClickListener));
            }
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public final void Q(OnPolygonClickListener onPolygonClickListener) {
        try {
            if (onPolygonClickListener == null) {
                this.f73041a.U0(null);
            } else {
                this.f73041a.U0(new zzo(this, onPolygonClickListener));
            }
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public final void R(OnPolylineClickListener onPolylineClickListener) {
        try {
            if (onPolylineClickListener == null) {
                this.f73041a.g4(null);
            } else {
                this.f73041a.g4(new zzp(this, onPolylineClickListener));
            }
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public final void S(int i3, int i4, int i5, int i6) {
        try {
            this.f73041a.R2(i3, i4, i5, i6);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public final void T(boolean z2) {
        try {
            this.f73041a.y3(z2);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public final void U() {
        try {
            this.f73041a.j();
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public final Circle a(CircleOptions circleOptions) {
        try {
            Preconditions.n(circleOptions, "CircleOptions must not be null.");
            return new Circle(this.f73041a.Y(circleOptions));
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public final GroundOverlay b(GroundOverlayOptions groundOverlayOptions) {
        try {
            Preconditions.n(groundOverlayOptions, "GroundOverlayOptions must not be null.");
            com.google.android.gms.internal.maps.zzr zzrVarN0 = this.f73041a.N0(groundOverlayOptions);
            if (zzrVarN0 != null) {
                return new GroundOverlay(zzrVarN0);
            }
            return null;
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public final Marker c(MarkerOptions markerOptions) {
        if (markerOptions instanceof AdvancedMarkerOptions) {
            markerOptions.b3(1);
        }
        try {
            Preconditions.n(markerOptions, "MarkerOptions must not be null.");
            com.google.android.gms.internal.maps.zzad zzadVarD2 = this.f73041a.d2(markerOptions);
            if (zzadVarD2 != null) {
                return markerOptions.a3() == 1 ? new AdvancedMarker(zzadVarD2) : new Marker(zzadVarD2);
            }
            return null;
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public final Polygon d(PolygonOptions polygonOptions) {
        try {
            Preconditions.n(polygonOptions, "PolygonOptions must not be null");
            return new Polygon(this.f73041a.g1(polygonOptions));
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public final Polyline e(PolylineOptions polylineOptions) {
        try {
            Preconditions.n(polylineOptions, "PolylineOptions must not be null");
            return new Polyline(this.f73041a.G4(polylineOptions));
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public final TileOverlay f(TileOverlayOptions tileOverlayOptions) {
        try {
            Preconditions.n(tileOverlayOptions, "TileOverlayOptions must not be null.");
            com.google.android.gms.internal.maps.zzam zzamVarA5 = this.f73041a.a5(tileOverlayOptions);
            if (zzamVarA5 != null) {
                return new TileOverlay(zzamVarA5);
            }
            return null;
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public final void g(CameraUpdate cameraUpdate, int i3, CancelableCallback cancelableCallback) {
        try {
            Preconditions.n(cameraUpdate, "CameraUpdate must not be null.");
            this.f73041a.h3(cameraUpdate.a(), i3, cancelableCallback == null ? null : new zzab(cancelableCallback));
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public final void h(CameraUpdate cameraUpdate, CancelableCallback cancelableCallback) {
        try {
            Preconditions.n(cameraUpdate, "CameraUpdate must not be null.");
            this.f73041a.q2(cameraUpdate.a(), cancelableCallback == null ? null : new zzab(cancelableCallback));
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public final void i() {
        try {
            this.f73041a.clear();
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public final CameraPosition j() {
        try {
            return this.f73041a.u0();
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public final Projection k() {
        try {
            return new Projection(this.f73041a.H1());
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public final UiSettings l() {
        try {
            if (this.f73044d == null) {
                this.f73044d = new UiSettings(this.f73041a.c4());
            }
            return this.f73044d;
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public final void m(CameraUpdate cameraUpdate) {
        try {
            Preconditions.n(cameraUpdate, "CameraUpdate must not be null.");
            this.f73041a.a3(cameraUpdate.a());
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public final void n(boolean z2) {
        try {
            this.f73041a.n2(z2);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public final void o(String str) {
        try {
            this.f73041a.i2(str);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public final boolean p(boolean z2) {
        try {
            return this.f73041a.x2(z2);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public final void q(InfoWindowAdapter infoWindowAdapter) {
        try {
            if (infoWindowAdapter == null) {
                this.f73041a.o0(null);
            } else {
                this.f73041a.o0(new zzf(this, infoWindowAdapter));
            }
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void r(LatLngBounds latLngBounds) {
        try {
            this.f73041a.W(latLngBounds);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public final void s(LocationSource locationSource) {
        try {
            if (locationSource == null) {
                this.f73041a.T2(null);
            } else {
                this.f73041a.T2(new zzt(this, locationSource));
            }
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public boolean t(MapStyleOptions mapStyleOptions) {
        try {
            return this.f73041a.g3(mapStyleOptions);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public final void u(int i3) {
        try {
            this.f73041a.c1(i3);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void v(float f3) {
        try {
            this.f73041a.R0(f3);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void w(float f3) {
        try {
            this.f73041a.A3(f3);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public final void x(boolean z2) {
        try {
            this.f73041a.N4(z2);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public final void y(OnCameraIdleListener onCameraIdleListener) {
        try {
            if (onCameraIdleListener == null) {
                this.f73041a.Z2(null);
            } else {
                this.f73041a.Z2(new zzy(this, onCameraIdleListener));
            }
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public final void z(OnCameraMoveCanceledListener onCameraMoveCanceledListener) {
        try {
            if (onCameraMoveCanceledListener == null) {
                this.f73041a.C2(null);
            } else {
                this.f73041a.C2(new zzx(this, onCameraMoveCanceledListener));
            }
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }
}
