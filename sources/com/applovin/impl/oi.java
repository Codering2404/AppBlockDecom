package com.applovin.impl;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class oi extends hb {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    static final oi f62319i = new oi(new Object[0], 0, null, 0, 0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final transient Object[] f62320c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final transient Object[] f62321d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final transient int f62322f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final transient int f62323g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final transient int f62324h;

    oi(Object[] objArr, int i3, Object[] objArr2, int i4, int i5) {
        this.f62320c = objArr;
        this.f62321d = objArr2;
        this.f62322f = i4;
        this.f62323g = i3;
        this.f62324h = i5;
    }

    @Override // com.applovin.impl.bb
    int a(Object[] objArr, int i3) {
        System.arraycopy(this.f62320c, 0, objArr, i3, this.f62324h);
        return i3 + this.f62324h;
    }

    @Override // com.applovin.impl.bb
    Object[] b() {
        return this.f62320c;
    }

    @Override // com.applovin.impl.bb
    int c() {
        return this.f62324h;
    }

    @Override // com.applovin.impl.bb, java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        Object[] objArr = this.f62321d;
        if (obj == null || objArr == null) {
            return false;
        }
        int iA = ja.a(obj);
        while (true) {
            int i3 = iA & this.f62322f;
            Object obj2 = objArr[i3];
            if (obj2 == null) {
                return false;
            }
            if (obj2.equals(obj)) {
                return true;
            }
            iA = i3 + 1;
        }
    }

    @Override // com.applovin.impl.bb
    int d() {
        return 0;
    }

    @Override // com.applovin.impl.bb
    boolean e() {
        return false;
    }

    @Override // com.applovin.impl.hb
    db f() {
        return db.b(this.f62320c, this.f62324h);
    }

    @Override // com.applovin.impl.hb
    boolean g() {
        return true;
    }

    @Override // com.applovin.impl.hb, java.util.Collection, java.util.Set
    public int hashCode() {
        return this.f62323g;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public pp iterator() {
        return a().iterator();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.f62324h;
    }
}
