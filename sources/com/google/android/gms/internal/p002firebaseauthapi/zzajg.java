package com.google.android.gms.internal.p002firebaseauthapi;

import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzajg implements zzafa {
    private String zza;
    private String zzb;
    private String zzc;
    private String zzd;
    private String zze;
    private boolean zzf;

    private zzajg() {
    }

    public static zzajg zza(String str, String str2, boolean z2) {
        zzajg zzajgVar = new zzajg();
        zzajgVar.zzb = Preconditions.g(str);
        zzajgVar.zzc = Preconditions.g(str2);
        zzajgVar.zzf = z2;
        return zzajgVar;
    }

    public static zzajg zzb(String str, String str2, boolean z2) {
        zzajg zzajgVar = new zzajg();
        zzajgVar.zza = Preconditions.g(str);
        zzajgVar.zzd = Preconditions.g(str2);
        zzajgVar.zzf = z2;
        return zzajgVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafa
    public final String zza() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(this.zzd)) {
            jSONObject.put("phoneNumber", this.zza);
            jSONObject.put("temporaryProof", this.zzd);
        } else {
            jSONObject.put("sessionInfo", this.zzb);
            jSONObject.put("code", this.zzc);
        }
        String str = this.zze;
        if (str != null) {
            jSONObject.put("idToken", str);
        }
        if (!this.zzf) {
            jSONObject.put("operation", 2);
        }
        return jSONObject.toString();
    }

    public final void zza(String str) {
        this.zze = str;
    }
}
