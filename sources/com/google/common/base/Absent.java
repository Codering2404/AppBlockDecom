package com.google.common.base;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
final class Absent<T> extends Optional<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final Absent f83213a = new Absent();
    private static final long serialVersionUID = 0;

    private Absent() {
    }

    static Optional g() {
        return f83213a;
    }

    private Object readResolve() {
        return f83213a;
    }

    @Override // com.google.common.base.Optional
    public Object b() {
        throw new IllegalStateException("Optional.get() cannot be called on an absent value");
    }

    @Override // com.google.common.base.Optional
    public boolean c() {
        return false;
    }

    @Override // com.google.common.base.Optional
    public Object e(Object obj) {
        return Preconditions.u(obj, "use Optional.orNull() instead of Optional.or(null)");
    }

    public boolean equals(Object obj) {
        return obj == this;
    }

    @Override // com.google.common.base.Optional
    public Object f() {
        return null;
    }

    public int hashCode() {
        return 2040732332;
    }

    public String toString() {
        return "Optional.absent()";
    }
}
