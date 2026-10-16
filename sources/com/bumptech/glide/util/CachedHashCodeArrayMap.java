package com.bumptech.glide.util;

import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class CachedHashCodeArrayMap<K, V> extends ArrayMap<K, V> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f67269h;

    @Override // androidx.collection.SimpleArrayMap, java.util.Map
    public void clear() {
        this.f67269h = 0;
        super.clear();
    }

    @Override // androidx.collection.SimpleArrayMap
    public void g(SimpleArrayMap simpleArrayMap) {
        this.f67269h = 0;
        super.g(simpleArrayMap);
    }

    @Override // androidx.collection.SimpleArrayMap
    public Object h(int i3) {
        this.f67269h = 0;
        return super.h(i3);
    }

    @Override // androidx.collection.SimpleArrayMap, java.util.Map
    public int hashCode() {
        if (this.f67269h == 0) {
            this.f67269h = super.hashCode();
        }
        return this.f67269h;
    }

    @Override // androidx.collection.SimpleArrayMap
    public Object i(int i3, Object obj) {
        this.f67269h = 0;
        return super.i(i3, obj);
    }

    @Override // androidx.collection.SimpleArrayMap, java.util.Map
    public Object put(Object obj, Object obj2) {
        this.f67269h = 0;
        return super.put(obj, obj2);
    }
}
