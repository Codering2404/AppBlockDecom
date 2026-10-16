package com.google.firebase.messaging;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.content.ContextCompat;
import com.facebook.AccessToken;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class Store {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final SharedPreferences f89463a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Token {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final long f89464d = TimeUnit.DAYS.toMillis(7);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final String f89465a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final String f89466b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final long f89467c;

        private Token(String str, String str2, long j3) {
            this.f89465a = str;
            this.f89466b = str2;
            this.f89467c = j3;
        }

        static String a(String str, String str2, long j3) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(AccessToken.TOKEN_KEY, str);
                jSONObject.put("appVersion", str2);
                jSONObject.put("timestamp", j3);
                return jSONObject.toString();
            } catch (JSONException e3) {
                Log.w("FirebaseMessaging", "Failed to encode token: " + e3);
                return null;
            }
        }

        static Token c(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (!str.startsWith("{")) {
                return new Token(str, null, 0L);
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                return new Token(jSONObject.getString(AccessToken.TOKEN_KEY), jSONObject.getString("appVersion"), jSONObject.getLong("timestamp"));
            } catch (JSONException e3) {
                Log.w("FirebaseMessaging", "Failed to parse token: " + e3);
                return null;
            }
        }

        boolean b(String str) {
            return System.currentTimeMillis() > this.f89467c + f89464d || !str.equals(this.f89466b);
        }
    }

    public Store(Context context) {
        this.f89463a = context.getSharedPreferences("com.google.android.gms.appid", 0);
        a(context, "com.google.android.gms.appid-no-backup");
    }

    private void a(Context context, String str) {
        File file = new File(ContextCompat.getNoBackupFilesDir(context), str);
        if (file.exists()) {
            return;
        }
        try {
            if (!file.createNewFile() || e()) {
                return;
            }
            Log.i("FirebaseMessaging", "App restored, clearing state");
            c();
        } catch (IOException e3) {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "Error creating file in no backup dir: " + e3.getMessage());
            }
        }
    }

    private String b(String str, String str2) {
        return str + "|T|" + str2 + "|*";
    }

    public synchronized void c() {
        this.f89463a.edit().clear().commit();
    }

    public synchronized Token d(String str, String str2) {
        return Token.c(this.f89463a.getString(b(str, str2), null));
    }

    public synchronized boolean e() {
        return this.f89463a.getAll().isEmpty();
    }

    public synchronized void f(String str, String str2, String str3, String str4) {
        String strA = Token.a(str3, str4, System.currentTimeMillis());
        if (strA == null) {
            return;
        }
        SharedPreferences.Editor editorEdit = this.f89463a.edit();
        editorEdit.putString(b(str, str2), strA);
        editorEdit.commit();
    }
}
