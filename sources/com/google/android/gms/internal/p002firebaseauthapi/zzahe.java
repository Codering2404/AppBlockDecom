package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzahe implements zzahb {
    private final String zza;
    private final String zzb;
    private final String zzc;
    private final String zzd;

    private zzahe(String str, String str2, String str3, String str4, String str5) {
        Preconditions.g(str);
        this.zza = Preconditions.g(str2);
        this.zzb = str3;
        this.zzc = str4;
        this.zzd = str5;
    }

    public static zzahe zza(String str, String str2, String str3, String str4) {
        Preconditions.g(str2);
        Preconditions.g(str4);
        return new zzahe("totp", str, str2, str3, str4);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafa
    public final String zza() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        String str = this.zzb;
        if (str != null) {
            jSONObject2.put("verificationCode", str);
        }
        jSONObject.put("totpVerificationInfo", jSONObject2);
        jSONObject.put("mfaPendingCredential", this.zza);
        String str2 = this.zzc;
        if (str2 != null) {
            jSONObject.put("tenantId", str2);
        }
        String str3 = this.zzd;
        if (str3 != null) {
            jSONObject.put("mfaEnrollmentId", str3);
        }
        return jSONObject.toString();
    }
}
