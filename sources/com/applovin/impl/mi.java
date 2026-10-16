package com.applovin.impl;

import com.applovin.exoplayer2.common.base.Preconditions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
class mi extends db {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final db f61895f = new mi(new Object[0], 0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final transient Object[] f61896c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final transient int f61897d;

    mi(Object[] objArr, int i3) {
        this.f61896c = objArr;
        this.f61897d = i3;
    }

    @Override // com.applovin.impl.db, com.applovin.impl.bb
    int a(Object[] objArr, int i3) {
        System.arraycopy(this.f61896c, 0, objArr, i3, this.f61897d);
        return i3 + this.f61897d;
    }

    @Override // com.applovin.impl.bb
    Object[] b() {
        return this.f61896c;
    }

    @Override // com.applovin.impl.bb
    int c() {
        return this.f61897d;
    }

    @Override // com.applovin.impl.bb
    int d() {
        return 0;
    }

    @Override // com.applovin.impl.bb
    boolean e() {
        return false;
    }

    @Override // java.util.List
    public Object get(int i3) {
        Preconditions.checkElementIndex(i3, this.f61897d);
        return this.f61896c[i3];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f61897d;
    }
}
