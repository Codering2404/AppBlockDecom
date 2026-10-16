package com.google.common.collect;

import androidx.compose.material.icons.twotone.Phg.QaXmqxvjHhxVy;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.Multiset;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public abstract class ImmutableMultiset<E> extends ImmutableMultisetGwtSerializationDependencies<E> implements Multiset<E> {
    private static final long serialVersionUID = 912559;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private transient ImmutableList f84074b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private transient ImmutableSet f84075c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private final class EntrySet extends IndexedImmutableSet<Multiset.Entry<E>> {
        private static final long serialVersionUID = 0;

        private EntrySet() {
        }

        private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
            throw new InvalidObjectException("Use EntrySetSerializedForm");
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.IndexedImmutableSet
        /* JADX INFO: renamed from: I, reason: merged with bridge method [inline-methods] */
        public Multiset.Entry get(int i3) {
            return ImmutableMultiset.this.q(i3);
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (obj instanceof Multiset.Entry) {
                Multiset.Entry entry = (Multiset.Entry) obj;
                if (entry.getCount() > 0 && ImmutableMultiset.this.Y1(entry.a()) == entry.getCount()) {
                    return true;
                }
            }
            return false;
        }

        @Override // com.google.common.collect.ImmutableCollection
        boolean g() {
            return ImmutableMultiset.this.g();
        }

        @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
        public int hashCode() {
            return ImmutableMultiset.this.hashCode();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return ImmutableMultiset.this.i().size();
        }

        @Override // com.google.common.collect.IndexedImmutableSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
        Object writeReplace() {
            return new EntrySetSerializedForm(ImmutableMultiset.this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class EntrySetSerializedForm<E> implements Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final ImmutableMultiset f84084a;

        EntrySetSerializedForm(ImmutableMultiset immutableMultiset) {
            this.f84084a = immutableMultiset;
        }

        Object readResolve() {
            return this.f84084a.entrySet();
        }
    }

    ImmutableMultiset() {
    }

    public static ImmutableMultiset l(Iterable iterable) {
        if (iterable instanceof ImmutableMultiset) {
            ImmutableMultiset immutableMultiset = (ImmutableMultiset) iterable;
            if (!immutableMultiset.g()) {
                return immutableMultiset;
            }
        }
        Builder builder = new Builder(Multisets.i(iterable));
        builder.f(iterable);
        return builder.h();
    }

    private ImmutableSet n() {
        return isEmpty() ? ImmutableSet.z() : new EntrySet();
    }

    public static ImmutableMultiset s() {
        return RegularImmutableMultiset.f84595h;
    }

    @Override // com.google.common.collect.Multiset
    public final boolean L1(Object obj, int i3, int i4) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ImmutableCollection
    public ImmutableList a() {
        ImmutableList immutableList = this.f84074b;
        if (immutableList != null) {
            return immutableList;
        }
        ImmutableList immutableListA = super.a();
        this.f84074b = immutableListA;
        return immutableListA;
    }

    @Override // com.google.common.collect.ImmutableCollection
    int b(Object[] objArr, int i3) {
        UnmodifiableIterator it = entrySet().iterator();
        while (it.hasNext()) {
            Multiset.Entry entry = (Multiset.Entry) it.next();
            Arrays.fill(objArr, i3, entry.getCount() + i3, entry.a());
            i3 += entry.getCount();
        }
        return i3;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return Y1(obj) > 0;
    }

    @Override // com.google.common.collect.Multiset
    public final int e0(Object obj, int i3) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection, com.google.common.collect.Multiset
    public boolean equals(Object obj) {
        return Multisets.f(this, obj);
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    /* JADX INFO: renamed from: h */
    public UnmodifiableIterator iterator() {
        final UnmodifiableIterator it = entrySet().iterator();
        return new UnmodifiableIterator<E>(this) { // from class: com.google.common.collect.ImmutableMultiset.1

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f84076a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            Object f84077b;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ ImmutableMultiset f84079d;

            {
                this.f84079d = this;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f84076a > 0 || it.hasNext();
            }

            @Override // java.util.Iterator
            public Object next() {
                if (this.f84076a <= 0) {
                    Multiset.Entry entry = (Multiset.Entry) it.next();
                    this.f84077b = entry.a();
                    this.f84076a = entry.getCount();
                }
                this.f84076a--;
                Object obj = this.f84077b;
                Objects.requireNonNull(obj);
                return obj;
            }
        };
    }

    @Override // java.util.Collection, com.google.common.collect.Multiset
    public int hashCode() {
        return Sets.f(entrySet());
    }

    @Override // com.google.common.collect.Multiset
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public abstract ImmutableSet i();

    @Override // com.google.common.collect.Multiset
    public final int o1(Object obj, int i3) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.Multiset
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public ImmutableSet entrySet() {
        ImmutableSet immutableSet = this.f84075c;
        if (immutableSet != null) {
            return immutableSet;
        }
        ImmutableSet immutableSetN = n();
        this.f84075c = immutableSetN;
        return immutableSetN;
    }

    abstract Multiset.Entry q(int i3);

    @Override // com.google.common.collect.Multiset
    public final int t1(Object obj, int i3) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return entrySet().toString();
    }

    @Override // com.google.common.collect.ImmutableCollection
    abstract Object writeReplace();

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException(QaXmqxvjHhxVy.FPVtzIaeMKP);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Builder<E> extends ImmutableCollection.Builder<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        ObjectCountHashMap f84080a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f84081b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f84082c;

        Builder(int i3) {
            this.f84081b = false;
            this.f84082c = false;
            this.f84080a = ObjectCountHashMap.c(i3);
        }

        static ObjectCountHashMap i(Iterable iterable) {
            if (iterable instanceof RegularImmutableMultiset) {
                return ((RegularImmutableMultiset) iterable).f84596d;
            }
            if (iterable instanceof AbstractMapBasedMultiset) {
                return ((AbstractMapBasedMultiset) iterable).f83729c;
            }
            return null;
        }

        @Override // com.google.common.collect.ImmutableCollection.Builder
        public Builder e(Object obj) {
            return g(obj, 1);
        }

        public Builder f(Iterable iterable) {
            Objects.requireNonNull(this.f84080a);
            if (!(iterable instanceof Multiset)) {
                super.b(iterable);
                return this;
            }
            Multiset multisetD = Multisets.d(iterable);
            ObjectCountHashMap objectCountHashMapI = i(multisetD);
            if (objectCountHashMapI != null) {
                ObjectCountHashMap objectCountHashMap = this.f84080a;
                objectCountHashMap.d(Math.max(objectCountHashMap.C(), objectCountHashMapI.C()));
                for (int iE = objectCountHashMapI.e(); iE >= 0; iE = objectCountHashMapI.s(iE)) {
                    g(objectCountHashMapI.i(iE), objectCountHashMapI.k(iE));
                }
            } else {
                Set setEntrySet = multisetD.entrySet();
                ObjectCountHashMap objectCountHashMap2 = this.f84080a;
                objectCountHashMap2.d(Math.max(objectCountHashMap2.C(), setEntrySet.size()));
                for (Multiset.Entry entry : multisetD.entrySet()) {
                    g(entry.a(), entry.getCount());
                }
            }
            return this;
        }

        public Builder g(Object obj, int i3) {
            Objects.requireNonNull(this.f84080a);
            if (i3 == 0) {
                return this;
            }
            if (this.f84081b) {
                this.f84080a = new ObjectCountHashMap(this.f84080a);
                this.f84082c = false;
            }
            this.f84081b = false;
            Preconditions.t(obj);
            ObjectCountHashMap objectCountHashMap = this.f84080a;
            objectCountHashMap.u(obj, i3 + objectCountHashMap.f(obj));
            return this;
        }

        public ImmutableMultiset h() {
            Objects.requireNonNull(this.f84080a);
            if (this.f84080a.C() == 0) {
                return ImmutableMultiset.s();
            }
            if (this.f84082c) {
                this.f84080a = new ObjectCountHashMap(this.f84080a);
                this.f84082c = false;
            }
            this.f84081b = true;
            return new RegularImmutableMultiset(this.f84080a);
        }

        Builder(boolean z2) {
            this.f84081b = false;
            this.f84082c = false;
            this.f84080a = null;
        }
    }
}
