package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzigv extends zzigt {
    zzigv() {
    }

    @Override // com.google.android.gms.internal.ads.zzigt
    final /* bridge */ /* synthetic */ void zza(Object obj, int i3, long j3) {
        ((zzigu) obj).zzk(i3 << 3, Long.valueOf(j3));
    }

    @Override // com.google.android.gms.internal.ads.zzigt
    final /* bridge */ /* synthetic */ void zzb(Object obj, int i3, int i4) {
        ((zzigu) obj).zzk((i3 << 3) | 5, Integer.valueOf(i4));
    }

    @Override // com.google.android.gms.internal.ads.zzigt
    final /* bridge */ /* synthetic */ void zzc(Object obj, int i3, long j3) {
        ((zzigu) obj).zzk((i3 << 3) | 1, Long.valueOf(j3));
    }

    @Override // com.google.android.gms.internal.ads.zzigt
    final /* bridge */ /* synthetic */ void zzd(Object obj, int i3, zzida zzidaVar) {
        ((zzigu) obj).zzk((i3 << 3) | 2, zzidaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzigt
    final /* bridge */ /* synthetic */ void zze(Object obj, int i3, Object obj2) {
        ((zzigu) obj).zzk((i3 << 3) | 3, (zzigu) obj2);
    }

    @Override // com.google.android.gms.internal.ads.zzigt
    final /* synthetic */ Object zzf() {
        return zzigu.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzigt
    final /* synthetic */ Object zzg(Object obj) {
        zzigu zziguVar = (zzigu) obj;
        zziguVar.zzd();
        return zziguVar;
    }

    @Override // com.google.android.gms.internal.ads.zzigt
    final /* bridge */ /* synthetic */ Object zzh(Object obj) {
        zziee zzieeVar = (zziee) obj;
        zzigu zziguVar = zzieeVar.zzt;
        if (zziguVar != zzigu.zza()) {
            return zziguVar;
        }
        zzigu zziguVarZzb = zzigu.zzb();
        zzieeVar.zzt = zziguVarZzb;
        return zziguVarZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzigt
    final /* synthetic */ void zzi(Object obj, Object obj2) {
        ((zziee) obj).zzt = (zzigu) obj2;
    }

    @Override // com.google.android.gms.internal.ads.zzigt
    final void zzj(Object obj) {
        ((zziee) obj).zzt.zzd();
    }
}
