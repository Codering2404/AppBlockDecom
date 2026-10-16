package com.google.android.libraries.places.api.model;

import com.google.android.libraries.places.api.model.AccessibilityOptions;
import com.google.android.libraries.places.api.model.Place;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zza extends AccessibilityOptions.Builder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Place.BooleanPlaceAttributeValue f75027a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Place.BooleanPlaceAttributeValue f75028b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Place.BooleanPlaceAttributeValue f75029c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Place.BooleanPlaceAttributeValue f75030d;

    zza() {
    }

    @Override // com.google.android.libraries.places.api.model.AccessibilityOptions.Builder
    public final AccessibilityOptions a() {
        Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue;
        Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue2;
        Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue3;
        Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue4 = this.f75027a;
        if (booleanPlaceAttributeValue4 != null && (booleanPlaceAttributeValue = this.f75028b) != null && (booleanPlaceAttributeValue2 = this.f75029c) != null && (booleanPlaceAttributeValue3 = this.f75030d) != null) {
            return new zzcg(booleanPlaceAttributeValue4, booleanPlaceAttributeValue, booleanPlaceAttributeValue2, booleanPlaceAttributeValue3);
        }
        StringBuilder sb = new StringBuilder();
        if (this.f75027a == null) {
            sb.append(" wheelchairAccessibleParking");
        }
        if (this.f75028b == null) {
            sb.append(" wheelchairAccessibleEntrance");
        }
        if (this.f75029c == null) {
            sb.append(" wheelchairAccessibleRestroom");
        }
        if (this.f75030d == null) {
            sb.append(" wheelchairAccessibleSeating");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }

    @Override // com.google.android.libraries.places.api.model.AccessibilityOptions.Builder
    public final AccessibilityOptions.Builder b(Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue) {
        if (booleanPlaceAttributeValue == null) {
            throw new NullPointerException("Null wheelchairAccessibleEntrance");
        }
        this.f75028b = booleanPlaceAttributeValue;
        return this;
    }

    @Override // com.google.android.libraries.places.api.model.AccessibilityOptions.Builder
    public final AccessibilityOptions.Builder c(Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue) {
        if (booleanPlaceAttributeValue == null) {
            throw new NullPointerException("Null wheelchairAccessibleParking");
        }
        this.f75027a = booleanPlaceAttributeValue;
        return this;
    }

    @Override // com.google.android.libraries.places.api.model.AccessibilityOptions.Builder
    public final AccessibilityOptions.Builder d(Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue) {
        if (booleanPlaceAttributeValue == null) {
            throw new NullPointerException("Null wheelchairAccessibleRestroom");
        }
        this.f75029c = booleanPlaceAttributeValue;
        return this;
    }

    @Override // com.google.android.libraries.places.api.model.AccessibilityOptions.Builder
    public final AccessibilityOptions.Builder e(Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue) {
        if (booleanPlaceAttributeValue == null) {
            throw new NullPointerException("Null wheelchairAccessibleSeating");
        }
        this.f75030d = booleanPlaceAttributeValue;
        return this;
    }
}
