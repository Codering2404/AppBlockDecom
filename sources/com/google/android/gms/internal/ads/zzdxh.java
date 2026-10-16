package com.google.android.gms.internal.ads;

import com.facebook.GraphRequest;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.CheckForNull;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzdxh {
    private JSONObject zzb;
    private final Executor zzc;
    private boolean zzd;
    private JSONObject zze;
    private final Map zza = new ConcurrentHashMap();
    private final AtomicBoolean zzf = new AtomicBoolean(false);

    public zzdxh(Executor executor) {
        this.zzc = executor;
    }

    private final void zzg() {
        if (this.zzf.getAndSet(true)) {
            return;
        }
        com.google.android.gms.ads.internal.zzt.l().zzo().l(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdxe
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zze();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzh, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public final synchronized void zzf() {
        JSONObject jSONObjectZzg;
        Map map;
        try {
            this.zzd = true;
            zzcey zzceyVarZzi = com.google.android.gms.ads.internal.zzt.l().zzo().zzi();
            if (zzceyVarZzi != null && (jSONObjectZzg = zzceyVarZzi.zzg()) != null) {
                this.zzb = ((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzeX)).booleanValue() ? jSONObjectZzg.optJSONObject("common_settings") : null;
                this.zze = jSONObjectZzg.optJSONObject("ad_unit_patterns");
                JSONArray jSONArrayOptJSONArray = jSONObjectZzg.optJSONArray("ad_unit_id_settings");
                if (jSONArrayOptJSONArray != null) {
                    for (int i3 = 0; i3 < jSONArrayOptJSONArray.length(); i3++) {
                        JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i3);
                        if (jSONObjectOptJSONObject != null) {
                            String strOptString = jSONObjectOptJSONObject.optString("ad_unit_id");
                            String strOptString2 = jSONObjectOptJSONObject.optString(GraphRequest.FORMAT_PARAM);
                            JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("request_signals");
                            if (strOptString != null && jSONObjectOptJSONObject2 != null && strOptString2 != null) {
                                Map map2 = this.zza;
                                if (map2.containsKey(strOptString2)) {
                                    map = (Map) map2.get(strOptString2);
                                } else {
                                    ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                                    map2.put(strOptString2, concurrentHashMap);
                                    map = concurrentHashMap;
                                }
                                map.put(strOptString, jSONObjectOptJSONObject2);
                            }
                        }
                    }
                }
            }
        } finally {
        }
    }

    public final void zza() {
        zzg();
        this.zzc.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdxg
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzd();
            }
        });
    }

    @CheckForNull
    public final JSONObject zzb(String str, String str2) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzeV)).booleanValue() || str == null || str2 == null) {
            return null;
        }
        if (!this.zzd) {
            zzf();
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzeW)).booleanValue()) {
                zzg();
            }
        }
        Map map = (Map) this.zza.get(str2);
        if (map == null) {
            return null;
        }
        JSONObject jSONObject = (JSONObject) map.get(str);
        if (jSONObject != null) {
            return jSONObject;
        }
        String strZza = zzdxj.zza(this.zze, str, str2);
        if (strZza != null) {
            return (JSONObject) map.get(strZza);
        }
        return null;
    }

    @CheckForNull
    public final JSONObject zzc() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzeX)).booleanValue()) {
            return this.zzb;
        }
        return null;
    }

    final /* synthetic */ void zze() {
        this.zzc.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdxf
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzf();
            }
        });
    }
}
