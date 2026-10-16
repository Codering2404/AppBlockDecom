package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzfg {
    private final Object zza;
    private final int zzb;

    zzfg(Object obj, int i3) {
        this.zza = obj;
        this.zzb = i3;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzfg)) {
            return false;
        }
        zzfg zzfgVar = (zzfg) obj;
        return this.zza == zzfgVar.zza && this.zzb == zzfgVar.zzb;
    }

    public final int hashCode() {
        return (System.identityHashCode(this.zza) * 65535) + this.zzb;
    }
}
