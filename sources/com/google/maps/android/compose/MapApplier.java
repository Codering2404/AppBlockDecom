package com.google.maps.android.compose;

import androidx.compose.runtime.AbstractApplier;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.GroundOverlay;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.Polyline;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
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
public final class MapApplier extends AbstractApplier<MapNode> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final GoogleMap f90864d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final MapView f90865e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List f90866f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MapApplier(GoogleMap map, MapView mapView) {
        super(MapNodeRoot.f90919a);
        Intrinsics.checkNotNullParameter(map, "map");
        Intrinsics.checkNotNullParameter(mapView, "mapView");
        this.f90864d = map;
        this.f90865e = mapView;
        this.f90866f = new ArrayList();
        H();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(MapApplier this$0, Polyline polyline) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(polyline, "polyline");
        Iterator it = this$0.f90866f.iterator();
        Function1 function1N = null;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            MapNode mapNode = (MapNode) it.next();
            if (mapNode instanceof PolylineNode) {
                PolylineNode polylineNode = (PolylineNode) mapNode;
                if (Intrinsics.areEqual(polylineNode.e(), polyline)) {
                    function1N = polylineNode.d();
                    break;
                }
            }
            if (mapNode instanceof InputHandlerNode) {
                function1N = ((InputHandlerNode) mapNode).n();
            }
        }
        if (function1N != null) {
            function1N.invoke(polyline);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean B(MapApplier this$0, Marker marker) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(marker, "marker");
        Iterator it = this$0.f90866f.iterator();
        Function1 function1I = null;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            MapNode mapNode = (MapNode) it.next();
            if (mapNode instanceof MarkerNode) {
                MarkerNode markerNode = (MarkerNode) mapNode;
                if (Intrinsics.areEqual(markerNode.g(), marker)) {
                    function1I = markerNode.l();
                    break;
                }
            }
            if (mapNode instanceof InputHandlerNode) {
                function1I = ((InputHandlerNode) mapNode).i();
            }
        }
        if (function1I != null) {
            return ((Boolean) function1I.invoke(marker)).booleanValue();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(MapApplier this$0, Marker marker) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(marker, "marker");
        Iterator it = this$0.f90866f.iterator();
        Function1 function1F = null;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            MapNode mapNode = (MapNode) it.next();
            if (mapNode instanceof MarkerNode) {
                MarkerNode markerNode = (MarkerNode) mapNode;
                if (Intrinsics.areEqual(markerNode.g(), marker)) {
                    function1F = markerNode.i();
                    break;
                }
            }
            if (mapNode instanceof InputHandlerNode) {
                function1F = ((InputHandlerNode) mapNode).f();
            }
        }
        if (function1F != null) {
            function1F.invoke(marker);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(MapApplier this$0, Marker marker) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(marker, "marker");
        Iterator it = this$0.f90866f.iterator();
        Function1 function1G = null;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            MapNode mapNode = (MapNode) it.next();
            if (mapNode instanceof MarkerNode) {
                MarkerNode markerNode = (MarkerNode) mapNode;
                if (Intrinsics.areEqual(markerNode.g(), marker)) {
                    function1G = markerNode.j();
                    break;
                }
            }
            if (mapNode instanceof InputHandlerNode) {
                function1G = ((InputHandlerNode) mapNode).g();
            }
        }
        if (function1G != null) {
            function1G.invoke(marker);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(MapApplier this$0, Marker marker) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(marker, "marker");
        Iterator it = this$0.f90866f.iterator();
        Function1 function1H = null;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            MapNode mapNode = (MapNode) it.next();
            if (mapNode instanceof MarkerNode) {
                MarkerNode markerNode = (MarkerNode) mapNode;
                if (Intrinsics.areEqual(markerNode.g(), marker)) {
                    function1H = markerNode.k();
                    break;
                }
            }
            if (mapNode instanceof InputHandlerNode) {
                function1H = ((InputHandlerNode) mapNode).h();
            }
        }
        if (function1H != null) {
            function1H.invoke(marker);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(MapApplier this$0, Circle circle) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(circle, "circle");
        Iterator it = this$0.f90866f.iterator();
        Function1 function1D = null;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            MapNode mapNode = (MapNode) it.next();
            if (mapNode instanceof CircleNode) {
                CircleNode circleNode = (CircleNode) mapNode;
                if (Intrinsics.areEqual(circleNode.d(), circle)) {
                    function1D = circleNode.e();
                    break;
                }
            }
            if (mapNode instanceof InputHandlerNode) {
                function1D = ((InputHandlerNode) mapNode).d();
            }
        }
        if (function1D != null) {
            function1D.invoke(circle);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(MapApplier this$0, GroundOverlay groundOverlay) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(groundOverlay, "groundOverlay");
        Iterator it = this$0.f90866f.iterator();
        Function1 function1E = null;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            MapNode mapNode = (MapNode) it.next();
            if (mapNode instanceof GroundOverlayNode) {
                GroundOverlayNode groundOverlayNode = (GroundOverlayNode) mapNode;
                if (Intrinsics.areEqual(groundOverlayNode.d(), groundOverlay)) {
                    function1E = groundOverlayNode.e();
                    break;
                }
            }
            if (mapNode instanceof InputHandlerNode) {
                function1E = ((InputHandlerNode) mapNode).e();
            }
        }
        if (function1E != null) {
            function1E.invoke(groundOverlay);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(MapApplier this$0, Polygon polygon) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(polygon, "polygon");
        Iterator it = this$0.f90866f.iterator();
        Function1 function1M = null;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            MapNode mapNode = (MapNode) it.next();
            if (mapNode instanceof PolygonNode) {
                PolygonNode polygonNode = (PolygonNode) mapNode;
                if (Intrinsics.areEqual(polygonNode.e(), polygon)) {
                    function1M = polygonNode.d();
                    break;
                }
            }
            if (mapNode instanceof InputHandlerNode) {
                function1M = ((InputHandlerNode) mapNode).m();
            }
        }
        if (function1M != null) {
            function1M.invoke(polygon);
        }
    }

    public final void H() {
        this.f90864d.C(new GoogleMap.OnCircleClickListener() { // from class: com.google.maps.android.compose.b
            @Override // com.google.android.gms.maps.GoogleMap.OnCircleClickListener
            public final void a(Circle circle) {
                MapApplier.F(this.f91301a, circle);
            }
        });
        this.f90864d.D(new GoogleMap.OnGroundOverlayClickListener() { // from class: com.google.maps.android.compose.c
            @Override // com.google.android.gms.maps.GoogleMap.OnGroundOverlayClickListener
            public final void a(GroundOverlay groundOverlay) {
                MapApplier.G(this.f91302a, groundOverlay);
            }
        });
        this.f90864d.Q(new GoogleMap.OnPolygonClickListener() { // from class: com.google.maps.android.compose.d
            @Override // com.google.android.gms.maps.GoogleMap.OnPolygonClickListener
            public final void a(Polygon polygon) {
                MapApplier.z(this.f91303a, polygon);
            }
        });
        this.f90864d.R(new GoogleMap.OnPolylineClickListener() { // from class: com.google.maps.android.compose.e
            @Override // com.google.android.gms.maps.GoogleMap.OnPolylineClickListener
            public final void a(Polyline polyline) {
                MapApplier.A(this.f91304a, polyline);
            }
        });
        this.f90864d.L(new GoogleMap.OnMarkerClickListener() { // from class: com.google.maps.android.compose.f
            @Override // com.google.android.gms.maps.GoogleMap.OnMarkerClickListener
            public final boolean a(Marker marker) {
                return MapApplier.B(this.f91305a, marker);
            }
        });
        this.f90864d.F(new GoogleMap.OnInfoWindowClickListener() { // from class: com.google.maps.android.compose.g
            @Override // com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener
            public final void a(Marker marker) {
                MapApplier.C(this.f91306a, marker);
            }
        });
        this.f90864d.G(new GoogleMap.OnInfoWindowCloseListener() { // from class: com.google.maps.android.compose.h
            @Override // com.google.android.gms.maps.GoogleMap.OnInfoWindowCloseListener
            public final void a(Marker marker) {
                MapApplier.D(this.f91307a, marker);
            }
        });
        this.f90864d.H(new GoogleMap.OnInfoWindowLongClickListener() { // from class: com.google.maps.android.compose.i
            @Override // com.google.android.gms.maps.GoogleMap.OnInfoWindowLongClickListener
            public final void a(Marker marker) {
                MapApplier.E(this.f91308a, marker);
            }
        });
        this.f90864d.M(new GoogleMap.OnMarkerDragListener() { // from class: com.google.maps.android.compose.MapApplier$attachClickListeners$9
            @Override // com.google.android.gms.maps.GoogleMap.OnMarkerDragListener
            public void a(Marker marker) {
                Intrinsics.checkNotNullParameter(marker, "marker");
                Iterator it = this.f90868a.f90866f.iterator();
                Function1 function1L = null;
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    MapNode mapNode = (MapNode) it.next();
                    if (mapNode instanceof MarkerNode) {
                        final MarkerNode markerNode = (MarkerNode) mapNode;
                        if (Intrinsics.areEqual(markerNode.g(), marker)) {
                            function1L = new Function1<Marker, Unit>() { // from class: com.google.maps.android.compose.MapApplier$attachClickListeners$9$onMarkerDragStart$2$1
                                {
                                    super(1);
                                }

                                public final void c(Marker it2) {
                                    Intrinsics.checkNotNullParameter(it2, "it");
                                    MarkerState markerStateH = markerNode.h();
                                    LatLng latLngA = it2.a();
                                    Intrinsics.checkNotNullExpressionValue(latLngA, "it.position");
                                    markerStateH.e(latLngA);
                                    markerNode.h().c(DragState.START);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    c((Marker) obj);
                                    return Unit.f139807a;
                                }
                            };
                            break;
                        }
                    }
                    if (mapNode instanceof InputHandlerNode) {
                        function1L = ((InputHandlerNode) mapNode).l();
                    }
                }
                if (function1L != null) {
                    function1L.invoke(marker);
                }
            }

            @Override // com.google.android.gms.maps.GoogleMap.OnMarkerDragListener
            public void b(Marker marker) {
                Intrinsics.checkNotNullParameter(marker, "marker");
                Iterator it = this.f90868a.f90866f.iterator();
                Function1 function1J = null;
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    MapNode mapNode = (MapNode) it.next();
                    if (mapNode instanceof MarkerNode) {
                        final MarkerNode markerNode = (MarkerNode) mapNode;
                        if (Intrinsics.areEqual(markerNode.g(), marker)) {
                            function1J = new Function1<Marker, Unit>() { // from class: com.google.maps.android.compose.MapApplier$attachClickListeners$9$onMarkerDrag$2$1
                                {
                                    super(1);
                                }

                                public final void c(Marker it2) {
                                    Intrinsics.checkNotNullParameter(it2, "it");
                                    MarkerState markerStateH = markerNode.h();
                                    LatLng latLngA = it2.a();
                                    Intrinsics.checkNotNullExpressionValue(latLngA, "it.position");
                                    markerStateH.e(latLngA);
                                    markerNode.h().c(DragState.DRAG);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    c((Marker) obj);
                                    return Unit.f139807a;
                                }
                            };
                            break;
                        }
                    }
                    if (mapNode instanceof InputHandlerNode) {
                        function1J = ((InputHandlerNode) mapNode).j();
                    }
                }
                if (function1J != null) {
                    function1J.invoke(marker);
                }
            }

            @Override // com.google.android.gms.maps.GoogleMap.OnMarkerDragListener
            public void c(Marker marker) {
                Intrinsics.checkNotNullParameter(marker, "marker");
                Iterator it = this.f90868a.f90866f.iterator();
                Function1 function1K = null;
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    MapNode mapNode = (MapNode) it.next();
                    if (mapNode instanceof MarkerNode) {
                        final MarkerNode markerNode = (MarkerNode) mapNode;
                        if (Intrinsics.areEqual(markerNode.g(), marker)) {
                            function1K = new Function1<Marker, Unit>() { // from class: com.google.maps.android.compose.MapApplier$attachClickListeners$9$onMarkerDragEnd$2$1
                                {
                                    super(1);
                                }

                                public final void c(Marker it2) {
                                    Intrinsics.checkNotNullParameter(it2, "it");
                                    MarkerState markerStateH = markerNode.h();
                                    LatLng latLngA = it2.a();
                                    Intrinsics.checkNotNullExpressionValue(latLngA, "it.position");
                                    markerStateH.e(latLngA);
                                    markerNode.h().c(DragState.END);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    c((Marker) obj);
                                    return Unit.f139807a;
                                }
                            };
                            break;
                        }
                    }
                    if (mapNode instanceof InputHandlerNode) {
                        function1K = ((InputHandlerNode) mapNode).k();
                    }
                }
                if (function1K != null) {
                    function1K.invoke(marker);
                }
            }
        });
        this.f90864d.q(new ComposeInfoWindowAdapter(this.f90865e, new Function1<Marker, MarkerNode>() { // from class: com.google.maps.android.compose.MapApplier$attachClickListeners$10
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final MarkerNode invoke(Marker marker) {
                Object next;
                Intrinsics.checkNotNullParameter(marker, "marker");
                Iterator it = this.f90867a.f90866f.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    MapNode mapNode = (MapNode) next;
                    if ((mapNode instanceof MarkerNode) && Intrinsics.areEqual(((MarkerNode) mapNode).g(), marker)) {
                        break;
                    }
                }
                return (MarkerNode) next;
            }
        }));
    }

    public final GoogleMap I() {
        return this.f90864d;
    }

    @Override // androidx.compose.runtime.Applier
    /* JADX INFO: renamed from: J, reason: merged with bridge method [inline-methods] */
    public void g(int i3, MapNode instance) {
        Intrinsics.checkNotNullParameter(instance, "instance");
        this.f90866f.add(i3, instance);
        instance.a();
    }

    @Override // androidx.compose.runtime.Applier
    /* JADX INFO: renamed from: K, reason: merged with bridge method [inline-methods] */
    public void e(int i3, MapNode instance) {
        Intrinsics.checkNotNullParameter(instance, "instance");
    }

    @Override // androidx.compose.runtime.Applier
    public void a(int i3, int i4) {
        for (int i5 = 0; i5 < i4; i5++) {
            ((MapNode) this.f90866f.get(i3 + i5)).c();
        }
        o(this.f90866f, i3, i4);
    }

    @Override // androidx.compose.runtime.Applier
    public void c(int i3, int i4, int i5) {
        m(this.f90866f, i3, i4, i5);
    }

    @Override // androidx.compose.runtime.AbstractApplier
    protected void n() {
        this.f90864d.i();
        Iterator it = this.f90866f.iterator();
        while (it.hasNext()) {
            ((MapNode) it.next()).b();
        }
        this.f90866f.clear();
    }
}
