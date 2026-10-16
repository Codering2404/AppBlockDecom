package com.google.android.gms.internal.ads;

import android.app.Activity;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzdwu {
    private final zzgau zza;
    private final AtomicBoolean zzb = new AtomicBoolean(false);
    private final AtomicBoolean zzc = new AtomicBoolean(false);

    zzdwu(zzgau zzgauVar) {
        this.zza = zzgauVar;
    }

    public final void zza(zzbfl zzbflVar) {
        this.zzc.set(true);
        zzbflVar.zzg(this);
        this.zza.zza();
    }

    public final void zzb(String str) {
        if (zzgua.zzc(str) || !this.zzc.get() || this.zzb.getAndSet(true)) {
            return;
        }
        this.zza.zzb(str);
    }

    public final void zzc() {
        if (this.zzb.get()) {
            this.zza.zzg();
        }
    }

    public final void zzd() {
        if (this.zzb.getAndSet(false)) {
            this.zza.zze();
        }
    }

    public final void zze(Activity activity) {
        if (this.zzb.get()) {
            this.zza.zzd();
        }
    }

    public final void zzf(Activity activity) {
        if (this.zzb.get()) {
            this.zza.zzc();
        }
    }

    public final boolean zzg(Activity activity) {
        if (!this.zzb.getAndSet(false)) {
            return false;
        }
        this.zza.zzf();
        return false;
    }
}
