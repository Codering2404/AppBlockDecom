package com.google.android.libraries.places.api.model;

import com.google.android.libraries.places.api.model.Place;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
abstract class zzb extends AccessibilityOptions {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Place.BooleanPlaceAttributeValue f75140a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Place.BooleanPlaceAttributeValue f75141b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Place.BooleanPlaceAttributeValue f75142c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Place.BooleanPlaceAttributeValue f75143d;

    zzb(Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue, Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue2, Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue3, Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue4) {
        if (booleanPlaceAttributeValue == null) {
            throw new NullPointerException("Null wheelchairAccessibleParking");
        }
        this.f75140a = booleanPlaceAttributeValue;
        if (booleanPlaceAttributeValue2 == null) {
            throw new NullPointerException("Null wheelchairAccessibleEntrance");
        }
        this.f75141b = booleanPlaceAttributeValue2;
        if (booleanPlaceAttributeValue3 == null) {
            throw new NullPointerException("Null wheelchairAccessibleRestroom");
        }
        this.f75142c = booleanPlaceAttributeValue3;
        if (booleanPlaceAttributeValue4 == null) {
            throw new NullPointerException("Null wheelchairAccessibleSeating");
        }
        this.f75143d = booleanPlaceAttributeValue4;
    }

    @Override // com.google.android.libraries.places.api.model.AccessibilityOptions
    public final Place.BooleanPlaceAttributeValue d() {
        return this.f75141b;
    }

    @Override // com.google.android.libraries.places.api.model.AccessibilityOptions
    public final Place.BooleanPlaceAttributeValue e() {
        return this.f75140a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AccessibilityOptions) {
            AccessibilityOptions accessibilityOptions = (AccessibilityOptions) obj;
            if (this.f75140a.equals(accessibilityOptions.e()) && this.f75141b.equals(accessibilityOptions.d()) && this.f75142c.equals(accessibilityOptions.f()) && this.f75143d.equals(accessibilityOptions.g())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.places.api.model.AccessibilityOptions
    public final Place.BooleanPlaceAttributeValue f() {
        return this.f75142c;
    }

    @Override // com.google.android.libraries.places.api.model.AccessibilityOptions
    public final Place.BooleanPlaceAttributeValue g() {
        return this.f75143d;
    }

    public final int hashCode() {
        return ((((((this.f75140a.hashCode() ^ 1000003) * 1000003) ^ this.f75141b.hashCode()) * 1000003) ^ this.f75142c.hashCode()) * 1000003) ^ this.f75143d.hashCode();
    }

    public final String toString() {
        String string = this.f75140a.toString();
        int length = string.length();
        String string2 = this.f75141b.toString();
        int length2 = string2.length();
        String string3 = this.f75142c.toString();
        int length3 = string3.length();
        String string4 = this.f75143d.toString();
        StringBuilder sb = new StringBuilder(length + 80 + length2 + 31 + length3 + 30 + string4.length() + 1);
        sb.append("AccessibilityOptions{wheelchairAccessibleParking=");
        sb.append(string);
        sb.append(", wheelchairAccessibleEntrance=");
        sb.append(string2);
        sb.append(", wheelchairAccessibleRestroom=");
        sb.append(string3);
        sb.append(", wheelchairAccessibleSeating=");
        sb.append(string4);
        sb.append("}");
        return sb.toString();
    }
}
