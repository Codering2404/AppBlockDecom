package com.google.android.libraries.places.api.model;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.libraries.places.api.model.RoutingParameters;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
abstract class zzbu extends RoutingParameters {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LatLng f75305a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final RoutingParameters.TravelMode f75306b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final RouteModifiers f75307c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final RoutingParameters.RoutingPreference f75308d;

    zzbu(LatLng latLng, RoutingParameters.TravelMode travelMode, RouteModifiers routeModifiers, RoutingParameters.RoutingPreference routingPreference) {
        this.f75305a = latLng;
        this.f75306b = travelMode;
        this.f75307c = routeModifiers;
        this.f75308d = routingPreference;
    }

    @Override // com.google.android.libraries.places.api.model.RoutingParameters
    public final LatLng c() {
        return this.f75305a;
    }

    @Override // com.google.android.libraries.places.api.model.RoutingParameters
    public final RouteModifiers d() {
        return this.f75307c;
    }

    @Override // com.google.android.libraries.places.api.model.RoutingParameters
    public final RoutingParameters.RoutingPreference e() {
        return this.f75308d;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof RoutingParameters) {
            RoutingParameters routingParameters = (RoutingParameters) obj;
            LatLng latLng = this.f75305a;
            if (latLng != null ? latLng.equals(routingParameters.c()) : routingParameters.c() == null) {
                RoutingParameters.TravelMode travelMode = this.f75306b;
                if (travelMode != null ? travelMode.equals(routingParameters.f()) : routingParameters.f() == null) {
                    RouteModifiers routeModifiers = this.f75307c;
                    if (routeModifiers != null ? routeModifiers.equals(routingParameters.d()) : routingParameters.d() == null) {
                        RoutingParameters.RoutingPreference routingPreference = this.f75308d;
                        if (routingPreference != null ? routingPreference.equals(routingParameters.e()) : routingParameters.e() == null) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.places.api.model.RoutingParameters
    public final RoutingParameters.TravelMode f() {
        return this.f75306b;
    }

    public final int hashCode() {
        LatLng latLng = this.f75305a;
        int iHashCode = latLng == null ? 0 : latLng.hashCode();
        RoutingParameters.TravelMode travelMode = this.f75306b;
        int iHashCode2 = travelMode == null ? 0 : travelMode.hashCode();
        int i3 = iHashCode ^ 1000003;
        RouteModifiers routeModifiers = this.f75307c;
        int iHashCode3 = ((((i3 * 1000003) ^ iHashCode2) * 1000003) ^ (routeModifiers == null ? 0 : routeModifiers.hashCode())) * 1000003;
        RoutingParameters.RoutingPreference routingPreference = this.f75308d;
        return iHashCode3 ^ (routingPreference != null ? routingPreference.hashCode() : 0);
    }

    public final String toString() {
        RoutingParameters.RoutingPreference routingPreference = this.f75308d;
        RouteModifiers routeModifiers = this.f75307c;
        RoutingParameters.TravelMode travelMode = this.f75306b;
        String strValueOf = String.valueOf(this.f75305a);
        String strValueOf2 = String.valueOf(travelMode);
        String strValueOf3 = String.valueOf(routeModifiers);
        String strValueOf4 = String.valueOf(routingPreference);
        int length = strValueOf.length();
        int length2 = strValueOf2.length();
        StringBuilder sb = new StringBuilder(length + 38 + length2 + 17 + strValueOf3.length() + 20 + strValueOf4.length() + 1);
        sb.append("RoutingParameters{origin=");
        sb.append(strValueOf);
        sb.append(", travelMode=");
        sb.append(strValueOf2);
        sb.append(", routeModifiers=");
        sb.append(strValueOf3);
        sb.append(", routingPreference=");
        sb.append(strValueOf4);
        sb.append("}");
        return sb.toString();
    }
}
