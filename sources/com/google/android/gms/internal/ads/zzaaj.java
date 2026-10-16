package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzaaj extends zzaaq implements Comparable {
    private final int zze;
    private final int zzf;

    public zzaaj(int i3, zzbg zzbgVar, int i4, zzaam zzaamVar, int i5) {
        super(i3, zzbgVar, i4);
        this.zze = zznc.zzac(i5, zzaamVar.zzV) ? 1 : 0;
        this.zzf = this.zzd.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzaaq
    public final int zza() {
        return this.zze;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final int compareTo(zzaaj zzaajVar) {
        return Integer.compare(this.zzf, zzaajVar.zzf);
    }

    @Override // com.google.android.gms.internal.ads.zzaaq
    public final /* bridge */ /* synthetic */ boolean zzc(zzaaq zzaaqVar) {
        return false;
    }
}
