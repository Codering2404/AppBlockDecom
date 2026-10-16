package com.applovin.exoplayer2.common.base;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class Optional<T> implements Serializable {
    private static final long serialVersionUID = 0;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a implements Iterable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Iterable f57933a;

        /* JADX INFO: renamed from: com.applovin.exoplayer2.common.base.Optional$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        class C0093a extends b {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private final Iterator f57934c;

            C0093a() {
                this.f57934c = (Iterator) Preconditions.checkNotNull(a.this.f57933a.iterator());
            }

            @Override // com.applovin.exoplayer2.common.base.b
            protected Object a() {
                while (this.f57934c.hasNext()) {
                    Optional optional = (Optional) this.f57934c.next();
                    if (optional.isPresent()) {
                        return optional.get();
                    }
                }
                return b();
            }
        }

        a(Iterable iterable) {
            this.f57933a = iterable;
        }

        @Override // java.lang.Iterable
        public Iterator iterator() {
            return new C0093a();
        }
    }

    Optional() {
    }

    public static <T> Optional<T> absent() {
        return com.applovin.exoplayer2.common.base.a.a();
    }

    public static <T> Optional<T> fromNullable(@NullableDecl T t2) {
        return t2 == null ? absent() : new d(t2);
    }

    public static <T> Optional<T> of(T t2) {
        return new d(Preconditions.checkNotNull(t2));
    }

    public static <T> Iterable<T> presentInstances(Iterable<? extends Optional<? extends T>> iterable) {
        Preconditions.checkNotNull(iterable);
        return new a(iterable);
    }

    public abstract Set<T> asSet();

    public abstract boolean equals(@NullableDecl Object obj);

    public abstract T get();

    public abstract int hashCode();

    public abstract boolean isPresent();

    public abstract Optional<T> or(Optional<? extends T> optional);

    public abstract T or(Supplier<? extends T> supplier);

    public abstract T or(T t2);

    @NullableDecl
    public abstract T orNull();

    public abstract String toString();

    public abstract <V> Optional<V> transform(Function<? super T, V> function);
}
