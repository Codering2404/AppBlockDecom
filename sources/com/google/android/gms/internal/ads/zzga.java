package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzga implements zzao {
    public final float zza;
    public final float zzb;

    public zzga(float f3, float f4) {
        boolean z2 = false;
        if (f3 >= -90.0f && f3 <= 90.0f && f4 >= -180.0f && f4 <= 180.0f) {
            z2 = true;
        }
        zzgtj.zzb(z2, "Invalid latitude or longitude");
        this.zza = f3;
        this.zzb = f4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzga.class == obj.getClass()) {
            zzga zzgaVar = (zzga) obj;
            if (this.zza == zzgaVar.zza && this.zzb == zzgaVar.zzb) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((Float.hashCode(this.zza) + 527) * 31) + Float.hashCode(this.zzb);
    }

    public final String toString() {
        float f3 = this.zza;
        int length = String.valueOf(f3).length();
        float f4 = this.zzb;
        StringBuilder sb = new StringBuilder(length + 26 + String.valueOf(f4).length());
        sb.append("xyz: latitude=");
        sb.append(f3);
        sb.append(", longitude=");
        sb.append(f4);
        return sb.toString();
    }
}
