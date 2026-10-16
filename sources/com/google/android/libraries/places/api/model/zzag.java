package com.google.android.libraries.places.api.model;

import com.google.android.libraries.places.api.model.FuelPrice;
import java.time.Instant;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
abstract class zzag extends FuelPrice {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final FuelPrice.FuelType f75051a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Money f75052b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Instant f75053c;

    zzag(FuelPrice.FuelType fuelType, Money money, Instant instant) {
        if (fuelType == null) {
            throw new NullPointerException("Null type");
        }
        this.f75051a = fuelType;
        if (money == null) {
            throw new NullPointerException("Null price");
        }
        this.f75052b = money;
        if (instant == null) {
            throw new NullPointerException("Null updateTime");
        }
        this.f75053c = instant;
    }

    @Override // com.google.android.libraries.places.api.model.FuelPrice
    public final Money c() {
        return this.f75052b;
    }

    @Override // com.google.android.libraries.places.api.model.FuelPrice
    public final FuelPrice.FuelType d() {
        return this.f75051a;
    }

    @Override // com.google.android.libraries.places.api.model.FuelPrice
    public final Instant e() {
        return this.f75053c;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof FuelPrice) {
            FuelPrice fuelPrice = (FuelPrice) obj;
            if (this.f75051a.equals(fuelPrice.d()) && this.f75052b.equals(fuelPrice.c()) && this.f75053c.equals(fuelPrice.e())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.f75051a.hashCode() ^ 1000003) * 1000003) ^ this.f75052b.hashCode()) * 1000003) ^ this.f75053c.hashCode();
    }

    public final String toString() {
        String string = this.f75051a.toString();
        int length = string.length();
        String string2 = this.f75052b.toString();
        int length2 = string2.length();
        String string3 = this.f75053c.toString();
        StringBuilder sb = new StringBuilder(length + 23 + length2 + 13 + string3.length() + 1);
        sb.append("FuelPrice{type=");
        sb.append(string);
        sb.append(", price=");
        sb.append(string2);
        sb.append(", updateTime=");
        sb.append(string3);
        sb.append("}");
        return sb.toString();
    }
}
