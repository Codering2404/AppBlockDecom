package com.google.common.base;

import java.io.Serializable;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public abstract class Converter<A, B> implements Function<A, B> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f83271a;

    /* JADX INFO: renamed from: com.google.common.base.Converter$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 implements Iterable<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Iterable f83272a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Converter f83273b;

        @Override // java.lang.Iterable
        public Iterator<Object> iterator() {
            return new Iterator<Object>() { // from class: com.google.common.base.Converter.1.1

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                private final Iterator f83274a;

                {
                    this.f83274a = AnonymousClass1.this.f83272a.iterator();
                }

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.f83274a.hasNext();
                }

                @Override // java.util.Iterator
                public Object next() {
                    return AnonymousClass1.this.f83273b.a(this.f83274a.next());
                }

                @Override // java.util.Iterator
                public void remove() {
                    this.f83274a.remove();
                }
            };
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class ConverterComposition<A, B, C> extends Converter<A, C> implements Serializable {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Converter f83276b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final Converter f83277c;

        @Override // com.google.common.base.Converter
        Object b(Object obj) {
            return this.f83276b.b(this.f83277c.b(obj));
        }

        @Override // com.google.common.base.Converter
        Object c(Object obj) {
            return this.f83277c.c(this.f83276b.c(obj));
        }

        @Override // com.google.common.base.Converter
        protected Object d(Object obj) {
            throw new AssertionError();
        }

        @Override // com.google.common.base.Converter
        protected Object e(Object obj) {
            throw new AssertionError();
        }

        @Override // com.google.common.base.Converter, com.google.common.base.Function
        public boolean equals(Object obj) {
            if (obj instanceof ConverterComposition) {
                ConverterComposition converterComposition = (ConverterComposition) obj;
                if (this.f83276b.equals(converterComposition.f83276b) && this.f83277c.equals(converterComposition.f83277c)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return (this.f83276b.hashCode() * 31) + this.f83277c.hashCode();
        }

        public String toString() {
            return this.f83276b + ".andThen(" + this.f83277c + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class FunctionBasedConverter<A, B> extends Converter<A, B> implements Serializable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Function f83278b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Function f83279c;

        @Override // com.google.common.base.Converter
        protected Object d(Object obj) {
            return this.f83279c.apply(obj);
        }

        @Override // com.google.common.base.Converter
        protected Object e(Object obj) {
            return this.f83278b.apply(obj);
        }

        @Override // com.google.common.base.Converter, com.google.common.base.Function
        public boolean equals(Object obj) {
            if (obj instanceof FunctionBasedConverter) {
                FunctionBasedConverter functionBasedConverter = (FunctionBasedConverter) obj;
                if (this.f83278b.equals(functionBasedConverter.f83278b) && this.f83279c.equals(functionBasedConverter.f83279c)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return (this.f83278b.hashCode() * 31) + this.f83279c.hashCode();
        }

        public String toString() {
            return "Converter.from(" + this.f83278b + ", " + this.f83279c + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class ReverseConverter<A, B> extends Converter<B, A> implements Serializable {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Converter f83281b;

        @Override // com.google.common.base.Converter
        Object b(Object obj) {
            return this.f83281b.c(obj);
        }

        @Override // com.google.common.base.Converter
        Object c(Object obj) {
            return this.f83281b.b(obj);
        }

        @Override // com.google.common.base.Converter
        protected Object d(Object obj) {
            throw new AssertionError();
        }

        @Override // com.google.common.base.Converter
        protected Object e(Object obj) {
            throw new AssertionError();
        }

        @Override // com.google.common.base.Converter, com.google.common.base.Function
        public boolean equals(Object obj) {
            if (obj instanceof ReverseConverter) {
                return this.f83281b.equals(((ReverseConverter) obj).f83281b);
            }
            return false;
        }

        public int hashCode() {
            return ~this.f83281b.hashCode();
        }

        public String toString() {
            return this.f83281b + ".reverse()";
        }
    }

    protected Converter() {
        this(true);
    }

    private Object f(Object obj) {
        return d(NullnessCasts.a(obj));
    }

    private Object g(Object obj) {
        return e(NullnessCasts.a(obj));
    }

    public final Object a(Object obj) {
        return c(obj);
    }

    @Override // com.google.common.base.Function
    public final Object apply(Object obj) {
        return a(obj);
    }

    Object b(Object obj) {
        if (!this.f83271a) {
            return f(obj);
        }
        if (obj == null) {
            return null;
        }
        return Preconditions.t(d(obj));
    }

    Object c(Object obj) {
        if (!this.f83271a) {
            return g(obj);
        }
        if (obj == null) {
            return null;
        }
        return Preconditions.t(e(obj));
    }

    protected abstract Object d(Object obj);

    protected abstract Object e(Object obj);

    @Override // com.google.common.base.Function
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    Converter(boolean z2) {
        this.f83271a = z2;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class IdentityConverter<T> extends Converter<T, T> implements Serializable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final Converter f83280b = new IdentityConverter();
        private static final long serialVersionUID = 0;

        private IdentityConverter() {
        }

        private Object readResolve() {
            return f83280b;
        }

        public String toString() {
            return "Converter.identity()";
        }

        @Override // com.google.common.base.Converter
        protected Object d(Object obj) {
            return obj;
        }

        @Override // com.google.common.base.Converter
        protected Object e(Object obj) {
            return obj;
        }
    }
}
