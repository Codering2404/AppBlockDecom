package com.google.common.base;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
final class Present<T> extends Optional<T> {
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f83351a;

    Present(Object obj) {
        this.f83351a = obj;
    }

    @Override // com.google.common.base.Optional
    public Object b() {
        return this.f83351a;
    }

    @Override // com.google.common.base.Optional
    public boolean c() {
        return true;
    }

    @Override // com.google.common.base.Optional
    public Object e(Object obj) {
        Preconditions.u(obj, "use Optional.orNull() instead of Optional.or(null)");
        return this.f83351a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Present) {
            return this.f83351a.equals(((Present) obj).f83351a);
        }
        return false;
    }

    @Override // com.google.common.base.Optional
    public Object f() {
        return this.f83351a;
    }

    public int hashCode() {
        return this.f83351a.hashCode() + 1502476572;
    }

    public String toString() {
        return "Optional.of(" + this.f83351a + ")";
    }
}
