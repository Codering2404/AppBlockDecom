package com.google.common.base;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
final class FunctionalEquivalence<F, T> extends Equivalence<F> implements Serializable {
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function f83298a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Equivalence f83299b;

    @Override // com.google.common.base.Equivalence
    protected boolean a(Object obj, Object obj2) {
        return this.f83299b.d(this.f83298a.apply(obj), this.f83298a.apply(obj2));
    }

    @Override // com.google.common.base.Equivalence
    protected int b(Object obj) {
        return this.f83299b.e(this.f83298a.apply(obj));
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof FunctionalEquivalence) {
            FunctionalEquivalence functionalEquivalence = (FunctionalEquivalence) obj;
            if (this.f83298a.equals(functionalEquivalence.f83298a) && this.f83299b.equals(functionalEquivalence.f83299b)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Objects.b(this.f83298a, this.f83299b);
    }

    public String toString() {
        return this.f83299b + ".onResultOf(" + this.f83298a + ")";
    }
}
