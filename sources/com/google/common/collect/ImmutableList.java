package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import java.util.stream.Collector;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public abstract class ImmutableList<E> extends ImmutableCollection<E> implements List<E>, RandomAccess {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final UnmodifiableListIterator f84015b = new Itr(RegularImmutableList.f84578f, 0);
    private static final long serialVersionUID = -889275714;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder<E> extends ImmutableCollection.ArrayBasedBuilder<E> {
        public Builder() {
            this(4);
        }

        @Override // com.google.common.collect.ImmutableCollection.ArrayBasedBuilder
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public Builder e(Object obj) {
            super.e(obj);
            return this;
        }

        public Builder j(Object... objArr) {
            super.f(objArr);
            return this;
        }

        public Builder k(Iterable iterable) {
            super.b(iterable);
            return this;
        }

        public Builder l(Iterator it) {
            super.c(it);
            return this;
        }

        public ImmutableList m() {
            this.f84007c = true;
            return ImmutableList.n(this.f84005a, this.f84006b);
        }

        ImmutableList n(Comparator comparator) {
            this.f84007c = true;
            Arrays.sort(this.f84005a, 0, this.f84006b, comparator);
            return ImmutableList.n(this.f84005a, this.f84006b);
        }

        Builder o(Builder builder) {
            g(builder.f84005a, builder.f84006b);
            return this;
        }

        Builder(int i3) {
            super(i3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Itr<E> extends AbstractIndexedListIterator<E> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final ImmutableList f84016c;

        Itr(ImmutableList immutableList, int i3) {
            super(immutableList.size(), i3);
            this.f84016c = immutableList;
        }

        @Override // com.google.common.collect.AbstractIndexedListIterator
        protected Object a(int i3) {
            return this.f84016c.get(i3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class ReverseImmutableList<E> extends ImmutableList<E> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final transient ImmutableList f84017c;

        ReverseImmutableList(ImmutableList immutableList) {
            this.f84017c = immutableList;
        }

        private int P(int i3) {
            return (size() - 1) - i3;
        }

        private int Q(int i3) {
            return size() - i3;
        }

        @Override // com.google.common.collect.ImmutableList
        public ImmutableList J() {
            return this.f84017c;
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        /* JADX INFO: renamed from: L, reason: merged with bridge method [inline-methods] */
        public ImmutableList subList(int i3, int i4) {
            Preconditions.y(i3, i4, size());
            return this.f84017c.subList(Q(i4), Q(i3)).J();
        }

        @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return this.f84017c.contains(obj);
        }

        @Override // com.google.common.collect.ImmutableCollection
        boolean g() {
            return this.f84017c.g();
        }

        @Override // java.util.List
        public Object get(int i3) {
            Preconditions.r(i3, size());
            return this.f84017c.get(P(i3));
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public int indexOf(Object obj) {
            int iLastIndexOf = this.f84017c.lastIndexOf(obj);
            if (iLastIndexOf >= 0) {
                return P(iLastIndexOf);
            }
            return -1;
        }

        @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return super.iterator();
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public int lastIndexOf(Object obj) {
            int iIndexOf = this.f84017c.indexOf(obj);
            if (iIndexOf >= 0) {
                return P(iIndexOf);
            }
            return -1;
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator() {
            return super.listIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f84017c.size();
        }

        @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection
        Object writeReplace() {
            return super.writeReplace();
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator(int i3) {
            return super.listIterator(i3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Object[] f84018a;

        SerializedForm(Object[] objArr) {
            this.f84018a = objArr;
        }

        Object readResolve() {
            return ImmutableList.v(this.f84018a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class SubList extends ImmutableList<E> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final transient int f84019c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final transient int f84020d;

        SubList(int i3, int i4) {
            this.f84019c = i3;
            this.f84020d = i4;
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        /* JADX INFO: renamed from: L */
        public ImmutableList subList(int i3, int i4) {
            Preconditions.y(i3, i4, this.f84020d);
            ImmutableList immutableList = ImmutableList.this;
            int i5 = this.f84019c;
            return immutableList.subList(i3 + i5, i4 + i5);
        }

        @Override // com.google.common.collect.ImmutableCollection
        Object[] d() {
            return ImmutableList.this.d();
        }

        @Override // com.google.common.collect.ImmutableCollection
        int e() {
            return ImmutableList.this.f() + this.f84019c + this.f84020d;
        }

        @Override // com.google.common.collect.ImmutableCollection
        int f() {
            return ImmutableList.this.f() + this.f84019c;
        }

        @Override // com.google.common.collect.ImmutableCollection
        boolean g() {
            return true;
        }

        @Override // java.util.List
        public Object get(int i3) {
            Preconditions.r(i3, this.f84020d);
            return ImmutableList.this.get(i3 + this.f84019c);
        }

        @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return super.iterator();
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator() {
            return super.listIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f84020d;
        }

        @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection
        Object writeReplace() {
            return super.writeReplace();
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator(int i3) {
            return super.listIterator(i3);
        }
    }

    ImmutableList() {
    }

    public static ImmutableList A(Object obj, Object obj2) {
        return q(obj, obj2);
    }

    public static ImmutableList B(Object obj, Object obj2, Object obj3) {
        return q(obj, obj2, obj3);
    }

    public static ImmutableList C(Object obj, Object obj2, Object obj3, Object obj4) {
        return q(obj, obj2, obj3, obj4);
    }

    public static ImmutableList D(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        return q(obj, obj2, obj3, obj4, obj5);
    }

    public static ImmutableList E(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        return q(obj, obj2, obj3, obj4, obj5, obj6);
    }

    public static ImmutableList G(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7) {
        return q(obj, obj2, obj3, obj4, obj5, obj6, obj7);
    }

    public static ImmutableList H(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9) {
        return q(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9);
    }

    public static ImmutableList I(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object... objArr) {
        Preconditions.e(objArr.length <= 2147483635, "the total number of elements must fit in an int");
        Object[] objArr2 = new Object[objArr.length + 12];
        objArr2[0] = obj;
        objArr2[1] = obj2;
        objArr2[2] = obj3;
        objArr2[3] = obj4;
        objArr2[4] = obj5;
        objArr2[5] = obj6;
        objArr2[6] = obj7;
        objArr2[7] = obj8;
        objArr2[8] = obj9;
        objArr2[9] = obj10;
        objArr2[10] = obj11;
        objArr2[11] = obj12;
        System.arraycopy(objArr, 0, objArr2, 12, objArr.length);
        return q(objArr2);
    }

    public static ImmutableList K(Comparator comparator, Iterable iterable) {
        Preconditions.t(comparator);
        Object[] objArrU = Iterables.u(iterable);
        ObjectArrays.b(objArrU);
        Arrays.sort(objArrU, comparator);
        return l(objArrU);
    }

    public static Collector N() {
        return CollectCollectors.d();
    }

    static ImmutableList l(Object[] objArr) {
        return n(objArr, objArr.length);
    }

    static ImmutableList n(Object[] objArr, int i3) {
        return i3 == 0 ? y() : new RegularImmutableList(objArr, i3);
    }

    public static Builder o() {
        return new Builder();
    }

    public static Builder p(int i3) {
        CollectPreconditions.b(i3, "expectedSize");
        return new Builder(i3);
    }

    private static ImmutableList q(Object... objArr) {
        return l(ObjectArrays.b(objArr));
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    public static ImmutableList s(Iterable iterable) {
        Preconditions.t(iterable);
        return iterable instanceof Collection ? t((Collection) iterable) : u(iterable.iterator());
    }

    public static ImmutableList t(Collection collection) {
        if (!(collection instanceof ImmutableCollection)) {
            return q(collection.toArray());
        }
        ImmutableList immutableListA = ((ImmutableCollection) collection).a();
        return immutableListA.g() ? l(immutableListA.toArray()) : immutableListA;
    }

    public static ImmutableList u(Iterator it) {
        if (!it.hasNext()) {
            return y();
        }
        Object next = it.next();
        return !it.hasNext() ? z(next) : new Builder().a(next).l(it).m();
    }

    public static ImmutableList v(Object[] objArr) {
        return objArr.length == 0 ? y() : q((Object[]) objArr.clone());
    }

    public static ImmutableList y() {
        return RegularImmutableList.f84578f;
    }

    public static ImmutableList z(Object obj) {
        return q(obj);
    }

    public ImmutableList J() {
        return size() <= 1 ? this : new ReverseImmutableList(this);
    }

    @Override // java.util.List
    /* JADX INFO: renamed from: L */
    public ImmutableList subList(int i3, int i4) {
        Preconditions.y(i3, i4, size());
        int i5 = i4 - i3;
        return i5 == size() ? this : i5 == 0 ? y() : M(i3, i4);
    }

    ImmutableList M(int i3, int i4) {
        return new SubList(i3, i4 - i3);
    }

    @Override // java.util.List
    public final void add(int i3, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public final boolean addAll(int i3, Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ImmutableCollection
    int b(Object[] objArr, int i3) {
        int size = size();
        for (int i4 = 0; i4 < size; i4++) {
            objArr[i3 + i4] = get(i4);
        }
        return i3 + size;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        return Lists.d(this, obj);
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public UnmodifiableIterator iterator() {
        return listIterator();
    }

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        int size = size();
        int i3 = 1;
        for (int i4 = 0; i4 < size; i4++) {
            i3 = ~(~((i3 * 31) + get(i4).hashCode()));
        }
        return i3;
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        return Lists.e(this, obj);
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        return Lists.g(this, obj);
    }

    @Override // java.util.List
    public final Object remove(int i3) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public final Object set(int i3, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
    public UnmodifiableListIterator listIterator() {
        return listIterator(0);
    }

    @Override // com.google.common.collect.ImmutableCollection
    Object writeReplace() {
        return new SerializedForm(toArray());
    }

    @Override // java.util.List
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public UnmodifiableListIterator listIterator(int i3) {
        Preconditions.w(i3, size());
        return isEmpty() ? f84015b : new Itr(this, i3);
    }

    @Override // com.google.common.collect.ImmutableCollection
    public final ImmutableList a() {
        return this;
    }
}
