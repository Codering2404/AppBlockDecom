package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzahc {
    public static final zzahc zza = new zzahc(0, 0);
    public final long zzb;
    public final long zzc;

    public zzahc(long j3, long j4) {
        this.zzb = j3;
        this.zzc = j4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzahc.class == obj.getClass()) {
            zzahc zzahcVar = (zzahc) obj;
            if (this.zzb == zzahcVar.zzb && this.zzc == zzahcVar.zzc) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (((int) this.zzb) * 31) + ((int) this.zzc);
    }

    public final String toString() {
        long j3 = this.zzb;
        int length = String.valueOf(j3).length();
        long j4 = this.zzc;
        StringBuilder sb = new StringBuilder(length + 19 + String.valueOf(j4).length() + 1);
        sb.append("[timeUs=");
        sb.append(j3);
        sb.append(", position=");
        sb.append(j4);
        sb.append("]");
        return sb.toString();
    }
}
