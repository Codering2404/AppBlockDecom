package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.Internal;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class MapFieldLite<K, V> extends LinkedHashMap<K, V> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final MapFieldLite f87014b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f87015a;

    static {
        MapFieldLite mapFieldLite = new MapFieldLite();
        f87014b = mapFieldLite;
        mapFieldLite.k();
    }

    private MapFieldLite() {
        this.f87015a = true;
    }

    static int a(Map map) {
        int iB = 0;
        for (Map.Entry<K, V> entry : map.entrySet()) {
            iB += b(entry.getValue()) ^ b(entry.getKey());
        }
        return iB;
    }

    private static int b(Object obj) {
        if (obj instanceof byte[]) {
            return Internal.d((byte[]) obj);
        }
        if (obj instanceof Internal.EnumLite) {
            throw new UnsupportedOperationException();
        }
        return obj.hashCode();
    }

    private static void c(Map map) {
        for (K k3 : map.keySet()) {
            Internal.a(k3);
            Internal.a(map.get(k3));
        }
    }

    public static MapFieldLite e() {
        return f87014b;
    }

    private void g() {
        if (!j()) {
            throw new UnsupportedOperationException();
        }
    }

    private static boolean h(Object obj, Object obj2) {
        return ((obj instanceof byte[]) && (obj2 instanceof byte[])) ? Arrays.equals((byte[]) obj, (byte[]) obj2) : obj.equals(obj2);
    }

    static boolean i(Map map, Map map2) {
        if (map == map2) {
            return true;
        }
        if (map.size() != map2.size()) {
            return false;
        }
        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (!map2.containsKey(entry.getKey()) || !h(entry.getValue(), map2.get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public void clear() {
        g();
        super.clear();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public Set entrySet() {
        return isEmpty() ? Collections.EMPTY_SET : super.entrySet();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object obj) {
        return (obj instanceof Map) && i(this, (Map) obj);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        return a(this);
    }

    public boolean j() {
        return this.f87015a;
    }

    public void k() {
        this.f87015a = false;
    }

    public void m(MapFieldLite mapFieldLite) {
        g();
        if (mapFieldLite.isEmpty()) {
            return;
        }
        putAll(mapFieldLite);
    }

    public MapFieldLite o() {
        return isEmpty() ? new MapFieldLite() : new MapFieldLite(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public Object put(Object obj, Object obj2) {
        g();
        Internal.a(obj);
        Internal.a(obj2);
        return super.put(obj, obj2);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public void putAll(Map map) {
        g();
        c(map);
        super.putAll(map);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public Object remove(Object obj) {
        g();
        return super.remove(obj);
    }

    private MapFieldLite(Map map) {
        super(map);
        this.f87015a = true;
    }
}
