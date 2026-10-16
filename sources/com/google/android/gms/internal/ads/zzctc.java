package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzctc implements zzhbt {
    final /* synthetic */ zzfsc zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ com.google.android.gms.ads.internal.util.client.zzv zzc;
    final /* synthetic */ zzctj zzd;

    zzctc(zzctj zzctjVar, zzfsc zzfscVar, String str, com.google.android.gms.ads.internal.util.client.zzv zzvVar) {
        this.zza = zzfscVar;
        this.zzb = str;
        this.zzc = zzvVar;
        Objects.requireNonNull(zzctjVar);
        this.zzd = zzctjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhbt
    public final void zza(final Throwable th) {
        final zzfsc zzfscVar = this.zza;
        final String str = this.zzb;
        final com.google.android.gms.ads.internal.util.client.zzv zzvVar = this.zzc;
        this.zzd.zzj().submit(new Runnable() { // from class: com.google.android.gms.internal.ads.zzctb
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                boolean zBooleanValue = ((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzlK)).booleanValue();
                Throwable th2 = th;
                zzctc zzctcVar = this.zza;
                if (zBooleanValue) {
                    zzctj zzctjVar = zzctcVar.zzd;
                    zzcaa zzcaaVarZzc = zzbzy.zzc(zzctjVar.zzi());
                    zzctjVar.zzb = zzcaaVarZzc;
                    zzcaaVarZzc.zzh(th2, "AttributionReporting.registerSourceAndPingClickUrl");
                } else {
                    zzctj zzctjVar2 = zzctcVar.zzd;
                    zzcaa zzcaaVarZza = zzbzy.zza(zzctjVar2.zzi());
                    zzctjVar2.zza = zzcaaVarZza;
                    zzcaaVarZza.zzh(th2, "AttributionReportingSampled.registerSourceAndPingClickUrl");
                }
                com.google.android.gms.ads.internal.util.client.zzv zzvVar2 = zzvVar;
                zzfscVar.zzb(str, zzvVar2, null, null);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzhbt
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        final zzfsc zzfscVar = this.zza;
        final String str = (String) obj;
        final com.google.android.gms.ads.internal.util.client.zzv zzvVar = this.zzc;
        this.zzd.zzj().submit(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcta
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                zzfscVar.zzb(str, zzvVar, null, null);
            }
        });
    }
}
