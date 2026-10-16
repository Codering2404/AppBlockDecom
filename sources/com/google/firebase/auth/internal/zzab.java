package com.google.firebase.auth.internal;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.AuthenticationTokenClaims;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.p002firebaseauthapi.zzaao;
import com.google.android.gms.internal.p002firebaseauthapi.zzahk;
import com.google.android.gms.internal.p002firebaseauthapi.zzaib;
import com.google.firebase.auth.UserInfo;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzab extends AbstractSafeParcelable implements UserInfo {
    public static final Parcelable.Creator<zzab> CREATOR = new zzaa();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f87832a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f87833b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f87834c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f87835d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Uri f87836f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f87837g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f87838h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f87839i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f87840j;

    public zzab(zzaib zzaibVar) {
        Preconditions.m(zzaibVar);
        this.f87832a = zzaibVar.zzd();
        this.f87833b = Preconditions.g(zzaibVar.zzf());
        this.f87834c = zzaibVar.zzb();
        Uri uriZza = zzaibVar.zza();
        if (uriZza != null) {
            this.f87835d = uriZza.toString();
            this.f87836f = uriZza;
        }
        this.f87837g = zzaibVar.zzc();
        this.f87838h = zzaibVar.zze();
        this.f87839i = false;
        this.f87840j = zzaibVar.zzg();
    }

    public static zzab w0(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new zzab(jSONObject.optString("userId"), jSONObject.optString("providerId"), jSONObject.optString(AuthenticationTokenClaims.JSON_KEY_EMAIL), jSONObject.optString("phoneNumber"), jSONObject.optString("displayName"), jSONObject.optString("photoUrl"), jSONObject.optBoolean("isEmailVerified"), jSONObject.optString("rawUserInfo"));
        } catch (JSONException e3) {
            Log.d("DefaultAuthUserInfo", "Failed to unpack UserInfo from JSON");
            throw new zzaao(e3);
        }
    }

    @Override // com.google.firebase.auth.UserInfo
    public final String K() {
        return this.f87833b;
    }

    public final String M() {
        return this.f87834c;
    }

    public final String N() {
        return this.f87837g;
    }

    public final String O() {
        return this.f87838h;
    }

    public final String g0() {
        return this.f87832a;
    }

    public final boolean j0() {
        return this.f87839i;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.G(parcel, 1, g0(), false);
        SafeParcelWriter.G(parcel, 2, K(), false);
        SafeParcelWriter.G(parcel, 3, M(), false);
        SafeParcelWriter.G(parcel, 4, this.f87835d, false);
        SafeParcelWriter.G(parcel, 5, N(), false);
        SafeParcelWriter.G(parcel, 6, O(), false);
        SafeParcelWriter.g(parcel, 7, j0());
        SafeParcelWriter.G(parcel, 8, this.f87840j, false);
        SafeParcelWriter.b(parcel, iA);
    }

    public final String zza() {
        return this.f87840j;
    }

    public final String zzb() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("userId", this.f87832a);
            jSONObject.putOpt("providerId", this.f87833b);
            jSONObject.putOpt("displayName", this.f87834c);
            jSONObject.putOpt("photoUrl", this.f87835d);
            jSONObject.putOpt(AuthenticationTokenClaims.JSON_KEY_EMAIL, this.f87837g);
            jSONObject.putOpt("phoneNumber", this.f87838h);
            jSONObject.putOpt("isEmailVerified", Boolean.valueOf(this.f87839i));
            jSONObject.putOpt("rawUserInfo", this.f87840j);
            return jSONObject.toString();
        } catch (JSONException e3) {
            Log.d("DefaultAuthUserInfo", "Failed to jsonify this object");
            throw new zzaao(e3);
        }
    }

    public zzab(zzahk zzahkVar, String str) {
        Preconditions.m(zzahkVar);
        Preconditions.g(str);
        this.f87832a = Preconditions.g(zzahkVar.zzi());
        this.f87833b = str;
        this.f87837g = zzahkVar.zzh();
        this.f87834c = zzahkVar.zzg();
        Uri uriZzc = zzahkVar.zzc();
        if (uriZzc != null) {
            this.f87835d = uriZzc.toString();
            this.f87836f = uriZzc;
        }
        this.f87839i = zzahkVar.zzm();
        this.f87840j = null;
        this.f87838h = zzahkVar.zzj();
    }

    public zzab(String str, String str2, String str3, String str4, String str5, String str6, boolean z2, String str7) {
        this.f87832a = str;
        this.f87833b = str2;
        this.f87837g = str3;
        this.f87838h = str4;
        this.f87834c = str5;
        this.f87835d = str6;
        if (!TextUtils.isEmpty(str6)) {
            this.f87836f = Uri.parse(this.f87835d);
        }
        this.f87839i = z2;
        this.f87840j = str7;
    }
}
