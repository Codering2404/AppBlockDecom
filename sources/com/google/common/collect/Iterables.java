package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public final class Iterables {

    /* JADX INFO: renamed from: com.google.common.collect.Iterables$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 extends FluentIterable<Object> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Iterable f84159b;

        @Override // java.lang.Iterable
        public Iterator iterator() {
            return Iterators.k(this.f84159b);
        }

        @Override // com.google.common.collect.FluentIterable
        public String toString() {
            return this.f84159b.toString() + " (cycled)";
        }
    }

    /* JADX INFO: renamed from: com.google.common.collect.Iterables$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass2 extends FluentIterable<List<Object>> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Iterable f84160b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f84161c;

        @Override // java.lang.Iterable
        public Iterator iterator() {
            return Iterators.D(this.f84160b.iterator(), this.f84161c);
        }
    }

    /* JADX INFO: renamed from: com.google.common.collect.Iterables$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass3 extends FluentIterable<List<Object>> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Iterable f84162b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f84163c;

        @Override // java.lang.Iterable
        public Iterator iterator() {
            return Iterators.C(this.f84162b.iterator(), this.f84163c);
        }
    }

    /* JADX INFO: renamed from: com.google.common.collect.Iterables$8, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass8 extends FluentIterable<Object> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Iterable f84175b;

        @Override // java.lang.Iterable
        public Iterator iterator() {
            Iterable iterable = this.f84175b;
            return iterable instanceof Queue ? new ConsumingQueueIterator((Queue) iterable) : Iterators.i(iterable.iterator());
        }

        @Override // com.google.common.collect.FluentIterable
        public String toString() {
            return "Iterables.consumingIterable(...)";
        }
    }

    /* JADX INFO: renamed from: com.google.common.collect.Iterables$9, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass9 extends FluentIterable<Object> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Iterable f84176b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Comparator f84177c;

        @Override // java.lang.Iterable
        public Iterator iterator() {
            return Iterators.B(Iterables.y(this.f84176b, new r()), this.f84177c);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class UnmodifiableIterable<T> extends FluentIterable<T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Iterable f84178b;

        @Override // java.lang.Iterable
        public Iterator iterator() {
            return Iterators.O(this.f84178b.iterator());
        }

        @Override // com.google.common.collect.FluentIterable
        public String toString() {
            return this.f84178b.toString();
        }
    }

    public static boolean a(Collection collection, Iterable iterable) {
        return iterable instanceof Collection ? collection.addAll((Collection) iterable) : Iterators.a(collection, ((Iterable) Preconditions.t(iterable)).iterator());
    }

    public static boolean b(Iterable iterable, Predicate predicate) {
        return Iterators.c(iterable.iterator(), predicate);
    }

    private static Collection c(Iterable iterable) {
        return iterable instanceof Collection ? (Collection) iterable : Lists.k(iterable.iterator());
    }

    public static Iterable d(Iterable iterable, Iterable iterable2) {
        return FluentIterable.a(iterable, iterable2);
    }

    public static Iterable e(final Iterable iterable, final Predicate predicate) {
        Preconditions.t(iterable);
        Preconditions.t(predicate);
        return new FluentIterable<Object>() { // from class: com.google.common.collect.Iterables.4
            @Override // java.lang.Iterable
            public Iterator iterator() {
                return Iterators.p(iterable.iterator(), predicate);
            }
        };
    }

    public static Iterable f(Iterable iterable, Class cls) {
        Preconditions.t(iterable);
        Preconditions.t(cls);
        return e(iterable, Predicates.h(cls));
    }

    public static Object g(Iterable iterable, Predicate predicate, Object obj) {
        return Iterators.r(iterable.iterator(), predicate, obj);
    }

    public static Object h(Iterable iterable, int i3) {
        Preconditions.t(iterable);
        return iterable instanceof List ? ((List) iterable).get(i3) : Iterators.u(iterable.iterator(), i3);
    }

    public static Object i(Iterable iterable, Object obj) {
        return Iterators.x(iterable.iterator(), obj);
    }

    public static Object j(Iterable iterable) {
        if (!(iterable instanceof List)) {
            return Iterators.v(iterable.iterator());
        }
        List list = (List) iterable;
        if (list.isEmpty()) {
            throw new NoSuchElementException();
        }
        return l(list);
    }

    public static Object k(Iterable iterable, Object obj) {
        if (iterable instanceof Collection) {
            if (((Collection) iterable).isEmpty()) {
                return obj;
            }
            if (iterable instanceof List) {
                return l(Lists.a(iterable));
            }
        }
        return Iterators.w(iterable.iterator(), obj);
    }

    private static Object l(List list) {
        return list.get(list.size() - 1);
    }

    public static Object m(Iterable iterable) {
        return Iterators.y(iterable.iterator());
    }

    public static Iterable n(final Iterable iterable, final int i3) {
        Preconditions.t(iterable);
        Preconditions.e(i3 >= 0, "limit is negative");
        return new FluentIterable<Object>() { // from class: com.google.common.collect.Iterables.7
            @Override // java.lang.Iterable
            public Iterator iterator() {
                return Iterators.A(iterable.iterator(), i3);
            }
        };
    }

    static Object o(Iterable iterable, Predicate predicate) {
        Preconditions.t(predicate);
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (predicate.apply(next)) {
                it.remove();
                return next;
            }
        }
        return null;
    }

    public static boolean p(Iterable iterable, Predicate predicate) {
        return ((iterable instanceof RandomAccess) && (iterable instanceof List)) ? q((List) iterable, (Predicate) Preconditions.t(predicate)) : Iterators.I(iterable.iterator(), predicate);
    }

    private static boolean q(List list, Predicate predicate) {
        int i3 = 0;
        int i4 = 0;
        while (i3 < list.size()) {
            Object obj = list.get(i3);
            if (!predicate.apply(obj)) {
                if (i3 > i4) {
                    try {
                        list.set(i4, obj);
                    } catch (IllegalArgumentException unused) {
                        t(list, predicate, i4, i3);
                        return true;
                    } catch (UnsupportedOperationException unused2) {
                        t(list, predicate, i4, i3);
                        return true;
                    }
                }
                i4++;
            }
            i3++;
        }
        list.subList(i4, list.size()).clear();
        return i3 != i4;
    }

    public static int r(Iterable iterable) {
        return iterable instanceof Collection ? ((Collection) iterable).size() : Iterators.L(iterable.iterator());
    }

    public static Iterable s(final Iterable iterable, final int i3) {
        Preconditions.t(iterable);
        Preconditions.e(i3 >= 0, "number to skip cannot be negative");
        return new FluentIterable<Object>() { // from class: com.google.common.collect.Iterables.6
            @Override // java.lang.Iterable
            public Iterator iterator() {
                Iterable iterable2 = iterable;
                if (iterable2 instanceof List) {
                    List list = (List) iterable2;
                    return list.subList(Math.min(list.size(), i3), list.size()).iterator();
                }
                final Iterator it = iterable2.iterator();
                Iterators.b(it, i3);
                return new Iterator<Object>(this) { // from class: com.google.common.collect.Iterables.6.1

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    boolean f84170a = true;

                    /* JADX INFO: renamed from: c, reason: collision with root package name */
                    final /* synthetic */ AnonymousClass6 f84172c;

                    {
                        this.f84172c = this;
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return it.hasNext();
                    }

                    @Override // java.util.Iterator
                    public Object next() {
                        Object next = it.next();
                        this.f84170a = false;
                        return next;
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        CollectPreconditions.e(!this.f84170a);
                        it.remove();
                    }
                };
            }
        };
    }

    private static void t(List list, Predicate predicate, int i3, int i4) {
        for (int size = list.size() - 1; size > i4; size--) {
            if (predicate.apply(list.get(size))) {
                list.remove(size);
            }
        }
        for (int i5 = i4 - 1; i5 >= i3; i5--) {
            list.remove(i5);
        }
    }

    static Object[] u(Iterable iterable) {
        return c(iterable).toArray();
    }

    public static Object[] v(Iterable iterable, Class cls) {
        return w(iterable, ObjectArrays.f(cls, 0));
    }

    static Object[] w(Iterable iterable, Object[] objArr) {
        return c(iterable).toArray(objArr);
    }

    public static String x(Iterable iterable) {
        return Iterators.M(iterable.iterator());
    }

    public static Iterable y(final Iterable iterable, final Function function) {
        Preconditions.t(iterable);
        Preconditions.t(function);
        return new FluentIterable<Object>() { // from class: com.google.common.collect.Iterables.5
            @Override // java.lang.Iterable
            public Iterator iterator() {
                return Iterators.N(iterable.iterator(), function);
            }
        };
    }
}
