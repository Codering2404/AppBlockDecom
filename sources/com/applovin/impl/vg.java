package com.applovin.impl;

import com.applovin.exoplayer2.common.base.Function;
import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class vg implements Comparator {
    protected vg() {
    }

    public static vg a(Comparator comparator) {
        return comparator instanceof vg ? (vg) comparator : new x3(comparator);
    }

    vg b() {
        return a(uc.a());
    }

    public vg c() {
        return new yi(this);
    }

    @Override // java.util.Comparator
    public abstract int compare(Object obj, Object obj2);

    public db a(Iterable iterable) {
        return db.a((Comparator) this, iterable);
    }

    public static vg a() {
        return zf.f65435a;
    }

    public vg a(Function function) {
        return new r2(function, this);
    }
}
