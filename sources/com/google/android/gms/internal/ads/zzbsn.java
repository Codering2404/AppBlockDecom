package com.google.android.gms.internal.ads;

import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public interface zzbsn extends zzbsy, zzbsm {
    @Override // com.google.android.gms.internal.ads.zzbsy
    void zza(String str);

    @Override // com.google.android.gms.internal.ads.zzbsy
    default void zzb(String str, JSONObject jSONObject) {
        zzc(str, jSONObject.toString());
    }

    @Override // com.google.android.gms.internal.ads.zzbsy
    default void zzc(String str, String str2) {
        StringBuilder sb = new StringBuilder(str.length() + 1 + String.valueOf(str2).length() + 2);
        sb.append(str);
        sb.append("(");
        sb.append(str2);
        sb.append(");");
        zza(sb.toString());
    }

    @Override // com.google.android.gms.internal.ads.zzbsm
    default void zzd(String str, JSONObject jSONObject) {
        String string = jSONObject.toString();
        StringBuilder sb = new StringBuilder();
        sb.append("(window.AFMA_ReceiveMessage || function() {})('");
        sb.append(str);
        sb.append("',");
        sb.append(string);
        sb.append(");");
        String string2 = sb.toString();
        int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
        com.google.android.gms.ads.internal.util.client.zzo.a("Dispatching AFMA event: ".concat(string2));
        zza(sb.toString());
    }

    @Override // com.google.android.gms.internal.ads.zzbsm
    default void zze(String str, Map map) {
        try {
            zzd(str, com.google.android.gms.ads.internal.client.zzay.a().w(map));
        } catch (JSONException unused) {
            int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.f("Could not convert parameters to JSON.");
        }
    }
}
