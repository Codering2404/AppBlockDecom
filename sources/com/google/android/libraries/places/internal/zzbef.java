package com.google.android.libraries.places.internal;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbef implements Map.Entry {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map.Entry f76106a;

    public final zzbeh a() {
        return (zzbeh) this.f76106a.getValue();
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f76106a.getKey();
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        if (((zzbeh) this.f76106a.getValue()) == null) {
            return null;
        }
        throw null;
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        if (obj instanceof zzbex) {
            return ((zzbeh) this.f76106a.getValue()).a((zzbex) obj);
        }
        throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
    }
}
