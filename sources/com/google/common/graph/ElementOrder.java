package com.google.common.graph;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.errorprone.annotations.Immutable;
import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@ElementTypesAreNonnullByDefault
public final class ElementOrder<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Type f84951a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Comparator f84952b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum Type {
        UNORDERED,
        STABLE,
        INSERTION,
        SORTED
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ElementOrder)) {
            return false;
        }
        ElementOrder elementOrder = (ElementOrder) obj;
        return this.f84951a == elementOrder.f84951a && Objects.a(this.f84952b, elementOrder.f84952b);
    }

    public int hashCode() {
        return Objects.b(this.f84951a, this.f84952b);
    }

    public String toString() {
        MoreObjects.ToStringHelper toStringHelperD = MoreObjects.c(this).d("type", this.f84951a);
        Comparator comparator = this.f84952b;
        if (comparator != null) {
            toStringHelperD.d("comparator", comparator);
        }
        return toStringHelperD.toString();
    }
}
