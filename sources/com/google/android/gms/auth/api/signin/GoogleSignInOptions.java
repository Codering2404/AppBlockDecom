package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.facebook.AuthenticationTokenClaims;
import com.facebook.login.LoginConfiguration;
import com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable;
import com.google.android.gms.auth.api.signin.internal.HashAccumulator;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class GoogleSignInOptions extends AbstractSafeParcelable implements ReflectedParcelable, Api.ApiOptions.Optional {
    public static final Parcelable.Creator<GoogleSignInOptions> CREATOR;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final GoogleSignInOptions f71197m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final GoogleSignInOptions f71198n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Scope f71199o = new Scope("profile");

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final Scope f71200p = new Scope(AuthenticationTokenClaims.JSON_KEY_EMAIL);

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final Scope f71201q = new Scope(LoginConfiguration.OPENID);

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final Scope f71202r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final Scope f71203s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final Comparator f71204t;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f71205a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f71206b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Account f71207c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f71208d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f71209f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f71210g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f71211h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f71212i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ArrayList f71213j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f71214k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Map f71215l;

    static {
        Scope scope = new Scope("https://www.googleapis.com/auth/games_lite");
        f71202r = scope;
        f71203s = new Scope("https://www.googleapis.com/auth/games");
        Builder builder = new Builder();
        builder.b();
        builder.c();
        f71197m = builder.a();
        Builder builder2 = new Builder();
        builder2.d(scope, new Scope[0]);
        f71198n = builder2.a();
        CREATOR = new zae();
        f71204t = new zac();
    }

    public static GoogleSignInOptions J2(String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("scopes");
        int length = jSONArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            hashSet.add(new Scope(jSONArray.getString(i3)));
        }
        String strOptString = jSONObject.has("accountName") ? jSONObject.optString("accountName") : null;
        return new GoogleSignInOptions(3, new ArrayList(hashSet), !TextUtils.isEmpty(strOptString) ? new Account(strOptString, "com.google") : null, jSONObject.getBoolean("idTokenRequested"), jSONObject.getBoolean("serverAuthRequested"), jSONObject.getBoolean("forceCodeForRefreshToken"), jSONObject.has("serverClientId") ? jSONObject.optString("serverClientId") : null, jSONObject.has("hostedDomain") ? jSONObject.optString("hostedDomain") : null, new HashMap(), (String) null);
    }

    public static Map U2(List list) {
        HashMap map = new HashMap();
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                GoogleSignInOptionsExtensionParcelable googleSignInOptionsExtensionParcelable = (GoogleSignInOptionsExtensionParcelable) it.next();
                map.put(Integer.valueOf(googleSignInOptionsExtensionParcelable.M()), googleSignInOptionsExtensionParcelable);
            }
        }
        return map;
    }

    public ArrayList M() {
        return this.f71213j;
    }

    public String N() {
        return this.f71214k;
    }

    public final String N2() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            Collections.sort(this.f71206b, f71204t);
            ArrayList arrayList = this.f71206b;
            int size = arrayList.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = arrayList.get(i3);
                i3++;
                jSONArray.put(((Scope) obj).M());
            }
            jSONObject.put("scopes", jSONArray);
            Account account = this.f71207c;
            if (account != null) {
                jSONObject.put("accountName", account.name);
            }
            jSONObject.put("idTokenRequested", this.f71208d);
            jSONObject.put("forceCodeForRefreshToken", this.f71210g);
            jSONObject.put("serverAuthRequested", this.f71209f);
            if (!TextUtils.isEmpty(this.f71211h)) {
                jSONObject.put("serverClientId", this.f71211h);
            }
            if (!TextUtils.isEmpty(this.f71212i)) {
                jSONObject.put("hostedDomain", this.f71212i);
            }
            return jSONObject.toString();
        } catch (JSONException e3) {
            throw new RuntimeException(e3);
        }
    }

    public ArrayList O() {
        return new ArrayList(this.f71206b);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0052 A[Catch: ClassCastException -> 0x0090, TryCatch #0 {ClassCastException -> 0x0090, blocks: (B:5:0x0004, B:7:0x000e, B:10:0x0018, B:12:0x0028, B:15:0x0035, B:17:0x0039, B:22:0x004a, B:24:0x0052, B:30:0x006a, B:32:0x0072, B:34:0x007a, B:36:0x0082, B:27:0x005d, B:20:0x0040), top: B:42:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x005d A[Catch: ClassCastException -> 0x0090, TryCatch #0 {ClassCastException -> 0x0090, blocks: (B:5:0x0004, B:7:0x000e, B:10:0x0018, B:12:0x0028, B:15:0x0035, B:17:0x0039, B:22:0x004a, B:24:0x0052, B:30:0x006a, B:32:0x0072, B:34:0x007a, B:36:0x0082, B:27:0x005d, B:20:0x0040), top: B:42:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x008e A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean equals(java.lang.Object r4) {
        /*
            r3 = this;
            r0 = 0
            if (r4 != 0) goto L4
            return r0
        L4:
            com.google.android.gms.auth.api.signin.GoogleSignInOptions r4 = (com.google.android.gms.auth.api.signin.GoogleSignInOptions) r4     // Catch: java.lang.ClassCastException -> L90
            java.util.ArrayList r1 = r3.f71213j     // Catch: java.lang.ClassCastException -> L90
            boolean r1 = r1.isEmpty()     // Catch: java.lang.ClassCastException -> L90
            if (r1 == 0) goto L90
            java.util.ArrayList r1 = r4.f71213j     // Catch: java.lang.ClassCastException -> L90
            boolean r1 = r1.isEmpty()     // Catch: java.lang.ClassCastException -> L90
            if (r1 != 0) goto L18
            goto L90
        L18:
            java.util.ArrayList r1 = r3.f71206b     // Catch: java.lang.ClassCastException -> L90
            int r1 = r1.size()     // Catch: java.lang.ClassCastException -> L90
            java.util.ArrayList r2 = r4.O()     // Catch: java.lang.ClassCastException -> L90
            int r2 = r2.size()     // Catch: java.lang.ClassCastException -> L90
            if (r1 != r2) goto L90
            java.util.ArrayList r1 = r3.f71206b     // Catch: java.lang.ClassCastException -> L90
            java.util.ArrayList r2 = r4.O()     // Catch: java.lang.ClassCastException -> L90
            boolean r1 = r1.containsAll(r2)     // Catch: java.lang.ClassCastException -> L90
            if (r1 != 0) goto L35
            goto L90
        L35:
            android.accounts.Account r1 = r3.f71207c     // Catch: java.lang.ClassCastException -> L90
            if (r1 != 0) goto L40
            android.accounts.Account r1 = r4.getAccount()     // Catch: java.lang.ClassCastException -> L90
            if (r1 != 0) goto L90
            goto L4a
        L40:
            android.accounts.Account r2 = r4.getAccount()     // Catch: java.lang.ClassCastException -> L90
            boolean r1 = r1.equals(r2)     // Catch: java.lang.ClassCastException -> L90
            if (r1 == 0) goto L90
        L4a:
            java.lang.String r1 = r3.f71211h     // Catch: java.lang.ClassCastException -> L90
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.ClassCastException -> L90
            if (r1 == 0) goto L5d
            java.lang.String r1 = r4.g0()     // Catch: java.lang.ClassCastException -> L90
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.ClassCastException -> L90
            if (r1 == 0) goto L90
            goto L6a
        L5d:
            java.lang.String r1 = r3.f71211h     // Catch: java.lang.ClassCastException -> L90
            java.lang.String r2 = r4.g0()     // Catch: java.lang.ClassCastException -> L90
            boolean r1 = r1.equals(r2)     // Catch: java.lang.ClassCastException -> L90
            if (r1 != 0) goto L6a
            goto L90
        L6a:
            boolean r1 = r3.f71210g     // Catch: java.lang.ClassCastException -> L90
            boolean r2 = r4.j0()     // Catch: java.lang.ClassCastException -> L90
            if (r1 != r2) goto L90
            boolean r1 = r3.f71208d     // Catch: java.lang.ClassCastException -> L90
            boolean r2 = r4.w0()     // Catch: java.lang.ClassCastException -> L90
            if (r1 != r2) goto L90
            boolean r1 = r3.f71209f     // Catch: java.lang.ClassCastException -> L90
            boolean r2 = r4.z0()     // Catch: java.lang.ClassCastException -> L90
            if (r1 != r2) goto L90
            java.lang.String r1 = r3.f71214k     // Catch: java.lang.ClassCastException -> L90
            java.lang.String r4 = r4.N()     // Catch: java.lang.ClassCastException -> L90
            boolean r4 = android.text.TextUtils.equals(r1, r4)     // Catch: java.lang.ClassCastException -> L90
            if (r4 == 0) goto L90
            r4 = 1
            return r4
        L90:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.auth.api.signin.GoogleSignInOptions.equals(java.lang.Object):boolean");
    }

    public String g0() {
        return this.f71211h;
    }

    public Account getAccount() {
        return this.f71207c;
    }

    public int hashCode() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = this.f71206b;
        int size = arrayList2.size();
        for (int i3 = 0; i3 < size; i3++) {
            arrayList.add(((Scope) arrayList2.get(i3)).M());
        }
        Collections.sort(arrayList);
        HashAccumulator hashAccumulator = new HashAccumulator();
        hashAccumulator.a(arrayList);
        hashAccumulator.a(this.f71207c);
        hashAccumulator.a(this.f71211h);
        hashAccumulator.c(this.f71210g);
        hashAccumulator.c(this.f71208d);
        hashAccumulator.c(this.f71209f);
        hashAccumulator.a(this.f71214k);
        return hashAccumulator.b();
    }

    public boolean j0() {
        return this.f71210g;
    }

    public boolean w0() {
        return this.f71208d;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int i4 = this.f71205a;
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.u(parcel, 1, i4);
        SafeParcelWriter.K(parcel, 2, O(), false);
        SafeParcelWriter.E(parcel, 3, getAccount(), i3, false);
        SafeParcelWriter.g(parcel, 4, w0());
        SafeParcelWriter.g(parcel, 5, z0());
        SafeParcelWriter.g(parcel, 6, j0());
        SafeParcelWriter.G(parcel, 7, g0(), false);
        SafeParcelWriter.G(parcel, 8, this.f71212i, false);
        SafeParcelWriter.K(parcel, 9, M(), false);
        SafeParcelWriter.G(parcel, 10, N(), false);
        SafeParcelWriter.b(parcel, iA);
    }

    public boolean z0() {
        return this.f71209f;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Set f71216a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f71217b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f71218c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f71219d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f71220e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Account f71221f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f71222g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public Map f71223h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public String f71224i;

        public Builder() {
            this.f71216a = new HashSet();
            this.f71223h = new HashMap();
        }

        public GoogleSignInOptions a() {
            if (this.f71216a.contains(GoogleSignInOptions.f71203s)) {
                Set set = this.f71216a;
                Scope scope = GoogleSignInOptions.f71202r;
                if (set.contains(scope)) {
                    this.f71216a.remove(scope);
                }
            }
            if (this.f71219d && (this.f71221f == null || !this.f71216a.isEmpty())) {
                b();
            }
            return new GoogleSignInOptions(new ArrayList(this.f71216a), this.f71221f, this.f71219d, this.f71217b, this.f71218c, this.f71220e, this.f71222g, this.f71223h, this.f71224i);
        }

        public Builder b() {
            this.f71216a.add(GoogleSignInOptions.f71201q);
            return this;
        }

        public Builder c() {
            this.f71216a.add(GoogleSignInOptions.f71199o);
            return this;
        }

        public Builder d(Scope scope, Scope... scopeArr) {
            this.f71216a.add(scope);
            this.f71216a.addAll(Arrays.asList(scopeArr));
            return this;
        }

        public Builder e(String str) {
            this.f71224i = str;
            return this;
        }

        public Builder(GoogleSignInOptions googleSignInOptions) {
            this.f71216a = new HashSet();
            this.f71223h = new HashMap();
            Preconditions.m(googleSignInOptions);
            this.f71216a = new HashSet(googleSignInOptions.f71206b);
            this.f71217b = googleSignInOptions.f71209f;
            this.f71218c = googleSignInOptions.f71210g;
            this.f71219d = googleSignInOptions.f71208d;
            this.f71220e = googleSignInOptions.f71211h;
            this.f71221f = googleSignInOptions.f71207c;
            this.f71222g = googleSignInOptions.f71212i;
            this.f71223h = GoogleSignInOptions.U2(googleSignInOptions.f71213j);
            this.f71224i = googleSignInOptions.f71214k;
        }
    }

    public GoogleSignInOptions(int i3, ArrayList arrayList, Account account, boolean z2, boolean z3, boolean z4, String str, String str2, ArrayList arrayList2, String str3) {
        this(i3, arrayList, account, z2, z3, z4, str, str2, U2(arrayList2), str3);
    }

    public GoogleSignInOptions(int i3, ArrayList arrayList, Account account, boolean z2, boolean z3, boolean z4, String str, String str2, Map map, String str3) {
        this.f71205a = i3;
        this.f71206b = arrayList;
        this.f71207c = account;
        this.f71208d = z2;
        this.f71209f = z3;
        this.f71210g = z4;
        this.f71211h = str;
        this.f71212i = str2;
        this.f71213j = new ArrayList(map.values());
        this.f71215l = map;
        this.f71214k = str3;
    }
}
