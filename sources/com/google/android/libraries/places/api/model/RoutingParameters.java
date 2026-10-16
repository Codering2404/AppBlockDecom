package com.google.android.libraries.places.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.maps.model.LatLng;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class RoutingParameters implements Parcelable {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class Builder {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum RoutingPreference implements Parcelable {
        ROUTING_PREFERENCE_UNSPECIFIED,
        TRAFFIC_UNAWARE,
        TRAFFIC_AWARE,
        TRAFFIC_AWARE_OPTIMAL;

        public static final Parcelable.Creator<RoutingPreference> CREATOR = new zzgh();

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeString(name());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum TravelMode implements Parcelable {
        TRAVEL_MODE_UNSPECIFIED,
        DRIVE,
        BICYCLE,
        WALK,
        TWO_WHEELER;

        public static final Parcelable.Creator<TravelMode> CREATOR = new zzgi();

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeString(name());
        }
    }

    public abstract LatLng c();

    public abstract RouteModifiers d();

    public abstract RoutingPreference e();

    public abstract TravelMode f();
}
