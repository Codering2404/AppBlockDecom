package com.google.common.graph;

import com.google.common.collect.AbstractIterator;
import com.google.common.collect.UnmodifiableIterator;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
abstract class MultiEdgesConnecting<E> extends AbstractSet<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map f84989a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f84990b;

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public UnmodifiableIterator iterator() {
        final Iterator<E> it = this.f84989a.entrySet().iterator();
        return new AbstractIterator<E>(this) { // from class: com.google.common.graph.MultiEdgesConnecting.1

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ MultiEdgesConnecting f84992d;

            {
                this.f84992d = this;
            }

            @Override // com.google.common.collect.AbstractIterator
            protected Object a() {
                while (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    if (this.f84992d.f84990b.equals(entry.getValue())) {
                        return entry.getKey();
                    }
                }
                return b();
            }
        };
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return this.f84990b.equals(this.f84989a.get(obj));
    }
}
