package com.google.common.collect;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
final class RegularImmutableSet<E> extends ImmutableSet<E> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final Object[] f84602i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    static final RegularImmutableSet f84603j;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final transient Object[] f84604c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final transient int f84605d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final transient Object[] f84606f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final transient int f84607g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final transient int f84608h;

    static {
        Object[] objArr = new Object[0];
        f84602i = objArr;
        f84603j = new RegularImmutableSet(objArr, 0, objArr, 0, 0);
    }

    RegularImmutableSet(Object[] objArr, int i3, Object[] objArr2, int i4, int i5) {
        this.f84604c = objArr;
        this.f84605d = i3;
        this.f84606f = objArr2;
        this.f84607g = i4;
        this.f84608h = i5;
    }

    @Override // com.google.common.collect.ImmutableCollection
    int b(Object[] objArr, int i3) {
        System.arraycopy(this.f84604c, 0, objArr, i3, this.f84608h);
        return i3 + this.f84608h;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        Object[] objArr = this.f84606f;
        if (obj == null || objArr.length == 0) {
            return false;
        }
        int iD = Hashing.d(obj);
        while (true) {
            int i3 = iD & this.f84607g;
            Object obj2 = objArr[i3];
            if (obj2 == null) {
                return false;
            }
            if (obj2.equals(obj)) {
                return true;
            }
            iD = i3 + 1;
        }
    }

    @Override // com.google.common.collect.ImmutableCollection
    Object[] d() {
        return this.f84604c;
    }

    @Override // com.google.common.collect.ImmutableCollection
    int e() {
        return this.f84608h;
    }

    @Override // com.google.common.collect.ImmutableCollection
    int f() {
        return 0;
    }

    @Override // com.google.common.collect.ImmutableCollection
    boolean g() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    /* JADX INFO: renamed from: h */
    public UnmodifiableIterator iterator() {
        return a().iterator();
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public int hashCode() {
        return this.f84605d;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.f84608h;
    }

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
    Object writeReplace() {
        return super.writeReplace();
    }

    @Override // com.google.common.collect.ImmutableSet
    ImmutableList x() {
        return ImmutableList.n(this.f84604c, this.f84608h);
    }

    @Override // com.google.common.collect.ImmutableSet
    boolean y() {
        return true;
    }
}
