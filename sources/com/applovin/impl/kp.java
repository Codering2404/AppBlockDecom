package com.applovin.impl;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class kp implements nl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final gp f61048a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long[] f61049b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map f61050c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map f61051d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Map f61052f;

    public kp(gp gpVar, Map map, Map map2, Map map3) {
        this.f61048a = gpVar;
        this.f61051d = map2;
        this.f61052f = map3;
        this.f61050c = map != null ? Collections.unmodifiableMap(map) : Collections.EMPTY_MAP;
        this.f61049b = gpVar.b();
    }

    @Override // com.applovin.impl.nl
    public long a(int i3) {
        return this.f61049b[i3];
    }

    @Override // com.applovin.impl.nl
    public List b(long j3) {
        return this.f61048a.a(j3, this.f61050c, this.f61051d, this.f61052f);
    }

    @Override // com.applovin.impl.nl
    public int a() {
        return this.f61049b.length;
    }

    @Override // com.applovin.impl.nl
    public int a(long j3) {
        int iA = xp.a(this.f61049b, j3, false, false);
        if (iA < this.f61049b.length) {
            return iA;
        }
        return -1;
    }
}
