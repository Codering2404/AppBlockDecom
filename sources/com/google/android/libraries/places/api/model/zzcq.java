package com.google.android.libraries.places.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzcq extends zzj {
    public static final Parcelable.Creator<zzcq> CREATOR = new zzcp();

    zzcq(String str, Integer num, List list, String str2, String str3, String str4, List list2, List list3, List list4) {
        super(str, num, list, str2, str3, str4, list2, list3, list4);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(d());
        if (c() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeInt(c().intValue());
        }
        parcel.writeList(g());
        parcel.writeString(h());
        parcel.writeString(i());
        parcel.writeString(j());
        parcel.writeList(k());
        parcel.writeList(l());
        parcel.writeList(m());
    }
}
