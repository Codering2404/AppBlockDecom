package com.google.firebase.crashlytics.internal.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.FirebaseApp;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.concurrency.CrashlyticsTasks;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class DataCollectionArbiter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SharedPreferences f88411a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final FirebaseApp f88412b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f88413c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    TaskCompletionSource f88414d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    boolean f88415e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f88416f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Boolean f88417g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final TaskCompletionSource f88418h;

    public DataCollectionArbiter(FirebaseApp firebaseApp) {
        Object obj = new Object();
        this.f88413c = obj;
        this.f88414d = new TaskCompletionSource();
        this.f88415e = false;
        this.f88416f = false;
        this.f88418h = new TaskCompletionSource();
        Context contextL = firebaseApp.l();
        this.f88412b = firebaseApp;
        this.f88411a = CommonUtils.q(contextL);
        Boolean boolB = b();
        this.f88417g = boolB == null ? a(contextL) : boolB;
        synchronized (obj) {
            try {
                if (d()) {
                    this.f88414d.trySetResult(null);
                    this.f88415e = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private Boolean a(Context context) {
        Boolean boolG = g(context);
        if (boolG == null) {
            this.f88416f = false;
            return null;
        }
        this.f88416f = true;
        return Boolean.valueOf(Boolean.TRUE.equals(boolG));
    }

    private Boolean b() {
        if (!this.f88411a.contains("firebase_crashlytics_collection_enabled")) {
            return null;
        }
        this.f88416f = false;
        return Boolean.valueOf(this.f88411a.getBoolean("firebase_crashlytics_collection_enabled", true));
    }

    private boolean e() {
        try {
            return this.f88412b.v();
        } catch (IllegalStateException unused) {
            return false;
        }
    }

    private void f(boolean z2) {
        Logger.f().b(String.format("Crashlytics automatic data collection %s by %s.", z2 ? "ENABLED" : "DISABLED", this.f88417g == null ? "global Firebase setting" : this.f88416f ? "firebase_crashlytics_collection_enabled manifest flag" : "API"));
    }

    private static Boolean g(Context context) {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null || (applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD)) == null || (bundle = applicationInfo.metaData) == null || !bundle.containsKey("firebase_crashlytics_collection_enabled")) {
                return null;
            }
            return Boolean.valueOf(applicationInfo.metaData.getBoolean("firebase_crashlytics_collection_enabled"));
        } catch (PackageManager.NameNotFoundException e3) {
            Logger.f().e("Could not read data collection permission from manifest", e3);
            return null;
        }
    }

    private static void i(SharedPreferences sharedPreferences, Boolean bool) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        if (bool != null) {
            editorEdit.putBoolean("firebase_crashlytics_collection_enabled", bool.booleanValue());
        } else {
            editorEdit.remove("firebase_crashlytics_collection_enabled");
        }
        editorEdit.apply();
    }

    public void c(boolean z2) {
        if (!z2) {
            throw new IllegalStateException("An invalid data collection token was used.");
        }
        this.f88418h.trySetResult(null);
    }

    public synchronized boolean d() {
        boolean zBooleanValue;
        try {
            Boolean bool = this.f88417g;
            zBooleanValue = bool != null ? bool.booleanValue() : e();
            f(zBooleanValue);
        } catch (Throwable th) {
            throw th;
        }
        return zBooleanValue;
    }

    public synchronized void h(Boolean bool) {
        if (bool != null) {
            try {
                this.f88416f = false;
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f88417g = bool != null ? bool : a(this.f88412b.l());
        i(this.f88411a, bool);
        synchronized (this.f88413c) {
            try {
                if (d()) {
                    if (!this.f88415e) {
                        this.f88414d.trySetResult(null);
                        this.f88415e = true;
                    }
                } else if (this.f88415e) {
                    this.f88414d = new TaskCompletionSource();
                    this.f88415e = false;
                }
            } finally {
            }
        }
    }

    public Task j() {
        Task task;
        synchronized (this.f88413c) {
            task = this.f88414d.getTask();
        }
        return task;
    }

    public Task k() {
        return CrashlyticsTasks.b(this.f88418h.getTask(), j());
    }
}
