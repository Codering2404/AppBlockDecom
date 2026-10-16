package com.google.android.libraries.places.api.model;

import com.google.android.libraries.places.api.model.Place;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
abstract class zzaz extends PaymentOptions {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Place.BooleanPlaceAttributeValue f75136a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Place.BooleanPlaceAttributeValue f75137b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Place.BooleanPlaceAttributeValue f75138c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Place.BooleanPlaceAttributeValue f75139d;

    zzaz(Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue, Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue2, Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue3, Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue4) {
        if (booleanPlaceAttributeValue == null) {
            throw new NullPointerException("Null acceptsCreditCards");
        }
        this.f75136a = booleanPlaceAttributeValue;
        if (booleanPlaceAttributeValue2 == null) {
            throw new NullPointerException("Null acceptsDebitCards");
        }
        this.f75137b = booleanPlaceAttributeValue2;
        if (booleanPlaceAttributeValue3 == null) {
            throw new NullPointerException("Null acceptsCashOnly");
        }
        this.f75138c = booleanPlaceAttributeValue3;
        if (booleanPlaceAttributeValue4 == null) {
            throw new NullPointerException("Null acceptsNfc");
        }
        this.f75139d = booleanPlaceAttributeValue4;
    }

    @Override // com.google.android.libraries.places.api.model.PaymentOptions
    public final Place.BooleanPlaceAttributeValue d() {
        return this.f75138c;
    }

    @Override // com.google.android.libraries.places.api.model.PaymentOptions
    public final Place.BooleanPlaceAttributeValue e() {
        return this.f75136a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof PaymentOptions) {
            PaymentOptions paymentOptions = (PaymentOptions) obj;
            if (this.f75136a.equals(paymentOptions.e()) && this.f75137b.equals(paymentOptions.f()) && this.f75138c.equals(paymentOptions.d()) && this.f75139d.equals(paymentOptions.g())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.places.api.model.PaymentOptions
    public final Place.BooleanPlaceAttributeValue f() {
        return this.f75137b;
    }

    @Override // com.google.android.libraries.places.api.model.PaymentOptions
    public final Place.BooleanPlaceAttributeValue g() {
        return this.f75139d;
    }

    public final int hashCode() {
        return ((((((this.f75136a.hashCode() ^ 1000003) * 1000003) ^ this.f75137b.hashCode()) * 1000003) ^ this.f75138c.hashCode()) * 1000003) ^ this.f75139d.hashCode();
    }

    public final String toString() {
        String string = this.f75136a.toString();
        int length = string.length();
        String string2 = this.f75137b.toString();
        int length2 = string2.length();
        String string3 = this.f75138c.toString();
        int length3 = string3.length();
        String string4 = this.f75139d.toString();
        StringBuilder sb = new StringBuilder(length + 54 + length2 + 18 + length3 + 13 + string4.length() + 1);
        sb.append("PaymentOptions{acceptsCreditCards=");
        sb.append(string);
        sb.append(", acceptsDebitCards=");
        sb.append(string2);
        sb.append(", acceptsCashOnly=");
        sb.append(string3);
        sb.append(", acceptsNfc=");
        sb.append(string4);
        sb.append("}");
        return sb.toString();
    }
}
