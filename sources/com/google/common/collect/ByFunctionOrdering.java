package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
final class ByFunctionOrdering<F, T> extends Ordering<F> implements Serializable {
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Function f83788a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Ordering f83789b;

    ByFunctionOrdering(Function function, Ordering ordering) {
        this.f83788a = (Function) Preconditions.t(function);
        this.f83789b = (Ordering) Preconditions.t(ordering);
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public int compare(Object obj, Object obj2) {
        return this.f83789b.compare(this.f83788a.apply(obj), this.f83788a.apply(obj2));
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByFunctionOrdering) {
            ByFunctionOrdering byFunctionOrdering = (ByFunctionOrdering) obj;
            if (this.f83788a.equals(byFunctionOrdering.f83788a) && this.f83789b.equals(byFunctionOrdering.f83789b)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Objects.b(this.f83788a, this.f83789b);
    }

    public String toString() {
        return this.f83789b + ".onResultOf(" + this.f83788a + ")";
    }
}
