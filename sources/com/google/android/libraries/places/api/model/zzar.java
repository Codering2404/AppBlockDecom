package com.google.android.libraries.places.api.model;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
abstract class zzar extends Money {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f75091a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Long f75092b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Integer f75093c;

    zzar(String str, Long l3, Integer num) {
        if (str == null) {
            throw new NullPointerException("Null currencyCode");
        }
        this.f75091a = str;
        this.f75092b = l3;
        this.f75093c = num;
    }

    @Override // com.google.android.libraries.places.api.model.Money
    public final String c() {
        return this.f75091a;
    }

    @Override // com.google.android.libraries.places.api.model.Money
    public final Integer d() {
        return this.f75093c;
    }

    @Override // com.google.android.libraries.places.api.model.Money
    public final Long e() {
        return this.f75092b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Money) {
            Money money = (Money) obj;
            if (this.f75091a.equals(money.c()) && this.f75092b.equals(money.e()) && this.f75093c.equals(money.d())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.f75091a.hashCode() ^ 1000003) * 1000003) ^ this.f75092b.hashCode()) * 1000003) ^ this.f75093c.hashCode();
    }

    public final String toString() {
        Long l3 = this.f75092b;
        int length = l3.toString().length();
        Integer num = this.f75093c;
        int length2 = num.toString().length();
        String str = this.f75091a;
        StringBuilder sb = new StringBuilder(str.length() + 27 + length + 8 + length2 + 1);
        sb.append("Money{currencyCode=");
        sb.append(str);
        sb.append(", units=");
        sb.append(l3);
        sb.append(", nanos=");
        sb.append(num);
        sb.append("}");
        return sb.toString();
    }
}
