package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zztm {
    private final zzco[] zza;
    private final zztz zzb;
    private final zzcu zzc;

    public zztm(zzco... zzcoVarArr) {
        zztz zztzVar = new zztz();
        zzcu zzcuVar = new zzcu();
        zzco[] zzcoVarArr2 = {zztzVar, zzcuVar};
        this.zza = zzcoVarArr2;
        System.arraycopy(zzcoVarArr, 0, zzcoVarArr2, 0, 0);
        this.zzb = zztzVar;
        this.zzc = zzcuVar;
    }

    public final zzco[] zza() {
        return this.zza;
    }

    public final zzav zzb(zzav zzavVar) {
        zzcu zzcuVar = this.zzc;
        zzcuVar.zzk(zzavVar.zzb);
        zzcuVar.zzl(zzavVar.zzc);
        return zzavVar;
    }

    public final boolean zzc(boolean z2) {
        this.zzb.zzq(z2);
        return z2;
    }

    public final long zzd(long j3) {
        zzcu zzcuVar = this.zzc;
        return zzcuVar.zzc() ? zzcuVar.zzm(j3) : j3;
    }

    public final long zze() {
        return this.zzb.zzr();
    }
}
