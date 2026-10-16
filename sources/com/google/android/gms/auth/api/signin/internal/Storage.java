package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.Preconditions;
import com.revenuecat.purchases.common.Constants;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class Storage {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Lock f71242c = new ReentrantLock();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Storage f71243d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Lock f71244a = new ReentrantLock();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SharedPreferences f71245b;

    Storage(Context context) {
        this.f71245b = context.getSharedPreferences("com.google.android.gms.signin", 0);
    }

    public static Storage b(Context context) {
        Preconditions.m(context);
        Lock lock = f71242c;
        lock.lock();
        try {
            if (f71243d == null) {
                f71243d = new Storage(context.getApplicationContext());
            }
            Storage storage = f71243d;
            lock.unlock();
            return storage;
        } catch (Throwable th) {
            f71242c.unlock();
            throw th;
        }
    }

    private static final String k(String str, String str2) {
        return str + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + str2;
    }

    public void a() {
        this.f71244a.lock();
        try {
            this.f71245b.edit().clear().apply();
        } finally {
            this.f71244a.unlock();
        }
    }

    public GoogleSignInAccount c() {
        String strG;
        String strG2 = g("defaultGoogleSignInAccount");
        if (!TextUtils.isEmpty(strG2) && (strG = g(k("googleSignInAccount", strG2))) != null) {
            try {
                return GoogleSignInAccount.L2(strG);
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    public GoogleSignInOptions d() {
        String strG;
        String strG2 = g("defaultGoogleSignInAccount");
        if (!TextUtils.isEmpty(strG2) && (strG = g(k("googleSignInOptions", strG2))) != null) {
            try {
                return GoogleSignInOptions.J2(strG);
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    public String e() {
        return g("refreshToken");
    }

    public void f(GoogleSignInAccount googleSignInAccount, GoogleSignInOptions googleSignInOptions) {
        Preconditions.m(googleSignInAccount);
        Preconditions.m(googleSignInOptions);
        j("defaultGoogleSignInAccount", googleSignInAccount.M2());
        Preconditions.m(googleSignInAccount);
        Preconditions.m(googleSignInOptions);
        String strM2 = googleSignInAccount.M2();
        j(k("googleSignInAccount", strM2), googleSignInAccount.N2());
        j(k("googleSignInOptions", strM2), googleSignInOptions.N2());
    }

    protected final String g(String str) {
        this.f71244a.lock();
        try {
            return this.f71245b.getString(str, null);
        } finally {
            this.f71244a.unlock();
        }
    }

    protected final void h(String str) {
        this.f71244a.lock();
        try {
            this.f71245b.edit().remove(str).apply();
        } finally {
            this.f71244a.unlock();
        }
    }

    public final void i() {
        String strG = g("defaultGoogleSignInAccount");
        h("defaultGoogleSignInAccount");
        if (TextUtils.isEmpty(strG)) {
            return;
        }
        h(k("googleSignInAccount", strG));
        h(k("googleSignInOptions", strG));
    }

    protected final void j(String str, String str2) {
        this.f71244a.lock();
        try {
            this.f71245b.edit().putString(str, str2).apply();
        } finally {
            this.f71244a.unlock();
        }
    }
}
