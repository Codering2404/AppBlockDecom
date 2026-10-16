package com.google.android.libraries.places.internal;

import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbfp implements Map.Entry, Comparable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Comparable f76156a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Object f76157b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ zzbfs f76158c;

    zzbfp(zzbfs zzbfsVar, Comparable comparable, Object obj) {
        Objects.requireNonNull(zzbfsVar);
        this.f76158c = zzbfsVar;
        this.f76156a = comparable;
        this.f76157b = obj;
    }

    private static final boolean b(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public final Comparable a() {
        return this.f76156a;
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return this.f76156a.compareTo(((zzbfp) obj).f76156a);
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return b(this.f76156a, entry.getKey()) && b(this.f76157b, entry.getValue());
    }

    @Override // java.util.Map.Entry
    public final /* synthetic */ Object getKey() {
        return this.f76156a;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.f76157b;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        Comparable comparable = this.f76156a;
        int iHashCode = comparable == null ? 0 : comparable.hashCode();
        Object obj = this.f76157b;
        return iHashCode ^ (obj != null ? obj.hashCode() : 0);
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        this.f76158c.h();
        Object obj2 = this.f76157b;
        this.f76157b = obj;
        return obj2;
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.f76156a);
        String strValueOf2 = String.valueOf(this.f76157b);
        StringBuilder sb = new StringBuilder(strValueOf.length() + 1 + strValueOf2.length());
        sb.append(strValueOf);
        sb.append("=");
        sb.append(strValueOf2);
        return sb.toString();
    }
}
