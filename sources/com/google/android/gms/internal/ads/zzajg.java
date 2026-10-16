package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzajg extends zzajo implements zzaiv {
    public final String zza;
    public final int zzb;
    public final int zzc;
    public final long zzd;
    public final long zze;
    private final zzajo[] zzg;

    public zzajg(String str, int i3, int i4, long j3, long j4, zzajo[] zzajoVarArr) {
        super("CHAP");
        zzgtj.zza(i3 <= i4);
        this.zza = str;
        this.zzb = i3;
        this.zzc = i4;
        this.zzd = j3;
        this.zze = j4;
        this.zzg = zzajoVarArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzajg.class == obj.getClass()) {
            zzajg zzajgVar = (zzajg) obj;
            if (this.zzb == zzajgVar.zzb && this.zzc == zzajgVar.zzc && this.zzd == zzajgVar.zzd && this.zze == zzajgVar.zze && Objects.equals(this.zza, zzajgVar.zza) && Arrays.equals(this.zzg, zzajgVar.zzg)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i3 = this.zzb + 527;
        String str = this.zza;
        long j3 = this.zze;
        return (((((((i3 * 31) + this.zzc) * 31) + ((int) this.zzd)) * 31) + ((int) j3)) * 31) + str.hashCode();
    }
}
