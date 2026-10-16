package com.google.android.libraries.places.api.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzfa extends zzbo {
    public static final Parcelable.Creator<zzfa> CREATOR = new zzez();

    zzfa(String str, String str2, String str3, String str4, String str5, Double d3, AuthorAttribution authorAttribution, String str6, String str7, Uri uri, LocalDate localDate) {
        super(str, str2, str3, str4, str5, d3, authorAttribution, str6, str7, uri, localDate);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        if (j() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(j());
        }
        if (k() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(k());
        }
        if (l() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(l());
        }
        if (f() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(f());
        }
        if (g() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(g());
        }
        parcel.writeDouble(i().doubleValue());
        parcel.writeParcelable(d(), i3);
        parcel.writeString(c());
        if (h() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(h());
        }
        parcel.writeParcelable(e(), i3);
        parcel.writeParcelable(m(), i3);
    }
}
