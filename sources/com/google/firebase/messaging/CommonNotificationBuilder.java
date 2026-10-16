package com.google.firebase.messaging;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import com.facebook.LegacyTokenHelper;
import com.github.appintro.AppIntroBaseFragmentKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class CommonNotificationBuilder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final AtomicInteger f89369a = new AtomicInteger((int) SystemClock.elapsedRealtime());

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class DisplayNotificationInfo {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final NotificationCompat.Builder f89370a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f89371b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f89372c;

        DisplayNotificationInfo(NotificationCompat.Builder builder, String str, int i3) {
            this.f89370a = builder;
            this.f89371b = str;
            this.f89372c = i3;
        }
    }

    private static PendingIntent a(Context context, NotificationParams notificationParams, String str, PackageManager packageManager) {
        Intent intentF = f(str, notificationParams, packageManager);
        if (intentF == null) {
            return null;
        }
        intentF.addFlags(67108864);
        intentF.putExtras(notificationParams.y());
        if (q(notificationParams)) {
            intentF.putExtra("gcm.n.analytics_data", notificationParams.x());
        }
        return PendingIntent.getActivity(context, g(), intentF, l(1073741824));
    }

    private static PendingIntent b(Context context, Context context2, NotificationParams notificationParams) {
        if (q(notificationParams)) {
            return c(context, context2, new Intent("com.google.firebase.messaging.NOTIFICATION_DISMISS").putExtras(notificationParams.x()));
        }
        return null;
    }

    private static PendingIntent c(Context context, Context context2, Intent intent) {
        return PendingIntent.getBroadcast(context, g(), new Intent("com.google.android.c2dm.intent.RECEIVE").setPackage(context2.getPackageName()).putExtra("wrapped_intent", intent), l(1073741824));
    }

    public static DisplayNotificationInfo d(Context context, Context context2, NotificationParams notificationParams, String str, Bundle bundle) {
        String packageName = context2.getPackageName();
        Resources resources = context2.getResources();
        PackageManager packageManager = context2.getPackageManager();
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context2, str);
        String strN = notificationParams.n(resources, packageName, "gcm.n.title");
        if (!TextUtils.isEmpty(strN)) {
            builder.n(strN);
        }
        String strN2 = notificationParams.n(resources, packageName, "gcm.n.body");
        if (!TextUtils.isEmpty(strN2)) {
            builder.m(strN2);
            builder.D(new NotificationCompat.BigTextStyle().h(strN2));
        }
        builder.B(m(packageManager, resources, packageName, notificationParams.p("gcm.n.icon"), bundle));
        Uri uriN = n(packageName, notificationParams, resources);
        if (uriN != null) {
            builder.C(uriN);
        }
        builder.l(a(context, notificationParams, packageName, packageManager));
        PendingIntent pendingIntentB = b(context, context2, notificationParams);
        if (pendingIntentB != null) {
            builder.p(pendingIntentB);
        }
        Integer numH = h(context2, notificationParams.p("gcm.n.color"), bundle);
        if (numH != null) {
            builder.k(numH.intValue());
        }
        builder.f(!notificationParams.a("gcm.n.sticky"));
        builder.t(notificationParams.a("gcm.n.local_only"));
        String strP = notificationParams.p("gcm.n.ticker");
        if (strP != null) {
            builder.F(strP);
        }
        Integer numM = notificationParams.m();
        if (numM != null) {
            builder.x(numM.intValue());
        }
        Integer numR = notificationParams.r();
        if (numR != null) {
            builder.H(numR.intValue());
        }
        Integer numL = notificationParams.l();
        if (numL != null) {
            builder.u(numL.intValue());
        }
        Long lJ = notificationParams.j("gcm.n.event_time");
        if (lJ != null) {
            builder.z(true);
            builder.I(lJ.longValue());
        }
        long[] jArrQ = notificationParams.q();
        if (jArrQ != null) {
            builder.G(jArrQ);
        }
        int[] iArrE = notificationParams.e();
        if (iArrE != null) {
            builder.s(iArrE[0], iArrE[1], iArrE[2]);
        }
        builder.o(i(notificationParams));
        return new DisplayNotificationInfo(builder, o(notificationParams), 0);
    }

    static DisplayNotificationInfo e(Context context, NotificationParams notificationParams) {
        Bundle bundleJ = j(context.getPackageManager(), context.getPackageName());
        return d(context, context, notificationParams, k(context, notificationParams.k(), bundleJ), bundleJ);
    }

    private static Intent f(String str, NotificationParams notificationParams, PackageManager packageManager) {
        String strP = notificationParams.p("gcm.n.click_action");
        if (!TextUtils.isEmpty(strP)) {
            Intent intent = new Intent(strP);
            intent.setPackage(str);
            intent.setFlags(268435456);
            return intent;
        }
        Uri uriF = notificationParams.f();
        if (uriF != null) {
            Intent intent2 = new Intent("android.intent.action.VIEW");
            intent2.setPackage(str);
            intent2.setData(uriF);
            return intent2;
        }
        Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(str);
        if (launchIntentForPackage == null) {
            Log.w("FirebaseMessaging", "No activity found to launch app");
        }
        return launchIntentForPackage;
    }

    private static int g() {
        return f89369a.incrementAndGet();
    }

    private static Integer h(Context context, String str, Bundle bundle) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return Integer.valueOf(Color.parseColor(str));
            } catch (IllegalArgumentException unused) {
                Log.w("FirebaseMessaging", "Color is invalid: " + str + ". Notification will use default color.");
            }
        }
        int i3 = bundle.getInt("com.google.firebase.messaging.default_notification_color", 0);
        if (i3 == 0) {
            return null;
        }
        try {
            return Integer.valueOf(ContextCompat.getColor(context, i3));
        } catch (Resources.NotFoundException unused2) {
            Log.w("FirebaseMessaging", "Cannot find the color resource referenced in AndroidManifest.");
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    private static int i(NotificationParams notificationParams) {
        boolean zA = notificationParams.a("gcm.n.default_sound");
        ?? r02 = zA;
        if (notificationParams.a("gcm.n.default_vibrate_timings")) {
            r02 = (zA ? 1 : 0) | 2;
        }
        return notificationParams.a("gcm.n.default_light_settings") ? r02 | 4 : r02;
    }

    private static Bundle j(PackageManager packageManager, String str) {
        try {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(str, ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
            if (applicationInfo != null) {
                Bundle bundle = applicationInfo.metaData;
                if (bundle != null) {
                    return bundle;
                }
            }
        } catch (PackageManager.NameNotFoundException e3) {
            Log.w("FirebaseMessaging", "Couldn't get own application info: " + e3);
        }
        return Bundle.EMPTY;
    }

    public static String k(Context context, String str, Bundle bundle) {
        String string;
        try {
            if (context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).targetSdkVersion < 26) {
                return null;
            }
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(NotificationManager.class);
            if (!TextUtils.isEmpty(str)) {
                if (notificationManager.getNotificationChannel(str) != null) {
                    return str;
                }
                Log.w("FirebaseMessaging", "Notification Channel requested (" + str + ") has not been created by the app. Manifest configuration, or default, value will be used.");
            }
            String string2 = bundle.getString("com.google.firebase.messaging.default_notification_channel_id");
            if (TextUtils.isEmpty(string2)) {
                Log.w("FirebaseMessaging", "Missing Default Notification Channel metadata in AndroidManifest. Default value will be used.");
            } else {
                if (notificationManager.getNotificationChannel(string2) != null) {
                    return string2;
                }
                Log.w("FirebaseMessaging", "Notification Channel set in AndroidManifest.xml has not been created by the app. Default value will be used.");
            }
            if (notificationManager.getNotificationChannel("fcm_fallback_notification_channel") == null) {
                int identifier = context.getResources().getIdentifier("fcm_fallback_notification_channel_label", LegacyTokenHelper.TYPE_STRING, context.getPackageName());
                if (identifier == 0) {
                    Log.e("FirebaseMessaging", "String resource \"fcm_fallback_notification_channel_label\" is not found. Using default string channel name.");
                    string = "Misc";
                } else {
                    string = context.getString(identifier);
                }
                notificationManager.createNotificationChannel(new NotificationChannel("fcm_fallback_notification_channel", string, 3));
            }
            return "fcm_fallback_notification_channel";
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    private static int l(int i3) {
        return i3 | 67108864;
    }

    private static int m(PackageManager packageManager, Resources resources, String str, String str2, Bundle bundle) {
        if (!TextUtils.isEmpty(str2)) {
            int identifier = resources.getIdentifier(str2, AppIntroBaseFragmentKt.ARG_DRAWABLE, str);
            if (identifier != 0 && p(resources, identifier)) {
                return identifier;
            }
            int identifier2 = resources.getIdentifier(str2, "mipmap", str);
            if (identifier2 != 0 && p(resources, identifier2)) {
                return identifier2;
            }
            Log.w("FirebaseMessaging", "Icon resource " + str2 + " not found. Notification will use default icon.");
        }
        int i3 = bundle.getInt("com.google.firebase.messaging.default_notification_icon", 0);
        if (i3 == 0 || !p(resources, i3)) {
            try {
                i3 = packageManager.getApplicationInfo(str, 0).icon;
            } catch (PackageManager.NameNotFoundException e3) {
                Log.w("FirebaseMessaging", "Couldn't get own application info: " + e3);
            }
        }
        return (i3 == 0 || !p(resources, i3)) ? android.R.drawable.sym_def_app_icon : i3;
    }

    private static Uri n(String str, NotificationParams notificationParams, Resources resources) {
        String strO = notificationParams.o();
        if (TextUtils.isEmpty(strO)) {
            return null;
        }
        if ("default".equals(strO) || resources.getIdentifier(strO, "raw", str) == 0) {
            return RingtoneManager.getDefaultUri(2);
        }
        return Uri.parse("android.resource://" + str + "/raw/" + strO);
    }

    private static String o(NotificationParams notificationParams) {
        String strP = notificationParams.p("gcm.n.tag");
        if (!TextUtils.isEmpty(strP)) {
            return strP;
        }
        return "FCM-Notification:" + SystemClock.uptimeMillis();
    }

    private static boolean p(Resources resources, int i3) {
        return true;
    }

    static boolean q(NotificationParams notificationParams) {
        return notificationParams.a("google.c.a.e");
    }
}
