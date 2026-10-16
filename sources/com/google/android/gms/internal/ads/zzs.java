package com.google.android.gms.internal.ads;

import android.util.SparseBooleanArray;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzs {
    private final SparseBooleanArray zza;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzs) {
            return this.zza.equals(((zzs) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final boolean zza(int i3) {
        return this.zza.get(i3);
    }

    public final int zzb() {
        return this.zza.size();
    }

    public final int zzc(int i3) {
        SparseBooleanArray sparseBooleanArray = this.zza;
        zzgtj.zzm(i3, sparseBooleanArray.size(), "index");
        return sparseBooleanArray.keyAt(i3);
    }
}
