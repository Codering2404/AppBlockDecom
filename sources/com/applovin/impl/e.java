package com.applovin.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
abstract class e extends f implements ec {
    protected e(Map map) {
        super(map);
    }

    @Override // com.applovin.impl.h, com.applovin.impl.tf
    public Map a() {
        return super.a();
    }

    @Override // com.applovin.impl.f
    Collection c(Collection collection) {
        return Collections.unmodifiableList((List) collection);
    }

    @Override // com.applovin.impl.h
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.applovin.impl.f, com.applovin.impl.tf
    public boolean put(Object obj, Object obj2) {
        return super.put(obj, obj2);
    }

    @Override // com.applovin.impl.f
    Collection a(Object obj, Collection collection) {
        return a(obj, (List) collection, null);
    }
}
