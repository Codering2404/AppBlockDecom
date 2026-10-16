package com.google.android.gms.internal.p002firebaseauthapi;

import com.facebook.AuthenticationTokenClaims;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.auth.ActionCodeSettings;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzahm implements zzafa {
    private String zza;
    private String zzb;
    private String zzc;
    private String zzd;
    private ActionCodeSettings zze;
    private String zzf;
    private String zzg;

    public zzahm(int i3) {
        this.zza = zza(i3);
    }

    public static zzahm zza(ActionCodeSettings actionCodeSettings, String str, String str2) {
        Preconditions.g(str);
        Preconditions.g(str2);
        Preconditions.m(actionCodeSettings);
        return new zzahm(7, actionCodeSettings, null, str2, str, null, null);
    }

    public final ActionCodeSettings zzb() {
        return this.zze;
    }

    public final zzahm zzc(String str) {
        this.zzf = str;
        return this;
    }

    public final zzahm zzd(String str) {
        this.zzd = Preconditions.g(str);
        return this;
    }

    public final zzahm zzb(String str) {
        this.zzb = Preconditions.g(str);
        return this;
    }

    public final String zzc() {
        return this.zzb;
    }

    public final String zzd() {
        return this.zzd;
    }

    private zzahm(int i3, ActionCodeSettings actionCodeSettings, String str, String str2, String str3, String str4, String str5) {
        this.zza = zza(7);
        this.zze = (ActionCodeSettings) Preconditions.m(actionCodeSettings);
        this.zzb = null;
        this.zzc = str2;
        this.zzd = str3;
        this.zzf = null;
        this.zzg = null;
    }

    public final zzahm zza(ActionCodeSettings actionCodeSettings) {
        this.zze = (ActionCodeSettings) Preconditions.m(actionCodeSettings);
        return this;
    }

    public final zzahm zza(String str) {
        this.zzg = str;
        return this;
    }

    private static String zza(int i3) {
        if (i3 == 1) {
            return "PASSWORD_RESET";
        }
        if (i3 == 4) {
            return "VERIFY_EMAIL";
        }
        if (i3 == 6) {
            return "EMAIL_SIGNIN";
        }
        if (i3 != 7) {
            return "REQUEST_TYPE_UNSET_ENUM_VALUE";
        }
        return "VERIFY_AND_CHANGE_EMAIL";
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafa
    public final String zza() throws JSONException {
        int i3;
        JSONObject jSONObject = new JSONObject();
        String str = this.zza;
        str.getClass();
        i3 = 1;
        switch (str) {
            case "PASSWORD_RESET":
                break;
            case "VERIFY_EMAIL":
                i3 = 4;
                break;
            case "VERIFY_AND_CHANGE_EMAIL":
                i3 = 7;
                break;
            case "EMAIL_SIGNIN":
                i3 = 6;
                break;
            default:
                i3 = 0;
                break;
        }
        jSONObject.put("requestType", i3);
        String str2 = this.zzb;
        if (str2 != null) {
            jSONObject.put(AuthenticationTokenClaims.JSON_KEY_EMAIL, str2);
        }
        String str3 = this.zzc;
        if (str3 != null) {
            jSONObject.put("newEmail", str3);
        }
        String str4 = this.zzd;
        if (str4 != null) {
            jSONObject.put("idToken", str4);
        }
        ActionCodeSettings actionCodeSettings = this.zze;
        if (actionCodeSettings != null) {
            jSONObject.put("androidInstallApp", actionCodeSettings.N());
            jSONObject.put("canHandleCodeInApp", this.zze.M());
            if (this.zze.z0() != null) {
                jSONObject.put("continueUrl", this.zze.z0());
            }
            if (this.zze.j0() != null) {
                jSONObject.put("iosBundleId", this.zze.j0());
            }
            if (this.zze.zzd() != null) {
                jSONObject.put("iosAppStoreId", this.zze.zzd());
            }
            if (this.zze.g0() != null) {
                jSONObject.put("androidPackageName", this.zze.g0());
            }
            if (this.zze.O() != null) {
                jSONObject.put("androidMinimumVersion", this.zze.O());
            }
            if (this.zze.zzc() != null) {
                jSONObject.put("dynamicLinkDomain", this.zze.zzc());
            }
            if (this.zze.w0() != null) {
                jSONObject.put("linkDomain", this.zze.w0());
            }
        }
        String str5 = this.zzf;
        if (str5 != null) {
            jSONObject.put("tenantId", str5);
        }
        String str6 = this.zzg;
        if (str6 != null) {
            zzajk.zza(jSONObject, "captchaResp", str6);
        } else {
            zzajk.zza(jSONObject);
        }
        return jSONObject.toString();
    }
}
