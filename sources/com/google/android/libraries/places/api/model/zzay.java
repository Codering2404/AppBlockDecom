package com.google.android.libraries.places.api.model;

import androidx.compose.material.icons.twotone.Phg.QaXmqxvjHhxVy;
import com.google.android.libraries.places.api.model.PaymentOptions;
import com.google.android.libraries.places.api.model.Place;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzay extends PaymentOptions.Builder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Place.BooleanPlaceAttributeValue f75132a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Place.BooleanPlaceAttributeValue f75133b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Place.BooleanPlaceAttributeValue f75134c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Place.BooleanPlaceAttributeValue f75135d;

    zzay() {
    }

    @Override // com.google.android.libraries.places.api.model.PaymentOptions.Builder
    public final PaymentOptions.Builder b(Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue) {
        if (booleanPlaceAttributeValue == null) {
            throw new NullPointerException("Null acceptsCashOnly");
        }
        this.f75134c = booleanPlaceAttributeValue;
        return this;
    }

    @Override // com.google.android.libraries.places.api.model.PaymentOptions.Builder
    public final PaymentOptions.Builder c(Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue) {
        if (booleanPlaceAttributeValue == null) {
            throw new NullPointerException("Null acceptsCreditCards");
        }
        this.f75132a = booleanPlaceAttributeValue;
        return this;
    }

    @Override // com.google.android.libraries.places.api.model.PaymentOptions.Builder
    public final PaymentOptions.Builder d(Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue) {
        if (booleanPlaceAttributeValue == null) {
            throw new NullPointerException("Null acceptsDebitCards");
        }
        this.f75133b = booleanPlaceAttributeValue;
        return this;
    }

    @Override // com.google.android.libraries.places.api.model.PaymentOptions.Builder
    public final PaymentOptions.Builder e(Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue) {
        if (booleanPlaceAttributeValue == null) {
            throw new NullPointerException("Null acceptsNfc");
        }
        this.f75135d = booleanPlaceAttributeValue;
        return this;
    }

    @Override // com.google.android.libraries.places.api.model.PaymentOptions.Builder
    public final PaymentOptions a() {
        Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue;
        Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue2;
        Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue3;
        Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue4 = this.f75132a;
        if (booleanPlaceAttributeValue4 != null && (booleanPlaceAttributeValue = this.f75133b) != null && (booleanPlaceAttributeValue2 = this.f75134c) != null && (booleanPlaceAttributeValue3 = this.f75135d) != null) {
            return new zzek(booleanPlaceAttributeValue4, booleanPlaceAttributeValue, booleanPlaceAttributeValue2, booleanPlaceAttributeValue3);
        }
        StringBuilder sb = new StringBuilder();
        if (this.f75132a == null) {
            sb.append(" acceptsCreditCards");
        }
        if (this.f75133b == null) {
            sb.append(" acceptsDebitCards");
        }
        if (this.f75134c == null) {
            sb.append(QaXmqxvjHhxVy.AiePU);
        }
        if (this.f75135d == null) {
            sb.append(" acceptsNfc");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }
}
