package com.google.android.gms.internal.p002firebaseauthapi;

import com.facebook.AuthenticationTokenClaims;
import com.google.android.gms.common.util.Strings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzaia {
    private List<zzaib> zza;

    public zzaia() {
        this.zza = new ArrayList();
    }

    public static zzaia zza(JSONArray jSONArray) throws JSONException {
        if (jSONArray == null || jSONArray.length() == 0) {
            return new zzaia(new ArrayList());
        }
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i3);
            arrayList.add(jSONObject == null ? new zzaib() : new zzaib(Strings.a(jSONObject.optString("federatedId")), Strings.a(jSONObject.optString("displayName")), Strings.a(jSONObject.optString("photoUrl")), Strings.a(jSONObject.optString("providerId")), null, Strings.a(jSONObject.optString("phoneNumber")), Strings.a(jSONObject.optString(AuthenticationTokenClaims.JSON_KEY_EMAIL))));
        }
        return new zzaia(arrayList);
    }

    private zzaia(List<zzaib> list) {
        if (!list.isEmpty()) {
            this.zza = Collections.unmodifiableList(list);
        } else {
            this.zza = Collections.EMPTY_LIST;
        }
    }

    public final List<zzaib> zza() {
        return this.zza;
    }
}
