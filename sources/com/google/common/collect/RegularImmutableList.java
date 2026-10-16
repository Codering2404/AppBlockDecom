package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
class RegularImmutableList<E> extends ImmutableList<E> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final ImmutableList f84578f = new RegularImmutableList(new Object[0], 0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final transient Object[] f84579c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final transient int f84580d;

    RegularImmutableList(Object[] objArr, int i3) {
        this.f84579c = objArr;
        this.f84580d = i3;
    }

    @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection
    int b(Object[] objArr, int i3) {
        System.arraycopy(this.f84579c, 0, objArr, i3, this.f84580d);
        return i3 + this.f84580d;
    }

    @Override // com.google.common.collect.ImmutableCollection
    Object[] d() {
        return this.f84579c;
    }

    @Override // com.google.common.collect.ImmutableCollection
    int e() {
        return this.f84580d;
    }

    @Override // com.google.common.collect.ImmutableCollection
    int f() {
        return 0;
    }

    @Override // com.google.common.collect.ImmutableCollection
    boolean g() {
        return false;
    }

    @Override // java.util.List
    public Object get(int i3) {
        Preconditions.r(i3, this.f84580d);
        Object obj = this.f84579c[i3];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f84580d;
    }

    @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection
    Object writeReplace() {
        return super.writeReplace();
    }
}
