package com.google.common.collect;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
class EmptyImmutableListMultimap extends ImmutableListMultimap<Object, Object> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    static final EmptyImmutableListMultimap f83908i = new EmptyImmutableListMultimap();
    private static final long serialVersionUID = 0;

    private EmptyImmutableListMultimap() {
        super(ImmutableMap.n(), 0);
    }

    private Object readResolve() {
        return f83908i;
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public ImmutableMap a1() {
        return super.a1();
    }
}
