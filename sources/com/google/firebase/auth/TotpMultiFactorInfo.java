package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.p002firebaseauthapi.zzaao;
import com.google.android.gms.internal.p002firebaseauthapi.zzaiz;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class TotpMultiFactorInfo extends MultiFactorInfo {
    public static final Parcelable.Creator<TotpMultiFactorInfo> CREATOR = new zzas();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f87805a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f87806b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f87807c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzaiz f87808d;

    public TotpMultiFactorInfo(String str, String str2, long j3, zzaiz zzaizVar) {
        this.f87805a = Preconditions.g(str);
        this.f87806b = str2;
        this.f87807c = j3;
        this.f87808d = (zzaiz) Preconditions.n(zzaizVar, "totpInfo cannot be null.");
    }

    public static TotpMultiFactorInfo w0(JSONObject jSONObject) {
        if (!jSONObject.has("enrollmentTimestamp")) {
            throw new IllegalArgumentException("An enrollment timestamp in seconds of UTC time since Unix epoch is required to build a TotpMultiFactorInfo instance.");
        }
        long jOptLong = jSONObject.optLong("enrollmentTimestamp");
        if (jSONObject.opt("totpInfo") == null) {
            throw new IllegalArgumentException("A totpInfo is required to build a TotpMultiFactorInfo instance.");
        }
        return new TotpMultiFactorInfo(jSONObject.optString("uid"), jSONObject.optString("displayName"), jOptLong, new zzaiz());
    }

    @Override // com.google.firebase.auth.MultiFactorInfo
    public String M() {
        return this.f87806b;
    }

    @Override // com.google.firebase.auth.MultiFactorInfo
    public long N() {
        return this.f87807c;
    }

    @Override // com.google.firebase.auth.MultiFactorInfo
    public String O() {
        return "totp";
    }

    @Override // com.google.firebase.auth.MultiFactorInfo
    public String g0() {
        return this.f87805a;
    }

    @Override // com.google.firebase.auth.MultiFactorInfo
    public JSONObject j0() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("factorIdKey", "totp");
            jSONObject.putOpt("uid", this.f87805a);
            jSONObject.putOpt("displayName", this.f87806b);
            jSONObject.putOpt("enrollmentTimestamp", Long.valueOf(this.f87807c));
            jSONObject.putOpt("totpInfo", this.f87808d);
            return jSONObject;
        } catch (JSONException e3) {
            Log.d("TotpMultiFactorInfo", "Failed to jsonify this object");
            throw new zzaao(e3);
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.G(parcel, 1, g0(), false);
        SafeParcelWriter.G(parcel, 2, M(), false);
        SafeParcelWriter.z(parcel, 3, N());
        SafeParcelWriter.E(parcel, 4, this.f87808d, i3, false);
        SafeParcelWriter.b(parcel, iA);
    }
}
