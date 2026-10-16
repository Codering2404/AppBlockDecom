package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzajh extends zzajo {
    public final String zza;
    public final boolean zzb;
    public final boolean zzc;
    public final String[] zzd;
    private final zzajo[] zze;

    public zzajh(String str, boolean z2, boolean z3, String[] strArr, zzajo[] zzajoVarArr) {
        super("CTOC");
        this.zza = str;
        this.zzb = z2;
        this.zzc = z3;
        this.zzd = strArr;
        this.zze = zzajoVarArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzajh.class == obj.getClass()) {
            zzajh zzajhVar = (zzajh) obj;
            if (this.zzb == zzajhVar.zzb && this.zzc == zzajhVar.zzc && Objects.equals(this.zza, zzajhVar.zza) && Arrays.equals(this.zzd, zzajhVar.zzd) && Arrays.equals(this.zze, zzajhVar.zze)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (((((this.zzb ? 1 : 0) + 527) * 31) + (this.zzc ? 1 : 0)) * 31) + this.zza.hashCode();
    }
}
