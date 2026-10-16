package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzakr implements zzao {
    public final float zza;
    public final zzakq zzb;
    public final zzakq zzc;

    private zzakr(float f3, zzakq zzakqVar, zzakq zzakqVar2) {
        this.zza = f3;
        this.zzb = zzakqVar;
        this.zzc = zzakqVar2;
    }

    public static zzakr zzb(float f3, int i3, int i4) {
        zzakq zzakqVarZza = zzakq.zza(i3);
        zzakq zzakqVarZza2 = zzakq.zza(i4);
        if (f3 <= 0.0f && zzakqVarZza == null && zzakqVarZza2 == null) {
            return null;
        }
        return new zzakr(f3, zzakqVarZza, zzakqVarZza2);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzakr)) {
            return false;
        }
        zzakr zzakrVar = (zzakr) obj;
        return Float.compare(this.zza, zzakrVar.zza) == 0 && Objects.equals(this.zzb, zzakrVar.zzb) && Objects.equals(this.zzc, zzakrVar.zzc);
    }

    public final int hashCode() {
        int iHashCode = Float.hashCode(this.zza) * 31;
        zzakq zzakqVar = this.zzb;
        int iHashCode2 = (iHashCode + (zzakqVar != null ? zzakqVar.hashCode() : 0)) * 31;
        zzakq zzakqVar2 = this.zzc;
        return iHashCode2 + (zzakqVar2 != null ? zzakqVar2.hashCode() : 0);
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.zzb);
        String strValueOf2 = String.valueOf(this.zzc);
        float f3 = this.zza;
        int length = String.valueOf(f3).length();
        StringBuilder sb = new StringBuilder(length + 37 + strValueOf.length() + 10 + strValueOf2.length());
        sb.append("ReplayGain Xing/Info: peak=");
        sb.append(f3);
        sb.append(", field 1=");
        sb.append(strValueOf);
        sb.append(", field 2=");
        sb.append(strValueOf2);
        return sb.toString();
    }
}
