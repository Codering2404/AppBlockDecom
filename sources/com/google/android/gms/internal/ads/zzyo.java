package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzyo {
    public final int zza;
    public final boolean zzb;

    public zzyo(int i3, boolean z2) {
        this.zza = i3;
        this.zzb = z2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzyo.class == obj.getClass()) {
            zzyo zzyoVar = (zzyo) obj;
            if (this.zza == zzyoVar.zza && this.zzb == zzyoVar.zzb) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (this.zza * 31) + (this.zzb ? 1 : 0);
    }
}
