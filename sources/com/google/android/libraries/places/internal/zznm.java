package com.google.android.libraries.places.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.libraries.places.api.model.AutocompleteSessionToken;
import com.google.android.libraries.places.api.model.LocationBias;
import com.google.android.libraries.places.api.model.LocationRestriction;
import com.google.android.libraries.places.widget.model.AutocompleteActivityMode;
import com.google.android.libraries.places.widget.model.AutocompleteUiCustomization;
import com.google.common.collect.ImmutableList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zznm extends zznk {
    public static final Parcelable.Creator<zznm> CREATOR = new zznl();

    zznm(zzow zzowVar, AutocompleteActivityMode autocompleteActivityMode, ImmutableList immutableList, zzor zzorVar, LatLng latLng, String str, String str2, LocationBias locationBias, LocationRestriction locationRestriction, ImmutableList immutableList2, ImmutableList immutableList3, int i3, int i4, String str3, AutocompleteUiCustomization autocompleteUiCustomization, boolean z2, AutocompleteSessionToken autocompleteSessionToken) {
        super(zzowVar, autocompleteActivityMode, immutableList, zzorVar, latLng, str, str2, locationBias, locationRestriction, immutableList2, immutableList3, i3, i4, str3, autocompleteUiCustomization, z2, autocompleteSessionToken);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        parcel.writeParcelable(c(), i3);
        parcel.writeParcelable(d(), i3);
        parcel.writeList(e().a());
        parcel.writeParcelable(f(), i3);
        parcel.writeParcelable(g(), i3);
        if (h() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(h());
        }
        if (i() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(i());
        }
        parcel.writeParcelable(j(), i3);
        parcel.writeParcelable(k(), i3);
        parcel.writeList(l().a());
        parcel.writeList(m().a());
        parcel.writeInt(n());
        parcel.writeInt(o());
        if (p() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(p());
        }
        parcel.writeParcelable(q(), i3);
        parcel.writeInt(r() ? 1 : 0);
        parcel.writeParcelable(s(), i3);
    }
}
