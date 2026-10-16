package com.google.common.collect;

import com.google.android.gms.common.api.Api;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.math.IntMath;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public final class Collections2 {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class FilteredCollection<E> extends AbstractCollection<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Collection f83799a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Predicate f83800b;

        FilteredCollection(Collection collection, Predicate predicate) {
            this.f83799a = collection;
            this.f83800b = predicate;
        }

        FilteredCollection a(Predicate predicate) {
            return new FilteredCollection(this.f83799a, Predicates.c(this.f83800b, predicate));
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean add(Object obj) {
            Preconditions.d(this.f83800b.apply(obj));
            return this.f83799a.add(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean addAll(Collection collection) {
            Iterator<E> it = collection.iterator();
            while (it.hasNext()) {
                Preconditions.d(this.f83800b.apply(it.next()));
            }
            return this.f83799a.addAll(collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            Iterables.p(this.f83799a, this.f83800b);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            if (Collections2.g(this.f83799a, obj)) {
                return this.f83800b.apply(obj);
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean containsAll(Collection collection) {
            return Collections2.b(this, collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return !Iterables.b(this.f83799a, this.f83800b);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return Iterators.p(this.f83799a.iterator(), this.f83800b);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            return contains(obj) && this.f83799a.remove(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection collection) {
            Iterator<E> it = this.f83799a.iterator();
            boolean z2 = false;
            while (it.hasNext()) {
                E next = it.next();
                if (this.f83800b.apply(next) && collection.contains(next)) {
                    it.remove();
                    z2 = true;
                }
            }
            return z2;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection collection) {
            Iterator<E> it = this.f83799a.iterator();
            boolean z2 = false;
            while (it.hasNext()) {
                E next = it.next();
                if (this.f83800b.apply(next) && !collection.contains(next)) {
                    it.remove();
                    z2 = true;
                }
            }
            return z2;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            Iterator<E> it = this.f83799a.iterator();
            int i3 = 0;
            while (it.hasNext()) {
                if (this.f83800b.apply(it.next())) {
                    i3++;
                }
            }
            return i3;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public Object[] toArray() {
            return Lists.k(iterator()).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public Object[] toArray(Object[] objArr) {
            return Lists.k(iterator()).toArray(objArr);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class OrderedPermutationCollection<E> extends AbstractCollection<List<E>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final ImmutableList f83801a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Comparator f83802b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final int f83803c;

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            if (!(obj instanceof List)) {
                return false;
            }
            return Collections2.e(this.f83801a, (List) obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return new OrderedPermutationIterator(this.f83801a, this.f83802b);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.f83803c;
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            return "orderedPermutationCollection(" + this.f83801a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class OrderedPermutationIterator<E> extends AbstractIterator<List<E>> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        List f83804c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final Comparator f83805d;

        OrderedPermutationIterator(List list, Comparator comparator) {
            this.f83804c = Lists.j(list);
            this.f83805d = comparator;
        }

        void d() {
            int iF = f();
            if (iF == -1) {
                this.f83804c = null;
                return;
            }
            Objects.requireNonNull(this.f83804c);
            Collections.swap(this.f83804c, iF, g(iF));
            Collections.reverse(this.f83804c.subList(iF + 1, this.f83804c.size()));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.AbstractIterator
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public List a() {
            List list = this.f83804c;
            if (list == null) {
                return (List) b();
            }
            ImmutableList immutableListT = ImmutableList.t(list);
            d();
            return immutableListT;
        }

        int f() {
            Objects.requireNonNull(this.f83804c);
            for (int size = this.f83804c.size() - 2; size >= 0; size--) {
                if (this.f83805d.compare(this.f83804c.get(size), this.f83804c.get(size + 1)) < 0) {
                    return size;
                }
            }
            return -1;
        }

        int g(int i3) {
            Objects.requireNonNull(this.f83804c);
            Object obj = this.f83804c.get(i3);
            for (int size = this.f83804c.size() - 1; size > i3; size--) {
                if (this.f83805d.compare(obj, this.f83804c.get(size)) < 0) {
                    return size;
                }
            }
            throw new AssertionError("this statement should be unreachable");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class PermutationCollection<E> extends AbstractCollection<List<E>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final ImmutableList f83806a;

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            if (!(obj instanceof List)) {
                return false;
            }
            return Collections2.e(this.f83806a, (List) obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return new PermutationIterator(this.f83806a);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return IntMath.e(this.f83806a.size());
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            return "permutations(" + this.f83806a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class PermutationIterator<E> extends AbstractIterator<List<E>> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final List f83807c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final int[] f83808d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final int[] f83809f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int f83810g;

        PermutationIterator(List list) {
            this.f83807c = new ArrayList(list);
            int size = list.size();
            int[] iArr = new int[size];
            this.f83808d = iArr;
            int[] iArr2 = new int[size];
            this.f83809f = iArr2;
            Arrays.fill(iArr, 0);
            Arrays.fill(iArr2, 1);
            this.f83810g = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        }

        void d() {
            int size = this.f83807c.size() - 1;
            this.f83810g = size;
            if (size == -1) {
                return;
            }
            int i3 = 0;
            while (true) {
                int[] iArr = this.f83808d;
                int i4 = this.f83810g;
                int i5 = iArr[i4];
                int i6 = this.f83809f[i4] + i5;
                if (i6 < 0) {
                    f();
                } else if (i6 != i4 + 1) {
                    Collections.swap(this.f83807c, (i4 - i5) + i3, (i4 - i6) + i3);
                    this.f83808d[this.f83810g] = i6;
                    return;
                } else {
                    if (i4 == 0) {
                        return;
                    }
                    i3++;
                    f();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.AbstractIterator
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public List a() {
            if (this.f83810g <= 0) {
                return (List) b();
            }
            ImmutableList immutableListT = ImmutableList.t(this.f83807c);
            d();
            return immutableListT;
        }

        void f() {
            int[] iArr = this.f83809f;
            int i3 = this.f83810g;
            iArr[i3] = -iArr[i3];
            this.f83810g = i3 - 1;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class TransformedCollection<F, T> extends AbstractCollection<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Collection f83811a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Function f83812b;

        TransformedCollection(Collection collection, Function function) {
            this.f83811a = (Collection) Preconditions.t(collection);
            this.f83812b = (Function) Preconditions.t(function);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            this.f83811a.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return this.f83811a.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return Iterators.N(this.f83811a.iterator(), this.f83812b);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.f83811a.size();
        }
    }

    static boolean b(Collection collection, Collection collection2) {
        Iterator it = collection2.iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    private static ObjectCountHashMap c(Collection collection) {
        ObjectCountHashMap objectCountHashMap = new ObjectCountHashMap();
        for (Object obj : collection) {
            objectCountHashMap.u(obj, objectCountHashMap.f(obj) + 1);
        }
        return objectCountHashMap;
    }

    public static Collection d(Collection collection, Predicate predicate) {
        return collection instanceof FilteredCollection ? ((FilteredCollection) collection).a(predicate) : new FilteredCollection((Collection) Preconditions.t(collection), (Predicate) Preconditions.t(predicate));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean e(List list, List list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        ObjectCountHashMap objectCountHashMapC = c(list);
        ObjectCountHashMap objectCountHashMapC2 = c(list2);
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i3 = 0; i3 < list.size(); i3++) {
            if (objectCountHashMapC.k(i3) != objectCountHashMapC2.f(objectCountHashMapC.i(i3))) {
                return false;
            }
        }
        return true;
    }

    static StringBuilder f(int i3) {
        CollectPreconditions.b(i3, "size");
        return new StringBuilder((int) Math.min(((long) i3) * 8, 1073741824L));
    }

    static boolean g(Collection collection, Object obj) {
        Preconditions.t(collection);
        try {
            return collection.contains(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    static boolean h(Collection collection, Object obj) {
        Preconditions.t(collection);
        try {
            return collection.remove(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    static String i(Collection collection) {
        StringBuilder sbF = f(collection.size());
        sbF.append('[');
        boolean z2 = true;
        for (Object obj : collection) {
            if (!z2) {
                sbF.append(", ");
            }
            if (obj == collection) {
                sbF.append("(this Collection)");
            } else {
                sbF.append(obj);
            }
            z2 = false;
        }
        sbF.append(']');
        return sbF.toString();
    }

    public static Collection j(Collection collection, Function function) {
        return new TransformedCollection(collection, function);
    }
}
