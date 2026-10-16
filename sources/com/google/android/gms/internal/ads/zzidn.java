package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzidn {
    private final Object zza;
    private final int zzb;

    zzidn(Object obj, int i3) {
        this.zza = obj;
        this.zzb = i3;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzidn)) {
            return false;
        }
        zzidn zzidnVar = (zzidn) obj;
        return this.zza == zzidnVar.zza && this.zzb == zzidnVar.zzb;
    }

    public final int hashCode() {
        return (System.identityHashCode(this.zza) * 65535) + this.zzb;
    }
}
