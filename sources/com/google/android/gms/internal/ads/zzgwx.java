package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgwx extends zzgws {
    public final zzgwx zzb(Object obj, Object... objArr) {
        List listAsList = Arrays.asList(objArr);
        if (obj == null) {
            Iterator it = listAsList.iterator();
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            boolean z2 = true;
            while (it.hasNext()) {
                if (!z2) {
                    sb.append(", ");
                }
                sb.append(it.next());
                z2 = false;
            }
            sb.append(']');
            throw new NullPointerException("null key in entry: null=".concat(sb.toString()));
        }
        Iterator it2 = listAsList.iterator();
        if (it2.hasNext()) {
            zzgwh zzgwhVarZzt = (zzgwh) zza().get(obj);
            if (zzgwhVarZzt == null) {
                zzgwhVarZzt = zzgww.zzt(listAsList instanceof Set ? Math.max(4, ((Set) listAsList).size()) : 4);
                zza().put(obj, zzgwhVarZzt);
            }
            while (it2.hasNext()) {
                Object next = it2.next();
                zzgvi.zza(obj, next);
                zzgwhVarZzt.zzd(next);
            }
        }
        return this;
    }

    public final zzgwz zzc() {
        Map map = this.zza;
        if (map == null) {
            return zzgwa.zza;
        }
        Set<Map.Entry> setEntrySet = map.entrySet();
        if (setEntrySet.isEmpty()) {
            return zzgwa.zza;
        }
        zzgwo zzgwoVar = new zzgwo(setEntrySet.size());
        int size = 0;
        for (Map.Entry entry : setEntrySet) {
            Object key = entry.getKey();
            zzgww zzgwwVarZzp = zzgww.zzp(((zzgwv) entry.getValue()).zzh());
            if (!zzgwwVarZzp.isEmpty()) {
                zzgwoVar.zza(key, zzgwwVarZzp);
                size += zzgwwVarZzp.size();
            }
        }
        return new zzgwz(zzgwoVar.zzc(), size, null);
    }
}
