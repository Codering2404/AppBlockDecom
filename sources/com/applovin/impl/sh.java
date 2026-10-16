package com.applovin.impl;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class sh extends b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f63711g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f63712h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int[] f63713i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final int[] f63714j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final fo[] f63715k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Object[] f63716l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final HashMap f63717m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sh(Collection collection, wj wjVar) {
        super(false, wjVar);
        int iB = 0;
        int size = collection.size();
        this.f63713i = new int[size];
        this.f63714j = new int[size];
        this.f63715k = new fo[size];
        this.f63716l = new Object[size];
        this.f63717m = new HashMap();
        Iterator it = collection.iterator();
        int iA = 0;
        int i3 = 0;
        while (it.hasNext()) {
            de deVar = (de) it.next();
            this.f63715k[i3] = deVar.b();
            this.f63714j[i3] = iB;
            this.f63713i[i3] = iA;
            iB += this.f63715k[i3].b();
            iA += this.f63715k[i3].a();
            this.f63716l[i3] = deVar.a();
            this.f63717m.put(this.f63716l[i3], Integer.valueOf(i3));
            i3++;
        }
        this.f63711g = iB;
        this.f63712h = iA;
    }

    @Override // com.applovin.impl.fo
    public int a() {
        return this.f63712h;
    }

    @Override // com.applovin.impl.b
    protected int b(Object obj) {
        Integer num = (Integer) this.f63717m.get(obj);
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    @Override // com.applovin.impl.b
    protected int d(int i3) {
        return xp.a(this.f63713i, i3 + 1, false, false);
    }

    @Override // com.applovin.impl.b
    protected int e(int i3) {
        return xp.a(this.f63714j, i3 + 1, false, false);
    }

    @Override // com.applovin.impl.b
    protected Object f(int i3) {
        return this.f63716l[i3];
    }

    @Override // com.applovin.impl.b
    protected int g(int i3) {
        return this.f63713i[i3];
    }

    @Override // com.applovin.impl.b
    protected int h(int i3) {
        return this.f63714j[i3];
    }

    @Override // com.applovin.impl.b
    protected fo i(int i3) {
        return this.f63715k[i3];
    }

    List d() {
        return Arrays.asList(this.f63715k);
    }

    @Override // com.applovin.impl.fo
    public int b() {
        return this.f63711g;
    }
}
