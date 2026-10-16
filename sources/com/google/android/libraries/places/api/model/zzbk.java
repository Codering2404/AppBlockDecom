package com.google.android.libraries.places.api.model;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
abstract class zzbk extends zzgf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Money f75263a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Money f75264b;

    zzbk(Money money, Money money2) {
        this.f75263a = money;
        this.f75264b = money2;
    }

    @Override // com.google.android.libraries.places.api.model.zzgf
    public final Money c() {
        return this.f75263a;
    }

    @Override // com.google.android.libraries.places.api.model.zzgf
    public final Money d() {
        return this.f75264b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzgf) {
            zzgf zzgfVar = (zzgf) obj;
            Money money = this.f75263a;
            if (money != null ? money.equals(zzgfVar.c()) : zzgfVar.c() == null) {
                Money money2 = this.f75264b;
                if (money2 != null ? money2.equals(zzgfVar.d()) : zzgfVar.d() == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        Money money = this.f75263a;
        int iHashCode = money == null ? 0 : money.hashCode();
        Money money2 = this.f75264b;
        return ((iHashCode ^ 1000003) * 1000003) ^ (money2 != null ? money2.hashCode() : 0);
    }

    public final String toString() {
        Money money = this.f75264b;
        String strValueOf = String.valueOf(this.f75263a);
        String strValueOf2 = String.valueOf(money);
        StringBuilder sb = new StringBuilder(strValueOf.length() + 33 + strValueOf2.length() + 1);
        sb.append("PriceRange{startPrice=");
        sb.append(strValueOf);
        sb.append(", endPrice=");
        sb.append(strValueOf2);
        sb.append("}");
        return sb.toString();
    }
}
