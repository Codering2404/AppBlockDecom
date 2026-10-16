package com.google.android.libraries.places.api.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzfc extends zzbq {
    public static final Parcelable.Creator<zzfc> CREATOR = new zzfb();

    zzfc(String str, String str2, Uri uri, String str3, String str4, Uri uri2) {
        super(str, str2, uri, str3, str4, uri2);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
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
        parcel.writeParcelable(f(), i3);
        if (d() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(d());
        }
        if (e() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(e());
        }
        parcel.writeParcelable(g(), i3);
    }
}
