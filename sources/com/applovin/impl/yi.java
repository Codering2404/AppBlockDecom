package com.applovin.impl;

import com.applovin.exoplayer2.common.base.Preconditions;
import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class yi extends vg implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final vg f65217a;

    yi(vg vgVar) {
        this.f65217a = (vg) Preconditions.checkNotNull(vgVar);
    }

    @Override // com.applovin.impl.vg
    public vg c() {
        return this.f65217a;
    }

    @Override // com.applovin.impl.vg, java.util.Comparator
    public int compare(Object obj, Object obj2) {
        return this.f65217a.compare(obj2, obj);
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof yi) {
            return this.f65217a.equals(((yi) obj).f65217a);
        }
        return false;
    }

    public int hashCode() {
        return -this.f65217a.hashCode();
    }

    public String toString() {
        return this.f65217a + ".reverse()";
    }
}
