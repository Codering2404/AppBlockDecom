package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import com.google.common.primitives.Ints;
import java.io.Serializable;
import java.math.RoundingMode;
import java.util.AbstractList;
import java.util.AbstractSequentialList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public final class Lists {

    /* JADX INFO: renamed from: com.google.common.collect.Lists$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 extends RandomAccessListWrapper<Object> {
        @Override // java.util.AbstractList, java.util.List
        public ListIterator listIterator(int i3) {
            return this.f84271a.listIterator(i3);
        }
    }

    /* JADX INFO: renamed from: com.google.common.collect.Lists$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass2 extends AbstractListWrapper<Object> {
        @Override // java.util.AbstractList, java.util.List
        public ListIterator listIterator(int i3) {
            return this.f84271a.listIterator(i3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class AbstractListWrapper<E> extends AbstractList<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final List f84271a;

        @Override // java.util.AbstractList, java.util.List
        public void add(int i3, Object obj) {
            this.f84271a.add(i3, obj);
        }

        @Override // java.util.AbstractList, java.util.List
        public boolean addAll(int i3, Collection collection) {
            return this.f84271a.addAll(i3, collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(Object obj) {
            return this.f84271a.contains(obj);
        }

        @Override // java.util.AbstractList, java.util.List
        public Object get(int i3) {
            return this.f84271a.get(i3);
        }

        @Override // java.util.AbstractList, java.util.List
        public Object remove(int i3) {
            return this.f84271a.remove(i3);
        }

        @Override // java.util.AbstractList, java.util.List
        public Object set(int i3, Object obj) {
            return this.f84271a.set(i3, obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f84271a.size();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class CharSequenceAsList extends AbstractList<Character> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final CharSequence f84272a;

        @Override // java.util.AbstractList, java.util.List
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Character get(int i3) {
            Preconditions.r(i3, size());
            return Character.valueOf(this.f84272a.charAt(i3));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f84272a.length();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class OnePlusArrayList<E> extends AbstractList<E> implements Serializable, RandomAccess {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Object f84273a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Object[] f84274b;

        @Override // java.util.AbstractList, java.util.List
        public Object get(int i3) {
            Preconditions.r(i3, size());
            return i3 == 0 ? this.f84273a : this.f84274b[i3 - 1];
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return IntMath.i(this.f84274b.length, 1);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Partition<T> extends AbstractList<List<T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final List f84275a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f84276b;

        @Override // java.util.AbstractList, java.util.List
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List get(int i3) {
            Preconditions.r(i3, size());
            int i4 = this.f84276b;
            int i5 = i3 * i4;
            return this.f84275a.subList(i5, Math.min(i4 + i5, this.f84275a.size()));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return this.f84275a.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return IntMath.d(this.f84275a.size(), this.f84276b, RoundingMode.CEILING);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class RandomAccessListWrapper<E> extends AbstractListWrapper<E> implements RandomAccess {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class RandomAccessPartition<T> extends Partition<T> implements RandomAccess {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class RandomAccessReverseList<T> extends ReverseList<T> implements RandomAccess {
        RandomAccessReverseList(List list) {
            super(list);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class ReverseList<T> extends AbstractList<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List f84277a;

        ReverseList(List list) {
            this.f84277a = (List) Preconditions.t(list);
        }

        private int d(int i3) {
            int size = size();
            Preconditions.r(i3, size);
            return (size - 1) - i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int e(int i3) {
            int size = size();
            Preconditions.w(i3, size);
            return size - i3;
        }

        @Override // java.util.AbstractList, java.util.List
        public void add(int i3, Object obj) {
            this.f84277a.add(e(i3), obj);
        }

        List b() {
            return this.f84277a;
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public void clear() {
            this.f84277a.clear();
        }

        @Override // java.util.AbstractList, java.util.List
        public Object get(int i3) {
            return this.f84277a.get(d(i3));
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
        public Iterator iterator() {
            return listIterator();
        }

        @Override // java.util.AbstractList, java.util.List
        public ListIterator listIterator(int i3) {
            final ListIterator listIterator = this.f84277a.listIterator(e(i3));
            return new ListIterator<T>(this) { // from class: com.google.common.collect.Lists.ReverseList.1

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                boolean f84278a;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                final /* synthetic */ ReverseList f84280c;

                {
                    this.f84280c = this;
                }

                @Override // java.util.ListIterator
                public void add(Object obj) {
                    listIterator.add(obj);
                    listIterator.previous();
                    this.f84278a = false;
                }

                @Override // java.util.ListIterator, java.util.Iterator
                public boolean hasNext() {
                    return listIterator.hasPrevious();
                }

                @Override // java.util.ListIterator
                public boolean hasPrevious() {
                    return listIterator.hasNext();
                }

                @Override // java.util.ListIterator, java.util.Iterator
                public Object next() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    this.f84278a = true;
                    return listIterator.previous();
                }

                @Override // java.util.ListIterator
                public int nextIndex() {
                    return this.f84280c.e(listIterator.nextIndex());
                }

                @Override // java.util.ListIterator
                public Object previous() {
                    if (!hasPrevious()) {
                        throw new NoSuchElementException();
                    }
                    this.f84278a = true;
                    return listIterator.next();
                }

                @Override // java.util.ListIterator
                public int previousIndex() {
                    return nextIndex() - 1;
                }

                @Override // java.util.ListIterator, java.util.Iterator
                public void remove() {
                    CollectPreconditions.e(this.f84278a);
                    listIterator.remove();
                    this.f84278a = false;
                }

                @Override // java.util.ListIterator
                public void set(Object obj) {
                    Preconditions.z(this.f84278a);
                    listIterator.set(obj);
                }
            };
        }

        @Override // java.util.AbstractList, java.util.List
        public Object remove(int i3) {
            return this.f84277a.remove(d(i3));
        }

        @Override // java.util.AbstractList
        protected void removeRange(int i3, int i4) {
            subList(i3, i4).clear();
        }

        @Override // java.util.AbstractList, java.util.List
        public Object set(int i3, Object obj) {
            return this.f84277a.set(d(i3), obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f84277a.size();
        }

        @Override // java.util.AbstractList, java.util.List
        public List subList(int i3, int i4) {
            Preconditions.y(i3, i4, size());
            return Lists.o(this.f84277a.subList(e(i4), e(i3)));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class StringAsImmutableList extends ImmutableList<Character> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f84281c;

        StringAsImmutableList(String str) {
            this.f84281c = str;
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        /* JADX INFO: renamed from: L */
        public ImmutableList subList(int i3, int i4) {
            Preconditions.y(i3, i4, size());
            return Lists.b(this.f84281c.substring(i3, i4));
        }

        @Override // java.util.List
        /* JADX INFO: renamed from: P, reason: merged with bridge method [inline-methods] */
        public Character get(int i3) {
            Preconditions.r(i3, size());
            return Character.valueOf(this.f84281c.charAt(i3));
        }

        @Override // com.google.common.collect.ImmutableCollection
        boolean g() {
            return false;
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public int indexOf(Object obj) {
            if (obj instanceof Character) {
                return this.f84281c.indexOf(((Character) obj).charValue());
            }
            return -1;
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public int lastIndexOf(Object obj) {
            if (obj instanceof Character) {
                return this.f84281c.lastIndexOf(((Character) obj).charValue());
            }
            return -1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f84281c.length();
        }

        @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection
        Object writeReplace() {
            return super.writeReplace();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class TransformingRandomAccessList<F, T> extends AbstractList<T> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final List f84282a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Function f84283b;

        TransformingRandomAccessList(List list, Function function) {
            this.f84282a = (List) Preconditions.t(list);
            this.f84283b = (Function) Preconditions.t(function);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.AbstractList, java.util.List
        public Object get(int i3) {
            return this.f84283b.apply(this.f84282a.get(i3));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return this.f84282a.isEmpty();
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
        public Iterator iterator() {
            return listIterator();
        }

        @Override // java.util.AbstractList, java.util.List
        public ListIterator listIterator(int i3) {
            return new TransformedListIterator<F, T>(this.f84282a.listIterator(i3)) { // from class: com.google.common.collect.Lists.TransformingRandomAccessList.1
                @Override // com.google.common.collect.TransformedIterator
                Object a(Object obj) {
                    return TransformingRandomAccessList.this.f84283b.apply(obj);
                }
            };
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.AbstractList, java.util.List
        public Object remove(int i3) {
            return this.f84283b.apply(this.f84282a.remove(i3));
        }

        @Override // java.util.AbstractList
        protected void removeRange(int i3, int i4) {
            this.f84282a.subList(i3, i4).clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f84282a.size();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class TransformingSequentialList<F, T> extends AbstractSequentialList<T> implements Serializable {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final List f84285a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Function f84286b;

        TransformingSequentialList(List list, Function function) {
            this.f84285a = (List) Preconditions.t(list);
            this.f84286b = (Function) Preconditions.t(function);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return this.f84285a.isEmpty();
        }

        @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
        public ListIterator listIterator(int i3) {
            return new TransformedListIterator<F, T>(this.f84285a.listIterator(i3)) { // from class: com.google.common.collect.Lists.TransformingSequentialList.1
                @Override // com.google.common.collect.TransformedIterator
                Object a(Object obj) {
                    return TransformingSequentialList.this.f84286b.apply(obj);
                }
            };
        }

        @Override // java.util.AbstractList
        protected void removeRange(int i3, int i4) {
            this.f84285a.subList(i3, i4).clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f84285a.size();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class TwoPlusArrayList<E> extends AbstractList<E> implements Serializable, RandomAccess {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Object f84288a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Object f84289b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final Object[] f84290c;

        @Override // java.util.AbstractList, java.util.List
        public Object get(int i3) {
            if (i3 == 0) {
                return this.f84288a;
            }
            if (i3 == 1) {
                return this.f84289b;
            }
            Preconditions.r(i3, size());
            return this.f84290c[i3 - 2];
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return IntMath.i(this.f84290c.length, 2);
        }
    }

    static List a(Iterable iterable) {
        return (List) iterable;
    }

    public static ImmutableList b(String str) {
        return new StringAsImmutableList((String) Preconditions.t(str));
    }

    static int c(int i3) {
        CollectPreconditions.b(i3, "arraySize");
        return Ints.m(((long) i3) + 5 + ((long) (i3 / 10)));
    }

    static boolean d(List list, Object obj) {
        if (obj == Preconditions.t(list)) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        List list2 = (List) obj;
        int size = list.size();
        if (size != list2.size()) {
            return false;
        }
        if (!(list instanceof RandomAccess) || !(list2 instanceof RandomAccess)) {
            return Iterators.l(list.iterator(), list2.iterator());
        }
        for (int i3 = 0; i3 < size; i3++) {
            if (!Objects.a(list.get(i3), list2.get(i3))) {
                return false;
            }
        }
        return true;
    }

    static int e(List list, Object obj) {
        if (list instanceof RandomAccess) {
            return f(list, obj);
        }
        ListIterator listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            if (Objects.a(obj, listIterator.next())) {
                return listIterator.previousIndex();
            }
        }
        return -1;
    }

    private static int f(List list, Object obj) {
        int size = list.size();
        int i3 = 0;
        if (obj == null) {
            while (i3 < size) {
                if (list.get(i3) == null) {
                    return i3;
                }
                i3++;
            }
            return -1;
        }
        while (i3 < size) {
            if (obj.equals(list.get(i3))) {
                return i3;
            }
            i3++;
        }
        return -1;
    }

    static int g(List list, Object obj) {
        if (list instanceof RandomAccess) {
            return h(list, obj);
        }
        ListIterator listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            if (Objects.a(obj, listIterator.previous())) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    private static int h(List list, Object obj) {
        if (obj == null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                if (list.get(size) == null) {
                    return size;
                }
            }
            return -1;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            if (obj.equals(list.get(size2))) {
                return size2;
            }
        }
        return -1;
    }

    public static ArrayList i() {
        return new ArrayList();
    }

    public static ArrayList j(Iterable iterable) {
        Preconditions.t(iterable);
        return iterable instanceof Collection ? new ArrayList((Collection) iterable) : k(iterable.iterator());
    }

    public static ArrayList k(Iterator it) {
        ArrayList arrayListI = i();
        Iterators.a(arrayListI, it);
        return arrayListI;
    }

    public static ArrayList l(Object... objArr) {
        Preconditions.t(objArr);
        ArrayList arrayList = new ArrayList(c(objArr.length));
        Collections.addAll(arrayList, objArr);
        return arrayList;
    }

    public static ArrayList m(int i3) {
        CollectPreconditions.b(i3, "initialArraySize");
        return new ArrayList(i3);
    }

    public static ArrayList n(int i3) {
        return new ArrayList(c(i3));
    }

    public static List o(List list) {
        return list instanceof ImmutableList ? ((ImmutableList) list).J() : list instanceof ReverseList ? ((ReverseList) list).b() : list instanceof RandomAccess ? new RandomAccessReverseList(list) : new ReverseList(list);
    }

    public static List p(List list, Function function) {
        return list instanceof RandomAccess ? new TransformingRandomAccessList(list, function) : new TransformingSequentialList(list, function);
    }
}
