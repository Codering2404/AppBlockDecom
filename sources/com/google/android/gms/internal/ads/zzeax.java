package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzeax {
    private Long zza;
    private final String zzb;
    private String zzc;
    private Integer zzd;
    private String zze;
    private Integer zzf;

    /* synthetic */ zzeax(String str, byte[] bArr) {
        this.zzb = str;
    }

    final /* synthetic */ String zza() {
        String str = (String) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzlt);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("objectId", this.zza);
            jSONObject.put("eventCategory", this.zzb);
            jSONObject.putOpt("event", this.zzc);
            jSONObject.putOpt("errorCode", this.zzd);
            jSONObject.putOpt("rewardType", this.zze);
            jSONObject.putOpt("rewardAmount", this.zzf);
        } catch (JSONException unused) {
            int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.f("Could not convert parameters to JSON.");
        }
        String string = jSONObject.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 14 + String.valueOf(string).length() + 2);
        sb.append(str);
        sb.append("(\"h5adsEvent\",");
        sb.append(string);
        sb.append(");");
        return sb.toString();
    }

    final /* synthetic */ void zzb(Long l3) {
        this.zza = l3;
    }

    final /* synthetic */ void zzc(String str) {
        this.zzc = str;
    }

    final /* synthetic */ void zzd(Integer num) {
        this.zzd = num;
    }

    final /* synthetic */ void zze(String str) {
        this.zze = str;
    }

    final /* synthetic */ void zzf(Integer num) {
        this.zzf = num;
    }
}
