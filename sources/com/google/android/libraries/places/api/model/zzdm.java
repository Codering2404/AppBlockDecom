package com.google.android.libraries.places.api.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzdm extends zzac {
    public static final Parcelable.Creator<zzdm> CREATOR = new zzdl();

    zzdm(ContentBlock contentBlock, ContentBlock contentBlock2, ContentBlock contentBlock3, ContentBlock contentBlock4, Uri uri, String str, String str2) {
        super(contentBlock, contentBlock2, contentBlock3, contentBlock4, uri, str, str2);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        parcel.writeParcelable(g(), i3);
        parcel.writeParcelable(c(), i3);
        parcel.writeParcelable(h(), i3);
        parcel.writeParcelable(i(), i3);
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
    }
}
