package com.google.android.libraries.places.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.libraries.places.api.model.OpeningHours;
import java.time.Instant;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzef implements Parcelable.Creator {
    zzef() {
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        Boolean boolValueOf;
        OpeningHours.HoursType hoursType = (OpeningHours.HoursType) parcel.readParcelable(OpeningHours.class.getClassLoader());
        ArrayList arrayList = parcel.readArrayList(OpeningHours.class.getClassLoader());
        ArrayList arrayList2 = parcel.readArrayList(OpeningHours.class.getClassLoader());
        ArrayList arrayList3 = parcel.readArrayList(OpeningHours.class.getClassLoader());
        if (parcel.readInt() == 0) {
            boolValueOf = Boolean.valueOf(parcel.readInt() == 1);
        } else {
            boolValueOf = null;
        }
        return new zzeg(hoursType, arrayList, arrayList2, arrayList3, boolValueOf, parcel.readInt() == 0 ? (Instant) parcel.readSerializable() : null, parcel.readInt() == 0 ? (Instant) parcel.readSerializable() : null);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i3) {
        return new zzeg[i3];
    }
}
