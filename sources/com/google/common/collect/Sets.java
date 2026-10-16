package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Collections2;
import com.google.common.math.IntMath;
import java.io.Serializable;
import java.util.AbstractSet;
import java.util.BitSet;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedSet;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public final class Sets {

    /* JADX INFO: renamed from: com.google.common.collect.Sets$4, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass4 extends SetView<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Set f84635a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Set f84636b;

        @Override // com.google.common.collect.Sets.SetView, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* JADX INFO: renamed from: a */
        public UnmodifiableIterator iterator() {
            final Iterator it = this.f84635a.iterator();
            final Iterator it2 = this.f84636b.iterator();
            return new AbstractIterator<Object>(this) { // from class: com.google.common.collect.Sets.4.1

                /* JADX INFO: renamed from: f, reason: collision with root package name */
                final /* synthetic */ AnonymousClass4 f84639f;

                {
                    this.f84639f = this;
                }

                @Override // com.google.common.collect.AbstractIterator
                public Object a() {
                    while (it.hasNext()) {
                        Object next = it.next();
                        if (!this.f84639f.f84636b.contains(next)) {
                            return next;
                        }
                    }
                    while (it2.hasNext()) {
                        Object next2 = it2.next();
                        if (!this.f84639f.f84635a.contains(next2)) {
                            return next2;
                        }
                    }
                    return b();
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return this.f84636b.contains(obj) ^ this.f84635a.contains(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return this.f84635a.equals(this.f84636b);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            Iterator it = this.f84635a.iterator();
            int i3 = 0;
            while (it.hasNext()) {
                if (!this.f84636b.contains(it.next())) {
                    i3++;
                }
            }
            Iterator it2 = this.f84636b.iterator();
            while (it2.hasNext()) {
                if (!this.f84635a.contains(it2.next())) {
                    i3++;
                }
            }
            return i3;
        }
    }

    /* JADX INFO: renamed from: com.google.common.collect.Sets$5, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass5 extends AbstractSet<Set<Object>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f84640a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ImmutableMap f84641b;

        /* JADX INFO: renamed from: com.google.common.collect.Sets$5$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        class AnonymousClass1 extends AbstractIterator<Set<Object>> {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final BitSet f84642c;

            AnonymousClass1() {
                this.f84642c = new BitSet(AnonymousClass5.this.f84641b.size());
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.common.collect.AbstractIterator
            /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
            public Set a() {
                if (this.f84642c.isEmpty()) {
                    this.f84642c.set(0, AnonymousClass5.this.f84640a);
                } else {
                    int iNextSetBit = this.f84642c.nextSetBit(0);
                    int iNextClearBit = this.f84642c.nextClearBit(iNextSetBit);
                    if (iNextClearBit == AnonymousClass5.this.f84641b.size()) {
                        return (Set) b();
                    }
                    int i3 = (iNextClearBit - iNextSetBit) - 1;
                    this.f84642c.set(0, i3);
                    this.f84642c.clear(i3, iNextClearBit);
                    this.f84642c.set(iNextClearBit);
                }
                final BitSet bitSet = (BitSet) this.f84642c.clone();
                return new AbstractSet<Object>(this) { // from class: com.google.common.collect.Sets.5.1.1

                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                    final /* synthetic */ AnonymousClass1 f84645b;

                    {
                        this.f84645b = this;
                    }

                    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                    public boolean contains(Object obj) {
                        Integer num = (Integer) AnonymousClass5.this.f84641b.get(obj);
                        return num != null && bitSet.get(num.intValue());
                    }

                    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
                    public Iterator iterator() {
                        return new AbstractIterator<Object>() { // from class: com.google.common.collect.Sets.5.1.1.1

                            /* JADX INFO: renamed from: c, reason: collision with root package name */
                            int f84646c = -1;

                            @Override // com.google.common.collect.AbstractIterator
                            protected Object a() {
                                int iNextSetBit2 = bitSet.nextSetBit(this.f84646c + 1);
                                this.f84646c = iNextSetBit2;
                                return iNextSetBit2 == -1 ? b() : AnonymousClass5.this.f84641b.keySet().a().get(this.f84646c);
                            }
                        };
                    }

                    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                    public int size() {
                        return AnonymousClass5.this.f84640a;
                    }
                };
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (obj instanceof Set) {
                Set set = (Set) obj;
                if (set.size() == this.f84640a && this.f84641b.keySet().containsAll(set)) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return new AnonymousClass1();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return IntMath.a(this.f84641b.size(), this.f84640a);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            return "Sets.combinations(" + this.f84641b.keySet() + ", " + this.f84640a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class CartesianSet<E> extends ForwardingCollection<List<E>> implements Set<List<E>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final transient ImmutableList f84648a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final transient CartesianList f84649b;

        /* JADX INFO: renamed from: com.google.common.collect.Sets$CartesianSet$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        class AnonymousClass1 extends ImmutableList<List<Object>> {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ ImmutableList f84650c;

            @Override // java.util.List
            /* JADX INFO: renamed from: P, reason: merged with bridge method [inline-methods] */
            public List get(int i3) {
                return ((ImmutableSet) this.f84650c.get(i3)).a();
            }

            @Override // com.google.common.collect.ImmutableCollection
            boolean g() {
                return true;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                return this.f84650c.size();
            }

            @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection
            Object writeReplace() {
                return super.writeReplace();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        /* JADX INFO: renamed from: I1, reason: merged with bridge method [inline-methods] */
        public Collection k2() {
            return this.f84649b;
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof List)) {
                return false;
            }
            List list = (List) obj;
            if (list.size() != this.f84648a.size()) {
                return false;
            }
            Iterator<E> it = list.iterator();
            int i3 = 0;
            while (it.hasNext()) {
                if (!((ImmutableSet) this.f84648a.get(i3)).contains(it.next())) {
                    return false;
                }
                i3++;
            }
            return true;
        }

        @Override // java.util.Collection, java.util.Set
        public boolean equals(Object obj) {
            if (obj instanceof CartesianSet) {
                return this.f84648a.equals(((CartesianSet) obj).f84648a);
            }
            if (obj instanceof Set) {
                Set set = (Set) obj;
                if (size() == set.size() && containsAll(set)) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            int i3 = 1;
            int size = size() - 1;
            for (int i4 = 0; i4 < this.f84648a.size(); i4++) {
                size = ~(~(size * 31));
            }
            UnmodifiableIterator it = this.f84648a.iterator();
            while (it.hasNext()) {
                Set set = (Set) it.next();
                i3 = ~(~((i3 * 31) + ((size() / set.size()) * set.hashCode())));
            }
            return ~(~(i3 + size));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class DescendingSet<E> extends ForwardingNavigableSet<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final NavigableSet f84651a;

        private static Ordering K2(Comparator comparator) {
            return Ordering.b(comparator).k();
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
        public Object ceiling(Object obj) {
            return this.f84651a.floor(obj);
        }

        @Override // com.google.common.collect.ForwardingSortedSet, java.util.SortedSet
        public Comparator comparator() {
            Comparator<? super E> comparator = this.f84651a.comparator();
            return comparator == null ? Ordering.f().k() : K2(comparator);
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
        public Iterator descendingIterator() {
            return this.f84651a.iterator();
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
        public NavigableSet descendingSet() {
            return this.f84651a;
        }

        @Override // com.google.common.collect.ForwardingSortedSet, java.util.SortedSet
        public Object first() {
            return this.f84651a.last();
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
        public Object floor(Object obj) {
            return this.f84651a.ceiling(obj);
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
        public NavigableSet headSet(Object obj, boolean z2) {
            return this.f84651a.tailSet(obj, z2).descendingSet();
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
        public Object higher(Object obj) {
            return this.f84651a.lower(obj);
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return this.f84651a.descendingIterator();
        }

        @Override // com.google.common.collect.ForwardingSortedSet, java.util.SortedSet
        public Object last() {
            return this.f84651a.first();
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
        public Object lower(Object obj) {
            return this.f84651a.higher(obj);
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
        public Object pollFirst() {
            return this.f84651a.pollLast();
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
        public Object pollLast() {
            return this.f84651a.pollFirst();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.ForwardingNavigableSet, com.google.common.collect.ForwardingSortedSet
        /* JADX INFO: renamed from: r2, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public NavigableSet o2() {
            return this.f84651a;
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
        public NavigableSet subSet(Object obj, boolean z2, Object obj2, boolean z3) {
            return this.f84651a.subSet(obj2, z3, obj, z2).descendingSet();
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
        public NavigableSet tailSet(Object obj, boolean z2) {
            return this.f84651a.headSet(obj, z2).descendingSet();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return b2();
        }

        @Override // com.google.common.collect.ForwardingObject
        public String toString() {
            return g2();
        }

        @Override // com.google.common.collect.ForwardingSortedSet, java.util.SortedSet
        public SortedSet headSet(Object obj) {
            return z2(obj);
        }

        @Override // com.google.common.collect.ForwardingSortedSet, java.util.SortedSet
        public SortedSet subSet(Object obj, Object obj2) {
            return C2(obj, obj2);
        }

        @Override // com.google.common.collect.ForwardingSortedSet, java.util.SortedSet
        public SortedSet tailSet(Object obj) {
            return J2(obj);
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public Object[] toArray(Object[] objArr) {
            return c2(objArr);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class FilteredNavigableSet<E> extends FilteredSortedSet<E> implements NavigableSet<E> {
        FilteredNavigableSet(NavigableSet navigableSet, Predicate predicate) {
            super(navigableSet, predicate);
        }

        NavigableSet b() {
            return (NavigableSet) this.f83799a;
        }

        @Override // java.util.NavigableSet
        public Object ceiling(Object obj) {
            return Iterables.g(b().tailSet(obj, true), this.f83800b, null);
        }

        @Override // java.util.NavigableSet
        public Iterator descendingIterator() {
            return Iterators.p(b().descendingIterator(), this.f83800b);
        }

        @Override // java.util.NavigableSet
        public NavigableSet descendingSet() {
            return Sets.c(b().descendingSet(), this.f83800b);
        }

        @Override // java.util.NavigableSet
        public Object floor(Object obj) {
            return Iterators.r(b().headSet(obj, true).descendingIterator(), this.f83800b, null);
        }

        @Override // java.util.NavigableSet
        public NavigableSet headSet(Object obj, boolean z2) {
            return Sets.c(b().headSet(obj, z2), this.f83800b);
        }

        @Override // java.util.NavigableSet
        public Object higher(Object obj) {
            return Iterables.g(b().tailSet(obj, false), this.f83800b, null);
        }

        @Override // com.google.common.collect.Sets.FilteredSortedSet, java.util.SortedSet
        public Object last() {
            return Iterators.q(b().descendingIterator(), this.f83800b);
        }

        @Override // java.util.NavigableSet
        public Object lower(Object obj) {
            return Iterators.r(b().headSet(obj, false).descendingIterator(), this.f83800b, null);
        }

        @Override // java.util.NavigableSet
        public Object pollFirst() {
            return Iterables.o(b(), this.f83800b);
        }

        @Override // java.util.NavigableSet
        public Object pollLast() {
            return Iterables.o(b().descendingSet(), this.f83800b);
        }

        @Override // java.util.NavigableSet
        public NavigableSet subSet(Object obj, boolean z2, Object obj2, boolean z3) {
            return Sets.c(b().subSet(obj, z2, obj2, z3), this.f83800b);
        }

        @Override // java.util.NavigableSet
        public NavigableSet tailSet(Object obj, boolean z2) {
            return Sets.c(b().tailSet(obj, z2), this.f83800b);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class FilteredSet<E> extends Collections2.FilteredCollection<E> implements Set<E> {
        FilteredSet(Set set, Predicate predicate) {
            super(set, predicate);
        }

        @Override // java.util.Collection, java.util.Set
        public boolean equals(Object obj) {
            return Sets.b(this, obj);
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            return Sets.f(this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class FilteredSortedSet<E> extends FilteredSet<E> implements SortedSet<E> {
        FilteredSortedSet(SortedSet sortedSet, Predicate predicate) {
            super(sortedSet, predicate);
        }

        @Override // java.util.SortedSet
        public Comparator comparator() {
            return ((SortedSet) this.f83799a).comparator();
        }

        @Override // java.util.SortedSet
        public Object first() {
            return Iterators.q(this.f83799a.iterator(), this.f83800b);
        }

        @Override // java.util.SortedSet
        public SortedSet headSet(Object obj) {
            return new FilteredSortedSet(((SortedSet) this.f83799a).headSet(obj), this.f83800b);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Object last() {
            SortedSet sortedSetHeadSet = (SortedSet) this.f83799a;
            while (true) {
                Object objLast = sortedSetHeadSet.last();
                if (this.f83800b.apply(objLast)) {
                    return objLast;
                }
                sortedSetHeadSet = sortedSetHeadSet.headSet(objLast);
            }
        }

        @Override // java.util.SortedSet
        public SortedSet subSet(Object obj, Object obj2) {
            return new FilteredSortedSet(((SortedSet) this.f83799a).subSet(obj, obj2), this.f83800b);
        }

        @Override // java.util.SortedSet
        public SortedSet tailSet(Object obj) {
            return new FilteredSortedSet(((SortedSet) this.f83799a).tailSet(obj), this.f83800b);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static abstract class ImprovedAbstractSet<E> extends AbstractSet<E> {
        ImprovedAbstractSet() {
        }

        @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection collection) {
            return Sets.n(this, collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection collection) {
            return super.retainAll((Collection) Preconditions.t(collection));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class PowerSet<E> extends AbstractSet<Set<E>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final ImmutableMap f84652a;

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof Set)) {
                return false;
            }
            return this.f84652a.keySet().containsAll((Set) obj);
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public boolean equals(Object obj) {
            return obj instanceof PowerSet ? this.f84652a.keySet().equals(((PowerSet) obj).f84652a.keySet()) : super.equals(obj);
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public int hashCode() {
            return this.f84652a.keySet().hashCode() << (this.f84652a.size() - 1);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return new AbstractIndexedListIterator<Set<E>>(size()) { // from class: com.google.common.collect.Sets.PowerSet.1
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.google.common.collect.AbstractIndexedListIterator
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public Set a(int i3) {
                    return new SubSet(PowerSet.this.f84652a, i3);
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return 1 << this.f84652a.size();
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            return "powerSet(" + this.f84652a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class SetView<E> extends AbstractSet<E> {
        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* JADX INFO: renamed from: a */
        public abstract UnmodifiableIterator iterator();

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean add(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean addAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean removeAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean retainAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        private SetView() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class SubSet<E> extends AbstractSet<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ImmutableMap f84654a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f84655b;

        SubSet(ImmutableMap immutableMap, int i3) {
            this.f84654a = immutableMap;
            this.f84655b = i3;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            Integer num = (Integer) this.f84654a.get(obj);
            if (num != null) {
                return ((1 << num.intValue()) & this.f84655b) != 0;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return new UnmodifiableIterator<E>() { // from class: com.google.common.collect.Sets.SubSet.1

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final ImmutableList f84656a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                int f84657b;

                {
                    this.f84656a = SubSet.this.f84654a.keySet().a();
                    this.f84657b = SubSet.this.f84655b;
                }

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.f84657b != 0;
                }

                @Override // java.util.Iterator
                public Object next() {
                    int iNumberOfTrailingZeros = Integer.numberOfTrailingZeros(this.f84657b);
                    if (iNumberOfTrailingZeros == 32) {
                        throw new NoSuchElementException();
                    }
                    this.f84657b &= ~(1 << iNumberOfTrailingZeros);
                    return this.f84656a.get(iNumberOfTrailingZeros);
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Integer.bitCount(this.f84655b);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class UnmodifiableNavigableSet<E> extends ForwardingSortedSet<E> implements NavigableSet<E>, Serializable {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final NavigableSet f84659a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final SortedSet f84660b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private transient UnmodifiableNavigableSet f84661c;

        UnmodifiableNavigableSet(NavigableSet navigableSet) {
            this.f84659a = (NavigableSet) Preconditions.t(navigableSet);
            this.f84660b = Collections.unmodifiableSortedSet(navigableSet);
        }

        @Override // java.util.NavigableSet
        public Object ceiling(Object obj) {
            return this.f84659a.ceiling(obj);
        }

        @Override // java.util.NavigableSet
        public Iterator descendingIterator() {
            return Iterators.O(this.f84659a.descendingIterator());
        }

        @Override // java.util.NavigableSet
        public NavigableSet descendingSet() {
            UnmodifiableNavigableSet unmodifiableNavigableSet = this.f84661c;
            if (unmodifiableNavigableSet != null) {
                return unmodifiableNavigableSet;
            }
            UnmodifiableNavigableSet unmodifiableNavigableSet2 = new UnmodifiableNavigableSet(this.f84659a.descendingSet());
            this.f84661c = unmodifiableNavigableSet2;
            unmodifiableNavigableSet2.f84661c = this;
            return unmodifiableNavigableSet2;
        }

        @Override // java.util.NavigableSet
        public Object floor(Object obj) {
            return this.f84659a.floor(obj);
        }

        @Override // java.util.NavigableSet
        public NavigableSet headSet(Object obj, boolean z2) {
            return Sets.q(this.f84659a.headSet(obj, z2));
        }

        @Override // java.util.NavigableSet
        public Object higher(Object obj) {
            return this.f84659a.higher(obj);
        }

        @Override // java.util.NavigableSet
        public Object lower(Object obj) {
            return this.f84659a.lower(obj);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.ForwardingSortedSet, com.google.common.collect.ForwardingSet
        public SortedSet k2() {
            return this.f84660b;
        }

        @Override // java.util.NavigableSet
        public Object pollFirst() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.NavigableSet
        public Object pollLast() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.NavigableSet
        public NavigableSet subSet(Object obj, boolean z2, Object obj2, boolean z3) {
            return Sets.q(this.f84659a.subSet(obj, z2, obj2, z3));
        }

        @Override // java.util.NavigableSet
        public NavigableSet tailSet(Object obj, boolean z2) {
            return Sets.q(this.f84659a.tailSet(obj, z2));
        }
    }

    public static SetView a(final Set set, final Set set2) {
        Preconditions.u(set, "set1");
        Preconditions.u(set2, "set2");
        return new SetView<Object>() { // from class: com.google.common.collect.Sets.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // com.google.common.collect.Sets.SetView, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            /* JADX INFO: renamed from: a */
            public UnmodifiableIterator iterator() {
                return new AbstractIterator<Object>() { // from class: com.google.common.collect.Sets.3.1

                    /* JADX INFO: renamed from: c, reason: collision with root package name */
                    final Iterator f84633c;

                    {
                        this.f84633c = set.iterator();
                    }

                    @Override // com.google.common.collect.AbstractIterator
                    protected Object a() {
                        while (this.f84633c.hasNext()) {
                            Object next = this.f84633c.next();
                            if (!set2.contains(next)) {
                                return next;
                            }
                        }
                        return b();
                    }
                };
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                return set.contains(obj) && !set2.contains(obj);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean isEmpty() {
                return set2.containsAll(set);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                Iterator it = set.iterator();
                int i3 = 0;
                while (it.hasNext()) {
                    if (!set2.contains(it.next())) {
                        i3++;
                    }
                }
                return i3;
            }
        };
    }

    static boolean b(Set set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                if (set.size() == set2.size()) {
                    if (set.containsAll(set2)) {
                        return true;
                    }
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static NavigableSet c(NavigableSet navigableSet, Predicate predicate) {
        if (!(navigableSet instanceof FilteredSet)) {
            return new FilteredNavigableSet((NavigableSet) Preconditions.t(navigableSet), (Predicate) Preconditions.t(predicate));
        }
        FilteredSet filteredSet = (FilteredSet) navigableSet;
        return new FilteredNavigableSet((NavigableSet) filteredSet.f83799a, Predicates.c(filteredSet.f83800b, predicate));
    }

    public static Set d(Set set, Predicate predicate) {
        if (set instanceof SortedSet) {
            return e((SortedSet) set, predicate);
        }
        if (!(set instanceof FilteredSet)) {
            return new FilteredSet((Set) Preconditions.t(set), (Predicate) Preconditions.t(predicate));
        }
        FilteredSet filteredSet = (FilteredSet) set;
        return new FilteredSet((Set) filteredSet.f83799a, Predicates.c(filteredSet.f83800b, predicate));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static SortedSet e(SortedSet sortedSet, Predicate predicate) {
        if (!(sortedSet instanceof FilteredSet)) {
            return new FilteredSortedSet((SortedSet) Preconditions.t(sortedSet), (Predicate) Preconditions.t(predicate));
        }
        FilteredSet filteredSet = (FilteredSet) sortedSet;
        return new FilteredSortedSet((SortedSet) filteredSet.f83799a, Predicates.c(filteredSet.f83800b, predicate));
    }

    static int f(Set set) {
        Iterator it = set.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            Object next = it.next();
            i3 = ~(~(i3 + (next != null ? next.hashCode() : 0)));
        }
        return i3;
    }

    public static SetView g(final Set set, final Set set2) {
        Preconditions.u(set, "set1");
        Preconditions.u(set2, "set2");
        return new SetView<Object>() { // from class: com.google.common.collect.Sets.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // com.google.common.collect.Sets.SetView, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            /* JADX INFO: renamed from: a */
            public UnmodifiableIterator iterator() {
                return new AbstractIterator<Object>() { // from class: com.google.common.collect.Sets.2.1

                    /* JADX INFO: renamed from: c, reason: collision with root package name */
                    final Iterator f84629c;

                    {
                        this.f84629c = set.iterator();
                    }

                    @Override // com.google.common.collect.AbstractIterator
                    protected Object a() {
                        while (this.f84629c.hasNext()) {
                            Object next = this.f84629c.next();
                            if (set2.contains(next)) {
                                return next;
                            }
                        }
                        return b();
                    }
                };
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                return set.contains(obj) && set2.contains(obj);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean containsAll(Collection collection) {
                return set.containsAll(collection) && set2.containsAll(collection);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean isEmpty() {
                return Collections.disjoint(set2, set);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                Iterator it = set.iterator();
                int i3 = 0;
                while (it.hasNext()) {
                    if (set2.contains(it.next())) {
                        i3++;
                    }
                }
                return i3;
            }
        };
    }

    public static Set h() {
        return Collections.newSetFromMap(new ConcurrentHashMap());
    }

    public static HashSet i() {
        return new HashSet();
    }

    public static HashSet j(int i3) {
        return new HashSet(Maps.m(i3));
    }

    public static Set k() {
        return Collections.newSetFromMap(Maps.B());
    }

    public static LinkedHashSet l() {
        return new LinkedHashSet();
    }

    public static LinkedHashSet m(Iterable iterable) {
        if (iterable instanceof Collection) {
            return new LinkedHashSet((Collection) iterable);
        }
        LinkedHashSet linkedHashSetL = l();
        Iterables.a(linkedHashSetL, iterable);
        return linkedHashSetL;
    }

    static boolean n(Set set, Collection collection) {
        Preconditions.t(collection);
        if (collection instanceof Multiset) {
            collection = ((Multiset) collection).i();
        }
        return (!(collection instanceof Set) || collection.size() <= set.size()) ? o(set, collection.iterator()) : Iterators.H(set.iterator(), collection);
    }

    static boolean o(Set set, Iterator it) {
        boolean zRemove = false;
        while (it.hasNext()) {
            zRemove |= set.remove(it.next());
        }
        return zRemove;
    }

    public static SetView p(final Set set, final Set set2) {
        Preconditions.u(set, "set1");
        Preconditions.u(set2, "set2");
        return new SetView<Object>() { // from class: com.google.common.collect.Sets.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // com.google.common.collect.Sets.SetView, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public UnmodifiableIterator iterator() {
                return new AbstractIterator<Object>() { // from class: com.google.common.collect.Sets.1.1

                    /* JADX INFO: renamed from: c, reason: collision with root package name */
                    final Iterator f84624c;

                    /* JADX INFO: renamed from: d, reason: collision with root package name */
                    final Iterator f84625d;

                    {
                        this.f84624c = set.iterator();
                        this.f84625d = set2.iterator();
                    }

                    @Override // com.google.common.collect.AbstractIterator
                    protected Object a() {
                        if (this.f84624c.hasNext()) {
                            return this.f84624c.next();
                        }
                        while (this.f84625d.hasNext()) {
                            Object next = this.f84625d.next();
                            if (!set.contains(next)) {
                                return next;
                            }
                        }
                        return b();
                    }
                };
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                return set.contains(obj) || set2.contains(obj);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean isEmpty() {
                return set.isEmpty() && set2.isEmpty();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                int size = set.size();
                Iterator it = set2.iterator();
                while (it.hasNext()) {
                    if (!set.contains(it.next())) {
                        size++;
                    }
                }
                return size;
            }
        };
    }

    public static NavigableSet q(NavigableSet navigableSet) {
        return ((navigableSet instanceof ImmutableCollection) || (navigableSet instanceof UnmodifiableNavigableSet)) ? navigableSet : new UnmodifiableNavigableSet(navigableSet);
    }
}
