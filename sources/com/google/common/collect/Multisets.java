package com.google.common.collect;

import com.google.android.gms.common.api.Api;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Multiset;
import com.google.common.collect.Sets;
import com.google.common.math.IntMath;
import com.google.common.primitives.Ints;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public final class Multisets {

    /* JADX INFO: renamed from: com.google.common.collect.Multisets$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 extends ViewMultiset<Object> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Multiset f84494c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ Multiset f84495d;

        @Override // com.google.common.collect.Multiset
        public int Y1(Object obj) {
            return Math.max(this.f84494c.Y1(obj), this.f84495d.Y1(obj));
        }

        @Override // com.google.common.collect.AbstractMultiset
        Set a() {
            return Sets.p(this.f84494c.i(), this.f84495d.i());
        }

        @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
        public boolean contains(Object obj) {
            return this.f84494c.contains(obj) || this.f84495d.contains(obj);
        }

        @Override // com.google.common.collect.AbstractMultiset
        Iterator e() {
            throw new AssertionError("should never be called");
        }

        @Override // com.google.common.collect.AbstractMultiset
        Iterator f() {
            final Iterator it = this.f84494c.entrySet().iterator();
            final Iterator it2 = this.f84495d.entrySet().iterator();
            return new AbstractIterator<Multiset.Entry<Object>>(this) { // from class: com.google.common.collect.Multisets.1.1

                /* JADX INFO: renamed from: f, reason: collision with root package name */
                final /* synthetic */ AnonymousClass1 f84498f;

                {
                    this.f84498f = this;
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.google.common.collect.AbstractIterator
                /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
                public Multiset.Entry a() {
                    if (it.hasNext()) {
                        Multiset.Entry entry = (Multiset.Entry) it.next();
                        Object objA = entry.a();
                        return Multisets.h(objA, Math.max(entry.getCount(), this.f84498f.f84495d.Y1(objA)));
                    }
                    while (it2.hasNext()) {
                        Multiset.Entry entry2 = (Multiset.Entry) it2.next();
                        Object objA2 = entry2.a();
                        if (!this.f84498f.f84494c.contains(objA2)) {
                            return Multisets.h(objA2, entry2.getCount());
                        }
                    }
                    return (Multiset.Entry) b();
                }
            };
        }

        @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return this.f84494c.isEmpty() && this.f84495d.isEmpty();
        }
    }

    /* JADX INFO: renamed from: com.google.common.collect.Multisets$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass2 extends ViewMultiset<Object> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Multiset f84499c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ Multiset f84500d;

        @Override // com.google.common.collect.Multiset
        public int Y1(Object obj) {
            int iY1 = this.f84499c.Y1(obj);
            if (iY1 == 0) {
                return 0;
            }
            return Math.min(iY1, this.f84500d.Y1(obj));
        }

        @Override // com.google.common.collect.AbstractMultiset
        Set a() {
            return Sets.g(this.f84499c.i(), this.f84500d.i());
        }

        @Override // com.google.common.collect.AbstractMultiset
        Iterator e() {
            throw new AssertionError("should never be called");
        }

        @Override // com.google.common.collect.AbstractMultiset
        Iterator f() {
            final Iterator it = this.f84499c.entrySet().iterator();
            return new AbstractIterator<Multiset.Entry<Object>>(this) { // from class: com.google.common.collect.Multisets.2.1

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                final /* synthetic */ AnonymousClass2 f84502d;

                {
                    this.f84502d = this;
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.google.common.collect.AbstractIterator
                /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
                public Multiset.Entry a() {
                    while (it.hasNext()) {
                        Multiset.Entry entry = (Multiset.Entry) it.next();
                        Object objA = entry.a();
                        int iMin = Math.min(entry.getCount(), this.f84502d.f84500d.Y1(objA));
                        if (iMin > 0) {
                            return Multisets.h(objA, iMin);
                        }
                    }
                    return (Multiset.Entry) b();
                }
            };
        }
    }

    /* JADX INFO: renamed from: com.google.common.collect.Multisets$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass3 extends ViewMultiset<Object> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Multiset f84503c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ Multiset f84504d;

        @Override // com.google.common.collect.Multiset
        public int Y1(Object obj) {
            return this.f84503c.Y1(obj) + this.f84504d.Y1(obj);
        }

        @Override // com.google.common.collect.AbstractMultiset
        Set a() {
            return Sets.p(this.f84503c.i(), this.f84504d.i());
        }

        @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
        public boolean contains(Object obj) {
            return this.f84503c.contains(obj) || this.f84504d.contains(obj);
        }

        @Override // com.google.common.collect.AbstractMultiset
        Iterator e() {
            throw new AssertionError("should never be called");
        }

        @Override // com.google.common.collect.AbstractMultiset
        Iterator f() {
            final Iterator it = this.f84503c.entrySet().iterator();
            final Iterator it2 = this.f84504d.entrySet().iterator();
            return new AbstractIterator<Multiset.Entry<Object>>(this) { // from class: com.google.common.collect.Multisets.3.1

                /* JADX INFO: renamed from: f, reason: collision with root package name */
                final /* synthetic */ AnonymousClass3 f84507f;

                {
                    this.f84507f = this;
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.google.common.collect.AbstractIterator
                /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
                public Multiset.Entry a() {
                    if (it.hasNext()) {
                        Multiset.Entry entry = (Multiset.Entry) it.next();
                        Object objA = entry.a();
                        return Multisets.h(objA, entry.getCount() + this.f84507f.f84504d.Y1(objA));
                    }
                    while (it2.hasNext()) {
                        Multiset.Entry entry2 = (Multiset.Entry) it2.next();
                        Object objA2 = entry2.a();
                        if (!this.f84507f.f84503c.contains(objA2)) {
                            return Multisets.h(objA2, entry2.getCount());
                        }
                    }
                    return (Multiset.Entry) b();
                }
            };
        }

        @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return this.f84503c.isEmpty() && this.f84504d.isEmpty();
        }

        @Override // com.google.common.collect.Multisets.ViewMultiset, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
        public int size() {
            return IntMath.i(this.f84503c.size(), this.f84504d.size());
        }
    }

    /* JADX INFO: renamed from: com.google.common.collect.Multisets$4, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass4 extends ViewMultiset<Object> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Multiset f84508c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ Multiset f84509d;

        @Override // com.google.common.collect.Multiset
        public int Y1(Object obj) {
            int iY1 = this.f84508c.Y1(obj);
            if (iY1 == 0) {
                return 0;
            }
            return Math.max(0, iY1 - this.f84509d.Y1(obj));
        }

        @Override // com.google.common.collect.Multisets.ViewMultiset, java.util.AbstractCollection, java.util.Collection
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.Multisets.ViewMultiset, com.google.common.collect.AbstractMultiset
        int d() {
            return Iterators.L(f());
        }

        @Override // com.google.common.collect.AbstractMultiset
        Iterator e() {
            final Iterator it = this.f84508c.entrySet().iterator();
            return new AbstractIterator<Object>(this) { // from class: com.google.common.collect.Multisets.4.1

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                final /* synthetic */ AnonymousClass4 f84511d;

                {
                    this.f84511d = this;
                }

                @Override // com.google.common.collect.AbstractIterator
                protected Object a() {
                    while (it.hasNext()) {
                        Multiset.Entry entry = (Multiset.Entry) it.next();
                        Object objA = entry.a();
                        if (entry.getCount() > this.f84511d.f84509d.Y1(objA)) {
                            return objA;
                        }
                    }
                    return b();
                }
            };
        }

        @Override // com.google.common.collect.AbstractMultiset
        Iterator f() {
            final Iterator it = this.f84508c.entrySet().iterator();
            return new AbstractIterator<Multiset.Entry<Object>>(this) { // from class: com.google.common.collect.Multisets.4.2

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                final /* synthetic */ AnonymousClass4 f84513d;

                {
                    this.f84513d = this;
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.google.common.collect.AbstractIterator
                /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
                public Multiset.Entry a() {
                    while (it.hasNext()) {
                        Multiset.Entry entry = (Multiset.Entry) it.next();
                        Object objA = entry.a();
                        int count = entry.getCount() - this.f84513d.f84509d.Y1(objA);
                        if (count > 0) {
                            return Multisets.h(objA, count);
                        }
                    }
                    return (Multiset.Entry) b();
                }
            };
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static abstract class AbstractEntry<E> implements Multiset.Entry<E> {
        AbstractEntry() {
        }

        public boolean equals(Object obj) {
            if (obj instanceof Multiset.Entry) {
                Multiset.Entry entry = (Multiset.Entry) obj;
                if (getCount() == entry.getCount() && Objects.a(a(), entry.a())) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            Object objA = a();
            return (objA == null ? 0 : objA.hashCode()) ^ getCount();
        }

        @Override // com.google.common.collect.Multiset.Entry
        public String toString() {
            String strValueOf = String.valueOf(a());
            int count = getCount();
            if (count == 1) {
                return strValueOf;
            }
            return strValueOf + " x " + count;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class DecreasingCount implements Comparator<Multiset.Entry<?>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final Comparator f84514a = new DecreasingCount();

        private DecreasingCount() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Multiset.Entry entry, Multiset.Entry entry2) {
            return entry2.getCount() - entry.getCount();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static abstract class ElementSet<E> extends Sets.ImprovedAbstractSet<E> {
        ElementSet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            f().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return f().contains(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection collection) {
            return f().containsAll(collection);
        }

        abstract Multiset f();

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return f().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return f().o1(obj, Api.BaseClientBuilder.API_PRIORITY_OTHER) > 0;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return f().entrySet().size();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static abstract class EntrySet<E> extends Sets.ImprovedAbstractSet<Multiset.Entry<E>> {
        EntrySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            f().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (obj instanceof Multiset.Entry) {
                Multiset.Entry entry = (Multiset.Entry) obj;
                if (entry.getCount() > 0 && f().Y1(entry.a()) == entry.getCount()) {
                    return true;
                }
            }
            return false;
        }

        abstract Multiset f();

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (obj instanceof Multiset.Entry) {
                Multiset.Entry entry = (Multiset.Entry) obj;
                Object objA = entry.a();
                int count = entry.getCount();
                if (count != 0) {
                    return f().L1(objA, count, 0);
                }
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class FilteredMultiset<E> extends ViewMultiset<E> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final Multiset f84515c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final Predicate f84516d;

        FilteredMultiset(Multiset multiset, Predicate predicate) {
            super(null);
            this.f84515c = (Multiset) Preconditions.t(multiset);
            this.f84516d = (Predicate) Preconditions.t(predicate);
        }

        @Override // com.google.common.collect.Multiset
        public int Y1(Object obj) {
            int iY1 = this.f84515c.Y1(obj);
            if (iY1 <= 0 || !this.f84516d.apply(obj)) {
                return 0;
            }
            return iY1;
        }

        @Override // com.google.common.collect.AbstractMultiset
        Set a() {
            return Sets.d(this.f84515c.i(), this.f84516d);
        }

        @Override // com.google.common.collect.AbstractMultiset
        Set b() {
            return Sets.d(this.f84515c.entrySet(), new Predicate<Multiset.Entry<E>>() { // from class: com.google.common.collect.Multisets.FilteredMultiset.1
                @Override // com.google.common.base.Predicate
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public boolean apply(Multiset.Entry entry) {
                    return FilteredMultiset.this.f84516d.apply(entry.a());
                }
            });
        }

        @Override // com.google.common.collect.AbstractMultiset
        Iterator e() {
            throw new AssertionError("should never be called");
        }

        @Override // com.google.common.collect.AbstractMultiset
        Iterator f() {
            throw new AssertionError("should never be called");
        }

        @Override // com.google.common.collect.Multisets.ViewMultiset, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, com.google.common.collect.Multiset
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public UnmodifiableIterator iterator() {
            return Iterators.p(this.f84515c.iterator(), this.f84516d);
        }

        @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
        public int o1(Object obj, int i3) {
            CollectPreconditions.b(i3, "occurrences");
            if (i3 == 0) {
                return Y1(obj);
            }
            if (contains(obj)) {
                return this.f84515c.o1(obj, i3);
            }
            return 0;
        }

        @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
        public int t1(Object obj, int i3) {
            Preconditions.o(this.f84516d.apply(obj), "Element %s does not match predicate %s", obj, this.f84516d);
            return this.f84515c.t1(obj, i3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class ImmutableEntry<E> extends AbstractEntry<E> implements Serializable {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Object f84518a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f84519b;

        ImmutableEntry(Object obj, int i3) {
            this.f84518a = obj;
            this.f84519b = i3;
            CollectPreconditions.b(i3, "count");
        }

        @Override // com.google.common.collect.Multiset.Entry
        public final Object a() {
            return this.f84518a;
        }

        @Override // com.google.common.collect.Multiset.Entry
        public final int getCount() {
            return this.f84519b;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class MultisetIteratorImpl<E> implements Iterator<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Multiset f84520a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Iterator f84521b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Multiset.Entry f84522c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f84523d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f84524f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f84525g;

        MultisetIteratorImpl(Multiset multiset, Iterator it) {
            this.f84520a = multiset;
            this.f84521b = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f84523d > 0 || this.f84521b.hasNext();
        }

        @Override // java.util.Iterator
        public Object next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            if (this.f84523d == 0) {
                Multiset.Entry entry = (Multiset.Entry) this.f84521b.next();
                this.f84522c = entry;
                int count = entry.getCount();
                this.f84523d = count;
                this.f84524f = count;
            }
            this.f84523d--;
            this.f84525g = true;
            Multiset.Entry entry2 = this.f84522c;
            java.util.Objects.requireNonNull(entry2);
            return entry2.a();
        }

        @Override // java.util.Iterator
        public void remove() {
            CollectPreconditions.e(this.f84525g);
            if (this.f84524f == 1) {
                this.f84521b.remove();
            } else {
                Multiset multiset = this.f84520a;
                Multiset.Entry entry = this.f84522c;
                java.util.Objects.requireNonNull(entry);
                multiset.remove(entry.a());
            }
            this.f84524f--;
            this.f84525g = false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class UnmodifiableMultiset<E> extends ForwardingMultiset<E> implements Serializable {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Multiset f84526a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        transient Set f84527b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        transient Set f84528c;

        UnmodifiableMultiset(Multiset multiset) {
            this.f84526a = multiset;
        }

        @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.Multiset
        public boolean L1(Object obj, int i3, int i4) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Queue
        public boolean add(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection
        public boolean addAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.Multiset
        public int e0(Object obj, int i3) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.Multiset
        public Set entrySet() {
            Set set = this.f84528c;
            if (set != null) {
                return set;
            }
            Set setUnmodifiableSet = Collections.unmodifiableSet(this.f84526a.entrySet());
            this.f84528c = setUnmodifiableSet;
            return setUnmodifiableSet;
        }

        @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.Multiset
        public Set i() {
            Set set = this.f84527b;
            if (set != null) {
                return set;
            }
            Set setM2 = m2();
            this.f84527b = setM2;
            return setM2;
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return Iterators.O(this.f84526a.iterator());
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.ForwardingCollection
        public Multiset k2() {
            return this.f84526a;
        }

        Set m2() {
            return Collections.unmodifiableSet(this.f84526a.i());
        }

        @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.Multiset
        public int o1(Object obj, int i3) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.Multiset
        public int t1(Object obj, int i3) {
            throw new UnsupportedOperationException();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static abstract class ViewMultiset<E> extends AbstractMultiset<E> {
        private ViewMultiset() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            i().clear();
        }

        @Override // com.google.common.collect.AbstractMultiset
        int d() {
            return i().size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, com.google.common.collect.Multiset
        public Iterator iterator() {
            return Multisets.j(this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
        public int size() {
            return Multisets.k(this);
        }

        /* synthetic */ ViewMultiset(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    private static boolean a(Multiset multiset, AbstractMapBasedMultiset abstractMapBasedMultiset) {
        if (abstractMapBasedMultiset.isEmpty()) {
            return false;
        }
        abstractMapBasedMultiset.g(multiset);
        return true;
    }

    private static boolean b(Multiset multiset, Multiset multiset2) {
        if (multiset2 instanceof AbstractMapBasedMultiset) {
            return a(multiset, (AbstractMapBasedMultiset) multiset2);
        }
        if (multiset2.isEmpty()) {
            return false;
        }
        for (Multiset.Entry entry : multiset2.entrySet()) {
            multiset.t1(entry.a(), entry.getCount());
        }
        return true;
    }

    static boolean c(Multiset multiset, Collection collection) {
        Preconditions.t(multiset);
        Preconditions.t(collection);
        if (collection instanceof Multiset) {
            return b(multiset, d(collection));
        }
        if (collection.isEmpty()) {
            return false;
        }
        return Iterators.a(multiset, collection.iterator());
    }

    static Multiset d(Iterable iterable) {
        return (Multiset) iterable;
    }

    static Iterator e(Iterator it) {
        return new TransformedIterator<Multiset.Entry<Object>, Object>(it) { // from class: com.google.common.collect.Multisets.5
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.google.common.collect.TransformedIterator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Object a(Multiset.Entry entry) {
                return entry.a();
            }
        };
    }

    static boolean f(Multiset multiset, Object obj) {
        if (obj == multiset) {
            return true;
        }
        if (obj instanceof Multiset) {
            Multiset multiset2 = (Multiset) obj;
            if (multiset.size() == multiset2.size() && multiset.entrySet().size() == multiset2.entrySet().size()) {
                for (Multiset.Entry entry : multiset2.entrySet()) {
                    if (multiset.Y1(entry.a()) != entry.getCount()) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public static Multiset g(Multiset multiset, Predicate predicate) {
        if (!(multiset instanceof FilteredMultiset)) {
            return new FilteredMultiset(multiset, predicate);
        }
        FilteredMultiset filteredMultiset = (FilteredMultiset) multiset;
        return new FilteredMultiset(filteredMultiset.f84515c, Predicates.c(filteredMultiset.f84516d, predicate));
    }

    public static Multiset.Entry h(Object obj, int i3) {
        return new ImmutableEntry(obj, i3);
    }

    static int i(Iterable iterable) {
        if (iterable instanceof Multiset) {
            return ((Multiset) iterable).i().size();
        }
        return 11;
    }

    static Iterator j(Multiset multiset) {
        return new MultisetIteratorImpl(multiset, multiset.entrySet().iterator());
    }

    static int k(Multiset multiset) {
        Iterator it = multiset.entrySet().iterator();
        long count = 0;
        while (it.hasNext()) {
            count += (long) ((Multiset.Entry) it.next()).getCount();
        }
        return Ints.m(count);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static boolean l(Multiset multiset, Collection collection) {
        if (collection instanceof Multiset) {
            collection = ((Multiset) collection).i();
        }
        return multiset.i().removeAll(collection);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static boolean m(Multiset multiset, Collection collection) {
        Preconditions.t(collection);
        if (collection instanceof Multiset) {
            collection = ((Multiset) collection).i();
        }
        return multiset.i().retainAll(collection);
    }

    static int n(Multiset multiset, Object obj, int i3) {
        CollectPreconditions.b(i3, "count");
        int iY1 = multiset.Y1(obj);
        int i4 = i3 - iY1;
        if (i4 > 0) {
            multiset.t1(obj, i4);
            return iY1;
        }
        if (i4 < 0) {
            multiset.o1(obj, -i4);
        }
        return iY1;
    }

    static boolean o(Multiset multiset, Object obj, int i3, int i4) {
        CollectPreconditions.b(i3, "oldCount");
        CollectPreconditions.b(i4, "newCount");
        if (multiset.Y1(obj) != i3) {
            return false;
        }
        multiset.e0(obj, i4);
        return true;
    }

    public static Multiset p(Multiset multiset) {
        return ((multiset instanceof UnmodifiableMultiset) || (multiset instanceof ImmutableMultiset)) ? multiset : new UnmodifiableMultiset((Multiset) Preconditions.t(multiset));
    }

    public static SortedMultiset q(SortedMultiset sortedMultiset) {
        return new UnmodifiableSortedMultiset((SortedMultiset) Preconditions.t(sortedMultiset));
    }
}
