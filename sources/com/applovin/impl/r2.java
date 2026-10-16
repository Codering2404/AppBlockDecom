package com.applovin.impl;

import com.applovin.exoplayer2.common.base.Function;
import com.applovin.exoplayer2.common.base.Objects;
import com.applovin.exoplayer2.common.base.Preconditions;
import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class r2 extends vg implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Function f62717a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final vg f62718b;

    r2(Function function, vg vgVar) {
        this.f62717a = (Function) Preconditions.checkNotNull(function);
        this.f62718b = (vg) Preconditions.checkNotNull(vgVar);
    }

    @Override // com.applovin.impl.vg, java.util.Comparator
    public int compare(Object obj, Object obj2) {
        return this.f62718b.compare(this.f62717a.apply(obj), this.f62717a.apply(obj2));
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof r2) {
            r2 r2Var = (r2) obj;
            if (this.f62717a.equals(r2Var.f62717a) && this.f62718b.equals(r2Var.f62718b)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(this.f62717a, this.f62718b);
    }

    public String toString() {
        return this.f62718b + ".onResultOf(" + this.f62717a + ")";
    }
}
