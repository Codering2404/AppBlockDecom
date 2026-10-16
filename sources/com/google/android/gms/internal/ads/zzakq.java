package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzakq {
    public final int zza;
    public final int zzb;
    public final float zzc;

    private zzakq(int i3, int i4, float f3) {
        this.zza = i3;
        this.zzb = i4;
        this.zzc = f3;
    }

    static /* synthetic */ zzakq zza(int i3) {
        int i4 = i3 >> 13;
        if (i4 == 0) {
            return null;
        }
        return new zzakq(i4, (i3 >> 10) & 7, ((i3 & 511) * ((i3 & 512) != 0 ? -1 : 1)) / 10.0f);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzakq)) {
            return false;
        }
        zzakq zzakqVar = (zzakq) obj;
        return this.zza == zzakqVar.zza && this.zzb == zzakqVar.zzb && Float.compare(this.zzc, zzakqVar.zzc) == 0;
    }

    public final int hashCode() {
        return (((this.zza * 31) + this.zzb) * 31) + Float.hashCode(this.zzc);
    }

    public final String toString() {
        int i3 = this.zza;
        int length = String.valueOf(i3).length();
        int i4 = this.zzb;
        int length2 = String.valueOf(i4).length();
        float f3 = this.zzc;
        StringBuilder sb = new StringBuilder(length + 28 + length2 + 7 + String.valueOf(f3).length() + 1);
        sb.append("GainField{name=");
        sb.append(i3);
        sb.append(", originator=");
        sb.append(i4);
        sb.append(", gain=");
        sb.append(f3);
        sb.append("}");
        return sb.toString();
    }
}
