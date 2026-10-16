package com.applovin.impl;

import com.applovin.exoplayer2.common.base.Preconditions;
import java.io.Serializable;
import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class x3 extends vg implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Comparator f64795a;

    x3(Comparator comparator) {
        this.f64795a = (Comparator) Preconditions.checkNotNull(comparator);
    }

    @Override // com.applovin.impl.vg, java.util.Comparator
    public int compare(Object obj, Object obj2) {
        return this.f64795a.compare(obj, obj2);
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof x3) {
            return this.f64795a.equals(((x3) obj).f64795a);
        }
        return false;
    }

    public int hashCode() {
        return this.f64795a.hashCode();
    }

    public String toString() {
        return this.f64795a.toString();
    }
}
