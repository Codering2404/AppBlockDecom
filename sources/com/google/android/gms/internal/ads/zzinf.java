package com.google.android.gms.internal.ads;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzinf {
    private final List zza;
    private final List zzb;

    /* synthetic */ zzinf(int i3, int i4, zzine zzineVar) {
        this.zza = zzimr.zza(i3);
        this.zzb = zzimr.zza(i4);
    }

    public final zzinf zza(zzind zzindVar) {
        this.zza.add(zzindVar);
        return this;
    }

    public final zzinf zzb(zzind zzindVar) {
        this.zzb.add(zzindVar);
        return this;
    }

    public final zzing zzc() {
        return new zzing(this.zza, this.zzb, null);
    }
}
