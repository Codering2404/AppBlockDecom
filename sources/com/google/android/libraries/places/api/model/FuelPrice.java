package com.google.android.libraries.places.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.time.Instant;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class FuelPrice implements Parcelable {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class Builder {
        public abstract FuelPrice a();

        public abstract Builder b(Money money);

        public abstract Builder c(Instant instant);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum FuelType implements Parcelable {
        FUEL_TYPE_UNSPECIFIED,
        DIESEL,
        REGULAR_UNLEADED,
        MIDGRADE,
        PREMIUM,
        SP91,
        SP91_E10,
        SP92,
        SP95,
        SP95_E10,
        SP98,
        SP99,
        SP100,
        LPG,
        E80,
        E85,
        METHANE,
        BIO_DIESEL,
        TRUCK_DIESEL;

        public static final Parcelable.Creator<FuelType> CREATOR = new zzfv();

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeString(name());
        }
    }

    public static FuelPrice f(FuelType fuelType, Money money, Instant instant) {
        zzaf zzafVar = new zzaf();
        zzafVar.d(fuelType);
        zzafVar.b(money);
        zzafVar.c(instant);
        return zzafVar.a();
    }

    public abstract Money c();

    public abstract FuelType d();

    public abstract Instant e();
}
