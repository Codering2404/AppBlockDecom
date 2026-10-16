package com.google.common.net;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public final class HostSpecifier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f85338a;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof HostSpecifier) {
            return this.f85338a.equals(((HostSpecifier) obj).f85338a);
        }
        return false;
    }

    public int hashCode() {
        return this.f85338a.hashCode();
    }

    public String toString() {
        return this.f85338a;
    }
}
