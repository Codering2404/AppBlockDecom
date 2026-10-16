package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzqr {
    private boolean zza;
    private boolean zzb;
    private boolean zzc;

    public final zzqr zza(boolean z2) {
        this.zza = z2;
        return this;
    }

    public final zzqr zzb(boolean z2) {
        this.zzb = z2;
        return this;
    }

    public final zzqr zzc(boolean z2) {
        this.zzc = z2;
        return this;
    }

    public final zzqs zzd() {
        if (this.zza || !(this.zzb || this.zzc)) {
            return new zzqs(this, null);
        }
        throw new IllegalStateException("Secondary offload attribute fields are true but primary isFormatSupported is false");
    }

    final /* synthetic */ boolean zze() {
        return this.zza;
    }

    final /* synthetic */ boolean zzf() {
        return this.zzb;
    }

    final /* synthetic */ boolean zzg() {
        return this.zzc;
    }
}
