package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.Multiset;
import com.google.common.primitives.Ints;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
abstract class AbstractMapBasedMultiset<E> extends AbstractMultiset<E> implements Serializable {
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    transient ObjectCountHashMap f83729c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    transient long f83730d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    abstract class Itr<T> implements Iterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f83733a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f83734b = -1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f83735c;

        Itr() {
            this.f83733a = AbstractMapBasedMultiset.this.f83729c.e();
            this.f83735c = AbstractMapBasedMultiset.this.f83729c.f84542d;
        }

        private void a() {
            if (AbstractMapBasedMultiset.this.f83729c.f84542d != this.f83735c) {
                throw new ConcurrentModificationException();
            }
        }

        abstract Object b(int i3);

        @Override // java.util.Iterator
        public boolean hasNext() {
            a();
            return this.f83733a >= 0;
        }

        @Override // java.util.Iterator
        public Object next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Object objB = b(this.f83733a);
            int i3 = this.f83733a;
            this.f83734b = i3;
            this.f83733a = AbstractMapBasedMultiset.this.f83729c.s(i3);
            return objB;
        }

        @Override // java.util.Iterator
        public void remove() {
            a();
            CollectPreconditions.e(this.f83734b != -1);
            AbstractMapBasedMultiset abstractMapBasedMultiset = AbstractMapBasedMultiset.this;
            abstractMapBasedMultiset.f83730d -= (long) abstractMapBasedMultiset.f83729c.x(this.f83734b);
            this.f83733a = AbstractMapBasedMultiset.this.f83729c.t(this.f83733a, this.f83734b);
            this.f83734b = -1;
            this.f83735c = AbstractMapBasedMultiset.this.f83729c.f84542d;
        }
    }

    AbstractMapBasedMultiset(int i3) {
        this.f83729c = h(i3);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        int iH = Serialization.h(objectInputStream);
        this.f83729c = h(3);
        Serialization.g(this, objectInputStream, iH);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        Serialization.k(this, objectOutputStream);
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public final boolean L1(Object obj, int i3, int i4) {
        CollectPreconditions.b(i3, "oldCount");
        CollectPreconditions.b(i4, "newCount");
        int iM = this.f83729c.m(obj);
        if (iM == -1) {
            if (i3 != 0) {
                return false;
            }
            if (i4 > 0) {
                this.f83729c.u(obj, i4);
                this.f83730d += (long) i4;
            }
            return true;
        }
        if (this.f83729c.k(iM) != i3) {
            return false;
        }
        if (i4 == 0) {
            this.f83729c.x(iM);
            this.f83730d -= (long) i3;
        } else {
            this.f83729c.B(iM, i4);
            this.f83730d += (long) (i4 - i3);
        }
        return true;
    }

    @Override // com.google.common.collect.Multiset
    public final int Y1(Object obj) {
        return this.f83729c.f(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        this.f83729c.a();
        this.f83730d = 0L;
    }

    @Override // com.google.common.collect.AbstractMultiset
    final int d() {
        return this.f83729c.C();
    }

    @Override // com.google.common.collect.AbstractMultiset
    final Iterator e() {
        return new AbstractMapBasedMultiset<E>.Itr<E>() { // from class: com.google.common.collect.AbstractMapBasedMultiset.1
            @Override // com.google.common.collect.AbstractMapBasedMultiset.Itr
            Object b(int i3) {
                return AbstractMapBasedMultiset.this.f83729c.i(i3);
            }
        };
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public final int e0(Object obj, int i3) {
        CollectPreconditions.b(i3, "count");
        ObjectCountHashMap objectCountHashMap = this.f83729c;
        int iV = i3 == 0 ? objectCountHashMap.v(obj) : objectCountHashMap.u(obj, i3);
        this.f83730d += (long) (i3 - iV);
        return iV;
    }

    @Override // com.google.common.collect.AbstractMultiset
    final Iterator f() {
        return new AbstractMapBasedMultiset<E>.Itr<Multiset.Entry<E>>() { // from class: com.google.common.collect.AbstractMapBasedMultiset.2
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.google.common.collect.AbstractMapBasedMultiset.Itr
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public Multiset.Entry b(int i3) {
                return AbstractMapBasedMultiset.this.f83729c.g(i3);
            }
        };
    }

    void g(Multiset multiset) {
        Preconditions.t(multiset);
        int iE = this.f83729c.e();
        while (iE >= 0) {
            multiset.t1(this.f83729c.i(iE), this.f83729c.k(iE));
            iE = this.f83729c.s(iE);
        }
    }

    abstract ObjectCountHashMap h(int i3);

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, com.google.common.collect.Multiset
    public final Iterator iterator() {
        return Multisets.j(this);
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public final int o1(Object obj, int i3) {
        if (i3 == 0) {
            return Y1(obj);
        }
        Preconditions.h(i3 > 0, "occurrences cannot be negative: %s", i3);
        int iM = this.f83729c.m(obj);
        if (iM == -1) {
            return 0;
        }
        int iK = this.f83729c.k(iM);
        if (iK > i3) {
            this.f83729c.B(iM, iK - i3);
        } else {
            this.f83729c.x(iM);
            i3 = iK;
        }
        this.f83730d -= (long) i3;
        return iK;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public final int size() {
        return Ints.m(this.f83730d);
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public final int t1(Object obj, int i3) {
        if (i3 == 0) {
            return Y1(obj);
        }
        Preconditions.h(i3 > 0, "occurrences cannot be negative: %s", i3);
        int iM = this.f83729c.m(obj);
        if (iM == -1) {
            this.f83729c.u(obj, i3);
            this.f83730d += (long) i3;
            return 0;
        }
        int iK = this.f83729c.k(iM);
        long j3 = i3;
        long j4 = ((long) iK) + j3;
        Preconditions.k(j4 <= 2147483647L, "too many occurrences: %s", j4);
        this.f83729c.B(iM, (int) j4);
        this.f83730d += j3;
        return iK;
    }
}
