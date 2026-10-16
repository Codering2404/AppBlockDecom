package com.google.firebase.auth.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static zzo f87993a = new zzo();

    public static SharedPreferences a(Context context, String str) {
        return context.getSharedPreferences(String.format("com.google.firebase.auth.internal.browserSignInSessionStore.%s", str), 0);
    }

    public static zzo b() {
        return f87993a;
    }

    public static void f(SharedPreferences sharedPreferences) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        Iterator<String> it = sharedPreferences.getAll().keySet().iterator();
        while (it.hasNext()) {
            editorEdit.remove(it.next());
        }
        editorEdit.apply();
    }

    public final synchronized zzr c(Context context, String str, String str2) {
        Preconditions.g(str);
        Preconditions.g(str2);
        SharedPreferences sharedPreferencesA = a(context, str);
        String str3 = String.format("com.google.firebase.auth.internal.EVENT_ID.%s.SESSION_ID", str2);
        String str4 = String.format("com.google.firebase.auth.internal.EVENT_ID.%s.OPERATION", str2);
        String str5 = String.format("com.google.firebase.auth.internal.EVENT_ID.%s.PROVIDER_ID", str2);
        String str6 = String.format("com.google.firebase.auth.internal.EVENT_ID.%s.FIREBASE_APP_NAME", str2);
        String string = sharedPreferencesA.getString(str3, null);
        String string2 = sharedPreferencesA.getString(str4, null);
        String string3 = sharedPreferencesA.getString(str5, null);
        String string4 = sharedPreferencesA.getString("com.google.firebase.auth.api.gms.config.tenant.id", null);
        String string5 = sharedPreferencesA.getString(str6, null);
        SharedPreferences.Editor editorEdit = sharedPreferencesA.edit();
        editorEdit.remove(str3);
        editorEdit.remove(str4);
        editorEdit.remove(str5);
        editorEdit.remove(str6);
        editorEdit.apply();
        if (string == null || string2 == null || string3 == null) {
            return null;
        }
        return new zzr(string, string2, string3, string4, string5);
    }

    public final synchronized void d(Context context, String str, String str2, String str3, String str4) {
        Preconditions.g(str);
        Preconditions.g(str2);
        SharedPreferences sharedPreferencesA = a(context, str);
        f(sharedPreferencesA);
        SharedPreferences.Editor editorEdit = sharedPreferencesA.edit();
        editorEdit.putString(String.format("com.google.firebase.auth.internal.EVENT_ID.%s.OPERATION", str2), str3);
        editorEdit.putString(String.format("com.google.firebase.auth.internal.EVENT_ID.%s.FIREBASE_APP_NAME", str2), str4);
        editorEdit.apply();
    }

    public final synchronized void e(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        Preconditions.g(str);
        Preconditions.g(str2);
        Preconditions.g(str3);
        Preconditions.g(str7);
        SharedPreferences sharedPreferencesA = a(context, str);
        f(sharedPreferencesA);
        SharedPreferences.Editor editorEdit = sharedPreferencesA.edit();
        editorEdit.putString(String.format("com.google.firebase.auth.internal.EVENT_ID.%s.SESSION_ID", str2), str3);
        editorEdit.putString(String.format("com.google.firebase.auth.internal.EVENT_ID.%s.OPERATION", str2), str4);
        editorEdit.putString(String.format("com.google.firebase.auth.internal.EVENT_ID.%s.PROVIDER_ID", str2), str5);
        editorEdit.putString(String.format("com.google.firebase.auth.internal.EVENT_ID.%s.FIREBASE_APP_NAME", str2), str7);
        editorEdit.putString("com.google.firebase.auth.api.gms.config.tenant.id", str6);
        editorEdit.apply();
    }

    public final synchronized String g(Context context, String str, String str2) {
        Preconditions.g(str);
        Preconditions.g(str2);
        SharedPreferences sharedPreferencesA = a(context, str);
        String str3 = String.format("com.google.firebase.auth.internal.EVENT_ID.%s.OPERATION", str2);
        String string = sharedPreferencesA.getString(str3, null);
        String str4 = String.format("com.google.firebase.auth.internal.EVENT_ID.%s.FIREBASE_APP_NAME", str2);
        String string2 = sharedPreferencesA.getString(str4, null);
        SharedPreferences.Editor editorEdit = sharedPreferencesA.edit();
        editorEdit.remove(str3);
        editorEdit.remove(str4);
        editorEdit.apply();
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return string2;
    }
}
