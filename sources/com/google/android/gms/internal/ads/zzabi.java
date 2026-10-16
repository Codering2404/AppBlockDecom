package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzabi {
    public final int zza;
    public final zznd[] zzb;
    public final zzaba[] zzc;
    public final zzbn zzd;
    public final Object zze;

    public zzabi(zznd[] zzndVarArr, zzaba[] zzabaVarArr, zzbn zzbnVar, Object obj) {
        int length = zzndVarArr.length;
        zzgtj.zza(length == zzabaVarArr.length);
        this.zzb = zzndVarArr;
        this.zzc = (zzaba[]) zzabaVarArr.clone();
        this.zzd = zzbnVar;
        this.zze = obj;
        this.zza = length;
    }

    public final boolean zza(int i3) {
        return this.zzb[i3] != null;
    }

    public final boolean zzb(zzabi zzabiVar, int i3) {
        return zzabiVar != null && Objects.equals(this.zzb[i3], zzabiVar.zzb[i3]) && Objects.equals(this.zzc[i3], zzabiVar.zzc[i3]);
    }
}
