package com.google.android.libraries.places.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.libraries.places.api.model.FuelPrice;
import java.time.Instant;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzdq extends zzag {
    public static final Parcelable.Creator<zzdq> CREATOR = new zzdp();

    zzdq(FuelPrice.FuelType fuelType, Money money, Instant instant) {
        super(fuelType, money, instant);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        parcel.writeParcelable(d(), i3);
        parcel.writeParcelable(c(), i3);
        parcel.writeSerializable(e());
    }
}
