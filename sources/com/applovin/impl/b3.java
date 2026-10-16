package com.applovin.impl;

import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class b3 implements nl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f58540a;

    public b3(List list) {
        this.f58540a = list;
    }

    @Override // com.applovin.impl.nl
    public int a() {
        return 1;
    }

    @Override // com.applovin.impl.nl
    public List b(long j3) {
        return j3 >= 0 ? this.f58540a : Collections.EMPTY_LIST;
    }

    @Override // com.applovin.impl.nl
    public int a(long j3) {
        return j3 < 0 ? 0 : -1;
    }

    @Override // com.applovin.impl.nl
    public long a(int i3) {
        b1.a(i3 == 0);
        return 0L;
    }
}
