package com.google.firebase.installations.local;

import android.content.SharedPreferences;
import android.util.Base64;
import android.util.Log;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.AccessToken;
import com.google.firebase.FirebaseApp;
import com.revenuecat.purchases.common.Constants;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class IidStore {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String[] f89283c = {"*", "FCM", "GCM", ""};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SharedPreferences f89284a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f89285b;

    public IidStore(FirebaseApp firebaseApp) {
        this.f89284a = firebaseApp.l().getSharedPreferences("com.google.android.gms.appid", 0);
        this.f89285b = b(firebaseApp);
    }

    private String a(String str, String str2) {
        return "|T|" + str + "|" + str2;
    }

    private static String b(FirebaseApp firebaseApp) {
        String strD = firebaseApp.p().d();
        if (strD != null) {
            return strD;
        }
        String strC = firebaseApp.p().c();
        if (!strC.startsWith("1:") && !strC.startsWith("2:")) {
            return strC;
        }
        String[] strArrSplit = strC.split(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
        if (strArrSplit.length != 4) {
            return null;
        }
        String str = strArrSplit[1];
        if (str.isEmpty()) {
            return null;
        }
        return str;
    }

    private static String c(PublicKey publicKey) {
        try {
            byte[] bArrDigest = MessageDigest.getInstance("SHA1").digest(publicKey.getEncoded());
            bArrDigest[0] = (byte) (((bArrDigest[0] & Ascii.SI) + 112) & 255);
            return Base64.encodeToString(bArrDigest, 0, 8, 11);
        } catch (NoSuchAlgorithmException unused) {
            Log.w("ContentValues", "Unexpected error, device missing required algorithms");
            return null;
        }
    }

    private String d(String str) {
        try {
            return new JSONObject(str).getString(AccessToken.TOKEN_KEY);
        } catch (JSONException unused) {
            return null;
        }
    }

    private PublicKey e(String str) {
        try {
            return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str, 8)));
        } catch (IllegalArgumentException | NoSuchAlgorithmException | InvalidKeySpecException e3) {
            Log.w("ContentValues", "Invalid key stored " + e3);
            return null;
        }
    }

    private String g() {
        String string;
        synchronized (this.f89284a) {
            string = this.f89284a.getString("|S|id", null);
        }
        return string;
    }

    private String h() {
        synchronized (this.f89284a) {
            try {
                String string = this.f89284a.getString("|S||P|", null);
                if (string == null) {
                    return null;
                }
                PublicKey publicKeyE = e(string);
                if (publicKeyE == null) {
                    return null;
                }
                return c(publicKeyE);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public String f() {
        synchronized (this.f89284a) {
            try {
                String strG = g();
                if (strG != null) {
                    return strG;
                }
                return h();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public String i() {
        synchronized (this.f89284a) {
            try {
                for (String str : f89283c) {
                    String string = this.f89284a.getString(a(this.f89285b, str), null);
                    if (string != null && !string.isEmpty()) {
                        if (string.startsWith("{")) {
                            string = d(string);
                        }
                        return string;
                    }
                }
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
