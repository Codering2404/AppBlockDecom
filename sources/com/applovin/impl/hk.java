package com.applovin.impl;

import com.applovin.exoplayer2.common.base.Preconditions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class hk extends hb {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final transient Object f60214c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private transient int f60215d;

    hk(Object obj) {
        this.f60214c = Preconditions.checkNotNull(obj);
    }

    @Override // com.applovin.impl.bb
    int a(Object[] objArr, int i3) {
        objArr[i3] = this.f60214c;
        return i3 + 1;
    }

    @Override // com.applovin.impl.bb, java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        return this.f60214c.equals(obj);
    }

    @Override // com.applovin.impl.bb
    boolean e() {
        return false;
    }

    @Override // com.applovin.impl.hb
    db f() {
        return db.a(this.f60214c);
    }

    @Override // com.applovin.impl.hb
    boolean g() {
        return this.f60215d != 0;
    }

    @Override // com.applovin.impl.hb, java.util.Collection, java.util.Set
    public final int hashCode() {
        int i3 = this.f60215d;
        if (i3 != 0) {
            return i3;
        }
        int iHashCode = this.f60214c.hashCode();
        this.f60215d = iHashCode;
        return iHashCode;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public pp iterator() {
        return wb.a(this.f60214c);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return 1;
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return '[' + this.f60214c.toString() + ']';
    }

    hk(Object obj, int i3) {
        this.f60214c = obj;
        this.f60215d = i3;
    }
}
