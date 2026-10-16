package com.google.android.libraries.places.api.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzdu extends zzak {
    public static final Parcelable.Creator<zzdu> CREATOR = new zzdt();

    zzdu(Uri uri, Uri uri2, Uri uri3, Uri uri4, Uri uri5) {
        super(uri, uri2, uri3, uri4, uri5);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        parcel.writeParcelable(d(), i3);
        parcel.writeParcelable(f(), i3);
        parcel.writeParcelable(h(), i3);
        parcel.writeParcelable(g(), i3);
        parcel.writeParcelable(e(), i3);
    }
}
