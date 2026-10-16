package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzahj {
    public final int zza;
    public final byte[] zzb;
    public final int zzc;
    public final int zzd;

    public zzahj(int i3, byte[] bArr, int i4, int i5) {
        this.zza = i3;
        this.zzb = bArr;
        this.zzc = i4;
        this.zzd = i5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzahj.class == obj.getClass()) {
            zzahj zzahjVar = (zzahj) obj;
            if (this.zza == zzahjVar.zza && this.zzc == zzahjVar.zzc && this.zzd == zzahjVar.zzd && Arrays.equals(this.zzb, zzahjVar.zzb)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (((((this.zza * 31) + Arrays.hashCode(this.zzb)) * 31) + this.zzc) * 31) + this.zzd;
    }
}
