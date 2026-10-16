package com.google.android.libraries.places.api.model;

import android.os.Parcelable;
import com.google.android.libraries.places.api.model.Place;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class ParkingOptions implements Parcelable {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class Builder {
        public abstract ParkingOptions a();

        public abstract Builder b(Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue);

        public abstract Builder c(Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue);

        public abstract Builder d(Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue);

        public abstract Builder e(Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue);

        public abstract Builder f(Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue);

        public abstract Builder g(Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue);

        public abstract Builder h(Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue);
    }

    public static Builder c() {
        zzaw zzawVar = new zzaw();
        Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue = Place.BooleanPlaceAttributeValue.UNKNOWN;
        zzawVar.c(booleanPlaceAttributeValue);
        zzawVar.f(booleanPlaceAttributeValue);
        zzawVar.d(booleanPlaceAttributeValue);
        zzawVar.g(booleanPlaceAttributeValue);
        zzawVar.h(booleanPlaceAttributeValue);
        zzawVar.b(booleanPlaceAttributeValue);
        zzawVar.e(booleanPlaceAttributeValue);
        return zzawVar;
    }

    public abstract Place.BooleanPlaceAttributeValue d();

    public abstract Place.BooleanPlaceAttributeValue e();

    public abstract Place.BooleanPlaceAttributeValue f();

    public abstract Place.BooleanPlaceAttributeValue g();

    public abstract Place.BooleanPlaceAttributeValue h();

    public abstract Place.BooleanPlaceAttributeValue i();

    public abstract Place.BooleanPlaceAttributeValue j();
}
