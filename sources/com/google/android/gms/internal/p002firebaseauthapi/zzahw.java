package com.google.android.gms.internal.p002firebaseauthapi;

import android.util.Log;
import com.facebook.AuthenticationTokenClaims;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzahw {
    private Long zza;
    private Long zzb;

    public static zzahw zza(String str) throws UnsupportedEncodingException {
        try {
            zzahw zzahwVar = new zzahw();
            JSONObject jSONObject = new JSONObject(str);
            jSONObject.optString(AuthenticationTokenClaims.JSON_KEY_ISS);
            jSONObject.optString(AuthenticationTokenClaims.JSON_KEY_AUD);
            jSONObject.optString(AuthenticationTokenClaims.JSON_KEY_SUB);
            zzahwVar.zza = Long.valueOf(jSONObject.optLong(AuthenticationTokenClaims.JSON_KEY_IAT));
            zzahwVar.zzb = Long.valueOf(jSONObject.optLong(AuthenticationTokenClaims.JSON_KEY_EXP));
            jSONObject.optBoolean("is_anonymous");
            return zzahwVar;
        } catch (JSONException e3) {
            if (Log.isLoggable("JwtToken", 3)) {
                Log.d("JwtToken", "Failed to read JwtToken from JSONObject. " + String.valueOf(e3));
            }
            throw new UnsupportedEncodingException("Failed to read JwtToken from JSONObject. " + String.valueOf(e3));
        }
    }

    public final Long zzb() {
        return this.zza;
    }

    public final Long zza() {
        return this.zzb;
    }
}
