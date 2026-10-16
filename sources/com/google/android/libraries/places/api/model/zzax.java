package com.google.android.libraries.places.api.model;

import com.google.android.libraries.places.api.model.Place;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
abstract class zzax extends ParkingOptions {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Place.BooleanPlaceAttributeValue f75125a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Place.BooleanPlaceAttributeValue f75126b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Place.BooleanPlaceAttributeValue f75127c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Place.BooleanPlaceAttributeValue f75128d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Place.BooleanPlaceAttributeValue f75129f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Place.BooleanPlaceAttributeValue f75130g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Place.BooleanPlaceAttributeValue f75131h;

    zzax(Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue, Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue2, Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue3, Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue4, Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue5, Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue6, Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue7) {
        if (booleanPlaceAttributeValue == null) {
            throw new NullPointerException("Null freeParkingLot");
        }
        this.f75125a = booleanPlaceAttributeValue;
        if (booleanPlaceAttributeValue2 == null) {
            throw new NullPointerException("Null paidParkingLot");
        }
        this.f75126b = booleanPlaceAttributeValue2;
        if (booleanPlaceAttributeValue3 == null) {
            throw new NullPointerException("Null freeStreetParking");
        }
        this.f75127c = booleanPlaceAttributeValue3;
        if (booleanPlaceAttributeValue4 == null) {
            throw new NullPointerException("Null paidStreetParking");
        }
        this.f75128d = booleanPlaceAttributeValue4;
        if (booleanPlaceAttributeValue5 == null) {
            throw new NullPointerException("Null valetParking");
        }
        this.f75129f = booleanPlaceAttributeValue5;
        if (booleanPlaceAttributeValue6 == null) {
            throw new NullPointerException("Null freeGarageParking");
        }
        this.f75130g = booleanPlaceAttributeValue6;
        if (booleanPlaceAttributeValue7 == null) {
            throw new NullPointerException("Null paidGarageParking");
        }
        this.f75131h = booleanPlaceAttributeValue7;
    }

    @Override // com.google.android.libraries.places.api.model.ParkingOptions
    public final Place.BooleanPlaceAttributeValue d() {
        return this.f75130g;
    }

    @Override // com.google.android.libraries.places.api.model.ParkingOptions
    public final Place.BooleanPlaceAttributeValue e() {
        return this.f75125a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ParkingOptions) {
            ParkingOptions parkingOptions = (ParkingOptions) obj;
            if (this.f75125a.equals(parkingOptions.e()) && this.f75126b.equals(parkingOptions.h()) && this.f75127c.equals(parkingOptions.f()) && this.f75128d.equals(parkingOptions.i()) && this.f75129f.equals(parkingOptions.j()) && this.f75130g.equals(parkingOptions.d()) && this.f75131h.equals(parkingOptions.g())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.places.api.model.ParkingOptions
    public final Place.BooleanPlaceAttributeValue f() {
        return this.f75127c;
    }

    @Override // com.google.android.libraries.places.api.model.ParkingOptions
    public final Place.BooleanPlaceAttributeValue g() {
        return this.f75131h;
    }

    @Override // com.google.android.libraries.places.api.model.ParkingOptions
    public final Place.BooleanPlaceAttributeValue h() {
        return this.f75126b;
    }

    public final int hashCode() {
        return ((((((((((((this.f75125a.hashCode() ^ 1000003) * 1000003) ^ this.f75126b.hashCode()) * 1000003) ^ this.f75127c.hashCode()) * 1000003) ^ this.f75128d.hashCode()) * 1000003) ^ this.f75129f.hashCode()) * 1000003) ^ this.f75130g.hashCode()) * 1000003) ^ this.f75131h.hashCode();
    }

    @Override // com.google.android.libraries.places.api.model.ParkingOptions
    public final Place.BooleanPlaceAttributeValue i() {
        return this.f75128d;
    }

    @Override // com.google.android.libraries.places.api.model.ParkingOptions
    public final Place.BooleanPlaceAttributeValue j() {
        return this.f75129f;
    }

    public final String toString() {
        String string = this.f75125a.toString();
        int length = string.length();
        String string2 = this.f75126b.toString();
        int length2 = string2.length();
        String string3 = this.f75127c.toString();
        int length3 = string3.length();
        String string4 = this.f75128d.toString();
        int length4 = string4.length();
        String string5 = this.f75129f.toString();
        int length5 = string5.length();
        String string6 = this.f75130g.toString();
        int length6 = string6.length();
        String string7 = this.f75131h.toString();
        StringBuilder sb = new StringBuilder(length + 47 + length2 + 20 + length3 + 20 + length4 + 15 + length5 + 20 + length6 + 20 + string7.length() + 1);
        sb.append("ParkingOptions{freeParkingLot=");
        sb.append(string);
        sb.append(", paidParkingLot=");
        sb.append(string2);
        sb.append(", freeStreetParking=");
        sb.append(string3);
        sb.append(", paidStreetParking=");
        sb.append(string4);
        sb.append(", valetParking=");
        sb.append(string5);
        sb.append(", freeGarageParking=");
        sb.append(string6);
        sb.append(", paidGarageParking=");
        sb.append(string7);
        sb.append("}");
        return sb.toString();
    }
}
