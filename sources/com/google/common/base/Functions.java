package com.google.common.base;

import java.io.Serializable;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public final class Functions {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class ConstantFunction<E> implements Function<Object, E>, Serializable {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Object f83300a;

        @Override // com.google.common.base.Function
        public Object apply(Object obj) {
            return this.f83300a;
        }

        @Override // com.google.common.base.Function
        public boolean equals(Object obj) {
            if (obj instanceof ConstantFunction) {
                return Objects.a(this.f83300a, ((ConstantFunction) obj).f83300a);
            }
            return false;
        }

        public int hashCode() {
            Object obj = this.f83300a;
            if (obj == null) {
                return 0;
            }
            return obj.hashCode();
        }

        public String toString() {
            return "Functions.constant(" + this.f83300a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class ForMapWithDefault<K, V> implements Function<K, V>, Serializable {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Map f83301a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Object f83302b;

        @Override // com.google.common.base.Function
        public Object apply(Object obj) {
            Object obj2 = this.f83301a.get(obj);
            return (obj2 != null || this.f83301a.containsKey(obj)) ? NullnessCasts.a(obj2) : this.f83302b;
        }

        @Override // com.google.common.base.Function
        public boolean equals(Object obj) {
            if (obj instanceof ForMapWithDefault) {
                ForMapWithDefault forMapWithDefault = (ForMapWithDefault) obj;
                if (this.f83301a.equals(forMapWithDefault.f83301a) && Objects.a(this.f83302b, forMapWithDefault.f83302b)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return Objects.b(this.f83301a, this.f83302b);
        }

        public String toString() {
            return "Functions.forMap(" + this.f83301a + ", defaultValue=" + this.f83302b + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class FunctionComposition<A, B, C> implements Function<A, C>, Serializable {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Function f83303a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Function f83304b;

        @Override // com.google.common.base.Function
        public Object apply(Object obj) {
            return this.f83303a.apply(this.f83304b.apply(obj));
        }

        @Override // com.google.common.base.Function
        public boolean equals(Object obj) {
            if (obj instanceof FunctionComposition) {
                FunctionComposition functionComposition = (FunctionComposition) obj;
                if (this.f83304b.equals(functionComposition.f83304b) && this.f83303a.equals(functionComposition.f83303a)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return this.f83304b.hashCode() ^ this.f83303a.hashCode();
        }

        public String toString() {
            return this.f83303a + "(" + this.f83304b + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class FunctionForMapNoDefault<K, V> implements Function<K, V>, Serializable {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Map f83305a;

        @Override // com.google.common.base.Function
        public Object apply(Object obj) {
            Object obj2 = this.f83305a.get(obj);
            Preconditions.m(obj2 != null || this.f83305a.containsKey(obj), "Key '%s' not present in map", obj);
            return NullnessCasts.a(obj2);
        }

        @Override // com.google.common.base.Function
        public boolean equals(Object obj) {
            if (obj instanceof FunctionForMapNoDefault) {
                return this.f83305a.equals(((FunctionForMapNoDefault) obj).f83305a);
            }
            return false;
        }

        public int hashCode() {
            return this.f83305a.hashCode();
        }

        public String toString() {
            return "Functions.forMap(" + this.f83305a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class PredicateFunction<T> implements Function<T, Boolean>, Serializable {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Predicate f83308a;

        @Override // com.google.common.base.Function
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean apply(Object obj) {
            return Boolean.valueOf(this.f83308a.apply(obj));
        }

        @Override // com.google.common.base.Function
        public boolean equals(Object obj) {
            if (obj instanceof PredicateFunction) {
                return this.f83308a.equals(((PredicateFunction) obj).f83308a);
            }
            return false;
        }

        public int hashCode() {
            return this.f83308a.hashCode();
        }

        public String toString() {
            return "Functions.forPredicate(" + this.f83308a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class SupplierFunction<F, T> implements Function<F, T>, Serializable {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Supplier f83309a;

        @Override // com.google.common.base.Function
        public Object apply(Object obj) {
            return this.f83309a.get();
        }

        @Override // com.google.common.base.Function
        public boolean equals(Object obj) {
            if (obj instanceof SupplierFunction) {
                return this.f83309a.equals(((SupplierFunction) obj).f83309a);
            }
            return false;
        }

        public int hashCode() {
            return this.f83309a.hashCode();
        }

        public String toString() {
            return "Functions.forSupplier(" + this.f83309a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private enum ToStringFunction implements Function<Object, String> {
        INSTANCE;

        @Override // com.google.common.base.Function
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public String apply(Object obj) {
            Preconditions.t(obj);
            return obj.toString();
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Functions.toStringFunction()";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private enum IdentityFunction implements Function<Object, Object> {
        INSTANCE;

        @Override // java.lang.Enum
        public String toString() {
            return "Functions.identity()";
        }

        @Override // com.google.common.base.Function
        public Object apply(Object obj) {
            return obj;
        }
    }
}
