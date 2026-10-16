package com.google.android.libraries.places.api.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzdl implements Parcelable.Creator {
    zzdl() {
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new zzdm((ContentBlock) parcel.readParcelable(EvChargeAmenitySummary.class.getClassLoader()), (ContentBlock) parcel.readParcelable(EvChargeAmenitySummary.class.getClassLoader()), (ContentBlock) parcel.readParcelable(EvChargeAmenitySummary.class.getClassLoader()), (ContentBlock) parcel.readParcelable(EvChargeAmenitySummary.class.getClassLoader()), (Uri) parcel.readParcelable(EvChargeAmenitySummary.class.getClassLoader()), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i3) {
        return new zzdm[i3];
    }
}
