package com.google.common.base;

import java.io.Serializable;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
final class PairwiseEquivalence<E, T extends E> extends Equivalence<Iterable<T>> implements Serializable {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Equivalence f83334a;

    public boolean equals(Object obj) {
        if (obj instanceof PairwiseEquivalence) {
            return this.f83334a.equals(((PairwiseEquivalence) obj).f83334a);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.base.Equivalence
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public boolean a(Iterable iterable, Iterable iterable2) {
        Iterator it = iterable.iterator();
        Iterator it2 = iterable2.iterator();
        while (it.hasNext() && it2.hasNext()) {
            if (!this.f83334a.d(it.next(), it2.next())) {
                return false;
            }
        }
        return (it.hasNext() || it2.hasNext()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.base.Equivalence
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public int b(Iterable iterable) {
        Iterator it = iterable.iterator();
        int iE = 78721;
        while (it.hasNext()) {
            iE = (iE * 24943) + this.f83334a.e(it.next());
        }
        return iE;
    }

    public int hashCode() {
        return this.f83334a.hashCode() ^ 1185147655;
    }

    public String toString() {
        return this.f83334a + ".pairwise()";
    }
}
