package com.google.android.gms.internal.gtm;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzaam extends zzaak {
    zzaam() {
    }

    @Override // com.google.android.gms.internal.gtm.zzaak
    final /* synthetic */ int zza(Object obj) {
        return ((zzaal) obj).zza();
    }

    @Override // com.google.android.gms.internal.gtm.zzaak
    final /* synthetic */ int zzb(Object obj) {
        return ((zzaal) obj).zzb();
    }

    @Override // com.google.android.gms.internal.gtm.zzaak
    final /* bridge */ /* synthetic */ Object zzc(Object obj) {
        zzxv zzxvVar = (zzxv) obj;
        zzaal zzaalVar = zzxvVar.zzc;
        if (zzaalVar != zzaal.zzc()) {
            return zzaalVar;
        }
        zzaal zzaalVarZzf = zzaal.zzf();
        zzxvVar.zzc = zzaalVarZzf;
        return zzaalVarZzf;
    }

    @Override // com.google.android.gms.internal.gtm.zzaak
    final /* synthetic */ Object zzd(Object obj) {
        return ((zzxv) obj).zzc;
    }

    @Override // com.google.android.gms.internal.gtm.zzaak
    final /* bridge */ /* synthetic */ Object zze(Object obj, Object obj2) {
        if (!zzaal.zzc().equals(obj2)) {
            if (zzaal.zzc().equals(obj)) {
                return zzaal.zze((zzaal) obj, (zzaal) obj2);
            }
            ((zzaal) obj).zzd((zzaal) obj2);
        }
        return obj;
    }

    @Override // com.google.android.gms.internal.gtm.zzaak
    final /* synthetic */ Object zzf() {
        return zzaal.zzf();
    }

    @Override // com.google.android.gms.internal.gtm.zzaak
    final /* synthetic */ Object zzg(Object obj) {
        ((zzaal) obj).zzh();
        return obj;
    }

    @Override // com.google.android.gms.internal.gtm.zzaak
    final /* bridge */ /* synthetic */ void zzh(Object obj, int i3, int i4) {
        ((zzaal) obj).zzj((i3 << 3) | 5, Integer.valueOf(i4));
    }

    @Override // com.google.android.gms.internal.gtm.zzaak
    final /* bridge */ /* synthetic */ void zzi(Object obj, int i3, long j3) {
        ((zzaal) obj).zzj((i3 << 3) | 1, Long.valueOf(j3));
    }

    @Override // com.google.android.gms.internal.gtm.zzaak
    final /* bridge */ /* synthetic */ void zzj(Object obj, int i3, Object obj2) {
        ((zzaal) obj).zzj((i3 << 3) | 3, obj2);
    }

    @Override // com.google.android.gms.internal.gtm.zzaak
    final /* bridge */ /* synthetic */ void zzk(Object obj, int i3, zzud zzudVar) {
        ((zzaal) obj).zzj((i3 << 3) | 2, zzudVar);
    }

    @Override // com.google.android.gms.internal.gtm.zzaak
    final /* bridge */ /* synthetic */ void zzl(Object obj, int i3, long j3) {
        ((zzaal) obj).zzj(i3 << 3, Long.valueOf(j3));
    }

    @Override // com.google.android.gms.internal.gtm.zzaak
    final void zzm(Object obj) {
        ((zzxv) obj).zzc.zzh();
    }

    @Override // com.google.android.gms.internal.gtm.zzaak
    final /* synthetic */ void zzn(Object obj, Object obj2) {
        ((zzxv) obj).zzc = (zzaal) obj2;
    }

    @Override // com.google.android.gms.internal.gtm.zzaak
    final /* synthetic */ void zzo(Object obj, Object obj2) {
        ((zzxv) obj).zzc = (zzaal) obj2;
    }

    @Override // com.google.android.gms.internal.gtm.zzaak
    final boolean zzq(zzzs zzzsVar) {
        return false;
    }

    @Override // com.google.android.gms.internal.gtm.zzaak
    final /* synthetic */ void zzr(Object obj, zzur zzurVar) throws IOException {
        ((zzaal) obj).zzk(zzurVar);
    }

    @Override // com.google.android.gms.internal.gtm.zzaak
    final /* synthetic */ void zzs(Object obj, zzur zzurVar) throws IOException {
        ((zzaal) obj).zzl(zzurVar);
    }
}
