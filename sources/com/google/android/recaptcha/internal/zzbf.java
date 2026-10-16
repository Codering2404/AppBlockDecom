package com.google.android.recaptcha.internal;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbf {
    private final SharedPreferences zza;

    public zzbf(Context context) {
        this.zza = context.getSharedPreferences("_GRECAPTCHA", 0);
    }

    public final String zza() {
        String string = this.zza.getString("_GRECAPTCHA_KC", null);
        return string == null ? "" : string;
    }

    public final void zzb(Map map) {
        SharedPreferences.Editor editorEdit = this.zza.edit();
        for (Map.Entry entry : map.entrySet()) {
            editorEdit.putString((String) entry.getKey(), (String) entry.getValue());
        }
        editorEdit.commit();
    }
}
