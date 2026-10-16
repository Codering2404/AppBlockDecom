package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzqz {
    private boolean zza;
    private boolean zzb;
    private boolean zzc;
    private int zzd = 0;

    public final zzqz zza(boolean z2) {
        this.zza = z2;
        return this;
    }

    public final zzqz zzb(boolean z2) {
        this.zzb = z2;
        return this;
    }

    public final zzqz zzc(boolean z2) {
        this.zzc = z2;
        return this;
    }

    public final zzqz zzd(int i3) {
        this.zzd = i3;
        return this;
    }

    public final zzra zze() {
        if (this.zza || !(this.zzb || this.zzc)) {
            return new zzra(this, null);
        }
        throw new IllegalStateException("Secondary offload attribute fields are true but primary isFormatSupportedForOffload is false");
    }

    final /* synthetic */ boolean zzf() {
        return this.zza;
    }

    final /* synthetic */ boolean zzg() {
        return this.zzb;
    }

    final /* synthetic */ boolean zzh() {
        return this.zzc;
    }

    final /* synthetic */ int zzi() {
        return this.zzd;
    }
}
