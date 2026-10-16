package com.google.android.libraries.places.api.model;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
abstract class zzx extends EVChargeOptions {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Integer f75412a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f75413b;

    zzx(Integer num, List list) {
        this.f75412a = num;
        if (list == null) {
            throw new NullPointerException("Null connectorAggregations");
        }
        this.f75413b = list;
    }

    @Override // com.google.android.libraries.places.api.model.EVChargeOptions
    public final List c() {
        return this.f75413b;
    }

    @Override // com.google.android.libraries.places.api.model.EVChargeOptions
    public final Integer d() {
        return this.f75412a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof EVChargeOptions) {
            EVChargeOptions eVChargeOptions = (EVChargeOptions) obj;
            if (this.f75412a.equals(eVChargeOptions.d()) && this.f75413b.equals(eVChargeOptions.c())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((this.f75412a.hashCode() ^ 1000003) * 1000003) ^ this.f75413b.hashCode();
    }

    public final String toString() {
        String string = this.f75413b.toString();
        Integer num = this.f75412a;
        StringBuilder sb = new StringBuilder(num.toString().length() + 55 + string.length() + 1);
        sb.append("EVChargeOptions{connectorCount=");
        sb.append(num);
        sb.append(", connectorAggregations=");
        sb.append(string);
        sb.append("}");
        return sb.toString();
    }
}
