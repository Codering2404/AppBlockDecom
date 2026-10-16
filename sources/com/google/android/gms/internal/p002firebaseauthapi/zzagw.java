package com.google.android.gms.internal.p002firebaseauthapi;

import android.text.TextUtils;
import com.facebook.AuthenticationTokenClaims;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public class zzagw implements zzaez<zzagw> {
    private static final String zza = "zzagw";
    private String zzb;
    private String zzc;
    private boolean zzd;
    private long zze;
    private List<zzahy> zzf;
    private String zzg;

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaez
    /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final zzagw zza(String str) throws zzacn {
        try {
            JSONObject jSONObject = new JSONObject(str);
            jSONObject.optString("localId", null);
            jSONObject.optString(AuthenticationTokenClaims.JSON_KEY_EMAIL, null);
            this.zzb = jSONObject.optString("idToken", null);
            this.zzc = jSONObject.optString("refreshToken", null);
            this.zzd = jSONObject.optBoolean("isNewUser", false);
            this.zze = jSONObject.optLong("expiresIn", 0L);
            this.zzf = zzahy.zza(jSONObject.optJSONArray("mfaInfo"));
            this.zzg = jSONObject.optString("mfaPendingCredential", null);
            return this;
        } catch (NullPointerException | JSONException e3) {
            throw zzajk.zza(e3, zza, str);
        }
    }

    public final long zza() {
        return this.zze;
    }

    public final String zzc() {
        return this.zzg;
    }

    public final String zzd() {
        return this.zzc;
    }

    public final List<zzahy> zze() {
        return this.zzf;
    }

    public final boolean zzf() {
        return !TextUtils.isEmpty(this.zzg);
    }

    public final boolean zzg() {
        return this.zzd;
    }

    public final String zzb() {
        return this.zzb;
    }
}
