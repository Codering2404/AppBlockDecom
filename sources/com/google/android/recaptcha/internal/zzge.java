package com.google.android.recaptcha.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzge {
    private final Map zza = new LinkedHashMap();
    private final Set zzb = new LinkedHashSet();

    private final List zzh(List list) {
        List list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(zza((zzue) it.next()));
        }
        return arrayList;
    }

    public final Object zza(zzue zzueVar) throws zzce {
        int iZzS = zzueVar.zzS();
        int i3 = iZzS - 1;
        if (iZzS == 0) {
            throw null;
        }
        switch (i3) {
            case 0:
                return this.zza.get(Integer.valueOf(zzueVar.zzi()));
            case 1:
                return Boolean.valueOf(zzueVar.zzQ());
            case 2:
                byte[] bArrZzl = zzueVar.zzM().zzl();
                if (bArrZzl.length == 1) {
                    return Byte.valueOf(bArrZzl[0]);
                }
                throw new zzce(4, 6, null);
            case 3:
                String strZzO = zzueVar.zzO();
                if (strZzO.length() == 1) {
                    return Character.valueOf(strZzO.charAt(0));
                }
                throw new zzce(4, 6, null);
            case 4:
                int iZzj = zzueVar.zzj();
                if (iZzj < -32768 || iZzj > 32767) {
                    throw new zzce(4, 6, null);
                }
                return Short.valueOf((short) iZzj);
            case 5:
                return Integer.valueOf(zzueVar.zzk());
            case 6:
            case 8:
                throw new zzce(4, 6, null);
            case 7:
                return Long.valueOf(zzueVar.zzl());
            case 9:
                return Float.valueOf(zzueVar.zzg());
            case 10:
                return Double.valueOf(zzueVar.zzf());
            case 11:
                return zzueVar.zzP();
            case 12:
                return null;
            default:
                throw new zzce(4, 5, null);
        }
    }

    public final Object zzb(int i3) {
        return this.zza.remove(Integer.valueOf(i3));
    }

    public final void zzc() {
        this.zza.clear();
    }

    public final void zzd(int i3, Object obj) {
        zze(173, obj);
        this.zzb.add(173);
    }

    public final void zze(int i3, Object obj) {
        this.zza.put(Integer.valueOf(i3), obj);
    }

    public final Class[] zzf(List list) {
        List listZzh = zzh(list);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listZzh, 10));
        Iterator it = listZzh.iterator();
        while (it.hasNext()) {
            arrayList.add(zzgc.zza(it.next()));
        }
        return (Class[]) arrayList.toArray(new Class[0]);
    }

    public final Object[] zzg(List list) {
        return zzh(list).toArray(new Object[0]);
    }
}
