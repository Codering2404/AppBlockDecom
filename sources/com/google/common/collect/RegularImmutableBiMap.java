package com.google.common.collect;

import com.google.common.collect.RegularImmutableMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
final class RegularImmutableBiMap<K, V> extends ImmutableBiMap<K, V> {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    static final RegularImmutableBiMap f84572k = new RegularImmutableBiMap();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final transient Object f84573f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final transient Object[] f84574g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final transient int f84575h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final transient int f84576i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final transient RegularImmutableBiMap f84577j;

    private RegularImmutableBiMap() {
        this.f84573f = null;
        this.f84574g = new Object[0];
        this.f84575h = 0;
        this.f84576i = 0;
        this.f84577j = this;
    }

    @Override // com.google.common.collect.ImmutableMap
    ImmutableSet f() {
        return new RegularImmutableMap.EntrySet(this, this.f84574g, this.f84575h, this.f84576i);
    }

    @Override // com.google.common.collect.ImmutableMap
    ImmutableSet g() {
        return new RegularImmutableMap.KeySet(this, new RegularImmutableMap.KeysOrValuesAsList(this.f84574g, this.f84575h, this.f84576i));
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public Object get(Object obj) {
        Object objX = RegularImmutableMap.x(this.f84573f, this.f84574g, this.f84576i, this.f84575h, obj);
        if (objX == null) {
            return null;
        }
        return objX;
    }

    @Override // com.google.common.collect.ImmutableMap
    boolean k() {
        return false;
    }

    @Override // java.util.Map
    public int size() {
        return this.f84576i;
    }

    @Override // com.google.common.collect.ImmutableBiMap, com.google.common.collect.BiMap
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public ImmutableBiMap u1() {
        return this.f84577j;
    }

    @Override // com.google.common.collect.ImmutableBiMap, com.google.common.collect.ImmutableMap
    Object writeReplace() {
        return super.writeReplace();
    }

    RegularImmutableBiMap(Object[] objArr, int i3) {
        this.f84574g = objArr;
        this.f84576i = i3;
        this.f84575h = 0;
        int iQ = i3 >= 2 ? ImmutableSet.q(i3) : 0;
        this.f84573f = RegularImmutableMap.w(objArr, i3, iQ, 0);
        this.f84577j = new RegularImmutableBiMap(RegularImmutableMap.w(objArr, i3, iQ, 1), objArr, i3, this);
    }

    private RegularImmutableBiMap(Object obj, Object[] objArr, int i3, RegularImmutableBiMap regularImmutableBiMap) {
        this.f84573f = obj;
        this.f84574g = objArr;
        this.f84575h = 1;
        this.f84576i = i3;
        this.f84577j = regularImmutableBiMap;
    }
}
