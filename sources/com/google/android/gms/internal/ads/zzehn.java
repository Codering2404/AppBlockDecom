package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.cache.LSNn.vfptEEmYY;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzehn {
    private final Context zza;
    private final zzhcg zzb;
    private final zzhcg zzc;
    private final zzimo zzd;
    private final VersionInfoParcel zze;
    private final zzehj zzf;
    private final zzdzl zzg;

    zzehn(Context context, zzhcg zzhcgVar, zzhcg zzhcgVar2, zzimo zzimoVar, VersionInfoParcel versionInfoParcel, zzehj zzehjVar, zzdzl zzdzlVar) {
        this.zza = context;
        this.zzb = zzhcgVar;
        this.zzc = zzhcgVar2;
        this.zzd = zzimoVar;
        this.zze = versionInfoParcel;
        this.zzf = zzehjVar;
        this.zzg = zzdzlVar;
    }

    public final void zza() {
        com.google.android.gms.ads.internal.zzt.g();
        if (com.google.android.gms.ads.internal.util.zzs.f(this.zza.getPackageName())) {
            this.zzc.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzehl
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzb();
                }
            });
            return;
        }
        zzehk zzehkVar = new zzehk(this);
        zzehp zzehpVarZzb = this.zzf.zzb();
        zzehpVarZzb.zzb(zzehkVar);
        final zzefx zzefxVarZza = zzehpVarZzb.zza().zza();
        zzhcg zzhcgVar = this.zzb;
        Objects.requireNonNull(zzefxVarZza);
        zzhcgVar.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzehm
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                zzefxVarZza.zza();
            }
        });
    }

    final /* synthetic */ zzdzl zzd() {
        return this.zzg;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zze, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public final void zzc() {
        String str = vfptEEmYY.IHAwYkHBGN;
        try {
            ((zzeii) this.zzd.zzb()).zzi(this.zze.f70149a);
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzpC)).booleanValue()) {
                zzdzk zzdzkVarZza = this.zzg.zza();
                zzdzkVarZza.zzc("action", str);
                zzdzkVarZza.zzc(str, "l");
                zzdzkVarZza.zzd();
            }
        } catch (RemoteException | NullPointerException e3) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzpD)).booleanValue()) {
                com.google.android.gms.ads.internal.zzt.l().zzg(e3, "Preconnect Local");
            }
        }
    }
}
