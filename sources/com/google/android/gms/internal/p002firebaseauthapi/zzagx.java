package com.google.android.gms.internal.p002firebaseauthapi;

import com.facebook.AuthenticationTokenClaims;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import com.google.firebase.auth.ActionCodeUrl;
import com.google.firebase.auth.EmailAuthCredential;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public class zzagx implements zzafa {
    private static final String zza = "zzagx";
    private final String zzb;
    private final String zzc;
    private final EmailAuthCredential zzd;
    private final String zze;
    private final String zzf;

    static {
        new Logger(zzagx.class.getSimpleName(), new String[0]);
    }

    public zzagx(EmailAuthCredential emailAuthCredential, String str, String str2) {
        this.zzd = (EmailAuthCredential) Preconditions.m(emailAuthCredential);
        this.zzb = Preconditions.g(emailAuthCredential.zzc());
        this.zzc = Preconditions.g(emailAuthCredential.zze());
        this.zze = str;
        this.zzf = str2;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafa
    public final String zza() throws JSONException {
        ActionCodeUrl actionCodeUrlB = ActionCodeUrl.b(this.zzc);
        String strA = actionCodeUrlB != null ? actionCodeUrlB.a() : null;
        String strC = actionCodeUrlB != null ? actionCodeUrlB.c() : null;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(AuthenticationTokenClaims.JSON_KEY_EMAIL, this.zzb);
        if (strA != null) {
            jSONObject.put("oobCode", strA);
        }
        if (strC != null) {
            jSONObject.put("tenantId", strC);
        }
        String str = this.zze;
        if (str != null) {
            jSONObject.put("idToken", str);
        }
        String str2 = this.zzf;
        if (str2 != null) {
            zzajk.zza(jSONObject, "captchaResp", str2);
        } else {
            zzajk.zza(jSONObject);
        }
        return jSONObject.toString();
    }

    public final EmailAuthCredential zzb() {
        return this.zzd;
    }

    public final String zzc() {
        return this.zzf;
    }
}
