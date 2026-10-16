package com.google.android.libraries.places.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.time.Instant;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzcy extends zzp {
    public static final Parcelable.Creator<zzcy> CREATOR = new zzcx();

    zzcy(EVConnectorType eVConnectorType, Double d3, Integer num, Integer num2, Integer num3, Instant instant) {
        super(eVConnectorType, d3, num, num2, num3, instant);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        parcel.writeParcelable(h(), i3);
        parcel.writeDouble(f().doubleValue());
        parcel.writeInt(e().intValue());
        if (d() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeInt(d().intValue());
        }
        if (g() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeInt(g().intValue());
        }
        if (c() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeSerializable(c());
        }
    }
}
