package com.google.maps.android.compose;

import android.location.Location;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.IndoorBuilding;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PointOfInterest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata
public final class MapPropertiesNode implements MapNode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final GoogleMap f90931a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private MapClickListeners f90932b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Density f90933c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private LayoutDirection f90934d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f90935e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private CameraPositionState f90936f;

    public MapPropertiesNode(GoogleMap map, CameraPositionState cameraPositionState, String str, MapClickListeners clickListeners, Density density, LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(map, "map");
        Intrinsics.checkNotNullParameter(cameraPositionState, "cameraPositionState");
        Intrinsics.checkNotNullParameter(clickListeners, "clickListeners");
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        this.f90931a = map;
        this.f90932b = clickListeners;
        this.f90933c = density;
        this.f90934d = layoutDirection;
        cameraPositionState.u(map);
        if (str != null) {
            map.o(str);
        }
        this.f90935e = str;
        this.f90936f = cameraPositionState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(MapPropertiesNode this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.f90936f.w(false);
        CameraPositionState cameraPositionState = this$0.f90936f;
        CameraPosition cameraPositionJ = this$0.f90931a.j();
        Intrinsics.checkNotNullExpressionValue(cameraPositionJ, "map.cameraPosition");
        cameraPositionState.z(cameraPositionJ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(MapPropertiesNode this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.f90936f.w(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(MapPropertiesNode this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.f90936f.s(CameraMoveStartedReason.f90589b.a(i3));
        this$0.f90936f.w(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(MapPropertiesNode this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        CameraPositionState cameraPositionState = this$0.f90936f;
        CameraPosition cameraPositionJ = this$0.f90931a.j();
        Intrinsics.checkNotNullExpressionValue(cameraPositionJ, "map.cameraPosition");
        cameraPositionState.z(cameraPositionJ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(MapPropertiesNode this$0, LatLng it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.f90932b.b().invoke(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(MapPropertiesNode this$0, LatLng it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.f90932b.d().invoke(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(MapPropertiesNode this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.f90932b.c().invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean x(MapPropertiesNode this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        return ((Boolean) this$0.f90932b.e().invoke()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(MapPropertiesNode this$0, Location it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.f90932b.f().invoke(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(MapPropertiesNode this$0, PointOfInterest it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.f90932b.g().invoke(it);
    }

    public final void A(CameraPositionState value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (Intrinsics.areEqual(value, this.f90936f)) {
            return;
        }
        this.f90936f.u(null);
        this.f90936f = value;
        value.u(this.f90931a);
    }

    public final void B(MapClickListeners mapClickListeners) {
        Intrinsics.checkNotNullParameter(mapClickListeners, "<set-?>");
        this.f90932b = mapClickListeners;
    }

    public final void C(String str) {
        this.f90935e = str;
        this.f90931a.o(str);
    }

    public final void D(Density density) {
        Intrinsics.checkNotNullParameter(density, "<set-?>");
        this.f90933c = density;
    }

    public final void E(LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(layoutDirection, "<set-?>");
        this.f90934d = layoutDirection;
    }

    @Override // com.google.maps.android.compose.MapNode
    public void a() {
        this.f90931a.y(new GoogleMap.OnCameraIdleListener() { // from class: com.google.maps.android.compose.j
            @Override // com.google.android.gms.maps.GoogleMap.OnCameraIdleListener
            public final void a() {
                MapPropertiesNode.q(this.f91309a);
            }
        });
        this.f90931a.z(new GoogleMap.OnCameraMoveCanceledListener() { // from class: com.google.maps.android.compose.k
            @Override // com.google.android.gms.maps.GoogleMap.OnCameraMoveCanceledListener
            public final void a() {
                MapPropertiesNode.r(this.f91310a);
            }
        });
        this.f90931a.B(new GoogleMap.OnCameraMoveStartedListener() { // from class: com.google.maps.android.compose.l
            @Override // com.google.android.gms.maps.GoogleMap.OnCameraMoveStartedListener
            public final void a(int i3) {
                MapPropertiesNode.s(this.f91311a, i3);
            }
        });
        this.f90931a.A(new GoogleMap.OnCameraMoveListener() { // from class: com.google.maps.android.compose.m
            @Override // com.google.android.gms.maps.GoogleMap.OnCameraMoveListener
            public final void a() {
                MapPropertiesNode.t(this.f91312a);
            }
        });
        this.f90931a.I(new GoogleMap.OnMapClickListener() { // from class: com.google.maps.android.compose.n
            @Override // com.google.android.gms.maps.GoogleMap.OnMapClickListener
            public final void a(LatLng latLng) {
                MapPropertiesNode.u(this.f91313a, latLng);
            }
        });
        this.f90931a.K(new GoogleMap.OnMapLongClickListener() { // from class: com.google.maps.android.compose.o
            @Override // com.google.android.gms.maps.GoogleMap.OnMapLongClickListener
            public final void a(LatLng latLng) {
                MapPropertiesNode.v(this.f91314a, latLng);
            }
        });
        this.f90931a.J(new GoogleMap.OnMapLoadedCallback() { // from class: com.google.maps.android.compose.p
            @Override // com.google.android.gms.maps.GoogleMap.OnMapLoadedCallback
            public final void a() {
                MapPropertiesNode.w(this.f91315a);
            }
        });
        this.f90931a.N(new GoogleMap.OnMyLocationButtonClickListener() { // from class: com.google.maps.android.compose.q
            @Override // com.google.android.gms.maps.GoogleMap.OnMyLocationButtonClickListener
            public final boolean a() {
                return MapPropertiesNode.x(this.f91316a);
            }
        });
        this.f90931a.O(new GoogleMap.OnMyLocationClickListener() { // from class: com.google.maps.android.compose.s
            @Override // com.google.android.gms.maps.GoogleMap.OnMyLocationClickListener
            public final void a(Location location) {
                MapPropertiesNode.y(this.f91317a, location);
            }
        });
        this.f90931a.P(new GoogleMap.OnPoiClickListener() { // from class: com.google.maps.android.compose.t
            @Override // com.google.android.gms.maps.GoogleMap.OnPoiClickListener
            public final void a(PointOfInterest pointOfInterest) {
                MapPropertiesNode.z(this.f91395a, pointOfInterest);
            }
        });
        this.f90931a.E(new GoogleMap.OnIndoorStateChangeListener() { // from class: com.google.maps.android.compose.MapPropertiesNode$onAttached$11
            @Override // com.google.android.gms.maps.GoogleMap.OnIndoorStateChangeListener
            public void a(IndoorBuilding building) {
                Intrinsics.checkNotNullParameter(building, "building");
                this.f90937a.n().a().a(building);
            }

            @Override // com.google.android.gms.maps.GoogleMap.OnIndoorStateChangeListener
            public void b() {
                this.f90937a.n().a().b();
            }
        });
    }

    @Override // com.google.maps.android.compose.MapNode
    public void b() {
        this.f90936f.u(null);
    }

    @Override // com.google.maps.android.compose.MapNode
    public void c() {
        this.f90936f.u(null);
    }

    public final MapClickListeners n() {
        return this.f90932b;
    }

    public final Density o() {
        return this.f90933c;
    }

    public final LayoutDirection p() {
        return this.f90934d;
    }
}
