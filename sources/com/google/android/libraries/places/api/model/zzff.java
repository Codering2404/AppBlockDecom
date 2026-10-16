package com.google.android.libraries.places.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.libraries.places.api.model.RoutingParameters;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzff implements Parcelable.Creator {
    zzff() {
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new zzfg((LatLng) parcel.readParcelable(RoutingParameters.class.getClassLoader()), (RoutingParameters.TravelMode) parcel.readParcelable(RoutingParameters.class.getClassLoader()), (RouteModifiers) parcel.readParcelable(RoutingParameters.class.getClassLoader()), (RoutingParameters.RoutingPreference) parcel.readParcelable(RoutingParameters.class.getClassLoader()));
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i3) {
        return new zzfg[i3];
    }
}
