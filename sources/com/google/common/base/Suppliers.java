package com.google.common.base;

import com.google.common.base.Suppliers;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public final class Suppliers {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class ExpiringMemoizingSupplier<T> implements Supplier<T>, Serializable {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private transient Object f83405a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Supplier f83406b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final long f83407c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        volatile transient Object f83408d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        volatile transient long f83409f;

        private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
            objectInputStream.defaultReadObject();
            this.f83405a = new Object();
        }

        @Override // com.google.common.base.Supplier
        public Object get() {
            long j3 = this.f83409f;
            long jNanoTime = System.nanoTime();
            if (j3 == 0 || jNanoTime - j3 >= 0) {
                synchronized (this.f83405a) {
                    try {
                        if (j3 == this.f83409f) {
                            Object obj = this.f83406b.get();
                            this.f83408d = obj;
                            long j4 = jNanoTime + this.f83407c;
                            if (j4 == 0) {
                                j4 = 1;
                            }
                            this.f83409f = j4;
                            return obj;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            return NullnessCasts.a(this.f83408d);
        }

        public String toString() {
            return "Suppliers.memoizeWithExpiration(" + this.f83406b + ", " + this.f83407c + ", NANOS)";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class MemoizingSupplier<T> implements Supplier<T>, Serializable {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private transient Object f83410a = new Object();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Supplier f83411b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        volatile transient boolean f83412c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        transient Object f83413d;

        MemoizingSupplier(Supplier supplier) {
            this.f83411b = (Supplier) Preconditions.t(supplier);
        }

        private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
            objectInputStream.defaultReadObject();
            this.f83410a = new Object();
        }

        @Override // com.google.common.base.Supplier
        public Object get() {
            if (!this.f83412c) {
                synchronized (this.f83410a) {
                    try {
                        if (!this.f83412c) {
                            Object obj = this.f83411b.get();
                            this.f83413d = obj;
                            this.f83412c = true;
                            return obj;
                        }
                    } finally {
                    }
                }
            }
            return NullnessCasts.a(this.f83413d);
        }

        public String toString() {
            Object obj;
            StringBuilder sb = new StringBuilder();
            sb.append("Suppliers.memoize(");
            if (this.f83412c) {
                obj = "<supplier that returned " + this.f83413d + ">";
            } else {
                obj = this.f83411b;
            }
            sb.append(obj);
            sb.append(")");
            return sb.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class NonSerializableMemoizingSupplier<T> implements Supplier<T> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final Supplier f83414d = new Supplier() { // from class: com.google.common.base.a
            @Override // com.google.common.base.Supplier
            public final Object get() {
                return Suppliers.NonSerializableMemoizingSupplier.a();
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Object f83415a = new Object();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private volatile Supplier f83416b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Object f83417c;

        NonSerializableMemoizingSupplier(Supplier supplier) {
            this.f83416b = (Supplier) Preconditions.t(supplier);
        }

        public static /* synthetic */ Void a() {
            throw new IllegalStateException();
        }

        @Override // com.google.common.base.Supplier
        public Object get() {
            Supplier supplier = this.f83416b;
            Supplier supplier2 = f83414d;
            if (supplier != supplier2) {
                synchronized (this.f83415a) {
                    try {
                        if (this.f83416b != supplier2) {
                            Object obj = this.f83416b.get();
                            this.f83417c = obj;
                            this.f83416b = supplier2;
                            return obj;
                        }
                    } finally {
                    }
                }
            }
            return NullnessCasts.a(this.f83417c);
        }

        public String toString() {
            Object obj = this.f83416b;
            StringBuilder sb = new StringBuilder();
            sb.append("Suppliers.memoize(");
            if (obj == f83414d) {
                obj = "<supplier that returned " + this.f83417c + ">";
            }
            sb.append(obj);
            sb.append(")");
            return sb.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class SupplierComposition<F, T> implements Supplier<T>, Serializable {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Function f83418a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Supplier f83419b;

        public boolean equals(Object obj) {
            if (obj instanceof SupplierComposition) {
                SupplierComposition supplierComposition = (SupplierComposition) obj;
                if (this.f83418a.equals(supplierComposition.f83418a) && this.f83419b.equals(supplierComposition.f83419b)) {
                    return true;
                }
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.base.Supplier
        public Object get() {
            return this.f83418a.apply(this.f83419b.get());
        }

        public int hashCode() {
            return Objects.b(this.f83418a, this.f83419b);
        }

        public String toString() {
            return "Suppliers.compose(" + this.f83418a + ", " + this.f83419b + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private interface SupplierFunction<T> extends Function<Supplier<T>, T> {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private enum SupplierFunctionImpl implements SupplierFunction<Object> {
        INSTANCE;

        @Override // com.google.common.base.Function
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Object apply(Supplier supplier) {
            return supplier.get();
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Suppliers.supplierFunction()";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class SupplierOfInstance<T> implements Supplier<T>, Serializable {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Object f83422a;

        SupplierOfInstance(Object obj) {
            this.f83422a = obj;
        }

        public boolean equals(Object obj) {
            if (obj instanceof SupplierOfInstance) {
                return Objects.a(this.f83422a, ((SupplierOfInstance) obj).f83422a);
            }
            return false;
        }

        @Override // com.google.common.base.Supplier
        public Object get() {
            return this.f83422a;
        }

        public int hashCode() {
            return Objects.b(this.f83422a);
        }

        public String toString() {
            return "Suppliers.ofInstance(" + this.f83422a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class ThreadSafeSupplier<T> implements Supplier<T>, Serializable {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Supplier f83423a;

        @Override // com.google.common.base.Supplier
        public Object get() {
            Object obj;
            synchronized (this.f83423a) {
                obj = this.f83423a.get();
            }
            return obj;
        }

        public String toString() {
            return "Suppliers.synchronizedSupplier(" + this.f83423a + ")";
        }
    }

    public static Supplier a(Supplier supplier) {
        return ((supplier instanceof NonSerializableMemoizingSupplier) || (supplier instanceof MemoizingSupplier)) ? supplier : supplier instanceof Serializable ? new MemoizingSupplier(supplier) : new NonSerializableMemoizingSupplier(supplier);
    }

    public static Supplier b(Object obj) {
        return new SupplierOfInstance(obj);
    }
}
