package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.primitives.Ints;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public final class Iterators {

    /* JADX INFO: renamed from: com.google.common.collect.Iterators$10, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass10 implements Enumeration<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Iterator f84180a;

        @Override // java.util.Enumeration
        public boolean hasMoreElements() {
            return this.f84180a.hasNext();
        }

        @Override // java.util.Enumeration
        public Object nextElement() {
            return this.f84180a.next();
        }
    }

    /* JADX INFO: renamed from: com.google.common.collect.Iterators$9, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass9 extends UnmodifiableIterator<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Enumeration f84195a;

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f84195a.hasMoreElements();
        }

        @Override // java.util.Iterator
        public Object next() {
            return this.f84195a.nextElement();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class ArrayItr<T> extends AbstractIndexedListIterator<T> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        static final UnmodifiableListIterator f84196d = new ArrayItr(new Object[0], 0);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Object[] f84197c;

        ArrayItr(Object[] objArr, int i3) {
            super(objArr.length, i3);
            this.f84197c = objArr;
        }

        @Override // com.google.common.collect.AbstractIndexedListIterator
        protected Object a(int i3) {
            return this.f84197c[i3];
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class ConcatenatedIterator<T> implements Iterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Iterator f84198a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Iterator f84199b = Iterators.m();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Iterator f84200c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Deque f84201d;

        ConcatenatedIterator(Iterator it) {
            this.f84200c = (Iterator) Preconditions.t(it);
        }

        private Iterator a() {
            while (true) {
                Iterator it = this.f84200c;
                if (it != null && it.hasNext()) {
                    return this.f84200c;
                }
                Deque deque = this.f84201d;
                if (deque == null || deque.isEmpty()) {
                    return null;
                }
                this.f84200c = (Iterator) this.f84201d.removeFirst();
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            while (!((Iterator) Preconditions.t(this.f84199b)).hasNext()) {
                Iterator itA = a();
                this.f84200c = itA;
                if (itA == null) {
                    return false;
                }
                Iterator it = (Iterator) itA.next();
                this.f84199b = it;
                if (it instanceof ConcatenatedIterator) {
                    ConcatenatedIterator concatenatedIterator = (ConcatenatedIterator) it;
                    this.f84199b = concatenatedIterator.f84199b;
                    if (this.f84201d == null) {
                        this.f84201d = new ArrayDeque();
                    }
                    this.f84201d.addFirst(this.f84200c);
                    if (concatenatedIterator.f84201d != null) {
                        while (!concatenatedIterator.f84201d.isEmpty()) {
                            this.f84201d.addFirst((Iterator) concatenatedIterator.f84201d.removeLast());
                        }
                    }
                    this.f84200c = concatenatedIterator.f84200c;
                }
            }
            return true;
        }

        @Override // java.util.Iterator
        public Object next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Iterator it = this.f84199b;
            this.f84198a = it;
            return it.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            Iterator it = this.f84198a;
            if (it == null) {
                throw new IllegalStateException("no calls to next() since the last call to remove()");
            }
            it.remove();
            this.f84198a = null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private enum EmptyModifiableIterator implements Iterator<Object> {
        INSTANCE;

        @Override // java.util.Iterator
        public boolean hasNext() {
            return false;
        }

        @Override // java.util.Iterator
        public Object next() {
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            CollectPreconditions.e(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class MergingIterator<T> extends UnmodifiableIterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Queue f84204a;

        public MergingIterator(Iterable iterable, final Comparator comparator) {
            this.f84204a = new PriorityQueue(2, new Comparator() { // from class: com.google.common.collect.v
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return comparator.compare(((PeekingIterator) obj).peek(), ((PeekingIterator) obj2).peek());
                }
            });
            Iterator<T> it = iterable.iterator();
            while (it.hasNext()) {
                Iterator it2 = (Iterator) it.next();
                if (it2.hasNext()) {
                    this.f84204a.add(Iterators.F(it2));
                }
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return !this.f84204a.isEmpty();
        }

        @Override // java.util.Iterator
        public Object next() {
            PeekingIterator peekingIterator = (PeekingIterator) this.f84204a.remove();
            Object next = peekingIterator.next();
            if (peekingIterator.hasNext()) {
                this.f84204a.add(peekingIterator);
            }
            return next;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class PeekingImpl<E> implements PeekingIterator<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Iterator f84205a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f84206b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Object f84207c;

        public PeekingImpl(Iterator it) {
            this.f84205a = (Iterator) Preconditions.t(it);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f84206b || this.f84205a.hasNext();
        }

        @Override // com.google.common.collect.PeekingIterator, java.util.Iterator
        public Object next() {
            if (!this.f84206b) {
                return this.f84205a.next();
            }
            Object objA = NullnessCasts.a(this.f84207c);
            this.f84206b = false;
            this.f84207c = null;
            return objA;
        }

        @Override // com.google.common.collect.PeekingIterator
        public Object peek() {
            if (!this.f84206b) {
                this.f84207c = this.f84205a.next();
                this.f84206b = true;
            }
            return NullnessCasts.a(this.f84207c);
        }

        @Override // java.util.Iterator
        public void remove() {
            Preconditions.A(!this.f84206b, "Can't remove after you've peeked at next");
            this.f84205a.remove();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class SingletonIterator<T> extends UnmodifiableIterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Object f84208a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f84209b;

        SingletonIterator(Object obj) {
            this.f84208a = obj;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return !this.f84209b;
        }

        @Override // java.util.Iterator
        public Object next() {
            if (this.f84209b) {
                throw new NoSuchElementException();
            }
            this.f84209b = true;
            return this.f84208a;
        }
    }

    public static Iterator A(final Iterator it, final int i3) {
        Preconditions.t(it);
        Preconditions.e(i3 >= 0, "limit is negative");
        return new Iterator<Object>() { // from class: com.google.common.collect.Iterators.7

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private int f84191a;

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f84191a < i3 && it.hasNext();
            }

            @Override // java.util.Iterator
            public Object next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                this.f84191a++;
                return it.next();
            }

            @Override // java.util.Iterator
            public void remove() {
                it.remove();
            }
        };
    }

    public static UnmodifiableIterator B(Iterable iterable, Comparator comparator) {
        Preconditions.u(iterable, "iterators");
        Preconditions.u(comparator, "comparator");
        return new MergingIterator(iterable, comparator);
    }

    public static UnmodifiableIterator C(Iterator it, int i3) {
        return E(it, i3, true);
    }

    public static UnmodifiableIterator D(Iterator it, int i3) {
        return E(it, i3, false);
    }

    private static UnmodifiableIterator E(final Iterator it, final int i3, final boolean z2) {
        Preconditions.t(it);
        Preconditions.d(i3 > 0);
        return new UnmodifiableIterator<List<Object>>() { // from class: com.google.common.collect.Iterators.4
            @Override // java.util.Iterator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public List next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Object[] objArr = new Object[i3];
                int i4 = 0;
                while (i4 < i3 && it.hasNext()) {
                    objArr[i4] = it.next();
                    i4++;
                }
                for (int i5 = i4; i5 < i3; i5++) {
                    objArr[i5] = null;
                }
                List listUnmodifiableList = Collections.unmodifiableList(Arrays.asList(objArr));
                return (z2 || i4 == i3) ? listUnmodifiableList : listUnmodifiableList.subList(0, i4);
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return it.hasNext();
            }
        };
    }

    public static PeekingIterator F(Iterator it) {
        return it instanceof PeekingImpl ? (PeekingImpl) it : new PeekingImpl(it);
    }

    static Object G(Iterator it) {
        if (!it.hasNext()) {
            return null;
        }
        Object next = it.next();
        it.remove();
        return next;
    }

    public static boolean H(Iterator it, Collection collection) {
        Preconditions.t(collection);
        boolean z2 = false;
        while (it.hasNext()) {
            if (collection.contains(it.next())) {
                it.remove();
                z2 = true;
            }
        }
        return z2;
    }

    public static boolean I(Iterator it, Predicate predicate) {
        Preconditions.t(predicate);
        boolean z2 = false;
        while (it.hasNext()) {
            if (predicate.apply(it.next())) {
                it.remove();
                z2 = true;
            }
        }
        return z2;
    }

    public static boolean J(Iterator it, Collection collection) {
        Preconditions.t(collection);
        boolean z2 = false;
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
                z2 = true;
            }
        }
        return z2;
    }

    public static UnmodifiableIterator K(Object obj) {
        return new SingletonIterator(obj);
    }

    public static int L(Iterator it) {
        long j3 = 0;
        while (it.hasNext()) {
            it.next();
            j3++;
        }
        return Ints.m(j3);
    }

    public static String M(Iterator it) {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        boolean z2 = true;
        while (it.hasNext()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append(it.next());
            z2 = false;
        }
        sb.append(']');
        return sb.toString();
    }

    public static Iterator N(Iterator it, final Function function) {
        Preconditions.t(function);
        return new TransformedIterator<Object, Object>(it) { // from class: com.google.common.collect.Iterators.6
            @Override // com.google.common.collect.TransformedIterator
            Object a(Object obj) {
                return function.apply(obj);
            }
        };
    }

    public static UnmodifiableIterator O(final Iterator it) {
        Preconditions.t(it);
        return it instanceof UnmodifiableIterator ? (UnmodifiableIterator) it : new UnmodifiableIterator<Object>() { // from class: com.google.common.collect.Iterators.1
            @Override // java.util.Iterator
            public boolean hasNext() {
                return it.hasNext();
            }

            @Override // java.util.Iterator
            public Object next() {
                return it.next();
            }
        };
    }

    public static boolean a(Collection collection, Iterator it) {
        Preconditions.t(collection);
        Preconditions.t(it);
        boolean zAdd = false;
        while (it.hasNext()) {
            zAdd |= collection.add(it.next());
        }
        return zAdd;
    }

    public static int b(Iterator it, int i3) {
        Preconditions.t(it);
        int i4 = 0;
        Preconditions.e(i3 >= 0, "numberToAdvance must be nonnegative");
        while (i4 < i3 && it.hasNext()) {
            it.next();
            i4++;
        }
        return i4;
    }

    public static boolean c(Iterator it, Predicate predicate) {
        return z(it, predicate) != -1;
    }

    static void d(int i3) {
        if (i3 >= 0) {
            return;
        }
        throw new IndexOutOfBoundsException("position (" + i3 + ") must not be negative");
    }

    static void e(Iterator it) {
        Preconditions.t(it);
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
    }

    public static Iterator f(Iterator it) {
        return new ConcatenatedIterator(it);
    }

    public static Iterator g(Iterator it, Iterator it2) {
        Preconditions.t(it);
        Preconditions.t(it2);
        return f(h(it, it2));
    }

    private static Iterator h(final Iterator... itArr) {
        return new UnmodifiableIterator<Iterator<?>>() { // from class: com.google.common.collect.Iterators.3

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f84183a = 0;

            @Override // java.util.Iterator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Iterator next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Iterator it = itArr[this.f84183a];
                Objects.requireNonNull(it);
                Iterator it2 = it;
                Iterator[] itArr2 = itArr;
                int i3 = this.f84183a;
                itArr2[i3] = null;
                this.f84183a = i3 + 1;
                return it2;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f84183a < itArr.length;
            }
        };
    }

    public static Iterator i(final Iterator it) {
        Preconditions.t(it);
        return new UnmodifiableIterator<Object>() { // from class: com.google.common.collect.Iterators.8
            @Override // java.util.Iterator
            public boolean hasNext() {
                return it.hasNext();
            }

            @Override // java.util.Iterator
            public Object next() {
                Object next = it.next();
                it.remove();
                return next;
            }

            public String toString() {
                return "Iterators.consumingIterator(...)";
            }
        };
    }

    public static boolean j(Iterator it, Object obj) {
        if (obj == null) {
            while (it.hasNext()) {
                if (it.next() == null) {
                    return true;
                }
            }
            return false;
        }
        while (it.hasNext()) {
            if (obj.equals(it.next())) {
                return true;
            }
        }
        return false;
    }

    public static Iterator k(final Iterable iterable) {
        Preconditions.t(iterable);
        return new Iterator<Object>() { // from class: com.google.common.collect.Iterators.2

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            Iterator f84181a = Iterators.o();

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f84181a.hasNext() || iterable.iterator().hasNext();
            }

            @Override // java.util.Iterator
            public Object next() {
                if (!this.f84181a.hasNext()) {
                    Iterator it = iterable.iterator();
                    this.f84181a = it;
                    if (!it.hasNext()) {
                        throw new NoSuchElementException();
                    }
                }
                return this.f84181a.next();
            }

            @Override // java.util.Iterator
            public void remove() {
                this.f84181a.remove();
            }
        };
    }

    public static boolean l(Iterator it, Iterator it2) {
        while (it.hasNext()) {
            if (!it2.hasNext() || !com.google.common.base.Objects.a(it.next(), it2.next())) {
                return false;
            }
        }
        return !it2.hasNext();
    }

    static UnmodifiableIterator m() {
        return n();
    }

    static UnmodifiableListIterator n() {
        return ArrayItr.f84196d;
    }

    static Iterator o() {
        return EmptyModifiableIterator.INSTANCE;
    }

    public static UnmodifiableIterator p(final Iterator it, final Predicate predicate) {
        Preconditions.t(it);
        Preconditions.t(predicate);
        return new AbstractIterator<Object>() { // from class: com.google.common.collect.Iterators.5
            @Override // com.google.common.collect.AbstractIterator
            protected Object a() {
                while (it.hasNext()) {
                    Object next = it.next();
                    if (predicate.apply(next)) {
                        return next;
                    }
                }
                return b();
            }
        };
    }

    public static Object q(Iterator it, Predicate predicate) {
        Preconditions.t(it);
        Preconditions.t(predicate);
        while (it.hasNext()) {
            Object next = it.next();
            if (predicate.apply(next)) {
                return next;
            }
        }
        throw new NoSuchElementException();
    }

    public static Object r(Iterator it, Predicate predicate, Object obj) {
        Preconditions.t(it);
        Preconditions.t(predicate);
        while (it.hasNext()) {
            Object next = it.next();
            if (predicate.apply(next)) {
                return next;
            }
        }
        return obj;
    }

    public static UnmodifiableIterator s(Object... objArr) {
        return t(objArr, 0);
    }

    static UnmodifiableListIterator t(Object[] objArr, int i3) {
        if (objArr.length != 0) {
            return new ArrayItr(objArr, i3);
        }
        Preconditions.w(i3, objArr.length);
        return n();
    }

    public static Object u(Iterator it, int i3) {
        d(i3);
        int iB = b(it, i3);
        if (it.hasNext()) {
            return it.next();
        }
        throw new IndexOutOfBoundsException("position (" + i3 + ") must be less than the number of elements that remained (" + iB + ")");
    }

    public static Object v(Iterator it) {
        Object next;
        do {
            next = it.next();
        } while (it.hasNext());
        return next;
    }

    public static Object w(Iterator it, Object obj) {
        return it.hasNext() ? v(it) : obj;
    }

    public static Object x(Iterator it, Object obj) {
        return it.hasNext() ? it.next() : obj;
    }

    public static Object y(Iterator it) {
        Object next = it.next();
        if (!it.hasNext()) {
            return next;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("expected one element but was: <");
        sb.append(next);
        for (int i3 = 0; i3 < 4 && it.hasNext(); i3++) {
            sb.append(", ");
            sb.append(it.next());
        }
        if (it.hasNext()) {
            sb.append(", ...");
        }
        sb.append('>');
        throw new IllegalArgumentException(sb.toString());
    }

    public static int z(Iterator it, Predicate predicate) {
        Preconditions.u(predicate, "predicate");
        int i3 = 0;
        while (it.hasNext()) {
            if (predicate.apply(it.next())) {
                return i3;
            }
            i3++;
        }
        return -1;
    }
}
