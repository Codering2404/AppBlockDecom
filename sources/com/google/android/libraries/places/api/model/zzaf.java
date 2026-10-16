package com.google.android.libraries.places.api.model;

import com.google.android.libraries.places.api.model.FuelPrice;
import java.time.Instant;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzaf extends FuelPrice.Builder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private FuelPrice.FuelType f75048a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Money f75049b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Instant f75050c;

    zzaf() {
    }

    @Override // com.google.android.libraries.places.api.model.FuelPrice.Builder
    public final FuelPrice a() {
        Money money;
        Instant instant;
        FuelPrice.FuelType fuelType = this.f75048a;
        if (fuelType != null && (money = this.f75049b) != null && (instant = this.f75050c) != null) {
            return new zzdq(fuelType, money, instant);
        }
        StringBuilder sb = new StringBuilder();
        if (this.f75048a == null) {
            sb.append(" type");
        }
        if (this.f75049b == null) {
            sb.append(" price");
        }
        if (this.f75050c == null) {
            sb.append(" updateTime");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }

    @Override // com.google.android.libraries.places.api.model.FuelPrice.Builder
    public final FuelPrice.Builder b(Money money) {
        if (money == null) {
            throw new NullPointerException("Null price");
        }
        this.f75049b = money;
        return this;
    }

    @Override // com.google.android.libraries.places.api.model.FuelPrice.Builder
    public final FuelPrice.Builder c(Instant instant) {
        if (instant == null) {
            throw new NullPointerException("Null updateTime");
        }
        this.f75050c = instant;
        return this;
    }

    public final FuelPrice.Builder d(FuelPrice.FuelType fuelType) {
        if (fuelType == null) {
            throw new NullPointerException("Null type");
        }
        this.f75048a = fuelType;
        return this;
    }
}
