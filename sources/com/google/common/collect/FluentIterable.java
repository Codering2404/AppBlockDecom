package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public abstract class FluentIterable<E> implements Iterable<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Optional f83947a;

    /* JADX INFO: renamed from: com.google.common.collect.FluentIterable$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass2 extends FluentIterable<Object> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Iterable f83949b;

        @Override // java.lang.Iterable
        public Iterator iterator() {
            return Iterators.f(Iterators.N(this.f83949b.iterator(), new r()));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class FromIterableFunction<E> implements Function<Iterable<E>, FluentIterable<E>> {
        @Override // com.google.common.base.Function
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public FluentIterable apply(Iterable iterable) {
            return FluentIterable.g(iterable);
        }
    }

    protected FluentIterable() {
        this.f83947a = Optional.a();
    }

    public static FluentIterable a(Iterable iterable, Iterable iterable2) {
        return b(iterable, iterable2);
    }

    private static FluentIterable b(final Iterable... iterableArr) {
        for (Iterable iterable : iterableArr) {
            Preconditions.t(iterable);
        }
        return new FluentIterable<Object>() { // from class: com.google.common.collect.FluentIterable.3
            @Override // java.lang.Iterable
            public Iterator iterator() {
                return Iterators.f(new AbstractIndexedListIterator<Iterator<Object>>(iterableArr.length) { // from class: com.google.common.collect.FluentIterable.3.1
                    @Override // com.google.common.collect.AbstractIndexedListIterator
                    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                    public Iterator a(int i3) {
                        return iterableArr[i3].iterator();
                    }
                });
            }
        };
    }

    public static FluentIterable g(final Iterable iterable) {
        return iterable instanceof FluentIterable ? (FluentIterable) iterable : new FluentIterable<Object>(iterable) { // from class: com.google.common.collect.FluentIterable.1
            @Override // java.lang.Iterable
            public Iterator iterator() {
                return iterable.iterator();
            }
        };
    }

    private Iterable h() {
        return (Iterable) this.f83947a.e(this);
    }

    public final FluentIterable d(Predicate predicate) {
        return g(Iterables.e(h(), predicate));
    }

    public final FluentIterable e(Class cls) {
        return g(Iterables.f(h(), cls));
    }

    public final Optional f() {
        Iterator it = h().iterator();
        return it.hasNext() ? Optional.d(it.next()) : Optional.a();
    }

    public final Object[] l(Class cls) {
        return Iterables.v(h(), cls);
    }

    public final ImmutableSet n() {
        return ImmutableSet.t(h());
    }

    public String toString() {
        return Iterables.x(h());
    }

    FluentIterable(Iterable iterable) {
        this.f83947a = Optional.d(iterable);
    }
}
