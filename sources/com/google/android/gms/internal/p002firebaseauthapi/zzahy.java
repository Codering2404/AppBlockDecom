package com.google.android.gms.internal.p002firebaseauthapi;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Strings;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzahy {
    private final String zza;
    private final String zzb;
    private final String zzc;
    private final long zzd;
    private final zzaiz zze;

    private zzahy(String str, String str2, String str3, long j3, zzaiz zzaizVar) {
        if (!TextUtils.isEmpty(str) && zzaizVar != null) {
            Log.e("MfaInfo", "Cannot have both MFA phone_info and totp_info");
            throw new IllegalArgumentException("Cannot have both MFA phone_info and totp_info");
        }
        this.zza = str;
        this.zzb = Preconditions.g(str2);
        this.zzc = str3;
        this.zzd = j3;
        this.zze = zzaizVar;
    }

    private static long zza(String str) {
        try {
            return zzaoo.zza(zzaoo.zza(str));
        } catch (ParseException e3) {
            Log.w("MfaInfo", "Could not parse timestamp as ISOString. Invalid ISOString \"" + str + "\"", e3);
            return 0L;
        }
    }

    public final zzaiz zzb() {
        return this.zze;
    }

    public final String zzc() {
        return this.zzc;
    }

    public final String zzd() {
        return this.zzb;
    }

    public final String zze() {
        return this.zza;
    }

    public final long zza() {
        return this.zzd;
    }

    public static zzahy zza(JSONObject jSONObject) {
        zzahy zzahyVar = new zzahy(Strings.a(jSONObject.optString("phoneInfo")), Strings.a(jSONObject.optString("mfaEnrollmentId")), Strings.a(jSONObject.optString("displayName")), zza(jSONObject.optString("enrolledAt", "")), jSONObject.opt("totpInfo") != null ? new zzaiz() : null);
        jSONObject.optString("unobfuscatedPhoneInfo");
        return zzahyVar;
    }

    public static List<zzahy> zza(JSONArray jSONArray) throws JSONException {
        if (jSONArray != null && jSONArray.length() != 0) {
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                arrayList.add(zza(jSONArray.getJSONObject(i3)));
            }
            return arrayList;
        }
        return new ArrayList();
    }
}
