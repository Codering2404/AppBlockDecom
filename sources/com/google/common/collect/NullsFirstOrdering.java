package com.google.common.collect;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
final class NullsFirstOrdering<T> extends Ordering<T> implements Serializable {
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Ordering f84537a;

    NullsFirstOrdering(Ordering ordering) {
        this.f84537a = ordering;
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public int compare(Object obj, Object obj2) {
        if (obj == obj2) {
            return 0;
        }
        if (obj == null) {
            return -1;
        }
        if (obj2 == null) {
            return 1;
        }
        return this.f84537a.compare(obj, obj2);
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof NullsFirstOrdering) {
            return this.f84537a.equals(((NullsFirstOrdering) obj).f84537a);
        }
        return false;
    }

    @Override // com.google.common.collect.Ordering
    public Ordering h() {
        return this.f84537a.h();
    }

    public int hashCode() {
        return this.f84537a.hashCode() ^ 957692532;
    }

    @Override // com.google.common.collect.Ordering
    public Ordering k() {
        return this.f84537a.k().h();
    }

    public String toString() {
        return this.f84537a + ".nullsFirst()";
    }

    @Override // com.google.common.collect.Ordering
    public Ordering g() {
        return this;
    }
}
