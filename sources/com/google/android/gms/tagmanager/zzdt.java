package com.google.android.gms.tagmanager;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzdt implements zzfh {
    final /* synthetic */ zzdv zza;

    zzdt(zzdv zzdvVar) {
        this.zza = zzdvVar;
    }

    @Override // com.google.android.gms.tagmanager.zzfh
    public final void zza(zzbz zzbzVar) {
        long jZza = zzbzVar.zza();
        if (jZza == 0) {
            zzdv.zzi(this.zza, zzbzVar.zzb(), this.zza.zzg.currentTimeMillis());
            return;
        }
        if (jZza + 14400000 < this.zza.zzg.currentTimeMillis()) {
            this.zza.zzl(zzbzVar.zzb());
            zzdg.zzb.zzd("Giving up on failed hitId: " + zzbzVar.zzb());
        }
    }
}
