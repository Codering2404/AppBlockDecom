package com.google.android.libraries.places.api.model;

import com.google.android.libraries.places.api.model.FuelOptions;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzad extends FuelOptions.Builder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List f75046a;

    zzad() {
    }

    @Override // com.google.android.libraries.places.api.model.FuelOptions.Builder
    public final List b() {
        List list = this.f75046a;
        if (list != null) {
            return list;
        }
        throw new IllegalStateException("Property \"fuelPrices\" has not been set");
    }

    @Override // com.google.android.libraries.places.api.model.FuelOptions.Builder
    public final FuelOptions.Builder c(List list) {
        if (list == null) {
            throw new NullPointerException("Null fuelPrices");
        }
        this.f75046a = list;
        return this;
    }

    @Override // com.google.android.libraries.places.api.model.FuelOptions.Builder
    final FuelOptions d() {
        List list = this.f75046a;
        if (list != null) {
            return new zzdo(list);
        }
        throw new IllegalStateException("Missing required properties: fuelPrices");
    }
}
