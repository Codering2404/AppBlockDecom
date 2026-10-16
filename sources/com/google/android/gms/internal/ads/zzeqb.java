package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzeqb implements zzdno {
    private final Context zza;
    private final zzdwi zzb;
    private final zzfky zzc;
    private final VersionInfoParcel zzd;
    private final zzfkf zze;
    private final ListenableFuture zzf;
    private final zzcku zzg;
    private final zzbpt zzh;
    private final boolean zzi;
    private final zzekr zzj;
    private final zzdzg zzk;
    private final zzdzl zzl;

    zzeqb(Context context, zzdwi zzdwiVar, zzfky zzfkyVar, VersionInfoParcel versionInfoParcel, zzfkf zzfkfVar, ListenableFuture listenableFuture, zzcku zzckuVar, zzbpt zzbptVar, boolean z2, zzekr zzekrVar, zzdzg zzdzgVar, zzdzl zzdzlVar) {
        this.zza = context;
        this.zzb = zzdwiVar;
        this.zzc = zzfkyVar;
        this.zzd = versionInfoParcel;
        this.zze = zzfkfVar;
        this.zzf = listenableFuture;
        this.zzg = zzckuVar;
        this.zzh = zzbptVar;
        this.zzi = z2;
        this.zzj = zzekrVar;
        this.zzk = zzdzgVar;
        this.zzl = zzdzlVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdno
    public final void zza(boolean z2, Context context, zzdde zzddeVar) {
        boolean z3;
        zzdvn zzdvnVar = (zzdvn) zzhbw.zzt(this.zzf);
        try {
            zzfkf zzfkfVar = this.zze;
            final zzcku zzckuVarZza = this.zzg;
            if (zzckuVarZza.zzaB()) {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzby)).booleanValue()) {
                    zzckuVarZza = this.zzb.zza(this.zzc.zzf, null, null);
                    zzbqj.zzb(zzckuVarZza, zzdvnVar.zzk());
                    final zzdwm zzdwmVar = new zzdwm();
                    zzdvnVar.zzl().zzi(zzckuVarZza, true, this.zzi ? this.zzh : null, this.zzk);
                    zzckuVarZza.zzP().zzG(new zzcmq(zzdwmVar, zzckuVarZza) { // from class: com.google.android.gms.internal.ads.zzeqa
                        private final /* synthetic */ zzcku zza;

                        {
                            this.zza = zzckuVarZza;
                        }

                        @Override // com.google.android.gms.internal.ads.zzcmq
                        public final /* synthetic */ void zza(boolean z4, int i3, String str, String str2) {
                            zzcku zzckuVar = this.zza;
                            zzckuVar.zzJ();
                            zzckuVar.zzP().zzq();
                        }
                    });
                    zzckuVarZza.zzP().zzH(new zzcmr() { // from class: com.google.android.gms.internal.ads.zzepz
                        @Override // com.google.android.gms.internal.ads.zzcmr
                        public final /* synthetic */ void zza() {
                            zzckuVarZza.zzI();
                        }
                    });
                    zzfkk zzfkkVar = zzfkfVar.zzs;
                    zzckuVarZza.zzau(zzfkkVar.zzb, zzfkkVar.zza, null);
                }
            }
            zzcku zzckuVar = zzckuVarZza;
            zzckuVar.zzag(true);
            boolean z4 = this.zzi;
            boolean z5 = false;
            boolean zZzc = z4 ? this.zzh.zzc(false) : false;
            com.google.android.gms.ads.internal.zzt.g();
            boolean zL = com.google.android.gms.ads.internal.util.zzs.l(this.zza);
            if (!z4) {
                z3 = z5;
            } else if (this.zzh.zzd()) {
                z5 = true;
                z3 = z5;
            } else {
                z3 = false;
                z5 = true;
            }
            float fZze = z5 ? this.zzh.zze() : 0.0f;
            zzfkf zzfkfVar2 = this.zze;
            com.google.android.gms.ads.internal.zzl zzlVar = new com.google.android.gms.ads.internal.zzl(zZzc, zL, z3, fZze, -1, z2, zzfkfVar2.zzO, zzfkfVar2.zzP);
            if (zzddeVar != null) {
                zzddeVar.zzb();
            }
            com.google.android.gms.ads.internal.zzt.f();
            zzdnd zzdndVarZzj = zzdvnVar.zzj();
            int i3 = zzfkfVar2.zzQ;
            VersionInfoParcel versionInfoParcel = this.zzd;
            String str = zzfkfVar2.zzB;
            zzfkk zzfkkVar2 = zzfkfVar2.zzs;
            com.google.android.gms.ads.internal.overlay.zzn.a(context, new AdOverlayInfoParcel(null, zzdndVarZzj, null, zzckuVar, i3, versionInfoParcel, str, zzlVar, zzfkkVar2.zzb, zzfkkVar2.zza, this.zzc.zzg, zzddeVar, zzfkfVar2.zzb() ? this.zzj : null, zzckuVar.zzn()), true, this.zzl);
        } catch (zzclj e3) {
            int i4 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.d("", e3);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdno
    public final zzfkf zzb() {
        return this.zze;
    }
}
