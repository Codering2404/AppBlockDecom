package com.applovin.impl;

import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class al implements nl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f58462a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f58463b;

    public al(List list, List list2) {
        this.f58462a = list;
        this.f58463b = list2;
    }

    @Override // com.applovin.impl.nl
    public long a(int i3) {
        b1.a(i3 >= 0);
        b1.a(i3 < this.f58463b.size());
        return ((Long) this.f58463b.get(i3)).longValue();
    }

    @Override // com.applovin.impl.nl
    public List b(long j3) {
        int iB = xp.b(this.f58463b, (Comparable) Long.valueOf(j3), true, false);
        return iB == -1 ? Collections.EMPTY_LIST : (List) this.f58462a.get(iB);
    }

    @Override // com.applovin.impl.nl
    public int a() {
        return this.f58463b.size();
    }

    @Override // com.applovin.impl.nl
    public int a(long j3) {
        int iA = xp.a(this.f58463b, (Comparable) Long.valueOf(j3), false, false);
        if (iA < this.f58463b.size()) {
            return iA;
        }
        return -1;
    }
}
