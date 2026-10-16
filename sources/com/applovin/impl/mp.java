package com.applovin.impl;

import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class mp implements nl {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final mp f61921b = new mp();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f61922a;

    private mp() {
        this.f61922a = Collections.EMPTY_LIST;
    }

    @Override // com.applovin.impl.nl
    public int a() {
        return 1;
    }

    @Override // com.applovin.impl.nl
    public List b(long j3) {
        return j3 >= 0 ? this.f61922a : Collections.EMPTY_LIST;
    }

    @Override // com.applovin.impl.nl
    public int a(long j3) {
        return j3 < 0 ? 0 : -1;
    }

    public mp(a5 a5Var) {
        this.f61922a = Collections.singletonList(a5Var);
    }

    @Override // com.applovin.impl.nl
    public long a(int i3) {
        b1.a(i3 == 0);
        return 0L;
    }
}
