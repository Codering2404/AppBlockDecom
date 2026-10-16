package com.google.android.recaptcha.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzpn extends zzpl {
    zzpn() {
    }

    @Override // com.google.android.recaptcha.internal.zzpl
    final /* bridge */ /* synthetic */ Object zza(Object obj) {
        zznd zzndVar = (zznd) obj;
        zzpm zzpmVar = zzndVar.zzc;
        if (zzpmVar != zzpm.zzc()) {
            return zzpmVar;
        }
        zzpm zzpmVarZzf = zzpm.zzf();
        zzndVar.zzc = zzpmVarZzf;
        return zzpmVarZzf;
    }

    @Override // com.google.android.recaptcha.internal.zzpl
    final /* synthetic */ Object zzb() {
        return zzpm.zzf();
    }

    @Override // com.google.android.recaptcha.internal.zzpl
    final /* synthetic */ Object zzc(Object obj) {
        zzpm zzpmVar = (zzpm) obj;
        zzpmVar.zzh();
        return zzpmVar;
    }

    @Override // com.google.android.recaptcha.internal.zzpl
    final /* bridge */ /* synthetic */ void zzd(Object obj, int i3, int i4) {
        ((zzpm) obj).zzj((i3 << 3) | 5, Integer.valueOf(i4));
    }

    @Override // com.google.android.recaptcha.internal.zzpl
    final /* bridge */ /* synthetic */ void zze(Object obj, int i3, long j3) {
        ((zzpm) obj).zzj((i3 << 3) | 1, Long.valueOf(j3));
    }

    @Override // com.google.android.recaptcha.internal.zzpl
    final /* bridge */ /* synthetic */ void zzf(Object obj, int i3, Object obj2) {
        ((zzpm) obj).zzj((i3 << 3) | 3, (zzpm) obj2);
    }

    @Override // com.google.android.recaptcha.internal.zzpl
    final /* bridge */ /* synthetic */ void zzg(Object obj, int i3, zzle zzleVar) {
        ((zzpm) obj).zzj((i3 << 3) | 2, zzleVar);
    }

    @Override // com.google.android.recaptcha.internal.zzpl
    final /* bridge */ /* synthetic */ void zzh(Object obj, int i3, long j3) {
        ((zzpm) obj).zzj(i3 << 3, Long.valueOf(j3));
    }

    @Override // com.google.android.recaptcha.internal.zzpl
    final void zzi(Object obj) {
        ((zznd) obj).zzc.zzh();
    }

    @Override // com.google.android.recaptcha.internal.zzpl
    final /* synthetic */ void zzj(Object obj, Object obj2) {
        ((zznd) obj).zzc = (zzpm) obj2;
    }
}
