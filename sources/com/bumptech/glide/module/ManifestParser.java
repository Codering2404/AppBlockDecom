package com.bumptech.glide.module;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public final class ManifestParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f67074a;

    public ManifestParser(Context context) {
        this.f67074a = context;
    }

    private ApplicationInfo a() {
        return this.f67074a.getPackageManager().getApplicationInfo(this.f67074a.getPackageName(), ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
    }

    private static GlideModule c(String str) {
        try {
            Class<?> cls = Class.forName(str);
            Object objNewInstance = null;
            try {
                objNewInstance = cls.getDeclaredConstructor(null).newInstance(null);
            } catch (IllegalAccessException e3) {
                d(cls, e3);
            } catch (InstantiationException e4) {
                d(cls, e4);
            } catch (NoSuchMethodException e5) {
                d(cls, e5);
            } catch (InvocationTargetException e6) {
                d(cls, e6);
            }
            if (objNewInstance instanceof GlideModule) {
                return (GlideModule) objNewInstance;
            }
            throw new RuntimeException("Expected instanceof GlideModule, but found: " + objNewInstance);
        } catch (ClassNotFoundException e7) {
            throw new IllegalArgumentException("Unable to find GlideModule implementation", e7);
        }
    }

    private static void d(Class cls, Exception exc) {
        throw new RuntimeException("Unable to instantiate GlideModule implementation for " + cls, exc);
    }

    public List b() {
        if (Log.isLoggable("ManifestParser", 3)) {
            Log.d("ManifestParser", "Loading Glide modules");
        }
        ArrayList arrayList = new ArrayList();
        try {
            ApplicationInfo applicationInfoA = a();
            if (applicationInfoA != null && applicationInfoA.metaData != null) {
                if (Log.isLoggable("ManifestParser", 2)) {
                    Log.v("ManifestParser", "Got app info metadata: " + applicationInfoA.metaData);
                }
                for (String str : applicationInfoA.metaData.keySet()) {
                    if ("GlideModule".equals(applicationInfoA.metaData.get(str))) {
                        arrayList.add(c(str));
                        if (Log.isLoggable("ManifestParser", 3)) {
                            Log.d("ManifestParser", "Loaded Glide module: " + str);
                        }
                    }
                }
                if (Log.isLoggable("ManifestParser", 3)) {
                    Log.d("ManifestParser", "Finished loading Glide modules");
                    return arrayList;
                }
            } else if (Log.isLoggable("ManifestParser", 3)) {
                Log.d("ManifestParser", "Got null app info metadata");
                return arrayList;
            }
        } catch (PackageManager.NameNotFoundException e3) {
            if (Log.isLoggable("ManifestParser", 6)) {
                Log.e("ManifestParser", "Failed to parse glide modules", e3);
            }
        }
        return arrayList;
    }
}
