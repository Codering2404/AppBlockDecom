package com.google.android.libraries.places.api.model;

import com.google.android.libraries.places.api.model.Money;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzaq extends Money.Builder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f75088a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Long f75089b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Integer f75090c;

    zzaq() {
    }

    @Override // com.google.android.libraries.places.api.model.Money.Builder
    public final Integer b() {
        Integer num = this.f75090c;
        if (num != null) {
            return num;
        }
        throw new IllegalStateException("Property \"nanos\" has not been set");
    }

    @Override // com.google.android.libraries.places.api.model.Money.Builder
    public final Long c() {
        Long l3 = this.f75089b;
        if (l3 != null) {
            return l3;
        }
        throw new IllegalStateException("Property \"units\" has not been set");
    }

    @Override // com.google.android.libraries.places.api.model.Money.Builder
    public final Money.Builder d(Integer num) {
        if (num == null) {
            throw new NullPointerException("Null nanos");
        }
        this.f75090c = num;
        return this;
    }

    @Override // com.google.android.libraries.places.api.model.Money.Builder
    public final Money.Builder e(Long l3) {
        if (l3 == null) {
            throw new NullPointerException("Null units");
        }
        this.f75089b = l3;
        return this;
    }

    @Override // com.google.android.libraries.places.api.model.Money.Builder
    final Money f() {
        Long l3;
        Integer num;
        String str = this.f75088a;
        if (str != null && (l3 = this.f75089b) != null && (num = this.f75090c) != null) {
            return new zzec(str, l3, num);
        }
        StringBuilder sb = new StringBuilder();
        if (this.f75088a == null) {
            sb.append(" currencyCode");
        }
        if (this.f75089b == null) {
            sb.append(" units");
        }
        if (this.f75090c == null) {
            sb.append(" nanos");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }

    public final Money.Builder g(String str) {
        if (str == null) {
            throw new NullPointerException("Null currencyCode");
        }
        this.f75088a = str;
        return this;
    }
}
