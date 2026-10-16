package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.appopen.AppOpenAd;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbgr {
    private com.google.android.gms.ads.internal.client.zzbu zza;
    private final Context zzb;
    private final String zzc;
    private final com.google.android.gms.ads.internal.client.zzeh zzd;
    private final AppOpenAd.AppOpenAdLoadCallback zze;
    private final zzbuy zzf = new zzbuy();
    private final com.google.android.gms.ads.internal.client.zzq zzg = com.google.android.gms.ads.internal.client.zzq.f70003a;

    public zzbgr(Context context, String str, com.google.android.gms.ads.internal.client.zzeh zzehVar, AppOpenAd.AppOpenAdLoadCallback appOpenAdLoadCallback) {
        this.zzb = context;
        this.zzc = str;
        this.zzd = zzehVar;
        this.zze = appOpenAdLoadCallback;
    }

    public final void zza() {
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            com.google.android.gms.ads.internal.client.zzr zzrVarG0 = com.google.android.gms.ads.internal.client.zzr.g0();
            com.google.android.gms.ads.internal.client.zzaw zzawVarB = com.google.android.gms.ads.internal.client.zzay.b();
            Context context = this.zzb;
            String str = this.zzc;
            com.google.android.gms.ads.internal.client.zzbu zzbuVarA = zzawVarB.a(context, zzrVarG0, str, this.zzf);
            this.zza = zzbuVarA;
            if (zzbuVarA != null) {
                com.google.android.gms.ads.internal.client.zzeh zzehVar = this.zzd;
                zzehVar.o(jCurrentTimeMillis);
                this.zza.zzJ(new zzbge(this.zze, str));
                this.zza.zze(this.zzg.a(context, zzehVar));
            }
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e3);
        }
    }
}
