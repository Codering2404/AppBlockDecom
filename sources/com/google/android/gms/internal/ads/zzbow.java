package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzbow implements zzbpq {
    zzbow() {
    }

    @Override // com.google.android.gms.internal.ads.zzbpq
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcku zzckuVar = (zzcku) obj;
        try {
            JSONArray jSONArray = new JSONArray((String) map.get("args"));
            SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(zzckuVar.getContext()).edit();
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                editorEdit.remove(jSONArray.getString(i3));
            }
            editorEdit.apply();
        } catch (JSONException e3) {
            com.google.android.gms.ads.internal.zzt.l().zzg(e3, "GMSG clear local storage keys handler");
        }
    }
}
