package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.facebook.GraphRequest;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbof implements zzbpq {
    private final zzbog zza;

    public zzbof(zzbog zzbogVar) {
        this.zza = zzbogVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbpq
    public final void zza(Object obj, Map map) {
        if (this.zza == null) {
            return;
        }
        String str = (String) map.get("name");
        if (str == null) {
            int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.e("Ad metadata with no name parameter.");
            str = "";
        }
        Bundle bundleL = null;
        if (map.containsKey(GraphRequest.DEBUG_SEVERITY_INFO)) {
            try {
                bundleL = com.google.android.gms.ads.internal.util.zzbp.l(new JSONObject((String) map.get(GraphRequest.DEBUG_SEVERITY_INFO)));
            } catch (JSONException e3) {
                int i4 = com.google.android.gms.ads.internal.util.zze.f70328b;
                com.google.android.gms.ads.internal.util.client.zzo.d("Failed to convert ad metadata to JSON.", e3);
            }
        }
        if (bundleL != null) {
            this.zza.zza(str, bundleL);
        } else {
            int i5 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.c("Failed to convert ad metadata to Bundle.");
        }
    }
}
