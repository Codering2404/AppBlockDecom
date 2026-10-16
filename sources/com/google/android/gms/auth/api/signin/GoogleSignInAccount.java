package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.facebook.AuthenticationTokenClaims;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class GoogleSignInAccount extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<GoogleSignInAccount> CREATOR = new zab();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Clock f71181o = DefaultClock.c();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f71182a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f71183b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f71184c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f71185d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f71186f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Uri f71187g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f71188h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f71189i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f71190j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final List f71191k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f71192l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f71193m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Set f71194n = new HashSet();

    public GoogleSignInAccount(int i3, String str, String str2, String str3, String str4, Uri uri, String str5, long j3, String str6, List list, String str7, String str8) {
        this.f71182a = i3;
        this.f71183b = str;
        this.f71184c = str2;
        this.f71185d = str3;
        this.f71186f = str4;
        this.f71187g = uri;
        this.f71188h = str5;
        this.f71189i = j3;
        this.f71190j = str6;
        this.f71191k = list;
        this.f71192l = str7;
        this.f71193m = str8;
    }

    public static GoogleSignInAccount K2(String str, String str2, String str3, String str4, String str5, String str6, Uri uri, Long l3, String str7, Set set) {
        return new GoogleSignInAccount(3, str, str2, str3, str4, uri, null, l3.longValue(), Preconditions.g(str7), new ArrayList((Collection) Preconditions.m(set)), str5, str6);
    }

    public static GoogleSignInAccount L2(String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        String strOptString = jSONObject.optString("photoUrl");
        Uri uri = !TextUtils.isEmpty(strOptString) ? Uri.parse(strOptString) : null;
        long j3 = Long.parseLong(jSONObject.getString(SDKConstants.PARAM_EXPIRATION_TIME));
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("grantedScopes");
        int length = jSONArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            hashSet.add(new Scope(jSONArray.getString(i3)));
        }
        GoogleSignInAccount googleSignInAccountK2 = K2(jSONObject.optString("id"), jSONObject.has("tokenId") ? jSONObject.optString("tokenId") : null, jSONObject.has(AuthenticationTokenClaims.JSON_KEY_EMAIL) ? jSONObject.optString(AuthenticationTokenClaims.JSON_KEY_EMAIL) : null, jSONObject.has("displayName") ? jSONObject.optString("displayName") : null, jSONObject.has("givenName") ? jSONObject.optString("givenName") : null, jSONObject.has("familyName") ? jSONObject.optString("familyName") : null, uri, Long.valueOf(j3), jSONObject.getString("obfuscatedIdentifier"), hashSet);
        googleSignInAccountK2.f71188h = jSONObject.has("serverAuthCode") ? jSONObject.optString("serverAuthCode") : null;
        return googleSignInAccountK2;
    }

    public String J2() {
        return this.f71188h;
    }

    public String M() {
        return this.f71186f;
    }

    public final String M2() {
        return this.f71190j;
    }

    public String N() {
        return this.f71185d;
    }

    public final String N2() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (j0() != null) {
                jSONObject.put("id", j0());
            }
            if (w0() != null) {
                jSONObject.put("tokenId", w0());
            }
            if (N() != null) {
                jSONObject.put(AuthenticationTokenClaims.JSON_KEY_EMAIL, N());
            }
            if (M() != null) {
                jSONObject.put("displayName", M());
            }
            if (g0() != null) {
                jSONObject.put("givenName", g0());
            }
            if (O() != null) {
                jSONObject.put("familyName", O());
            }
            Uri uriZ0 = z0();
            if (uriZ0 != null) {
                jSONObject.put("photoUrl", uriZ0.toString());
            }
            if (J2() != null) {
                jSONObject.put("serverAuthCode", J2());
            }
            jSONObject.put(SDKConstants.PARAM_EXPIRATION_TIME, this.f71189i);
            jSONObject.put("obfuscatedIdentifier", this.f71190j);
            JSONArray jSONArray = new JSONArray();
            List list = this.f71191k;
            Scope[] scopeArr = (Scope[]) list.toArray(new Scope[list.size()]);
            Arrays.sort(scopeArr, new Comparator() { // from class: com.google.android.gms.auth.api.signin.zaa
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    Parcelable.Creator<GoogleSignInAccount> creator = GoogleSignInAccount.CREATOR;
                    return ((Scope) obj).M().compareTo(((Scope) obj2).M());
                }
            });
            for (Scope scope : scopeArr) {
                jSONArray.put(scope.M());
            }
            jSONObject.put("grantedScopes", jSONArray);
            jSONObject.remove("serverAuthCode");
            return jSONObject.toString();
        } catch (JSONException e3) {
            throw new RuntimeException(e3);
        }
    }

    public String O() {
        return this.f71193m;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GoogleSignInAccount)) {
            return false;
        }
        GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) obj;
        return googleSignInAccount.f71190j.equals(this.f71190j) && googleSignInAccount.h1().equals(h1());
    }

    public String g0() {
        return this.f71192l;
    }

    public Account getAccount() {
        String str = this.f71185d;
        if (str == null) {
            return null;
        }
        return new Account(str, "com.google");
    }

    public Set h1() {
        HashSet hashSet = new HashSet(this.f71191k);
        hashSet.addAll(this.f71194n);
        return hashSet;
    }

    public int hashCode() {
        return ((this.f71190j.hashCode() + 527) * 31) + h1().hashCode();
    }

    public String j0() {
        return this.f71183b;
    }

    public String w0() {
        return this.f71184c;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.u(parcel, 1, this.f71182a);
        SafeParcelWriter.G(parcel, 2, j0(), false);
        SafeParcelWriter.G(parcel, 3, w0(), false);
        SafeParcelWriter.G(parcel, 4, N(), false);
        SafeParcelWriter.G(parcel, 5, M(), false);
        SafeParcelWriter.E(parcel, 6, z0(), i3, false);
        SafeParcelWriter.G(parcel, 7, J2(), false);
        SafeParcelWriter.z(parcel, 8, this.f71189i);
        SafeParcelWriter.G(parcel, 9, this.f71190j, false);
        SafeParcelWriter.K(parcel, 10, this.f71191k, false);
        SafeParcelWriter.G(parcel, 11, g0(), false);
        SafeParcelWriter.G(parcel, 12, O(), false);
        SafeParcelWriter.b(parcel, iA);
    }

    public Uri z0() {
        return this.f71187g;
    }
}
