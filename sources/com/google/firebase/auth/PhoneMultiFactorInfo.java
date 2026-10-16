package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import androidx.media3.exoplayer.audio.wRw.CbYNFSEGaQj;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.p002firebaseauthapi.zzaao;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class PhoneMultiFactorInfo extends MultiFactorInfo {
    public static final Parcelable.Creator<PhoneMultiFactorInfo> CREATOR = new zzaq();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f87797a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f87798b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f87799c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f87800d;

    public PhoneMultiFactorInfo(String str, String str2, long j3, String str3) {
        this.f87797a = Preconditions.g(str);
        this.f87798b = str2;
        this.f87799c = j3;
        this.f87800d = Preconditions.g(str3);
    }

    public static PhoneMultiFactorInfo z0(JSONObject jSONObject) {
        if (jSONObject.has("enrollmentTimestamp")) {
            return new PhoneMultiFactorInfo(jSONObject.optString("uid"), jSONObject.optString("displayName"), jSONObject.optLong("enrollmentTimestamp"), jSONObject.optString("phoneNumber"));
        }
        throw new IllegalArgumentException("An enrollment timestamp in seconds of UTC time since Unix epoch is required to build a PhoneMultiFactorInfo instance.");
    }

    @Override // com.google.firebase.auth.MultiFactorInfo
    public String M() {
        return this.f87798b;
    }

    @Override // com.google.firebase.auth.MultiFactorInfo
    public long N() {
        return this.f87799c;
    }

    @Override // com.google.firebase.auth.MultiFactorInfo
    public String O() {
        return "phone";
    }

    @Override // com.google.firebase.auth.MultiFactorInfo
    public String g0() {
        return this.f87797a;
    }

    public String w0() {
        return this.f87800d;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.G(parcel, 1, g0(), false);
        SafeParcelWriter.G(parcel, 2, M(), false);
        SafeParcelWriter.z(parcel, 3, N());
        SafeParcelWriter.G(parcel, 4, w0(), false);
        SafeParcelWriter.b(parcel, iA);
    }

    @Override // com.google.firebase.auth.MultiFactorInfo
    public JSONObject j0() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("factorIdKey", "phone");
            jSONObject.putOpt("uid", this.f87797a);
            jSONObject.putOpt("displayName", this.f87798b);
            jSONObject.putOpt(CbYNFSEGaQj.DgJySLJKmYVnhP, Long.valueOf(this.f87799c));
            jSONObject.putOpt("phoneNumber", this.f87800d);
            return jSONObject;
        } catch (JSONException e3) {
            Log.d("PhoneMultiFactorInfo", "Failed to jsonify this object");
            throw new zzaao(e3);
        }
    }
}
