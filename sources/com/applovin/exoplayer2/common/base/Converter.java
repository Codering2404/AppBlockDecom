package com.applovin.exoplayer2.common.base;

import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.Serializable;
import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class Converter<A, B> implements Function<A, B> {
    private final boolean handleNullAutomatically;

    @LazyInit
    @MonotonicNonNullDecl
    private transient Converter<B, A> reverse;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a implements Iterable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Iterable f57916a;

        /* JADX INFO: renamed from: com.applovin.exoplayer2.common.base.Converter$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        class C0092a implements Iterator {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final Iterator f57918a;

            C0092a() {
                this.f57918a = a.this.f57916a.iterator();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f57918a.hasNext();
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Iterator
            public Object next() {
                return Converter.this.convert(this.f57918a.next());
            }

            @Override // java.util.Iterator
            public void remove() {
                this.f57918a.remove();
            }
        }

        a(Iterable iterable) {
            this.f57916a = iterable;
        }

        @Override // java.lang.Iterable
        public Iterator iterator() {
            return new C0092a();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class b extends Converter implements Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Converter f57920a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Converter f57921b;

        b(Converter converter, Converter converter2) {
            this.f57920a = converter;
            this.f57921b = converter2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.applovin.exoplayer2.common.base.Converter
        Object correctedDoBackward(Object obj) {
            return this.f57920a.correctedDoBackward(this.f57921b.correctedDoBackward(obj));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.applovin.exoplayer2.common.base.Converter
        Object correctedDoForward(Object obj) {
            return this.f57921b.correctedDoForward(this.f57920a.correctedDoForward(obj));
        }

        @Override // com.applovin.exoplayer2.common.base.Converter
        protected Object doBackward(Object obj) {
            throw new AssertionError();
        }

        @Override // com.applovin.exoplayer2.common.base.Converter
        protected Object doForward(Object obj) {
            throw new AssertionError();
        }

        @Override // com.applovin.exoplayer2.common.base.Converter, com.applovin.exoplayer2.common.base.Function
        public boolean equals(Object obj) {
            if (obj instanceof b) {
                b bVar = (b) obj;
                if (this.f57920a.equals(bVar.f57920a) && this.f57921b.equals(bVar.f57921b)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return (this.f57920a.hashCode() * 31) + this.f57921b.hashCode();
        }

        public String toString() {
            return this.f57920a + ".andThen(" + this.f57921b + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class c extends Converter implements Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Function f57922a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Function f57923b;

        /* synthetic */ c(Function function, Function function2, a aVar) {
            this(function, function2);
        }

        @Override // com.applovin.exoplayer2.common.base.Converter
        protected Object doBackward(Object obj) {
            return this.f57923b.apply(obj);
        }

        @Override // com.applovin.exoplayer2.common.base.Converter
        protected Object doForward(Object obj) {
            return this.f57922a.apply(obj);
        }

        @Override // com.applovin.exoplayer2.common.base.Converter, com.applovin.exoplayer2.common.base.Function
        public boolean equals(Object obj) {
            if (obj instanceof c) {
                c cVar = (c) obj;
                if (this.f57922a.equals(cVar.f57922a) && this.f57923b.equals(cVar.f57923b)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return (this.f57922a.hashCode() * 31) + this.f57923b.hashCode();
        }

        public String toString() {
            return "Converter.from(" + this.f57922a + ", " + this.f57923b + ")";
        }

        private c(Function function, Function function2) {
            this.f57922a = (Function) Preconditions.checkNotNull(function);
            this.f57923b = (Function) Preconditions.checkNotNull(function2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class e extends Converter implements Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Converter f57925a;

        e(Converter converter) {
            this.f57925a = converter;
        }

        @Override // com.applovin.exoplayer2.common.base.Converter
        Object correctedDoBackward(Object obj) {
            return this.f57925a.correctedDoForward(obj);
        }

        @Override // com.applovin.exoplayer2.common.base.Converter
        Object correctedDoForward(Object obj) {
            return this.f57925a.correctedDoBackward(obj);
        }

        @Override // com.applovin.exoplayer2.common.base.Converter
        protected Object doBackward(Object obj) {
            throw new AssertionError();
        }

        @Override // com.applovin.exoplayer2.common.base.Converter
        protected Object doForward(Object obj) {
            throw new AssertionError();
        }

        @Override // com.applovin.exoplayer2.common.base.Converter, com.applovin.exoplayer2.common.base.Function
        public boolean equals(Object obj) {
            if (obj instanceof e) {
                return this.f57925a.equals(((e) obj).f57925a);
            }
            return false;
        }

        public int hashCode() {
            return ~this.f57925a.hashCode();
        }

        @Override // com.applovin.exoplayer2.common.base.Converter
        public Converter reverse() {
            return this.f57925a;
        }

        public String toString() {
            return this.f57925a + ".reverse()";
        }
    }

    protected Converter() {
        this(true);
    }

    public static <A, B> Converter<A, B> from(Function<? super A, ? extends B> function, Function<? super B, ? extends A> function2) {
        return new c(function, function2, null);
    }

    public static <T> Converter<T, T> identity() {
        return d.f57924a;
    }

    public final <C> Converter<A, C> andThen(Converter<B, C> converter) {
        return doAndThen(converter);
    }

    @Override // com.applovin.exoplayer2.common.base.Function
    @NullableDecl
    @Deprecated
    public final B apply(@NullableDecl A a3) {
        return convert(a3);
    }

    @NullableDecl
    public final B convert(@NullableDecl A a3) {
        return correctedDoForward(a3);
    }

    public Iterable<B> convertAll(Iterable<? extends A> iterable) {
        Preconditions.checkNotNull(iterable, "fromIterable");
        return new a(iterable);
    }

    @NullableDecl
    A correctedDoBackward(@NullableDecl B b3) {
        if (!this.handleNullAutomatically) {
            return doBackward(b3);
        }
        if (b3 == null) {
            return null;
        }
        return (A) Preconditions.checkNotNull(doBackward(b3));
    }

    @NullableDecl
    B correctedDoForward(@NullableDecl A a3) {
        if (!this.handleNullAutomatically) {
            return doForward(a3);
        }
        if (a3 == null) {
            return null;
        }
        return (B) Preconditions.checkNotNull(doForward(a3));
    }

    <C> Converter<A, C> doAndThen(Converter<B, C> converter) {
        return new b(this, (Converter) Preconditions.checkNotNull(converter));
    }

    protected abstract A doBackward(B b3);

    protected abstract B doForward(A a3);

    @Override // com.applovin.exoplayer2.common.base.Function
    public boolean equals(@NullableDecl Object obj) {
        return super.equals(obj);
    }

    public Converter<B, A> reverse() {
        Converter<B, A> converter = this.reverse;
        if (converter != null) {
            return converter;
        }
        e eVar = new e(this);
        this.reverse = eVar;
        return eVar;
    }

    Converter(boolean z2) {
        this.handleNullAutomatically = z2;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class d extends Converter implements Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final d f57924a = new d();

        private d() {
        }

        @Override // com.applovin.exoplayer2.common.base.Converter
        Converter doAndThen(Converter converter) {
            return (Converter) Preconditions.checkNotNull(converter, "otherConverter");
        }

        @Override // com.applovin.exoplayer2.common.base.Converter
        public d reverse() {
            return this;
        }

        public String toString() {
            return "Converter.identity()";
        }

        @Override // com.applovin.exoplayer2.common.base.Converter
        protected Object doBackward(Object obj) {
            return obj;
        }

        @Override // com.applovin.exoplayer2.common.base.Converter
        protected Object doForward(Object obj) {
            return obj;
        }
    }
}
