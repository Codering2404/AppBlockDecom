package com.google.android.libraries.places.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.libraries.places.api.model.OpeningHours;
import java.time.Instant;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzeg extends zzav {
    public static final Parcelable.Creator<zzeg> CREATOR = new zzef();

    zzeg(OpeningHours.HoursType hoursType, List list, List list2, List list3, Boolean bool, Instant instant, Instant instant2) {
        super(hoursType, list, list2, list3, bool, instant, instant2);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        parcel.writeParcelable(d(), i3);
        parcel.writeList(e());
        parcel.writeList(f());
        parcel.writeList(g());
        if (h() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeInt(h().booleanValue() ? 1 : 0);
        }
        if (i() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeSerializable(i());
        }
        if (j() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeSerializable(j());
        }
    }
}
