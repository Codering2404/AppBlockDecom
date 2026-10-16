package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzata {
    public final int zza;
    public final byte[] zzb;
    public final Map zzc;
    public final List zzd;
    public final boolean zze;

    private zzata(int i3, byte[] bArr, Map map, List list, boolean z2, long j3) {
        this.zza = i3;
        this.zzb = bArr;
        this.zzc = map;
        this.zzd = list == null ? null : Collections.unmodifiableList(list);
        this.zze = z2;
    }

    private static List zza(Map map) {
        if (map == null) {
            return null;
        }
        if (map.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry entry : map.entrySet()) {
            arrayList.add(new zzasw((String) entry.getKey(), (String) entry.getValue()));
        }
        return arrayList;
    }

    @Deprecated
    public zzata(int i3, byte[] bArr, Map map, boolean z2, long j3) {
        this(i3, bArr, map, zza(map), z2, j3);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public zzata(int i3, byte[] bArr, boolean z2, long j3, List list) {
        Map treeMap;
        if (list == null) {
            treeMap = null;
        } else if (list.isEmpty()) {
            treeMap = Collections.EMPTY_MAP;
        } else {
            treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                zzasw zzaswVar = (zzasw) it.next();
                treeMap.put(zzaswVar.zza(), zzaswVar.zzb());
            }
        }
        this(i3, bArr, treeMap, list, z2, j3);
    }

    @Deprecated
    public zzata(byte[] bArr, Map map) {
        this(200, bArr, map, zza(map), false, 0L);
    }
}
