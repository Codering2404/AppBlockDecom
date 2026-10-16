package com.applovin.impl;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
class cb extends g implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Object f58860a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Object f58861b;

    cb(Object obj, Object obj2) {
        this.f58860a = obj;
        this.f58861b = obj2;
    }

    @Override // com.applovin.impl.g, java.util.Map.Entry
    public final Object getKey() {
        return this.f58860a;
    }

    @Override // com.applovin.impl.g, java.util.Map.Entry
    public final Object getValue() {
        return this.f58861b;
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        throw new UnsupportedOperationException();
    }
}
