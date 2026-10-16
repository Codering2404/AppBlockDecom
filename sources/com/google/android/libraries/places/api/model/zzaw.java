package com.google.android.libraries.places.api.model;

import com.google.android.libraries.places.api.model.ParkingOptions;
import com.google.android.libraries.places.api.model.Place;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzaw extends ParkingOptions.Builder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Place.BooleanPlaceAttributeValue f75118a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Place.BooleanPlaceAttributeValue f75119b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Place.BooleanPlaceAttributeValue f75120c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Place.BooleanPlaceAttributeValue f75121d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Place.BooleanPlaceAttributeValue f75122e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Place.BooleanPlaceAttributeValue f75123f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Place.BooleanPlaceAttributeValue f75124g;

    zzaw() {
    }

    @Override // com.google.android.libraries.places.api.model.ParkingOptions.Builder
    public final ParkingOptions a() {
        Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue;
        Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue2;
        Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue3;
        Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue4;
        Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue5;
        Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue6;
        Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue7 = this.f75118a;
        if (booleanPlaceAttributeValue7 != null && (booleanPlaceAttributeValue = this.f75119b) != null && (booleanPlaceAttributeValue2 = this.f75120c) != null && (booleanPlaceAttributeValue3 = this.f75121d) != null && (booleanPlaceAttributeValue4 = this.f75122e) != null && (booleanPlaceAttributeValue5 = this.f75123f) != null && (booleanPlaceAttributeValue6 = this.f75124g) != null) {
            return new zzei(booleanPlaceAttributeValue7, booleanPlaceAttributeValue, booleanPlaceAttributeValue2, booleanPlaceAttributeValue3, booleanPlaceAttributeValue4, booleanPlaceAttributeValue5, booleanPlaceAttributeValue6);
        }
        StringBuilder sb = new StringBuilder();
        if (this.f75118a == null) {
            sb.append(" freeParkingLot");
        }
        if (this.f75119b == null) {
            sb.append(" paidParkingLot");
        }
        if (this.f75120c == null) {
            sb.append(" freeStreetParking");
        }
        if (this.f75121d == null) {
            sb.append(" paidStreetParking");
        }
        if (this.f75122e == null) {
            sb.append(" valetParking");
        }
        if (this.f75123f == null) {
            sb.append(" freeGarageParking");
        }
        if (this.f75124g == null) {
            sb.append(" paidGarageParking");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }

    @Override // com.google.android.libraries.places.api.model.ParkingOptions.Builder
    public final ParkingOptions.Builder b(Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue) {
        if (booleanPlaceAttributeValue == null) {
            throw new NullPointerException("Null freeGarageParking");
        }
        this.f75123f = booleanPlaceAttributeValue;
        return this;
    }

    @Override // com.google.android.libraries.places.api.model.ParkingOptions.Builder
    public final ParkingOptions.Builder c(Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue) {
        if (booleanPlaceAttributeValue == null) {
            throw new NullPointerException("Null freeParkingLot");
        }
        this.f75118a = booleanPlaceAttributeValue;
        return this;
    }

    @Override // com.google.android.libraries.places.api.model.ParkingOptions.Builder
    public final ParkingOptions.Builder d(Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue) {
        if (booleanPlaceAttributeValue == null) {
            throw new NullPointerException("Null freeStreetParking");
        }
        this.f75120c = booleanPlaceAttributeValue;
        return this;
    }

    @Override // com.google.android.libraries.places.api.model.ParkingOptions.Builder
    public final ParkingOptions.Builder e(Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue) {
        if (booleanPlaceAttributeValue == null) {
            throw new NullPointerException("Null paidGarageParking");
        }
        this.f75124g = booleanPlaceAttributeValue;
        return this;
    }

    @Override // com.google.android.libraries.places.api.model.ParkingOptions.Builder
    public final ParkingOptions.Builder f(Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue) {
        if (booleanPlaceAttributeValue == null) {
            throw new NullPointerException("Null paidParkingLot");
        }
        this.f75119b = booleanPlaceAttributeValue;
        return this;
    }

    @Override // com.google.android.libraries.places.api.model.ParkingOptions.Builder
    public final ParkingOptions.Builder g(Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue) {
        if (booleanPlaceAttributeValue == null) {
            throw new NullPointerException("Null paidStreetParking");
        }
        this.f75121d = booleanPlaceAttributeValue;
        return this;
    }

    @Override // com.google.android.libraries.places.api.model.ParkingOptions.Builder
    public final ParkingOptions.Builder h(Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue) {
        if (booleanPlaceAttributeValue == null) {
            throw new NullPointerException("Null valetParking");
        }
        this.f75122e = booleanPlaceAttributeValue;
        return this;
    }
}
