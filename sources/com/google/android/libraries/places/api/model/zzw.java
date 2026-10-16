package com.google.android.libraries.places.api.model;

import com.google.android.libraries.places.api.model.EVChargeOptions;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzw extends EVChargeOptions.Builder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Integer f75410a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List f75411b;

    zzw() {
    }

    @Override // com.google.android.libraries.places.api.model.EVChargeOptions.Builder
    public final EVChargeOptions a() {
        List list;
        Integer num = this.f75410a;
        if (num != null && (list = this.f75411b) != null) {
            return new zzdg(num, list);
        }
        StringBuilder sb = new StringBuilder();
        if (this.f75410a == null) {
            sb.append(" connectorCount");
        }
        if (this.f75411b == null) {
            sb.append(" connectorAggregations");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }

    @Override // com.google.android.libraries.places.api.model.EVChargeOptions.Builder
    public final EVChargeOptions.Builder b(List list) {
        if (list == null) {
            throw new NullPointerException("Null connectorAggregations");
        }
        this.f75411b = list;
        return this;
    }

    public final EVChargeOptions.Builder c(Integer num) {
        if (num == null) {
            throw new NullPointerException("Null connectorCount");
        }
        this.f75410a = num;
        return this;
    }
}
