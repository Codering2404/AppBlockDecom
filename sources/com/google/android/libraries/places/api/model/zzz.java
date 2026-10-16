package com.google.android.libraries.places.api.model;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
abstract class zzz extends EVSearchOptions {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Double f75414a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f75415b;

    zzz(Double d3, List list) {
        this.f75414a = d3;
        this.f75415b = list;
    }

    @Override // com.google.android.libraries.places.api.model.EVSearchOptions
    public final List c() {
        return this.f75415b;
    }

    @Override // com.google.android.libraries.places.api.model.EVSearchOptions
    public final Double d() {
        return this.f75414a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof EVSearchOptions) {
            EVSearchOptions eVSearchOptions = (EVSearchOptions) obj;
            Double d3 = this.f75414a;
            if (d3 != null ? d3.equals(eVSearchOptions.d()) : eVSearchOptions.d() == null) {
                List list = this.f75415b;
                if (list != null ? list.equals(eVSearchOptions.c()) : eVSearchOptions.c() == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        Double d3 = this.f75414a;
        int iHashCode = d3 == null ? 0 : d3.hashCode();
        List list = this.f75415b;
        return ((iHashCode ^ 1000003) * 1000003) ^ (list != null ? list.hashCode() : 0);
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.f75415b);
        Double d3 = this.f75414a;
        StringBuilder sb = new StringBuilder(String.valueOf(d3).length() + 55 + strValueOf.length() + 1);
        sb.append("EVSearchOptions{minimumChargingRateKw=");
        sb.append(d3);
        sb.append(", connectorTypes=");
        sb.append(strValueOf);
        sb.append("}");
        return sb.toString();
    }
}
