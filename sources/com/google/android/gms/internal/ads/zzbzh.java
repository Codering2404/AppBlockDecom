package com.google.android.gms.internal.ads;

import androidx.glance.color.Tq.KqqtdetwHMIO;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbzh {
    public final boolean zza;
    public final String zzb;
    public final boolean zzc;

    public zzbzh(boolean z2, String str, boolean z3) {
        this.zza = z2;
        this.zzb = str;
        this.zzc = z3;
    }

    public static zzbzh zza(JSONObject jSONObject) {
        return new zzbzh(jSONObject.optBoolean("enable_prewarming", false), jSONObject.optString("prefetch_url", KqqtdetwHMIO.PnQ), jSONObject.optBoolean("skip_offline_notification_flow", false));
    }
}
