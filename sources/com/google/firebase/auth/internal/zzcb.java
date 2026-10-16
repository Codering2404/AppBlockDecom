package com.google.firebase.auth.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.compose.animation.core.Xrg.muQRKXGtpOhe;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.internal.p002firebaseauthapi.zzaao;
import com.google.android.gms.internal.p002firebaseauthapi.zzahv;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.MultiFactorInfo;
import com.google.firebase.auth.PhoneMultiFactorInfo;
import com.google.firebase.auth.TotpMultiFactorInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzcb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f87960a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f87961b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SharedPreferences f87962c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Logger f87963d;

    public zzcb(Context context, String str) {
        Preconditions.m(context);
        this.f87961b = Preconditions.g(str);
        this.f87960a = context.getApplicationContext();
        this.f87962c = this.f87960a.getSharedPreferences(String.format("com.google.firebase.auth.api.Store.%s", this.f87961b), 0);
        this.f87963d = new Logger("StorageHelpers", new String[0]);
    }

    private final String d(String str) {
        String string = this.f87962c.getString(str, null);
        if (string != null) {
            return string.startsWith("ENCRYPTED:") ? zzby.a(this.f87960a, this.f87961b).b(string.substring(10)) : string;
        }
        return null;
    }

    private final void f(String str, String str2) {
        String strD = zzby.a(this.f87960a, this.f87961b).d(str2);
        if (strD != null) {
            this.f87962c.edit().putString(str, "ENCRYPTED:" + strD).apply();
        }
    }

    private final void i(String str) {
        this.f87962c.edit().remove(str).apply();
    }

    private final String k(FirebaseUser firebaseUser) {
        boolean z2;
        JSONObject jSONObject = new JSONObject();
        if (!(firebaseUser instanceof zzaf)) {
            return null;
        }
        zzaf zzafVar = (zzaf) firebaseUser;
        try {
            jSONObject.put("cachedTokenState", zzafVar.zze());
            jSONObject.put("applicationName", zzafVar.J2().o());
            jSONObject.put("type", "com.google.firebase.auth.internal.DefaultFirebaseUser");
            if (zzafVar.X2() != null) {
                JSONArray jSONArray = new JSONArray();
                List listX2 = zzafVar.X2();
                int size = listX2.size();
                if (listX2.size() > 30) {
                    this.f87963d.h("Provider user info list size larger than max size, truncating list to %d. Actual list size: %d", 30, Integer.valueOf(listX2.size()));
                    size = 30;
                }
                int i3 = 0;
                boolean z3 = false;
                while (true) {
                    z2 = true;
                    if (i3 >= size) {
                        break;
                    }
                    zzab zzabVar = (zzab) listX2.get(i3);
                    if (zzabVar.K().equals("firebase")) {
                        z3 = true;
                    }
                    if (i3 == size - 1 && !z3) {
                        break;
                    }
                    jSONArray.put(zzabVar.zzb());
                    i3++;
                }
                if (!z3) {
                    for (int i4 = size - 1; i4 < listX2.size() && i4 >= 0; i4++) {
                        zzab zzabVar2 = (zzab) listX2.get(i4);
                        if (zzabVar2.K().equals("firebase")) {
                            jSONArray.put(zzabVar2.zzb());
                            break;
                        }
                        if (i4 == listX2.size() - 1) {
                            jSONArray.put(zzabVar2.zzb());
                        }
                    }
                    z2 = z3;
                    if (!z2) {
                        this.f87963d.h("Malformed user object! No Firebase Auth provider id found. Provider user info list size: %d, trimmed size: %d", Integer.valueOf(listX2.size()), Integer.valueOf(size));
                        if (listX2.size() < 5) {
                            StringBuilder sb = new StringBuilder("Provider user info list:\n");
                            Iterator it = listX2.iterator();
                            while (it.hasNext()) {
                                sb.append(String.format("Provider - %s\n", ((zzab) it.next()).K()));
                            }
                            this.f87963d.h(sb.toString(), new Object[0]);
                        }
                    }
                }
                jSONObject.put("userInfos", jSONArray);
            }
            jSONObject.put("anonymous", zzafVar.w0());
            jSONObject.put("version", "2");
            if (zzafVar.M() != null) {
                jSONObject.put("userMetadata", ((zzah) zzafVar.M()).f());
            }
            List listA = ((zzaj) zzafVar.N()).a();
            if (listA != null && !listA.isEmpty()) {
                JSONArray jSONArray2 = new JSONArray();
                for (int i5 = 0; i5 < listA.size(); i5++) {
                    jSONArray2.put(((MultiFactorInfo) listA.get(i5)).j0());
                }
                jSONObject.put("userMultiFactorInfo", jSONArray2);
            }
            List listQ2 = zzafVar.Q2();
            if (listQ2 != null && !listQ2.isEmpty()) {
                JSONArray jSONArray3 = new JSONArray();
                for (int i6 = 0; i6 < listQ2.size(); i6++) {
                    jSONArray3.put(com.google.firebase.auth.zzan.O((com.google.firebase.auth.zzan) listQ2.get(i6)));
                }
                jSONObject.put("passkeyInfo", jSONArray3);
            }
            return jSONObject.toString();
        } catch (Exception e3) {
            this.f87963d.i("Failed to turn object into JSON", e3, new Object[0]);
            throw new zzaao(e3);
        }
    }

    public final zzahv a(FirebaseUser firebaseUser) {
        Preconditions.m(firebaseUser);
        String strD = d(String.format("com.google.firebase.auth.GET_TOKEN_RESPONSE.%s", firebaseUser.j0()));
        if (strD == null) {
            return null;
        }
        try {
            return zzahv.zzb(strD);
        } catch (zzaao unused) {
            this.f87963d.e("Failed to restore token data from persistent storage.", new Object[0]);
            return null;
        }
    }

    public final FirebaseUser b() {
        String strD = d("com.google.firebase.auth.FIREBASE_USER");
        if (TextUtils.isEmpty(strD)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(strD);
            if (jSONObject.has("type") && "com.google.firebase.auth.internal.DefaultFirebaseUser".equalsIgnoreCase(jSONObject.optString("type"))) {
                return c(jSONObject);
            }
        } catch (Exception unused) {
            this.f87963d.e("Failed to restore user data from persistent storage.", new Object[0]);
        }
        return null;
    }

    public final void e(FirebaseUser firebaseUser, zzahv zzahvVar) {
        Preconditions.m(firebaseUser);
        Preconditions.m(zzahvVar);
        f(String.format("com.google.firebase.auth.GET_TOKEN_RESPONSE.%s", firebaseUser.j0()), zzahvVar.zzf());
    }

    public final void g() {
        i("com.google.firebase.auth.FIREBASE_USER");
    }

    public final void h(FirebaseUser firebaseUser) {
        Preconditions.m(firebaseUser);
        i(String.format("com.google.firebase.auth.GET_TOKEN_RESPONSE.%s", firebaseUser.j0()));
    }

    public final void j(FirebaseUser firebaseUser) {
        Preconditions.m(firebaseUser);
        String strK = k(firebaseUser);
        if (TextUtils.isEmpty(strK)) {
            return;
        }
        f("com.google.firebase.auth.FIREBASE_USER", strK);
    }

    private final zzaf c(JSONObject jSONObject) {
        JSONArray jSONArray;
        JSONArray jSONArray2;
        zzah zzahVarE;
        try {
            String string = jSONObject.getString("cachedTokenState");
            String string2 = jSONObject.getString("applicationName");
            boolean z2 = jSONObject.getBoolean("anonymous");
            String string3 = jSONObject.getString("version");
            String str = string3 != null ? string3 : "2";
            JSONArray jSONArray3 = jSONObject.getJSONArray(muQRKXGtpOhe.WcLMJJljvjxZD);
            int length = jSONArray3.length();
            if (length == 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList(length);
            for (int i3 = 0; i3 < length; i3++) {
                arrayList.add(zzab.w0(jSONArray3.getString(i3)));
            }
            zzaf zzafVar = new zzaf(FirebaseApp.n(string2), arrayList);
            if (!TextUtils.isEmpty(string)) {
                zzafVar.L2(zzahv.zzb(string));
            }
            if (!z2) {
                zzafVar.M2();
            }
            zzafVar.R2(str);
            if (jSONObject.has("userMetadata") && (zzahVarE = zzah.e(jSONObject.getJSONObject("userMetadata"))) != null) {
                zzafVar.S2(zzahVarE);
            }
            if (jSONObject.has("userMultiFactorInfo") && (jSONArray2 = jSONObject.getJSONArray("userMultiFactorInfo")) != null) {
                ArrayList arrayList2 = new ArrayList();
                for (int i4 = 0; i4 < jSONArray2.length(); i4++) {
                    JSONObject jSONObject2 = new JSONObject(jSONArray2.getString(i4));
                    String strOptString = jSONObject2.optString("factorIdKey");
                    arrayList2.add("phone".equals(strOptString) ? PhoneMultiFactorInfo.z0(jSONObject2) : Objects.equals(strOptString, "totp") ? TotpMultiFactorInfo.w0(jSONObject2) : null);
                }
                zzafVar.P2(arrayList2);
            }
            if (jSONObject.has("passkeyInfo") && (jSONArray = jSONObject.getJSONArray("passkeyInfo")) != null) {
                ArrayList arrayList3 = new ArrayList();
                for (int i5 = 0; i5 < jSONArray.length(); i5++) {
                    arrayList3.add(com.google.firebase.auth.zzan.N(new JSONObject(jSONArray.getString(i5))));
                }
                zzafVar.N2(arrayList3);
            }
            return zzafVar;
        } catch (zzaao e3) {
            e = e3;
            this.f87963d.j(e);
            return null;
        } catch (ArrayIndexOutOfBoundsException e4) {
            e = e4;
            this.f87963d.j(e);
            return null;
        } catch (IllegalArgumentException e5) {
            e = e5;
            this.f87963d.j(e);
            return null;
        } catch (JSONException e6) {
            e = e6;
            this.f87963d.j(e);
            return null;
        }
    }
}
