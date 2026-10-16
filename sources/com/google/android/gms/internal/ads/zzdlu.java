package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzdlu extends zzdip {
    private boolean zzb;

    protected zzdlu(Set set) {
        super(set);
    }

    public final void zza() {
        zzs(zzdlt.zza);
    }

    public final void zzb() {
        zzs(zzdlp.zza);
    }

    public final synchronized void zzc() {
        zzs(zzdlq.zza);
        this.zzb = true;
    }

    public final synchronized void zzd() {
        try {
            if (!this.zzb) {
                zzs(zzdls.zza);
                this.zzb = true;
            }
            zzs(zzdlr.zza);
        } catch (Throwable th) {
            throw th;
        }
    }
}
