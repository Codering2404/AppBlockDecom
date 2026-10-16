package com.google.android.libraries.places.internal;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.libraries.places.api.model.RouteModifiers;
import com.google.android.libraries.places.api.model.RoutingParameters;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzjy {
    zzjy(zzhq zzhqVar) {
    }

    public static final zzbay a(RoutingParameters routingParameters) {
        zzbax zzbaxVarG = zzbay.G();
        LatLng latLngC = routingParameters.c();
        if (latLngC != null) {
            zzbaxVarG.y(zzhq.a(latLngC));
        }
        RoutingParameters.TravelMode travelModeF = routingParameters.f();
        int i3 = 5;
        if (travelModeF != null) {
            RoutingParameters.RoutingPreference routingPreference = RoutingParameters.RoutingPreference.ROUTING_PREFERENCE_UNSPECIFIED;
            int iOrdinal = travelModeF.ordinal();
            zzbaxVarG.A(iOrdinal != 1 ? iOrdinal != 2 ? iOrdinal != 3 ? iOrdinal != 4 ? 2 : 6 : 5 : 4 : 3);
        }
        RouteModifiers routeModifiersD = routingParameters.d();
        if (routeModifiersD != null) {
            zzbav zzbavVarG = zzbaw.G();
            zzbavVarG.y(routeModifiersD.f());
            zzbavVarG.z(routeModifiersD.d());
            zzbavVarG.A(routeModifiersD.c());
            zzbavVarG.B(routeModifiersD.e());
            zzbaxVarG.z((zzbaw) zzbavVarG.zzG());
        }
        RoutingParameters.RoutingPreference routingPreferenceE = routingParameters.e();
        if (routingPreferenceE != null) {
            RoutingParameters.TravelMode travelMode = RoutingParameters.TravelMode.TRAVEL_MODE_UNSPECIFIED;
            int iOrdinal2 = routingPreferenceE.ordinal();
            if (iOrdinal2 == 1) {
                i3 = 3;
            } else if (iOrdinal2 == 2) {
                i3 = 4;
            } else if (iOrdinal2 != 3) {
                i3 = 2;
            }
            zzbaxVarG.B(i3);
        }
        return (zzbay) zzbaxVarG.zzG();
    }
}
