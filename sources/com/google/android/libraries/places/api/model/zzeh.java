package com.google.android.libraries.places.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.libraries.places.api.model.Place;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzeh implements Parcelable.Creator {
    zzeh() {
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new zzei((Place.BooleanPlaceAttributeValue) parcel.readParcelable(ParkingOptions.class.getClassLoader()), (Place.BooleanPlaceAttributeValue) parcel.readParcelable(ParkingOptions.class.getClassLoader()), (Place.BooleanPlaceAttributeValue) parcel.readParcelable(ParkingOptions.class.getClassLoader()), (Place.BooleanPlaceAttributeValue) parcel.readParcelable(ParkingOptions.class.getClassLoader()), (Place.BooleanPlaceAttributeValue) parcel.readParcelable(ParkingOptions.class.getClassLoader()), (Place.BooleanPlaceAttributeValue) parcel.readParcelable(ParkingOptions.class.getClassLoader()), (Place.BooleanPlaceAttributeValue) parcel.readParcelable(ParkingOptions.class.getClassLoader()));
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i3) {
        return new zzei[i3];
    }
}
