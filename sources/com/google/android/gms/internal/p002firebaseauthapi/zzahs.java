package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Strings;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public class zzahs implements zzaez<zzahs> {
    private static final String zza = "zzahs";
    private String zzb;
    private zzah<zzaid> zzc;

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaez
    /* JADX INFO: renamed from: zzd, reason: merged with bridge method [inline-methods] */
    public final zzahs zza(String str) throws zzacn {
        zzah<zzaid> zzahVarZzg;
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.zzb = Strings.a(jSONObject.optString("recaptchaKey"));
            if (jSONObject.has("recaptchaEnforcementState")) {
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("recaptchaEnforcementState");
                if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() == 0) {
                    zzahVarZzg = zzah.zzg();
                } else {
                    zzak zzakVarZzf = zzah.zzf();
                    for (int i3 = 0; i3 < jSONArrayOptJSONArray.length(); i3++) {
                        JSONObject jSONObject2 = jSONArrayOptJSONArray.getJSONObject(i3);
                        zzakVarZzf.zza(jSONObject2 == null ? zzaid.zza(null, null) : zzaid.zza(Strings.a(jSONObject2.optString("provider")), Strings.a(jSONObject2.optString("enforcementState"))));
                    }
                    zzahVarZzg = zzakVarZzf.zza();
                }
                this.zzc = zzahVarZzg;
            }
            return this;
        } catch (NullPointerException e3) {
            e = e3;
            throw zzajk.zza(e, zza, str);
        } catch (JSONException e4) {
            e = e4;
            throw zzajk.zza(e, zza, str);
        }
    }

    public final String zzb(String str) {
        Preconditions.g(str);
        zzah<zzaid> zzahVar = this.zzc;
        if (zzahVar != null && !zzahVar.isEmpty()) {
            zzah<zzaid> zzahVar2 = this.zzc;
            int size = zzahVar2.size();
            int i3 = 0;
            while (i3 < size) {
                zzaid zzaidVar = zzahVar2.get(i3);
                i3++;
                zzaid zzaidVar2 = zzaidVar;
                String strZza = zzaidVar2.zza();
                String strZzb = zzaidVar2.zzb();
                if (strZza != null && strZzb != null && strZzb.equals(str)) {
                    return zzaidVar2.zza();
                }
            }
        }
        return null;
    }

    public final boolean zzc(String str) {
        String strZzb = zzb(str);
        if (strZzb == null) {
            return false;
        }
        return strZzb.equals("ENFORCE") || strZzb.equals("AUDIT");
    }

    public final String zza() {
        return this.zzb;
    }
}
