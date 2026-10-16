package com.applovin.impl;

import com.applovin.exoplayer2.common.base.Preconditions;
import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zf extends vg implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final zf f65435a = new zf();

    private zf() {
    }

    @Override // com.applovin.impl.vg, java.util.Comparator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(Comparable comparable, Comparable comparable2) {
        Preconditions.checkNotNull(comparable);
        Preconditions.checkNotNull(comparable2);
        return comparable.compareTo(comparable2);
    }

    @Override // com.applovin.impl.vg
    public vg c() {
        return xi.f64984a;
    }

    public String toString() {
        return "Ordering.natural()";
    }
}
