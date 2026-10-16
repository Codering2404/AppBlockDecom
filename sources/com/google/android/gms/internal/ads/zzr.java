package com.google.android.gms.internal.ads;

import android.util.SparseBooleanArray;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzr {
    private final SparseBooleanArray zza = new SparseBooleanArray();
    private boolean zzb;

    public final zzr zza(int i3) {
        zzgtj.zzi(!this.zzb);
        this.zza.append(i3, true);
        return this;
    }

    public final zzs zzb() {
        zzgtj.zzi(!this.zzb);
        this.zzb = true;
        return new zzs(this.zza, null);
    }
}
