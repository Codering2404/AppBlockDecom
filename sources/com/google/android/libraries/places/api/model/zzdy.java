package com.google.android.libraries.places.api.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzdy extends zzan {
    public static final Parcelable.Creator<zzdy> CREATOR = new zzdx();

    zzdy(int i3, int i4, int i5) {
        super(i3, i4, i5);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(e());
        parcel.writeInt(d());
        parcel.writeInt(c());
    }
}
