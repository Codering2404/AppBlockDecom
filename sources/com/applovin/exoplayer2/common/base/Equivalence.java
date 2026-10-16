package com.applovin.exoplayer2.common.base;

import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class Equivalence<T> {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Wrapper<T> implements Serializable {
        private static final long serialVersionUID = 0;
        private final Equivalence<? super T> equivalence;

        @NullableDecl
        private final T reference;

        public boolean equals(@NullableDecl Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Wrapper)) {
                return false;
            }
            Wrapper wrapper = (Wrapper) obj;
            if (this.equivalence.equals(wrapper.equivalence)) {
                return this.equivalence.equivalent(this.reference, wrapper.reference);
            }
            return false;
        }

        @NullableDecl
        public T get() {
            return this.reference;
        }

        public int hashCode() {
            return this.equivalence.hash(this.reference);
        }

        public String toString() {
            return this.equivalence + ".wrap(" + this.reference + ")";
        }

        private Wrapper(Equivalence<? super T> equivalence, @NullableDecl T t2) {
            this.equivalence = (Equivalence) Preconditions.checkNotNull(equivalence);
            this.reference = t2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class b extends Equivalence implements Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final b f57926a = new b();

        b() {
        }

        @Override // com.applovin.exoplayer2.common.base.Equivalence
        protected boolean doEquivalent(Object obj, Object obj2) {
            return obj.equals(obj2);
        }

        @Override // com.applovin.exoplayer2.common.base.Equivalence
        protected int doHash(Object obj) {
            return obj.hashCode();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class c implements Predicate, Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Equivalence f57927a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Object f57928b;

        c(Equivalence equivalence, Object obj) {
            this.f57927a = (Equivalence) Preconditions.checkNotNull(equivalence);
            this.f57928b = obj;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.applovin.exoplayer2.common.base.Predicate
        public boolean apply(Object obj) {
            return this.f57927a.equivalent(obj, this.f57928b);
        }

        @Override // com.applovin.exoplayer2.common.base.Predicate
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof c) {
                c cVar = (c) obj;
                if (this.f57927a.equals(cVar.f57927a) && Objects.equal(this.f57928b, cVar.f57928b)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return Objects.hashCode(this.f57927a, this.f57928b);
        }

        public String toString() {
            return this.f57927a + ".equivalentTo(" + this.f57928b + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class d extends Equivalence implements Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final d f57929a = new d();

        d() {
        }

        @Override // com.applovin.exoplayer2.common.base.Equivalence
        protected boolean doEquivalent(Object obj, Object obj2) {
            return false;
        }

        @Override // com.applovin.exoplayer2.common.base.Equivalence
        protected int doHash(Object obj) {
            return System.identityHashCode(obj);
        }
    }

    protected Equivalence() {
    }

    public static Equivalence<Object> equals() {
        return b.f57926a;
    }

    public static Equivalence<Object> identity() {
        return d.f57929a;
    }

    protected abstract boolean doEquivalent(T t2, T t3);

    protected abstract int doHash(T t2);

    public final boolean equivalent(@NullableDecl T t2, @NullableDecl T t3) {
        if (t2 == t3) {
            return true;
        }
        if (t2 == null || t3 == null) {
            return false;
        }
        return doEquivalent(t2, t3);
    }

    public final Predicate<T> equivalentTo(@NullableDecl T t2) {
        return new c(this, t2);
    }

    public final int hash(@NullableDecl T t2) {
        if (t2 == null) {
            return 0;
        }
        return doHash(t2);
    }

    public final <S extends T> Wrapper<S> wrap(@NullableDecl S s2) {
        return new Wrapper<>(s2);
    }
}
