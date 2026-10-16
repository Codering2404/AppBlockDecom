package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzan extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzan> CREATOR = new zzam();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f88034a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f88035b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f88036c;

    zzan(String str, String str2, String str3) {
        this.f88034a = str;
        this.f88035b = str2;
        this.f88036c = str3;
    }

    public static com.google.android.gms.internal.p002firebaseauthapi.zzah M(JSONArray jSONArray) throws JSONException {
        if (jSONArray == null || jSONArray.length() == 0) {
            return com.google.android.gms.internal.p002firebaseauthapi.zzah.zzg();
        }
        com.google.android.gms.internal.p002firebaseauthapi.zzak zzakVarZzf = com.google.android.gms.internal.p002firebaseauthapi.zzah.zzf();
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i3);
            zzakVarZzf.zza(new zzan(jSONObject.getString("credentialId"), jSONObject.getString("name"), jSONObject.getString("displayName")));
        }
        return zzakVarZzf.zza();
    }

    public static final zzan N(JSONObject jSONObject) {
        return new zzan(jSONObject.getString("credentialId"), jSONObject.getString("name"), jSONObject.getString("displayName"));
    }

    public static final JSONObject O(zzan zzanVar) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("credentialId", zzanVar.f88034a);
        jSONObject.put("name", zzanVar.f88035b);
        jSONObject.put("displayName", zzanVar.f88036c);
        return jSONObject;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.G(parcel, 1, this.f88034a, false);
        SafeParcelWriter.G(parcel, 2, this.f88035b, false);
        SafeParcelWriter.G(parcel, 3, this.f88036c, false);
        SafeParcelWriter.b(parcel, iA);
    }
}
