package com.google.android.libraries.places.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzvj extends zzvk {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map f78688b;

    /* synthetic */ zzvj(zzut zzutVar, zzut zzutVar2, byte[] bArr) {
        super(null);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        e(linkedHashMap, zzutVar);
        e(linkedHashMap, zzutVar2);
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            if (((zztv) entry.getKey()).f()) {
                entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
            }
        }
        this.f78688b = Collections.unmodifiableMap(linkedHashMap);
    }

    private static void e(Map map, zzut zzutVar) {
        for (int i3 = 0; i3 < zzutVar.a(); i3++) {
            zztv zztvVarB = zzutVar.b(i3);
            Object obj = map.get(zztvVarB);
            if (zztvVarB.f()) {
                List arrayList = (List) obj;
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    map.put(zztvVarB, arrayList);
                }
                arrayList.add(zztvVarB.e(zzutVar.c(i3)));
            } else {
                map.put(zztvVarB, zztvVarB.e(zzutVar.c(i3)));
            }
        }
    }

    @Override // com.google.android.libraries.places.internal.zzvk
    public final void a(zzva zzvaVar, Object obj) {
        for (Map.Entry entry : this.f78688b.entrySet()) {
            zztv zztvVar = (zztv) entry.getKey();
            Object value = entry.getValue();
            if (zztvVar.f()) {
                zzvaVar.b(zztvVar, ((List) value).iterator(), obj);
            } else {
                zzvaVar.a(zztvVar, value, obj);
            }
        }
    }

    @Override // com.google.android.libraries.places.internal.zzvk
    public final int b() {
        return this.f78688b.size();
    }

    @Override // com.google.android.libraries.places.internal.zzvk
    public final Set c() {
        return this.f78688b.keySet();
    }
}
