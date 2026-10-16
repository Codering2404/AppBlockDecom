package com.google.common.base;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public abstract class Equivalence<T> {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class Equals extends Equivalence<Object> implements Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final Equals f83286a = new Equals();
        private static final long serialVersionUID = 1;

        Equals() {
        }

        private Object readResolve() {
            return f83286a;
        }

        @Override // com.google.common.base.Equivalence
        protected boolean a(Object obj, Object obj2) {
            return obj.equals(obj2);
        }

        @Override // com.google.common.base.Equivalence
        protected int b(Object obj) {
            return obj.hashCode();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class EquivalentToPredicate<T> implements Predicate<T>, Serializable {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Equivalence f83287a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Object f83288b;

        @Override // com.google.common.base.Predicate
        public boolean apply(Object obj) {
            return this.f83287a.d(obj, this.f83288b);
        }

        @Override // com.google.common.base.Predicate
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof EquivalentToPredicate) {
                EquivalentToPredicate equivalentToPredicate = (EquivalentToPredicate) obj;
                if (this.f83287a.equals(equivalentToPredicate.f83287a) && Objects.a(this.f83288b, equivalentToPredicate.f83288b)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return Objects.b(this.f83287a, this.f83288b);
        }

        public String toString() {
            return this.f83287a + ".equivalentTo(" + this.f83288b + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class Identity extends Equivalence<Object> implements Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final Identity f83289a = new Identity();
        private static final long serialVersionUID = 1;

        Identity() {
        }

        private Object readResolve() {
            return f83289a;
        }

        @Override // com.google.common.base.Equivalence
        protected boolean a(Object obj, Object obj2) {
            return false;
        }

        @Override // com.google.common.base.Equivalence
        protected int b(Object obj) {
            return System.identityHashCode(obj);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Wrapper<T> implements Serializable {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Equivalence f83290a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Object f83291b;

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Wrapper)) {
                return false;
            }
            Wrapper wrapper = (Wrapper) obj;
            if (this.f83290a.equals(wrapper.f83290a)) {
                return this.f83290a.d(this.f83291b, wrapper.f83291b);
            }
            return false;
        }

        public int hashCode() {
            return this.f83290a.e(this.f83291b);
        }

        public String toString() {
            return this.f83290a + ".wrap(" + this.f83291b + ")";
        }
    }

    protected Equivalence() {
    }

    public static Equivalence c() {
        return Equals.f83286a;
    }

    public static Equivalence f() {
        return Identity.f83289a;
    }

    protected abstract boolean a(Object obj, Object obj2);

    protected abstract int b(Object obj);

    public final boolean d(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj == null || obj2 == null) {
            return false;
        }
        return a(obj, obj2);
    }

    public final int e(Object obj) {
        if (obj == null) {
            return 0;
        }
        return b(obj);
    }
}
