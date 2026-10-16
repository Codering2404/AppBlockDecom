package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.facebook.gamingservices.cloudgaming.internal.SDKAnalyticsEvents;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzewb implements zzfci {
    private final Context zza;
    private final Bundle zzb;
    private final String zzc;
    private final String zzd;
    private final com.google.android.gms.ads.internal.util.zzg zze;
    private final String zzf;
    private final zzczx zzg;

    public zzewb(Context context, Bundle bundle, String str, String str2, com.google.android.gms.ads.internal.util.zzg zzgVar, String str3, zzczx zzczxVar) {
        this.zza = context;
        this.zzb = bundle;
        this.zzc = str;
        this.zzd = str2;
        this.zze = zzgVar;
        this.zzf = str3;
        this.zzg = zzczxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfci
    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        Bundle bundle = (Bundle) obj;
        bundle.putBundle("quality_signals", this.zzb);
        bundle.putString("seq_num", this.zzc);
        if (!this.zze.zzx()) {
            bundle.putString(SDKAnalyticsEvents.PARAMETER_SESSION_ID, this.zzd);
        }
        bundle.putBoolean("client_purpose_one", !r0.zzx());
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzgF)).booleanValue()) {
            try {
                com.google.android.gms.ads.internal.zzt.g();
                bundle.putString("_app_id", com.google.android.gms.ads.internal.util.zzs.c0(this.zza));
            } catch (RemoteException | RuntimeException e3) {
                com.google.android.gms.ads.internal.zzt.l().zzg(e3, "AppStatsSignal_AppId");
            }
        }
        String str = this.zzf;
        if (str != null) {
            Bundle bundle2 = new Bundle();
            zzczx zzczxVar = this.zzg;
            bundle2.putLong("dload", zzczxVar.zzc(str));
            bundle2.putInt("pcc", zzczxVar.zzb(str));
            bundle.putBundle("ad_unit_quality_signals", bundle2);
        }
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzlg)).booleanValue() || com.google.android.gms.ads.internal.zzt.l().zzn() <= 0) {
            return;
        }
        bundle.putInt("nrwv", com.google.android.gms.ads.internal.zzt.l().zzn());
    }
}
