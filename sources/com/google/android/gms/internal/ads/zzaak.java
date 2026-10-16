package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzaak implements Comparable {
    private final boolean zza;
    private final boolean zzb;

    public zzaak(zzv zzvVar, int i3) {
        this.zza = 1 == (zzvVar.zze & 1);
        this.zzb = zznc.zzac(i3, false);
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final int compareTo(zzaak zzaakVar) {
        return zzgvz.zzg().zzd(this.zzb, zzaakVar.zzb).zzd(this.zza, zzaakVar.zza).zze();
    }
}
