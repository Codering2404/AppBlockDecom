package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfdu implements zzfci {
    final String zza;
    final int zzb;

    public zzfdu(String str, int i3) {
        this.zza = str;
        this.zzb = i3;
    }

    @Override // com.google.android.gms.internal.ads.zzfci
    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        int i3;
        String str = this.zza;
        JSONObject jSONObject = (JSONObject) obj;
        if (TextUtils.isEmpty(str) || (i3 = this.zzb) == -1) {
            return;
        }
        try {
            JSONObject jSONObjectH = com.google.android.gms.ads.internal.util.zzbp.h(jSONObject, "pii");
            jSONObjectH.put("pvid", str);
            jSONObjectH.put("pvid_s", i3);
        } catch (JSONException e3) {
            com.google.android.gms.ads.internal.util.zze.l("Failed putting gms core app set ID info.", e3);
        }
    }
}
