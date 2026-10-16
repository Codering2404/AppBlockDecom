package com.google.android.gms.tagmanager;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
abstract class zzbt {
    private final Set zzr;
    private final String zzs;

    public zzbt(String str, String... strArr) {
        this.zzs = str;
        this.zzr = new HashSet(strArr.length);
        for (String str2 : strArr) {
            this.zzr.add(str2);
        }
    }

    public abstract com.google.android.gms.internal.gtm.zzam zza(Map map);

    public abstract boolean zzb();

    public final String zze() {
        return this.zzs;
    }

    public final Set zzf() {
        return this.zzr;
    }

    final boolean zzg(Set set) {
        return set.containsAll(this.zzr);
    }
}
