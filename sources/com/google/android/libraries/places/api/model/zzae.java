package com.google.android.libraries.places.api.model;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
abstract class zzae extends FuelOptions {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f75047a;

    zzae(List list) {
        if (list == null) {
            throw new NullPointerException("Null fuelPrices");
        }
        this.f75047a = list;
    }

    @Override // com.google.android.libraries.places.api.model.FuelOptions
    public final List c() {
        return this.f75047a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof FuelOptions) {
            return this.f75047a.equals(((FuelOptions) obj).c());
        }
        return false;
    }

    public final int hashCode() {
        return this.f75047a.hashCode() ^ 1000003;
    }

    public final String toString() {
        String string = this.f75047a.toString();
        StringBuilder sb = new StringBuilder(string.length() + 24);
        sb.append("FuelOptions{fuelPrices=");
        sb.append(string);
        sb.append("}");
        return sb.toString();
    }
}
