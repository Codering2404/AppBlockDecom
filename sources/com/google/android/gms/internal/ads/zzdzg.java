package com.google.android.gms.internal.ads;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.ads.nonagon.devicetier.DeviceTierManager;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzdzg {
    private final ConcurrentHashMap zza;
    private final zzcfi zzb;
    private final zzfky zzc;
    private final String zzd;
    private final String zze;
    private final zzbap zzf;
    private final DeviceTierManager zzg;
    private final Bundle zzh = new Bundle();
    private final Context zzi;

    public zzdzg(Context context, zzdzq zzdzqVar, zzcfi zzcfiVar, zzfky zzfkyVar, String str, String str2, zzbap zzbapVar, DeviceTierManager deviceTierManager) {
        ActivityManager.MemoryInfo memoryInfoP;
        ConcurrentHashMap concurrentHashMapZzd = zzdzqVar.zzd();
        this.zza = concurrentHashMapZzd;
        this.zzb = zzcfiVar;
        this.zzc = zzfkyVar;
        this.zzd = str;
        this.zze = str2;
        this.zzf = zzbapVar;
        this.zzg = deviceTierManager;
        this.zzi = context;
        concurrentHashMapZzd.put("ad_format", str2.toUpperCase(Locale.ROOT));
        zzi();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzcN)).booleanValue()) {
            Runtime runtime = Runtime.getRuntime();
            zzd("rt_f", String.valueOf(runtime.freeMemory()));
            zzd("rt_m", String.valueOf(runtime.maxMemory()));
            zzd("rt_t", String.valueOf(runtime.totalMemory()));
            zzd("wv_c", String.valueOf(com.google.android.gms.ads.internal.zzt.l().zzl()));
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzcW)).booleanValue() && (memoryInfoP = com.google.android.gms.ads.internal.util.client.zzf.p(context)) != null) {
                zzd("mem_avl", String.valueOf(memoryInfoP.availMem));
                zzd("mem_tt", String.valueOf(memoryInfoP.totalMem));
                zzd("low_m", true != memoryInfoP.lowMemory ? AppEventsConstants.EVENT_PARAM_VALUE_NO : AppEventsConstants.EVENT_PARAM_VALUE_YES);
            }
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzdd)).booleanValue()) {
            zzd("ad_unit_id", zzfkyVar.zzg);
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzcX)).booleanValue()) {
            zzd("mem_tier", deviceTierManager.a().name());
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzcY)).booleanValue()) {
            zzd("proc_tier", deviceTierManager.b().name());
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzhT)).booleanValue()) {
            int iG = com.google.android.gms.ads.nonagon.signalgeneration.zzv.g(zzfkyVar) - 1;
            if (iG == 0) {
                concurrentHashMapZzd.put("request_id", str);
                concurrentHashMapZzd.put("scar", "false");
                return;
            }
            if (iG == 1) {
                concurrentHashMapZzd.put("request_id", str);
                concurrentHashMapZzd.put("se", "query_g");
            } else if (iG == 2) {
                concurrentHashMapZzd.put("se", "r_adinfo");
            } else if (iG != 3) {
                concurrentHashMapZzd.put("se", "r_both");
            } else {
                concurrentHashMapZzd.put("se", "r_adstring");
            }
            concurrentHashMapZzd.put("scar", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
            zzd("ragent", zzfkyVar.zzd.f69979q);
            zzd("rtype", com.google.android.gms.ads.nonagon.signalgeneration.zzv.b(com.google.android.gms.ads.nonagon.signalgeneration.zzv.c(zzfkyVar.zzd)));
        }
    }

    public final void zza(zzfkq zzfkqVar) {
        zzfkp zzfkpVar = zzfkqVar.zzb;
        List list = zzfkpVar.zza;
        if (!list.isEmpty()) {
            int i3 = ((zzfkf) list.get(0)).zzb;
            zzd("ad_format", zzfkf.zza(i3));
            if (i3 == 6) {
                this.zza.put("as", true != this.zzb.zzl() ? AppEventsConstants.EVENT_PARAM_VALUE_NO : AppEventsConstants.EVENT_PARAM_VALUE_YES);
            }
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzcP)).booleanValue()) {
            zzd("mwl", Integer.toString(list.size()));
        }
        zzd("gqi", zzfkpVar.zzb.zzb);
    }

    public final void zzb(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        if (bundle.containsKey("cnt")) {
            zzd("network_coarse", Integer.toString(bundle.getInt("cnt")));
        }
        if (bundle.containsKey("gnt")) {
            zzd("network_fine", Integer.toString(bundle.getInt("gnt")));
        }
    }

    public final Map zzc() {
        return this.zza;
    }

    public final void zzd(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.zza.put(str, str2);
    }

    public final synchronized Bundle zze() {
        return this.zzh;
    }

    public final synchronized void zzf(String str, long j3) {
        this.zzh.putLong(str, j3);
    }

    public final synchronized void zzg(Bundle bundle) {
        this.zzh.putAll(bundle);
    }

    public final void zzh() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzoM)).booleanValue()) {
            zzd("brr", true != this.zzc.zzq ? AppEventsConstants.EVENT_PARAM_VALUE_NO : AppEventsConstants.EVENT_PARAM_VALUE_YES);
        }
    }

    public final void zzi() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzkV)).booleanValue()) {
            zzbak zzbakVarZzb = this.zzf.zzb();
            if (zzbakVarZzb instanceof com.google.android.gms.ads.internal.zzk) {
                this.zza.put("asv", ((com.google.android.gms.ads.internal.zzk) zzbakVarZzb).c());
            } else if (zzbakVarZzb instanceof zzcni) {
                this.zza.put("asv", ((zzcni) zzbakVarZzb).zza());
            } else {
                this.zza.put("asv", "NA");
            }
        }
    }
}
