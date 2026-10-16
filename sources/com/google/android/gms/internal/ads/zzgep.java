package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzgep implements Comparable {
    final Runnable zza;
    final long zzb;

    zzgep(Runnable runnable, long j3) {
        this.zza = runnable;
        this.zzb = j3;
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return Long.compare(this.zzb, ((zzgep) obj).zzb);
    }
}
