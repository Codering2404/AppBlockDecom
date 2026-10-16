package com.google.android.gms.common.internal;

import android.R;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Log;
import androidx.collection.SimpleArrayMap;
import androidx.core.os.ConfigurationCompat;
import com.facebook.LegacyTokenHelper;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.wrappers.Wrappers;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zac {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final SimpleArrayMap f72041a = new SimpleArrayMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Locale f72042b;

    public static String a(Context context) {
        String packageName = context.getPackageName();
        try {
            return Wrappers.a(context).d(packageName).toString();
        } catch (PackageManager.NameNotFoundException | NullPointerException unused) {
            String str = context.getApplicationInfo().name;
            return TextUtils.isEmpty(str) ? packageName : str;
        }
    }

    public static String b(Context context, int i3) {
        Resources resources = context.getResources();
        return i3 != 1 ? i3 != 2 ? i3 != 3 ? resources.getString(R.string.ok) : resources.getString(com.google.android.gms.base.R.string.f71346a) : resources.getString(com.google.android.gms.base.R.string.f71355j) : resources.getString(com.google.android.gms.base.R.string.f71349d);
    }

    public static String c(Context context, int i3) {
        Resources resources = context.getResources();
        String strA = a(context);
        if (i3 == 1) {
            return resources.getString(com.google.android.gms.base.R.string.f71350e, strA);
        }
        if (i3 == 2) {
            return DeviceProperties.g(context) ? resources.getString(com.google.android.gms.base.R.string.f71359n) : resources.getString(com.google.android.gms.base.R.string.f71356k, strA);
        }
        if (i3 == 3) {
            return resources.getString(com.google.android.gms.base.R.string.f71347b, strA);
        }
        if (i3 == 5) {
            return g(context, "common_google_play_services_invalid_account_text", strA);
        }
        if (i3 == 7) {
            return g(context, "common_google_play_services_network_error_text", strA);
        }
        if (i3 == 9) {
            return resources.getString(com.google.android.gms.base.R.string.f71354i, strA);
        }
        if (i3 == 20) {
            return g(context, "common_google_play_services_restricted_profile_text", strA);
        }
        switch (i3) {
            case 16:
                return g(context, "common_google_play_services_api_unavailable_text", strA);
            case 17:
                return g(context, "common_google_play_services_sign_in_failed_text", strA);
            case 18:
                return resources.getString(com.google.android.gms.base.R.string.f71358m, strA);
            default:
                return resources.getString(com.google.android.gms.common.R.string.f71467a, strA);
        }
    }

    public static String d(Context context, int i3) {
        return (i3 == 6 || i3 == 19) ? g(context, "common_google_play_services_resolution_required_text", a(context)) : c(context, i3);
    }

    public static String e(Context context, int i3) {
        String strH = i3 == 6 ? h(context, "common_google_play_services_resolution_required_title") : f(context, i3);
        return strH == null ? context.getResources().getString(com.google.android.gms.base.R.string.f71353h) : strH;
    }

    public static String f(Context context, int i3) {
        Resources resources = context.getResources();
        switch (i3) {
            case 1:
                return resources.getString(com.google.android.gms.base.R.string.f71351f);
            case 2:
                return resources.getString(com.google.android.gms.base.R.string.f71357l);
            case 3:
                return resources.getString(com.google.android.gms.base.R.string.f71348c);
            case 4:
            case 6:
            case 18:
                return null;
            case 5:
                Log.e("GoogleApiAvailability", "An invalid account was specified when connecting. Please provide a valid account.");
                return h(context, "common_google_play_services_invalid_account_title");
            case 7:
                Log.e("GoogleApiAvailability", "Network error occurred. Please retry request later.");
                return h(context, "common_google_play_services_network_error_title");
            case 8:
                Log.e("GoogleApiAvailability", "Internal error occurred. Please see logs for detailed information");
                return null;
            case 9:
                Log.e("GoogleApiAvailability", "Google Play services is invalid. Cannot recover.");
                return null;
            case 10:
                Log.e("GoogleApiAvailability", "Developer error occurred. Please see logs for detailed information");
                return null;
            case 11:
                Log.e("GoogleApiAvailability", "The application is not licensed to the user.");
                return null;
            case 12:
            case 13:
            case 14:
            case 15:
            case 19:
            default:
                Log.e("GoogleApiAvailability", "Unexpected error code " + i3);
                return null;
            case 16:
                Log.e("GoogleApiAvailability", "One of the API components you attempted to connect to is not available.");
                return null;
            case 17:
                Log.e("GoogleApiAvailability", "The specified account could not be signed in.");
                return h(context, "common_google_play_services_sign_in_failed_title");
            case 20:
                Log.e("GoogleApiAvailability", "The current user profile is restricted and could not use authenticated features.");
                return h(context, "common_google_play_services_restricted_profile_title");
        }
    }

    private static String g(Context context, String str, String str2) {
        Resources resources = context.getResources();
        String strH = h(context, str);
        if (strH == null) {
            strH = resources.getString(com.google.android.gms.common.R.string.f71467a);
        }
        return String.format(resources.getConfiguration().locale, strH, str2);
    }

    private static String h(Context context, String str) {
        SimpleArrayMap simpleArrayMap = f72041a;
        synchronized (simpleArrayMap) {
            try {
                Locale localeD = ConfigurationCompat.a(context.getResources().getConfiguration()).d(0);
                if (!localeD.equals(f72042b)) {
                    simpleArrayMap.clear();
                    f72042b = localeD;
                }
                String str2 = (String) simpleArrayMap.get(str);
                if (str2 != null) {
                    return str2;
                }
                Resources resourcesF = GooglePlayServicesUtil.f(context);
                if (resourcesF == null) {
                    return null;
                }
                int identifier = resourcesF.getIdentifier(str, LegacyTokenHelper.TYPE_STRING, "com.google.android.gms");
                if (identifier == 0) {
                    Log.w("GoogleApiAvailability", "Missing resource: " + str);
                    return null;
                }
                String string = resourcesF.getString(identifier);
                if (!TextUtils.isEmpty(string)) {
                    simpleArrayMap.put(str, string);
                    return string;
                }
                Log.w("GoogleApiAvailability", "Got empty resource: " + str);
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
