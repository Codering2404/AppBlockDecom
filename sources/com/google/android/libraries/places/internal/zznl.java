package com.google.android.libraries.places.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.libraries.places.api.model.AutocompleteSessionToken;
import com.google.android.libraries.places.api.model.LocationBias;
import com.google.android.libraries.places.api.model.LocationRestriction;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.widget.model.AutocompleteActivityMode;
import com.google.android.libraries.places.widget.model.AutocompleteUiCustomization;
import com.google.common.collect.ImmutableList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zznl implements Parcelable.Creator {
    zznl() {
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        zzow zzowVar = (zzow) parcel.readParcelable(zznq.class.getClassLoader());
        AutocompleteActivityMode autocompleteActivityMode = (AutocompleteActivityMode) parcel.readParcelable(zznq.class.getClassLoader());
        ImmutableList immutableListT = ImmutableList.t(parcel.readArrayList(Place.Field.class.getClassLoader()));
        zzor zzorVar = (zzor) parcel.readParcelable(zznq.class.getClassLoader());
        LatLng latLng = (LatLng) parcel.readParcelable(zznq.class.getClassLoader());
        String string = parcel.readInt() == 0 ? parcel.readString() : null;
        String string2 = parcel.readInt() == 0 ? parcel.readString() : null;
        LocationBias locationBias = (LocationBias) parcel.readParcelable(zznq.class.getClassLoader());
        LocationRestriction locationRestriction = (LocationRestriction) parcel.readParcelable(zznq.class.getClassLoader());
        ImmutableList immutableListT2 = ImmutableList.t(parcel.readArrayList(String.class.getClassLoader()));
        ImmutableList immutableListT3 = ImmutableList.t(parcel.readArrayList(String.class.getClassLoader()));
        String string3 = null;
        int i3 = parcel.readInt();
        String str = string;
        int i4 = parcel.readInt();
        if (parcel.readInt() == 0) {
            string3 = parcel.readString();
        }
        return new zznm(zzowVar, autocompleteActivityMode, immutableListT, zzorVar, latLng, str, string2, locationBias, locationRestriction, immutableListT2, immutableListT3, i3, i4, string3, (AutocompleteUiCustomization) parcel.readParcelable(zznq.class.getClassLoader()), parcel.readInt() == 1, (AutocompleteSessionToken) parcel.readParcelable(zznq.class.getClassLoader()));
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i3) {
        return new zznm[i3];
    }
}
