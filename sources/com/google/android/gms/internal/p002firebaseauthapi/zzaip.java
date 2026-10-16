package com.google.android.gms.internal.p002firebaseauthapi;

import com.facebook.AuthenticationTokenClaims;
import com.google.android.gms.common.util.Strings;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public class zzaip implements zzaez<zzaip> {
    private static final String zza = "zzaip";
    private String zzb;
    private String zzc;
    private long zzd;

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaez
    /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final zzaip zza(String str) throws zzacn {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.zzb = Strings.a(jSONObject.optString("idToken", null));
            Strings.a(jSONObject.optString("displayName", null));
            Strings.a(jSONObject.optString(AuthenticationTokenClaims.JSON_KEY_EMAIL, null));
            this.zzc = Strings.a(jSONObject.optString("refreshToken", null));
            this.zzd = jSONObject.optLong("expiresIn", 0L);
            return this;
        } catch (NullPointerException | JSONException e3) {
            throw zzajk.zza(e3, zza, str);
        }
    }

    public final long zza() {
        return this.zzd;
    }

    public final String zzc() {
        return this.zzc;
    }

    public final String zzb() {
        return this.zzb;
    }
}
