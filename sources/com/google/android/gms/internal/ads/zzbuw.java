package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbuw {
    public final List zza;

    public zzbuw(JSONObject jSONObject) throws JSONException {
        if (com.google.android.gms.ads.internal.util.client.zzo.j(2)) {
            com.google.android.gms.ads.internal.util.zze.k("Mediation Response JSON: ".concat(String.valueOf(jSONObject.toString(2))));
        }
        JSONArray jSONArray = jSONObject.getJSONArray("ad_networks");
        ArrayList arrayList = new ArrayList(jSONArray.length());
        int i3 = -1;
        for (int i4 = 0; i4 < jSONArray.length(); i4++) {
            try {
                zzbuv zzbuvVar = new zzbuv(jSONArray.getJSONObject(i4));
                "banner".equalsIgnoreCase(zzbuvVar.zzc);
                arrayList.add(zzbuvVar);
                if (i3 < 0) {
                    Iterator it = zzbuvVar.zza.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (((String) it.next()).equals("com.google.ads.mediation.admob.AdMobAdapter")) {
                                i3 = i4;
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
            } catch (JSONException unused) {
            }
        }
        jSONArray.length();
        this.zza = Collections.unmodifiableList(arrayList);
        jSONObject.optString("qdata");
        jSONObject.optInt("fs_model_type", -1);
        jSONObject.optLong("timeout_ms", -1L);
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("settings");
        if (jSONObjectOptJSONObject != null) {
            jSONObjectOptJSONObject.optLong("ad_network_timeout_millis", -1L);
            com.google.android.gms.ads.internal.zzt.B();
            zzbux.zza(jSONObjectOptJSONObject, "click_urls");
            com.google.android.gms.ads.internal.zzt.B();
            zzbux.zza(jSONObjectOptJSONObject, "imp_urls");
            com.google.android.gms.ads.internal.zzt.B();
            zzbux.zza(jSONObjectOptJSONObject, "downloaded_imp_urls");
            com.google.android.gms.ads.internal.zzt.B();
            zzbux.zza(jSONObjectOptJSONObject, "nofill_urls");
            com.google.android.gms.ads.internal.zzt.B();
            zzbux.zza(jSONObjectOptJSONObject, "remote_ping_urls");
            jSONObjectOptJSONObject.optBoolean("render_in_browser", false);
            jSONObjectOptJSONObject.optLong("refresh", -1L);
            zzccb.zza(jSONObjectOptJSONObject.optJSONArray("rewards"));
            jSONObjectOptJSONObject.optBoolean("use_displayed_impression", false);
            jSONObjectOptJSONObject.optBoolean("allow_pub_rendered_attribution", false);
            jSONObjectOptJSONObject.optBoolean("allow_pub_owned_ad_view", false);
            jSONObjectOptJSONObject.optBoolean("allow_custom_click_gesture", false);
        }
    }
}
