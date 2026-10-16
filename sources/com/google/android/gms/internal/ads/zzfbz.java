package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfbz implements zzfci {
    public final boolean zza;
    public final boolean zzb;
    public final String zzc;
    public final boolean zzd;
    public final int zze;
    public final int zzf;
    public final int zzg;
    public final String zzh;

    zzfbz(boolean z2, boolean z3, String str, boolean z4, int i3, int i4, int i5, String str2) {
        this.zza = z2;
        this.zzb = z3;
        this.zzc = str;
        this.zzd = z4;
        this.zze = i3;
        this.zzf = i4;
        this.zzg = i5;
        this.zzh = str2;
    }

    @Override // com.google.android.gms.internal.ads.zzfci
    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        Bundle bundle = (Bundle) obj;
        bundle.putString("js", this.zzc);
        bundle.putBoolean("is_nonagon", true);
        bundle.putString("extra_caps", (String) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzeE));
        bundle.putInt("target_api", this.zze);
        bundle.putInt("dv", this.zzf);
        bundle.putInt("lv", this.zzg);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzgT)).booleanValue()) {
            String str = this.zzh;
            if (!TextUtils.isEmpty(str)) {
                bundle.putString("ev", str);
            }
        }
        Bundle bundleZza = zzfln.zza(bundle, "sdk_env");
        bundleZza.putBoolean("mf", ((Boolean) zzbkq.zzg.zze()).booleanValue());
        bundleZza.putBoolean("instant_app", this.zza);
        bundleZza.putBoolean("lite", this.zzb);
        bundleZza.putBoolean("is_privileged_process", this.zzd);
        bundle.putBundle("sdk_env", bundleZza);
        Bundle bundleZza2 = zzfln.zza(bundleZza, "build_meta");
        bundleZza2.putString("cl", "885195211");
        bundleZza2.putString("rapid_rc", "dev");
        bundleZza2.putString("rapid_rollup", "HEAD");
        bundleZza.putBundle("build_meta", bundleZza2);
    }
}
