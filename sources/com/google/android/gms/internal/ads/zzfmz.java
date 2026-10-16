package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfmz implements zzfmx {
    private final String zza;

    public zzfmz(String str) {
        this.zza = str;
    }

    @Override // com.google.android.gms.internal.ads.zzfmx
    public final boolean equals(Object obj) {
        if (obj instanceof zzfmz) {
            return this.zza.equals(((zzfmz) obj).zza);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzfmx
    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final String toString() {
        return this.zza;
    }
}
