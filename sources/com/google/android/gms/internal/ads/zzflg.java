package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzflg implements zzhbt {
    final /* synthetic */ zzcku zza;
    final /* synthetic */ zzctj zzb;
    final /* synthetic */ zzfsc zzc;
    final /* synthetic */ zzekg zzd;

    zzflg(zzcku zzckuVar, zzctj zzctjVar, zzfsc zzfscVar, zzekg zzekgVar) {
        this.zza = zzckuVar;
        this.zzb = zzctjVar;
        this.zzc = zzfscVar;
        this.zzd = zzekgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhbt
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzctj zzctjVar;
        String str = (String) obj;
        zzcku zzckuVar = this.zza;
        zzfkf zzfkfVarZzC = zzckuVar.zzC();
        if (zzfkfVarZzC != null && !zzfkfVarZzC.zzai) {
            com.google.android.gms.ads.internal.util.client.zzv zzvVar = zzfkfVarZzC.zzax;
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzlw)).booleanValue() && (zzctjVar = this.zzb) != null && zzctj.zzc(str)) {
                zzctjVar.zza(str, this.zzc, com.google.android.gms.ads.internal.client.zzay.h(), zzvVar);
                return;
            } else {
                this.zzc.zzb(str, zzvVar, null, null);
                return;
            }
        }
        zzfki zzfkiVarZzaC = zzckuVar.zzaC();
        if (zzfkiVarZzaC == null) {
            com.google.android.gms.ads.internal.zzt.l().zzg(new IllegalArgumentException("Common configuration cannot be null"), "BufferingGmsgHandlers.getBufferingClickGmsgHandler");
            return;
        }
        long jCurrentTimeMillis = com.google.android.gms.ads.internal.zzt.o().currentTimeMillis();
        boolean zZzs = com.google.android.gms.ads.internal.zzt.l().zzs(zzckuVar.getContext());
        boolean z2 = false;
        boolean z3 = ((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzhj)).booleanValue() && zzfkfVarZzC != null && zzfkfVarZzC.zzS;
        if (zzfkfVarZzC != null && zzfkfVarZzC.zzad != null) {
            z2 = true;
        }
        this.zzd.zze(new zzeki(jCurrentTimeMillis, zzfkiVarZzaC.zzb, str, (zZzs || z3 || z2) ? 2 : 1));
    }

    @Override // com.google.android.gms.internal.ads.zzhbt
    public final void zza(Throwable th) {
    }
}
