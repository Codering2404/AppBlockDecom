package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzean extends zzear {
    private final long zza;
    private final int zzb;

    /* synthetic */ zzean(long j3, int i3, byte[] bArr) {
        this.zza = j3;
        this.zzb = i3;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzear) {
            zzear zzearVar = (zzear) obj;
            if (this.zza == zzearVar.zza() && this.zzb == zzearVar.zzb()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j3 = this.zza;
        return ((((int) (j3 ^ (j3 >>> 32))) ^ 1000003) * 1000003) ^ this.zzb;
    }

    public final String toString() {
        long j3 = this.zza;
        int length = String.valueOf(j3).length();
        int i3 = this.zzb;
        StringBuilder sb = new StringBuilder(length + 34 + String.valueOf(i3).length() + 1);
        sb.append("OnDeviceStorageKey{id=");
        sb.append(j3);
        sb.append(", eventType=");
        sb.append(i3);
        sb.append("}");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzear
    public final long zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzear
    public final int zzb() {
        return this.zzb;
    }
}
