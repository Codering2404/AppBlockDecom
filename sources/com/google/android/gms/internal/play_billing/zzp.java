package com.google.android.gms.internal.play_billing;

import com.google.android.material.bottomsheet.lKiE.YznnJpHcAmeoW;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzp {
    Object zza;
    zzt zzb;
    private zzv zzc = zzv.zze();
    private boolean zzd;

    zzp() {
    }

    final void zza() {
        this.zza = null;
        this.zzb = null;
        this.zzc.zzd(null);
    }

    public final boolean zzb(Object obj) {
        this.zzd = true;
        zzt zztVar = this.zzb;
        boolean z2 = zztVar != null && zztVar.zza(obj);
        if (z2) {
            this.zza = null;
            this.zzb = null;
            this.zzc = null;
        }
        return z2;
    }

    protected final void finalize() {
        zzv zzvVar;
        zzt zztVar = this.zzb;
        if (zztVar != null && !zztVar.isDone()) {
            zztVar.zzc(new zzq(YznnJpHcAmeoW.qGc.concat(String.valueOf(this.zza))));
        }
        if (this.zzd || (zzvVar = this.zzc) == null) {
            return;
        }
        zzvVar.zzd(null);
    }
}
