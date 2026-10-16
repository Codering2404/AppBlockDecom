package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzaju extends zzajo {
    public final String zza;
    public final String zzb;

    public zzaju(String str, String str2, String str3) {
        super(str);
        this.zza = str2;
        this.zzb = str3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzaju.class == obj.getClass()) {
            zzaju zzajuVar = (zzaju) obj;
            if (this.zzf.equals(zzajuVar.zzf) && Objects.equals(this.zza, zzajuVar.zza) && Objects.equals(this.zzb, zzajuVar.zzb)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.zzf.hashCode() + 527;
        String str = this.zza;
        return (((iHashCode * 31) + (str != null ? str.hashCode() : 0)) * 31) + this.zzb.hashCode();
    }

    @Override // com.google.android.gms.internal.ads.zzajo
    public final String toString() {
        String str = this.zzf;
        int length = String.valueOf(str).length();
        String str2 = this.zzb;
        StringBuilder sb = new StringBuilder(length + 6 + str2.length());
        sb.append(str);
        sb.append(": url=");
        sb.append(str2);
        return sb.toString();
    }
}
