package com.google.android.libraries.places.api.model;

import java.time.Instant;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
abstract class zzp extends ConnectorAggregation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final EVConnectorType f75382a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Double f75383b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Integer f75384c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Integer f75385d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Integer f75386f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Instant f75387g;

    zzp(EVConnectorType eVConnectorType, Double d3, Integer num, Integer num2, Integer num3, Instant instant) {
        if (eVConnectorType == null) {
            throw new NullPointerException("Null type");
        }
        this.f75382a = eVConnectorType;
        this.f75383b = d3;
        this.f75384c = num;
        this.f75385d = num2;
        this.f75386f = num3;
        this.f75387g = instant;
    }

    @Override // com.google.android.libraries.places.api.model.ConnectorAggregation
    public final Instant c() {
        return this.f75387g;
    }

    @Override // com.google.android.libraries.places.api.model.ConnectorAggregation
    public final Integer d() {
        return this.f75385d;
    }

    @Override // com.google.android.libraries.places.api.model.ConnectorAggregation
    public final Integer e() {
        return this.f75384c;
    }

    public final boolean equals(Object obj) {
        Integer num;
        Integer num2;
        Instant instant;
        if (obj == this) {
            return true;
        }
        if (obj instanceof ConnectorAggregation) {
            ConnectorAggregation connectorAggregation = (ConnectorAggregation) obj;
            if (this.f75382a.equals(connectorAggregation.h()) && this.f75383b.equals(connectorAggregation.f()) && this.f75384c.equals(connectorAggregation.e()) && ((num = this.f75385d) != null ? num.equals(connectorAggregation.d()) : connectorAggregation.d() == null) && ((num2 = this.f75386f) != null ? num2.equals(connectorAggregation.g()) : connectorAggregation.g() == null) && ((instant = this.f75387g) != null ? instant.equals(connectorAggregation.c()) : connectorAggregation.c() == null)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.places.api.model.ConnectorAggregation
    public final Double f() {
        return this.f75383b;
    }

    @Override // com.google.android.libraries.places.api.model.ConnectorAggregation
    public final Integer g() {
        return this.f75386f;
    }

    @Override // com.google.android.libraries.places.api.model.ConnectorAggregation
    public final EVConnectorType h() {
        return this.f75382a;
    }

    public final int hashCode() {
        int iHashCode = ((((this.f75382a.hashCode() ^ 1000003) * 1000003) ^ this.f75383b.hashCode()) * 1000003) ^ this.f75384c.hashCode();
        Integer num = this.f75385d;
        int iHashCode2 = ((iHashCode * 1000003) ^ (num == null ? 0 : num.hashCode())) * 1000003;
        Integer num2 = this.f75386f;
        int iHashCode3 = (iHashCode2 ^ (num2 == null ? 0 : num2.hashCode())) * 1000003;
        Instant instant = this.f75387g;
        return iHashCode3 ^ (instant != null ? instant.hashCode() : 0);
    }

    public final String toString() {
        String string = this.f75382a.toString();
        int length = string.length();
        String strValueOf = String.valueOf(this.f75387g);
        Double d3 = this.f75383b;
        int length2 = d3.toString().length();
        Integer num = this.f75384c;
        int length3 = num.toString().length();
        Integer num2 = this.f75385d;
        int length4 = String.valueOf(num2).length();
        Integer num3 = this.f75386f;
        StringBuilder sb = new StringBuilder(length + 44 + length2 + 8 + length3 + 17 + length4 + 20 + String.valueOf(num3).length() + 29 + strValueOf.length() + 1);
        sb.append("ConnectorAggregation{type=");
        sb.append(string);
        sb.append(", maxChargeRateKw=");
        sb.append(d3);
        sb.append(", count=");
        sb.append(num);
        sb.append(", availableCount=");
        sb.append(num2);
        sb.append(", outOfServiceCount=");
        sb.append(num3);
        sb.append(", availabilityLastUpdateTime=");
        sb.append(strValueOf);
        sb.append("}");
        return sb.toString();
    }
}
