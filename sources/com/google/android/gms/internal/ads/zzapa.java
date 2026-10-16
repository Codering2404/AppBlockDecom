package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzapa implements Comparable {
    public final int zza;
    public final zzaov zzb;

    public zzapa(int i3, zzaov zzaovVar) {
        this.zza = i3;
        this.zzb = zzaovVar;
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return Integer.compare(this.zza, ((zzapa) obj).zza);
    }
}
