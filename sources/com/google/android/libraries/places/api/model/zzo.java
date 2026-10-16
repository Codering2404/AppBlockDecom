package com.google.android.libraries.places.api.model;

import com.google.android.libraries.places.api.model.ConnectorAggregation;
import java.time.Instant;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzo extends ConnectorAggregation.Builder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private EVConnectorType f75376a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Double f75377b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Integer f75378c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Integer f75379d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Integer f75380e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Instant f75381f;

    zzo() {
    }

    @Override // com.google.android.libraries.places.api.model.ConnectorAggregation.Builder
    public final ConnectorAggregation a() {
        Double d3;
        Integer num;
        EVConnectorType eVConnectorType = this.f75376a;
        if (eVConnectorType != null && (d3 = this.f75377b) != null && (num = this.f75378c) != null) {
            return new zzcy(eVConnectorType, d3, num, this.f75379d, this.f75380e, this.f75381f);
        }
        StringBuilder sb = new StringBuilder();
        if (this.f75376a == null) {
            sb.append(" type");
        }
        if (this.f75377b == null) {
            sb.append(" maxChargeRateKw");
        }
        if (this.f75378c == null) {
            sb.append(" count");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }

    @Override // com.google.android.libraries.places.api.model.ConnectorAggregation.Builder
    public final ConnectorAggregation.Builder b(Instant instant) {
        this.f75381f = instant;
        return this;
    }

    @Override // com.google.android.libraries.places.api.model.ConnectorAggregation.Builder
    public final ConnectorAggregation.Builder c(Integer num) {
        this.f75379d = num;
        return this;
    }

    @Override // com.google.android.libraries.places.api.model.ConnectorAggregation.Builder
    public final ConnectorAggregation.Builder d(Integer num) {
        if (num == null) {
            throw new NullPointerException("Null count");
        }
        this.f75378c = num;
        return this;
    }

    @Override // com.google.android.libraries.places.api.model.ConnectorAggregation.Builder
    public final ConnectorAggregation.Builder e(Double d3) {
        if (d3 == null) {
            throw new NullPointerException("Null maxChargeRateKw");
        }
        this.f75377b = d3;
        return this;
    }

    @Override // com.google.android.libraries.places.api.model.ConnectorAggregation.Builder
    public final ConnectorAggregation.Builder f(Integer num) {
        this.f75380e = num;
        return this;
    }

    public final ConnectorAggregation.Builder g(EVConnectorType eVConnectorType) {
        if (eVConnectorType == null) {
            throw new NullPointerException("Null type");
        }
        this.f75376a = eVConnectorType;
        return this;
    }
}
