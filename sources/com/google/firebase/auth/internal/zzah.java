package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.firebase.auth.FirebaseUserMetadata;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzah implements FirebaseUserMetadata {
    public static final Parcelable.Creator<zzah> CREATOR = new zzag();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f87858a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f87859b;

    public zzah(long j3, long j4) {
        this.f87858a = j3;
        this.f87859b = j4;
    }

    public static zzah e(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            return new zzah(jSONObject.getLong("lastSignInTimestamp"), jSONObject.getLong("creationTimestamp"));
        } catch (JSONException unused) {
            return null;
        }
    }

    public final long c() {
        return this.f87859b;
    }

    public final long d() {
        return this.f87858a;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final JSONObject f() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("lastSignInTimestamp", this.f87858a);
            jSONObject.put("creationTimestamp", this.f87859b);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.z(parcel, 1, d());
        SafeParcelWriter.z(parcel, 2, c());
        SafeParcelWriter.b(parcel, iA);
    }
}
