package com.google.firebase.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.core.content.ContextCompat;
import com.google.firebase.events.Publisher;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class DataCollectionConfigStorage {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f89330a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SharedPreferences f89331b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Publisher f89332c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f89333d;

    public DataCollectionConfigStorage(Context context, String str, Publisher publisher) {
        Context contextA = a(context);
        this.f89330a = contextA;
        this.f89331b = contextA.getSharedPreferences("com.google.firebase.common.prefs:" + str, 0);
        this.f89332c = publisher;
        this.f89333d = c();
    }

    private static Context a(Context context) {
        return ContextCompat.createDeviceProtectedStorageContext(context);
    }

    private boolean c() {
        return this.f89331b.contains("firebase_data_collection_default_enabled") ? this.f89331b.getBoolean("firebase_data_collection_default_enabled", true) : d();
    }

    private boolean d() {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        try {
            PackageManager packageManager = this.f89330a.getPackageManager();
            if (packageManager == null || (applicationInfo = packageManager.getApplicationInfo(this.f89330a.getPackageName(), ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD)) == null || (bundle = applicationInfo.metaData) == null || !bundle.containsKey("firebase_data_collection_default_enabled")) {
                return true;
            }
            return applicationInfo.metaData.getBoolean("firebase_data_collection_default_enabled");
        } catch (PackageManager.NameNotFoundException unused) {
            return true;
        }
    }

    public synchronized boolean b() {
        return this.f89333d;
    }
}
