package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfkk {
    public final String zza;
    public final String zzb;
    public final JSONObject zzc;
    public final JSONObject zzd;

    zzfkk(JsonReader jsonReader) throws IllegalStateException, JSONException, IOException, NumberFormatException {
        JSONObject jSONObjectD = com.google.android.gms.ads.internal.util.zzbp.d(jsonReader);
        this.zzd = jSONObjectD;
        this.zza = jSONObjectD.optString("ad_html", null);
        this.zzb = jSONObjectD.optString("ad_base_url", null);
        this.zzc = jSONObjectD.optJSONObject("ad_json");
    }
}
