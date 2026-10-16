package com.android.volley;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class NetworkResponse {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f57676a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f57677b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map f57678c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f57679d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f57680e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f57681f;

    public NetworkResponse(int i3, byte[] bArr, Map map, boolean z2, long j3) {
        this(i3, bArr, map, a(map), z2, j3);
    }

    private static List a(Map map) {
        if (map == null) {
            return null;
        }
        if (map.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry entry : map.entrySet()) {
            arrayList.add(new Header((String) entry.getKey(), (String) entry.getValue()));
        }
        return arrayList;
    }

    private static Map b(List list) {
        if (list == null) {
            return null;
        }
        if (list.isEmpty()) {
            return Collections.EMPTY_MAP;
        }
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Header header = (Header) it.next();
            treeMap.put(header.a(), header.b());
        }
        return treeMap;
    }

    public NetworkResponse(int i3, byte[] bArr, boolean z2, long j3, List list) {
        this(i3, bArr, b(list), list, z2, j3);
    }

    public NetworkResponse(byte[] bArr, Map map) {
        this(200, bArr, map, false, 0L);
    }

    private NetworkResponse(int i3, byte[] bArr, Map map, List list, boolean z2, long j3) {
        this.f57676a = i3;
        this.f57677b = bArr;
        this.f57678c = map;
        if (list == null) {
            this.f57679d = null;
        } else {
            this.f57679d = Collections.unmodifiableList(list);
        }
        this.f57680e = z2;
        this.f57681f = j3;
    }
}
