package com.google.android.gms.common;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.app.PendingIntentCompat;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.wrappers.Wrappers;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class GoogleApiAvailabilityLight {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f71453a = GooglePlayServicesUtilLight.f71459a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final GoogleApiAvailabilityLight f71454b = new GoogleApiAvailabilityLight();

    GoogleApiAvailabilityLight() {
    }

    public static GoogleApiAvailabilityLight h() {
        return f71454b;
    }

    public void a(Context context) {
        GooglePlayServicesUtilLight.a(context);
    }

    public int b(Context context) {
        return GooglePlayServicesUtilLight.c(context);
    }

    public Intent c(int i3) {
        return d(null, i3, null);
    }

    public Intent d(Context context, int i3, String str) {
        if (i3 != 1 && i3 != 2) {
            if (i3 != 3) {
                return null;
            }
            Uri uriFromParts = Uri.fromParts("package", "com.google.android.gms", null);
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(uriFromParts);
            return intent;
        }
        if (context != null && DeviceProperties.g(context)) {
            Intent intent2 = new Intent("com.google.android.clockwork.home.UPDATE_ANDROID_WEAR_ACTION");
            intent2.setPackage("com.google.android.wearable.app");
            return intent2;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("gcore_");
        sb.append(f71453a);
        sb.append("-");
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
        }
        sb.append("-");
        if (context != null) {
            sb.append(context.getPackageName());
        }
        sb.append("-");
        if (context != null) {
            try {
                sb.append(Wrappers.a(context).f(context.getPackageName(), 0).versionCode);
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        String string = sb.toString();
        Intent intent3 = new Intent("android.intent.action.VIEW");
        Uri.Builder builderAppendQueryParameter = Uri.parse("market://details").buildUpon().appendQueryParameter("id", "com.google.android.gms");
        if (!TextUtils.isEmpty(string)) {
            builderAppendQueryParameter.appendQueryParameter("pcampaignid", string);
        }
        intent3.setData(builderAppendQueryParameter.build());
        intent3.setPackage("com.android.vending");
        intent3.addFlags(524288);
        return intent3;
    }

    public PendingIntent e(Context context, int i3, int i4) {
        return f(context, i3, i4, null);
    }

    public PendingIntent f(Context context, int i3, int i4, String str) {
        Intent intentD = d(context, i3, str);
        if (intentD == null) {
            return null;
        }
        return PendingIntentCompat.b(context, i4, intentD, 134217728, false);
    }

    public String g(int i3) {
        return GooglePlayServicesUtilLight.d(i3);
    }

    public int i(Context context) {
        return j(context, f71453a);
    }

    public int j(Context context, int i3) {
        int iH = GooglePlayServicesUtilLight.h(context, i3);
        if (GooglePlayServicesUtilLight.i(context, iH)) {
            return 18;
        }
        return iH;
    }

    public boolean k(Context context, int i3) {
        return GooglePlayServicesUtilLight.i(context, i3);
    }

    public boolean l(Context context, String str) {
        return GooglePlayServicesUtilLight.m(context, str);
    }

    public boolean m(int i3) {
        return GooglePlayServicesUtilLight.k(i3);
    }

    public void n(Context context, int i3) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
        GooglePlayServicesUtilLight.b(context, i3);
    }
}
