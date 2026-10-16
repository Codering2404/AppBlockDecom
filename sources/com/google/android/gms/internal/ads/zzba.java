package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzba {
    public final Object zza;
    public final int zzb;
    public final zzak zzc;
    public final Object zzd;
    public final int zze;
    public final long zzf;
    public final long zzg;
    public final int zzh;
    public final int zzi;

    static {
        String str = zzfl.zza;
        Integer.toString(0, 36);
        Integer.toString(1, 36);
        Integer.toString(2, 36);
        Integer.toString(3, 36);
        Integer.toString(4, 36);
        Integer.toString(5, 36);
        Integer.toString(6, 36);
    }

    public zzba(Object obj, int i3, zzak zzakVar, Object obj2, int i4, long j3, long j4, int i5, int i6) {
        zzgtj.zza(i3 >= 0);
        zzgtj.zza(i4 >= 0);
        this.zza = obj;
        this.zzb = i3;
        this.zzc = zzakVar;
        this.zzd = obj2;
        this.zze = i4;
        this.zzf = j3;
        this.zzg = j4;
        this.zzh = i5;
        this.zzi = i6;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzba.class == obj.getClass()) {
            zzba zzbaVar = (zzba) obj;
            if (this.zzb == zzbaVar.zzb && this.zze == zzbaVar.zze && this.zzf == zzbaVar.zzf && this.zzg == zzbaVar.zzg && this.zzh == zzbaVar.zzh && this.zzi == zzbaVar.zzi && Objects.equals(this.zzc, zzbaVar.zzc) && Objects.equals(this.zza, zzbaVar.zza) && Objects.equals(this.zzd, zzbaVar.zzd)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(this.zza, Integer.valueOf(this.zzb), this.zzc, this.zzd, Integer.valueOf(this.zze), Long.valueOf(this.zzf), Long.valueOf(this.zzg), Integer.valueOf(this.zzh), Integer.valueOf(this.zzi));
    }

    public final String toString() {
        int i3 = this.zzb;
        int length = String.valueOf(i3).length();
        int i4 = this.zze;
        int length2 = String.valueOf(i4).length();
        long j3 = this.zzf;
        StringBuilder sb = new StringBuilder(length + 19 + length2 + 6 + String.valueOf(j3).length());
        sb.append("mediaItem=");
        sb.append(i3);
        sb.append(", period=");
        sb.append(i4);
        sb.append(", pos=");
        sb.append(j3);
        String string = sb.toString();
        int i5 = this.zzh;
        if (i5 == -1) {
            return string;
        }
        long j4 = this.zzg;
        int i6 = this.zzi;
        int length3 = string.length();
        StringBuilder sb2 = new StringBuilder(length3 + 13 + String.valueOf(j4).length() + 10 + String.valueOf(i5).length() + 5 + String.valueOf(i6).length());
        sb2.append(string);
        sb2.append(", contentPos=");
        sb2.append(j4);
        sb2.append(", adGroup=");
        sb2.append(i5);
        sb2.append(", ad=");
        sb2.append(i6);
        return sb2.toString();
    }
}
