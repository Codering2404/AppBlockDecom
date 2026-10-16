package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public class zziq {
    private int zza;

    public void zza() {
        this.zza = 0;
    }

    public final boolean zzb() {
        return zzi(4);
    }

    public final boolean zzc() {
        return zzi(1);
    }

    public final boolean zzd() {
        return zzi(536870912);
    }

    public final boolean zze() {
        return zzi(268435456);
    }

    public final boolean zzf() {
        return zzi(67108864);
    }

    public final void zzg(int i3) {
        this.zza = i3;
    }

    public final void zzh(int i3) {
        this.zza |= 536870912;
    }

    protected final boolean zzi(int i3) {
        return (this.zza & i3) == i3;
    }
}
