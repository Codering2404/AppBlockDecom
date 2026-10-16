package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzajd implements zzao {
    public final int zza;
    public final String zzb;
    public final String zzc;
    public final String zzd;
    public final boolean zze;
    public final int zzf;

    public zzajd(int i3, String str, String str2, String str3, boolean z2, int i4) {
        boolean z3 = true;
        if (i4 != -1 && i4 <= 0) {
            z3 = false;
        }
        zzgtj.zza(z3);
        this.zza = i3;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = str3;
        this.zze = z2;
        this.zzf = i4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzajd.class == obj.getClass()) {
            zzajd zzajdVar = (zzajd) obj;
            if (this.zza == zzajdVar.zza && Objects.equals(this.zzb, zzajdVar.zzb) && Objects.equals(this.zzc, zzajdVar.zzc) && Objects.equals(this.zzd, zzajdVar.zzd) && this.zze == zzajdVar.zze && this.zzf == zzajdVar.zzf) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.zzb;
        int iHashCode = str != null ? str.hashCode() : 0;
        int i3 = this.zza;
        String str2 = this.zzc;
        int iHashCode2 = str2 != null ? str2.hashCode() : 0;
        int i4 = ((i3 + 527) * 31) + iHashCode;
        String str3 = this.zzd;
        return (((((((i4 * 31) + iHashCode2) * 31) + (str3 != null ? str3.hashCode() : 0)) * 31) + (this.zze ? 1 : 0)) * 31) + this.zzf;
    }

    public final String toString() {
        String str = this.zzc;
        int length = String.valueOf(str).length();
        String str2 = this.zzb;
        int length2 = String.valueOf(str2).length();
        int i3 = this.zza;
        int length3 = String.valueOf(i3).length();
        int i4 = this.zzf;
        StringBuilder sb = new StringBuilder(length + 28 + length2 + 11 + length3 + 19 + String.valueOf(i4).length());
        sb.append("IcyHeaders: name=\"");
        sb.append(str);
        sb.append("\", genre=\"");
        sb.append(str2);
        sb.append("\", bitrate=");
        sb.append(i3);
        sb.append(", metadataInterval=");
        sb.append(i4);
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzao
    public final void zza(zzam zzamVar) {
        String str = this.zzc;
        if (str != null) {
            zzamVar.zzu(str);
        }
        String str2 = this.zzb;
        if (str2 != null) {
            zzamVar.zzt(str2);
        }
    }
}
