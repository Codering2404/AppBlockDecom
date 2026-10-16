package com.google.android.libraries.places.internal;

import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbjy {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final Joiner f76306c = Joiner.h(',');

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final zzbjy f76307d = new zzbjy(zzbjh.f76278a, false, new zzbjy(new zzbjg(), true, new zzbjy()));

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map f76308a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final byte[] f76309b;

    private zzbjy() {
        this.f76308a = new LinkedHashMap(0);
        this.f76309b = new byte[0];
    }

    public static zzbjy a() {
        return f76307d;
    }

    final byte[] b() {
        return this.f76309b;
    }

    public final zzbjw c(String str) {
        zzbjx zzbjxVar = (zzbjx) this.f76308a.get(str);
        if (zzbjxVar != null) {
            return zzbjxVar.f76304a;
        }
        return null;
    }

    private zzbjy(zzbjw zzbjwVar, boolean z2, zzbjy zzbjyVar) {
        String strZza = zzbjwVar.zza();
        Preconditions.e(!strZza.contains(","), "Comma is currently not allowed in message encoding");
        int size = zzbjyVar.f76308a.size();
        LinkedHashMap linkedHashMap = new LinkedHashMap(zzbjyVar.f76308a.containsKey(zzbjwVar.zza()) ? size : size + 1);
        for (zzbjx zzbjxVar : zzbjyVar.f76308a.values()) {
            String strZza2 = zzbjxVar.f76304a.zza();
            if (!strZza2.equals(strZza)) {
                linkedHashMap.put(strZza2, new zzbjx(zzbjxVar.f76304a, zzbjxVar.f76305b));
            }
        }
        linkedHashMap.put(strZza, new zzbjx(zzbjwVar, z2));
        Map mapUnmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        this.f76308a = mapUnmodifiableMap;
        Joiner joiner = f76306c;
        HashSet hashSet = new HashSet(mapUnmodifiableMap.size());
        for (Map.Entry entry : mapUnmodifiableMap.entrySet()) {
            if (((zzbjx) entry.getValue()).f76305b) {
                hashSet.add((String) entry.getKey());
            }
        }
        this.f76309b = joiner.e(Collections.unmodifiableSet(hashSet)).getBytes(Charset.forName("US-ASCII"));
    }
}
