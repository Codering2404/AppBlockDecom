package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzday implements zzdfx, zzdlk {
    private final Context zza;
    private final zzfky zzb;
    private final VersionInfoParcel zzc;
    private final com.google.android.gms.ads.internal.util.zzg zzd;
    private final zzebw zze;
    private final zzfqj zzf;
    private final zzecr zzg;

    public zzday(Context context, zzfky zzfkyVar, VersionInfoParcel versionInfoParcel, com.google.android.gms.ads.internal.util.zzg zzgVar, zzebw zzebwVar, zzfqj zzfqjVar, zzecr zzecrVar) {
        this.zza = context;
        this.zzb = zzfkyVar;
        this.zzc = versionInfoParcel;
        this.zzd = zzgVar;
        this.zze = zzebwVar;
        this.zzf = zzfqjVar;
        this.zzg = zzecrVar;
    }

    private final void zzc() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzeT)).booleanValue()) {
            com.google.android.gms.ads.internal.util.zzg zzgVar = this.zzd;
            Context context = this.zza;
            VersionInfoParcel versionInfoParcel = this.zzc;
            zzfky zzfkyVar = this.zzb;
            zzfqj zzfqjVar = this.zzf;
            zzecr zzecrVar = this.zzg;
            com.google.android.gms.ads.internal.zzt.p().b(context, versionInfoParcel, zzfkyVar.zzg, zzgVar.zzi(), zzfqjVar, zzecrVar.zzs());
        }
        this.zze.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzdlk
    public final void zzd(com.google.android.gms.ads.nonagon.signalgeneration.zzbc zzbcVar) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzeU)).booleanValue()) {
            zzc();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdfx
    public final void zzdP(zzcbd zzcbdVar) {
        zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzdfx
    public final void zzdQ(zzfkq zzfkqVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzdlk
    public final void zze(String str) {
    }
}
