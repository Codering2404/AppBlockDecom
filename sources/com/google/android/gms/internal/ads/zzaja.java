package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzaja implements zzao {
    public final String zza;
    public final String zzb;
    public final long zzc;
    public final long zzd;
    public final byte[] zze;
    private int zzf;

    static {
        zzt zztVar = new zzt();
        zztVar.zzo("application/id3");
        zztVar.zzO();
        zzt zztVar2 = new zzt();
        zztVar2.zzo("application/x-scte35");
        zztVar2.zzO();
    }

    public zzaja(String str, String str2, long j3, long j4, byte[] bArr) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = j3;
        this.zzd = j4;
        this.zze = bArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzaja.class == obj.getClass()) {
            zzaja zzajaVar = (zzaja) obj;
            if (this.zzc == zzajaVar.zzc && this.zzd == zzajaVar.zzd && Objects.equals(this.zza, zzajaVar.zza) && Objects.equals(this.zzb, zzajaVar.zzb) && Arrays.equals(this.zze, zzajaVar.zze)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i3 = this.zzf;
        if (i3 != 0) {
            return i3;
        }
        int iHashCode = ((this.zza.hashCode() + 527) * 31) + this.zzb.hashCode();
        long j3 = this.zzc;
        int iHashCode2 = (((((iHashCode * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31) + ((int) this.zzd)) * 31) + Arrays.hashCode(this.zze);
        this.zzf = iHashCode2;
        return iHashCode2;
    }

    public final String toString() {
        long j3 = this.zzd;
        int length = String.valueOf(j3).length();
        long j4 = this.zzc;
        int length2 = String.valueOf(j4).length();
        String str = this.zza;
        int length3 = str.length() + 18 + length + 13 + length2;
        String str2 = this.zzb;
        StringBuilder sb = new StringBuilder(length3 + 8 + str2.length());
        sb.append("EMSG: scheme=");
        sb.append(str);
        sb.append(", id=");
        sb.append(j3);
        sb.append(", durationMs=");
        sb.append(j4);
        sb.append(", value=");
        sb.append(str2);
        return sb.toString();
    }
}
