package com.google.android.gms.ads.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.ads.zzbih;
import com.google.android.gms.internal.ads.zzbiq;
import com.google.android.gms.internal.ads.zzbty;
import com.google.android.gms.internal.ads.zzbuc;
import com.google.android.gms.internal.ads.zzbuf;
import com.google.android.gms.internal.ads.zzbui;
import com.google.android.gms.internal.ads.zzcey;
import com.google.android.gms.internal.ads.zzcfr;
import com.google.android.gms.internal.ads.zzcfu;
import com.google.android.gms.internal.ads.zzdzk;
import com.google.android.gms.internal.ads.zzdzl;
import com.google.android.gms.internal.ads.zzfpw;
import com.google.android.gms.internal.ads.zzfqj;
import com.google.android.gms.internal.ads.zzhbe;
import com.google.android.gms.internal.ads.zzhbw;
import com.google.android.gms.internal.ads.zzhcg;
import com.google.common.util.concurrent.ListenableFuture;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@ParametersAreNonnullByDefault
public final class zzf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f70399a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f70400b = 0;

    static final /* synthetic */ ListenableFuture d(Long l3, zzdzl zzdzlVar, zzfpw zzfpwVar, zzfqj zzfqjVar, JSONObject jSONObject) throws JSONException {
        boolean zOptBoolean = jSONObject.optBoolean("isSuccessful", false);
        if (zOptBoolean) {
            zzt.l().zzo().zzh(jSONObject.getString("appSettingsJson"));
            if (l3 != null) {
                f(zzdzlVar, "cld_s", zzt.o().a() - l3.longValue());
            }
        }
        String strOptString = jSONObject.optString("errorReason", "");
        if (!TextUtils.isEmpty(strOptString)) {
            zzfpwVar.zzk(strOptString);
        }
        zzfpwVar.zzd(zOptBoolean);
        zzfqjVar.zzb(zzfpwVar.zzm());
        return zzhbw.zza(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(zzdzl zzdzlVar, String str, long j3) {
        if (zzdzlVar != null) {
            if (((Boolean) zzba.c().zzd(zzbiq.zzof)).booleanValue()) {
                zzdzk zzdzkVarZza = zzdzlVar.zza();
                zzdzkVarZza.zzc("action", "lat_init");
                zzdzkVarZza.zzc(str, Long.toString(j3));
                zzdzkVarZza.zzd();
            }
        }
    }

    public final void a(Context context, VersionInfoParcel versionInfoParcel, String str, Runnable runnable, zzfqj zzfqjVar, zzdzl zzdzlVar, Long l3, boolean z2) {
        c(context, versionInfoParcel, true, null, str, null, runnable, zzfqjVar, zzdzlVar, l3, z2);
    }

    public final void b(Context context, VersionInfoParcel versionInfoParcel, String str, zzcey zzceyVar, zzfqj zzfqjVar, boolean z2) {
        c(context, versionInfoParcel, false, zzceyVar, zzceyVar != null ? zzceyVar.zze() : null, str, null, zzfqjVar, null, null, z2);
    }

    final void c(Context context, VersionInfoParcel versionInfoParcel, boolean z2, zzcey zzceyVar, String str, String str2, Runnable runnable, final zzfqj zzfqjVar, final zzdzl zzdzlVar, final Long l3, boolean z3) {
        zzfpw zzfpwVar;
        Exception exc;
        PackageInfo packageInfoF;
        if (zzt.o().a() - this.f70400b < 5000) {
            int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.f("Not retrying to fetch app settings");
            return;
        }
        this.f70400b = zzt.o().a();
        if (zzceyVar != null && !TextUtils.isEmpty(zzceyVar.zzd())) {
            if (zzt.o().currentTimeMillis() - zzceyVar.zzb() <= ((Long) zzba.c().zzd(zzbiq.zzfb)).longValue() && zzceyVar.zzc()) {
                return;
            }
        }
        if (context == null) {
            int i4 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.f("Context not provided to fetch application settings");
            return;
        }
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            int i5 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.f("App settings could not be fetched. Required parameters missing");
            return;
        }
        Context applicationContext = context.getApplicationContext();
        if (applicationContext == null) {
            applicationContext = context;
        }
        this.f70399a = applicationContext;
        final zzfpw zzfpwVarZzn = zzfpw.zzn(context, 4);
        zzfpwVarZzn.zza();
        zzbui zzbuiVarZzb = zzt.v().zzb(this.f70399a, versionInfoParcel, zzfqjVar);
        zzbuc zzbucVar = zzbuf.zza;
        zzbty zzbtyVarZza = zzbuiVarZzb.zza("google.afma.config.fetchAppSettings", zzbucVar, zzbucVar);
        try {
            JSONObject jSONObject = new JSONObject();
            try {
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put("app_id", str);
                } else if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put("ad_unit_id", str2);
                }
                jSONObject.put("is_init", z2);
                jSONObject.put("pn", context.getPackageName());
                zzbih zzbihVar = zzbiq.zza;
                jSONObject.put("experiment_ids", TextUtils.join(",", zzba.b().zze()));
                jSONObject.put("js", versionInfoParcel.f70149a);
                if (((Boolean) zzba.c().zzd(zzbiq.zzkU)).booleanValue()) {
                    jSONObject.put("inspector_enabled", z3);
                }
                try {
                    ApplicationInfo applicationInfo = this.f70399a.getApplicationInfo();
                    if (applicationInfo != null && (packageInfoF = Wrappers.a(context).f(applicationInfo.packageName, 0)) != null) {
                        jSONObject.put("version", packageInfoF.versionCode);
                    }
                } catch (PackageManager.NameNotFoundException unused) {
                    com.google.android.gms.ads.internal.util.zze.k("Error fetching PackageInfo.");
                }
                ListenableFuture listenableFutureZzb = zzbtyVarZza.zzb(jSONObject);
                try {
                    zzhbe zzhbeVar = new zzhbe(this) { // from class: com.google.android.gms.ads.internal.zzd
                        @Override // com.google.android.gms.internal.ads.zzhbe
                        public final /* synthetic */ ListenableFuture zza(Object obj) {
                            return zzf.d(l3, zzdzlVar, zzfpwVarZzn, zzfqjVar, (JSONObject) obj);
                        }
                    };
                    zzfpwVar = zzfpwVarZzn;
                    try {
                        zzhcg zzhcgVar = zzcfr.zzh;
                        ListenableFuture listenableFutureZzj = zzhbw.zzj(listenableFutureZzb, zzhbeVar, zzhcgVar);
                        if (runnable != null) {
                            listenableFutureZzb.addListener(runnable, zzhcgVar);
                        }
                        if (l3 != null) {
                            listenableFutureZzb.addListener(new Runnable(this) { // from class: com.google.android.gms.ads.internal.zze
                                @Override // java.lang.Runnable
                                public final /* synthetic */ void run() {
                                    zzf.f(zzdzlVar, "cld_r", zzt.o().a() - l3.longValue());
                                }
                            }, zzhcgVar);
                        }
                        if (((Boolean) zzba.c().zzd(zzbiq.zziG)).booleanValue()) {
                            zzcfu.zzb(listenableFutureZzj, "ConfigLoader.maybeFetchNewAppSettings");
                        } else {
                            zzcfu.zza(listenableFutureZzj, "ConfigLoader.maybeFetchNewAppSettings", zzhcgVar);
                        }
                    } catch (Exception e3) {
                        e = e3;
                        exc = e;
                        int i6 = com.google.android.gms.ads.internal.util.zze.f70328b;
                        com.google.android.gms.ads.internal.util.client.zzo.d("Error requesting application settings", exc);
                        zzfpwVar.zzj(exc);
                        zzfpwVar.zzd(false);
                        zzfqjVar.zzb(zzfpwVar.zzm());
                    }
                } catch (Exception e4) {
                    e = e4;
                    zzfpwVar = zzfpwVarZzn;
                }
            } catch (Exception e5) {
                exc = e5;
                zzfpwVar = zzfpwVarZzn;
                int i62 = com.google.android.gms.ads.internal.util.zze.f70328b;
                com.google.android.gms.ads.internal.util.client.zzo.d("Error requesting application settings", exc);
                zzfpwVar.zzj(exc);
                zzfpwVar.zzd(false);
                zzfqjVar.zzb(zzfpwVar.zzm());
            }
        } catch (Exception e6) {
            e = e6;
            zzfpwVar = zzfpwVarZzn;
        }
    }
}
