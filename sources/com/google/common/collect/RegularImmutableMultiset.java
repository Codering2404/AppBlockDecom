package com.google.common.collect;

import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.Multiset;
import com.google.common.primitives.Ints;
import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
class RegularImmutableMultiset<E> extends ImmutableMultiset<E> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    static final RegularImmutableMultiset f84595h = new RegularImmutableMultiset(ObjectCountHashMap.b());

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final transient ObjectCountHashMap f84596d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final transient int f84597f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private transient ImmutableSet f84598g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private final class ElementSet extends IndexedImmutableSet<E> {
        private ElementSet() {
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return RegularImmutableMultiset.this.contains(obj);
        }

        @Override // com.google.common.collect.ImmutableCollection
        boolean g() {
            return true;
        }

        @Override // com.google.common.collect.IndexedImmutableSet
        Object get(int i3) {
            return RegularImmutableMultiset.this.f84596d.i(i3);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return RegularImmutableMultiset.this.f84596d.C();
        }

        @Override // com.google.common.collect.IndexedImmutableSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
        Object writeReplace() {
            return super.writeReplace();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Object[] f84600a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int[] f84601b;

        SerializedForm(Multiset multiset) {
            int size = multiset.entrySet().size();
            this.f84600a = new Object[size];
            this.f84601b = new int[size];
            int i3 = 0;
            for (Multiset.Entry entry : multiset.entrySet()) {
                this.f84600a[i3] = entry.a();
                this.f84601b[i3] = entry.getCount();
                i3++;
            }
        }

        Object readResolve() {
            ImmutableMultiset.Builder builder = new ImmutableMultiset.Builder(this.f84600a.length);
            int i3 = 0;
            while (true) {
                Object[] objArr = this.f84600a;
                if (i3 >= objArr.length) {
                    return builder.h();
                }
                builder.g(objArr[i3], this.f84601b[i3]);
                i3++;
            }
        }
    }

    RegularImmutableMultiset(ObjectCountHashMap objectCountHashMap) {
        this.f84596d = objectCountHashMap;
        long jK = 0;
        for (int i3 = 0; i3 < objectCountHashMap.C(); i3++) {
            jK += (long) objectCountHashMap.k(i3);
        }
        this.f84597f = Ints.m(jK);
    }

    @Override // com.google.common.collect.Multiset
    public int Y1(Object obj) {
        return this.f84596d.f(obj);
    }

    @Override // com.google.common.collect.ImmutableCollection
    boolean g() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.Multiset
    /* JADX INFO: renamed from: o */
    public ImmutableSet i() {
        ImmutableSet immutableSet = this.f84598g;
        if (immutableSet != null) {
            return immutableSet;
        }
        ElementSet elementSet = new ElementSet();
        this.f84598g = elementSet;
        return elementSet;
    }

    @Override // com.google.common.collect.ImmutableMultiset
    Multiset.Entry q(int i3) {
        return this.f84596d.g(i3);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public int size() {
        return this.f84597f;
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.ImmutableCollection
    Object writeReplace() {
        return new SerializedForm(this);
    }
}
