package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzibi extends zzibg {
    private final zzibw zza = new zzibw(false);

    public final boolean equals(Object obj) {
        if (obj != this) {
            return (obj instanceof zzibi) && ((zzibi) obj).zza.equals(this.zza);
        }
        return true;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final void zza(String str, zzibg zzibgVar) {
        this.zza.put(str, zzibgVar);
    }

    public final Set zzb() {
        return this.zza.entrySet();
    }

    public final boolean zzc(String str) {
        return this.zza.containsKey(str);
    }

    public final zzibg zzh(String str) {
        return (zzibg) this.zza.get(str);
    }
}
