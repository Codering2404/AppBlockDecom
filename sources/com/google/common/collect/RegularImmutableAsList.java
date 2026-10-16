package com.google.common.collect;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
class RegularImmutableAsList<E> extends ImmutableAsList<E> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ImmutableCollection f84570c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ImmutableList f84571d;

    @Override // com.google.common.collect.ImmutableAsList
    ImmutableCollection P() {
        return this.f84570c;
    }

    @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection
    int b(Object[] objArr, int i3) {
        return this.f84571d.b(objArr, i3);
    }

    @Override // com.google.common.collect.ImmutableCollection
    Object[] d() {
        return this.f84571d.d();
    }

    @Override // com.google.common.collect.ImmutableCollection
    int e() {
        return this.f84571d.e();
    }

    @Override // com.google.common.collect.ImmutableCollection
    int f() {
        return this.f84571d.f();
    }

    @Override // java.util.List
    public Object get(int i3) {
        return this.f84571d.get(i3);
    }

    @Override // com.google.common.collect.ImmutableAsList, com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection
    Object writeReplace() {
        return super.writeReplace();
    }

    @Override // com.google.common.collect.ImmutableList, java.util.List
    /* JADX INFO: renamed from: x */
    public UnmodifiableListIterator listIterator(int i3) {
        return this.f84571d.listIterator(i3);
    }
}
