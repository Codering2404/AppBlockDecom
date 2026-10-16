package com.google.android.gms.internal.ads;

import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzffe implements zzfci {
    private final Map zza;

    public zzffe(Map map) {
        this.zza = map;
    }

    @Override // com.google.android.gms.internal.ads.zzfci
    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        try {
            ((JSONObject) obj).put("video_decoders", com.google.android.gms.ads.internal.client.zzay.a().w(this.zza));
        } catch (JSONException e3) {
            com.google.android.gms.ads.internal.util.zze.k("Could not encode video decoder properties: ".concat(String.valueOf(e3.getMessage())));
        }
    }
}
