package com.google.android.libraries.places.api.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzeo extends zzbd {
    public static final Parcelable.Creator<zzeo> CREATOR = new zzen();

    zzeo(String str, int i3, int i4, String str2, String str3, AuthorAttributions authorAttributions, Uri uri) {
        super(str, i3, i4, str2, str3, authorAttributions, uri);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(c());
        parcel.writeInt(e());
        parcel.writeInt(f());
        parcel.writeString(g());
        if (h() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(h());
        }
        parcel.writeParcelable(d(), i3);
        parcel.writeParcelable(i(), i3);
    }
}
